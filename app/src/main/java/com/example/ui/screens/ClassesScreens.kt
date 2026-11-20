package com.example.ui.screens

import android.widget.Toast
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.MenuBook
import androidx.compose.material.icons.rounded.AutoStories
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.material.icons.rounded.BookmarkBorder
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Description
import androidx.compose.material.icons.rounded.ExpandLess
import androidx.compose.material.icons.rounded.ExpandMore
import androidx.compose.material.icons.rounded.LibraryBooks
import androidx.compose.material.icons.rounded.Movie
import androidx.compose.material.icons.rounded.OpenInNew
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.PlayCircle
import androidx.compose.material.icons.rounded.Quiz
import androidx.compose.material.icons.rounded.Translate
import androidx.compose.material3.Button
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.core.pdf.PdfPaperUtils
import com.example.data.curriculum.QuestionBankAndVocab
import com.example.data.curriculum.SyllabusInventory
import com.example.data.model.AdminPdfNoteDoc
import com.example.data.model.AdminVideoLinkDoc
import com.example.data.model.BookmarkDoc
import com.example.data.model.Chapter
import com.example.data.model.ChapterQuestion
import com.example.data.model.ChapterSection
import com.example.data.model.QuestionSourceTag
import com.example.data.model.QuestionType
import com.example.data.model.StudyProgressDoc
import com.example.ui.components.CartoonAnimationVideoPlayer
import com.example.ui.components.EmptyStateCard
import com.example.ui.components.InteractiveFillBlankCard
import com.example.ui.components.InteractiveMatchCard
import com.example.ui.components.InteractiveMcqCard
import com.example.ui.components.InteractiveTrueFalseCard
import com.example.ui.components.SectionHeading
import com.example.ui.components.StatusBannerCard
import com.example.ui.components.SubjectiveQuestionCard

@Composable
fun ClassesScreen(
    selectedClass: Int,
    bilingualMode: Boolean,
    chapters: List<Chapter>,
    bookmarks: List<BookmarkDoc>,
    progressList: List<StudyProgressDoc>,
    selectedCategory: String = "All",
    onSelectCategory: (String) -> Unit = {},
    onSelectClass: (Int) -> Unit,
    onOpenChapter: (Chapter) -> Unit,
    onToggleBookmark: (Chapter) -> Unit
) {
    val courseInfo = QuestionBankAndVocab.classCourses.firstOrNull { it.classLevel == selectedClass }
        ?: QuestionBankAndVocab.classCourses[1]
    val books = listOf("All Books") +
        (courseInfo.books + chapters.filter { it.classLevel == selectedClass }.map { it.bookName }).distinct()
    var selectedBook by remember(selectedClass) { mutableStateOf("All Books") }
    var showInventoryCard by remember { mutableStateOf(false) }

    val classUnits = remember(chapters, selectedClass) {
        chapters.filter { it.classLevel == selectedClass }
    }
    val poemsInClass = remember(classUnits) {
        classUnits.filter { it.category.equals("Poem", ignoreCase = true) }
    }
    val inventorySummaries = remember(chapters) {
        SyllabusInventory.summarizeByClass(chapters)
    }

    val filteredChapters = remember(classUnits, selectedBook, selectedCategory) {
        classUnits.filter { ch ->
            val bookMatch = selectedBook == "All Books" || ch.bookName == selectedBook
            val catMatch = selectedCategory == "All" || ch.category.equals(selectedCategory, ignoreCase = true)
            bookMatch && catMatch
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
                    titleEn = "Class ${selectedClass}th Syllabus",
                    titleHi = "${courseInfo.titleHi} • NCERT व MPBSE 2026–27 संपूर्ण पाठ्यक्रम",
                    bilingualMode = bilingualMode
                )
            }

            // Class 9-12 Filter Row
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    listOf(9, 10, 11, 12).forEach { level ->
                        FilterChip(
                            selected = selectedClass == level,
                            onClick = { onSelectClass(level) },
                            label = { Text("Class ${level}th") },
                            modifier = Modifier.testTag("classes_filter_$level")
                        )
                    }
                }
            }

            // Separate Category Filter Row: All / Prose / Poems / Supplementary
            item {
                val categoryOptions = listOf(
                    "All" to "All (${classUnits.size})",
                    "Prose" to "Prose (${classUnits.count { it.category.equals("Prose", true) }})",
                    "Poem" to "Poems • कविताएँ (${poemsInClass.size})",
                    "Supplementary" to "Supplementary (${classUnits.count { it.category.equals("Supplementary", true) }})"
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    categoryOptions.forEach { (catKey, label) ->
                        FilterChip(
                            selected = selectedCategory.equals(catKey, ignoreCase = true),
                            onClick = {
                                onSelectCategory(catKey)
                                if (catKey == "Poem") {
                                    selectedBook = "All Books"
                                }
                            },
                            label = { Text(label) },
                            leadingIcon = if (catKey == "Poem") {
                                { Icon(Icons.Rounded.AutoStories, contentDescription = null, modifier = Modifier.size(16.dp)) }
                            } else null,
                            modifier = Modifier.testTag("category_chip_$catKey")
                        )
                    }
                }
            }

            // Book Filter Chips (All Books + Class Books)
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    books.forEach { book ->
                        FilterChip(
                            selected = selectedBook == book,
                            onClick = { selectedBook = book },
                            label = { Text(book) },
                            leadingIcon = {
                                Icon(Icons.AutoMirrored.Rounded.MenuBook, contentDescription = null, modifier = Modifier.size(16.dp))
                            },
                            modifier = Modifier.testTag("book_chip_${book.replace(" ", "_")}")
                        )
                    }
                }
            }

            // Highlighted Separate Poems Section Banner
            if (selectedCategory != "Poem") {
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("separate_poems_banner")
                            .clickable {
                                selectedBook = "All Books"
                                onSelectCategory("Poem")
                            },
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.tertiary.copy(alpha = 0.4f))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(14.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.AutoStories,
                                contentDescription = "Separate Poems Section",
                                tint = MaterialTheme.colorScheme.onTertiaryContainer,
                                modifier = Modifier.size(28.dp)
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    text = "Separate Poems Section • कविता संग्रह (${poemsInClass.size} Poems)",
                                    style = MaterialTheme.typography.titleSmall,
                                    color = MaterialTheme.colorScheme.onTertiaryContainer
                                )
                                Text(
                                    text = "Poet Intro, Stanza-wise Hindi, Central Idea, Theme, Poetic Devices, Extracts & 40 MCQs",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.85f)
                                )
                            }
                            Text(
                                text = "Open →",
                                style = MaterialTheme.typography.labelLarge,
                                color = MaterialTheme.colorScheme.onTertiaryContainer,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            // Collapsible Master Syllabus Inventory Card (MPBSE 2026-27)
            item {
                val totalPrescribed = inventorySummaries.sumOf { it.prescribedTotal }
                val totalLoaded = inventorySummaries.sumOf { it.loadedTotal }
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("master_syllabus_inventory_card")
                        .clickable { showInventoryCard = !showInventoryCard },
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                                Icon(Icons.Rounded.LibraryBooks, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                                Spacer(modifier = Modifier.width(8.dp))
                                Column {
                                    Text(
                                        text = "MPBSE 2026–27 Master Inventory ($totalLoaded/$totalPrescribed Units)",
                                        style = MaterialTheme.typography.titleSmall,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    Text(
                                        text = "Class 9–12 Prose, Poems & Supplementary Tracker",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                            Icon(
                                imageVector = if (showInventoryCard) Icons.Rounded.ExpandLess else Icons.Rounded.ExpandMore,
                                contentDescription = if (showInventoryCard) "Collapse inventory" else "Expand inventory"
                            )
                        }
                        if (showInventoryCard) {
                            inventorySummaries.forEach { row ->
                                Surface(
                                    color = MaterialTheme.colorScheme.surface,
                                    shape = RoundedCornerShape(10.dp),
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text("Class ${row.classLevel}th (${row.booksLabel})", style = MaterialTheme.typography.labelMedium)
                                            Text(
                                                "${row.loadedProse}/${row.prescribedProse} Prose • ${row.loadedPoems}/${row.prescribedPoems} Poems • ${row.loadedSupplementary}/${row.prescribedSupplementary} Supp.",
                                                style = MaterialTheme.typography.bodySmall,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                        Text(
                                            text = if (row.isComplete) "${row.loadedTotal}/${row.prescribedTotal} ✓" else "${row.loadedTotal}/${row.prescribedTotal}",
                                            style = MaterialTheme.typography.labelLarge,
                                            color = if (row.isComplete) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (filteredChapters.isEmpty()) {
                item {
                    EmptyStateCard(
                        icon = Icons.AutoMirrored.Rounded.MenuBook,
                        title = "No units match this filter",
                        subtitle = "Tap 'All Books' or switch category above to view chapters and poems."
                    )
                }
            } else {
                items(filteredChapters, key = { it.id }) { chapter ->
                    val isPoem = chapter.category.equals("Poem", ignoreCase = true)
                    val isSupp = chapter.category.equals("Supplementary", ignoreCase = true)
                    val isBookmarked = bookmarks.any { it.targetId == chapter.id && it.itemType == "chapter" }
                    val prog = progressList.firstOrNull { it.chapterId == chapter.id }
                    val mastery = prog?.masteryPercent?.toInt() ?: 0
                    val mcqCount = chapter.questions.count { it.type == QuestionType.MCQ }
                    val unitSectionsCount = ChapterSection.entries.count {
                        if (isPoem) it != ChapterSection.CHARACTER_SKETCHES else it != ChapterSection.POETIC_DEVICES
                    }

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("chapter_card_${chapter.id}")
                            .clickable { onOpenChapter(chapter) },
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
                                    color = when {
                                        isPoem -> MaterialTheme.colorScheme.tertiaryContainer
                                        isSupp -> MaterialTheme.colorScheme.secondaryContainer
                                        else -> MaterialTheme.colorScheme.primaryContainer
                                    },
                                    shape = RoundedCornerShape(10.dp)
                                ) {
                                    Text(
                                        text = when {
                                            isPoem -> "Poem ${chapter.chapterNumber}"
                                            isSupp -> "Supp. ${chapter.chapterNumber}"
                                            else -> "Ch. ${chapter.chapterNumber}"
                                        },
                                        style = MaterialTheme.typography.labelLarge,
                                        color = when {
                                            isPoem -> MaterialTheme.colorScheme.onTertiaryContainer
                                            isSupp -> MaterialTheme.colorScheme.onSecondaryContainer
                                            else -> MaterialTheme.colorScheme.onPrimaryContainer
                                        },
                                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                                    )
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Column(modifier = Modifier.weight(1f)) {
                                    Text(chapter.title, style = MaterialTheme.typography.titleMedium)
                                    if (bilingualMode && chapter.titleHi.isNotBlank()) {
                                        Text(
                                            chapter.titleHi,
                                            style = MaterialTheme.typography.bodySmall,
                                            color = MaterialTheme.colorScheme.primary
                                        )
                                    }
                                    Text(
                                        text = "${if (isPoem) "Poet" else "By"} ${chapter.author} • ${chapter.bookName} (${chapter.category})",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                                IconButton(
                                    onClick = { onToggleBookmark(chapter) },
                                    modifier = Modifier.testTag("bookmark_chapter_${chapter.id}")
                                ) {
                                    Icon(
                                        imageVector = if (isBookmarked) Icons.Rounded.Bookmark else Icons.Rounded.BookmarkBorder,
                                        contentDescription = if (isBookmarked) "Remove chapter bookmark" else "Bookmark chapter",
                                        tint = if (isBookmarked) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            }
                            LinearProgressIndicator(
                                progress = { mastery / 100f },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(6.dp)
                                    .clip(RoundedCornerShape(999.dp))
                            )
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = "$unitSectionsCount Sections • $mcqCount MCQs • $mastery% read",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                                Surface(
                                    color = MaterialTheme.colorScheme.secondaryContainer,
                                    shape = RoundedCornerShape(999.dp)
                                ) {
                                    Row(
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                                    ) {
                                        Icon(
                                            Icons.Rounded.Movie,
                                            contentDescription = null,
                                            modifier = Modifier.size(12.dp),
                                            tint = MaterialTheme.colorScheme.onSecondaryContainer
                                        )
                                        Text(
                                            text = if (isPoem) "Poem + 2D Video" else "2D Video",
                                            style = MaterialTheme.typography.labelSmall,
                                            color = MaterialTheme.colorScheme.onSecondaryContainer
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
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ChapterDetailScreen(
    chapter: Chapter,
    sameBookChapters: List<Chapter>,
    bilingualMode: Boolean,
    bookmarks: List<BookmarkDoc>,
    completedSections: List<String>,
    chapterPdfNotes: List<AdminPdfNoteDoc> = emptyList(),
    chapterVideoLinks: List<AdminVideoLinkDoc> = emptyList(),
    onBack: () -> Unit,
    onSwitchChapter: (Chapter) -> Unit,
    onToggleBookmark: (Chapter) -> Unit,
    onToggleFavoriteQuestion: (ChapterQuestion, String) -> Unit,
    onMarkSectionCompleted: (String) -> Unit,
    onLaunchChapterTest: (Chapter, Int, Int) -> Unit
) {
    val context = LocalContext.current
    val isPoem = chapter.category.equals("Poem", ignoreCase = true)
    val visibleSections = remember(isPoem) {
        ChapterSection.entries.filter { sec ->
            if (isPoem) sec != ChapterSection.CHARACTER_SKETCHES else sec != ChapterSection.POETIC_DEVICES
        }
    }
    var selectedSection by remember(chapter.id) { mutableStateOf(ChapterSection.SUMMARY) }
    var mcqRangeFilter by remember(chapter.id) { mutableIntStateOf(0) } // 0 = All, 1..4 slices
    var qaTypeFilter by remember(chapter.id) { mutableIntStateOf(0) } // 0 = All, 1 = Long/Board, 2 = Short, 3 = Very Short

    val isBookmarked = bookmarks.any { it.targetId == chapter.id && it.itemType == "chapter" }
    val favouriteIds = remember(bookmarks) {
        bookmarks.filter { it.itemType == "question" }.map { it.targetId }.toSet()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(chapter.title, style = MaterialTheme.typography.titleMedium, maxLines = 1)
                        Text(
                            "Class ${chapter.classLevel} • ${chapter.bookName} • ${chapter.category} (${completedSections.size}/${visibleSections.size})",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("chapter_back_button")) {
                        Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back to chapters")
                    }
                },
                actions = {
                    IconButton(onClick = { onToggleBookmark(chapter) }) {
                        Icon(
                            imageVector = if (isBookmarked) Icons.Rounded.Bookmark else Icons.Rounded.BookmarkBorder,
                            contentDescription = "Bookmark chapter",
                            tint = if (isBookmarked) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSurface
                        )
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
            // Dynamic Sections Horizontal Picker (Poem-tailored or Prose-tailored)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 12.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                visibleSections.forEachIndexed { idx, section ->
                    val done = section.name in completedSections
                    val displayLabel = sectionDisplayLabel(section, isPoem)
                    FilterChip(
                        selected = selectedSection == section,
                        onClick = { selectedSection = section },
                        label = { Text("${idx + 1}. $displayLabel") },
                        leadingIcon = when {
                            done -> {
                                { Icon(Icons.Rounded.CheckCircle, contentDescription = null, modifier = Modifier.size(16.dp)) }
                            }
                            section == ChapterSection.CARTOON_VIDEO -> {
                                { Icon(Icons.Rounded.Movie, contentDescription = null, modifier = Modifier.size(16.dp)) }
                            }
                            else -> null
                        },
                        modifier = Modifier.testTag("section_chip_${section.order}")
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
                    item {
                        SectionHeading(
                            titleEn = sectionDisplayLabel(selectedSection, isPoem),
                            titleHi = sectionDisplayHi(selectedSection, isPoem),
                            bilingualMode = bilingualMode,
                            trailing = {
                                val done = selectedSection.name in completedSections
                                OutlinedButton(
                                    onClick = { onMarkSectionCompleted(selectedSection.name) },
                                    enabled = !done,
                                    modifier = Modifier.testTag("mark_section_done_btn")
                                ) {
                                    Text(if (done) "Done ✓" else "Mark Read")
                                }
                            }
                        )
                    }

                    when (selectedSection) {
                        ChapterSection.CHAPTER_LIST -> {
                            items(sameBookChapters, key = { it.id }) { item ->
                                Card(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable { onSwitchChapter(item) },
                                    colors = CardDefaults.cardColors(
                                        containerColor = if (item.id == chapter.id) MaterialTheme.colorScheme.primaryContainer
                                        else MaterialTheme.colorScheme.surface
                                    ),
                                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                                ) {
                                    Row(
                                        modifier = Modifier.padding(14.dp),
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            "Ch. ${item.chapterNumber}",
                                            style = MaterialTheme.typography.labelLarge,
                                            color = MaterialTheme.colorScheme.primary
                                        )
                                        Spacer(modifier = Modifier.width(12.dp))
                                        Column(modifier = Modifier.weight(1f)) {
                                            Text(item.title, style = MaterialTheme.typography.titleSmall)
                                            if (item.titleHi.isNotBlank()) {
                                                Text(item.titleHi, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.primary)
                                            }
                                            Text(item.author, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                        }
                                    }
                                }
                            }
                        }

                        ChapterSection.CARTOON_VIDEO -> {
                            item {
                                CartoonAnimationVideoPlayer(
                                    chapterId = chapter.id,
                                    chapterTitle = chapter.title,
                                    chapterTitleHi = chapter.titleHi,
                                    scenes = chapter.cartoonScenes,
                                    bilingualMode = bilingualMode,
                                    onVideoCompleted = {
                                        onMarkSectionCompleted(ChapterSection.CARTOON_VIDEO.name)
                                    }
                                )
                            }
                            item {
                                Text(
                                    text = "Story Scenes Breakdown • कहानी के सभी एनीमेटेड दृश्य",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                            items(chapter.cartoonScenes, key = { "sc_${chapter.id}_${it.sceneNumber}" }) { scene ->
                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                                ) {
                                    Column(
                                        modifier = Modifier.padding(14.dp),
                                        verticalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
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
                                                    text = "Scene ${scene.sceneNumber} • ${scene.actionLabel}",
                                                    style = MaterialTheme.typography.labelSmall,
                                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                                                )
                                            }
                                            Text(
                                                text = "${scene.durationSeconds}s",
                                                style = MaterialTheme.typography.labelSmall,
                                                color = MaterialTheme.colorScheme.onSurfaceVariant
                                            )
                                        }
                                        Text(scene.titleHi, style = MaterialTheme.typography.titleSmall)
                                        Text(scene.narrationHi, style = MaterialTheme.typography.bodyMedium)
                                        Text(
                                            text = "Characters: ${scene.characterName}" +
                                                if (scene.secondaryCharacter.isNotBlank()) " & ${scene.secondaryCharacter}" else "",
                                            style = MaterialTheme.typography.labelSmall,
                                            color = MaterialTheme.colorScheme.secondary
                                        )
                                    }
                                }
                            }
                            if (chapterVideoLinks.isNotEmpty()) {
                                item {
                                    Text(
                                        text = "Imran Gori Sir Animated Video Lessons",
                                        style = MaterialTheme.typography.titleMedium,
                                        color = MaterialTheme.colorScheme.secondary
                                    )
                                }
                                items(chapterVideoLinks, key = { "vid_${it.id}" }) { vid ->
                                    Card(
                                        modifier = Modifier.fillMaxWidth(),
                                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
                                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.secondary.copy(alpha = 0.4f))
                                    ) {
                                        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                            Text(vid.title, style = MaterialTheme.typography.titleSmall)
                                            if (vid.summaryHi.isNotBlank()) {
                                                Text(vid.summaryHi, style = MaterialTheme.typography.bodySmall)
                                            }
                                            FilledTonalButton(
                                                onClick = {
                                                    if (!PdfPaperUtils.openExternalUrl(context, vid.videoUrl)) {
                                                        Toast.makeText(context, "Could not open video link.", Toast.LENGTH_SHORT).show()
                                                    }
                                                },
                                                modifier = Modifier.height(44.dp)
                                            ) {
                                                Icon(Icons.Rounded.OpenInNew, contentDescription = null, modifier = Modifier.size(16.dp))
                                                Spacer(modifier = Modifier.width(6.dp))
                                                Text("Watch Video Lesson")
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        ChapterSection.SUMMARY -> {
                            item {
                                FilledTonalButton(
                                    onClick = { selectedSection = ChapterSection.CARTOON_VIDEO },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(48.dp)
                                        .testTag("quick_watch_cartoon_btn")
                                ) {
                                    Icon(Icons.Rounded.PlayCircle, contentDescription = null)
                                    Spacer(modifier = Modifier.width(8.dp))
                                    Text("Watch 2D Cartoon Animation Video (हिंदी में कहानी देखें)")
                                }
                            }
                            if (chapterPdfNotes.isNotEmpty()) {
                                items(chapterPdfNotes, key = { "pdfnote_${it.id}" }) { note ->
                                    Card(
                                        modifier = Modifier.fillMaxWidth(),
                                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer),
                                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.tertiary.copy(alpha = 0.4f))
                                    ) {
                                        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Icon(Icons.Rounded.Description, contentDescription = null, tint = MaterialTheme.colorScheme.tertiary)
                                                Spacer(modifier = Modifier.width(8.dp))
                                                Text("PDF Notes: ${note.title}", style = MaterialTheme.typography.titleSmall)
                                            }
                                            if (note.summaryHi.isNotBlank()) {
                                                Text(note.summaryHi, style = MaterialTheme.typography.bodySmall)
                                            }
                                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                                if (note.pdfBase64.isNotBlank()) {
                                                    Button(
                                                        onClick = {
                                                            val file = PdfPaperUtils.writeBase64NoteToFile(context, note.pdfFileName, note.pdfBase64)
                                                            if (file == null || !PdfPaperUtils.openPdfWithViewer(context, file)) {
                                                                Toast.makeText(context, "Unable to open PDF viewer.", Toast.LENGTH_SHORT).show()
                                                            }
                                                        },
                                                        modifier = Modifier.height(44.dp)
                                                    ) {
                                                        Text("Open PDF")
                                                    }
                                                }
                                                if (note.pdfUrl.isNotBlank()) {
                                                    OutlinedButton(
                                                        onClick = { PdfPaperUtils.openExternalUrl(context, note.pdfUrl) },
                                                        modifier = Modifier.height(44.dp)
                                                    ) {
                                                        Icon(Icons.Rounded.OpenInNew, contentDescription = null, modifier = Modifier.size(16.dp))
                                                        Spacer(modifier = Modifier.width(4.dp))
                                                        Text("Open PDF Link")
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            item {
                                ContentCardBlock(
                                    if (isPoem) "कविता का केंद्रीय भाव व हिंदी सारांश (Central Idea & Summary)" else "सरल हिंदी सारांश (Hindi Summary) — Imran Gori Sir",
                                    chapter.summaryHi
                                )
                            }
                            item {
                                ContentCardBlock(
                                    if (isPoem) "Central Idea & English Overview" else "English Summary (Board Exam Overview)",
                                    chapter.summaryEn
                                )
                            }
                            if (chapter.themeEn.isNotBlank() || chapter.themeHi.isNotBlank()) {
                                item {
                                    ContentCardBlock(
                                        "Theme & Moral Message • मुख्य विषय एवं संदेश",
                                        buildString {
                                            if (chapter.themeHi.isNotBlank()) append("हिंदी विषय: ${chapter.themeHi}\n\n")
                                            if (chapter.themeEn.isNotBlank()) append("Theme (English): ${chapter.themeEn}")
                                            if (chapter.messageHi.isNotBlank() && chapter.messageHi != chapter.summaryHi) {
                                                append("\n\nसंदेश: ${chapter.messageHi}")
                                            }
                                        }
                                    )
                                }
                            }
                        }

                        ChapterSection.THEME_AND_POET -> {
                            val poemGuide = chapter.poemDetails
                            if (isPoem && poemGuide != null) {
                                item {
                                    ContentCardBlock(
                                        "Poet Introduction • कवि परिचय: ${poemGuide.poetName}",
                                        "${poemGuide.poetIntroHi}\n\n${poemGuide.poetIntroEn}"
                                    )
                                }
                                item {
                                    ContentCardBlock(
                                        "Central Idea (केंद्रीय भाव — Board Exam Ready)",
                                        "${poemGuide.centralIdeaEn}\n\nहिंदी केंद्रीय भाव: ${poemGuide.centralIdeaHi}"
                                    )
                                }
                                item {
                                    ContentCardBlock(
                                        "Poem Theme • मुख्य विषय",
                                        "${poemGuide.themeHi}\n\nEnglish Theme: ${poemGuide.themeEn}"
                                    )
                                }
                            } else {
                                item {
                                    ContentCardBlock(
                                        "Core Theme • मुख्य विषय (${chapter.title})",
                                        buildString {
                                            if (chapter.themeHi.isNotBlank()) append("${chapter.themeHi}\n\n")
                                            if (chapter.themeEn.isNotBlank()) append(chapter.themeEn)
                                            if (chapter.themeHi.isBlank() && chapter.themeEn.isBlank()) append(chapter.summaryHi)
                                        }
                                    )
                                }
                                item {
                                    ContentCardBlock(
                                        "Moral & Board Exam Message • जीवन मूल्य एवं संदेश",
                                        chapter.messageHi.ifBlank { chapter.summaryHi }
                                    )
                                }
                            }
                        }

                        ChapterSection.HINDI_EXPLANATION -> {
                            item {
                                StatusBannerCard(
                                    text = if (isPoem) {
                                        "Imran Gori Sir Poetry Note: पहले संपूर्ण हिंदी अनुवाद व भावार्थ पढ़ें, फिर पद्यांश-वार (Stanza-wise) व्याख्या और काव्य सौंदर्य देखें।"
                                    } else {
                                        "Imran Gori Sir Teaching Note: बोर्ड परीक्षा में अच्छे अंक लाने के लिए पहले पूरी सरल हिंदी व्याख्या पढ़ें, फिर अनुच्छेद-वार व्याख्या देखें।"
                                    },
                                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                                )
                            }
                            val explanationText = chapter.poemDetails?.hindiTranslationAndInterpretation
                                ?.takeIf { it.isNotBlank() } ?: chapter.hindiExplanation
                            item {
                                ContentCardBlock(
                                    if (isPoem) "संपूर्ण हिंदी अनुवाद एवं भावार्थ (Hindi Translation & Interpretation)" else "विस्तृत सरल हिंदी व्याख्या (Complete Hindi Explanation)",
                                    explanationText
                                )
                            }
                        }

                        ChapterSection.PARAGRAPH_EXPLANATION -> {
                            val stanzas = chapter.poemDetails?.stanzas.orEmpty()
                            if (isPoem && stanzas.isNotEmpty()) {
                                items(stanzas, key = { "stanza_${chapter.id}_${it.stanzaNumber}" }) { st ->
                                    Card(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .testTag("paragraph_card_${st.stanzaNumber}"),
                                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                                    ) {
                                        Column(
                                            modifier = Modifier.padding(16.dp),
                                            verticalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {
                                            Surface(
                                                color = MaterialTheme.colorScheme.tertiaryContainer,
                                                shape = RoundedCornerShape(999.dp)
                                            ) {
                                                Text(
                                                    text = "Stanza ${st.stanzaNumber} • पद्यांश ${st.stanzaNumber}",
                                                    style = MaterialTheme.typography.labelMedium,
                                                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                                                    fontWeight = FontWeight.SemiBold,
                                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                                )
                                            }
                                            Surface(
                                                color = MaterialTheme.colorScheme.surfaceVariant,
                                                shape = MaterialTheme.shapes.small
                                            ) {
                                                Text(
                                                    text = st.englishStanza,
                                                    style = MaterialTheme.typography.bodyMedium,
                                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                                    modifier = Modifier.padding(10.dp)
                                                )
                                            }
                                            Text(
                                                text = "हिंदी अनुवाद: ${st.hindiTranslation}",
                                                style = MaterialTheme.typography.bodyLarge
                                            )
                                            Text(
                                                text = "सरल व्याख्या: ${st.simpleHindiExplanation}",
                                                style = MaterialTheme.typography.bodyMedium,
                                                color = MaterialTheme.colorScheme.onSurface
                                            )
                                            Surface(
                                                color = MaterialTheme.colorScheme.secondaryContainer,
                                                shape = MaterialTheme.shapes.small
                                            ) {
                                                Text(
                                                    text = "Poetic Note: ${st.poeticNoteHi}",
                                                    style = MaterialTheme.typography.labelMedium,
                                                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                                                )
                                            }
                                        }
                                    }
                                }
                            } else if (chapter.paragraphExplanations.isEmpty()) {
                                item {
                                    EmptyStateCard(
                                        Icons.AutoMirrored.Rounded.MenuBook,
                                        "No paragraph breakdowns yet",
                                        "Paragraph-wise Hindi explanation will appear here."
                                    )
                                }
                            } else {
                                items(chapter.paragraphExplanations, key = { "para_${chapter.id}_${it.paragraphNumber}" }) { para ->
                                    Card(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .testTag("paragraph_card_${para.paragraphNumber}"),
                                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                                    ) {
                                        Column(
                                            modifier = Modifier.padding(16.dp),
                                            verticalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {
                                            Surface(
                                                color = MaterialTheme.colorScheme.primaryContainer,
                                                shape = RoundedCornerShape(999.dp)
                                            ) {
                                                Text(
                                                    text = "अनुच्छेद ${para.paragraphNumber} • ${para.headingHi}",
                                                    style = MaterialTheme.typography.labelMedium,
                                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                                    fontWeight = FontWeight.SemiBold,
                                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                                )
                                            }
                                            Surface(
                                                color = MaterialTheme.colorScheme.surfaceVariant,
                                                shape = MaterialTheme.shapes.small
                                            ) {
                                                Text(
                                                    text = "English Text: ${para.englishExcerpt}",
                                                    style = MaterialTheme.typography.bodySmall,
                                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                                    modifier = Modifier.padding(10.dp)
                                                )
                                            }
                                            Text(
                                                text = para.simpleHindiExplanation,
                                                style = MaterialTheme.typography.bodyLarge
                                            )
                                            Surface(
                                                color = MaterialTheme.colorScheme.tertiaryContainer,
                                                shape = MaterialTheme.shapes.small
                                            ) {
                                                Text(
                                                    text = "Board Takeaway: ${para.keyTakeawayHi}",
                                                    style = MaterialTheme.typography.labelMedium,
                                                    color = MaterialTheme.colorScheme.onTertiaryContainer,
                                                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        ChapterSection.POETIC_DEVICES -> {
                            val devices = chapter.poemDetails?.poeticDevices.orEmpty()
                            if (devices.isEmpty()) {
                                item {
                                    EmptyStateCard(
                                        Icons.Rounded.AutoStories,
                                        "No poetic devices listed",
                                        "Poetic devices and literary figures appear here for poems."
                                    )
                                }
                            } else {
                                item {
                                    StatusBannerCard(
                                        text = "${devices.size} Key Poetic Devices & Literary Figures in '${chapter.title}'",
                                        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                                        contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                                    )
                                }
                                itemsIndexed(devices, key = { idx, dev -> "dev_${chapter.id}_${idx}_${dev.deviceName}" }) { idx, device ->
                                    Card(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .testTag("poetic_device_card_${idx + 1}"),
                                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                                    ) {
                                        Column(
                                            modifier = Modifier.padding(16.dp),
                                            verticalArrangement = Arrangement.spacedBy(8.dp)
                                        ) {
                                            Text(
                                                text = "${idx + 1}. ${device.deviceName} (${device.deviceNameHi})",
                                                style = MaterialTheme.typography.titleSmall,
                                                color = MaterialTheme.colorScheme.primary
                                            )
                                            Surface(
                                                color = MaterialTheme.colorScheme.surfaceVariant,
                                                shape = MaterialTheme.shapes.small
                                            ) {
                                                Text(
                                                    text = "Example: \"${device.exampleLine}\"",
                                                    style = MaterialTheme.typography.bodyMedium,
                                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                                    modifier = Modifier.padding(10.dp)
                                                )
                                            }
                                            Text(
                                                text = "हिंदी स्पष्टीकरण: ${device.explanationHi}",
                                                style = MaterialTheme.typography.bodyMedium
                                            )
                                        }
                                    }
                                }
                            }
                        }

                        ChapterSection.WORD_MEANINGS -> {
                            if (chapter.wordMeanings.isEmpty()) {
                                item {
                                    EmptyStateCard(Icons.Rounded.Translate, "No word meanings yet", "Check back or add words in Admin Studio.")
                                }
                            } else {
                                item {
                                    StatusBannerCard(
                                        text = "${chapter.wordMeanings.size} Important English Words with Hindi Meanings & Board Usage",
                                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                                        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                                    )
                                }
                                items(chapter.wordMeanings) { wm ->
                                    Card(
                                        modifier = Modifier.fillMaxWidth(),
                                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                                    ) {
                                        Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                                            Row(
                                                modifier = Modifier.fillMaxWidth(),
                                                horizontalArrangement = Arrangement.SpaceBetween
                                            ) {
                                                Text(wm.word, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
                                                Text(wm.partOfSpeech, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.secondary)
                                            }
                                            Text(
                                                text = "${wm.meaningHi}  (${wm.meaningEn})",
                                                style = MaterialTheme.typography.bodyMedium,
                                                fontWeight = FontWeight.Medium
                                            )
                                            if (wm.exampleSentence.isNotBlank()) {
                                                Text("Example: ${wm.exampleSentence}", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        ChapterSection.CHARACTER_SKETCHES -> {
                            if (chapter.characterSketches.isEmpty()) {
                                item {
                                    EmptyStateCard(Icons.Rounded.Person, "No character sketches available", "This chapter focuses on poetic imagery or themes.")
                                }
                            } else {
                                items(chapter.characterSketches, key = { "char_${chapter.id}_${it.name}" }) { cs ->
                                    Card(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .testTag("character_sketch_${cs.name}"),
                                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                                    ) {
                                        Column(
                                            modifier = Modifier.padding(16.dp),
                                            verticalArrangement = Arrangement.spacedBy(10.dp)
                                        ) {
                                            Row(verticalAlignment = Alignment.CenterVertically) {
                                                Surface(
                                                    color = MaterialTheme.colorScheme.primary,
                                                    contentColor = MaterialTheme.colorScheme.onPrimary,
                                                    shape = CircleShape,
                                                    modifier = Modifier.size(42.dp)
                                                ) {
                                                    Box(contentAlignment = Alignment.Center) {
                                                        Text(
                                                            text = cs.name.firstOrNull()?.uppercase() ?: "C",
                                                            style = MaterialTheme.typography.titleMedium,
                                                            fontWeight = FontWeight.Bold
                                                        )
                                                    }
                                                }
                                                Spacer(modifier = Modifier.width(12.dp))
                                                Column(modifier = Modifier.weight(1f)) {
                                                    Text("${cs.name} (${cs.nameHi})", style = MaterialTheme.typography.titleMedium)
                                                    Text(cs.roleHi, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.secondary)
                                                }
                                            }

                                            FlowRow(
                                                horizontalArrangement = Arrangement.spacedBy(6.dp),
                                                verticalArrangement = Arrangement.spacedBy(6.dp)
                                            ) {
                                                cs.traits.forEach { trait ->
                                                    Surface(
                                                        color = MaterialTheme.colorScheme.secondaryContainer,
                                                        shape = RoundedCornerShape(999.dp)
                                                    ) {
                                                        Text(
                                                            text = trait,
                                                            style = MaterialTheme.typography.labelSmall,
                                                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                                                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                                                        )
                                                    }
                                                }
                                            }

                                            Text(
                                                text = "हिंदी चरित्र-चित्रण: ${cs.sketchHi}",
                                                style = MaterialTheme.typography.bodyLarge
                                            )
                                            Surface(
                                                color = MaterialTheme.colorScheme.surfaceVariant,
                                                shape = MaterialTheme.shapes.small
                                            ) {
                                                Text(
                                                    text = "Board Exam Note (English): ${cs.sketchEn}",
                                                    style = MaterialTheme.typography.bodyMedium,
                                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                                    modifier = Modifier.padding(12.dp)
                                                )
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        ChapterSection.IMPORTANT_QA -> {
                            val allImportant = chapter.questions.filter {
                                it.type in listOf(QuestionType.VERY_SHORT, QuestionType.SHORT, QuestionType.LONG, QuestionType.BOARD_PYQ)
                            }
                            val filteredImportant = when (qaTypeFilter) {
                                1 -> allImportant.filter { it.type == QuestionType.LONG || it.type == QuestionType.BOARD_PYQ }
                                2 -> allImportant.filter { it.type == QuestionType.SHORT }
                                3 -> allImportant.filter { it.type == QuestionType.VERY_SHORT }
                                else -> allImportant
                            }
                            item {
                                StatusBannerCard(
                                    text = "${allImportant.size} Important Questions & Answers • Imran Gori Sir Bilingual Notes",
                                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                                    contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            }
                            item {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .horizontalScroll(rememberScrollState()),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    listOf(
                                        0 to "All (${allImportant.size})",
                                        1 to "Board & Long",
                                        2 to "Short Answer",
                                        3 to "Very Short"
                                    ).forEach { (key, label) ->
                                        FilterChip(
                                            selected = qaTypeFilter == key,
                                            onClick = { qaTypeFilter = key },
                                            label = { Text(label) }
                                        )
                                    }
                                }
                            }
                            itemsIndexed(filteredImportant, key = { _, q -> "imp_${q.id}" }) { idx, q ->
                                SubjectiveQuestionCard(
                                    index = idx + 1,
                                    question = q,
                                    bilingualMode = bilingualMode,
                                    isFavourite = q.id in favouriteIds,
                                    onToggleFavourite = { onToggleFavoriteQuestion(q, chapter.title) }
                                )
                            }
                        }

                        ChapterSection.VERY_SHORT -> {
                            val list = chapter.questions.filter { it.type == QuestionType.VERY_SHORT }
                            itemsIndexed(list, key = { _, q -> q.id }) { idx, q ->
                                SubjectiveQuestionCard(idx + 1, q, bilingualMode, q.id in favouriteIds) {
                                    onToggleFavoriteQuestion(q, chapter.title)
                                }
                            }
                        }

                        ChapterSection.SHORT_ANSWER -> {
                            val list = chapter.questions.filter { it.type == QuestionType.SHORT }
                            itemsIndexed(list, key = { _, q -> q.id }) { idx, q ->
                                SubjectiveQuestionCard(idx + 1, q, bilingualMode, q.id in favouriteIds) {
                                    onToggleFavoriteQuestion(q, chapter.title)
                                }
                            }
                        }

                        ChapterSection.LONG_ANSWER -> {
                            val list = chapter.questions.filter { it.type == QuestionType.LONG }
                            itemsIndexed(list, key = { _, q -> q.id }) { idx, q ->
                                SubjectiveQuestionCard(idx + 1, q, bilingualMode, q.id in favouriteIds) {
                                    onToggleFavoriteQuestion(q, chapter.title)
                                }
                            }
                        }

                        ChapterSection.MCQ -> {
                            val allMcqs = chapter.questions.filter { it.type == QuestionType.MCQ }
                            val rangeTabs = if (allMcqs.size > 50) {
                                listOf(
                                    0 to "All (${allMcqs.size})",
                                    1 to "1 – 25",
                                    2 to "26 – 50",
                                    3 to "51 – 75",
                                    4 to "76 – ${allMcqs.size}"
                                )
                            } else {
                                listOf(
                                    0 to "All (${allMcqs.size})",
                                    1 to "1 – 20",
                                    2 to "21 – ${allMcqs.size}"
                                )
                            }
                            val sliceStart = if (allMcqs.size > 50) {
                                when (mcqRangeFilter) {
                                    1 -> 0
                                    2 -> 25
                                    3 -> 50
                                    4 -> 75
                                    else -> 0
                                }
                            } else {
                                when (mcqRangeFilter) {
                                    2 -> 20
                                    else -> 0
                                }
                            }
                            val displayedMcqs = if (allMcqs.size > 50) {
                                when (mcqRangeFilter) {
                                    1 -> allMcqs.drop(0).take(25)
                                    2 -> allMcqs.drop(25).take(25)
                                    3 -> allMcqs.drop(50).take(25)
                                    4 -> allMcqs.drop(75)
                                    else -> allMcqs
                                }
                            } else {
                                when (mcqRangeFilter) {
                                    1 -> allMcqs.drop(0).take(20)
                                    2 -> allMcqs.drop(20)
                                    else -> allMcqs
                                }
                            }
                            item {
                                StatusBannerCard(
                                    text = "${allMcqs.size} Multiple Choice Questions (MCQs) with Answers & Simple Hindi Explanation",
                                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                                    contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                                )
                            }
                            item {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .horizontalScroll(rememberScrollState()),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    rangeTabs.forEach { (key, label) ->
                                        FilterChip(
                                            selected = mcqRangeFilter == key,
                                            onClick = { mcqRangeFilter = key },
                                            label = { Text(label) },
                                            modifier = Modifier.testTag("mcq_range_chip_$key")
                                        )
                                    }
                                }
                            }
                            itemsIndexed(displayedMcqs, key = { _, q -> q.id }) { idx, q ->
                                InteractiveMcqCard(
                                    index = sliceStart + idx + 1,
                                    question = q,
                                    bilingualMode = bilingualMode,
                                    isFavourite = q.id in favouriteIds
                                ) {
                                    onToggleFavoriteQuestion(q, chapter.title)
                                }
                            }
                        }

                        ChapterSection.FILL_BLANKS -> {
                            val list = chapter.questions.filter { it.type == QuestionType.FILL_BLANK }
                            itemsIndexed(list, key = { _, q -> q.id }) { idx, q ->
                                InteractiveFillBlankCard(idx + 1, q, bilingualMode)
                            }
                        }

                        ChapterSection.TRUE_FALSE -> {
                            val list = chapter.questions.filter { it.type == QuestionType.TRUE_FALSE }
                            itemsIndexed(list, key = { _, q -> q.id }) { idx, q ->
                                InteractiveTrueFalseCard(idx + 1, q, bilingualMode)
                            }
                        }

                        ChapterSection.MATCH_FOLLOWING -> {
                            val list = chapter.questions.filter { it.type == QuestionType.MATCH }
                            items(list, key = { it.id }) { q ->
                                InteractiveMatchCard(q, bilingualMode)
                            }
                        }

                        ChapterSection.EXTRACT_BASED -> {
                            val list = chapter.questions.filter { it.type == QuestionType.EXTRACT }
                            itemsIndexed(list, key = { _, q -> q.id }) { idx, q ->
                                SubjectiveQuestionCard(idx + 1, q, bilingualMode, q.id in favouriteIds) {
                                    onToggleFavoriteQuestion(q, chapter.title)
                                }
                            }
                        }

                        ChapterSection.BOARD_QUESTIONS -> {
                            item {
                                Surface(
                                    color = MaterialTheme.colorScheme.tertiaryContainer,
                                    shape = MaterialTheme.shapes.small
                                ) {
                                    Text(
                                        text = "Note: Verified NCERT / MP Board syllabus questions and Practice Bank items are clearly labeled with source tags below.",
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                                        modifier = Modifier.padding(12.dp)
                                    )
                                }
                            }
                            val list = chapter.questions.filter {
                                it.type == QuestionType.BOARD_PYQ || it.sourceTag == QuestionSourceTag.MP_BOARD_VERIFIED || it.sourceTag == QuestionSourceTag.ADMIN_ADDED
                            }
                            itemsIndexed(list, key = { _, q -> "brd_${q.id}" }) { idx, q ->
                                SubjectiveQuestionCard(idx + 1, q, bilingualMode, q.id in favouriteIds) {
                                    onToggleFavoriteQuestion(q, chapter.title)
                                }
                            }
                        }

                        ChapterSection.CHAPTER_TEST -> {
                            val chapterMcqCount = chapter.questions.count { it.type == QuestionType.MCQ }.coerceAtLeast(10)
                            item {
                                Card(
                                    modifier = Modifier.fillMaxWidth(),
                                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                                ) {
                                    Column(
                                        modifier = Modifier.padding(20.dp),
                                        verticalArrangement = Arrangement.spacedBy(12.dp)
                                    ) {
                                        Icon(Icons.Rounded.Quiz, contentDescription = null, tint = MaterialTheme.colorScheme.primary, modifier = Modifier.size(36.dp))
                                        Text(
                                            text = "Chapter-Wise Online Test: ${chapter.title}",
                                            style = MaterialTheme.typography.titleLarge
                                        )
                                        Text(
                                            text = "इस अध्याय की तैयारी परखने के लिए नीचे से अपनी पसंद का टेस्ट चुनें — टाइमर, ऑटो-स्कोरकार्ड और हिंदी व्याख्या सहित!",
                                            style = MaterialTheme.typography.bodyMedium
                                        )

                                        Button(
                                            onClick = {
                                                onMarkSectionCompleted(ChapterSection.CHAPTER_TEST.name)
                                                onLaunchChapterTest(chapter, 10, 10)
                                            },
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(50.dp)
                                                .testTag("start_chapter_test_10_btn")
                                        ) {
                                            Text("Start 10 Questions Quick Test (10 Min)")
                                        }

                                        FilledTonalButton(
                                            onClick = {
                                                onMarkSectionCompleted(ChapterSection.CHAPTER_TEST.name)
                                                onLaunchChapterTest(chapter, 30.coerceAtMost(chapterMcqCount), 25)
                                            },
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(50.dp)
                                                .testTag("start_chapter_test_30_btn")
                                        ) {
                                            Text("Start 30 Questions Board Chapter Test (25 Min)")
                                        }

                                        OutlinedButton(
                                            onClick = {
                                                onMarkSectionCompleted(ChapterSection.CHAPTER_TEST.name)
                                                onLaunchChapterTest(chapter, 100.coerceAtMost(chapterMcqCount), 60)
                                            },
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(50.dp)
                                                .testTag("start_chapter_test_100_btn")
                                        ) {
                                            Text("Start 100 Questions Mega Chapter Exam (60 Min)")
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

@Composable
private fun ContentCardBlock(heading: String, body: String) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(heading, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
            Text(body, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

private fun sectionDisplayLabel(section: ChapterSection, isPoem: Boolean): String = when {
    isPoem && section == ChapterSection.CHAPTER_LIST -> "Poems List"
    isPoem && section == ChapterSection.SUMMARY -> "Central Idea & Summary"
    isPoem && section == ChapterSection.THEME_AND_POET -> "Poet Intro & Theme"
    !isPoem && section == ChapterSection.THEME_AND_POET -> "Theme & Message"
    isPoem && section == ChapterSection.HINDI_EXPLANATION -> "Hindi Translation"
    isPoem && section == ChapterSection.PARAGRAPH_EXPLANATION -> "Stanza-wise Hindi"
    !isPoem && section == ChapterSection.PARAGRAPH_EXPLANATION -> "Paragraph Hindi"
    isPoem && section == ChapterSection.WORD_MEANINGS -> "Difficult Words"
    else -> section.titleEn
}

private fun sectionDisplayHi(section: ChapterSection, isPoem: Boolean): String = when {
    isPoem && section == ChapterSection.CHAPTER_LIST -> "इस पुस्तक की सभी कविताएँ"
    isPoem && section == ChapterSection.SUMMARY -> "कविता का केंद्रीय भाव व हिंदी सारांश"
    isPoem && section == ChapterSection.THEME_AND_POET -> "कवि परिचय, केंद्रीय भाव व विषय"
    !isPoem && section == ChapterSection.THEME_AND_POET -> "मुख्य विषय एवं नैतिक संदेश"
    isPoem && section == ChapterSection.HINDI_EXPLANATION -> "संपूर्ण हिंदी अनुवाद एवं भावार्थ"
    isPoem && section == ChapterSection.PARAGRAPH_EXPLANATION -> "पद्यांश-वार (Stanza-wise) सरल हिंदी व्याख्या"
    !isPoem && section == ChapterSection.PARAGRAPH_EXPLANATION -> "अनुच्छेद-वार सरल हिंदी व्याख्या"
    else -> section.titleHi
}

