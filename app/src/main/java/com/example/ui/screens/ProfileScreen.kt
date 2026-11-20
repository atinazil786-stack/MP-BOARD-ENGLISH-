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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.Logout
import androidx.compose.material.icons.rounded.AdminPanelSettings
import androidx.compose.material.icons.rounded.Bookmark
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.School
import androidx.compose.material.icons.rounded.TrendingUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.curriculum.QuestionBankAndVocab
import com.example.data.model.BookmarkDoc
import com.example.data.model.Chapter
import com.example.data.model.StudyProgressDoc
import com.example.data.model.TestResultDoc
import com.example.ui.components.EmptyStateCard
import com.example.ui.components.TeacherCircularAvatar
import com.example.ui.theme.SaffronGoldLight

@Composable
fun ProfileScreen(
    displayName: String,
    email: String?,
    selectedClass: Int,
    darkMode: Boolean,
    bilingualMode: Boolean,
    streakCount: Int,
    testsTaken: Int,
    isAdmin: Boolean,
    teacherPhotoBase64: String = "",
    chapters: List<Chapter>,
    bookmarks: List<BookmarkDoc>,
    progressList: List<StudyProgressDoc>,
    testHistory: List<TestResultDoc>,
    onSelectClass: (Int) -> Unit,
    onToggleDarkMode: (Boolean) -> Unit,
    onToggleBilingualMode: (Boolean) -> Unit,
    onRemoveBookmark: (BookmarkDoc) -> Unit,
    onOpenChapterById: (String) -> Unit,
    onOpenAboutTeacher: () -> Unit = {},
    onOpenAskAi: () -> Unit = {},
    onOpenAdminStudio: () -> Unit,
    onSignOut: () -> Unit
) {
    var selectedTab by remember { mutableIntStateOf(0) }
    val tabs = listOf("Progress", "Favourites", "Bookmarks", "History", "Vocab")

    val favouriteQuestions = remember(bookmarks) { bookmarks.filter { it.itemType == "question" } }
    val bookmarkedChapters = remember(bookmarks) { bookmarks.filter { it.itemType == "chapter" } }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        LazyColumn(
            modifier = Modifier
                .widthIn(max = 760.dp)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Student Profile Header Card
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Surface(
                            color = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary,
                            shape = CircleShape,
                            modifier = Modifier.size(54.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Text(
                                    text = displayName.firstOrNull()?.uppercase() ?: "S",
                                    style = MaterialTheme.typography.headlineSmall
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(12.dp))
                        Column(modifier = Modifier.weight(1f)) {
                            Text(displayName, style = MaterialTheme.typography.titleLarge)
                            if (!email.isNullOrBlank()) {
                                Text(
                                    email,
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            Text(
                                "Class ${selectedClass}th • $streakCount Day Streak • $testsTaken Tests",
                                style = MaterialTheme.typography.labelMedium,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }

            // Teacher Profile Card (Visible to all students & educators)
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("teacher_profile_card"),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.38f))
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            TeacherCircularAvatar(
                                customPhotoBase64 = teacherPhotoBase64,
                                size = 76.dp,
                                borderColor = SaffronGoldLight,
                                borderWidth = 2.5.dp,
                                showVerifiedBadge = true,
                                contentDescription = "Imran Gori Sir teacher profile photo",
                                modifier = Modifier.testTag("teacher_profile_avatar")
                            )
                            Spacer(modifier = Modifier.width(14.dp))
                            Column(
                                modifier = Modifier.weight(1f),
                                verticalArrangement = Arrangement.spacedBy(3.dp)
                            ) {
                                Surface(
                                    color = MaterialTheme.colorScheme.primaryContainer,
                                    shape = RoundedCornerShape(999.dp)
                                ) {
                                    Text(
                                        text = "Teacher Profile • शिक्षक प्रोफ़ाइल",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                    )
                                }
                                Text(
                                    text = "IMRAN GORI SIR",
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Text(
                                    text = "MP BOARD ENGLISH HUB",
                                    style = MaterialTheme.typography.labelMedium,
                                    fontWeight = FontWeight.SemiBold
                                )
                                Text(
                                    text = "Educator & Mentor • Class 9th–12th MPBSE (English & हिंदी)",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Button(
                                onClick = onOpenAboutTeacher,
                                modifier = Modifier
                                    .weight(1f)
                                    .height(48.dp)
                                    .testTag("profile_about_teacher_button")
                            ) {
                                Text("About Teacher", maxLines = 1)
                            }
                            OutlinedButton(
                                onClick = onOpenAskAi,
                                modifier = Modifier
                                    .weight(1f)
                                    .height(48.dp)
                            ) {
                                Text("Ask Imran Sir AI", maxLines = 1)
                            }
                        }
                    }
                }
            }

            // Student Class Selector & Theme Preferences
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        Text("Student Preferences", style = MaterialTheme.typography.titleMedium)

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .horizontalScroll(rememberScrollState()),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            listOf(9, 10, 11, 12).forEach { lvl ->
                                FilterChip(
                                    selected = selectedClass == lvl,
                                    onClick = { onSelectClass(lvl) },
                                    label = { Text("Class ${lvl}th") },
                                    leadingIcon = { Icon(Icons.Rounded.School, contentDescription = null, modifier = Modifier.size(16.dp)) }
                                )
                            }
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text("Dark Mode", style = MaterialTheme.typography.titleSmall)
                                Text("Comfortable night reading theme", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                            Switch(
                                checked = darkMode,
                                onCheckedChange = onToggleDarkMode,
                                modifier = Modifier.testTag("dark_mode_switch")
                            )
                        }

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text("Bilingual Hindi + English", style = MaterialTheme.typography.titleSmall)
                                Text("Show Hindi explanations alongside English", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                            Switch(
                                checked = bilingualMode,
                                onCheckedChange = onToggleBilingualMode,
                                modifier = Modifier.testTag("bilingual_mode_switch")
                            )
                        }
                    }
                }
            }

            // Admin Content Management Access Card
            item {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("profile_admin_card"),
                    colors = CardDefaults.cardColors(
                        containerColor = if (isAdmin) MaterialTheme.colorScheme.secondaryContainer
                        else MaterialTheme.colorScheme.surfaceVariant
                    ),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            TeacherCircularAvatar(
                                customPhotoBase64 = teacherPhotoBase64,
                                size = 48.dp,
                                borderColor = MaterialTheme.colorScheme.primary,
                                borderWidth = 2.dp,
                                showVerifiedBadge = isAdmin
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            Column(modifier = Modifier.weight(1f)) {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Icon(
                                        imageVector = if (isAdmin) Icons.Rounded.AdminPanelSettings else Icons.Rounded.Lock,
                                        contentDescription = null,
                                        tint = MaterialTheme.colorScheme.primary,
                                        modifier = Modifier.size(18.dp)
                                    )
                                    Spacer(modifier = Modifier.width(6.dp))
                                    Text("Admin Profile • IMRAN GORI SIR", style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
                                }
                                Text(
                                    text = "MP BOARD ENGLISH HUB",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                        if (isAdmin) {
                            Text(
                                "Verified Admin Access: Manage teacher profile photo, chapters, Q&A, MCQs, grammar lessons, PDFs, and test papers.",
                                style = MaterialTheme.typography.bodySmall
                            )
                            Button(
                                onClick = onOpenAdminStudio,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(48.dp)
                                    .testTag("open_admin_button")
                            ) {
                                Text("Open Admin Studio & Photo")
                            }
                        } else {
                            Text(
                                "Restricted to authorized educator account (Imran Gori Sir).",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            // Student Hub Tabs
            item {
                TabRow(selectedTabIndex = selectedTab) {
                    tabs.forEachIndexed { idx, label ->
                        Tab(
                            selected = selectedTab == idx,
                            onClick = { selectedTab = idx },
                            text = { Text(label, maxLines = 1) }
                        )
                    }
                }
            }

            when (selectedTab) {
                0 -> {
                    val classChapters = chapters.filter { it.classLevel == selectedClass }
                    if (progressList.isEmpty()) {
                        item {
                            EmptyStateCard(
                                icon = Icons.Rounded.TrendingUp,
                                title = "Start studying Class ${selectedClass}th chapters",
                                subtitle = "Tap 'Mark Read' inside any chapter section to track your board preparation mastery."
                            )
                        }
                    } else {
                        items(classChapters, key = { it.id }) { ch ->
                            val prog = progressList.firstOrNull { it.chapterId == ch.id }
                            val mastery = prog?.masteryPercent?.toInt() ?: 0
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { onOpenChapterById(ch.id) },
                                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                            ) {
                                Column(modifier = Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Text(ch.title, style = MaterialTheme.typography.titleSmall)
                                        Text("$mastery%", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
                                    }
                                    LinearProgressIndicator(
                                        progress = { mastery / 100f },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(6.dp)
                                            .clip(RoundedCornerShape(999.dp))
                                    )
                                }
                            }
                        }
                    }
                }

                1 -> {
                    if (favouriteQuestions.isEmpty()) {
                        item {
                            EmptyStateCard(
                                icon = Icons.Rounded.Favorite,
                                title = "No Favourite Questions Yet",
                                subtitle = "Tap the heart icon on any textbook or grammar question to save it for quick exam revision."
                            )
                        }
                    } else {
                        items(favouriteQuestions, key = { it.id }) { fav ->
                            SavedItemCard(
                                title = fav.title,
                                subtitle = fav.subtitle,
                                onOpen = null,
                                onDelete = { onRemoveBookmark(fav) }
                            )
                        }
                    }
                }

                2 -> {
                    if (bookmarkedChapters.isEmpty()) {
                        item {
                            EmptyStateCard(
                                icon = Icons.Rounded.Bookmark,
                                title = "No Bookmarked Chapters",
                                subtitle = "Bookmark chapters from the Classes tab for one-tap revision."
                            )
                        }
                    } else {
                        items(bookmarkedChapters, key = { it.id }) { bm ->
                            SavedItemCard(
                                title = bm.title,
                                subtitle = bm.subtitle,
                                onOpen = { onOpenChapterById(bm.targetId) },
                                onDelete = { onRemoveBookmark(bm) }
                            )
                        }
                    }
                }

                3 -> {
                    if (testHistory.isEmpty()) {
                        item {
                            EmptyStateCard(
                                icon = Icons.Rounded.History,
                                title = "No Test History Yet",
                                subtitle = "Complete a 20Q, 50Q, 100Q, Chapter Test, or Daily Quiz to see your score progression."
                            )
                        }
                    } else {
                        items(testHistory, key = { it.id }) { res ->
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
                                        Text(res.testTitle, style = MaterialTheme.typography.titleSmall)
                                        Text(
                                            "Class ${res.classLevel}th • ${res.correctCount}/${res.totalQuestions} Correct",
                                            style = MaterialTheme.typography.bodySmall,
                                            color = MaterialTheme.colorScheme.onSurfaceVariant
                                        )
                                    }
                                    Surface(
                                        color = MaterialTheme.colorScheme.primaryContainer,
                                        shape = RoundedCornerShape(10.dp)
                                    ) {
                                        Text(
                                            text = "${res.percentage}%",
                                            style = MaterialTheme.typography.titleMedium,
                                            color = MaterialTheme.colorScheme.primary,
                                            fontWeight = FontWeight.Bold,
                                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                4 -> {
                    items(QuestionBankAndVocab.dailyVocabulary, key = { it.id }) { word ->
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
                                    Text(word.word, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.primary)
                                    Text(word.pronunciation, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.secondary)
                                }
                                Text("${word.meaningEn} — ${word.meaningHi}", style = MaterialTheme.typography.bodyMedium)
                                Text("Ex: ${word.exampleEn}", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }
                    }
                }
            }

            // Sign Out Action
            item {
                Spacer(modifier = Modifier.height(4.dp))
                OutlinedButton(
                    onClick = onSignOut,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .testTag("sign_out_button")
                ) {
                    Icon(Icons.AutoMirrored.Rounded.Logout, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text("Sign Out")
                }
            }
        }
    }
}

@Composable
private fun SavedItemCard(
    title: String,
    subtitle: String,
    onOpen: (() -> Unit)?,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .then(if (onOpen != null) Modifier.clickable(onClick = onOpen) else Modifier),
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
                if (subtitle.isNotBlank()) {
                    Text(subtitle, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
            IconButton(onClick = onDelete) {
                Icon(Icons.Rounded.Delete, contentDescription = "Remove saved item")
            }
        }
    }
}
