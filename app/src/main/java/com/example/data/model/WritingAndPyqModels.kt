package com.example.data.model

data class WritingSolvedExample(
    val title: String,
    val questionEn: String,
    val englishAnswer: String,
    val hindiExplanation: String
)

data class WritingExamQuestion(
    val id: String,
    val boardRef: String,
    val marks: Int,
    val questionEn: String,
    val questionHi: String,
    val modelAnswer: String
)

data class WritingExercise(
    val id: String,
    val promptEn: String,
    val promptHi: String,
    val marks: Int,
    val hintsHi: String
)

data class WritingSkillTopic(
    val id: String,
    val order: Int,
    val titleEn: String,
    val titleHi: String,
    val applicableClasses: List<Int>,
    val syllabusNoteHi: String,
    val explanationHi: String,
    val rulesAndFormatEn: List<String>,
    val formatTemplate: String,
    val stepsHi: List<String>,
    val solvedExamples: List<WritingSolvedExample>,
    val examQuestionsAndModels: List<WritingExamQuestion>,
    val practiceExercises: List<WritingExercise>,
    val isAdminAdded: Boolean = false
)

enum class PyqSectionType(val labelEn: String, val labelHi: String) {
    OBJECTIVE("Objective Questions", "वस्तुनिष्ठ प्रश्न (MCQs)"),
    VERY_SHORT("Very Short Answer", "अति लघु उत्तरीय (2 अंक)"),
    SHORT("Short Answer", "लघु उत्तरीय (3 अंक)"),
    LONG("Long Answer", "दीर्घ उत्तरीय (4–5 अंक)")
}

data class PyqQuestionItem(
    val id: String,
    val sectionType: PyqSectionType,
    val chapterTag: String,
    val marks: Int,
    val questionEn: String,
    val questionHi: String,
    val options: List<String> = emptyList(),
    val correctOptionIndex: Int = -1,
    val answerKeyEn: String,
    val modelSolutionEn: String,
    val explanationHi: String
)

data class PreviousYearPaper(
    val id: String,
    val classLevel: Int,
    val year: Int,
    val title: String,
    val titleHi: String,
    val setCode: String,
    val isVerifiedPyq: Boolean,
    val sourceLabel: String,
    val summaryHi: String,
    val chapterTopicsTag: List<String>,
    val questions: List<PyqQuestionItem>,
    val pdfUrl: String = "",
    val pdfBase64: String = "",
    val pdfFileName: String = "",
    val isAdminAdded: Boolean = false
)

data class MarkingSchemeOption(
    val maxMarks: Int,
    val label: String,
    val labelHi: String,
    val wordLimitHint: String
) {
    companion object {
        val PRESETS = listOf(
            MarkingSchemeOption(2, "2 Marks (Very Short)", "2 अंक (अति लघु)", "25–35 words"),
            MarkingSchemeOption(3, "3 Marks (Short Answer)", "3 अंक (लघु उत्तर)", "40–60 words"),
            MarkingSchemeOption(4, "4 Marks (Writing / Notice / Letter)", "4 अंक (पत्र / सूचना / निबंध)", "60–100 words"),
            MarkingSchemeOption(5, "5 Marks (Long / Essay)", "5 अंक (दीर्घ उत्तर / निबंध)", "120–150 words")
        )
    }
}

data class AiAnswerEvaluation(
    val marksObtained: Double,
    val maxMarks: Int,
    val grammarScore: Int,
    val spellingScore: Int,
    val vocabularyScore: Int,
    val sentenceFormationScore: Int,
    val contentRelevanceScore: Int,
    val answerStructureScore: Int,
    val correctedAnswer: String,
    val grammaticalMistakes: List<String>,
    val suggestions: List<String>,
    val modelAnswer: String,
    val explanationHi: String
)
