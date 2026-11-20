package com.example.ui.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
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
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.MenuBook
import androidx.compose.material.icons.rounded.Assessment
import androidx.compose.material.icons.rounded.Bolt
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Description
import androidx.compose.material.icons.rounded.Flag
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.RateReview
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Timer
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.data.model.AdminTestPaperDoc
import com.example.data.model.Chapter
import com.example.data.model.ExamMode
import com.example.ui.components.SectionHeading
import com.example.ui.components.SourceTagPill
import com.example.ui.theme.JetBrainsMonoFamily
import com.example.ui.viewmodel.ExamResultSummary
import com.example.ui.viewmodel.ExamUiState
import java.util.Locale

@Composable
fun TestsScreen(
    selectedClass: Int,
    bilingualMode: Boolean,
    chapters: List<Chapter>,
    customTestPapers: List<AdminTestPaperDoc>,
    onStartStandardExam: (ExamMode, Int, Chapter?) -> Unit,
    onStartCustomTest: (AdminTestPaperDoc) -> Unit,
    onOpenPyqPapers: () -> Unit = {},
    onOpenAiAnswerPractice: () -> Unit = {}
) {
    var examClass by remember(selectedClass) { mutableIntStateOf(selectedClass) }
    var showChapterPicker by remember { mutableStateOf(false) }

    val classChapters = remember(chapters, examClass) {
        chapters.filter { it.classLevel == examClass }
    }

    if (showChapterPicker) {
        AlertDialog(
            onDismissRequest = { showChapterPicker = false },
            title = { Text("Select Class ${examClass}th Chapter") },
            text = {
                LazyColumn(
                    modifier = Modifier.height(320.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(classChapters, key = { it.id }) { ch ->
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    showChapterPicker = false
                                    onStartStandardExam(ExamMode.CHAPTER_WISE, examClass, ch)
                                },
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(Icons.AutoMirrored.Rounded.MenuBook, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                Spacer(modifier = Modifier.width(10.dp))
                                Column {
                                    Text(ch.title, style = MaterialTheme.typography.titleSmall)
                                    Text(ch.bookName, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showChapterPicker = false }) { Text("Close") }
            }
        )
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        LazyColumn(
            modifier = Modifier
                .widthIn(max = 760.dp)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Box(modifier = Modifier.height(132.dp).fillMaxWidth()) {
                        Image(
                            painter = painterResource(id = R.drawable.img_exam_banner),
                            contentDescription = "Online Exam System Banner",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        Box(modifier = Modifier.fillMaxSize().background(Color(0x9911264A)))
                        Column(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(16.dp)
                        ) {
                            Text("ONLINE EXAM SYSTEM", style = MaterialTheme.typography.labelLarge, color = Color(0xFFFBBF24))
                            Text("MP Board Timed Practice Tests", style = MaterialTheme.typography.titleLarge, color = Color.White)
                            Text("Countdown Timer • Auto Scoring • Detailed Scorecard", style = MaterialTheme.typography.bodySmall, color = Color.White.copy(alpha = 0.88f))
                        }
                    }
                }
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf(9, 10, 11, 12).forEach { lvl ->
                        FilterChip(
                            selected = examClass == lvl,
                            onClick = { examClass = lvl },
                            label = { Text("Class ${lvl}th") }
                        )
                    }
                }
            }

            item {
                SectionHeading(
                    titleEn = "Choose Exam Format",
                    titleHi = "परीक्षा प्रारूप चुनें",
                    bilingualMode = bilingualMode
                )
            }

            items(ExamMode.entries) { mode ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("exam_mode_${mode.code}")
                        .clickable {
                            if (mode == ExamMode.CHAPTER_WISE) {
                                showChapterPicker = true
                            } else {
                                onStartStandardExam(mode, examClass, null)
                            }
                        },
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Bolt,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.padding(12.dp)
                            )
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(mode.titleEn, style = MaterialTheme.typography.titleMedium)
                            if (bilingualMode) {
                                Text(mode.titleHi, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.primary)
                            }
                            Text(
                                text = "${mode.questionCount} Questions • ${mode.durationMinutes} Minutes",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Icon(Icons.Rounded.PlayArrow, contentDescription = "Start ${mode.titleEn}", tint = MaterialTheme.colorScheme.primary)
                    }
                }
            }

            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    OutlinedButton(
                        onClick = onOpenPyqPapers,
                        modifier = Modifier.weight(1f).height(50.dp).testTag("tests_open_pyq_btn")
                    ) {
                        Icon(Icons.Rounded.Description, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("PYQ Papers", maxLines = 1)
                    }
                    FilledTonalButton(
                        onClick = onOpenAiAnswerPractice,
                        modifier = Modifier.weight(1f).height(50.dp).testTag("tests_open_ai_practice_btn")
                    ) {
                        Icon(Icons.Rounded.RateReview, contentDescription = null, modifier = Modifier.size(18.dp))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("AI Answer Practice", maxLines = 1)
                    }
                }
            }

            if (customTestPapers.isNotEmpty()) {
                item {
                    SectionHeading(
                        titleEn = "Papers by Imran Gori Sir",
                        titleHi = "इमरान गोरी सर द्वारा प्रकाशित टेस्ट",
                        bilingualMode = bilingualMode
                    )
                }
                items(customTestPapers, key = { it.id }) { paper ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onStartCustomTest(paper) },
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary.copy(alpha = 0.4f))
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(paper.title, style = MaterialTheme.typography.titleMedium)
                                Text(
                                    "Class ${paper.classLevel}th • ${paper.questionCount} Qs • ${paper.durationMinutes} Min",
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                            Button(onClick = { onStartCustomTest(paper) }) { Text("Start") }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ExamRunnerScreen(
    uiState: ExamUiState,
    bilingualMode: Boolean,
    onSelectAnswer: (Int, Int) -> Unit,
    onJumpToQuestion: (Int) -> Unit,
    onToggleFlag: (Int) -> Unit,
    onSubmitExam: () -> Unit,
    onExitExam: () -> Unit
) {
    val paper = uiState.activePaper ?: return
    val currentIdx = uiState.currentQuestionIndex
    val currentQ = paper.questions.getOrNull(currentIdx) ?: return
    var showConfirmExit by remember { mutableStateOf(false) }
    var showPalette by remember { mutableStateOf(false) }

    BackHandler { showConfirmExit = true }

    if (showConfirmExit) {
        AlertDialog(
            onDismissRequest = { showConfirmExit = false },
            title = { Text("Leave Exam?") },
            text = { Text("Your current exam timer is running. Submit now to see your scorecard, or exit without saving?") },
            confirmButton = {
                Button(onClick = {
                    showConfirmExit = false
                    onSubmitExam()
                }) { Text("Submit & Grade") }
            },
            dismissButton = {
                TextButton(onClick = {
                    showConfirmExit = false
                    onExitExam()
                }) { Text("Exit") }
            }
        )
    }

    if (showPalette) {
        AlertDialog(
            onDismissRequest = { showPalette = false },
            title = { Text("Question Palette (${uiState.selectedAnswers.size}/${paper.questions.size} answered)") },
            text = {
                Box(modifier = Modifier.height(260.dp)) {
                    LazyColumn {
                        item {
                            FlowRow(
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                paper.questions.indices.forEach { idx ->
                                    val isAnswered = idx in uiState.selectedAnswers
                                    val isFlagged = idx in uiState.flaggedQuestions
                                    Surface(
                                        modifier = Modifier
                                            .size(44.dp)
                                            .clickable {
                                                onJumpToQuestion(idx)
                                                showPalette = false
                                            },
                                        shape = RoundedCornerShape(10.dp),
                                        color = when {
                                            idx == currentIdx -> MaterialTheme.colorScheme.primary
                                            isFlagged -> MaterialTheme.colorScheme.secondaryContainer
                                            isAnswered -> MaterialTheme.colorScheme.tertiaryContainer
                                            else -> MaterialTheme.colorScheme.surfaceVariant
                                        }
                                    ) {
                                        Box(contentAlignment = Alignment.Center) {
                                            Text(
                                                text = "${idx + 1}",
                                                color = if (idx == currentIdx) Color.White else MaterialTheme.colorScheme.onSurface,
                                                fontWeight = FontWeight.Bold
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {
                TextButton(onClick = { showPalette = false }) { Text("Close") }
            }
        )
    }

    val mins = uiState.remainingSeconds / 60
    val secs = uiState.remainingSeconds % 60
    val formattedTime = String.format(Locale.US, "%02d:%02d", mins, secs)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(paper.title, style = MaterialTheme.typography.titleSmall, maxLines = 1)
                        Text(
                            "Q ${currentIdx + 1} of ${paper.questions.size}",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { showConfirmExit = true }) {
                        Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Exit exam")
                    }
                },
                actions = {
                    Surface(
                        color = if (uiState.remainingSeconds < 60) MaterialTheme.colorScheme.errorContainer
                        else MaterialTheme.colorScheme.primaryContainer,
                        shape = RoundedCornerShape(999.dp),
                        modifier = Modifier.padding(end = 8.dp)
                    ) {
                        Row(
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(Icons.Rounded.Timer, contentDescription = null, modifier = Modifier.size(16.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = formattedTime,
                                fontFamily = JetBrainsMonoFamily,
                                fontWeight = FontWeight.Bold,
                                style = MaterialTheme.typography.labelLarge
                            )
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            LinearProgressIndicator(
                progress = { (currentIdx + 1).toFloat() / paper.questions.size.coerceAtLeast(1) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(7.dp)
                    .clip(RoundedCornerShape(999.dp))
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SourceTagPill(sourceTag = currentQ.sourceTag, bilingualMode = bilingualMode)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedButton(onClick = { showPalette = true }) {
                        Text("Grid (${uiState.selectedAnswers.size}/${paper.questions.size})")
                    }
                    IconButton(onClick = { onToggleFlag(currentIdx) }) {
                        Icon(
                            imageVector = Icons.Rounded.Flag,
                            contentDescription = "Flag question",
                            tint = if (currentIdx in uiState.flaggedQuestions) MaterialTheme.colorScheme.secondary
                            else MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            LazyColumn(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                    ) {
                        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Text(
                                text = currentQ.promptEn,
                                style = MaterialTheme.typography.titleMedium
                            )
                            if (bilingualMode && currentQ.promptHi.isNotBlank()) {
                                Text(
                                    text = currentQ.promptHi,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }

                val letters = listOf("A", "B", "C", "D")
                itemsIndexed(currentQ.options) { optIdx, option ->
                    val isSelected = uiState.selectedAnswers[currentIdx] == optIdx
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onSelectAnswer(currentIdx, optIdx) }
                            .testTag("exam_option_$optIdx"),
                        shape = RoundedCornerShape(14.dp),
                        color = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface,
                        border = BorderStroke(
                            width = if (isSelected) 2.dp else 1.dp,
                            color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant
                        )
                    ) {
                        Row(
                            modifier = Modifier.padding(16.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Surface(
                                shape = CircleShape,
                                color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
                                modifier = Modifier.size(30.dp)
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text(
                                        text = letters.getOrElse(optIdx) { "${optIdx + 1}" },
                                        color = if (isSelected) Color.White else MaterialTheme.colorScheme.onSurface,
                                        fontWeight = FontWeight.Bold
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(option, style = MaterialTheme.typography.bodyLarge)
                        }
                    }
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OutlinedButton(
                    onClick = { onJumpToQuestion(currentIdx - 1) },
                    enabled = currentIdx > 0,
                    modifier = Modifier.weight(1f).height(50.dp)
                ) {
                    Text("Previous")
                }
                if (currentIdx < paper.questions.lastIndex) {
                    Button(
                        onClick = { onJumpToQuestion(currentIdx + 1) },
                        modifier = Modifier.weight(1f).height(50.dp)
                    ) {
                        Text("Next")
                    }
                } else {
                    Button(
                        onClick = onSubmitExam,
                        modifier = Modifier.weight(1f).height(50.dp).testTag("submit_exam_button"),
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)
                    ) {
                        Text("Submit Exam")
                    }
                }
            }
            if (currentIdx < paper.questions.lastIndex) {
                OutlinedButton(
                    onClick = onSubmitExam,
                    modifier = Modifier.fillMaxWidth().height(46.dp).testTag("submit_exam_early_button")
                ) {
                    Text("Finish & Submit Early")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScorecardScreen(
    summary: ExamResultSummary,
    bilingualMode: Boolean,
    onRetake: () -> Unit,
    onClose: () -> Unit
) {
    BackHandler { onClose() }

    val analysisText = when {
        summary.percentage >= 85 -> "Outstanding Board Performance! उत्कृष्ट प्रदर्शन — आप बोर्ड परीक्षा में 90+ अंक लाने की राह पर हैं!"
        summary.percentage >= 65 -> "Good Attempt! अच्छा प्रयास — गलत हुए प्रश्नों की हिंदी व्याख्या दोहराएं और फिर टेस्ट दें।"
        else -> "Keep Practicing! अभ्यास जारी रखें — अध्याय सारांश व व्याकरण नियम पढ़कर दोबारा टेस्ट दें।"
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Exam Scorecard • परीक्षा परिणाम") },
                navigationIcon = {
                    IconButton(onClick = onClose) {
                        Icon(Icons.Rounded.Close, contentDescription = "Close scorecard")
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.TopCenter
        ) {
            LazyColumn(
                modifier = Modifier
                    .widthIn(max = 760.dp)
                    .fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(24.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Icon(Icons.Rounded.Assessment, contentDescription = null, tint = Color(0xFFFBBF24), modifier = Modifier.size(40.dp))
                            Text(summary.paper.title, style = MaterialTheme.typography.titleMedium, color = Color.White)
                            Text(
                                text = "${summary.percentage}%",
                                style = MaterialTheme.typography.displayMedium,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Time Used: ${summary.timeTakenSeconds / 60}m ${summary.timeTakenSeconds % 60}s",
                                style = MaterialTheme.typography.labelLarge,
                                color = Color.White.copy(alpha = 0.85f),
                                fontFamily = JetBrainsMonoFamily
                            )
                        }
                    }
                }

                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        ScoreMetricBox("Correct", "${summary.correctCount}", MaterialTheme.colorScheme.tertiaryContainer, Modifier.weight(1f))
                        ScoreMetricBox("Wrong", "${summary.wrongCount}", MaterialTheme.colorScheme.errorContainer, Modifier.weight(1f))
                        ScoreMetricBox("Skipped", "${summary.skippedCount}", MaterialTheme.colorScheme.surfaceVariant, Modifier.weight(1f))
                    }
                }

                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
                    ) {
                        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text("Performance Analysis • प्रदर्शन विश्लेषण", style = MaterialTheme.typography.titleSmall)
                            Text(analysisText, style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }

                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Button(
                            onClick = onRetake,
                            modifier = Modifier.weight(1f).height(50.dp).testTag("retake_test_button")
                        ) {
                            Icon(Icons.Rounded.Refresh, contentDescription = null)
                            Spacer(modifier = Modifier.width(6.dp))
                            Text("Retake Test")
                        }
                        OutlinedButton(
                            onClick = onClose,
                            modifier = Modifier.weight(1f).height(50.dp)
                        ) {
                            Text("Back to Tests")
                        }
                    }
                }

                item {
                    SectionHeading(
                        titleEn = "Detailed Answer Key",
                        titleHi = "सही उत्तर व हिंदी व्याख्या",
                        bilingualMode = bilingualMode
                    )
                }

                itemsIndexed(summary.paper.questions) { idx, q ->
                    val chosen = summary.selectedAnswers[idx]
                    val isCorrect = chosen == q.correctOptionIndex
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        border = BorderStroke(
                            1.dp,
                            if (isCorrect) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.outlineVariant
                        )
                    ) {
                        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Icon(
                                    imageVector = if (isCorrect) Icons.Rounded.CheckCircle else Icons.Rounded.Close,
                                    contentDescription = null,
                                    tint = if (isCorrect) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.error,
                                    modifier = Modifier.size(18.dp)
                                )
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Q${idx + 1}. ${q.promptEn}", style = MaterialTheme.typography.titleSmall)
                            }
                            Text(
                                text = "Your Answer: ${chosen?.let { q.options.getOrNull(it) } ?: "Skipped"}",
                                style = MaterialTheme.typography.bodySmall,
                                color = if (isCorrect) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.error
                            )
                            Text(
                                text = "Correct Answer: ${q.options.getOrNull(q.correctOptionIndex) ?: q.answerEn}",
                                style = MaterialTheme.typography.bodySmall,
                                fontWeight = FontWeight.SemiBold
                            )
                            if (q.explanationHi.isNotBlank()) {
                                Text(
                                    text = "व्याख्या: ${q.explanationHi}",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun ScoreMetricBox(
    label: String,
    value: String,
    containerColor: Color,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = containerColor,
        shape = RoundedCornerShape(14.dp)
    ) {
        Column(
            modifier = Modifier.padding(vertical = 14.dp, horizontal = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(value, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
            Text(label, style = MaterialTheme.typography.labelMedium)
        }
    }
}
