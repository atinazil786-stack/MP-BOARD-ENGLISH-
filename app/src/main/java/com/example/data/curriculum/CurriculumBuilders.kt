package com.example.data.curriculum

import com.example.data.model.CartoonMood
import com.example.data.model.CartoonScene
import com.example.data.model.CartoonSetting
import com.example.data.model.Chapter
import com.example.data.model.ChapterQuestion
import com.example.data.model.CharacterSketch
import com.example.data.model.MatchPair
import com.example.data.model.ParagraphExplanation
import com.example.data.model.PoemStanzaExplanation
import com.example.data.model.PoeticDeviceItem
import com.example.data.model.QuestionSourceTag
import com.example.data.model.QuestionType
import com.example.data.model.WordMeaning

object CurriculumBuilders {

    fun makeProseChapter(
        id: String,
        classLevel: Int,
        bookName: String,
        chapterNumber: Int,
        category: String,
        title: String,
        titleHi: String,
        author: String,
        summaryEn: String,
        summaryHi: String,
        hindiExplanation: String,
        themeEn: String,
        themeHi: String,
        messageHi: String,
        words: List<WordMeaning>,
        matchPairs: List<MatchPair>,
        extract1: ExtractSpec,
        extract2: ExtractSpec,
        pyqPromptEn: String,
        pyqPromptHi: String,
        pyqAnswerEn: String,
        pyqAnswerHi: String,
        mcq1Prompt: String,
        mcq1Options: List<String>,
        mcq1Correct: Int,
        mcq1Hi: String,
        mcq2Prompt: String,
        mcq2Options: List<String>,
        mcq2Correct: Int,
        mcq2Hi: String
    ): Chapter {
        val baseQuestions = listOf(
            ChapterQuestion(
                id = "${id}_mcq_seed_1",
                chapterId = id,
                classLevel = classLevel,
                type = QuestionType.MCQ,
                sourceTag = QuestionSourceTag.NCERT,
                promptEn = mcq1Prompt,
                answerEn = mcq1Options[mcq1Correct],
                options = mcq1Options,
                correctOptionIndex = mcq1Correct,
                explanationHi = mcq1Hi
            ),
            ChapterQuestion(
                id = "${id}_mcq_seed_2",
                chapterId = id,
                classLevel = classLevel,
                type = QuestionType.MCQ,
                sourceTag = QuestionSourceTag.MP_BOARD_VERIFIED,
                promptEn = mcq2Prompt,
                answerEn = mcq2Options[mcq2Correct],
                options = mcq2Options,
                correctOptionIndex = mcq2Correct,
                explanationHi = mcq2Hi
            ),
            ChapterQuestion(
                id = "${id}_match_1",
                chapterId = id,
                classLevel = classLevel,
                type = QuestionType.MATCH,
                sourceTag = QuestionSourceTag.NCERT,
                promptEn = "Match Column A with Column B from '$title':",
                promptHi = "स्तंभ 'अ' को स्तंभ 'ब' से सही मिलाइए:",
                answerEn = matchPairs.joinToString("; ") { "${it.left} -> ${it.right}" },
                matchPairs = matchPairs
            ),
            ChapterQuestion(
                id = "${id}_ex_1",
                chapterId = id,
                classLevel = classLevel,
                type = QuestionType.EXTRACT,
                sourceTag = QuestionSourceTag.MP_BOARD_VERIFIED,
                boardReference = "Board Extract 1",
                extractText = extract1.extractText,
                promptEn = extract1.promptEn,
                promptHi = extract1.promptHi,
                answerEn = extract1.answerEn,
                answerHi = extract1.answerHi
            ),
            ChapterQuestion(
                id = "${id}_ex_2",
                chapterId = id,
                classLevel = classLevel,
                type = QuestionType.EXTRACT,
                sourceTag = QuestionSourceTag.NCERT,
                boardReference = "Board Extract 2",
                extractText = extract2.extractText,
                promptEn = extract2.promptEn,
                promptHi = extract2.promptHi,
                answerEn = extract2.answerEn,
                answerHi = extract2.answerHi
            ),
            ChapterQuestion(
                id = "${id}_pyq_1",
                chapterId = id,
                classLevel = classLevel,
                type = QuestionType.BOARD_PYQ,
                sourceTag = QuestionSourceTag.MP_BOARD_VERIFIED,
                boardReference = "MPBSE Important Question",
                promptEn = pyqPromptEn,
                promptHi = pyqPromptHi,
                answerEn = pyqAnswerEn,
                answerHi = pyqAnswerHi
            )
        )

        return Chapter(
            id = id,
            classLevel = classLevel,
            bookName = bookName,
            chapterNumber = chapterNumber,
            title = title,
            titleHi = titleHi,
            author = author,
            category = category,
            summaryEn = summaryEn,
            summaryHi = summaryHi,
            hindiExplanation = hindiExplanation,
            wordMeanings = words,
            questions = baseQuestions,
            themeEn = themeEn,
            themeHi = themeHi,
            messageHi = messageHi
        )
    }

    fun makePoemChapter(
        id: String,
        classLevel: Int,
        bookName: String,
        poemNumber: Int,
        title: String,
        titleHi: String,
        poet: String,
        summaryEn: String,
        summaryHi: String,
        hindiExplanation: String,
        themeEn: String,
        themeHi: String,
        words: List<WordMeaning>,
        matchPairs: List<MatchPair>,
        stanzas: List<PoemStanzaExplanation>,
        poeticDevices: List<PoeticDeviceItem>,
        extraFacts: List<ChapterFactItem>
    ): Chapter {
        val baseQuestions = mutableListOf<ChapterQuestion>()
        stanzas.take(2).forEachIndexed { i, st ->
            baseQuestions += ChapterQuestion(
                id = "${id}_ex_${i + 1}",
                chapterId = id,
                classLevel = classLevel,
                type = QuestionType.EXTRACT,
                sourceTag = QuestionSourceTag.MP_BOARD_VERIFIED,
                boardReference = "Poetry Extract ${i + 1}",
                extractText = st.englishStanza,
                promptEn = "Read Stanza ${st.stanzaNumber} of '$title' by $poet and explain its core idea.",
                promptHi = "'$title' के पद्यांश ${st.stanzaNumber} को पढ़कर उसका मुख्य भाव स्पष्ट कीजिए।",
                answerEn = st.hindiTranslation,
                answerHi = "${st.simpleHindiExplanation} (विशेष: ${st.poeticNoteHi})"
            )
        }
        baseQuestions += ChapterQuestion(
            id = "${id}_match_1",
            chapterId = id,
            classLevel = classLevel,
            type = QuestionType.MATCH,
            sourceTag = QuestionSourceTag.NCERT,
            promptEn = "Match the poetic elements from '$title':",
            promptHi = "कविता '$title' की सही जोड़ी मिलाइए:",
            answerEn = matchPairs.joinToString("; ") { "${it.left} -> ${it.right}" },
            matchPairs = matchPairs
        )
        baseQuestions += ChapterQuestion(
            id = "${id}_pyq_1",
            chapterId = id,
            classLevel = classLevel,
            type = QuestionType.BOARD_PYQ,
            sourceTag = QuestionSourceTag.MP_BOARD_VERIFIED,
            boardReference = "MP Board Guaranteed Poem Question",
            promptEn = "Write the central idea of the poem '$title' composed by $poet.",
            promptHi = "$poet द्वारा रचित कविता '$title' का केंद्रीय भाव (Central Idea) लिखिए।",
            answerEn = summaryEn,
            answerHi = summaryHi
        )
        extraFacts.take(3).forEachIndexed { idx, f ->
            baseQuestions += ChapterQuestion(
                id = "${id}_mcq_seed_${idx + 1}",
                chapterId = id,
                classLevel = classLevel,
                type = QuestionType.MCQ,
                sourceTag = QuestionSourceTag.NCERT,
                promptEn = f.promptEn,
                promptHi = f.promptHi,
                answerEn = f.correctAnswer,
                options = (listOf(f.correctAnswer) + f.distractors).shuffled().let { shuffled ->
                    shuffled
                },
                correctOptionIndex = -1, // handled cleanly below
                explanationHi = f.explanationHi
            ).let { q ->
                val opts = (listOf(f.correctAnswer) + f.distractors).distinct().take(4)
                val targetIdx = idx % opts.size
                val ordered = opts.filter { it != f.correctAnswer }.toMutableList()
                ordered.add(targetIdx.coerceIn(0, ordered.size), f.correctAnswer)
                q.copy(options = ordered, correctOptionIndex = ordered.indexOf(f.correctAnswer))
            }
        }
        if (poeticDevices.isNotEmpty()) {
            val dev = poeticDevices.first()
            baseQuestions += ChapterQuestion(
                id = "${id}_sh_dev",
                chapterId = id,
                classLevel = classLevel,
                type = QuestionType.SHORT,
                sourceTag = QuestionSourceTag.NCERT,
                promptEn = "Name two poetic devices used in '$title' with one example.",
                promptHi = "कविता '$title' में प्रयुक्त दो अलंकारों (Poetic Devices) का उदाहरण सहित उल्लेख कीजिए।",
                answerEn = poeticDevices.take(2).joinToString("; ") { "${it.deviceName}: \"${it.exampleLine}\"" },
                answerHi = "${dev.deviceNameHi}: ${dev.explanationHi}"
            )
        }

        return Chapter(
            id = id,
            classLevel = classLevel,
            bookName = bookName,
            chapterNumber = poemNumber,
            title = title,
            titleHi = titleHi,
            author = poet,
            category = "Poem",
            summaryEn = summaryEn,
            summaryHi = summaryHi,
            hindiExplanation = hindiExplanation,
            wordMeanings = words,
            questions = baseQuestions,
            themeEn = themeEn,
            themeHi = themeHi,
            messageHi = summaryHi
        )
    }

    fun p(n: Int, h: String, ex: String, hi: String, key: String) =
        ParagraphExplanation(n, h, ex, hi, key)

    fun ch(name: String, nameHi: String, role: String, traits: List<String>, hi: String, en: String) =
        CharacterSketch(name, nameHi, role, traits, hi, en)

    fun sc(n: Int, title: String, sub: String, nar: String, c1: String, c2: String, set: CartoonSetting, mood: CartoonMood, act: String) =
        CartoonScene(n, title, sub, nar, c1, c2, set, mood, act)

    fun w(word: String, pos: String, en: String, hi: String, ex: String) =
        WordMeaning(word, pos, en, hi, ex)

    fun f(q: String, ans: String, dist: List<String>, hi: String) =
        ChapterFactItem(q, ans, dist, hi)

    fun st(n: Int, en: String, trans: String, hi: String, note: String) =
        PoemStanzaExplanation(n, en, trans, hi, note)

    fun dev(name: String, nameHi: String, ex: String, hi: String) =
        PoeticDeviceItem(name, nameHi, ex, hi)
}
