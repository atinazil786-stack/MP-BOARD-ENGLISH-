package com.example.ui.screens

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
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.EditNote
import androidx.compose.material.icons.rounded.FormatListNumbered
import androidx.compose.material.icons.rounded.Lightbulb
import androidx.compose.material.icons.rounded.School
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.model.WritingSkillTopic
import com.example.ui.components.SectionHeading
import com.example.ui.components.StatusBannerCard
import com.example.ui.theme.SaffronGoldLight

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun WritingSkillsDashboardScreen(
    selectedClass: Int,
    bilingualMode: Boolean,
    topics: List<WritingSkillTopic>,
    onOpenTopic: (WritingSkillTopic) -> Unit,
    onOpenAiAnswerPractice: () -> Unit,
    onBack: () -> Unit
) {
    var classFilter by remember { mutableIntStateOf(0) } // 0 = All Classes, 9..12

    val filteredTopics = remember(topics, classFilter) {
        if (classFilter == 0) topics
        else topics.filter { classFilter in it.applicableClasses }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("Writing Skills", style = MaterialTheme.typography.titleMedium)
                        Text(
                            "Presented by Imran Gori Sir • MP Board 9th–12th",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("writing_back_button")) {
                        Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back from Writing Skills")
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
                                text = "WRITING SKILLS • लेखन कौशल",
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
                                text = "15 Complete MP Board Formats (Class 9–12 Syllabus): Simple Hindi Guide, Box Templates, Solved Examples, Model Answers & Interactive Writing Practice.",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.White.copy(alpha = 0.9f)
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Button(
                                onClick = onOpenAiAnswerPractice,
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = MaterialTheme.colorScheme.secondary,
                                    contentColor = MaterialTheme.colorScheme.onSecondary
                                ),
                                modifier = Modifier.height(48.dp).testTag("writing_open_ai_practice_btn")
                            ) {
                                Icon(Icons.Rounded.AutoAwesome, contentDescription = null, modifier = Modifier.size(18.dp))
                                Spacer(modifier = Modifier.width(6.dp))
                                Text("Evaluate Your Draft with AI Practice")
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
                        listOf(
                            0 to "All 15 Topics",
                            9 to "Class 9th",
                            10 to "Class 10th",
                            11 to "Class 11th",
                            12 to "Class 12th"
                        ).forEach { (cls, label) ->
                            FilterChip(
                                selected = classFilter == cls,
                                onClick = { classFilter = cls },
                                label = { Text(label) },
                                modifier = Modifier.testTag("writing_class_chip_$cls")
                            )
                        }
                    }
                }

                item {
                    StatusBannerCard(
                        text = "Tip: Class ${selectedClass}th Syllabus Focus — ध्यान दें कि Notice, Poster, Advertisement व Report मुख्यतः Class 11th–12th में और Essay, Application व Picture Composition Class 9th–10th में पूछे जाते हैं।",
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }

                item {
                    SectionHeading(
                        titleEn = "Topics (${filteredTopics.size})",
                        titleHi = "MP बोर्ड लेखन कौशल विषय",
                        bilingualMode = bilingualMode
                    )
                }

                items(filteredTopics, key = { it.id }) { topic ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("writing_topic_card_${topic.id}")
                            .clickable { onOpenTopic(topic) },
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
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
                                        text = "#${topic.order}",
                                        style = MaterialTheme.typography.labelLarge,
                                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(topic.titleEn, style = MaterialTheme.typography.titleMedium)
                                    if (bilingualMode && topic.titleHi.isNotBlank()) {
                                        Text(
                                            topic.titleHi,
                                            style = MaterialTheme.typography.bodySmall,
                                            color = MaterialTheme.colorScheme.primary
                                        )
                                    }
                                }
                                Icon(Icons.AutoMirrored.Rounded.ArrowForward, contentDescription = "Open ${topic.titleEn}")
                            }

                            FlowRow(
                                horizontalArrangement = Arrangement.spacedBy(6.dp),
                                verticalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                topic.applicableClasses.sorted().forEach { cls ->
                                    Surface(
                                        color = if (cls == selectedClass) MaterialTheme.colorScheme.secondaryContainer
                                        else MaterialTheme.colorScheme.surfaceVariant,
                                        shape = RoundedCornerShape(999.dp)
                                    ) {
                                        Text(
                                            text = "Class ${cls}th",
                                            style = MaterialTheme.typography.labelSmall,
                                            color = if (cls == selectedClass) MaterialTheme.colorScheme.onSecondaryContainer
                                            else MaterialTheme.colorScheme.onSurfaceVariant,
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                        )
                                    }
                                }
                                if (topic.isAdminAdded) {
                                    Surface(
                                        color = MaterialTheme.colorScheme.tertiaryContainer,
                                        shape = RoundedCornerShape(999.dp)
                                    ) {
                                        Text(
                                            text = "Imran Sir Added",
                                            style = MaterialTheme.typography.labelSmall,
                                            color = MaterialTheme.colorScheme.onTertiaryContainer,
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                        )
                                    }
                                }
                            }

                            Text(
                                text = topic.syllabusNoteHi,
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WritingSkillDetailScreen(
    topic: WritingSkillTopic,
    bilingualMode: Boolean,
    onBack: () -> Unit,
    onSendToAiEvaluation: (questionPrompt: String, draftAnswer: String, maxMarks: Int, title: String) -> Unit
) {
    val tabs = listOf(
        "Hindi Guide",
        "Format & Rules",
        "Solved Example",
        "Exam Q&As",
        "Practice"
    )
    var selectedTab by remember(topic.id) { mutableIntStateOf(0) }
    var studentDraft by rememberSaveable(topic.id) { mutableStateOf("") }
    var draftFeedbackSaved by remember(topic.id) { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(topic.titleEn, style = MaterialTheme.typography.titleMedium, maxLines = 1)
                        Text(
                            topic.titleHi.ifBlank { "Imran Gori Sir • Writing Skills" },
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("writing_detail_back_btn")) {
                        Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back to Writing Skills")
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                tabs.forEachIndexed { idx, label ->
                    FilterChip(
                        selected = selectedTab == idx,
                        onClick = { selectedTab = idx },
                        label = { Text(label) },
                        modifier = Modifier.testTag("writing_detail_tab_$idx")
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
                    when (selectedTab) {
                        0 -> {
                            item {
                                StatusBannerCard(
                                    text = "MP Board Syllabus: ${topic.syllabusNoteHi}",
                                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                            item {
                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                                ) {
                                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                        Text("सरल हिंदी व्याख्या (Simple Hindi Explanation)", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
                                        Text(topic.explanationHi, style = MaterialTheme.typography.bodyLarge)
                                    }
                                }
                            }
                            if (topic.stepsHi.isNotEmpty()) {
                                item {
                                    SectionHeading(
                                        titleEn = "Step-by-Step Guidance",
                                        titleHi = "लिखने के आसान चरण",
                                        bilingualMode = bilingualMode
                                    )
                                }
                                items(topic.stepsHi) { step ->
                                    Card(
                                        modifier = Modifier.fillMaxWidth(),
                                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                                    ) {
                                        Row(modifier = Modifier.padding(14.dp), verticalAlignment = Alignment.Top) {
                                            Icon(Icons.Rounded.FormatListNumbered, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(20.dp))
                                            Spacer(modifier = Modifier.width(10.dp))
                                            Text(step, style = MaterialTheme.typography.bodyMedium)
                                        }
                                    }
                                }
                            }
                        }

                        1 -> {
                            if (topic.rulesAndFormatEn.isNotEmpty()) {
                                item {
                                    Card(
                                        modifier = Modifier.fillMaxWidth(),
                                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                                    ) {
                                        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                            Text("Essential Board Marking Rules", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
                                            topic.rulesAndFormatEn.forEach { rule ->
                                                Row(verticalAlignment = Alignment.Top) {
                                                    Icon(Icons.Rounded.CheckCircle, contentDescription = null, tint = MaterialTheme.colorScheme.tertiary, modifier = Modifier.size(18.dp))
                                                    Spacer(modifier = Modifier.width(8.dp))
                                                    Text(rule, style = MaterialTheme.typography.bodyMedium)
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (topic.formatTemplate.isNotBlank()) {
                                item {
                                    Card(
                                        modifier = Modifier.fillMaxWidth(),
                                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.4f))
                                    ) {
                                        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                            Text("Standard Format Template (Exam Layout)", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
                                            Text(
                                                text = topic.formatTemplate,
                                                style = MaterialTheme.typography.bodySmall.copy(fontFamily = FontFamily.Monospace)
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        2 -> {
                            items(topic.solvedExamples) { ex ->
                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                                ) {
                                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                                        Text(ex.title, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
                                        Surface(color = MaterialTheme.colorScheme.surfaceVariant, shape = MaterialTheme.shapes.small) {
                                            Text(
                                                text = "Question: ${ex.questionEn}",
                                                style = MaterialTheme.typography.bodyMedium,
                                                modifier = Modifier.padding(10.dp)
                                            )
                                        }
                                        Surface(
                                            color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.45f),
                                            shape = MaterialTheme.shapes.small
                                        ) {
                                            Text(
                                                text = ex.englishAnswer,
                                                style = MaterialTheme.typography.bodyMedium.copy(fontFamily = FontFamily.Monospace),
                                                modifier = Modifier.padding(12.dp)
                                            )
                                        }
                                        Surface(
                                            color = MaterialTheme.colorScheme.secondaryContainer,
                                            shape = MaterialTheme.shapes.small
                                        ) {
                                            Text(
                                                text = "हिंदी स्पष्टीकरण: ${ex.hindiExplanation}",
                                                style = MaterialTheme.typography.bodyMedium,
                                                color = MaterialTheme.colorScheme.onSecondaryContainer,
                                                modifier = Modifier.padding(12.dp)
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        3 -> {
                            itemsIndexed(topic.examQuestionsAndModels) { idx, item ->
                                var showModel by remember(item.id) { mutableStateOf(true) }
                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                                ) {
                                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ) {
                                            Text("${item.boardRef}", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.secondary)
                                            Text("${item.marks} Marks", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
                                        }
                                        Text("Q${idx + 1}. ${item.questionEn}", style = MaterialTheme.typography.titleSmall)
                                        if (bilingualMode && item.questionHi.isNotBlank()) {
                                            Text(item.questionHi, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                        }
                                        FilledTonalButton(onClick = { showModel = !showModel }, modifier = Modifier.height(44.dp)) {
                                            Text(if (showModel) "Hide Model Answer" else "Show Model Answer")
                                        }
                                        if (showModel) {
                                            Surface(color = MaterialTheme.colorScheme.surfaceVariant, shape = MaterialTheme.shapes.small) {
                                                Text(
                                                    text = item.modelAnswer,
                                                    style = MaterialTheme.typography.bodyMedium.copy(fontFamily = FontFamily.Monospace),
                                                    modifier = Modifier.padding(12.dp)
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        4 -> {
                            val activeExercise = topic.practiceExercises.firstOrNull()
                            itemsIndexed(topic.practiceExercises) { idx, ex ->
                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer)
                                ) {
                                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Icon(Icons.Rounded.Lightbulb, contentDescription = null, tint = MaterialTheme.colorScheme.secondary)
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Text("Practice Exercise ${idx + 1} (${ex.marks} Marks)", style = MaterialTheme.typography.titleSmall)
                                        }
                                        Text(ex.promptEn, style = MaterialTheme.typography.bodyMedium)
                                        if (bilingualMode && ex.promptHi.isNotBlank()) {
                                            Text(ex.promptHi, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSecondaryContainer)
                                        }
                                        Text("संकेत (Hints): ${ex.hintsHi}", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
                                    }
                                }
                            }
                            item {
                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                                ) {
                                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                                        Row(verticalAlignment = Alignment.CenterVertically) {
                                            Icon(Icons.Rounded.EditNote, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Text("Student Writing Practice Pad", style = MaterialTheme.typography.titleMedium)
                                        }
                                        OutlinedTextField(
                                            value = studentDraft,
                                            onValueChange = {
                                                studentDraft = it
                                                draftFeedbackSaved = false
                                            },
                                            label = { Text("Write your answer in English here...") },
                                            minLines = 6,
                                            modifier = Modifier.fillMaxWidth().testTag("writing_practice_draft_input")
                                        )
                                        val words = studentDraft.trim().split(Regex("\\s+")).count { it.isNotBlank() }
                                        Text("Word Count: $words words", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                        Button(
                                            enabled = studentDraft.isNotBlank(),
                                            onClick = {
                                                val prompt = activeExercise?.promptEn
                                                    ?: topic.examQuestionsAndModels.firstOrNull()?.questionEn
                                                    ?: "Write a ${topic.titleEn} on the given topic."
                                                val marks = activeExercise?.marks ?: 4
                                                onSendToAiEvaluation(prompt, studentDraft, marks, topic.titleEn)
                                            },
                                            modifier = Modifier.fillMaxWidth().height(50.dp).testTag("writing_send_to_ai_btn")
                                        ) {
                                            Icon(Icons.Rounded.AutoAwesome, contentDescription = null)
                                            Spacer(modifier = Modifier.width(8.dp))
                                            Text("Evaluate Grammar & Marks with AI")
                                        }
                                        if (draftFeedbackSaved) {
                                            Text("Draft ready!", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.tertiary)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
