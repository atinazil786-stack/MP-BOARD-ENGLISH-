package com.example.data.repository

import android.content.Context
import com.example.R
import com.example.core.firebase.OperationType
import com.example.core.firebase.handleFirestoreError
import com.example.data.local.LocalBookmarkEntity
import com.example.data.local.LocalProgressEntity
import com.example.data.local.LocalStudentDao
import com.example.data.local.LocalTestResultEntity
import com.example.data.model.BookmarkDoc
import com.example.data.model.StudyProgressDoc
import com.example.data.model.TestResultDoc
import com.example.data.model.UserProfileDoc
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.snapshots
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.tasks.await
import java.util.UUID

class StudentRepository(
    private val db: FirebaseFirestore,
    private val localDao: LocalStudentDao? = null
) {
    constructor(context: Context, localDao: LocalStudentDao? = null) : this(
        db = FirebaseFirestore.getInstance(
            context.applicationContext.getString(R.string.firestore_database_id)
        ),
        localDao = localDao
    )

    suspend fun ensureUserProfile(
        userId: String,
        displayName: String,
        email: String?,
        defaultClass: Int = 10
    ): Result<UserProfileDoc> {
        val docRef = db.collection("users").document(userId)
        return try {
            val snap = docRef.get().await()
            if (snap.exists()) {
                val profile = snap.toObject(
                    UserProfileDoc::class.java,
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                ) ?: UserProfileDoc(id = userId, userId = userId, displayName = displayName)
                Result.success(profile)
            } else {
                val safeName = displayName.ifBlank { "MP Board Student" }.take(80)
                val payload = mutableMapOf<String, Any>(
                    "userId" to userId,
                    "displayName" to safeName,
                    "selectedClass" to defaultClass.coerceIn(9, 12),
                    "darkMode" to false,
                    "bilingualMode" to true,
                    "dailyStreak" to 1,
                    "totalTestsTaken" to 0,
                    "createdAt" to FieldValue.serverTimestamp(),
                    "updatedAt" to FieldValue.serverTimestamp()
                )
                if (!email.isNullOrBlank()) {
                    payload["email"] = email.take(120)
                }
                docRef.set(payload).await()
                val created = docRef.get().await().toObject(
                    UserProfileDoc::class.java,
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                ) ?: UserProfileDoc(
                    id = userId,
                    userId = userId,
                    displayName = safeName,
                    email = email,
                    selectedClass = defaultClass.toLong()
                )
                Result.success(created)
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.WRITE, docRef.path)
            Result.failure(e)
        }
    }

    fun observeUserProfile(userId: String): Flow<UserProfileDoc?> {
        val docRef = db.collection("users").document(userId)
        return docRef.snapshots()
            .map { snapshot ->
                if (snapshot.exists()) {
                    snapshot.toObject(
                        UserProfileDoc::class.java,
                        DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                    )
                } else {
                    null
                }
            }
            .catch { error ->
                handleFirestoreError(error, OperationType.GET, docRef.path)
                throw error
            }
    }

    suspend fun updateUserPreferences(
        userId: String,
        selectedClass: Int,
        darkMode: Boolean,
        bilingualMode: Boolean
    ): Result<Unit> {
        val docRef = db.collection("users").document(userId)
        return try {
            val updates = mapOf(
                "selectedClass" to selectedClass.coerceIn(9, 12),
                "darkMode" to darkMode,
                "bilingualMode" to bilingualMode,
                "updatedAt" to FieldValue.serverTimestamp()
            )
            docRef.update(updates).await()
            Result.success(Unit)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.UPDATE, docRef.path)
            Result.failure(e)
        }
    }

    suspend fun incrementStreakAndTestCount(
        userId: String,
        newStreak: Int,
        newTotalTests: Int
    ): Result<Unit> {
        val docRef = db.collection("users").document(userId)
        return try {
            docRef.update(
                mapOf(
                    "dailyStreak" to newStreak.coerceAtLeast(1),
                    "totalTestsTaken" to newTotalTests.coerceAtLeast(0),
                    "updatedAt" to FieldValue.serverTimestamp()
                )
            ).await()
            Result.success(Unit)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.UPDATE, docRef.path)
            Result.failure(e)
        }
    }

    fun observeBookmarks(userId: String): Flow<List<BookmarkDoc>> {
        val path = "users/$userId/bookmarks"
        return db.collection("users").document(userId).collection("bookmarks")
            .snapshots()
            .map { snap ->
                snap.toObjects(
                    BookmarkDoc::class.java,
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                )
            }
            .catch { error ->
                handleFirestoreError(error, OperationType.LIST, path)
                throw error
            }
    }

    suspend fun toggleBookmark(
        userId: String,
        bookmarkId: String,
        itemType: String,
        targetId: String,
        classLevel: Int,
        title: String,
        subtitle: String,
        currentlySaved: Boolean
    ): Result<Boolean> {
        val safeId = sanitizeDocId(bookmarkId)
        val docRef = db.collection("users").document(userId).collection("bookmarks").document(safeId)
        return try {
            if (currentlySaved) {
                docRef.delete().await()
                localDao?.deleteBookmark(safeId, userId)
                Result.success(false)
            } else {
                val payload = mapOf(
                    "userId" to userId,
                    "itemType" to itemType,
                    "targetId" to targetId.take(128),
                    "classLevel" to classLevel.coerceIn(9, 12),
                    "title" to title.ifBlank { "Saved Item" }.take(200),
                    "subtitle" to subtitle.take(400),
                    "createdAt" to FieldValue.serverTimestamp()
                )
                docRef.set(payload).await()
                localDao?.upsertBookmark(
                    LocalBookmarkEntity(
                        id = safeId,
                        userId = userId,
                        itemType = itemType,
                        targetId = targetId,
                        classLevel = classLevel,
                        title = title,
                        subtitle = subtitle
                    )
                )
                Result.success(true)
            }
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.WRITE, docRef.path)
            Result.failure(e)
        }
    }

    fun observeProgress(userId: String): Flow<List<StudyProgressDoc>> {
        val path = "users/$userId/progress"
        return db.collection("users").document(userId).collection("progress")
            .snapshots()
            .map { snap ->
                snap.toObjects(
                    StudyProgressDoc::class.java,
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                )
            }
            .catch { error ->
                handleFirestoreError(error, OperationType.LIST, path)
                throw error
            }
    }

    suspend fun markChapterSectionCompleted(
        userId: String,
        chapterId: String,
        classLevel: Int,
        sectionKey: String,
        totalSectionsCount: Int = 18
    ): Result<StudyProgressDoc> {
        val safeId = sanitizeDocId("prog_$chapterId")
        val docRef = db.collection("users").document(userId).collection("progress").document(safeId)
        return try {
            val existingSnap = docRef.get().await()
            val existingSections = if (existingSnap.exists()) {
                val existingDoc = existingSnap.toObject(StudyProgressDoc::class.java)
                existingDoc?.completedSections.orEmpty()
            } else {
                emptyList()
            }
            val updatedSections = (existingSections + sectionKey).distinct().take(25)
            val mastery = ((updatedSections.size * 100) / totalSectionsCount.coerceAtLeast(1)).coerceIn(0, 100)

            if (existingSnap.exists()) {
                docRef.update(
                    mapOf(
                        "classLevel" to classLevel.coerceIn(9, 12),
                        "completedSections" to updatedSections,
                        "masteryPercent" to mastery,
                        "updatedAt" to FieldValue.serverTimestamp()
                    )
                ).await()
            } else {
                docRef.set(
                    mapOf(
                        "userId" to userId,
                        "chapterId" to chapterId.take(128),
                        "classLevel" to classLevel.coerceIn(9, 12),
                        "completedSections" to updatedSections,
                        "masteryPercent" to mastery,
                        "createdAt" to FieldValue.serverTimestamp(),
                        "updatedAt" to FieldValue.serverTimestamp()
                    )
                ).await()
            }
            localDao?.upsertProgress(
                LocalProgressEntity(
                    id = safeId,
                    userId = userId,
                    chapterId = chapterId,
                    classLevel = classLevel,
                    completedSectionsCsv = updatedSections.joinToString(","),
                    masteryPercent = mastery
                )
            )
            Result.success(
                StudyProgressDoc(
                    id = safeId,
                    userId = userId,
                    chapterId = chapterId,
                    classLevel = classLevel.toLong(),
                    completedSections = updatedSections,
                    masteryPercent = mastery.toLong()
                )
            )
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.WRITE, docRef.path)
            Result.failure(e)
        }
    }

    fun observeTestHistory(userId: String): Flow<List<TestResultDoc>> {
        val path = "users/$userId/testHistory"
        return db.collection("users").document(userId).collection("testHistory")
            .snapshots()
            .map { snap ->
                snap.toObjects(
                    TestResultDoc::class.java,
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                ).sortedByDescending { it.createdAt?.seconds ?: 0L }
            }
            .catch { error ->
                handleFirestoreError(error, OperationType.LIST, path)
                throw error
            }
    }

    suspend fun saveTestResult(
        userId: String,
        testTitle: String,
        testMode: String,
        classLevel: Int,
        totalQuestions: Int,
        correctCount: Int,
        wrongCount: Int,
        skippedCount: Int,
        percentage: Int,
        durationSeconds: Int,
        studentName: String = "MP Board Student"
    ): Result<String> {
        val resultId = "res_${UUID.randomUUID().toString().replace("-", "").take(16)}"
        val docRef = db.collection("users").document(userId).collection("testHistory").document(resultId)
        val summaryRef = db.collection("studentTestResults").document(resultId)
        return try {
            val safeTotal = totalQuestions.coerceIn(1, 100)
            val safeCorrect = correctCount.coerceIn(0, safeTotal)
            val safeWrong = wrongCount.coerceIn(0, safeTotal)
            val safeSkipped = skippedCount.coerceIn(0, safeTotal)
            val safePct = percentage.coerceIn(0, 100)
            val safeDur = durationSeconds.coerceIn(0, 10800)
            val safeTitle = testTitle.ifBlank { "MP Board Test" }.take(150)
            val safeClass = classLevel.coerceIn(9, 12)
            val payload = mapOf(
                "userId" to userId,
                "testTitle" to safeTitle,
                "testMode" to testMode,
                "classLevel" to safeClass,
                "totalQuestions" to safeTotal,
                "correctCount" to safeCorrect,
                "wrongCount" to safeWrong,
                "skippedCount" to safeSkipped,
                "percentage" to safePct,
                "durationSeconds" to safeDur,
                "createdAt" to FieldValue.serverTimestamp()
            )
            docRef.set(payload).await()
            val summaryPayload = mapOf(
                "userId" to userId,
                "studentName" to studentName.ifBlank { "MP Board Student" }.take(80),
                "testTitle" to safeTitle,
                "testMode" to testMode,
                "classLevel" to safeClass,
                "totalQuestions" to safeTotal,
                "correctCount" to safeCorrect,
                "wrongCount" to safeWrong,
                "percentage" to safePct,
                "durationSeconds" to safeDur,
                "createdAt" to FieldValue.serverTimestamp()
            )
            summaryRef.set(summaryPayload).await()
            localDao?.insertTestResult(
                LocalTestResultEntity(
                    id = resultId,
                    userId = userId,
                    testTitle = safeTitle,
                    testMode = testMode,
                    classLevel = safeClass,
                    totalQuestions = safeTotal,
                    correctCount = safeCorrect,
                    wrongCount = safeWrong,
                    skippedCount = safeSkipped,
                    percentage = safePct,
                    durationSeconds = safeDur
                )
            )
            Result.success(resultId)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.CREATE, docRef.path)
            Result.failure(e)
        }
    }

    fun observeWritingPracticeHistory(userId: String): Flow<List<com.example.data.model.WritingPracticeAttemptDoc>> {
        val path = "users/$userId/writingPractice"
        return db.collection("users").document(userId).collection("writingPractice")
            .snapshots()
            .map { snap ->
                snap.toObjects(
                    com.example.data.model.WritingPracticeAttemptDoc::class.java,
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                ).sortedByDescending { it.createdAt?.seconds ?: 0L }
            }
            .catch { error ->
                handleFirestoreError(error, OperationType.LIST, path)
                throw error
            }
    }

    suspend fun saveWritingPracticeAttempt(
        userId: String,
        classLevel: Int,
        chapterId: String,
        chapterTitle: String,
        questionPrompt: String,
        studentAnswer: String,
        evaluation: com.example.data.model.AiAnswerEvaluation
    ): Result<String> {
        val attemptId = "wp_${UUID.randomUUID().toString().replace("-", "").take(16)}"
        val docRef = db.collection("users").document(userId).collection("writingPractice").document(attemptId)
        return try {
            val safeMax = evaluation.maxMarks.coerceIn(1, 20)
            val safeObtained = evaluation.marksObtained.coerceIn(0.0, safeMax.toDouble())
            val payload = mapOf(
                "userId" to userId,
                "classLevel" to classLevel.coerceIn(9, 12),
                "chapterId" to chapterId.ifBlank { "general_writing" }.take(128),
                "chapterTitle" to chapterTitle.ifBlank { "English Writing" }.take(200),
                "questionPrompt" to questionPrompt.ifBlank { "Question" }.take(2000),
                "studentAnswer" to studentAnswer.ifBlank { "No answer" }.take(8000),
                "maxMarks" to safeMax,
                "marksObtained" to safeObtained,
                "grammarScore" to evaluation.grammarScore.coerceIn(0, 100),
                "spellingScore" to evaluation.spellingScore.coerceIn(0, 100),
                "vocabularyScore" to evaluation.vocabularyScore.coerceIn(0, 100),
                "structureScore" to evaluation.answerStructureScore.coerceIn(0, 100),
                "correctedAnswer" to evaluation.correctedAnswer.take(8000),
                "grammaticalMistakes" to evaluation.grammaticalMistakes.take(25),
                "suggestions" to evaluation.suggestions.take(25),
                "modelAnswer" to evaluation.modelAnswer.take(8000),
                "explanationHi" to evaluation.explanationHi.take(8000),
                "createdAt" to FieldValue.serverTimestamp()
            )
            docRef.set(payload).await()
            Result.success(attemptId)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.CREATE, docRef.path)
            Result.failure(e)
        }
    }

    fun observeAllStudentTestResults(): Flow<List<com.example.data.model.StudentTestSummaryDoc>> {
        val path = "studentTestResults"
        return db.collection(path)
            .snapshots()
            .map { snap ->
                snap.toObjects(
                    com.example.data.model.StudentTestSummaryDoc::class.java,
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                ).sortedByDescending { it.createdAt?.seconds ?: 0L }
            }
            .catch { error ->
                handleFirestoreError(error, OperationType.LIST, path)
                throw error
            }
    }

    fun observeOwnTestSummaries(userId: String): Flow<List<com.example.data.model.StudentTestSummaryDoc>> {
        val path = "studentTestResults"
        return db.collection(path)
            .whereEqualTo("userId", userId)
            .snapshots()
            .map { snap ->
                snap.toObjects(
                    com.example.data.model.StudentTestSummaryDoc::class.java,
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                ).sortedByDescending { it.createdAt?.seconds ?: 0L }
            }
            .catch { error ->
                handleFirestoreError(error, OperationType.LIST, path)
                throw error
            }
    }

    suspend fun checkIsAdmin(userId: String, email: String?, isEmailVerified: Boolean): Boolean {
        if (isEmailVerified && email.equals(BOOTSTRAPPED_ADMIN_EMAIL, ignoreCase = true)) {
            return true
        }
        return try {
            val snap = db.collection("admins").document(userId).get().await()
            snap.exists()
        } catch (e: CancellationException) {
            throw e
        } catch (_: Exception) {
            false
        }
    }

    companion object {
        const val BOOTSTRAPPED_ADMIN_EMAIL = "atinazil786@gmail.com"

        fun sanitizeDocId(raw: String): String {
            return raw.replace(Regex("[^a-zA-Z0-9_\\-]"), "_").take(120).ifBlank { "doc_1" }
        }
    }
}
