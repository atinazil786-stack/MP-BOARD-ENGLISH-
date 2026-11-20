package com.example.data.model

enum class QuestionType(val labelEn: String, val labelHi: String) {
    VERY_SHORT("Very Short Answer", "अति लघु उत्तरीय प्रश्न"),
    SHORT("Short Answer", "लघु उत्तरीय प्रश्न"),
    LONG("Long Answer", "दीर्घ उत्तरीय प्रश्न"),
    MCQ("Multiple Choice Questions", "बहुविकल्पीय प्रश्न"),
    FILL_BLANK("Fill in the Blanks", "रिक्त स्थान भरिए"),
    TRUE_FALSE("True and False", "सत्य / असत्य"),
    MATCH("Match the Following", "सही जोड़ी बनाइए"),
    EXTRACT("Extract Based Questions", "गद्यांश / पद्यांश आधारित प्रश्न"),
    BOARD_PYQ("Important Board Questions", "महत्वपूर्ण बोर्ड परीक्षा प्रश्न")
}

enum class QuestionSourceTag(val badgeText: String, val badgeHi: String) {
    NCERT("NCERT Syllabus", "NCERT पाठ्यक्रम"),
    MP_BOARD_VERIFIED("MP Board Verified", "MP बोर्ड प्रमाणित"),
    PRACTICE("Practice Bank", "अभ्यास प्रश्न"),
    AI_GENERATED("AI Practice (Gemini)", "AI अभ्यास प्रश्न"),
    ADMIN_ADDED("Imran Sir Update", "इमरान सर अपडेट")
}

enum class ChapterSection(val order: Int, val titleEn: String, val titleHi: String) {
    CHAPTER_LIST(1, "Chapter List", "अध्याय सूची"),
    CARTOON_VIDEO(2, "2D Cartoon Video", "2D कार्टून एनीमेशन वीडियो"),
    SUMMARY(3, "Hindi & Eng Summary", "अध्याय सारांश (सरल हिंदी)"),
    THEME_AND_POET(4, "Theme, Message & Poet", "मुख्य विषय, संदेश एवं कवि परिचय"),
    HINDI_EXPLANATION(5, "Detailed Hindi", "संपूर्ण सरल हिंदी व्याख्या"),
    PARAGRAPH_EXPLANATION(6, "Paragraph / Stanza Hindi", "अनुच्छेद / पद्यांश हिंदी व्याख्या"),
    POETIC_DEVICES(7, "Poetic Devices", "काव्य सौंदर्य एवं अलंकार"),
    WORD_MEANINGS(8, "Word Meanings", "अंग्रेजी शब्दार्थ हिंदी में"),
    CHARACTER_SKETCHES(9, "Character Sketches", "पात्रों का चरित्र-चित्रण"),
    IMPORTANT_QA(10, "Important Q&A", "महत्वपूर्ण प्रश्नोत्तर"),
    VERY_SHORT(11, "Very Short Answer", "अति लघु उत्तरीय"),
    SHORT_ANSWER(12, "Short Answer", "लघु उत्तरीय"),
    LONG_ANSWER(13, "Long Answer", "दीर्घ उत्तरीय"),
    MCQ(14, "MCQs Practice", "बहुविकल्पीय प्रश्न (MCQs)"),
    FILL_BLANKS(15, "Fill in the Blanks", "रिक्त स्थान भरिए"),
    TRUE_FALSE(16, "True and False", "सत्य / असत्य"),
    MATCH_FOLLOWING(17, "Match the Following", "सही जोड़ी मिलाइए"),
    EXTRACT_BASED(18, "Extract Based", "गद्यांश / पद्यांश आधारित प्रश्न"),
    BOARD_QUESTIONS(19, "Important Board Qs", "महत्वपूर्ण बोर्ड प्रश्न"),
    CHAPTER_TEST(20, "Chapter-Wise Test", "अध्याय-वार ऑनलाइन टेस्ट")
}

enum class CartoonSetting {
    CLASSROOM,
    FARM_STORM,
    HOME_GARDEN,
    OCEAN_SHIP,
    CITY_MARKET,
    ROYAL_PALACE,
    MOUNTAIN_LAB
}

enum class CartoonMood {
    HAPPY,
    THOUGHTFUL,
    DRAMATIC,
    INSPIRING,
    MYSTERY
}

data class CartoonScene(
    val sceneNumber: Int,
    val titleHi: String,
    val subtitleEn: String,
    val narrationHi: String,
    val characterName: String,
    val secondaryCharacter: String = "",
    val settingType: CartoonSetting = CartoonSetting.CLASSROOM,
    val mood: CartoonMood = CartoonMood.INSPIRING,
    val actionLabel: String = "Story Scene",
    val durationSeconds: Int = 8
)

data class ParagraphExplanation(
    val paragraphNumber: Int,
    val headingHi: String,
    val englishExcerpt: String,
    val simpleHindiExplanation: String,
    val keyTakeawayHi: String
)

data class CharacterSketch(
    val name: String,
    val nameHi: String,
    val roleHi: String,
    val traits: List<String>,
    val sketchHi: String,
    val sketchEn: String
)

data class PoeticDeviceItem(
    val deviceName: String,
    val deviceNameHi: String,
    val exampleLine: String,
    val explanationHi: String
)

data class PoemStanzaExplanation(
    val stanzaNumber: Int,
    val englishStanza: String,
    val hindiTranslation: String,
    val simpleHindiExplanation: String,
    val poeticNoteHi: String
)

data class PoemStudyGuide(
    val poetName: String,
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

data class ClassCourseInfo(
    val classLevel: Int,
    val titleEn: String,
    val titleHi: String,
    val books: List<String>,
    val taglineEn: String,
    val taglineHi: String
)

data class WordMeaning(
    val word: String,
    val partOfSpeech: String,
    val meaningEn: String,
    val meaningHi: String,
    val exampleSentence: String
)

data class MatchPair(
    val left: String,
    val right: String
)

data class ChapterQuestion(
    val id: String,
    val chapterId: String,
    val classLevel: Int,
    val type: QuestionType,
    val sourceTag: QuestionSourceTag = QuestionSourceTag.NCERT,
    val boardReference: String = "",
    val promptEn: String,
    val promptHi: String = "",
    val answerEn: String,
    val answerHi: String = "",
    val options: List<String> = emptyList(),
    val correctOptionIndex: Int = -1,
    val matchPairs: List<MatchPair> = emptyList(),
    val extractText: String = "",
    val explanationHi: String = ""
)

data class Chapter(
    val id: String,
    val classLevel: Int,
    val bookName: String,
    val chapterNumber: Int,
    val title: String,
    val titleHi: String = "",
    val author: String,
    val category: String = "Prose", // "Prose", "Poem", or "Supplementary"
    val summaryEn: String,
    val summaryHi: String,
    val hindiExplanation: String,
    val wordMeanings: List<WordMeaning>,
    val questions: List<ChapterQuestion>,
    val paragraphExplanations: List<ParagraphExplanation> = emptyList(),
    val characterSketches: List<CharacterSketch> = emptyList(),
    val cartoonScenes: List<CartoonScene> = emptyList(),
    val themeEn: String = "",
    val themeHi: String = "",
    val messageHi: String = "",
    val poemDetails: PoemStudyGuide? = null,
    val isAdminAdded: Boolean = false
)

data class GrammarExample(
    val english: String,
    val hindi: String,
    val note: String = ""
)

data class GrammarTopic(
    val id: String,
    val title: String,
    val titleHi: String,
    val category: String,
    val formula: String,
    val explanationHi: String,
    val rulesSummaryEn: String,
    val examples: List<GrammarExample>,
    val practiceQuestions: List<ChapterQuestion>,
    val mcqQuestions: List<ChapterQuestion>,
    val isAdminAdded: Boolean = false
)

data class DailyVocabWord(
    val id: String,
    val word: String,
    val partOfSpeech: String,
    val pronunciation: String,
    val meaningEn: String,
    val meaningHi: String,
    val synonym: String,
    val antonym: String,
    val exampleEn: String,
    val exampleHi: String
)

enum class ExamMode(val code: String, val titleEn: String, val titleHi: String, val questionCount: Int, val durationMinutes: Int) {
    TEST_20("20Q", "20 Questions Quick Exam", "20 प्रश्न त्वरित परीक्षा", 20, 15),
    TEST_50("50Q", "50 Questions Practice Set", "50 प्रश्न अभ्यास परीक्षा", 50, 40),
    TEST_100("100Q", "100 Questions Mega Mock", "100 प्रश्न महा-मॉक टेस्ट", 100, 90),
    CHAPTER_WISE("CHAPTER", "Chapter Wise Test", "अध्याय-वार टेस्ट", 20, 15),
    FULL_SYLLABUS("FULL_SYLLABUS", "Full Syllabus Board Exam", "पूर्ण पाठ्यक्रम बोर्ड परीक्षा", 40, 45),
    DAILY_QUIZ("DAILY_QUIZ", "Daily 5-Min Quiz", "दैनिक 5-मिनट क्विज़", 5, 5)
}

data class ActiveExamPaper(
    val title: String,
    val mode: ExamMode,
    val classLevel: Int,
    val durationSeconds: Int,
    val questions: List<ChapterQuestion>
)
