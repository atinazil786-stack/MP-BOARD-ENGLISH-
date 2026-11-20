package com.example.ui.screens

import android.content.Context
import android.net.Uri
import android.provider.OpenableColumns
import android.util.Base64
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Assessment
import androidx.compose.material.icons.rounded.AttachFile
import androidx.compose.material.icons.rounded.Verified
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
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
import com.example.data.model.AdminVideoLinkDoc
import com.example.data.model.AdminWritingMaterialDoc
import com.example.data.model.Chapter
import com.example.data.model.StudentTestSummaryDoc
import com.example.ui.components.EmptyStateCard
import com.example.ui.components.StatusBannerCard

private const val MAX_INLINE_PDF_BYTES = 450 * 1024

private fun readPickedPdf(context: Context, uri: Uri): Triple<String, String, String?> {
    var fileName = "document.pdf"
    context.contentResolver.query(uri, arrayOf(OpenableColumns.DISPLAY_NAME), null, null, null)?.use { cursor ->
        if (cursor.moveToFirst()) {
            val idx = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            if (idx >= 0) fileName = cursor.getString(idx) ?: fileName
        }
    }
    val bytes = context.contentResolver.openInputStream(uri)?.use { it.readBytes() }
        ?: return Triple(fileName, "", "Unable to read the selected PDF file.")
    if (bytes.size > MAX_INLINE_PDF_BYTES) {
        return Triple(
            fileName,
            "",
            "PDF is ${(bytes.size / 1024)} KB (limit 450 KB for direct upload). Compress it or paste an external PDF link below."
        )
    }
    val b64 = Base64.encodeToString(bytes, Base64.NO_WRAP)
    return Triple(fileName, b64, null)
}

@Composable
internal fun AdminPdfNotesTab(
    isBusy: Boolean,
    pdfNotes: List<AdminPdfNoteDoc>,
    chapters: List<Chapter>,
    onSave: (String?, Int, String, String, String, String, String, String) -> Unit,
    onDelete: (String) -> Unit
) {
    val context = LocalContext.current
    var editingId by remember { mutableStateOf<String?>(null) }
    var classLevel by remember { mutableIntStateOf(10) }
    var chapterId by remember { mutableStateOf("c10_ff_1") }
    var title by remember { mutableStateOf("") }
    var summaryHi by remember { mutableStateOf("") }
    var pdfFileName by remember { mutableStateOf("") }
    var pdfUrl by remember { mutableStateOf("") }
    var pdfBase64 by remember { mutableStateOf("") }

    val pdfPicker = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
        if (uri != null) {
            val (name, b64, err) = readPickedPdf(context, uri)
            if (err != null) {
                Toast.makeText(context, err, Toast.LENGTH_LONG).show()
            } else {
                pdfFileName = name
                pdfBase64 = b64
                Toast.makeText(context, "Attached $name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    val classChapters = remember(chapters, classLevel) {
        chapters.filter { it.classLevel == classLevel }.take(8)
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(if (editingId == null) "Upload PDF Revision Notes" else "Edit PDF Notes", style = MaterialTheme.typography.titleMedium)
                Row(modifier = Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf(9, 10, 11, 12).forEach { cls ->
                        FilterChip(selected = classLevel == cls, onClick = { classLevel = cls }, label = { Text("Class $cls") })
                    }
                }
                Row(modifier = Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    FilterChip(selected = chapterId == "general", onClick = { chapterId = "general" }, label = { Text("All Chapters") })
                    classChapters.forEach { ch ->
                        FilterChip(selected = chapterId == ch.id, onClick = { chapterId = ch.id }, label = { Text("Ch ${ch.chapterNumber}") })
                    }
                }
                OutlinedTextField(value = chapterId, onValueChange = { chapterId = it }, label = { Text("Target Chapter ID") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("PDF Notes Title") }, modifier = Modifier.fillMaxWidth().testTag("admin_pdf_title_input"))
                OutlinedTextField(value = summaryHi, onValueChange = { summaryHi = it }, label = { Text("Hindi Note / Summary (optional)") }, minLines = 2, modifier = Modifier.fillMaxWidth())
                OutlinedButton(
                    onClick = { pdfPicker.launch(arrayOf("application/pdf")) },
                    modifier = Modifier.fillMaxWidth().height(48.dp)
                ) {
                    Icon(Icons.Rounded.AttachFile, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(if (pdfBase64.isNotBlank()) "Attached: $pdfFileName (${pdfBase64.length / 1024} KB)" else "Pick PDF File (Max 450 KB)")
                }
                OutlinedTextField(value = pdfUrl, onValueChange = { pdfUrl = it }, label = { Text("Or External PDF URL (Google Drive / Website)") }, modifier = Modifier.fillMaxWidth())

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(
                        enabled = !isBusy && title.isNotBlank() && (pdfBase64.isNotBlank() || pdfUrl.isNotBlank()),
                        onClick = {
                            onSave(editingId, classLevel, chapterId, title, summaryHi, pdfFileName, pdfUrl, pdfBase64)
                            editingId = null; title = ""; summaryHi = ""; pdfFileName = ""; pdfUrl = ""; pdfBase64 = ""
                        },
                        modifier = Modifier.weight(1f).height(48.dp)
                    ) {
                        Text(if (editingId == null) "Publish PDF Notes" else "Update PDF Notes")
                    }
                    if (editingId != null) {
                        OutlinedButton(onClick = { editingId = null; title = ""; pdfBase64 = "" }, modifier = Modifier.height(48.dp)) { Text("Cancel") }
                    }
                }
            }
        }

        pdfNotes.forEach { note ->
            AdminItemRow(
                title = note.title,
                subtitle = "Class ${note.classLevel} • ${note.chapterId} • ${note.pdfFileName.ifBlank { "URL Link" }}",
                onEdit = {
                    editingId = note.id; classLevel = note.classLevel.toInt(); chapterId = note.chapterId
                    title = note.title; summaryHi = note.summaryHi; pdfFileName = note.pdfFileName
                    pdfUrl = note.pdfUrl; pdfBase64 = note.pdfBase64
                },
                onDelete = { onDelete(note.id) }
            )
        }
    }
}

@Composable
internal fun AdminPyqPapersTab(
    isBusy: Boolean,
    papers: List<AdminPreviousPaperDoc>,
    onSave: (String?, Int, Int, String, String, Boolean, String, String, String, String, String) -> Unit,
    onDelete: (String) -> Unit
) {
    val context = LocalContext.current
    var editingId by remember { mutableStateOf<String?>(null) }
    var classLevel by remember { mutableIntStateOf(10) }
    var year by remember { mutableIntStateOf(2025) }
    var title by remember { mutableStateOf("") }
    var setCode by remember { mutableStateOf("Set A") }
    var isVerifiedPyq by remember { mutableStateOf(true) }
    var summaryHi by remember { mutableStateOf("") }
    var pdfFileName by remember { mutableStateOf("") }
    var pdfUrl by remember { mutableStateOf("") }
    var pdfBase64 by remember { mutableStateOf("") }
    var rawQuestions by remember { mutableStateOf("") }

    val pdfPicker = rememberLauncherForActivityResult(ActivityResultContracts.OpenDocument()) { uri ->
        if (uri != null) {
            val (name, b64, err) = readPickedPdf(context, uri)
            if (err != null) {
                Toast.makeText(context, err, Toast.LENGTH_LONG).show()
            } else {
                pdfFileName = name
                pdfBase64 = b64
                Toast.makeText(context, "Attached $name", Toast.LENGTH_SHORT).show()
            }
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        StatusBannerCard(
            text = "Honesty Policy: Only mark 'Verified Original PYQ' for genuine scanned/official MPBSE papers. Never label AI-generated questions as official previous year questions.",
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        )
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(if (editingId == null) "Upload Previous Year Paper" else "Edit Question Paper", style = MaterialTheme.typography.titleMedium)
                Row(modifier = Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf(9, 10, 11, 12).forEach { cls ->
                        FilterChip(selected = classLevel == cls, onClick = { classLevel = cls }, label = { Text("Class $cls") })
                    }
                }
                Row(modifier = Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf(2022, 2023, 2024, 2025, 2026).forEach { yr ->
                        FilterChip(
                            selected = year == yr,
                            onClick = {
                                year = yr
                                if (yr == 2026) isVerifiedPyq = false
                            },
                            label = { Text("$yr") }
                        )
                    }
                }
                OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Paper Title (e.g., MPBSE English Main 2024)") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = setCode, onValueChange = { setCode = it }, label = { Text("Set Code (e.g., Set A / Blueprint)") }, modifier = Modifier.fillMaxWidth())
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                        Icon(Icons.Rounded.Verified, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Verified Official MPBSE Paper", style = MaterialTheme.typography.bodyMedium)
                    }
                    Switch(checked = isVerifiedPyq, onCheckedChange = { isVerifiedPyq = it })
                }
                OutlinedTextField(value = summaryHi, onValueChange = { summaryHi = it }, label = { Text("Hindi Overview / Notes") }, minLines = 2, modifier = Modifier.fillMaxWidth())
                OutlinedButton(
                    onClick = { pdfPicker.launch(arrayOf("application/pdf")) },
                    modifier = Modifier.fillMaxWidth().height(48.dp)
                ) {
                    Icon(Icons.Rounded.AttachFile, contentDescription = null)
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(if (pdfBase64.isNotBlank()) "PDF Attached: $pdfFileName" else "Pick Original Question Paper PDF (Max 450 KB)")
                }
                OutlinedTextField(value = pdfUrl, onValueChange = { pdfUrl = it }, label = { Text("Or External Paper PDF URL") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(
                    value = rawQuestions,
                    onValueChange = { rawQuestions = it },
                    label = { Text("Questions & Keys (1/line: TYPE::Question::Answer::Hindi::Chapter)") },
                    minLines = 3,
                    modifier = Modifier.fillMaxWidth()
                )
                Button(
                    enabled = !isBusy && title.isNotBlank(),
                    onClick = {
                        onSave(editingId, classLevel, year, title, setCode, isVerifiedPyq, summaryHi, pdfFileName, pdfUrl, pdfBase64, rawQuestions)
                        editingId = null; title = ""; summaryHi = ""; pdfFileName = ""; pdfUrl = ""; pdfBase64 = ""; rawQuestions = ""
                    },
                    modifier = Modifier.fillMaxWidth().height(48.dp)
                ) {
                    Text(if (editingId == null) "Publish Question Paper" else "Update Question Paper")
                }
            }
        }

        papers.forEach { p ->
            AdminItemRow(
                title = "${p.year} • Class ${p.classLevel} • ${p.title}",
                subtitle = "${p.setCode} • ${if (p.isVerifiedPyq) "Verified PYQ" else "Blueprint"} • ${p.pdfFileName.ifBlank { "Online Format" }}",
                onEdit = {
                    editingId = p.id; classLevel = p.classLevel.toInt(); year = p.year.toInt(); title = p.title
                    setCode = p.setCode; isVerifiedPyq = p.isVerifiedPyq; summaryHi = p.summaryHi
                    pdfFileName = p.pdfFileName; pdfUrl = p.pdfUrl; pdfBase64 = p.pdfBase64
                    rawQuestions = p.questionsFormatted.joinToString("\n")
                },
                onDelete = { onDelete(p.id) }
            )
        }
    }
}

@Composable
internal fun AdminVideoLinksTab(
    isBusy: Boolean,
    videoLinks: List<AdminVideoLinkDoc>,
    chapters: List<Chapter>,
    onSave: (String?, Int, String, String, String, String) -> Unit,
    onDelete: (String) -> Unit
) {
    var editingId by remember { mutableStateOf<String?>(null) }
    var classLevel by remember { mutableIntStateOf(10) }
    var chapterId by remember { mutableStateOf("c10_ff_1") }
    var title by remember { mutableStateOf("") }
    var summaryHi by remember { mutableStateOf("") }
    var videoUrl by remember { mutableStateOf("") }

    val classChapters = remember(chapters, classLevel) {
        chapters.filter { it.classLevel == classLevel }.take(8)
    }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(if (editingId == null) "Add Animated / Explanation Video Link" else "Edit Video Link", style = MaterialTheme.typography.titleMedium)
                Row(modifier = Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf(9, 10, 11, 12).forEach { cls ->
                        FilterChip(selected = classLevel == cls, onClick = { classLevel = cls }, label = { Text("Class $cls") })
                    }
                }
                Row(modifier = Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    classChapters.forEach { ch ->
                        FilterChip(selected = chapterId == ch.id, onClick = { chapterId = ch.id }, label = { Text("Ch ${ch.chapterNumber}") })
                    }
                }
                OutlinedTextField(value = chapterId, onValueChange = { chapterId = it }, label = { Text("Chapter ID") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Video Title") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = videoUrl, onValueChange = { videoUrl = it }, label = { Text("Video URL (YouTube / MP4 Link)") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = summaryHi, onValueChange = { summaryHi = it }, label = { Text("Hindi Summary / Topics Covered") }, minLines = 2, modifier = Modifier.fillMaxWidth())
                Button(
                    enabled = !isBusy && title.isNotBlank() && videoUrl.isNotBlank(),
                    onClick = {
                        onSave(editingId, classLevel, chapterId, title, summaryHi, videoUrl)
                        editingId = null; title = ""; summaryHi = ""; videoUrl = ""
                    },
                    modifier = Modifier.fillMaxWidth().height(48.dp)
                ) {
                    Text(if (editingId == null) "Publish Video Link" else "Update Video Link")
                }
            }
        }

        videoLinks.forEach { vid ->
            AdminItemRow(
                title = vid.title,
                subtitle = "Class ${vid.classLevel} • ${vid.chapterId} • ${vid.videoUrl.take(40)}",
                onEdit = {
                    editingId = vid.id; classLevel = vid.classLevel.toInt(); chapterId = vid.chapterId
                    title = vid.title; summaryHi = vid.summaryHi; videoUrl = vid.videoUrl
                },
                onDelete = { onDelete(vid.id) }
            )
        }
    }
}

@Composable
internal fun AdminWritingTab(
    isBusy: Boolean,
    materials: List<AdminWritingMaterialDoc>,
    onSave: (String?, String, String, String, List<Int>, String, String, String, String, String, String) -> Unit,
    onDelete: (String) -> Unit
) {
    var editingId by remember { mutableStateOf<String?>(null) }
    var category by remember { mutableStateOf("Notice Writing") }
    var selectedClasses by remember { mutableStateOf(listOf(9, 10, 11, 12)) }
    var title by remember { mutableStateOf("") }
    var titleHi by remember { mutableStateOf("") }
    var explanationHi by remember { mutableStateOf("") }
    var formatTemplate by remember { mutableStateOf("") }
    var solvedEn by remember { mutableStateOf("") }
    var solvedHi by remember { mutableStateOf("") }
    var examQuestion by remember { mutableStateOf("") }
    var modelAnswer by remember { mutableStateOf("") }

    val categories = listOf(
        "Notice Writing", "Formal Application Writing", "Informal Letter Writing",
        "Formal Letter Writing", "Poster Making", "Advertisement Writing",
        "Report Writing", "Article Writing", "Speech Writing", "Essay Writing", "Note Making"
    )

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Card(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
        ) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(if (editingId == null) "Add Writing Skills Material" else "Edit Writing Material", style = MaterialTheme.typography.titleMedium)
                Row(modifier = Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    categories.forEach { cat ->
                        FilterChip(selected = category == cat, onClick = { category = cat }, label = { Text(cat) })
                    }
                }
                Row(modifier = Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf(9, 10, 11, 12).forEach { cls ->
                        val picked = cls in selectedClasses
                        FilterChip(
                            selected = picked,
                            onClick = {
                                val next = if (picked) selectedClasses - cls else (selectedClasses + cls).sorted()
                                if (next.isNotEmpty()) selectedClasses = next
                            },
                            label = { Text("Class $cls") }
                        )
                    }
                }
                OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Title (English)") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = titleHi, onValueChange = { titleHi = it }, label = { Text("Title (Hindi)") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = explanationHi, onValueChange = { explanationHi = it }, label = { Text("Simple Hindi Explanation") }, minLines = 3, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = formatTemplate, onValueChange = { formatTemplate = it }, label = { Text("Format / Box Layout") }, minLines = 3, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = solvedEn, onValueChange = { solvedEn = it }, label = { Text("Solved Example (English)") }, minLines = 3, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = solvedHi, onValueChange = { solvedHi = it }, label = { Text("Hindi Explanation of Example") }, minLines = 2, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = examQuestion, onValueChange = { examQuestion = it }, label = { Text("MP Board Exam Question") }, minLines = 2, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = modelAnswer, onValueChange = { modelAnswer = it }, label = { Text("Model Answer") }, minLines = 3, modifier = Modifier.fillMaxWidth())

                Button(
                    enabled = !isBusy && title.isNotBlank() && explanationHi.isNotBlank(),
                    onClick = {
                        onSave(editingId, category, title, titleHi, selectedClasses, explanationHi, formatTemplate, solvedEn, solvedHi, examQuestion, modelAnswer)
                        editingId = null; title = ""; titleHi = ""; explanationHi = ""; formatTemplate = ""; solvedEn = ""; solvedHi = ""; examQuestion = ""; modelAnswer = ""
                    },
                    modifier = Modifier.fillMaxWidth().height(48.dp)
                ) {
                    Text(if (editingId == null) "Publish Writing Material" else "Update Writing Material")
                }
            }
        }

        materials.forEach { m ->
            AdminItemRow(
                title = m.title,
                subtitle = "${m.topicCategory} • Classes ${m.applicableClasses.joinToString(",")}",
                onEdit = {
                    editingId = m.id; category = m.topicCategory; title = m.title; titleHi = m.titleHi
                    selectedClasses = m.applicableClasses.map { it.toInt() }.ifEmpty { listOf(9, 10, 11, 12) }
                    explanationHi = m.explanationHi; formatTemplate = m.formatTemplate
                    solvedEn = m.solvedExampleEn; solvedHi = m.solvedExampleHi
                    examQuestion = m.examQuestion; modelAnswer = m.modelAnswer
                },
                onDelete = { onDelete(m.id) }
            )
        }
    }
}

@Composable
internal fun AdminStudentResultsTab(
    results: List<StudentTestSummaryDoc>
) {
    var classFilter by remember { mutableIntStateOf(0) }
    var search by remember { mutableStateOf("") }

    val filtered = remember(results, classFilter, search) {
        val q = search.trim()
        results.filter { res ->
            (classFilter == 0 || res.classLevel.toInt() == classFilter) &&
                (q.isBlank() || res.studentName.contains(q, ignoreCase = true) || res.testTitle.contains(q, ignoreCase = true))
        }
    }

    val avgPct = if (filtered.isEmpty()) 0 else filtered.sumOf { it.percentage.toInt() } / filtered.size

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Surface(
                modifier = Modifier.weight(1f),
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = RoundedCornerShape(14.dp)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text("Total Attempts", style = MaterialTheme.typography.labelSmall)
                    Text("${filtered.size}", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
                }
            }
            Surface(
                modifier = Modifier.weight(1f),
                color = MaterialTheme.colorScheme.tertiaryContainer,
                shape = RoundedCornerShape(14.dp)
            ) {
                Column(modifier = Modifier.padding(14.dp)) {
                    Text("Avg. Score", style = MaterialTheme.typography.labelSmall)
                    Text("$avgPct%", style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
                }
            }
        }

        OutlinedTextField(
            value = search,
            onValueChange = { search = it },
            label = { Text("Filter by student name or test title...") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Row(modifier = Modifier.horizontalScroll(rememberScrollState()), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            listOf(0 to "All Classes", 9 to "Class 9", 10 to "Class 10", 11 to "Class 11", 12 to "Class 12").forEach { (cls, lbl) ->
                FilterChip(selected = classFilter == cls, onClick = { classFilter = cls }, label = { Text(lbl) })
            }
        }

        if (filtered.isEmpty()) {
            EmptyStateCard(
                icon = Icons.Rounded.Assessment,
                title = "No Student Test Results Yet",
                subtitle = "Completed student tests across Class 9th–12th appear here automatically for Imran Gori Sir."
            )
        } else {
            filtered.forEach { res ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth().padding(14.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(3.dp)) {
                            Text(res.studentName.ifBlank { "Student" }, style = MaterialTheme.typography.titleSmall)
                            Text(res.testTitle, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.primary)
                            Text(
                                "Class ${res.classLevel}th • ${res.correctCount}/${res.totalQuestions} Correct • ${res.durationSeconds / 60}m ${res.durationSeconds % 60}s",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                        Surface(
                            color = if (res.percentage >= 60) MaterialTheme.colorScheme.tertiaryContainer
                            else MaterialTheme.colorScheme.errorContainer,
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "${res.percentage}%",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}
