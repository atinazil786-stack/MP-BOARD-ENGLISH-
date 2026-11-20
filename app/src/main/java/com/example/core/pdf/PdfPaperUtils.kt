package com.example.core.pdf

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.util.Base64
import androidx.core.content.FileProvider
import com.example.data.model.PreviousYearPaper
import java.io.File
import java.io.FileOutputStream

object PdfPaperUtils {

    private const val PAGE_WIDTH = 595
    private const val PAGE_HEIGHT = 842
    private const val MARGIN_X = 44f
    private const val CONTENT_WIDTH = 507f

    fun writePaperToFile(context: Context, paper: PreviousYearPaper): File {
        val dir = File(context.cacheDir, "pdfs").apply { mkdirs() }
        val safeName = (paper.pdfFileName.ifBlank { "${paper.id}_${paper.year}.pdf" })
            .replace(Regex("[^a-zA-Z0-9._\\-]"), "_")
            .let { if (it.endsWith(".pdf", ignoreCase = true)) it else "$it.pdf" }
        val outFile = File(dir, safeName)

        if (paper.pdfBase64.isNotBlank()) {
            val decoded = runCatching { Base64.decode(paper.pdfBase64, Base64.DEFAULT) }.getOrNull()
            if (decoded != null && decoded.size > 100) {
                FileOutputStream(outFile).use { it.write(decoded) }
                return outFile
            }
        }

        val doc = PdfDocument()
        val titlePaint = Paint().apply {
            color = Color.rgb(20, 45, 95)
            textSize = 16f
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        }
        val subtitlePaint = Paint().apply {
            color = Color.rgb(65, 85, 115)
            textSize = 11f
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        }
        val bodyPaint = Paint().apply {
            color = Color.BLACK
            textSize = 10.5f
        }
        val sectionPaint = Paint().apply {
            color = Color.rgb(165, 72, 12)
            textSize = 12f
            typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)
        }

        var pageNum = 1
        var page = doc.startPage(PdfDocument.PageInfo.Builder(PAGE_WIDTH, PAGE_HEIGHT, pageNum).create())
        var canvas = page.canvas
        var y = 52f

        fun newPage() {
            doc.finishPage(page)
            pageNum++
            page = doc.startPage(PdfDocument.PageInfo.Builder(PAGE_WIDTH, PAGE_HEIGHT, pageNum).create())
            canvas = page.canvas
            y = 48f
        }

        fun drawWrapped(text: String, paint: Paint, lineSpacing: Float = 15f) {
            val words = text.split(Regex("\\s+"))
            val line = StringBuilder()
            for (word in words) {
                val candidate = if (line.isEmpty()) word else "$line $word"
                if (paint.measureText(candidate) <= CONTENT_WIDTH) {
                    line.clear()
                    line.append(candidate)
                } else {
                    if (y > PAGE_HEIGHT - 48f) newPage()
                    canvas.drawText(line.toString(), MARGIN_X, y, paint)
                    y += lineSpacing
                    line.clear()
                    line.append(word)
                }
            }
            if (line.isNotEmpty()) {
                if (y > PAGE_HEIGHT - 48f) newPage()
                canvas.drawText(line.toString(), MARGIN_X, y, paint)
                y += lineSpacing
            }
        }

        drawWrapped("IMRAN GORI SIR - MP BOARD ENGLISH HUB", titlePaint, 20f)
        drawWrapped("Class ${paper.classLevel}th | ${paper.year} | ${paper.title}", subtitlePaint, 16f)
        drawWrapped("Source: ${paper.sourceLabel} (${paper.setCode})", bodyPaint, 15f)
        y += 6f
        canvas.drawLine(MARGIN_X, y, PAGE_WIDTH - MARGIN_X, y, bodyPaint)
        y += 18f

        paper.questions.forEachIndexed { idx, q ->
            if (y > PAGE_HEIGHT - 90f) newPage()
            drawWrapped("Q${idx + 1}. [${q.sectionType.labelEn} - ${q.marks} Marks] (${q.chapterTag})", sectionPaint, 15f)
            drawWrapped(q.questionEn, bodyPaint, 14f)
            if (q.options.isNotEmpty()) {
                q.options.forEachIndexed { optIdx, opt ->
                    val label = ('A' + optIdx)
                    drawWrapped("   ($label) $opt", bodyPaint, 13.5f)
                }
            }
            drawWrapped("Answer Key: ${q.answerKeyEn}", subtitlePaint, 14f)
            if (q.modelSolutionEn.isNotBlank() && q.modelSolutionEn != q.answerKeyEn) {
                drawWrapped("Model Solution: ${q.modelSolutionEn}", bodyPaint, 14f)
            }
            y += 8f
        }

        doc.finishPage(page)
        FileOutputStream(outFile).use { doc.writeTo(it) }
        doc.close()
        return outFile
    }

    fun writeBase64NoteToFile(context: Context, fileName: String, base64Data: String): File? {
        if (base64Data.isBlank()) return null
        val decoded = runCatching { Base64.decode(base64Data, Base64.DEFAULT) }.getOrNull() ?: return null
        val dir = File(context.cacheDir, "pdfs").apply { mkdirs() }
        val safeName = fileName.ifBlank { "imran_sir_notes.pdf" }
            .replace(Regex("[^a-zA-Z0-9._\\-]"), "_")
            .let { if (it.endsWith(".pdf", ignoreCase = true)) it else "$it.pdf" }
        val outFile = File(dir, safeName)
        FileOutputStream(outFile).use { it.write(decoded) }
        return outFile
    }

    fun copyPdfFileToUri(context: Context, sourceFile: File, targetUri: Uri): Boolean {
        return runCatching {
            context.contentResolver.openOutputStream(targetUri)?.use { out ->
                sourceFile.inputStream().use { input ->
                    input.copyTo(out)
                }
            } ?: return false
            true
        }.getOrDefault(false)
    }

    fun openPdfWithViewer(context: Context, file: File): Boolean {
        return runCatching {
            val uri = FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", file)
            val intent = Intent(Intent.ACTION_VIEW).apply {
                setDataAndType(uri, "application/pdf")
                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
            }
            context.startActivity(Intent.createChooser(intent, "Open PDF with"))
            true
        }.getOrDefault(false)
    }

    fun openExternalUrl(context: Context, url: String): Boolean {
        val normalized = if (url.startsWith("http://") || url.startsWith("https://")) url else "https://$url"
        return runCatching {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(normalized))
            context.startActivity(intent)
            true
        }.getOrDefault(false)
    }
}
