package com.example.data.model

import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.IgnoreExtraProperties
import com.google.firebase.firestore.ServerTimestamp

@IgnoreExtraProperties
data class UserProfileDoc(
    @DocumentId val id: String = "",
    val userId: String = "",
    val displayName: String = "",
    val email: String? = null,
    val selectedClass: Long = 10L,
    val darkMode: Boolean = false,
    val bilingualMode: Boolean = true,
    val dailyStreak: Long = 1L,
    val totalTestsTaken: Long = 0L,
    @ServerTimestamp val createdAt: Timestamp? = null,
    @ServerTimestamp val updatedAt: Timestamp? = null
)

@IgnoreExtraProperties
data class BookmarkDoc(
    @DocumentId val id: String = "",
    val userId: String = "",
    val itemType: String = "chapter",
    val targetId: String = "",
    val classLevel: Long = 10L,
    val title: String = "",
    val subtitle: String = "",
    @ServerTimestamp val createdAt: Timestamp? = null
)

@IgnoreExtraProperties
data class StudyProgressDoc(
    @DocumentId val id: String = "",
    val userId: String = "",
    val chapterId: String = "",
    val classLevel: Long = 10L,
    val completedSections: List<String> = emptyList(),
    val masteryPercent: Long = 0L,
    @ServerTimestamp val createdAt: Timestamp? = null,
    @ServerTimestamp val updatedAt: Timestamp? = null
)

@IgnoreExtraProperties
data class TestResultDoc(
    @DocumentId val id: String = "",
    val userId: String = "",
    val testTitle: String = "",
    val testMode: String = "20Q",
    val classLevel: Long = 10L,
    val totalQuestions: Long = 0L,
    val correctCount: Long = 0L,
    val wrongCount: Long = 0L,
    val skippedCount: Long = 0L,
    val percentage: Long = 0L,
    val durationSeconds: Long = 0L,
    @ServerTimestamp val createdAt: Timestamp? = null
)

@IgnoreExtraProperties
data class AdminChapterDoc(
    @DocumentId val id: String = "",
    val authorId: String = "",
    val classLevel: Long = 10L,
    val bookName: String = "",
    val chapterNumber: Long = 1L,
    val title: String = "",
    val author: String = "",
    val summaryEn: String = "",
    val summaryHi: String = "",
    val hindiExplanation: String = "",
    val wordMeanings: List<String> = emptyList(),
    val isPublished: Boolean = true,
    @ServerTimestamp val createdAt: Timestamp? = null,
    @ServerTimestamp val updatedAt: Timestamp? = null
)

@IgnoreExtraProperties
data class AdminQuestionDoc(
    @DocumentId val id: String = "",
    val authorId: String = "",
    val chapterId: String = "",
    val classLevel: Long = 10L,
    val questionType: String = "MCQ",
    val sourceTag: String = "ADMIN_ADDED",
    val promptEn: String = "",
    val promptHi: String = "",
    val answerEn: String = "",
    val answerHi: String = "",
    val options: List<String> = emptyList(),
    val correctOptionIndex: Long = -1L,
    val explanationHi: String = "",
    val isPublished: Boolean = true,
    @ServerTimestamp val createdAt: Timestamp? = null,
    @ServerTimestamp val updatedAt: Timestamp? = null
)

@IgnoreExtraProperties
data class AdminGrammarDoc(
    @DocumentId val id: String = "",
    val authorId: String = "",
    val title: String = "",
    val titleHi: String = "",
    val category: String = "",
    val explanationHi: String = "",
    val rulesSummaryEn: String = "",
    val examples: List<String> = emptyList(),
    val isPublished: Boolean = true,
    @ServerTimestamp val createdAt: Timestamp? = null,
    @ServerTimestamp val updatedAt: Timestamp? = null
)

@IgnoreExtraProperties
data class AdminTestPaperDoc(
    @DocumentId val id: String = "",
    val authorId: String = "",
    val title: String = "",
    val classLevel: Long = 10L,
    val testMode: String = "20Q",
    val durationMinutes: Long = 15L,
    val questionCount: Long = 20L,
    val isPublished: Boolean = true,
    @ServerTimestamp val createdAt: Timestamp? = null,
    @ServerTimestamp val updatedAt: Timestamp? = null
)

@IgnoreExtraProperties
data class WritingPracticeAttemptDoc(
    @DocumentId val id: String = "",
    val userId: String = "",
    val classLevel: Long = 10L,
    val chapterId: String = "",
    val chapterTitle: String = "",
    val questionPrompt: String = "",
    val studentAnswer: String = "",
    val maxMarks: Long = 3L,
    val marksObtained: Double = 0.0,
    val grammarScore: Long = 0L,
    val spellingScore: Long = 0L,
    val vocabularyScore: Long = 0L,
    val structureScore: Long = 0L,
    val correctedAnswer: String = "",
    val grammaticalMistakes: List<String> = emptyList(),
    val suggestions: List<String> = emptyList(),
    val modelAnswer: String = "",
    val explanationHi: String = "",
    @ServerTimestamp val createdAt: Timestamp? = null
)

@IgnoreExtraProperties
data class StudentTestSummaryDoc(
    @DocumentId val id: String = "",
    val userId: String = "",
    val studentName: String = "",
    val testTitle: String = "",
    val testMode: String = "20Q",
    val classLevel: Long = 10L,
    val totalQuestions: Long = 0L,
    val correctCount: Long = 0L,
    val wrongCount: Long = 0L,
    val percentage: Long = 0L,
    val durationSeconds: Long = 0L,
    @ServerTimestamp val createdAt: Timestamp? = null
)

@IgnoreExtraProperties
data class AdminWritingMaterialDoc(
    @DocumentId val id: String = "",
    val authorId: String = "",
    val topicCategory: String = "",
    val title: String = "",
    val titleHi: String = "",
    val applicableClasses: List<Long> = listOf(9L, 10L, 11L, 12L),
    val explanationHi: String = "",
    val formatTemplate: String = "",
    val solvedExampleEn: String = "",
    val solvedExampleHi: String = "",
    val examQuestion: String = "",
    val modelAnswer: String = "",
    val isPublished: Boolean = true,
    @ServerTimestamp val createdAt: Timestamp? = null,
    @ServerTimestamp val updatedAt: Timestamp? = null
)

@IgnoreExtraProperties
data class AdminPreviousPaperDoc(
    @DocumentId val id: String = "",
    val authorId: String = "",
    val classLevel: Long = 10L,
    val year: Long = 2024L,
    val title: String = "",
    val setCode: String = "Set A",
    val isVerifiedPyq: Boolean = true,
    val summaryHi: String = "",
    val pdfFileName: String = "",
    val pdfUrl: String = "",
    val pdfBase64: String = "",
    val questionsFormatted: List<String> = emptyList(),
    val isPublished: Boolean = true,
    @ServerTimestamp val createdAt: Timestamp? = null,
    @ServerTimestamp val updatedAt: Timestamp? = null
)

@IgnoreExtraProperties
data class AdminPdfNoteDoc(
    @DocumentId val id: String = "",
    val authorId: String = "",
    val classLevel: Long = 10L,
    val chapterId: String = "",
    val title: String = "",
    val summaryHi: String = "",
    val pdfFileName: String = "",
    val pdfUrl: String = "",
    val pdfBase64: String = "",
    val isPublished: Boolean = true,
    @ServerTimestamp val createdAt: Timestamp? = null,
    @ServerTimestamp val updatedAt: Timestamp? = null
)

@IgnoreExtraProperties
data class AdminVideoLinkDoc(
    @DocumentId val id: String = "",
    val authorId: String = "",
    val classLevel: Long = 10L,
    val chapterId: String = "",
    val title: String = "",
    val summaryHi: String = "",
    val videoUrl: String = "",
    val isPublished: Boolean = true,
    @ServerTimestamp val createdAt: Timestamp? = null,
    @ServerTimestamp val updatedAt: Timestamp? = null
)

@IgnoreExtraProperties
data class TeacherProfileConfigDoc(
    @DocumentId val id: String = "teacherProfile",
    val authorId: String = "",
    val teacherName: String = "Imran Gori Sir",
    val brandTitle: String = "IMRAN GORI SIR",
    val brandSubtitle: String = "MP BOARD ENGLISH HUB",
    val photoBase64: String = "",
    @ServerTimestamp val updatedAt: Timestamp? = null
)
