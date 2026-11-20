package com.example.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.curriculum.QuestionBankAndVocab
import com.example.data.model.ActiveExamPaper
import com.example.data.model.Chapter
import com.example.data.model.ChapterQuestion
import com.example.data.model.ExamMode
import com.example.data.model.GrammarTopic
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class ExamResultSummary(
    val paper: ActiveExamPaper,
    val selectedAnswers: Map<Int, Int>,
    val correctCount: Int,
    val wrongCount: Int,
    val skippedCount: Int,
    val percentage: Int,
    val timeTakenSeconds: Int
)

data class ExamUiState(
    val activePaper: ActiveExamPaper? = null,
    val currentQuestionIndex: Int = 0,
    val selectedAnswers: Map<Int, Int> = emptyMap(),
    val flaggedQuestions: Set<Int> = emptySet(),
    val remainingSeconds: Int = 0,
    val resultSummary: ExamResultSummary? = null
)

class ExamViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ExamUiState())
    val uiState: StateFlow<ExamUiState> = _uiState.asStateFlow()

    private var timerJob: Job? = null
    private var lastBuilderArgs: (() -> ActiveExamPaper)? = null

    fun startExam(
        title: String,
        mode: ExamMode,
        classLevel: Int,
        durationMinutes: Int,
        questionCount: Int,
        chapters: List<Chapter>,
        grammarTopics: List<GrammarTopic>,
        extraQuestions: List<ChapterQuestion>,
        chapterIdFilter: String? = null,
        onAutoSaveResult: (ExamResultSummary) -> Unit
    ) {
        val builder = {
            val questions = QuestionBankAndVocab.buildExamQuestions(
                allChapters = chapters,
                allGrammar = grammarTopics,
                extraQuestions = extraQuestions,
                targetCount = questionCount,
                classFilter = if (mode == ExamMode.FULL_SYLLABUS || mode == ExamMode.CHAPTER_WISE) classLevel else null,
                chapterIdFilter = chapterIdFilter
            )
            ActiveExamPaper(
                title = title,
                mode = mode,
                classLevel = classLevel,
                durationSeconds = durationMinutes * 60,
                questions = questions
            )
        }
        lastBuilderArgs = builder
        launchPaper(builder(), onAutoSaveResult)
    }

    fun startCustomQuestionListExam(
        title: String,
        classLevel: Int,
        durationMinutes: Int,
        customMcqs: List<ChapterQuestion>,
        fallbackChapters: List<Chapter>,
        fallbackGrammar: List<GrammarTopic>,
        onAutoSaveResult: (ExamResultSummary) -> Unit
    ) {
        val builder = {
            val validCustom = customMcqs.filter { it.options.isNotEmpty() && it.correctOptionIndex >= 0 }
            val merged = if (validCustom.size >= 10) {
                validCustom
            } else {
                val extra = QuestionBankAndVocab.buildExamQuestions(
                    allChapters = fallbackChapters,
                    allGrammar = fallbackGrammar,
                    extraQuestions = emptyList(),
                    targetCount = (10 - validCustom.size).coerceAtLeast(1),
                    classFilter = classLevel
                )
                (validCustom + extra).distinctBy { it.id }.take(10)
            }
            ActiveExamPaper(
                title = title,
                mode = ExamMode.CHAPTER_WISE,
                classLevel = classLevel,
                durationSeconds = durationMinutes.coerceIn(5, 180) * 60,
                questions = merged
            )
        }
        lastBuilderArgs = builder
        launchPaper(builder(), onAutoSaveResult)
    }

    fun retakeExam(onAutoSaveResult: (ExamResultSummary) -> Unit) {
        val builder = lastBuilderArgs ?: return
        launchPaper(builder(), onAutoSaveResult)
    }

    private fun launchPaper(
        paper: ActiveExamPaper,
        onAutoSaveResult: (ExamResultSummary) -> Unit
    ) {
        timerJob?.cancel()
        _uiState.value = ExamUiState(
            activePaper = paper,
            currentQuestionIndex = 0,
            selectedAnswers = emptyMap(),
            flaggedQuestions = emptySet(),
            remainingSeconds = paper.durationSeconds,
            resultSummary = null
        )
        timerJob = viewModelScope.launch {
            while (_uiState.value.remainingSeconds > 0 && _uiState.value.resultSummary == null) {
                delay(1000L)
                val next = (_uiState.value.remainingSeconds - 1).coerceAtLeast(0)
                _uiState.update { it.copy(remainingSeconds = next) }
                if (next == 0) {
                    submitExam(onAutoSaveResult)
                }
            }
        }
    }

    fun selectAnswer(questionIndex: Int, optionIndex: Int) {
        if (_uiState.value.resultSummary != null) return
        _uiState.update { state ->
            state.copy(selectedAnswers = state.selectedAnswers + (questionIndex to optionIndex))
        }
    }

    fun jumpToQuestion(index: Int) {
        val total = _uiState.value.activePaper?.questions?.size ?: return
        if (index in 0 until total) {
            _uiState.update { it.copy(currentQuestionIndex = index) }
        }
    }

    fun toggleFlag(index: Int) {
        _uiState.update { state ->
            val updated = if (index in state.flaggedQuestions) state.flaggedQuestions - index
            else state.flaggedQuestions + index
            state.copy(flaggedQuestions = updated)
        }
    }

    fun submitExam(onAutoSaveResult: (ExamResultSummary) -> Unit) {
        val state = _uiState.value
        val paper = state.activePaper ?: return
        if (state.resultSummary != null) return
        timerJob?.cancel()

        var correct = 0
        var wrong = 0
        var skipped = 0

        paper.questions.forEachIndexed { idx, q ->
            val chosen = state.selectedAnswers[idx]
            if (chosen == null) {
                skipped++
            } else if (chosen == q.correctOptionIndex) {
                correct++
            } else {
                wrong++
            }
        }

        val total = paper.questions.size.coerceAtLeast(1)
        val percentage = ((correct * 100) / total).coerceIn(0, 100)
        val timeTaken = (paper.durationSeconds - state.remainingSeconds).coerceAtLeast(1)

        val summary = ExamResultSummary(
            paper = paper,
            selectedAnswers = state.selectedAnswers,
            correctCount = correct,
            wrongCount = wrong,
            skippedCount = skipped,
            percentage = percentage,
            timeTakenSeconds = timeTaken
        )
        _uiState.update { it.copy(resultSummary = summary) }
        onAutoSaveResult(summary)
    }

    fun exitExam() {
        timerJob?.cancel()
        _uiState.value = ExamUiState()
    }

    override fun onCleared() {
        super.onCleared()
        timerJob?.cancel()
    }
}
