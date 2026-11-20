package com.example.ui.screens

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Description
import androidx.compose.material.icons.rounded.Download
import androidx.compose.material.icons.rounded.OpenInNew
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Verified
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material.icons.rounded.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.core.pdf.PdfPaperUtils
import com.example.data.model.PreviousYearPaper
import com.example.data.model.PyqQuestionItem
import com.example.data.model.PyqSectionType
import com.example.ui.components.EmptyStateCard
import com.example.ui.components.SectionHeading
import com.example.ui.components.StatusBannerCard
import com.example.ui.theme.SaffronGoldLight

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun PreviousYearPapersDashboardScreen(
    selectedClass: Int,
    bilingualMode: Boolean,
    papers: List<PreviousYearPaper>,
    onOpenPaper: (PreviousYearPaper) -> Unit,
    onPracticeOnline: (PreviousYearPaper) -> Unit,
    onBack: () -> Unit
) {
    val context = LocalContext.current
    var classFilter by remember(selectedClass) { mutableIntStateOf(selectedClass) }
    var yearFilter by remember { mutableIntStateOf(0) } // 0 = All, or 2022..2026
    var viewMode by remember { mutableIntStateOf(0) } // 0 = Year-wise Library, 1 = Chapter-wise PYQs
    var selectedChapterTag by remember { mutableStateOf("All") }

    val classPapers = remember(papers, classFilter, yearFilter) {
        papers.filter {
            it.classLevel == classFilter && (yearFilter == 0 || it.year == yearFilter)
        }.sortedByDescending { it.year }
    }

    val allClassChapterTags = remember(papers, classFilter) {
        listOf("All") + papers.filter { it.classLevel == classFilter }
            .flatMap { it.chapterTopicsTag }
            .distinct()
            .sorted()
    }

    val chapterWiseItems = remember(papers, classFilter, selectedChapterTag) {
        papers.filter { it.classLevel == classFilter }
            .flatMap { paper ->
                paper.questions.filter { q ->
                    selectedChapterTag == "All" || q.chapterTag == selectedChapterTag
                }.map { q -> paper to q }
            }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Previous Year Question Papers", style = MaterialTheme.typography.titleMedium)
                        Text(
                            "Presented by Imran Gori Sir • MP Board 2022–2026",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("pyq_back_button")) {
                        Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back from Previous Year Papers")
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
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(22.dp),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
                    ) {
                        Column(
                            modifier = Modifier.padding(18.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "MP BOARD PREVIOUS YEAR PAPERS",
                                style = MaterialTheme.typography.labelLarge,
                                color = SaffronGoldLight,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                text = "Presented by Imran Gori Sir",
                                style = MaterialTheme.typography.titleLarge,
                                color = Color.White
                            )
                            Text(
                                text = "Class 9th–12th Library (2022–2026) with Objective, Very Short, Short & Long Questions, Answer Keys, Model Solutions, Downloadable PDFs & Online Practice Mode.",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.White.copy(alpha = 0.9f)
                            )
                        }
                    }
                }

                item {
                    StatusBannerCard(
                        text = "Authenticity Note: 2022–2025 sets follow verified MPBSE patterns & Imran Gori Sir's uploaded original papers. 2026 sets are clearly marked 'Blueprint Model Paper 2026' — never AI-disguised as past PYQs.",
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                    )
                }

                // Class 9th - 12th tabs
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        listOf(9, 10, 11, 12).forEach { cls ->
                            FilterChip(
                                selected = classFilter == cls,
                                onClick = {
                                    classFilter = cls
                                    selectedChapterTag = "All"
                                },
                                label = { Text("Class ${cls}th") },
                                modifier = Modifier.testTag("pyq_class_chip_$cls")
                            )
                        }
                    }
                }

                // View mode switch: Year-wise Library vs Chapter-wise Important Questions
                item {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        FilterChip(
                            selected = viewMode == 0,
                            onClick = { viewMode = 0 },
                            label = { Text("Year-Wise Library (2022–2026)") },
                            modifier = Modifier.testTag("pyq_mode_yearwise")
                        )
                        FilterChip(
                            selected = viewMode == 1,
                            onClick = { viewMode = 1 },
                            label = { Text("Chapter-Wise Questions") },
                            modifier = Modifier.testTag("pyq_mode_chapterwise")
                        )
                    }
                }

                if (viewMode == 0) {
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            listOf(0, 2026, 2025, 2024, 2023, 2022).forEach { yr ->
                                FilterChip(
                                    selected = yearFilter == yr,
                                    onClick = { yearFilter = yr },
                                    label = { Text(if (yr == 0) "All Years" else "$yr") },
                                    modifier = Modifier.testTag("pyq_year_chip_$yr")
                                )
                            }
                        }
                    }

                    if (classPapers.isEmpty()) {
                        item {
                            EmptyStateCard(
                                icon = Icons.Rounded.Description,
                                title = "No papers for this filter",
                                subtitle = "Select another year or upload a paper from Admin Studio."
                            )
                        }
                    } else {
                        items(classPapers, key = { it.id }) { paper ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .testTag("pyq_paper_card_${paper.id}")
                                    .clickable { onOpenPaper(paper) },
                                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                            ) {
                                Column(
                                    modifier = Modifier.padding(16.dp),
                                    verticalArrangement = Arrangement.spacedBy(10.dp)
                                ) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Surface(
                                            color = MaterialTheme.colorScheme.primaryContainer,
                                            shape = RoundedCornerShape(10.dp)
                                        ) {
                                            Text(
                                                text = "${paper.year}",
                                                style = MaterialTheme.typography.titleSmall,
                                                color = MaterialTheme.colorScheme.onPrimaryContainer,
                                                fontWeight = FontWeight.Bold,
                                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                                            )
                                        }
                                        Spacer(modifier = Modifier.width(12.dp))
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(paper.title, style = MaterialTheme.typography.titleMedium)
                                            if (bilingualMode && paper.titleHi.isNotBlank()) {
                                                Text(paper.titleHi, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.primary)
                                            }
                                        }
                                        Icon(Icons.AutoMirrored.Rounded.ArrowForward, contentDescription = "Open ${paper.title}")
                                    }

                                    FlowRow(
                                        horizontalArrangement = Arrangement.spacedBy(6.dp),
                                        verticalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        Surface(
                                            color = if (paper.isVerifiedPyq) MaterialTheme.colorScheme.tertiaryContainer
                                            else MaterialTheme.colorScheme.secondaryContainer,
                                            shape = RoundedCornerShape(999.dp)
                                        ) {
                                            Row(
                                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                                verticalAlignment = Alignment.CenterVertically,
                                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                                            ) {
                                                Icon(Icons.Rounded.Verified, contentDescription = null, modifier = Modifier.size(13.dp))
                                                Text(paper.sourceLabel, style = MaterialTheme.typography.labelSmall)
                                            }
                                        }
                                        Surface(
                                            color = MaterialTheme.colorScheme.surfaceVariant,
                                            shape = RoundedCornerShape(999.dp)
                                        ) {
                                            Text(
                                                text = "${paper.setCode} • ${paper.questions.size} Sections/Qs",
                                                style = MaterialTheme.typography.labelSmall,
                                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                            )
                                        }
                                        if (paper.pdfBase64.isNotBlank() || paper.pdfUrl.isNotBlank()) {
                                            Surface(
                                                color = MaterialTheme.colorScheme.primaryContainer,
                                                shape = RoundedCornerShape(999.dp)
                                            ) {
                                                Text(
                                                    text = "Admin Original PDF",
                                                    style = MaterialTheme.typography.labelSmall,
                                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                                )
                                            }
                                        }
                                    }

                                    Text(
                                        text = paper.summaryHi,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )

                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                                    ) {
                                        FilledTonalButton(
                                            onClick = { onOpenPaper(paper) },
                                            modifier = Modifier.weight(1f).height(46.dp)
                                        ) {
                                            Text("View + Keys", maxLines = 1)
                                        }
                                        OutlinedButton(
                                            onClick = {
                                                val file = PdfPaperUtils.writePaperToFile(context, paper)
                                                val opened = PdfPaperUtils.openPdfWithViewer(context, file)
                                                if (!opened) {
                                                    Toast.makeText(context, "PDF generated at ${file.name}", Toast.LENGTH_SHORT).show()
                                                }
                                            },
                                            modifier = Modifier.weight(1f).height(46.dp)
                                        ) {
                                            Icon(Icons.Rounded.Download, contentDescription = null, modifier = Modifier.size(16.dp))
                                            Spacer(modifier = Modifier.width(4.dp))
                                            Text("PDF", maxLines = 1)
                                        }
                                        Button(
                                            onClick = { onPracticeOnline(paper) },
                                            modifier = Modifier.weight(1f).height(46.dp)
                                        ) {
                                            Icon(Icons.Rounded.PlayArrow, contentDescription = null, modifier = Modifier.size(16.dp))
                                            Spacer(modifier = Modifier.width(2.dp))
                                            Text("Practice", maxLines = 1)
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    item {
                        SectionHeading(
                            titleEn = "Filter by Chapter / Grammar Topic",
                            titleHi = "अध्याय-वार पिछले वर्षों के प्रश्न",
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
                            allClassChapterTags.forEach { tag ->
                                FilterChip(
                                    selected = selectedChapterTag == tag,
                                    onClick = { selectedChapterTag = tag },
                                    label = { Text(tag) }
                                )
                            }
                        }
                    }
                    itemsIndexed(chapterWiseItems, key = { idx, pair -> "${pair.first.id}_${pair.second.id}_$idx" }) { idx, (paper, q) ->
                        PyqQuestionDisplayCard(
                            index = idx + 1,
                            yearBadge = "${paper.year} • ${paper.sourceLabel}",
                            item = q,
                            bilingualMode = bilingualMode,
                            showAnswerByDefault = true
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PreviousYearPaperDetailScreen(
    paper: PreviousYearPaper,
    bilingualMode: Boolean,
    onPracticeOnline: (PreviousYearPaper) -> Unit,
    onBack: () -> Unit
) {
    val context = LocalContext.current
    var sectionFilter by remember(paper.id) { mutableStateOf<PyqSectionType?>(null) }
    var revealAllAnswers by remember(paper.id) { mutableStateOf(false) }

    val savePdfLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.CreateDocument("application/pdf")
    ) { targetUri ->
        if (targetUri != null) {
            val generated = PdfPaperUtils.writePaperToFile(context, paper)
            val saved = PdfPaperUtils.copyPdfFileToUri(context, generated, targetUri)
            Toast.makeText(
                context,
                if (saved) "PDF saved successfully!" else "Could not save PDF file.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    val filteredQuestions = remember(paper.questions, sectionFilter) {
        if (sectionFilter == null) paper.questions
        else paper.questions.filter { it.sectionType == sectionFilter }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(paper.title, style = MaterialTheme.typography.titleMedium, maxLines = 1)
                        Text(
                            "${paper.sourceLabel} • ${paper.setCode}",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("pyq_detail_back_btn")) {
                        Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back to Papers Library")
                    }
                },
                actions = {
                    IconButton(
                        onClick = { revealAllAnswers = !revealAllAnswers },
                        modifier = Modifier.testTag("pyq_toggle_keys_btn")
                    ) {
                        Icon(
                            imageVector = if (revealAllAnswers) Icons.Rounded.VisibilityOff else Icons.Rounded.Visibility,
                            contentDescription = "Toggle Answer Keys"
                        )
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
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Text(paper.summaryHi, style = MaterialTheme.typography.bodyMedium)
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                Button(
                                    onClick = {
                                        val fileName = paper.pdfFileName.ifBlank { "MPBSE_Class${paper.classLevel}_${paper.year}.pdf" }
                                        savePdfLauncher.launch(fileName)
                                    },
                                    modifier = Modifier.weight(1f).height(48.dp).testTag("pyq_download_pdf_btn")
                                ) {
                                    Icon(Icons.Rounded.Download, contentDescription = null, modifier = Modifier.size(18.dp))
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text("Download PDF", maxLines = 1)
                                }
                                FilledTonalButton(
                                    onClick = { onPracticeOnline(paper) },
                                    modifier = Modifier.weight(1f).height(48.dp).testTag("pyq_online_practice_btn")
                                ) {
                                    Icon(Icons.Rounded.PlayArrow, contentDescription = null, modifier = Modifier.size(18.dp))
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text("Online Practice", maxLines = 1)
                                }
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                OutlinedButton(
                                    onClick = {
                                        val file = PdfPaperUtils.writePaperToFile(context, paper)
                                        if (!PdfPaperUtils.openPdfWithViewer(context, file)) {
                                            Toast.makeText(context, "No PDF viewer app installed; use Download PDF.", Toast.LENGTH_SHORT).show()
                                        }
                                    },
                                    modifier = Modifier.weight(1f).height(44.dp)
                                ) {
                                    Text("Open PDF Viewer")
                                }
                                if (paper.pdfUrl.isNotBlank()) {
                                    OutlinedButton(
                                        onClick = { PdfPaperUtils.openExternalUrl(context, paper.pdfUrl) },
                                        modifier = Modifier.weight(1f).height(44.dp)
                                    ) {
                                        Icon(Icons.Rounded.OpenInNew, contentDescription = null, modifier = Modifier.size(16.dp))
                                        Spacer(modifier = Modifier.width(4.dp))
                                        Text("Original Link")
                                    }
                                }
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
                        FilterChip(
                            selected = sectionFilter == null,
                            onClick = { sectionFilter = null },
                            label = { Text("All (${paper.questions.size})") }
                        )
                        PyqSectionType.entries.forEach { st ->
                            val count = paper.questions.count { it.sectionType == st }
                            if (count > 0) {
                                FilterChip(
                                    selected = sectionFilter == st,
                                    onClick = { sectionFilter = st },
                                    label = { Text("${st.labelEn} ($count)") }
                                )
                            }
                        }
                    }
                }

                itemsIndexed(filteredQuestions, key = { idx, q -> "${paper.id}_${q.id}_$idx" }) { idx, item ->
                    PyqQuestionDisplayCard(
                        index = idx + 1,
                        yearBadge = item.sectionType.labelEn,
                        item = item,
                        bilingualMode = bilingualMode,
                        showAnswerByDefault = revealAllAnswers
                    )
                }
            }
        }
    }
}

@Composable
private fun PyqQuestionDisplayCard(
    index: Int,
    yearBadge: String,
    item: PyqQuestionItem,
    bilingualMode: Boolean,
    showAnswerByDefault: Boolean
) {
    var showAnswer by remember(item.id, showAnswerByDefault) { mutableStateOf(showAnswerByDefault) }
    val selectedOptMap = remember { mutableStateMapOf<String, Int>() }
    val chosenOpt = selectedOptMap[item.id]

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = "$yearBadge • ${item.marks} Marks",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
                Text(item.chapterTag, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.secondary)
            }

            Text("Q$index. ${item.questionEn}", style = MaterialTheme.typography.titleSmall)
            if (bilingualMode && item.questionHi.isNotBlank()) {
                Text(item.questionHi, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }

            if (item.options.isNotEmpty()) {
                val letters = listOf("A", "B", "C", "D")
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    item.options.forEachIndexed { optIdx, opt ->
                        val isPicked = chosenOpt == optIdx
                        val isRight = optIdx == item.correctOptionIndex
                        val bg = when {
                            chosenOpt != null && isRight -> MaterialTheme.colorScheme.tertiaryContainer
                            isPicked && !isRight -> MaterialTheme.colorScheme.errorContainer
                            else -> MaterialTheme.colorScheme.surfaceVariant
                        }
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { selectedOptMap[item.id] = optIdx },
                            color = bg,
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("(${letters.getOrElse(optIdx) { optIdx + 1 }}) ", fontWeight = FontWeight.Bold)
                                Text(opt, modifier = Modifier.weight(1f), style = MaterialTheme.typography.bodyMedium)
                                if (chosenOpt != null && isRight) {
                                    Icon(Icons.Rounded.CheckCircle, contentDescription = "Correct option", tint = MaterialTheme.colorScheme.tertiary, modifier = Modifier.size(18.dp))
                                }
                            }
                        }
                    }
                }
            }

            OutlinedButton(
                onClick = { showAnswer = !showAnswer },
                modifier = Modifier.height(42.dp)
            ) {
                Text(if (showAnswer) "Hide Answer Key & Solution" else "View Answer Key & Model Solution")
            }

            if (showAnswer) {
                Surface(color = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.6f), shape = MaterialTheme.shapes.small) {
                    Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(
                            text = "Answer Key: ${item.answerKeyEn}",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Bold
                        )
                        if (item.modelSolutionEn.isNotBlank() && item.modelSolutionEn != item.answerKeyEn) {
                            Text(
                                text = "Model Solution:\n${item.modelSolutionEn}",
                                style = MaterialTheme.typography.bodySmall.copy(fontFamily = FontFamily.Default)
                            )
                        }
                        if (item.explanationHi.isNotBlank()) {
                            Text(
                                text = "सरल हिंदी व्याख्या: ${item.explanationHi}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onTertiaryContainer
                            )
                        }
                    }
                }
            }
        }
    }
}
