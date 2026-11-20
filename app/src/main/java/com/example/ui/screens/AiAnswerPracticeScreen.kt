package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.ErrorOutline
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.School
import androidx.compose.material.icons.rounded.TipsAndUpdates
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.model.AiAnswerEvaluation
import com.example.data.model.Chapter
import com.example.data.model.MarkingSchemeOption
import com.example.data.model.QuestionType
import com.example.data.model.WritingPracticeAttemptDoc
import com.example.ui.components.EmptyStateCard
import com.example.ui.components.SectionHeading
import com.example.ui.components.StatusBannerCard
import com.example.ui.theme.SaffronGoldLight
import java.util.Locale

data class AiAnswerPracticeUiState(
    val isEvaluating: Boolean = false,
    val evaluation: AiAnswerEvaluation? = null,
    val errorMessage: String? = null,
    val savedToHistory: Boolean = false
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AiAnswerPracticeScreen(
    selectedClass: Int,
    bilingualMode: Boolean,
    chapters: List<Chapter>,
    practiceState: AiAnswerPracticeUiState,
    practiceHistory: List<WritingPracticeAttemptDoc>,
    prefilledQuestion: String? = null,
    prefilledAnswer: String? = null,
    prefilledMarks: Int? = null,
    prefilledTitle: String? = null,
    onEvaluateAndSave: (
        classLevel: Int,
        chapterId: String,
        chapterTitle: String,
        questionPrompt: String,
        studentAnswer: String,
        maxMarks: Int,
        referenceAnswer: String
    ) -> Unit,
    onClearResult: () -> Unit,
    onBack: () -> Unit
) {
    var activeTab by remember { mutableIntStateOf(0) } // 0 = Practice, 1 = History
    var chosenClass by remember(selectedClass) { mutableIntStateOf(selectedClass) }

    val classChapters = remember(chapters, chosenClass) {
        chapters.filter { it.classLevel == chosenClass }
    }
    var selectedChapterId by remember(chosenClass, classChapters) {
        mutableStateOf(classChapters.firstOrNull()?.id ?: "")
    }
    val activeChapter = remember(classChapters, selectedChapterId) {
        classChapters.firstOrNull { it.id == selectedChapterId } ?: classChapters.firstOrNull()
    }

    val chapterSubjectiveQuestions = remember(activeChapter) {
        activeChapter?.questions?.filter {
            it.type in listOf(QuestionType.VERY_SHORT, QuestionType.SHORT, QuestionType.LONG, QuestionType.BOARD_PYQ)
        }.orEmpty()
    }

    var questionPrompt by remember { mutableStateOf("") }
    var referenceAnswer by remember { mutableStateOf("") }
    var studentAnswer by remember { mutableStateOf("") }
    var maxMarks by remember { mutableIntStateOf(3) }

    LaunchedEffect(prefilledQuestion, prefilledAnswer, prefilledMarks) {
        if (!prefilledQuestion.isNullOrBlank()) {
            questionPrompt = prefilledQuestion
        }
        if (!prefilledAnswer.isNullOrBlank()) {
            studentAnswer = prefilledAnswer
        }
        if (prefilledMarks != null && prefilledMarks in 1..20) {
            maxMarks = prefilledMarks
        }
    }

    LaunchedEffect(activeChapter, chapterSubjectiveQuestions) {
        if (prefilledQuestion.isNullOrBlank() && questionPrompt.isBlank() && chapterSubjectiveQuestions.isNotEmpty()) {
            val firstQ = chapterSubjectiveQuestions.first()
            questionPrompt = firstQ.promptEn
            referenceAnswer = firstQ.answerEn
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("AI Answer Writing Practice", style = MaterialTheme.typography.titleMedium)
                        Text(
                            "Imran Gori Sir • Practice Feedback Engine",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("ai_answer_back_btn")) {
                        Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back from AI Answer Practice")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            TabRow(selectedTabIndex = activeTab) {
                Tab(
                    selected = activeTab == 0,
                    onClick = { activeTab = 0 },
                    text = { Text("Write & Evaluate") },
                    icon = { Icon(Icons.Rounded.AutoAwesome, contentDescription = null, modifier = Modifier.size(18.dp)) }
                )
                Tab(
                    selected = activeTab == 1,
                    onClick = { activeTab = 1 },
                    text = { Text("History (${practiceHistory.size})") },
                    icon = { Icon(Icons.Rounded.History, contentDescription = null, modifier = Modifier.size(18.dp)) }
                )
            }

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
                LazyColumn(
                    modifier = Modifier
                        .widthIn(max = 760.dp)
                        .fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    if (activeTab == 0) {
                        // Honest Disclaimer Banner
                        item {
                            StatusBannerCard(
                                text = "Disclaimer: AI evaluation checks Grammar, Spelling, Vocabulary, Sentence Formation, Content Relevance & Answer Structure for practice. AI marks are NOT official MP Board marks.",
                                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                        }

                        // Step 1: Select Class
                        item {
                            SectionHeading(
                                titleEn = "1. Select Class & Chapter",
                                titleHi = "कक्षा और अध्याय चुनें",
                                bilingualMode = bilingualMode
                            )
                        }
                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(rememberScrollState()),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                listOf(9, 10, 11, 12).forEach { cls ->
                                    FilterChip(
                                        selected = chosenClass == cls,
                                        onClick = {
                                            chosenClass = cls
                                            questionPrompt = ""
                                            referenceAnswer = ""
                                            onClearResult()
                                        },
                                        label = { Text("Class ${cls}th") },
                                        modifier = Modifier.testTag("ai_practice_class_$cls")
                                    )
                                }
                            }
                        }

                        // Chapter Picker Chips
                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(rememberScrollState()),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                classChapters.forEach { ch ->
                                    FilterChip(
                                        selected = activeChapter?.id == ch.id,
                                        onClick = {
                                            selectedChapterId = ch.id
                                            val firstQ = ch.questions.firstOrNull {
                                                it.type in listOf(QuestionType.VERY_SHORT, QuestionType.SHORT, QuestionType.LONG, QuestionType.BOARD_PYQ)
                                            }
                                            if (firstQ != null) {
                                                questionPrompt = firstQ.promptEn
                                                referenceAnswer = firstQ.answerEn
                                            }
                                            onClearResult()
                                        },
                                        label = { Text("Ch ${ch.chapterNumber}: ${ch.title}") }
                                    )
                                }
                            }
                        }

                        // Step 2: Pick a Question from Chapter
                        if (chapterSubjectiveQuestions.isNotEmpty()) {
                            item {
                                SectionHeading(
                                    titleEn = "2. Choose a Question (${chapterSubjectiveQuestions.size} available)",
                                    titleHi = "अभ्यास के लिए प्रश्न चुनें (या नीचे अपना प्रश्न लिखें)",
                                    bilingualMode = bilingualMode
                                )
                            }
                            item {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .horizontalScroll(rememberScrollState()),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    chapterSubjectiveQuestions.take(12).forEachIndexed { idx, q ->
                                        FilterChip(
                                            selected = questionPrompt == q.promptEn,
                                            onClick = {
                                                questionPrompt = q.promptEn
                                                referenceAnswer = q.answerEn
                                                maxMarks = when (q.type) {
                                                    QuestionType.VERY_SHORT -> 2
                                                    QuestionType.LONG -> 5
                                                    else -> 3
                                                }
                                                onClearResult()
                                            },
                                            label = { Text("Q${idx + 1}: ${q.type.labelEn}") }
                                        )
                                    }
                                }
                            }
                        }

                        // Question Field + Configurable Marking Scheme + Answer Input
                        item {
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                            ) {
                                Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                                    OutlinedTextField(
                                        value = questionPrompt,
                                        onValueChange = { questionPrompt = it },
                                        label = { Text("Selected Question / Prompt") },
                                        minLines = 2,
                                        modifier = Modifier.fillMaxWidth().testTag("ai_practice_question_input")
                                    )

                                    Text("Configurable Marking Scheme (अंक योजना चुनें)", style = MaterialTheme.typography.titleSmall)
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .horizontalScroll(rememberScrollState()),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        MarkingSchemeOption.PRESETS.forEach { preset ->
                                            FilterChip(
                                                selected = maxMarks == preset.maxMarks,
                                                onClick = { maxMarks = preset.maxMarks },
                                                label = { Text(preset.label) },
                                                modifier = Modifier.testTag("marking_scheme_${preset.maxMarks}")
                                            )
                                        }
                                    }
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                                    ) {
                                        Text("Custom Max Marks: $maxMarks", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
                                        OutlinedButton(
                                            onClick = { if (maxMarks > 1) maxMarks-- },
                                            modifier = Modifier.height(38.dp)
                                        ) { Text("-") }
                                        OutlinedButton(
                                            onClick = { if (maxMarks < 20) maxMarks++ },
                                            modifier = Modifier.height(38.dp)
                                        ) { Text("+") }
                                    }

                                    OutlinedTextField(
                                        value = studentAnswer,
                                        onValueChange = { studentAnswer = it },
                                        label = { Text("Write your answer in English...") },
                                        minLines = 5,
                                        modifier = Modifier.fillMaxWidth().testTag("ai_practice_answer_input")
                                    )

                                    val wordCount = studentAnswer.trim().split(Regex("\\s+")).count { it.isNotBlank() }
                                    Text(
                                        text = "Words written: $wordCount • Evaluating for $maxMarks Marks",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )

                                    Button(
                                        enabled = !practiceState.isEvaluating && questionPrompt.isNotBlank() && studentAnswer.trim().length >= 5,
                                        onClick = {
                                            val chId = activeChapter?.id ?: "writing_skills"
                                            val chTitle = prefilledTitle?.takeIf { questionPrompt == prefilledQuestion }
                                                ?: activeChapter?.title
                                                ?: "English Practice"
                                            onEvaluateAndSave(
                                                chosenClass,
                                                chId,
                                                chTitle,
                                                questionPrompt,
                                                studentAnswer,
                                                maxMarks,
                                                referenceAnswer
                                            )
                                        },
                                        modifier = Modifier.fillMaxWidth().height(52.dp).testTag("submit_ai_evaluation_btn")
                                    ) {
                                        if (practiceState.isEvaluating) {
                                            CircularProgressIndicator(
                                                modifier = Modifier.size(20.dp),
                                                strokeWidth = 2.dp,
                                                color = Color.White
                                            )
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Text("Evaluating Grammar & Structure...")
                                        } else {
                                            Icon(Icons.Rounded.AutoAwesome, contentDescription = null)
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Text("Submit Answer for AI Feedback")
                                        }
                                    }
                                }
                            }
                        }

                        if (!practiceState.errorMessage.isNullOrBlank()) {
                            item {
                                StatusBannerCard(
                                    text = "Evaluation Error: ${practiceState.errorMessage}",
                                    containerColor = MaterialTheme.colorScheme.errorContainer,
                                    contentColor = MaterialTheme.colorScheme.onErrorContainer
                                )
                            }
                        }

                        // Evaluation Result Card
                        practiceState.evaluation?.let { eval ->
                            item {
                                EvaluationResultCard(
                                    evaluation = eval,
                                    savedToHistory = practiceState.savedToHistory
                                )
                            }
                        }
                    } else {
                        // Practice History Tab
                        if (practiceHistory.isEmpty()) {
                            item {
                                EmptyStateCard(
                                    icon = Icons.Rounded.History,
                                    title = "No Practice History Yet",
                                    subtitle = "Write an answer in the 'Write & Evaluate' tab and submit it to see your past feedback and score progress here."
                                )
                            }
                        } else {
                            item {
                                SectionHeading(
                                    titleEn = "Your Answer Writing Practice History (${practiceHistory.size})",
                                    titleHi = "आपका उत्तर-लेखन अभ्यास इतिहास",
                                    bilingualMode = bilingualMode
                                )
                            }
                            items(practiceHistory, key = { it.id }) { attempt ->
                                PracticeHistoryCard(attempt)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun EvaluationResultCard(
    evaluation: AiAnswerEvaluation,
    savedToHistory: Boolean
) {
    Card(
        modifier = Modifier.fillMaxWidth().testTag("ai_evaluation_result_card"),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
    ) {
        Column(modifier = Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Surface(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text("AI Practice Score", style = MaterialTheme.typography.labelLarge, color = SaffronGoldLight)
                        Text(
                            text = "${String.format(Locale.US, "%.1f", evaluation.marksObtained)} / ${evaluation.maxMarks} Marks",
                            style = MaterialTheme.typography.headlineMedium,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "Practice Feedback Only • Not Official Board Marks",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color.White.copy(alpha = 0.85f)
                        )
                    }
                    if (savedToHistory) {
                        Icon(Icons.Rounded.CheckCircle, contentDescription = "Saved to History", tint = SaffronGoldLight, modifier = Modifier.size(28.dp))
                    }
                }
            }

            // Detailed Evaluation Bars
            ScoreMetricRow("Grammar (व्याकरण)", evaluation.grammarScore)
            ScoreMetricRow("Spelling (वर्तनी)", evaluation.spellingScore)
            ScoreMetricRow("Vocabulary (शब्दावली)", evaluation.vocabularyScore)
            ScoreMetricRow("Sentence Formation (वाक्य रचना)", evaluation.sentenceFormationScore)
            ScoreMetricRow("Content Relevance (विषय-वस्तु)", evaluation.contentRelevanceScore)
            ScoreMetricRow("Answer Structure (उत्तर संरचना)", evaluation.answerStructureScore)

            // Corrected Answer
            Surface(color = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.6f), shape = MaterialTheme.shapes.small) {
                Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text("Corrected Version (सुधारा हुआ उत्तर)", style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.onTertiaryContainer)
                    Text(evaluation.correctedAnswer, style = MaterialTheme.typography.bodyMedium)
                }
            }

            // Grammatical Mistakes
            if (evaluation.grammaticalMistakes.isNotEmpty()) {
                Surface(color = MaterialTheme.colorScheme.errorContainer.copy(alpha = 0.6f), shape = MaterialTheme.shapes.small) {
                    Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Rounded.ErrorOutline, contentDescription = null, tint = MaterialTheme.colorScheme.error, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Grammatical Mistakes Found", style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.onErrorContainer)
                        }
                        evaluation.grammaticalMistakes.forEach { m ->
                            Text("• $m", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }

            // Suggestions
            if (evaluation.suggestions.isNotEmpty()) {
                Surface(color = MaterialTheme.colorScheme.secondaryContainer, shape = MaterialTheme.shapes.small) {
                    Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Rounded.TipsAndUpdates, contentDescription = null, tint = MaterialTheme.colorScheme.secondary, modifier = Modifier.size(18.dp))
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Suggestions for Improvement", style = MaterialTheme.typography.titleSmall)
                        }
                        evaluation.suggestions.forEach { s ->
                            Text("• $s", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }

            // Model Answer
            Surface(color = MaterialTheme.colorScheme.surfaceVariant, shape = MaterialTheme.shapes.small) {
                Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text("Model Answer (आदर्श उत्तर)", style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.primary)
                    Text(evaluation.modelAnswer, style = MaterialTheme.typography.bodyMedium)
                }
            }

            // Hindi Explanation
            Surface(color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.55f), shape = MaterialTheme.shapes.small) {
                Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Rounded.Info, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("सरल हिंदी में व्याख्या (Explanation in Simple Hindi)", style = MaterialTheme.typography.titleSmall)
                    }
                    Text(evaluation.explanationHi, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}

@Composable
private fun ScoreMetricRow(label: String, score: Int) {
    Column(verticalArrangement = Arrangement.spacedBy(3.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(label, style = MaterialTheme.typography.labelMedium)
            Text("$score%", style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
        }
        LinearProgressIndicator(
            progress = { (score / 100f).coerceIn(0f, 1f) },
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
                .clip(RoundedCornerShape(999.dp))
        )
    }
}

@Composable
private fun PracticeHistoryCard(attempt: WritingPracticeAttemptDoc) {
    var expanded by remember(attempt.id) { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { expanded = !expanded },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Class ${attempt.classLevel} • ${attempt.chapterTitle}",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
                Surface(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(999.dp)
                ) {
                    Text(
                        text = "${String.format(Locale.US, "%.1f", attempt.marksObtained)} / ${attempt.maxMarks} Marks (Practice)",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
            }
            Text(attempt.questionPrompt, style = MaterialTheme.typography.titleSmall)
            Text("Your Answer: ${attempt.studentAnswer}", style = MaterialTheme.typography.bodySmall, maxLines = if (expanded) 20 else 2)
            Text(
                text = "Grammar ${attempt.grammarScore}% • Spelling ${attempt.spellingScore}% • Vocab ${attempt.vocabularyScore}% • Structure ${attempt.structureScore}%",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary
            )
            if (expanded) {
                if (attempt.correctedAnswer.isNotBlank()) {
                    Text("Corrected: ${attempt.correctedAnswer}", style = MaterialTheme.typography.bodySmall, fontWeight = FontWeight.Medium)
                }
                if (attempt.modelAnswer.isNotBlank()) {
                    Text("Model Answer: ${attempt.modelAnswer}", style = MaterialTheme.typography.bodySmall)
                }
                if (attempt.explanationHi.isNotBlank()) {
                    Text("हिंदी व्याख्या: ${attempt.explanationHi}", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            } else {
                Text("Tap to view full feedback & model answer", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}
