package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.automirrored.rounded.MenuBook
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material.icons.rounded.AutoStories
import androidx.compose.material.icons.rounded.Bolt
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Description
import androidx.compose.material.icons.rounded.EditNote
import androidx.compose.material.icons.rounded.LocalFireDepartment
import androidx.compose.material.icons.rounded.Quiz
import androidx.compose.material.icons.rounded.RateReview
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.School
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Spellcheck
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.data.curriculum.QuestionBankAndVocab
import com.example.data.model.Chapter
import com.example.data.model.ClassCourseInfo
import com.example.data.model.GrammarTopic
import com.example.data.model.StudyProgressDoc
import com.example.data.model.WritingSkillTopic
import com.example.ui.components.SectionHeading
import com.example.ui.components.TeacherBrandIdentityBlock
import com.example.ui.components.TeacherCircularAvatar
import com.example.ui.theme.SaffronGoldLight

@Composable
fun HomeScreen(
    studentName: String,
    selectedClass: Int,
    bilingualMode: Boolean,
    streakCount: Int,
    testsTaken: Int,
    searchQuery: String,
    teacherPhotoBase64: String = "",
    chapters: List<Chapter>,
    grammarTopics: List<GrammarTopic>,
    writingTopics: List<WritingSkillTopic> = emptyList(),
    progressList: List<StudyProgressDoc>,
    onSearchQueryChange: (String) -> Unit,
    onClassCardClick: (Int) -> Unit,
    onChapterClick: (Chapter) -> Unit,
    onGrammarTopicClick: (GrammarTopic) -> Unit,
    onWritingTopicClick: (WritingSkillTopic) -> Unit = {},
    onStartDailyQuiz: () -> Unit,
    onOpenAskAi: () -> Unit,
    onOpenTests: () -> Unit,
    onOpenWritingSkills: () -> Unit = {},
    onOpenPyqPapers: () -> Unit = {},
    onOpenAiAnswerPractice: () -> Unit = {},
    onOpenPoemsSection: () -> Unit = {},
    onOpenAboutTeacher: () -> Unit = {}
) {
    val vocabList = QuestionBankAndVocab.dailyVocabulary
    var vocabIndex by remember { mutableIntStateOf(0) }
    val todayVocab = vocabList[vocabIndex % vocabList.size]

    val matchingChapters = remember(searchQuery, chapters) {
        val q = searchQuery.trim()
        if (q.length < 2) emptyList()
        else chapters.filter {
            it.title.contains(q, ignoreCase = true) ||
                it.titleHi.contains(q, ignoreCase = true) ||
                it.bookName.contains(q, ignoreCase = true) ||
                it.author.contains(q, ignoreCase = true)
        }.take(6)
    }

    val matchingGrammar = remember(searchQuery, grammarTopics) {
        val q = searchQuery.trim()
        if (q.length < 2) emptyList()
        else grammarTopics.filter {
            it.title.contains(q, ignoreCase = true) ||
                it.titleHi.contains(q, ignoreCase = true) ||
                it.category.contains(q, ignoreCase = true)
        }.take(5)
    }

    val matchingWriting = remember(searchQuery, writingTopics) {
        val q = searchQuery.trim()
        if (q.length < 2) emptyList()
        else writingTopics.filter {
            it.titleEn.contains(q, ignoreCase = true) ||
                it.titleHi.contains(q, ignoreCase = true)
        }.take(4)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        LazyColumn(
            modifier = Modifier
                .widthIn(max = 760.dp)
                .fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 14.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Branded Hero Banner Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(24.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(132.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.img_hero_academy),
                                contentDescription = "Imran Gori Sir English Hub Banner",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(Color(0x8811264A))
                            )
                            Row(
                                modifier = Modifier
                                    .align(Alignment.BottomStart)
                                    .fillMaxWidth()
                                    .clickable(onClick = onOpenAboutTeacher)
                                    .padding(16.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                TeacherCircularAvatar(
                                    customPhotoBase64 = teacherPhotoBase64,
                                    size = 64.dp,
                                    borderColor = SaffronGoldLight,
                                    borderWidth = 2.5.dp,
                                    showVerifiedBadge = true,
                                    contentDescription = "Imran Gori Sir official circular portrait",
                                    modifier = Modifier.testTag("home_teacher_avatar")
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                TeacherBrandIdentityBlock(
                                    titleColor = Color.White,
                                    subtitleColor = SaffronGoldLight,
                                    modifier = Modifier.weight(1f)
                                )
                                Surface(
                                    color = Color.White.copy(alpha = 0.18f),
                                    shape = RoundedCornerShape(999.dp)
                                ) {
                                    Text(
                                        text = "About Sir",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = Color.White,
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                                    )
                                }
                            }
                        }

                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Text(
                                text = "Welcome to Your English Learning World!",
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.White
                            )
                            Text(
                                text = "Hello ${studentName.substringBefore(" ")} • Class ${selectedClass}th • 2D Cartoon Videos, Hindi Guides & 100 MCQs/Chapter!",
                                style = MaterialTheme.typography.bodySmall,
                                color = Color.White.copy(alpha = 0.88f)
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                StatChip(
                                    icon = Icons.Rounded.LocalFireDepartment,
                                    label = "$streakCount Day Streak",
                                    modifier = Modifier.weight(1f)
                                )
                                StatChip(
                                    icon = Icons.Rounded.Quiz,
                                    label = "$testsTaken Tests Done",
                                    modifier = Modifier.weight(1f)
                                )
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.spacedBy(10.dp)
                            ) {
                                Button(
                                    onClick = onOpenAskAi,
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(48.dp)
                                        .testTag("home_ask_ai_button"),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.colorScheme.secondary,
                                        contentColor = MaterialTheme.colorScheme.onSecondary
                                    )
                                ) {
                                    Icon(Icons.Rounded.AutoAwesome, contentDescription = null, modifier = Modifier.size(18.dp))
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text("Ask Imran Sir AI", maxLines = 1, overflow = TextOverflow.Ellipsis)
                                }
                                FilledTonalButton(
                                    onClick = onOpenTests,
                                    modifier = Modifier
                                        .weight(1f)
                                        .height(48.dp)
                                        .testTag("home_exams_button")
                                ) {
                                    Icon(Icons.Rounded.Bolt, contentDescription = null, modifier = Modifier.size(18.dp))
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text("Online Exam", maxLines = 1, overflow = TextOverflow.Ellipsis)
                                }
                            }
                        }
                    }
                }
            }

            // Global Search Bar
            item {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = onSearchQueryChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("global_search_input"),
                    singleLine = true,
                    shape = RoundedCornerShape(16.dp),
                    leadingIcon = {
                        Icon(Icons.Rounded.Search, contentDescription = "Search syllabus")
                    },
                    trailingIcon = {
                        if (searchQuery.isNotBlank()) {
                            IconButton(onClick = { onSearchQueryChange("") }) {
                                Icon(Icons.Rounded.Close, contentDescription = "Clear search")
                            }
                        }
                    },
                    placeholder = {
                        Text("Search chapters, grammar topics, authors...")
                    }
                )
            }

            // Live Search Results
            if (searchQuery.trim().length >= 2) {
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                    ) {
                        Column(
                            modifier = Modifier.padding(14.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "Search Results (${matchingChapters.size + matchingGrammar.size + matchingWriting.size})",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                            if (matchingChapters.isEmpty() && matchingGrammar.isEmpty() && matchingWriting.isEmpty()) {
                                Text(
                                    text = "No matching chapters or grammar lessons found for \"$searchQuery\".",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            } else {
                                matchingChapters.forEach { chapter ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(10.dp))
                                            .clickable { onChapterClick(chapter) }
                                            .padding(horizontal = 8.dp, vertical = 8.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(Icons.AutoMirrored.Rounded.MenuBook, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(chapter.title, style = MaterialTheme.typography.titleSmall)
                                            Text(
                                                "Class ${chapter.classLevel} • ${chapter.bookName}",
                                                style = MaterialTheme.typography.bodySmall,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                        Icon(Icons.AutoMirrored.Rounded.ArrowForward, contentDescription = null)
                                    }
                                }
                                matchingGrammar.forEach { topic ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(10.dp))
                                            .clickable { onGrammarTopicClick(topic) }
                                            .padding(horizontal = 8.dp, vertical = 8.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(Icons.Rounded.Spellcheck, contentDescription = null, tint = MaterialTheme.colorScheme.secondary)
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(topic.title, style = MaterialTheme.typography.titleSmall)
                                            Text(
                                                "Grammar • ${topic.titleHi}",
                                                style = MaterialTheme.typography.bodySmall,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                        Icon(Icons.AutoMirrored.Rounded.ArrowForward, contentDescription = null)
                                    }
                                }
                                matchingWriting.forEach { wTopic ->
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .clip(RoundedCornerShape(10.dp))
                                            .clickable { onWritingTopicClick(wTopic) }
                                            .padding(horizontal = 8.dp, vertical = 8.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Icon(Icons.Rounded.EditNote, contentDescription = null, tint = MaterialTheme.colorScheme.tertiary)
                                        Spacer(modifier = Modifier.width(10.dp))
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(wTopic.titleEn, style = MaterialTheme.typography.titleSmall)
                                            Text(
                                                "Writing Skills • ${wTopic.titleHi}",
                                                style = MaterialTheme.typography.bodySmall,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                        Icon(Icons.AutoMirrored.Rounded.ArrowForward, contentDescription = null)
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // 4 Attractive Class Cards (Class 9th to 12th)
            item {
                SectionHeading(
                    titleEn = "Choose Your MP Board Class",
                    titleHi = "अपनी कक्षा चुनें (NCERT / MPBSE)",
                    bilingualMode = bilingualMode
                )
            }

            item {
                val courses = QuestionBankAndVocab.classCourses
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    courses.chunked(2).forEach { rowCourses ->
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(12.dp)
                        ) {
                            rowCourses.forEach { course ->
                                val classChapters = chapters.filter { it.classLevel == course.classLevel }
                                val proseCount = classChapters.count { it.category.equals("Prose", ignoreCase = true) }
                                val poemCount = classChapters.count { it.category.equals("Poem", ignoreCase = true) }
                                val suppCount = classChapters.count { it.category.equals("Supplementary", ignoreCase = true) }
                                val classProgress = progressList.filter { it.classLevel.toInt() == course.classLevel }
                                val avgMastery = if (classChapters.isEmpty()) 0
                                else (classProgress.sumOf { it.masteryPercent.toInt() } / classChapters.size).coerceIn(0, 100)

                                ClassHubCard(
                                    course = course,
                                    chapterCount = classChapters.size,
                                    unitBreakdown = "$proseCount Prose • $poemCount Poems • $suppCount Supp.",
                                    avgMasteryPercent = avgMastery,
                                    isSelected = course.classLevel == selectedClass,
                                    bilingualMode = bilingualMode,
                                    onClick = { onClassCardClick(course.classLevel) },
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }
                    }
                }
            }

            // Board Exam Special Hubs (Writing Skills, PYQs, AI Answer Practice)
            item {
                SectionHeading(
                    titleEn = "MP Board Mastery Hubs",
                    titleHi = "लेखन कौशल, पुराने पेपर और AI उत्तर जांच",
                    bilingualMode = bilingualMode
                )
            }

            item {
                val totalPoems = chapters.count { it.category.equals("Poem", ignoreCase = true) }
                Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    FeatureHubCard(
                        icon = Icons.Rounded.AutoStories,
                        title = "Separate Poems Section ($totalPoems Poems) • कविता संग्रह",
                        subtitle = "All MPBSE 2026–27 Poems (9th–12th) • Poet Intro, Stanza Hindi, Central Idea & Poetic Devices",
                        badgeText = "Poems Hub",
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        onClick = onOpenPoemsSection,
                        testTag = "home_poems_section_card"
                    )
                    FeatureHubCard(
                        icon = Icons.Rounded.EditNote,
                        title = "Writing Skills (15 Topics) • लेखन कौशल",
                        subtitle = "Presented by Imran Gori Sir • Notice, Poster, Letter, Report, Essay & Solved Examples",
                        badgeText = "Class 9–12",
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        onClick = onOpenWritingSkills,
                        testTag = "home_writing_skills_card"
                    )
                    FeatureHubCard(
                        icon = Icons.Rounded.Description,
                        title = "MP Board PYQ Papers (2022–2026) • पिछले पेपर",
                        subtitle = "Presented by Imran Gori Sir • Downloadable PDFs, Answer Keys, Solutions & Practice",
                        badgeText = "2022–2026",
                        containerColor = MaterialTheme.colorScheme.secondaryContainer,
                        onClick = onOpenPyqPapers,
                        testTag = "home_pyq_papers_card"
                    )
                    FeatureHubCard(
                        icon = Icons.Rounded.RateReview,
                        title = "AI Answer Writing Practice • उत्तर जांच व अभ्यास",
                        subtitle = "Write answers in English, choose marks (2–5), get AI grammar & Hindi feedback",
                        badgeText = "AI Grader",
                        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                        onClick = onOpenAiAnswerPractice,
                        testTag = "home_ai_answer_practice_card"
                    )
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("home_about_teacher_card")
                            .clickable(onClick = onOpenAboutTeacher),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.35f))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TeacherCircularAvatar(
                                customPhotoBase64 = teacherPhotoBase64,
                                size = 56.dp,
                                borderColor = MaterialTheme.colorScheme.primary,
                                borderWidth = 2.dp,
                                showVerifiedBadge = true
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
                                Text(
                                    text = "IMRAN GORI SIR",
                                    style = MaterialTheme.typography.labelMedium,
                                    color = MaterialTheme.colorScheme.primary,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "About Teacher • शिक्षक परिचय",
                                    style = MaterialTheme.typography.titleSmall
                                )
                                Text(
                                    text = "MP BOARD ENGLISH HUB • Learn English Smartly – Score Higher!",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Icon(
                                imageVector = Icons.AutoMirrored.Rounded.ArrowForward,
                                contentDescription = "Open About Teacher",
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }

            // Daily Quiz Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary.copy(alpha = 0.35f))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "Daily 5-Minute Quiz • दैनिक क्विज़",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSecondaryContainer
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Sharpen your MP Board Class ${selectedClass}th prep and keep your study streak alive!",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.85f)
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                        Button(
                            onClick = onStartDailyQuiz,
                            modifier = Modifier
                                .height(48.dp)
                                .testTag("daily_quiz_button")
                        ) {
                            Text("Play")
                        }
                    }
                }
            }

            // Daily Vocabulary Spotlight
            item {
                SectionHeading(
                    titleEn = "Daily Vocabulary",
                    titleHi = "आज का महत्वपूर्ण शब्द",
                    bilingualMode = bilingualMode,
                    trailing = {
                        IconButton(
                            onClick = { vocabIndex = (vocabIndex + 1) % vocabList.size },
                            modifier = Modifier.testTag("next_vocab_button")
                        ) {
                            Icon(Icons.Rounded.Refresh, contentDescription = "Next daily word")
                        }
                    }
                )
            }

            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = todayVocab.word,
                                style = MaterialTheme.typography.headlineSmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Surface(
                                color = MaterialTheme.colorScheme.tertiaryContainer,
                                shape = RoundedCornerShape(999.dp)
                            ) {
                                Text(
                                    text = "${todayVocab.partOfSpeech} • ${todayVocab.pronunciation}",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                )
                            }
                        }
                        Text(
                            text = "${todayVocab.meaningEn} — ${todayVocab.meaningHi}",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            text = "Synonym: ${todayVocab.synonym}   •   Antonym: ${todayVocab.antonym}",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.secondary
                        )
                        Surface(
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            shape = MaterialTheme.shapes.small
                        ) {
                            Column(modifier = Modifier.padding(10.dp)) {
                                Text(todayVocab.exampleEn, style = MaterialTheme.typography.bodySmall)
                                if (bilingualMode) {
                                    Text(
                                        todayVocab.exampleHi,
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
}

@Composable
private fun StatChip(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = Color.White.copy(alpha = 0.14f),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Icon(icon, contentDescription = null, tint = SaffronGoldLight, modifier = Modifier.size(16.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = Color.White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
private fun ClassHubCard(
    course: ClassCourseInfo,
    chapterCount: Int,
    unitBreakdown: String,
    avgMasteryPercent: Int,
    isSelected: Boolean,
    bilingualMode: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .testTag("class_card_${course.classLevel}")
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface
        ),
        border = BorderStroke(
            width = if (isSelected) 2.dp else 1.dp,
            color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant
        )
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    color = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary,
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.School,
                        contentDescription = null,
                        modifier = Modifier.padding(6.dp).size(18.dp)
                    )
                }
                Text(
                    text = "$chapterCount Units",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = course.titleEn,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            if (bilingualMode) {
                Text(
                    text = course.titleHi,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Text(
                text = course.books.joinToString(" • "),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Medium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = unitBreakdown,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.secondary,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            LinearProgressIndicator(
                progress = { avgMasteryPercent / 100f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(RoundedCornerShape(999.dp))
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(Icons.Rounded.AutoStories, contentDescription = null, modifier = Modifier.size(14.dp), tint = MaterialTheme.colorScheme.onSurfaceVariant)
                Text(
                    text = "$avgMasteryPercent% studied",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
private fun FeatureHubCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    title: String,
    subtitle: String,
    badgeText: String,
    containerColor: Color,
    onClick: () -> Unit,
    testTag: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .testTag(testTag)
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                color = containerColor,
                shape = RoundedCornerShape(14.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    modifier = Modifier.padding(12.dp).size(24.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Text(title, style = MaterialTheme.typography.titleSmall, modifier = Modifier.weight(1f, fill = false))
                    Surface(
                        color = containerColor,
                        shape = RoundedCornerShape(999.dp)
                    ) {
                        Text(
                            text = badgeText,
                            style = MaterialTheme.typography.labelSmall,
                            modifier = Modifier.padding(horizontal = 7.dp, vertical = 2.dp)
                        )
                    }
                }
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(modifier = Modifier.width(6.dp))
            Icon(Icons.AutoMirrored.Rounded.ArrowForward, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
        }
    }
}
