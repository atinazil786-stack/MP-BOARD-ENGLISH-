package com.example.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.local.LocalPreferences
import com.example.data.model.QuestionType
import com.example.data.repository.CurriculumRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class AdminUiState(
    val isBusy: Boolean = false,
    val feedbackMessage: String? = null,
    val errorMessage: String? = null
)

class AdminViewModel(
    private val currentUserId: String,
    private val curriculumRepository: CurriculumRepository,
    private val localPrefs: LocalPreferences? = null
) : ViewModel() {

    private val _uiState = MutableStateFlow(AdminUiState())
    val uiState: StateFlow<AdminUiState> = _uiState.asStateFlow()

    fun clearFeedback() {
        _uiState.update { it.copy(feedbackMessage = null, errorMessage = null) }
    }

    fun saveChapter(
        existingId: String? = null,
        classLevel: Int,
        bookName: String,
        chapterNumber: Int,
        title: String,
        author: String,
        summaryEn: String,
        summaryHi: String,
        hindiExplanation: String,
        rawWordMeanings: String
    ) {
        viewModelScope.launch {
            _uiState.update { it.copy(isBusy = true, feedbackMessage = null, errorMessage = null) }
            val formattedMeanings = rawWordMeanings
                .lines()
                .map { it.trim() }
                .filter { it.isNotBlank() }
            val result = curriculumRepository.saveAdminChapter(
                authorId = currentUserId,
                existingId = existingId,
                classLevel = classLevel,
                bookName = bookName,
                chapterNumber = chapterNumber,
                title = title,
                author = author,
                summaryEn = summaryEn,
                summaryHi = summaryHi,
                hindiExplanation = hindiExplanation,
                wordMeaningsFormatted = formattedMeanings
            )
            result.onSuccess {
                _uiState.update { it.copy(isBusy = false, feedbackMessage = "Chapter saved & published!") }
            }.onFailure { err ->
                _uiState.update { it.copy(isBusy = false, errorMessage = err.localizedMessage ?: "Failed to save chapter") }
            }
        }
    }

    fun deleteChapter(chapterId: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isBusy = true, feedbackMessage = null, errorMessage = null) }
            curriculumRepository.deleteAdminChapter(chapterId)
                .onSuccess { _uiState.update { it.copy(isBusy = false, feedbackMessage = "Chapter deleted.") } }
                .onFailure { err -> _uiState.update { it.copy(isBusy = false, errorMessage = err.localizedMessage) } }
        }
    }

    fun saveQuestion(
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
    ) {
        viewModelScope.launch {
            _uiState.update { it.copy(isBusy = true, feedbackMessage = null, errorMessage = null) }
            curriculumRepository.saveAdminQuestion(
                authorId = currentUserId,
                existingId = existingId,
                chapterId = chapterId,
                classLevel = classLevel,
                questionType = questionType,
                promptEn = promptEn,
                promptHi = promptHi,
                answerEn = answerEn,
                answerHi = answerHi,
                options = options,
                correctOptionIndex = correctOptionIndex,
                explanationHi = explanationHi
            ).onSuccess {
                _uiState.update { it.copy(isBusy = false, feedbackMessage = "Question / MCQ saved!") }
            }.onFailure { err ->
                _uiState.update { it.copy(isBusy = false, errorMessage = err.localizedMessage ?: "Failed to save question") }
            }
        }
    }

    fun deleteQuestion(questionId: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isBusy = true) }
            curriculumRepository.deleteAdminQuestion(questionId)
                .onSuccess { _uiState.update { it.copy(isBusy = false, feedbackMessage = "Question deleted.") } }
                .onFailure { err -> _uiState.update { it.copy(isBusy = false, errorMessage = err.localizedMessage) } }
        }
    }

    fun saveGrammarLesson(
        existingId: String? = null,
        title: String,
        titleHi: String,
        category: String,
        explanationHi: String,
        rulesSummaryEn: String,
        rawExamples: String
    ) {
        viewModelScope.launch {
            _uiState.update { it.copy(isBusy = true, feedbackMessage = null, errorMessage = null) }
            val examples = rawExamples.lines().map { it.trim() }.filter { it.isNotBlank() }
            curriculumRepository.saveAdminGrammar(
                authorId = currentUserId,
                existingId = existingId,
                title = title,
                titleHi = titleHi,
                category = category,
                explanationHi = explanationHi,
                rulesSummaryEn = rulesSummaryEn,
                examplesFormatted = examples
            ).onSuccess {
                _uiState.update { it.copy(isBusy = false, feedbackMessage = "Grammar lesson saved!") }
            }.onFailure { err ->
                _uiState.update { it.copy(isBusy = false, errorMessage = err.localizedMessage ?: "Failed to save grammar lesson") }
            }
        }
    }

    fun deleteGrammarLesson(topicId: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isBusy = true) }
            curriculumRepository.deleteAdminGrammar(topicId)
                .onSuccess { _uiState.update { it.copy(isBusy = false, feedbackMessage = "Grammar lesson deleted.") } }
                .onFailure { err -> _uiState.update { it.copy(isBusy = false, errorMessage = err.localizedMessage) } }
        }
    }

    fun saveTestPaper(
        existingId: String? = null,
        title: String,
        classLevel: Int,
        testMode: String,
        durationMinutes: Int,
        questionCount: Int
    ) {
        viewModelScope.launch {
            _uiState.update { it.copy(isBusy = true, feedbackMessage = null, errorMessage = null) }
            curriculumRepository.saveAdminTestPaper(
                authorId = currentUserId,
                existingId = existingId,
                title = title,
                classLevel = classLevel,
                testMode = testMode,
                durationMinutes = durationMinutes,
                questionCount = questionCount
            ).onSuccess {
                _uiState.update { it.copy(isBusy = false, feedbackMessage = "Test paper published!") }
            }.onFailure { err ->
                _uiState.update { it.copy(isBusy = false, errorMessage = err.localizedMessage ?: "Failed to save test paper") }
            }
        }
    }

    fun deleteTestPaper(testId: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isBusy = true) }
            curriculumRepository.deleteAdminTestPaper(testId)
                .onSuccess { _uiState.update { it.copy(isBusy = false, feedbackMessage = "Test paper deleted.") } }
                .onFailure { err -> _uiState.update { it.copy(isBusy = false, errorMessage = err.localizedMessage) } }
        }
    }

    fun savePdfNote(
        existingId: String? = null,
        classLevel: Int,
        chapterId: String,
        title: String,
        summaryHi: String,
        pdfFileName: String,
        pdfUrl: String,
        pdfBase64: String
    ) {
        viewModelScope.launch {
            _uiState.update { it.copy(isBusy = true, feedbackMessage = null, errorMessage = null) }
            curriculumRepository.saveAdminPdfNote(
                authorId = currentUserId,
                existingId = existingId,
                classLevel = classLevel,
                chapterId = chapterId,
                title = title,
                summaryHi = summaryHi,
                pdfFileName = pdfFileName,
                pdfUrl = pdfUrl,
                pdfBase64 = pdfBase64
            ).onSuccess {
                _uiState.update { it.copy(isBusy = false, feedbackMessage = "PDF notes published for students!") }
            }.onFailure { err ->
                _uiState.update { it.copy(isBusy = false, errorMessage = err.localizedMessage ?: "Failed to save PDF notes") }
            }
        }
    }

    fun deletePdfNote(noteId: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isBusy = true) }
            curriculumRepository.deleteAdminPdfNote(noteId)
                .onSuccess { _uiState.update { it.copy(isBusy = false, feedbackMessage = "PDF note deleted.") } }
                .onFailure { err -> _uiState.update { it.copy(isBusy = false, errorMessage = err.localizedMessage) } }
        }
    }

    fun savePreviousPaper(
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
        rawQuestions: String
    ) {
        viewModelScope.launch {
            _uiState.update { it.copy(isBusy = true, feedbackMessage = null, errorMessage = null) }
            val formattedList = rawQuestions.lines().map { it.trim() }.filter { it.isNotBlank() }
            curriculumRepository.saveAdminPreviousPaper(
                authorId = currentUserId,
                existingId = existingId,
                classLevel = classLevel,
                year = year,
                title = title,
                setCode = setCode,
                isVerifiedPyq = isVerifiedPyq,
                summaryHi = summaryHi,
                pdfFileName = pdfFileName,
                pdfUrl = pdfUrl,
                pdfBase64 = pdfBase64,
                questionsFormatted = formattedList
            ).onSuccess {
                _uiState.update { it.copy(isBusy = false, feedbackMessage = "Question paper published!") }
            }.onFailure { err ->
                _uiState.update { it.copy(isBusy = false, errorMessage = err.localizedMessage ?: "Failed to save paper") }
            }
        }
    }

    fun deletePreviousPaper(paperId: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isBusy = true) }
            curriculumRepository.deleteAdminPreviousPaper(paperId)
                .onSuccess { _uiState.update { it.copy(isBusy = false, feedbackMessage = "Paper deleted.") } }
                .onFailure { err -> _uiState.update { it.copy(isBusy = false, errorMessage = err.localizedMessage) } }
        }
    }

    fun saveVideoLink(
        existingId: String? = null,
        classLevel: Int,
        chapterId: String,
        title: String,
        summaryHi: String,
        videoUrl: String
    ) {
        viewModelScope.launch {
            _uiState.update { it.copy(isBusy = true, feedbackMessage = null, errorMessage = null) }
            curriculumRepository.saveAdminVideoLink(
                authorId = currentUserId,
                existingId = existingId,
                classLevel = classLevel,
                chapterId = chapterId,
                title = title,
                summaryHi = summaryHi,
                videoUrl = videoUrl
            ).onSuccess {
                _uiState.update { it.copy(isBusy = false, feedbackMessage = "Animated video link published!") }
            }.onFailure { err ->
                _uiState.update { it.copy(isBusy = false, errorMessage = err.localizedMessage ?: "Failed to save video link") }
            }
        }
    }

    fun deleteVideoLink(videoId: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isBusy = true) }
            curriculumRepository.deleteAdminVideoLink(videoId)
                .onSuccess { _uiState.update { it.copy(isBusy = false, feedbackMessage = "Video link deleted.") } }
                .onFailure { err -> _uiState.update { it.copy(isBusy = false, errorMessage = err.localizedMessage) } }
        }
    }

    fun saveWritingMaterial(
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
    ) {
        viewModelScope.launch {
            _uiState.update { it.copy(isBusy = true, feedbackMessage = null, errorMessage = null) }
            curriculumRepository.saveAdminWritingMaterial(
                authorId = currentUserId,
                existingId = existingId,
                topicCategory = topicCategory,
                title = title,
                titleHi = titleHi,
                applicableClasses = applicableClasses,
                explanationHi = explanationHi,
                formatTemplate = formatTemplate,
                solvedExampleEn = solvedExampleEn,
                solvedExampleHi = solvedExampleHi,
                examQuestion = examQuestion,
                modelAnswer = modelAnswer
            ).onSuccess {
                _uiState.update { it.copy(isBusy = false, feedbackMessage = "Writing skills material published!") }
            }.onFailure { err ->
                _uiState.update { it.copy(isBusy = false, errorMessage = err.localizedMessage ?: "Failed to save writing material") }
            }
        }
    }

    fun deleteWritingMaterial(materialId: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isBusy = true) }
            curriculumRepository.deleteAdminWritingMaterial(materialId)
                .onSuccess { _uiState.update { it.copy(isBusy = false, feedbackMessage = "Writing material deleted.") } }
                .onFailure { err -> _uiState.update { it.copy(isBusy = false, errorMessage = err.localizedMessage) } }
        }
    }

    fun updateTeacherPhoto(photoBase64: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isBusy = true, feedbackMessage = null, errorMessage = null) }
            localPrefs?.setTeacherPhotoBase64(photoBase64)
            curriculumRepository.saveTeacherPhotoConfig(currentUserId, photoBase64)
                .onSuccess {
                    _uiState.update {
                        it.copy(
                            isBusy = false,
                            feedbackMessage = "Official Imran Gori Sir profile photo updated across Home, Teacher Profile, About Teacher & Admin Profile!"
                        )
                    }
                }
                .onFailure { err ->
                    _uiState.update {
                        it.copy(
                            isBusy = false,
                            feedbackMessage = if (localPrefs != null) "Photo updated locally on this device." else null,
                            errorMessage = err.localizedMessage ?: "Cloud sync warning while updating photo"
                        )
                    }
                }
        }
    }

    fun resetTeacherPhotoToDefault() {
        viewModelScope.launch {
            _uiState.update { it.copy(isBusy = true, feedbackMessage = null, errorMessage = null) }
            localPrefs?.setTeacherPhotoBase64("")
            curriculumRepository.saveTeacherPhotoConfig(currentUserId, "")
                .onSuccess {
                    _uiState.update {
                        it.copy(
                            isBusy = false,
                            feedbackMessage = "Restored original Imran Gori Sir profile photograph."
                        )
                    }
                }
                .onFailure { err ->
                    _uiState.update {
                        it.copy(
                            isBusy = false,
                            feedbackMessage = if (localPrefs != null) "Restored original photo locally." else null,
                            errorMessage = err.localizedMessage
                        )
                    }
                }
        }
    }
}
