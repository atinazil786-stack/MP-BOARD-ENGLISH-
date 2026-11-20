package com.example

import com.example.data.curriculum.ChapterEnrichmentRegistry
import com.example.data.curriculum.Class10Curriculum
import com.example.data.curriculum.Class11Curriculum
import com.example.data.curriculum.Class12Curriculum
import com.example.data.curriculum.Class9Curriculum
import com.example.data.curriculum.GrammarCurriculum
import com.example.data.curriculum.QuestionBankAndVocab
import com.example.data.curriculum.SyllabusInventory
import com.example.data.model.Chapter
import com.example.data.model.QuestionType
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class CurriculumEnrichmentTest {

    private val allRawChapters: List<Chapter> =
        Class9Curriculum.chapters +
            Class10Curriculum.chapters +
            Class11Curriculum.chapters +
            Class12Curriculum.chapters

    private val allEnrichedChapters: List<Chapter> = ChapterEnrichmentRegistry.enrichAll(allRawChapters)

    @Test
    fun `all 89 prescribed MPBSE 2026-27 prose poems and supplementary units from Class 9 to 12 are present and enriched`() {
        val missing = SyllabusInventory.missingIds(allEnrichedChapters)
        assertTrue(
            "Missing prescribed units: ${missing.joinToString { "${it.id}:${it.title}" }}",
            missing.isEmpty()
        )
        assertEquals(89, allEnrichedChapters.size)
        assertEquals(89, allEnrichedChapters.map { it.id }.distinct().size)

        val summaries = SyllabusInventory.summarizeByClass(allEnrichedChapters).associateBy { it.classLevel }
        assertEquals(26, summaries[9]?.loadedTotal)
        assertEquals(28, summaries[10]?.loadedTotal)
        assertEquals(16, summaries[11]?.loadedTotal)
        assertEquals(19, summaries[12]?.loadedTotal)
        summaries.values.forEach { summary ->
            assertTrue("Class ${summary.classLevel} syllabus summary incomplete", summary.isComplete)
        }

        val hindiRegex = Regex("[\\u0900-\\u097F]")

        allEnrichedChapters.forEach { chapter ->
            val isPoem = chapter.category.equals("Poem", ignoreCase = true)

            // 1. Detailed Hindi explanation
            assertTrue("${chapter.id} hindiExplanation must be detailed", chapter.hindiExplanation.length >= 120)
            assertTrue("${chapter.id} hindiExplanation must contain Hindi text", hindiRegex.containsMatchIn(chapter.hindiExplanation))

            // 2. Paragraph / Stanza explanations
            if (isPoem) {
                assertTrue("${chapter.id} poem must have >= 1 stanza explanation", chapter.paragraphExplanations.isNotEmpty())
            } else {
                assertTrue("${chapter.id} prose/supp must have >= 3 paragraph explanations", chapter.paragraphExplanations.size >= 3)
            }
            chapter.paragraphExplanations.forEach { p ->
                assertTrue("${chapter.id} p${p.paragraphNumber} excerpt blank", p.englishExcerpt.isNotBlank())
                assertTrue("${chapter.id} p${p.paragraphNumber} Hindi blank", hindiRegex.containsMatchIn(p.simpleHindiExplanation))
            }

            // 3. Word meanings in Hindi
            assertTrue("${chapter.id} must have >= 10 word meanings", chapter.wordMeanings.size >= 10)
            chapter.wordMeanings.forEach { wm ->
                assertTrue("${chapter.id} word blank", wm.word.isNotBlank())
                assertTrue("${chapter.id} meaningHi must contain Hindi", hindiRegex.containsMatchIn(wm.meaningHi))
            }

            // 4. Chapter summary in Hindi & Theme/Message
            assertTrue("${chapter.id} summaryHi blank", chapter.summaryHi.isNotBlank())
            assertTrue("${chapter.id} summaryHi must contain Hindi", hindiRegex.containsMatchIn(chapter.summaryHi))
            assertTrue("${chapter.id} themeEn blank", chapter.themeEn.isNotBlank())
            assertTrue("${chapter.id} themeHi blank", hindiRegex.containsMatchIn(chapter.themeHi))

            // 5. Character sketches (prose/supp required)
            assertTrue("${chapter.id} must have character sketches", chapter.characterSketches.isNotEmpty())
            chapter.characterSketches.forEach { cs ->
                assertTrue("${chapter.id} sketchHi blank", hindiRegex.containsMatchIn(cs.sketchHi))
                assertTrue("${chapter.id} sketchEn blank", cs.sketchEn.isNotBlank())
            }

            // 6. MCQs: 100 for Prose/Supplementary, >= 30 (40) for Poems
            val mcqs = chapter.questions.filter { it.type == QuestionType.MCQ }
            if (isPoem) {
                assertTrue("${chapter.id} poem must have >= 30 MCQs (found ${mcqs.size})", mcqs.size >= 30)
            } else {
                assertEquals("${chapter.id} prose/supp must have exactly 100 MCQs", 100, mcqs.size)
            }
            assertEquals("${chapter.id} MCQ IDs must be unique", mcqs.size, mcqs.map { it.id }.distinct().size)
            mcqs.forEach { q ->
                assertEquals("${chapter.id} ${q.id} must have 4 options", 4, q.options.size)
                assertTrue("${chapter.id} ${q.id} valid answer idx", q.correctOptionIndex in 0..3)
                assertTrue("${chapter.id} ${q.id} must have Hindi explanation", hindiRegex.containsMatchIn(q.explanationHi))
                assertFalse("${chapter.id} ${q.id} prompt blank", q.promptEn.isBlank())
            }

            // 7. Important Question Answers (Very Short, Short, Long, Board PYQ)
            val importantQas = chapter.questions.filter {
                it.type in listOf(QuestionType.VERY_SHORT, QuestionType.SHORT, QuestionType.LONG, QuestionType.BOARD_PYQ)
            }
            if (isPoem) {
                assertTrue("${chapter.id} poem must have >= 12 important Q&As", importantQas.size >= 12)
                assertTrue("${chapter.id} poem must have SHORT Qs", chapter.questions.any { it.type == QuestionType.SHORT })
                assertTrue("${chapter.id} poem must have LONG Qs", chapter.questions.any { it.type == QuestionType.LONG })
            } else {
                assertTrue("${chapter.id} must have >= 30 important Q&As (found ${importantQas.size})", importantQas.size >= 30)
            }

            // 8. Extract Based, Fill in the blanks, True/False, Match the following
            val extracts = chapter.questions.filter { it.type == QuestionType.EXTRACT }
            assertTrue("${chapter.id} must have >= 1 extract question", extracts.isNotEmpty())

            val fillBlanks = chapter.questions.filter { it.type == QuestionType.FILL_BLANK }
            assertTrue("${chapter.id} must have >= 8 fill in the blanks", fillBlanks.size >= 8)

            val trueFalse = chapter.questions.filter { it.type == QuestionType.TRUE_FALSE }
            assertTrue("${chapter.id} must have >= 8 true/false questions", trueFalse.size >= 8)

            val matchQs = chapter.questions.filter { it.type == QuestionType.MATCH }
            assertTrue("${chapter.id} must have match question", matchQs.isNotEmpty())

            // 9. Poem-specific 14-point study guide verification
            if (isPoem) {
                val guide = chapter.poemDetails
                assertNotNull("${chapter.id} must have poemDetails", guide)
                guide!!
                assertTrue("${chapter.id} poetIntroEn blank", guide.poetIntroEn.isNotBlank())
                assertTrue("${chapter.id} poetIntroHi blank", hindiRegex.containsMatchIn(guide.poetIntroHi))
                assertTrue("${chapter.id} centralIdeaEn blank", guide.centralIdeaEn.isNotBlank())
                assertTrue("${chapter.id} centralIdeaHi blank", hindiRegex.containsMatchIn(guide.centralIdeaHi))
                assertTrue("${chapter.id} hindiTranslationAndInterpretation blank", hindiRegex.containsMatchIn(guide.hindiTranslationAndInterpretation))
                assertTrue("${chapter.id} stanzas empty", guide.stanzas.isNotEmpty())
                assertTrue("${chapter.id} must have >= 2 poeticDevices", guide.poeticDevices.size >= 2)
            }

            // 10. 2D Cartoon Animation scenes
            assertTrue("${chapter.id} must have >= 4 cartoon scenes", chapter.cartoonScenes.size >= 4)
            chapter.cartoonScenes.forEach { scene ->
                assertTrue("${chapter.id} cartoon narration must have Hindi", hindiRegex.containsMatchIn(scene.narrationHi))
                assertTrue("${chapter.id} cartoon characterName blank", scene.characterName.isNotBlank())
            }
        }
    }

    @Test
    fun `chapter wise exam builder serves 10Q 30Q and 100Q unique tests per chapter`() {
        val sampleChapter = allEnrichedChapters.first()

        val test10 = QuestionBankAndVocab.buildExamQuestions(
            allChapters = allEnrichedChapters,
            allGrammar = GrammarCurriculum.topics,
            extraQuestions = emptyList(),
            targetCount = 10,
            classFilter = sampleChapter.classLevel,
            chapterIdFilter = sampleChapter.id
        )
        assertEquals(10, test10.size)

        val test30 = QuestionBankAndVocab.buildExamQuestions(
            allChapters = allEnrichedChapters,
            allGrammar = GrammarCurriculum.topics,
            extraQuestions = emptyList(),
            targetCount = 30,
            classFilter = sampleChapter.classLevel,
            chapterIdFilter = sampleChapter.id
        )
        assertEquals(30, test30.size)
        assertEquals(30, test30.map { it.id }.distinct().size)

        val test100 = QuestionBankAndVocab.buildExamQuestions(
            allChapters = allEnrichedChapters,
            allGrammar = GrammarCurriculum.topics,
            extraQuestions = emptyList(),
            targetCount = 100,
            classFilter = sampleChapter.classLevel,
            chapterIdFilter = sampleChapter.id
        )
        assertEquals(100, test100.size)
        assertEquals(100, test100.map { it.id }.distinct().size)
    }

    @Test
    fun `admin added custom chapter without pre authored spec also receives complete fallback enrichment`() {
        val customChapter = Chapter(
            id = "admin_c10_custom_1",
            classLevel = 10,
            bookName = "First Flight",
            chapterNumber = 99,
            title = "The Proposal",
            titleHi = "प्रस्ताव",
            author = "Anton Chekhov",
            summaryEn = "A humorous one-act play about marriage proposals and petty arguments.",
            summaryHi = "यह विवाह प्रस्ताव और छोटी-छोटी बहसों पर आधारित एक हास्य एकांकी है।",
            hindiExplanation = "इमरान गोरी सर द्वारा व्याख्या: लोमोव और नतालिया के बीच जमीनी विवाद की मज़ेदार कहानी।",
            wordMeanings = emptyList(),
            questions = emptyList(),
            isAdminAdded = true
        )

        val enriched = ChapterEnrichmentRegistry.enrichChapter(customChapter)
        assertEquals(100, enriched.questions.count { it.type == QuestionType.MCQ })
        assertTrue(enriched.questions.count { it.type in listOf(QuestionType.VERY_SHORT, QuestionType.SHORT, QuestionType.LONG, QuestionType.BOARD_PYQ) } >= 30)
        assertTrue(enriched.wordMeanings.size >= 10)
        assertTrue(enriched.paragraphExplanations.size >= 3)
        assertTrue(enriched.characterSketches.isNotEmpty())
        assertTrue(enriched.cartoonScenes.size >= 4)
    }
}
