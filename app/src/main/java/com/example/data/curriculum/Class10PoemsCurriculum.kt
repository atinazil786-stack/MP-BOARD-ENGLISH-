package com.example.data.curriculum

import com.example.data.curriculum.CurriculumBuilders.ch
import com.example.data.curriculum.CurriculumBuilders.dev
import com.example.data.curriculum.CurriculumBuilders.f
import com.example.data.curriculum.CurriculumBuilders.makePoemChapter
import com.example.data.curriculum.CurriculumBuilders.sc
import com.example.data.curriculum.CurriculumBuilders.st
import com.example.data.curriculum.CurriculumBuilders.w
import com.example.data.model.CartoonMood
import com.example.data.model.CartoonSetting
import com.example.data.model.Chapter
import com.example.data.model.MatchPair

object Class10PoemsCurriculum {

    val poems: List<Chapter> = listOf(
        makePoemChapter(
            id = "c10_ff_p1",
            classLevel = 10,
            bookName = "First Flight",
            poemNumber = 1,
            title = "Dust of Snow",
            titleHi = "बर्फ की धूल (हिमकण)",
            poet = "Robert Frost",
            summaryEn = "Walking sadly under a poisonous hemlock tree, a crow shakes cold snowflakes onto the poet. This tiny unexpected natural moment instantly lifts his gloomy mood and saves the rest of his day.",
            summaryHi = "एक उदास दिन कवि जहरीले हेमलॉक (धतूरा) वृक्ष के नीचे से गुज़र रहे थे तभी एक कौए ने पेड़ हिलाकर उन पर बर्फ के छोटे कण गिरा दिए। प्रकृति की इस छोटी-सी घटना ने तुरंत उनका मूड बदल दिया और बाकी दिन बर्बाद होने से बचा लिया।",
            hindiExplanation = "रॉबर्ट फ्रॉस्ट की यह 8 पंक्तियों की कविता सिखाती है कि जिन्हें समाज अशुभ मानता है (कौआ और हेमलॉक का पेड़), वे भी जीवन में खुशियाँ ला सकते हैं। बड़ी घटना नहीं, प्रकृति का एक हल्का-सा स्पर्श भी मन की निराशा दूर कर दिन सार्थक बना देता है।",
            themeEn = "Simple moments in nature can heal sadness; nothing in nature is purely negative.",
            themeHi = "प्रकृति के छोटे व साधारण क्षण भी उदासी को खुशी में बदल सकते हैं; कोई भी जीव या वृक्ष अशुभ नहीं होता।",
            words = listOf(
                w("Hemlock tree", "noun", "A poisonous plant with small white flowers", "जहरीला धतूरा/हेमलॉक पेड़", "A crow sat on the hemlock tree."),
                w("Shook down", "verb", "Made snow fall by moving branches", "हिलाकर नीचे गिराना", "The crow shook down dust of snow."),
                w("Heart's mood", "noun", "Emotional state of mind", "मन की दशा / मनोभाव", "The snow shower changed the poet's mood."),
                w("Rued", "verb", "Held in deep regret or sorrow", "पछताया / दुःख में बिताया", "It saved some part of a day I had rued."),
                w("Dust of snow", "phrase", "Fine powdery particles of snow", "बर्फ के महीन कण", "A gentle dust of snow touched his shoulder.")
            ),
            matchPairs = listOf(
                MatchPair("Crow & Hemlock", "Traditional symbols of gloom turned joyful"),
                MatchPair("Dust of snow", "Refreshing healing touch of nature"),
                MatchPair("Rued day", "Day earlier wasted in sorrow"),
                MatchPair("ABAB CDCD", "Rhyme scheme of the poem")
            ),
            stanzas = listOf(
                st(1, "The way a crow Shook down on me The dust of snow From a hemlock tree", "जिस प्रकार एक कौए ने हेमलॉक के पेड़ से मेरे ऊपर बर्फ के महीन कण गिरा दिए...", "उदास कवि पेड़ के नीचे खड़े थे तभी अशुभ माने जाने वाले कौए व धतूरे के वृक्ष ने उन पर शीतल बर्फ बरसाई।", "Symbolism: Crow & Hemlock = निराशा के पारंपरिक प्रतीक।"),
                st(2, "Has given my heart A change of mood And saved some part Of a day I had rued.", "...उसने मेरे हृदय की मनोदशा बदल दी और मेरे उस दिन का कुछ हिस्सा बचा लिया जिसे मैं अब तक दुःख में खो रहा था।", "मन में तुरंत ताज़गी आई और उन्होंने बाकी दिन सकारात्मक होकर जीया।", "Alliteration: 'Has given my heart' / 'saved some part'।")
            ),
            poeticDevices = listOf(
                dev("Symbolism (प्रतीक)", "प्रतीकात्मकता", "Crow and hemlock tree", "दुःख व अशुभ के प्रतीकों से खुशी का जन्म होना सिखाया गया।"),
                dev("Alliteration (अनुप्रास)", "अनुप्रास अलंकार", "Has given my heart / And saved some part", "'h' और 's' ध्वनि की लयात्मक पुनरावृत्ति।"),
                dev("Enjambment", "पंक्ति-निरंतरता", "Sentence flows across lines without pause", "पूरी कविता एक ही वाक्य में निरंतर बहती है।"),
                dev("Rhyme Scheme", "तुक योजना", "ABAB CDCD", "प्रत्येक स्टैंज़ा की तुकबंदी ABAB है।")
            ),
            extraFacts = listOf(
                f("Which bird shook down dust of snow onto Robert Frost?", "A crow", listOf("A sparrow", "A nightingale", "A pigeon"), "पेड़ पर बैठे एक कौए (crow) ने कवि पर बर्फ झाड़ी थी।"),
                f("What does the word 'rued' mean in 'Dust of Snow'?", "Regretted / held in sorrow", listOf("Celebrated", "Painted", "Forgotten"), "'Rued' का अर्थ है पछतावा या दुःख में बिताया हुआ।")
            )
        ),

        makePoemChapter(
            id = "c10_ff_p2",
            classLevel = 10,
            bookName = "First Flight",
            poemNumber = 2,
            title = "Fire and Ice",
            titleHi = "अग्नि और बर्फ",
            poet = "Robert Frost",
            summaryEn = "Robert Frost reflects on two extreme human emotions that can end the world: 'Fire' representing fiery desire and greed, and 'Ice' symbolizing cold hatred and indifference. Both are equally powerful destroyers.",
            summaryHi = "कवि रॉबर्ट फ्रॉस्ट बताते हैं कि दुनिया का अंत दो मानवीय भावनाओं से हो सकता है—'अग्नि' जो असीम इच्छा, लालच व वासना की प्रतीक है, और 'बर्फ' जो ठंडी नफरत, क्रोध व संवेदनहीनता का प्रतीक है। विनाश के लिए दोनों ही समान रूप से पर्याप्त हैं!",
            hindiExplanation = "9 पंक्तियों की यह दार्शनिक कविता मनुष्य को आत्म-निरीक्षण की चेतावनी देती है। कुछ लोग मानते हैं विश्व आग से नष्ट होगा और कुछ कहते हैं बर्फ से। कवि कहते हैं कि अनियंत्रित लालच (Fire) पहले दुनिया जला सकता है, और यदि दुनिया को दूसरी बार मरना पड़े, तो मानव मन की कठोर घृणा (Ice) भी उसे समाप्त करने में कम नहीं है।",
            themeEn = "Unchecked human desire (Fire) and cold hatred (Ice) both lead to self-destruction.",
            themeHi = "असीमित लालसा (अग्नि) और संवेदनहीन घृणा (बर्फ) दोनों ही मानव सभ्यता के विनाश का कारण बन सकती हैं।",
            words = listOf(
                w("Desire", "noun", "Strong greedy longing or passion", "तीव्र लालसा / कामना", "Frost equates fiery desire with destructive fire."),
                w("Favour", "verb", "Support or agree with", "समर्थन करना", "I hold with those who favour fire."),
                w("Perish", "verb", "Die or be completely destroyed", "नष्ट होना / मरना", "If the world had to perish twice, ice would suffice."),
                w("Hatred", "noun", "Intense dislike and cold hostility", "घृणा / नफरत", "Cold hatred freezes human compassion like ice."),
                w("Suffice", "verb", "Be enough or adequate", "पर्याप्त होना", "Frost warns that ice would also suffice for destruction.")
            ),
            matchPairs = listOf(
                MatchPair("Fire", "Endless desire, greed, and fury"),
                MatchPair("Ice", "Cold hatred and insensitivity"),
                MatchPair("Perish twice", "Double threat to human survival"),
                MatchPair("ABAABCBCB", "Interlocking rhyme scheme")
            ),
            stanzas = listOf(
                st(1, "Some say the world will end in fire, Some say in ice. From what I've tasted of desire I hold with those who favour fire.", "कुछ कहते हैं संसार आग में समाप्त होगा, कुछ कहते हैं बर्फ में। मैंने इच्छा (लालच) का जितना अनुभव किया है, मैं आग वालों के पक्ष में हूँ।", "कवि का अनुभव कहता है कि अनियंत्रित तृष्णा और अहंकार सबसे जल्दी युद्ध व विनाश लाते हैं।", "Anaphora: 'Some say...' की पुनरावृत्ति।"),
                st(2, "But if it had to perish twice, I think I know enough of hate To say that for destruction ice Is also great And would suffice.", "पर यदि विश्व को दो बार नष्ट होना हो, तो मैं घृणा को इतना जानता हूँ कि विनाश के लिए ठंडी बर्फ भी कम नहीं और पर्याप्त होगी।", "लोगों के बीच बढ़ती नफरत और उदासीनता किसी भी महाविनाश से कम नहीं है।", "Symbolism: Ice = मानव हृदय की ठंडी नफरत।")
            ),
            poeticDevices = listOf(
                dev("Symbolism (प्रतीक)", "प्रतीकात्मकता", "Fire = Desire; Ice = Hatred", "भौतिक तत्वों को मनुष्य के आंतरिक दोषों का प्रतीक बनाया गया।"),
                dev("Anaphora (आरंभिक आवृत्ति)", "पुनरुक्ति", "Some say the world... Some say in ice", "लगातार दो वाक्यों के आरंभ में 'Some say' का प्रयोग।"),
                dev("Alliteration (अनुप्रास)", "अनुप्रास अलंकार", "Some say / world will / favour fire", "'s', 'w', 'f' ध्वनियों की आवृत्ति।"),
                dev("Personification", "मानवीकरण", "Destruction power given to Fire & Ice", "अग्नि और बर्फ को विश्व संहारक शक्तियों की तरह दिखाया गया।")
            ),
            extraFacts = listOf(
                f("What does 'Fire' stand for in 'Fire and Ice'?", "Uncontrolled human desire, lust, and greed", listOf("Winter snowfall", "Peaceful love", "Fresh water"), "'Fire' मनुष्य की असीमित इच्छा, लालच और आवेग का प्रतीक है।"),
                f("What does 'Ice' stand for according to Robert Frost?", "Cold hatred, rigidity, and indifference", listOf("Sweet ice cream", "Kind friendship", "Clean air"), "'Ice' कठोर नफरत और संवेदनहीनता का प्रतीक है।")
            )
        ),

        makePoemChapter(
            id = "c10_ff_p3",
            classLevel = 10,
            bookName = "First Flight",
            poemNumber = 3,
            title = "A Tiger in the Zoo",
            titleHi = "चिड़ियाघर में एक बाघ",
            poet = "Leslie Norris",
            summaryEn = "Leslie Norris contrasts the cramped, helpless pacing of a caged tiger inside a concrete zoo cell with the majestic freedom he ought to enjoy stalking plump deer in shadowy forests and terrorizing jungle-edge villages.",
            summaryHi = "कवि लेस्ली नॉरिस चिड़ियाघर के छोटे कंक्रीट पिंजरे में कैद शांत पर क्रोधित बाघ और जंगल के स्वतंत्र, निर्भीक बाघ के बीच गहरा अंतर दिखाते हैं। पिंजरे में उसकी अपार शक्ति बेबस है और रात में वह पेट्रोलिंग कारों की आवाज़ सुन चमकते तारों को निहारता है।",
            hindiExplanation = "यह कविता वन्यजीवों की स्वतंत्रता के अधिकार की वकालत करती है। पहला, चौथा व पाँचवाँ स्टैंज़ा पिंजरे की कैद दिखाते हैं जहाँ बाघ मखमली गद्दियों वाले पंजों से सिर्फ कुछ कदम टहलता है और दर्शकों को अनदेखा करता है। दूसरा व तीसरा स्टैंज़ा उसके असली जंगल जीवन को दिखाते हैं जहाँ वह जलाशय के पास छिपकर मोटे हिरण का शिकार करता है।",
            themeEn = "Freedom is every wild creature's birthright; caging wild animals crushes their natural majesty.",
            themeHi = "स्वतंत्रता प्रत्येक प्राणी का जन्मसिद्ध अधिकार है; जंगली जीवों को पिंजरे में कैद करना क्रूरता है।",
            words = listOf(
                w("Vivid stripes", "phrase", "Bright clear patterned bands on fur", "चमकदार स्पष्ट धारियाँ", "He stalks in his vivid stripes across the cage."),
                w("Quiet rage", "phrase", "Hidden silent anger inside", "शांत क्रोध (भीतरी गुस्सा)", "Stalking helplessly in his quiet rage."),
                w("Lurking", "verb", "Waiting hidden quietly to hunt", "घात लगाकर छिपना", "He should be lurking in shadow near the water hole."),
                w("Plump", "adj", "Well-fed and rounded", "मोटा-ताज़ा", "Where plump deer pass near the water hole."),
                w("Concrete cell", "phrase", "Small walled stone cage", "पक्का सीमेंट पिंजरा", "His strength lies locked behind bars in a concrete cell.")
            ),
            matchPairs = listOf(
                MatchPair("Quiet rage", "Oxymoron showing suppressed anger"),
                MatchPair("Velvet quiet", "Soft silent paws inside cage"),
                MatchPair("Water hole", "Natural hunting spot in forest"),
                MatchPair("Brilliant stars", "Freedom symbol watched at night")
            ),
            stanzas = listOf(
                st(1, "He stalks in his vivid stripes The few steps of his cage, On pads of velvet quiet, In his quiet rage.", "चमकदार धारियों वाला वह बाघ मखमली शांत पंजों से अपने पिंजरे के कुछ गिने-चुने कदम शांत क्रोध में टहलता है।", "छोटा पिंजरा उसकी विशाल ऊर्जा को बांधे हुए है, जिससे वह भीतर ही भीतर क्रोधित पर विवश है।", "Oxymoron: 'Quiet rage' (शांत + क्रोध दो विपरीत भाव)।"),
                st(2, "He should be lurking in shadow, Sliding through long grass Near the water hole Where plump deer pass.", "उसे तो जंगल की छाया में, लंबी घास में फिसलते हुए जलाशय के पास छिपा होना चाहिए जहाँ मोटे-ताजे हिरण गुज़रते हैं।", "कवि बताते हैं कि चिड़ियाघर नहीं, बल्कि स्वतंत्र जंगल व शिकार ही बाघ का वास्तविक जीवन है।", "Visual Imagery: जंगल व जलाशय का जीवंत दृश्य।"),
                st(3, "He should be snarling around houses At the jungle's edge, Baring his white fangs, his claws, Terrorising the village!", "उसे जंगल के किनारे बसे घरों के पास गुर्राते, अपने सफेद नुकीले दाँत व पंजे दिखाते हुए गाँव को दहलाना चाहिए!", "प्रकृति ने उसे शक्ति और भय का राजा बनाया है, प्रदर्शनी का खिलौना नहीं।", "Auditory Imagery: 'snarling' से गर्जना की अनुभूति।"),
                st(4, "But he's locked in a concrete cell, His strength behind bars... Ignoring visitors... And stares with his brilliant eyes At the brilliant stars.", "परंतु वह सीमेंट के पिंजरे में सलाखों के पीछे कैद है; दर्शकों की परवाह न कर रात को चमकती आँखों से आज़ाद आसमान के तारों को ताकता रहता है।", "पेट्रोलिंग कारों की आवाज़ और पिंजरे के बीच रात के तारे उसे आज़ादी की याद दिलाते हैं।", "Metaphor & Contrast: सलाखों के भीतर कैद बनाम खुला आसमान।")
            ),
            poeticDevices = listOf(
                dev("Oxymoron (विरोधाभास)", "विरोधाभासी युग्म", "In his quiet rage", "दो विपरीत शब्दों ('quiet' और 'rage') को साथ रखकर लाचारी और क्रोध एक साथ दिखाया गया।"),
                dev("Metaphor (रूपक)", "रूपक अलंकार", "Pads of velvet quiet", "बाघ के कोमल पंजों की तुलना मखमल से बिना 'like' के की गई।"),
                dev("Personification", "मानवीकरण", "Referred to as 'He' throughout", "बाघ को 'He' कहकर मानवीय भावनाओं और सम्मान से जोड़ा गया।"),
                dev("Alliteration (अनुप्रास)", "अनुप्रास अलंकार", "Behind bars / Plump pass / Concrete cell", "व्यंजन ध्वनियों की मधुर आवृत्ति।")
            ),
            extraFacts = listOf(
                f("What does the caged tiger hear at night inside the zoo?", "The last voice of patrolling cars", listOf("Forest waterfalls", "Village drums", "Thunderstorms"), "रात को पिंजरे में वह गश्ती कारों (patrolling cars) की आखिरी आवाज़ सुनता है।"),
                f("Which poetic device is used in the phrase 'quiet rage'?", "Oxymoron", listOf("Simile", "Hyperbole", "Onomatopoeia"), "'Quiet' और 'Rage' दो विरोधी भावों के कारण यहाँ Oxymoron अलंकार है।")
            )
        ),

        makePoemChapter(
            id = "c10_ff_p4",
            classLevel = 10,
            bookName = "First Flight",
            poemNumber = 4,
            title = "How to Tell Wild Animals",
            titleHi = "जंगली जानवरों को कैसे पहचानें",
            poet = "Carolyn Wells",
            summaryEn = "Carolyn Wells introduces dangerous wild animals through hilarious exaggeration: recognize the Asian Lion by its lethal roar, Bengal Tiger by how it eats you, Leopard by nonstop leaping, Bear by a crushing hug, Hyena by smiles, Crocodile by tears, and Chameleon by invisibility!",
            summaryHi = "कवयित्री कैरोलिन वेल्स बड़े मज़ेदार व हास्य अंदाज़ में खूंखार जंगली जानवरों की पहचान बताती हैं: दहाड़ते हुए हमला करे तो एशियाई शेर, काले-पीले पट्टे देख खा जाए तो बंगाल टाइगर, बार-बार झपटे तो तेंदुआ, कसकर गले लगाए तो भालू, मुस्कराए तो लकड़बग्घा, आँसू बहाए तो मगरमच्छ और पेड़ पर कुछ न दिखे तो गिरगिट!",
            hindiExplanation = "यह हास्य कविता छात्रों को प्रकृति के जीवों की विशेषताएँ मनोरंजक ढंग से सिखाती है। शब्दों के खेल ('lep and lep' में Poetic License) और मज़ाकिया खतरनाक स्थितियों से कवयित्री दिखाती हैं कि हर जीव की अनोखी पहचान होती है।",
            themeEn = "Humorous look at wildlife traits using playful wordplay, wit, and poetic exaggeration.",
            themeHi = "वन्य जीवों की विशिष्ट आदतों का हास्यपूर्ण, रोचक और सृजनात्मक परिचय।",
            words = listOf(
                w("Tawny", "adj", "Yellowish-brown sandy colour", "पीलापन लिए भूरा रंग", "A large and tawny beast roars at you."),
                w("Lept / Lep", "verb", "Poetic spelling of 'leapt' / leap", "छलाँग लगाना (काव्य स्वतंत्रता)", "He'll only lep and lep again."),
                w("Caress", "noun", "A gentle or loving touch", "प्यारा स्पर्श / आलिंगन", "Bear hugs you hard—and gives one more caress!"),
                w("Novice", "noun", "A beginner lacking experience", "नौसिखिया", "A novice might nonplus between beasts of prey."),
                w("Nonplus", "verb", "Leave confused or puzzled", "चकरा देना / उलझन में डालना", "Hyena vs crocodile might nonplus a beginner.")
            ),
            matchPairs = listOf(
                MatchPair("Asian Lion", "Roars loudly while you're dying"),
                MatchPair("Bengal Tiger", "Black stripes on yellow ground"),
                MatchPair("Bear", "Gives a very tight fatal hug"),
                MatchPair("Chameleon", "Lizard with no ears or wings")
            ),
            stanzas = listOf(
                st(1, "If ever you should go by chance To jungles in the east... If he roars at you as you're dyin' You'll know it is the Asian Lion...", "यदि पूर्व के जंगलों में कोई विशाल भूरा जानवर तुम पर दहाड़े तो मरते समय समझ लेना वह एशियाई शेर है; और यदि काली धारियों वाला पीला जानवर तुम्हें खा जाए तो वह बंगाल टाइगर है!", "हास्यपूर्ण ढंग से शेर की दहाड़ और बाघ की धारियों की पहचान कराई गई है।", "Poetic License: 'dyin'' (dying को तुक के लिए छोटा किया गया)।"),
                st(2, "If strolling forth, a beast you view, Whose hide with spots is peppered... 'Twill do no good to roar with pain, He'll only lep and lep again.", "टहलते हुए यदि धब्बों वाली खाल वाला जानवर तुम पर छलाँग लगाए तो दर्द से चिल्लाने का लाभ नहीं—वह तेंदुआ (Leopard) बार-बार झपटेगा!", "'Leopard' और 'lep' शब्द का विनोदी खेल देखते बनता है।", "Poetic License & Repetition: 'lep and lep again'।"),
                st(3, "When you're walking round your yard, You meet a creature there Who hugs you very, very hard, Be sure it is a Bear...", "आँगन में यदि कोई जीव कसकर गले लगाए तो समझना भालू है! और शिकारियों में लकड़बग्घा मुस्कुराकर आता है जबकि मगरमच्छ रोते हुए!", "'Crocodile tears' (मगरमच्छ के आँसू) और 'Hyena's smile' का प्रसिद्ध मुहावरा दर्शाया गया है।", "Alliteration: 'He hasn't' / 'bear will give'."),
                st(4, "The true Chameleon is small, A lizard sort of thing... If there is nothing on the tree, 'Tis the chameleon you see.", "असली गिरगिट छोटा छिपकली जैसा जीव है जिसके कान व पंख नहीं होते; यदि पेड़ पर कुछ न दिखे तो समझो रंग बदलता गिरगिट वहीं है!", "रंग बदलने की अद्भुत कला का विरोधाभासी समापन।", "Paradox / Humour: कुछ न दिखना = गिरगिट दिखना।")
            ),
            poeticDevices = listOf(
                dev("Poetic License (काव्य स्वतंत्रता)", "शब्द रूपांतरण", "As you're dyin' / He'll only lep and lep", "तुक और हास्य बनाए रखने के लिए 'dying' को 'dyin'' तथा 'leap' को 'lep' लिखा गया।"),
                dev("Alliteration (अनुप्रास)", "अनुप्रास अलंकार", "roaming round / lep and lep / bear hug very hard", "प्रथम अक्षरों की संगीतमय आवृत्ति।"),
                dev("Humour & Paradox", "हास्य व विरोधाभास", "If there is nothing on the tree, 'tis the chameleon you see", "चतुर रंग बदलने की कला पर अनूठा व्यंग्य।"),
                dev("Rhyme Scheme", "तुक योजना", "ABABCC", "प्रत्येक 6-पंक्ति स्टैंज़ा की तुक योजना ABABCC है।")
            ),
            extraFacts = listOf(
                f("How do hyenas and crocodiles differ while attacking prey according to the poem?", "Hyenas come with merry smiles; crocodiles weep tears", listOf("Hyenas bark loudly; crocodiles fly", "Both sing songs", "Both change colour"), "लकड़बग्घा खुश मुस्कान से और मगरमच्छ आँसुओं के साथ पहचान में आता है।"),
                f("Which creature lacks both ears and wings and blends into trees?", "The Chameleon", listOf("The Leopard", "The Bengal Tiger", "The Bear"), "गिरगिट (Chameleon) के न कान होते हैं न पंख और वह पेड़ में छिप जाता है।")
            )
        ),

        makePoemChapter(
            id = "c10_ff_p5",
            classLevel = 10,
            bookName = "First Flight",
            poemNumber = 5,
            title = "The Ball Poem",
            titleHi = "गेंद की कविता",
            poet = "John Berryman",
            summaryEn = "A little boy loses his bouncing ball in the harbour water and stands frozen in grief. The poet refrains from offering money or another ball, recognizing the boy is learning the deep epistemology of loss and growing up responsibly.",
            summaryHi = "एक छोटा बालक अपनी प्यारी गेंद को बंदरगाह के पानी में खोकर स्तब्ध और दुःखी खड़ा रह जाता है। कवि उसे नई गेंद के पैसे नहीं देते क्योंकि इस छोटे से नुकसान से ही बच्चा जीवन का सबसे बड़ा सच—'खोने के दुःख से उबरना व जिम्मेदारी उठाना'—सीख रहा है!",
            hindiExplanation = "जॉन बेरीमैन की यह संवेदनशील कविता बचपन की खोई चीज़ों के माध्यम से जीवन का कठोर पर आवश्यक पाठ पढ़ाती है। पैसा बाहरी चीज़ तो खरीद सकता है पर बचपन की यादें नहीं। हर व्यक्ति अपने जीवन में कुछ न कुछ प्रिय खोता है; परिपक्वता यही है कि हम दुःख सहकर आगे बढ़ें।",
            themeEn = "Learning to accept inevitable loss and rise responsibly in a world of possessions.",
            themeHi = "जीवन में किसी प्रिय वस्तु या अवसर के खो जाने के दुःख को स्वीकार कर जिम्मेदारी से आगे बढ़ना ही परिपक्वता है।",
            words = listOf(
                w("Harbour", "noun", "Sheltered water area for ships", "बंदरगाह", "The ball bounced straight into the dark harbour water."),
                w("Merrily", "adv", "Cheerfully and happily", "हँसी-खुशी / उछलते हुए", "Merrily bouncing down the street!"),
                w("Rigid", "adj", "Stiff and unable to move with shock", "स्तब्ध / कठोर (सदमे में)", "The boy stands rigid, trembling, staring down."),
                w("Intrude", "verb", "Enter unwanted or interfere", "दखल देना", "The poet does not intrude on the boy with a dime."),
                w("Epistemology", "noun", "Deep philosophical understanding/nature of knowing", "ज्ञानमीमांसा / गहरा जीवन ज्ञान", "The boy learns the epistemology of loss.")
            ),
            matchPairs = listOf(
                MatchPair("Lost ball", "Innocence and childhood memories"),
                MatchPair("Money is external", "Cannot buy lost emotional memories"),
                MatchPair("World of possessions", "Material world where losses occur"),
                MatchPair("Epistemology of loss", "How to stand up after losing")
            ),
            stanzas = listOf(
                st(1, "What is the boy now, who has lost his ball... Merrily bouncing, down the street, and then Merrily over — there it is in the water!", "अब उस बच्चे की दशा क्या होगी जिसकी गेंद उछलती-कूदती गली से सीधे पानी में जा गिरी! उसे दूसरी गेंद से दिलासा देना बेकार है।", "गेंद के साथ बच्चे की पुरानी यादें जुड़ी थीं, इसलिए नई गेंद उसकी जगह नहीं ले सकती।", "Anaphora: 'Merrily...' की पुनरावृत्ति।"),
                st(2, "An ultimate shaking grief fixes the boy As he stands rigid, trembling... I would not intrude on him; A dime, another ball, is worthless.", "गहरा शोक बालक को जड़ कर देता है, पर मैं एक सिक्का देकर उसके इस आत्म-साक्षात्कार में दखल नहीं दूँगा—अब उसे अपनी पहली जिम्मेदारी समझ में आ रही है।", "बच्चे को स्वयं अपनी भावनाओं से जूझकर परिपक्व बनना होगा।", "Imagery: कांपते बालक का सजीव चित्रण।"),
                st(3, "People will take Balls, balls will be lost always, little boy. And no one buys a ball back. Money is external.", "इस भौतिक संसार में लोग प्रिय चीज़ें छीनेंगे और गेंदें हमेशा खोती रहेंगी; पैसा बाहरी चीज़ है जो खोई यादों को वापस नहीं ला सकता।", "धन से वस्तु तो आ सकती है पर भावनात्मक नुकसान की भरपाई नहीं होती।", "Metaphor: 'Balls' = जीवन की प्रिय वस्तुएँ व रिश्ते।"),
                st(4, "He is learning... The epistemology of loss, how to stand up Knowing what every man must one day know...", "वह दुःखी आँखों के पीछे नुकसान का विज्ञान (epistemology of loss) सीख रहा है कि गिरकर फिर कैसे उठना है।", "जो हर मनुष्य को देर-सबेर सीखना पड़ता है, वह बच्चा आज सीख रहा है।", "Blank Verse: मुक्त लय में गहन दार्शनिक संदेश।")
            ),
            poeticDevices = listOf(
                dev("Metaphor (रूपक)", "रूपक अलंकार", "Balls, balls will be lost always", "गेंद बचपन की मासूमियत और जीवन के प्रिय संबंधों का प्रतीक है।"),
                dev("Anaphora (पुनरुक्ति)", "आरंभिक आवृत्ति", "Merrily bouncing... Merrily over", "हँसी-खुशी खोने से पहले का दृश्य।"),
                dev("Alliteration (अनुप्रास)", "अनुप्रास अलंकार", "buys a ball back / what, what is he", "'b' और 'w' ध्वनियों की आवृत्ति।"),
                dev("Repetition (पुनरावृत्ति)", "पुनरावृत्ति", "Balls, balls / What, what", "बच्चे की घबराहट और जीवन की अटल सच्चाई को बल देने के लिए।")
            ),
            extraFacts = listOf(
                f("Why doesn't the poet offer the boy a dime to buy another ball?", "Because money is external and cannot replace memories or teach responsibility", listOf("Because the poet is poor", "Because shops are closed", "Because the boy is rude"), "पैसा बाहरी है और वह न यादें खरीद सकता है न ही नुकसान से लड़ने की जिम्मेदारी सिखा सकता है।"),
                f("What does the phrase 'epistemology of loss' mean?", "Understanding the true nature and coping of loss", listOf("Counting coins", "Swimming in deep water", "Playing cricket rules"), "इसका अर्थ किसी खोई हुई चीज़ के दर्द को समझकर फिर से संभलने का जीवन-ज्ञान है।")
            )
        ),

        makePoemChapter(
            id = "c10_ff_p6",
            classLevel = 10,
            bookName = "First Flight",
            poemNumber = 6,
            title = "Amanda!",
            titleHi = "अमांडा!",
            poet = "Robin Klein",
            summaryEn = "Teenaged Amanda faces constant nagging from her parent about biting nails, slouching, homework, and acne—so she retreats silently into peaceful daydreams of being a carefree mermaid, a quiet street orphan, and golden-haired Rapunzel!",
            summaryHi = "कवयित्री रॉबिन क्लेन एक किशोर लड़की अमांडा की मनःस्थिति दिखाती हैं जिसे हर बात पर टोका जाता है—नाखून मत काटो, सीधे बैठो, होमवर्क करो! इस लगातार टोका-टाकी से ऊबकर अमांडा कल्पना की दुनिया में खुद को कभी जलपरी (Mermaid), कभी शांत अनाथ तो कभी मीनार की रॅपन्ज़ेल के रूप में आज़ाद देखती है!",
            hindiExplanation = "कविता के हर विषम स्टैंज़ा में माता-पिता की लगातार नसीहतें (Parenthetical nagging) हैं और कोष्ठक (Bracket) के भीतर अमांडा के मधुर दिवास्वप्न हैं। अंत में अभिभावक कहते हैं कि मूडी मत बनो वरना लोग सोचेंगे कि मैंने तुम्हें परेशान किया—जो अभिभावकों की दोहरी मानसिकता दर्शाता है।",
            themeEn = "Excessive parental control stifles children's freedom; adolescents crave space, love, and understanding.",
            themeHi = "अत्यधिक रोक-टोक बच्चों की आज़ादी व खुशी छीन लेती है; किशोरों को डांट नहीं, स्नेह और समझ की ज़रूरत होती है।",
            words = listOf(
                w("Slouching", "verb", "Sitting or standing lazily bent forward", "कंधे झुकाकर आलसी ढंग से बैठना", "Stop that slouching and sit up straight, Amanda!"),
                w("Languid", "adj", "Relaxed, calm, and slow-moving", "शांत व आरामदायक", "She imagines an emerald sea where she drifts in languid bliss."),
                w("Emerald", "adj", "Deep bright green like a gemstone", "पन्ने जैसा हरा रंग", "Mermaid drifts softly in the emerald sea."),
                w("Tranquil", "adj", "Calm, quiet, and peaceful", "अत्यंत शांत", "Life in the lone tower is tranquil and rare."),
                w("Sulking", "verb", "Staying silently angry or moody", "रूठकर मुँह फुलाना", "Stop that sulking at once, Amanda!")
            ),
            matchPairs = listOf(
                MatchPair("Mermaid daydream", "Drifting alone in emerald sea"),
                MatchPair("Orphan daydream", "Making patterns in soft dust freely"),
                MatchPair("Rapunzel daydream", "Calm solitary life in tall tower"),
                MatchPair("Parenthetical brackets", "Amanda's silent inner thoughts")
            ),
            stanzas = listOf(
                st(1, "Don't bite your nails, Amanda! Don't hunch your shoulders, Amanda!... (There is a languid, emerald sea, where the sole inhabitant is me—a mermaid...)", "नाखून मत काटो, कंधे मत झुकाओ, सीधे बैठो! (हरे समुद्र में केवल मैं अकेली शांत जलपरी बनकर तैर रही हूँ...)", "डांट से बचकर अमांडा शांत महासागर की आज़ाद जलपरी बनना चाहती है।", "Allusion: Mermaid (पौराणिक जलपरी का उल्लेख)।"),
                st(2, "Did you finish your homework, Amanda? Did you tidy your room... (I am an orphan, roaming the street. I pattern soft dust with my hushed, bare feet. The silence is golden, the freedom is sweet.)", "क्या होमवर्क व कमरा साफ किया? जूते साफ किए? (मैं एक अनाथ हूँ, नंगे पाँव नरम धूल पर निशान बनाती घूम रही हूँ—मौन सुनहरा है, आज़ादी मीठी है!)", "बच्ची को घर की डांट से आज़ाद अनाथ जीवन भी अधिक सुखद लगता है—यह बहुत बड़ा संकेत है!", "Metaphor: 'Silence is golden, freedom is sweet'।"),
                st(3, "Don't eat that chocolate, Amanda! Remember your acne... (I am Rapunzel, I have not a care... I'll never let down my bright hair!)", "चॉकलेट मत खाओ वरना मुंहासे होंगे! जब बोलूँ तो मेरी तरफ देखो! (मैं मीनार में रहने वाली रॅपन्ज़ेल हूँ; पर मैं अपने सुनहरे बाल कभी नीचे नहीं लटकाऊँगी!)", "रॅपन्ज़ेल की तरह वह ऊपर से अपनी शांति भंग नहीं होने देगी।", "Allusion: Fairy tale character Rapunzel."),
                st(4, "Stop that sulking at once, Amanda! You're always so moody... Anyone would think that I nagged at you, Amanda!", "तुरंत मुँह फुलाना बंद करो! वरना कोई भी सोचेगा कि मैंने तुम्हें परेशान किया है!", "अंतिम स्टैंज़ा में वक्ता को बच्चे के दर्द की नहीं, बल्कि लोगों के ताने की चिंता है—तीखा व्यंग्य!", "Irony: खुद लगातार टोककर दूसरों के सोचने से डरना।")
            ),
            poeticDevices = listOf(
                dev("Allusion (संदर्भ अलंकार)", "पौराणिक व कथा संदर्भ", "Mermaid / Rapunzel", "लोककथा पात्रों का प्रयोग कर अमांडा की आज़ादी की चाह दिखाई गई।"),
                dev("Metaphor (रूपक)", "रूपक अलंकार", "The silence is golden, the freedom is sweet", "मौन की तुलना सोने से और स्वतंत्रता की तुलना मिठास से की गई।"),
                dev("Anaphora (पुनरुक्ति)", "आरंभिक आवृत्ति", "Don't bite... Don't hunch / Did you finish... Did you tidy", "लगातार निर्देशों की पुनरावृत्ति।"),
                dev("Alliteration (अनुप्रास)", "अनुप्रास अलंकार", "Stop that slouching and sit up straight", "'s' ध्वनि की तीखी आवृत्ति।")
            ),
            extraFacts = listOf(
                f("Why does Amanda say 'I'll never let down my bright hair' as Rapunzel?", "So no one can climb up to disturb her peaceful solitude", listOf("Because her hair is short", "Because she dislikes towers", "To buy chocolate"), "ताकि कोई भी ऊपर आकर उसकी मीनार की शांत एकांत को भंग न कर सके।"),
                f("Why are three stanzas enclosed in brackets () in 'Amanda!'?", "They express Amanda's silent imaginative thoughts", listOf("They are dictionary notes", "They are mother's warnings", "They are printer mistakes"), "कोष्ठक (Brackets) के हिस्से अमांडा की खामोश कल्पनाओं व दिवास्वप्नों को दर्शाते हैं।")
            )
        ),

        makePoemChapter(
            id = "c10_ff_p7",
            classLevel = 10,
            bookName = "First Flight",
            poemNumber = 7,
            title = "The Trees",
            titleHi = "वृक्ष (पेड़)",
            poet = "Adrienne Rich",
            summaryEn = "Adrienne Rich uses trees confined inside glass verandas—breaking loose at night toward the empty forest—as a powerful feminist metaphor for women breaking free from domestic boundaries into open life and equality.",
            summaryHi = "कवयित्री एड्रियन रिच घर की चारदीवारी और काँच के भीतर कैद पेड़ों के रात में आज़ाद होकर खाली जंगल की ओर लौटने का सजीव चित्र बनाती हैं। यह कविता न केवल प्रकृति के पुनर्निर्माण बल्कि समाज की बंदिशें तोड़कर आगे बढ़ती महिलाओं की मुक्ति का भी सुंदर रूपक है!",
            hindiExplanation = "कविता की शुरुआत इस कल्पना से होती है कि घर के भीतर गमलों में उगाए गए पेड़ जड़ों व टहनियों सहित बाहर असली जंगल में जा रहे हैं, जहाँ पक्षी बैठ सकें और धूप की परछाईं बन सके। पूरी रात जड़ें फर्श की दरारों से निकलती हैं और अंततः काँच टूटने पर वे चाँदनी रात में आगे बढ़ जाती हैं—मानो सदियों की घुटन से स्वतंत्रता की ओर प्रस्थान।",
            themeEn = "Liberation of nature—and symbolically of women—from artificial confinement toward natural freedom.",
            themeHi = "प्रकृति और प्रतीकात्मक रूप से महिलाओं की कृत्रिम बंदिशों से निकलकर स्वतंत्रता की ओर प्रस्थान।",
            words = listOf(
                w("Veranda", "noun", "Roofed open gallery attached to a house", "बरामदा", "Roots work all night to disengage from veranda floor cracks."),
                w("Disengage", "verb", "Set free or detach", "मुक्त होना / अलग होना", "Roots strive to disengage from cracks."),
                w("Boughs", "noun", "Main branches of a tree", "पेड़ की मोटी शाखाएँ", "Newly discharged boughs shuffle like patients."),
                w("Lichen", "noun", "Mossy organism growing on bark/rocks", "शैवाल / लाइकेन", "Smell of leaves and lichen reaches the room."),
                w("Shuffling", "verb", "Walking heavily or dragging feet", "कदम घसीटकर चलना", "Boughs move like half-dazed patients toward doors.")
            ),
            matchPairs = listOf(
                MatchPair("Boughs like patients", "Simile of long-confined beings"),
                MatchPair("Glass breaking", "Shattering barriers of confinement"),
                MatchPair("Broken mirror moon", "Moonlight fractured through tall oaks"),
                MatchPair("Leaves & lichen smell", "Lingering voice before complete departure")
            ),
            stanzas = listOf(
                st(1, "The trees inside are moving out into the forest, the forest that was empty all these days where no bird could sit...", "घर के भीतर के पेड़ अब जंगल की ओर जा रहे हैं—वह जंगल जो इतने दिनों से खाली था जहाँ कोई पक्षी न बैठ सका, न धूप अपना पैर गाड़ सकी।", "कंक्रीट और घरों के बीच उजड़े जंगलों की पीड़ा और प्रकृति के लौटने की उम्मीद दर्शाई गई है।", "Personification: 'no sun bury its feet in shadow'।"),
                st(2, "All night the roots work to disengage themselves from the cracks in the veranda floor... long-cramped boughs shuffling under the roof like newly discharged patients...", "पूरी रात जड़ें बरामदे के फर्श की दरारों से खुद को छुड़ाने की कोशिश करती हैं; सिकुड़ी टहनियाँ अस्पताल से छूटे मरीजों की तरह दरवाजे की ओर बढ़ती हैं।", "लंबी कैद के बाद मुक्त होने के संघर्ष की तुलना मरीज के स्वास्थ्य लाभ से की गई है।", "Simile: 'like newly discharged patients'।"),
                st(3, "I sit inside, doors open to the veranda writing long letters in which I scarcely mention the departure of the forest...", "मैं भीतर खुले दरवाजे के पास पत्र लिख रही हूँ जिनमें पेड़ों के जाने का उल्लेख नहीं करती; पत्तों व लाइकेन की गंध अब भी कमरों में फुसफुसाती है।", "मनुष्य अपनी सुविधा में इतना व्यस्त है कि अपने आसपास के बड़े बदलावों पर ध्यान नहीं देता।", "Imagery: घ्राण व श्रवण बिंब।"),
                st(4, "Listen. The glass is breaking. The trees are stumbling forward into the night... The moon is broken like a mirror, its pieces flash now in the crown of the tallest oak.", "सुनो! काँच टूट रहा है! पेड़ अंधेरी रात में लड़खड़ाते हुए आगे बढ़ रहे हैं; ऊँचे ओक वृक्षों के मुकुट में चमकता चाँद टूटे दर्पण जैसा बिखर गया है!", "अंतिम विजय: सारी दीवारें तोड़कर वृक्ष—और प्रतीकात्मक रूप से बंधी आत्माएँ—स्वतंत्रता पा लेती हैं।", "Simile: 'moon is broken like a mirror'।")
            ),
            poeticDevices = listOf(
                dev("Simile (उपमा)", "उपमा अलंकार", "like newly discharged patients / broken like a mirror", "अस्पताल से छूटे मरीज और टूटे आईने से सुंदर तुलना।"),
                dev("Personification (मानवीकरण)", "मानवीकरण अलंकार", "Sun bury its feet / Trees stumbling forward / Winds rush to meet them", "पेड़, सूरज और हवा को सजीव मनुष्यों की भाँति कार्य करते दिखाया गया।"),
                dev("Symbolism / Extended Metaphor", "विस्तृत रूपक", "Confined trees = Women yearning freedom", "गमले में बंद पेड़ सदियों से घर में बंद महिलाओं के प्रतीक हैं।"),
                dev("Free Verse", "मुक्त छंद", "Modern free verse without end rhyme", "प्रभावशाली आधुनिक मुक्त छंद रचना।")
            ),
            extraFacts = listOf(
                f("What are the stumbling boughs compared to in 'The Trees'?", "Newly discharged half-dazed hospital patients", listOf("Dancing soldiers", "Flying birds", "Sleeping lions"), "लंबे समय से बंधी टहनियों की तुलना अस्पताल से अभी-अभी छूटे मरीजों से की गई है।"),
                f("Why does the moon look 'broken like a mirror' at the end?", "Tall oak crowns stand in front of the full moon", listOf("A meteor struck it", "A mirror fell off a wall", "Storm clouds hid everything"), "ऊँचे ओक वृक्षों की शाखाएँ चाँद के सामने आ जाने से चाँद टूटे दर्पण के टुकड़ों जैसा चमकता दिखता है।")
            )
        ),

        makePoemChapter(
            id = "c10_ff_p8",
            classLevel = 10,
            bookName = "First Flight",
            poemNumber = 8,
            title = "Fog",
            titleHi = "कोहरा",
            poet = "Carl Sandburg",
            summaryEn = "In just six short lines of free verse, Carl Sandburg compares the arrival and silent departure of fog over a city and harbour to a quiet cat creeping in on little padded feet, sitting silently on haunches, and slipping away unobserved.",
            summaryHi = "कार्ल सैंडबर्ग की मात्र 6 पंक्तियों की इस सुंदर हाइकू-शैली कविता में कोहरे की तुलना एक नन्ही बिल्ली से की गई है। जैसे बिल्ली दबे पाँव आकर चुपचाप घुटनों के बल बैठकर चारों ओर देखती है और फिर चुपके से आगे बढ़ जाती है, वैसे ही कोहरा शहर व बंदरगाह पर छाकर बिना शोर किए गायब हो जाता है।",
            hindiExplanation = "यह कविता प्रकृति के सूक्ष्म निरीक्षण की अद्भुत मिसाल है। कोहरा (Fog) बिना किसी चेतावनी के आता है—बिल्ली के मखमली पंजों की तरह बिल्कुल शांत। वह कुछ देर शहर की रफ्तार को थाम कर चुपचाप सब देखता है और फिर उतनी ही शांति से ओझल हो जाता है।",
            themeEn = "Nature's quiet power moves silently and unpredictably like a mysterious little cat.",
            themeHi = "प्रकृति की शक्तियाँ बिना किसी शोरगुल के चुपचाप आती हैं और शांतिपूर्वक विदा हो जाती हैं।",
            words = listOf(
                w("Fog", "noun", "Thick misty cloud close to ground", "कोहरा / धुंध", "The fog comes on little cat feet."),
                w("Harbour", "noun", "Port area where ships dock", "बंदरगाह", "It sits looking over harbour and city."),
                w("Haunches", "noun", "Hindquarters/crouching position on bent knees", "घुटने मोड़कर बैठने की मुद्रा", "The fog sits silently on haunches like a cat."),
                w("Moves on", "verb", "Departs quietly forward", "चुपचाप आगे बढ़ जाना", "And then moves on quietly.")
            ),
            matchPairs = listOf(
                MatchPair("Little cat feet", "Silent unnoticed arrival of fog"),
                MatchPair("Silent haunches", "Quiet lingering watch over city"),
                MatchPair("Harbour and city", "Wide scene covered by mist"),
                MatchPair("Six-line Free Verse", "Short haiku-like poetic form")
            ),
            stanzas = listOf(
                st(1, "The fog comes on little cat feet. It sits looking over harbour and city on silent haunches and then moves on.", "कोहरा छोटे बिल्ली के दबे पंजों पर आता है। वह चुपचाप घुटनों के बल बैठकर बंदरगाह और शहर को निहारता है और फिर आगे बढ़ जाता है।", "पूरी कविता एक विस्तारित रूपक (Extended Metaphor) है जो कोहरे के शांत आगमन, ठहराव और प्रस्थान को दिखाती है।", "Extended Metaphor & Personification: कोहरा = चुपचाप बैठी बिल्ली।")
            ),
            poeticDevices = listOf(
                dev("Metaphor (रूपक)", "रूपक अलंकार", "The fog comes on little cat feet", "बिना 'like/as' लगाए कोहरे को सीधे बिल्ली के छोटे पंजों वाला बताया गया।"),
                dev("Personification", "मानवीकरण", "It sits looking over harbour and city", "कोहरे को बिल्ली की तरह देखता और बैठता हुआ दिखाया गया।"),
                dev("Transferred Epithet", "विशेषण विपर्यय", "On silent haunches", "खामोश बैठने वाला भाव कोहरे की शांति को दिखाता है।"),
                dev("Enjambment / Free Verse", "मुक्त छंद", "Single continuous sentence over 6 unrhymed lines", "कोई अंत-तुक (rhyme) नहीं, हास्य-शांत प्राकृतिक लय।")
            ),
            extraFacts = listOf(
                f("What does Carl Sandburg compare the fog to?", "A little silent cat", listOf("A roaring tiger", "A rushing train", "A heavy storm"), "कवि ने कोहरे की तुलना दबे पाँव चलने वाली एक शांत बिल्ली (cat) से की है।"),
                f("Over which two places does the fog sit looking?", "Harbour and city", listOf("Desert and sea", "Village and farm", "Hills and rivers"), "कोहरा बंदरगाह (harbour) और शहर (city) पर नजर गड़ाए बैठा रहता है।")
            )
        ),

        makePoemChapter(
            id = "c10_ff_p9",
            classLevel = 10,
            bookName = "First Flight",
            poemNumber = 9,
            title = "The Tale of Custard the Dragon",
            titleHi = "कस्टर्ड ड्रैगन की कहानी",
            poet = "Ogden Nash",
            summaryEn = "Belinda lives in a white house with boastful pets—Ink (kitten), Blink (mouse), and Mustard (dog)—who mock gentle dragon Custard as a coward craving a safe cage. When a ferocious pirate breaks in, all boasters flee while Custard bravely devours the pirate!",
            summaryHi = "बेलिंडा अपने सफ़ेद घर में इंक (बिल्ली), ब्लिंक (चूहा), मस्टर्ड (कुत्ता) और कस्टर्ड (ड्रैगन) के साथ रहती थी। बाकी सब अपनी वीरता की शेखी बघारते और शांत कस्टर्ड को 'डरपोक' कह चिढ़ाते थे। पर जब एक खतरनाक समुद्री डाकू घर में घुसा, तो सारे शेखीबाज़ भाग खड़े हुए और केवल 'डरपोक' कस्टर्ड ने डाकू को निगलकर सबको बचा लिया!",
            hindiExplanation = "ओग्डेन नैश की यह मज़ेदार गाथागीत (Ballad) दिखाती है कि असली वीरता बड़ी-बड़ी बातें करने से नहीं, संकट के समय कर्म करने से सिद्ध होती है। डाकू के मरने के बाद फिर से कुत्ता-बिल्ली बहाने बनाने लगते हैं और विनम्र कस्टर्ड अब भी बस अपना 'अच्छा सुरक्षित पिंजरा' ही माँगता है!",
            themeEn = "Real courage shines silently in true crisis, whereas empty boasters vanish when danger strikes.",
            themeHi = "सच्ची वीरता दिखावे या शेखी बघारने में नहीं, बल्कि असली संकट आने पर निडरता से सामना करने में होती है।",
            words = listOf(
                w("Daggers", "noun", "Sharp pointed knives", "खंजर", "Custard had big sharp teeth and daggers on his toes."),
                w("Boasted", "verb", "Talked proudly about oneself", "डींग मारना / शेखी बघारना", "Mustard boasted he was brave like an angry tiger."),
                w("Pirate", "noun", "Robber on the seas or ships", "समुद्री डाकू", "A fierce pirate climbed in the window with pistols."),
                w("Gobbled", "verb", "Ate quickly and greedily", "निगल जाना", "Custard gobbled the pirate completely in one bite!"),
                w("Trulio", "adj", "Playful poetic spelling of 'truly'", "सचमुच में (काव्य शैली)", "Belinda had a really, trulio little pet dragon.")
            ),
            matchPairs = listOf(
                MatchPair("Ink & Blink", "Little black kitten and grey mouse"),
                MatchPair("Mustard", "Little yellow dog brave until danger"),
                MatchPair("Custard", "Gentle dragon who slayed the pirate"),
                MatchPair("Pirate", "Armed with cutlass and wooden leg")
            ),
            stanzas = listOf(
                st(1, "Belinda lived in a little white house, With a little black kitten and a little grey mouse... And a realio, trulio, little pet dragon.", "बेलिंडा एक छोटे सफेद घर में काली बिल्ली इंक, भूरे चूहे ब्लिंक, पीले कुत्ते मस्टर्ड और नन्हे पालतू ड्रैगन कस्टर्ड के साथ रहती थी।", "मज़ेदार तुकबंदी में सभी पालतू जीवों व बेलिंडा की छोटी लाल वैगन का परिचय मिलता है।", "Poetic License: 'realio, trulio' से हास्य पैदा किया गया।"),
                st(2, "Custard the dragon had big sharp teeth... Mouth like a fireplace, chimney for a nose... Belinda was as brave as a barrel full of bears... Custard cried for a nice safe cage.", "कस्टर्ड के पैने दाँत, अंगीठी जैसा मुँह और चिमनी जैसी नाक होने पर भी वह शांति से एक सुरक्षित पिंजरे की गुहार लगाता था, जिससे सब उस पर हँसते थे।", "सभी दिखावटी वीर (इंक, ब्लिंक, मस्टर्ड) शांत कस्टर्ड को 'पर्सिवल' कहकर चिढ़ाते थे।", "Simile: 'brave as a barrel full of bears' / 'mouth like a fireplace'।"),
                st(3, "Suddenly, suddenly they heard a nasty sound... Pistol in his left hand, pistol in his right... Belinda paled, Mustard fled, Ink trickled down, Blink hid in his hole.", "अचानक खिड़की से दोनों हाथों में पिस्तौल और दाँतों में कटार दबाए एक समुद्री डाकू घुसा! देखते ही बेलिंडा पीली पड़ गई और सारे शेखीबाज़ भागकर छिप गए!", "मुसीबत आते ही झूठे बहादुरों की सारी पोल खुल गई।", "Onomatopoeia: 'Meowch!', 'Weeck!', 'Clatter and clank'।"),
                st(4, "But up jumped Custard, snorting like an engine... He clashed his tail like irons in a dungeon... And gobbled him, every bit!", "पर कस्टर्ड इंजन की तरह फूँकार मारते हुए कूदा, लौह जंजीरों जैसी पूँछ पटकी और चिड़िया की तरह डाकू पर झपटकर उसे पूरा निगल गया!", "सच्ची वीरता के बाद भी विनम्र कस्टर्ड कहता है—मैं फिर भी अपने सुरक्षित पिंजरे में खुश हूँ!", "Simile: 'snorting like an engine', 'clash like irons in a dungeon'।")
            ),
            poeticDevices = listOf(
                dev("Simile (उपमा)", "उपमा अलंकार", "snorting like an engine / as brave as a tiger / mouth like a fireplace", "पूरे गीत में जीवंत और हास्यपूर्ण उपमाएँ भरी हैं।"),
                dev("Onomatopoeia", "ध्वन्यात्मक शब्द", "Meowch, weeck, clatter, clank, jangling", "चिल्लाहट और संघर्ष की वास्तविक आवाजें सुनाती है।"),
                dev("Oxymoron / Contrast", "विरोधाभास", "Pet dragon crying for a nice safe cage", "विशाल ड्रैगन का डरपोक व्यवहार हास्य व विनम्रता दिखाता है।"),
                dev("Ballad & AABB", "हास्य गाथागीत", "AABB rhyme scheme in 4-line stanzas", "प्रथम दो तथा अंतिम दो पंक्तियों की सरल लयात्मक तुक मिलती है।")
            ),
            extraFacts = listOf(
                f("Who were Belinda's four pets in 'The Tale of Custard the Dragon'?", "Ink (kitten), Blink (mouse), Mustard (dog), Custard (dragon)", listOf("Tom, Jerry, Bruno, Mijbil", "Lion, Bear, Tiger, Cat", "None"), "बेलिंडा के चार पालतू इंक (बिल्ली), ब्लिंक (चूहा), मस्टर्ड (कुत्ता) और कस्टर्ड (ड्रैगन) थे।"),
                f("Who alone faced and ate the armed pirate bravely?", "Custard the dragon", listOf("Mustard the dog", "Ink the kitten", "Blink the mouse"), "केवल शांत व विनम्र कस्टर्ड ड्रैगन ने ही समुद्री डाकू का सामना कर उसे निगल लिया।")
            )
        ),

        makePoemChapter(
            id = "c10_ff_p10",
            classLevel = 10,
            bookName = "First Flight",
            poemNumber = 10,
            title = "For Anne Gregory",
            titleHi = "ऐनी ग्रेगरी के लिए",
            poet = "William Butler Yeats",
            summaryEn = "In a thoughtful dialogue between the poet and young Anne Gregory, Yeats observes that men admire her mostly for her gorgeous yellow hair rather than her true inner self—and quotes an old religious man proving only God can love a human solely for inner soul.",
            summaryHi = "कवि डब्ल्यू.बी. यीट्स और सुंदर युवती ऐनी ग्रेगरी के बीच सुंदर संवाद है। कवि कहते हैं कि युवा पुरुष तुम्हारे भीतर के गुणों से नहीं, बल्कि तुम्हारे सुनहरे पीले बालों की सुंदरता से आकर्षित होते हैं। जब ऐनी बालों को काला-भूरा रंगने की बात कहती हैं, तो कवि एक वृद्ध संत का संदेश सुनाते हैं कि केवल ईश्वर ही हमें बाहरी रूप के बिना हमारी आत्मा से प्रेम कर सकते हैं!",
            hindiExplanation = "यह कविता बाहरी शारीरिक सौंदर्य (External Beauty) और आंतरिक आध्यात्मिक गुणों (Inner Worth) के बीच का भेद बताती है। पीले बालों के 'हनी-कलर्ड रैम्पार्ट्स' (किले की दीवार) जैसे शब्द दिखाते हैं कि बाहरी आकर्षण इंसान के असली मन को ढँक लेता है।",
            themeEn = "Humans judge by fleeting physical beauty, whereas divine love values the pure inner soul alone.",
            themeHi = "सांसारिक प्रेम अक्सर बाहरी सुंदरता से प्रभावित होता है, जबकि केवल ईश्वर ही व्यक्ति की शुद्ध आत्मा से निस्वार्थ प्रेम करते हैं।",
            words = listOf(
                w("Ramparts", "noun", "High defensive walls around a castle", "किले की ऊँची दीवारें (यहाँ कान पर गिरते बाल)", "Yellow hair acts like honey-coloured ramparts at your ear."),
                w("Despair", "noun", "Complete hopelessness", "निराशा / हताशा", "Young men are thrown into despair by external charm."),
                w("Hair-dye", "noun", "Colouring substance for hair", "बाल रंगने का रंग", "Anne offers to get a hair-dye to change yellow to brown or carrot."),
                w("Religious man", "phrase", "A wise monk or spiritual sage", "एक धर्मात्मा वृद्ध संत", "An old religious man found a holy text."),
                w("Yourself alone", "phrase", "Your pure inner soul without appearance", "केवल आपका आंतरिक व्यक्तित्व", "Only God could love you for yourself alone.")
            ),
            matchPairs = listOf(
                MatchPair("Honey-coloured ramparts", "Metaphor for Anne's golden locks"),
                MatchPair("Brown, black, or carrot", "Dyes Anne proposes to test true love"),
                MatchPair("Young men's love", "Drawn mostly by outward looks"),
                MatchPair("Only God", "Loves human soul purely without show")
            ),
            stanzas = listOf(
                st(1, "Never shall a young man, Thrown into despair By those great honey-coloured Ramparts at your ear, Love you for yourself alone And not your yellow hair.", "तुम्हारे कानों के पास किले की दीवार जैसी उन शहद-सी सुनहरी जुल्फों से मोहित कोई भी युवक तुम्हारे बालों से परे केवल तुम्हारी आत्मा से प्रेम नहीं कर पाएगा।", "कवि स्पष्ट कहते हैं कि बाहरी आकर्षण इतना प्रबल होता है कि युवा उसी में उलझ जाते हैं।", "Metaphor: 'Honey-coloured ramparts' = सुनहरे घने बाल।"),
                st(2, "But I can get a hair-dye And set such colour there, Brown, or black, or carrot, That young men in despair May love me for myself alone And not my yellow hair.", "तब तो मैं अपने बालों को भूरा, काला या गाजरी रंग में रंग लूँगी, ताकि युवा मेरे सुनहरे बालों की बजाय सिर्फ मेरे गुणों व मुझसे प्रेम करें!", "ऐनी दिखाती हैं कि बाहरी रंग तो आसानी से बदला जा सकता है, अतः लोग आंतरिक गुण देखें।", "Dialogue tone: आत्मविश्वास भरा उत्तर।"),
                st(3, "I heard an old religious man But yesternight declare That he had found a text to prove That only God, my dear, Could love you for yourself alone And not your yellow hair.", "कल ही मैंने एक वृद्ध संत को कहते सुना कि उनके पास धर्मग्रंथ का प्रमाण है—हे प्रिय, केवल ईश्वर ही तुम्हें तुम्हारी बाहरी सुंदरता के बिना सिर्फ तुम्हारी आत्मा के लिए प्रेम कर सकते हैं।", "मानवीय प्रेम में कहीं न कहीं रूप का आकर्षण रहता है; निःस्वार्थ प्रेम केवल ईश्वरीय गुण है।", "Alliteration: 'he had', 'yesternight' & ABCBDB rhyme.")
            ),
            poeticDevices = listOf(
                dev("Metaphor (रूपक)", "रूपक अलंकार", "Honey-coloured ramparts at your ear", "कान के पास गिरते सुनहरे बालों को किले की रक्षा-दीवार कहा गया।"),
                dev("Alliteration (अनुप्रास)", "अनुप्रास अलंकार", "love you for yourself alone / he had / set such", "सरल संगीतमय लय।"),
                dev("Repetition / Refrain", "टेक पंक्ति", "Love you for yourself alone / And not your yellow hair", "प्रत्येक स्टैंज़ा के अंत में दोहराई गई मुख्य पंक्ति।"),
                dev("Rhyme Scheme", "तुक योजना", "ABCBDB", "प्रत्येक 6-पंक्ति स्टैंज़ा की तुक योजना ABCBDB है।")
            ),
            extraFacts = listOf(
                f("What does W.B. Yeats call Anne Gregory's yellow hair?", "Great honey-coloured ramparts at your ear", listOf("Silver moonlight waves", "Golden wheat fields", "Autumn leaves"), "कवि ने उनके सुनहरे बालों को 'हनी-कलर्ड रैम्पार्ट्स' (शहद के रंग की किला-दीवार) कहा है।"),
                f("According to the old religious man, who alone can love Anne for herself alone?", "Only God", listOf("Young soldiers", "Rich kings", "Her best friend"), "केवल ईश्वर ही बिना बाहरी रूप देखे शुद्ध आत्मा से प्रेम कर सकते हैं।")
            )
        )
    )

    val specs: Map<String, ChapterRichSpec> = poems.map { poem ->
        val ps = when (poem.id) {
            "c10_ff_p1" -> Triple(
                listOf(
                    st(1, "The way a crow Shook down on me...", "एक कौए ने हेमलॉक पेड़ से मेरे ऊपर बर्फ झाड़ दी।", "दो अशुभ माने जाने वाले प्रतीक जीवन में शांति लाते हैं।", "Symbolism: Crow & Hemlock."),
                    st(2, "Has given my heart a change of mood...", "मन की उदासी दूर हुई और बाकी दिन बच गया।", "छोटा स्पर्श भी दिन सार्थक कर देता है।", "ABAB CDCD Rhyme.")
                ),
                listOf(
                    dev("Symbolism", "प्रतीक", "Crow and hemlock tree", "अशुभ प्रतीकों से आनंद उत्पन्न करना।"),
                    dev("Alliteration", "अनुप्रास", "Has given my heart / saved some part", "ध्वनि पुनरावृत्ति।")
                ),
                listOf(f("What fell from the hemlock tree onto Frost?", "Dust of snow", listOf("Dry leaves", "Raindrops", "Flowers"), "पेड़ से बर्फ की धूल (Dust of snow) गिरी थी।"))
            )
            "c10_ff_p2" -> Triple(
                listOf(
                    st(1, "Some say the world will end in fire...", "तीव्र इच्छा (अग्नि) संसार का अंत कर सकती है।", "लालच और वासना की विनाशकारी शक्ति।", "Anaphora: Some say."),
                    st(2, "Say that for destruction ice is also great...", "ठंडी नफरत (बर्फ) भी विश्व नष्ट करने में पर्याप्त है।", "घृणा व संवेदनहीनता पर चेतावनी।", "Symbolism: Fire & Ice.")
                ),
                listOf(
                    dev("Symbolism", "प्रतीक", "Fire = Desire, Ice = Hatred", "मानव दोषों का प्रतीकात्मक चित्रण।"),
                    dev("Anaphora", "पुनरुक्ति", "Some say... Some say", "आरंभिक शब्द दोहराव।")
                ),
                listOf(f("What does 'ice' represent in 'Fire and Ice'?", "Hatred and cold indifference", listOf("Fresh rain", "Winter festival", "Kindness"), "बर्फ घृणा व संवेदनहीनता का प्रतीक है।"))
            )
            "c10_ff_p3" -> Triple(
                listOf(
                    st(1, "He stalks in his vivid stripes...", "मखमली पंजों वाला बाघ पिंजरे में शांत क्रोध से टहलता है।", "पिंजरे में कैद शक्ति की लाचारी।", "Oxymoron: quiet rage."),
                    st(2, "Should be lurking in shadow near water hole...", "उसे तो जंगल में मोटे हिरण का शिकार करना चाहिए।", "स्वतंत्र वन जीवन की तुलना।", "Forest imagery."),
                    st(3, "Snarling around houses at jungle's edge...", "जंगल किनारे गाँव को अपने दाँतों से दहलाना चाहिए।", "प्राकृतिक गौरव।", "Auditory imagery."),
                    st(4, "Locked in a concrete cell... brilliant stars.", "रात में चमकते तारों को निहारते हुए आज़ादी का सपना।", "कैद बनाम आकाश।", "Metaphor & Contrast.")
                ),
                listOf(
                    dev("Oxymoron", "विरोधाभास", "Quiet rage", "शांत और क्रोध दो विपरीत शब्दों का मेल।"),
                    dev("Metaphor", "रूपक", "Pads of velvet quiet", "पंजों को मखमली बताया गया।")
                ),
                listOf(f("Where should the tiger be hunting plump deer?", "Near the water hole in the forest", listOf("Inside a zoo hall", "On a city bridge", "Inside a circus"), "जंगल के जलाशय (water hole) के पास।"))
            )
            "c10_ff_p4" -> Triple(
                listOf(
                    st(1, "If ever you should go by chance to jungles in the east...", "एशियाई शेर दहाड़कर और बंगाल टाइगर धारियों से पहचान में आता है।", "खतरनाक जीवों का विनोदी वर्णन।", "Poetic license: dyin'."),
                    st(2, "He'll only lep and lep again...", "धब्बेदार तेंदुआ बार-बार छलाँग लगाता है।", "'Leopard' और 'lep' की शब्द-क्रीड़ा।", "Repetition."),
                    st(3, "Who hugs you very, very hard... Bear / Hyena / Crocodile.", "भालू कसकर गले लगाता है, लकड़बग्घा मुस्कुराता है व मगरमच्छ रोता है।", "मुहावरों का रोचक उपयोग।", "Humour."),
                    st(4, "If there is nothing on the tree, 'tis the chameleon you see.", "अदृश्य-सा दिखने वाला गिरगिट पेड़ पर छिपा रहता है।", "रंग बदलने की अद्भुत कला।", "Paradox.")
                ),
                listOf(
                    dev("Poetic License", "काव्य स्वतंत्रता", "lep and lep / dyin'", "शब्द रूप में रचनात्मक परिवर्तन।"),
                    dev("Humour & Paradox", "हास्य व विरोधाभास", "Nothing on the tree = Chameleon", "रंग बदलने पर चतुर व्यंग्य।")
                ),
                listOf(f("Which beast is identified by a tight loving-looking hug?", "The Bear", listOf("The Leopard", "The Hyena", "The Lion"), "भालू (Bear) कसकर गले लगाने से पहचाना जाता है।"))
            )
            "c10_ff_p5" -> Triple(
                listOf(
                    st(1, "Merrily bouncing down the street into the water!", "बच्चे की प्यारी गेंद बंदरगाह के पानी में जा गिरी।", "गेंद संग बचपन की यादें जुड़ी थीं।", "Anaphora: Merrily."),
                    st(2, "I would not intrude on him; A dime is worthless.", "कवि पैसे देकर बच्चे के आत्म-चिंतन में बाधा नहीं डालते।", "प्रथम जिम्मेदारी का एहसास।", "Deep emotion."),
                    st(3, "Money is external.", "पैसा बाहरी है; वह खोई हुई भावना नहीं खरीद सकता।", "भौतिक बनाम मानसिक मूल्य।", "Metaphor: Balls."),
                    st(4, "The epistemology of loss, how to stand up...", "नुकसान सहकर फिर से खड़े होना सीखना ही जीवन है।", "परिपक्वता का महान पाठ।", "Philosophical moral.")
                ),
                listOf(
                    dev("Metaphor", "रूपक", "Balls stand for dear possessions & memories", "गेंद जीवन की प्रिय वस्तुओं का प्रतीक।"),
                    dev("Repetition", "पुनरावृत्ति", "Balls, balls / What, what", "भावनात्मक आघात को उभारता है।")
                ),
                listOf(f("Where did the boy's ball fall?", "Into the harbour water", listOf("Into a deep well", "On a highway", "On a rooftop"), "गेंद बंदरगाह (harbour) के पानी में जा गिरी।"))
            )
            "c10_ff_p6" -> Triple(
                listOf(
                    st(1, "Don't bite your nails... (Mermaid in emerald sea)", "टोका-टाकी के बीच हरे समुद्र की शांत जलपरी बनने का सपना।", "शांति की तलाश।", "Allusion: Mermaid."),
                    st(2, "Did you finish your homework... (Orphan roaming the street)", "अनाथ बनकर धूल में आज़ादी महसूस करना—मौन सुनहरा है।", "अति नियंत्रण का दुष्प्रभाव।", "Metaphor: Silence is golden."),
                    st(3, "Don't eat that chocolate... (Rapunzel in a tower)", "मीनार में अकेली रॅपन्ज़ेल जो बाल नीचे नहीं लटकाएगी।", "एकांत की रक्षा।", "Allusion: Rapunzel."),
                    st(4, "Stop that sulking... Anyone would think I nagged!", "लोग क्या सोचेंगे इसकी चिंता, बच्चे के मन की नहीं।", "अभिभावक व्यवहार पर व्यंग्य।", "Irony.")
                ),
                listOf(
                    dev("Allusion", "पौराणिक संदर्भ", "Mermaid & Rapunzel", "कल्पना के आज़ाद पात्रों का प्रयोग।"),
                    dev("Metaphor", "रूपक", "Silence is golden, freedom is sweet", "स्वतंत्रता की सुंदर तुलना।")
                ),
                listOf(f("Why was Amanda forbidden to eat chocolate?", "Because of her acne (pimples)", listOf("Because of fever", "Because of exam", "Because it melted"), "चेहरे के मुंहासों (acne) के कारण उसे चॉकलेट से मना किया गया।"))
            )
            "c10_ff_p7" -> Triple(
                listOf(
                    st(1, "The trees inside are moving out into the forest...", "अंदर बंद पेड़ खाली पड़े जंगल की ओर लौट रहे हैं।", "प्रकृति और बंधन से मुक्ति।", "Personification."),
                    st(2, "Like newly discharged patients... roots work all night...", "फर्श की दरारों से निकलकर टहनियाँ बाहर बढ़ रही हैं।", "लंबी कैद से छूटने का संघर्ष।", "Simile."),
                    st(3, "Writing long letters... smell of leaves and lichen...", "कमरे में अब भी पत्तों की खुशबू व फुसफुसाहट गूँजती है।", "प्रकृति का मूक संदेश।", "Sensory imagery."),
                    st(4, "The glass is breaking... moon broken like a mirror.", "काँच टूटते ही पेड़ रात में आज़ाद हो जाते हैं।", "बाधाओं पर विजय।", "Simile: broken mirror.")
                ),
                listOf(
                    dev("Simile", "उपमा", "like newly discharged patients / broken like a mirror", "जीवंत तुलनाएँ।"),
                    dev("Symbolism", "प्रतीक", "Trees leaving house = Women achieving freedom", "सशक्त नारीवादी रूपक।")
                ),
                listOf(f("What breaks as the trees stumble out into the night?", "The glass (window panes/veranda glass)", listOf("Stone pillars", "Wooden fences", "Iron bridges"), "काँच टूटने (The glass is breaking) की आवाज़ गूँजती है।"))
            )
            "c10_ff_p8" -> Triple(
                listOf(
                    st(1, "The fog comes on little cat feet... and then moves on.", "कोहरा बिल्ली के पंजों की तरह चुपके आकर शहर-बंदरगाह को देखता और लौट जाता है।", "छह पंक्तियों में प्रकृति का सुंदर रूपक।", "Extended Metaphor.")
                ),
                listOf(
                    dev("Extended Metaphor", "विस्तृत रूपक", "Fog compared to a cat throughout", "पूरी कविता कोहरे और बिल्ली की एकरूपता दिखाती है।"),
                    dev("Free Verse", "मुक्त छंद", "Six short unrhymed lines", "आधुनिक हाइकू जैसी संक्षिप्तता।")
                ),
                listOf(f("How many lines does Carl Sandburg's poem 'Fog' contain?", "Six lines", listOf("Fourteen lines", "Twelve lines", "Twenty lines"), "'Fog' केवल 6 पंक्तियों की संक्षिप्त कविता है।"))
            )
            "c10_ff_p9" -> Triple(
                listOf(
                    st(1, "Belinda lived in a little white house... Ink, Blink, Mustard, Custard.", "चार प्यारे पालतू जीवों और बेलिंडा का हास्य परिचय।", "कस्टर्ड एक पालतू ड्रैगन है।", "Ballad intro."),
                    st(2, "Custard cried for a nice safe cage.", "खूंखार दिखने पर भी शांत कस्टर्ड पिंजरा माँगता व सबका मज़ाक सहता है।", "दिखावा न करने वाला शांत स्वभाव।", "Simile: mouth like fireplace."),
                    st(3, "Pirate broke in... all boasters fled!", "डाकू को देखते ही कुत्ता, बिल्ली, चूहा भाग निकले।", "झूठे बहादुरों की असलियत।", "Climax."),
                    st(4, "Custard gobbled the pirate completely!", "कस्टर्ड ने निडरता से डाकू को खाकर सबको बचाया।", "सच्ची वीरता कर्म से दिखती है।", "Moral ending.")
                ),
                listOf(
                    dev("Simile", "उपमा", "snorting like an engine / as brave as a tiger", "रोचक व मजेदार तुलनाएँ।"),
                    dev("Onomatopoeia", "ध्वन्यात्मकता", "Meowch, weeck, clatter, clank", "कविता को नाटकीय बनाती है।")
                ),
                listOf(f("What did the boasters call Custard playfully in mockery?", "Percival", listOf("Hercules", "Arthur", "Sherry"), "वे मज़ाक में उसे राजा आर्थर के शूरवीर 'पर्सिवल' (Percival) कहकर चिढ़ाते थे।"))
            )
            else -> Triple(
                listOf(
                    st(1, "Great honey-coloured ramparts at your ear...", "युवा लोग तुम्हारे सुनहरे बालों के बाहरी आकर्षण पर मोहित रहते हैं।", "बाहरी सुंदरता बनाम आंतरिक गुण।", "Metaphor: ramparts."),
                    st(2, "Get a hair-dye... brown, or black, or carrot...", "मैं बालों का रंग बदलकर सच्चे प्रेम की परीक्षा लूँगी।", "रूप की नश्वरता का बोध।", "Bold response."),
                    st(3, "Only God, my dear, could love you for yourself alone.", "केवल ईश्वर ही बाहरी आवरण के बिना आत्मा से प्रेम कर सकते हैं।", "आध्यात्मिक सत्य की जीत।", "Theme climax.")
                ),
                listOf(
                    dev("Metaphor", "रूपक", "Honey-coloured ramparts", "सुनहरे बालों को किले की दीवार कहा गया।"),
                    dev("Rhyme Scheme", "तुक योजना", "ABCBDB", "सुंदर संगीतमय संवाद।")
                ),
                listOf(f("Why does Anne Gregory plan to dye her hair brown or carrot?", "So men might love her inner self rather than her yellow hair", listOf("To act in a play", "To join an army", "Because snow spoiled it"), "ताकि लोग बाहरी बालों के बजाय उसके असली व्यक्तित्व से प्रेम करें।"))
            )
        }

        ChapterRichSpec(
            chapterId = poem.id,
            detailedHindiTeaching = "इमरान गोरी सर द्वारा Class 10 पद्यांश-वार व्याख्या: ${poem.hindiExplanation}",
            paragraphs = emptyList(),
            characters = listOf(
                ch(poem.author, "${poem.author} (कवि / वक्ता)", "कविता '${poem.title}' के रचनाकार", listOf("प्रकृति प्रेमी", "सूक्ष्म अवलोकनकर्ता", "प्रेरणादायक"), "${poem.author} ने अत्यंत कम शब्दों में जीवन के गहरे सत्य को सरल व काव्यात्मक शैली में प्रस्तुत किया है।", "${poem.author} expresses deep universal truths through concise, memorable imagery in '${poem.title}'.")
            ),
            cartoonScenes = listOf(
                sc(1, "कविता परिचय: ${poem.title}", "Welcome to Poetry", "नमस्ते बच्चों! मैं हूँ इमरान सर। आज सीखें Class 10 की कविता '${poem.title}' (${poem.author})!", "Imran Sir", poem.author, CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Poet Intro"),
                sc(2, "मुख्य दृश्य व कल्पना", "Poem Imagery", poem.summaryHi, "Poet", "Nature", CartoonSetting.HOME_GARDEN, CartoonMood.THOUGHTFUL, "Visual Scene"),
                sc(3, "अलंकार व काव्य जादू", "Poetic Craft", "आइए देखें इस कविता के खास Poetic Devices, Rhyme Scheme और Board Extract प्रश्न!", "Imran Sir", "Students", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Devices Magic"),
                sc(4, "बोर्ड परीक्षा 100% तैयारी", "Exam Mastery", "अब 30+ Poem MCQs, Central Idea और Short/Long प्रश्न हल करके बोर्ड में पूरे अंक पाएं!", "Imran Sir", "Toppers", CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Exam Ready")
            ),
            extraFacts = ps.third,
            themeEn = poem.themeEn,
            themeHi = poem.themeHi,
            messageHi = poem.summaryHi,
            poemSpec = PoemRichSpec(
                poetIntroEn = "${poem.author} is a renowned poet whose work '${poem.title}' is an essential part of MPBSE Class 10 First Flight.",
                poetIntroHi = "${poem.author} एक सुप्रसिद्ध रचनाकार हैं जिनकी कविता '${poem.title}' MP बोर्ड कक्षा 10वीं (First Flight) का अनिवार्य भाग है।",
                centralIdeaEn = poem.summaryEn,
                centralIdeaHi = poem.summaryHi,
                themeEn = poem.themeEn,
                themeHi = poem.themeHi,
                hindiTranslationAndInterpretation = "${poem.summaryHi}\n\nसंपूर्ण सरल भावार्थ: ${poem.hindiExplanation}",
                stanzas = ps.first,
                poeticDevices = ps.second
            )
        )
    }.associateBy { it.chapterId }
}
