package com.example.ui.screens

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.PhotoCamera
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Verified
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.model.AdminPdfNoteDoc
import com.example.data.model.AdminPreviousPaperDoc
import com.example.data.model.AdminTestPaperDoc
import com.example.data.model.AdminVideoLinkDoc
import com.example.data.model.AdminWritingMaterialDoc
import com.example.data.model.Chapter
import com.example.data.model.ChapterQuestion
import com.example.data.model.ExamMode
import com.example.data.model.GrammarTopic
import com.example.data.model.QuestionType
import com.example.data.model.StudentTestSummaryDoc
import com.example.ui.components.EmptyStateCard
import com.example.ui.components.StatusBannerCard
import com.example.ui.components.TeacherCircularAvatar
import com.example.ui.components.encodePickedTeacherPhoto
import com.example.ui.theme.SaffronGoldLight
import com.example.ui.viewmodel.AdminUiState
import com.example.ui.viewmodel.AdminViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdminScreen(
    isAdmin: Boolean,
    teacherPhotoBase64: String = "",
    initialTab: Int = 0,
    adminUiState: AdminUiState,
    adminViewModel: AdminViewModel,
    chapters: List<Chapter>,
    adminQuestions: List<ChapterQuestion>,
    grammarTopics: List<GrammarTopic>,
    customTestPapers: List<AdminTestPaperDoc>,
    pdfNotes: List<AdminPdfNoteDoc> = emptyList(),
    adminPreviousPapers: List<AdminPreviousPaperDoc> = emptyList(),
    videoLinks: List<AdminVideoLinkDoc> = emptyList(),
    adminWritingMaterials: List<AdminWritingMaterialDoc> = emptyList(),
    studentTestResults: List<StudentTestSummaryDoc> = emptyList(),
    onBack: () -> Unit
) {
    val context = LocalContext.current
    var selectedTab by remember(initialTab) { mutableIntStateOf(initialTab.coerceIn(0, 9)) }
    val tabs = listOf(
        "Admin Profile",
        "Chapters",
        "Q&A / MCQs",
        "PDF Notes",
        "PYQ Papers",
        "Videos",
        "Writing",
        "Grammar",
        "Tests",
        "Student Results"
    )

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri ->
        if (uri != null) {
            val (encoded, err) = encodePickedTeacherPhoto(context, uri)
            if (err != null) {
                Toast.makeText(context, err, Toast.LENGTH_LONG).show()
            } else {
                adminViewModel.updateTeacherPhoto(encoded)
                Toast.makeText(context, "Teacher photo updated!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        TeacherCircularAvatar(
                            customPhotoBase64 = teacherPhotoBase64,
                            size = 38.dp,
                            borderColor = SaffronGoldLight,
                            borderWidth = 1.5.dp,
                            contentDescription = "Admin Imran Gori Sir portrait"
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text("Admin Content Studio", style = MaterialTheme.typography.titleMedium)
                            Text("IMRAN GORI SIR • MP BOARD ENGLISH HUB", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
                        }
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("admin_back_button")) {
                        Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back from Admin")
                    }
                }
            )
        }
    ) { innerPadding ->
        if (!isAdmin) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(24.dp),
                contentAlignment = Alignment.Center
            ) {
                EmptyStateCard(
                    icon = Icons.Rounded.Lock,
                    title = "Authorized Admin Access Only",
                    subtitle = "Only Imran Gori Sir's verified educator account can add, edit, or delete live syllabus materials."
                )
            }
            return@Scaffold
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            ScrollableTabRow(selectedTabIndex = selectedTab, edgePadding = 12.dp) {
                tabs.forEachIndexed { idx, label ->
                    Tab(
                        selected = selectedTab == idx,
                        onClick = {
                            adminViewModel.clearFeedback()
                            selectedTab = idx
                        },
                        text = { Text(label, maxLines = 1) },
                        modifier = Modifier.testTag("admin_tab_$idx")
                    )
                }
            }

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
                LazyColumn(
                    modifier = Modifier
                        .widthIn(max = 760.dp)
                        .fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    if (!adminUiState.feedbackMessage.isNullOrBlank()) {
                        item {
                            StatusBannerCard(
                                text = adminUiState.feedbackMessage,
                                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                                contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                            )
                        }
                    }
                    if (!adminUiState.errorMessage.isNullOrBlank()) {
                        item {
                            StatusBannerCard(
                                text = adminUiState.errorMessage,
                                containerColor = MaterialTheme.colorScheme.errorContainer,
                                contentColor = MaterialTheme.colorScheme.onErrorContainer
                            )
                        }
                    }

                    when (selectedTab) {
                        0 -> item {
                            AdminProfilePhotoTab(
                                isBusy = adminUiState.isBusy,
                                teacherPhotoBase64 = teacherPhotoBase64,
                                onPickPhoto = {
                                    photoPickerLauncher.launch(
                                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                    )
                                },
                                onResetDefault = {
                                    adminViewModel.resetTeacherPhotoToDefault()
                                }
                            )
                        }
                        1 -> item {
                            AdminChapterTab(
                                isBusy = adminUiState.isBusy,
                                adminChapters = chapters.filter { it.isAdminAdded },
                                onSave = { id, cls, book, num, title, author, sumEn, sumHi, expHi, meanings ->
                                    adminViewModel.saveChapter(id, cls, book, num, title, author, sumEn, sumHi, expHi, meanings)
                                },
                                onDelete = { adminViewModel.deleteChapter(it) }
                            )
                        }
                        2 -> item {
                            AdminQuestionTab(
                                isBusy = adminUiState.isBusy,
                                chapters = chapters,
                                adminQuestions = adminQuestions,
                                onSave = { id, chId, cls, type, pEn, pHi, aEn, aHi, opts, corrIdx, expHi ->
                                    adminViewModel.saveQuestion(id, chId, cls, type, pEn, pHi, aEn, aHi, opts, corrIdx, expHi)
                                },
                                onDelete = { adminViewModel.deleteQuestion(it) }
                            )
                        }
                        3 -> item {
                            AdminPdfNotesTab(
                                isBusy = adminUiState.isBusy,
                                pdfNotes = pdfNotes,
                                chapters = chapters,
                                onSave = { id, cls, chId, title, sumHi, file, url, b64 ->
                                    adminViewModel.savePdfNote(id, cls, chId, title, sumHi, file, url, b64)
                                },
                                onDelete = { adminViewModel.deletePdfNote(it) }
                            )
                        }
                        4 -> item {
                            AdminPyqPapersTab(
                                isBusy = adminUiState.isBusy,
                                papers = adminPreviousPapers,
                                onSave = { id, cls, yr, title, setCode, verified, sumHi, file, url, b64, qs ->
                                    adminViewModel.savePreviousPaper(id, cls, yr, title, setCode, verified, sumHi, file, url, b64, qs)
                                },
                                onDelete = { adminViewModel.deletePreviousPaper(it) }
                            )
                        }
                        5 -> item {
                            AdminVideoLinksTab(
                                isBusy = adminUiState.isBusy,
                                videoLinks = videoLinks,
                                chapters = chapters,
                                onSave = { id, cls, chId, title, sumHi, url ->
                                    adminViewModel.saveVideoLink(id, cls, chId, title, sumHi, url)
                                },
                                onDelete = { adminViewModel.deleteVideoLink(it) }
                            )
                        }
                        6 -> item {
                            AdminWritingTab(
                                isBusy = adminUiState.isBusy,
                                materials = adminWritingMaterials,
                                onSave = { id, cat, title, titleHi, classes, expHi, tmpl, solEn, solHi, eq, modelAns ->
                                    adminViewModel.saveWritingMaterial(id, cat, title, titleHi, classes, expHi, tmpl, solEn, solHi, eq, modelAns)
                                },
                                onDelete = { adminViewModel.deleteWritingMaterial(it) }
                            )
                        }
                        7 -> item {
                            AdminGrammarTab(
                                isBusy = adminUiState.isBusy,
                                adminGrammar = grammarTopics.filter { it.isAdminAdded },
                                onSave = { id, title, titleHi, cat, expHi, rulesEn, examples ->
                                    adminViewModel.saveGrammarLesson(id, title, titleHi, cat, expHi, rulesEn, examples)
                                },
                                onDelete = { adminViewModel.deleteGrammarLesson(it) }
                            )
                        }
                        8 -> item {
                            AdminTestPaperTab(
                                isBusy = adminUiState.isBusy,
                                papers = customTestPapers,
                                onSave = { id, title, cls, mode, mins, qCount ->
                                    adminViewModel.saveTestPaper(id, title, cls, mode, mins, qCount)
                                },
                                onDelete = { adminViewModel.deleteTestPaper(it) }
                            )
                        }
                        9 -> item {
                            AdminStudentResultsTab(results = studentTestResults)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun AdminProfilePhotoTab(
    isBusy: Boolean,
    teacherPhotoBase64: String,
    onPickPhoto: () -> Unit,
    onResetDefault: () -> Unit
) {
    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("admin_profile_card"),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.4f))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TeacherCircularAvatar(
                    customPhotoBase64 = teacherPhotoBase64,
                    size = 116.dp,
                    borderColor = SaffronGoldLight,
                    borderWidth = 3.dp,
                    showVerifiedBadge = true,
                    contentDescription = "Admin Profile Circular Portrait of Imran Gori Sir",
                    modifier = Modifier.testTag("admin_profile_avatar")
                )
                Text(
                    text = "IMRAN GORI SIR",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "MP BOARD ENGLISH HUB",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Surface(
                    color = MaterialTheme.colorScheme.surface,
                    shape = RoundedCornerShape(999.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 5.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Verified,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(16.dp)
                        )
                        Text(
                            text = if (teacherPhotoBase64.isBlank()) {
                                "Using Official Uploaded Portrait"
                            } else {
                                "Using Custom Admin Updated Photo"
                            },
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                }
            }
        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
        ) {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Manage Official Teacher Profile Photo",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = "Any photo selected here automatically updates the circular teacher portrait on Home Screen, Teacher Profile, About Teacher, and Admin Profile.",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Button(
                    onClick = onPickPhoto,
                    enabled = !isBusy,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .testTag("admin_change_photo_button")
                ) {
                    if (isBusy) {
                        CircularProgressIndicator(modifier = Modifier.size(18.dp), strokeWidth = 2.dp)
                    } else {
                        Icon(Icons.Rounded.PhotoCamera, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Change Teacher Photo (Gallery)")
                    }
                }
                if (teacherPhotoBase64.isNotBlank()) {
                    OutlinedButton(
                        onClick = onResetDefault,
                        enabled = !isBusy,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .testTag("admin_reset_photo_button")
                    ) {
                        Icon(Icons.Rounded.Refresh, contentDescription = null)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Restore Original Uploaded Photo")
                    }
                }
            }
        }
    }
}

@Composable
private fun AdminChapterTab(
    isBusy: Boolean,
    adminChapters: List<Chapter>,
    onSave: (String?, Int, String, Int, String, String, String, String, String, String) -> Unit,
    onDelete: (String) -> Unit
) {
    var editingId by remember { mutableStateOf<String?>(null) }
    var classLevel by remember { mutableIntStateOf(10) }
    var bookName by remember { mutableStateOf("First Flight") }
    var chapterNum by remember { mutableStateOf("10") }
    var title by remember { mutableStateOf("") }
    var author by remember { mutableStateOf("Imran Gori Sir") }
    var summaryEn by remember { mutableStateOf("") }
    var summaryHi by remember { mutableStateOf("") }
    var hindiExplanation by remember { mutableStateOf("") }
    var wordMeanings by remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(if (editingId == null) "Add New Chapter" else "Edit Chapter", style = MaterialTheme.typography.titleMedium)
                Row(modifier = Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf(9, 10, 11, 12).forEach { cls ->
                        FilterChip(selected = classLevel == cls, onClick = { classLevel = cls }, label = { Text("Class $cls") })
                    }
                }
                OutlinedTextField(value = bookName, onValueChange = { bookName = it }, label = { Text("Book Name (e.g., First Flight)") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = chapterNum, onValueChange = { chapterNum = it }, label = { Text("Chapter Number") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Chapter Title") }, modifier = Modifier.fillMaxWidth().testTag("admin_chapter_title"))
                OutlinedTextField(value = author, onValueChange = { author = it }, label = { Text("Author") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = summaryEn, onValueChange = { summaryEn = it }, label = { Text("English Summary") }, minLines = 2, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = summaryHi, onValueChange = { summaryHi = it }, label = { Text("Hindi Summary (हिंदी सारांश)") }, minLines = 2, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = hindiExplanation, onValueChange = { hindiExplanation = it }, label = { Text("Detailed Hindi Explanation") }, minLines = 3, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = wordMeanings, onValueChange = { wordMeanings = it }, label = { Text("Word Meanings (1 per line: word::meaningEn::meaningHi::example)") }, minLines = 2, modifier = Modifier.fillMaxWidth())
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(
                        enabled = !isBusy && title.isNotBlank(),
                        onClick = {
                            onSave(editingId, classLevel, bookName, chapterNum.toIntOrNull() ?: 1, title, author, summaryEn, summaryHi, hindiExplanation, wordMeanings)
                            editingId = null; title = ""; summaryEn = ""; summaryHi = ""; hindiExplanation = ""; wordMeanings = ""
                        },
                        modifier = Modifier.weight(1f).height(48.dp)
                    ) {
                        if (isBusy) CircularProgressIndicator(modifier = Modifier.size(18.dp), strokeWidth = 2.dp)
                        else Text(if (editingId == null) "Publish Chapter" else "Update Chapter")
                    }
                    if (editingId != null) {
                        OutlinedButton(onClick = { editingId = null; title = "" }, modifier = Modifier.height(48.dp)) { Text("Cancel") }
                    }
                }
            }
        }

        if (adminChapters.isNotEmpty()) {
            Text("Published Custom Chapters (${adminChapters.size})", style = MaterialTheme.typography.titleSmall)
            adminChapters.forEach { ch ->
                AdminItemRow(
                    title = "Class ${ch.classLevel} • ${ch.title}",
                    subtitle = "${ch.bookName} (Ch. ${ch.chapterNumber})",
                    onEdit = {
                        editingId = ch.id; classLevel = ch.classLevel; bookName = ch.bookName
                        chapterNum = ch.chapterNumber.toString(); title = ch.title; author = ch.author
                        summaryEn = ch.summaryEn; summaryHi = ch.summaryHi; hindiExplanation = ch.hindiExplanation
                        wordMeanings = ch.wordMeanings.joinToString("\n") { "${it.word}::${it.meaningEn}::${it.meaningHi}::${it.exampleSentence}" }
                    },
                    onDelete = { onDelete(ch.id) }
                )
            }
        }
    }
}

@Composable
private fun AdminQuestionTab(
    isBusy: Boolean,
    chapters: List<Chapter>,
    adminQuestions: List<ChapterQuestion>,
    onSave: (String?, String, Int, QuestionType, String, String, String, String, List<String>, Int, String) -> Unit,
    onDelete: (String) -> Unit
) {
    var editingId by remember { mutableStateOf<String?>(null) }
    var classLevel by remember { mutableIntStateOf(10) }
    var chapterId by remember { mutableStateOf(chapters.firstOrNull()?.id ?: "c10_ff_1") }
    var qType by remember { mutableStateOf(QuestionType.MCQ) }
    var promptEn by remember { mutableStateOf("") }
    var promptHi by remember { mutableStateOf("") }
    var answerEn by remember { mutableStateOf("") }
    var opt1 by remember { mutableStateOf("") }
    var opt2 by remember { mutableStateOf("") }
    var opt3 by remember { mutableStateOf("") }
    var opt4 by remember { mutableStateOf("") }
    var correctIdx by remember { mutableIntStateOf(0) }
    var explanationHi by remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(if (editingId == null) "Add Question / 4-Option MCQ" else "Edit Question", style = MaterialTheme.typography.titleMedium)
                Row(modifier = Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf(9, 10, 11, 12).forEach { cls ->
                        FilterChip(selected = classLevel == cls, onClick = { classLevel = cls }, label = { Text("Class $cls") })
                    }
                }
                Row(modifier = Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf(QuestionType.MCQ, QuestionType.VERY_SHORT, QuestionType.SHORT, QuestionType.LONG, QuestionType.BOARD_PYQ).forEach { t ->
                        FilterChip(selected = qType == t, onClick = { qType = t }, label = { Text(t.labelEn) })
                    }
                }
                OutlinedTextField(value = chapterId, onValueChange = { chapterId = it }, label = { Text("Target Chapter ID (e.g., c10_ff_1)") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = promptEn, onValueChange = { promptEn = it }, label = { Text("Question Prompt (English)") }, minLines = 2, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = promptHi, onValueChange = { promptHi = it }, label = { Text("Question Prompt (Hindi - optional)") }, modifier = Modifier.fillMaxWidth())
                if (qType == QuestionType.MCQ) {
                    OutlinedTextField(value = opt1, onValueChange = { opt1 = it }, label = { Text("Option A") }, modifier = Modifier.fillMaxWidth())
                    OutlinedTextField(value = opt2, onValueChange = { opt2 = it }, label = { Text("Option B") }, modifier = Modifier.fillMaxWidth())
                    OutlinedTextField(value = opt3, onValueChange = { opt3 = it }, label = { Text("Option C") }, modifier = Modifier.fillMaxWidth())
                    OutlinedTextField(value = opt4, onValueChange = { opt4 = it }, label = { Text("Option D") }, modifier = Modifier.fillMaxWidth())
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        listOf("A", "B", "C", "D").forEachIndexed { idx, l ->
                            FilterChip(selected = correctIdx == idx, onClick = { correctIdx = idx }, label = { Text("Ans: $l") })
                        }
                    }
                } else {
                    OutlinedTextField(value = answerEn, onValueChange = { answerEn = it }, label = { Text("Model Answer (English)") }, minLines = 2, modifier = Modifier.fillMaxWidth())
                }
                OutlinedTextField(value = explanationHi, onValueChange = { explanationHi = it }, label = { Text("Hindi Explanation (व्याख्या)") }, minLines = 2, modifier = Modifier.fillMaxWidth())
                Button(
                    enabled = !isBusy && promptEn.isNotBlank(),
                    onClick = {
                        val opts = if (qType == QuestionType.MCQ) listOf(opt1, opt2, opt3, opt4) else emptyList()
                        val finalAns = if (qType == QuestionType.MCQ) opts.getOrElse(correctIdx) { opt1 } else answerEn
                        onSave(editingId, chapterId, classLevel, qType, promptEn, promptHi, finalAns, "", opts, correctIdx, explanationHi)
                        editingId = null; promptEn = ""; promptHi = ""; answerEn = ""; opt1 = ""; opt2 = ""; opt3 = ""; opt4 = ""; explanationHi = ""
                    },
                    modifier = Modifier.fillMaxWidth().height(48.dp)
                ) {
                    Text(if (editingId == null) "Publish Question / MCQ" else "Update Question")
                }
            }
        }

        if (adminQuestions.isNotEmpty()) {
            Text("Published Custom Questions (${adminQuestions.size})", style = MaterialTheme.typography.titleSmall)
            adminQuestions.forEach { q ->
                AdminItemRow(
                    title = q.promptEn,
                    subtitle = "Class ${q.classLevel} • ${q.type.labelEn} • ${q.chapterId}",
                    onEdit = {
                        editingId = q.id; chapterId = q.chapterId; classLevel = q.classLevel; qType = q.type
                        promptEn = q.promptEn; promptHi = q.promptHi; answerEn = q.answerEn
                        opt1 = q.options.getOrElse(0) { "" }; opt2 = q.options.getOrElse(1) { "" }
                        opt3 = q.options.getOrElse(2) { "" }; opt4 = q.options.getOrElse(3) { "" }
                        correctIdx = q.correctOptionIndex.coerceAtLeast(0); explanationHi = q.explanationHi
                    },
                    onDelete = { onDelete(q.id) }
                )
            }
        }
    }
}

@Composable
private fun AdminGrammarTab(
    isBusy: Boolean,
    adminGrammar: List<GrammarTopic>,
    onSave: (String?, String, String, String, String, String, String) -> Unit,
    onDelete: (String) -> Unit
) {
    var editingId by remember { mutableStateOf<String?>(null) }
    var title by remember { mutableStateOf("") }
    var titleHi by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("MP Board Grammar") }
    var explanationHi by remember { mutableStateOf("") }
    var rulesEn by remember { mutableStateOf("") }
    var examples by remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(if (editingId == null) "Add Grammar Lesson" else "Edit Grammar Lesson", style = MaterialTheme.typography.titleMedium)
                OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Topic Title") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = titleHi, onValueChange = { titleHi = it }, label = { Text("Hindi Title") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = category, onValueChange = { category = it }, label = { Text("Category") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = explanationHi, onValueChange = { explanationHi = it }, label = { Text("Hindi Explanation") }, minLines = 3, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = rulesEn, onValueChange = { rulesEn = it }, label = { Text("English Rules Summary") }, minLines = 2, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = examples, onValueChange = { examples = it }, label = { Text("Examples (1 per line: English::Hindi::Note)") }, minLines = 2, modifier = Modifier.fillMaxWidth())
                Button(
                    enabled = !isBusy && title.isNotBlank(),
                    onClick = {
                        onSave(editingId, title, titleHi, category, explanationHi, rulesEn, examples)
                        editingId = null; title = ""; titleHi = ""; explanationHi = ""; rulesEn = ""; examples = ""
                    },
                    modifier = Modifier.fillMaxWidth().height(48.dp)
                ) {
                    Text(if (editingId == null) "Publish Grammar Lesson" else "Update Grammar Lesson")
                }
            }
        }

        adminGrammar.forEach { g ->
            AdminItemRow(
                title = g.title,
                subtitle = "${g.titleHi} • ${g.category}",
                onEdit = {
                    editingId = g.id; title = g.title; titleHi = g.titleHi; category = g.category
                    explanationHi = g.explanationHi; rulesEn = g.rulesSummaryEn
                    examples = g.examples.joinToString("\n") { "${it.english}::${it.hindi}::${it.note}" }
                },
                onDelete = { onDelete(g.id) }
            )
        }
    }
}

@Composable
private fun AdminTestPaperTab(
    isBusy: Boolean,
    papers: List<AdminTestPaperDoc>,
    onSave: (String?, String, Int, String, Int, Int) -> Unit,
    onDelete: (String) -> Unit
) {
    var editingId by remember { mutableStateOf<String?>(null) }
    var title by remember { mutableStateOf("") }
    var classLevel by remember { mutableIntStateOf(10) }
    var mode by remember { mutableStateOf(ExamMode.TEST_20.code) }
    var duration by remember { mutableStateOf("15") }
    var questionCount by remember { mutableStateOf("20") }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(if (editingId == null) "Create Custom Test Paper" else "Edit Test Paper", style = MaterialTheme.typography.titleMedium)
                OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Test Paper Title") }, modifier = Modifier.fillMaxWidth())
                Row(modifier = Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf(9, 10, 11, 12).forEach { cls ->
                        FilterChip(selected = classLevel == cls, onClick = { classLevel = cls }, label = { Text("Class $cls") })
                    }
                }
                Row(modifier = Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf(ExamMode.TEST_20, ExamMode.TEST_50, ExamMode.TEST_100, ExamMode.FULL_SYLLABUS).forEach { m ->
                        FilterChip(
                            selected = mode == m.code,
                            onClick = {
                                mode = m.code
                                questionCount = m.questionCount.toString()
                                duration = m.durationMinutes.toString()
                            },
                            label = { Text(m.code) }
                        )
                    }
                }
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(value = questionCount, onValueChange = { questionCount = it }, label = { Text("Questions") }, modifier = Modifier.weight(1f))
                    OutlinedTextField(value = duration, onValueChange = { duration = it }, label = { Text("Minutes") }, modifier = Modifier.weight(1f))
                }
                Button(
                    enabled = !isBusy && title.isNotBlank(),
                    onClick = {
                        onSave(editingId, title, classLevel, mode, duration.toIntOrNull() ?: 15, questionCount.toIntOrNull() ?: 20)
                        editingId = null; title = ""
                    },
                    modifier = Modifier.fillMaxWidth().height(48.dp)
                ) {
                    Text(if (editingId == null) "Publish Test Paper" else "Update Test Paper")
                }
            }
        }

        papers.forEach { p ->
            AdminItemRow(
                title = p.title,
                subtitle = "Class ${p.classLevel} • ${p.questionCount} Qs • ${p.durationMinutes} min",
                onEdit = {
                    editingId = p.id; title = p.title; classLevel = p.classLevel.toInt()
                    mode = p.testMode; duration = p.durationMinutes.toString(); questionCount = p.questionCount.toString()
                },
                onDelete = { onDelete(p.id) }
            )
        }
    }
}

@Composable
internal fun AdminItemRow(
    title: String,
    subtitle: String,
    onEdit: () -> Unit,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(title, style = MaterialTheme.typography.titleSmall)
                Text(subtitle, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            IconButton(onClick = onEdit) {
                Icon(Icons.Rounded.Edit, contentDescription = "Edit item")
            }
            IconButton(onClick = onDelete) {
                Icon(Icons.Rounded.Delete, contentDescription = "Delete item", tint = MaterialTheme.colorScheme.error)
            }
        }
    }
}
