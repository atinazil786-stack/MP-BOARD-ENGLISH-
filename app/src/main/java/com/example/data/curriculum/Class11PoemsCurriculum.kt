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

object Class11PoemsCurriculum {

    val poems: List<Chapter> = listOf(
        makePoemChapter(
            id = "c11_hb_p1",
            classLevel = 11,
            bookName = "Hornbill",
            poemNumber = 1,
            title = "A Photograph",
            titleHi = "एक छायाचित्र (फोटोग्राफ)",
            poet = "Shirley Toulson",
            summaryEn = "Shirley Toulson gazes at an old cardboard photograph showing her twelve-year-old mother smiling on a sea holiday with cousins Betty and Dolly. She contrasts the changeless ocean with transient human life—first mourning her mother's childhood and now falling silent over her mother's death.",
            summaryHi = "कवयित्री शर्ली टूलसन एक पुराने कार्डबोर्ड पर लगी अपनी माँ की बारह वर्ष की समुद्र-तट वाली तस्वीर देखती हैं। वे अस्थायी मानव जीवन और अपरिवर्तनीय समुद्र की तुलना करते हुए अपनी दिवंगत माँ की मधुर हँसी को याद कर निःशब्द हो जाती हैं।",
            hindiExplanation = "इस भावुक कविता में समय के तीन चरण हैं। पहले चरण में लगभग 12 वर्षीय माँ अपनी चचेरी बहनों बेट्टी और डॉली का हाथ थामे समुद्र में खड़ी मुस्कुरा रही हैं, जबकि उनके चाचा तस्वीर खींच रहे हैं। दूसरे चरण में बीस-तीस वर्ष बाद माँ खुद अपनी वह तस्वीर देखकर हँसती थीं। तीसरे चरण में आज माँ को गुज़रे लगभग बारह वर्ष हो चुके हैं और कवयित्री के पास उनकी याद में कहने को शब्द ही नहीं बचे—केवल उसकी चुप्पी ही सबको चुप कर देती है!",
            themeEn = "Time erodes human life swiftly while nature endures; bereavement leaves a silence beyond words.",
            themeHi = "समुद्र और प्रकृति स्थिर हैं किंतु समय मनुष्य का जीवन तेज़ी से बदल देता है; अपनों के जाने का दुःख शब्दों से परे एक गहरा सन्नाटा छोड़ जाता है।",
            words = listOf(
                w("Cardboard", "noun", "Thick stiff paper holding the old photo", "गत्ता / पुराना फोटो फ्रेम", "The cardboard shows me how it was."),
                w("Paddling", "verb", "Walking cheerfully in shallow sea water", "उथले पानी में नंगे पाँव चलना", "The two girl cousins went paddling on the beach."),
                w("Transient", "adj", "Lasting only for a short time", "क्षणभंगुर / अस्थायी", "The sea washed their terribly transient feet."),
                w("Wry", "adj", "Dryly ironic / bittersweet", "खट्टा-मीठा / व्यंग्यात्मक", "Both wry with the laboured ease of loss."),
                w("Silence silences", "phrase", "Deep quietness of death leaves no words", "मौन की गहरी निस्तब्धता", "Its silence silences.")
            ),
            matchPairs = listOf(
                MatchPair("Big girl", "The poet's twelve-year-old mother"),
                MatchPair("Betty and Dolly", "Two smiling cousins holding her hands"),
                MatchPair("Sea", "Changed far less than mortal humans"),
                MatchPair("Laboured ease of loss", "Oxymoron expressing bittersweet grief")
            ),
            stanzas = listOf(
                st(1, "The cardboard shows me how it was When the two girl cousins went paddling, Each one holding one of my mother's hands, And she the big girl — some twelve years or so.", "वह पुराना गत्ते वाला फोटो दिखाता है कि कैसा समय था जब दोनों चचेरी बहनें पानी में चल रही थीं, मेरी माँ के दोनों हाथ पकड़े हुए, और माँ सबसे बड़ी थीं—लगभग बारह वर्ष की।", "पहली अवस्था: कवयित्री की माँ के बचपन की समुद्री सैर का मधुर दृश्य।", "Alliteration: 'stood still to smile', 'terribly transient'."),
                st(2, "Some twenty — thirty — years later She'd laugh at the snapshot. 'See Betty And Dolly,' she'd say, 'and look how they Dressed us for the beach.'", "कुछ बीस-तीस वर्ष बाद वे उस तस्वीर को देखकर हँसतीं और कहतीं—'बेट्टी और डॉली को देखो, समुद्र तट के लिए हमें कैसे सजाया गया था!'", "दूसरी अवस्था: माँ का अपने बीते बचपन को मुस्कुराकर याद करना।", "Contrast: 'Sea holiday was her past, mine is her laughter'."),
                st(3, "Now she's been dead nearly as many years As that girl lived. And of this circumstance There is nothing to say at all. Its silence silences.", "अब उन्हें मरे हुए लगभग उतने ही वर्ष हो चुके हैं जितने साल वह लड़की फोटो में जी थी। और इस स्थिति के बारे में कहने को कुछ नहीं है—उसकी चुप्पी ही सबको मौन कर देती है।", "तीसरी अवस्था: कवयित्री की माँ की मृत्यु के बाद का निशब्द शोक।", "Oxymoron & Personification: 'Its silence silences'.")
            ),
            poeticDevices = listOf(
                dev("Oxymoron (विरोधाभास)", "विरोधाभास अलंकार", "Laboured ease of loss", "'कठिन' (laboured) और 'सरल' (ease) शब्दों का भावपूर्ण संयोजन।"),
                dev("Transferred Epithet", "स्थानांतरित विशेषण", "Terribly transient feet", "जीवन की नश्वरता का गुण 'पैरों' पर आरोपित किया गया।"),
                dev("Alliteration (अनुप्रास)", "अनुप्रास अलंकार", "Stood still to smile / Silence silences", "'s' तथा 't' ध्वनियों की मधुर आवृत्ति।"),
                dev("Personification", "मानवीकरण", "Its silence silences", "चुप्पी को मानवीय क्रिया करते दिखाया गया।")
            ),
            extraFacts = listOf(
                f("How old was Shirley Toulson's mother in the cardboard photograph?", "About twelve years old", listOf("Eight years old", "Twenty years old", "Five years old"), "तस्वीर में कवयित्री की माँ लगभग 12 वर्ष की ('some twelve years or so') थीं।"),
                f("What does the phrase 'Its silence silences' convey?", "The overwhelming quiet emptiness after her mother's death leaves no words", listOf("A noisy sea storm", "A cheerful song", "Camera click sound"), "माँ की मृत्यु के बाद की गहरी निस्तब्धता कवयित्री को निःशब्द कर देती है।")
            )
        ),
        makePoemChapter(
            id = "c11_hb_p2",
            classLevel = 11,
            bookName = "Hornbill",
            poemNumber = 2,
            title = "The Laburnum Top",
            titleHi = "अमलतास का शिखर",
            poet = "Ted Hughes",
            summaryEn = "In yellow September sunlight, a silent, seemingly lifeless Laburnum tree bursts into vibrant motion when a goldfinch arrives to feed her young ones hidden in the thickness of branches—comparing the tree to an engine started by the mother bird before she flies away, leaving it empty again.",
            summaryHi = "सितंबर की पीली धूप में शांत और निश्चल खड़ा अमलतास (Laburnum) का वृक्ष जैसे ही एक सोनचिड़िया (Goldfinch) के घोंसले में आने से जीवंत हो उठता है, मानो कोई इंजन स्टार्ट हो गया हो! बच्चों को दाना खिलाकर पक्षी पुनः अनंत आकाश में उड़ जाता है और पेड़ फिर शांत हो जाता है।",
            hindiExplanation = "टेड ह्यूजेस प्रकृति में माँ और संतान के जीवंत रिश्ते को दिखाते हैं। शुरू में पतझड़ की धूप में अमलतास के पत्ते पीले हो रहे हैं और बीज गिर रहे हैं। अचानक सोनचिड़िया (Goldfinch) फड़फड़ाहट के साथ आती है और छिपकली जैसी फुर्ती से शाखाओं के भीतर घुस जाती है। पूरा पेड़ पंखों की फड़फड़ाहट व चहचहाहट से थर्राने लगता है मानो परिवार का इंजन चालू हो गया हो! अंत में वह शांत सीटी जैसी ध्वनि के साथ आकाश में उड़ जाती है और पेड़ पुनः मौन (subsides to empty) हो जाता है।",
            themeEn = "Maternal care infuses silent nature with vibrant energy, rhythm, and purpose.",
            themeHi = "मातृत्व का स्पर्श और जीवन की गति सबसे शांत प्रकृति में भी ऊर्जा और संगीत भर देती है।",
            words = listOf(
                w("Laburnum", "noun", "A small tree with hanging yellow flowers", "अमलतास का वृक्ष", "The laburnum top is silent, quite still."),
                w("Goldfinch", "noun", "Small singing bird with bright yellow feathers", "सोनचिड़िया", "Till the goldfinch comes, with a twitching chirrup."),
                w("Sleek", "adj", "Smooth, streamlined, and swift", "चिकना व फुर्तीला", "She enters the thickness sleek as a lizard."),
                w("Tremor", "noun", "Shaking or trembling vibration", "कंपन / थरथराहट", "A machine starts up of chitterings and a tremor of wings."),
                w("Eerie", "adj", "Strange, delicate, and mysterious", "विचित्र / रहस्यमयी", "With eerie delicate whistle-chirrup whisperings she launches away.")
            ),
            matchPairs = listOf(
                MatchPair("September sunlight", "Yellowing autumn afternoon"),
                MatchPair("Sleek as a lizard", "Simile for cautious goldfinch"),
                MatchPair("Engine of her family", "Metaphor for bustling nest"),
                MatchPair("Subsides to empty", "Silent stillness after departure")
            ),
            stanzas = listOf(
                st(1, "The Laburnum top is silent, quite still In the afternoon yellow September sunlight, A few leaves yellowing, all its seeds fallen.", "अमलतास का ऊपरी भाग बिल्कुल शांत और निश्चल है, सितंबर की पीली दोपहरी में कुछ पत्ते पीले पड़ रहे हैं और सारे बीज झड़ चुके हैं।", "कविता शांत और नीरस पतझड़ दृश्य से आरंभ होती है।", "Visual imagery: पीला रंग दोनों धूप और पत्तों में एकरूपता दिखाता है।"),
                st(2, "Till the goldfinch comes, with a twitching chirrup... Then sleek as a lizard, and alert, and abrupt, She enters the thickness, and a machine starts up...", "जब तक कि एक सोनचिड़िया चहचहाहट के साथ नहीं आती... फिर छिपकली की तरह फिसलती, सतर्क व अचानक वह घनी पत्तियों में घुसती है और मानो चहचहाने की एक मशीन चालू हो जाती है!", "सोनचिड़िया के आते ही घोंसले में बच्चों की चहचहाहट से पेड़ जीवंत हो उठता है।", "Simile & Metaphor: 'Sleek as a lizard' और 'a machine starts up'."),
                st(3, "It is the engine of her family. She stokes it full... Then with eerie delicate whistle-chirrup whisperings She launches away, towards the infinite And the laburnum subsides to empty.", "वह अपने परिवार रूपी इंजन में ऊर्जा भरती है... फिर कोमल सीटी जैसी आवाज़ कर अनंत आकाश की ओर उड़ जाती है, और अमलतास फिर से शून्य व शांत हो जाता है।", "परस्पर निर्भरता: पेड़ और पक्षी एक-दूसरे को सुरक्षा व जीवन प्रदान करते हैं।", "Onomatopoeia: chirrup, chitterings, trillings, whistle-chirrup.")
            ),
            poeticDevices = listOf(
                dev("Simile (उपमा)", "उपमा अलंकार", "Sleek as a lizard", "सोनचिड़िया की फुर्ती की तुलना छिपकली से।"),
                dev("Metaphor (रूपक)", "रूपक अलंकार", "It is the engine of her family", "चिड़िया और उसके घोंसले को परिवार रूपी इंजन कहा गया।"),
                dev("Onomatopoeia", "ध्वनि-अनुकरण", "Twitching chirrup, chitterings, trillings", "चिड़ियों की चहचहाहट को शब्द-ध्वनियों में जीवंत करना।"),
                dev("Transferred Epithet", "स्थानांतरित विशेषण", "Her barred face identity mask", "धारीदार चेहरे को पहचान का मुखौटा बताया।")
            ),
            extraFacts = listOf(
                f("Which month and colour dominate the opening scene of 'The Laburnum Top'?", "Yellow September afternoon", listOf("Green July morning", "White January night", "Red May noon"), "कविता की शुरुआत सितंबर की पीली दोपहरी से होती है।"),
                f("Why is the goldfinch compared to an 'engine'?", "Just as fuel starts a quiet machine, her arrival fills the silent nest and tree with sound and motion", listOf("Because she flies like an aeroplane", "Because her beak is iron", "Because the tree makes smoke"), "जैसे इंजन ऊर्जा से मशीन चलाता है, वैसे ही सोनचिड़िया के आते ही पूरा वृक्ष व घोंसला सक्रिय हो जाता है।")
            )
        ),
        makePoemChapter(
            id = "c11_hb_p3",
            classLevel = 11,
            bookName = "Hornbill",
            poemNumber = 3,
            title = "The Voice of the Rain",
            titleHi = "वर्षा की आवाज़",
            poet = "Walt Whitman",
            summaryEn = "Walt Whitman asks a gentle shower 'Who art thou?' and receives a poetic answer: the rain is the 'Poem of Earth', rising invisibly from land and bottomless sea to heaven, purifying droughts and returning to nurture seeds—just as a song returns to its creator with love.",
            summaryHi = "कवि वॉल्ट व्हिटमैन हल्की फुहार से पूछते हैं—'तुम कौन हो?' और वर्षा स्वयं को 'पृथ्वी की कविता' बताती है। यह भूमि व अथाह सागर से अदृश्य भाप बनकर आकाश में जाती है, रूप बदलकर पुनः धरती पर बरसती है, सूखे को धोकर बीजों को जीवन देती है—बिल्कुल उस गीत की तरह जो प्रेम से अपने रचयिता के पास लौट आता है!",
            hindiExplanation = "वॉल्ट व्हिटमैन ने वर्षा और कविता (संगीत) के बीच सुंदर समानांतर चित्र खींचा है। वर्षा कभी न छुई जा सकने वाली जलवाष्प के रूप में ऊपर उठती है और बादल बनकर पुनः अपने जन्मस्थान (धरती) पर लौटती है। यदि वर्षा न लौटे तो बीज छिपे व अजन्मे (unborn) ही रह जाएँगे। इसी प्रकार कवि का गीत भी हृदय से निकलकर दुनिया भर में गूँजने के बाद प्यार लेकर अपने स्रोत के पास लौट आता है!",
            themeEn = "Rain's eternal hydrological cycle nurtures Earth just as art and poetry enrich and return joy to humanity.",
            themeHi = "वर्षा का चक्रीय जीवन-दान पृथ्वी को जीवित रखता है, ठीक वैसे ही जैसे श्रेष्ठ संगीत व कविता सृजनकर्ता को प्रेम लौटाते हैं।",
            words = listOf(
                w("Impalpable", "adj", "Unable to be felt by touch", "अस्पृश्य / जिसे छुआ न जा सके", "Rain rises impalpable out of the land and bottomless sea."),
                w("Lave", "verb", "Wash or cleanse gently", "धोना / पवित्र करना", "I descend to lave the droughts and dust-layers of the globe."),
                w("Latent", "adj", "Present but hidden / dormant", "सुप्त / छिपा हुआ", "Without rain, seeds would remain only latent and unborn."),
                w("Vaguely formed", "phrase", "Shaped loosely like clouds", "अस्पष्ट आकार (बादल)", "Upward to heaven, vaguely formed, altogether changed."),
                w("Reck'd or unreck'd", "phrase", "Cared for or ignored by listeners", "सुने जाने या अनसुने रहने पर भी", "Song returns duly with love, reck'd or unreck'd.")
            ),
            matchPairs = listOf(
                MatchPair("Poem of Earth", "Rain's own proud identity"),
                MatchPair("Impalpable", "Invisible water vapour rising"),
                MatchPair("Latent seeds", "Awakened to life by rain"),
                MatchPair("Song analogy", "Returns to creator with love")
            ),
            stanzas = listOf(
                st(1, "And who art thou? said I to the soft-falling shower, Which, strange to tell, gave me an answer, as here translated: I am the Poem of Earth, said the voice of the rain,", "और मैंने धीरे-धीरे गिरती बौछार से पूछा—'तुम कौन हो?' और अचरज की बात, उसने मुझे उत्तर दिया जिसका अनुवाद है: 'मैं पृथ्वी की कविता हूँ,' वर्षा की आवाज़ ने कहा।", "कवि और वर्षा के बीच काव्यात्मक संवाद प्रारंभ होता है।", "Personification: वर्षा बोलकर स्वयं को 'पृथ्वी की कविता' बताती है।"),
                st(2, "Eternal I rise impalpable out of the land and the bottomless sea, Upward to heaven, whence, vaguely formed, altogether changed, and yet the same,", "अनवरत मैं भूमि और अथाह सागर से अदृश्य रूप में ऊपर आकाश की ओर उठती हूँ, जहाँ बादल रूप में बिल्कुल बदलकर भी मैं वही रहती हूँ।", "वैज्ञानिक जल-चक्र (वाष्पीकरण व संघनन) का सुंदर काव्यात्मक वर्णन।", "Hyperbole & Paradox: 'bottomless sea', 'altogether changed, and yet the same'."),
                st(3, "I descend to lave the droughts, atomies, dust-layers of the globe... And forever, by day and night, I give back life to my own origin, and make pure and beautify it; (For song, issuing from its birth-place, after fulfilment, wandering, Reck'd or unreck'd, duly with love returns.)", "मैं सूखे, सूक्ष्म कणों और धूल की परतों को धोने नीचे आती हूँ और रात-दिन अपने ही जन्मस्थान को जीवन व सौंदर्य लौटाती हूँ। (क्योंकि गीत भी अपने जन्मस्थान से निकलकर पूर्ण होकर प्रेम सहित लौट आता है।)", "वर्षा और कविता दोनों निःस्वार्थ होकर सृष्टि का कल्याण करती हैं।", "Parallelism: वर्षा और गीत (Song) की समान प्रकृति।")
            ),
            poeticDevices = listOf(
                dev("Personification", "मानवीकरण अलंकार", "I am the Poem of Earth, said the voice of the rain", "वर्षा को सजीव वक्ता बनाया गया है।"),
                dev("Metaphor (रूपक)", "रूपक अलंकार", "I am the Poem of Earth", "वर्षा को धरती की कविता कहा गया।"),
                dev("Hyperbole (अतिशयोक्ति)", "अतिशयोक्ति अलंकार", "Bottomless sea", "समुद्र की गहराई को अनंत दिखाने हेतु।"),
                dev("Parallelism / Simile", "समानांतरता", "Comparison between Rain and Song", "गीत की तरह वर्षा का लौट आना।")
            ),
            extraFacts = listOf(
                f("How does the rain describe herself in 'The Voice of the Rain'?", "As the Poem of Earth", listOf("As the Thunder of Sky", "As the Queen of Oceans", "As the Tears of Clouds"), "वर्षा स्वयं को 'पृथ्वी की कविता' (the Poem of Earth) कहती है।"),
                f("Why are the last two lines enclosed in brackets in 'The Voice of the Rain'?", "They represent the poet's personal parallel reflection comparing rain to a song", listOf("Because they were spoken by clouds", "They are a stage direction", "They are a bibliography"), "कोष्ठक की अंतिम दो पंक्तियाँ कवि का अपना विचार हैं जो वर्षा और गीत की समानता दर्शाती हैं।")
            )
        ),
        makePoemChapter(
            id = "c11_hb_p4",
            classLevel = 11,
            bookName = "Hornbill",
            poemNumber = 4,
            title = "Childhood",
            titleHi = "बचपन (चाइल्डहुड)",
            poet = "Markus Natten",
            summaryEn = "Markus Natten wonders at what precise moment his innocent childhood slipped away: Was it when he turned eleven, realized Heaven and Hell didn't exist on maps, saw adults preach love while acting hypocritically, or discovered his mind was truly independent? He concludes childhood hides in an infant's innocent face.",
            summaryHi = "कवि मार्कस नैटन सोचते हैं कि उनका मासूम बचपन आखिर किस पल चला गया—क्या तब जब वे ग्यारह वर्ष के हुए, या जब जाना कि स्वर्ग-नर्क भूगोल में नहीं मिलते, या जब बड़ों के दोहरे चरित्र (कहनी और करनी में अंतर) को समझा, या जब स्वतंत्र विचार की शक्ति खोजी? अंत में वे पाते हैं कि खोया बचपन किसी नन्हे शिशु के निश्छल चेहरे में छिपा है!",
            hindiExplanation = "कविता दो प्रश्न पूछती है: बचपन *कब* गया और बचपन *कहाँ* गया? पहले तीन छंदों में कवि तर्कवाद (rationalism—11 वर्ष में स्वर्ग-नर्क न मिलना), वयस्कों के पाखंड की पहचान (preach vs practise love), और आत्म-चेतना (individuality—मेरा मन वास्तव में मेरा अपना है!) को बचपन जाने का कारण मानते हैं। अंतिम छंद में वे शांतिपूर्वक स्वीकार करते हैं कि बचपन किसी भूले-बिसरे स्थान पर जाकर किसी छोटे बच्चे के निष्कपट चेहरे में बस गया है।",
            themeEn = "Growing up trades simple innocence for rational thinking, awareness of hypocrisy, and individual thought.",
            themeHi = "बड़े होने की प्रक्रिया में व्यक्ति की तर्कशक्ति, यथार्थ बोध और स्वतंत्र विचार जागृत होते हैं, जिससे सहज मासूमियत पीछे छूट जाती है।",
            words = listOf(
                w("Ceased", "verb", "Came to an end / stopped", "समाप्त हो गया", "When did my childhood go? Was it the day I ceased to be eleven?"),
                w("Geography", "noun", "Scientific study of maps and places", "भूगोल", "Hell and Heaven could not be found in Geography."),
                w("Preached", "verb", "Advised publicly on morals", "उपदेश दिया", "Adults preached of love yet failed to act so lovingly."),
                w("Individuality", "noun", "Independent mind of one's own", "निजता / स्वतंत्र व्यक्तित्व", "He discovered his mind could produce its own thoughts."),
                w("Infant", "noun", "Very young innocent baby", "नन्हा शिशु", "Childhood lies hidden in an infant's face.")
            ),
            matchPairs = listOf(
                MatchPair("Stanza 1 (Rationalism)", "Hell & Heaven missing from Geography"),
                MatchPair("Stanza 2 (Hypocrisy)", "Adults didn't practise love they preached"),
                MatchPair("Stanza 3 (Individuality)", "My mind was really mine to use"),
                MatchPair("Stanza 4 (Location)", "Hidden in an infant's innocent face")
            ),
            stanzas = listOf(
                st(1, "When did my childhood go? Was it the day I ceased to be eleven, Was it the time I realised that Hell and Heaven, Could not be found in Geography...", "मेरा बचपन कब चला गया? क्या वह दिन जब मैं ग्यारह वर्ष का नहीं रहा, या जब मैंने जाना कि स्वर्ग और नर्क भूगोल की किताब में नहीं मिलते...", "तार्किक बुद्धि का विकास बचपन जाने का पहला संकेत है।", "Refrain: 'When did my childhood go?'"),
                st(2, "Was it the time I realised that adults were not All they seemed to be, They talked of love and preached of love, But did not act so lovingly...", "या वह समय जब मैंने समझा कि बड़े जैसे दिखते हैं वैसे होते नहीं—वे प्रेम की बातें करते हैं पर वैसा आचरण नहीं करते?", "बड़ों के दोहरे व्यवहार (पाखंड) की पहचान।", "Irony: उपदेश और व्यवहार के बीच विरोधाभास।"),
                st(3, "Was it the time I found my mind was really mine, To use whichever way I choose, Producing thoughts that were not those of other people...", "या जब मुझे पता चला कि मेरा दिमाग सचमुच मेरा अपना है और मैं दूसरों से अलग स्वतंत्र विचार बना सकता हूँ?", "स्वतंत्र चिंतन और व्यक्तित्व की खोज।", "Alliteration: 'my mind', 'time', 'that were not'."),
                st(4, "Where did my childhood go? It went to some forgotten place, That's hidden in an infant's face, That's all I know.", "मेरा बचपन कहाँ गया? वह किसी भूले हुए स्थान पर चला गया, जो एक छोटे शिशु के चेहरे में छिपा है—बस इतना ही मैं जानता हूँ।", "कहाँ गया—शिशु की निर्दोष मुस्कान में बचपन सुरक्षित है।", "Poetic Shift: 'When' से 'Where' की ओर परिवर्तन।")
            ),
            poeticDevices = listOf(
                dev("Refrain (टेक)", "पुनरावृत्त पंक्ति", "When did my childhood go? / Was that the day!", "मुख्य प्रश्न को प्रत्येक स्टैंज़ा में दोहराया गया।"),
                dev("Antithesis (विरोधी विचार)", "विरोध अलंकार", "Hell and Heaven / talked of love vs did not act", "विपरीत शब्दों से विचार की गहराई बढ़ाना।"),
                dev("Alliteration (अनुप्रास)", "अनुप्रास अलंकार", "My mind / Hell and Heaven / The time", "व्यंजन ध्वनियों की मधुर आवृत्ति।"),
                dev("Rationalism & Metaphor", "बौद्धिक प्रतीक", "Hidden in an infant's face", "शिशु का चेहरा खोई निर्दोषता का प्रतीक है।")
            ),
            extraFacts = listOf(
                f("Where does the poet finally conclude his childhood has gone?", "Hidden in an infant's face", listOf("Inside old school books", "At the top of a mountain", "In another country"), "कवि के अनुसार उनका बचपन एक नन्हे शिशु के मासूम चेहरे में छिपा है।"),
                f("Which realization about adults shocked the poet's childhood innocence?", "Adults preached of love but did not act lovingly", listOf("Adults couldn't swim", "Adults forgot birthdays", "Adults hated music"), "बड़े लोग प्यार के उपदेश तो देते हैं पर वैसा प्रेमपूर्ण व्यवहार नहीं करते।")
            )
        ),
        makePoemChapter(
            id = "c11_hb_p5",
            classLevel = 11,
            bookName = "Hornbill",
            poemNumber = 5,
            title = "Father to Son",
            titleHi = "पिता का पुत्र के नाम संदेश",
            poet = "Elizabeth Jennings",
            summaryEn = "Elizabeth Jennings portrays the painful generation gap between a father and his grown-up son living under the same roof yet speaking like strangers. Despite misunderstandings and stubborn silence, the father longs to forgive, rebuild childhood warmth, and bridge their emotional distance.",
            summaryHi = "एलिज़ाबेथ जेनिंग्स एक ही घर में रहते हुए भी अजनबियों जैसे दूर हो चुके पिता और युवा पुत्र के बीच की 'पीढ़ी-अंतराल' (Generation Gap) की पीड़ा को दिखाती हैं। पिता दुःखी हैं कि वे अपने बेटे को समझ नहीं पा रहे, फिर भी वे क्षमा करके पुराना स्नेह लौटाने को व्याकुल हैं।",
            hindiExplanation = "पिता वर्षों से एक ही घर में रहते हुए भी अपने बेटे को अजनबी पाते हैं और बचपन के दिनों जैसा रिश्ता पुनः बनाना चाहते हैं। हालांकि उन्होंने खुद 'उड़ाऊ पुत्र' (Prodigal son) की तरह बेटे को जन्म दिया, लेकिन बेटा अलग दुनिया में रहता है। दोनों के बीच मौन (Silence) पसरा है। वे चाहते हैं कि बेटा घर लौटे—पिता अपने दुःख से नया प्यार गढ़ने और एक खाली हाथ दूसरे को थमाने को तैयार हैं ताकि क्षमा के साथ रिश्ता जुड़ सके।",
            themeEn = "Unspoken communication gaps divide parents and children, yet paternal love always yearns for reconciliation.",
            themeHi = "संवाद की कमी और पीढ़ियों का अंतर रिश्तों में मौन लाता है, फिर भी पिता का निस्वार्थ प्रेम हमेशा समझौते व क्षमा के लिए तत्पर रहता है।",
            words = listOf(
                w("Strangers", "noun", "People who do not know each other", "अजनबी", "We speak like strangers, there's no sign of understanding."),
                w("Prodigal", "adj", "Spending recklessly; biblical lost son", "फिजूलखर्च / भटका हुआ पुत्र", "Yet have I killed the seed I spent or sown it where the land is his and none of mine?"),
                w("Silence surrounds", "phrase", "Cold lack of communication", "चारों ओर सन्नाटा व संवादहीनता", "Silence surrounds us."),
                w("Grief", "noun", "Deep sorrow and heartache", "गहरा दुःख / व्यथा", "From sorrow I'd love to forgive him."),
                w("Longing", "noun", "Strong emotional yearning", "तीव्र चाह / लालसा", "We both must live on the same globe; each puts out an empty hand longing for something to forgive.")
            ),
            matchPairs = listOf(
                MatchPair("Speak like strangers", "Lack of mutual understanding"),
                MatchPair("The seed I spent", "Metaphor for father's upbringing effort"),
                MatchPair("Prodigal returning", "Biblical allusion to loving reconciliation"),
                MatchPair("Empty hand longing", "Quiet mutual desire to forgive")
            ),
            stanzas = listOf(
                st(1, "I do not understand this child Though we have lived together now In the same house for years. I know Nothing of him, so try to build Up a relationship from how He was when small.", "मैं इस बच्चे को समझ नहीं पाता यद्यपि हम वर्षों से एक ही घर में साथ रहे हैं। मैं उसके बारे में कुछ नहीं जानता, इसलिए जैसा वह बचपन में था वैसा रिश्ता फिर बनाना चाहता हूँ।", "एक ही छत के नीचे रहने पर भी वैचारिक दूरी।", "First-person monologue: पिता की असहाय पीड़ा।"),
                st(2, "Yet have I killed The seed I spent or sown it where The land is his and none of mine? We speak like strangers, there's no sign Of understanding in the air. This child is built to my design Yet what he loves I cannot share.", "क्या मैंने अपना बोया बीज नष्ट कर दिया या ऐसी ज़मीन में बोया जो अब केवल उसकी है मेरी नहीं? हम अजनबियों जैसा बोलते हैं; शक्ल मेरी पर पसंद उसकी अलग है।", "अजनबी जैसा व्यवहार और साझा भावनाओं की कमी।", "Metaphor: 'Seed' = पिता का दिया प्यार व संस्कार।"),
                st(3, "Silence surrounds us. I would have Him prodigal, returning to His father's house, the home he knew, Rather than see him make and move His world. I would forgive him too, Shaping from sorrow a new love.", "हमारे चारों ओर मौन छाया है। मैं चाहूँगा कि वह भटके हुए पुत्र की तरह अपने पिता के घर लौट आए—मैं उसे क्षमा करके दुःख से नया प्रेम गढ़ दूँगा।", "पिता बिना शर्त बेटे को माफ कर अपनाने को तैयार हैं।", "Biblical Allusion: Prodigal Son (बाइबिल का प्रसंग)।"),
                st(4, "Father and son, we both must live On the same globe and the same land, He speaks: I cannot understand Myself, why anger grows from grief. We each put out an empty hand, Longing for something to forgive.", "पिता और पुत्र, हमें इसी धरती पर साथ रहना है। वह कहता है—मैं खुद नहीं समझता कि दुःख से क्रोध क्यों जन्म लेता है। हम दोनों क्षमा के लिए खाली हाथ बढ़ाए रहते हैं।", "सुलह और क्षमा की साझा मानवीय आकांक्षा।", "Symbolism: 'Empty hand' = सुलह व क्षमा की अपेक्षा।")
            ),
            poeticDevices = listOf(
                dev("Simile (उपमा)", "उपमा अलंकार", "We speak like strangers", "पिता-पुत्र के संवाद की अजनबियों से तुलना।"),
                dev("Metaphor (रूपक)", "रूपक अलंकार", "The seed I spent / Shaping from sorrow a new love", "परवरिश को बीज और क्षमा को नए प्रेम से तुलना।"),
                dev("Allusion (संदर्भ)", "पौराणिक संदर्भ", "I would have him prodigal, returning", "बाइबिल की 'Prodigal Son' कथा का सुंदर उल्लेख।"),
                dev("Alliteration (अनुप्रास)", "अनुप्रास अलंकार", "Silence surrounds us / same house", "'s' ध्वनि की लयात्मक पुनरावृत्ति।")
            ),
            extraFacts = listOf(
                f("Why does the father feel 'Silence surrounds us' in 'Father to Son'?", "Because emotional distance and generation gap prevent honest conversation despite living under the same roof", listOf("Because the house is in a forest", "Because the son lives abroad", "Because nobody speaks English"), "एक ही घर में रहकर भी संवाद न होने और वैचारिक दूरी के कारण चारों ओर मौन छाया है।"),
                f("What biblical reference does the father make when wishing his son would return home?", "The prodigal son returning to his father's house", listOf("Noah's Ark", "David and Goliath", "Solomon's wisdom"), "पिता बाइबिल के 'Prodigal Son' (भटके हुए पुत्र की घर वापसी) का उल्लेख करते हैं।")
            )
        )
    )

    val specs: Map<String, ChapterRichSpec> = poems.map { poem ->
        val ps = when (poem.id) {
            "c11_hb_p1" -> Triple(
                listOf(
                    st(1, "The cardboard shows me how it was... And she the big girl — some twelve years or so.", "गत्ते वाला फोटो माँ के 12 वर्षीय बचपन की समुद्री सैर दिखाता है।", "बेट्टी और डॉली दोनों चचेरी बहनें माँ के हाथ थामे मुस्कुरा रही हैं।", "Alliteration: stood still to smile."),
                    st(2, "Some twenty — thirty — years later She'd laugh at the snapshot...", "बीस-तीस साल बाद माँ खुद वह फोटो देखकर मुस्कुराती थीं।", "माँ के लिए वह छुट्टी बीती याद थी, कवयित्री के लिए माँ की हँसी अब अतीत है।", "Contrast & Past Memory."),
                    st(3, "Now she's been dead nearly as many years... Its silence silences.", "माँ के जाने के बाद कवयित्री के पास कोई शब्द नहीं बचे।", "मृत्यु का गहरा मौन सबको शांत कर देता है।", "Personification: Its silence silences.")
                ),
                listOf(
                    dev("Oxymoron", "विरोधाभास", "Laboured ease of loss", "कठिन और सहज का सटीक विरोधाभासी प्रयोग।"),
                    dev("Transferred Epithet", "स्थानांतरित विशेषण", "Terribly transient feet", "नश्वरता का भाव पैरों से जोड़ा गया।")
                ),
                listOf(f("What does the phrase 'Both wry with the laboured ease of loss' describe?", "Both the mother missing her childhood and the poet mourning her mother's smile", listOf("A happy beach picnic", "A stormy sea voyage", "A school award"), "माँ को अपना बचपन और कवयित्री को अपनी माँ की मुस्कान खोने का मीठा-कड़वा दर्द है।"))
            )
            "c11_hb_p2" -> Triple(
                listOf(
                    st(1, "The Laburnum top is silent, quite still In the afternoon yellow September sunlight...", "सितंबर की पीली धूप में अमलतास का वृक्ष बिल्कुल निश्चल व शांत है।", "पतझड़ के पत्ते पीले हो रहे हैं और बीज गिर गए हैं।", "Yellow imagery."),
                    st(2, "Till the goldfinch comes... Then sleek as a lizard... a machine starts up...", "सोनचिड़िया फुर्ती से आकर घोंसले में प्रवेश करती है और पेड़ चहचहाने लगता है।", "पूरा पेड़ बच्चों की फड़फड़ाहट से इंजन सा जाग उठता है।", "Simile: sleek as a lizard."),
                    st(3, "It is the engine of her family... She launches away, towards the infinite...", "बच्चों को खिलाकर वह फिर आकाश में उड़ जाती है और पेड़ पुनः शांत हो जाता है।", "प्रकृति में जीवन व शांति का सुंदर संतुलन।", "Metaphor: engine of her family.")
                ),
                listOf(
                    dev("Simile", "उपमा", "Sleek as a lizard", "चिड़िया की तेज़ी और सतर्कता की तुलना।"),
                    dev("Metaphor", "रूपक", "It is the engine of her family", "चिड़िया अपने परिवार के इंजन को ऊर्जा देती है।")
                ),
                listOf(f("To what reptile is the goldfinch compared when entering the Laburnum branches?", "A sleek lizard", listOf("A green snake", "A slow tortoise", "A chameleon"), "कवि ने सोनचिड़िया की तुलना 'sleek as a lizard' (छिपकली जैसी फुर्तीली) से की है।"))
            )
            "c11_hb_p3" -> Triple(
                listOf(
                    st(1, "And who art thou? said I to the soft-falling shower... I am the Poem of Earth...", "कवि के पूछने पर वर्षा खुद को 'पृथ्वी की कविता' बताती है।", "प्रकृति व संगीत के सुंदर संवाद का आरंभ।", "Personification."),
                    st(2, "Eternal I rise impalpable out of the land and the bottomless sea...", "अदृश्य भाप बनकर आसमान में बादल रूप धारण कर वर्षा नीचे बरसती है।", "जल-चक्र से रूप बदलकर भी मूल रूप वही रहता है।", "Hydrological imagery."),
                    st(3, "I descend to lave the droughts... (For song... duly with love returns.)", "सूखे को धोकर बीजों को जगाती है—जैसे गीत प्रेम से अपने स्रोत को लौट आता है।", "सृष्टि व कला का निःस्वार्थ जीवन-चक्र।", "Song analogy.")
                ),
                listOf(
                    dev("Personification", "मानवीकरण", "Said the voice of the rain", "वर्षा स्वयं अपनी आत्मकथा सुनाती है।"),
                    dev("Metaphor", "रूपक", "I am the Poem of Earth", "वर्षा और कविता की एकात्मता।")
                ),
                listOf(f("What happens to seeds in the soil without rain?", "They remain hidden, latent, and unborn", listOf("They grow twice as fast", "They turn into stones", "They fly upward"), "वर्षा के बिना धरती में छिपे बीज सुप्त और अजन्मे (latent and unborn) ही रह जाते हैं।"))
            )
            "c11_hb_p4" -> Triple(
                listOf(
                    st(1, "When did my childhood go? Was it the day I ceased to be eleven... Hell and Heaven...", "ग्यारह वर्ष का होते ही तर्कशक्ति जागी कि स्वर्ग-नर्क नक्शे पर नहीं हैं।", "बौद्धिक समझ से बचपन की पहली सीमा पार हुई।", "Refrain."),
                    st(2, "Was it the time I realised that adults were not All they seemed to be...", "बड़ों की कथनी और करनी का अंतर समझने पर भ्रम टूटा।", "पाखंड और यथार्थ का बोध।", "Contrast."),
                    st(3, "Was it the time I found my mind was really mine...", "जब मैंने जाना कि मेरे विचार स्वयं मेरे अपने हैं।", "व्यक्तित्व और आत्मनिर्भर चिंतन की प्राप्ति।", "Individuality."),
                    st(4, "Where did my childhood go? It went to some forgotten place... hidden in an infant's face.", "बचपन कहीं खोया नहीं—वह आज भी हर नन्हे शिशु के निश्छल चेहरे में जीवित है।", "सरलता व निर्दोष मुस्कान की महिमा।", "Shift from When to Where.")
                ),
                listOf(
                    dev("Refrain", "टेक / आवृत्ति", "When did my childhood go?", "केंद्रीय प्रश्न की लयात्मक पुनरावृत्ति।"),
                    dev("Alliteration", "अनुप्रास", "My mind / Hell and Heaven", "ध्वनियों का सुंदर मेल।")
                ),
                listOf(f("Which discovery in Stanza 3 marks the poet's intellectual independence?", "Realizing his mind was truly his own to produce original thoughts", listOf("Learning to drive a car", "Winning a medal", "Buying a globe"), "जब कवि को एहसास हुआ कि उनका मन स्वतंत्र है और वे अपने मौलिक विचार सोच सकते हैं।"))
            )
            else -> Triple(
                listOf(
                    st(1, "I do not understand this child Though we have lived together now In the same house...", "एक ही घर में रहते हुए भी पिता-पुत्र एक-दूसरे को नहीं समझ पाते।", "पीढ़ी के अंतराल की पहली व्यथा।", "Dramatic monologue."),
                    st(2, "Yet have I killed The seed I spent... We speak like strangers...", "हम अजनबियों की तरह बात करते हैं; एक ही खून होकर भी रुचियाँ अलग हैं।", "संवादहीनता और भावनात्मक दूरी।", "Metaphor: Seed."),
                    st(3, "Silence surrounds us. I would have Him prodigal, returning...", "पिता चाहते हैं कि भटका पुत्र घर लौट आए और वे दुःख से नया प्यार गढ़ दें।", "असीम पितृ-प्रेम और क्षमाशीलता।", "Biblical allusion."),
                    st(4, "We each put out an empty hand, Longing for something to forgive.", "दोनों एक ही संसार में रहते हुए क्षमा के लिए खाली हाथ बढ़ाते हैं।", "सुलह की आशा।", "Symbolism: Empty hand.")
                ),
                listOf(
                    dev("Simile", "उपमा", "We speak like strangers", "संवाद की ठंडक को अजनबियों से जोड़ा गया।"),
                    dev("Metaphor", "रूपक", "The seed I spent", "पिता द्वारा दिए संस्कारों को बीज कहा गया।")
                ),
                listOf(f("Why does the son say 'anger grows from grief'?", "His outward anger hides deep inner sorrow over their strained father-son bond", listOf("Because he lost money", "Because of bad weather", "Because of school exams"), "बेटे का क्रोध वास्तव में पिता से टूटते रिश्ते के गहरे दुःख से जन्म लेता है।"))
            )
        }

        ChapterRichSpec(
            chapterId = poem.id,
            detailedHindiTeaching = "इमरान गोरी सर द्वारा Class 11 (Hornbill) कविता व्याख्या: ${poem.hindiExplanation}",
            paragraphs = emptyList(),
            characters = listOf(
                ch(poem.author, "${poem.author} (कवि / वक्ता)", "कविता '${poem.title}' के रचनाकार", listOf("गहन संवेदनशीलता", "प्रतीकात्मक शैली", "दार्शनिक दृष्टि"), "${poem.author} ने अत्यंत संवेदनशीलता से मानवीय अनुभव और प्रकृति के सत्य को '${poem.title}' में पिरोया है।", "${poem.author} blends keen observation, emotion, and memorable imagery in '${poem.title}'.")
            ),
            cartoonScenes = listOf(
                sc(1, "कविता परिचय: ${poem.title}", "Hornbill Poetry", "नमस्ते! इमरान सर के साथ सीखें कक्षा 11 (Hornbill) की कविता '${poem.title}' (${poem.author})!", "Imran Sir", poem.author, CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Poet Intro"),
                sc(2, "कविता का भाव व चित्रण", "Core Imagery", poem.summaryHi, "Poet", "Nature", CartoonSetting.HOME_GARDEN, CartoonMood.THOUGHTFUL, "Visual Scene"),
                sc(3, "काव्य सौंदर्य एवं अलंकार", "Poetic Devices", "स्टैंज़ा-वार सरल हिंदी व्याख्या और Simile, Metaphor, Personification जैसे मुख्य अलंकार समझें!", "Imran Sir", "Students", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Poetic Craft"),
                sc(4, "MP बोर्ड परीक्षा तैयारी", "Board Exam Ready", "अब Central Idea, Extract Based, Short/Long प्रश्न और 30+ MCQs से 100% स्कोर करें!", "Imran Sir", "Toppers", CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Full Marks")
            ),
            extraFacts = ps.third,
            themeEn = poem.themeEn,
            themeHi = poem.themeHi,
            messageHi = poem.summaryHi,
            poemSpec = PoemRichSpec(
                poetIntroEn = "${poem.author} is a celebrated poet whose poem '${poem.title}' is prescribed in MPBSE Class 11 Hornbill.",
                poetIntroHi = "${poem.author} एक प्रतिष्ठित कवि हैं जिनकी रचना '${poem.title}' MP बोर्ड कक्षा 11 (Hornbill) के पाठ्यक्रम में सम्मिलित है।",
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
