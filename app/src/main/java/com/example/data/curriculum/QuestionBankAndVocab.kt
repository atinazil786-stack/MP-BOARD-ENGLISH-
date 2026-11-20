package com.example.data.curriculum

import com.example.data.model.ChapterQuestion
import com.example.data.model.ClassCourseInfo
import com.example.data.model.DailyVocabWord
import com.example.data.model.QuestionSourceTag
import com.example.data.model.QuestionType

object QuestionBankAndVocab {

    val classCourses: List<ClassCourseInfo> = listOf(
        ClassCourseInfo(
            classLevel = 9,
            titleEn = "Class 9th",
            titleHi = "कक्षा 9वीं",
            books = listOf("Beehive", "Moments"),
            taglineEn = "Foundation Literature, Prose, Poetry & Grammar",
            taglineHi = "आधारभूत साहित्य, गद्य, पद्य एवं व्याकरण"
        ),
        ClassCourseInfo(
            classLevel = 10,
            titleEn = "Class 10th",
            titleHi = "कक्षा 10वीं",
            books = listOf("First Flight", "Footprints Without Feet"),
            taglineEn = "High School Board Mastery & Writing Skills",
            taglineHi = "हाईस्कूल बोर्ड परीक्षा तैयारी व लेखन कौशल"
        ),
        ClassCourseInfo(
            classLevel = 11,
            titleEn = "Class 11th",
            titleHi = "कक्षा 11वीं",
            books = listOf("Hornbill", "Snapshots"),
            taglineEn = "Advanced Comprehension, Reading & Expression",
            taglineHi = "उच्चतर माध्यमिक गहन अध्ययन एवं अभिव्यक्ति"
        ),
        ClassCourseInfo(
            classLevel = 12,
            titleEn = "Class 12th",
            titleHi = "कक्षा 12वीं",
            books = listOf("Flamingo", "Vistas"),
            taglineEn = "Higher Secondary Board Excellence & Extracts",
            taglineHi = "हायर सेकेंडरी बोर्ड श्रेष्ठता एवं विश्लेषण"
        )
    )

    val dailyVocabulary: List<DailyVocabWord> = listOf(
        DailyVocabWord("v1", "Perseverance", "noun", "पर-सि-विअर-अंस", "Continued effort despite difficulties", "दृढ़ता / लगातार प्रयास", "Persistence", "Laziness", "Success comes through perseverance.", "सफलता निरंतर प्रयास से मिलती है।"),
        DailyVocabWord("v2", "Eloquent", "adj", "एल-ओ-क्वेंट", "Fluent and persuasive in speaking or writing", "वाक्पटु / प्रभावशाली", "Articulate", "Inarticulate", "She delivered an eloquent speech on Republic Day.", "उसने गणतंत्र दिवस पर प्रभावशाली भाषण दिया।"),
        DailyVocabWord("v3", "Compassion", "noun", "कम-पै-शन", "Sympathetic pity and concern for others", "करुणा / दया", "Empathy", "Cruelty", "True education teaches compassion.", "सच्ची शिक्षा करुणा सिखाती है।"),
        DailyVocabWord("v4", "Resilient", "adj", "रि-ज़िल-िएंट", "Able to recover quickly from hardship", "लचीला / हिम्मत न हारने वाला", "Strong", "Fragile", "Students must stay resilient during exams.", "परीक्षा के समय विद्यार्थियों को हिम्मत बनाए रखनी चाहिए।"),
        DailyVocabWord("v5", "Diligent", "adj", "डिल-इ-जेंट", "Hardworking and careful in duties", "परिश्रमी / मेहनती", "Industrious", "Careless", "Diligent learners always score higher.", "मेहनती विद्यार्थी सदैव उच्च अंक पाते हैं।"),
        DailyVocabWord("v6", "Inevitable", "adj", "इन-एव-इ-टेबल", "Certain to happen; unavoidable", "अपरिहार्य / अटल", "Unavoidable", "Preventable", "Change is an inevitable part of life.", "परिवर्तन जीवन का अटल हिस्सा है।"),
        DailyVocabWord("v7", "Benevolent", "adj", "बे-नेव-ओ-लेंट", "Well-meaning and kindly", "परोपकारी / दयालु", "Generous", "Cruel", "The benevolent teacher helped every child.", "दयालु शिक्षक ने हर बच्चे की मदद की।"),
        DailyVocabWord("v8", "Optimistic", "adj", "ऑप-टि-मिस्-टिक", "Hopeful and confident about the future", "आशावादी", "Hopeful", "Pessimistic", "Stay optimistic before your MP Board result.", "बोर्ड परीक्षा परिणाम से पहले आशावादी रहें।"),
        DailyVocabWord("v9", "Gratitude", "noun", "ग्रैट-इ-ट्यूड", "Quality of being thankful", "कृतज्ञता / आभार", "Thankfulness", "Ingratitude", "Express gratitude to your parents and teachers.", "अपने माता-पिता व शिक्षकों के प्रति आभार व्यक्त करें।"),
        DailyVocabWord("v10", "Profound", "adj", "प्रो-फाउंड", "Very deep or intense", "गहन / गहरा", "Deep", "Superficial", "Books leave a profound impact on young minds.", "किताबें युवा मन पर गहरा प्रभाव छोड़ती हैं।"),
        DailyVocabWord("v11", "Vigilant", "adj", "विज-इ-लेंट", "Keeping careful watch for danger", "सतर्क / सावधान", "Alert", "Negligent", "Be vigilant while reading tricky exam questions.", "कठिन प्रश्न पढ़ते समय सतर्क रहें।"),
        DailyVocabWord("v12", "Harmony", "noun", "हार-म-नी", "Peaceful agreement and unity", "सामंजस्य / सद्भाव", "Unity", "Discord", "Dr. Kalam celebrated communal harmony.", "डॉ. कलाम ने सामाजिक सद्भाव का संदेश दिया।")
    )

    val extraPracticeMcqs: List<ChapterQuestion> = listOf(
        mcq("eb1", 9, "Choose the correct synonym of 'Brave':", listOf("Timid", "Courageous", "Weak", "Afraid"), 1, "'Brave' का अर्थ बहादुर है, जिसका समानार्थी 'Courageous' है।"),
        mcq("eb2", 9, "What is the antonym of 'Ancient'?", listOf("Old", "Modern", "Past", "Historic"), 1, "'Ancient' (प्राचीन) का विलोम 'Modern' (आधुनिक) होता है।"),
        mcq("eb3", 9, "Identify the noun form of 'Educate':", listOf("Educated", "Education", "Educational", "Educating"), 1, "'Educate' क्रिया का संज्ञा रूप 'Education' है।"),
        mcq("eb4", 9, "In Robert Frost's poem 'The Road Not Taken', what do the two roads symbolize?", listOf("Traffic rules", "Choices in life", "Mountain paths", "Village streets"), 1, "दो सड़कें जीवन में लिए जाने वाले निर्णयों/विकल्पों का प्रतीक हैं।"),
        mcq("eb5", 9, "In 'Wind', Subramania Bharati advises us to make our hearts:", listOf("Weak", "Steadfast", "Fearful", "Fragile"), 1, "कवि कहते हैं कि हमें अपने हृदय को दृढ़ (steadfast) बनाना चाहिए।"),
        mcq("eb6", 10, "In 'Dust of Snow', which tree shook snow onto the poet?", listOf("Oak tree", "Hemlock tree", "Pine tree", "Banyan tree"), 1, "हेमलॉक (धतूरा) वृक्ष पर बैठे कौए ने कवि पर बर्फ झाड़ी।"),
        mcq("eb7", 10, "What do 'Fire' and 'Ice' symbolize in Frost's poem 'Fire and Ice'?", listOf("Heat and cold", "Desire and hatred", "Rain and sun", "Joy and sorrow"), 1, "'Fire' असीम इच्छा/लोभ और 'Ice' घृणा/उदासीनता का प्रतीक है।"),
        mcq("eb8", 10, "In 'A Tiger in the Zoo', where does the tiger belong naturally?", listOf("In a concrete cell", "In the jungle near the water hole", "In a circus", "In a city street"), 1, "बाघ का प्राकृतिक निवास जंगल और जलाशय के पास है।"),
        mcq("eb9", 10, "What is the antonym of 'Optimistic'?", listOf("Hopeful", "Bright", "Pessimistic", "Cheerful"), 2, "'Optimistic' (आशावादी) का विलोम 'Pessimistic' (निराशावादी) है।"),
        mcq("eb10", 10, "Choose the correct spelling:", listOf("Recieve", "Receive", "Receeve", "Recive"), 1, "सही वर्तनी 'Receive' (R-e-c-e-i-v-e) है।"),
        mcq("eb11", 11, "In 'A Photograph' by Shirley Toulson, how old was the poet's mother in the snapshot?", listOf("Around twelve years", "Twenty years", "Five years", "Thirty years"), 0, "समुद्र तट की तस्वीर में कवयित्री की माँ लगभग बारह वर्ष की थीं।"),
        mcq("eb12", 11, "In 'The Voice of the Rain', who calls itself the 'Poem of Earth'?", listOf("The Wind", "The Rain", "The Cloud", "The Sea"), 1, "वर्षा स्वयं को 'पृथ्वी की कविता' (Poem of Earth) कहती है।"),
        mcq("eb13", 11, "Which bird visits the Laburnum tree in Ted Hughes' poem?", listOf("Sparrow", "Goldfinch", "Cuckoo", "Eagle"), 1, "गोल्डफिंच (Goldfinch) पक्षी अमलतास के पेड़ पर अपने बच्चों को खिलाने आती है।"),
        mcq("eb14", 12, "In 'My Mother at Sixty-six', Kamala Das compares her mother's pale face to:", listOf("A blooming rose", "A late winter's moon", "A bright star", "A summer cloud"), 1, "कवयित्री ने अपनी माँ के पीले चेहरे की तुलना 'देर सर्दी के चंद्रमा' से की है।"),
        mcq("eb15", 12, "Who wrote the poem 'Keeping Quiet'?", listOf("John Keats", "Pablo Neruda", "Robert Frost", "Kamala Das"), 1, "'Keeping Quiet' के कवि पाब्लो नेरुदा (Pablo Neruda) हैं।"),
        mcq("eb16", 12, "According to John Keats, 'A thing of beauty is a ______ forever.'", listOf("pain", "joy", "dream", "shadow"), 1, "जॉन कीट्स की प्रसिद्ध पंक्ति: 'A thing of beauty is a joy forever.'"),
        mcq("eb17", 12, "In 'Aunt Jennifer's Tigers', what do the prancing tigers symbolize?", listOf("Fear and weakness", "Fearlessness and freedom", "Sorrow", "Old age"), 1, "कढ़ाई के बाघ निर्भयता और स्वतंत्रता के प्रतीक हैं।"),
        mcq("eb18", 12, "Choose the one-word substitution for 'One who knows everything':", listOf("Omnipotent", "Omniscient", "Omnipresent", "Optimist"), 1, "सब कुछ जानने वाला 'Omniscient' (सर्वज्ञ) कहलाता है।"),
        mcq("eb19", 10, "Choose the meaning of the idiom 'A piece of cake':", listOf("A sweet dish", "A very easy task", "A difficult puzzle", "A birthday gift"), 1, "'A piece of cake' मुहावरे का अर्थ 'बहुत आसान कार्य' होता है।"),
        mcq("eb20", 11, "Choose the correct passive: 'Someone has stolen my watch.'", listOf("My watch has stolen.", "My watch has been stolen.", "My watch was stolen.", "My watch is been stolen."), 1, "Present Perfect Passive में has/have + been + V3 का प्रयोग होता है।")
    )

    private fun mcq(
        id: String,
        classLevel: Int,
        prompt: String,
        options: List<String>,
        correctIdx: Int,
        explanationHi: String
    ) = ChapterQuestion(
        id = id,
        chapterId = "practice_bank",
        classLevel = classLevel,
        type = QuestionType.MCQ,
        sourceTag = QuestionSourceTag.PRACTICE,
        promptEn = prompt,
        answerEn = options[correctIdx],
        options = options,
        correctOptionIndex = correctIdx,
        explanationHi = explanationHi
    )

    fun buildExamQuestions(
        allChapters: List<com.example.data.model.Chapter>,
        allGrammar: List<com.example.data.model.GrammarTopic>,
        extraQuestions: List<ChapterQuestion>,
        targetCount: Int,
        classFilter: Int? = null,
        chapterIdFilter: String? = null
    ): List<ChapterQuestion> {
        val pool = mutableListOf<ChapterQuestion>()
        if (chapterIdFilter != null) {
            allChapters.filter { it.id == chapterIdFilter }.forEach { ch ->
                pool += ch.questions.filter { it.options.isNotEmpty() && it.correctOptionIndex >= 0 }
            }
            pool += extraQuestions.filter {
                it.chapterId == chapterIdFilter && it.options.isNotEmpty() && it.correctOptionIndex >= 0
            }
        } else {
            val filteredChapters = if (classFilter != null) {
                allChapters.filter { it.classLevel == classFilter }
            } else {
                allChapters
            }
            filteredChapters.forEach { ch ->
                pool += ch.questions.filter { it.options.isNotEmpty() && it.correctOptionIndex >= 0 }
            }
            pool += extraQuestions.filter {
                (classFilter == null || it.classLevel == classFilter) &&
                    it.options.isNotEmpty() && it.correctOptionIndex >= 0
            }
            allGrammar.forEach { gr ->
                pool += gr.mcqQuestions.filter { it.options.isNotEmpty() && it.correctOptionIndex >= 0 }
            }
            pool += extraPracticeMcqs.filter { classFilter == null || it.classLevel == classFilter }
            // Also include remaining class/general MCQs if larger test count (50Q / 100Q) requested
            if (pool.size < targetCount) {
                allChapters.forEach { ch ->
                    pool += ch.questions.filter { it.options.isNotEmpty() && it.correctOptionIndex >= 0 }
                }
                pool += extraPracticeMcqs
            }
        }

        val distinct = pool.distinctBy { it.id }.shuffled()
        if (distinct.isEmpty()) return emptyList()
        if (distinct.size >= targetCount) return distinct.take(targetCount)

        // For 50Q / 100Q mega tests or small chapters, extend cleanly up to targetCount with fresh IDs
        val result = distinct.toMutableList()
        var idx = 0
        while (result.size < targetCount) {
            val base = distinct[idx % distinct.size]
            result += base.copy(id = "${base.id}_rep_${result.size}")
            idx++
        }
        return result
    }
}
