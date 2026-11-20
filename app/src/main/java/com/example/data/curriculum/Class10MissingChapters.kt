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

object Class10MissingChapters {

    val chapters: List<Chapter> = listOf(
        // --- FIRST FLIGHT PROSE (4 missing) ---
        makeProseChapter(
            id = "c10_ff_5",
            classLevel = 10,
            bookName = "First Flight",
            chapterNumber = 5,
            category = "Prose",
            title = "Glimpses of India",
            titleHi = "भारत की झलकियाँ",
            author = "Lucio Rodrigues, Lokesh Abrol, Arup Kumar Datta",
            summaryEn = "A rich three-part portrait of India: Goa's nostalgic Portuguese 'pader' bakers, Coorg's misty coffee hills and brave Kodavu heritage, and Assam's sprawling lush tea estates explored by Pranjol and Rajvir.",
            summaryHi = "तीन भागों में भारत की विविधता की सुंदर झलक: गोवा के पारंपरिक बेकर (पैडर), कर्नाटक के कुर्ग (कोडागु) के सुगंधित कॉफी बागान व वीर निवासी, और असम के हरे-भरे चाय बागानों की रोचक कहानी।",
            hindiExplanation = "भाग 1 'ए बेकर फ्रॉम गोवा' में गोवा के पुराने पुर्तगाली बेकर (pader) बांस की खट-खट आवाज़ के साथ ब्रेड-बैंगल व बोल लाते थे। भाग 2 'कुर्ग' कर्नाटक का सबसे छोटा जिला है जहाँ सदाबहार वन, मसाले, कॉफी, कावेरी नदी और मार्शल कोडावु लोग हैं। भाग 3 'टी फ्रॉम असम' में राजवीर और प्रांजोल ट्रेन से असम की चाय की हरियाली देखते हैं और चीनी सम्राट व बोधिधर्म से जुड़ी चाय की कथाएँ साझा करते हैं।",
            themeEn = "India's regional diversity unites culinary traditions, ecological richness, and proud heritage.",
            themeHi = "भारत की सांस्कृतिक, भौगोलिक और परंपरागत विविधता देश की सबसे बड़ी शक्ति और सुंदरता है।",
            messageHi = "अपनी स्थानीय परंपराओं, प्रकृति और इतिहास पर गर्व करें तथा सीखने की जिज्ञासा बनाए रखें।",
            words = listOf(
                w("Pader", "noun", "Traditional bread-baker in Goa", "गोवा का पारंपरिक बेकर", "Even today the baker is known as a pader in Goa."),
                w("Kabai", "noun", "Single-piece knee-length frock worn by bakers", "बेकर्स का पारंपरिक लंबा कुर्ता", "Bakers wore the peculiar dress called kabai."),
                w("Hospitality", "noun", "Friendly welcome to guests", "अतिथि सत्कार", "Coorg people are famous for tales of valour and hospitality."),
                w("Pruning", "noun", "Trimming tea bushes cleanly", "छँटाई (चाय की झाड़ियों की)", "The second-flush tea sprouting period yields the best tea."),
                w("Nostalgically", "adv", "With fond longing for the past", "पुरानी यादों के साथ", "Elders reminisce nostalgically about Portuguese bread.")
            ),
            matchPairs = listOf(
                MatchPair("Pader & Bol", "Goan baking tradition"),
                MatchPair("Kuppia", "Traditional black coat of Kodavus"),
                MatchPair("Kaveri River", "Flows from Coorg hills"),
                MatchPair("Assam", "Largest concentration of tea plantations")
            ),
            extract1 = ExtractSpec(
                extractText = "“Our elders are often heard reminiscing nostalgically about those good old Portuguese days, the Portuguese and their famous loaves of bread.”",
                promptEn = "Why was the baker considered an essential part of every Goan village occasion?",
                promptHi = "गोवा के प्रत्येक उत्सव में बेकर (पैडर) को आवश्यक क्यों माना जाता था?",
                answerEn = "Marriage gifts were meaningless without sweet bread 'bol', sandwiches were made for a daughter's engagement, and cakes/bolinhas were must-haves at festivals.",
                answerHi = "विवाह में मीठी ब्रेड 'बोल', सगाई में सैंडविच और त्योहारों पर केक व बोलिन्हास बेकर के बिना अधूरे थे।"
            ),
            extract2 = ExtractSpec(
                extractText = "“It was a magnificent view. Against the backdrop of densely wooded hills a sea of tea bushes stretched as far as the eye could see.”",
                promptEn = "Who admired this tea garden view on the train to Mariani Junction?",
                promptHi = "मरियानी जंक्शन जाते समय ट्रेन से यह सुंदर चाय बागान का दृश्य किसने देखा?",
                answerEn = "Rajvir, who was visiting his classmate Pranjol's father's Dhekiabari Tea Estate in Assam.",
                answerHi = "राजवीर ने, जो अपने मित्र प्रांजोल के पिता के असम स्थित ढेकियाबारी चाय बागान जा रहा था।"
            ),
            pyqPromptEn = "Describe the wildlife and adventure attractions of Coorg mentioned by Lokesh Abrol.",
            pyqPromptHi = "लोकेश अब्रोल द्वारा वर्णित कुर्ग (Coorg) के वन्यजीव व साहसिक आकर्षणों का वर्णन कीजिए।",
            pyqAnswerEn = "Coorg offers evergreen rainforests, mahaseer fish in the Kaveri, kingfishers, squirrels, elephants, Brahmagiri hills, Nisargadhama island, Bylakuppe monastery, river rafting, and rock climbing.",
            pyqAnswerHi = "कुर्ग में वर्षावन, कावेरी नदी में महासीर मछली, किंगफिशर, हाथी, ब्रह्मगिरि पहाड़ियाँ, बायलाकुप्पे मठ तथा रिवर राफ्टिंग व ट्रैकिंग प्रसिद्ध हैं।",
            mcq1Prompt = "What are bakers traditionally called in Goa?",
            mcq1Options = listOf("Kuppia", "Pader", "Bodhidharma", "Bolinhas"),
            mcq1Correct = 1,
            mcq1Hi = "गोवा में पारंपरिक बेकर को आज भी 'पैडर' (Pader) कहा जाता है।",
            mcq2Prompt = "Which general of the Indian Army belonged to Coorg?",
            mcq2Options = listOf("General Cariappa", "General Sam Manekshaw", "General Thimayya", "General Rawat"),
            mcq2Correct = 0,
            mcq2Hi = "भारतीय थल सेना के प्रथम प्रमुख जनरल के.एम. करिअप्पा कुर्ग (कोडागु) से थे।"
        ),
        makeProseChapter(
            id = "c10_ff_6",
            classLevel = 10,
            bookName = "First Flight",
            chapterNumber = 6,
            category = "Prose",
            title = "Mijbil the Otter",
            titleHi = "मिजबिल ऊदबिलाव",
            author = "Gavin Maxwell",
            summaryEn = "After his dog Jonnie dies, Gavin Maxwell adopts an otter in Iraq's Basra named Mijbil. The playful otter loves splashing water, inventing marble games, and creates hilarious chaos on a flight back to London.",
            summaryHi = "अपने कुत्ते की मृत्यु के बाद लेखक गेविन मैक्सवेल इराक के बसरा से एक ऊदबिलाव (Otter) 'मिजबिल' को पालते हैं। पानी से खेलने और कंचों से करतब करने वाले मिजबिल के साथ लंदन की हवाई यात्रा और दैनिक जीवन बेहद मज़ेदार व स्नेहपूर्ण बन जाता है।",
            hindiExplanation = "इराक के दक्षिणी दलदल से लेखक को एक अनोखी प्रजाति का ऊदबिलाव मिला जिसे वैज्ञानिकों ने *Lutrogale perspicillata maxwelli* नाम दिया। पहले दिन संकोची रहने के बाद मिजबिल बाथरूम में जाकर नल खुद खोलना और पानी उछालना सीख गया। हवाई जहाज़ में डिब्बे से निकलकर उसने यात्रियों को चौंकाया, पर एक दयालु एयर होस्टेस ने मदद की। लंदन में लोग उसे बेबी सील, गिलहरी या वॉलरस समझते थे!",
            themeEn = "Trust, patience, and affection create an unforgettable bond between humans and wild creatures.",
            themeHi = "धैर्य, करुणा और देखभाल से मनुष्य और जंगली जीवों के बीच अद्भुत स्नेह व विश्वास विकसित होता है।",
            messageHi = "पशु-पक्षियों की स्वाभाविक आदतों को समझकर उनसे मित्रता करना जीवन को आनंद से भर देता है।",
            words = listOf(
                w("Otter", "noun", "Semi-aquatic playful mammal", "ऊदबिलाव", "Mijbil was a rare Iraqi marsh otter."),
                w("Thraldom", "noun", "State of being fascinated or bound", "मोह / वशीभूत होना", "He remained in the thraldom of keeping a pet."),
                w("Squat", "adj", "Short and wide", "ठिगना / छोटा", "Basra Consul's mail arrived late in squat bundles."),
                w("Ricochetted", "verb", "Bounced rapidly off a surface", "टकराकर उछलना", "Ping-pong balls ricochetted across the suitcase."),
                w("Barrage", "noun", "Continuous rapid outpouring", "बौछार (सवालों की)", "Maxwell faced a barrage of questions about Mijbil.")
            ),
            matchPairs = listOf(
                MatchPair("Basra, Iraq", "Where Maxwell got Mijbil"),
                MatchPair("Lutrogale... maxwelli", "Scientific name given to race"),
                MatchPair("Ping-pong ball", "Favourite suitcase game toy"),
                MatchPair("Air hostess", "Kind queen of Maxwell's heart")
            ),
            extract1 = ExtractSpec(
                extractText = "“She was the very queen of her kind. She suggested that I might prefer to have my pet on my knee.”",
                promptEn = "Who is 'she' and why did the narrator praise her?",
                promptHi = "यहाँ 'she' कौन हैं और लेखक ने उनकी इतनी प्रशंसा क्यों की?",
                answerEn = "The British Airline air hostess who showed extraordinary empathy when frightened Mijbil escaped inside the aircraft.",
                answerHi = "वह दयालु एयर होस्टेस थी जिसने घायल व डरे मिजबिल के समय लेखक का पूरा साथ दिया।"
            ),
            extract2 = ExtractSpec(
                extractText = "“For the first twenty-four hours Mijbil was neither hostile nor friendly; he was simply aloof and indifferent.”",
                promptEn = "How did Mijbil's behaviour change after the first night?",
                promptHi = "पहली रात के बाद मिजबिल के व्यवहार में क्या बदलाव आया?",
                answerEn = "He came onto Maxwell's bed, slept comfortably inside the crook of his knees, and quickly became playful and deeply attached.",
                answerHi = "वह लेखक के बिस्तर पर घुटनों के पास सो गया और जल्दी ही बेहद चंचल व घनिष्ठ मित्र बन गया।"
            ),
            pyqPromptEn = "What compulsive habits did Mijbil develop during walks on London streets?",
            pyqPromptHi = "लंदन की सड़कों पर टहलते समय मिजबिल ने कौन-सी रोचक आदतें बना ली थीं?",
            pyqAnswerEn = "Mijbil always placed his toys precisely, hopped only on the low outer wall of a primary school, and loved running all thirty yards along its two-foot-high edge.",
            pyqAnswerHi = "वह हमेशा प्राइमरी स्कूल की दो फीट ऊँची बाहरी दीवार पर कूदकर पूरे 30 गज़ दौड़ता था।",
            mcq1Prompt = "Where did Gavin Maxwell decide to adopt an otter instead of a dog?",
            mcq1Options = listOf("Camusfearna", "Basra (Iraq)", "London", "Paris"),
            mcq1Correct = 1,
            mcq1Hi = "लेखक ने 1956 में दक्षिणी इराक (बसरा की यात्रा) के समय ऊदबिलाव पालने का निश्चय किया।",
            mcq2Prompt = "Which household fixture did Mijbil amaze Maxwell by turning on himself?",
            mcq2Options = listOf("Television switch", "Chromium bathroom tap", "Kitchen gas", "Door bell"),
            mcq2Correct = 1,
            mcq2Hi = "मिजबिल ने अपने पंजों से बाथरूम का क्रोमियम नल खुद घुमाकर पानी चला लिया था।"
        ),
        makeProseChapter(
            id = "c10_ff_7",
            classLevel = 10,
            bookName = "First Flight",
            chapterNumber = 7,
            category = "Prose",
            title = "Madam Rides the Bus",
            titleHi = "मैडम ने बस की सवारी की",
            author = "Vallikkannan",
            summaryEn = "Eight-year-old curious Valli carefully saves sixty paise over months to take her first solo bus ride to town and back. Thrilled by swaying fields and a comical running cow, she grows deeply thoughtful upon seeing the same cow lying dead on the return trip.",
            summaryHi = "आठ साल की जिज्ञासु वल्ली महीनों तक पैसे बचाकर (60 पैसे) अकेले शहर तक बस यात्रा करती है। रास्ते में हरी खेत, नहर और दौड़ती गाय देखकर वह खिलखिलाती है, पर लौटते समय उसी गाय को मरा देख जीवन-मृत्यु के गंभीर सत्य से परिचित होती है।",
            hindiExplanation = "वल्लीअम्मई (वल्ली) आठ वर्ष की बुद्धिमान बालिका थी जिसका प्रिय शौक दरवाजे पर खड़े होकर सड़क और शहर जाने वाली बस देखना था। उसने हर जानकारी जुटाई कि किराया 30 पैसे एक तरफ है और सफर 45 मिनट का। पेपरमिंट व खिलौने छोड़कर उसने 60 पैसे बचाए और कंडक्टर से आत्मविश्वास से बोली—'मुझे मैडम मत कहो, मुझे सफर करना है!' लौटते समय मरी हुई गाय देखकर उसकी सारी खुशी गंभीर चिंतन में बदल गई।",
            themeEn = "Curiosity, careful planning, and a child's sudden encounter with life's joys and mortality.",
            themeHi = "बाल जिज्ञासा, आत्मनिर्भर योजना और पहली स्वतंत्र यात्रा में जीवन के सुख व मृत्यु का गंभीर बोध।",
            messageHi = "सही योजना और आत्मविश्वास से बच्चे भी बड़े अनुभव पा सकते हैं, पर सुरक्षा व बड़ों का मार्गदर्शन भी आवश्यक है।",
            words = listOf(
                w("Wistfully", "adv", "With a feeling of longing", "ललक / चाहत भरी नज़र से", "Valli stared wistfully at passengers alighting the bus."),
                w("Slack time", "noun", "Quiet hours with fewer passengers", "कम भीड़ वाला समय", "Only six or seven passengers travelled during slack afternoon hours."),
                w("Haughty", "adj", "Proudly distant or arrogant", "अभिमानी / अकड़ वाला", "She answered the friendly conductor with a haughty 'Don't call me madam!'"),
                w("Repulsive", "adj", "Disgusting and unpleasant", "घृणास्पद / अप्रिय", "The elderly woman's huge earlobes and betel juice looked repulsive to Valli."),
                w("Thriftily", "adv", "Using money carefully and saving", "किफायत / बचत के साथ", "Valli thriftily saved every stray coin she received.")
            ),
            matchPairs = listOf(
                MatchPair("Valli (Valliammai)", "8-year-old determined traveller"),
                MatchPair("30 paise", "One-way bus fare to town"),
                MatchPair("Jolly conductor", "Nicknamed her 'Fine Madam'"),
                MatchPair("Dead young cow", "Turned joy into solemn reality")
            ),
            extract1 = ExtractSpec(
                extractText = "“There's nobody here who's a child. I've paid my thirty paise like everyone else.”",
                promptEn = "Why did Valli insist on not being treated as a helpless child?",
                promptHi = "वल्ली ने खुद को छोटा बच्चा न मानने की ज़िद क्यों की?",
                answerEn = "Because she had independently saved the full fare, planned the timetable, and paid for her own seat like any adult.",
                answerHi = "क्योंकि उसने अपने पैसों से पूरा 30 पैसे का टिकट खरीदा था और खुद को आत्मनिर्भर यात्री समझती थी।"
            ),
            extract2 = ExtractSpec(
                extractText = "“The memory of the dead cow haunted her, dampening her enthusiasm.”",
                promptEn = "How did Valli react on seeing the cow lying dead by the roadside?",
                promptHi = "सड़क किनारे मरी हुई गाय को देखकर वल्ली पर क्या प्रभाव पड़ा?",
                answerEn = "Minutes earlier the cow seemed full of life and funny; seeing it lifeless shocked Valli and she refused to look out the window again.",
                answerHi = "कुछ देर पहले जो गाय उछल रही थी उसे निष्प्राण देखकर वल्ली स्तब्ध और उदास हो गई।"
            ),
            pyqPromptEn = "How did Valli manage to save sixty paise for her bus journey?",
            pyqPromptHi = "वल्ली ने बस यात्रा के लिए 60 पैसे किस प्रकार बचाए?",
            pyqAnswerEn = "She thriftily saved every stray coin that came her way, resisted buying peppermints, toys, balloons, and even skipped riding the merry-go-round at the village fair.",
            pyqAnswerHi = "उसने हर मिले सिक्के को बचाया तथा पेपरमिंट, खिलौने, गुब्बारे और मेले के झूले तक छोड़ दिए।",
            mcq1Prompt = "How much was the total bus fare for Valli's two-way trip?",
            mcq1Options = listOf("30 paise", "60 paise", "45 paise", "One rupee"),
            mcq1Correct = 1,
            mcq1Hi = "एक तरफ का किराया 30 पैसे था, इसलिए आने-जाने का कुल किराया 60 पैसे (30+30) था।",
            mcq2Prompt = "What free treat did the kind conductor offer Valli in town?",
            mcq2Options = listOf("A cold drink", "An ice cream", "Sweets", "Story books"),
            mcq2Correct = 0,
            mcq2Hi = "दयालु कंडक्टर ने उसे मुफ्त में कोल्ड ड्रिंक (Cold drink) पिलाने की पेशकश की, जिसे स्वाभिमानी वल्ली ने मना कर दिया।"
        ),
        makeProseChapter(
            id = "c10_ff_9",
            classLevel = 10,
            bookName = "First Flight",
            chapterNumber = 9,
            category = "Prose",
            title = "The Proposal",
            titleHi = "विवाह का प्रस्ताव",
            author = "Anton Chekhov",
            summaryEn = "Anton Chekhov's hilarious one-act farce shows wealthy Russian neighbours Lomov and Natalya constantly quarrelling over Oxen Meadows and hunting dogs (Guess vs Squeezer) even while Lomov tries to propose marriage.",
            summaryHi = "एंटन चेखव का यह प्रसिद्ध हास्य नाटक दिखाता है कि कैसे धनी रूसी पड़ोसी लोमोव और नतालिया शादी का प्रस्ताव रखने के बजाय 'ऑक्सेन मीडोज़' ज़मीन और अपने शिकारी कुत्तों (गेस बनाम स्क्वीज़र) को लेकर मूर्खतापूर्ण झगड़ा करते हैं!",
            hindiExplanation = "35 वर्षीय ज़मींदार इवान लोमोव अपने पड़ोसी स्टीफन चुबुकोव की 25 वर्षीय बेटी नतालिया से विवाह का प्रस्ताव लेकर आते हैं। पर बात शुरू होने से पहले ही वे 'ऑक्सेन मीडोज़' के मालिकाना हक पर लड़ पड़ते हैं। चुबुकोव भी शामिल होकर लोमोव को भगा देता है। जब नतालिया को पता चलता है कि लोमोव शादी का प्रस्ताव लाया था, वह उसे वापस बुलाती है—पर तुरंत फिर कुत्तों (गेस और स्क्वीज़र) पर बहस शुरू हो जाती है! लोमोव बेहोश हो जाता है और चुबुकोव झटपट दोनों का हाथ थमाकर शादी करा देता है।",
            themeEn = "Satire on wealthy landowners who value petty pride, property, and trivial arguments over harmony.",
            themeHi = "तथाकथित संपन्न लोगों के छोटे अहम, संपत्ति-मोह और हास्यास्पद झगड़ों पर तीखा व्यंग्य।",
            messageHi = "संबंधों को मधुर बनाए रखने के लिए व्यर्थ के अहंकार और तुच्छ विवादों से बचना चाहिए।",
            words = listOf(
                w("Palpitations", "noun", "Rapid irregular heartbeat due to anxiety", "दिल की तेज़ धड़कन", "Nervous Lomov suffered frequent palpitations."),
                w("Impudence", "noun", "Rude disrespect and arrogance", "गुस्ताखी / धृष्टता", "Natalya accused Lomov of impudence regarding the land."),
                w("Oxen Meadows", "noun", "Disputed strip of grassland", "बैलों की चरागाह भूमि", "They argued endlessly over who owned Oxen Meadows."),
                w("Pedigree", "noun", "Recorded purebred ancestry of an animal", "उच्च नस्ल / वंशावली", "Lomov boasted that Guess was a thoroughbred dog."),
                w("Carcass", "noun", "Dead body of an animal", "मृत पशु शरीर (तंज में)", "Chubukov insulted Lomov's age and temperament.")
            ),
            matchPairs = listOf(
                MatchPair("Ivan Lomov", "Nervous 35-year-old hypochondriac"),
                MatchPair("Natalya Stepanovna", "Quarrelsome house-proud 25-year-old"),
                MatchPair("Oxen Meadows", "Five-dessiatins disputed land"),
                MatchPair("Guess vs Squeezer", "Hunting dog superiority fight")
            ),
            extract1 = ExtractSpec(
                extractText = "“Please don't shout! You can shout yourself hoarse in your own house, but here I must ask you to restrain yourself!”",
                promptEn = "Who speaks these lines and over what issue are they shouting?",
                promptHi = "ये पंक्तियाँ किसने कहीं और किस विषय पर झगड़ा हो रहा था?",
                answerEn = "Lomov says this to Natalya during their heated argument over whether Lomov's aunt's grandmother or Natalya's family owned Oxen Meadows.",
                answerHi = "लोमोव ने नतालिया से कहा जब दोनों 'ऑक्सेन मीडोज़' के मालिकाना हक को लेकर लड़ रहे थे।"
            ),
            extract2 = ExtractSpec(
                extractText = "“My dear fellow, why are you so formal in your get-up? Evening dress, gloves, and so on.”",
                promptEn = "Why was Chubukov surprised at Lomov's formal attire initially?",
                promptHi = "चुबुकोव शुरू में लोमोव की औपचारिक वेशभूषा देखकर हैरान क्यों हुए?",
                answerEn = "Seeing Lomov in an evening coat and white gloves, Chubukov suspected he had come to borrow money.",
                answerHi = "शाम की पोशाक और सफेद दस्ताने देख चुबुकोव को लगा कि लोमोव शायद पैसे उधार माँगने आया है।"
            ),
            pyqPromptEn = "Why did Natalya desperately ask her father to bring Lomov back after driving him out?",
            pyqPromptHi = "लोमोव को घर से निकालने के तुरंत बाद नतालिया ने पिता से उसे वापस बुलाने की गुहार क्यों लगाई?",
            pyqAnswerEn = "When Chubukov revealed Lomov had actually come to propose marriage to her, Natalya grew hysterical and insisted on calling him back immediately.",
            pyqAnswerHi = "जब चुबुकोव ने बताया कि लोमोव उससे शादी का प्रस्ताव लेकर आया था, तो वह रोकर उसे तुरंत वापस बुलाने लगी।",
            mcq1Prompt = "Which two topics caused fierce arguments between Lomov and Natalya?",
            mcq1Options = listOf("Weather and taxes", "Oxen Meadows and hunting dogs", "Wedding music and food", "Books and paintings"),
            mcq1Correct = 1,
            mcq1Hi = "दोनों के बीच पहला झगड़ा 'ऑक्सेन मीडोज़' ज़मीन पर और दूसरा 'गेस बनाम स्क्वीज़र' कुत्तों पर हुआ।",
            mcq2Prompt = "What was the name of Natalya's hunting dog bought for 85 roubles?",
            mcq2Options = listOf("Guess", "Squeezer", "Tricki", "Mijbil"),
            mcq2Correct = 1,
            mcq2Hi = "नतालिया के कुत्ते का नाम 'स्क्वीज़र' (Squeezer) था और लोमोव के कुत्ते का नाम 'गेस' (Guess) था।"
        ),

        // --- FOOTPRINTS WITHOUT FEET SUPPLEMENTARY (5 missing) ---
        makeProseChapter(
            id = "c10_fp_3",
            classLevel = 10,
            bookName = "Footprints Without Feet",
            chapterNumber = 3,
            category = "Supplementary",
            title = "The Midnight Visitor",
            titleHi = "आधी रात का मेहमान",
            author = "Robert Arthur",
            summaryEn = "Secret agent Ausable looks fat and unromantic, disappointing young writer Fowler—until armed rival Max breaks in to steal a missile report. Ausable calmly invents a non-existent balcony and knocks Max out without firing a shot.",
            summaryHi = "जासूस ऑसेबल मोटे और साधारण दिखते हैं जिससे युवा लेखक फाउलर निराश हो जाता है। तभी बंदूक लिए प्रतिद्वंद्वी मैक्स मिसाइल रिपोर्ट चुराने कमरे में घुसता है। ऑसेबल बिना हथियार के अपनी हाजिरजवाबी से 'नकली बालकनी' और पुलिस की कहानी गढ़कर मैक्स को चकमा दे देते हैं!",
            hindiExplanation = "रॉबर्ट आर्थर की यह रोमांचक कहानी बताती है कि असली जासूस फिल्मों की तरह पिस्तौल या ग्लैमर पर नहीं, बल्कि ठंडे दिमाग पर भरोसा करता है। छठी मंजिल के कमरे में जब मैक्स बंदूक तानता है, तो ऑसेबल शिकायत करते हैं कि नीचे की बालकनी से कोई दूसरी बार घुस आया। तभी दरवाजे पर वेटर हेनरी दस्तक देता है! ऑसेबल कहते हैं—पुलिस आ गई! डरकर मैक्स नकली बालकनी पर कूद जाता है और छठी मंजिल से नीचे गिर पड़ता है।",
            themeEn = "Presence of mind, psychological wit, and calm observation defeat armed brute force.",
            themeHi = "संकट के समय शांत दिमाग, सूझबूझ और मानसिक चतुरता बंदूक की ताकत को भी हरा देती है।",
            messageHi = "बाहरी दिखावे से किसी की प्रतिभा को न आँकें; मुश्किल घड़ी में शांत रहकर बुद्धि से काम लें।",
            words = listOf(
                w("Authentic", "adj", "Genuine and real", "प्रामाणिक / असली", "Fowler wanted an authentic spy adventure."),
                w("Espionage", "noun", "The practice of spying", "जासूसी", "Ausable worked quietly in espionage."),
                w("Wheezed", "verb", "Breathed with a whistling sound", "हाँफकर साँस लेना", "Ausable wheezed gently as he walked upstairs."),
                w("Passkey", "noun", "A master key opening locked rooms", "मास्टर चाबी", "Max entered the room using a passkey."),
                w("Exasperated", "adj", "Intensely irritated or annoyed", "चिढ़ा / झुंझलाया हुआ", "Ausable sounded exasperated while inventing the balcony story.")
            ),
            matchPairs = listOf(
                MatchPair("Ausable", "Clever quick-witted secret agent"),
                MatchPair("Fowler", "Disappointed young writer"),
                MatchPair("Max", "Armed rival tricked by balcony lie"),
                MatchPair("Henry", "Waiter who knocked with drinks")
            ),
            extract1 = ExtractSpec(
                extractText = "“You are disappointed. You were told that I was a secret agent, a spy, dealing in espionage and danger.”",
                promptEn = "Why was Fowler initially disappointed on meeting Ausable?",
                promptHi = "ऑसेबल से पहली बार मिलकर युवा लेखक फाउलर निराश क्यों हुआ?",
                answerEn = "Ausable lived in a gloomy sixth-floor French hotel room, was very fat, spoke French with an American accent, and received phone calls instead of secret messages.",
                answerHi = "क्योंकि ऑसेबल बहुत मोटे थे, साधारण छोटे कमरे में रहते थे और फिल्मी जासूसों जैसे आकर्षक नहीं दिखते थे।"
            ),
            extract2 = ExtractSpec(
                extractText = "“No, he won't return. You see, my young friend, there is no balcony.”",
                promptEn = "How did Ausable rid himself of Max cleanly?",
                promptHi = "ऑसेबल ने मैक्स से हमेशा के लिए छुटकारा कैसे पाया?",
                answerEn = "Thinking waiter Henry was police knocking at the door, Max swung over the window onto the imaginary balcony and fell six stories down.",
                answerHi = "दरवाजे पर दस्तक को पुलिस समझ मैक्स काल्पनिक बालकनी की ओर कूदा और छठी मंजिल से गिर पड़ा।"
            ),
            pyqPromptEn = "Why did Max believe Ausable's story about a balcony outside the window?",
            pyqPromptHi = "मैक्स ने खिड़की के बाहर बालकनी होने की ऑसेबल की बात पर विश्वास क्यों कर लिया?",
            pyqAnswerEn = "Ausable narrated it casually in an irritated tone blaming the hotel management—so convincing and natural that anxious Max didn't verify before jumping.",
            pyqAnswerHi = "ऑसेबल ने होटल प्रबंधन पर झुंझलाते हुए इतनी स्वाभाविकता से झूठ बोला कि हड़बड़ी में मैक्स ने जाँच भी न की।",
            mcq1Prompt = "Who actually knocked on Ausable's door at the climax?",
            mcq1Options = listOf("Armed police", "Henry the waiter with drinks", "Max's partner", "Hotel manager"),
            mcq1Correct = 1,
            mcq1Hi = "दरअसल होटल का वेटर हेनरी ऑसेबल द्वारा मँगवाई गई ड्रिंक्स लेकर आया था।",
            mcq2Prompt = "On which floor was Ausable's hotel room located?",
            mcq2Options = listOf("Ground floor", "Sixth and top floor", "Second floor", "Basement"),
            mcq2Correct = 1,
            mcq2Hi = "ऑसेबल का कमरा होटल की छठी और सबसे ऊपरी मंजिल (sixth and top floor) पर था।"
        ),
        makeProseChapter(
            id = "c10_fp_4",
            classLevel = 10,
            bookName = "Footprints Without Feet",
            chapterNumber = 4,
            category = "Supplementary",
            title = "A Question of Trust",
            titleHi = "विश्वास का प्रश्न",
            author = "Victor Canning",
            summaryEn = "Gentleman thief Horace Danby robs one safe per year to buy rare books. While robbing Shotover Grange, a clever young lady posing as the house owner tricks him into opening the safe without gloves—landing Horace in jail while she escapes with the jewels.",
            summaryHi = "ईमानदार दिखने वाला चोर होरेस डैनबी दुर्लभ किताबें खरीदने के लिए साल में एक बार तिजोरी लूटता है। शॉटओवर ग्रेंज में चोरी करते समय खुद को घर की मालकिन बताने वाली एक शातिर युवा चोरनी उससे बिना दस्ताने तिजोरी खुलवाकर गहने ले उड़ती है, और उँगलियों के निशान से होरेस जेल चला जाता है!",
            hindiExplanation = "पचास वर्षीय होरेस डैनबी ताले बनाने का काम करता था और हे-फीवर (फूलों से एलर्जी) से पीड़ित था। उसने दो हफ्ते तक शॉटओवर ग्रेंज की रेकी की, पर जब वह तिजोरी के पास पहुँचा तो लाल ड्रेस में एक युवती ने खुद को मालकिन बताकर उसे फँसा दिया। होरेस अपनी उँगलियों के निशान तिजोरी पर छोड़कर चला आया। दो दिन बाद पुलिस ने उसे पकड़ लिया और वह 'चोरों में ईमानदारी' (honour among thieves) की बात पर नाराज़ होता रहा!",
            themeEn = "Greed and overconfidence invite betrayal; even criminals cannot trust fellow criminals.",
            themeHi = "अपराध और अति-आत्मविश्वास अंततः पतन लाते हैं; गलत रास्ते पर किसी का भरोसा स्थायी नहीं होता।",
            messageHi = "सही और ईमानदार जीवन चुनें; छोटा हो या बड़ा, कोई भी अपराध आखिर पकड़ा ही जाता है।",
            words = listOf(
                w("Hay fever", "noun", "Allergy to pollen causing sneezing", "परागकणों से होने वाली एलर्जी", "The bowl of flowers gave Horace severe hay fever."),
                w("Robbery", "noun", "Stealing property unlawfully", "चोरी / डकैती", "Horace planned only one robbery a year."),
                w("Deceived", "verb", "Misled someone by lying", "धोखा दिया", "The lady in red smoothly deceived Horace."),
                w("Grange", "noun", "A large country house with farm buildings", "बड़ा ग्रामीण बंगला", "Horace targeted Shotover Grange in July."),
                w("Honour among thieves", "phrase", "Code of loyalty supposedly shared by criminals", "चोरों के बीच का कथित विश्वास", "Horace grew angry whenever someone spoke of honour among thieves.")
            ),
            matchPairs = listOf(
                MatchPair("Horace Danby", "Lockmaker stealing for rare books"),
                MatchPair("Shotover Grange", "Mansion with 15,000-pound jewels"),
                MatchPair("Sherry", "Pet dog who wagged tail calmly"),
                MatchPair("Lady in Red", "True master thief who framed Horace")
            ),
            extract1 = ExtractSpec(
                extractText = "“You'll let me go, and forget you ever saw me? My dear, I am not afraid of prison!”",
                promptEn = "On what condition did the young woman promise not to report Horace?",
                promptHi = "लाल कपड़े वाली युवती ने होरेस को पुलिस को न सौंपने की क्या शर्त रखी?",
                answerEn = "She pretended she had forgotten the safe's combination number and needed jewels for a party tonight—asking Horace to break open the safe for her.",
                answerHi = "उसने नाटक किया कि वह तिजोरी का नंबर भूल गई है और रात की पार्टी के लिए गहने निकालने हेतु होरेस से तिजोरी खुलवा ली।"
            ),
            extract2 = ExtractSpec(
                extractText = "“He is now the assistant librarian in the prison.”",
                promptEn = "Why was Horace arrested despite returning home empty-handed?",
                promptHi = "खाली हाथ घर लौटने के बाद भी पुलिस ने होरेस को क्यों गिरफ्तार कर लिया?",
                answerEn = "To hand her his cigarette lighter, Horace took off his gloves and left his fingerprints all over the safe.",
                answerHi = "सिगरेट लाइटर देते समय उसने दस्ताने उतार दिए थे, जिससे तिजोरी पर उसकी उँगलियों के निशान छूट गए।"
            ),
            pyqPromptEn = "Was Horace Danby a typical ruthless criminal? Why did he rob?",
            pyqPromptHi = "क्या होरेस डैनबी एक सामान्य क्रूर अपराधी था? वह चोरी क्यों करता था?",
            pyqAnswerEn = "Horace was otherwise respected and harmless; he robbed one rich safe a year secretly only to buy expensive, rare books through an agent.",
            pyqAnswerHi = "वह हिंसा नहीं करता था; वह केवल अपनी महँगी और दुर्लभ किताबें खरीदने के शौक के लिए साल में एक बार चोरी करता था।",
            mcq1Prompt = "Why did Horace Danby sneeze repeatedly inside Shotover Grange?",
            mcq1Options = listOf("Cold winter snow", "Hay fever from a bowl of flowers", "Dust from old books", "Chilli smoke"),
            mcq1Correct = 1,
            mcq1Hi = "मेज़ पर रखे फूलों के गुलदस्ते से उसकी हे-फीवर (Hay fever) एलर्जी बढ़ गई और उसे छींक आ गई।",
            mcq2Prompt = "What job did Horace Danby eventually get inside the prison?",
            mcq2Options = listOf("Cook", "Assistant librarian", "Night guard", "Carpenter"),
            mcq2Correct = 1,
            mcq2Hi = "किताबों से प्रेम होने के कारण जेल में उसे सहायक पुस्तकालयाध्यक्ष (Assistant librarian) का काम मिला।"
        ),
        makeProseChapter(
            id = "c10_fp_5",
            classLevel = 10,
            bookName = "Footprints Without Feet",
            chapterNumber = 5,
            category = "Supplementary",
            title = "Footprints Without Feet",
            titleHi = "बिना पैरों के पदचिह्न",
            author = "H.G. Wells",
            summaryEn = "Brilliant yet lawless scientist Griffin discovers a drug that makes the human body transparent like glass. Instead of using science for good, he sets fire to his landlord's house, steals clothes and money, terrorizes Iping village, and escapes invisibly.",
            summaryHi = "प्रतिभाशाली पर नियम-विरुद्ध वैज्ञानिक ग्रिफिन मानव शरीर को काँच जैसा पारदर्शी बनाने की दवा खोजता है। पर समाज की भलाई करने के बजाय वह अपने मकान मालिक के घर में आग लगाता है, दुकानें लूटता है और इपिंग गाँव में आतंक फैला देता है!",
            hindiExplanation = "लंदन की कीचड़ भरी सड़क पर दो लड़कों को ताज़ा पैरों के निशान दिखे पर कोई आदमी नहीं! वह अदृश्य वैज्ञानिक ग्रिफिन था जिसने दुर्लभ दवाओं से अपना शरीर काँच जैसा पारदर्शी कर लिया था। सर्दी से बचने वह लंदन स्टोर में कपड़े-भोजन चुराता है और फिर इपिंग गाँव की सराय में श्रीमती हॉल के यहाँ ठहरता है। पैसे खत्म होने पर वह पादरी के घर चोरी करता है और पुलिस कांस्टेबल जैफर्स को चकमा देकर कपड़े उतारकर अदृश्य भाग निकलता है।",
            themeEn = "Science without moral responsibility becomes destructive rather than beneficial.",
            themeHi = "नैतिक जिम्मेदारी के बिना वैज्ञानिक खोज समाज के लिए वरदान नहीं बल्कि अभिशाप बन जाती है।",
            messageHi = "अपने ज्ञान और प्रतिभा का उपयोग सदैव मानव कल्याण के लिए करें, स्वार्थ या अपराध के लिए नहीं।",
            words = listOf(
                w("Transparent", "adj", "Allowing light through completely", "पारदर्शी", "Griffin's body became transparent like a sheet of glass."),
                w("Eccentric", "adj", "Unconventional and slightly strange", "सनकी / विचित्र", "Mrs. Hall tolerated Griffin thinking he was an eccentric scientist."),
                w("Solicitude", "noun", "Care and concern for someone", "चिंता / देखभाल", "Griffin stayed muffled despite intense winter chill."),
                w("Hysterics", "noun", "Wild uncontrollable emotional panic", "घबराहट व चीख-पुकार", "Mrs. Hall fell into hysterics seeing furniture fly by itself."),
                w("Baffled", "adj", "Puzzled and frustrated", "चकित / हैरान", "Constable Jaffers struggled to arrest an invisible man.")
            ),
            matchPairs = listOf(
                MatchPair("Griffin", "Brilliant lawless invisible scientist"),
                MatchPair("Iping", "Quiet village inn visited in winter"),
                MatchPair("Mrs. Hall", "Landlord's wife terrified by hat & chair"),
                MatchPair("Mr. Jaffers", "Dutiful village constable")
            ),
            extract1 = ExtractSpec(
                extractText = "“Griffin, the scientist, had carried out experiment after experiment to prove that the human body could become invisible.”",
                promptEn = "Why was Griffin wandering the London streets without clothes on a bitter January day?",
                promptHi = "कड़ाके की ठंड में ग्रिफिन बिना कपड़ों के लंदन की सड़कों पर क्यों घूम रहा था?",
                answerEn = "Being homeless and wanting revenge, he set fire to his landlord's house and removed all clothes so no one could spot him escaping.",
                answerHi = "बदला लेने के लिए उसने मकान मालिक का घर जलाया और पकड़े जाने से बचने के लिए कपड़े उतारकर अदृश्य भाग निकला।"
            ),
            extract2 = ExtractSpec(
                extractText = "“The extraordinary chair pushed them both out of the room and then appeared to slam and lock the door after them.”",
                promptEn = "Why did Mrs. Hall think the inn room was haunted by spirits?",
                promptHi = "श्रीमती हॉल को क्यों लगा कि कमरे में भूत या आत्मा का साया है?",
                answerEn = "Invisible Griffin threw her mother's chair straight at her and slammed the door without anyone being visible.",
                answerHi = "अदृश्य ग्रिफिन ने हवा में कुर्सी उछालकर उन्हें बाहर धकेल दिया, जिससे उन्हें प्रेतबाधा का भ्रम हुआ।"
            ),
            pyqPromptEn = "Why do we say Griffin misused his extraordinary scientific discovery?",
            pyqPromptHi = "हम ऐसा क्यों कहते हैं कि ग्रिफिन ने अपनी अद्भुत वैज्ञानिक खोज का दुरुपयोग किया?",
            pyqAnswerEn = "Instead of helping medicine or humanity, he burned his landlord's house, robbed shops and a clergyman, assaulted Mr. and Mrs. Hall, and knocked out a policeman.",
            pyqAnswerHi = "मानवता की भलाई करने के बजाय उसने आगजनी, चोरी, पादरी के घर लूट और पुलिस से मारपीट के लिए अदृश्यता का दुरुपयोग किया।",
            mcq1Prompt = "What happened when Griffin swallowed the rare drugs he invented?",
            mcq1Options = listOf("He became giant", "His body became transparent like glass", "He forgot everything", "He could fly"),
            mcq1Correct = 1,
            mcq1Hi = "दवा पीने से ग्रिफिन का शरीर काँच की चादर जैसा पूरी तरह पारदर्शी (transparent) हो गया।",
            mcq2Prompt = "Who was the village constable sent to arrest the headless scientist in Iping?",
            mcq2Options = listOf("Mr. Jaffers", "Inspector Ausable", "Mr. Hall", "Dr. Herriot"),
            mcq2Correct = 0,
            mcq2Hi = "गांव के कर्तव्यनिष्ठ सिपाही श्री जैफर्स (Mr. Jaffers) बिना सिर वाले आदमी को पकड़ने आए थे।"
        ),
        makeProseChapter(
            id = "c10_fp_6",
            classLevel = 10,
            bookName = "Footprints Without Feet",
            chapterNumber = 6,
            category = "Supplementary",
            title = "The Making of a Scientist",
            titleHi = "एक वैज्ञानिक का निर्माण",
            author = "Robert W. Peterson",
            summaryEn = "The inspiring biography of Richard H. Ebright, whose childhood curiosity collecting butterflies in Pennsylvania—nurtured by his mother and Dr. Urquhart's book—grew into groundbreaking discoveries on how cells read their DNA.",
            summaryHi = "रिचर्ड एच. ईब्राइट की प्रेरक जीवनी, जिन्होंने बचपन में अपनी माँ के प्रोत्साहन और 'द ट्रैवल्स ऑफ मोनार्क एक्स' किताब की मदद से तितलियाँ इकट्ठी करना शुरू किया और आगे चलकर कोशिका द्वारा DNA पढ़ने की क्रांतिकारी खोज की!",
            hindiExplanation = "पेंसिल्वेनिया में इकलौते बच्चे रिचर्ड ईब्राइट को उनकी माँ ने दूरबीन, सूक्ष्मदर्शी व किताबें लाकर दीं। पहले उन्होंने सभी 25 तितली प्रजातियाँ इकट्ठी कीं, फिर डॉ. उर्क्वहार्ट के लिए मोनार्क तितलियों पर टैग लगाए। आठवीं कक्षा में असफल होने के बाद वे समझे कि असली विज्ञान प्रदर्शन (Display) नहीं, बल्कि प्रयोग (Experiment) है। प्यूपा के सुनहरे धब्बों के हार्मोन पर शोध करते हुए उन्होंने कोशिका के DNA सिद्धांत का बड़ा रहस्य खोज निकाला!",
            themeEn = "Insatiable curiosity, a first-rate mind, and competitive spirit—guided by supportive parents—forges great scientists.",
            themeHi = "तीव्र जिज्ञासा, प्रयोगशील सोच, माता-पिता का प्रोत्साहन और स्वस्थ प्रतिस्पर्धा महान वैज्ञानिक गढ़ती है।",
            messageHi = "रटने या केवल दिखावे के बजाय प्रयोग करें, कारण पूछें और असफलता से सीखकर आगे बढ़ें।",
            words = listOf(
                w("Entomology", "noun", "Scientific study of insects", "कीट विज्ञान", "Butterfly tagging introduced him to entomology."),
                w("Blueprint", "noun", "Detailed design plan", "रूपरेखा / ब्लूप्रिंट", "DNA is the blueprint for life in every cell."),
                w("Competitive", "adj", "Eager to win cleanly in contests", "प्रतिस्पर्धी", "Weiherer praised Ebright's healthy competitive spirit."),
                w("Heredity", "noun", "Passing of traits from parents", "आनुवंशिकता", "His cell study explained how cells read heredity DNA."),
                w("Migratory", "adj", "Moving seasonally from one region to another", "प्रवासी", "Monarch butterflies are remarkable migratory insects.")
            ),
            matchPairs = listOf(
                MatchPair("The Travels of Monarch X", "Book opening world of science"),
                MatchPair("Ebright's Mother", "First companion and supporter"),
                MatchPair("Dr. Frederick Urquhart", "Toronto butterfly researcher"),
                MatchPair("Richard Weiherer", "Social studies mentor & advisor")
            ),
            extract1 = ExtractSpec(
                extractText = "“It was his fascination for butterflies that opened the world of science to him.”",
                promptEn = "How did 'The Travels of Monarch X' become a turning point for Ebright?",
                promptHi = "'द ट्रैवल्स ऑफ मोनार्क एक्स' किताब ईब्राइट के जीवन में बड़ा मोड़ कैसे बनी?",
                answerEn = "Its final page invited readers to tag monarch butterflies for Dr. Urquhart's migration research, launching Ebright into real scientific investigation.",
                answerHi = "किताब के अंत में पाठकों से मोनार्क तितलियों पर टैग लगाने की अपील थी, जिससे ईब्राइट वास्तविक शोध से जुड़ गए।"
            ),
            extract2 = ExtractSpec(
                extractText = "“He found out that the twelve tiny gold spots on a monarch pupa produced a vital hormone necessary for development.”",
                promptEn = "What major theory on cell life emerged from Ebright's gold-spot hormone study?",
                promptHi = "सुनहरे धब्बों वाले हार्मोन के अध्ययन से ईब्राइट ने कौन-सा बड़ा सिद्धांत खोजा?",
                answerEn = "Looking at X-ray photos of the hormone's chemical structure, Ebright conceived how cells read the blueprint of their DNA.",
                answerHi = "हार्मोन की एक्स-रे संरचना देखते हुए उन्होंने समझा कि कोशिका अपने DNA के ब्लूप्रिंट को कैसे पढ़ती है।"
            ),
            pyqPromptEn = "What lesson did Richard Ebright learn when he lost at the county science fair in seventh grade?",
            pyqPromptHi = "सातवीं कक्षा के विज्ञान मेले में हारने पर रिचर्ड ईब्राइट ने क्या महत्वपूर्ण सबक सीखा?",
            pyqAnswerEn = "He realized winning isn't about neat displays (frog slides) alone—true science winners conduct real experiments showing cause and result.",
            pyqAnswerHi = "उन्होंने सीखा कि सिर्फ सुंदर स्लाइड दिखाने से पुरस्कार नहीं मिलता; असली विज्ञान ठोस प्रयोग करने से सिद्ध होता है।",
            mcq1Prompt = "Which book gifted by his mother opened the world of science for Richard Ebright?",
            mcq1Options = listOf("The Origin of Species", "The Travels of Monarch X", "Brief History of Time", "Wings of Fire"),
            mcq1Correct = 1,
            mcq1Hi = "'द ट्रैवल्स ऑफ मोनार्क एक्स' किताब ने ईब्राइट को तितलियों के प्रवास व विज्ञान शोध से जोड़ा।",
            mcq2Prompt = "According to Richard Weiherer, what are the three essential ingredients in making a scientist?",
            mcq2Options = listOf("Wealth, fame, luck", "First-rate mind, curiosity, will to win", "Big lab, expensive cars, travel", "Memory only"),
            mcq2Correct = 1,
            mcq2Hi = "एक श्रेष्ठ मस्तिष्क, जिज्ञासा और सही कारणों से जीतने की इच्छा—ये तीन गुण वैज्ञानिक बनाते हैं।"
        ),
        makeProseChapter(
            id = "c10_fp_9",
            classLevel = 10,
            bookName = "Footprints Without Feet",
            chapterNumber = 9,
            category = "Supplementary",
            title = "The Book That Saved the Earth",
            titleHi = "वह किताब जिसने पृथ्वी को बचा लिया",
            author = "Claire Boiko",
            summaryEn = "In this humorous futuristic play set in the 25th century, Martian commander Think-Tank plans to invade Earth in 2040—until he comically misreads a nursery rhyme book ('Mother Goose'), fears Earthlings are far smarter, and flees to Alpha Centauri!",
            summaryHi = "25वीं सदी के इस हास्य नाटक में मंगल ग्रह का अहंकारी शासक 'थिंक-टैंक' सन् 2040 में पृथ्वी पर आक्रमण करने आता है। पर पुस्तकालय में मिली बच्चों की कविता किताब 'मदर गूज़' का गलत अर्थ लगाकर (विशेषकर हम्प्टी-डम्प्टी देख) वह इतना डर जाता है कि मंगल छोड़कर भाग निकलता है!",
            hindiExplanation = "इतिहासकार बताती हैं कि 20वीं सदी 'पुस्तकों का युग' थी। 2040 में मंगल ग्रह के 'महान व शक्तिशाली थिंक-टैंक' ने कैप्टन ओमेगा और सार्जेंट ऊप को पृथ्वी की जासूसी के लिए भेजा। वे एक लाइब्रेरी में पहुँचे और किताबों को पहले 'सैंडविच' समझ बैठते हैं! फिर 'मदर गूज़' कविताएँ पढ़कर थिंक-टैंक मान लेता है कि धरती के लोग शंख-चाँदी की खेती करते हैं और 'हम्प्टी-डम्प्टी' तो खुद उसकी शक्ल जैसा गिरने वाला है—वह डर कर मंगल खाली कर भाग जाता है!",
            themeEn = "Half-baked arrogance and overthinking create foolish panic; books preserve human wisdom cleanly.",
            themeHi = "अधूरा ज्ञान और अहंकार हास्यास्पद भय पैदा करता है, जबकि किताबें मानव सभ्यता की सबसे बड़ी रक्षक हैं।",
            messageHi = "बिना पूरी समझ के किसी बात का गलत अनुमान न लगाएँ और पुस्तकों के महत्व का सम्मान करें।",
            words = listOf(
                w("Historian", "noun", "Expert who studies and records past events", "इतिहासकार", "The Historian shows slides of 2040 Earth invasion."),
                w("Peculiar", "adj", "Strange or unusual", "अजीब / विचित्र", "Martians stared at peculiar objects called books."),
                w("Sandwich", "noun", "Slices of bread with filling", "सैंडविच", "Think-Tank wrongly guessed books were Earth sandwiches."),
                w("Transcribed", "verb", "Put thoughts or speech into written form", "लिखित रूप में उतारना", "Iota transcribed the nursery rhymes carefully."),
                w("Decipher", "verb", "Convert secret or difficult text into meaning", "अर्थ समझना / कूट खोलना", "Martians tried to decipher Mother Goose code.")
            ),
            matchPairs = listOf(
                MatchPair("Think-Tank", "Vain Martian Commander-in-Chief"),
                MatchPair("Noodle", "Polite intelligent apprentice"),
                MatchPair("Mother Goose", "Nursery rhyme book that saved Earth"),
                MatchPair("Humpty Dumpty", "Picture mistaken for Think-Tank's fall")
            ),
            extract1 = ExtractSpec(
                extractText = "“Had a great fall! That means they plan to capture Mars Central Control and me!”",
                promptEn = "Why did Think-Tank panic upon seeing Humpty Dumpty's picture?",
                promptHi = "हम्प्टी-डम्प्टी का चित्र देखकर थिंक-टैंक क्यों घबरा गया?",
                answerEn = "Because Humpty Dumpty's large balloon-shaped head resembled Think-Tank's own huge egg-shaped head, convincing him Earthlings targeted him.",
                answerHi = "क्योंकि हम्प्टी-डम्प्टी का बड़ा अंडाकार सिर बिल्कुल थिंक-टैंक के सिर जैसा दिखता था!"
            ),
            extract2 = ExtractSpec(
                extractText = "“Wait a minute! Little round objects! They're not ears; they're sandwiches!”",
                promptEn = "How did Think-Tank absurdly identify books at first?",
                promptHi = "शुरुआत में थिंक-टैंक ने किताबों को क्या समझ लिया था?",
                answerEn = "Knowing nothing of libraries, he arrogantly claimed books were staple Earth diet called sandwiches and forced Oop to bite one.",
                answerHi = "पुस्तकों से अनजान थिंक-टैंक ने अहंकार में किताबों को खाने वाला सैंडविच बता दिया।"
            ),
            pyqPromptEn = "Compare the characters of Think-Tank and Apprentice Noodle.",
            pyqPromptHi = "कमांडर थिंक-टैंक और उसके सहायक नूडल के स्वभाव की तुलना कीजिए।",
            pyqAnswerEn = "Think-Tank was vain, boastful, and foolish despite his big head; Noodle was humble, tactful, and genuinely wise—who eventually replaced Think-Tank and befriended Earth.",
            pyqAnswerHi = "थिंक-टैंक अहंकारी व मूर्ख था जबकि नूडल विनम्र, बुद्धिमान और व्यावहारिक था, जो बाद में मंगल का शासक बना।",
            mcq1Prompt = "Which nursery rhyme book accidentally scared Think-Tank off Earth?",
            mcq1Options = listOf("Mother Goose", "Panchatantra", "Alice in Wonderland", "Fairy Tales"),
            mcq1Correct = 0,
            mcq1Hi = "बच्चों की प्रसिद्ध कविता पुस्तक 'मदर गूज़' (Mother Goose) ने पृथ्वी को आक्रमण से बचा लिया।",
            mcq2Prompt = "Where did Think-Tank flee after ordering evacuation of Mars?",
            mcq2Options = listOf("Jupiter", "Alpha Centauri", "Venus", "The Moon"),
            mcq2Correct = 1,
            mcq2Hi = "घबराकर थिंक-टैंक ने मंगल खाली करने का आदेश दिया और सौ मिलियन मील दूर 'अल्फा सेंटॉरी' भाग गया।"
        )
    )

    val specs: Map<String, ChapterRichSpec> = listOf(
        ChapterRichSpec(
            chapterId = "c10_ff_5",
            detailedHindiTeaching = "यह पाठ तीन अलग राज्यों—गोवा, कर्नाटक (कुर्ग) और असम—की अनोखी खुशबू और संस्कृति से परिचय कराता है। बोर्ड परीक्षा में गोवा के पैडर और असम चाय से जुड़े प्रश्न नियमित आते हैं!",
            paragraphs = listOf(
                p(1, "गोवा का बेकर (पैडर)", "Goan bakers called paders announced morning bread with bamboo jingles and wore knee-length kabai.", "बच्चे ब्रेड नहीं बल्कि मीठी ब्रेड-बैंगल लेने दौड़ते थे और घर के खर्च का हिसाब दीवार पर पेंसिल से लिखा जाता था।", "परंपरागत पेशे आज भी समाज की पहचान हैं।"),
                p(2, "कुर्ग: कॉफी और वीरता की भूमि", "Coorg is home to evergreen forests, Kodavu warriors with firearms privilege, and the Kaveri River.", "कुर्ग के कोडावु लोग अपने कप्पिया वस्त्र, अतिथि सत्कार व भारतीय सेना में अद्वितीय शौर्य के लिए प्रसिद्ध हैं।", "प्रकृति और वीरता कुर्ग को स्वर्ग का अंश बनाते हैं।"),
                p(3, "असम के हरे-भरे चाय बागान", "Rajvir amazed Pranjol with tea legends from China and India while passing Assam's endless tea estates.", "पूरी दुनिया में प्रतिदिन 80 करोड़ से अधिक कप चाय पी जाती है और मई-जुलाई की 'सेकंड-फ्लश' पत्तियाँ सर्वश्रेष्ठ चाय देती हैं।", "यात्रा के साथ ज्ञान साझा करना सीखने को रोचक बनाता है।")
            ),
            characters = listOf(
                ch("The Pader (Goan Baker)", "गोवा का पैडर (बेकर)", "गाँव का प्रिय मित्र व मार्गदर्शक", listOf("मेहनती", "समृद्ध (कटहल जैसा तंदुरुस्त)", "सामाजिक हिस्सा"), "पैडर की उपस्थिति गोवा के हर जन्मदिन, विवाह और त्योहार का अनिवार्य हिस्सा थी।", "The pader symbolizes warm Goan nostalgia, prosperity, and community celebration."),
                ch("Rajvir", "राजवीर", "जिज्ञासु व अध्ययनशील छात्र", listOf("खोजी", "प्रकृति प्रेमी", "सुसज्जित जानकारी वाला"), "पहली बार असम जाते समय उसने चाय के बारे में सभी रोचक इतिहास व तथ्य पहले ही पढ़ लिए थे।", "Rajvir is an observant, curious teenager fascinated by Assam's tea heritage.")
            ),
            cartoonScenes = listOf(
                sc(1, "गोवा में पैडर की ठक-ठक", "Goan Morning Bread", "टंग-टंग! बांस की खट-खट सुनते ही बच्चे बेकर से मीठी ब्रेड-बैंगल लेने दौड़ पड़े!", "Pader", "Children", CartoonSetting.CITY_MARKET, CartoonMood.HAPPY, "Bakery Joy"),
                sc(2, "कुर्ग की धुंध और कॉफी खुशबू", "Misty Coorg Hills", "हर तरफ कॉफी, कावेरी की लहरें और हाथियों का नहाना—मानो पृथ्वी पर स्वर्ग!", "Tourists", "Kodavus", CartoonSetting.HOME_GARDEN, CartoonMood.INSPIRING, "Coorg Beauty"),
                sc(3, "ट्रेन की खिड़की से असम के चाय बागान", "Sea of Tea", "अरे प्रांजोल, देखो! जहाँ तक नज़र जाती है, सिर्फ चाय की हरी झाड़ियों का समुद्र!", "Rajvir", "Pranjol", CartoonSetting.MOUNTAIN_LAB, CartoonMood.HAPPY, "Assam Tea"),
                sc(4, "भारत की विविधता में एकता", "Incredible India", "गोवा की ब्रेड, कुर्ग की कॉफी और असम की चाय—इमरान सर कहते हैं यही भारत की शान है!", "Rajvir", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Unity & Culture")
            )
        ),
        ChapterRichSpec(
            chapterId = "c10_ff_6",
            detailedHindiTeaching = "गेविन मैक्सवेल की यह प्यारी कहानी पालतू ऊदबिलाव मिजबिल की शरारतों और समझदारी को दर्शाती है। बाथरूम का नल खोलना और मार्बल्स से खेलना बच्चों को बहुत पसंद आता है!",
            paragraphs = listOf(
                p(1, "बसरा में मिजबिल से पहली मुलाकात", "Two Arabs brought Mijbil in a sack; coated in mud, he revealed chocolate-brown fur after weeks of bathing.", "मछली की तरह दिखने वाले मिट्टी से सने छोटे जीव को नहलाने पर मुलायम भूरा फर निकला—यह एक अज्ञात प्रजाति का ऊदबिलाव था!", "धैर्य से ही किसी नए प्राणी को समझा जा सकता है।"),
                p(2, "पानी व कंचों से अनूठे खेल", "Mijbil loved plunging in water, opening taps himself, and juggling marbles on his belly while lying flat.", "मिजबिल को स्थिर पानी बिल्कुल पसंद न था—वह हर बूंद उछालता और सूटकेस की ढलान पर पिंग-पोंग गेंद दौड़ाता था!", "खेल जीवों की बुद्धिमत्ता बढ़ाते हैं।"),
                p(3, "लंदन उड़ान और अजीब नामकरण", "On the flight to London, Mijbil slipped out causing hilarious shrieks until a kind air hostess calmed Maxwell; Londoners guessed bizarre animals!", "अखबार पढ़ रही महिला चिल्लाई 'चूहा!' पर एयर होस्टेस ने मुस्कान के साथ मदद की। लंदन में लोग पूछते—क्या यह बीवर, भालू या दरियाई घोड़ा है?", "अजनबी की करुणा बड़ी मुसीबत आसान कर देती है।")
            ),
            characters = listOf(
                ch("Mijbil", "मिजबिल (ऊदबिलाव)", "चंचल, बुद्धिमान जल-प्रेमी जीव", listOf("जिज्ञासु", "खिलाड़ी", "स्नेही"), "पानी और कंचों का प्रेमी मिजबिल जल्दी ही मैक्सवेल के साथ गहरा स्नेह स्थापित कर लेता है।", "Mijbil is an inventive, energetic otter whose curiosity charms everyone he meets."),
                ch("Gavin Maxwell", "गेविन मैक्सवेल", "संवेदनशील प्रकृति व पशु प्रेमी लेखक", listOf("धैर्यवान", "देखभाल करने वाले", "अवलोकनशील"), "लेखक मिजबिल के लिए विशेष खेल, यात्रा डिब्बा और सुरक्षित वातावरण तैयार करते हैं।", "Maxwell shows deep patience, responsibility, and gentle affection toward his animal companion.")
            ),
            cartoonScenes = listOf(
                sc(1, "बोरी में मिट्टी सना मेहमान!", "Basra Surprise", "अरे! इस बोरी के भीतर कौन है? मिट्टी हटी तो प्यारा चॉकलेट जैसा ऊदबिलाव मिजबिल निकला!", "Maxwell", "Mijbil", CartoonSetting.HOME_GARDEN, CartoonMood.MYSTERY, "First Meet"),
                sc(2, "बाथरूम में नल खोलकर मस्ती!", "Tap Genius", "वाह मिजबिल! इसने अपने छोटे पंजों से खुद नल घुमा दिया और पानी में छपाक-छपाक खेल रहा है!", "Mijbil", "Maxwell", CartoonSetting.HOME_GARDEN, CartoonMood.HAPPY, "Water Splash"),
                sc(3, "हवाई जहाज़ में 'चूहा-चूहा!' हंगामा", "Plane Chaos", "मिजबिल डिब्बे से निकलकर सीटों के नीचे भागा! दयालु एयर होस्टेस ने तुरंत सब संभाल लिया!", "Mijbil", "Air Hostess", CartoonSetting.OCEAN_SHIP, CartoonMood.DRAMATIC, "Flight Adventure"),
                sc(4, "लंदन की सड़कों पर अजूबा!", "London Guessing", "कोई इसे सील कहता है तो कोई डायनासोर! पर मिजबिल तो बस अपने कंचों व दीवार से खुश है!", "Mijbil", "Imran Sir", CartoonSetting.CITY_MARKET, CartoonMood.HAPPY, "Pet Love")
            )
        ),
        ChapterRichSpec(
            chapterId = "c10_ff_7",
            detailedHindiTeaching = "वल्लिक्कन्नन की यह मर्मस्पर्शी कहानी आठ साल की वल्ली की आँखों से दुनिया दिखाती है। छोटे बच्चे भी कितने स्वाभिमानी और संवेदनशील हो सकते हैं, यह इस पाठ का मुख्य सौंदर्य है!",
            paragraphs = listOf(
                p(1, "60 पैसे की बचत और गोपनीय योजना", "Valli calculated bus timings and saved sixty paise avoiding candies and fair rides.", "गांव की बस को रोज़ देख वल्ली ने यात्रियों की बातों से दूरी (6 मील), समय (45 मिनट) और किराए (30 पैसे) का हिसाब लगा लिया।", "सूक्ष्म अवलोकन और अनुशासन बड़े लक्ष्य आसान करते हैं।"),
                p(2, "बस में पहली यात्रा और हँसी", "Refusing the conductor's 'Madam' joke politely, she stood on her seat to watch palm trees and a racing cow.", "सड़क के बीच पूँछ उठाए दौड़ती गाय देखकर वल्ली जोर से हँस पड़ी—यह उसके लिए जीवन का सबसे रोचक दृश्य था।", "नई चीज़ें देखने का उत्साह बचपन को सुंदर बनाता है।"),
                p(3, "लौटती बस और मरी गाय का सन्नाटा", "Returning alone without stepping off in town, Valli saw the same cow dead and learned how fleeting joy can be.", "बिना माँ को बताए सुरक्षित लौटते समय अचानक मरी गाय देख वह जीवन-मृत्यु के सच से सिहर उठी।", "अनुभव हमें सुख के साथ जीवन की गंभीरता भी सिखाते हैं।")
            ),
            characters = listOf(
                ch("Valliammai (Valli)", "वल्ली (8 वर्ष)", "स्वाभिमानी, जिज्ञासु व परिपक्व बालिका", listOf("आत्मविश्वासी", "योजनाकार", "संवेदनशील"), "किसी की मुफ्त कोल्ड ड्रिंक भी न लेने वाली वल्ली आत्मसम्मान और बाल सुलभ जिज्ञासा की अद्भुत मिसाल है।", "Valli is observant, fiercely independent, and remarkably mature beyond her eight years.")
            ),
            cartoonScenes = listOf(
                sc(1, "खिड़की पर खड़ी सपना देखती वल्ली", "Dreaming at the Door", "रोकिए बस! आठ साल की वल्ली ने महीनों पेपरमिंट बचाकर 60 पैसे जमा कर लिए हैं!", "Valli", "Bus", CartoonSetting.CITY_MARKET, CartoonMood.THOUGHTFUL, "Saving Coins"),
                sc(2, "'मैं बच्ची नहीं हूँ, कंडक्टर जी!'", "Fine Madam Ride", "बस में बैठकर वल्ली गर्व से बोली—मैंने पूरे 30 पैसे दिए हैं, मुझे मैडम मत कहो!", "Valli", "Conductor", CartoonSetting.CITY_MARKET, CartoonMood.HAPPY, "Bold Passenger"),
                sc(3, "बस के आगे दौड़ती नटखट गाय", "Cow Chase", "हाहा! बस के आगे पूँछ उठाए दौड़ती गाय को देख वल्ली हँस-हँस कर लोटपोट हो रही है!", "Valli", "Cow", CartoonSetting.HOME_GARDEN, CartoonMood.HAPPY, "Funny Ride"),
                sc(4, "घर वापसी और गहरा जीवन सबक", "Quiet Return", "लौटते समय उसी गाय को शांत पड़ा देख वल्ली समझ गई—जीवन कितना क्षणभंगुर है!", "Valli", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Life Lesson")
            )
        ),
        ChapterRichSpec(
            chapterId = "c10_ff_9",
            detailedHindiTeaching = "एंटन चेखव का यह एकांकी नाटक MP बोर्ड कक्षा 10 के लिए अत्यंत महत्वपूर्ण है। लोमोव, नतालिया और चुबुकोव के बीच दोनों झगड़ों (Oxen Meadows और Guess vs Squeezer) के बिंदु ज़रूर याद रखें!",
            paragraphs = listOf(
                p(1, "विवाह प्रस्ताव से पहले ही ज़मीनी झगड़ा", "Lomov arrives nervously to propose to Natalya but ends up screaming over who owns Oxen Meadows.", "सूट-दस्ताने पहनकर आए लोमोव प्रपोज़ करने की बजाय 5 डेसिएटिन जमीन पर बहस कर बैठे और चुबुकोव ने उन्हें बाहर निकाल दिया।", "व्यर्थ की बहस मूल उद्देश्य भटका देती है।"),
                p(2, "वापसी और कुत्तों पर दूसरा संग्राम", "Upon learning Lomov came to propose, Natalya calls him back—only to fight again over whether Guess beats Squeezer.", "नतालिया लोमोव को गले लगाने दौड़ती है पर तुरंत कहती है—मेरा स्क्वीज़र तुम्हारे बूढ़े गेस से बेहतर है! फिर चीख-पुकार शुरू!", "अहंकार शांत बातचीत नहीं होने देता।"),
                p(3, "बेहोशी के बीच झटपट शादी!", "Exhausted Lomov collapses; Chubukov places Natalya's hand in his and declares them engaged amidst shouting.", "हार्ट पल्पिटेशन से लोमोव कुर्सी पर बेहोश हो गया—चुबुकोव ने तुरंत दोनों का हाथ मिलाया और शैंपेन मँगवा ली!", "चेखव दिखाते हैं कि धन-जमीन के विवाह कितने हास्यास्पद होते हैं।")
            ),
            characters = listOf(
                ch("Ivan Lomov", "इवान लोमोव (35 वर्ष)", "घबराया व वहमी ज़मींदार", listOf("रोगभ्रमी (Hypochondriac)", "झगड़ालू", "सीधा-सादा"), "दिल की धड़कन बढ़ने पर भी वह जमीन और कुत्ते के मामले में पीछे नहीं हटता।", "Lomov is an anxious, hypochondriac landowner who turns a romantic proposal into bitter debate."),
                ch("Natalya Stepanovna", "नतालिया (25 वर्ष)", "अच्छी गृहणी पर तेज़-तर्रार युवती", listOf("तर्क-वितर्क प्रेमी", "विवाह की इच्छुक", "जिद्दी"), "लोमोव से विवाह करने को बेताब होने पर भी वह अपने कुत्ते व जमीन पर समझौता नहीं करती।", "Natalya is sharp-tongued, assertive, yet anxious not to miss a wealthy match.")
            ),
            cartoonScenes = listOf(
                sc(1, "दस्ताने पहन कर आया दूल्हा!", "Formal Visit", "चुबुकोव हैरान हैं—इवान लोमोव शाम का कोट पहनकर आया है, जरूर शादी का प्रस्ताव लाया है!", "Lomov", "Chubukov", CartoonSetting.HOME_GARDEN, CartoonMood.HAPPY, "Surprise Guest"),
                sc(2, "ऑक्सेन मीडोज़ पर महाभारत!", "Meadows Fight", "मेरी ज़मीन! नहीं, मेरी ज़मीन! शादी की बात भूलकर लोमोव और नतालिया जोर-जोर से लड़ रहे हैं!", "Lomov", "Natalya", CartoonSetting.ROYAL_PALACE, CartoonMood.DRAMATIC, "Land Fight"),
                sc(3, "'मेरा स्क्वीज़र बेहतर है!'", "Dogs War", "वापस बुलाने के दो मिनट बाद ही दोनों अपने-अपने कुत्ते 'गेस' और 'स्क्वीज़र' को लेकर फिर भिड़ गए!", "Lomov", "Natalya", CartoonSetting.HOME_GARDEN, CartoonMood.DRAMATIC, "Second Quarrel"),
                sc(4, "बेहोशी में बन गई जोड़ी!", "Hilarious Engagement", "लोमोव धड़ाम से कुर्सी पर गिरा और पिता चुबुकोव ने झट से शादी पक्की कर दी—हास्य की पराकाष्ठा!", "Chubukov", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Comic Finale")
            )
        ),
        ChapterRichSpec(
            chapterId = "c10_fp_3",
            detailedHindiTeaching = "रॉबर्ट आर्थर की यह कहानी दिखाती है कि असली बुद्धिमान व्यक्ति संकट आने पर शोर नहीं मचाता। ऑसेबल की गढ़ी हुई बालकनी कहानी बोर्ड परीक्षा का सबसे पसंदीदा प्रश्न है!",
            paragraphs = listOf(
                p(1, "मोटे जासूस से फाउलर की निराशा", "Fowler expected thrilling gunfights, not dull Ausable wheezing up six floors.", "फाउलर ने सोचा था जासूस रहस्यमय होंगे पर ऑसेबल शांत और साधारण दिखते थे।", "बाहरी रूप हमेशा प्रतिभा का पैमाना नहीं होता।"),
                p(2, "कमरे में बंदूकधारी मैक्स और बालकनी का जाल", "Max demanded the missile report at gunpoint; Ausable complained calmly about the hotel's balcony.", "ऑसेबल ने बिना डरे कहा—मैनेजमेंट ने फिर नीचे की बालकनी बंद नहीं की!", "तनाव में झूठ को सच जैसा पेश करना उच्च मानसिक नियंत्रण है।"),
                p(3, "वेटर हेनरी की दस्तक और मैक्स का पतन", "Mistaking waiter Henry for police, Max stepped onto the nonexistent balcony and screamed down.", "ऑसेबल ने बताया कोई बालकनी है ही नहीं—फाउलर सच्ची जासूसी देखकर दंग रह गया!", "प्रत्युत्पन्नमति (Quick wit) बड़े से बड़े खतरे को टाल देती है।")
            ),
            characters = listOf(
                ch("Ausable", "ऑसेबल", "शांत व अत्यंत बुद्धिमान गुप्तचर", listOf("हाजिरजवाब", "निडर", "व्यावहारिक"), "बिना गोली चलाए केवल मानसिक चाल से उसने मैक्स को मात दे दी।", "Ausable relies on calm intellect and psychological improvisation rather than physical bravado.")
            ),
            cartoonScenes = listOf(
                sc(1, "छठी मंजिल का साधारण कमरा", "Meet Ausable", "फाउलर को विश्वास नहीं हो रहा कि ये मोटे और शांत ऑसेबल इतने बड़े सीक्रेट एजेंट हैं!", "Ausable", "Fowler", CartoonSetting.CITY_MARKET, CartoonMood.THOUGHTFUL, "First Impression"),
                sc(2, "कमरे में पिस्तौल लिए मैक्स!", "Max Appears", "हाथ ऊपर करो! मैक्स मिसाइल रिपोर्ट लेने कमरे में खड़ा है—ऑसेबल बिल्कुल घबराए नहीं!", "Max", "Ausable", CartoonSetting.ROYAL_PALACE, CartoonMood.DRAMATIC, "Gun Threat"),
                sc(3, "दरवाज़े पर ठक-ठक! पुलिस?", "The Balcony Bluff", "ऑसेबल ने कहा—नीचे बालकनी से कोई फिर आ गया और बाहर पुलिस है! मैक्स खिड़की पर चढ़ गया!", "Max", "Ausable", CartoonSetting.ROYAL_PALACE, CartoonMood.MYSTERY, "Smart Trap"),
                sc(4, "'वहाँ कोई बालकनी नहीं थी!'", "Brains Over Brawns", "वेटर हेनरी ड्रिंक्स लाया—फाउलर सलाम करता है कि दिमाग की ताकत बंदूक से बड़ी है!", "Ausable", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Clever Win")
            )
        ),
        ChapterRichSpec(
            chapterId = "c10_fp_4",
            detailedHindiTeaching = "विक्टर कैनिंग की यह रहस्यकथा सिखाती है कि गलत काम करने वाला व्यक्ति भी चालाकी के जाल में फँस सकता है। लाल ड्रेस वाली चोरनी ने होरेस को उसके ही अंदाज़ में मात दी!",
            paragraphs = listOf(
                p(1, "अनोखा सज्जन चोर होरेस डैनबी", "Horace made locks and stole once a year solely to finance his expensive rare-book habit.", "50 वर्षीय अविवाहित होरेस हर किसी को भला इंसान लगता था, पर वह तिजोरियाँ तोड़ने में माहिर था।", "सॉफ्ट अपराध भी अपराध ही रहता है।"),
                p(2, "शॉटओवर ग्रेंज में लाल ड्रेस वाली युवती", "Distracted by hay fever sneezes, Horace believed the young woman claiming to be the returning mistress.", "बिना नाम पूछे और संदेह किए उसने खुद पर भरोसा जताकर युवती के लिए तिजोरी खोल दी।", "भावनात्मक दबाव में व्यक्ति सावधानी खो देता है।"),
                p(3, "दस्तानों की भूल और गिरफ्तारी", "Taking off gloves to light her cigarette left fingerprints everywhere while the real mistress was old and grey-haired.", "जेल में पुस्तकालय संभालते हुए होरेस हर दिन अपनी मूर्खता पर पछताता रहा।", "बुराई अंततः स्वयं पर भारी पड़ती है।")
            ),
            characters = listOf(
                ch("Horace Danby", "होरेस डैनबी", "पुस्तक-प्रेमी भोला चोर", listOf("ताले का विशेषज्ञ", "सरल व भोला", "अंततः पकड़ा गया"), "होरेस ने अपने शौक के लिए साल में एक बार चोरी की, पर खुद एक अधिक चालाक चोर का शिकार बन गया।", "Horace is meticulous in planning locks yet surprisingly gullible under social pressure.")
            ),
            cartoonScenes = listOf(
                sc(1, "किताबों के लिए साल में एक चोरी", "Gentleman Thief", "होरेस डैनबी को दुर्लभ किताबों का शौक है—आज वह शॉटओवर ग्रेंज की तिजोरी पर नज़र गड़ाए है!", "Horace", "Books", CartoonSetting.HOME_GARDEN, CartoonMood.MYSTERY, "Planning Raid"),
                sc(2, "अरे! आछीं! हे-फीवर की छींक", "The Flower Trap", "फूलों की खुशबू से होरेस को जोरदार छींक आई और कुत्ता शेरी पूँछ हिलाता रहा!", "Horace", "Sherry", CartoonSetting.ROYAL_PALACE, CartoonMood.THOUGHTFUL, "Sneezing Clue"),
                sc(3, "लाल ड्रेस में शातिर मालकिन?", "Deceptive Lady", "लाल कपड़ों वाली युवती ने कहा—तिजोरी खोलो वरना पुलिस बुलाऊँ! होरेस ने दस्ताने उतार दिए!", "Horace", "Lady in Red", CartoonSetting.ROYAL_PALACE, CartoonMood.DRAMATIC, "Clever Trick"),
                sc(4, "जेल पुस्तकालय में पछतावा", "Fingerprints Caught", "गहने तो चोरनी ले उड़ी और उँगलियों के निशान से होरेस जेल लाइब्रेरी में पहुँच गए!", "Horace", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Honesty Pays")
            )
        ),
        ChapterRichSpec(
            chapterId = "c10_fp_5",
            detailedHindiTeaching = "एच.जी. वेल्स की प्रसिद्ध विज्ञान कथा का यह अंश बताता है कि जब ज्ञान व विज्ञान अराजक व्यक्ति के हाथ में चला जाए तो वह दूसरों की सुरक्षा के लिए खतरा बन जाता है।",
            paragraphs = listOf(
                p(1, "कीचड़ में बिना शरीर के पदचिह्न", "Two shocked boys traced fresh muddy footprints down London steps with nobody visible.", "सर्दियों में लंदन स्टोर में घुसकर ग्रिफिन ने मुफ्त कोट, टोपी व खाना चुराया और फिर थियेटर दुकान से पट्टियाँ व चश्मा लूटा।", "शक्ति का दुरुपयोग अपराध की ओर ले जाता है।"),
                p(2, "इपिंग सराय में रहस्यमयी घटनाएँ", "Paying in stolen cash, Griffin amazed Mr. and Mrs. Hall when hat and chair attacked them mid-air.", "बंद दरवाज़े से कुर्सी का हवा में उछलकर उन्हें बाहर फेंकना पूरे गांव में सनसनी बन गया।", "अज्ञानता में लोग वैज्ञानिक घटना को जादू मान लेते हैं।"),
                p(3, "बिना सिर वाला आदमी और जैफर्स की हार", "Stripping off bandages piece by piece, headless Griffin knocked out Constable Jaffers and escaped invisibly.", "जैसे ही पुलिस कांस्टेबल उसे पकड़ने बढ़ा, ग्रिफिन कपड़े फेंकते हुए हवा में गायब हो गया!", "विज्ञान को सदैव नैतिकता के नियंत्रण में होना चाहिए।")
            ),
            characters = listOf(
                ch("Griffin", "ग्रिफिन", "प्रतिभाशाली पर क्रोधी वैज्ञानिक", listOf("तेज़ बुद्धि", "गुस्सैल", "नियम-विरोधी"), "अदृश्यता की अद्भुत खोज करके भी अपने क्रोध व लालच के कारण वह एक भगोड़ा अपराधी बन जाता है।", "Griffin represents brilliant scientific intellect corrupted by selfishness and lawlessness.")
            ),
            cartoonScenes = listOf(
                sc(1, "लंदन की सीढ़ियों पर जादुई निशान", "Invisible Footsteps", "अरे देखो! कीचड़ में पैरों के निशान बन रहे हैं पर सामने कोई इंसान दिख ही नहीं रहा!", "Boys", "Griffin", CartoonSetting.CITY_MARKET, CartoonMood.MYSTERY, "Ghostly Prints"),
                sc(2, "लंदन स्टोर में अदृश्य दावत", "London Store", "ठंड से काँपता ग्रिफिन रात में मॉल के अंदर गर्म कपड़े, जूते और मिठाई खा रहा है!", "Griffin", "Store", CartoonSetting.CITY_MARKET, CartoonMood.HAPPY, "Warm Escape"),
                sc(3, "इपिंग सराय में उड़ती कुर्सियाँ!", "Flying Furniture", "बचाओ! श्रीमती हॉल की टोपी और कुर्सी अपने आप हवा में उड़कर हमला कर रही हैं!", "Mrs. Hall", "Griffin", CartoonSetting.HOME_GARDEN, CartoonMood.DRAMATIC, "Room Panic"),
                sc(4, "बिना सिर के भागा वैज्ञानिक!", "Headless Escape", "जैफर्स ने पकड़ने की कोशिश की, पर ग्रिफिन ने पट्टियाँ उतारीं और हवा में गायब! विज्ञान संभलकर!", "Jaffers", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Ethics in Science")
            )
        ),
        ChapterRichSpec(
            chapterId = "c10_fp_6",
            detailedHindiTeaching = "रिचर्ड ईब्राइट की कहानी प्रत्येक MP बोर्ड विद्यार्थी के लिए प्रेरणा का स्रोत है—कैसे तितलियाँ पकड़ने से लेकर जीवन के सबसे छोटे कोड 'DNA' की समझ तक उन्होंने ऊँचाइयाँ छुईं!",
            paragraphs = listOf(
                p(1, "चमकता बचपन और माँ का साथ", "By second grade Ebright collected all 25 butterfly species around Reading, Pennsylvania, nurtured by his widowed mother.", "पिता को जल्दी खोने के बाद माँ ही उनकी सबसे अच्छी मित्र और पहली शिक्षक बनीं—दोनों मेज़ पर सीखने के खेल खेलते थे।", "माता-पिता का प्रोत्साहन प्रतिभा को पंख देता है।"),
                p(2, "विज्ञान मेले से वास्तविक शोध की ओर", "After losing with a mere display, he resolved to do true experiments, discovering viral disease causes and viceroy mimicry.", "आठवीं से लेकर हाईस्कूल तक उन्होंने साबित किया कि वायसरॉय तितली पक्षियों से बचने के लिए मोनार्क की नकल करती है!", "प्रश्नों का उत्तर वास्तविक प्रयोगों से मिलता है।"),
                p(3, "हार्मोन और DNA ब्लूप्रिंट की खोज", "Investigating monarch pupa's 12 gold spots led Ebright and James Wong to explain how cells read their genetic DNA.", "हार्वर्ड में टॉपर बनने के साथ-साथ वे अच्छे वक्ता, फोटोग्राफर और नाव चालक भी थे।", "संपूर्ण व्यक्तित्व और निरंतर शोध जीवन को महान बनाते हैं।")
            ),
            characters = listOf(
                ch("Richard H. Ebright", "रिचर्ड एच. ईब्राइट", "जिज्ञासु बालक से महान जीव-वैज्ञानिक", listOf("मेहनती", "खोजी", "बहुमुखी प्रतिभा"), "तितलियों से शुरू हुई उनकी जिज्ञासा ने उन्हें कोशिका विज्ञान व DNA शोध में विश्व स्तर का वैज्ञानिक बनाया।", "Ebright combines sharp analytical curiosity, disciplined work ethic, and rounded interests.")
            ),
            cartoonScenes = listOf(
                sc(1, "माँ द्वारा दिया गया दूरबीन व किताब", "Mother's Gift", "रिचर्ड की माँ ने उन्हें 'मोनार्क एक्स' किताब दी—यहीं से शुरू हुई महान वैज्ञानिक यात्रा!", "Ebright", "Mother", CartoonSetting.HOME_GARDEN, CartoonMood.HAPPY, "Early Spark"),
                sc(2, "तितलियों पर टैग लगाने का अभियान", "Tagging Monarchs", "पेंसिल्वेनिया के खेतों में रिचर्ड सैकड़ों मोनार्क तितलियों के पंखों पर हल्के टैग लगा रहे हैं!", "Ebright", "Butterflies", CartoonSetting.HOME_GARDEN, CartoonMood.THOUGHTFUL, "Field Research"),
                sc(3, "असफलता से सीख: असली प्रयोग!", "Real Experiments", "सातवीं की हार ने सिखाया—केवल चित्र नहीं, प्रयोगशाला में प्रयोग ही असली विज्ञान है!", "Ebright", "Microscope", CartoonSetting.MOUNTAIN_LAB, CartoonMood.INSPIRING, "Science Fair"),
                sc(4, "DNA रहस्य का उजागर!", "Cell Blueprint", "सुनहरे धब्बों के हार्मोन से ईब्राइट ने DNA की गुत्थी सुलझा दी—इमरान सर कहते हैं सवाल पूछते रहो!", "Ebright", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Great Discovery")
            )
        ),
        ChapterRichSpec(
            chapterId = "c10_fp_9",
            detailedHindiTeaching = "क्लेयर बोइको का यह मज़ेदार नाटक 'मदर गूज़' नामक बच्चों की कविता किताब को पृथ्वी का रक्षक बताता है! थिंक-टैंक, नूडल, ओमेगा, आयोटा और ऊप सभी पात्रों के नाम परीक्षा में पूछे जाते हैं।",
            paragraphs = listOf(
                p(1, "मंगल का घमंडी शासक थिंक-टैंक", "Standing in 25th-century museum, Historian reveals how Think-Tank planned to conquer Earth in 2040.", "विशाल अंडे जैसे सिर वाला थिंक-टैंक खुद को ब्रह्मांड का सबसे बुद्धिमान प्राणी मानता था।", "झूठा घमंड विवेक को अंधा कर देता है।"),
                p(2, "लाइब्रेरी की किताबें: सैंडविच या कान के फोन?", "Landing in a public library, Think-Tank guessed books were sandwiches before Noodle hinted they are for reading/communication.", "ओप को सैंडविच की तरह किताब चबानी पड़ी, तब विटामिन की गोली खाकर उन्होंने कविताएँ पढ़ीं!", "अधूरी जानकारी गलतफहमियाँ पैदा करती है।"),
                p(3, "हम्प्टी-डम्प्टी का डर और पलायन", "Reading 'Mistress Mary' and 'Humpty Dumpty', Think-Tank thought Earthlings threatened him and fled to Alpha Centauri.", "किताब से डरकर पूरा मंगल अभियान रद्द हो गया और सदियों बाद बुद्धिमान नूडल ने पृथ्वी से मित्रता की।", "पुस्तकें ज्ञान और शांति की सबसे शक्तिशाली ढाल हैं।")
            ),
            characters = listOf(
                ch("Great and Mighty Think-Tank", "थिंक-टैंक", "मंगल सेना का अहंकारी पर डरपोक प्रमुख", listOf("अभिमानी", "अधूरा ज्ञानी", "कायर"), "दूसरों के विचारों को अपना बताकर शेखी बघारने वाला थिंक-टैंक बच्चों की कविता पढ़कर ही भाग खड़ा हुआ।", "Think-Tank is a pompous, thin-skinned Martian ruler exposed by simple nursery rhymes."),
                ch("Apprentice Noodle", "नूडल (सहायक)", "विनम्र व वास्तव में बुद्धिमान अधिकारी", listOf("नम्र", "समझदार", "कूटनीतिक"), "नूडल हर सही सुझाव बड़ी विनम्रता से देता है और बाद में मंगल का योग्य शासक बनता है।", "Noodle gracefully guides his vain boss and eventually builds peace with Earth.")
            ),
            cartoonScenes = listOf(
                sc(1, "25वीं सदी का इतिहास संग्रहालय", "25th Century Museum", "नमस्ते! इतिहासकार बता रही हैं कि 2040 में पृथ्वी को हथियारों ने नहीं, एक किताब ने बचाया था!", "Historian", "Projector", CartoonSetting.MOUNTAIN_LAB, CartoonMood.MYSTERY, "Future Flashback"),
                sc(2, "पुस्तकालय में एलियंस: 'सैंडविच खाओ!'", "Book Sandwich?", "हाहा! थिंक-टैंक ने किताब को सैंडविच समझ लिया और सार्जेंट ऊप मुँह बनाकर पन्ना चबा रहे हैं!", "Think-Tank", "Oop", CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Funny Mistake"),
                sc(3, "हम्प्टी-डम्प्टी देख थिंक-टैंक काँप उठे!", "Mother Goose Panic", "अरे! 'हम्प्टी-डम्प्टी हैड अ ग्रेट फॉल'—ये तो मेरा ही चित्र है! जल्दी स्पेसशिप तैयार करो!", "Think-Tank", "Noodle", CartoonSetting.ROYAL_PALACE, CartoonMood.DRAMATIC, "Comic Panic"),
                sc(4, "पुस्तकों ने बचाई हमारी प्यारी पृथ्वी!", "Books Save Earth", "थिंक-टैंक अल्फा सेंटॉरी भागे और बुद्धिमान नूडल ने पृथ्वी से दोस्ती की—खूब किताबें पढ़ें!", "Noodle", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Power of Books")
            )
        )
    ).associateBy { it.chapterId }
}
