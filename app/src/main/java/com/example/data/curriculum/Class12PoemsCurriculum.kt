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

object Class12PoemsCurriculum {

    val poems: List<Chapter> = listOf(
        makePoemChapter(
            id = "c12_fl_p1",
            classLevel = 12,
            bookName = "Flamingo",
            poemNumber = 1,
            title = "My Mother at Sixty-six",
            titleHi = "छियासठ वर्ष की मेरी माँ",
            poet = "Kamala Das",
            summaryEn = "Driving from her parent's home to Cochin airport, Kamala Das looks at her sixty-six-year-old mother dozing open-mouthed, her face pale like an ashen corpse. To escape the childhood fear of losing her mother, she gazes out at young sprinting trees and merry children, then hides her tears behind a lingering smile at security check: 'See you soon, Amma.'",
            summaryHi = "कोचीन हवाई अड्डे जाते समय कार में कवयित्री कमला दास अपनी छियासठ वर्षीय माँ को ऊँघते हुए देखती हैं, जिनका चेहरा राख या सर्दी के पीले चंद्रमा जैसा निस्तेज दिखता है। माँ को खोने के पुराने बचपन के डर से मन हटाने के लिए वे बाहर दौड़ते जवान पेड़ों और खुश बच्चों को देखती हैं, और विदाई पर आँसू छिपाकर मुस्कुराते हुए कहती हैं—'जल्द मिलेंगे, अम्मा!'",
            hindiExplanation = "यह कविता एक ही वाक्य में रची गई अत्यंत मार्मिक रचना है जो बुढ़ापे और बिछड़ने के डर को दर्शाती है। कार के भीतर माँ का पीला, शव जैसा निस्तेज चेहरा (ashen like a corpse / late winter's moon) मृत्यु और वृद्धावस्था की याद दिलाता है। कार की खिड़की के बाहर 'दौर लगाते हरे पेड़' (Young Trees sprinting) और 'खेलते बच्चे' जीवन की ऊर्जा का विरोधाभास रचते हैं। एयरपोर्ट पर सुरक्षा जांच के बाद कवयित्री अपनी असहाय पीड़ा छिपाकर बार-बार मुस्कुराती हैं ताकि माँ को उम्मीद और ढाँढस मिले।",
            themeEn = "Ageing is an inevitable natural truth; filial love conceals deep fear of separation behind a reassuring smile.",
            themeHi = "वृद्धावस्था और समय का बदलाव अटल सत्य है; संतान का प्रेम बिछड़ने के गहरे भय को भी मधुर मुस्कान के पीछे छिपा लेता है।",
            words = listOf(
                w("Ashen", "adj", "Pale grey like cold ash", "राख जैसा पीला व निस्तेज", "Her face was ashen like that of a corpse."),
                w("Dozed", "verb", "Slept lightly / nodded off", "ऊँघना / झपकी लेना", "The aged mother dozed open-mouthed beside her."),
                w("Sprinting", "verb", "Running fast past the car window", "तेज़ी से दौड़ते दिखना", "Young trees sprinting outside symbolized youthful energy."),
                w("Wan", "adj", "Weak, colourless, and tired", "मुरझाया हुआ / पीला", "Her face looked wan and pale like a late winter's moon."),
                w("Ache", "noun", "Deep continuous emotional pain", "गहरी टीस / वेदना", "Kamala felt that familiar old childhood ache of losing Amma.")
            ),
            matchPairs = listOf(
                MatchPair("Ashen like a corpse", "Simile for mother's pale sleeping face"),
                MatchPair("Young trees sprinting", "Personification contrasting youth & age"),
                MatchPair("Late winter's moon", "Simile showing dimness & waning strength"),
                MatchPair("Smile and smile and smile", "Repetition masking separation grief")
            ),
            stanzas = listOf(
                st(1, "Driving from my parent's home to Cochin last Friday morning, I saw my mother, beside me, doze, open mouthed, her face ashen like that of a corpse...", "पिछले शुक्रवार की सुबह माता-पिता के घर से कोचीन जाते समय मैंने बगल में बैठी अपनी माँ को खुले मुँह ऊँघते देखा, उनका चेहरा शव की तरह राख जैसा पीला था।", "कार में बैठी 66 वर्षीय माँ को देख कवयित्री को अचानक उनके बुढ़ापे व मृत्यु का भय सताता है।", "Simile: 'Ashen like that of a corpse'."),
                st(2, "...and looked out at Young Trees sprinting, the merry children spilling out of their homes...", "...और मैंने ध्यान बंटाने के लिए बाहर देखा—तेज़ी से पीछे दौड़ते हरे वृक्ष और घरों से उछलकर बाहर निकलते प्रसन्न बच्चे...", "भीतर के बुढ़ापे और बाहर की युवा स्फूर्ति के बीच तीखा विरोधाभास।", "Personification & Imagery: 'Young Trees sprinting'."),
                st(3, "...wan, pale as a late winter's moon and felt that old familiar ache, my childhood's fear, but all I said was, see you soon, Amma, all I did was smile and smile and smile...", "...सर्दियों के अंत के पीले चंद्रमा सी कमज़ोर माँ को देख मेरा बचपन का पुराना दर्द जाग उठा, पर मैंने केवल इतना कहा—'जल्द मिलेंगे, अम्मा' और मैं बस मुस्कुराती रही...", "विदाई की पीड़ा को उम्मीद भरी मुस्कान से ढकना।", "Simile & Repetition: 'Late winter's moon', 'smile and smile and smile'.")
            ),
            poeticDevices = listOf(
                dev("Simile (उपमा)", "उपमा अलंकार", "Ashen like that of a corpse / pale as a late winter's moon", "माँ के निस्तेज चेहरे की तुलना राख व शीतकालीन धुंधले चाँद से।"),
                dev("Personification", "मानवीकरण", "Young Trees sprinting", "पेड़ों को मानव की तरह तेज़ दौड़ते दिखाया गया।"),
                dev("Repetition (पुनरुक्ति)", "पुनरुक्ति अलंकार", "Smile and smile and smile", "दर्द छिपाने के प्रयास को गहराई देने हेतु आवृत्ति।"),
                dev("Contrast (विरोधाभास)", "विरोध चित्रण", "Dozing aged mother vs merry children spilling out", "मृत्यु भय बनाम जीवंत बचपन।")
            ),
            extraFacts = listOf(
                f("Where was Kamala Das driving with her mother in 'My Mother at Sixty-six'?", "From her parent's home to Cochin airport", listOf("To Mumbai railway station", "To Chennai harbour", "To Delhi temple"), "कवयित्री शुक्रवार सुबह माता-पिता के घर से कोचीन हवाई अड्डे (Cochin airport) जा रही थीं।"),
                f("Why did Kamala Das repeat 'smile and smile and smile' at the airport?", "To hide her fear of never seeing her ageing mother again and give Amma cheerful assurance", listOf("Because her flight was early", "Because she won a prize", "Because the airport was funny"), "बिछड़ने के आँसुओं को छिपाकर माँ को हौसला व उम्मीद देने के लिए वे बार-बार मुस्कुराईं।")
            )
        ),
        makePoemChapter(
            id = "c12_fl_p2",
            classLevel = 12,
            bookName = "Flamingo",
            poemNumber = 2,
            title = "Keeping Quiet",
            titleHi = "शांत रहना (कीपिंग क्वाइट)",
            poet = "Pablo Neruda",
            summaryEn = "Nobel laureate Pablo Neruda urges humanity to count to twelve and pause all rushed activity, languages, and destructive wars for one tranquil moment of introspection. Far from promoting total inactivity or death, this quiet stillness heals whales, salt-gatherers' hurt hands, and Earth's ecological balance—helping humans understand themselves and avoid self-destruction.",
            summaryHi = "नोबेल विजेता कवि पाब्लो नेरूदा मानवता से आग्रह करते हैं कि हम 12 तक गिनकर कुछ क्षणों के लिए सारी भागदौड़, भाषाओं के भेद और विनाशकारी युद्ध रोक दें! यह मौन मृत्यु या आलस्य (total inactivity) नहीं है, बल्कि आत्म-मंथन (Introspection) है—जिससे मछुआरे व्हेलों को नुकसान न पहुँचाएँ, नमक बटोरने वालों को अपने घायल हाथ देखने का समय मिले और धरती शांत रहकर नया जीवन पा सके!",
            hindiExplanation = "पाब्लो नेरूदा 12 तक गिनने (घड़ी के 12 घंटे या वर्ष के 12 महीने) की बात करते हैं। उस अद्भुत 'विचित्र क्षण' (exotic moment) में बिना इंजन व शोर के सब भाईचारे से एक साथ होंगे। वे स्पष्ट करते हैं कि वे 'मृत्यु से कोई नाता नहीं' रखते—यदि हम हमेशा व्यस्त रहने की ज़िद छोड़कर थोड़ा रुकें, तो खुद को न समझने की उदासी (threat of death) खत्म हो जाएगी। अंत में वे धरती (Earth) का उदाहरण देते हैं जो सर्दी में मृत सी दिखती है पर वसंत में पुनः जीवित हो जाती है!",
            themeEn = "Quiet introspection fosters universal brotherhood, environmental harmony, and relief from self-destructive frenzy.",
            themeHi = "शांत आत्म-चिंतन विश्व बंधुत्व, प्रकृति के प्रति करुणा और अंधी भागदौड़ से उत्पन्न विनाश से मुक्ति दिलाता है।",
            words = listOf(
                w("Exotic", "adj", "Unusual, magical, and deeply peaceful", "अद्भुत / विलक्षण", "It would be an exotic moment without rush or engines."),
                w("Introspection", "noun", "Quiet examination of one's own mind and deeds", "आत्म-चिंतन / आत्म-अवलोकन", "Stillness enables deep healing introspection."),
                w("Hurt hands", "phrase", "Wounded hands of poor salt gatherers", "घायल व फटे हाथ", "The man gathering salt would look at his hurt hands."),
                w("Clean clothes", "phrase", "Peaceful mindset free of bloodshed", "निर्मल विचार व शांति के वस्त्र", "Warmongers would put on clean clothes and walk with brothers."),
                w("Total inactivity", "phrase", "Absolute stillness equated with death", "पूर्ण निष्क्रियता (जिसे कवि अस्वीकार करते हैं)", "Stillness should not be confused with total inactivity.")
            ),
            matchPairs = listOf(
                MatchPair("Count to twelve", "12 hours on a clock or 12 months"),
                MatchPair("Fishermen & whales", "Harmony with marine life"),
                MatchPair("Green wars & gas wars", "Environmental & chemical destruction"),
                MatchPair("Earth teaching", "Everything seems dead yet proves alive")
            ),
            stanzas = listOf(
                st(1, "Now we will count to twelve and we will all keep still. For once on the face of the Earth let's not speak in any language, let's stop for one second, and not move our arms so much.", "अब हम बारह तक गिनेंगे और सब शांत रहेंगे। धरती पर एक बार के लिए हम किसी भाषा में न बोलें, एक पल रुकें और अपने हाथ (हथियार व अंधा श्रम) न हिलाएँ।", "भाषा और कार्यों की भागदौड़ रोककर वैश्विक एकता का आह्वान।", "Anaphora: 'let's not... let's stop...'"),
                st(2, "It would be an exotic moment without rush, without engines, we would all be together in a sudden strangeness. Fishermen in the cold sea would not harm whales and the man gathering salt would look at his hurt hands.", "बिना हड़बड़ी और बिना मशीनों के वह एक अद्भुत क्षण होगा जब हम सब अचानक एकत्रित होंगे। ठंडे समुद्र में मछुआरे व्हेलों को चोट नहीं पहुँचाएँगे और नमक बीनने वाला अपने घायल हाथों को देख सकेगा।", "शांति से प्रकृति के जीव और गरीब श्रमिक दोनों को राहत मिलेगी।", "Alliteration: 'we would', 'sudden strangeness', 'hurt hands'."),
                st(3, "Those who prepare green wars, wars with gas, wars with fire, victory with no survivors, would put on clean clothes and walk about with their brothers in the shade, doing nothing.", "जो लोग हरियाली व पर्यावरण के विरुद्ध युद्ध, गैस व आग वाले युद्ध रचते हैं—जहाँ जीत के बाद कोई जीवित न बचे—वे साफ कपड़े पहनकर भाइयों के साथ छाया में शांत चलेंगे।", "युद्ध-उन्माद छोड़कर विश्व-बंधुत्व अपनाने का संदेश।", "Metaphor & Irony: 'Victory with no survivors', 'clean clothes'."),
                st(4, "What I want should not be confused with total inactivity. Life is what it is about; I want no truck with death... Perhaps the Earth can teach us as when everything seems dead and later proves to be alive.", "मेरी बात को पूर्ण निष्क्रियता न समझा जाए। जीवन गतिशील है; मेरा मृत्यु से कोई संबंध नहीं। शायद धरती हमें सिखा सकती है कि जब सब मृत सा लगता है, बाद में वही जीवित सिद्ध होता है।", "धरती की तरह विश्राम हमें पुनर्जीवित करता है।", "Personification: 'Perhaps the Earth can teach us'.")
            ),
            poeticDevices = listOf(
                dev("Alliteration (अनुप्रास)", "अनुप्रास अलंकार", "We will / sudden strangeness / his hurt hands / clean clothes", "'w', 's', 'h', 'c' ध्वनियों की मधुर आवृत्ति।"),
                dev("Personification", "मानवीकरण", "Perhaps the Earth can teach us", "पृथ्वी को सजीव गुरु के रूप में दिखाया गया।"),
                dev("Symbolism & Metaphor", "प्रतीक व रूपक", "Green wars / clean clothes / count to twelve", "पर्यावरणीय युद्ध और शांति की नई शुरुआत का प्रतीक।"),
                dev("Irony (विडंबना)", "विडंबना", "Victory with no survivors", "ऐसा युद्ध जिसमें विजेता के पास भी कोई न बचे।")
            ),
            extraFacts = listOf(
                f("What does Pablo Neruda clearly warn us NOT to confuse stillness with?", "Total inactivity or death", listOf("Peaceful meditation", "Earth's seasons", "Brotherhood"), "कवि स्पष्ट करते हैं कि शांत रहने का अर्थ 'पूर्ण निष्क्रियता (total inactivity) या मृत्यु' बिल्कुल नहीं है।"),
                f("What natural teacher does Neruda cite to prove quiet pauses lead to renewal?", "The Earth (which seems quiet in winter then blooms alive in spring)", listOf("A waterfall", "A racing horse", "A volcano"), "पाब्लो नेरूदा धरती (Earth) का उदाहरण देते हैं जो ठहरने के बाद फिर से हरी-भरी जीवित हो उठती है।")
            )
        ),
        makePoemChapter(
            id = "c12_fl_p3",
            classLevel = 12,
            bookName = "Flamingo",
            poemNumber = 3,
            title = "A Thing of Beauty",
            titleHi = "सुंदरता की वस्तु (अ थिंग ऑफ ब्यूटी)",
            poet = "John Keats",
            summaryEn = "Taken from John Keats' epic 'Endymion', this timeless poem opens with 'A thing of beauty is a joy forever'—explaining that beauty never fades into nothingness. Despite gloom, despondence, and dearth of noble natures, shapes of beauty—sun, moon, old and young trees, daffodils, cool rills, musk-roses, and heroic tales—wash away sadness like an endless fountain of immortal drink.",
            summaryHi = "जॉन कीट्स के महाकाव्य 'एंडिमियन' से ली गई यह अमर कविता कहती है—'सुंदरता की वस्तु सदा के लिए आनंद है।' इसका आकर्षण कभी शून्य नहीं होता। जीवन की निराशा व नेक लोगों की कमी के बावजूद प्रकृति के सुंदर उपहार—सूर्य, चाँद, वृक्षों की छाया, डैफोडिल फूल, ठंडे झरने, कस्तूरी गुलाब और वीरों की कहानियाँ—हमारे मन से उदासी हटाकर स्वर्ग से अमृत का झरना बरसाती हैं!",
            hindiExplanation = "कीट्स बताते हैं कि सुंदर वस्तु हमें शांत कुंज (bower quiet) और मीठे सपनों से भरी नींद देती है। यही सुंदरता हर सुबह हमें धरती से बांधे रखने के लिए 'फूलों की माला' (flowery band) गूँथती है। दुनिया की अंधेरी राहों व दुःख के बावजूद प्रकृति का सौंदर्य हमारे हृदय से उदासी का काला पर्दा (pall) हटा देता है। जंगल की झाड़ियों के बीच खिले कस्तूरी गुलाब और महान पूर्वजों की गाथाएँ (grandeur of the dooms) भगवान की ओर से अमृत का अनंत फव्वारा (endless fountain of immortal drink) हैं!",
            themeEn = "True beauty is eternal—offering spiritual shelter, healing joy, and renewed hope amid human suffering.",
            themeHi = "सच्चा सौंदर्य अमर और शाश्वत है—यह मानव जीवन के दुःख, निराशा व अंधकार को हटाकर अनंत आनंद व आशा देता है।",
            words = listOf(
                w("Bower", "noun", "A pleasant shady resting place under trees", "पेड़ों के नीचे शीतल कुंज / छायादार स्थान", "Beauty keeps a bower quiet for us."),
                w("Despondence", "noun", "State of low spirits / hopelessness", "निराशा / हताशा", "Of despondence, of the inhuman dearth of noble natures."),
                w("Pall", "noun", "Dark heavy cloth covering grief over the spirit", "उदासी का काला आवरण / कफ़न", "Some shape of beauty moves away the pall from our dark spirits."),
                w("Brake", "noun", "Thick clump of ferns or bushes", "झाड़ियों का झुरमुट", "Rich with a sprinkling of fair musk-rose blooms amidst the forest brake."),
                w("Immortal drink", "phrase", "Heavenly nectar of eternal joy", "अमर अमृत", "An endless fountain of immortal drink pouring from heaven's brink.")
            ),
            matchPairs = listOf(
                MatchPair("Joy forever", "Beauty's loveliness never passes into nothingness"),
                MatchPair("Flowery band", "Metaphor binding us joyfully to Earth"),
                MatchPair("Shady boon", "Simple sheep sheltered by old & young trees"),
                MatchPair("Immortal drink", "Metaphor for divine grace of beauty")
            ),
            stanzas = listOf(
                st(1, "A thing of beauty is a joy forever: Its loveliness increases; it will never Pass into nothingness; but still will keep A bower quiet for us, and a sleep Full of sweet dreams, and health, and quiet breathing.", "सुंदरता की वस्तु सदैव के लिए आनंद होती है। इसका सौंदर्य बढ़ता जाता है और कभी शून्य में विलीन नहीं होता; यह हमारे लिए एक शांत कुंज और मीठे सपनों भरी नींद, स्वास्थ्य व शांत श्वास सँजोए रखती है।", "सौंदर्य कभी नष्ट नहीं होता बल्कि समय के साथ बढ़ता है।", "Metaphor: 'A bower quiet for us'."),
                st(2, "Therefore, on every morrow, are we wreathing A flowery band to bind us to the earth, Spite of despondence, of the inhuman dearth Of noble natures, of the gloomy days... some shape of beauty moves away the pall From our dark spirits.", "इसलिए हर नई सुबह हम धरती से जुड़े रहने के लिए फूलों की माला गूँथते हैं—निराशा, नेक लोगों की कमी और उदास दिनों के बावजूद सौंदर्य का कोई रूप हमारी आत्मा से दुःख का काला पर्दा हटा देता है।", "कठिनाइयों के बीच भी प्रकृति ही हमें धरती से प्रेम कराती है।", "Metaphor: 'Flowery band', 'pall from our dark spirits'."),
                st(3, "Such the sun, the moon, Trees old, and young, sprouting a shady boon For simple sheep; and such are daffodils... And clear rills... Rich with a sprinkling of fair musk-rose blooms:", "सूर्य, चाँद, पुराने व नए वृक्ष जो सीधी-सादी भेड़ों को छाया रूपी वरदान देते हैं; हरे संसार में खिले डैफोडिल्स, गर्म मौसम से बचाने वाले स्वच्छ झरने और वन के झुरमुट में खिले कस्तूरी गुलाब—सब सुंदरता हैं।", "प्रकृति के विविध सुंदर रूपों का सजीव वर्णन।", "Imagery & Alliteration: 'cooling covert', 'noble natures'."),
                st(4, "And such too is the grandeur of the dooms We have imagined for the mighty dead; All lovely tales that we have heard or read: An endless fountain of immortal drink, Pouring unto us from the heaven's brink.", "और महान वीरों की भव्य गाथाएँ व वे सभी प्यारी कहानियाँ जो हमने सुनी या पढ़ी हैं—ये सब स्वर्ग के किनारे से हम पर बरसते अमर अमृत का अनंत झरना हैं।", "केवल प्रकृति ही नहीं, वीरता और साहित्य की श्रेष्ठ कथाएँ भी शाश्वत सौंदर्य हैं।", "Metaphor & Hyperbole: 'Endless fountain of immortal drink'.")
            ),
            poeticDevices = listOf(
                dev("Metaphor (रूपक)", "रूपक अलंकार", "Bower quiet / Flowery band / Pall / Immortal drink", "सुंदर विचारों व प्रकृति को माला, कुंज व अमृत का झरना कहा गया।"),
                dev("Alliteration (अनुप्रास)", "अनुप्रास अलंकार", "Noble natures / Cooling covert / Band to bind", "'n', 'c', 'b' ध्वनियों का सुमधुर प्रयोग।"),
                dev("Antithesis (विरोधी जोड़े)", "विरोध अलंकार", "Trees old, and young", "पुराने और नए वृक्षों का सुंदर साथ-साथ उल्लेख।"),
                dev("Transferred Epithet", "स्थानांतरित विशेषण", "Gloomy days / Unhealthy and o'er-darkened ways", "मनुष्य के दुःख को दिनों व रास्तों से जोड़ा गया।")
            ),
            extraFacts = listOf(
                f("From which longer poetic work by John Keats is 'A Thing of Beauty' an excerpt?", "Endymion: A Poetic Romance", listOf("Ode to a Nightingale", "Hyperion", "Ode on a Grecian Urn"), "यह प्रसिद्ध कविता जॉन कीट्स के लंबे काव्य 'एंडिमियन' (Endymion) से ली गई है।"),
                f("What does the phrase 'mighty dead' refer to in 'A Thing of Beauty'?", "Brave heroes and noble ancestors whose inspiring tales live on forever", listOf("Ancient ruined palaces", "Dead fallen trees", "Soldiers of Troy only"), "'Mighty dead' का अर्थ उन महान पूर्वजों व वीरों से है जिनकी गौरवपूर्ण कहानियाँ आज भी प्रेरणा देती हैं।")
            )
        ),
        makePoemChapter(
            id = "c12_fl_p4",
            classLevel = 12,
            bookName = "Flamingo",
            poemNumber = 4,
            title = "A Roadside Stand",
            titleHi = "सड़क किनारे की एक दुकान",
            poet = "Robert Frost",
            summaryEn = "Robert Frost contrasts indifferent city drivers speeding past in polished cars with struggling rural farmers who build a humble roadside stand hoping for a touch of city money. Ignored by commuters—and exploited by 'greedy good-doers' promising false relocation—the villagers endure a 'childish longing in vain', leaving the poet deeply anguished by rural poverty.",
            summaryHi = "रॉबर्ट फ्रॉस्ट शहर के उन अमीर वाहन चालकों की संवेदनहीनता दिखाते हैं जो अपनी चमकती कारों में गाँव की सड़क किनारे बनी गरीब किसानों की दुकान को अनदेखा कर निकल जाते हैं। किसान भीख नहीं, बस शहर की थोड़ी नकदी चाहते हैं। स्वार्थी राजनेता ('greedy good-doers') उन्हें गाँव से हटाकर झूठे सपनों में सुला देते हैं, और किसान खाली उम्मीद में खिड़की पर प्रतीक्षा करते रहते हैं!",
            hindiExplanation = "ग्रामीण परिवारों ने अपने पुराने घर के आगे एक छोटा सा नया छप्पर (roadside stand) लगाया है ताकि वे जंगली जामुन (wild berries) व सुनहरे कद्दू (squash) बेचकर कुछ पैसे कमा सकें। शहर के लोग या तो मुड़कर देखते नहीं या खराब लगे साइन-बोर्ड ('N' और 'S' उल्टा लगा होने) पर गुस्सा करते हैं! शहर के 'लालची भलाई करने वाले' (beneficent beasts of prey) उन्हें थिएटर व दुकानों के पास बसाकर उनका चैन छीन लेते हैं। कवि को उनकी 'बच्चों जैसी व्यर्थ प्रतीक्षा' से गहरा दर्द होता है!",
            themeEn = "Urban-rural economic inequality and hollow political promises trap hardworking villagers in quiet despair.",
            themeHi = "शहरी-ग्रामीण आर्थिक असमानता, अमीरों की बेरुखी और स्वार्थी नेताओं के झूठे वादे मेहनती ग्रामीणों को निराशा के दलदल में धकेल देते हैं।",
            words = listOf(
                w("Pathetically", "adv", "In a pitiably sad manner", "दयनीय ढंग से", "The little new shed stood pathetically at the edge of the road."),
                w("Polished traffic", "phrase", "Expensive glossy city cars speeding past", "चमकती तेज़ शहरी कारें", "The polished traffic passed with a mind ahead."),
                w("Bequest / Dole", "noun", "Charity handout (which farmers refused)", "भीख / दान", "Farmers didn't ask for dole of bread, only fair city cash."),
                w("Beneficent beasts", "phrase", "Oxymoron for greedy fake helpers", "ऊपरी भलाई करने वाले स्वार्थी शिकारी", "Greedy good-doers act like beneficent beasts of prey."),
                w("Plow", "noun / verb", "Farm tool / heavy farming work", "खेती व हल चलाना", "Squash and berries symbolized hard rural labour.")
            ),
            matchPairs = listOf(
                MatchPair("Polished traffic", "Indifferent wealthy city drivers"),
                MatchPair("Wild berries & squash", "Humble wares sold at the stand"),
                MatchPair("Greedy good-doers", "Manipulative politicians exploiting villagers"),
                MatchPair("Childish longing in vain", "Waiting anxiously for a car to stop and buy")
            ),
            stanzas = listOf(
                st(1, "The little old house was out with a little new shed In front at the edge of the road where the traffic sped, A roadside stand that too pathetically pled, It would not be fair to say for a dole of bread, But for some of the money, the cash, whose flow supports The flower of cities from sinking and withering faint.", "छोटे पुराने घर के आगे सड़क किनारे एक नया छप्पर लगाकर गरीब किसान रोटी की भीख नहीं, बल्कि शहर के उस धन का थोड़ा-सा हिस्सा माँग रहे हैं जो महानगरों को खिलते फूल की तरह समृद्ध रखता है।", "गरीब किसान सम्मानपूर्वक अपनी फसल बेचकर शहर की समृद्धि में हिस्सा चाहते हैं।", "Personification: 'A roadside stand that too pathetically pled'."),
                st(2, "The polished traffic passed with a mind ahead... Or if ever aside a moment, then out of sorts At having the landscape marred with the artless paint Of signs that with N turned wrong and S turned wrong Offered for sale wild berries in wooden quarts...", "चमकती कारें आगे की धुन में निकल गईं, और यदि किसी ने देखा भी तो भद्दे पेंट व उल्टे 'N-S' साइनबोर्ड पर खीझ जताई जहाँ लकड़ी की टोकरी में जामुन और सुनहरा कद्दू बिकने रखा था।", "अमीर शहरी लोग गरीबों की मदद के बजाय उनके भद्दे साइनबोर्ड पर चिढ़ते हैं।", "Transferred Epithet: 'Polished traffic', 'Selfish cars'."),
                st(3, "It is in the news that all these pitiful kin Are to be bought out and mercifully gathered in To live in villages, next to the theatre and the store... While greedy good-doers, beneficent beasts of prey, Swarm over their lives enforcing benefits That are calculated to soothe them out of their wits...", "खबर है कि इन ग्रामीणों की ज़मीन खरीदकर इन्हें थिएटर व मॉल के पास बसाया जाएगा ताकि इन्हें खुद सोचना न पड़े; पर ये 'लालची भलाई करने वाले' उन्हें सुख का नशा देकर उनकी रात की नींद छीन रहे हैं।", "स्वार्थी राजनेताओं और शोषक योजनाओं पर तीखा व्यंग्य।", "Oxymoron: 'Greedy good-doers', 'Beneficent beasts of prey'."),
                st(4, "Sometimes I feel myself I can hardly bear The thought of so much childish longing in vain, The sadness that lurks near the open window there... Just one to inquire what a farmer's prices are.", "कभी-कभी मुझसे इस व्यर्थ प्रतीक्षा का विचार भी सहा नहीं जाता—खुली खिड़की के पास छिपी उदासी, जब हज़ारों स्वार्थी कारों में से एक केवल रास्ता पूछने या पेट्रोल माँगने रुकती है, भाव पूछने कोई नहीं रुकता।", "किसानों की टूटी उम्मीदों पर कवि की गहरी करुणा।", "Personification: 'The sadness that lurks near the open window'.")
            ),
            poeticDevices = listOf(
                dev("Oxymoron (विरोधाभास)", "विरोधाभास अलंकार", "Greedy good-doers / Beneficent beasts of prey", "दयालु और हिंसक जैसे विपरीत गुणों का व्यंग्यात्मक प्रयोग।"),
                dev("Transferred Epithet", "स्थानांतरित विशेषण", "Polished traffic / Selfish cars", "चालकों की स्वार्थपरता को 'कारों' पर आरोपित किया गया।"),
                dev("Personification", "मानवीकरण", "Roadside stand pled / Sadness lurks", "दुकान और उदासी को मानव जैसा कार्य करते दर्शाया गया।"),
                dev("Alliteration (अनुप्रास)", "अनुप्रास अलंकार", "Pathetically pled / Greedy good-doers / Gallery of cities", "व्यंजन ध्वनियों का लयात्मक दोहराव।")
            ),
            extraFacts = listOf(
                f("What items did the villagers offer for sale at the roadside stand?", "Wild berries in wooden quarts and crooked-necked golden squash", listOf("Fresh flowers and newspapers", "Gold ornaments", "Petrol and car tyres"), "ग्रामीण लकड़ी के डिब्बों में जंगली जामुन (wild berries) और टेढ़ी गर्दन वाले सुनहरे कद्दू (golden squash) बेचते थे।"),
                f("Why did some passing cars stop at the roadside stand without buying anything?", "Only to back around, ask directions, or inquire if they sold gas (petrol)", listOf("To praise the painting", "To pay tax", "To deliver letters"), "रुकने वाली कारें केवल गाड़ी मोड़ने, रास्ता पूछने या यह पूछने रुकती थीं कि क्या यहाँ पेट्रोल (gas) मिलता है।")
            )
        ),
        makePoemChapter(
            id = "c12_fl_p5",
            classLevel = 12,
            bookName = "Flamingo",
            poemNumber = 5,
            title = "Aunt Jennifer's Tigers",
            titleHi = "आंट जेनिफर के बाघ",
            poet = "Adrienne Rich",
            summaryEn = "Adrienne Rich portrays the silent oppression of Aunt Jennifer inside a male-dominated marriage. While her terrified fingers flutter under the heavy weight of 'Uncle's wedding band', she escapes through embroidery—creating fearless, bright topaz tigers prancing proudly across a green forest. Even after Aunt Jennifer dies ringed with ordeals, her art lives on eternally bold and unafraid.",
            summaryHi = "कवयित्री एड्रिएन रिच पुरुष-प्रधान विवाह के बंधन में दबी आंट जेनिफर की पीड़ा को दिखाती हैं। 'अंकल की शादी की अंगूठी' का भारी बोझ उनकी काँपती उँगलियों को थका देता है, फिर भी वे कढ़ाई (embroidery) के ज़रिए पर्दे पर निर्भीक व चमकीले बाघ बनाती हैं जो किसी से नहीं डरते। आंट जेनिफर की मृत्यु के बाद भी उनकी बनाई कला हमेशा निडर व आज़ाद रहेगी!",
            hindiExplanation = "पहले छंद में आंट जेनिफर के बाघ हरे जंगल में पीले पुखराज (topaz) जैसे चमकते हैं और पेड़ के नीचे खड़े पुरुषों से भी नहीं डरते। दूसरे छंद में वास्तविक आंट इतनी भयभीत हैं कि उनके हाथ काँपते हैं और हाथीदांत की हल्की सुई (ivory needle) भी खींचना भारी लगता है—क्योंकि शादी की अंगूठी के भार से वे जीवनभर दबी रहीं। तीसरे छंद में वे मरने पर भी उन कष्टों की अंगूठी से घिरी रहेंगी, लेकिन उनके बनाए बाघ सदैव गर्व से उछलते रहेंगे—कला उत्पीड़न से अधिक अमर होती है!",
            themeEn = "Patriarchal marriage may crush a woman's freedom, yet creative art outlives oppression with fearless grace.",
            themeHi = "पितृसत्तात्मक बंधन एक महिला के व्यक्तित्व को दबा सकते हैं, किंतु उसकी सृजनात्मक कला अत्याचार से परे सदैव निडर व अमर रहती है।",
            words = listOf(
                w("Prance", "verb", "Spring or move with high proud steps", "गर्व से उछलते हुए चलना", "Aunt Jennifer's tigers prance across a screen."),
                w("Topaz", "noun", "Bright golden-yellow precious gemstone", "पुखराज (सुनहरा रत्न)", "Bright topaz denizens of a world of green."),
                w("Denizens", "noun", "Natural inhabitants or residents of a place", "निवासी", "Tigers are fearless denizens of the forest."),
                w("Chivalric", "adj", "Brave, courteous, and honourable like knights", "शूरवीर व गौरवपूर्ण", "Tigers pace in sleek chivalric certainty."),
                w("Ordeals", "noun", "Severe painful trials and hardships", "कठिन परीक्षाएँ / यातनाएँ", "Her terrified hands lie still, ringed with ordeals.")
            ),
            matchPairs = listOf(
                MatchPair("Bright topaz tigers", "Aunt Jennifer's fearless artistic dream"),
                MatchPair("Fluttering fingers", "Physical trembling from marital fear"),
                MatchPair("Uncle's wedding band", "Heavy symbol of patriarchal oppression"),
                MatchPair("Prancing proud & unafraid", "Immortality of art outliving the artist")
            ),
            stanzas = listOf(
                st(1, "Aunt Jennifer's tigers prance across a screen, Bright topaz denizens of a world of green. They do not fear the men beneath the tree; They pace in sleek chivalric certainty.", "आंट जेनिफर के कढ़ाई वाले बाघ हरे जंगल रूपी पर्दे पर पुखराज जैसे चमकते हुए गर्व से उछलते हैं। वे पेड़ के नीचे खड़े पुरुषों से नहीं डरते और शूरवीर जैसी निडर निश्चितता से चलते हैं।", "कढ़ाई में रचे बाघ आंट जेनिफर के खोए साहस और स्वतंत्रता का सपना हैं।", "Metaphor & Alliteration: 'Bright topaz denizens', 'chivalric certainty'."),
                st(2, "Aunt Jennifer's fingers fluttering through her wool Find even the ivory needle hard to pull. The massive weight of Uncle's wedding band Sits heavily upon Aunt Jennifer's hand.", "ऊनी धागे के बीच आंट जेनिफर की काँपती उँगलियों को हल्की हाथीदांत की सुई खींचना भी कठिन लगता है। अंकल की शादी की अंगूठी का भारी बोझ आंट जेनिफर के हाथ पर दबा बैठा है।", "भयग्रस्त वास्तविक जीवन और वैवाहिक बंधन का मानसिक दबाव।", "Hyperbole & Symbolism: 'Massive weight of Uncle's wedding band'."),
                st(3, "When Aunt is dead, her terrified hands will lie Still ringed with ordeals she was mastered by. The tigers in the panel that she made Will go on prancing, proud and unafraid.", "जब आंट की मृत्यु होगी, उनके डरे हुए हाथ अब भी उन्हीं कष्टों से घिरे रहेंगे जिन्होंने उन्हें वश में रखा। परंतु पर्दे पर उनके द्वारा बनाए गए बाघ सदैव गर्व व निडरता से उछलते रहेंगे।", "कला अपने रचयिता के कष्टों से ऊपर उठकर अमर हो जाती है।", "Pun & Contrast: 'Ringed with ordeals' बनाम जीवन से भरे बाघ।")
            ),
            poeticDevices = listOf(
                dev("Symbolism (प्रतीक)", "प्रतीकात्मकता", "Tigers = Fearlessness; Wedding band = Oppression", "बाघ निडर इच्छा के और अंगूठी पुरुष-सत्ता के दबाव की प्रतीक है।"),
                dev("Metaphor (रूपक)", "रूपक अलंकार", "Bright topaz denizens of a world of green", "बाघों के पीले रंग की पुखराज रत्न से प्रत्यक्ष एकता।"),
                dev("Pun (श्लेष अलंकार)", "श्लेष", "Still ringed with ordeals", "'Ringed' का अर्थ शादी की अंगूठी और कष्टों के घेरे दोनों हैं।"),
                dev("Alliteration & Hyperbole", "अनुप्रास व अतिशयोक्ति", "Fingers fluttering / Prancing proud / Massive weight", "काँपते हाथों व अंगूठी के मनोवैज्ञानिक भार पर बल।")
            ),
            extraFacts = listOf(
                f("What does the 'massive weight of Uncle's wedding band' symbolize?", "The oppressive burden and loss of freedom Aunt Jennifer suffered inside an unequal marriage", listOf("A heavy diamond ring gift", "A golden bracelet from friends", "Sewing box scissors"), "'अंकल की शादी की अंगूठी का भारी बोझ' वैवाहिक बंधन में मिले मानसिक दबाव व स्वतंत्रता के हनन का प्रतीक है।"),
                f("How do Aunt Jennifer's tigers contrast with her own personality?", "The tigers are fearless, proud, and free, whereas Aunt Jennifer is timid, terrified, and trapped", listOf("Both live inside zoos", "Tigers sleep while Aunt dances", "Both fear hunters"), "बाघ निडर, शूरवीर व आज़ाद हैं, जबकि आंट जेनिफर स्वयं भयभीत और दबाव में जीवन जीती हैं।")
            )
        )
    )

    val specs: Map<String, ChapterRichSpec> = poems.map { poem ->
        val ps = when (poem.id) {
            "c12_fl_p1" -> Triple(
                listOf(
                    st(1, "Driving from my parent's home to Cochin last Friday morning... her face ashen like that of a corpse...", "कोचीन एयरपोर्ट जाते हुए कार में माँ को पीला व निस्तेज ऊँघते देख कवयित्री सिहर उठीं।", "माँ का वृद्ध शरीर मृत्यु के निकट होने का एहसास दिलाता है।", "Simile: ashen like corpse."),
                    st(2, "...looked out at Young Trees sprinting, the merry children spilling out...", "ध्यान हटाने को बाहर देखा—दौड़ते हरे पेड़ और खेलते बच्चे जीवन का उत्साह दिखाते हैं।", "वृद्धावस्था और यौवन के बीच मार्मिक तुलना।", "Personification & Contrast."),
                    st(3, "...wan, pale as a late winter's moon... see you soon, Amma, all I did was smile and smile and smile...", "माँ को शीतकालीन चाँद सा कमज़ोर देख बचपन का डर जागा पर मुस्कान से विदा दी।", "आँसू छिपाकर आशावादी मुस्कान देना सच्चा मातृ-प्रेम है।", "Repetition & Simile.")
                ),
                listOf(
                    dev("Simile", "उपमा", "Ashen like that of a corpse / pale as a late winter's moon", "माँ के पीलेपन की सजीव तुलना।"),
                    dev("Personification", "मानवीकरण", "Young Trees sprinting", "तेज़ चलते वाहन के सापेक्ष दौड़ते युवा वृक्ष।")
                ),
                listOf(f("Why did Kamala Das compare her mother's face to 'a late winter's moon'?", "Because like the winter moon shrouded in mist, her mother looked pale, dim, and drained of strength", listOf("Because she loved moonlight walks", "Because the car was cold", "Because she wore white pearls"), "सर्दियों के धुंधले चाँद की तरह माँ का चेहरा अपनी चमक व ऊर्जा खो चुका था।"))
            )
            "c12_fl_p2" -> Triple(
                listOf(
                    st(1, "Now we will count to twelve and we will all keep still...", "12 तक गिनकर क्षण भर भाषा और भागदौड़ रोककर शांत होने का आह्वान।", "शांति से आपसी समझ पैदा होती है।", "Anaphora."),
                    st(2, "It would be an exotic moment without rush... fishermen... gathering salt...", "मछुआरे व्हेलों को नहीं सताएँगे और नमक बीनने वाला अपने घायल हाथ देख सकेगा।", "प्रकृति और श्रमिकों के प्रति संवेदनशीलता।", "Alliteration."),
                    st(3, "Those who prepare green wars... put on clean clothes and walk about with their brothers...", "विनाशकारी युद्ध रचने वाले निर्मल विचारों के साथ विश्व-बंधुत्व अपनाएँगे।", "युद्ध का विरोध और शांति की वकालत।", "Irony: victory with no survivors."),
                    st(4, "What I want should not be confused with total inactivity... Perhaps the Earth can teach us...", "शांत रहना मृत्यु नहीं; धरती से सीखें जो ठहरने के बाद पुनः खिल उठती है।", "सकारात्मक आत्म-चिंतन से नवजीवन मिलता है।", "Earth Personification.")
                ),
                listOf(
                    dev("Alliteration", "अनुप्रास", "Sudden strangeness / hurt hands / clean clothes", "ध्वनियों की मधुरता से शांति का एहसास।"),
                    dev("Personification", "मानवीकरण", "Perhaps the Earth can teach us", "धरती को जीवन का शिक्षक बनाया गया।")
                ),
                listOf(f("What do 'green wars' signify in Pablo Neruda's 'Keeping Quiet'?", "Reckless human war against nature, deforestation, and environmental destruction", listOf("Cricket matches on grass", "Planting vegetable gardens", "Green festivals"), "'Green wars' का अर्थ वनों और पर्यावरण के विरुद्ध मानव द्वारा छेड़े गए विनाशकारी युद्ध से है।"))
            )
            "c12_fl_p3" -> Triple(
                listOf(
                    st(1, "A thing of beauty is a joy forever: Its loveliness increases...", "सुंदरता की वस्तु सदैव आनंद देती है, मीठी नींद व शांत श्वास प्रदान करती है।", "सच्चा सौंदर्य कभी समाप्त नहीं होता।", "Metaphor: bower quiet."),
                    st(2, "Therefore, on every morrow, are we wreathing A flowery band... moves away the pall...", "उदास दिनों के बावजूद प्रकृति धरती से जोड़ने वाली फूलों की माला गूँथती है।", "सौंदर्य आत्मा से निराशा का पर्दा हटाता है।", "Metaphor: flowery band & pall."),
                    st(3, "Such the sun, the moon, Trees old, and young... daffodils... clear rills... musk-rose blooms:", "सूर्य, चाँद, छायादार वृक्ष, डैफोडिल्स, ठंडे झरने व कस्तूरी गुलाब प्रकृति की अमूल्य भेंट हैं।", "सौंदर्य की विविध प्राकृतिक छटाएँ।", "Visual imagery."),
                    st(4, "And such too is the grandeur of the dooms... endless fountain of immortal drink...", "वीरों की महान गाथाएँ भी स्वर्ग से बरसते अमृत का अनंत झरना हैं।", "साहित्य व इतिहास भी शाश्वत आनंद देते हैं।", "Immortal drink metaphor.")
                ),
                listOf(
                    dev("Metaphor", "रूपक", "Flowery band / Endless fountain of immortal drink", "सुंदरता को ईश्वर के अमृत झरने के रूप में चित्रित किया गया।"),
                    dev("Alliteration", "अनुप्रास", "Noble natures / Cooling covert", "काव्यात्मक संगीत पैदा करने हेतु।")
                ),
                listOf(f("What does the 'flowery band' signify in 'A Thing of Beauty'?", "Daily beautiful experiences of nature that joyfully tie human hearts to living on Earth", listOf("A wedding garland", "A crown of thorns", "A rope tied to trees"), "'फूलों की माला' प्रकृति के उन सुंदर अनुभवों का प्रतीक है जो हमें जीवन व पृथ्वी से जोड़े रखते हैं।"))
            )
            "c12_fl_p4" -> Triple(
                listOf(
                    st(1, "The little old house was out with a little new shed... cash, whose flow supports The flower of cities...", "गरीब किसान सड़क किनारे झोंपड़ी में भीख नहीं, बल्कि न्यायपूर्ण कमाई की आशा करते हैं।", "ग्रामीण श्रम को शहरी अर्थतंत्र से सम्मान की तलाश।", "Personification: stand pled."),
                    st(2, "The polished traffic passed... artless paint Of signs that with N turned wrong and S turned wrong...", "चमकती कारों वाले अमीर लोग जामुन-कद्दू लेने के बजाय उल्टे बोर्ड देख चिढ़ते हैं।", "शहरी अमीरों की बेरुखी व असंवेदनशीलता।", "Transferred Epithet: selfish cars."),
                    st(3, "Greedy good-doers, beneficent beasts of prey, Swarm over their lives enforcing benefits...", "स्वार्थी नेता विकास का नाटक करके भोले ग्रामीणों की नींद व ज़मीन छीन लेते हैं।", "दिखावटी राजनीति पर तीखा कटाक्ष।", "Oxymoron."),
                    st(4, "Thought of so much childish longing in vain... Just one to inquire what a farmer's prices are.", "गाँव वालों की बच्चों जैसी उम्मीद टूटने पर कवि गहरे दुःख में डूब जाते हैं।", "शहर व गाँव की आर्थिक खाई पर करुणा।", "Childish longing.")
                ),
                listOf(
                    dev("Oxymoron", "विरोधाभास", "Greedy good-doers / Beneficent beasts of prey", "दयालु दिखने वाले शोषक नेताओं पर व्यंग्य।"),
                    dev("Transferred Epithet", "स्थानांतरित विशेषण", "Polished traffic / Selfish cars", "कार सवार अमीरों के गुण वाहनों को दिए गए।")
                ),
                listOf(f("Why did the city commuters feel irritated near the roadside stand?", "They complained that the artless paint and reversed 'N' and 'S' signs spoiled the mountain scenery", listOf("Because traffic lights failed", "Because rain washed the road", "Because cows blocked lanes"), "शहर के अमीर लोग भद्दे रंग व उल्टे 'N' और 'S' लिखे साइनबोर्ड से सुंदर दृश्य खराब होने की शिकायत करते थे।"))
            )
            else -> Triple(
                listOf(
                    st(1, "Aunt Jennifer's tigers prance across a screen, Bright topaz denizens of a world of green...", "आंट जेनिफर के पर्दे पर बने पुखराज जैसे सुनहरे बाघ निडर होकर उछलते हैं।", "कढ़ाई की कला उनकी दबी आज़ादी की आवाज़ है।", "Metaphor: topaz denizens."),
                    st(2, "Aunt Jennifer's fingers fluttering through her wool... massive weight of Uncle's wedding band...", "अंकल की शादी की अंगूठी के भारी दबाव में उनकी काँपती उँगलियाँ सुई तक नहीं खींच पातीं।", "वैवाहिक उत्पीड़न और मानसिक भय।", "Hyperbole & Symbolism."),
                    st(3, "When Aunt is dead, her terrified hands will lie Still ringed with ordeals... tigers... proud and unafraid.", "उनकी मृत्यु पर भी कष्टों की अंगूठी रहेगी, पर उनके बनाए बाघ सदैव निडर उछलते रहेंगे।", "कलाकार मिट जाता है पर उसकी कला अमर रहती है।", "Pun: ringed with ordeals.")
                ),
                listOf(
                    dev("Symbolism", "प्रतीक", "Wedding band = Marital oppression; Tigers = Freedom", "गहरे नारीवादी प्रतीक।"),
                    dev("Pun", "श्लेष", "Still ringed with ordeals", "'Ringed' शब्द अंगूठी और कष्ट-चक्र दोनों दर्शाता है।")
                ),
                listOf(f("What will happen to Aunt Jennifer's tigers after her death?", "They will continue prancing across the panel proudly and fearlessly forever", listOf("They will fade immediately", "They will run away into forest", "Uncle will erase them"), "आंट जेनिफर के जाने के बाद भी उनके बनाए बाघ पर्दे पर गर्व व निडरता से उछलते रहेंगे।"))
            )
        }

        ChapterRichSpec(
            chapterId = poem.id,
            detailedHindiTeaching = "इमरान गोरी सर द्वारा Class 12 (Flamingo) पद्यांश-वार व्याख्या: ${poem.hindiExplanation}",
            paragraphs = emptyList(),
            characters = listOf(
                ch(poem.author, "${poem.author} (कवि / कवयित्री)", "कविता '${poem.title}' के रचनाकार", listOf("प्रभावशाली बिंब", "गहरा मानवीय संदेश", "MP बोर्ड प्रमुख पाठ"), "${poem.author} की रचना '${poem.title}' कक्षा 12 बोर्ड परीक्षा के Extract, Central Idea व MCQs के लिए अत्यंत महत्वपूर्ण है।", "${poem.author} weaves vivid imagery and enduring human insight into '${poem.title}'.")
            ),
            cartoonScenes = listOf(
                sc(1, "कविता परिचय: ${poem.title}", "Flamingo Poetry", "नमस्ते विद्यार्थियों! इमरान सर के साथ सीखें Class 12 (Flamingo) की कविता '${poem.title}' (${poem.author})!", "Imran Sir", poem.author, CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Poet Intro"),
                sc(2, "कविता का सजीव दृश्य", "Poetic Imagery", poem.summaryHi, "Poet", "Nature", CartoonSetting.HOME_GARDEN, CartoonMood.THOUGHTFUL, "Visual Scene"),
                sc(3, "अलंकार व स्टैंज़ा व्याख्या", "Poetic Devices", "Simile, Metaphor, Personification, Symbolism और हर स्टैंज़ा की सरल हिंदी व्याख्या सीखें!", "Imran Sir", "Students", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Devices Mastery"),
                sc(4, "कक्षा 12 बोर्ड 100% स्कोर!", "Board Topper Prep", "Central Idea, Poetry Extract और 30+ MCQs के साथ अब बोर्ड परीक्षा में पूरे अंक पक्के करें!", "Imran Sir", "Toppers", CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Exam Ready")
            ),
            extraFacts = ps.third,
            themeEn = poem.themeEn,
            themeHi = poem.themeHi,
            messageHi = poem.summaryHi,
            poemSpec = PoemRichSpec(
                poetIntroEn = "${poem.author} is a globally acclaimed poet whose classic poem '${poem.title}' is a core part of MPBSE Class 12 Flamingo.",
                poetIntroHi = "${poem.author} विश्व-प्रसिद्ध कवि/कवयित्री हैं जिनकी कालजयी रचना '${poem.title}' MP बोर्ड कक्षा 12वीं (Flamingo) के पाठ्यक्रम का अनिवार्य अंग है।",
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
