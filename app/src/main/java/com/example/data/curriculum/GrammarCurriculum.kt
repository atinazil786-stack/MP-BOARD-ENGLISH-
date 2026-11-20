package com.example.data.curriculum

import com.example.data.model.ChapterQuestion
import com.example.data.model.GrammarExample
import com.example.data.model.GrammarTopic
import com.example.data.model.QuestionSourceTag
import com.example.data.model.QuestionType

object GrammarCurriculum {

    private fun gMcq(
        id: String,
        topicId: String,
        prompt: String,
        options: List<String>,
        correctIdx: Int,
        explanationHi: String
    ) = ChapterQuestion(
        id = id,
        chapterId = topicId,
        classLevel = 10,
        type = QuestionType.MCQ,
        sourceTag = QuestionSourceTag.PRACTICE,
        promptEn = prompt,
        answerEn = options[correctIdx],
        options = options,
        correctOptionIndex = correctIdx,
        explanationHi = explanationHi
    )

    private fun gPractice(
        id: String,
        topicId: String,
        promptEn: String,
        promptHi: String,
        answerEn: String,
        answerHi: String
    ) = ChapterQuestion(
        id = id,
        chapterId = topicId,
        classLevel = 10,
        type = QuestionType.SHORT,
        sourceTag = QuestionSourceTag.PRACTICE,
        promptEn = promptEn,
        promptHi = promptHi,
        answerEn = answerEn,
        answerHi = answerHi
    )

    val topics: List<GrammarTopic> = listOf(
        GrammarTopic(
            id = "gr_tenses",
            title = "Tenses",
            titleHi = "काल (Tenses)",
            category = "Core Grammar",
            formula = "Present / Past / Future × (Indefinite, Continuous, Perfect, Perfect Continuous)",
            explanationHi = "Tense समय और कार्य की स्थिति (अवस्था) बताता है। मुख्य 3 काल हैं: Present (वर्तमान - ता है/रहा है/चुका है), Past (भूत - था/रहा था/चुका था) और Future (भविष्य - गा/गी/गे)। MP Board परीक्षा में 'Do as Directed' और 'Fill in the blanks' में Present Indefinite (s/es), Present Perfect (has/have + V3) तथा Past Indefinite (V2 / did + V1) से सर्वाधिक प्रश्न आते हैं।",
            rulesSummaryEn = "• Present Indefinite: Subject + V1(s/es) + Object (Universal truths, habits).\n• Present Continuous: is/am/are + V-ing.\n• Present Perfect: has/have + V3 (just, already, yet).\n• Past Indefinite: Subject + V2 (yesterday, ago, last night).\n• Future Indefinite: will/shall + V1.",
            examples = listOf(
                GrammarExample("The sun rises in the east.", "सूर्य पूर्व में उगता है।", "Present Indefinite - Universal truth"),
                GrammarExample("She has completed her homework just now.", "उसने अभी अपना गृहकार्य पूरा किया है।", "Present Perfect"),
                GrammarExample("They went to Bhopal yesterday.", "वे कल भोपाल गए थे।", "Past Indefinite - 'yesterday' takes V2")
            ),
            practiceQuestions = listOf(
                gPractice("gr_t_p1", "gr_tenses", "Change into Present Perfect: 'He writes a letter.'", "वाक्य को Present Perfect में बदलें:", "He has written a letter.", "has + V3 (written) का प्रयोग होगा।"),
                gPractice("gr_t_p2", "gr_tenses", "Change into Negative: 'She sang a song.'", "नकारात्मक (Negative) में बदलें:", "She did not sing a song.", "Past Indefinite Negative में did not + V1 लगता है।")
            ),
            mcqQuestions = listOf(
                gMcq("gr_t_m1", "gr_tenses", "He ______ to school daily.", listOf("go", "goes", "going", "gone"), 1, "He एकवचन (singular) है और 'daily' आदत बताता है, इसलिए 'goes' सही है।"),
                gMcq("gr_t_m2", "gr_tenses", "I ______ my work before you arrived.", listOf("finish", "have finished", "had finished", "finishing"), 2, "भूतकाल में दो कार्यों में पहले पूर्ण होने वाले कार्य के लिए Past Perfect (had + V3) लगता है।"),
                gMcq("gr_t_m3", "gr_tenses", "It ______ raining since morning.", listOf("is", "has been", "was", "have been"), 1, "'since morning' समय अवधि बताता है, अतः Present Perfect Continuous (has been) सही है।")
            )
        ),
        GrammarTopic(
            id = "gr_articles",
            title = "Articles",
            titleHi = "आर्टिकल्स (A, An, The)",
            category = "Determiners & Modifiers",
            formula = "A (व्यंजन ध्वनि) | An (स्वर ध्वनि a,e,i,o,u) | The (निश्चित/विशेष)",
            explanationHi = "English में 'A', 'An' (Indefinite) और 'The' (Definite) तीन Articles हैं। ध्यान दें कि A/An का चुनाव अक्षर से नहीं बल्कि हिंदी उच्चारण की ध्वनि (Sound) से होता है। जैसे: 'An honest man' (ऑनेस्ट - स्वर ध्वनि), 'A university' (यूनिवर्सिटी - य व्यंजन ध्वनि), 'An M.L.A.' (एम - ए स्वर ध्वनि)। 'The' का प्रयोग नदियों, पहाड़ों, धार्मिक ग्रंथों, अद्वितीय वस्तुओं और Superlative degree के पहले होता है।",
            rulesSummaryEn = "• Use 'A' before consonant sounds (a book, a European, a one-eyed man).\n• Use 'An' before vowel sounds (an apple, an hour, an M.A.).\n• Use 'The' before unique things, rivers, holy books, superlatives, and previously mentioned nouns.",
            examples = listOf(
                GrammarExample("He is an honest officer.", "वह एक ईमानदार अधिकारी हैं।", "'h' silent है, उच्चारण 'ऑ' स्वर से है।"),
                GrammarExample("My brother studies in a university.", "मेरा भाई एक विश्वविद्यालय में पढ़ता है।", "'University' का उच्चारण 'य' व्यंजन से है।"),
                GrammarExample("The Narmada is a sacred river.", "नर्मदा एक पवित्र नदी है।", "नदियों के नाम से पहले 'The' आता है।")
            ),
            practiceQuestions = listOf(
                gPractice("gr_a_p1", "gr_articles", "Fill suitable article: 'Gold is ______ precious metal.'", "उचित आर्टिकल भरें:", "a", "precious व्यंजन ध्वनि 'प' से शुरू होता है।"),
                gPractice("gr_a_p2", "gr_articles", "Fill suitable article: 'He reached ______ hour late.'", "उचित आर्टिकल भरें:", "an", "hour में 'h' मौन है, उच्चारण 'आवर' है।")
            ),
            mcqQuestions = listOf(
                gMcq("gr_a_m1", "gr_articles", "She wants to become ______ M.B.B.S. doctor.", listOf("a", "an", "the", "no article"), 1, "M.B.B.S. का उच्चारण 'एम' (स्वर 'ए') से शुरू होता है, इसलिए 'an' आएगा।"),
                gMcq("gr_a_m2", "gr_articles", "______ Ganga is the holiest river of India.", listOf("A", "An", "The", "None"), 2, "पवित्र नदियों के नाम से पहले 'The' का प्रयोग होता है।"),
                gMcq("gr_a_m3", "gr_articles", "This is ______ useful book for MP Board students.", listOf("a", "an", "the", "any"), 0, "'Useful' का उच्चारण 'यूसफुल' (व्यंजन 'य') से शुरू होता है, अतः 'a' सही है।")
            )
        ),
        GrammarTopic(
            id = "gr_determiners",
            title = "Determiners",
            titleHi = "निर्धारक (Some, Any, Much, Many, Few, Little)",
            category = "Determiners & Modifiers",
            formula = "Countable: Many / Few | Uncountable: Much / Little | Positive: Some | Negative/Q: Any",
            explanationHi = "Determiners वे शब्द हैं जो संज्ञा (Noun) से पहले आकर उसकी मात्रा या संख्या बताते हैं।\n• Some का प्रयोग सकारात्मक वाक्यों व विनम्र अनुरोध में होता है।\n• Any का प्रयोग नकारात्मक (not) और प्रश्नवाचक वाक्यों में होता है।\n• Many और Few (गणनीय बहुवचन संज्ञाओं के साथ), जबकि Much और Little (अगणनीय मात्रा जैसे water, milk, time के साथ) प्रयोग होते हैं।",
            rulesSummaryEn = "• Some: affirmative sentences & polite offers.\n• Any: negative & interrogative sentences.\n• Many / Few / A few: countable plural nouns.\n• Much / Little / A little: uncountable nouns.",
            examples = listOf(
                GrammarExample("I have some good news for you.", "मेरे पास आपके लिए कुछ अच्छी खबर है।", "सकारात्मक वाक्य -> some"),
                GrammarExample("There isn't any sugar left in the jar.", "डिब्बे में कोई चीनी नहीं बची है।", "नकारात्मक वाक्य -> any"),
                GrammarExample("How much water is in the bottle?", "बोतल में कितना पानी है?", "पानी अगणनीय है -> much")
            ),
            practiceQuestions = listOf(
                gPractice("gr_d_p1", "gr_determiners", "Choose correct word: 'How (much/many) pages did you read?'", "सही शब्द चुनें:", "many", "Pages गिने जा सकते हैं (Countable plural)।"),
                gPractice("gr_d_p2", "gr_determiners", "Choose (some/any): 'Do you have ______ doubt?'", "सही शब्द चुनें:", "any", "प्रश्नवाचक वाक्य में 'any' का प्रयोग होता है।")
            ),
            mcqQuestions = listOf(
                gMcq("gr_d_m1", "gr_determiners", "He did not buy ______ apples from the market.", listOf("some", "any", "much", "little"), 1, "नकारात्मक वाक्य (did not) में 'any' का प्रयोग होता है।"),
                gMcq("gr_d_m2", "gr_determiners", "How ______ students are present in the class today?", listOf("much", "little", "many", "any"), 2, "'Students' गणनीय बहुवचन है, इसलिए 'many' सही है।"),
                gMcq("gr_d_m3", "gr_determiners", "______ knowledge is a dangerous thing.", listOf("A few", "Few", "A little", "Many"), 2, "प्रसिद्ध लोकोक्ति 'A little knowledge...' — knowledge अगणनीय है।")
            )
        ),
        GrammarTopic(
            id = "gr_modals",
            title = "Modals",
            titleHi = "मोडल सहायक क्रियाएँ (Can, May, Must, Should...)",
            category = "Verbs & Modals",
            formula = "Subject + Modal + V1 (Base Verb)",
            explanationHi = "Modals वे सहायक क्रियाएँ हैं जो वक्ता के भाव (क्षमता, अनुमति, कर्तव्य, संभावना, आवश्यकता) बताती हैं। इनके बाद हमेशा क्रिया का पहला रूप (V1) आता है।\n• Can: क्षमता (Ability) • Could: भूतकाल की क्षमता / विनम्र निवेदन\n• May: औपचारिक अनुमति, संभावना, आशीर्वाद\n• Must: अनिवार्य कर्तव्य / सख्त नियम\n• Should: नैतिक सलाह / सुझाव • Used to: भूतकाल की आदत।",
            rulesSummaryEn = "• Can/Could: ability, informal/polite request.\n• May/Might: formal permission, possibility, wish.\n• Must: strong obligation or necessity.\n• Should/Ought to: advice and moral duty.\n• Would/Used to: past habits or polite offer.",
            examples = listOf(
                GrammarExample("May I come in, Sir?", "क्या मैं अंदर आ सकता हूँ, सर?", "औपचारिक अनुमति -> May"),
                GrammarExample("You must obey traffic rules.", "आपको यातायात के नियमों का पालन अवश्य करना चाहिए।", "अनिवार्य नियम -> Must"),
                GrammarExample("We should respect our elders.", "हमें बड़ों का सम्मान करना चाहिए।", "नैतिक सलाह -> Should")
            ),
            practiceQuestions = listOf(
                gPractice("gr_m_p1", "gr_modals", "Fill modal: '______ God bless you with success!'", "उचित मोडल भरें:", "May", "आशीर्वाद/शुभकामना (optative sentence) में May आता है।"),
                gPractice("gr_m_p2", "gr_modals", "Fill modal: 'She ______ speak English fluently.' (ability)", "उचित मोडल भरें:", "can", "वर्तमान क्षमता के लिए can प्रयोग होता है।")
            ),
            mcqQuestions = listOf(
                gMcq("gr_m_m1", "gr_modals", "Work hard lest you ______ fail.", listOf("should", "could", "can", "may"), 0, "'Lest' के साथ हमेशा 'should' का प्रयोग होता है।"),
                gMcq("gr_m_m2", "gr_modals", "Candidates ______ bring their admit card to the exam hall.", listOf("might", "must", "could", "would"), 1, "परीक्षा के अनिवार्य नियम के लिए 'must' सही है।"),
                gMcq("gr_m_m3", "gr_modals", "When I was young, I ______ climb trees easily.", listOf("can", "may", "could", "must"), 2, "भूतकाल की क्षमता बताने के लिए 'could' का प्रयोग होता है।")
            )
        ),
        GrammarTopic(
            id = "gr_voice",
            title = "Active and Passive Voice",
            titleHi = "कर्तृवाच्य और कर्मवाच्य (Active & Passive Voice)",
            category = "Sentence Structure",
            formula = "Object + Helping Verb (be-form) + V3 + by + Subject",
            explanationHi = "Active Voice में कर्ता (Subject) प्रमुख होता है, जबकि Passive Voice में कर्म (Object) प्रमुख हो जाता है। Passive बनाते समय हमेशा क्रिया का तीसरा रूप (V3) और सामान्यतः 'by' लगता है।\n• Present Indefinite: is/am/are + V3\n• Past Indefinite: was/were + V3\n• Continuous: being + V3\n• Perfect: been + V3\n• Modals: modal + be + V3।",
            rulesSummaryEn = "• Swap Subject and Object; always use V3.\n• Pronouns shift: I -> me, we -> us, he -> him, she -> her, they -> them.\n• Imperative sentences: Let + Object + be + V3.",
            examples = listOf(
                GrammarExample("Active: Imran Sir teaches English.\nPassive: English is taught by Imran Sir.", "इमरान सर अंग्रेजी पढ़ाते हैं -> अंग्रेजी इमरान सर द्वारा पढ़ाई जाती है।", "Present Indefinite Passive"),
                GrammarExample("Active: Open the window.\nPassive: Let the window be opened.", "खिड़की खोलो -> खिड़की खोली जाए।", "Imperative Passive")
            ),
            practiceQuestions = listOf(
                gPractice("gr_v_p1", "gr_voice", "Change voice: 'She wrote a poem.'", "Passive Voice में बदलें:", "A poem was written by her.", "Past Indefinite में was + V3 लगता है।"),
                gPractice("gr_v_p2", "gr_voice", "Change voice: 'Who taught you grammar?'", "Passive Voice में बदलें:", "By whom were you taught grammar?", "Who को 'By whom' में बदला जाता है।")
            ),
            mcqQuestions = listOf(
                gMcq("gr_v_m1", "gr_voice", "Passive of 'They are playing cricket':", listOf("Cricket is played by them.", "Cricket is being played by them.", "Cricket was being played by them.", "Cricket has been played by them."), 1, "Present Continuous के Passive में is/am/are + being + V3 आता है।"),
                gMcq("gr_v_m2", "gr_voice", "Passive of 'Someone stole my pen':", listOf("My pen was stolen.", "My pen is stolen.", "My pen had stolen.", "My pen was stealing."), 0, "Past Indefinite का Passive 'was stolen' होगा; अज्ञात कर्ता (someone) हटा देते हैं।")
            )
        ),
        GrammarTopic(
            id = "gr_narration",
            title = "Direct and Indirect Speech",
            titleHi = "प्रत्यक्ष और अप्रत्यक्ष कथन (Narration)",
            category = "Sentence Structure",
            formula = "Reporting Verb (said/told/asked) + Conjunction (that/if/to) + Reported Speech (Tense shift)",
            explanationHi = "किसी की बात को ज्यों का त्यों Inverted Commas (\"...\") में लिखना Direct Speech है, और अपने शब्दों में बताना Indirect Speech। यदि Reporting Verb भूतकाल (said) में हो तो Reported Speech का काल एक कदम पीछे जाता है (Present -> Past, Past Indefinite -> Past Perfect, will -> would)। यूनिवर्सल ट्रुथ (सदा सत्य) का काल नहीं बदलता।",
            rulesSummaryEn = "• Assertive: 'said to' -> 'told', use 'that'.\n• Interrogative: 'said to' -> 'asked', use 'if/whether' (yes/no) or Wh-word.\n• Imperative: ordered/requested/advised + to + V1.\n• Time words change: today -> that day, tomorrow -> the next day.",
            examples = listOf(
                GrammarExample("Direct: Ram said, \"I am busy now.\"\nIndirect: Ram said that he was busy then.", "राम ने कहा कि वह तब व्यस्त था।", "am -> was, now -> then"),
                GrammarExample("Direct: She said to me, \"Where do you live?\"\nIndirect: She asked me where I lived.", "उसने मुझसे पूछा कि मैं कहाँ रहता था।", "Wh-question removes 'do'")
            ),
            practiceQuestions = listOf(
                gPractice("gr_n_p1", "gr_narration", "Convert to Indirect: 'The teacher said, \"The earth moves round the sun.\"'", "Indirect Speech में बदलें:", "The teacher said that the earth moves round the sun.", "सदा सत्य (Universal Truth) का काल नहीं बदलता।")
            ),
            mcqQuestions = listOf(
                gMcq("gr_n_m1", "gr_narration", "Indirect of: He said to me, \"Are you ready?\"", listOf("He asked me that I was ready.", "He asked me if I was ready.", "He told me if I am ready.", "He asked me was I ready."), 1, "Yes/No प्रश्न में 'asked' के साथ 'if' या 'whether' लगता है और वाक्य साधारण बनता है।"),
                gMcq("gr_n_m2", "gr_narration", "Indirect of: The doctor said to the patient, \"Take rest.\"", listOf("The doctor advised the patient to take rest.", "The doctor said the patient take rest.", "The doctor asked that take rest.", "The doctor ordered for rest."), 0, "सलाह वाले Imperative वाक्य में advised + object + to + V1 आता है।")
            )
        ),
        GrammarTopic(
            id = "gr_prepositions",
            title = "Prepositions",
            titleHi = "संबंधसूचक अव्यय (In, On, At, By, With, Since, For...)",
            category = "Connectors & Phrases",
            formula = "Preposition + Noun / Pronoun / Gerund (V-ing)",
            explanationHi = "Preposition संज्ञा या सर्वनाम से पहले आकर उसका स्थान, समय या दिशा से संबंध बताते हैं।\n• At (निश्चित समय/छोटा स्थान) • On (दिन/तारीख/सतह के ऊपर) • In (महीना/साल/बड़ा शहर/अंदर)\n• Between (दो के बीच) • Among (दो से अधिक के बीच)\n• Since (निश्चित समय बिंदु - 2020, Monday) • For (अवधि - 2 hours, 5 days)।",
            rulesSummaryEn = "• Time: at 5 PM, on Monday, in June/2026.\n• Agent vs Instrument: killed by a hunter (agent) with a stick (instrument).\n• Fixed prepositions: fond of, afraid of, senior to, prefer tea to coffee, died of (disease).",
            examples = listOf(
                GrammarExample("He is senior to me by two years.", "वह मुझसे दो वर्ष वरिष्ठ है।", "senior/junior/prefer के साथ 'to' लगता है।"),
                GrammarExample("Distribute these sweets among the students.", "ये मिठाइयाँ विद्यार्थियों में बाँट दो।", "दो से अधिक के लिए among"),
                GrammarExample("The frog jumped into the well.", "मेंढक कुएँ में कूद पड़ा।", "गति के साथ अंदर जाने पर 'into'")
            ),
            practiceQuestions = listOf(
                gPractice("gr_p_p1", "gr_prepositions", "Fill preposition: 'He died ______ malaria.'", "उचित Preposition भरें:", "of", "किसी बीमारी से मृत्यु होने पर 'died of' का प्रयोग होता है।")
            ),
            mcqQuestions = listOf(
                gMcq("gr_p_m1", "gr_prepositions", "She prefers coffee ______ tea.", listOf("than", "from", "to", "over"), 2, "'Prefer' के साथ 'than' नहीं, हमेशा 'to' का प्रयोग होता है।"),
                gMcq("gr_p_m2", "gr_prepositions", "The cat is sitting ______ the table.", listOf("into", "under", "between", "since"), 1, "मेज़ के नीचे बैठने के लिए 'under' सही है।")
            )
        ),
        GrammarTopic(
            id = "gr_conjunctions",
            title = "Conjunctions",
            titleHi = "समुच्चयबोधक अव्यय (And, But, So, Because, Unless, Although...)",
            category = "Connectors & Phrases",
            formula = "Clause 1 + Conjunction + Clause 2",
            explanationHi = "Conjunctions दो शब्दों या वाक्यों को जोड़ते हैं। MP Board परीक्षा में 'If...not' के स्थान पर 'Unless' और 'So...that' के स्थान पर 'Too...to' के प्रयोग बहुत पूछे जाते हैं।\n• Unless = If + not (अतः Unless वाले भाग में not नहीं आता)।\n• Although / Though के साथ 'yet' या कॉमा आता है, 'but' नहीं।\n• No sooner...than, Hardly...when।",
            rulesSummaryEn = "• Coordinating: FANBOYS (For, And, Nor, But, Or, Yet, So).\n• Correlative: either...or, neither...nor, not only...but also, both...and.\n• Subordinating: because, unless, until, if, although, while.",
            examples = listOf(
                GrammarExample("Unless you work hard, you cannot pass.", "यदि तुम मेहनत नहीं करोगे, तो पास नहीं हो सकते।", "Unless = If you do not"),
                GrammarExample("He is so weak that he cannot walk.", "वह इतना कमजोर है कि चल नहीं सकता।", "So...that संरचना")
            ),
            practiceQuestions = listOf(
                gPractice("gr_c_p1", "gr_conjunctions", "Rewrite using 'Unless': 'If he does not come early, he will miss the bus.'", "'Unless' का प्रयोग कर पुनः लिखें:", "Unless he comes early, he will miss the bus.", "If...does not हटाकर Unless और verb में s लगाया गया।")
            ),
            mcqQuestions = listOf(
                gMcq("gr_c_m1", "gr_conjunctions", "Work hard ______ you should fail.", listOf("and", "or", "lest", "but"), 2, "'Lest' के साथ हमेशा 'should' का जोड़ा बनता है।"),
                gMcq("gr_c_m2", "gr_conjunctions", "No sooner did the bell ring ______ the students ran out.", listOf("when", "then", "than", "that"), 2, "'No sooner' के साथ हमेशा 'than' (t-h-a-n) लगता है।")
            )
        ),
        GrammarTopic(
            id = "gr_sva",
            title = "Subject Verb Agreement",
            titleHi = "कर्ता-क्रिया अन्विति (Subject-Verb Agreement)",
            category = "Core Grammar",
            formula = "Singular Subject -> Singular Verb | Plural Subject -> Plural Verb",
            explanationHi = "वाक्य में क्रिया (Verb) हमेशा कर्ता (Subject) के वचन और पुरुष के अनुसार आती है।\n• Either/Neither/Each/Everyone के साथ एकवचन क्रिया लगती है।\n• Either...or / Neither...nor में क्रिया पास वाले Subject के अनुसार होती है।\n• Bread and butter (एक ही व्यंजन) या दूरी/राशि एक इकाई होने पर एकवचन क्रिया लगती है।",
            rulesSummaryEn = "• Singular indefinite pronouns (each, everyone, nobody) take singular verbs.\n• With 'as well as' or 'along with', verb agrees with the FIRST subject.\n• With 'either...or' / 'neither...nor', verb agrees with the NEAREST subject.",
            examples = listOf(
                GrammarExample("The teacher, along with the students, is going on a picnic.", "शिक्षक विद्यार्थियों के साथ पिकनिक पर जा रहे हैं।", "along with में पहले कर्ता 'teacher' के अनुसार 'is'"),
                GrammarExample("Neither Rani nor her friends were present.", "न तो रानी और न ही उसके मित्र उपस्थित थे।", "पास वाले कर्ता 'friends' के अनुसार 'were'")
            ),
            practiceQuestions = listOf(
                gPractice("gr_sva_p1", "gr_sva", "Choose verb: 'Slow and steady (win/wins) the race.'", "सही क्रिया चुनें:", "wins", "एक ही विचार/कहावत होने के कारण एकवचन 'wins' आएगा।")
            ),
            mcqQuestions = listOf(
                gMcq("gr_sva_m1", "gr_sva", "Each of the boys ______ given a prize.", listOf("were", "are", "was", "have"), 2, "'Each of + plural noun' के साथ हमेशा एकवचन क्रिया (was) लगती है।"),
                gMcq("gr_sva_m2", "gr_sva", "Physics ______ an interesting subject.", listOf("are", "is", "were", "have"), 1, "Physics, Mathematics, News दिखने में बहुवचन हैं पर एकवचन क्रिया लेते हैं।")
            )
        ),
        GrammarTopic(
            id = "gr_clauses",
            title = "Clauses",
            titleHi = "उपवाक्य (Noun, Adjective / Relative, Adverb Clauses)",
            category = "Sentence Structure",
            formula = "Main Clause + Subordinate Clause (Noun / Relative / Adverb)",
            explanationHi = "Clause शब्दों का वह समूह है जिसमें अपना Subject और Finite Verb होता है।\n1. Noun Clause: 'What/That' से शुरू होकर संज्ञा का काम करता है (I know that he is honest)।\n2. Relative (Adjective) Clause: Who, Which, That, Whose से किसी Noun की विशेषता बताता है।\n3. Adverb Clause: समय, कारण, शर्त या परिणाम बताता है (when, because, if, so...that)।",
            rulesSummaryEn = "• Noun Clause answers 'What?' after the verb.\n• Relative Clause uses 'who' (persons), 'which' (things), 'where' (places).\n• Adverb Clause answers 'When, Why, How, Under what condition?'.",
            examples = listOf(
                GrammarExample("The boy who won the gold medal is my brother.", "जिस लड़के ने स्वर्ण पदक जीता वह मेरा भाई है।", "Relative / Adjective Clause"),
                GrammarExample("Wait here until I return.", "जब तक मैं लौटूँ तब तक यहीं प्रतीक्षा करो।", "Adverb Clause of Time")
            ),
            practiceQuestions = listOf(
                gPractice("gr_cl_p1", "gr_clauses", "Combine using 'who': 'The man is my uncle. He is wearing a blue shirt.'", "'who' से जोड़ें:", "The man who is wearing a blue shirt is my uncle.", "Relative clause व्यक्ति के लिए 'who' लेता है।")
            ),
            mcqQuestions = listOf(
                gMcq("gr_cl_m1", "gr_clauses", "This is the school ______ Imran Sir teaches.", listOf("who", "where", "which", "whom"), 1, "स्थान (school) के लिए Relative Adverb 'where' का प्रयोग होता है।"),
                gMcq("gr_cl_m2", "gr_clauses", "In 'I know where he lives', the underlined part 'where he lives' is a:", listOf("Noun Clause", "Adjective Clause", "Adverb Clause", "Phrase"), 0, "यह 'know' क्रिया के कर्म (What?) का उत्तर दे रहा है, अतः Noun Clause है।")
            )
        ),
        GrammarTopic(
            id = "gr_transformation",
            title = "Transformation of Sentences",
            titleHi = "वाक्य रूपांतरण (So...that, Too...to, No sooner...than, Negative/Interrogative)",
            category = "Exam Writing Skills",
            formula = "So + adj + that + Sub + cannot/could not  <-->  Too + adj + to + V1",
            explanationHi = "वाक्य का अर्थ बदले बिना उसका रूप बदलना Transformation कहलाता है। MP Board कक्षा 9–12 के Section C में यह हर साल आता है:\n• Too...to को हटाकर So...that लगाना।\n• As soon as को हटाकर No sooner...than लगाना।\n• Simple/Compound/Complex में रूपांतरण।",
            rulesSummaryEn = "• Replace 'too' with 'so', and 'to' with 'that + subject + cannot/could not'.\n• Replace 'As soon as' with 'No sooner did/does + subject + V1 ... than'.",
            examples = listOf(
                GrammarExample("He is too tired to run.\n-> He is so tired that he cannot run.", "वह इतना थका है कि दौड़ नहीं सकता।", "Too...to -> So...that"),
                GrammarExample("As soon as the thief saw the police, he ran away.\n-> No sooner did the thief see the police than he ran away.", "जैसे ही चोर ने पुलिस को देखा, वह भाग गया।", "As soon as -> No sooner...than")
            ),
            practiceQuestions = listOf(
                gPractice("gr_tr_p1", "gr_transformation", "Use 'so...that': 'The tea is too hot to drink.'", "'so...that' में बदलें:", "The tea is so hot that one cannot drink it (or it cannot be drunk).", "निर्जीव कर्ता होने पर 'one cannot' या passive प्रयोग होता है।")
            ),
            mcqQuestions = listOf(
                gMcq("gr_tr_m1", "gr_transformation", "Transform 'He is too poor to pay the fees' using 'so...that':", listOf("He is so poor that he cannot pay the fees.", "He is so poor to pay the fees.", "He is very poor that he cannot pay.", "He was so poor that he cannot pay."), 0, "वर्तमान काल (is) होने के कारण 'that he cannot' सही है।")
            )
        ),
        GrammarTopic(
            id = "gr_degrees",
            title = "Degrees of Comparison",
            titleHi = "तुलना की अवस्थाएँ (Positive, Comparative, Superlative)",
            category = "Determiners & Modifiers",
            formula = "Positive (as...as) | Comparative (-er / more + than) | Superlative (the -est / most)",
            explanationHi = "Adjective की तीन डिग्री होती हैं:\n1. Positive: दो समान गुणों की तुलना (as tall as / not so tall as)।\n2. Comparative: दो के बीच तुलना (taller than, better than, more beautiful than)।\n3. Superlative: सबसे श्रेष्ठ (the tallest, the best)। ध्यान रहे 'junior, senior, superior, inferior' के साथ 'than' की जगह 'to' लगता है।",
            rulesSummaryEn = "• Never use double comparatives/superlatives (avoid 'more better' or 'most tallest').\n• Always place 'the' before a superlative degree.",
            examples = listOf(
                GrammarExample("Bhopal is cleaner than many other cities.", "भोपाल कई अन्य शहरों से अधिक स्वच्छ है।", "Comparative Degree"),
                GrammarExample("Mount Everest is the highest peak in the world.", "माउंट एवरेस्ट विश्व की सबसे ऊँची चोटी है।", "Superlative Degree")
            ),
            practiceQuestions = listOf(
                gPractice("gr_deg_p1", "gr_degrees", "Change to Positive: 'Gold is costlier than silver.'", "Positive Degree में बदलें:", "Silver is not so costly as gold.", "दोनों के बीच अर्थ समान रखने हेतु नकारात्मक बनाया जाता है।")
            ),
            mcqQuestions = listOf(
                gMcq("gr_deg_m1", "gr_degrees", "Rohan is the ______ boy in our class.", listOf("intelligent", "more intelligent", "most intelligent", "very intelligent"), 2, "'the' के साथ पूरी कक्षा में तुलना होने से Superlative 'most intelligent' सही है।")
            )
        ),
        GrammarTopic(
            id = "gr_error",
            title = "Error Detection",
            titleHi = "त्रुटि सुधार (Error Detection & Correction)",
            category = "Exam Writing Skills",
            formula = "Check: Subject-Verb -> Tense -> Preposition -> Article -> Pronoun",
            explanationHi = "किसी वाक्य में व्याकरण की गलती पहचानकर सही करना Error Detection है। जाँच करने का क्रम:\n1. Subject के अनुसार Verb (is/are, has/have) सही है?\n2. Tense के समय सूचक शब्द (yesterday -> V2, since/for -> has/have been) सही हैं?\n3. Preposition व Article सही हैं?",
            rulesSummaryEn = "• 'One of the' + Plural Noun + Singular Verb.\n• 'Did' is always followed by V1, never V2.\n• Uncountable nouns (information, advice, luggage, furniture) never take '-s'.",
            examples = listOf(
                GrammarExample("Incorrect: He did not went there.\nCorrect: He did not go there.", "did के साथ हमेशा V1 (go) आता है।", "Verb form error"),
                GrammarExample("Incorrect: Give me two informations.\nCorrect: Give me two pieces of information.", "'information' हमेशा एकवचन होता है।", "Uncountable noun error")
            ),
            practiceQuestions = listOf(
                gPractice("gr_er_p1", "gr_error", "Correct the sentence: 'One of my friend live in Indore.'", "वाक्य शुद्ध करें:", "One of my friends lives in Indore.", "'One of' के बाद बहुवचन संज्ञा (friends) और एकवचन क्रिया (lives) आती है।")
            ),
            mcqQuestions = listOf(
                gMcq("gr_er_m1", "gr_error", "Identify the correct sentence:", listOf("She is good in English.", "She is good at English.", "She is good on English.", "She is good with English."), 1, "किसी विषय में दक्ष होने के लिए 'good at' का प्रयोग होता है।")
            )
        ),
        GrammarTopic(
            id = "gr_rearrangement",
            title = "Sentence Rearrangement",
            titleHi = "जम्बल्ड शब्द क्रमबद्ध करना (Sentence Rearrangement)",
            category = "Exam Writing Skills",
            formula = "Subject + Helping Verb + Main Verb + Object + Place/Time",
            explanationHi = "बिखरे हुए शब्दों (Jumbled Words) को अर्थपूर्ण वाक्य में जमाना कक्षा 9 से 12 की परीक्षा का महत्वपूर्ण प्रश्न है। सबसे पहले कर्ता (Subject) खोजें, फिर सहायक व मुख्य क्रिया (Verb), फिर कर्म (Object) और अंत में स्थान/समय रखें। प्रश्नवाचक वाक्य में Wh-word + Helping Verb + Subject + Main Verb क्रम अपनाएँ।",
            rulesSummaryEn = "• Assertive order: S + V + O + Manner + Place + Time.\n• Interrogative order: (Wh) + HV + S + V + O + ?\n• Count all given words after rearranging so none is missed.",
            examples = listOf(
                GrammarExample("Jumbled: hobby / is / my / reading / books\nOrdered: Reading books is my hobby.", "किताबें पढ़ना मेरा शौक है।", "Gerund as Subject")
            ),
            practiceQuestions = listOf(
                gPractice("gr_re_p1", "gr_rearrangement", "Rearrange: 'always / truth / the / speak'", "सही वाक्य बनाएँ:", "Always speak the truth.", "आदेशात्मक/उपदेशात्मक वाक्य")
            ),
            mcqQuestions = listOf(
                gMcq("gr_re_m1", "gr_rearrangement", "Rearrange: 'is / Bhopal / capital / the / Madhya Pradesh / of'", listOf("Madhya Pradesh is the capital of Bhopal.", "Bhopal is the capital of Madhya Pradesh.", "The capital is Bhopal of Madhya Pradesh.", "Bhopal the capital of Madhya Pradesh is."), 1, "कर्ता 'Bhopal' से शुरू होकर सही अर्थपूर्ण वाक्य बनता है।")
            )
        ),
        GrammarTopic(
            id = "gr_hi_to_en",
            title = "Hindi to English Translation",
            titleHi = "हिंदी से अंग्रेजी अनुवाद (Translation)",
            category = "Translation Skills",
            formula = "हिंदी: कर्ता + कर्म + क्रिया  ==>  English: Subject + Verb + Object",
            explanationHi = "MP Board परीक्षा में 5 अंक के अनुवाद प्रश्न आते हैं। हिंदी वाक्य के अंत से पहचानें कि कौन-सा Tense या Structure लगेगा:\n• 'ता है/ती है' -> Present Indefinite\n• 'रहा है' -> is/am/are + V-ing\n• 'चाहिए' -> should + V1\n• 'मेरे पास ... है' -> I have...\n• मौसम/समय/दूरी -> 'It' से शुरू करें (जैसे: आज बहुत ठंड है -> It is very cold today)।",
            rulesSummaryEn = "• Always identify Tense from the last word of the Hindi sentence.\n• Use 'There' for existence (There are 40 students in my class).\n• Use 'It' for time, weather, and day.",
            examples = listOf(
                GrammarExample("मैं रोज़ सुबह अखबार पढ़ता हूँ -> I read the newspaper every morning.", "Present Indefinite", "Habit"),
                GrammarExample("मेरी कक्षा में पचास विद्यार्थी हैं -> There are fifty students in my class.", "Introductory 'There'", "Existence"),
                GrammarExample("आज बहुत गर्मी है -> It is very hot today.", "Introductory 'It'", "Weather")
            ),
            practiceQuestions = listOf(
                gPractice("gr_hte_p1", "gr_hi_to_en", "Translate into English: 'क्या तुम तैरना जानते हो?'", "अंग्रेजी में अनुवाद करें:", "Do you know how to swim?", "कौशल जानने के लिए 'know how to + V1' प्रयोग होता है।")
            ),
            mcqQuestions = listOf(
                gMcq("gr_hte_m1", "gr_hi_to_en", "Translate: 'सुबह से बारिश हो रही है।'", listOf("It is raining since morning.", "It has been raining since morning.", "It rained since morning.", "Rain is falling from morning."), 1, "'सुबह से' (समय + रहा है) के लिए Present Perfect Continuous (has been raining) सही है।")
            )
        ),
        GrammarTopic(
            id = "gr_en_to_hi",
            title = "English to Hindi Translation",
            titleHi = "अंग्रेजी से हिंदी अनुवाद (Translation)",
            category = "Translation Skills",
            formula = "Subject (कर्ता) -> Object/Modifiers (कर्म) -> Verb (अंत में क्रिया)",
            explanationHi = "अंग्रेजी से हिंदी अनुवाद करते समय वाक्य को तीन हिस्सों में बाँटें: 1. Subject, 2. Prepositional Phrase (पीछे से आगे), 3. Verb (बिल्कुल अंत में)। कठिन शब्दों का भावार्थ समझें और मुहावरों का शाब्दिक नहीं, बल्कि स्वाभाविक हिंदी अनुवाद करें।",
            rulesSummaryEn = "• Read the whole English sentence first to grasp context.\n• Place the Hindi verb at the end.\n• Translate passive sentences naturally ('English is spoken worldwide' -> 'दुनिया भर में अंग्रेजी बोली जाती है').",
            examples = listOf(
                GrammarExample("Honesty is the best policy. -> ईमानदारी सबसे अच्छी नीति है।", "Proverb", "Natural translation"),
                GrammarExample("Trees give us oxygen and shade. -> वृक्ष हमें ऑक्सीजन और छाया देते हैं।", "Simple Present", "Plural subject")
            ),
            practiceQuestions = listOf(
                gPractice("gr_eth_p1", "gr_en_to_hi", "Translate into Hindi: 'Hard work is the key to success.'", "हिंदी में अनुवाद करें:", "कठिन परिश्रम सफलता की कुंजी है।", "key to success = सफलता की कुंजी")
            ),
            mcqQuestions = listOf(
                gMcq("gr_eth_m1", "gr_en_to_hi", "Best Hindi translation of 'Prevention is better than cure':", listOf("रोकथाम इलाज से बेहतर है।", "इलाज करना आसान है।", "बीमारी से डरना चाहिए।", "दवाइयाँ महंगी होती हैं।"), 0, "इस प्रसिद्ध कहावत का सही हिंदी अर्थ 'रोकथाम इलाज से बेहतर है' (सावधानी उपचार से श्रेष्ठ है) है।")
            )
        )
    )
}
