package com.example.data.curriculum

import com.example.data.model.Chapter
import com.example.data.model.ChapterQuestion
import com.example.data.model.MatchPair
import com.example.data.model.QuestionSourceTag
import com.example.data.model.QuestionType
import com.example.data.model.WordMeaning

object Class12Curriculum {

    private fun buildQuestions(
        chapterId: String,
        title: String,
        author: String,
        themeEn: String,
        themeHi: String,
        vsQ: String,
        vsA: String,
        vsHi: String,
        mcq1Q: String,
        mcq1Opts: List<String>,
        mcq1Idx: Int,
        mcq1Hi: String,
        mcq2Q: String,
        mcq2Opts: List<String>,
        mcq2Idx: Int,
        mcq2Hi: String,
        fillQ: String,
        fillA: String,
        tfQ: String,
        tfA: String,
        extractQuote: String,
        extractQ: String,
        extractA: String,
        pairs: List<MatchPair>
    ): List<ChapterQuestion> = listOf(
        ChapterQuestion(
            id = "${chapterId}_vs1",
            chapterId = chapterId,
            classLevel = 12,
            type = QuestionType.VERY_SHORT,
            sourceTag = QuestionSourceTag.NCERT,
            promptEn = vsQ,
            answerEn = vsA,
            answerHi = vsHi
        ),
        ChapterQuestion(
            id = "${chapterId}_sh1",
            chapterId = chapterId,
            classLevel = 12,
            type = QuestionType.SHORT,
            sourceTag = QuestionSourceTag.NCERT,
            promptEn = "Explain the main theme and moral insight of '$title'.",
            promptHi = "'$title' का मुख्य विषय और नैतिक संदेश स्पष्ट कीजिए।",
            answerEn = themeEn,
            answerHi = themeHi
        ),
        ChapterQuestion(
            id = "${chapterId}_lg1",
            chapterId = chapterId,
            classLevel = 12,
            type = QuestionType.LONG,
            sourceTag = QuestionSourceTag.NCERT,
            promptEn = "Write an analytical essay/answer on the significance of '$title' by $author for Class 12 Board preparation (120 words).",
            promptHi = "कक्षा 12 बोर्ड परीक्षा की दृष्टि से $author द्वारा रचित '$title' के महत्व पर विस्तृत उत्तर लिखिए।",
            answerEn = "In '$title', $author illuminates $themeEn Every incident reinforces how courage, awareness, and human empathy overcome prejudice, fear, or complacency.",
            answerHi = "'$title' में $author ने अत्यंत गहराई से $themeHi को दर्शाया है। यह पाठ MP बोर्ड कक्षा 12 के दीर्घ उत्तरीय प्रश्नों के लिए अत्यंत महत्वपूर्ण है।"
        ),
        ChapterQuestion(
            id = "${chapterId}_mcq1",
            chapterId = chapterId,
            classLevel = 12,
            type = QuestionType.MCQ,
            sourceTag = QuestionSourceTag.NCERT,
            promptEn = mcq1Q,
            answerEn = mcq1Opts[mcq1Idx],
            options = mcq1Opts,
            correctOptionIndex = mcq1Idx,
            explanationHi = mcq1Hi
        ),
        ChapterQuestion(
            id = "${chapterId}_mcq2",
            chapterId = chapterId,
            classLevel = 12,
            type = QuestionType.MCQ,
            sourceTag = QuestionSourceTag.PRACTICE,
            promptEn = mcq2Q,
            answerEn = mcq2Opts[mcq2Idx],
            options = mcq2Opts,
            correctOptionIndex = mcq2Idx,
            explanationHi = mcq2Hi
        ),
        ChapterQuestion(
            id = "${chapterId}_fb1",
            chapterId = chapterId,
            classLevel = 12,
            type = QuestionType.FILL_BLANK,
            sourceTag = QuestionSourceTag.PRACTICE,
            promptEn = fillQ,
            answerEn = fillA,
            explanationHi = "सही उत्तर: $fillA"
        ),
        ChapterQuestion(
            id = "${chapterId}_tf1",
            chapterId = chapterId,
            classLevel = 12,
            type = QuestionType.TRUE_FALSE,
            sourceTag = QuestionSourceTag.PRACTICE,
            promptEn = tfQ,
            answerEn = tfA,
            options = listOf("True", "False"),
            correctOptionIndex = if (tfA.equals("True", ignoreCase = true)) 0 else 1,
            explanationHi = "यह कथन $tfA है।"
        ),
        ChapterQuestion(
            id = "${chapterId}_mt1",
            chapterId = chapterId,
            classLevel = 12,
            type = QuestionType.MATCH,
            sourceTag = QuestionSourceTag.PRACTICE,
            promptEn = "Match the following from '$title':",
            answerEn = pairs.joinToString("; ") { "${it.left} -> ${it.right}" },
            matchPairs = pairs
        ),
        ChapterQuestion(
            id = "${chapterId}_ex1",
            chapterId = chapterId,
            classLevel = 12,
            type = QuestionType.EXTRACT,
            sourceTag = QuestionSourceTag.NCERT,
            extractText = extractQuote,
            promptEn = extractQ,
            answerEn = extractA,
            explanationHi = "यह अवतरण कक्षा 12 के पाठ '$title' से है।"
        ),
        ChapterQuestion(
            id = "${chapterId}_pyq1",
            chapterId = chapterId,
            classLevel = 12,
            type = QuestionType.BOARD_PYQ,
            sourceTag = QuestionSourceTag.NCERT,
            boardReference = "NCERT Class 12 MP Board Core Question",
            promptEn = "How does '$title' reflect real-world social or psychological truths?",
            promptHi = "'$title' पाठ वास्तविक सामाजिक या मनोवैज्ञानिक सत्य को किस प्रकार प्रकट करता है?",
            answerEn = themeEn,
            answerHi = themeHi
        )
    )

    val chapters: List<Chapter> = listOf(
        // --- FLAMINGO ---
        Chapter(
            id = "c12_fl_1",
            classLevel = 12,
            bookName = "Flamingo",
            chapterNumber = 1,
            title = "The Last Lesson",
            titleHi = "अंतिम पाठ",
            author = "Alphonse Daudet",
            summaryEn = "During the Franco-Prussian War (1870–71), Berlin orders that only German be taught in Alsace and Lorraine. Young Franz attends M. Hamel's final French class, realizing too late the priceless value of his mother tongue.",
            summaryHi = "फ्रांस-प्रशिया युद्ध में अलसेस और लोरेन जिलों के हारने के बाद बर्लिन से आदेश आता है कि अब स्कूलों में केवल जर्मन पढ़ाई जाएगी। नन्हा फ्रांज़ अपने शिक्षक एम. हैमेल के अंतिम फ्रेंच पाठ में मातृभाषा के महत्व को समझता है।",
            hindiExplanation = "स्कूल जाने से डरने वाला फ्रांज़ उस दिन हैरान रह जाता है जब कक्षा में सन्नाटा होता है और पीछे की बेंचों पर गांव के बुजुर्ग भी बैठे होते हैं। शिक्षक एम. हैमेल अपनी सबसे सुंदर हरी कोट पहने होते हैं और बताते हैं कि यह उनका अंतिम फ्रेंच पाठ है। वे कहते हैं कि जब लोग गुलाम हो जाते हैं, तब तक वे आज़ाद हैं जब तक वे अपनी भाषा से जुड़े रहते हैं—क्योंकि मातृभाषा ही उनकी जेल की चाबी है। अंत में वे बोर्ड पर 'Vive La France!' लिखते हैं।",
            wordMeanings = listOf(
                WordMeaning("Dread", "noun", "Great fear or apprehension", "भय / आशंका", "Franz started for school in great dread of a scolding."),
                WordMeaning("Unison", "noun", "Simultaneous speaking/action", "एक स्वर में", "The students repeated lessons in unison."),
                WordMeaning("Reproach", "verb", "Blame or criticize", "धिक्कारना / दोष देना", "We have all a great deal to reproach ourselves with."),
                WordMeaning("Enslaved", "verb", "Made a slave", "गुलाम बनाया हुआ", "When a people are enslaved, language is the key to their prison.")
            ),
            questions = buildQuestions(
                chapterId = "c12_fl_1",
                title = "The Last Lesson",
                author = "Alphonse Daudet",
                themeEn = "Linguistic chauvinism hurts identity; people realize the worth of their mother tongue only when threatened with losing it.",
                themeHi = "भाषाई अहंकार संस्कृति को चोट पहुँचाता है; हमें समय रहते अपनी मातृभाषा का सम्मान करना चाहिए।",
                vsQ = "What was written on the blackboard by M. Hamel at the end of the last lesson?",
                vsA = "“Vive La France!” (Long Live France!).",
                vsHi = "अंत में एम. हैमेल ने ब्लैकबोर्ड पर बड़े अक्षरों में 'Vive La France!' लिखा।",
                mcq1Q = "For how many years had M. Hamel served faithfully at the school?",
                mcq1Opts = listOf("Twenty years", "Thirty years", "Forty years", "Fifty years"),
                mcq1Idx = 2,
                mcq1Hi = "एम. हैमेल ने उसी स्कूल में 40 वर्षों तक निष्ठापूर्वक सेवा की थी।",
                mcq2Q = "What did M. Hamel call 'the key to their prison' for an enslaved people?",
                mcq2Opts = listOf("Weapons", "Their language (mother tongue)", "Gold", "Secret letters"),
                mcq2Idx = 1,
                mcq2Hi = "एम. हैमेल ने कहा कि जब तक गुलाम लोग अपनी भाषा थामे रहते हैं, वह उनकी जेल की चाबी है।",
                fillQ = "The order from ______ stated that only German would be taught in Alsace and Lorraine.",
                fillA = "Berlin",
                tfQ = "Franz had prepared all the rules of participles before entering M. Hamel's class.",
                tfA = "False",
                extractQuote = "“When a people are enslaved, as long as they hold fast to their language it is as if they had the key to their prison.”",
                extractQ = "Why is holding fast to one's language vital for freedom?",
                extractA = "Because language preserves cultural identity, unity, and the spirit of independence.",
                pairs = listOf(
                    MatchPair("Franz", "Schoolboy who regretted procrastinating"),
                    MatchPair("M. Hamel", "Devoted French teacher for 40 years"),
                    MatchPair("Old Hauser", "Brought an old primer"),
                    MatchPair("Wachter", "Village blacksmith")
                )
            )
        ),
        Chapter(
            id = "c12_fl_2",
            classLevel = 12,
            bookName = "Flamingo",
            chapterNumber = 2,
            title = "Lost Spring",
            titleHi = "खोया हुआ वसंत",
            author = "Anees Jung",
            summaryEn = "Anees Jung exposes the stolen childhood of poor children through two accounts: Saheb-e-Alam, a ragpicker from Dhaka living in Seemapuri, and Mukesh, a bangle-maker's son in Firozabad who dares to dream of becoming a motor mechanic.",
            summaryHi = "अनीस जंग ने इस पाठ में बाल श्रम और गरीबी से छीने गए बचपन का यथार्थ दिखाया है—सीमापुरी का कचरा बीनने वाला साहेब और फिरोज़ाबाद का मुकेश, जो चूड़ी बनाने की परंपरा तोड़कर मोटर मैकेनिक बनना चाहता है।",
            hindiExplanation = "पहले भाग 'कभी-कभी मुझे कचरे में एक रुपया मिल जाता है' में साहेब-ए-आलम है जो ढाका से सीमापुरी आया है। उसके लिए कचरा ही 'सोना' है जिससे परिवार का पेट भरता है। चाय की दुकान पर काम करने पर उसे 800 रुपये मिलते हैं, पर उसकी आज़ादी छिन जाती है। दूसरे भाग 'मैं कार चलाना चाहता हूँ' में फिरोज़ाबाद की तंग गलियों में पीढ़ियों से काँच की चूड़ियाँ बनाते परिवार हैं, जहाँ अंधेरे और गरीबी के बीच मुकेश मोटर मैकेनिक बनने का साहसिक सपना देखता है।",
            wordMeanings = listOf(
                WordMeaning("Scrounging", "verb", "Searching for something usable", "कचरे में ढूँढना", "Boys were scrounging for gold in garbage dumps."),
                WordMeaning("Perpetual", "adj", "Never ending", "निरंतर / स्थायी", "They lived in a perpetual state of poverty."),
                WordMeaning("Mirage", "noun", "An illusion or unrealistic hope", "मृगतृष्णा / भ्रम", "His dream looms like a mirage amidst dust."),
                WordMeaning("Vicious circle", "noun", "Trap of repeating hardships", "दुष्चक्र", "Middlemen and sahukars form a vicious circle.")
            ),
            questions = buildQuestions(
                chapterId = "c12_fl_2",
                title = "Lost Spring",
                author = "Anees Jung",
                themeEn = "Poverty and child labour rob children of their spring (childhood), yet courage to dream sparks change.",
                themeHi = "गरीबी और बाल श्रम बचपन छीन लेते हैं, पर मुकेश जैसे साहसिक सपने बदलाव की आशा जगाते हैं।",
                vsQ = "What is the irony in Saheb-e-Alam's name?",
                vsA = "'Saheb-e-Alam' means 'Lord of the Universe', yet he is a barefoot ragpicker searching garbage.",
                vsHi = "'साहेब-ए-आलम' का अर्थ 'ब्रह्मांड का स्वामी' है, जबकि वह नंगे पाँव कचरा बीनने वाला गरीब लड़का है।",
                mcq1Q = "What does Mukesh dream of becoming instead of making bangles?",
                mcq1Opts = listOf("A motor mechanic", "A pilot", "A teacher", "A shopkeeper"),
                mcq1Idx = 0,
                mcq1Hi = "मुकेश मोटर मैकेनिक बनकर कार चलाना सीखना चाहता है।",
                mcq2Q = "How much did Saheb earn working at the tea stall?",
                mcq2Opts = listOf("500 rupees", "800 rupees and all meals", "1,200 rupees", "300 rupees"),
                mcq2Idx = 1,
                mcq2Hi = "चाय की दुकान पर उसे 800 रुपये और पूरा भोजन मिलता था, पर वह अब अपना मालिक नहीं रहा।",
                fillQ = "For the elders of Seemapuri, garbage is a means of survival, whereas for children it is wrapped in ______.",
                fillA = "wonder",
                tfQ = "Saheb was happier carrying the heavy steel canister at the tea stall than his plastic rag-picking bag.",
                tfA = "False",
                extractQuote = "“Garbage to them is gold. It is their daily bread, a roof over their heads, even if it is a leaking roof.”",
                extractQ = "Why is garbage described as 'gold' for Seemapuri families?",
                extractA = "Because ragpicking provides their daily food and survival.",
                pairs = listOf(
                    MatchPair("Saheb-e-Alam", "Ragpicker in Seemapuri"),
                    MatchPair("Mukesh", "Aspiring motor mechanic"),
                    MatchPair("Firozabad", "Glass-bangle industry"),
                    MatchPair("Savita", "Young girl soldering glass")
                )
            )
        ),
        Chapter(
            id = "c12_fl_3",
            classLevel = 12,
            bookName = "Flamingo",
            chapterNumber = 3,
            title = "Deep Water",
            titleHi = "गहरा पानी",
            author = "William Douglas",
            summaryEn = "William Douglas recounts how two childhood incidents left him terrified of water. Years later, he hires a patient YMCA swimming instructor and practices relentlessly until he conquers his terror completely.",
            summaryHi = "विलियम डगलस बताते हैं कि कैसे बचपन की दो घटनाओं ने उनके मन में पानी का गहरा डर पैदा कर दिया और कैसे उन्होंने एक कुशल प्रशिक्षक की मदद व अडिग अभ्यास से उस डर पर पूरी तरह विजय प्राप्त की।",
            hindiExplanation = "चार साल की उम्र में कैलिफोर्निया के समुद्र तट पर लहरें डगलस को गिरा देती हैं। ग्यारह साल की उम्र में याकिमा के YMCA पूल में एक बड़ा लड़का उन्हें 9 फीट गहरे पानी में फेंक देता है। डूबते हुए वे तीन बार ऊपर आने की कोशिश करते हैं पर बेहोश हो जाते हैं। इस घटना का डर सालों तक उनका पीछा करता है। अंततः वे एक प्रशिक्षक रखते हैं जो पाँच दिन प्रति सप्ताह अभ्यास कराकर उन्हें तैरना सिखाता है। लेक वेंटवर्थ में तैरकर वे डर को हमेशा के लिए हरा देते हैं।",
            wordMeanings = listOf(
                WordMeaning("Aversion", "noun", "Strong dislike or fear", "तीव्र घृणा / डर", "He had an aversion to water from age three."),
                WordMeaning("Bruiser", "noun", "A tough, aggressive person", "हट्टा-कट्टा झगड़ालू लड़का", "A big bruiser tossed Douglas into the deep end."),
                WordMeaning("Oblivion", "noun", "State of unconsciousness", "बेहोशी / विस्मृति", "The curtain of life fell and he slipped into oblivion."),
                WordMeaning("Residual", "adj", "Remaining after most is gone", "अवशिष्ट / बचा हुआ", "Tiny vestiges of residual doubts vanished at Warm Lake.")
            ),
            questions = buildQuestions(
                chapterId = "c12_fl_3",
                title = "Deep Water",
                author = "William Douglas",
                themeEn = "As Roosevelt said, 'All we have to fear is fear itself'—perseverance conquers any phobia.",
                themeHi = "डर केवल मन में होता है; दृढ़ संकल्प और निरंतर अभ्यास से किसी भी भय पर विजय पाई जा सकती है।",
                vsQ = "How deep was the deep end of the YMCA pool where Douglas was thrown?",
                vsA = "Nine feet deep.",
                vsHi = "YMCA पूल का गहरा सिरा नौ फीट गहरा था।",
                mcq1Q = "Which lake did Douglas swim across to test if any fear remained?",
                mcq1Opts = listOf("Lake Wentworth and Warm Lake", "Lake Superior", "Dal Lake", "Lake Michigan"),
                mcq1Idx = 0,
                mcq1Hi = "उन्होंने लेक वेंटवर्थ और वार्म लेक में तैरकर अपने डर को पूरी तरह समाप्त किया।",
                mcq2Q = "Who said: 'All we have to fear is fear itself'?",
                mcq2Opts = listOf("Abraham Lincoln", "Franklin D. Roosevelt", "William Douglas", "Winston Churchill"),
                mcq2Idx = 1,
                mcq2Hi = "डगलस ने अमेरिकी राष्ट्रपति रूज़वेल्ट के इस प्रसिद्ध कथन को उद्धृत किया है।",
                fillQ = "The YMCA instructor built a swimmer out of Douglas piece by ______.",
                fillA = "piece",
                tfQ = "Douglas conquered his fear of water in a single week without any instructor.",
                tfA = "False",
                extractQuote = "“All we have to fear is fear itself.”",
                extractQ = "How did Douglas prove this truth in his own life?",
                extractA = "By confronting his lifelong hydrophobia step-by-step until he swam across miles of deep lakes fearlessly.",
                pairs = listOf(
                    MatchPair("Yakima River", "Treacherous river warned by mother"),
                    MatchPair("YMCA Pool", "9 feet deep at one end"),
                    MatchPair("Instructor", "Used belt and pulley"),
                    MatchPair("Lake Wentworth", "Two-mile swim conquering fear")
                )
            )
        ),
        Chapter(
            id = "c12_fl_5",
            classLevel = 12,
            bookName = "Flamingo",
            chapterNumber = 5,
            title = "Indigo",
            titleHi = "नील (इंडीगो)",
            author = "Louis Fischer",
            summaryEn = "Based on Mahatma Gandhi's Champaran Satyagraha (1917), triggered by resilient peasant Rajkumar Shukla. Gandhi wins justice for sharecroppers against British landlords, proving self-reliance and fearlessness are the core of India's freedom.",
            summaryHi = "1917 के चंपारण सत्याग्रह पर आधारित यह पाठ दर्शाता है कि कैसे किसान राजकुमार शुक्ल के आग्रह पर गांधीजी ने बटाईदार किसानों को नील की खेती के शोषण से मुक्त कराया और निर्भयता की नींव रखी।",
            hindiExplanation = "1916 के लखनऊ अधिवेशन में गरीब किसान राजकुमार शुक्ल गांधीजी से मिले और अडिग रहकर उन्हें चंपारण ले गए। वहां अंग्रेज जमींदार किसानों से 15% जमीन पर नील की खेती कराते थे और सिंथेटिक नील बनने पर मुआवज़ा माँग रहे थे। गांधीजी ने अदालत में जनसमर्थन से साबित किया कि किसान अब डरते नहीं। उन्होंने 25% धन वापसी स्वीकार की क्योंकि उनके लिए धन से अधिक जमींदारों के घमंड का टूटना महत्वपूर्ण था। साथ ही उन्होंने चंपारण में स्कूल और स्वच्छता कार्य भी शुरू किए।",
            wordMeanings = listOf(
                WordMeaning("Resolute", "adj", "Determined and unwavering", "दृढ़ निश्चयी", "Rajkumar Shukla was illiterate yet resolute."),
                WordMeaning("Sharecroppers", "noun", "Tenant farmers giving share of crop", "बटाईदार किसान", "Champaran peasants were poor sharecroppers."),
                WordMeaning("Deadlock", "noun", "Complete standstill in talks", "गतिरोध", "Gandhi broke the deadlock by accepting 25% refund."),
                WordMeaning("Self-reliance", "noun", "Relying on one's own strength", "आत्मनिर्भरता", "Gandhi taught his followers a lesson in self-reliance.")
            ),
            questions = buildQuestions(
                chapterId = "c12_fl_5",
                title = "Indigo",
                author = "Louis Fischer",
                themeEn = "Liberation from fear, moral courage, and self-reliance are the foundation of true independence.",
                themeHi = "भय से मुक्ति, नैतिक साहस और आत्मनिर्भरता ही सच्ची स्वतंत्रता की नींव है।",
                vsQ = "Why did Gandhi agree to a settlement of only 25% refund to the farmers?",
                vsA = "Because the amount mattered less than forcing British landlords to surrender part of their money and prestige.",
                vsHi = "क्योंकि धनराशि से अधिक महत्वपूर्ण यह था कि अंग्रेज जमींदारों को अपना धन व झूठा सम्मान झुककर लौटाना पड़ा।",
                mcq1Q = "Which resolute peasant brought Mahatma Gandhi to Champaran?",
                mcq1Opts = listOf("Rajkumar Shukla", "Rajendra Prasad", "J.B. Kripalani", "Brij Kishor Babu"),
                mcq1Idx = 0,
                mcq1Hi = "चंपारण के दृढ़ निश्चयी किसान राजकुमार शुक्ल गांधीजी को वहां लेकर आए।",
                mcq2Q = "Why did Gandhi refuse Charles Freer Andrews' help in Champaran?",
                mcq2Opts = listOf("To teach Indians self-reliance instead of leaning on an Englishman", "Because Andrews was unwell", "Because the case was over", "For lack of funds"),
                mcq2Idx = 0,
                mcq2Hi = "गांधीजी भारतीयों को सिखाना चाहते थे कि अपनी लड़ाई अपने बल पर लड़नी चाहिए (आत्मनिर्भरता)।",
                fillQ = "Under the old agreement, Champaran peasants had to plant ______ percent of their holdings with indigo.",
                fillA = "15",
                tfQ = "The Champaran episode became a major turning point in Gandhi's life and India's freedom struggle.",
                tfA = "True",
                extractQuote = "“The real relief for them is to be free from fear.”",
                extractQ = "Why did Gandhi consider freedom from fear more important than court cases?",
                extractA = "Because crushed, terrified peasants could not defend their rights until they overcame fear of British authority.",
                pairs = listOf(
                    MatchPair("Rajkumar Shukla", "Resolute Champaran peasant"),
                    MatchPair("Motihari", "Headquarters of Champaran"),
                    MatchPair("25% Refund", "Moral victory over landlords"),
                    MatchPair("Kasturbai", "Taught personal cleanliness")
                )
            )
        ),

        // --- VISTAS ---
        Chapter(
            id = "c12_vi_1",
            classLevel = 12,
            bookName = "Vistas",
            chapterNumber = 1,
            title = "The Third Level",
            titleHi = "तीसरा स्तर",
            author = "Jack Finney",
            category = "Supplementary",
            summaryEn = "Charley, a 31-year-old New Yorker stressed by modern insecurities, stumbles upon a mysterious 'third level' at Grand Central Station leading back to peaceful 1894 Galesburg—blending fantasy, nostalgia, and psychological escapism.",
            summaryHi = "आधुनिक जीवन के तनाव से परेशान चार्ली को न्यूयॉर्क के ग्रैंड सेंट्रल स्टेशन पर एक रहस्यमयी 'तीसरा स्तर' मिलता है जो उसे 1894 के शांत गेल्सबर्ग ले जाता है—यह कहानी कल्पना और यथार्थ के बीच का अद्भुत संगम है।",
            hindiExplanation = "ग्रैंड सेंट्रल स्टेशन पर वास्तव में केवल दो ही तल (levels) हैं, पर चार्ली दावा करता है कि वह तीसरे तल पर पहुँचा जहाँ पीतल के पीकदान, गैस की बत्तियाँ, 1894 की 'द वर्ल्ड' अखबार और पुराने नोट चलते थे। उसका मनोचिकित्सक मित्र सैम इसे 'जागते हुए इच्छा-पूर्ति का सपना' बताता है। लेकिन बाद में चार्ली को अपने दादाजी के स्टाम्प संग्रह में सैम द्वारा 1894 के गेल्सबर्ग से भेजा गया एक 'फर्स्ट-डे कवर' पत्र मिलता है।",
            wordMeanings = listOf(
                WordMeaning("Waking-dream", "noun", "Daydream / wish fulfillment", "दिवास्वप्न", "Sam called it a waking-dream wish fulfillment."),
                WordMeaning("First-day cover", "noun", "Envelope mailed on a stamp's release date", "प्रथम दिवस आवरण", "Sam's letter arrived inside an old first-day cover."),
                WordMeaning("Spittoons", "noun", "Brass containers for spitting", "पीकदान", "There were brass spittoons on the third level floor."),
                WordMeaning("Philately", "noun", "Stamp collecting", "डाक टिकट संग्रह", "Charley pursued philately as a temporary refuge.")
            ),
            questions = buildQuestions(
                chapterId = "c12_vi_1",
                title = "The Third Level",
                author = "Jack Finney",
                themeEn = "Modern war and anxiety push people to seek peaceful refuge in nostalgia and imagination.",
                themeHi = "आधुनिक युग की चिंता और असुरक्षा इंसान को अतीत की शांति और कल्पना में आश्रय खोजने को प्रेरित करती है।",
                vsQ = "What date was printed on the newspaper 'The World' that Charley saw on the third level?",
                vsA = "June 11, 1894.",
                vsHi = "'द वर्ल्ड' अखबार पर 11 जून 1894 की तारीख छपी थी।",
                mcq1Q = "Who was Sam Weiner in 'The Third Level'?",
                mcq1Opts = listOf("Charley's psychiatrist friend", "Station master", "Ticket clerk", "Charley's grandfather"),
                mcq1Idx = 0,
                mcq1Hi = "सैम वीनर चार्ली का मनोचिकित्सक (psychiatrist) मित्र था।",
                mcq2Q = "Where did Sam buy 800 dollars worth of old-style currency to settle down?",
                mcq2Opts = listOf("Chicago", "Galesburg, Illinois (1894)", "Boston", "London"),
                mcq2Idx = 1,
                mcq2Hi = "सैम 1894 के शांत शहर गेल्सबर्ग (इलिनोइस) में घास और अनाज का व्यापार करने चला गया।",
                fillQ = "Grand Central Station officially has only ______ levels.",
                fillA = "two",
                tfQ = "Charley successfully bought two tickets to Galesburg on the third level using his modern currency.",
                tfA = "False",
                extractQuote = "“That was a temporary refuge from reality.”",
                extractQ = "Why did Sam say stamp collecting was a refuge from reality?",
                extractA = "Because modern life is full of insecurity, fear, war, and worry.",
                pairs = listOf(
                    MatchPair("Charley", "31-year-old New Yorker"),
                    MatchPair("Louisa", "Charley's wife"),
                    MatchPair("Sam Weiner", "Psychiatrist who moved to 1894"),
                    MatchPair("The World", "Newspaper dated June 11, 1894")
                )
            )
        ),
        Chapter(
            id = "c12_vi_4",
            classLevel = 12,
            bookName = "Vistas",
            chapterNumber = 4,
            title = "The Enemy",
            titleHi = "शत्रु (द एनिमी)",
            author = "Pearl S. Buck",
            category = "Supplementary",
            summaryEn = "During World War II, Japanese surgeon Dr. Sadao Hoki finds a wounded American prisoner of war washed ashore near his home. Torn between patriotism and medical ethics, he and his wife Hana save the soldier's life and help him escape.",
            summaryHi = "द्वितीय विश्वयुद्ध के दौरान जापानी सर्जन डॉ. सदाओ होकी के घर के पास समुद्र किनारे एक घायल अमेरिकी युद्धबंदी बहकर आता है। देशभक्ति और मानवता के द्वंद्व के बीच सदाओ और उनकी पत्नी हाना उसकी जान बचाकर उसे सुरक्षित निकालते हैं।",
            hindiExplanation = "डॉ. सदाओ ने अमेरिका में चिकित्सा शिक्षा प्राप्त की थी और वे एक कुशल जापानी सर्जन थे। युद्ध के दौरान जब एक घायल अमेरिकी सैनिक टॉम उनके समुद्र तटीय घर के बाहर मिला, तो नौकर डरकर काम छोड़कर चले गए। किंतु अपने चिकित्सकीय धर्म के कारण सदाओ ने गोली निकालकर उसकी जान बचाई। उन्होंने जनरल को भी सूचित किया, पर जब जनरल के हत्यारे नहीं आए तो सदाओ ने नाव, भोजन और टॉर्च देकर अमेरिकी सैनिक को सुरक्षित द्वीप की ओर भगा दिया।",
            wordMeanings = listOf(
                WordMeaning("Anaesthetic", "noun", "Drug inducing loss of sensation", "बेहोशी की दवा", "Hana helped administer the anaesthetic."),
                WordMeaning("Superstitious", "adj", "Believing in omens/magic", "अंधविश्वासी", "The servants were superstitious and fearful."),
                WordMeaning("Assassins", "noun", "Hired killers", "हत्यारे", "The General promised to send private assassins."),
                WordMeaning("Prejudice", "noun", "Unreasonable bias", "पूर्वाग्रह", "Humanity rose above wartime prejudice.")
            ),
            questions = buildQuestions(
                chapterId = "c12_vi_4",
                title = "The Enemy",
                author = "Pearl S. Buck",
                themeEn = "Universal human compassion and medical duty transcend narrow nationalism and wartime hatred.",
                themeHi = "मानवता और चिकित्सक का कर्तव्य युद्ध की घृणा और संकीर्ण सीमाओं से सदैव ऊपर होता है।",
                vsQ = "Why wasn't Dr. Sadao sent abroad with Japanese troops during the war?",
                vsA = "Because he was perfecting a medical discovery for wounds, and the old General might need his surgery.",
                vsHi = "क्योंकि वे घाव साफ करने की एक नई खोज कर रहे थे और बीमार जनरल को कभी भी उनके ऑपरेशन की ज़रूरत पड़ सकती थी।",
                mcq1Q = "Who was the wounded soldier washed ashore outside Dr. Sadao's house?",
                mcq1Opts = listOf("Tom, an American prisoner of war", "A British pilot", "A Russian sailor", "A German spy"),
                mcq1Idx = 0,
                mcq1Hi = "समुद्र किनारे बहकर आया घायल सैनिक 'टॉम' नाम का अमेरिकी युद्धबंदी था।",
                mcq2Q = "How did Dr. Sadao finally help the American soldier escape?",
                mcq2Opts = listOf("By hiding him in Tokyo", "By giving him his boat, food, water, and a flashlight to reach a nearby island", "By calling the embassy", "By dressing him as a guard"),
                mcq2Idx = 1,
                mcq2Hi = "सदाओ ने उसे अपनी नाव, भोजन, पानी, कपड़े और टॉर्च देकर पास के द्वीप से कोरियाई नाव पकड़ने भेजा।",
                fillQ = "Dr. Sadao's wife ______ washed the wounded soldier herself when Yumi refused.",
                fillA = "Hana",
                tfQ = "The old General kept his promise and sent his private assassins on the third night.",
                tfA = "False",
                extractQuote = "“I wonder why I could not kill him?”",
                extractQ = "Why couldn't Dr. Sadao hand over or kill his enemy?",
                extractA = "Because his medical training and innate human compassion made saving life stronger than wartime hatred.",
                pairs = listOf(
                    MatchPair("Dr. Sadao", "Japanese surgeon trained in America"),
                    MatchPair("Hana", "Sadao's courageous wife"),
                    MatchPair("Tom", "Wounded American POW"),
                    MatchPair("Yumi", "Servant who refused to wash the enemy")
                )
            )
        )
    ) + Class12MissingChapters.chapters + Class12PoemsCurriculum.poems
}
