package com.example.data.curriculum

import com.example.data.model.CartoonMood
import com.example.data.model.CartoonScene
import com.example.data.model.CartoonSetting
import com.example.data.model.Chapter
import com.example.data.model.ChapterQuestion
import com.example.data.model.CharacterSketch
import com.example.data.model.ParagraphExplanation
import com.example.data.model.PoemStanzaExplanation
import com.example.data.model.PoemStudyGuide
import com.example.data.model.PoeticDeviceItem
import com.example.data.model.QuestionSourceTag
import com.example.data.model.QuestionType
import com.example.data.model.WordMeaning

data class ChapterFactItem(
    val promptEn: String,
    val correctAnswer: String,
    val distractors: List<String>,
    val explanationHi: String,
    val promptHi: String = "",
    val isNcert: Boolean = true
)

data class ChapterQaSpec(
    val type: QuestionType,
    val promptEn: String,
    val promptHi: String,
    val answerEn: String,
    val answerHi: String,
    val isBoardPyq: Boolean = false
)

data class ExtractSpec(
    val extractText: String,
    val promptEn: String,
    val promptHi: String,
    val answerEn: String,
    val answerHi: String
)

data class PoemRichSpec(
    val poetIntroEn: String,
    val poetIntroHi: String,
    val centralIdeaEn: String,
    val centralIdeaHi: String,
    val themeEn: String,
    val themeHi: String,
    val hindiTranslationAndInterpretation: String,
    val stanzas: List<PoemStanzaExplanation>,
    val poeticDevices: List<PoeticDeviceItem>
)

data class ChapterRichSpec(
    val chapterId: String,
    val detailedHindiTeaching: String,
    val summaryHiEnhanced: String = "",
    val paragraphs: List<ParagraphExplanation>,
    val characters: List<CharacterSketch>,
    val cartoonScenes: List<CartoonScene>,
    val extraWords: List<WordMeaning> = emptyList(),
    val extraFacts: List<ChapterFactItem> = emptyList(),
    val extraFillBlanks: List<Pair<String, String>> = emptyList(),
    val extraTrueFalse: List<Pair<String, Boolean>> = emptyList(),
    val extraQa: List<ChapterQaSpec> = emptyList(),
    val extraExtracts: List<ExtractSpec> = emptyList(),
    val themeEn: String = "",
    val themeHi: String = "",
    val messageHi: String = "",
    val poemSpec: PoemRichSpec? = null
)

object ChapterEnrichmentEngine {

    private val allHindiPool = listOf(
        "दयालुता / सहानुभूति",
        "साहस / निडरता",
        "परिश्रम / दृढ़ संकल्प",
        "आश्चर्य / विस्मय",
        "शांति / धैर्य",
        "स्वतंत्रता / आज़ादी",
        "ईमानदारी / सत्यनिष्ठा",
        "उदासी / निराशा",
        "प्रसन्नता / उत्साह",
        "विवेक / बुद्धिमत्ता",
        "संघर्ष / कठिनाई",
        "सफलता / उपलब्धि"
    )

    private val allPartsOfSpeech = listOf("noun", "verb", "adj", "adv")
    private val allAuthorsPool = listOf(
        "G.L. Fuentes", "Nelson Mandela", "Ruskin Bond", "Isaac Asimov",
        "A.P.J. Abdul Kalam", "Robert Frost", "Khushwant Singh",
        "Alphonse Daudet", "Anees Jung", "William Douglas", "Pearl S. Buck",
        "James Herriot", "Guy de Maupassant", "Anne Frank", "A.J. Cronin"
    )
    private val allBooksPool = listOf(
        "Beehive", "Moments", "First Flight", "Footprints Without Feet",
        "Hornbill", "Snapshots", "Flamingo", "Vistas"
    )

    fun enrich(chapter: Chapter, spec: ChapterRichSpec?): Chapter {
        val isPoem = chapter.category.equals("Poem", ignoreCase = true)
        val mergedWords = mergeWordMeanings(chapter, spec)
        val builtPoemGuide = if (isPoem) buildPoemStudyGuide(chapter, spec) else null

        val mergedParagraphs = when {
            spec != null && spec.paragraphs.isNotEmpty() -> spec.paragraphs
            builtPoemGuide != null && builtPoemGuide.stanzas.isNotEmpty() -> builtPoemGuide.stanzas.map { st ->
                ParagraphExplanation(
                    paragraphNumber = st.stanzaNumber,
                    headingHi = "पद्यांश ${st.stanzaNumber} (Stanza ${st.stanzaNumber} Explanation)",
                    englishExcerpt = st.englishStanza,
                    simpleHindiExplanation = "${st.hindiTranslation}\n\nसरल भावार्थ: ${st.simpleHindiExplanation}",
                    keyTakeawayHi = st.poeticNoteHi
                )
            }
            else -> defaultParagraphs(chapter)
        }
        val mergedCharacters = if (spec != null && spec.characters.isNotEmpty()) {
            spec.characters
        } else {
            defaultCharacters(chapter)
        }
        val mergedScenes = if (spec != null && spec.cartoonScenes.isNotEmpty()) {
            spec.cartoonScenes
        } else {
            defaultCartoonScenes(chapter)
        }
        val detailedHi = if (isPoem && builtPoemGuide != null) {
            buildString {
                if (spec?.detailedHindiTeaching?.isNotBlank() == true) {
                    append(spec.detailedHindiTeaching)
                    append("\n\n")
                }
                append("📜 संपूर्ण हिंदी अनुवाद एवं भावार्थ (Translation & Interpretation):\n")
                append(builtPoemGuide.hindiTranslationAndInterpretation)
                append("\n\n📌 इमरान गोरी सर (Imran Gori Sir) काव्य टिप:\n")
                append(chapter.hindiExplanation)
            }
        } else if (spec != null && spec.detailedHindiTeaching.isNotBlank()) {
            "${spec.detailedHindiTeaching}\n\n📌 इमरान गोरी सर (Imran Gori Sir) परीक्षा टिप:\n${chapter.hindiExplanation}"
        } else {
            "इमरान गोरी सर की सरल हिंदी व्याख्या:\n${chapter.hindiExplanation}\n\nसार संक्षेप: ${chapter.summaryHi}"
        }
        val finalSummaryHi = spec?.summaryHiEnhanced?.takeIf { it.isNotBlank() } ?: chapter.summaryHi

        val resolvedThemeEn = chapter.themeEn.ifBlank {
            spec?.themeEn?.ifBlank { builtPoemGuide?.themeEn }
                ?: "Exploring core human values, courage, empathy, and life lessons in '${chapter.title}'."
        }
        val resolvedThemeHi = chapter.themeHi.ifBlank {
            spec?.themeHi?.ifBlank { builtPoemGuide?.themeHi }
                ?: "'${chapter.title}' मानवीय मूल्यों, संवेदनशीलता और सही जीवन दृष्टिकोण को उजागर करता है।"
        }
        val resolvedMessageHi = chapter.messageHi.ifBlank {
            spec?.messageHi?.ifBlank { builtPoemGuide?.centralIdeaHi }
                ?: "${chapter.title} हमें सिखाता है कि विवेक, करुणा और सकारात्मक प्रयास से जीवन में सफलता मिलती है।"
        }

        val existingNonMcq = chapter.questions.filter { it.type != QuestionType.MCQ }
        val existingMcqs = chapter.questions.filter { it.type == QuestionType.MCQ }

        val fillBlanks = buildFillBlanks(chapter, existingNonMcq, mergedWords, spec)
        val trueFalseList = buildTrueFalse(chapter, existingNonMcq, mergedCharacters, spec)
        val importantQAs = buildThirtyImportantQAs(
            chapter = chapter,
            existingNonMcq = existingNonMcq,
            paragraphs = mergedParagraphs,
            characters = mergedCharacters,
            words = mergedWords,
            spec = spec,
            poemGuide = builtPoemGuide
        )
        val targetMcqCount = if (isPoem) 40 else 100
        val generatedMcqs = buildHundredMcqs(
            chapter = chapter,
            existingMcqs = existingMcqs,
            words = mergedWords,
            paragraphs = mergedParagraphs,
            characters = mergedCharacters,
            fillBlanks = fillBlanks,
            trueFalseList = trueFalseList,
            spec = spec,
            poemGuide = builtPoemGuide,
            targetCount = targetMcqCount
        )

        val preservedMatch = existingNonMcq.filter { it.type == QuestionType.MATCH }
        val extractQuestions = buildExtractQuestions(chapter, existingNonMcq, mergedParagraphs, spec, builtPoemGuide)

        val combinedQuestions = (importantQAs + generatedMcqs + fillBlanks + trueFalseList + preservedMatch + extractQuestions)
            .distinctBy { it.id }

        return chapter.copy(
            summaryHi = finalSummaryHi,
            hindiExplanation = detailedHi,
            wordMeanings = mergedWords,
            paragraphExplanations = mergedParagraphs,
            characterSketches = mergedCharacters,
            cartoonScenes = mergedScenes,
            themeEn = resolvedThemeEn,
            themeHi = resolvedThemeHi,
            messageHi = resolvedMessageHi,
            poemDetails = builtPoemGuide,
            questions = combinedQuestions
        )
    }

    private fun buildPoemStudyGuide(chapter: Chapter, spec: ChapterRichSpec?): PoemStudyGuide {
        val ps = spec?.poemSpec
        if (ps != null) {
            return PoemStudyGuide(
                poetName = chapter.author,
                poetIntroEn = ps.poetIntroEn,
                poetIntroHi = ps.poetIntroHi,
                centralIdeaEn = ps.centralIdeaEn,
                centralIdeaHi = ps.centralIdeaHi,
                themeEn = ps.themeEn,
                themeHi = ps.themeHi,
                hindiTranslationAndInterpretation = ps.hindiTranslationAndInterpretation,
                stanzas = ps.stanzas,
                poeticDevices = ps.poeticDevices
            )
        }
        return chapter.poemDetails ?: PoemStudyGuide(
            poetName = chapter.author,
            poetIntroEn = "${chapter.author} is a celebrated poet whose poem '${chapter.title}' is prescribed in MPBSE Class ${chapter.classLevel} (${chapter.bookName}).",
            poetIntroHi = "${chapter.author} एक प्रसिद्ध कवि हैं जिनकी कविता '${chapter.title}' कक्षा ${chapter.classLevel} (${chapter.bookName}) के पाठ्यक्रम में संकलित है।",
            centralIdeaEn = chapter.summaryEn,
            centralIdeaHi = chapter.summaryHi,
            themeEn = chapter.themeEn.ifBlank { chapter.summaryEn },
            themeHi = chapter.themeHi.ifBlank { chapter.summaryHi },
            hindiTranslationAndInterpretation = chapter.hindiExplanation,
            stanzas = listOf(
                PoemStanzaExplanation(
                    stanzaNumber = 1,
                    englishStanza = chapter.summaryEn,
                    hindiTranslation = chapter.summaryHi,
                    simpleHindiExplanation = chapter.hindiExplanation,
                    poeticNoteHi = "कविता के मुख्य भाव और प्रतीकों को ध्यान से समझें।"
                )
            ),
            poeticDevices = listOf(
                PoeticDeviceItem(
                    deviceName = "Imagery (बिंब विधान)",
                    deviceNameHi = "दृश्य एवं भाव बिंब",
                    exampleLine = "Key lines of '${chapter.title}'",
                    explanationHi = "कवि ने सरल और सजीव शब्दों से पाठक के मन में स्पष्ट चित्र उकेरा है।"
                ),
                PoeticDeviceItem(
                    deviceName = "Symbolism (प्रतीकात्मकता)",
                    deviceNameHi = "प्रतीक अलंकार",
                    exampleLine = "Central motif of '${chapter.title}'",
                    explanationHi = "कविता के शब्द गहरे मानवीय व दार्शनिक अर्थ व्यक्त करते हैं।"
                )
            )
        )
    }

    private fun buildExtractQuestions(
        chapter: Chapter,
        existingNonMcq: List<ChapterQuestion>,
        paragraphs: List<ParagraphExplanation>,
        spec: ChapterRichSpec?,
        poemGuide: PoemStudyGuide?
    ): List<ChapterQuestion> {
        val list = existingNonMcq.filter { it.type == QuestionType.EXTRACT }.toMutableList()
        var idx = list.size + 1
        spec?.extraExtracts?.forEach { ex ->
            if (list.none { it.promptEn == ex.promptEn }) {
                list += ChapterQuestion(
                    id = "${chapter.id}_ex_$idx",
                    chapterId = chapter.id,
                    classLevel = chapter.classLevel,
                    type = QuestionType.EXTRACT,
                    sourceTag = QuestionSourceTag.MP_BOARD_VERIFIED,
                    boardReference = "Extract Question #${idx}",
                    extractText = ex.extractText,
                    promptEn = ex.promptEn,
                    promptHi = ex.promptHi,
                    answerEn = ex.answerEn,
                    answerHi = ex.answerHi
                )
                idx++
            }
        }
        if (list.size < 2 && poemGuide != null && poemGuide.stanzas.isNotEmpty()) {
            poemGuide.stanzas.take(2).forEach { st ->
                if (list.size < 2 && list.none { it.extractText == st.englishStanza }) {
                    list += ChapterQuestion(
                        id = "${chapter.id}_ex_${idx++}",
                        chapterId = chapter.id,
                        classLevel = chapter.classLevel,
                        type = QuestionType.EXTRACT,
                        sourceTag = QuestionSourceTag.NCERT,
                        boardReference = "Stanza ${st.stanzaNumber} Extract",
                        extractText = st.englishStanza,
                        promptEn = "Explain the message of Stanza ${st.stanzaNumber} from '${chapter.title}' by ${chapter.author}.",
                        promptHi = "कविता '${chapter.title}' के पद्यांश ${st.stanzaNumber} का भावार्थ स्पष्ट कीजिए।",
                        answerEn = "${st.hindiTranslation} (Theme: ${poemGuide.centralIdeaEn})",
                        answerHi = st.simpleHindiExplanation
                    )
                }
            }
        }
        if (list.size < 2 && paragraphs.isNotEmpty()) {
            paragraphs.take(2).forEach { p ->
                if (list.size < 2 && list.none { it.extractText == p.englishExcerpt }) {
                    list += ChapterQuestion(
                        id = "${chapter.id}_ex_${idx++}",
                        chapterId = chapter.id,
                        classLevel = chapter.classLevel,
                        type = QuestionType.EXTRACT,
                        sourceTag = QuestionSourceTag.NCERT,
                        boardReference = "Prose Extract ${p.paragraphNumber}",
                        extractText = p.englishExcerpt,
                        promptEn = "From which chapter are these lines taken, and what key event do they highlight?",
                        promptHi = "यह अवतरण किस पाठ से लिया गया है और इसमें क्या मुख्य बात कही गई है?",
                        answerEn = "Taken from '${chapter.title}' by ${chapter.author} (${chapter.bookName}). Key idea: ${p.keyTakeawayHi}",
                        answerHi = "यह अंश पाठ '${chapter.title}' से है। भावार्थ: ${p.simpleHindiExplanation}"
                    )
                }
            }
        }
        return list
    }

    private fun mergeWordMeanings(chapter: Chapter, spec: ChapterRichSpec?): List<WordMeaning> {
        val list = (chapter.wordMeanings + (spec?.extraWords ?: emptyList())).distinctBy { it.word.lowercase() }.toMutableList()
        val supplemental = listOf(
            WordMeaning("Narrator", "noun", "The person telling the story", "कथावाचक / कहानी सुनाने वाला", "The narrator describes every detail clearly."),
            WordMeaning("Compassion", "noun", "Deep sympathy and kindness", "करुणा / दया भाव", "Compassion makes human society stronger."),
            WordMeaning("Determined", "adj", "Having a firm decision", "दृढ़ निश्चयी", "A determined student achieves top board marks."),
            WordMeaning("Struggle", "noun", "Hard effort against difficulties", "संघर्ष / कठिन प्रयास", "Success often follows patient struggle."),
            WordMeaning("Courage", "noun", "Ability to face fear bravely", "साहस / हिम्मत", "Courage helps characters overcome obstacles."),
            WordMeaning("Empathy", "noun", "Understanding another's feelings", "समानुभूति / दूसरों का दर्द समझना", "Empathy builds trust between people."),
            WordMeaning("Wisdom", "noun", "Good judgment and deep knowledge", "बुद्धिमत्ता / विवेक", "Experience brings quiet wisdom."),
            WordMeaning("Resilience", "noun", "Strength to recover from hardship", "लचीलापन / विपरीत हालात से उबरना", "Resilience is a key theme in NCERT literature."),
            WordMeaning("Conscience", "noun", "Inner sense of right and wrong", "अंतरात्मा / विवेक", "Conscience guides honest choices."),
            WordMeaning("Triumph", "noun", "A great victory or achievement", "महान विजय / सफलता", "Hard work leads to triumph in exams.")
        )
        for (w in supplemental) {
            if (list.size >= 12) break
            if (list.none { it.word.equals(w.word, ignoreCase = true) }) {
                list += w
            }
        }
        return list
    }

    private fun defaultParagraphs(chapter: Chapter): List<ParagraphExplanation> = listOf(
        ParagraphExplanation(
            paragraphNumber = 1,
            headingHi = "प्रारंभ और पृष्ठभूमि (Introduction)",
            englishExcerpt = "In '${chapter.title}', ${chapter.author} introduces the central setting and the main characters.",
            simpleHindiExplanation = "इस पाठ की शुरुआत में लेखक ${chapter.author} कहानी के वातावरण और मुख्य पात्रों से हमारा परिचय कराते हैं। ${chapter.summaryHi}",
            keyTakeawayHi = "प्रारंभिक भाग पाठ की मुख्य समस्या या विचार को स्पष्ट करता है।"
        ),
        ParagraphExplanation(
            paragraphNumber = 2,
            headingHi = "कहानी का विकास (Rising Action)",
            englishExcerpt = "As events unfold in '${chapter.title}', the protagonist faces a meaningful challenge or turning point.",
            simpleHindiExplanation = "कहानी आगे बढ़ने पर मुख्य पात्र के सामने एक महत्वपूर्ण चुनौती आती है। यहीं से पात्र का धैर्य, बुद्धि और मानवीय गुण दिखाई देते हैं।",
            keyTakeawayHi = "कठिन परिस्थिति ही व्यक्ति के वास्तविक चरित्र को उजागर करती है।"
        ),
        ParagraphExplanation(
            paragraphNumber = 3,
            headingHi = "चरम बिंदु (Climax)",
            englishExcerpt = "The decisive moment tests character values, courage, and emotional strength.",
            simpleHindiExplanation = "यह पाठ का सबसे रोमांचक और निर्णायक भाग है, जहाँ मुख्य पात्र सही निर्णय लेकर स्थिति को संभालता है।",
            keyTakeawayHi = "सही समय पर लिया गया साहसिक निर्णय परिणाम बदल देता है।"
        ),
        ParagraphExplanation(
            paragraphNumber = 4,
            headingHi = "निष्कर्ष और सीख (Conclusion & Moral)",
            englishExcerpt = chapter.summaryEn,
            simpleHindiExplanation = "${chapter.hindiExplanation} अंततः यह पाठ MP बोर्ड के विद्यार्थियों को सकारात्मक सोच व नैतिक मूल्य सिखाता है।",
            keyTakeawayHi = "यह पाठ जीवन मूल्य और बोर्ड परीक्षा दोनों के लिए उपयोगी है।"
        )
    )

    private fun defaultCharacters(chapter: Chapter): List<CharacterSketch> = listOf(
        CharacterSketch(
            name = "Central Protagonist",
            nameHi = "मुख्य पात्र (${chapter.title})",
            roleHi = "कहानी का प्रमुख नायक / नायिका",
            traits = listOf("संवेदनशील", "साहसी", "ईमानदार"),
            sketchHi = "पाठ '${chapter.title}' में मुख्य पात्र परिस्थितियों का सामना धैर्य और विवेक से करता है। उनके व्यवहार से विद्यार्थियों को जिम्मेदारी व आत्मविश्वास की सीख मिलती है।",
            sketchEn = "In '${chapter.title}', the protagonist demonstrates resilience, sincerity, and moral clarity while facing life's challenges."
        ),
        CharacterSketch(
            name = chapter.author,
            nameHi = "${chapter.author} (लेखक / दृष्टिकोण)",
            roleHi = "रचनाकार एवं संदेशवाहक",
            traits = listOf("यथार्थवादी", "प्रेरणादायी", "मानवतावादी"),
            sketchHi = "${chapter.author} ने अत्यंत सरल और प्रभावशाली भाषा में '${chapter.title}' की रचना की है, ताकि विद्यार्थी जीवन की गहरी सच्चाइयों को आसानी से समझ सकें।",
            sketchEn = "${chapter.author} writes with clarity and empathy, blending relatable events with lasting human values."
        )
    )

    private fun defaultCartoonScenes(chapter: Chapter): List<CartoonScene> = listOf(
        CartoonScene(
            sceneNumber = 1,
            titleHi = "दृश्य 1: पाठ का परिचय",
            subtitleEn = "Welcome to '${chapter.title}'",
            narrationHi = "नमस्ते बच्चों! मैं हूँ इमरान सर। आज हम कक्षा ${chapter.classLevel} की किताब ${chapter.bookName} का पाठ '${chapter.title}' कार्टून कहानी से समझेंगे।",
            characterName = "Imran Sir",
            secondaryCharacter = chapter.author,
            settingType = CartoonSetting.CLASSROOM,
            mood = CartoonMood.HAPPY,
            actionLabel = "Intro Animation"
        ),
        CartoonScene(
            sceneNumber = 2,
            titleHi = "दृश्य 2: मुख्य घटना की शुरुआत",
            subtitleEn = "The Story Begins",
            narrationHi = chapter.summaryHi,
            characterName = "Main Hero",
            secondaryCharacter = "Companion",
            settingType = CartoonSetting.HOME_GARDEN,
            mood = CartoonMood.THOUGHTFUL,
            actionLabel = "Story Setup"
        ),
        CartoonScene(
            sceneNumber = 3,
            titleHi = "दृश्य 3: महत्वपूर्ण मोड़",
            subtitleEn = "Turning Point",
            narrationHi = "कहानी के इस भाग में मुख्य पात्र के सामने परीक्षा की घड़ी आती है, लेकिन हिम्मत और समझदारी से रास्ता निकलता है।",
            characterName = "Main Hero",
            secondaryCharacter = "Challenge",
            settingType = CartoonSetting.CITY_MARKET,
            mood = CartoonMood.DRAMATIC,
            actionLabel = "Climax Action"
        ),
        CartoonScene(
            sceneNumber = 4,
            titleHi = "दृश्य 4: शिक्षा और बोर्ड तैयारी",
            subtitleEn = "Key Moral & Board Tip",
            narrationHi = "तो बच्चों, '${chapter.title}' से हमें यही सीख मिलती है कि धैर्य और सच्चाई से हर कठिनाई जीती जा सकती है। अब 100 MCQ टेस्ट ज़रूर हल करें!",
            characterName = "Imran Sir",
            secondaryCharacter = "Students",
            settingType = CartoonSetting.CLASSROOM,
            mood = CartoonMood.INSPIRING,
            actionLabel = "Moral & Revision"
        )
    )

    private fun buildFillBlanks(
        chapter: Chapter,
        existingNonMcq: List<ChapterQuestion>,
        words: List<WordMeaning>,
        spec: ChapterRichSpec?
    ): List<ChapterQuestion> {
        val result = existingNonMcq.filter { it.type == QuestionType.FILL_BLANK }.toMutableList()
        var idx = result.size + 1

        spec?.extraFillBlanks?.forEach { (prompt, ans) ->
            result += ChapterQuestion(
                id = "${chapter.id}_fb_$idx",
                chapterId = chapter.id,
                classLevel = chapter.classLevel,
                type = QuestionType.FILL_BLANK,
                sourceTag = QuestionSourceTag.PRACTICE,
                promptEn = prompt,
                promptHi = "उपयुक्त शब्द भरकर वाक्य पूरा करें:",
                answerEn = ans,
                answerHi = "सही उत्तर: $ans",
                explanationHi = "सही रिक्त स्थान '$ans' है।"
            )
            idx++
        }

        if (result.none { it.answerEn.equals(chapter.author, ignoreCase = true) }) {
            result += ChapterQuestion(
                id = "${chapter.id}_fb_$idx",
                chapterId = chapter.id,
                classLevel = chapter.classLevel,
                type = QuestionType.FILL_BLANK,
                sourceTag = QuestionSourceTag.NCERT,
                promptEn = "The lesson '${chapter.title}' is written by ______.",
                promptHi = "'${chapter.title}' पाठ ______ द्वारा लिखा गया है।",
                answerEn = chapter.author,
                explanationHi = "'${chapter.title}' के लेखक ${chapter.author} हैं।"
            )
            idx++
        }

        if (result.none { it.answerEn.equals(chapter.bookName, ignoreCase = true) }) {
            result += ChapterQuestion(
                id = "${chapter.id}_fb_$idx",
                chapterId = chapter.id,
                classLevel = chapter.classLevel,
                type = QuestionType.FILL_BLANK,
                sourceTag = QuestionSourceTag.NCERT,
                promptEn = "'${chapter.title}' is included in the NCERT Class ${chapter.classLevel} book ______.",
                promptHi = "'${chapter.title}' कक्षा ${chapter.classLevel} की पुस्तक ______ में संकलित है।",
                answerEn = chapter.bookName,
                explanationHi = "यह पाठ ${chapter.bookName} पुस्तक का हिस्सा है।"
            )
            idx++
        }

        for (w in words) {
            if (result.size >= 10) break
            val sentence = w.exampleSentence
            if (sentence.contains(w.word, ignoreCase = true)) {
                val blanked = sentence.replace(Regex("\\b${Regex.escape(w.word)}\\b", RegexOption.IGNORE_CASE), "______")
                if (blanked.contains("______") && result.none { it.promptEn == blanked }) {
                    result += ChapterQuestion(
                        id = "${chapter.id}_fb_$idx",
                        chapterId = chapter.id,
                        classLevel = chapter.classLevel,
                        type = QuestionType.FILL_BLANK,
                        sourceTag = QuestionSourceTag.PRACTICE,
                        promptEn = blanked,
                        promptHi = "संकेत (हिंदी अर्थ): ${w.meaningHi}",
                        answerEn = w.word,
                        explanationHi = "यहाँ '${w.word}' (${w.meaningHi}) उपयुक्त शब्द है।"
                    )
                    idx++
                }
            }
        }
        var fbPad = 0
        while (result.size < 10 && fbPad < words.size) {
            val w = words[fbPad++]
            val prompt = "The English word meaning '${w.meaningHi}' in '${chapter.title}' is ______."
            if (result.none { it.promptEn == prompt }) {
                result += ChapterQuestion(
                    id = "${chapter.id}_fb_${idx++}",
                    chapterId = chapter.id,
                    classLevel = chapter.classLevel,
                    type = QuestionType.FILL_BLANK,
                    sourceTag = QuestionSourceTag.PRACTICE,
                    promptEn = prompt,
                    promptHi = "संकेत: ${w.meaningEn}",
                    answerEn = w.word,
                    explanationHi = "'${w.meaningHi}' के लिए सही अंग्रेजी शब्द '${w.word}' है।"
                )
            }
        }
        return result.take(10)
    }

    private fun buildTrueFalse(
        chapter: Chapter,
        existingNonMcq: List<ChapterQuestion>,
        characters: List<CharacterSketch>,
        spec: ChapterRichSpec?
    ): List<ChapterQuestion> {
        val result = existingNonMcq.filter { it.type == QuestionType.TRUE_FALSE }.toMutableList()
        var idx = result.size + 1

        fun addTf(statement: String, isTrue: Boolean, explainHi: String) {
            if (result.size >= 10) return
            if (result.any { it.promptEn == statement }) return
            val ans = if (isTrue) "True" else "False"
            result += ChapterQuestion(
                id = "${chapter.id}_tf_$idx",
                chapterId = chapter.id,
                classLevel = chapter.classLevel,
                type = QuestionType.TRUE_FALSE,
                sourceTag = QuestionSourceTag.PRACTICE,
                promptEn = statement,
                promptHi = explainHi,
                answerEn = ans,
                options = listOf("True", "False"),
                correctOptionIndex = if (isTrue) 0 else 1,
                explanationHi = explainHi
            )
            idx++
        }

        spec?.extraTrueFalse?.forEach { (stmt, truth) ->
            addTf(
                stmt,
                truth,
                if (truth) "यह कथन पाठ '${chapter.title}' के अनुसार बिल्कुल सत्य (True) है।"
                else "यह कथन पाठ '${chapter.title}' के तथ्यों के विपरीत होने के कारण असत्य (False) है।"
            )
        }

        addTf(
            "'${chapter.title}' was written by ${chapter.author}.",
            true,
            "सत्य: '${chapter.title}' के लेखक ${chapter.author} हैं।"
        )
        addTf(
            "'${chapter.title}' belongs to the NCERT Class ${chapter.classLevel} textbook '${chapter.bookName}'.",
            true,
            "सत्य: यह अध्याय कक्षा ${chapter.classLevel} की '${chapter.bookName}' पुस्तक में है।"
        )
        val wrongBook = allBooksPool.firstOrNull { it != chapter.bookName } ?: "Moments"
        addTf(
            "'${chapter.title}' is Chapter ${chapter.chapterNumber} of the textbook '$wrongBook'.",
            false,
            "असत्य: यह पाठ '${chapter.bookName}' का हिस्सा है, '$wrongBook' का नहीं।"
        )
        val mainChar = characters.firstOrNull()
        if (mainChar != null) {
            addTf(
                "${mainChar.name} is an important character in '${chapter.title}'.",
                true,
                "सत्य: ${mainChar.name} (${mainChar.nameHi}) इस पाठ के प्रमुख पात्र हैं।"
            )
        }
        val wrongAuthor = allAuthorsPool.firstOrNull { !it.equals(chapter.author, ignoreCase = true) } ?: "Ruskin Bond"
        addTf(
            "'${chapter.title}' was authored by $wrongAuthor.",
            false,
            "असत्य: इस पाठ के वास्तविक लेखक ${chapter.author} हैं।"
        )
        addTf(
            "Understanding English word meanings in Hindi helps students score higher in MP Board exams.",
            true,
            "सत्य: हिंदी में शब्दार्थ समझने से उत्तर लेखन सरल व सटीक होता है।"
        )
        addTf(
            "'${chapter.title}' has no moral message or human value for students.",
            false,
            "असत्य: यह अध्याय विद्यार्थियों को गहरे मानवीय मूल्य व जीवन संदेश देता है।"
        )
        val otherClass = if (chapter.classLevel == 9) 12 else 9
        addTf(
            "'${chapter.title}' is prescribed only for Class $otherClass and not Class ${chapter.classLevel}.",
            false,
            "असत्य: यह रचना MP Board कक्षा ${chapter.classLevel} के पाठ्यक्रम में शामिल है।"
        )
        addTf(
            if (chapter.category.equals("Poem", ignoreCase = true)) {
                "'${chapter.title}' is a poem featuring poetic devices, imagery, and a central idea."
            } else {
                "'${chapter.title}' uses meaningful events and characters to convey its core theme."
            },
            true,
            "सत्य: यह पाठ/कविता अपने मुख्य भाव और संदेश को प्रभावशाली ढंग से प्रस्तुत करती है।"
        )
        addTf(
            "Imran Gori Sir's bilingual notes explain '${chapter.title}' in simple Hindi for MP Board preparation.",
            true,
            "सत्य: सरल हिंदी व्याख्या से परीक्षा की तैयारी आसान और मजबूत होती है।"
        )
        addTf(
            "Students do not need to learn word meanings or extracts from '${chapter.title}'.",
            false,
            "असत्य: बोर्ड परीक्षा में शब्दार्थ और Extract Based Questions बहुत महत्वपूर्ण होते हैं।"
        )
        return result.take(10)
    }

    private fun buildThirtyImportantQAs(
        chapter: Chapter,
        existingNonMcq: List<ChapterQuestion>,
        paragraphs: List<ParagraphExplanation>,
        characters: List<CharacterSketch>,
        words: List<WordMeaning>,
        spec: ChapterRichSpec?,
        poemGuide: PoemStudyGuide? = null
    ): List<ChapterQuestion> {
        val qaTypes = setOf(QuestionType.VERY_SHORT, QuestionType.SHORT, QuestionType.LONG, QuestionType.BOARD_PYQ)
        val list = existingNonMcq.filter { it.type in qaTypes }.toMutableList()
        var counter = 1

        fun addQa(
            type: QuestionType,
            source: QuestionSourceTag,
            promptEn: String,
            promptHi: String,
            answerEn: String,
            answerHi: String,
            boardRef: String = ""
        ) {
            if (list.any { it.promptEn == promptEn }) return
            list += ChapterQuestion(
                id = "${chapter.id}_imp_${counter++}",
                chapterId = chapter.id,
                classLevel = chapter.classLevel,
                type = type,
                sourceTag = source,
                boardReference = boardRef,
                promptEn = promptEn,
                promptHi = promptHi,
                answerEn = answerEn,
                answerHi = answerHi
            )
        }

        // 0. If Poem, add Central Idea, Theme, Poet Intro & Poetic Devices Important QAs
        if (poemGuide != null) {
            addQa(
                type = QuestionType.LONG,
                source = QuestionSourceTag.MP_BOARD_VERIFIED,
                promptEn = "Write the Central Idea and Theme of the poem '${chapter.title}' by ${poemGuide.poetName}.",
                promptHi = "कविता '${chapter.title}' (${poemGuide.poetName}) का केंद्रीय भाव (Central Idea) और मुख्य विषय लिखिए।",
                answerEn = "Central Idea: ${poemGuide.centralIdeaEn}\nTheme: ${poemGuide.themeEn}",
                answerHi = "केंद्रीय भाव: ${poemGuide.centralIdeaHi}\nमुख्य विषय: ${poemGuide.themeHi}",
                boardRef = "Class ${chapter.classLevel} Board Exam Guaranteed Question"
            )
            addQa(
                type = QuestionType.SHORT,
                source = QuestionSourceTag.NCERT,
                promptEn = "Introduce the poet ${poemGuide.poetName} in the context of '${chapter.title}'.",
                promptHi = "कवि '${poemGuide.poetName}' का संक्षिप्त परिचय लिखिए।",
                answerEn = poemGuide.poetIntroEn,
                answerHi = poemGuide.poetIntroHi
            )
            poemGuide.poeticDevices.forEach { dev ->
                addQa(
                    type = QuestionType.SHORT,
                    source = QuestionSourceTag.PRACTICE,
                    promptEn = "Identify and explain the poetic device '${dev.deviceName}' used in '${chapter.title}'.",
                    promptHi = "कविता '${chapter.title}' में प्रयुक्त अलंकार '${dev.deviceNameHi}' को उदाहरण सहित समझाइए।",
                    answerEn = "${dev.deviceName}: Example — \"${dev.exampleLine}\".",
                    answerHi = dev.explanationHi
                )
            }
        }

        // 1. Chapter-authored Extra QAs
        spec?.extraQa?.forEach { qa ->
            addQa(
                type = qa.type,
                source = if (qa.isBoardPyq) QuestionSourceTag.MP_BOARD_VERIFIED else QuestionSourceTag.NCERT,
                promptEn = qa.promptEn,
                promptHi = qa.promptHi,
                answerEn = qa.answerEn,
                answerHi = qa.answerHi,
                boardRef = if (qa.isBoardPyq) "MP Board Important Question" else ""
            )
        }

        // 2. Character Sketch Q&As
        characters.forEach { ch ->
            addQa(
                type = QuestionType.LONG,
                source = QuestionSourceTag.NCERT,
                promptEn = "Write a character sketch of ${ch.name} from '${chapter.title}'.",
                promptHi = "पाठ '${chapter.title}' से '${ch.nameHi}' का चरित्र-चित्रण लिखिए।",
                answerEn = ch.sketchEn,
                answerHi = ch.sketchHi
            )
        }

        // 3. Paragraph / Stanza-wise Important Q&As
        paragraphs.forEach { p ->
            addQa(
                type = QuestionType.SHORT,
                source = QuestionSourceTag.PRACTICE,
                promptEn = "Explain Part ${p.paragraphNumber} of '${chapter.title}': \"${p.englishExcerpt.take(90)}...\"",
                promptHi = "भाग ${p.paragraphNumber} (${p.headingHi}) की सरल हिंदी व्याख्या व मुख्य शिक्षा लिखिए।",
                answerEn = "${p.englishExcerpt} — Key insight: ${p.keyTakeawayHi}",
                answerHi = "${p.simpleHindiExplanation} मुख्य सीख: ${p.keyTakeawayHi}"
            )
        }

        // 4. Fact-based Very Short Q&As
        spec?.extraFacts?.forEach { fact ->
            if (list.size < 30) {
                addQa(
                    type = QuestionType.VERY_SHORT,
                    source = if (fact.isNcert) QuestionSourceTag.NCERT else QuestionSourceTag.PRACTICE,
                    promptEn = fact.promptEn,
                    promptHi = fact.promptHi.ifBlank { "'${chapter.title}' पर आधारित महत्वपूर्ण प्रश्न:" },
                    answerEn = fact.correctAnswer,
                    answerHi = fact.explanationHi
                )
            }
        }

        // 5. Fill-in & Summary Board QAs
        addQa(
            type = QuestionType.LONG,
            source = QuestionSourceTag.MP_BOARD_VERIFIED,
            promptEn = "Write the complete summary and moral/theme of '${chapter.title}' in simple words.",
            promptHi = "'${chapter.title}' का संपूर्ण सारांश व नैतिक संदेश सरल शब्दों में लिखिए।",
            answerEn = chapter.summaryEn,
            answerHi = chapter.summaryHi,
            boardRef = "Class ${chapter.classLevel} Board Exam Long Q"
        )
        addQa(
            type = QuestionType.VERY_SHORT,
            source = QuestionSourceTag.NCERT,
            promptEn = "Which textbook and chapter number does '${chapter.title}' belong to?",
            promptHi = "'${chapter.title}' किस पुस्तक और अध्याय संख्या से संबंधित है?",
            answerEn = "Book: ${chapter.bookName}, Unit ${chapter.chapterNumber} (Class ${chapter.classLevel}, ${chapter.category}).",
            answerHi = "पुस्तक: ${chapter.bookName}, क्रमांक ${chapter.chapterNumber} (कक्षा ${chapter.classLevel}, ${chapter.category})।"
        )

        // 6. Vocabulary & Usage Q&As until at least 30 distinct Important Q&As are present
        words.forEach { w ->
            if (list.size < 30) {
                addQa(
                    type = QuestionType.VERY_SHORT,
                    source = QuestionSourceTag.PRACTICE,
                    promptEn = "Give the English meaning, Hindi meaning, and a sentence for '${w.word}' from '${chapter.title}'.",
                    promptHi = "'${w.word}' शब्द का हिंदी अर्थ बताइए और वाक्य में प्रयोग कीजिए।",
                    answerEn = "${w.word} (${w.partOfSpeech}): ${w.meaningEn}. Example: ${w.exampleSentence}",
                    answerHi = "'${w.word}' का हिंदी अर्थ '${w.meaningHi}' है।"
                )
            }
        }

        // Guarantee minimum 30 QAs even if a chapter has fewer words/facts
        var padIndex = 1
        while (list.size < 30) {
            val w = words[(padIndex - 1) % words.size]
            addQa(
                type = QuestionType.SHORT,
                source = QuestionSourceTag.PRACTICE,
                promptEn = "Revision Drill #$padIndex (${chapter.title}): How does the word '${w.word}' connect to the theme?",
                promptHi = "पुनरावृत्ति प्रश्न #$padIndex: '${w.word}' (${w.meaningHi}) इस पाठ/कविता के भाव से कैसे जुड़ता है?",
                answerEn = "'${w.word}' means '${w.meaningEn}'. Usage: ${w.exampleSentence}",
                answerHi = "सरल हिंदी व्याख्या: '${w.word}' का अर्थ '${w.meaningHi}' है और यह मुख्य भाव को स्पष्ट करता है।"
            )
            padIndex++
        }

        return list
    }

    private fun buildHundredMcqs(
        chapter: Chapter,
        existingMcqs: List<ChapterQuestion>,
        words: List<WordMeaning>,
        paragraphs: List<ParagraphExplanation>,
        characters: List<CharacterSketch>,
        fillBlanks: List<ChapterQuestion>,
        trueFalseList: List<ChapterQuestion>,
        spec: ChapterRichSpec?,
        poemGuide: PoemStudyGuide? = null,
        targetCount: Int = 100
    ): List<ChapterQuestion> {
        val result = existingMcqs.toMutableList()
        val seenPrompts = result.map { it.promptEn.lowercase() }.toMutableSet()
        var mcqNum = result.size + 1

        fun addMcq(
            promptEn: String,
            correct: String,
            distractors: List<String>,
            explanationHi: String,
            promptHi: String = "",
            sourceTag: QuestionSourceTag = QuestionSourceTag.PRACTICE
        ) {
            if (result.size >= targetCount) return
            val cleanPrompt = promptEn.trim()
            if (cleanPrompt.isBlank() || cleanPrompt.lowercase() in seenPrompts) return

            val distinctDistractors = distractors
                .map { it.trim() }
                .filter { it.isNotBlank() && !it.equals(correct.trim(), ignoreCase = true) }
                .distinct()
                .take(3)
                .toMutableList()

            val fallbackPool = listOf("None of these", "All of the above", "Not mentioned in chapter", "Cannot be determined")
            for (fb in fallbackPool) {
                if (distinctDistractors.size >= 3) break
                if (!fb.equals(correct, ignoreCase = true) && fb !in distinctDistractors) {
                    distinctDistractors += fb
                }
            }

            val correctIdx = mcqNum % 4
            val options = distinctDistractors.take(3).toMutableList()
            options.add(correctIdx.coerceIn(0, options.size), correct.trim())

            seenPrompts += cleanPrompt.lowercase()
            result += ChapterQuestion(
                id = "${chapter.id}_mcq_${mcqNum++}",
                chapterId = chapter.id,
                classLevel = chapter.classLevel,
                type = QuestionType.MCQ,
                sourceTag = sourceTag,
                promptEn = cleanPrompt,
                promptHi = promptHi,
                answerEn = correct.trim(),
                options = options.take(4),
                correctOptionIndex = correctIdx,
                explanationHi = explanationHi
            )
        }

        // 1. Authored chapter-specific plot/fact MCQs
        spec?.extraFacts?.forEach { fact ->
            addMcq(
                promptEn = fact.promptEn,
                correct = fact.correctAnswer,
                distractors = fact.distractors,
                explanationHi = fact.explanationHi,
                promptHi = fact.promptHi,
                sourceTag = if (fact.isNcert) QuestionSourceTag.NCERT else QuestionSourceTag.PRACTICE
            )
        }

        // 2. Core Textbook Metadata & Poetic Devices MCQs
        if (poemGuide != null) {
            addMcq(
                promptEn = "Who is the poet of '${chapter.title}'?",
                correct = poemGuide.poetName,
                distractors = allAuthorsPool.filter { !it.equals(poemGuide.poetName, ignoreCase = true) }.take(3),
                explanationHi = "कविता '${chapter.title}' के कवि/कवयित्री ${poemGuide.poetName} हैं।",
                sourceTag = QuestionSourceTag.NCERT
            )
            addMcq(
                promptEn = "What is the central idea of the poem '${chapter.title}'?",
                correct = poemGuide.centralIdeaEn.take(110),
                distractors = listOf(
                    "Only wealth brings happiness in modern cities",
                    "Nature should be replaced completely by machines",
                    "Students should avoid reading poetry for exams"
                ),
                explanationHi = "कविता का केंद्रीय भाव: ${poemGuide.centralIdeaHi}",
                sourceTag = QuestionSourceTag.NCERT
            )
            poemGuide.poeticDevices.forEach { dev ->
                val otherDevs = listOf("Simile", "Metaphor", "Alliteration", "Personification", "Imagery", "Oxymoron")
                    .filter { !dev.deviceName.contains(it, ignoreCase = true) }
                    .take(3)
                addMcq(
                    promptEn = "Which poetic device is highlighted in '${chapter.title}' by the line \"${dev.exampleLine.take(65)}\"?",
                    correct = dev.deviceName,
                    distractors = otherDevs,
                    explanationHi = dev.explanationHi,
                    sourceTag = QuestionSourceTag.NCERT
                )
            }
        } else {
            addMcq(
                promptEn = "Who is the author of the Class ${chapter.classLevel} lesson '${chapter.title}'?",
                correct = chapter.author,
                distractors = allAuthorsPool.filter { !it.equals(chapter.author, ignoreCase = true) }.take(3),
                explanationHi = "'${chapter.title}' के लेखक ${chapter.author} हैं।",
                promptHi = "'${chapter.title}' पाठ के लेखक कौन हैं?",
                sourceTag = QuestionSourceTag.NCERT
            )
        }
        addMcq(
            promptEn = "Which NCERT / MP Board textbook contains '${chapter.title}'?",
            correct = chapter.bookName,
            distractors = allBooksPool.filter { it != chapter.bookName }.take(3),
            explanationHi = "'${chapter.title}' पुस्तक '${chapter.bookName}' में संकलित है।",
            sourceTag = QuestionSourceTag.NCERT
        )
        addMcq(
            promptEn = "What is the Hindi title / theme name of '${chapter.title}'?",
            correct = chapter.titleHi.ifBlank { chapter.title },
            distractors = listOf("अंतिम यात्रा", "सच्चा मित्र", "खोया हुआ खजाना"),
            explanationHi = "'${chapter.title}' का हिंदी शीर्षक '${chapter.titleHi}' है।",
            sourceTag = QuestionSourceTag.NCERT
        )

        // 3. Character Sketch MCQs
        characters.forEachIndexed { idx, ch ->
            val otherChars = characters.filter { it.name != ch.name }.map { it.name } + listOf("Inspector General", "Village Postman", "School Clerk")
            addMcq(
                promptEn = "Which character in '${chapter.title}' fits the role: '${ch.roleHi}'?",
                correct = ch.name,
                distractors = otherChars.take(3),
                explanationHi = "${ch.name} (${ch.nameHi}) की भूमिका: ${ch.roleHi}।",
                sourceTag = QuestionSourceTag.NCERT
            )
            if (ch.traits.isNotEmpty()) {
                addMcq(
                    promptEn = "Which quality best describes ${ch.name} in '${chapter.title}'?",
                    correct = ch.traits.joinToString(", "),
                    distractors = listOf("स्वार्थी और आलसी", "क्रूर और अभिमानी", "लापरवाह और डरपोक"),
                    explanationHi = "${ch.nameHi} की प्रमुख विशेषताएँ: ${ch.traits.joinToString(", ")}।"
                )
            }
            addMcq(
                promptEn = "In '${chapter.title}', what is the Hindi name/title of ${ch.name}?",
                correct = ch.nameHi,
                distractors = listOf("गाँव का सिपाही", "विदेशी यात्री", "शहर का व्यापारी"),
                explanationHi = "${ch.name} को हिंदी में '${ch.nameHi}' के रूप में जाना जाता है।"
            )
            if (idx == 0) {
                addMcq(
                    promptEn = "Which lesson features the character '${ch.name}'?",
                    correct = chapter.title,
                    distractors = listOf("The Last Leaf", "The Necklace", "Discovering Tut"),
                    explanationHi = "${ch.name} पाठ '${chapter.title}' के प्रमुख पात्र हैं।"
                )
            }
        }

        // 4. Paragraph Sequence & Takeaway MCQs
        paragraphs.forEach { p ->
            val otherHeadings = paragraphs.filter { it.paragraphNumber != p.paragraphNumber }.map { it.headingHi }
            addMcq(
                promptEn = "What is discussed in Paragraph ${p.paragraphNumber} of '${chapter.title}'?",
                correct = p.headingHi,
                distractors = (otherHeadings + listOf("अंतिम प्रश्न पत्र नियम", "व्याकरण परीक्षा सारणी")).take(3),
                explanationHi = "अनुच्छेद ${p.paragraphNumber}: ${p.keyTakeawayHi}"
            )
            addMcq(
                promptEn = "What key lesson does Paragraph ${p.paragraphNumber} ('${p.headingHi}') teach?",
                correct = p.keyTakeawayHi,
                distractors = listOf(
                    "बिना मेहनत किए भी बड़ी सफलता मिल सकती है",
                    "दूसरों की मदद करना समय की बर्बादी है",
                    "पढ़ाई से जीवन में कोई बदलाव नहीं आता"
                ),
                explanationHi = "सरल हिंदी भावार्थ: ${p.keyTakeawayHi}"
            )
        }

        // 5. Vocabulary Word-Meaning MCQs (4 distinct question patterns per word = up to 48+ MCQs!)
        val wordHindiList = words.map { it.meaningHi } + allHindiPool
        val wordEnglishMeanings = words.map { it.meaningEn }
        val wordNames = words.map { it.word }

        words.forEachIndexed { wIdx, w ->
            // Pattern A: Word -> Hindi Meaning
            val hiDistractors = wordHindiList.filter { it != w.meaningHi }.distinct().take(3)
            addMcq(
                promptEn = "Choose the correct Hindi meaning of '${w.word}' (from '${chapter.title}'):",
                correct = w.meaningHi,
                distractors = hiDistractors,
                explanationHi = "'${w.word}' (${w.partOfSpeech}) का हिंदी अर्थ '${w.meaningHi}' (${w.meaningEn}) है।"
            )

            // Pattern B: Hindi Meaning -> English Word
            val enWordDistractors = wordNames.filter { !it.equals(w.word, ignoreCase = true) }.take(3)
            addMcq(
                promptEn = "Which English word from '${chapter.title}' means '${w.meaningHi}'?",
                correct = w.word,
                distractors = enWordDistractors,
                explanationHi = "'${w.meaningHi}' के लिए पाठ में प्रयुक्त अंग्रेजी शब्द '${w.word}' है।"
            )

            // Pattern C: Word -> English Meaning
            val enMeanDistractors = wordEnglishMeanings.filter { !it.equals(w.meaningEn, ignoreCase = true) }.take(3)
            addMcq(
                promptEn = "What is the correct English definition of '${w.word}'?",
                correct = w.meaningEn,
                distractors = enMeanDistractors,
                explanationHi = "'${w.word}' का अर्थ '${w.meaningEn}' (हिंदी: ${w.meaningHi}) होता है।"
            )

            // Pattern D: Part of Speech in context
            val posDistractors = allPartsOfSpeech.filter { it != w.partOfSpeech }
            addMcq(
                promptEn = "Identify the part of speech of '${w.word}' in '${chapter.title}' vocabulary:",
                correct = w.partOfSpeech,
                distractors = posDistractors,
                explanationHi = "'${w.word}' इस संदर्भ में एक '${w.partOfSpeech}' है।"
            )

            // Pattern E: Contextual Sentence Completion
            if (w.exampleSentence.contains(w.word, ignoreCase = true)) {
                val blankSentence = w.exampleSentence.replace(
                    Regex("\\b${Regex.escape(w.word)}\\b", RegexOption.IGNORE_CASE),
                    "______"
                )
                if (blankSentence.contains("______")) {
                    addMcq(
                        promptEn = "Complete the sentence from '${chapter.title}': \"$blankSentence\"",
                        correct = w.word,
                        distractors = enWordDistractors,
                        explanationHi = "यहाँ '${w.word}' (${w.meaningHi}) सही शब्द होगा।"
                    )
                }
            }

            // Pattern F: Spelling Check for vocabulary mastery
            if (w.word.length >= 5 && !w.word.contains(" ")) {
                val misspell1 = w.word.dropLast(1)
                val misspell2 = w.word + w.word.last()
                val misspell3 = w.word.replaceFirstChar { it.lowercase() }.reversed().replaceFirstChar { it.uppercase() }
                addMcq(
                    promptEn = "Choose the correctly spelt word from '${chapter.title}' meaning '${w.meaningHi}':",
                    correct = w.word,
                    distractors = listOf(misspell1, misspell2, misspell3),
                    explanationHi = "सही वर्तनी (Spelling) '${w.word}' है।"
                )
            }
        }

        // 6. Fill-in-the-blank & True/False variations as MCQs
        fillBlanks.forEach { fb ->
            val otherAns = wordNames.filter { !it.equals(fb.answerEn, ignoreCase = true) }.take(3)
            addMcq(
                promptEn = "Choose the correct word to fill the blank: ${fb.promptEn}",
                correct = fb.answerEn,
                distractors = otherAns,
                explanationHi = fb.explanationHi
            )
        }
        trueFalseList.forEach { tf ->
            addMcq(
                promptEn = "True or False according to '${chapter.title}': \"${tf.promptEn}\"",
                correct = tf.answerEn,
                distractors = listOf(
                    if (tf.answerEn.equals("True", true)) "False" else "True",
                    "Only partially in another chapter",
                    "Cannot be verified"
                ),
                explanationHi = tf.explanationHi
            )
        }

        // 7. Chapter-grounded MP Board Exam Grammar & Comprehension Drills to cleanly reach 100 MCQs
        val grammarDrills = buildChapterGrammarMcqs(chapter, words)
        grammarDrills.forEach { g ->
            addMcq(
                promptEn = g.promptEn,
                correct = g.answerEn,
                distractors = g.options.filter { it != g.answerEn },
                explanationHi = g.explanationHi
            )
        }

        // 8. Final safety loop using indexed vocabulary / sentence analysis if still < targetCount
        var safetyIdx = 1
        while (result.size < targetCount) {
            val w = words[(safetyIdx - 1) % words.size]
            val p = paragraphs[(safetyIdx - 1) % paragraphs.size]
            addMcq(
                promptEn = "Quick Revision #$safetyIdx ('${chapter.title}'): Which Hindi phrase accurately translates '${w.word}'?",
                correct = w.meaningHi,
                distractors = wordHindiList.filter { it != w.meaningHi }.shuffled().take(3),
                explanationHi = "'${w.word}' का सरल हिंदी अर्थ '${w.meaningHi}' है (भाग ${p.paragraphNumber} से जुड़ा शब्द)।"
            )
            if (result.size < targetCount) {
                addMcq(
                    promptEn = "Board Concept Check #$safetyIdx: In '${chapter.title}', Part ${p.paragraphNumber} emphasizes which core message?",
                    correct = p.keyTakeawayHi,
                    distractors = listOf(
                        "अत्यधिक क्रोध ही हर समस्या का हल है",
                        "किसी भी नियम का पालन आवश्यक नहीं है",
                        "असफलता के बाद प्रयास बंद कर देना चाहिए"
                    ),
                    explanationHi = "भाग ${p.paragraphNumber} की मुख्य सीख: ${p.keyTakeawayHi}"
                )
            }
            safetyIdx++
            if (safetyIdx > 50) break
        }

        return result.take(targetCount)
    }

    private fun buildChapterGrammarMcqs(chapter: Chapter, words: List<WordMeaning>): List<ChapterQuestion> {
        val w0 = words.getOrNull(0)?.word ?: "story"
        val w1 = words.getOrNull(1)?.word ?: "lesson"
        val title = chapter.title
        val author = chapter.author
        val level = chapter.classLevel

        val specs = listOf(
            Triple(
                "Choose the correct Passive Voice: '$author wrote $title.'",
                "'$title' was written by $author.",
                listOf("'$title' is written by $author.", "'$title' wrote by $author.", "'$title' had write by $author.")
            ) to "Past Simple Active (wrote) का Passive Voice 'was written by' बनता है।",

            Triple(
                "Choose the correct Tense in: 'Students are revising $title today.'",
                "Present Continuous Tense",
                listOf("Past Simple Tense", "Future Perfect Tense", "Past Perfect Continuous Tense")
            ) to "'are + V-ing' Present Continuous Tense की पहचान है।",

            Triple(
                "Select the right Modal: 'Class $level students ______ read $title carefully for board exams.'",
                "should",
                listOf("ought", "needn't to", "would to")
            ) to "सलाह या कर्तव्य बताने के लिए 'should' मोडल का प्रयोग होता है।",

            Triple(
                "Select the correct Preposition: '$title is included ______ ${chapter.bookName}.'",
                "in",
                listOf("into", "between", "under")
            ) to "किसी पुस्तक में शामिल होने के लिए 'included in' का प्रयोग होता है।",

            Triple(
                "Choose the correct Article: '$title is ______ inspiring NCERT chapter.'",
                "an",
                listOf("a", "few", "many")
            ) to "'inspiring' स्वर ध्वनि (vowel sound) से शुरू होता है, इसलिए 'an' लगेगा।",

            Triple(
                "Change into Indirect Speech: The teacher said, \"Read $title carefully.\"",
                "The teacher advised the students to read $title carefully.",
                listOf("The teacher said read $title carefully.", "The teacher asked that read $title.", "The teacher told to read $title.")
            ) to "आदेश या सलाह वाले वाक्य को Indirect Speech में 'advised ... to + V1' से बदलते हैं।",

            Triple(
                "Identify the correct Question Tag: 'You enjoyed $title, ______?'",
                "didn't you",
                listOf("don't you", "aren't you", "hadn't you")
            ) to "'enjoyed' (V2) सकारात्मक वाक्य है, अतः Question Tag 'didn't you' होगा।",

            Triple(
                "Choose the correct Verb form: 'Neither the summary nor the notes of $title ______ difficult.'",
                "are",
                listOf("is being", "was were", "has")
            ) to "Neither...nor में निकटतम कर्ता ('notes' - बहुवचन) के अनुसार क्रिया 'are' आती है।",

            Triple(
                "Pick the correct Comparative sentence about '$title':",
                "'$title' is more memorable than many other prose pieces.",
                listOf("'$title' is most memorable than other prose pieces.", "'$title' is memorabler than other prose pieces.", "'$title' is very memorable than other prose pieces.")
            ) to "दो से अधिक अक्षरों वाले विशेषण (memorable) का Comparative 'more + adjective + than' होता है।",

            Triple(
                "Fill in the correct Conjunction: 'Study the Hindi summary ______ you remember every detail of $title.'",
                "so that",
                listOf("unless", "despite", "although")
            ) to "उद्देश्य बताने के लिए 'so that' (ताकि) संयोजक का प्रयोग होता है।",

            Triple(
                "Which noun form matches the word '$w0' in academic writing?",
                w0.replaceFirstChar { it.uppercase() },
                listOf("${w0}lyly", "un${w0}ingness", "${w0}edly")
            ) to "मूल शब्द का सही मानक रूप पहचानना परीक्षा की दृष्टि से उपयोगी है।",

            Triple(
                "Identify the correct Article: '${chapter.bookName} is ______ prescribed textbook for Class $level.'",
                "a",
                listOf("an", "those", "these")
            ) to "'prescribed' व्यंजन ध्वनि (consonant sound) से शुरू होता है, इसलिए 'a' का प्रयोग होगा।",

            Triple(
                "Choose the correct preposition: 'Imran Gori Sir explains '$title' ______ simple Hindi.'",
                "in",
                listOf("at", "on", "above")
            ) to "भाषा का माध्यम बताने के लिए 'in' (जैसे in simple Hindi) का प्रयोग होता है।",

            Triple(
                "Convert to Negative: 'She remembers the theme of $title.'",
                "She does not remember the theme of $title.",
                listOf("She do not remembers the theme of $title.", "She did not remembers the theme of $title.", "She is not remember the theme of $title.")
            ) to "Present Simple में एकवचन कर्ता के साथ 'does not + V1' आता है।",

            Triple(
                "Choose the correct Determiner: 'Have you solved ______ MCQs from $title?'",
                "many",
                listOf("much", "little", "less")
            ) to "'MCQs' गणनीय बहुवचन संज्ञा (countable plural) है, इसलिए 'many' आएगा।",

            Triple(
                "Spot the correct active voice of: 'The word '$w1' was explained by Imran Sir.'",
                "Imran Sir explained the word '$w1'.",
                listOf("Imran Sir explains the word '$w1'.", "Imran Sir was explain the word '$w1'.", "Imran Sir had explaining the word '$w1'.")
            ) to "Past Simple Passive ('was explained') का Active 'explained' (V2) होता है।"
        )

        return specs.mapIndexed { idx, (triple, explainHi) ->
            ChapterQuestion(
                id = "${chapter.id}_gr_mcq_$idx",
                chapterId = chapter.id,
                classLevel = chapter.classLevel,
                type = QuestionType.MCQ,
                sourceTag = QuestionSourceTag.PRACTICE,
                promptEn = triple.first,
                answerEn = triple.second,
                options = listOf(triple.second) + triple.third,
                correctOptionIndex = 0,
                explanationHi = explainHi
            )
        }
    }
}
