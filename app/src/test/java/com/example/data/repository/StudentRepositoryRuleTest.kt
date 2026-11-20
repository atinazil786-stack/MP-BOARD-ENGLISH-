package com.example.data.repository

import com.example.base.FirestoreEmulatorTestBase
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Test
import java.util.UUID

class StudentRepositoryRuleTest : FirestoreEmulatorTestBase() {

    @Test
    fun ensureUserProfile_authenticatedUser_createsAndReadsProfile() = runBlocking {
        val uid = signInTestUser(ALICE_EMAIL)
        val repository = StudentRepository(firestore)

        val result = withTimeout(DEFAULT_TIMEOUT_MS) {
            repository.ensureUserProfile(uid, "Aarav Sharma", ALICE_EMAIL, 10)
        }
        assertTrue("Profile creation should succeed: ${result.exceptionOrNull()}", result.isSuccess)
        assertEquals(uid, result.getOrThrow().userId)
    }

    @Test
    fun toggleBookmark_and_observeBookmarks_emitsSavedBookmark() = runBlocking {
        val uid = signInTestUser(ALICE_EMAIL)
        val repository = StudentRepository(firestore)
        val bmId = "bm_${UUID.randomUUID().toString().replace("-", "").take(10)}"

        val toggleRes = withTimeout(DEFAULT_TIMEOUT_MS) {
            repository.toggleBookmark(
                userId = uid,
                bookmarkId = bmId,
                itemType = "chapter",
                targetId = "c10_ff_1",
                classLevel = 10,
                title = "A Letter to God",
                subtitle = "First Flight",
                currentlySaved = false
            )
        }
        assertTrue(toggleRes.isSuccess)
        assertTrue(toggleRes.getOrThrow())

        val bookmarks = withTimeout(FLOW_TIMEOUT_MS) {
            repository.observeBookmarks(uid).first { list -> list.any { it.id == bmId } }
        }
        assertTrue(bookmarks.any { it.id == bmId })
    }

    @Test
    fun saveTestResult_and_crossUserIsolation_enforcesSecurityRules() = runBlocking {
        val aliceUid = signInTestUser(ALICE_EMAIL)
        val aliceRepo = StudentRepository(firestore)

        val savedId = withTimeout(DEFAULT_TIMEOUT_MS) {
            aliceRepo.saveTestResult(
                userId = aliceUid,
                testTitle = "Class 10 Quick 20Q",
                testMode = "20Q",
                classLevel = 10,
                totalQuestions = 20,
                correctCount = 17,
                wrongCount = 3,
                skippedCount = 0,
                percentage = 85,
                durationSeconds = 300
            )
        }
        assertTrue(savedId.isSuccess)

        signInTestUser(BOB_EMAIL)
        val bobRepo = StudentRepository(firestore)

        try {
            withTimeout(FLOW_TIMEOUT_MS) {
                bobRepo.observeTestHistory(aliceUid).first()
            }
            fail("Expected PERMISSION_DENIED when Bob reads Alice's test history")
        } catch (e: Exception) {
            val firestoreEx = e.unwrapFirestoreException()
            assertNotNull("Expected nested FirebaseFirestoreException, got $e", firestoreEx)
            assertEquals(FirebaseFirestoreException.Code.PERMISSION_DENIED, firestoreEx!!.code)
        }
    }

    @Test
    fun observeUserProfile_unauthenticatedUser_failsWithPermissionDenied() = runBlocking {
        auth.signOut()
        val repository = StudentRepository(firestore)

        try {
            withTimeout(FLOW_TIMEOUT_MS) {
                repository.observeUserProfile("some_uid").first()
            }
            fail("Expected PERMISSION_DENIED for unauthenticated caller")
        } catch (e: Exception) {
            val firestoreEx = e.unwrapFirestoreException()
            assertNotNull("Expected nested FirebaseFirestoreException, got $e", firestoreEx)
            assertEquals(FirebaseFirestoreException.Code.PERMISSION_DENIED, firestoreEx!!.code)
        }
    }

    @Test
    fun saveWritingPracticeAttempt_and_crossUserIsolation_enforcesSecurityRules() = runBlocking {
        val aliceUid = signInTestUser(ALICE_EMAIL)
        val aliceRepo = StudentRepository(firestore)

        val evaluation = com.example.data.model.AiAnswerEvaluation(
            marksObtained = 2.5,
            maxMarks = 3,
            grammarScore = 88,
            spellingScore = 95,
            vocabularyScore = 82,
            sentenceFormationScore = 84,
            contentRelevanceScore = 90,
            answerStructureScore = 86,
            correctedAnswer = "Lencho wrote a letter to God asking for 100 pesos.",
            grammaticalMistakes = listOf("Use 'asking for' instead of 'ask for'."),
            suggestions = listOf("Add the reason why his crops were destroyed."),
            modelAnswer = "Lencho wrote a letter to God asking for 100 pesos after a hailstorm ruined his crops.",
            explanationHi = "आपका उत्तर अच्छा है। कृपया 100 पेसोस और ओलावृष्टि का स्पष्ट उल्लेख करें।"
        )

        val saveRes = withTimeout(DEFAULT_TIMEOUT_MS) {
            aliceRepo.saveWritingPracticeAttempt(
                userId = aliceUid,
                classLevel = 10,
                chapterId = "c10_ff_1",
                chapterTitle = "A Letter to God",
                questionPrompt = "Why did Lencho write a letter to God?",
                studentAnswer = "Lencho wrote a letter to God ask for 100 pesos.",
                evaluation = evaluation
            )
        }
        assertTrue("Writing attempt save should succeed: ${saveRes.exceptionOrNull()}", saveRes.isSuccess)
        val attemptId = saveRes.getOrThrow()

        val history = withTimeout(FLOW_TIMEOUT_MS) {
            aliceRepo.observeWritingPracticeHistory(aliceUid).first { list -> list.any { it.id == attemptId } }
        }
        assertTrue(history.any { it.id == attemptId && it.marksObtained == 2.5 })

        val ownSummaries = withTimeout(FLOW_TIMEOUT_MS) {
            aliceRepo.observeOwnTestSummaries(aliceUid).first()
        }
        assertNotNull(ownSummaries)

        signInTestUser(BOB_EMAIL)
        val bobRepo = StudentRepository(firestore)
        try {
            withTimeout(FLOW_TIMEOUT_MS) {
                bobRepo.observeWritingPracticeHistory(aliceUid).first()
            }
            fail("Expected PERMISSION_DENIED when Bob reads Alice's writing practice history")
        } catch (e: Exception) {
            val firestoreEx = e.unwrapFirestoreException()
            assertNotNull("Expected nested FirebaseFirestoreException, got $e", firestoreEx)
            assertEquals(FirebaseFirestoreException.Code.PERMISSION_DENIED, firestoreEx!!.code)
        }
    }

    private companion object {
        const val ALICE_EMAIL = "alice_student@test.com"
        const val BOB_EMAIL = "bob_student@test.com"
        const val DEFAULT_TIMEOUT_MS = 5000L
        const val FLOW_TIMEOUT_MS = 3000L
    }
}
