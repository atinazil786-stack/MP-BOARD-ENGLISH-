package com.example.data.repository

import android.util.Log
import com.example.data.model.AiAnswerEvaluation
import com.google.firebase.Firebase
import com.google.firebase.ai.ai
import com.google.firebase.ai.type.Schema
import com.google.firebase.ai.type.content
import com.google.firebase.ai.type.generationConfig
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withTimeout
import org.json.JSONObject

enum class AiTutorMode(val labelEn: String, val labelHi: String, val promptPrefix: String) {
    GRAMMAR_HINDI(
        "Grammar in Hindi",
        "हिंदी में ग्रामर",
        "Explain this English grammar concept clearly in Hindi with easy MP Board Class 9-12 examples and rules:"
    ),
    TEXTBOOK_QA(
        "Textbook Q&A",
        "पाठ्यपुस्तक प्रश्नोत्तर",
        "Answer this NCERT / MP Board Class 9-12 English textbook question accurately in simple exam-ready English followed by a brief Hindi summary:"
    ),
    WORD_MEANING(
        "Word Meaning",
        "कठिन शब्दार्थ",
        "Explain the meaning, pronunciation, Hindi translation, synonyms, antonyms, and an example sentence for this English word or phrase:"
    ),
    CORRECT_MISTAKE(
        "Fix My English",
        "वाक्य सुधारें",
        "Check this English sentence for grammatical mistakes, provide the corrected sentence, and explain the rule in simple Hindi and English:"
    ),
    GENERATE_PRACTICE(
        "AI Practice Qs",
        "AI अभ्यास प्रश्न",
        "Generate 3 original AI practice questions (clearly marked as 'AI-Generated Practice Questions — Not Official Board PYQs') with answers and Hindi explanations on this MP Board topic:"
    ),
    SPOKEN_ENGLISH(
        "Spoken English",
        "अंग्रेजी बोलना सीखें",
        "Help the MP Board student practice spoken English on this topic with natural daily dialogues, Hindi meanings, and pronunciation tips:"
    )
}

class AiTeacherRepository {

    private val model by lazy {
        Firebase.ai.generativeModel(
            modelName = "gemini-3.8-flash",
            systemInstruction = content {
                text(
                    """
                    You are "ASK IMRAN SIR AI", the official AI English Tutor for "Imran Gori Sir – MP Board English Hub", serving Madhya Pradesh Board (MPBSE) & NCERT students from Class 9th to Class 12th.
                    Rules:
                    1. Always maintain a warm, encouraging, respectful educator tone suitable for school students.
                    2. Use a bilingual English + Hindi (Devanagari) teaching style whenever helpful so Hindi-medium and English-medium MP Board students both understand effortlessly.
                    3. Follow official NCERT / MP Board textbooks: Class 9 (Beehive, Moments), Class 10 (First Flight, Footprints Without Feet), Class 11 (Hornbill, Snapshots), Class 12 (Flamingo, Vistas).
                    4. NEVER invent fake textbook chapters or claim AI-generated questions are official MP Board Previous Year Questions (PYQs). Whenever generating practice questions, explicitly label them: "[AI-Generated Practice Questions]".
                    5. Keep formatting clean, structured, and exam-focused for board exams.
                    """.trimIndent()
                )
            }
        )
    }

    private val answerEvaluatorSchema = Schema.obj(
        mapOf(
            "marksObtained" to Schema.double("Marks awarded out of maxMarks (e.g. 2.5 out of 3)"),
            "grammarScore" to Schema.integer("Grammar quality score from 0 to 100"),
            "spellingScore" to Schema.integer("Spelling accuracy score from 0 to 100"),
            "vocabularyScore" to Schema.integer("Vocabulary & word choice score from 0 to 100"),
            "sentenceFormationScore" to Schema.integer("Sentence formation & clarity score from 0 to 100"),
            "contentRelevanceScore" to Schema.integer("Relevance to textbook / writing prompt from 0 to 100"),
            "answerStructureScore" to Schema.integer("Answer structure, intro/body/ending & format score from 0 to 100"),
            "correctedAnswer" to Schema.string("Polished, grammatically correct version of the student's answer"),
            "grammaticalMistakes" to Schema.array(
                Schema.string("Specific grammatical or spelling mistake found and how to fix it")
            ),
            "suggestions" to Schema.array(
                Schema.string("Actionable board exam improvement tip")
            ),
            "modelAnswer" to Schema.string("Ideal exam-ready MP Board model answer for full marks"),
            "explanationHi" to Schema.string("Encouraging, simple Hindi (Devanagari) explanation of mistakes, vocabulary, and how to score full marks")
        )
    )

    private val evaluationModel by lazy {
        Firebase.ai.generativeModel(
            modelName = "gemini-3.8-flash",
            generationConfig = generationConfig {
                responseMimeType = "application/json"
                responseSchema = answerEvaluatorSchema
            },
            systemInstruction = content {
                text(
                    """
                    You are Imran Gori Sir's AI Answer Evaluation Assistant for Madhya Pradesh Board (MPBSE) Class 9th–12th English.
                    Evaluate student answers fairly, strictly based on Grammar, Spelling, Vocabulary, Sentence Formation, Content Relevance, and Answer Structure under the requested maximum marks.
                    Always note in your feedback that these are practice evaluation marks for learning, not official MP Board marks.
                    Keep 'explanationHi' in very simple, clear Devanagari Hindi suitable for MP Board students.
                    """.trimIndent()
                )
            }
        )
    }

    fun streamTeacherResponse(
        studentPrompt: String,
        selectedClass: Int,
        mode: AiTutorMode? = null,
        conversationContext: String = ""
    ): Flow<String> = flow {
        val fullPrompt = buildString {
            append("Student Class: Class ${selectedClass}th (MP Board / NCERT).\n")
            if (conversationContext.isNotBlank()) {
                append("Recent conversation context:\n$conversationContext\n\n")
            }
            if (mode != null) {
                append("${mode.promptPrefix}\n")
            }
            append("Student query: $studentPrompt")
        }

        val accumulated = StringBuilder()
        try {
            withTimeout(60_000L) {
                model.generateContentStream(fullPrompt).collect { chunk ->
                    val chunkText = chunk.text.orEmpty()
                    if (chunkText.isNotEmpty()) {
                        accumulated.append(chunkText)
                        emit(accumulated.toString())
                    }
                }
            }
            if (accumulated.isBlank()) {
                throw IllegalStateException("Ask Imran Sir AI returned an empty response. Please try again.")
            }
        } catch (e: TimeoutCancellationException) {
            Log.e(TAG, "AI Teacher streaming timed out", e)
            throw IllegalStateException(
                "Response timed out after 60 seconds. Please try a shorter question or check your connection.",
                e
            )
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e(TAG, "Firebase AI Logic inference failed", e)
            throw e
        }
    }

    suspend fun evaluateStudentAnswer(
        classLevel: Int,
        chapterTitle: String,
        questionPrompt: String,
        studentAnswer: String,
        maxMarks: Int,
        referenceAnswer: String = ""
    ): AiAnswerEvaluation {
        val safeMax = maxMarks.coerceIn(1, 20)
        val prompt = buildString {
            appendLine("Evaluate this MP Board Class ${classLevel}th English student answer.")
            appendLine("Topic / Chapter: $chapterTitle")
            appendLine("Question: $questionPrompt")
            if (referenceAnswer.isNotBlank()) {
                appendLine("Reference key points: ${referenceAnswer.take(700)}")
            }
            appendLine("Maximum Marks (Configurable Practice Scheme): $safeMax")
            appendLine("Student's English Answer:")
            appendLine(studentAnswer.trim())
            appendLine()
            appendLine("Evaluate: Grammar, Spelling, Vocabulary, Sentence Formation, Content Relevance, Answer Structure.")
            appendLine("Round marksObtained to nearest 0.5 between 0 and $safeMax.")
        }

        try {
            val response = withTimeout(60_000L) {
                evaluationModel.generateContent(prompt)
            }
            val rawJson = response.text?.trim().orEmpty()
            if (rawJson.isBlank()) {
                throw IllegalStateException("AI Evaluator returned an empty response. Please try again.")
            }
            val obj = JSONObject(rawJson)
            val mistakesArr = obj.optJSONArray("grammaticalMistakes")
            val mistakes = buildList {
                if (mistakesArr != null) {
                    for (i in 0 until mistakesArr.length()) {
                        val item = mistakesArr.optString(i).trim()
                        if (item.isNotEmpty()) add(item)
                    }
                }
            }
            val suggestionsArr = obj.optJSONArray("suggestions")
            val suggestions = buildList {
                if (suggestionsArr != null) {
                    for (i in 0 until suggestionsArr.length()) {
                        val item = suggestionsArr.optString(i).trim()
                        if (item.isNotEmpty()) add(item)
                    }
                }
            }
            val marks = obj.optDouble("marksObtained", 0.0).coerceIn(0.0, safeMax.toDouble())
            return AiAnswerEvaluation(
                marksObtained = marks,
                maxMarks = safeMax,
                grammarScore = obj.optInt("grammarScore", 0).coerceIn(0, 100),
                spellingScore = obj.optInt("spellingScore", 0).coerceIn(0, 100),
                vocabularyScore = obj.optInt("vocabularyScore", 0).coerceIn(0, 100),
                sentenceFormationScore = obj.optInt("sentenceFormationScore", 0).coerceIn(0, 100),
                contentRelevanceScore = obj.optInt("contentRelevanceScore", 0).coerceIn(0, 100),
                answerStructureScore = obj.optInt("answerStructureScore", 0).coerceIn(0, 100),
                correctedAnswer = obj.optString("correctedAnswer", "").ifBlank { studentAnswer },
                grammaticalMistakes = mistakes,
                suggestions = suggestions,
                modelAnswer = obj.optString("modelAnswer", ""),
                explanationHi = obj.optString("explanationHi", "")
            )
        } catch (e: TimeoutCancellationException) {
            Log.e(TAG, "AI Answer Evaluation timed out", e)
            throw IllegalStateException("Answer evaluation timed out after 60 seconds. Please retry.", e)
        } catch (e: CancellationException) {
            throw e
        } catch (e: Exception) {
            Log.e(TAG, "AI Answer Evaluation failed", e)
            throw e
        }
    }

    private companion object {
        const val TAG = "AiTeacherRepo"
    }
}
