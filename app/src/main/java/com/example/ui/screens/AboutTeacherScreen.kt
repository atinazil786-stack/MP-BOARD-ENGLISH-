package com.example.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material.icons.rounded.AutoStories
import androidx.compose.material.icons.rounded.EditNote
import androidx.compose.material.icons.rounded.PhotoCamera
import androidx.compose.material.icons.rounded.School
import androidx.compose.material.icons.rounded.Spellcheck
import androidx.compose.material.icons.rounded.Verified
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ui.components.TeacherCircularAvatar
import com.example.ui.theme.RoyalIndigo
import com.example.ui.theme.RoyalIndigoDark
import com.example.ui.theme.SaffronGoldLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutTeacherScreen(
    teacherPhotoBase64: String,
    bilingualMode: Boolean,
    totalChaptersCount: Int,
    isAdmin: Boolean,
    onOpenAskAi: () -> Unit,
    onOpenAdminPhotoManager: () -> Unit,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("About Teacher • शिक्षक परिचय", style = MaterialTheme.typography.titleMedium)
                        Text(
                            "IMRAN GORI SIR • MP BOARD ENGLISH HUB",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack, modifier = Modifier.testTag("about_teacher_back_button")) {
                        Icon(Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back from About Teacher")
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .testTag("about_teacher_screen"),
            contentAlignment = Alignment.TopCenter
        ) {
            LazyColumn(
                modifier = Modifier
                    .widthIn(max = 760.dp)
                    .fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Hero Educator Portrait Card
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(24.dp),
                        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    Brush.verticalGradient(
                                        colors = listOf(RoyalIndigoDark, RoyalIndigo)
                                    )
                                )
                                .padding(24.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            TeacherCircularAvatar(
                                customPhotoBase64 = teacherPhotoBase64,
                                size = 124.dp,
                                borderColor = SaffronGoldLight,
                                borderWidth = 3.dp,
                                showVerifiedBadge = true,
                                contentDescription = "Imran Gori Sir official circular portrait",
                                modifier = Modifier.testTag("about_teacher_avatar")
                            )

                            Spacer(modifier = Modifier.height(4.dp))

                            Text(
                                text = "IMRAN GORI SIR",
                                style = MaterialTheme.typography.titleLarge,
                                color = SaffronGoldLight,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                            Text(
                                text = "MP BOARD ENGLISH HUB",
                                style = MaterialTheme.typography.headlineSmall,
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center
                            )
                            Surface(
                                color = Color.White.copy(alpha = 0.14f),
                                shape = RoundedCornerShape(999.dp)
                            ) {
                                Text(
                                    text = "Learn English Smartly – Score Higher!",
                                    style = MaterialTheme.typography.labelLarge,
                                    color = Color.White,
                                    modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp)
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(6.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Rounded.Verified,
                                    contentDescription = null,
                                    tint = SaffronGoldLight,
                                    modifier = Modifier.size(16.dp)
                                )
                                Text(
                                    text = "Official Educator & Founder • MPBSE Class 9th–12th",
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Color.White.copy(alpha = 0.9f)
                                )
                            }
                        }
                    }
                }

                // Educator Highlights Grid
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        TeacherStatTile(
                            icon = Icons.Rounded.AutoStories,
                            value = "$totalChaptersCount Units",
                            label = "NCERT/MPBSE Syllabus",
                            modifier = Modifier.weight(1f)
                        )
                        TeacherStatTile(
                            icon = Icons.Rounded.Spellcheck,
                            value = "16 Topics",
                            label = "Bilingual Grammar",
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        TeacherStatTile(
                            icon = Icons.Rounded.EditNote,
                            value = "15 Skills",
                            label = "Board Writing Mastery",
                            modifier = Modifier.weight(1f)
                        )
                        TeacherStatTile(
                            icon = Icons.Rounded.School,
                            value = "2022–2026",
                            label = "Verified PYQ Archive",
                            modifier = Modifier.weight(1f)
                        )
                    }
                }

                // About Teacher Bio (English & Hindi)
                item {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                    ) {
                        Column(
                            modifier = Modifier.padding(18.dp),
                            verticalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Text(
                                text = "About Imran Gori Sir",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.primary
                            )
                            Text(
                                text = "Imran Gori Sir is the creator and lead English educator of MP Board English Hub, dedicated to empowering Madhya Pradesh Board students from Class 9th to 12th with crystal-clear bilingual lessons, exam-oriented notes, and smart board preparation.",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.onSurface
                            )
                            if (bilingualMode) {
                                Surface(
                                    color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.65f),
                                    shape = RoundedCornerShape(14.dp)
                                ) {
                                    Column(
                                        modifier = Modifier.padding(14.dp),
                                        verticalArrangement = Arrangement.spacedBy(6.dp)
                                    ) {
                                        Text(
                                            text = "शिक्षक संदेश (Hindi Introduction):",
                                            style = MaterialTheme.typography.labelLarge,
                                            color = MaterialTheme.colorScheme.primary,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(
                                            text = "इमरान गोरी सर का उद्देश्य मध्य प्रदेश बोर्ड (कक्षा 9वीं से 12वीं) के प्रत्येक विद्यार्थी को सरल हिंदी व अंग्रेजी में संपूर्ण NCERT पाठ्यक्रम, कविताएँ, ग्रामर, राइटिंग स्किल्स और बोर्ड परीक्षा के महत्वपूर्ण प्रश्नों की सटीक तैयारी कराना है—ताकि हर छात्र आत्मविश्वास से उच्च अंक प्राप्त कर सके।",
                                            style = MaterialTheme.typography.bodyMedium,
                                            color = MaterialTheme.colorScheme.onSurface
                                        )
                                    }
                                }
                            }
                        }
                    }
                }

                // Action Buttons
                item {
                    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Button(
                            onClick = onOpenAskAi,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .testTag("about_teacher_ask_ai_button")
                        ) {
                            Icon(Icons.Rounded.AutoAwesome, contentDescription = null)
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("Ask Imran Sir AI Tutor")
                        }
                        if (isAdmin) {
                            OutlinedButton(
                                onClick = onOpenAdminPhotoManager,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                                    .testTag("about_teacher_change_photo_button")
                            ) {
                                Icon(Icons.Rounded.PhotoCamera, contentDescription = null)
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Change Teacher Photo in Admin Panel")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun TeacherStatTile(
    icon: ImageVector,
    value: String,
    label: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Surface(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(12.dp)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.padding(10.dp).size(20.dp)
                )
            }
            Column {
                Text(value, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text(label, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
    }
}
