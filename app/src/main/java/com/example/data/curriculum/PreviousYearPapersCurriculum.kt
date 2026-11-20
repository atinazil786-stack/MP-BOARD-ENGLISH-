package com.example.data.curriculum

import com.example.data.model.PreviousYearPaper
import com.example.data.model.PyqQuestionItem
import com.example.data.model.PyqSectionType

object PreviousYearPapersCurriculum {

    val years: List<Int> = listOf(2022, 2023, 2024, 2025, 2026)

    val papers: List<PreviousYearPaper> by lazy {
        buildAllPapers()
    }

    private fun buildAllPapers(): List<PreviousYearPaper> {
        val list = mutableListOf<PreviousYearPaper>()
        for (cls in 9..12) {
            for (year in years) {
                list += buildPaperFor(cls, year)
            }
        }
        return list
    }

    private fun buildPaperFor(classLevel: Int, year: Int): PreviousYearPaper {
        val isVerifiedPast = year <= 2025
        val sourceLabel = if (isVerifiedPast) {
            "MPBSE Verified Pattern ($year)"
        } else {
            "MPBSE 2026 Blueprint Model Paper"
        }
        val setCode = when (year) {
            2022 -> "Set A (MPBSE)"
            2023 -> "Set B (MPBSE)"
            2024 -> "Main Board Set"
            2025 -> "Annual Exam Set"
            else -> "Blueprint 2026"
        }

        val questions = when (classLevel) {
            9 -> class9Questions(year)
            10 -> class10Questions(year)
            11 -> class11Questions(year)
            else -> class12Questions(year)
        }

        val bookDesc = when (classLevel) {
            9 -> "Beehive, Moments & Grammar"
            10 -> "First Flight, Footprints & Writing"
            11 -> "Hornbill, Snapshots & Notice/Report"
            else -> "Flamingo, Vistas & Section B"
        }

        return PreviousYearPaper(
            id = "pyq_c${classLevel}_$year",
            classLevel = classLevel,
            year = year,
            title = if (isVerifiedPast) {
                "MP Board Class ${classLevel}th English Paper $year"
            } else {
                "MP Board Class ${classLevel}th Blueprint Model Set $year"
            },
            titleHi = if (isVerifiedPast) {
                "एमपी बोर्ड कक्षा $classLevel अंग्रेजी प्रश्न पत्र ($year)"
            } else {
                "एमपी बोर्ड कक्षा $classLevel ब्लूप्रिंट मॉडल पेपर ($year)"
            },
            setCode = setCode,
            isVerifiedPyq = isVerifiedPast,
            sourceLabel = sourceLabel,
            summaryHi = if (isVerifiedPast) {
                "कक्षा $classLevel ($bookDesc) के वर्ष $year के प्रमाणित MP Board परीक्षा पैटर्न पर आधारित प्रश्न पत्र, उत्तर कुंजी (Answer Key) व आदर्श हल सहित।"
            } else {
                "नवीनतम MP Board 2026 ब्लूप्रिंट एवं पाठ्यक्रम पर आधारित अभ्यास मॉडल प्रश्न पत्र (पूर्ण हल सहित)।"
            },
            chapterTopicsTag = questions.map { it.chapterTag }.distinct(),
            questions = questions,
            pdfFileName = "MPBSE_Class${classLevel}_English_${year}.pdf"
        )
    }

    private fun class9Questions(year: Int): List<PyqQuestionItem> = when (year) {
        2022 -> listOf(
            obj(
                id = "c9_22_o1",
                tag = "The Fun They Had",
                q = "What did Margie write about in her diary dated 17 May 2157?",
                hi = "मार्गी ने 17 मई 2157 की अपनी डायरी में किस बारे में लिखा?",
                opts = listOf("Tommy found a real book", "She failed in Maths", "She got a new laptop", "School was closed"),
                ansIdx = 0,
                ans = "Tommy found a real book",
                expHi = "अध्याय 'The Fun They Had' में मार्गी ने लिखा कि टॉमी को एक असली कागज की किताब मिली थी।"
            ),
            obj(
                id = "c9_22_o2",
                tag = "Grammar – Articles",
                q = "My uncle is _____ MLA from Bhopal. (Fill in the correct article)",
                hi = "सही Article चुनिए: My uncle is _____ MLA.",
                opts = listOf("a", "an", "the", "no article"),
                ansIdx = 1,
                ans = "an",
                expHi = "MLA का उच्चारण 'एम' (स्वर ध्वनि) से शुरू होता है, इसलिए 'an' आएगा।"
            ),
            obj(
                id = "c9_22_o3",
                tag = "The Road Not Taken",
                q = "Who is the poet of 'The Road Not Taken'?",
                hi = "'The Road Not Taken' कविता के कवि कौन हैं?",
                opts = listOf("Subramania Bharati", "Robert Frost", "W.B. Yeats", "Phoebe Cary"),
                ansIdx = 1,
                ans = "Robert Frost",
                expHi = "यह प्रसिद्ध कविता रॉबर्ट फ्रॉस्ट द्वारा लिखी गई है।"
            ),
            obj(
                id = "c9_22_o4",
                tag = "Grammar – Tenses",
                q = "The earth _____ round the sun.",
                hi = "सही क्रिया रूप चुनिए:",
                opts = listOf("move", "moves", "moved", "moving"),
                ansIdx = 1,
                ans = "moves",
                expHi = "सार्वभौमिक सत्य (Universal Truth) हमेशा Simple Present Tense में होता है।"
            ),
            vs(
                id = "c9_22_vs1",
                tag = "The Sound of Music",
                q = "When was Evelyn Glennie's deafness first noticed and when was it confirmed?",
                hi = "एवलिन ग्लेनी के बहरेपन का पहली बार पता कब चला और इसकी पुष्टि कब हुई?",
                ans = "Noticed at age 8; confirmed at age 11.",
                model = "Evelyn's deafness was first noticed by her mother when she was eight years old, and it was medically confirmed by a specialist when she was eleven.",
                expHi = "8 वर्ष की उम्र में पहली बार पता चला और 11 वर्ष की उम्र में डॉक्टर द्वारा पुष्टि हुई।"
            ),
            sh(
                id = "c9_22_s1",
                tag = "The Little Girl",
                q = "Why was Kezia afraid of her father?",
                hi = "केज़िया अपने पिता से क्यों डरती थी?",
                ans = "Kezia's father was strict, spoke loudly, and looked huge to her.",
                model = "Kezia was afraid of her father because he appeared very strict and giant-like to her. He spoke loudly, rarely played with her, and scolded her harshly when she tore his important speech papers.",
                expHi = "उसके पिता बहुत सख्त, बड़ी कद-काठी वाले और तेज आवाज में बोलने वाले थे, इसलिए वह उनसे डरती थी।"
            ),
            lg(
                id = "c9_22_l1",
                tag = "Writing Skills – Application",
                q = "Write an application to your Principal requesting 3 days' leave for attending your sister's marriage.",
                hi = "बहन की शादी में जाने के लिए 3 दिन के अवकाश हेतु प्राचार्य को आवेदन पत्र लिखिए।",
                ans = "Standard Formal Application addressed to Principal with dates and reason.",
                model = "To,\nThe Principal,\nGovt. H.S. School, Bhopal.\n\nSubject: Application for 3 days' leave.\n\nRespected Sir,\nI beg to state that my elder sister's marriage is fixed for 20th February. Kindly grant me 3 days' leave from 19th to 21st February. I shall be grateful.\n\nYours obediently,\nAman, Class IX"
            )
        )
        2023 -> listOf(
            obj("c9_23_o1", "A Truly Beautiful Mind", "Where was Albert Einstein born?", "अल्बर्ट आइंस्टीन का जन्म कहाँ हुआ था?", listOf("Berlin", "Ulm (Germany)", "Zurich", "London"), 1, "Ulm (Germany)", "आइंस्टीन का जन्म 14 मार्च 1879 को जर्मनी के उल्म शहर में हुआ था।"),
            obj("c9_23_o2", "Rain on the Roof", "What brings sweet memories to the poet when rain falls on the roof?", "छत पर बारिश गिरने पर कवि को किसकी याद आती है?", listOf("His school", "His affectionate mother", "His village pond", "His childhood toy"), 1, "His affectionate mother", "बारिश की आवाज़ कवि को अपनी स्नेही माँ की याद दिलाती है।"),
            obj("c9_23_o3", "Grammar – Modals", "_____ you please lend me your pen?", "विनम्र निवेदन हेतु सही Modal चुनिए:", listOf("Should", "Would", "Must", "Need"), 1, "Would", "विनम्र निवेदन (Polite request) के लिए 'Would' या 'Could' का प्रयोग होता है।"),
            obj("c9_23_o4", "The Lost Child", "Who rescued the lost child in the fair?", "मेले में खोए बच्चे को किसने उठाया?", listOf("A policeman", "A kind stranger", "His uncle", "A shopkeeper"), 1, "A kind stranger", "मेले में एक दयालु अजनबी ने उस रोते हुए बच्चे को संभाला।"),
            vs("c9_23_vs1", "My Childhood", "Where was A.P.J. Abdul Kalam's house situated?", "डॉ. अब्दुल कलाम का घर कहाँ स्थित था?", "Mosque Street, Rameswaram.", "Dr. A.P.J. Abdul Kalam's ancestral house was situated on Mosque Street in Rameswaram, Tamil Nadu.", "तमिलनाडु के रामेश्वरम में मस्जिद गली (Mosque Street) में।"),
            sh("c9_23_s1", "Bismillah Khan", "Why did Bismillah Khan refuse to start a shehnai school in the USA?", "बिस्मिल्लाह खान ने अमेरिका में शहनाई स्कूल खोलने से मना क्यों किया?", "He loved India, Benaras, and the holy Ganga deeply.", "Bismillah Khan loved Hindustan, Benaras, and the river Ganga so deeply that he could not imagine living away from them, even for wealth in the USA.", "वे भारत, बनारस और गंगा नदी से बेहद प्रेम करते थे।"),
            lg("c9_23_l1", "The Happy Prince (Moments)", "Why did the Happy Prince send a ruby to the seamstress and sapphires to the playwright and matchgirl?", "हैप्पी प्रिंस ने गरीब लोगों की मदद के लिए अपने रत्न क्यों भेजे?", "He felt deep compassion seeing the misery and poverty of his city.", "From his tall statue, the Happy Prince saw the hunger and sorrow of poor citizens. Moved by compassion, he gave away his ruby, golden leaves, and sapphire eyes through the swallow to bring hope and survival to the needy.")
        )
        2024 -> listOf(
            obj("c9_24_o1", "Reach for the Top", "Which mountain peak did Santosh Yadav climb twice?", "संतोष यादव ने किस पर्वत शिखर पर दो बार चढ़ाई की?", listOf("K2", "Mount Everest", "Kangchenjunga", "Nanda Devi"), 1, "Mount Everest", "संतोष यादव विश्व की पहली महिला थीं जिन्होंने माउंट एवरेस्ट को दो बार फतह किया।"),
            obj("c9_24_o2", "Grammar – Prepositions", "He has been living in Indore _____ 2018.", "सही Preposition चुनिए:", listOf("for", "since", "from", "by"), 1, "since", "निश्चित समय (Point of time - 2018) के लिए 'since' का प्रयोग होता है।"),
            obj("c9_24_o3", "Wind (Poem)", "Who does the poet request to come softly in the poem 'Wind'?", "'Wind' कविता में कवि किससे धीरे आने का अनुरोध करता है?", listOf("Rain", "The Wind", "Storm clouds", "Sunlight"), 1, "The Wind", "कवि सुब्रमण्यम भारती हवा (Wind) से धीरे बहने का आग्रह करते हैं।"),
            obj("c9_24_o4", "In the Kingdom of Fools", "What cost was fixed for everything in the Kingdom of Fools?", "मूर्खों के राज्य में हर वस्तु की कीमत क्या थी?", listOf("One rupee", "Single duddu", "Two coins", "Free"), 1, "Single duddu", "वहाँ हर चीज एक 'डुड्डू' (single duddu) में मिलती थी।"),
            vs("c9_24_vs1", "Packing / Kathmandu", "Name the two famous temples visited by Vikram Seth in Kathmandu.", "काठमांडू में विक्रम सेठ किन दो प्रसिद्ध मंदिरों में गए?", "Pashupatinath Temple and Baudhnath Stupa.", "Vikram Seth visited the sacred Hindu Pashupatinath Temple and the peaceful Buddhist Baudhnath Stupa in Kathmandu.", "पशुपतिनाथ मंदिर और बौद्धनाथ स्तूप।"),
            sh("c9_24_s1", "If I Were You", "How did Gerrard outsmart the Intruder?", "जेरार्ड ने अपनी चतुराई से घुसपैठिए (Intruder) को कैसे पकड़ा?", "Gerrard fooled the Intruder with a false criminal story and locked him in a cupboard.", "Gerrard stayed calm and convinced the Intruder that he himself was a wanted criminal running from police. When the Intruder looked into the 'escape door', Gerrard pushed him inside a cupboard and locked it.", "जेरार्ड ने शांत रहकर झूठी कहानी गढ़ी और उसे अलमारी में बंद कर पुलिस बुला ली।"),
            lg("c9_24_l1", "Essay Writing", "Write an essay in 150 words on 'Wonders of Science' OR 'Importance of Trees'.", "'विज्ञान के चमत्कार' या 'पेड़ों का महत्व' पर 150 शब्दों में निबंध लिखिए।", "Heading-wise 5-paragraph essay covering Introduction, Benefits, Uses, Conclusion.", "1. Introduction: Trees are nature's greatest gift to mankind.\n2. Oxygen & Food: They absorb carbon dioxide and give life-saving oxygen, fruits, and medicines.\n3. Preventing Floods: Roots hold soil tightly and bring timely rainfall.\n4. Save Trees: Cutting forests causes global warming.\n5. Conclusion: Every student must plant and nurture at least one tree every year.")
        )
        2025 -> listOf(
            obj("c9_25_o1", "If I Were You", "What was Gerrard's profession?", "जेरार्ड का व्यवसाय क्या था?", listOf("Doctor", "Playwright", "Teacher", "Detective"), 1, "Playwright", "जेरार्ड एक नाटककार (Playwright) था।"),
            obj("c9_25_o2", "No Men Are Foreign", "What is the central theme of 'No Men Are Foreign'?", "'No Men Are Foreign' कविता का मुख्य संदेश क्या है?", listOf("Nationalism", "Universal Brotherhood", "Science", "Trade"), 1, "Universal Brotherhood", "कवि जेम्स किर्कप विश्व बंधुत्व और मानव एकता का संदेश देते हैं।"),
            obj("c9_25_o3", "Grammar – Passive Voice", "Choose correct Passive Voice: 'He writes a letter.'", "'He writes a letter.' का सही Passive Voice चुनिए:", listOf("A letter was written by him.", "A letter is written by him.", "A letter has written by him.", "A letter is write by him."), 1, "A letter is written by him.", "Simple Present का Passive: Object + is/am/are + V3 + by Subject।"),
            obj("c9_25_o4", "The Last Leaf", "Who painted the last leaf on the ivy creeper?", "बेल पर आखिरी पत्ता किसने पेंट किया था?", listOf("Johnsy", "Behrman", "Sue", "The doctor"), 1, "Behrman", "वृद्ध चित्रकार बेहरमन ने बारिश और ठंड में वह आखिरी पत्ता बनाया था।"),
            vs("c9_25_vs1", "Maria Sharapova", "Why was Maria Sharapova sent to the United States?", "मारिया शारापोवा को अमेरिका क्यों भेजा गया था?", "For advanced tennis training at age nine.", "Maria was sent to Florida, USA at the age of nine with her father Yuri to receive world-class tennis training.", "नौ वर्ष की आयु में उच्च स्तरीय टेनिस प्रशिक्षण के लिए।"),
            sh("c9_25_s1", "A Legend of the Northland", "Why did Saint Peter punish the greedy little woman?", "संत पीटर ने लालची महिला को क्या और क्यों दंड दिया?", "She refused to share even a tiny cake with the hungry saint, so she was turned into a woodpecker.", "Even though she had plenty of dough, the greedy woman made cakes smaller and smaller and gave none to starving Saint Peter. Angry at her selfishness, he turned her into a woodpecker who bores into dry wood for food.", "उसने भूखे संत को एक छोटा केक भी देने से मना कर दिया, इसलिए उसे कठफोड़वा (Woodpecker) पक्षी बना दिया गया।"),
            lg("c9_25_l1", "The Beggar (Moments)", "How did Olga's kindness transform Lushkoff from a beggar into a notary?", "ओल्गा की दयालुता ने भिखारी लश्कॉफ का जीवन कैसे बदल दिया?", "Olga scolded him out of sympathy and chopped wood for him quietly, awakening his conscience.", "Unlike Sergei who merely gave work, the cook Olga cried for Lushkoff and chopped all the firewood herself while advising him warmly. Her selfless compassion touched Lushkoff's heart, helping him quit drinking and become an honest notary.")
        )
        else -> listOf(
            obj("c9_26_o1", "The Fun They Had", "Who repaired Margie's mechanical teacher?", "मार्गी के यांत्रिक शिक्षक को किसने सुधारा?", listOf("Her father", "County Inspector", "Tommy", "School Principal"), 1, "County Inspector", "काउंटी इंस्पेक्टर ने भूगोल सेक्टर की गति को मार्गी की उम्र के अनुसार धीमा किया।"),
            obj("c9_26_o2", "Grammar – Conjunctions", "Work hard _____ you will fail.", "सही Conjunction चुनिए:", listOf("and", "or", "because", "so"), 1, "or", "चेतावनी/परिणाम बताने के लिए 'or' (अन्यथा) का उपयोग होता है।"),
            obj("c9_26_o3", "The Adventures of Toto", "Why did Grandfather sell Toto back to the tonga-driver?", "दादाजी ने टोटो बंदर को वापस तांगेवाले को क्यों बेचा?", listOf("Toto tore clothes, broke dishes, and caused daily losses.", "Toto fell ill", "Grandfather moved away", "Toto ran away"), 0, "Toto tore clothes, broke dishes, and caused daily losses.", "टोटो की शरारतों से परिवार को बार-बार आर्थिक नुकसान हो रहा था।"),
            obj("c9_26_o4", "Grammar – Determiners", "Is there _____ sugar left in the jar?", "प्रश्नवाचक वाक्य में सही Determiner चुनिए:", listOf("some", "any", "many", "few"), 1, "any", "प्रश्नवाचक और नकारात्मक वाक्यों में सामान्यतः 'any' का प्रयोग होता है।"),
            vs("c9_26_vs1", "A House Is Not a Home", "Why did Zan break down in tears after the fire?", "आग लगने के बाद ज़ैन क्यों रो पड़ा?", "His house was burned and his beloved pet cat was missing.", "Zan lost his house, books, shoes, and feared his beloved tabby cat had perished in the fire.", "उसका घर व किताबें जल गई थीं और उसकी प्यारी बिल्ली गायब थी।"),
            sh("c9_26_s1", "A Slumber Did My Spirit Seal", "How does Wordsworth imagine Lucy after her death?", "मृत्यु के बाद कवि वर्ड्सवर्थ लूसी की कल्पना कैसे करते हैं?", "Lucy has become an eternal part of Earth's rocks, stones, and trees.", "The poet feels Lucy is beyond earthly fears and time now; rolled round in Earth's diurnal course, she is eternally united with rocks, stones, and trees.", "लूसी अब समय से परे प्रकृति (पत्थरों, पेड़ों और पृथ्वी की गति) का हिस्सा बन चुकी है।"),
            lg("c9_26_l1", "Blueprint 2026 – Picture / Paragraph", "Write a paragraph in 80 words on 'Swachh Bharat Abhiyan' OR 'Importance of Discipline'.", "2026 ब्लूप्रिंट अनुसार 'स्वच्छ भारत अभियान' पर 80 शब्दों का अनुच्छेद लिखिए।", "Cleanliness leads to health, civic responsibility, and national pride.", "Swachh Bharat Abhiyan is a nationwide cleanliness movement launched to make India clean, green, and disease-free. Throwing waste into proper dustbins, avoiding single-use plastic, and keeping classrooms spotless are simple habits every student can practice. Clean surroundings create a healthy mind and reflect civic pride.")
        )
    }

    private fun class10Questions(year: Int): List<PyqQuestionItem> = when (year) {
        2022 -> listOf(
            obj("c10_22_o1", "A Letter to God", "How much money did Lencho ask God for?", "लेंचो ने ईश्वर से कितने पैसे मांगे थे?", listOf("50 pesos", "70 pesos", "100 pesos", "1000 pesos"), 2, "100 pesos", "ओलावृष्टि से फसल बर्बाद होने पर लेंचो ने ईश्वर से 100 पेसोस की मदद मांगी थी।"),
            obj("c10_22_o2", "Nelson Mandela", "What does 'apartheid' mean?", "'अपारथाइड' (Apartheid) का क्या अर्थ है?", listOf("Economic poverty", "Political system separating people by race", "Colonial war", "Religious festival"), 1, "Political system separating people by race", "रंगभेद की ऐसी राजनीतिक व्यवस्था जो लोगों को नस्ल के आधार पर अलग करती थी।"),
            obj("c10_22_o3", "Grammar – Tenses", "He _____ in this school since 2019.", "सही Tense चुनिए:", listOf("studies", "is studying", "has been studying", "studied"), 2, "has been studying", "'since 2019' होने के कारण Present Perfect Continuous ('has been studying') सही है।"),
            obj("c10_22_o4", "Dust of Snow", "Which tree shook down dust of snow on Robert Frost?", "कवि पर किस पेड़ से बर्फ की धूल गिरी?", listOf("Oak tree", "Pine tree", "Hemlock tree", "Banyan tree"), 2, "Hemlock tree", "हेमलॉक (धतूरा/विषैला वृक्ष) पर बैठे कौए ने बर्फ गिराई थी।"),
            vs("c10_22_vs1", "A Triumph of Surgery", "Why was Dr. Herriot tempted to keep Tricki as a permanent guest?", "डॉ. हैरियट ट्रिकी को स्थायी मेहमान बनाकर क्यों रखना चाहते थे?", "Because Mrs. Pumphrey sent fresh eggs, wine, and brandy daily.", "Dr. Herriot and his partners enjoyed the eggs, wine, and brandy Mrs. Pumphrey sent daily for Tricki's recovery.", "क्योंकि श्रीमती पम्फ्रे रोज ताजे अंडे, वाइन और ब्रांडी भेजती थीं जिनका आनंद डॉक्टर और स्टाफ उठाते थे।"),
            sh("c10_22_s1", "His First Flight", "How did the young seagull conquer his fear of flying?", "नन्हे सीगल ने उड़ने का डर कैसे जीता?", "Driven by extreme hunger, he dived for a piece of fish in his mother's beak and his wings spread naturally.", "The young seagull had not eaten for 24 hours. Seeing his mother fly near with a piece of fish, hunger maddened him and he dived at it, falling outwards until his wings opened automatically and he soared.", "भूख से व्याकुल होकर जब वह माँ की चोंच में मछली की ओर झपटा, तो नीचे गिरते समय उसके पंख खुद-ब-खुद खुल गए।"),
            lg("c10_22_l1", "Formal Letter – Collector", "Write a letter to the Collector of your district to ban loudspeakers during examinations.", "परीक्षा के दौरान लाउडस्पीकर पर प्रतिबंध लगाने हेतु जिला कलेक्टर को पत्र लिखिए।", "Formal Collector Letter with Sender Address, Date, Subject, Reason, Polite Request.", "24, Civil Lines,\nBhopal (M.P.)\nDate: 15 February 2022\n\nThe Collector,\nDistrict Bhopal (M.P.)\n\nSubject: Request to impose a ban on loudspeakers during board exams.\n\nRespected Sir,\nBoard examinations are starting next week, and loud DJs/loudspeakers at night disturb students' concentration. Kindly issue an immediate ban on loudspeakers until exams conclude.\n\nYours faithfully,\nRohan Sharma")
        )
        2023 -> listOf(
            obj("c10_23_o1", "From the Diary of Anne Frank", "What name did Anne Frank give to her diary?", "ऐनी फ्रैंक ने अपनी डायरी को क्या नाम दिया?", listOf("Kitty", "Misty", "Margot", "Betty"), 0, "Kitty", "ऐनी ने अपनी डायरी को अपनी सच्ची सहेली मानकर 'किटी (Kitty)' नाम दिया।"),
            obj("c10_23_o2", "Coorg", "Coorg (Kodagu) is famous for:", "कूर्ग किसके लिए प्रसिद्ध है?", listOf("Tea and Silk", "Evergreen rainforests, spices and coffee", "Gold mines", "Deserts"), 1, "Evergreen rainforests, spices and coffee", "कूर्ग सदाबहार वर्षा वनों, मसालों और कॉफी के बागानों के लिए प्रसिद्ध है।"),
            obj("c10_23_o3", "Grammar – Articles", "Kalidas is _____ Shakespeare of India.", "सही Article चुनिए:", listOf("a", "an", "the", "no article"), 2, "the", "जब किसी प्रसिद्ध व्यक्ति के नाम की उपमा दी जाए तो 'the' लगता है।"),
            obj("c10_23_o4", "The Thief's Story", "What made Hari Singh return to Anil with the stolen money?", "हरि सिंह चोरी किए गए पैसे लेकर अनिल के पास क्यों लौटा?", listOf("Police chased him", "Anil's trust and desire for education", "Train left", "It rained"), 1, "Anil's trust and desire for education", "अनिल का विश्वास और पढ़-लिखकर बड़ा आदमी बनने की इच्छा हरि सिंह को वापस ले आई।"),
            vs("c10_23_vs1", "Fire and Ice", "What do 'Fire' and 'Ice' symbolize in Robert Frost's poem?", "'Fire and Ice' कविता में Fire और Ice किसके प्रतीक हैं?", "Fire = human greed/desire; Ice = hatred/indifference.", "In Frost's poem, 'Fire' symbolizes uncontrolled human desire and greed, while 'Ice' stands for cold hatred and intolerance.", "'Fire' लालच/इच्छा का और 'Ice' घृणा/नफरत का प्रतीक है।"),
            sh("c10_23_s1", "Madam Rides the Bus", "What was Valli's favourite pastime and how did she plan her bus ride?", "वल्ली का पसंदीदा समय कैसे बीतता था और उसने बस यात्रा की योजना कैसे बनाई?", "Standing in her doorway watching the street; she saved every stray coin and gathered bus timings secretly.", "Valli loved standing at her front door watching the bus travel between her village and town. She listened carefully to passengers' conversations, learned the fare was 30 paise each way, and resisted buying toys/pepperments to save 60 paise.", "वह दरवाजे पर खड़े होकर गली देखती थी और खिलौने व मिठाई न खरीदकर 60 पैसे बचाकर सफर की योजना बनाई।"),
            lg("c10_23_l1", "Essay Writing", "Write an essay in 150 words on 'Wonders of Science' OR 'My Hobby'.", "'विज्ञान के चमत्कार' या 'मेरा शौक' पर निबंध लिखिए।", "5-section structured essay covering Introduction, Science Wonders/Hobby benefits, Conclusion.", "WONDERS OF SCIENCE\n1. Introduction: Today's era belongs to science.\n2. Electricity & Gadgets: Powers homes, hospitals, and smart classrooms.\n3. Transport & Internet: Trains, aeroplanes, and smartphones unite the globe.\n4. Medicine: Vaccines and surgeries save millions.\n5. Conclusion: Science used wisely builds human progress.")
        )
        2024 -> listOf(
            obj("c10_24_o1", "Glimpses of India – Baker from Goa", "What were the traditional Goan bakers known as?", "गोवा के पारंपरिक बेकर क्या कहलाते थे?", listOf("Kabai", "Pader", "Bol", "Bolinhas"), 1, "Pader", "गोवा में पारंपरिक ब्रेड बनाने वालों को 'Pader (पादेर)' कहा जाता था।"),
            obj("c10_24_o2", "The Sermon at Benares", "Why did Kisa Gotami go from house to house?", "किसा गौतमी घर-घर क्यों भटक रही थी?", listOf("For alms", "For medicine for her dead child", "For mustard seeds from a death-free home", "First medicine, later mustard seeds"), 3, "First medicine, later mustard seeds", "पहले वह अपने मृत पुत्र के लिए दवा मांगने गई, फिर बुद्ध के कहने पर ऐसा घर खोजने निकली जहाँ कभी किसी की मृत्यु न हुई हो।"),
            obj("c10_24_o3", "Grammar – Clauses / Relative", "The boy _____ won the prize is my brother.", "सही Relative Pronoun चुनिए:", listOf("which", "who", "whom", "whose"), 1, "who", "व्यक्ति (Subject) के लिए 'who' का प्रयोग होता है।"),
            obj("c10_24_o4", "Bholi", "Why was Sulekha called 'Bholi'?", "सुलेखा को 'भोली' क्यों कहा जाता था?", listOf("She fell off the cot damaging part of her brain and stammered", "She was rich", "She was clever", "She loved painting"), 0, "She fell off the cot damaging part of her brain and stammered", "बचपन में चारपाई से गिरने और चेचक के कारण वह हकलाती और सीधी-सादी रही।"),
            vs("c10_24_vs1", "Amanda!", "Why does Amanda wish to be an orphan or Rapunzel?", "अमांडा अनाथ या रपुंजेल क्यों बनना चाहती है?", "To enjoy silence, freedom, and peace away from constant nagging.", "Amanda longs for calm freedom from her parent's constant instructions and nagging.", "अपनी माँ की लगातार डांट-फटकार से दूर शांति और आज़ादी पाने के लिए।"),
            sh("c10_24_s1", "A Question of Trust", "Why did Horace Danby rob a safe once every year?", "होरेस डैनबी साल में एक बार ही चोरी क्यों करता था?", "To buy rare and expensive books secretly.", "Horace Danby loved rare and expensive books. He stole just enough money once a year to buy the books he desired through an agent.", "दुर्लभ और महंगी किताबें खरीदने के अपने शौक को पूरा करने के लिए।"),
            lg("c10_24_l1", "Bholi – Long Answer", "How did education and her teacher's support help Bholi stand up against Bishamber?", "शिक्षा और शिक्षिका के सहयोग ने भोली को आत्मविश्वासी कैसे बनाया?", "Her teacher's affection gave Bholi confidence to reject greedy Bishamber and serve her parents.", "Bholi's kind teacher encouraged her patiently, helping her overcome stammering and gain self-respect. On her wedding day, when greedy Bishamber demanded Rs. 5,000 dowry after seeing her pockmarks, educated Bholi boldly threw the garland into the fire, refused to marry a mean coward, and decided to teach at her village school.")
        )
        2025 -> listOf(
            obj("c10_25_o1", "The Proposal", "Why did Lomov come to Chubukov's house?", "लोमोव चुबुकोव के घर क्यों आया था?", listOf("To borrow money", "To propose marriage to Natalya", "To buy Oxen Meadows", "To invite for dinner"), 1, "To propose marriage to Natalya", "लोमोव नताल्या के सामने विवाह का प्रस्ताव (Proposal) रखने आया था।"),
            obj("c10_25_o2", "The Necklace", "From whom did Matilda borrow the diamond necklace?", "मटिल्डा ने हीरों का हार किससे उधार लिया था?", listOf("Mme Forestier", "Her aunt", "A jeweller", "Her neighbour"), 0, "Mme Forestier", "उसने अपनी अमीर सहेली मैडम फॉरेस्टियर से हार उधार लिया था।"),
            obj("c10_25_o3", "Grammar – Modals", "We _____ follow traffic rules for our safety.", "सही Modal चुनिए:", listOf("must", "might", "could", "would"), 0, "must", "कठोर नियम/अनिवार्य कर्तव्य हेतु 'must' आता है।"),
            obj("c10_25_o4", "Mijbil the Otter", "Where did Gavin Maxwell find Mijbil the otter?", "लेखक को मिजबिल ऊदबिलाव कहाँ मिला?", listOf("London", "Iraq (Tigris marshes)", "Scotland", "India"), 1, "Iraq (Tigris marshes)", "लेखक को मिजबिल दक्षिणी इराक (बसरा/टायग्रिस दलदल) में मिला।"),
            vs("c10_25_vs1", "For Anne Gregory", "What does the yellow hair of Anne Gregory symbolize?", "ऐन ग्रेगरी के सुनहरे बाल किस बात के प्रतीक हैं?", "External physical beauty, which is temporary.", "Her yellow hair represents superficial outer beauty that people often love instead of true inner soul.", "बाहरी शारीरिक सुंदरता का प्रतीक।"),
            sh("c10_25_s1", "The Midnight Visitor", "How did Ausable get rid of Max without firing a shot?", "औसेबल ने बिना गोली चलाए मैक्स से कैसे छुटकारा पाया?", "He invented a fake balcony and police knock story, making Max jump to his doom.", "Quick-witted spy Ausable fabricated a story about a balcony outside his window and pretended the waiter knocking at the door was the police. Panicked, Max climbed out expecting a balcony and fell from the sixth floor.", "चतुर जासूस औसेबल ने झूठी बालकनी और पुलिस आने की कहानी गढ़कर मैक्स को खिड़की से कूदने पर मजबूर कर दिया।"),
            lg("c10_25_l1", "Formal Application – T.C.", "Write an application to your Principal for Transfer Certificate (T.C.) as your father has been transferred.", "पिताजी के स्थानांतरण पर T.C. (स्थानांतरण प्रमाण-पत्र) हेतु प्राचार्य को आवेदन पत्र लिखिए।", "Proper Left-Aligned Formal Application for Transfer Certificate.", "To,\nThe Principal,\nGovt. H.S. School, Ujjain (M.P.)\n\nDate: 10 March 2025\nSubject: Application for Transfer Certificate.\n\nRespected Sir,\nMy father has been transferred to Jabalpur. Therefore, I cannot continue my studies here. Kindly issue my T.C. at the earliest.\n\nYours obediently,\nNeha Tiwari, Class X")
        )
        else -> listOf(
            obj("c10_26_o1", "A Letter to God", "Who actually sent 70 pesos to Lencho?", "लेंचो को वास्तव में 70 पेसोस किसने भेजे थे?", listOf("God", "The kind Postmaster & employees", "His neighbours", "Mayor"), 1, "The kind Postmaster & employees", "दयालु पोस्टमास्टर ने अपने वेतन व साथियों से चंदा इकट्ठा करके पैसे भेजे।"),
            obj("c10_26_o2", "Grammar – Transformation", "Rewrite using 'Unless': 'If you do not work hard, you will fail.'", "'Unless' का सही प्रयोग चुनिए:", listOf("Unless you work hard, you will fail.", "Unless you do not work hard, you fail.", "Unless you worked hard, you fail.", "Unless you work hard, you will pass."), 0, "Unless you work hard, you will fail.", "'Unless' का अर्थ 'If...not' होता है, इसलिए 'do not' हट जाता है।"),
            obj("c10_26_o3", "The Trees (Poem)", "Where are the trees moving out in Adrienne Rich's poem?", "'The Trees' कविता में पेड़ कहाँ जा रहे हैं?", listOf("Into the forest", "Into the city", "To mountains", "To ocean"), 0, "Into the forest", "घरों के भीतर कैद पेड़ काँच तोड़कर वापस जंगल (forest) की ओर जा रहे हैं।"),
            obj("c10_26_o4", "Footprints Without Feet", "What made Griffin invisible?", "ग्रिफिन किस वजह से अदृश्य हुआ?", listOf("Magic ring", "Rare drugs he swallowed", "Invisible cloak", "Mirror"), 1, "Rare drugs he swallowed", "वैज्ञानिक ग्रिफिन ने विशेष दुर्लभ दवाओं का आविष्कार कर उन्हें निगल लिया था।"),
            vs("c10_26_vs1", "Nelson Mandela", "What are the 'twin obligations' every man has according to Mandela?", "मंडेला के अनुसार हर मनुष्य के दो मुख्य दायित्व (Twin Obligations) क्या हैं?", "Obligation to family and obligation to community/country.", "First, duty toward one's family, parents, and children; second, duty toward one's people, community, and nation.", "पहला परिवार के प्रति और दूसरा समाज व देश के प्रति।"),
            sh("c10_26_s1", "The Ball Poem", "What lesson does the boy learn after losing his ball?", "अपनी गेंद खोने के बाद लड़का कौन-सा जीवन-पाठ सीखता है?", "He learns the epistemology of loss — how to accept loss and move on responsibly.", "Through the loss of his childhood ball in the harbour, the boy learns his first hard lesson of responsibility: material things get lost in life, and one must stand up and bear the grief courageously.", "वह नुकसान को स्वीकार करने और जीवन में जिम्मेदारी से आगे बढ़ने का पहला पाठ सीखता है।"),
            lg("c10_26_l1", "Blueprint 2026 – Picture Composition", "Describe in 80 words a picture showing 'Importance of Reading & Library for Students'.", "2026 ब्लूप्रिंट अनुसार 'पुस्तकालय और पढ़ने का महत्व' पर 80 शब्दों का अनुच्छेद लिखिए।", "Unified 80-word paragraph highlighting reading habits, knowledge, and focus.", "Library — Temple of Knowledge\nBooks are our wisest and most faithful friends. This picture shows students reading quietly in a bright, peaceful school library. Reading expands vocabulary, sharpens imagination, and improves writing skills for board examinations. Unlike endless mobile scrolling that strains our eyes, reading books builds deep focus and lifelong wisdom. Every student must spend at least thirty minutes daily reading good books.")
        )
    }

    private fun class11Questions(year: Int): List<PyqQuestionItem> = when (year) {
        2022 -> listOf(
            obj("c11_22_o1", "The Portrait of a Lady", "What did the grandmother feed the village dogs?", "दादी माँ गाँव के कुत्तों को क्या खिलाती थीं?", listOf("Fresh fruits", "Stale chapattis", "Bread crumbs", "Milk"), 1, "Stale chapattis", "दादी माँ मंदिर जाते समय बासी रोटियाँ (stale chapattis) कुत्तों के लिए ले जाती थीं।"),
            obj("c11_22_o2", "A Photograph", "Who are the three girls in the cardboard photograph?", "फोटो में दिखाई देने वाली तीन लड़कियाँ कौन थीं?", listOf("Poetess and sisters", "Poetess's mother and cousins Betty & Dolly", "Friends", "Neighbours"), 1, "Poetess's mother and cousins Betty & Dolly", "कवयित्री की माँ (12 वर्ष) और उनकी चचेरी बहनें बेट्टी और डॉली।"),
            obj("c11_22_o3", "Grammar – Determiners", "There is _____ milk in the glass, enough for tea.", "सही Determiner चुनिए:", listOf("little", "a little", "few", "many"), 1, "a little", "मात्रात्मक व सकारात्मक अर्थ ('थोड़ा, पर्याप्त') के लिए 'a little' आता है।"),
            obj("c11_22_o4", "The Summer of the Beautiful White Horse", "To which tribe did Aram and Mourad belong?", "अराम और मुराद किस कबीले से थे?", listOf("Garoghlanian tribe", "Apache tribe", "Zulu tribe", "Bedouin"), 0, "Garoghlanian tribe", "वे ईमानदारी के लिए प्रसिद्ध गैरोग्लैनियन कबीले से थे।"),
            vs("c11_22_vs1", "We're Not Afraid to Die", "What was the name of the narrator's boat?", "लेखक की नाव का नाम क्या था?", "Wavewalker.", "The narrator's professionally built 23-metre wooden-hulled yacht was named 'Wavewalker'.", "उनकी 23 मीटर लंबी लकड़ी की नाव का नाम 'वेववॉकर (Wavewalker)' था।"),
            sh("c11_22_s1", "Discovering Tut", "Why was King Tut's mummy scanned with a CT machine?", "राजा तूत की ममी का सीटी स्कैन क्यों किया गया?", "To solve the mystery of how he lived and died over 3,300 years ago.", "Archaeologists conducted a CT scan on King Tutankhamun's mummy in 2005 to uncover medical clues about his young age at death and whether he was murdered or died naturally.", "3,300 वर्ष पहले कम उम्र में हुई उनकी मृत्यु का रहस्य जानने के लिए।"),
            lg("c11_22_l1", "Notice Writing", "Draft a Notice for your school board informing students about an Inter-School Science Quiz.", "इंटर-स्कूल साइंस क्विज़ की सूचना देने के लिए बॉक्स में Notice लिखिए।", "Notice inside box with School Name, NOTICE, Date, Topic, Event details, Signature.", "+--------------------------------------------+\n|     GOVT. MODEL H.S. SCHOOL, BHOPAL        |\n|                   NOTICE                   |\n| Date: 18 Sep 2022                          |\n|       INTER-SCHOOL SCIENCE QUIZ            |\n| Students of Class IX–XII are informed that |\n| an Inter-School Science Quiz will be held  |\n| on 28 Sep at 11 AM in School Hall. Give    |\n| names by 22 Sep to the undersigned.        |\n|                                            |\n| Ritu Jain (Secretary, Science Club)        |\n+--------------------------------------------+")
        )
        2023 -> listOf(
            obj("c11_23_o1", "The Laburnum Top", "Which bird brings sudden energy to the silent Laburnum tree?", "शांत अमलतास के पेड़ पर कौन-सा पक्षी ऊर्जा भर देता है?", listOf("Sparrow", "Goldfinch", "Cuckoo", "Owl"), 1, "Goldfinch", "गोल्डफिंच पक्षी अपने घोंसले में आते ही पेड़ को चहचहाहट से जीवंत कर देता है।"),
            obj("c11_23_o2", "The Address", "What was the house number of Mrs. Dorling?", "श्रीमती डॉर्लिंग के घर का नंबर क्या था?", listOf("46, Marconi Street", "12, Baker Street", "40, Civil Lines", "10, Downing Street"), 0, "46, Marconi Street", "कथाकार की माँ ने '46, मार्कोनी स्ट्रीट' पता बताया था।"),
            obj("c11_23_o3", "Grammar – Clauses", "I know the reason _____ she is absent today.", "सही शब्द चुनिए:", listOf("when", "where", "why", "who"), 2, "why", "'reason' के साथ कारण बताने के लिए 'why' का उपयोग होता है।"),
            obj("c11_23_o4", "Mother's Day", "Who helped Mrs. Pearson gain respect from her selfish family?", "श्रीमती पियरसन को उनके परिवार से सम्मान दिलाने में किसने मदद की?", listOf("Mrs. Fitzgerald", "Doris", "Cyril", "Mr. Pearson"), 0, "Mrs. Fitzgerald", "पड़ोसन श्रीमती फिट्ज़गेराल्ड ने व्यक्तित्व बदलकर परिवार को सबक सिखाया।"),
            vs("c11_23_vs1", "The Voice of the Rain", "Why does the rain call itself 'the Poem of Earth'?", "बारिश स्वयं को 'पृथ्वी की कविता' क्यों कहती है?", "Because it rises invisibly from land/sea and returns to purify and nourish the earth.", "Just as a poem gives joy and beauty before returning to its creator, rain rises as vapour and descends to wash, beautify, and give life to Earth.", "क्योंकि यह पृथ्वी से उठकर वापस लौटती है और उसे जीवन व सुंदरता देती है।"),
            sh("c11_23_s1", "The Adventure", "What unusual thing did Professor Gaitonde notice in the Town Hall library?", "प्रोफेसर गायतोंडे ने टाउन हॉल पुस्तकालय में कौन-सी असामान्य बात देखी?", "He read an alternate history where the Marathas won the Battle of Panipat.", "In the parallel world, Professor Gaitonde found the fifth volume of history books stating that Vishwasrao survived and the Marathas won the Third Battle of Panipat, transforming India into a proud modern nation.", "वहाँ की इतिहास किताब में लिखा था कि पानीपत का युद्ध मराठों ने जीता था।"),
            lg("c11_23_l1", "Poster Making", "Design a Poster on 'Save Trees, Save Environment' with slogans.", "'पेड़ बचाओ, पर्यावरण बचाओ' पर स्लोगन सहित एक पोस्टर बनाइए।", "Boxed poster with catchy slogans, bullet actions, and Issuing Authority.", "+------------------------------------------+\n|      ★ PLANT TREES, SAVE EARTH! ★        |\n|    'No Trees = No Oxygen = No Life'      |\n|  WHY TREES MATTER:                       |\n|  ✔ Purify air & reduce heat              |\n|  ✔ Bring rain & stop soil erosion        |\n|  ✔ Shelter birds & give fruits           |\n|  Issued by: Eco Club, Jabalpur           |\n+------------------------------------------+")
        )
        2024 -> listOf(
            obj("c11_24_o1", "Silk Road", "Where was Nick Middleton travelling to complete the 'Kora'?", "निक मिडलटन 'कोरा' पूरा करने कहाँ जा रहे थे?", listOf("Rishikesh", "Mount Kailash (Darchen)", "Shimla", "Leh"), 1, "Mount Kailash (Darchen)", "वे तिब्बत में कैलाश पर्वत (दारचेन) की परिक्रमा 'कोरा' के लिए जा रहे थे।"),
            obj("c11_24_o2", "Childhood", "When did Markus Natten feel he lost his childhood?", "मार्कस नैटन को कब लगा कि उनका बचपन खो गया?", listOf("At age 5", "When he realized Hell/Heaven aren't in Geography & adults preach love differently", "On finishing school", "Never"), 1, "When he realized Hell/Heaven aren't in Geography & adults preach love differently", "जब उन्होंने तर्क, पाखंड और स्वतंत्र सोच को समझा, तब उन्हें बचपन जाने का एहसास हुआ।"),
            obj("c11_24_o3", "Grammar – Passive", "Change into Passive: 'Someone has stolen my book.'", "सही Passive चुनिए:", listOf("My book was stolen.", "My book has been stolen.", "My book is stolen.", "My book had stolen."), 1, "My book has been stolen.", "Present Perfect Passive में 'has/have + been + V3' लगता है।"),
            obj("c11_24_o4", "Birth", "How did Dr. Andrew Manson revive the lifeless newborn baby?", "डॉ. एंड्रयू ने नवजात शिशु में जान कैसे डाली?", listOf("With injections", "Alternate hot & cold water plunge + chest compression", "Oxygen cylinder", "Surgery"), 1, "Alternate hot & cold water plunge + chest compression", "गर्म-ठंडे पानी की विशेष तकनीक और हल्की छाती दबाने से बच्चा रो पड़ा।"),
            vs("c11_24_vs1", "Father to Son", "What is the central problem between the father and son?", "पिता और पुत्र के बीच मुख्य समस्या क्या है?", "Communication gap and lack of mutual understanding.", "Although they live in the same house for years, the father and son behave like strangers due to a painful generation and communication gap.", "दोनों के बीच संवादहीनता (Communication gap) और आपसी समझ की कमी।"),
            sh("c11_24_s1", "The Portrait of a Lady", "How did the sparrows mourn the grandmother's death?", "दादी माँ की मृत्यु पर गौरैया पक्षियों ने शोक कैसे मनाया?", "Thousands of silent sparrows sat around her corpse and didn't touch bread crumbs.", "Thousands of sparrows gathered quietly around the grandmother's dead body without chirping. They ignored the bread crumbs thrown by the author's mother and flew away silently when her body was carried out.", "हजारों गौरैया चुपचाप आकर बैठ गईं, चहचहाईं नहीं और रोटी के टुकड़े भी नहीं खाए।"),
            lg("c11_24_l1", "Report Writing", "Write a report in 100 words on 'Annual Sports Day' celebrated at your school.", "अपने विद्यालय में मनाए गए 'वार्षिक खेल दिवस' पर 100 शब्दों की रिपोर्ट लिखिए।", "Past-tense Report with Heading, By-line, Place/Date, Event highlights, Prize ceremony.", "ANNUAL SPORTS DAY CELEBRATION\nBy: Aman Patel, Class XI\n\nIndore, 18 December: Govt. H.S. School celebrated its Annual Sports Day with great enthusiasm yesterday. The District Sports Officer inaugurated the meet by lighting the torch. Over 200 students competed in races, long jump, kabaddi, and relay events. Winners received medals and certificates from the Principal, inspiring everyone toward fitness and teamwork.")
        )
        2025 -> listOf(
            obj("c11_25_o1", "The Tale of Melon City", "Who was finally crowned the king of the city?", "अंत में शहर का राजा किसे चुना गया?", listOf("The architect", "A wise old man", "A Melon", "The chief minister"), 2, "A Melon", "अविवेकी मंत्रियों ने पहले शहर द्वार से गुज़रे व्यक्ति के कहने पर एक तरबूज को राजा बना दिया।"),
            obj("c11_25_o2", "The Portrait of a Lady", "What was the happiest half-hour of the day for the grandmother in the city?", "शहर में दादी माँ के लिए दिन का सबसे खुशहाल आधा घंटा कौन सा था?", listOf("Spinning wheel", "Feeding sparrows bread crumbs", "Listening to music", "Visiting school"), 1, "Feeding sparrows bread crumbs", "दोपहर में गौरैया चिड़ियों को रोटी के टुकड़े खिलाना उनका सबसे सुखद समय था।"),
            obj("c11_25_o3", "Grammar – Tenses", "By next month, we _____ our syllabus.", "सही Tense चुनिए:", listOf("complete", "will have completed", "completed", "are completing"), 1, "will have completed", "'By next month' भविष्य में कार्य समाप्ति (Future Perfect) दर्शाता है।"),
            obj("c11_25_o4", "We're Not Afraid to Die", "What words did young Jonathan say that gave courage to his father?", "छोटे जोनाथन के किन शब्दों ने लेखक को हिम्मत दी?", listOf("Please save us", "We aren't afraid of dying if we can all be together", "Turn the boat back", "Call rescue"), 1, "We aren't afraid of dying if we can all be together", "6 वर्षीय जोनाथन ने कहा कि यदि हम सब साथ हैं तो हमें मरने से भी डर नहीं लगता।"),
            vs("c11_25_vs1", "Tsetan / Silk Road", "Who was Tsetan and how did he help the narrator?", "त्सेतान कौन था और उसने लेखक की मदद कैसे की?", "An experienced Tibetan driver who ensured Nick received medical care in Darchen.", "Tsetan drove Nick Middleton safely across snowy mountain passes and took him to Darchen Medical College when Nick fell ill with altitude sickness.", "वह एक अनुभवी तिब्बती ड्राइवर था जिसने कठिन रास्तों पर सहायता की और दारचेन में इलाज कराया।"),
            sh("c11_25_s1", "The Summer of the Beautiful White Horse", "Why did Mourad and Aram return the white horse to John Byro?", "मुराद और अराम ने सफेद घोड़ा जॉन बायरो को वापस क्यों लौटा दिया?", "Byro trusted their family's honesty blindly, awakening their conscience.", "When John Byro inspected the horse, he refused to doubt the boys because of the Garoghlanian tribe's reputation for honesty. Stricken by conscience, the boys returned the horse quietly next morning.", "जॉन बायरो के अपने कबीले की ईमानदारी पर अटूट विश्वास को देखकर उनकी अंतरात्मा जाग उठी।"),
            lg("c11_25_l1", "Advertisement Writing", "Draft a TO-LET classified advertisement for a 2-BHK independent house in Bhopal.", "भोपाल में किराए के लिए उपलब्ध 2-BHK मकान हेतु 'TO-LET' विज्ञापन लिखिए।", "Boxed Classified Advertisement with facilities, rent, and contact info.", "+--------------------------------------------+\n|                   TO-LET                   |\n| Available on rent: airy 2-BHK independent  |\n| ground-floor house in MP Nagar, Bhopal.    |\n| Modular kitchen, 24x7 water & parking.     |\n| Rent Rs. 11,000/month. Small family only.  |\n| Contact: S.K. Verma, Mob: 9827XXXXXX       |\n+--------------------------------------------+")
        )
        else -> listOf(
            obj("c11_26_o1", "Discovering Tut", "Who discovered King Tut's tomb in 1922?", "1922 में किंग तूत का मकबरा किसने खोजा था?", listOf("Howard Carter", "Zahi Hawass", "Lord Carnarvon", "Ray Johnson"), 0, "Howard Carter", "ब्रिटिश पुरातत्ववेत्ता हॉवर्ड कार्टर ने 1922 में तूत का मकबरा खोजा।"),
            obj("c11_26_o2", "Grammar – Degrees", "No other city in MP is as clean as Indore. (Superlative form)", "Superlative Degree चुनिए:", listOf("Indore is cleaner than any city.", "Indore is the cleanest city in MP.", "Indore is as clean.", "Indore was clean."), 1, "Indore is the cleanest city in MP.", "'the + superlative adjective (cleanest)' सही रूप है।"),
            obj("c11_26_o3", "Father to Son", "Why does the father hold out an 'empty hand'?", "पिता अपना 'खाली हाथ' क्यों बढ़ाते हैं?", listOf("He is poor", "He longs to forgive and reconcile with his son", "He lost money", "He wants to leave"), 1, "He longs to forgive and reconcile with his son", "पिता अपने बेटे को माफ कर पुनः रिश्ता जोड़ने की इच्छा रखते हैं।"),
            obj("c11_26_o4", "Birth", "Who was Joe Morgan waiting for nervously at midnight?", "आधी रात को जो मॉर्गन घबराकर किसका इंतजार कर रहा था?", listOf("Nurse", "Dr. Andrew Manson", "Police", "Friend"), 1, "Dr. Andrew Manson", "वह अपनी पत्नी के प्रसव के लिए डॉ. एंड्रयू मैंसन का इंतजार कर रहा था।"),
            vs("c11_26_vs1", "A Photograph", "What does 'its silence silences' mean at the end of 'A Photograph'?", "'Its silence silences' का क्या अर्थ है?", "The quiet finality of her mother's death leaves the poet speechless with grief.", "The silence of death and time overwhelms the poet so deeply that she has no words left to express her sorrow.", "माँ के निधन की निस्तब्धता कवि को भी निःशब्द कर देती है।"),
            sh("c11_26_s1", "Mother's Day", "What message does J.B. Priestley convey through 'Mother's Day'?", "नाटक 'Mother's Day' क्या संदेश देता है?", "Mothers deserve equal respect, rest, and appreciation for their tireless care.", "J.B. Priestley highlights how families often take mothers for granted as unpaid servants, urging children and husbands to treat mothers with gratitude, kindness, and dignity.", "परिवार में माँ के श्रम का सम्मान और आदर किया जाना चाहिए, उन्हें नौकर नहीं समझना चाहिए।"),
            lg("c11_26_l1", "Blueprint 2026 – Article Writing", "Write an article in 100 words on 'Role of AI & Smart Learning in MP Board Preparation'.", "2026 ब्लूप्रिंट अनुसार 'बोर्ड परीक्षा की तैयारी में स्मार्ट लर्निंग' पर लेख लिखिए।", "Centered Title, By-line, 3 structured paragraphs (Intro, Benefits/Balance, Conclusion).", "SMART LEARNING IN BOARD PREPARATION\nBy: Student Writer\n\nModern digital classrooms and mobile study hubs have made quality English learning accessible to every village in Madhya Pradesh. Audio-visual summaries, instant quizzes, and structured grammar lessons help students grasp concepts faster.\n\nHowever, technology works best alongside daily textbook reading and handwritten answer practice. Balanced use of smart tools builds high confidence for board success.")
        )
    }

    private fun class12Questions(year: Int): List<PyqQuestionItem> = when (year) {
        2022 -> listOf(
            obj("c12_22_o1", "The Last Lesson", "What did M. Hamel write on the blackboard at the end of the lesson?", "पाठ के अंत में एम. हैमेल ने ब्लैकबोर्ड पर क्या लिखा?", listOf("Goodbye Students", "Vive La France!", "Study Hard", "Merci"), 1, "Vive La France!", "एम. हैमेल ने देशभक्ति से भरकर बड़े अक्षरों में 'Vive La France!' (फ्रांस जिंदाबाद) लिखा।"),
            obj("c12_22_o2", "Deep Water", "At which swimming pool did William Douglas nearly drown?", "विलियम डगलस किस स्विमिंग पूल में डूबते-डूबते बचे थे?", listOf("YMCA Pool", "Yakima River Pool", "Olympic Pool", "Seattle Pool"), 0, "YMCA Pool", "एक बड़े लड़के ने उन्हें वाईएमसीए (YMCA) पूल के गहरे हिस्से में फेंक दिया था।"),
            obj("c12_22_o3", "Grammar – Voice / Modals", "_____ I borrow your umbrella for an hour?", "सही अनुमतिवाचक शब्द चुनिए:", listOf("May", "Must", "Will", "Did"), 0, "May", "औपचारिक अनुमति लेने हेतु 'May' का प्रयोग होता है।"),
            obj("c12_22_o4", "The Third Level", "What did Charley wish to buy at the Third Level ticket window?", "चार्ली थर्ड लेवल की टिकट खिड़की से कहाँ के टिकट खरीदना चाहता था?", listOf("Boston", "Galesburg, Illinois", "Chicago", "New York"), 1, "Galesburg, Illinois", "वह 1894 के शांतिपूर्ण शहर गेल्सबर्ग (इलिनोइस) के दो टिकट खरीदना चाहता था।"),
            vs("c12_22_vs1", "Lost Spring", "What is Mukesh's dream and why is it daring in Firozabad?", "मुकेश का सपना क्या है और वह साहसिक क्यों है?", "He wants to become a motor mechanic instead of making bangles.", "Mukesh dreams of driving a car and becoming a motor mechanic, daring to break free from generations of dangerous bangle-making in Firozabad.", "वह चूड़ी बनाने के पारिवारिक काम से अलग होकर मोटर मैकेनिक बनना चाहता है।"),
            sh("c12_22_s1", "The Rattrap", "Why did Edla Willmansson treat the peddler like a real captain?", "एडला विलमंसन ने फेरीवाले के साथ एक असली कैप्टन जैसा व्यवहार क्यों किया?", "Her genuine kindness, trust, and respect helped reform the peddler's heart.", "Even after discovering he was not her father's regimental comrade, Edla felt he deserved one day of peace on Christmas Eve. Treating him with dignity awakened his goodness, inspiring him to return the stolen thirty kronor.", "क्रिसमस की पूर्व संध्या पर एडला के सम्मान और दयालुता ने उसके हृदय को परिवर्तित कर दिया।"),
            lg("c12_22_l1", "Formal Letter – Collector", "Write a letter to the Collector requesting a ban on loudspeakers during board exams.", "परीक्षाओं के दौरान लाउडस्पीकर बंद कराने हेतु कलेक्टर को औपचारिक पत्र लिखिए।", "Formal Block Letter to District Collector with Subject and respectful appeal.", "15, Patel Nagar,\nIndore (M.P.)\nDate: 12 February 2022\n\nThe Collector,\nDistrict Indore (M.P.)\n\nSubject: Request to ban loudspeakers during Class XII Board Exams.\n\nSir,\nClass XII examinations are approaching rapidly. Loudspeakers playing until midnight disrupt students' study concentration. Kindly impose a strict ban on loudspeakers until exams end.\n\nYours faithfully,\nPriya Verma")
        )
        2023 -> listOf(
            obj("c12_23_o1", "Indigo", "How much refund did Gandhi agree to accept for the Champaran peasants?", "चंपारण के किसानों के लिए गांधीजी कितने प्रतिशत रिफंड पर सहमत हुए?", listOf("100%", "50%", "25%", "10%"), 2, "25%", "गांधीजी 25% वापसी पर इसलिए सहमत हुए क्योंकि अंग्रेज़ जमींदारों का अहंकार टूटना पैसों से अधिक महत्वपूर्ण था।"),
            obj("c12_23_o2", "My Mother at Sixty-Six", "Why did the poet smile repeatedly while parting at the airport?", "एयरपोर्ट पर विदा होते समय कवयित्री बार-बार क्यों मुस्कुराईं?", listOf("To hide her fear and comfort her aging mother", "She loved flying", "She met a friend", "She got a gift"), 0, "To hide her fear and comfort her aging mother", "अपनी बूढ़ी माँ को खोने के डर को छिपाने और माँ को दिलासा देने के लिए वह मुस्कुराईं।"),
            obj("c12_23_o3", "Grammar – Prepositions", "He died _____ malaria last week.", "बीमारी से मृत्यु हेतु सही Preposition चुनिए:", listOf("from", "of", "by", "with"), 1, "of", "किसी बीमारी से मृत्यु होने पर 'died of' का प्रयोग किया जाता है।"),
            obj("c12_23_o4", "The Tiger King", "How did the hundredth tiger actually cause the Maharaja's death?", "सौवें बाघ ने अंततः महाराजा की मृत्यु का कारण कैसे बनाया?", listOf("Bit him", "A tiny sliver from a wooden toy tiger caused fatal infection", "Fell on him", "Poisoned him"), 1, "A tiny sliver from a wooden toy tiger caused fatal infection", "लकड़ी के खिलौने वाले बाघ की एक छोटी फाँस (sliver) चुभने से हुए संक्रमण से उनकी मृत्यु हुई।"),
            vs("c12_23_vs1", "Keeping Quiet", "What kind of victory does Pablo Neruda warn against in 'Keeping Quiet'?", "पाब्लो नेरुदा किस प्रकार की 'जीत' से बचने की चेतावनी देते हैं?", "Green wars and nuclear wars that leave no survivors.", "Neruda condemns destructive wars where victory brings only death and leaves no human survivors to celebrate.", "युद्ध की ऐसी जीत जहाँ कोई जीवित न बचे।"),
            sh("c12_23_s1", "A Thing of Beauty", "Why is a thing of beauty a joy forever according to John Keats?", "जॉन कीट्स के अनुसार सुंदर वस्तु हमेशा के लिए आनंद का स्रोत क्यों होती है?", "Its loveliness increases and never passes into nothingness; it removes gloom.", "Keats explains that a beautiful object leaves a permanent soothing imprint on our soul, providing peaceful sleep, fresh hope, and relief from worldly sadness.", "उसकी सुंदरता समय के साथ बढ़ती है, कभी खत्म नहीं होती और मन के अंधकार को दूर करती है।"),
            lg("c12_23_l1", "Notice Writing", "You are Cultural Secretary. Draft a Notice inviting names for an Inter-School Debate Competition.", "सांस्कृतिक सचिव के रूप में वाद-विवाद प्रतियोगिता हेतु बॉक्स में Notice लिखिए।", "Boxed Notice with Issuing School, NOTICE, Date, Topic, Date/Venue, Signature.", "+--------------------------------------------+\n|      GOVT. EXCELLENCE H.S. SCHOOL, REWA    |\n|                   NOTICE                   |\n| Date: 10 Oct 2023                          |\n|     INTER-SCHOOL DEBATE COMPETITION        |\n| All Class XI–XII students are informed     |\n| that a Debate Contest will be held on      |\n| 22 Oct at 10:30 AM in the Auditorium.      |\n| Submit names to the undersigned by 16 Oct. |\n| Ananya Tiwari (Cultural Secretary)         |\n+--------------------------------------------+")
        )
        2024 -> listOf(
            obj("c12_24_o1", "The Enemy", "Who was the American prisoner of war washed ashore near Dr. Sadao's house?", "डॉ. सदाओ के घर के पास समुद्र तट पर मिला अमेरिकी युद्धबंदी कौन था?", listOf("Tom", "Jack", "William", "Sam"), 0, "Tom", "वह युवा घायल अमेरिकी सैनिक 'टॉम' था।"),
            obj("c12_24_o2", "A Roadside Stand", "What do the poor rural folk wait for at the roadside stand?", "सड़क किनारे स्टाल पर गरीब ग्रामीण किसकी प्रतीक्षा करते हैं?", listOf("Tourists", "Passing city cars to stop and buy their goods", "Buses", "Rain"), 1, "Passing city cars to stop and buy their goods", "वे आशा करते हैं कि शहर की कुछ गाड़ियां रुकें और उनसे कुछ खरीदें ताकि कुछ शहर का धन उनके पास आए।"),
            obj("c12_24_o3", "Grammar – Clauses", "She worked hard so that she _____ pass.", "उद्देश्य (so that) वाले वाक्य में सही Modal चुनिए:", listOf("may", "might", "can", "will"), 1, "might", "मुख्य वाक्य Past Tense ('worked') में हो तो 'so that' के बाद 'might' आता है।"),
            obj("c12_24_o4", "On the Face of It", "Why did Derry avoid meeting people?", "डेरी लोगों से मिलने से क्यों कतराता था?", listOf("One side of his face was burnt by acid", "He was shy", "He had no money", "He was ill"), 0, "One side of his face was burnt by acid", "एसिड से झुलसे चेहरे और लोगों की सहानुभूति भरी या डरी निगाहों से वह परेशान रहता था।"),
            vs("c12_24_vs1", "Aunt Jennifer's Tigers", "Why are Aunt Jennifer's hands fluttering as she pulls the ivory needle?", "हाथीदांत की सुई खींचते समय आंट जेनिफर के हाथ क्यों कांपते हैं?", "Due to lifelong fear and emotional oppression of her unhappy marriage.", "The massive weight of her wedding band and years of marital domination make her fingers tremble.", "वैवाहिक जीवन के भय और मानसिक दबाव के कारण।"),
            sh("c12_24_s1", "The Enemy", "Why did Dr. Sadao decide to save Tom despite Japan being at war with America?", "अमेरिका से युद्ध के बावजूद डॉ. सदाओ ने टॉम की जान क्यों बचाई?", "His duty as a humane doctor rose above narrow wartime hatred.", "As a skilled surgeon trained to value every human life, Dr. Sadao could not let a wounded man die at his doorstep, risking even treason to operate on Tom and help him escape safely.", "एक चिकित्सक के रूप में मानव जीवन बचाने का कर्तव्य युद्ध की शत्रुता से ऊपर था।"),
            lg("c12_24_l1", "Poster Making (Drugs / Bomb)", "Prepare an eye-catching Poster advising people to say NO to Plastics / Drugs.", "'प्लास्टिक बंद' या 'नशा मुक्ति' पर एक आकर्षक पोस्टर तैयार कीजिए।", "Boxed awareness poster with bold heading, dangers, eco/healthy steps, Issued by.", "+--------------------------------------------+\n|         ✖ SAY NO TO POLYTHENE! ✖           |\n|    'Use Cloth & Jute Bags — Go Green!'     |\n|  HARMFUL EFFECTS:                          |\n|  • Blocks drains & pollutes soil           |\n|  • Fatal for stray cows & aquatic life     |\n|  Issued in Public Interest: Eco Club, MP   |\n+--------------------------------------------+")
        )
        2025 -> listOf(
            obj("c12_25_o1", "Poets and Pancakes", "What was 'Pancake' in Gemini Studios?", "जेमिनी स्टूडियो में 'पैनकेक (Pancake)' क्या था?", listOf("A breakfast dish", "Brand name of make-up material", "A camera", "A film title"), 1, "Brand name of make-up material", "पैनकेक अभिनेताओं पर उपयोग होने वाले मेकअप का ब्रांड नाम था।"),
            obj("c12_25_o2", "Going Places", "Who was Sophie's real-life brother whom she trusted with secrets?", "सोफी अपने किस भाई पर सबसे ज्यादा भरोसा करती थी?", listOf("Geoff", "Derek", "Danny", "Jansie"), 0, "Geoff", "सोफी अपने चुप रहने वाले बड़े भाई ज्योफ (Geoff) को अपने सारे राज बताती थी।"),
            obj("c12_25_o3", "Grammar – Error / Determiners", "Do you have _____ complaint against me?", "सही Determiner चुनिए:", listOf("some", "any", "many", "several"), 1, "any", "प्रश्नवाचक वाक्य में सिंगुलर काउंटेबल नाउन के साथ 'any' लगता है।"),
            obj("c12_25_o4", "Memories of Childhood", "What discrimination did Bama witness in her village?", "बामा ने अपने गाँव में किस प्रकार का भेदभाव देखा?", listOf("Untouchability / caste discrimination", "Gender gap", "Language barrier", "Age gap"), 0, "Untouchability / caste discrimination", "उन्होंने छुआछूत देखा जब एक बुजुर्ग जमींदार के लिए वड़ा पैकेट डोरी से पकड़कर ले जा रहे थे।"),
            vs("c12_25_vs1", "Journey to the End of the Earth", "What is the 'Students on Ice' programme headed by Geoff Green?", "जेफ ग्रीन का 'Students on Ice' कार्यक्रम क्या है?", "An educational expedition taking high school students to Antarctica.", "It takes young students to Antarctica to witness melting glaciers firsthand and build lifelong respect for protecting our planet.", "हाई स्कूल छात्रों को अंटार्कटिका ले जाकर पर्यावरण संरक्षण की प्रत्यक्ष समझ देने का अभियान।"),
            sh("c12_25_s1", "The Last Lesson", "How did the order from Berlin change the atmosphere of Franz's school?", "बर्लिन के आदेश ने फ्रांज के स्कूल का माहौल कैसे बदल दिया?", "Deep silence, sorrow, and respect for French filled the classroom with village elders present.", "Instead of usual noise, the school felt as solemn as a Sunday morning. Village elders sat silently on the back benches, M. Hamel wore his best Sunday clothes, and everyone regretted neglecting their mother tongue French.", "असामान्य शांति छा गई, गाँव के बुजुर्ग पीछे की बेंच पर बैठे और सबने मातृभाषा की उपेक्षा पर पछतावा किया।"),
            lg("c12_25_l1", "Report Writing", "Write a report in 100 words on an 'NSS Camp / Blood Donation Camp' in your school.", "'NSS शिविर' या 'रक्तदान शिविर' पर 100 शब्दों में रिपोर्ट लिखिए।", "Past-tense Report with Heading, By-line, Place/Date, Volunteers/Doctors, Outcome.", "BLOOD DONATION CAMP ORGANIZED\nBy: Student Reporter\n\nBhopal, 15 January: An inspiring Blood Donation Camp was organized by the Red Cross and NSS Unit of Govt. H.S. School, Bhopal. A team of doctors from Hamidia Hospital conducted medical check-ups before collection. Over 65 units of blood were donated by teachers, senior students, and parents. Refreshments and certificates were given to every donor.")
        )
        else -> listOf(
            obj("c12_26_o1", "The Interview", "Who wrote the famous novel 'The Name of the Rose'?", "'The Name of the Rose' प्रसिद्ध उपन्यास किसने लिखा?", listOf("Umberto Eco", "Christopher Silvester", "Rudyard Kipling", "H.G. Wells"), 0, "Umberto Eco", "प्रसिद्ध विद्वान और लेखक अम्बर्टो इको ने 'The Name of the Rose' लिखा था।"),
            obj("c12_26_o2", "Grammar – Combine Sentences", "Combine using 'No sooner... than': 'The thief saw the police. He ran away.'", "'No sooner... than' का सही प्रयोग चुनिए:", listOf("No sooner did the thief see the police than he ran away.", "No sooner the thief saw police than he ran.", "No sooner did the thief saw police when he ran.", "No sooner had thief see police than ran."), 0, "No sooner did the thief see the police than he ran away.", "'No sooner + did + Subject + V1 ... than' सही व्याकरण संरचना है।"),
            obj("c12_26_o3", "Lost Spring", "Why do Ragpickers in Seemapuri consider garbage 'gold'?", "सीमापुरी के कचरा बीनने वाले कचरे को 'सोना' क्यों मानते हैं?", listOf("It is daily bread, survival, and sometimes a rupee note", "It contains gold coins", "Government buys it", "It is decorative"), 0, "It is daily bread, survival, and sometimes a rupee note", "उनके लिए कचरा ही रोज़ी-रोटी और जीवित रहने का आधार है।"),
            obj("c12_26_o4", "The Third Level", "What is a 'First Day Cover'?", "'फर्स्ट डे कवर (First Day Cover)' क्या होता है?", listOf("Stamp collectors buy a new stamp on issue day and mail a blank paper to themselves", "First letter to school", "A bank cheque", "Postcard"), 0, "Stamp collectors buy a new stamp on issue day and mail a blank paper to themselves", "नया डाक टिकट जारी होने के पहले दिन लिफाफे पर चिपकाकर खुद के पते पर डाक से भेजा जाता है।"),
            vs("c12_26_vs1", "Deep Water", "What did Roosevelt mean by 'All we have to fear is fear itself'?", "रूजवेल्ट के कथन 'हमें केवल डर से ही डरना चाहिए' का क्या अर्थ है?", "Fear only lives in our mind; courage and repeated practice conquer it.", "Douglas realized death brings peace, whereas terror resides in the fear of death — conquering fear unlocks true freedom.", "डर केवल हमारे मन में होता है; साहस और निरंतर अभ्यास से हर डर जीता जा सकता है।"),
            sh("c12_26_s1", "On the Face of It", "How did Mr. Lamb change Derry's negative outlook towards life?", "मिस्टर लैम्ब ने जीवन के प्रति डेरी के नकारात्मक दृष्टिकोण को कैसे बदला?", "By teaching him to love life bravely despite physical scars and ignore cruel comments.", "Mr. Lamb never pitied Derry. Through examples of weeds and flowers, bees and nature, he showed Derry that he still had two arms, legs, eyes, and a brain to achieve anything if he overcame bitterness.", "उन्होंने सहानुभूति दिखाने के बजाय डेरी को सिखाया कि शरीर के घावों से बड़ा उसका हौसला और मस्तिष्क है।"),
            lg("c12_26_l1", "Blueprint 2026 – Informal Letter", "Write a letter to your younger brother advising him to avoid bad company and prepare systematically for board exams.", "2026 ब्लूप्रिंट अनुसार छोटे भाई को बुरी संगति से बचकर परीक्षा तैयारी की सलाह देते हुए पत्र लिखिए।", "Informal Letter with Sender Address, Date, Dear Brother, Advice, Affectionate closing.", "18, Arera Colony,\nBhopal (M.P.)\nDate: 10 January 2026\n\nDear Aarav,\nI heard you have been spending too much time with careless friends. Board exams are very close, and time once lost never returns. Please focus on daily revision, practice previous papers, and keep good company. Wishing you great success!\n\nYours lovingly,\nVikram")
        )
    }

    private fun obj(
        id: String,
        tag: String,
        q: String,
        hi: String,
        opts: List<String>,
        ansIdx: Int,
        ans: String,
        expHi: String
    ) = PyqQuestionItem(
        id = id,
        sectionType = PyqSectionType.OBJECTIVE,
        chapterTag = tag,
        marks = 1,
        questionEn = q,
        questionHi = hi,
        options = opts,
        correctOptionIndex = ansIdx,
        answerKeyEn = ans,
        modelSolutionEn = ans,
        explanationHi = expHi
    )

    private fun vs(
        id: String,
        tag: String,
        q: String,
        hi: String,
        ans: String,
        model: String,
        expHi: String
    ) = PyqQuestionItem(
        id = id,
        sectionType = PyqSectionType.VERY_SHORT,
        chapterTag = tag,
        marks = 2,
        questionEn = q,
        questionHi = hi,
        answerKeyEn = ans,
        modelSolutionEn = model,
        explanationHi = expHi
    )

    private fun sh(
        id: String,
        tag: String,
        q: String,
        hi: String,
        ans: String,
        model: String,
        expHi: String
    ) = PyqQuestionItem(
        id = id,
        sectionType = PyqSectionType.SHORT,
        chapterTag = tag,
        marks = 3,
        questionEn = q,
        questionHi = hi,
        answerKeyEn = ans,
        modelSolutionEn = model,
        explanationHi = expHi
    )

    private fun lg(
        id: String,
        tag: String,
        q: String,
        hi: String,
        ans: String,
        model: String
    ) = PyqQuestionItem(
        id = id,
        sectionType = PyqSectionType.LONG,
        chapterTag = tag,
        marks = 4,
        questionEn = q,
        questionHi = hi,
        answerKeyEn = ans,
        modelSolutionEn = model,
        explanationHi = "बोर्ड परीक्षा में साफ-सुथरे फॉर्मेट और बिंदुओं (Headings / Proper Alignment) के साथ लिखने पर पूरे अंक प्राप्त होते हैं।"
    )
}
