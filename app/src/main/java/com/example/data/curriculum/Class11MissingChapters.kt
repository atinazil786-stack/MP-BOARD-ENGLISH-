package com.example.data.curriculum

import com.example.data.curriculum.CurriculumBuilders.ch
import com.example.data.curriculum.CurriculumBuilders.f
import com.example.data.curriculum.CurriculumBuilders.makeProseChapter
import com.example.data.curriculum.CurriculumBuilders.p
import com.example.data.curriculum.CurriculumBuilders.sc
import com.example.data.curriculum.CurriculumBuilders.w
import com.example.data.model.CartoonMood
import com.example.data.model.CartoonSetting
import com.example.data.model.Chapter
import com.example.data.model.MatchPair

object Class11MissingChapters {

    val chapters: List<Chapter> = listOf(
        // --- HORNBILL PROSE (3 missing) ---
        makeProseChapter(
            id = "c11_hb_4",
            classLevel = 11,
            bookName = "Hornbill",
            chapterNumber = 4,
            category = "Prose",
            title = "The Ailing Planet: the Green Movement's Role",
            titleHi = "बीमार ग्रह: हरित आंदोलन की भूमिका",
            author = "Nani Palkhivala",
            summaryEn = "Written in 1994, Nani Palkhivala's landmark article highlights Earth as a living, suffering patient weakened by overpopulation, deforestation, collapsing fisheries, and overgrazed grasslands—urging humanity to become responsible trustees for future generations.",
            summaryHi = "1994 में नानी पालखीवाला द्वारा लिखा गया यह प्रसिद्ध लेख पृथ्वी को एक बीमार रोगी के रूप में दिखाता है जिसे बढ़ती जनसंख्या, वनों की कटाई, समाप्त होते मत्स्य क्षेत्र और चरागाह नुकसान पहुँचा रहे हैं। यह 'सतत विकास' और आने वाली पीढ़ियों के लिए पृथ्वी की रक्षा की अपील करता है।",
            hindiExplanation = "1972 में न्यूज़ीलैंड में पहली हरित पार्टी (Green Party) के साथ हरित आंदोलन शुरू हुआ, जिसने हमारी सोच यांत्रिक (mechanistic) से पारिस्थितिक (holistic/ecological) दृष्टिकोण में बदली। ब्रंटलैंड आयोग (1987) ने 'सतत विकास' (Sustainable Development) की परिभाषा दी। लेस्टर ब्राउन ने पृथ्वी की चार प्रमुख जैविक प्रणालियाँ बताईं—मत्स्य पालन, वन, चरागाह और कृषि भूमि—जो मनुष्य की अत्यधिक माँग से नष्ट हो रही हैं। मार्गरेट थैचर के शब्दों में हमारे पास धरती पर आजीवन अधिकार (freehold) नहीं, बल्कि अगली पीढ़ी के लिए मरम्मत की शर्त पर किराया (repairing lease) है!",
            themeEn = "Earth is a living organism requiring sustainable stewardship, ecological ethics, and population control.",
            themeHi = "पृथ्वी एक जीवित ग्रह है जिसकी रक्षा सतत विकास, वन संरक्षण और जनसंख्या नियंत्रण से ही संभव है।",
            messageHi = "हमने यह पृथ्वी पूर्वजों से विरासत में नहीं ली, बल्कि अपनी आने वाली संतानों से उधार ली है—इसलिए इसका संरक्षण हमारा कर्तव्य है।",
            words = listOf(
                w("Holistic", "adj", "Treating the whole system as interconnected", "समग्र / पारिस्थितिक", "Humanity shifted from a mechanistic to a holistic view."),
                w("Sustainable", "adj", "Able to continue without exhausting resources", "सतत / टिकाऊ", "Sustainable development protects future needs."),
                w("Decimated", "verb", "Destroyed a large fraction of", "बड़ी संख्या में नष्ट करना", "Tropical forests are being decimated at a rapid pace."),
                w("Catastrophic", "adj", "Involving sudden terrible disaster", "विनाशकारी", "Forest loss causes catastrophic extinction of species."),
                w("Transcending", "verb", "Going beyond ordinary limits", "सीमाओं से ऊपर उठना", "Environment protection demands an ethics transcending self-interest.")
            ),
            matchPairs = listOf(
                MatchPair("1972 (New Zealand)", "First nationwide Green Party founded"),
                MatchPair("Lester R. Brown", "Identified four principal biological systems"),
                MatchPair("Brundtland Commission", "Defined Sustainable Development (1987)"),
                MatchPair("Lusaka Zoo Cage", "World's most dangerous animal — Man")
            ),
            extract1 = ExtractSpec(
                extractText = "“Notice inside a cage in the zoo at Lusaka, Zambia reads: ‘The world's most dangerous animal’. Inside the cage there is no animal but a mirror where you see yourself.”",
                promptEn = "Why did the Lusaka zoo place a mirror inside the cage labeled 'the world's most dangerous animal'?",
                promptHi = "लुसाका चिड़ियाघर के पिंजरे में 'दुनिया का सबसे खतरनाक जानवर' लिखकर आईना क्यों रखा गया था?",
                answerEn = "To awaken humans to the truth that human greed, pollution, and destruction of habitats make mankind far more dangerous than wild beasts.",
                answerHi = "मनुष्य को यह एहसास दिलाने के लिए कि अपने स्वार्थ व प्रकृति के विनाश के कारण इंसान ही सबसे खतरनाक प्राणी बन गया है।"
            ),
            extract2 = ExtractSpec(
                extractText = "“We have not inherited this earth from our forefathers; we have borrowed it from our children.”",
                promptEn = "What moral responsibility does Mr. Lester Brown's statement place on us?",
                promptHi = "लेस्टर ब्राउन का यह कथन हम पर क्या नैतिक जिम्मेदारी डालता है?",
                answerEn = "We are trustees, not owners, and must hand over a healthy, unspoiled planet with intact forests, clean water, and fertile soil to future generations.",
                answerHi = "हम पृथ्वी के मालिक नहीं बल्कि संरक्षक (trustees) हैं; हमें इसे स्वस्थ व सुरक्षित रूप में अगली पीढ़ी को सौंपना है।"
            ),
            pyqPromptEn = "What are the four principal biological systems of Earth discussed by Nani Palkhivala, and how are they threatened?",
            pyqPromptHi = "नानी पालखीवाला द्वारा बताई गई पृथ्वी की चार प्रमुख जैविक प्रणालियाँ कौन-सी हैं और वे खतरे में क्यों हैं?",
            pyqAnswerEn = "Fisheries, forests, grasslands, and croplands form Earth's economic foundation. Over-fishing, logging for firewood, overgrazing, and excessive chemical farming push them to unsustainable collapse.",
            pyqAnswerHi = "मत्स्य पालन, वन, चरागाह और कृषि भूमि चार मुख्य जैविक प्रणालियाँ हैं, जो अत्यधिक दोहन, चराई, लकड़ी कटाई व प्रदूषण के कारण नष्ट हो रही हैं।",
            mcq1Prompt = "Where was the world's first nationwide Green Party founded in 1972?",
            mcq1Options = listOf("New Zealand", "Australia", "Sweden", "India"),
            mcq1Correct = 0,
            mcq1Hi = "1972 में दुनिया की पहली राष्ट्रव्यापी ग्रीन पार्टी न्यूज़ीलैंड में बनी थी।",
            mcq2Prompt = "Which Indian constitutional article mandates the State to protect and improve the environment?",
            mcq2Options = listOf("Article 370", "Article 48A", "Article 21A", "Article 19"),
            mcq2Correct = 1,
            mcq2Hi = "भारतीय संविधान के अनुच्छेद 48A में पर्यावरण, वन और वन्यजीवों की रक्षा का प्रावधान है।"
        ),
        makeProseChapter(
            id = "c11_hb_5",
            classLevel = 11,
            bookName = "Hornbill",
            chapterNumber = 5,
            category = "Prose",
            title = "The Adventure",
            titleHi = "साहसिक अनुभव (द एडवेंचर)",
            author = "Jayant Narlikar",
            summaryEn = "Historian Professor Gangadharpant Gaitonde suffers a collision and wakes up in an alternate timeline where the Marathas won the Third Battle of Panipat (1761), transforming India into a proud, modern, self-ruled nation. Physicist Rajendra Deshpande explains the phenomenon using catastrophe theory and quantum mechanics.",
            summaryHi = "इतिहासकार प्रोफेसर गायतोंडे एक दुर्घटना के बाद ऐसे समानांतर संसार (Parallel Reality) में पहुँच जाते हैं जहाँ 1761 में मराठा पानीपत का तीसरा युद्ध जीत गए थे और भारत कभी गुलाम नहीं हुआ! भौतिक वैज्ञानिक राजेंद्र देशपांडे इसे कैटास्ट्रोफी थ्योरी और क्वांटम सिद्धांत से समझाते हैं।",
            hindiExplanation = "प्रोफेसर गायतोंडे पुणे से 'जीजामाता एक्सप्रेस' द्वारा बॉम्बे जाते हैं। वहाँ उन्हें ईस्ट इंडिया कंपनी का भव्य दफ्तर, ब्रिटिश झंडा और एक स्वतंत्र-समृद्ध भारत दिखता है। टाउन हॉल पुस्तकालय में उन्हें 'भाऊसाहेबांची बखर' में पता चलता है कि गोली विश्वासराव के कान के पास से निकल गई, सदाशिवराव भाऊ व मराठे पानीपत जीत गए और भारत लोकतांत्रिक राष्ट्र बन गया। आज़ाद मैदान के मंच से धक्का खाने के बाद वे वापस वर्तमान में लौटते हैं और राजेंद्र देशपांडे बताते हैं कि दुर्घटना के क्षण वे दो में से दूसरी क्वांटम वास्तविकता का अनुभव कर आए थे!",
            themeEn = "Science and history intersect through alternative realities, human curiosity, and quantum possibilities.",
            themeHi = "विज्ञान और इतिहास के संगम में छोटे-से ऐतिहासिक मोड़ से संपूर्ण भविष्य बदल सकता है।",
            messageHi = "तर्कशीलता, जिज्ञासा और वैज्ञानिक दृष्टिकोण अज्ञात घटनाओं को समझने की कुंजी हैं।",
            words = listOf(
                w("Catastrophe", "noun", "Sudden violent event or abrupt shift", "अचानक बड़ा मोड़ / विपत्ति", "Rajendra used catastrophe theory to explain the timeline split."),
                w("Determinism", "noun", "Belief that events are fixed by prior causes", "नियतिवाद", "Quantum physics challenges strict determinism."),
                w("Relegated", "verb", "Assigned to an inferior position", "निचले स्तर पर भेजना", "In the alternate history, the East India Company was relegated to trade pockets."),
                w("Valour", "noun", "Great courage in battle", "वीरता / शौर्य", "Maratha troops fought with extraordinary valour."),
                w("Immaculate", "adj", "Spotless and neatly maintained", "बेदाग / अत्यंत स्वच्छ", "Bombay streets looked surprisingly clean and immaculate.")
            ),
            matchPairs = listOf(
                MatchPair("Prof. Gaitonde", "Historian from Pune"),
                MatchPair("Rajendra Deshpande", "Physicist explaining quantum split"),
                MatchPair("Panipat (1761)", "Pivotal turning point in the story"),
                MatchPair("Bhausahebanchi Bakhar", "Chronicle read in Town Hall")
            ),
            extract1 = ExtractSpec(
                extractText = "“He was pondering over a point in history when the truck hit him. Two days later he was found in Azad Maidan.”",
                promptEn = "What historical turning point was Professor Gaitonde thinking about right before his accident?",
                promptHi = "दुर्घटना से ठीक पहले प्रोफेसर गायतोंडे इतिहास के किस मोड़ के बारे में सोच रहे थे?",
                answerEn = "He was wondering what would have happened in Indian history had the Marathas not lost the Third Battle of Panipat in 1761.",
                answerHi = "वे सोच रहे थे कि यदि 1761 में पानीपत का तीसरा युद्ध मराठे जीत गए होते तो भारत का इतिहास कैसा होता।"
            ),
            extract2 = ExtractSpec(
                extractText = "“Lack of determinism in quantum theory! When an electron jumps, it may exist in multiple states until observed.”",
                promptEn = "How did Rajendra Deshpande use quantum theory to explain Gaitonde's strange experience?",
                promptHi = "राजेंद्र देशपांडे ने क्वांटम सिद्धांत से प्रोफेसर गायतोंडे के अनुभव को कैसे समझाया?",
                answerEn = "He explained that Gaitonde experienced a catastrophic bifurcation into a parallel universe because his mind was intensely focused on Panipat during the collision.",
                answerHi = "उन्होंने समझाया कि दुर्घटना के समय मन की एकाग्रता के कारण प्रोफेसर ने एक वैकल्पिक वास्तविकता (parallel world) का प्रत्यक्ष अनुभव किया।"
            ),
            pyqPromptEn = "Why was Professor Gaitonde shocked upon seeing the Hornby Road and Victoria Terminus in Bombay?",
            pyqPromptHi = "बॉम्बे के विक्टोरिया टर्मिनस और हॉर्नबी रोड को देखकर प्रोफेसर गायतोंडे क्यों चौंक गए?",
            pyqAnswerEn = "Instead of familiar post-independence shops, he saw British-named stores, Anglo-Indian staff, and the headquarters of an active East India Company restricted strictly to commercial zones in a never-colonized India.",
            pyqAnswerHi = "उन्हें ब्रिटिश नामों वाली दुकानें, एंग्लो-इंडियन कर्मचारी और स्वतंत्र भारत के बीच सीमित व्यापार करती ईस्ट इंडिया कंपनी का मुख्यालय दिखा।" ,
            mcq1Prompt = "Which book did Professor Gaitonde read inside the Town Hall Library to verify Panipat's outcome?",
            mcq1Options = listOf("Bhausahebanchi Bakhar", "Discovery of India", "Ain-i-Akbari", "Arthashastra"),
            mcq1Correct = 0,
            mcq1Hi = "टाउन हॉल पुस्तकालय में उन्होंने अपनी ही लिखी किताबों के साथ 'भाऊसाहेबांची बखर' (Bhausahebanchi Bakhar) पढ़ी।",
            mcq2Prompt = "What happened to the torn page found in Professor Gaitonde's jacket pocket?",
            mcq2Options = listOf("It was a blank note", "It was a real page from Bhausahebanchi Bakhar proving the alternate world", "It was a train ticket", "It was a grocery bill"),
            mcq2Correct = 1,
            mcq2Hi = "जेब में मिला फटा पन्ना 'भाऊसाहेबांची बखर' का असली पन्ना था जिसने सिद्ध किया कि उनका अनुभव मात्र कल्पना नहीं था।"
        ),
        makeProseChapter(
            id = "c11_hb_6",
            classLevel = 11,
            bookName = "Hornbill",
            chapterNumber = 6,
            category = "Prose",
            title = "Silk Road",
            titleHi = "रेशम मार्ग (सिल्क रोड)",
            author = "Nick Middleton",
            summaryEn = "Nick Middleton's vivid travelogue follows his challenging pilgrimage-trek to Mount Kailash via Ravu, Hor, and Darchen along the ancient Silk Road. Battling icy mountain passes, fierce Tibetan mastiffs, high-altitude sinus blockage, and sleeplessness, he meets Tibetan scholar Norbu and finds fellowship.",
            summaryHi = "निक मिडलटन की यह रोमांचक यात्रा कथा प्राचीन सिल्क रोड से होते हुए तिब्बत के पवित्र कैलाश पर्वत की परिक्रमा (कोरा) के कठिन सफर का वर्णन करती है। बर्फीले दर्रों, तिब्बती मस्टिफ कुत्तों और ऊँचाई की साँस की बीमारी से जूझते हुए वे डार्चेन पहुँचते हैं जहाँ नोरबू से उनकी मित्रता होती है।",
            hindiExplanation = "यात्रा की शुरुआत रावू गाँव से होती है जहाँ ल्हामो उन्हें भेड़ की खाल का लंबा कोट (drokba coat) भेंट करती हैं और चालक सेतन उन्हें डार्चेन ले जाता है। मार्ग में वे खानाबदोश तंबुओं, विशाल तिब्बती मस्टिफ कुत्तों और बर्फ से ढके 5,210 मीटर ऊँचे दर्रे को पार करते हैं। होर (Hor) की गंदगी और डार्चेन में गंभीर साइनस व अनिद्रा से लेखक घबरा जाते हैं। तिब्बती डॉक्टर से इलाज के बाद जब वे डार्चेन के कैफे में बीजिंग से आए नोरबू से मिलते हैं, जो स्वयं कैलाश कोरा करने आए थे, तो दोनों एक साथ परिक्रमा करने का निर्णय लेते हैं!",
            themeEn = "Endurance, local kindness, and shared companionship transform a gruelling pilgrimage into triumph.",
            themeHi = "धैर्य, स्थानीय लोगों का स्नेह और समान उद्देश्य वाले साथी की संगति सबसे कठिन यात्रा को भी सफल बना देती है।",
            messageHi = "चुनौतियों में घबराने के बजाय उपचार व सकारात्मक सोच अपनाएँ तो मार्ग स्वयं आसान हो जाता है।",
            words = listOf(
                w("Kora", "noun", "Sacred Tibetan clockwise circumambulation", "पवित्र परिक्रमा (कैलाश की)", "Middleton travelled to Darchen to perform the Kora."),
                w("Drokba", "noun", "Nomadic Tibetan shepherds", "तिब्बती घुमंतू चरवाहे", "Drokba nomads waved from dark woolen tents."),
                w("Mastiff", "noun", "Large powerful Tibetan guard dog", "तिब्बती शिकारी कुत्ता", "Shaggy Tibetan mastiffs chased the passing car."),
                w("Cairn", "noun", "Mound of stones as a mountain landmark", "पत्थरों का टीला / मार्गदर्शक स्तूप", "A cairn of rocks marked the snowy mountain pass."),
                w("Paraphernalia", "noun", "Equipment needed for an activity", "यात्रा का साज़ो-सामान", "Norbu carried academic books rather than heavy trekking paraphernalia.")
            ),
            matchPairs = listOf(
                MatchPair("Tsetan", "Skilled Tibetan driver"),
                MatchPair("Lhamo", "Gifted sheepskin drokba coat"),
                MatchPair("Daniel", "Accompanied from Ravu to Hor"),
                MatchPair("Norbu", "Tibetan scholar writing papers on Kora")
            ),
            extract1 = ExtractSpec(
                extractText = "“She gave me a long-sleeved sheepskin coat that all the men wore... ‘You’re going to Kailash, you’ll need warm clothes.’”",
                promptEn = "Who gave the author this farewell gift and where did the journey start?",
                promptHi = "लेखक को यह विदाई उपहार किसने दिया और उनकी यात्रा कहाँ से शुरू हुई?",
                answerEn = "Lhamo at Ravu village in Tibet gave Nick Middleton the warm sheepskin drokba coat as a farewell gift.",
                answerHi = "तिब्बत के रावू गाँव में ल्हामो ने निक मिडलटन को ठंड से बचने के लिए भेड़ की ऊन का लंबा कोट भेंट किया।"
            ),
            extract2 = ExtractSpec(
                extractText = "“My initial relief at meeting Norbu, who was also staying in the guest house, was tempered by the realisation that he was almost as ill-equipped as I was.”",
                promptEn = "Why did Nick Middleton feel both relieved and amused upon meeting Norbu?",
                promptHi = "डार्चेन में नोरबू से मिलकर लेखक को राहत और हँसी दोनों क्यों आई?",
                answerEn = "He was relieved to have a fellow English-speaking companion for the Kailash Kora, yet amused because Norbu was an overweight academic wearing no climbing gear.",
                answerHi = "उन्हें कोरा परिक्रमा के लिए एक अंग्रेजी जानने वाला साथी मिला, और हँसी इसलिए आई क्योंकि नोरबू भी एक विद्वान प्रोफेसर थे जो पर्वतारोहण के बजाय किताबों के साथ आए थे।"
            ),
            pyqPromptEn = "Why did the narrator feel disappointed on reaching Hor, and what medical trouble troubled him in Darchen?",
            pyqPromptHi = "होर (Hor) पहुँचकर लेखक को निराशा क्यों हुई और डार्चेन में उन्हें किस शारीरिक समस्या का सामना करना पड़ा?",
            pyqAnswerEn = "Hor, beside sacred Lake Manasarovar, looked grim, dusty, and littered with refuse unlike poetic travel tales. In Darchen, a severe cold and high altitude blocked his nostrils, causing sleeplessness until Tibetan herbal medicine cured him.",
            pyqAnswerHi = "मानसरोवर किनारे बसा होर गंदा और बेरंग था। डार्चेन में ऊँचाई व सर्दी के कारण उनकी नाक बंद हो गई और रात भर नींद नहीं आई, जिसे तिब्बती दवा ने ठीक किया।",
            mcq1Prompt = "What was the name of the friendly Tibetan scholar whom Nick Middleton met at Darchen's cafe?",
            mcq1Options = listOf("Norbu", "Tsetan", "Lhamo", "Daniel"),
            mcq1Correct = 0,
            mcq1Hi = "डार्चेन के कैफे में निक मिडलटन की मुलाकात तिब्बती विद्वान नोरबू (Norbu) से हुई।",
            mcq2Prompt = "What did Tibetan nomads raise that were famously fierce guard dogs even in China's imperial courts?",
            mcq2Options = listOf("Tibetan mastiffs", "Kyang wild asses", "Siberian huskies", "Mountain wolves"),
            mcq2Correct = 0,
            mcq2Hi = "तिब्बती मस्टिफ (Tibetan mastiffs) अपनी निडरता के लिए प्रसिद्ध थे और प्राचीन चीन के शाही दरबारों में भेंट किए जाते थे।"
        ),

        // --- SNAPSHOTS SUPPLEMENTARY (3 missing) ---
        makeProseChapter(
            id = "c11_sn_2",
            classLevel = 11,
            bookName = "Snapshots",
            chapterNumber = 2,
            category = "Supplementary",
            title = "The Address",
            titleHi = "पता (द एड्रेस)",
            author = "Marga Minco",
            summaryEn = "A poignant post-World War II story in Holland. After surviving the Holocaust, the narrator visits Mrs. Dorling at 46 Marconi Street to reclaim her dead mother's silver, antique plates, and woollens—only to realize cold, tastelessly arranged objects lose all meaning without the loved ones who cherished them.",
            summaryHi = "द्वितीय विश्वयुद्ध के बाद हॉलैंड की एक युवा लड़की अपनी मृत माँ की कीमती चीज़ें वापस लेने 46 मार्कोनी स्ट्रीट पर श्रीमती डोरलिंग के घर जाती है। अपने परिवार की यादों से जुड़ी वस्तुओं को बेढंगे व अजनबी माहौल में देखकर वह उन्हें वहीं छोड़ देने का कठिन पर शांतिपूर्ण निर्णय लेती है।",
            hindiExplanation = "युद्ध शुरू होने पर कथावाचक की माँ श्रीमती एस ने जान बचाने की उम्मीद में अपनी चाँदी की कटलरी, चीनी मिट्टी की प्लेटें और पुरानी मेज़पोश अपनी पुरानी परिचित श्रीमती डोरलिंग को सौंप दीं। युद्ध के बाद अकेली बची बेटी 46 मार्कोनी स्ट्रीट पहुँचती है। पहली बार डोरलिंग दरवाज़े से ही टाल देती है। दूसरी बार डोरलिंग की 15 वर्षीय बेटी घर में बुलाती है जहाँ अपनी माँ का बुना मेज़पोश (जिस पर जलने का पुराना दाग था) और चाँदी के बर्तन देखकर वह भावुक हो उठती है। पर वह समझ जाती है कि युद्ध के बाद छोटे किराए के कमरे में उन चीज़ों के कोई मायने नहीं बचे—इसलिए वह वह पता भूल जाने का निश्चय करती है!",
            themeEn = "War tears away both loved ones and memories; true peace comes from letting go of dead possessions.",
            themeHi = "युद्ध केवल जीवन ही नहीं, यादों को भी उजाड़ देता है; अतीत के बोझ को छोड़कर आगे बढ़ना ही सच्ची शांति है।",
            messageHi = "वस्तुओं का मूल्य उनसे जुड़े अपनों के प्रेम से होता है; भौतिक संग्रह के पीछे अतीत के दर्द में न उलझें।",
            words = listOf(
                w("Chink", "noun", "A narrow opening or crack", "दरार / थोड़ी खुली जगह", "Mrs. Dorling opened the door just a chink."),
                w("Musty", "adj", "Smelling stale and damp", "सीली हुई / बासी गंध वाला", "The room had a muggy, musty smell."),
                w("Pewter", "noun", "Grey metal alloy used for plates", "जस्ता-टिन मिश्रधातु के बर्तन", "She recognized the old pewter plates on the dresser."),
                w("Liberation", "noun", "Freedom from war occupation", "मुक्ति / आज़ादी", "After liberation, she hesitated to visit 46 Marconi Street."),
                w("Beckoned", "verb", "Signaled someone to come closer", "इशारे से बुलाया", "The young girl beckoned the narrator inside.")
            ),
            matchPairs = listOf(
                MatchPair("46 Marconi Street", "Mrs. Dorling's address"),
                MatchPair("Mrs. Dorling", "Took away valuables during war"),
                MatchPair("Green knitted cardigan", "Worn by Mrs. Dorling at door"),
                MatchPair("Burn mark on tablecloth", "Proof of narrator's childhood")
            ),
            extract1 = ExtractSpec(
                extractText = "“She held her hand on the door as though she wanted to prevent it opening any further. Her face gave absolutely no sign of recognition.”",
                promptEn = "Why did Mrs. Dorling pretend not to recognize the narrator at 46 Marconi Street?",
                promptHi = "46 मार्कोनी स्ट्रीट पर श्रीमती डोरलिंग ने कथावाचक को पहचानने से इनकार करने का नाटक क्यों किया?",
                answerEn = "Because she was wearing the narrator's mother's green cardigan and had kept all the family's silver and antiques for herself, never expecting any survivor to return.",
                answerHi = "क्योंकि वह कथावाचक की माँ का हरा स्वेटर पहने थी और परिवार के सभी कीमती सामान हड़प चुकी थी—उसे उम्मीद नहीं थी कि कोई जीवित लौटेगा।"
            ),
            extract2 = ExtractSpec(
                extractText = "“Of all the things I had to forget, that would be the easiest.”",
                promptEn = "Why did the narrator resolve to forget the address 46 Marconi Street forever?",
                promptHi = "कथावाचक ने 46 मार्कोनी स्ट्रीट का पता हमेशा के लिए भूल जाने का निश्चय क्यों किया?",
                answerEn = "Seeing her mother's treasured items stored tastelessly in a strange cramped room stripped them of emotional value; she wanted to heal and move on without painful reminders.",
                answerHi = "अपनी माँ की सजी हुई वस्तुओं को एक अजनबी कमरे में बेतरतीब देख उनका भावनात्मक महत्व समाप्त हो गया—वह दर्दनाक अतीत को पीछे छोड़कर आगे बढ़ना चाहती थी।"
            ),
            pyqPromptEn = "Contrast Mrs. S's trusting nature with Mrs. Dorling's opportunism in 'The Address'.",
            pyqPromptHi = "'द एड्रेस' में श्रीमती एस के भोले विश्वास और श्रीमती डोरलिंग के अवसरवादी स्वभाव की तुलना कीजिए।",
            pyqAnswerEn = "Mrs. S naively believed Dorling was taking grave risk by carrying away heavy suitcases to safeguard them, whereas Dorling greedily exploited a terrified Jewish neighbour's crisis and coldly shut the door on her surviving daughter.",
            pyqAnswerHi = "श्रीमती एस ने भोलेपन में डोरलिंग की मदद पर भरोसा किया, जबकि डोरलिंग ने युद्ध संकट का फायदा उठाकर सारा सामान अपने पास रख लिया और जीवित लौटी बेटी को पहचानने से भी इनकार कर दिया।",
            mcq1Prompt = "What was the house number and street address where Mrs. Dorling lived?",
            mcq1Options = listOf("46 Marconi Street", "221B Baker Street", "14 Victoria Road", "88 Oxford Lane"),
            mcq1Correct = 0,
            mcq1Hi = "श्रीमती डोरलिंग का पता 'नंबर 46, मार्कोनी स्ट्रीट' (46 Marconi Street) था।",
            mcq2Prompt = "How did the narrator recognize the woollen tablecloth as belonging to her mother?",
            mcq2Options = listOf("By a tiny unrepaired burn mark on its edge", "By her own signature", "By a silver tag", "By a blue stamp"),
            mcq2Correct = 0,
            mcq2Hi = "मेज़पोश के किनारे पर बने एक अनसिला जले हुए दाग से उन्होंने पहचान लिया कि यह उन्हीं के घर का था।"
        ),
        makeProseChapter(
            id = "c11_sn_3",
            classLevel = 11,
            bookName = "Snapshots",
            chapterNumber = 3,
            category = "Supplementary",
            title = "Mother's Day",
            titleHi = "मातृ दिवस (मदर्स डे)",
            author = "J.B. Priestley",
            summaryEn = "A witty, insightful one-act play about Mrs. Annie Pearson, a devoted homemaker taken for granted by her husband George, daughter Doris, and son Cyril. With magical help from bold neighbour Mrs. Fitzgerald, they temporarily swap personalities so Annie stands up firmly for respect, rest, and equality at home.",
            summaryHi = "जे.बी. प्रीस्टली का यह हास्य व सामाजिक नाटक एक ऐसी गृहिणी श्रीमती एनी पियर्सन की कहानी है जिसे उसके पति जॉर्ज, बेटी डोरिस और बेटे सिरिल दिनभर नौकर की तरह ट्रीट करते हैं। तेज़-तर्रार पड़ोसी श्रीमती फिट्ज़गेराल्ड के साथ जादुई व्यक्तित्व-अदला-बदली के बाद एनी अपने परिवार को सबक सिखाती है और घर में सम्मान व बराबरी हासिल करती है।",
            hindiExplanation = "श्रीमती पियर्सन बहुत सीधी व नम्र हैं, इसलिए बेटी डोरिस पीली सिल्क ड्रेस इस्त्री कराती है, बेटा सिरिल बिना धन्यवाद दिए हुक्म चलाता है और पति जॉर्ज उन्हें घर पर छोड़कर क्लब चले जाते हैं। उनकी पड़ोसी श्रीमती फिट्ज़गेराल्ड 'अरशदांता' मंत्र से दोनों की आत्माएँ (personalities) बदल देती हैं। फिट्ज़गेराल्ड के साहसी रूप में एनी अपने बच्चों व पति को आईना दिखाती हैं—वे कहती हैं कि अब वे भी हफ्ते में दो दिन छुट्टी लेंगी और ओवरटाइम नहीं करेंगी! घबराए हुए परिवार के सुधरने पर दोनों वापस अपने शरीर में लौटती हैं और परिवार साथ रमी खेलता है।",
            themeEn = "Homemakers deserve equal respect, appreciation, and personal leisure—never silent exploitation.",
            themeHi = "माताएँ और गृहिणियाँ भी सम्मान, विश्राम और धन्यवाद की पूरी हकदार हैं; उनकी सेवा को कमज़ोरी न समझें।",
            messageHi = "परिवार के सभी सदस्यों को घर के काम साझा करने चाहिए और माँ के परिश्रम का सम्मान करना चाहिए।",
            words = listOf(
                w("Submissive", "adj", "Meekly obeying everyone without protest", "दब्बू / आज्ञाकारी", "Earlier Annie was timid and submissive toward her children."),
                w("Put one's foot down", "idiom", "Take a firm stand", "कड़ा रुख अपनाना", "Mrs. Fitzgerald urged Annie to put her foot down as mistress of the house."),
                w("Barmy", "adj", "Crazy or foolish (British slang)", "पागल / बेतुका", "Cyril thought his mother had gone barmy."),
                w("Stout", "adj", "Stocky / strongly built and determined", "मज़बूत कद-काठी वाला", "George Pearson was a solemn, self-important stout man."),
                w("Complacent", "adj", "Smugly satisfied and unconcerned", "आत्मसंतुष्ट", "The family's complacent selfishness finally broke.")
            ),
            matchPairs = listOf(
                MatchPair("Mrs. Annie Pearson", "Mild homemaker claiming respect"),
                MatchPair("Mrs. Fitzgerald", "Bold neighbour who swaps souls"),
                MatchPair("Doris Pearson", "Wanted yellow silk ironed for Charlie Spence"),
                MatchPair("George Pearson", "Called 'Pompy-ompy Pearson' at club")
            ),
            extract1 = ExtractSpec(
                extractText = "“I'm going to start putting in a forty-hour week just like the rest of you—and have two days off at the weekend!”",
                promptEn = "Who speaks these bold words to Cyril and Doris, and why are they shocked?",
                promptHi = "सिरिल और डोरिस से ये कड़े शब्द कौन बोलता है और दोनों बच्चे हैरान क्यों रह जाते हैं?",
                answerEn = "Mrs. Pearson (possessed by Mrs. Fitzgerald's bold spirit) speaks them; Cyril and Doris are shocked because their meek mother always slaved 24/7 without complaining.",
                answerHi = "श्रीमती फिट्ज़गेराल्ड के व्यक्तित्व में श्रीमती पियर्सन यह कहती हैं; बच्चे चौंक जाते हैं क्योंकि हमेशा चुप रहने वाली माँ पहली बार अपना अधिकार माँग रही है।"
            ),
            extract2 = ExtractSpec(
                extractText = "“Now remember—keep firm! If you don't go easy now, you'll undo all the good we've done.”",
                promptEn = "What final advice did Mrs. Fitzgerald give Annie after returning to their own bodies?",
                promptHi = "वापस अपने असली रूप में आने पर श्रीमती फिट्ज़गेराल्ड ने एनी को क्या अंतिम सलाह दी?",
                answerEn = "She advised Annie to remain firm and occasionally give her family a sharp look or firm tone so they never slip back into disrespecting her.",
                answerHi = "उन्होंने सलाह दी कि एनी को थोड़ा सख्त और आत्मविश्वासी बने रहना होगा ताकि परिवार दोबारा उनका फायदा न उठाए।"
            ),
            pyqPromptEn = "How did Mrs. Fitzgerald help transform Mrs. Pearson's family life in 'Mother's Day'?",
            pyqPromptHi = "'मदर्स डे' नाटक में श्रीमती फिट्ज़गेराल्ड ने श्रीमती पियर्सन के पारिवारिक जीवन को कैसे सुधारा?",
            pyqAnswerEn = "By exchanging personalities with Annie, Mrs. Fitzgerald fearlessly confronted Doris, Cyril, and George about their selfishness and ingratitude, shocking them into respecting Annie and agreeing to spend a happy evening together.",
            pyqAnswerHi = "व्यक्तित्व बदलकर श्रीमती फिट्ज़गेराल्ड ने डोरिस, सिरिल और जॉर्ज को उनकी स्वार्थपरता का एहसास कराया, जिससे वे सभी एनी का सम्मान करने लगे।",
            mcq1Prompt = "What was the nickname that club members jokingly used behind George Pearson's back?",
            mcq1Options = listOf("Pompy-ompy Pearson", "Jolly George", "Club King", "Uncle Joe"),
            mcq1Correct = 0,
            mcq1Hi = "क्लब में लोग जॉर्ज पियर्सन का मज़ाक उड़ाते हुए उन्हें 'पॉम्पी-ऑम्पी पियर्सन' (Pompy-ompy Pearson) कहते थे।",
            mcq2Prompt = "Whom was Doris Pearson planning to go out with, making her mother iron her yellow silk dress?",
            mcq2Options = listOf("Charlie Spence", "Harry Brown", "Jack Smith", "Cyril"),
            mcq2Correct = 0,
            mcq2Hi = "डोरिस 'चार्ली स्पेंस' के साथ घूमने जाने के लिए अपनी पीली सिल्क ड्रेस इस्त्री कराना चाहती थी।"
        ),
        makeProseChapter(
            id = "c11_sn_5",
            classLevel = 11,
            bookName = "Snapshots",
            chapterNumber = 5,
            category = "Supplementary",
            title = "The Tale of Melon City",
            titleHi = "खरबूजा शहर की कहानी",
            author = "Vikram Seth",
            summaryEn = "A hilarious, biting verse satire by Vikram Seth about a 'just and placid' king whose obsession with whimsical justice ends with him hanging himself by the neck—after which citizens dutifully crown a melon passed by an idiot, celebrating 'laissez faire' peace.",
            summaryHi = "विक्रम सेठ की यह व्यंग्यात्मक काव्य-कथा एक 'न्यायप्रिय और शांत' राजा की कहानी है जिसकी मूर्खतापूर्ण न्याय व्यवस्था अंत में उसे ही फांसी पर लटका देती है! उसके बाद प्रजा एक मूर्ख के कहने पर एक 'खरबूजे' को ही अपना राजा घोषित कर देती है क्योंकि उन्हें केवल अपनी शांति से मतलब है।",
            hindiExplanation = "एक राजा शहर के मुख्य द्वार पर विजय मेहराब (arch) बनवाता है, जो बहुत नीचा बनने से राजा का मुकुट गिरा देता है। क्रोधित राजा न्याय के नाम पर दोष एक-दूसरे पर टलते देखता है—मजदूर से बिल्डर, आर्किटेक्ट से अंततः खुद राजा पर दोष आ जाता है! भीड़ को फांसी चाहिए, इसलिए नाप का फंदा केवल ऊँचे कद वाले राजा की गर्दन में ही फिट आता है और राजा खुशी-खुशी फांसी चढ़ जाता है। नए राजा चुनने के लिए शहर के दरवाजे से गुज़रने वाले पहले व्यक्ति से पूछा जाता है—जो एक पागल होता है और हर बात का जवाब 'एक खरबूजा' देता है। राज्य में खरबूजा राजा बन जाता है और लोग निश्चिंत रहते हैं!",
            themeEn = "Blind bureaucratic justice and public apathy allow absurd leadership to rule unchecked.",
            themeHi = "अंधा कानून, चाटुकारिता और जनता की उदासीनता किसी भी देश में हास्यास्पद व अयोग्य नेतृत्व को जन्म देती है।",
            messageHi = "नेतृत्व और न्याय प्रणाली में विवेक व जागरूकता आवश्यक है; अंधी परंपराएँ समाज का उपहास बनाती हैं।",
            words = listOf(
                w("Placid", "adj", "Calm and not easily excited", "शांत स्वभाव वाला", "The king proclaimed himself just and placid."),
                w("Scaffold", "noun", "Raised platform used for hanging", "फांसी का मंच", "A high gallows scaffold was erected."),
                w("Reverently", "adv", "With deep solemn respect", "श्रद्धापूर्वक", "Ministers reverently carried the melon to the throne."),
                w("Laissez faire", "noun", "Policy of non-interference", "अहस्तक्षेप की नीति / पूर्ण स्वतंत्रता", "Citizens valued peace and laissez faire above who ruled."),
                w("Pondered", "verb", "Thought deeply about something", "गहन विचार किया", "The king pondered the tricky blame-passing dilemma.")
            ),
            matchPairs = listOf(
                MatchPair("Chief of builders", "Blamed the workmen"),
                MatchPair("Architect", "Blamed the King's own amendments"),
                MatchPair("Wisest man", "Declared the arch itself must hang"),
                MatchPair("A Melon", "Crowned monarch by an idiot's decree")
            ),
            extract1 = ExtractSpec(
                extractText = "“The noose was set up somewhat high. Each man was measured by and by. But only one man was so tall He fitted. One man. That was all.”",
                promptEn = "Who was the only person tall enough to fit the noose, and what absurd consequence followed?",
                promptHi = "उस फांसी के फंदे में किस एकमात्र व्यक्ति का कद फिट बैठा और इसका क्या हास्यास्पद परिणाम हुआ?",
                answerEn = "The King himself was the only one tall enough; obeying his own decree that someone must hang, he was executed by royal command.",
                answerHi = "केवल स्वयं राजा का कद इतना ऊँचा था; भीड़ के दबाव व अपने ही आदेश के कारण राजा को खुद फांसी पर चढ़ना पड़ा।"
            ),
            extract2 = ExtractSpec(
                extractText = "“‘A melon,’ the idiot replied. This was his standard answer to all questions. (He liked melons.)”",
                promptEn = "Why did the ministers happily crown a melon as the new King of Melon City?",
                promptHi = "मंत्रियों ने एक खरबूजे को ही नया राजा क्यों घोषित कर दिया?",
                answerEn = "Custom required the first man passing the City Gate to name the monarch; ministers feared public unrest if custom broke and saw a melon wouldn't interfere with their freedom.",
                answerHi = "पुरानी परंपरा के अनुसार नगर द्वार से गुज़रने वाले पहले व्यक्ति का आदेश मानना था और मंत्रियों को लगा कि खरबूजा राजा उनके काम में दखल नहीं देगा।"
            ),
            pyqPromptEn = "Why is Vikram Seth's 'The Tale of Melon City' considered a sharp political satire?",
            pyqPromptHi = "विक्रम सेठ की 'द टेल ऑफ मेलन सिटी' को एक तीखा राजनीतिक व्यंग्य क्यों माना जाता है?",
            pyqAnswerEn = "It mocks rulers who equate noisy display of 'justice' with wisdom, ministers who blindly follow empty customs, and citizens who happily tolerate even a vegetable ruler as long as they are left alone.",
            pyqAnswerHi = "यह दिखावटी न्याय व्यवस्था, अंधी परंपराओं के गुलाम मंत्रियों और केवल अपने स्वार्थ की शांति चाहने वाली उदासीन जनता पर तीखा व्यंग्य है।",
            mcq1Prompt = "Who was blamed by the architect for making wrong changes to the arch's original plan?",
            mcq1Options = listOf("The King himself", "The chief mason", "The wisest old man", "The town crier"),
            mcq1Correct = 0,
            mcq1Hi = "वास्तुकार (Architect) ने बताया कि मूल योजना में स्वयं राजा ने ही बदलाव किए थे।",
            mcq2Prompt = "What quality of the Melon King made the citizens perfectly happy years later?",
            mcq2Options = listOf("Peace, liberty, and the principle of laissez faire", "Heavy taxes", "Daily parades", "Military conquests"),
            mcq2Correct = 0,
            mcq2Hi = "नागरिक खुश थे क्योंकि खरबूजा राजा से उन्हें शांति, स्वतंत्रता और 'अहस्तक्षेप नीति' (laissez faire) मिली थी।"
        )
    )

    val specs: Map<String, ChapterRichSpec> = listOf(
        ChapterRichSpec(
            chapterId = "c11_hb_4",
            detailedHindiTeaching = "नानी पालखीवाला का यह निबंध MP बोर्ड कक्षा 11 का सबसे महत्वपूर्ण पर्यावरण-आधारित पाठ है। 'Green Movement', 'Sustainable Development', और '4 Biological Systems' परीक्षा में बार-बार पूछे जाते हैं!",
            paragraphs = listOf(
                p(1, "हरित क्रांति और पारिस्थितिक दृष्टिकोण", "Green Movement began in 1972 in New Zealand, shifting humanity toward viewing Earth as a living organism.", "पृथ्वी कोई निर्जीव मशीन नहीं बल्कि एक बीमार मरीज़ है जिसकी नब्ज़ तेज़ी से कमज़ोर पड़ रही है—अब यांत्रिक नहीं समग्र सोच चाहिए।", "पृथ्वी के प्रति सम्वेदनशील व्यवहार ही सच्ची प्रगति है।"),
                p(2, "चार जैविक प्रणालियाँ और घटते वन", "Lester Brown identified four biological systems: fisheries, forests, grasslands, and croplands—all eroding under human greed.", "अधिक मछली पकड़ना, अंधाधुंध पेड़ काटना और चरागाह नष्ट करना हमारे पूरे आर्थिक आधार को खतरे में डाल रहा है।", "वन जीवित रहेंगे तभी मानव जीवन बचेगा।"),
                p(3, "जनसंख्या विस्फोट और संतानों से उधार पृथ्वी", "Rising world population undermines development; as trustees holding a 'repairing lease', we owe future children a green planet.", "विकास ही सबसे अच्छा गर्भनिरोधक है—हमें शिक्षित होकर जनसंख्या व प्रदूषण दोनों पर लगाम लगानी होगी।", "पृथ्वी संतानों की अमानत है—इसे हरा-भरा लौटाएँ।")
            ),
            characters = listOf(
                ch("Nani Palkhivala", "नानी पालखीवाला", "प्रख्यात न्यायविद एवं पर्यावरण विचारक", listOf("दूरदर्शी", "तर्कशील", "पर्यावरण रक्षक"), "पालखीवाला ने सांख्यिकी और संवैधानिक तथ्यों के साथ भारत और विश्व को सतत विकास की चेतावनी दी।", "Palkhivala blends legal clarity, scientific data, and moral urgency to plead for Earth's survival.")
            ),
            cartoonScenes = listOf(
                sc(1, "लुसाका चिड़ियाघर का आईना!", "Most Dangerous Animal", "अरे देखो! पिंजरे में कोई शेर नहीं—एक आईना लगा है जिसमें इंसान खुद का चेहरा देखता है!", "Student", "Zoo Mirror", CartoonSetting.HOME_GARDEN, CartoonMood.MYSTERY, "Human Mirror"),
                sc(2, "बीमार पृथ्वी माता की चिंता", "Ailing Planet", "पेड़ कट रहे हैं, नदियाँ सूख रही हैं—धरती माता बुखार में बीमार पड़ी मदद पुकार रही हैं!", "Earth", "Green Movement", CartoonSetting.HOME_GARDEN, CartoonMood.DRAMATIC, "Ecology Alert"),
                sc(3, "चार जैविक स्तंभ", "Four Biological Systems", "इमरान सर समझा रहे हैं—Fisheries, Forests, Grasslands और Croplands बचाना ही भविष्य की कुंजी है!", "Imran Sir", "Board Diagram", CartoonSetting.CLASSROOM, CartoonMood.THOUGHTFUL, "Four Systems"),
                sc(4, "हरियाली और सतत विकास", "Sustainable Future", "चलो मिलकर पौधे लगाएँ—क्योंकि हमने यह धरती अपने बच्चों से उधार ली है!", "Students", "Imran Sir", CartoonSetting.HOME_GARDEN, CartoonMood.INSPIRING, "Save Earth")
            )
        ),
        ChapterRichSpec(
            chapterId = "c11_hb_5",
            detailedHindiTeaching = "जयंत नारलीकर (प्रख्यात भारतीय खगोल-भौतिकविद्) की यह कहानी इतिहास और आधुनिक क्वांटम विज्ञान को जोड़ती है! पानीपत 1761 का वैकल्पिक परिणाम पढ़ते हुए बच्चों को बड़ा रोमांच आता है।",
            paragraphs = listOf(
                p(1, "जीजामाता एक्सप्रेस और अनजान बॉम्बे", "Professor Gaitonde travelled to Bombay and was stunned to find East India Company buildings standing in an independent India.", "इतिहास की किताबें पढ़ते समय गायतोंडे ने देखा कि उनके सामने बिल्कुल अलग भारत है—जहाँ अंग्रेज़ केवल व्यापारी बनकर रह गए।", "एक घटना इतिहास की पूरी धारा बदल सकती है।"),
                p(2, "टाउन हॉल पुस्तकालय में 'भाऊसाहेबांची बखर'", "Reading the historical chronicle revealed that Vishwasrao survived the bullet and the Marathas won Panipat in 1761.", "गोली विश्वासराव के कान के पास से निकल गई! सदाशिवराव और मराठों की जीत के बाद भारत ने स्वशासन व आधुनिक विज्ञान अपनाया।", "सकारात्मक इतिहास आत्मविश्वास और प्रेरणा देता है।"),
                p(3, "कैटास्ट्रोफी थ्योरी व क्वांटम वास्तविकता", "Rajendra Deshpande explained via catastrophe theory and quantum uncertainty that Gaitonde experienced a parallel reality.", "कोमा में रहते हुए गायतोंडे वास्तव में दूसरी क्वांटम स्थिति से गुज़रे—उनकी जेब में मिला फटा पन्ना इसका ठोस सबूत था!", "विज्ञान में अनेक अनदेखी संभावनाएँ छिपी होती हैं।")
            ),
            characters = listOf(
                ch("Prof. Gangadharpant Gaitonde", "प्रो. गायतोंडे", "जिज्ञासु इतिहासकार", listOf("शोधप्रिय", "साहसी", "तार्किक"), "पाँच खंडों का भारतीय इतिहास लिख चुके प्रोफेसर अचानक समानांतर इतिहास का साक्षात अनुभव करते हैं।", "Prof. Gaitonde is a dedicated historian whose curiosity carries him into an alternate historical timeline."),
                ch("Rajendra Deshpande", "राजेंद्र देशपांडे", "क्वांटम भौतिक विज्ञानी", listOf("विद्वान", "वैज्ञानिक दृष्टि", "सहायक मित्र"), "वे गायतोंडे के विचित्र अनुभव को कैटास्ट्रोफी थ्योरी व इलेक्ट्रॉन संक्रमण से वैज्ञानिक रूप से सिद्ध करते हैं।", "Rajendra Deshpande bridges historical mystery and theoretical physics.")
            ),
            cartoonScenes = listOf(
                sc(1, "पुणे से जीजामाता एक्सप्रेस", "Train Journey", "प्रोफेसर गायतोंडे पुणे से बॉम्बे जा रहे हैं—सड़क दुर्घटना के बाद समय की दुनिया बदल गई!", "Gaitonde", "Train", CartoonSetting.CITY_MARKET, CartoonMood.MYSTERY, "Timeline Shift"),
                sc(2, "बदला हुआ बॉम्बे व टाउन हॉल", "Alternate Bombay", "अरे! ईस्ट इंडिया कंपनी अभी भी व्यापार कर रही है और भारत कभी गुलाम ही नहीं हुआ?", "Gaitonde", "Library", CartoonSetting.CITY_MARKET, CartoonMood.THOUGHTFUL, "Hidden History"),
                sc(3, "आज़ाद मैदान पर बहस!", "Azad Maidan Stage", "खाली अध्यक्ष कुर्सी पर बैठने की ज़िद में प्रोफेसर को मंच से हटाया गया—तभी वे वर्तमान में लौट आए!", "Gaitonde", "Crowd", CartoonSetting.ROYAL_PALACE, CartoonMood.DRAMATIC, "Empty Chair"),
                sc(4, "क्वांटम थ्योरी का रहस्य खुला!", "Quantum Science", "राजेंद्र सर और इमरान सर ने फटे पन्ने से साबित किया—अंतरिक्ष-समय में अनंत संभावनाएँ हैं!", "Rajendra", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Science Reveal")
            )
        ),
        ChapterRichSpec(
            chapterId = "c11_hb_6",
            detailedHindiTeaching = "निक मिडलटन का 'Silk Road' यात्रा-वृत्तांत रावू से शुरू होकर 5,210 मीटर बर्फीले दर्रे, होर झील और डार्चेन तक कैलाश परिक्रमा की कठिनाइयों व मानवीय जुड़ाव को जीवंत करता है।",
            paragraphs = listOf(
                p(1, "रावू से विदाई और सिल्क रोड की चढ़ाई", "Leaving Ravu with Lhamo's warm sheepskin coat, Nick, Tsetan, and Daniel climbed snowy mountain passes toward Lake Manasarovar.", "भयंकर तिब्बती मस्टिफ कुत्तों और फिसलती बर्फीली सड़कों को पार करते हुए सेतन ने धैर्य से गाड़ी चलाई।", "ऊँचे पहाड़ों में स्थानीय मार्गदर्शकों का अनुभव जीवन रक्षक होता है।"),
                p(2, "होर कस्बा और डार्चेन में साइनस संकट", "Disappointed by dusty Hor, Nick caught a harsh cold in Darchen where blocked nostrils kept him gasping all night.", "डार्चेन में रातभर साँस न आने के डर से वे जागते रहे, पर सुबह तिब्बती डॉक्टर की पाँच दिन की पुड़ियों ने तुरंत राहत दी।", "स्वास्थ्य बाधाओं के बावजूद सही उपचार से राह खुलती है।"),
                p(3, "नोरबू से भेंट और कैलाश कोरा का संकल्प", "Meeting fellow pilgrim Norbu at Darchen's cafe transformed Nick's lonely anxiety into cheerful companionship.", "नोरबू ने बताया कि वे भी पहली बार कैलाश कोरा (परिक्रमा) करने आए हैं—दोनों ने याक किराए पर लेकर साथ चलने की योजना बनाई!", "अच्छा साथी किसी भी कठिन यात्रा को आनंददायक बना देता है।")
            ),
            characters = listOf(
                ch("Nick Middleton", "निक मिडलटन", "अंग्रेज़ यात्री और लेखक", listOf("खोजी", "धैर्यवान", "हास्यबोध वाले"), "कठिन ठंड और साँस की परेशानी के बावजूद वे अपनी यात्रा पूरी करने का संकल्प नहीं छोड़ते।", "Middleton narrates extreme high-altitude trials with vivid observation and dry humour."),
                ch("Tsetan", "सेतन", "कुशल तिब्बती ड्राइवर", listOf("निडर", "व्यावहारिक", "दयालु"), "बर्फीली चट्टानों पर मिट्टी डालकर रास्ता बनाने से लेकर लेखक को डॉक्टर तक ले जाने में सेतन अद्भुत मदद करते हैं।", "Tsetan is a fearless, resourceful Tibetan driver who ensures Nick reaches medical care safely.")
            ),
            cartoonScenes = listOf(
                sc(1, "रावू से गर्म कोट की विदाई", "Sheepskin Gift", "ल्हामो ने निक को भेड़ की खाल का गर्म कोट दिया—कैलाश पर्वत की बर्फीली यात्रा शुरू!", "Nick", "Lhamo", CartoonSetting.MOUNTAIN_LAB, CartoonMood.HAPPY, "Farewell Gift"),
                sc(2, "खतरनाक तिब्बती मस्टिफ और बर्फ", "Snowy Pass", "तेज़ तिब्बती कुत्ते गाड़ी के पीछे दौड़ रहे हैं और 5,210 मीटर ऊपर बर्फ ही बर्फ है!", "Nick", "Tsetan", CartoonSetting.MOUNTAIN_LAB, CartoonMood.DRAMATIC, "Mountain Pass"),
                sc(3, "डार्चेन में ठंड व तिब्बती इलाज", "High Altitude Cold", "ऊँचाई पर निक की नाक बंद हो गई—सेतन उन्हें तिब्बती डॉक्टर के पास ले गए जहाँ दवा ने कमाल किया!", "Nick", "Tibetan Doctor", CartoonSetting.CITY_MARKET, CartoonMood.THOUGHTFUL, "Medical Help"),
                sc(4, "नोरबू के साथ पवित्र कोरा!", "Meeting Norbu", "चाय की मेज़ पर मिले नोरबू! अब दोनों मित्र साथ मिलकर कैलाश परिक्रमा पूरी करेंगे!", "Norbu", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Pilgrim Partners")
            )
        ),
        ChapterRichSpec(
            chapterId = "c11_sn_2",
            detailedHindiTeaching = "मार्गा मिंको की 'The Address' युद्ध की त्रासदी और मानवीय स्वार्थ का गहरा चित्रण है। '46 Marconi Street', हरा स्वेटर, और जले दाग वाला मेज़पोश बोर्ड परीक्षा के प्रमुख बिंदु हैं।",
            paragraphs = listOf(
                p(1, "46 मार्कोनी स्ट्रीट पर ठंडा व्यवहार", "Visiting 46 Marconi Street after WWII, the narrator saw Mrs. Dorling wearing her mother's green cardigan yet pretending not to know her.", "युद्ध से लौटकर जब बेटी अपनी माँ की अमानत देखने गई, तो दरवाज़ा आधा खुलकर झटके से बंद हो गया।", "संकट काल में स्वार्थी लोग पहचानने से भी मुकर जाते हैं।"),
                p(2, "दूसरी यात्रा और अपनों की वस्तुओं से अजनबीपन", "Invited inside by Dorling's teenage daughter, she saw her family's silver and burn-marked woollen tablecloth arranged tastelessly.", "अपनी माँ के चाँदी के चम्मचों और कप-प्लेटों को बेढंगे घर में देख कर उसका मन भारी हो गया।", "जिनके लिए वस्तुएँ थीं, उनके बिना वे सिर्फ निर्जीव सामान रह जाती हैं।"),
                p(3, "पता भूल जाने का शांत फैसला", "Realizing the objects were severed from childhood memories and wouldn't fit her tiny rented room, she resolved to forget the address forever.", "उसने भारी मन से दरवाज़े से बाहर कदम रखा और तय किया कि नए जीवन के लिए इस पते को भूलना ही सही है।", "बीते दर्द से मुक्त होना ही मानसिक शांति का मार्ग है।")
            ),
            characters = listOf(
                ch("The Narrator", "कथावाचक (युवा यहूदी बेटी)", "युद्ध-पीड़ित संवेदनशील युवा", listOf("भावुक", "आत्मसम्मानी", "परिपक्व"), "अपनी माँ की चीज़ें देखकर भी वह लालच के बजाय आत्मसम्मान और नई शुरुआत को चुनती है।", "The narrator chooses emotional healing and dignity over reclaiming lifeless family antiques."),
                ch("Mrs. Dorling", "श्रीमती डोरलिंग", "अवसरवादी एवं स्वार्थी परिचित", listOf("लालची", "कठोर", "अहसानफरामोश"), "संकट के दिनों में सारा कीमती सामान ले जाकर वह युद्ध के बाद असली वारिस को दरवाज़े से लौटा देती है।", "Mrs. Dorling is opportunistic and callous, hoarding a vulnerable family's possessions.")
            ),
            cartoonScenes = listOf(
                sc(1, "युद्ध के दिनों में भारी सूटकेस", "War Crisis", "माँ अपनी परिचित डोरलिंग को विश्वास से चाँदी के बर्तन और यादगार सामान सौंप रही हैं।", "Mother", "Mrs. Dorling", CartoonSetting.HOME_GARDEN, CartoonMood.THOUGHTFUL, "Trust Given"),
                sc(2, "46 मार्कोनी स्ट्रीट पर दरवाज़ा बंद!", "Cold Rejection", "युद्ध के बाद बेटी पहुँची तो माँ का हरा स्वेटर पहने डोरलिंग ने पहचानने से मना कर दिया!", "Narrator", "Mrs. Dorling", CartoonSetting.CITY_MARKET, CartoonMood.DRAMATIC, "Locked Door"),
                sc(3, "अजनबी घर में माँ के चाँदी के बर्तन", "Painful Recognition", "मेज़पोश के किनारे जले निशान देख बेटी की आँखें नम हो गईं—सब सामान यहाँ सजा पड़ा है!", "Narrator", "Girl", CartoonSetting.ROYAL_PALACE, CartoonMood.THOUGHTFUL, "Old Memories"),
                sc(4, "पता भूलने का साहसी निर्णय", "Letting Go", "बेटी ने सामान वहीं छोड़ा और शांति से आगे बढ़ी—वस्तुओं से नहीं, प्रेम से जीवन बनता है!", "Narrator", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Peaceful Closure")
            )
        ),
        ChapterRichSpec(
            chapterId = "c11_sn_3",
            detailedHindiTeaching = "जे.बी. प्रीस्टली का यह लोकप्रिय नाटक बहुत मज़ेदार भी है और गंभीर सामाजिक संदेश भी देता है—हर गृहिणी माँ के काम को उतना ही सम्मान मिलना चाहिए जितना बाहर कमाने वालों को!",
            paragraphs = listOf(
                p(1, "सीधी माँ और स्वार्थी परिवार", "Mrs. Annie Pearson patiently served Doris, Cyril, and George while being treated as an unpaid servant.", "पूरा परिवार बाहर जाने की तैयारियाँ कर रहा है और कोई माँ से पूछता तक नहीं कि वह क्या चाहती हैं।", "अति विनम्रता कभी-कभी अपनों को भी लापरवाह बना देती है।"),
                p(2, "श्रीमती फिट्ज़गेराल्ड का जादू और आईना", "Switching personalities via a spell, bold Annie shocked Doris, Cyril, and George by refusing overtime work and demanding respect.", "चाय तैयार न पाकर और तीखे सच सुनकर डोरिस व जॉर्ज का सारा घमंड तुरंत उतर जाता है।", "अपने आत्मसम्मान के लिए दृढ़ता से खड़ा होना ज़रूरी है।"),
                p(3, "असली रूप में वापसी और खुशहाल शाम", "After swapping back, the humbled family eagerly played rummy together while helping Mrs. Pearson joyfully.", "जब असली एनी लौटती हैं तो डोरिस, सिरिल और जॉर्ज खुद डिनर बनाने और साथ खेल खेलने को तैयार हो जाते हैं!", "माँ का सम्मान ही घर को स्वर्ग बनाता है।")
            ),
            characters = listOf(
                ch("Mrs. Annie Pearson", "श्रीमती एनी पियर्सन", "स्नेही फिर भी आत्मसम्मानी माँ", listOf("दयालु", "परिश्रमी", "नव-आत्मविश्वासी"), "अंत में वे सीख जाती हैं कि परिवार को प्यार देने के साथ अपनी सीमाएँ व सम्मान बचाना भी ज़रूरी है।", "Annie learns to balance maternal love with healthy self-respect and firmness."),
                ch("Mrs. Fitzgerald", "श्रीमती फिट्ज़गेराल्ड", "साहसी व स्पष्टवादी पड़ोसी", listOf("निडर", "तेज़ दिमाग", "सच्ची सहेली"), "वे जादुई अदला-बदली से एनी के आलसी परिवार को जीवन भर का सबक सिखा देती हैं।", "Mrs. Fitzgerald is assertive, clever, and fiercely loyal to her mild neighbour.")
            ),
            cartoonScenes = listOf(
                sc(1, "थकी हुई माँ और बच्चों के हुक्म", "Endless Chores", "डोरिस को सिल्क ड्रेस प्रेस करानी है और सिरिल को चाय चाहिए—पर कोई माँ को धन्यवाद नहीं कहता!", "Annie", "Children", CartoonSetting.HOME_GARDEN, CartoonMood.THOUGHTFUL, "Unfair Burden"),
                sc(2, "श्रीमती फिट्ज़गेराल्ड का अनोखा मंत्र!", "Personality Swap", "आर्शादामा-अरशदांता! जादू से दोनों पड़ोसनों के व्यक्तित्व बदल गए—अब देखिए मज़ा!", "Fitzgerald", "Annie", CartoonSetting.HOME_GARDEN, CartoonMood.MYSTERY, "Magic Switch"),
                sc(3, "'अब मैं भी हफ्ते में 2 दिन छुट्टी लूँगी!'", "Bold Stand", "बॉस बनी माँ को देख जॉर्ज, डोरिस और सिरिल सन्न रह गए—सभी ने तुरंत माफी माँगी!", "Annie", "George", CartoonSetting.ROYAL_PALACE, CartoonMood.DRAMATIC, "Family Shocked"),
                sc(4, "साथ मिलकर खाना और रमी खेल!", "Respect Restored", "वाह! अब पूरा परिवार मिलकर खाना बना रहा है और माँ के साथ खुश होकर रमी खेल रहा है!", "Family", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Happy Harmony")
            )
        ),
        ChapterRichSpec(
            chapterId = "c11_sn_5",
            detailedHindiTeaching = "विक्रम सेठ की यह मज़ेदार कवितानुमा कहानी व्यंग्य की बेहतरीन मिसाल है। 'Just and Placid King', 'Bitter Melon', और 'Laissez Faire' से बोर्ड में रोचक प्रश्न आते हैं!",
            paragraphs = listOf(
                p(1, "नीचा मेहराब और टालमटोल की अदालत", "A low triumphal arch knocked off the 'just and placid' King's crown; blame shifted from workmen to builders, masons, and architect.", "सब अपनी गर्दन बचाने के लिए दूसरों पर दोष डालते रहे और बुद्धिमान वृद्ध ने खुद मेहराब को ही दोषी बता दिया।", "चाटुकार और भ्रष्ट तंत्र में कोई जिम्मेदारी नहीं लेता।"),
                p(2, "फंदे के नाप में राजा खुद फँसा!", "When the crowd demanded a hanging, only the tall King fitted the high noose—and was hanged by his own decree.", "जनता को शांत करने के चक्कर में राजा अपने ही बनाए बेतुके नियमों का शिकार होकर फांसी चढ़ गया!", "अंधी भीड़ और विवेकहीन कानून घातक होते हैं।"),
                p(3, "मूर्ख का फैसला और खरबूजा राजा", "Per custom, the first citizen through the gate—an idiot who only replied 'a melon'—crowned a melon as King!", "मंत्रियों ने खुशी-खुशी खरबूजे को सिंहासन पर बिठाया और जनता 'हमें क्या' कहकर शांति से जीने लगी!", "उदासीन नागरिक किसी भी बेतुकी सत्ता को स्वीकार कर लेते हैं।")
            ),
            characters = listOf(
                ch("The King", "शांत व तथाकथित न्यायप्रिय राजा", "कमज़ोर व विवेकहीन शासक", listOf("दिखावटी न्याय", "अदूरदर्शी", "भीड़ से डरने वाला"), "वह सोचने के बजाय भीड़ को खुश करने में लग जाता है और खुद फांसी का शिकार बन जाता है।", "The King confuses impulsive decrees with justice and falls victim to his own foolishness.")
            ),
            cartoonScenes = listOf(
                sc(1, "धड़ाम! राजा का मुकुट गिरा!", "The Low Arch", "अरे! नया बनाया गया मेहराब इतना नीचा निकला कि राजा का मुकुट नीचे गिर पड़ा—राजा लाल हो गए!", "King", "Ministers", CartoonSetting.ROYAL_PALACE, CartoonMood.DRAMATIC, "Crown Knocked"),
                sc(2, "सब एक-दूसरे पर दोष टाल रहे हैं!", "Blame Game", "मजदूर बोला—ईंट गलत थी! मेसन बोला—वास्तुकार दोषी है! और वास्तुकार बोला—महाराज खुद दोषी हैं!", "Architect", "King", CartoonSetting.ROYAL_PALACE, CartoonMood.MYSTERY, "Passing Blame"),
                sc(3, "फंदे में केवल राजा ही फिट बैठा!", "Royal Noose", "हाहा! किसी के गले में फंदा नहीं आया, तो नियम बचाने के लिए खुद राजा को ही फांसी दे दी गई!", "King", "Crowd", CartoonSetting.CITY_MARKET, CartoonMood.THOUGHTFUL, "Absurd Justice"),
                sc(4, "महारानी नहीं—खरबूजा महाराज की जय!", "King Melon", "पागल ने कहा 'खरबूजा'! अब सिंहासन पर खरबूजा बैठा है—सोचिए, जागरूक जनता कितनी ज़रूरी है!", "Melon King", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Satire Moral")
            )
        )
    ).associateBy { it.chapterId }
}
