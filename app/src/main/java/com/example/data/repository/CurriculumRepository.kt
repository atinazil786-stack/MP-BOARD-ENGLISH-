package com.example.data.repository

import android.content.Context
import com.example.R
import com.example.core.firebase.OperationType
import com.example.core.firebase.handleFirestoreError
import com.example.data.model.AdminChapterDoc
import com.example.data.model.AdminGrammarDoc
import com.example.data.model.AdminQuestionDoc
import com.example.data.model.AdminTestPaperDoc
import com.example.data.model.Chapter
import com.example.data.model.ChapterQuestion
import com.example.data.model.GrammarExample
import com.example.data.model.GrammarTopic
import com.example.data.model.QuestionSourceTag
import com.example.data.model.QuestionType
import com.example.data.model.WordMeaning
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

class CurriculumRepository(private val db: FirebaseFirestore) {

    constructor(context: Context) : this(
        FirebaseFirestore.getInstance(
            context.applicationContext.getString(R.string.firestore_database_id)
        )
    )

    fun observePublishedAdminChapters(): Flow<List<Chapter>> {
        val path = "chapters"
        return db.collection(path)
            .whereEqualTo("isPublished", true)
            .snapshots()
            .map { snap ->
                snap.toObjects(
                    AdminChapterDoc::class.java,
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                ).map { doc -> doc.toDomainChapter() }
            }
            .catch { error ->
                handleFirestoreError(error, OperationType.LIST, path)
                throw error
            }
    }

    fun observePublishedAdminQuestions(): Flow<List<ChapterQuestion>> {
        val path = "chapterQuestions"
        return db.collection(path)
            .whereEqualTo("isPublished", true)
            .snapshots()
            .map { snap ->
                snap.toObjects(
                    AdminQuestionDoc::class.java,
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                ).map { doc -> doc.toDomainQuestion() }
            }
            .catch { error ->
                handleFirestoreError(error, OperationType.LIST, path)
                throw error
            }
    }

    fun observePublishedAdminGrammar(): Flow<List<GrammarTopic>> {
        val path = "grammarTopics"
        return db.collection(path)
            .whereEqualTo("isPublished", true)
            .snapshots()
            .map { snap ->
                snap.toObjects(
                    AdminGrammarDoc::class.java,
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                ).map { doc -> doc.toDomainGrammar() }
            }
            .catch { error ->
                handleFirestoreError(error, OperationType.LIST, path)
                throw error
            }
    }

    fun observePublishedCustomTests(): Flow<List<AdminTestPaperDoc>> {
        val path = "customTests"
        return db.collection(path)
            .whereEqualTo("isPublished", true)
            .snapshots()
            .map { snap ->
                snap.toObjects(
                    AdminTestPaperDoc::class.java,
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                )
            }
            .catch { error ->
                handleFirestoreError(error, OperationType.LIST, path)
                throw error
            }
    }

    // --- ADMIN CRUD OPERATIONS ---

    suspend fun saveAdminChapter(
        authorId: String,
        existingId: String? = null,
        classLevel: Int,
        bookName: String,
        chapterNumber: Int,
        title: String,
        author: String,
        summaryEn: String,
        summaryHi: String,
        hindiExplanation: String,
        wordMeaningsFormatted: List<String>
    ): Result<String> {
        val docId = existingId?.takeIf { it.isNotBlank() }
            ?: "ch_${classLevel}_${UUID.randomUUID().toString().replace("-", "").take(10)}"
        val docRef = db.collection("chapters").document(docId)
        return try {
            val existingSnap = if (existingId != null) docRef.get().await() else null
            if (existingSnap != null && existingSnap.exists()) {
                docRef.update(
                    mapOf(
                        "classLevel" to classLevel.coerceIn(9, 12),
                        "bookName" to bookName.ifBlank { "Textbook" }.take(60),
                        "chapterNumber" to chapterNumber.coerceIn(1, 30),
                        "title" to title.ifBlank { "Untitled Chapter" }.take(150),
                        "author" to author.ifBlank { "Imran Gori Sir" }.take(100),
                        "summaryEn" to summaryEn.ifBlank { title }.take(4000),
                        "summaryHi" to summaryHi.ifBlank { title }.take(4000),
                        "hindiExplanation" to hindiExplanation.ifBlank { summaryHi }.take(6000),
                        "wordMeanings" to wordMeaningsFormatted.take(100),
                        "isPublished" to true,
                        "updatedAt" to FieldValue.serverTimestamp()
                    )
                ).await()
            } else {
                docRef.set(
                    mapOf(
                        "authorId" to authorId,
                        "classLevel" to classLevel.coerceIn(9, 12),
                        "bookName" to bookName.ifBlank { "Textbook" }.take(60),
                        "chapterNumber" to chapterNumber.coerceIn(1, 30),
                        "title" to title.ifBlank { "Untitled Chapter" }.take(150),
                        "author" to author.ifBlank { "Imran Gori Sir" }.take(100),
                        "summaryEn" to summaryEn.ifBlank { title }.take(4000),
                        "summaryHi" to summaryHi.ifBlank { title }.take(4000),
                        "hindiExplanation" to hindiExplanation.ifBlank { summaryHi }.take(6000),
                        "wordMeanings" to wordMeaningsFormatted.take(100),
                        "isPublished" to true,
                        "createdAt" to FieldValue.serverTimestamp(),
                        "updatedAt" to FieldValue.serverTimestamp()
                    )
                ).await()
            }
            Result.success(docId)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.WRITE, docRef.path)
            Result.failure(e)
        }
    }

    suspend fun deleteAdminChapter(chapterId: String): Result<Unit> {
        val docRef = db.collection("chapters").document(chapterId)
        return try {
            docRef.delete().await()
            Result.success(Unit)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.DELETE, docRef.path)
            Result.failure(e)
        }
    }

    suspend fun saveAdminQuestion(
        authorId: String,
        existingId: String? = null,
        chapterId: String,
        classLevel: Int,
        questionType: QuestionType,
        promptEn: String,
        promptHi: String,
        answerEn: String,
        answerHi: String,
        options: List<String>,
        correctOptionIndex: Int,
        explanationHi: String
    ): Result<String> {
        val docId = existingId?.takeIf { it.isNotBlank() }
            ?: "q_${classLevel}_${UUID.randomUUID().toString().replace("-", "").take(10)}"
        val docRef = db.collection("chapterQuestions").document(docId)
        return try {
            val existingSnap = if (existingId != null) docRef.get().await() else null
            val safeOptions = options.filter { it.isNotBlank() }.take(4)
            val safeCorrect = if (safeOptions.isEmpty()) -1 else correctOptionIndex.coerceIn(0, safeOptions.lastIndex)
            if (existingSnap != null && existingSnap.exists()) {
                docRef.update(
                    mapOf(
                        "chapterId" to chapterId.ifBlank { "general" }.take(128),
                        "classLevel" to classLevel.coerceIn(9, 12),
                        "questionType" to questionType.name,
                        "sourceTag" to QuestionSourceTag.ADMIN_ADDED.name,
                        "promptEn" to promptEn.ifBlank { "Question" }.take(1000),
                        "promptHi" to promptHi.take(1000),
                        "answerEn" to answerEn.ifBlank { "Answer" }.take(2000),
                        "answerHi" to answerHi.take(2000),
                        "options" to safeOptions,
                        "correctOptionIndex" to safeCorrect,
                        "explanationHi" to explanationHi.take(1500),
                        "isPublished" to true,
                        "updatedAt" to FieldValue.serverTimestamp()
                    )
                ).await()
            } else {
                docRef.set(
                    mapOf(
                        "authorId" to authorId,
                        "chapterId" to chapterId.ifBlank { "general" }.take(128),
                        "classLevel" to classLevel.coerceIn(9, 12),
                        "questionType" to questionType.name,
                        "sourceTag" to QuestionSourceTag.ADMIN_ADDED.name,
                        "promptEn" to promptEn.ifBlank { "Question" }.take(1000),
                        "promptHi" to promptHi.take(1000),
                        "answerEn" to answerEn.ifBlank { "Answer" }.take(2000),
                        "answerHi" to answerHi.take(2000),
                        "options" to safeOptions,
                        "correctOptionIndex" to safeCorrect,
                        "explanationHi" to explanationHi.take(1500),
                        "isPublished" to true,
                        "createdAt" to FieldValue.serverTimestamp(),
                        "updatedAt" to FieldValue.serverTimestamp()
                    )
                ).await()
            }
            Result.success(docId)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.WRITE, docRef.path)
            Result.failure(e)
        }
    }

    suspend fun deleteAdminQuestion(questionId: String): Result<Unit> {
        val docRef = db.collection("chapterQuestions").document(questionId)
        return try {
            docRef.delete().await()
            Result.success(Unit)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.DELETE, docRef.path)
            Result.failure(e)
        }
    }

    suspend fun saveAdminGrammar(
        authorId: String,
        existingId: String? = null,
        title: String,
        titleHi: String,
        category: String,
        explanationHi: String,
        rulesSummaryEn: String,
        examplesFormatted: List<String>
    ): Result<String> {
        val docId = existingId?.takeIf { it.isNotBlank() }
            ?: "gr_${UUID.randomUUID().toString().replace("-", "").take(10)}"
        val docRef = db.collection("grammarTopics").document(docId)
        return try {
            val existingSnap = if (existingId != null) docRef.get().await() else null
            if (existingSnap != null && existingSnap.exists()) {
                docRef.update(
                    mapOf(
                        "title" to title.ifBlank { "Grammar Lesson" }.take(120),
                        "titleHi" to titleHi.ifBlank { title }.take(120),
                        "category" to category.ifBlank { "Core Grammar" }.take(60),
                        "explanationHi" to explanationHi.ifBlank { titleHi }.take(5000),
                        "rulesSummaryEn" to rulesSummaryEn.ifBlank { title }.take(4000),
                        "examples" to examplesFormatted.take(20),
                        "isPublished" to true,
                        "updatedAt" to FieldValue.serverTimestamp()
                    )
                ).await()
            } else {
                docRef.set(
                    mapOf(
                        "authorId" to authorId,
                        "title" to title.ifBlank { "Grammar Lesson" }.take(120),
                        "titleHi" to titleHi.ifBlank { title }.take(120),
                        "category" to category.ifBlank { "Core Grammar" }.take(60),
                        "explanationHi" to explanationHi.ifBlank { titleHi }.take(5000),
                        "rulesSummaryEn" to rulesSummaryEn.ifBlank { title }.take(4000),
                        "examples" to examplesFormatted.take(20),
                        "isPublished" to true,
                        "createdAt" to FieldValue.serverTimestamp(),
                        "updatedAt" to FieldValue.serverTimestamp()
                    )
                ).await()
            }
            Result.success(docId)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.WRITE, docRef.path)
            Result.failure(e)
        }
    }

    suspend fun deleteAdminGrammar(topicId: String): Result<Unit> {
        val docRef = db.collection("grammarTopics").document(topicId)
        return try {
            docRef.delete().await()
            Result.success(Unit)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.DELETE, docRef.path)
            Result.failure(e)
        }
    }

    suspend fun saveAdminTestPaper(
        authorId: String,
        existingId: String? = null,
        title: String,
        classLevel: Int,
        testMode: String,
        durationMinutes: Int,
        questionCount: Int
    ): Result<String> {
        val docId = existingId?.takeIf { it.isNotBlank() }
            ?: "tp_${classLevel}_${UUID.randomUUID().toString().replace("-", "").take(10)}"
        val docRef = db.collection("customTests").document(docId)
        return try {
            val existingSnap = if (existingId != null) docRef.get().await() else null
            if (existingSnap != null && existingSnap.exists()) {
                docRef.update(
                    mapOf(
                        "title" to title.ifBlank { "Custom MP Board Paper" }.take(150),
                        "classLevel" to classLevel.coerceIn(9, 12),
                        "testMode" to testMode,
                        "durationMinutes" to durationMinutes.coerceIn(1, 180),
                        "questionCount" to questionCount.coerceIn(1, 100),
                        "isPublished" to true,
                        "updatedAt" to FieldValue.serverTimestamp()
                    )
                ).await()
            } else {
                docRef.set(
                    mapOf(
                        "authorId" to authorId,
                        "title" to title.ifBlank { "Custom MP Board Paper" }.take(150),
                        "classLevel" to classLevel.coerceIn(9, 12),
                        "testMode" to testMode,
                        "durationMinutes" to durationMinutes.coerceIn(1, 180),
                        "questionCount" to questionCount.coerceIn(1, 100),
                        "isPublished" to true,
                        "createdAt" to FieldValue.serverTimestamp(),
                        "updatedAt" to FieldValue.serverTimestamp()
                    )
                ).await()
            }
            Result.success(docId)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.WRITE, docRef.path)
            Result.failure(e)
        }
    }

    suspend fun deleteAdminTestPaper(testId: String): Result<Unit> {
        val docRef = db.collection("customTests").document(testId)
        return try {
            docRef.delete().await()
            Result.success(Unit)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.DELETE, docRef.path)
            Result.failure(e)
        }
    }

    // --- WRITING MATERIALS ---

    fun observePublishedWritingMaterials(): Flow<List<com.example.data.model.AdminWritingMaterialDoc>> {
        val path = "writingMaterials"
        return db.collection(path)
            .whereEqualTo("isPublished", true)
            .snapshots()
            .map { snap ->
                snap.toObjects(
                    com.example.data.model.AdminWritingMaterialDoc::class.java,
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                )
            }
            .catch { error ->
                handleFirestoreError(error, OperationType.LIST, path)
                throw error
            }
    }

    suspend fun saveAdminWritingMaterial(
        authorId: String,
        existingId: String? = null,
        topicCategory: String,
        title: String,
        titleHi: String,
        applicableClasses: List<Int>,
        explanationHi: String,
        formatTemplate: String,
        solvedExampleEn: String,
        solvedExampleHi: String,
        examQuestion: String,
        modelAnswer: String
    ): Result<String> {
        val docId = existingId?.takeIf { it.isNotBlank() }
            ?: "wm_${UUID.randomUUID().toString().replace("-", "").take(10)}"
        val docRef = db.collection("writingMaterials").document(docId)
        return try {
            val existingSnap = if (existingId != null) docRef.get().await() else null
            val safeClasses = applicableClasses.filter { it in 9..12 }.distinct().ifEmpty { listOf(9, 10, 11, 12) }
            val fields = mapOf(
                "topicCategory" to topicCategory.ifBlank { "Paragraph Writing" }.take(100),
                "title" to title.ifBlank { "Writing Material" }.take(160),
                "titleHi" to titleHi.take(160),
                "applicableClasses" to safeClasses,
                "explanationHi" to explanationHi.ifBlank { title }.take(6000),
                "formatTemplate" to formatTemplate.take(4000),
                "solvedExampleEn" to solvedExampleEn.take(6000),
                "solvedExampleHi" to solvedExampleHi.take(6000),
                "examQuestion" to examQuestion.take(2000),
                "modelAnswer" to modelAnswer.take(6000),
                "isPublished" to true,
                "updatedAt" to FieldValue.serverTimestamp()
            )
            if (existingSnap != null && existingSnap.exists()) {
                docRef.update(fields).await()
            } else {
                docRef.set(fields + mapOf("authorId" to authorId, "createdAt" to FieldValue.serverTimestamp())).await()
            }
            Result.success(docId)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.WRITE, docRef.path)
            Result.failure(e)
        }
    }

    suspend fun deleteAdminWritingMaterial(materialId: String): Result<Unit> {
        val docRef = db.collection("writingMaterials").document(materialId)
        return try {
            docRef.delete().await()
            Result.success(Unit)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.DELETE, docRef.path)
            Result.failure(e)
        }
    }

    // --- PREVIOUS YEAR QUESTION PAPERS ---

    fun observePublishedPreviousPapers(): Flow<List<com.example.data.model.AdminPreviousPaperDoc>> {
        val path = "previousPapers"
        return db.collection(path)
            .whereEqualTo("isPublished", true)
            .snapshots()
            .map { snap ->
                snap.toObjects(
                    com.example.data.model.AdminPreviousPaperDoc::class.java,
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                )
            }
            .catch { error ->
                handleFirestoreError(error, OperationType.LIST, path)
                throw error
            }
    }

    suspend fun saveAdminPreviousPaper(
        authorId: String,
        existingId: String? = null,
        classLevel: Int,
        year: Int,
        title: String,
        setCode: String,
        isVerifiedPyq: Boolean,
        summaryHi: String,
        pdfFileName: String,
        pdfUrl: String,
        pdfBase64: String,
        questionsFormatted: List<String>
    ): Result<String> {
        val docId = existingId?.takeIf { it.isNotBlank() }
            ?: "pyq_${classLevel}_${year}_${UUID.randomUUID().toString().replace("-", "").take(8)}"
        val docRef = db.collection("previousPapers").document(docId)
        return try {
            val existingSnap = if (existingId != null) docRef.get().await() else null
            val fields = mapOf(
                "classLevel" to classLevel.coerceIn(9, 12),
                "year" to year.coerceIn(2018, 2030),
                "title" to title.ifBlank { "MPBSE Question Paper $year" }.take(180),
                "setCode" to setCode.ifBlank { "Set A" }.take(60),
                "isVerifiedPyq" to isVerifiedPyq,
                "summaryHi" to summaryHi.take(4000),
                "pdfFileName" to pdfFileName.take(200),
                "pdfUrl" to pdfUrl.take(1000),
                "pdfBase64" to pdfBase64.take(650000),
                "questionsFormatted" to questionsFormatted.filter { it.isNotBlank() }.take(80),
                "isPublished" to true,
                "updatedAt" to FieldValue.serverTimestamp()
            )
            if (existingSnap != null && existingSnap.exists()) {
                docRef.update(fields).await()
            } else {
                docRef.set(fields + mapOf("authorId" to authorId, "createdAt" to FieldValue.serverTimestamp())).await()
            }
            Result.success(docId)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.WRITE, docRef.path)
            Result.failure(e)
        }
    }

    suspend fun deleteAdminPreviousPaper(paperId: String): Result<Unit> {
        val docRef = db.collection("previousPapers").document(paperId)
        return try {
            docRef.delete().await()
            Result.success(Unit)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.DELETE, docRef.path)
            Result.failure(e)
        }
    }

    // --- PDF NOTES ---

    fun observePublishedPdfNotes(): Flow<List<com.example.data.model.AdminPdfNoteDoc>> {
        val path = "pdfNotes"
        return db.collection(path)
            .whereEqualTo("isPublished", true)
            .snapshots()
            .map { snap ->
                snap.toObjects(
                    com.example.data.model.AdminPdfNoteDoc::class.java,
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                )
            }
            .catch { error ->
                handleFirestoreError(error, OperationType.LIST, path)
                throw error
            }
    }

    suspend fun saveAdminPdfNote(
        authorId: String,
        existingId: String? = null,
        classLevel: Int,
        chapterId: String,
        title: String,
        summaryHi: String,
        pdfFileName: String,
        pdfUrl: String,
        pdfBase64: String
    ): Result<String> {
        val docId = existingId?.takeIf { it.isNotBlank() }
            ?: "note_${classLevel}_${UUID.randomUUID().toString().replace("-", "").take(10)}"
        val docRef = db.collection("pdfNotes").document(docId)
        return try {
            val existingSnap = if (existingId != null) docRef.get().await() else null
            val fields = mapOf(
                "classLevel" to classLevel.coerceIn(9, 12),
                "chapterId" to chapterId.ifBlank { "general" }.take(128),
                "title" to title.ifBlank { "PDF Revision Notes" }.take(180),
                "summaryHi" to summaryHi.take(2000),
                "pdfFileName" to pdfFileName.take(200),
                "pdfUrl" to pdfUrl.take(1000),
                "pdfBase64" to pdfBase64.take(650000),
                "isPublished" to true,
                "updatedAt" to FieldValue.serverTimestamp()
            )
            if (existingSnap != null && existingSnap.exists()) {
                docRef.update(fields).await()
            } else {
                docRef.set(fields + mapOf("authorId" to authorId, "createdAt" to FieldValue.serverTimestamp())).await()
            }
            Result.success(docId)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.WRITE, docRef.path)
            Result.failure(e)
        }
    }

    suspend fun deleteAdminPdfNote(noteId: String): Result<Unit> {
        val docRef = db.collection("pdfNotes").document(noteId)
        return try {
            docRef.delete().await()
            Result.success(Unit)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.DELETE, docRef.path)
            Result.failure(e)
        }
    }

    // --- ANIMATED VIDEO LINKS ---

    fun observePublishedVideoLinks(): Flow<List<com.example.data.model.AdminVideoLinkDoc>> {
        val path = "videoLinks"
        return db.collection(path)
            .whereEqualTo("isPublished", true)
            .snapshots()
            .map { snap ->
                snap.toObjects(
                    com.example.data.model.AdminVideoLinkDoc::class.java,
                    DocumentSnapshot.ServerTimestampBehavior.ESTIMATE
                )
            }
            .catch { error ->
                handleFirestoreError(error, OperationType.LIST, path)
                throw error
            }
    }

    suspend fun saveAdminVideoLink(
        authorId: String,
        existingId: String? = null,
        classLevel: Int,
        chapterId: String,
        title: String,
        summaryHi: String,
        videoUrl: String
    ): Result<String> {
        val docId = existingId?.takeIf { it.isNotBlank() }
            ?: "vid_${classLevel}_${UUID.randomUUID().toString().replace("-", "").take(10)}"
        val docRef = db.collection("videoLinks").document(docId)
        return try {
            val existingSnap = if (existingId != null) docRef.get().await() else null
            val fields = mapOf(
                "classLevel" to classLevel.coerceIn(9, 12),
                "chapterId" to chapterId.ifBlank { "general" }.take(128),
                "title" to title.ifBlank { "Animated Lesson Video" }.take(180),
                "summaryHi" to summaryHi.take(2000),
                "videoUrl" to videoUrl.ifBlank { "https://youtube.com" }.take(1000),
                "isPublished" to true,
                "updatedAt" to FieldValue.serverTimestamp()
            )
            if (existingSnap != null && existingSnap.exists()) {
                docRef.update(fields).await()
            } else {
                docRef.set(fields + mapOf("authorId" to authorId, "createdAt" to FieldValue.serverTimestamp())).await()
            }
            Result.success(docId)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.WRITE, docRef.path)
            Result.failure(e)
        }
    }

    suspend fun deleteAdminVideoLink(videoId: String): Result<Unit> {
        val docRef = db.collection("videoLinks").document(videoId)
        return try {
            docRef.delete().await()
            Result.success(Unit)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.DELETE, docRef.path)
            Result.failure(e)
        }
    }

    // --- TEACHER PROFILE PHOTO CONFIG ---

    fun observeTeacherProfileConfig(): Flow<com.example.data.model.TeacherProfileConfigDoc?> {
        val docRef = db.collection("appConfig").document("teacherProfile")
        return docRef.snapshots()
            .map { snap ->
                if (snap.exists()) {
                    snap.toObject(
                        com.example.data.model.TeacherProfileConfigDoc::class.java,
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

    suspend fun saveTeacherPhotoConfig(
        authorId: String,
        photoBase64: String
    ): Result<Unit> {
        val docRef = db.collection("appConfig").document("teacherProfile")
        return try {
            val payload = mapOf(
                "authorId" to authorId,
                "teacherName" to "Imran Gori Sir",
                "brandTitle" to "IMRAN GORI SIR",
                "brandSubtitle" to "MP BOARD ENGLISH HUB",
                "photoBase64" to photoBase64.take(450000),
                "updatedAt" to FieldValue.serverTimestamp()
            )
            docRef.set(payload).await()
            Result.success(Unit)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            handleFirestoreError(e, OperationType.WRITE, docRef.path)
            Result.failure(e)
        }
    }
}

private fun AdminChapterDoc.toDomainChapter(): Chapter {
    val meanings = wordMeanings.mapNotNull { entry ->
        val parts = entry.split("::").map { it.trim() }
        if (parts.isEmpty() || parts[0].isBlank()) null
        else WordMeaning(
            word = parts.getOrElse(0) { "" },
            partOfSpeech = "vocab",
            meaningEn = parts.getOrElse(1) { "" },
            meaningHi = parts.getOrElse(2) { parts.getOrElse(1) { "" } },
            exampleSentence = parts.getOrElse(3) { "" }
        )
    }
    return Chapter(
        id = id,
        classLevel = classLevel.toInt(),
        bookName = bookName,
        chapterNumber = chapterNumber.toInt(),
        title = title,
        author = author,
        summaryEn = summaryEn,
        summaryHi = summaryHi,
        hindiExplanation = hindiExplanation,
        wordMeanings = meanings,
        questions = emptyList(),
        isAdminAdded = true
    )
}

private fun AdminQuestionDoc.toDomainQuestion(): ChapterQuestion {
    val qType = QuestionType.entries.firstOrNull { it.name == questionType } ?: QuestionType.MCQ
    return ChapterQuestion(
        id = id,
        chapterId = chapterId,
        classLevel = classLevel.toInt(),
        type = qType,
        sourceTag = QuestionSourceTag.ADMIN_ADDED,
        boardReference = "Added by Imran Gori Sir",
        promptEn = promptEn,
        promptHi = promptHi,
        answerEn = answerEn,
        answerHi = answerHi,
        options = options,
        correctOptionIndex = correctOptionIndex.toInt(),
        explanationHi = explanationHi
    )
}

private fun AdminGrammarDoc.toDomainGrammar(): GrammarTopic {
    val parsedExamples = examples.mapNotNull { line ->
        val parts = line.split("::").map { it.trim() }
        if (parts[0].isBlank()) null
        else GrammarExample(
            english = parts[0],
            hindi = parts.getOrElse(1) { "" },
            note = parts.getOrElse(2) { "" }
        )
    }
    return GrammarTopic(
        id = id,
        title = title,
        titleHi = titleHi,
        category = category,
        formula = "Admin Added Lesson",
        explanationHi = explanationHi,
        rulesSummaryEn = rulesSummaryEn,
        examples = parsedExamples,
        practiceQuestions = emptyList(),
        mcqQuestions = emptyList(),
        isAdminAdded = true
    )
}
