package com.example.data.curriculum

import com.example.data.model.Chapter
import com.example.data.model.ChapterQuestion
import com.example.data.model.MatchPair
import com.example.data.model.QuestionSourceTag
import com.example.data.model.QuestionType
import com.example.data.model.WordMeaning

object Class11Curriculum {

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
            classLevel = 11,
            type = QuestionType.VERY_SHORT,
            sourceTag = QuestionSourceTag.NCERT,
            promptEn = vsQ,
            answerEn = vsA,
            answerHi = vsHi
        ),
        ChapterQuestion(
            id = "${chapterId}_sh1",
            chapterId = chapterId,
            classLevel = 11,
            type = QuestionType.SHORT,
            sourceTag = QuestionSourceTag.NCERT,
            promptEn = "Explain the core theme of '$title' by $author.",
            promptHi = "$author द्वारा रचित '$title' का मुख्य भाव स्पष्ट कीजिए।",
            answerEn = themeEn,
            answerHi = themeHi
        ),
        ChapterQuestion(
            id = "${chapterId}_lg1",
            chapterId = chapterId,
            classLevel = 11,
            type = QuestionType.LONG,
            sourceTag = QuestionSourceTag.NCERT,
            promptEn = "Analyze the key events and character development in '$title' (100–120 words).",
            promptHi = "'$title' की प्रमुख घटनाओं और पात्रों के विकास का विश्लेषण कीजिए।",
            answerEn = "'$title' by $author explores $themeEn Through rich imagery and emotional realism, the text offers deep insight into relationships, courage, and human resilience.",
            answerHi = "$author का पाठ '$title' दर्शाता है कि $themeHi परीक्षा की तैयारी के लिए यह अध्याय अत्यंत उपयोगी है।"
        ),
        ChapterQuestion(
            id = "${chapterId}_mcq1",
            chapterId = chapterId,
            classLevel = 11,
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
            classLevel = 11,
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
            classLevel = 11,
            type = QuestionType.FILL_BLANK,
            sourceTag = QuestionSourceTag.PRACTICE,
            promptEn = fillQ,
            answerEn = fillA,
            explanationHi = "सही उत्तर: $fillA"
        ),
        ChapterQuestion(
            id = "${chapterId}_tf1",
            chapterId = chapterId,
            classLevel = 11,
            type = QuestionType.TRUE_FALSE,
            sourceTag = QuestionSourceTag.PRACTICE,
            promptEn = tfQ,
            answerEn = tfA,
            options = listOf("True", "False"),
            correctOptionIndex = if (tfA.equals("True", ignoreCase = true)) 0 else 1,
            explanationHi = "कथन $tfA है।"
        ),
        ChapterQuestion(
            id = "${chapterId}_mt1",
            chapterId = chapterId,
            classLevel = 11,
            type = QuestionType.MATCH,
            sourceTag = QuestionSourceTag.PRACTICE,
            promptEn = "Match the following from '$title':",
            answerEn = pairs.joinToString("; ") { "${it.left} -> ${it.right}" },
            matchPairs = pairs
        ),
        ChapterQuestion(
            id = "${chapterId}_ex1",
            chapterId = chapterId,
            classLevel = 11,
            type = QuestionType.EXTRACT,
            sourceTag = QuestionSourceTag.NCERT,
            extractText = extractQuote,
            promptEn = extractQ,
            answerEn = extractA,
            explanationHi = "यह अंश कक्षा 11 के पाठ '$title' से लिया गया है।"
        ),
        ChapterQuestion(
            id = "${chapterId}_pyq1",
            chapterId = chapterId,
            classLevel = 11,
            type = QuestionType.BOARD_PYQ,
            sourceTag = QuestionSourceTag.NCERT,
            boardReference = "NCERT Class 11 Core Assessment",
            promptEn = "What value or literary insight does '$title' leave with the reader?",
            promptHi = "'$title' पाठ पाठकों को क्या जीवन मूल्य या साहित्यिक संदेश देता है?",
            answerEn = themeEn,
            answerHi = themeHi
        )
    )

    val chapters: List<Chapter> = listOf(
        // --- HORNBILL ---
        Chapter(
            id = "c11_hb_1",
            classLevel = 11,
            bookName = "Hornbill",
            chapterNumber = 1,
            title = "The Portrait of a Lady",
            titleHi = "एक महिला का चित्र",
            author = "Khushwant Singh",
            summaryEn = "Khushwant Singh lovingly portrays his religious, silver-haired grandmother—from their close bond in the village to the quiet distance in the city and university, and the sparrows' silent mourning at her death.",
            summaryHi = "खुशवंत सिंह अपनी धार्मिक और स्नेही दादी माँ का मार्मिक चित्रण करते हैं—गांव में साथ बिताए दिनों से लेकर शहर में बढ़ती दूरी और उनकी मृत्यु पर गौरैयों के मौन शोक तक।",
            hindiExplanation = "लेखक अपनी दादी को याद करते हुए बताते हैं कि वे हमेशा सफेद कपड़ों में रहतीं और माला जपती थीं। गांव में दादी उन्हें स्कूल छोड़तीं और कुत्तों को बासी रोटियाँ खिलाती थीं। शहर आने पर जब लेखक अंग्रेजी स्कूल और फिर विश्वविद्यालय जाने लगा, तो उनका संवाद कम हो गया। दादी ने खुद को चरखे और दोपहर में गौरैयों को रोटी के टुकड़े खिलाने में व्यस्त कर लिया। जब उनकी मृत्यु हुई, तो हज़ारों गौरैयां चुपचाप आकर उनके शव के पास बैठ गईं और बिना दाना खाए उड़ गईं।",
            wordMeanings = listOf(
                WordMeaning("Mantelpiece", "noun", "Shelf above a fireplace", "अंगीठी के ऊपर का शेल्फ", "Grandfather's portrait hung above the mantelpiece."),
                WordMeaning("Puckered", "adj", "Wrinkled / gathered into folds", "झुर्रियों से भरा", "Her lips constantly moved in inaudible prayer."),
                WordMeaning("Seclusion", "noun", "State of being private/alone", "एकांतवास", "She accepted her seclusion with resignation."),
                WordMeaning("Shroud", "noun", "Cloth wrapped around a dead body", "कफ़न", "They covered her with a red shroud.")
            ),
            questions = buildQuestions(
                chapterId = "c11_hb_1",
                title = "The Portrait of a Lady",
                author = "Khushwant Singh",
                themeEn = "Unconditional love, quiet dignity, and the evolving bond between generations.",
                themeHi = "निस्वार्थ प्रेम, शांत गरिमा और पीढ़ियों के बीच बदलते संबंधों की मार्मिक अभिव्यक्ति।",
                vsQ = "How did the grandmother spend her happiest half-hour in the city?",
                vsA = "Feeding hundreds of little sparrows with bread crumbs in the afternoon.",
                vsHi = "शहर में दादी का सबसे सुखद आधा घंटा दोपहर में गौरैयों को रोटी के टुकड़े खिलाने में बीतता था।",
                mcq1Q = "What happened when the grandmother returned from the railway station after welcoming Khushwant Singh?",
                mcq1Opts = listOf("She fell asleep immediately", "She sang songs of warriors with neighbours on an old drum", "She wrote a letter", "She cooked sweets"),
                mcq1Idx = 1,
                mcq1Hi = "पोते के विदेश से लौटने की खुशी में उन्होंने पड़ोस की महिलाओं के साथ ढोलक बजाकर गीत गाए।",
                mcq2Q = "How did the sparrows react after the grandmother passed away?",
                mcq2Opts = listOf("They chirped loudly", "They sat quietly in the verandah and did not eat bread crumbs", "They flew away at once", "They pecked the window"),
                mcq2Idx = 1,
                mcq2Hi = "गौरैयां चुपचाप शोक मनाने आईं और उन्होंने फेंके गए रोटी के टुकड़ों को छुआ तक नहीं।",
                fillQ = "In the village, the grandmother carried several ______ chapattis for village dogs.",
                fillA = "stale",
                tfQ = "The grandmother was delighted when Khushwant Singh told her he was learning music at the city school.",
                tfA = "False",
                extractQuote = "“Thousands of sparrows sat scattered on the floor. There was no chirruping.”",
                extractQ = "Why were the sparrows completely silent?",
                extractA = "They had gathered to mourn the death of the kind grandmother who fed them daily.",
                pairs = listOf(
                    MatchPair("Grandmother", "Silver locks & rosary"),
                    MatchPair("Village temple", "Alphabet & morning prayers"),
                    MatchPair("City afternoon", "Feeding sparrows"),
                    MatchPair("Red shroud", "Final farewell")
                )
            )
        ),
        Chapter(
            id = "c11_hb_2",
            classLevel = 11,
            bookName = "Hornbill",
            chapterNumber = 2,
            title = "We're Not Afraid to Die... if We Can All Be Together",
            titleHi = "हम मरने से नहीं डरते... यदि हम सब साथ हों",
            author = "Gordon Cook and Alan East",
            summaryEn = "A gripping true survival story of a family sailing around the world on the Wavewalker. Struck by a colossal wave in the southern Indian Ocean, their unity, seamanship, and 6-year-old Jon's courage carry them to Ile Amsterdam.",
            summaryHi = "एक परिवार की सच्ची समुद्री साहसिक कहानी जो 'वेववॉकर' नाव से विश्व भ्रमण पर निकलता है। दक्षिणी हिंद महासागर की विशाल लहरों से क्षतिग्रस्त नाव को परिवार का साहस और एकता सुरक्षित द्वीप तक ले जाती है।",
            hindiExplanation = "जुलाई 1976 में कथावाचक, उनकी पत्नी मैरी, बेटा जोनाथन (6 वर्ष) और बेटी सुज़ैन (7 वर्ष) 'वेववॉकर' नाव से विश्व यात्रा पर निकले। केप टाउन के बाद दक्षिणी हिंद महासागर में भयंकर तूफान ने नाव को लगभग तोड़ दिया। कथावाचक और दो क्रू सदस्य लैरी व हर्ब ने लगातार पानी बाहर निकाला। घायल सुज़ैन ने दर्द छिपाया और नन्हे जॉन ने कहा—'हमें मरने से डर नहीं लगता यदि हम सब साथ रहें।' अंततः वे एम्स्टर्डम द्वीप सुरक्षित पहुँच गए।",
            wordMeanings = listOf(
                WordMeaning("Honing", "verb", "Sharpening or perfecting skills", "निखारना / तेज़ करना", "They spent years honing their seafaring skills."),
                WordMeaning("Gigantic", "adj", "Extremely large", "विशालकाय", "A gigantic wave struck the Wavewalker."),
                WordMeaning("Capsize", "verb", "Overturn in water", "नाव पलटना", "The boat nearly capsized in the storm."),
                WordMeaning("Sextant", "noun", "Instrument for celestial navigation", "कोण मापक समुद्री यंत्र", "The narrator used a spare compass and sextant.")
            ),
            questions = buildQuestions(
                chapterId = "c11_hb_2",
                title = "We're Not Afraid to Die... if We Can All Be Together",
                author = "Gordon Cook and Alan East",
                themeEn = "Courage, family unity, and calm perseverance triumph over nature's fiercest storms.",
                themeHi = "साहस, पारिवारिक एकता और धैर्य जीवन के सबसे बड़े तूफानों को भी जीत लेते हैं।",
                vsQ = "What was the name of the boat built by the narrator for the round-the-world voyage?",
                vsA = "Wavewalker (a 23-metre, 30-ton wooden-hulled boat).",
                vsHi = "उनकी नाव का नाम 'वेववॉकर' (Wavewalker) था।",
                mcq1Q = "Which two crewmen joined the family from Cape Town to tackle the southern Indian Ocean?",
                mcq1Opts = listOf("Larry Vigil and Herb Seigler", "Gordon and Alan", "Howard and Carter", "Tom and Nick"),
                mcq1Idx = 0,
                mcq1Hi = "केप टाउन से अमेरिकी लैरी विजिल और स्विस हर्ब सीग्लर को साथ लिया गया।",
                mcq2Q = "Which small island did the damaged Wavewalker reach safely?",
                mcq2Opts = listOf("Madagascar", "Ile Amsterdam", "Sri Lanka", "Mauritius"),
                mcq2Idx = 1,
                mcq2Hi = "नाव 'आइल एम्स्टर्डम' (Ile Amsterdam) नामक फ्रांसीसी वैज्ञानिक द्वीप पर सुरक्षित पहुँची।",
                fillQ = "Six-year-old ______ said they were not afraid of dying if they could all be together.",
                fillA = "Jonathan",
                tfQ = "Seven-year-old Sue complained loudly about her head injury so her father would stop steering.",
                tfA = "False",
                extractQuote = "“Daddy, are we going to die?” ... “But, Daddy, we aren't afraid of dying if we can all be together.”",
                extractQ = "How did Jonathan's words inspire the narrator?",
                extractA = "His fearless words renewed the narrator's determination to fight the sea with everything he had.",
                pairs = listOf(
                    MatchPair("Wavewalker", "23-metre wooden yacht"),
                    MatchPair("Jonathan", "6-year-old brave son"),
                    MatchPair("Suzanne", "Made a 'Thank you' card"),
                    MatchPair("Ile Amsterdam", "Pinprick in the ocean")
                )
            )
        ),
        Chapter(
            id = "c11_hb_3",
            classLevel = 11,
            bookName = "Hornbill",
            chapterNumber = 3,
            title = "Discovering Tut: the Saga Continues",
            titleHi = "टुट की खोज: गाथा जारी है",
            author = "A.R. Williams",
            summaryEn = "An archaeological account of King Tutankhamun, the teenaged Egyptian pharaoh. From Howard Carter's 1922 discovery to the 2005 CT scan, modern forensic science uncovers mysteries of his life and death.",
            summaryHi = "मिस्र के युवा फैरो राजा तुतनखामेन (King Tut) के मकबरे की 1922 में हॉवर्ड कार्टर द्वारा खोज और 2005 में आधुनिक सीटी स्कैन द्वारा उनकी मृत्यु के रहस्यों की वैज्ञानिक पड़ताल।",
            hindiExplanation = "तुतनखामेन प्राचीन मिस्र के एक शक्तिशाली वंश के अंतिम किशोर शासक थे, जिनकी लगभग 3,300 वर्ष पहले मृत्यु हुई। 1922 में ब्रिटिश पुरातत्वविद् हॉवर्ड कार्टर ने उनका सोने से भरा मकबरा खोजा। 2005 में ज़ाही हवास के नेतृत्व में टुट की ममी का सीटी स्कैन किया गया जिससे 1,700 डिजिटल एक्स-रे चित्र बने। इससे पता चला कि आधुनिक विज्ञान पुरातत्व के पुराने रहस्यों को बिना नुकसान पहुँचाए सुलझा सकता है।",
            wordMeanings = listOf(
                WordMeaning("Pharaoh", "noun", "Ruler in ancient Egypt", "मिस्र के प्राचीन सम्राट", "King Tut was the last teenage pharaoh of his dynasty."),
                WordMeaning("Resin", "noun", "Sticky plant substance used in embalming", "राल / गोंद", "Ritual resins had hardened, cementing Tut to the coffin."),
                WordMeaning("Forensic", "adj", "Relating to scientific investigation", "वैज्ञानिक जाँच संबंधी", "Forensic reconstruction revealed his features."),
                WordMeaning("Cemetery", "noun", "Burial ground", "कब्रिस्तान", "The Valley of the Kings is an ancient royal cemetery.")
            ),
            questions = buildQuestions(
                chapterId = "c11_hb_3",
                title = "Discovering Tut: the Saga Continues",
                author = "A.R. Williams",
                themeEn = "Archaeology has evolved from treasure-hunting into non-invasive scientific investigation.",
                themeHi = "आधुनिक पुरातत्व विज्ञान खजाने की खोज से आगे बढ़कर वैज्ञानिक विश्लेषण का माध्यम बन चुका है।",
                vsQ = "Who discovered King Tut's tomb in 1922?",
                vsA = "British archaeologist Howard Carter.",
                vsHi = "ब्रिटिश पुरातत्वविद् हॉवर्ड कार्टर ने 1922 में राजा टुट का मकबरा खोजा।",
                mcq1Q = "In which year was King Tut's mummy taken for a CT scan?",
                mcq1Opts = listOf("1922", "1968", "2005", "2010"),
                mcq1Idx = 2,
                mcq1Hi = "5 जनवरी 2005 को राजा टुट की ममी का सीटी स्कैन किया गया।",
                mcq2Q = "What was Tutankhamun's original birth name before he changed it?",
                mcq2Opts = listOf("Tutankhaten", "Amenhotep", "Akhenaten", "Smenkhkare"),
                mcq2Idx = 0,
                mcq2Hi = "उनका मूल नाम 'तुतनखातेन' (Tutankhaten) था जिसे उन्होंने बाद में तुतनखामेन किया।",
                fillQ = "Howard Carter had to chisel away the hardened ______ beneath Tut's body.",
                fillA = "resins",
                tfQ = "The CT scan machine failed permanently due to sand in a cooler fan and could not scan Tut.",
                tfA = "False",
                extractQuote = "“Archaeology has changed substantially in the intervening decades, focusing less on treasure and more on the fascinating details of life.”",
                extractQ = "How has modern archaeology shifted its focus?",
                extractA = "It now prioritizes medical/forensic clues about ancient life and death rather than gold treasures.",
                pairs = listOf(
                    MatchPair("Howard Carter", "Discovered tomb in 1922"),
                    MatchPair("Zahi Hawass", "Secretary General of Antiquities"),
                    MatchPair("CT Scan", "1,700 digital X-ray slices"),
                    MatchPair("Valley of the Kings", "Ancient royal burial site")
                )
            )
        ),

        // --- SNAPSHOTS ---
        Chapter(
            id = "c11_sn_1",
            classLevel = 11,
            bookName = "Snapshots",
            chapterNumber = 1,
            title = "The Summer of the Beautiful White Horse",
            titleHi = "सुंदर सफेद घोड़े की गर्मियाँ",
            author = "William Saroyan",
            category = "Supplementary",
            summaryEn = "Two poor Armenian boys, Aram and Mourad, belong to the Garoghlanian tribe famous for honesty. Mourad steals a white horse just to ride it, and after weeks of joyful dawn rides, conscience leads them to return it quietly.",
            summaryHi = "अपनी ईमानदारी के लिए प्रसिद्ध गारोघलानियन कबीले के दो गरीब लड़के आराम और मुराद एक सुंदर सफेद घोड़े की सवारी का शौक पूरा करने के बाद अपनी अंतरात्मा की आवाज़ सुनकर उसे मालिक को लौटा देते हैं।",
            hindiExplanation = "नौ वर्षीय आराम को एक सुबह उसका चचेरा भाई मुराद एक सुंदर सफेद घोड़े के साथ जगाता है। उनका गारोघलानियन परिवार गरीबी के बावजूद पूरी दुनिया में ईमानदारी के लिए जाना जाता था। इसलिए आराम को विश्वास नहीं होता कि मुराद ने घोड़ा चुराया है, पर सवारी के लोभ में वह चुप रहता है। जब घोड़े के असली मालिक जॉन बायरो मिलते हैं और कबीले की ईमानदारी पर भरोसा जताते हैं, तो दोनों लड़के चुपचाप घोड़े को उसके अस्तबल में लौटा आते हैं।",
            wordMeanings = listOf(
                WordMeaning("Magnificence", "noun", "Grandeur and beauty", "भव्यता / शानदार रूप", "The white horse stood in all its magnificence."),
                WordMeaning("Streak", "noun", "A trace or characteristic trait", "गुण / झलक", "Mourad had a crazy streak like Uncle Khosrove."),
                WordMeaning("Pious", "adj", "Devoutly religious and honest", "धर्मपरायण / नेक", "The tribe was famous for pious honesty."),
                WordMeaning("Vineyard", "noun", "Grape farm", "अंगूर का बाग", "They hid the horse in a deserted vineyard.")
            ),
            questions = buildQuestions(
                chapterId = "c11_sn_1",
                title = "The Summer of the Beautiful White Horse",
                author = "William Saroyan",
                themeEn = "Family honour and inner conscience ultimately outweigh childish temptation.",
                themeHi = "पारिवारिक सम्मान और अंतरात्मा की आवाज़ बालसुलभ लोभ से सदैव ऊपर होती है।",
                vsQ = "What was the Garoghlanian tribe famous for?",
                vsA = "Their unwavering trust and honesty, even in extreme poverty.",
                vsHi = "गारोघलानियन कबीला गरीबी में भी अपनी अटूट ईमानदारी और भरोसे के लिए प्रसिद्ध था।",
                mcq1Q = "Who was the real owner of the beautiful white horse?",
                mcq1Opts = listOf("John Byro", "Uncle Khosrove", "Zorab", "Arak"),
                mcq1Idx = 0,
                mcq1Hi = "उस सुंदर सफेद घोड़े के असली मालिक किसान जॉन बायरो (John Byro) थे।",
                mcq2Q = "What was Uncle Khosrove's famous impatient catchphrase?",
                mcq2Opts = listOf("Pay no attention to it!", "Leave it alone!", "Run away!", "Keep quiet!"),
                mcq2Idx = 0,
                mcq2Hi = "अंकल खोसरोव हर बात पर चिल्लाते थे: 'It is no harm; pay no attention to it!'",
                fillQ = "Aram and Mourad hid the white horse in the barn of a deserted ______ belonging to Fetvajian.",
                fillA = "vineyard",
                tfQ = "John Byro accused the boys directly of stealing his horse when he saw them on the road.",
                tfA = "False",
                extractQuote = "“A suspicious man would believe his eyes instead of his heart.”",
                extractQ = "Why did John Byro say this after examining the horse's teeth?",
                extractA = "Although the horse looked identical to his stolen one, his faith in the boys' family honesty stopped him from calling them thieves.",
                pairs = listOf(
                    MatchPair("Aram", "9-year-old narrator"),
                    MatchPair("Mourad", "Had a way with animals"),
                    MatchPair("John Byro", "Assyrian farmer"),
                    MatchPair("Uncle Khosrove", "Furious yet harmless")
                )
            )
        ),
        Chapter(
            id = "c11_sn_4",
            classLevel = 11,
            bookName = "Snapshots",
            chapterNumber = 4,
            title = "Birth",
            titleHi = "जन्म (बर्थ)",
            author = "A.J. Cronin",
            category = "Supplementary",
            summaryEn = "Young Dr. Andrew Manson faces an exhausting midnight delivery at Joe Morgan's home. When the newborn appears lifeless, he refuses to give up, using alternating hot-and-cold water therapy and artificial respiration to save both mother and child.",
            summaryHi = "युवा डॉक्टर एंड्रयू मेंसन थकान और व्यक्तिगत तनाव के बावजूद जो मॉर्गन के घर एक जटिल प्रसव कराते हैं और मृतप्राय नवजात शिशु को ठंडे-गर्म पानी की चिकित्सा व कृत्रिम श्वसन से जीवनदान देते हैं।",
            hindiExplanation = "डॉ. एंड्रयू मेंसन रात को आधी रात जो मॉर्गन के घर पहुँचते हैं। कई घंटों की प्रतीक्षा के बाद भोर में बच्चे का जन्म होता है, लेकिन बच्चा बिल्कुल निश्चल और नीला (asphyxia pallida) होता है और माँ की हालत भी गंभीर थी। एंड्रयू ने पहले माँ को बचाया और फिर बिना हार माने बच्चे को बारी-बारी से गर्म व ठंडे पानी के बेसिन में रखकर और छाती दबाकर श्वास लौटाई। बच्चे की पहली किलकारी सुनकर एंड्रयू को लगा कि आज उन्होंने जीवन में सचमुच कुछ सार्थक किया है।",
            wordMeanings = listOf(
                WordMeaning("Resuscitation", "noun", "Reviving someone from unconsciousness", "पुनर्जीवन प्रक्रिया", "He began frantic resuscitation efforts for the baby."),
                WordMeaning("Asphyxia", "noun", "Lack of oxygen causing unconsciousness", "दम घुटना / श्वास अवरोध", "He recognized the condition as asphyxia pallida."),
                WordMeaning("Limp", "adj", "Lacking stiffness or strength", "शिथिल / बेजान", "The newborn lay limp like a broken stem."),
                WordMeaning("Gasp", "noun", "Sudden convulsive intake of breath", "गहरी हाँफ / श्वास लेना", "A tiny chest heave turned into a miraculous gasp.")
            ),
            questions = buildQuestions(
                chapterId = "c11_sn_4",
                title = "Birth",
                author = "A.J. Cronin",
                themeEn = "Dedicated medical perseverance and compassion can turn despair into the miracle of life.",
                themeHi = "चिकित्सक की निष्ठा, धैर्य और करुणा निराशा को भी जीवन के चमत्कार में बदल सकती है।",
                vsQ = "Why was Joe Morgan waiting anxiously outside Dr. Andrew Manson's house?",
                vsA = "His wife Susan was about to give birth to their first child after twenty years of marriage.",
                vsHi = "विवाह के बीस साल बाद उसकी पत्नी सुज़ैन पहली बार माँ बनने वाली थी।",
                mcq1Q = "Which condition did Andrew recognize in the lifeless-looking newborn?",
                mcq1Opts = listOf("Jaundice", "Asphyxia pallida", "Pneumonia", "Malaria"),
                mcq1Idx = 1,
                mcq1Hi = "डॉ. एंड्रयू ने तुरंत शिशु में 'Asphyxia pallida' (श्वास-अवरोध) की स्थिति पहचान ली।",
                mcq2Q = "What technique did Andrew use to revive the newborn baby?",
                mcq2Opts = listOf("Surgery", "Alternating hot and cold water baths with gentle chest compression", "Electric shock", "Herbal medicine"),
                mcq2Idx = 1,
                mcq2Hi = "उन्होंने गर्म और ठंडे पानी के बेसिन में बारी-बारी डुबोकर तथा छाती को हल्के से दबाकर श्वास लौटाई।",
                fillQ = "Dr. Andrew Manson remarked at the end: 'Oh God! I've done something ______ at last.'",
                fillA = "real",
                tfQ = "The midwife encouraged Andrew to give up on the baby immediately.",
                tfA = "True",
                extractQuote = "“I've done something; oh, God! I've done something real at last.”",
                extractQ = "Why did Andrew feel so deeply fulfilled as he walked home at dawn?",
                extractA = "Because his relentless effort had saved both Susan Morgan and her newborn son.",
                pairs = listOf(
                    MatchPair("Andrew Manson", "Dedicated young doctor"),
                    MatchPair("Joe Morgan", "Anxious expectant father"),
                    MatchPair("Asphyxia pallida", "Medical emergency"),
                    MatchPair("Hot & cold basins", "Revival method")
                )
            )
        )
    ) + Class11MissingChapters.chapters + Class11PoemsCurriculum.poems
}
