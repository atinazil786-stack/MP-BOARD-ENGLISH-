package com.example.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.repository.AiTeacherRepository
import com.example.data.repository.AiTutorMode
import com.example.data.repository.StudentRepository
import com.example.ui.screens.AiAnswerPracticeUiState
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

data class AiChatMessage(
    val id: String = UUID.randomUUID().toString(),
    val isStudent: Boolean,
    val text: String,
    val modeLabel: String? = null,
    val isError: Boolean = false
)

data class AiTeacherUiState(
    val messages: List<AiChatMessage> = listOf(
        AiChatMessage(
            id = "welcome_1",
            isStudent = false,
            text = "नमस्ते विद्यार्थी! Welcome to **ASK IMRAN SIR AI**.\n\nAsk me anything in Hindi or English:\n• Explain English Grammar in Hindi\n• NCERT / MP Board Class 9th–12th Textbook Q&A\n• Difficult Word Meanings & Pronunciation\n• Fix Grammar Mistakes in Your Sentences\n• AI Practice Questions & Spoken English"
        )
    ),
    val selectedMode: AiTutorMode? = null,
    val isStreaming: Boolean = false,
    val streamingText: String = "",
    val errorMessage: String? = null
)

class AiTeacherViewModel(
    private val repository: AiTeacherRepository = AiTeacherRepository()
) : ViewModel() {

    private val _uiState = MutableStateFlow(AiTeacherUiState())
    val uiState: StateFlow<AiTeacherUiState> = _uiState.asStateFlow()

    private val _practiceState = MutableStateFlow(AiAnswerPracticeUiState())
    val practiceState: StateFlow<AiAnswerPracticeUiState> = _practiceState.asStateFlow()

    fun selectMode(mode: AiTutorMode?) {
        _uiState.update { it.copy(selectedMode = if (it.selectedMode == mode) null else mode) }
    }

    fun sendQuery(queryText: String, selectedClass: Int) {
        val trimmed = queryText.trim()
        if (trimmed.isBlank() || _uiState.value.isStreaming) return

        val currentMode = _uiState.value.selectedMode
        val studentMsg = AiChatMessage(
            isStudent = true,
            text = trimmed,
            modeLabel = currentMode?.labelEn
        )

        val recentContext = _uiState.value.messages
            .takeLast(4)
            .joinToString("\n") { msg ->
                val role = if (msg.isStudent) "Student" else "Imran Sir AI"
                "$role: ${msg.text.take(300)}"
            }

        _uiState.update {
            it.copy(
                messages = it.messages + studentMsg,
                isStreaming = true,
                streamingText = "",
                errorMessage = null
            )
        }

        viewModelScope.launch {
            try {
                var latestText = ""
                repository.streamTeacherResponse(
                    studentPrompt = trimmed,
                    selectedClass = selectedClass,
                    mode = currentMode,
                    conversationContext = recentContext
                ).collect { chunk ->
                    latestText = chunk
                    _uiState.update { it.copy(streamingText = chunk) }
                }

                val aiMessage = AiChatMessage(
                    isStudent = false,
                    text = latestText,
                    modeLabel = currentMode?.labelEn
                )
                _uiState.update {
                    it.copy(
                        messages = it.messages + aiMessage,
                        isStreaming = false,
                        streamingText = ""
                    )
                }
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                Log.e(TAG, "Ask Imran Sir AI query failed", e)
                val msg = e.localizedMessage ?: "Unable to reach Ask Imran Sir AI right now."
                _uiState.update {
                    it.copy(
                        isStreaming = false,
                        streamingText = "",
                        errorMessage = msg,
                        messages = it.messages + AiChatMessage(
                            isStudent = false,
                            text = "Could not complete response: $msg",
                            isError = true
                        )
                    )
                }
            }
        }
    }

    fun evaluateAnswer(
        userId: String,
        studentRepository: StudentRepository,
        classLevel: Int,
        chapterId: String,
        chapterTitle: String,
        questionPrompt: String,
        studentAnswer: String,
        maxMarks: Int,
        referenceAnswer: String = ""
    ) {
        val cleanAnswer = studentAnswer.trim()
        val cleanQuestion = questionPrompt.trim()
        if (cleanAnswer.length < 5 || cleanQuestion.isBlank() || _practiceState.value.isEvaluating) return

        _practiceState.value = AiAnswerPracticeUiState(isEvaluating = true)

        viewModelScope.launch {
            try {
                val evaluation = repository.evaluateStudentAnswer(
                    classLevel = classLevel,
                    chapterTitle = chapterTitle,
                    questionPrompt = cleanQuestion,
                    studentAnswer = cleanAnswer,
                    maxMarks = maxMarks,
                    referenceAnswer = referenceAnswer
                )
                val saveRes = studentRepository.saveWritingPracticeAttempt(
                    userId = userId,
                    classLevel = classLevel,
                    chapterId = chapterId,
                    chapterTitle = chapterTitle,
                    questionPrompt = cleanQuestion,
                    studentAnswer = cleanAnswer,
                    evaluation = evaluation
                )
                _practiceState.value = AiAnswerPracticeUiState(
                    isEvaluating = false,
                    evaluation = evaluation,
                    errorMessage = null,
                    savedToHistory = saveRes.isSuccess
                )
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                Log.e(TAG, "AI Answer Practice evaluation failed", e)
                _practiceState.value = AiAnswerPracticeUiState(
                    isEvaluating = false,
                    evaluation = null,
                    errorMessage = e.localizedMessage ?: "Unable to evaluate answer right now. Please try again."
                )
            }
        }
    }

    fun clearPracticeEvaluation() {
        _practiceState.value = AiAnswerPracticeUiState()
    }

    fun clearChat() {
        _uiState.value = AiTeacherUiState()
    }

    private companion object {
        const val TAG = "AiTeacherVM"
    }
}
