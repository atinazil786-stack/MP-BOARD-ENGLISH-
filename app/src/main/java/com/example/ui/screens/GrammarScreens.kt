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
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Spellcheck
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
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
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.model.BookmarkDoc
import com.example.data.model.ChapterQuestion
import com.example.data.model.GrammarTopic
import com.example.ui.components.EmptyStateCard
import com.example.ui.components.InteractiveMcqCard
import com.example.ui.components.SectionHeading
import com.example.ui.components.SubjectiveQuestionCard

@Composable
fun GrammarScreen(
    grammarTopics: List<GrammarTopic>,
    bilingualMode: Boolean,
    onTopicClick: (GrammarTopic) -> Unit
) {
    var search by remember { mutableStateOf("") }
    var selectedCategory by remember { mutableStateOf("All") }
    val categories = remember(grammarTopics) {
        listOf("All") + grammarTopics.map { it.category }.distinct()
    }

    val filtered = remember(grammarTopics, search, selectedCategory) {
        grammarTopics.filter { topic ->
            val matchCat = selectedCategory == "All" || topic.category == selectedCategory
            val q = search.trim()
            val matchText = q.isBlank() ||
                topic.title.contains(q, ignoreCase = true) ||
                topic.titleHi.contains(q, ignoreCase = true) ||
                topic.formula.contains(q, ignoreCase = true)
            matchCat && matchText
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
            item {
                SectionHeading(
                    titleEn = "Complete English Grammar",
                    titleHi = "संपूर्ण अंग्रेजी व्याकरण (हिंदी व्याख्या व MCQ सहित)",
                    bilingualMode = bilingualMode
                )
            }

            item {
                OutlinedTextField(
                    value = search,
                    onValueChange = { search = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("grammar_search_input"),
                    singleLine = true,
                    shape = RoundedCornerShape(14.dp),
                    leadingIcon = { Icon(Icons.Rounded.Search, contentDescription = "Search grammar") },
                    placeholder = { Text("Search Tenses, Voice, Narration, Modals...") }
                )
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    categories.forEach { cat ->
                        FilterChip(
                            selected = selectedCategory == cat,
                            onClick = { selectedCategory = cat },
                            label = { Text(cat) }
                        )
                    }
                }
            }

            if (filtered.isEmpty()) {
                item {
                    EmptyStateCard(
                        icon = Icons.Rounded.Spellcheck,
                        title = "No grammar topic matches",
                        subtitle = "Clear your search filter to view all 16 MP Board grammar topics."
                    )
                }
            } else {
                items(filtered, key = { it.id }) { topic ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("grammar_card_${topic.id}")
                            .clickable { onTopicClick(topic) },
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
                                    imageVector = Icons.Rounded.Spellcheck,
                                    contentDescription = null,
                                    tint = MaterialTheme.colorScheme.primary,
                                    modifier = Modifier.padding(10.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(topic.title, style = MaterialTheme.typography.titleMedium)
                                if (bilingualMode) {
                                    Text(
                                        topic.titleHi,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                                Text(
                                    text = "${topic.category} • ${topic.examples.size} Examples • ${topic.mcqQuestions.size} MCQs",
                                    style = MaterialTheme.typography.labelSmall,
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GrammarDetailScreen(
    topic: GrammarTopic,
    bilingualMode: Boolean,
    bookmarks: List<BookmarkDoc>,
    onBack: () -> Unit,
    onToggleFavoriteQuestion: (ChapterQuestion, String) -> Unit
) {
    var selectedTab by remember(topic.id) { mutableIntStateOf(0) }
    val tabs = listOf("Hindi Guide", "Examples", "Practice Qs", "MCQ Test")
    val favouriteIds = remember(bookmarks) {
        bookmarks.filter { it.itemType == "question" }.map { it.targetId }.toSet()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(topic.title, style = MaterialTheme.typography.titleMedium, maxLines = 1)
                        Text(topic.titleHi, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("grammar_back_button")) {
                        Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back to grammar")
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
            TabRow(selectedTabIndex = selectedTab) {
                tabs.forEachIndexed { idx, label ->
                    Tab(
                        selected = selectedTab == idx,
                        onClick = { selectedTab = idx },
                        text = { Text(label, maxLines = 1) }
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
                                Surface(
                                    color = MaterialTheme.colorScheme.secondaryContainer,
                                    shape = MaterialTheme.shapes.medium,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Column(modifier = Modifier.padding(14.dp)) {
                                        Text("Key Formula / Structure", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.secondary)
                                        Spacer(modifier = Modifier.height(4.dp))
                                        Text(topic.formula, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                                    }
                                }
                            }
                            item {
                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                                ) {
                                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                        Text("हिंदी व्याख्या (Hindi Explanation)", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
                                        Text(topic.explanationHi, style = MaterialTheme.typography.bodyLarge)
                                    }
                                }
                            }
                            item {
                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                                ) {
                                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                        Text("Core English Rules", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
                                        Text(topic.rulesSummaryEn, style = MaterialTheme.typography.bodyMedium)
                                    }
                                }
                            }
                        }

                        1 -> {
                            items(topic.examples) { ex ->
                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                                ) {
                                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                        Text(ex.english, style = MaterialTheme.typography.titleSmall, color = MaterialTheme.colorScheme.primary)
                                        if (ex.hindi.isNotBlank()) {
                                            Text(ex.hindi, style = MaterialTheme.typography.bodyMedium)
                                        }
                                        if (ex.note.isNotBlank()) {
                                            Surface(
                                                color = MaterialTheme.colorScheme.surfaceVariant,
                                                shape = MaterialTheme.shapes.small
                                            ) {
                                                Text(
                                                    text = "Rule Tip: ${ex.note}",
                                                    style = MaterialTheme.typography.bodySmall,
                                                    modifier = Modifier.padding(8.dp)
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        2 -> {
                            if (topic.practiceQuestions.isEmpty()) {
                                item {
                                    EmptyStateCard(Icons.Rounded.Spellcheck, "Use MCQ Test tab", "Practice MCQs are ready in the next tab or ask Imran Sir AI for custom exercises.")
                                }
                            } else {
                                itemsIndexed(topic.practiceQuestions, key = { _, q -> q.id }) { idx, q ->
                                    SubjectiveQuestionCard(idx + 1, q, bilingualMode, q.id in favouriteIds) {
                                        onToggleFavoriteQuestion(q, "Grammar: ${topic.title}")
                                    }
                                }
                            }
                        }

                        3 -> {
                            if (topic.mcqQuestions.isEmpty()) {
                                item {
                                    EmptyStateCard(Icons.Rounded.Spellcheck, "No MCQs yet", "Add MCQs for this topic via Admin Content Management.")
                                }
                            } else {
                                itemsIndexed(topic.mcqQuestions, key = { _, q -> q.id }) { idx, q ->
                                    InteractiveMcqCard(idx + 1, q, bilingualMode, q.id in favouriteIds) {
                                        onToggleFavoriteQuestion(q, "Grammar: ${topic.title}")
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
