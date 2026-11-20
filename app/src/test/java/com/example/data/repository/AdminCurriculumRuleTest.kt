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

class AdminCurriculumRuleTest : FirestoreEmulatorTestBase() {

    @Test
    fun authenticatedStudent_canObservePublishedNewCollections() = runBlocking {
        signInTestUser(STUDENT_EMAIL)
        val repo = CurriculumRepository(firestore)

        val writing = withTimeout(FLOW_TIMEOUT_MS) { repo.observePublishedWritingMaterials().first() }
        val papers = withTimeout(FLOW_TIMEOUT_MS) { repo.observePublishedPreviousPapers().first() }
        val notes = withTimeout(FLOW_TIMEOUT_MS) { repo.observePublishedPdfNotes().first() }
        val videos = withTimeout(FLOW_TIMEOUT_MS) { repo.observePublishedVideoLinks().first() }

        assertNotNull(writing)
        assertNotNull(papers)
        assertNotNull(notes)
        assertNotNull(videos)
    }

    @Test
    fun authenticatedStudent_cannotWriteToAdminManagedCollections() = runBlocking {
        val uid = signInTestUser(STUDENT_EMAIL)
        val repo = CurriculumRepository(firestore)

        val writingWrite = withTimeout(DEFAULT_TIMEOUT_MS) {
            repo.saveAdminWritingMaterial(
                authorId = uid,
                topicCategory = "Notice Writing",
                title = "Unauthorized Notice",
                titleHi = "अनधिकृत",
                applicableClasses = listOf(10),
                explanationHi = "Test",
                formatTemplate = "Test",
                solvedExampleEn = "Test",
                solvedExampleHi = "Test",
                examQuestion = "Test",
                modelAnswer = "Test"
            )
        }
        assertTrue(writingWrite.isFailure)
        val wEx = writingWrite.exceptionOrNull()?.unwrapFirestoreException()
        assertEquals(FirebaseFirestoreException.Code.PERMISSION_DENIED, wEx?.code)

        val paperWrite = withTimeout(DEFAULT_TIMEOUT_MS) {
            repo.saveAdminPreviousPaper(
                authorId = uid,
                classLevel = 12,
                year = 2024,
                title = "Unauthorized Paper",
                setCode = "Set A",
                isVerifiedPyq = true,
                summaryHi = "Test",
                pdfFileName = "test.pdf",
                pdfUrl = "",
                pdfBase64 = "",
                questionsFormatted = emptyList()
            )
        }
        assertTrue(paperWrite.isFailure)
        val pEx = paperWrite.exceptionOrNull()?.unwrapFirestoreException()
        assertEquals(FirebaseFirestoreException.Code.PERMISSION_DENIED, pEx?.code)

        val noteWrite = withTimeout(DEFAULT_TIMEOUT_MS) {
            repo.saveAdminPdfNote(
                authorId = uid,
                classLevel = 10,
                chapterId = "c10_ff_1",
                title = "Unauthorized Note",
                summaryHi = "Test",
                pdfFileName = "note.pdf",
                pdfUrl = "",
                pdfBase64 = ""
            )
        }
        assertTrue(noteWrite.isFailure)
        val nEx = noteWrite.exceptionOrNull()?.unwrapFirestoreException()
        assertEquals(FirebaseFirestoreException.Code.PERMISSION_DENIED, nEx?.code)

        val videoWrite = withTimeout(DEFAULT_TIMEOUT_MS) {
            repo.saveAdminVideoLink(
                authorId = uid,
                classLevel = 10,
                chapterId = "c10_ff_1",
                title = "Unauthorized Video",
                summaryHi = "Test",
                videoUrl = "https://example.com"
            )
        }
        assertTrue(videoWrite.isFailure)
        val vEx = videoWrite.exceptionOrNull()?.unwrapFirestoreException()
        assertEquals(FirebaseFirestoreException.Code.PERMISSION_DENIED, vEx?.code)

        val photoWrite = withTimeout(DEFAULT_TIMEOUT_MS) {
            repo.saveTeacherPhotoConfig(
                authorId = uid,
                photoBase64 = "unauthorized_base64"
            )
        }
        assertTrue(photoWrite.isFailure)
        val photoEx = photoWrite.exceptionOrNull()?.unwrapFirestoreException()
        assertEquals(FirebaseFirestoreException.Code.PERMISSION_DENIED, photoEx?.code)
    }

    @Test
    fun authenticatedStudent_canObserveTeacherProfileConfig() = runBlocking {
        signInTestUser(STUDENT_EMAIL)
        val repo = CurriculumRepository(firestore)

        // Document may be absent (null) in clean emulator state, but observation must succeed without PERMISSION_DENIED
        val config = withTimeout(FLOW_TIMEOUT_MS) { repo.observeTeacherProfileConfig().first() }
        assertTrue(config == null || config.teacherName.isNotBlank())
    }

    @Test
    fun unauthenticatedUser_cannotObserveNewCollections() = runBlocking {
        auth.signOut()
        val repo = CurriculumRepository(firestore)

        try {
            withTimeout(FLOW_TIMEOUT_MS) { repo.observePublishedPreviousPapers().first() }
            fail("Expected PERMISSION_DENIED for unauthenticated user reading previousPapers")
        } catch (e: Exception) {
            val firestoreEx = e.unwrapFirestoreException()
            assertNotNull("Expected nested FirebaseFirestoreException, got $e", firestoreEx)
            assertEquals(FirebaseFirestoreException.Code.PERMISSION_DENIED, firestoreEx!!.code)
        }

        try {
            withTimeout(FLOW_TIMEOUT_MS) { repo.observeTeacherProfileConfig().first() }
            fail("Expected PERMISSION_DENIED for unauthenticated user reading appConfig/teacherProfile")
        } catch (e: Exception) {
            val firestoreEx = e.unwrapFirestoreException()
            assertNotNull("Expected nested FirebaseFirestoreException, got $e", firestoreEx)
            assertEquals(FirebaseFirestoreException.Code.PERMISSION_DENIED, firestoreEx!!.code)
        }
    }

    private companion object {
        const val STUDENT_EMAIL = "student_reader@test.com"
        const val DEFAULT_TIMEOUT_MS = 8000L
        const val FLOW_TIMEOUT_MS = 8000L
    }
}
