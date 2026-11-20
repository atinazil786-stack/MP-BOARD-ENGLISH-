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

object Class9PoemsCurriculum {

    val poems: List<Chapter> = listOf(
        makePoemChapter(
            id = "c9_bh_p1",
            classLevel = 9,
            bookName = "Beehive",
            poemNumber = 1,
            title = "The Road Not Taken",
            titleHi = "वह राह जो नहीं चुनी गई",
            poet = "Robert Frost",
            summaryEn = "The poet stands at a fork in a yellow autumn wood facing two diverging paths. Choosing the less-travelled grassy road makes all the difference in shaping his unique life destiny.",
            summaryHi = "कवि पतझड़ के पीले जंगल में दो रास्तों के चौराहे पर खड़े हैं। वे कम लोगों द्वारा चुने गए घास वाले रास्ते को चुनते हैं और यही साहसिक निर्णय उनके पूरे जीवन की दिशा बदल देता है।",
            hindiExplanation = "रॉबर्ट फ्रॉस्ट की यह प्रसिद्ध प्रतीकात्मक कविता जीवन के महत्वपूर्ण निर्णयों (Career & Life Choices) के बारे में है। चौराहे पर दो राहें विकल्पों का प्रतीक हैं। दोनों दिखने में लगभग समान थीं, पर कवि ने कम चली गई कठिन राह चुनी क्योंकि निर्णय वापस लौटने का मौका जीवन कम ही देता है।",
            themeEn = "Choices shape destiny; courage to take an unconventional path defines individuality.",
            themeHi = "जीवन में लिए गए निर्णय हमारा भविष्य गढ़ते हैं; भीड़ से अलग राह चुनने का साहस ही पहचान बनाता है।",
            words = listOf(
                w("Diverged", "verb", "Separated in different directions", "दो दिशाओं में बंट जाना", "Two roads diverged in a yellow wood."),
                w("Undergrowth", "noun", "Dense growth of bushes under trees", "घनी झाड़ियाँ", "The first road bent into the undergrowth."),
                w("Wanted wear", "phrase", "Had not been walked on much", "कम उपयोग किया हुआ", "The second path was grassy and wanted wear."),
                w("Trodden", "verb", "Walked over or crushed by feet", "पैरों से रौंदा हुआ", "Leaves no step had trodden black."),
                w("Sigh", "noun", "Deep audible breath showing emotion", "गहरी साँस / आभार या पछतावा", "I shall be telling this with a sigh.")
            ),
            matchPairs = listOf(
                MatchPair("Yellow wood", "Autumn season / mature life stage"),
                MatchPair("Two roads", "Life choices and decisions"),
                MatchPair("Less travelled road", "Unconventional bold path"),
                MatchPair("ABAAB", "Rhyme scheme of each stanza")
            ),
            stanzas = listOf(
                st(1, "Two roads diverged in a yellow wood, And sorry I could not travel both...", "एक पीले पतझड़ के जंगल में दो सड़कें अलग दिशाओं में जाती थीं, और मुझे दुःख था कि मैं दोनों पर नहीं चल सकता।", "कवि जीवन के एक ऐसे मोड़ पर खड़े हैं जहाँ दो करियर या जीवन-मार्ग सामने हैं, पर इंसान एक समय में केवल एक ही राह चुन सकता है।", "Metaphor: 'Yellow wood' = पतझड़ / जीवन का निर्णय क्षण।"),
                st(2, "Then took the other, just as fair... Because it was grassy and wanted wear...", "फिर मैंने दूसरी राह चुनी जो कम चली गई और हरी घास से भरी थी।", "कवि भीड़ की देखा-देखी के बजाय कम लोगों द्वारा चुने गए नए व चुनौतीपूर्ण मार्ग को चुनते हैं।", "Alliteration: 'wanted wear' में 'w' ध्वनि की आवृत्ति।"),
                st(3, "Oh, I kept the first for another day! Yet knowing how way leads on to way...", "मैंने सोचा कि पहली राह फिर कभी चुनूँगा, पर जानता था कि एक रास्ता आगे दूसरे रास्तों से जुड़ता जाता है।", "एक बार बड़ा निर्णय ले लेने पर जीवन आगे बढ़ जाता है और पीछे मुड़कर सब कुछ बदलना आसान नहीं होता।", "Repetition: 'way leads on to way' जीवन की निरंतरता दिखाता है।"),
                st(4, "I took the one less traveled by, And that has made all the difference.", "मैंने वह राह चुनी जिस पर कम लोग चले थे, और इसी ने सारा अंतर पैदा किया।", "सालों बाद कवि गर्व व संतोष के साथ बताते हैं कि उनके साहसिक चुनाव ने उन्हें अद्वितीय व्यक्तित्व दिया।", "Theme: सही या अनूठे चुनाव से ही जीवन सार्थक बनता है।")
            ),
            poeticDevices = listOf(
                dev("Metaphor (रूपक)", "रूपक अलंकार", "Two roads diverged in a yellow wood", "दो सड़कें जीवन के दो महत्वपूर्ण विकल्पों या फैसलों का रूपक हैं।"),
                dev("Alliteration (अनुप्रास)", "अनुप्रास अलंकार", "Because it was grassy and wanted wear", "'wanted wear' में 'w' वर्ण की मधुर आवृत्ति है।"),
                dev("Symbolism (प्रतीक)", "प्रतीकात्मकता", "The road less traveled by", "लीक से हटकर स्वतंत्र व साहसिक रास्ता चुनने का प्रतीक है।"),
                dev("Rhyme Scheme", "तुक योजना", "ABAAB across all four stanzas", "प्रत्येक पाँच-पंक्ति स्टैंज़ा की तुकबंदी ABAAB है।")
            ),
            extraFacts = listOf(
                f("What does 'yellow wood' symbolize in 'The Road Not Taken'?", "A forest in autumn / stage of decision", listOf("A golden palace", "A desert storm", "Spring garden"), "'Yellow wood' पतझड़ के जंगल और निर्णय की परिपक्व अवस्था का प्रतीक है।"),
                f("Which rhyme scheme is used in Robert Frost's 'The Road Not Taken'?", "ABAAB", listOf("ABAB", "AABB", "ABCDE"), "प्रत्येक स्टैंज़ा की तुक योजना (Rhyme Scheme) ABAAB है।"),
                f("Why did the poet choose the second road?", "Because it was grassy and less travelled", listOf("Because it was paved", "Because friends walked on it", "Because it was shorter"), "दूसरी सड़क हरी घास वाली थी और उस पर बहुत कम लोग चले थे।")
            )
        ),

        makePoemChapter(
            id = "c9_bh_p2",
            classLevel = 9,
            bookName = "Beehive",
            poemNumber = 2,
            title = "Wind",
            titleHi = "पवन (हवा)",
            poet = "Subramania Bharati (Translated by A.K. Ramanujan)",
            summaryEn = "The poet urges the fierce wind to blow gently, yet notices how wind destroys weak things while strengthening strong fires. Thus, we must build strong bodies and steadfast hearts so adversities become our friends.",
            summaryHi = "कवि तेज़ हवा से धीरे बहने का आग्रह करते हैं पर देखते हैं कि पवन कमजोर चीज़ों को तोड़ देती है जबकि तेज़ आग को और भड़काती है। इसलिए हमें अपना तन और मन इतना मज़बूत बनाना चाहिए कि जीवन की हर मुसीबत हमारी मित्र बन जाए।",
            hindiExplanation = "तमिल के महान कवि सुब्रह्मण्य भारती (अनुवाद ए.के. रामानुजन) ने हवा को जीवन की कठिनाइयों व चुनौतियों का प्रतीक माना है। हवा कमजोर दरवाज़ों, कागज़ों व कमज़ोर हृदयों को उड़ा ले जाती है, पर पक्के घरों और धधकती आग को और प्रबल बनाती है।",
            themeEn = "Adversity crushes the weak but empowers the strong and steadfast.",
            themeHi = "कठिनाइयाँ कमजोरों को तोड़ती हैं पर दृढ़ निश्चयी लोगों को और अधिक शक्तिशाली बनाती हैं।",
            words = listOf(
                w("Scatter", "verb", "Throw in different directions", "बिखेरना", "Don't scatter the papers on the desk."),
                w("Crumbling", "adj", "Breaking into small weak pieces", "टूटता / चरमराता हुआ", "The wind god crushes crumbling houses and rafters."),
                w("Winnows", "verb", "Blows away chaff from grain", "फटक कर अलग करना", "The wind god winnows and crushes weak things."),
                w("Steadfast", "adj", "Firm, determined, unchanging", "अडिग / दृढ़", "Make our hearts steadfast to befriend the wind."),
                w("Flourish", "verb", "Grow strongly and thrive", "फलना-फूलना", "Strong fires roar and flourish in fierce wind.")
            ),
            matchPairs = listOf(
                MatchPair("Weak fires", "Blown out by the wind"),
                MatchPair("Strong fires", "Roar and flourish brighter"),
                MatchPair("Wind God", "Symbol of life's hardships"),
                MatchPair("Steadfast heart", "Key to befriending adversity")
            ),
            stanzas = listOf(
                st(1, "Wind, come softly. Don't break the shutters of the windows...", "हे पवन, धीरे आओ। खिड़कियों के पल्ले मत तोड़ो, किताबें मत गिराओ।", "शुरुआत में कवि बच्चे की तरह हवा से विनम्र अनुरोध करते हैं कि वह नुकसान न पहुँचाए।", "Anaphora: 'Don't...' की पुनरावृत्ति।"),
                st(2, "You tore the pages of the books. You brought rain again. You're very clever at poking fun at weaklings.", "तुमने किताबों के पन्ने फाड़ दिए और फिर बारिश ले आईं। तुम कमजोरों का मज़ाक उड़ाने में चतुर हो।", "कवि दिखाते हैं कि जीवन के तूफान हमेशा कमजोर और लापरवाह लोगों की परीक्षा लेते हैं।", "Personification: हवा को चतुर जीवित शक्ति के रूप में दर्शाया गया है।"),
                st(3, "So, come, let's build strong homes... Practise to firm the body. Make the heart steadfast.", "इसलिए आओ, मज़बूत घर बनाएँ, शरीर को सुदृढ़ करें और हृदय को अडिग रखें।", "कविता का व्यावहारिक संदेश: मुश्किलों से विनती करने की बजाय अपनी क्षमता व आत्मविश्वास बढ़ाना बेहतर है।", "Symbolism: पक्के घर और मज़बूत दिल = आत्मबल।"),
                st(4, "The wind blows out weak fires. He makes strong fires roar and flourish. His friendship is good.", "हवा कमजोर आग को बुझाती है पर तेज़ आग को और भड़काती है—उसकी मित्रता कल्याणकारी है।", "सशक्त लोगों के लिए संघर्ष वरदान बन जाते हैं, इसलिए हमें प्रतिदिन आत्म-विकास करना चाहिए।", "Metaphor: कमजोर आग बनाम प्रबल अग्नि।")
            ),
            poeticDevices = listOf(
                dev("Personification (मानवीकरण)", "मानवीकरण अलंकार", "You're very clever at poking fun at weaklings", "पवन को 'You' और 'He' कहकर मानवीय रूप दिया गया है।"),
                dev("Anaphora (पुनरुक्ति प्रकाश)", "आरंभिक शब्द पुनरावृत्ति", "Don't break... Don't scatter... Don't throw...", "लगातार पंक्तियों की शुरुआत 'Don't' शब्द से हुई है।"),
                dev("Metaphor (रूपक)", "रूपक अलंकार", "The wind blows out weak fires / makes strong fires roar", "कमजोर आग कायर लोगों की और प्रबल आग साहसी लोगों की प्रतीक है।"),
                dev("Free Verse", "मुक्त छंद", "No fixed end rhyme scheme", "कविता बिना बंधे तुक के स्वतंत्र लय में लिखी गई है।")
            ),
            extraFacts = listOf(
                f("Who originally composed the poem 'Wind' in Tamil?", "Subramania Bharati", listOf("Rabindranath Tagore", "Sarojini Naidu", "Kamala Das"), "मूल तमिल कविता सुब्रह्मण्य भारती ने लिखी जिसे ए.के. रामानुजन ने अंग्रेजी में अनूदित किया।"),
                f("How does wind treat strong fires?", "Makes them roar and flourish", listOf("Blows them out quickly", "Turns them into water", "Hides them silently"), "तेज़ हवा प्रबल आग को और धधका कर भड़का देती है।"),
                f("What does the poet ask us to do to befriend the wind?", "Build strong homes and steadfast hearts", listOf("Lock all doors forever", "Run away from storms", "Stop studying outdoors"), "मज़बूत घर, सुदृढ़ शरीर और अडिग हृदय बनाकर ही हम संकटों को मित्र बना सकते हैं।")
            )
        ),

        makePoemChapter(
            id = "c9_bh_p3",
            classLevel = 9,
            bookName = "Beehive",
            poemNumber = 3,
            title = "Rain on the Roof",
            titleHi = "छत पर बरसात",
            poet = "Coates Kinney",
            summaryEn = "Lying on a cozy bed listening to gentle raindrops pattering on wooden roof shingles, the poet drifts into fond memories of his loving mother who once gazed tenderly at her sleeping children.",
            summaryHi = "अँधेरी रात में कुटिया के बिस्तर पर लेटे कवि को छत के तख्तों पर गिरती बारिश की टप-टप आवाजें हजारों सपनों और अपनी प्यारी माँ की मधुर यादों में ले जाती हैं।",
            hindiExplanation = "कोट्स किन्नी की यह मधुर कविता वर्षा के संगीत और माँ के स्नेह का सुंदर संगम है। जब आकाश काले बादलों से भर जाता है और बारिश रोने जैसी बूंदें बरसाती है, तब कमरे में तकिए पर सिर रखे लेटना अनोखा सुख देता है। हर बूंद की गूँज कवि के दिल में बचपन की यादें जगाती है—विशेषकर उनकी दिवंगत माँ की ममता भरी मुस्कान।",
            themeEn = "Rain's gentle music awakens nostalgic warmth and undying memories of motherly love.",
            themeHi = "वर्षा की मधुर ध्वनि मनुष्य को बचपन की सुनहरी स्मृतियों और माँ के अमर स्नेह से जोड़ देती है।",
            words = listOf(
                w("Humid", "adj", "Warm and damp with water vapour", "नमी / आर्द्रता भरा", "Humid shadows hover over the starry spheres."),
                w("Melancholy", "adj", "Sad and thoughtful", "उदासी भरा / भावुक", "The melancholy darkness gently weeps in rainy tears."),
                w("Patter", "noun", "Soft rapid tapping sound of rain drops", "टप-टप की आवाज़", "Listen to the patter of the soft rain overhead."),
                w("Shingles", "noun", "Thin rectangular wooden roof tiles", "छत के लकड़ी के तख्ते", "Every tinkle on the shingles has an echo in the heart."),
                w("Fond look", "noun", "Loving and affectionate glance", "प्यार भरी नज़र", "He feels his mother's fond look upon him.")
            ),
            matchPairs = listOf(
                MatchPair("Melancholy darkness", "Gently weeps in rainy tears"),
                MatchPair("Cottage chamber bed", "Bliss of pressing the pillow"),
                MatchPair("Shingles", "Wooden roof tiles creating rhythm"),
                MatchPair("Darling dreamers", "Sleeping children watched by Mother")
            ),
            stanzas = listOf(
                st(1, "When the humid shadows hover... And the melancholy darkness gently weeps in rainy tears...", "जब नमी भरे काले बादल तारों भरे आकाश पर छा जाते हैं और उदास अंधकार वर्षा के आँसुओं में रोता है, तब तकिए पर सिर रख बारिश सुनना परम आनंद है।", "कवि कहते हैं कि बरसाती रात में आरामदायक बिस्तर पर लेटकर छत की बरसात सुनना अनोखा सुख है।", "Personification: अंधकार को रोते हुए दिखाया गया है।"),
                st(2, "Every tinkle on the shingles has an echo in the heart; And a thousand dreamy fancies into busy being start...", "छत पर गिरती हर टप-टप आवाज़ दिल में गूँजती है और मन में हजारों कल्पनाएँ और यादें जाग उठती हैं।", "बारिश की ध्वनि मन के तार झंकृत कर पुरानी यादों का ताना-बाना बुनती है।", "Metaphor: 'Recollections weave their air-threads into woof' (यादों की बुनाई)।"),
                st(3, "Now in memory comes my mother, As she used in years agone, To regard the darling dreamers...", "अब यादों में मेरी माँ आती हैं जैसे वर्षों पहले वे हम बच्चों को सुबह तक स्नेह से निहारती थीं।", "माँ की ममता भरी नज़र आज भी कवि को बारिश के संगीत में जीवंत महसूस होती है।", "Imagery & Nostalgia: माँ के वात्सल्य का सजीव चित्रण।")
            ),
            poeticDevices = listOf(
                dev("Onomatopoeia (ध्वन्यात्मकता)", "ध्वनि अलंकार", "Patter / Tinkle on the shingles", "'Patter' और 'Tinkle' शब्द सीधे बारिश की टप-टप ध्वनि सुनाते हैं।"),
                dev("Personification (मानवीकरण)", "मानवीकरण अलंकार", "Melancholy darkness gently weeps in rainy tears", "अंधेरे को उदास होकर रोते हुए मनुष्य की तरह चित्रित किया गया है।"),
                dev("Alliteration (अनुप्रास)", "अनुप्रास अलंकार", "Humid hover / starry spheres / press the pillow / busy being", "पास-पास आए शब्दों में प्रथम अक्षर की पुनरावृत्ति है।"),
                dev("Transferred Epithet", "विशेषण विपर्यय", "Melancholy darkness / Dreamy fancies", "उदासी अंधकार की नहीं, बल्कि मानव मन की भावना है।")
            ),
            extraFacts = listOf(
                f("Who are 'the darling dreamers' in 'Rain on the Roof'?", "The poet and his sleeping siblings in childhood", listOf("Stray birds on roof", "Passing clouds", "Village farmers"), "'Darling dreamers' कवि और उनके सोते हुए भाई-बहन हैं जिन्हें माँ प्यार से देखती थीं।"),
                f("What does the poet consider a 'bliss' on a rainy night?", "Pressing the pillow and listening to rain patter", listOf("Walking alone in storms", "Reading under a tree", "Cooking hot snacks"), "कुटिया के बिस्तर के तकिए को दबाकर बारिश की आवाज़ सुनना कवि को परम आनंद लगता है।"),
                f("What are 'shingles' mentioned in the poem?", "Rectangular wooden tiles used on roofs", listOf("Pebbles on rivers", "Glass window panes", "Iron bells"), "'Shingles' छत पर लगे लकड़ी के आयताकार तख्तों को कहते हैं।")
            )
        ),

        makePoemChapter(
            id = "c9_bh_p4",
            classLevel = 9,
            bookName = "Beehive",
            poemNumber = 4,
            title = "The Lake Isle of Innisfree",
            titleHi = "इनिसफ्री का झील द्वीप",
            poet = "William Butler Yeats",
            summaryEn = "Tired of grey city pavements, W.B. Yeats longs to escape to the tranquil uninhabited island of Innisfree, build a simple clay-and-wattles cabin, keep honeybees, and soak in timeless natural peace day and night.",
            summaryHi = "शहर की धूसर सड़कों और शोरगुल से ऊबकर कवि डब्ल्यू.बी. यीट्स शांत झील द्वीप 'इनिसफ्री' जाने की कामना करते हैं, जहाँ वे मिट्टी और टहनियों की झोपड़ी बनाकर प्रकृति व मधुमक्खियों के बीच परम शांति पाना चाहते हैं।",
            hindiExplanation = "यह कविता प्रकृति-प्रेम और आधुनिक शहरी तनाव से शांति की तलाश पर आधारित है। यीट्स अपने बचपन के प्रिय स्थान इनिसफ्री जाना चाहते हैं जहाँ सुबह की शांति झींगुर के गीत से उतरती है, दोपहर बैंगनी चमक से भरती है, शाम लिननेट पक्षी के पंखों से सजी होती है और झील का पानी दिन-रात मंद-मंद थिरकता रहता है—यह आवाज़ कवि को शहर की सड़क पर खड़े रहते हुए भी अपने हृदय की गहराई में सुनाई देती है।",
            themeEn = "Deep inner peace comes from harmonious living with quiet, unspoiled nature.",
            themeHi = "सच्ची मानसिक शांति आधुनिक चकाचौंध में नहीं बल्कि शांत प्रकृति की गोद में मिलती है।",
            words = listOf(
                w("Wattles", "noun", "Twisted sticks for making fences/walls", "टहनियों की बाड़", "He plans a small cabin of clay and wattles."),
                w("Glade", "noun", "Open grassy space in a forest", "जंगल के बीच खुला मैदान", "He will live alone in the bee-loud glade."),
                w("Linnet", "noun", "A small brown and grey songbird", "एक छोटा गायक पक्षी (लिननेट)", "Evening is full of the linnet's wings."),
                w("Veils of the morning", "phrase", "Early morning mist covering nature", "सुबह की धुंध का आवरण", "Peace drops gently from the veils of morning."),
                w("Lapping", "verb", "Gentle splashing of water against shore", "लहरों की हल्की छप-छप", "He hears lake water lapping with low sounds.")
            ),
            matchPairs = listOf(
                MatchPair("Nine bean-rows", "Self-sufficient simple living"),
                MatchPair("Cricket sings", "Morning peace at Innisfree"),
                MatchPair("Midnight's all a glimmer", "Starry peaceful night"),
                MatchPair("Pavements grey", "Dull, stressful modern city life")
            ),
            stanzas = listOf(
                st(1, "I will arise and go now, and go to Innisfree, And a small cabin build there, of clay and wattles made...", "मैं अभी उठकर इनिसफ्री जाऊँगा, मिट्टी व टहनियों की छोटी झोपड़ी बनाऊँगा, नौ कतार सेम बोऊँगा और मधुमक्खियों के बीच रहूँगा।", "कवि सादगीपूर्ण, प्रकृति-निर्भर और शांत जीवन जीने का दृढ़ संकल्प लेते हैं।", "Imagery: 'bee-loud glade' श्रवण बिंब है।"),
                st(2, "And I shall have some peace there, for peace comes dropping slow... There midnight's all a glimmer, and noon a purple glow...", "वहाँ शांति धीरे-धीरे सुबह के कोहरे से झींगुर के गीत संग उतरती है; आधी रात चमकती है, दोपहर बैंगनी लगती है और शाम लिननेट पक्षियों से गूँजती है।", "दिन के चारों पहरों की प्राकृतिक सुंदरता को कवि ने अत्यंत काव्यात्मक ढंग से दर्शाया है।", "Metaphor: 'veils of the morning' (कोहरे का पर्दा)।"),
                st(3, "I will arise and go now, for always night and day I hear lake water lapping with low sounds by the shore... I hear it in the deep heart's core.", "शहर की पक्की और धूसर सड़कों पर खड़े रहते हुए भी दिन-रात मुझे अपने दिल की गहराई में झील की लहरों की मीठी ध्वनि सुनाई देती है।", "शहर में रहकर भी मन प्रकृति की पुकार को भूल नहीं पाता।", "Alliteration: 'lake water lapping with low' में 'l' ध्वनि की लय है।")
            ),
            poeticDevices = listOf(
                dev("Alliteration (अनुप्रास)", "अनुप्रास अलंकार", "lake water lapping with low sounds / hive for the honeybee", "'l' और 'h' ध्वनि की संगीतमय आवृत्ति पानी की हल्की आवाज़ महसूस कराती है।"),
                dev("Metaphor (रूपक)", "रूपक अलंकार", "Veils of the morning / Pavements grey", "कोहरे को सुबह का घूँघट और धूसर सड़कों को शहरी नीरसता का प्रतीक बताया गया है।"),
                dev("Visual & Auditory Imagery", "दृश्य एवं श्रव्य बिंब", "midnight's all a glimmer / cricket sings", "आँखों और कानों को प्रकृति का सीधा अनुभव मिलता है।"),
                dev("Rhyme Scheme", "तुक योजना", "ABAB across all three stanzas", "प्रत्येक चार-पंक्ति स्टैंज़ा की तुकबंदी ABAB है।")
            ),
            extraFacts = listOf(
                f("What does the poet want to build at Innisfree?", "A small cabin of clay and wattles", listOf("A tall marble mansion", "A stone castle", "A bamboo hotel"), "कवि मिट्टी और टहनियों की एक छोटी सादी कुटिया (cabin) बनाना चाहते हैं।"),
                f("How many bean-rows does W.B. Yeats plan to plant at Innisfree?", "Nine bean-rows", listOf("Twelve bean-rows", "Three bean-rows", "Twenty bean-rows"), "कवि इनिसफ्री में सेम की नौ कतारें (nine bean-rows) उगाना चाहते हैं।"),
                f("Where does the poet stand when he hears Innisfree's lake water in his heart?", "On the roadway or grey city pavements", listOf("On a ship deck", "Inside a railway train", "On a snowy hill"), "वे शहर की सड़क या धूसर फुटपाथ (grey pavements) पर खड़े होते हैं।")
            )
        ),

        makePoemChapter(
            id = "c9_bh_p5",
            classLevel = 9,
            bookName = "Beehive",
            poemNumber = 5,
            title = "A Legend of the Northland",
            titleHi = "नॉर्थलैंड की एक लोककथा",
            poet = "Phoebe Cary",
            summaryEn = "In this traditional ballad from the snowy Northland, Saint Peter asks a greedy woman for one small cake while she bakes. Unable to part with even the tiniest wafer-thin cake, she is cursed into a woodpecker who must bore hard dry wood for meagre food.",
            summaryHi = "बर्फीले नॉर्थलैंड की इस लोककथा में भूखे संत पीटर केक बना रही एक लालची महिला से एक छोटा केक माँगते हैं। वह हर बार केक को छोटा करती जाती है और आखिर एक भी नहीं देती। संत पीटर के शाप से वह कठफोड़वा पक्षी (Woodpecker) बन जाती है जिसे सख्त सूखी लकड़ी खोदकर भोजन ढूँढना पड़ता है।",
            hindiExplanation = "फीबी कैरी की यह नैतिक गाथागीत (Ballad) बताती है कि स्वार्थ और कंजूसी मनुष्य का पतन कर देती है। नॉर्थलैंड में सर्दी की रातें इतनी लंबी होती हैं कि लोग सो नहीं पाते और हिरण (Reindeer) बर्फगाड़ी खींचते हैं। ऐसे प्रदेश में जब उपवास से थके संत पीटर उस महिला की झोपड़ी में पहुँचे, तो महिला ने पहले छोटा केक बनाया जो उसे बड़ा लगा; फिर दूसरा और अंत में कागज़ जैसा पतला केक बनाकर भी वह न दे सकी!",
            themeEn = "Selfishness and greed invite moral punishment; kindness and generosity enrich humanity.",
            themeHi = "स्वार्थ और लालच मनुष्य को पतित कर देता है, जबकि दानशीलता और परोपकार सच्चा मानवीय गुण है।",
            words = listOf(
                w("Legend", "noun", "An old traditional popular story", "लोककथा / पौराणिक कथा", "A legend teaches moral truth across generations."),
                w("Sledges", "noun", "Vehicles on runners for sliding over snow", "बर्फ पर फिसलने वाली गाड़ी", "Reindeer draw swift sledges over snow."),
                w("Faint", "adj", "Weak and dizzy from hunger", "भूख से चकराया / कमजोर", "Saint Peter was faint with fasting."),
                w("Hearth", "noun", "Floor of a fireplace / oven area", "चूल्हा / अँगीठी", "The little woman baked cakes on the hearth."),
                w("Boring", "verb", "Making a hole with persistent pecking", "छेद करना / कुरेदना", "The woodpecker keeps boring into hard dry wood.")
            ),
            matchPairs = listOf(
                MatchPair("Northland", "Snowy polar region with long nights"),
                MatchPair("Saint Peter", "Travelling saint faint with fasting"),
                MatchPair("Scarlet cap", "Red head plumage on the bird"),
                MatchPair("Woodpecker", "Woman transformed due to greed")
            ),
            stanzas = listOf(
                st(1, "Away, away in the Northland, Where the hours of the day are few... And the children look like bear's cubs in their funny, furry clothes...", "सुदूर उत्तर प्रदेश में दिन छोटे और सर्दी की रातें बहुत लंबी होती हैं; बच्चे फर वाले कपड़ों में भालू के बच्चों जैसे दिखते हैं।", "कवयित्री बर्फीले नॉर्थलैंड के अनोखे मौसम, रेनडियर स्लेज और फरदार कपड़ों का परिचय देती हैं।", "Simile: 'like bear's cubs' (बच्चों की तुलना भालू के बच्चों से)।"),
                st(2, "Once, when the good Saint Peter lived in the world below... He came to the door of a cottage... Where a little woman was making cakes...", "एक बार पृथ्वी पर उपदेश देते समय भूखे संत पीटर एक कुटिया के पास पहुँचे जहाँ एक महिला चूल्हे पर केक सेंक रही थी।", "संत ने भोजन में से बस एक छोटा केक माँगकर उसकी उदारता की परीक्षा ली।", "Ballad form: सरल कथात्मक प्रवाह।"),
                st(3, "So she made a very little cake, But as it baking lay, She looked at it, and thought it seemed Too large to give away... Rolled it flat as a wafer...", "उसने सबसे छोटा केक बनाया पर देते समय हर बार बड़ा लगा; वेफर जैसा पतला बनाकर भी वह देने का मन न कर सकी और सब अलमारी में रख दिया।", "लालच मनुष्य की आँखों पर पर्दा डाल देता है—छोटी-सी मदद भी बहुत बड़ी लगने लगती है।", "Simile: 'flat as a wafer'।"),
                st(4, "Then good Saint Peter grew angry... 'You are far too selfish to dwell in a human form'... And changed her to a woodpecker.", "क्रोधित संत ने कहा—तुम मानव रूप व गर्म घर के योग्य नहीं हो; तुम अब पक्षी बनकर सूखी लकड़ी में चोंच मारकर थोड़ा भोजन पाओगी।", "उसकी लाल टोपी छोड़कर बाकी तन काला पड़ गया और आज भी वह जंगल के पेड़ों पर टक-टक करती है।", "Moral: अतिथि और जरूरतमंद को कभी खाली हाथ नहीं लौटाना चाहिए।")
            ),
            poeticDevices = listOf(
                dev("Ballad (गाथागीत)", "कथात्मक गीत", "16 four-line stanzas narrating a folk tale", "सरल लयबद्ध छंद में एक नैतिक लोककथा सुनाई गई है।"),
                dev("Simile (उपमा)", "उपमा अलंकार", "Look like bear's cubs / Rolled it flat as a wafer / Black as a coal", "'like' और 'as' के माध्यम से स्पष्ट तुलना की गई है।"),
                dev("Repetition (पुनरावृत्ति)", "पुनरावृत्ति अलंकार", "Away, away in the Northland / Boring, and boring, for food", "दूरी और कठोर परिश्रम को प्रभावशाली बनाने के लिए शब्दों को दोहराया गया है।"),
                dev("Rhyme Scheme", "तुक योजना", "ABCB in each stanza", "प्रत्येक स्टैंज़ा की दूसरी और चौथी पंक्ति की तुक मिलती है।")
            ),
            extraFacts = listOf(
                f("Into which bird did Saint Peter transform the greedy woman?", "A woodpecker", listOf("An eagle", "A swallow", "A nightingale"), "संत पीटर के शाप से लालची महिला कठफोड़वा (Woodpecker) बन गई।"),
                f("What was left unchanged on the woman's head after transformation?", "Her scarlet (red) cap", listOf("Her silver bangles", "Her white apron", "Her golden crown"), "केवल उसकी लाल टोपी (scarlet cap) सिर पर बनी रही, बाकी कपड़े कोयले जैसे काले हो गए।"),
                f("Why couldn't the people of Northland sleep through winter nights?", "Because the winter nights are too long", listOf("Because bears roared", "Because there was no wood", "Because rains flooded homes"), "नॉर्थलैंड में सर्दी की रातें इतनी लंबी होती हैं कि लोग पूरी रात सो नहीं सकते।")
            )
        ),

        makePoemChapter(
            id = "c9_bh_p6",
            classLevel = 9,
            bookName = "Beehive",
            poemNumber = 6,
            title = "No Men Are Foreign",
            titleHi = "कोई भी मनुष्य पराया नहीं है",
            poet = "James Kirkup",
            summaryEn = "Poet James Kirkup appeals for universal brotherhood, reminding humankind that beneath all uniforms breathes a single human body. All people share the same sun, air, water, labour, eyes, and earth; therefore, hating or warring against others only defiles our own shared world.",
            summaryHi = "कवि जेम्स किर्कअप विश्व बंधुत्व और शांति का संदेश देते हैं। वे याद दिलाते हैं कि अलग-अलग वर्दियों और देशों की सीमाओं के नीचे हर इंसान एक ही धरती का वासी है। हम सब एक ही धूप, हवा और पानी का उपयोग करते हैं। इसलिए किसी दूसरे देश से नफरत करना या युद्ध करना अपनी ही मानवता को कलंकित करना है।",
            hindiExplanation = "‘नो मेन आर फॉरेन’ एक महान युद्ध-विरोधी और मानवतावादी कविता है। कवि हर स्टैंज़ा में बताते हैं कि सभी मनुष्यों के हाथ, आँखें, नींद और मेहनत एक जैसी है। जब स्वार्थी नेता हमें दूसरों से नफरत करने को कहते हैं, तो असल में हम खुद के भाई को धोखा देते हैं और युद्ध की आग से अपनी ही स्वच्छ हवा व पृथ्वी को प्रदूषित करते हैं।",
            themeEn = "Universal brotherhood, equality of all human beings, and futility of war and hatred.",
            themeHi = "विश्व बंधुत्व (वसुधैव कुटुम्बकम्), मानव समानता और युद्ध की व्यर्थता।",
            words = listOf(
                w("Uniforms", "noun", "Distinct military dresses of nations", "सैनिक वर्दियाँ / वेशभूषा", "Beneath all uniforms, a single human body breathes."),
                w("Aware of", "phrase", "Having knowledge of", "परिचित / जागरूक होना", "All nations are aware of the same sun, air, and water."),
                w("Starved", "verb", "Suffered severely from lack of food", "भूख से तड़पा हुआ", "By war's long winter everyone is starved."),
                w("Dispossess", "verb", "Deprive someone of property or rights", "छीन लेना / वंचित करना", "Whenever we hate our brothers, we dispossess ourselves."),
                w("Defile", "verb", "Make impure, spoil, or pollute", "दूषित / अपवित्र करना", "War's hells of fire and dust defile the human earth.")
            ),
            matchPairs = listOf(
                MatchPair("Beneath all uniforms", "A single human body breathes"),
                MatchPair("War's long winter", "Destruction and famine"),
                MatchPair("Strength won by love", "True moral victory"),
                MatchPair("Innocence of air", "Purity harmed by war smoke")
            ),
            stanzas = listOf(
                st(1, "Remember, no men are strange, no countries foreign Beneath all uniforms, a single body breathes Like ours...", "याद रखो, कोई इंसान अजनबी नहीं और कोई देश पराया नहीं; सभी वर्दियों के नीचे हमारे जैसा ही एक शरीर साँस लेता है और अंत में इसी धरती में समा जाता है।", "बाहरी पहनावा, भाषा और सीमाएँ अलग होने पर भी सबका जैविक और मानवीय अस्तित्व एक समान है।", "Metaphor: 'Uniforms' देशों की सेनाओं और पहचानों का प्रतीक है।"),
                st(2, "They, too, aware of sun and air and water, Are fed by peaceful harvests, by war's long winter starv'd.", "वे भी उसी सूरज, हवा और पानी से जीते हैं; शांति के समय फसल पाकर पलते हैं और युद्ध के लंबे शीतकाल में भूखों मरते हैं।", "शांति सबके लिए समृद्धि लाती है जबकि युद्ध हर पक्ष को केवल भुखमरी व पीड़ा देता है।", "Transferred Epithet: 'peaceful harvests', 'war's long winter'।"),
                st(3, "Their hands are ours, and in their lines we read A labour not different from our own.", "उनके हाथ भी हमारे जैसे हैं और उनकी हथेलियों की रेखाओं में हमारी ही तरह कठोर परिश्रम झलकता है; प्यार ही जीवन की असली शक्ति है।", "हर देश का श्रमिक एक समान मेहनत करता है और घृणा के बजाय प्रेम से ही किसी को जीता जा सकता है।", "Humanity: दुनिया भर के मजदूरों की एकता।"),
                st(4, "Remember, we who take arms against each other It is the human earth that we defile.", "याद रखो, जब हम एक-दूसरे के विरुद्ध हथियार उठाते हैं तो हम अपनी ही मानवीय धरती को दूषित और नष्ट करते हैं।", "युद्ध में कोई नहीं जीतता—गोला-बारूद की धूल हम सभी के साझा आकाश की शुद्ध हवा छीन लेती है।", "Refrain: 'Remember, no men are foreign...' संदेश को अमिट बनाता है।")
            ),
            poeticDevices = listOf(
                dev("Metaphor (रूपक)", "रूपक अलंकार", "Beneath all uniforms / War's long winter / Hells of fire and dust", "वर्दियाँ अलग-अलग राष्ट्रों की और युद्ध का शीतकाल विनाश के दिनों का रूपक है।"),
                dev("Alliteration (अनुप्रास)", "अनुप्रास अलंकार", "body breathes / war's long winter", "'b' और 'w' ध्वनि की लयात्मक पुनरावृत्ति है।"),
                dev("Transferred Epithet", "विशेषण विपर्यय", "Peaceful harvests", "फसलें शांतिपूर्ण नहीं होतीं, बल्कि शांति के समय की उपज सुखद होती है।"),
                dev("Repetition / Refrain", "टेक पुनरावृत्ति", "Remember, no men are strange, no countries foreign", "प्रारंभ व अंत में समान संदेश कविता के मूल विचार को सुदृढ़ करता है।")
            ),
            extraFacts = listOf(
                f("Who wrote the anti-war poem 'No Men Are Foreign'?", "James Kirkup", listOf("William Wordsworth", "Robert Frost", "Gieve Patel"), "'No Men Are Foreign' प्रसिद्ध ब्रिटिश कवि जेम्स किर्कअप की रचना है।"),
                f("What do all people on earth share equally according to James Kirkup?", "Sun, air, and water", listOf("Gold and weapons", "Military uniforms", "Railways and borders"), "संपूर्ण मानवता एक ही सूरज, हवा और पानी का आनंद लेती है।"),
                f("What happens when we hate our brothers or take up arms?", "We dispossess, betray, and defile our own earth", listOf("We become immortal", "Crops grow faster", "Air becomes cleaner"), "नफरत और हथियार उठाकर हम अपनी ही मानव पृथ्वी को अपवित्र और बर्बाद करते हैं।")
            )
        ),

        makePoemChapter(
            id = "c9_bh_p7",
            classLevel = 9,
            bookName = "Beehive",
            poemNumber = 7,
            title = "On Killing a Tree",
            titleHi = "एक वृक्ष की हत्या पर",
            poet = "Gieve Patel",
            summaryEn = "Through bitter irony, poet Gieve Patel demonstrates how deeply rooted and resilient a tree is. Mere hacking and chopping cannot kill it; to destroy a tree completely, one must pull out its white, sensitive life-anchoring root from the earth's cave and scorch it in the sun.",
            summaryHi = "कवि गिव पटेल करारे व्यंग्य के माध्यम से दिखाते हैं कि एक पेड़ को मारना कितना कठिन होता है क्योंकि वह वर्षों तक धरती से पोषण और धूप पीकर मज़बूत होता है। केवल कुल्हाड़ी से काटने पर उसकी छाल से फिर टहनियाँ फूट पड़ती हैं—पेड़ तभी मरता है जब उसकी सफ़ेद संवेदनशील जड़ को धरती से उखाड़कर धूप में सुखाया जाए!",
            hindiExplanation = "‘ऑन किलिंग अ ट्री’ पर्यावरण संरक्षण पर आधारित एक गहरी व्यंग्यात्मक कविता है। कवि जानबूझकर पेड़ काटने की प्रक्रिया को क्रूर 'हत्या' के रूप में लिखते हैं ताकि मनुष्य को प्रकृति के प्रति अपनी निर्दयता का एहसास हो। पेड़ के तने का रस निकलना मनुष्य के रक्त बहने जैसा है ('bleeding bark'), जो बताता है कि पेड़ भी सजीव हैं।",
            themeEn = "Nature's deep resilience versus human cruelty toward trees; urgent need to protect forests.",
            themeHi = "प्रकृति की अद्भुत जीवनी-शक्ति और वृक्षों के प्रति मनुष्य की क्रूरता पर गहरा व्यंग्य एवं पर्यावरण सुरक्षा का संदेश।",
            words = listOf(
                w("Jab", "noun", "A sudden rough thrust with a sharp blade", "तेज़ प्रहार / वार", "Not a simple jab of the knife will kill a tree."),
                w("Leprous hide", "phrase", "Rough discoloured bark resembling skin disease", "खुरदुरी बदरंग छाल", "Sprouting leaves grow out of its leprous hide."),
                w("Bleeding bark", "phrase", "Sap oozing out where bark is cut", "कटी छाल से बहता रस (मानो रक्त)", "The bleeding bark will heal on its own."),
                w("Anchoring earth", "phrase", "Soil holding the tree firmly in place", "जकड़ कर रखने वाली धरती", "Its roots stay hidden inside the anchoring earth."),
                w("Scorching and choking", "phrase", "Drying and suffocating in intense sun/air", "धूप व हवा में झुलसाना और दम घुटना", "Killing finishes with scorching and choking in sun and air.")
            ),
            matchPairs = listOf(
                MatchPair("Jab of the knife", "Fails to kill the mature tree"),
                MatchPair("Bleeding bark", "Oozing sap likened to blood"),
                MatchPair("White and wet root", "True hidden strength inside earth"),
                MatchPair("Scorching and choking", "Final destruction out in the sun")
            ),
            stanzas = listOf(
                st(1, "It takes much time to kill a tree, Not a simple jab of the knife will do it...", "एक पेड़ को मारने में बहुत समय लगता है; चाकू का साधारण वार इसे नहीं मार सकता क्योंकि इसने वर्षों तक धरती की परत से भोजन, धूप, हवा और पानी सोखकर आकार लिया है।", "पेड़ की मज़बूती वर्षों के प्राकृतिक पोषण की देन है; उसे आसानी से समाप्त नहीं किया जा सकता।", "Irony: पेड़ काटने को 'हत्या' बताकर संवेदनशीलता जगाई गई है।"),
                st(2, "So hack and chop But this alone won't do it. Not so much pain will do it. The bleeding bark will heal...", "चाहे इसे काटो या छांटो, कटी हुई छाल (रक्त बहती छाल) फिर भर जाएगी और ज़मीन के पास से फिर छोटी हरी टहनियाँ फूट पड़ेंगी।", "पेड़ अद्भुत जीवन-शक्ति रखता है और घायल होने पर भी पुनः पनप उठता है।", "Personification: 'bleeding bark will heal'।"),
                st(3, "No, The root is to be pulled out — Out of the anchoring earth; It is to be roped, tied, And pulled out—snapped out...", "नहीं, इसकी जड़ को रस्सी से बाँधकर सहारा देने वाली धरती की गुफा से पूरी तरह खींचकर बाहर निकालना होगा।", "जब पेड़ की असली शक्ति—सफ़ेद व गीली जड़—बाहर आ जाती है तभी उसका आधार टूटता है।", "Metaphor: 'earth-cave' और 'anchoring earth'।"),
                st(4, "Then the matter Of scorching and choking In sun and air, Browning, hardening, Twisting, withering, And then it is done.", "इसके बाद धूप व हवा में झुलसकर, भूरा व सख्त होकर, ऐंठकर और मुरझाकर अंततः पेड़ की मृत्यु हो जाती है।", "अंतिम शब्द 'And then it is done' पढ़कर पाठक के मन में पेड़ काटने की क्रूरता के प्रति गहरा दुःख उपजता है।", "Imagery: तपते सूर्य में जड़ के सूखने का सजीव वर्णन।")
            ),
            poeticDevices = listOf(
                dev("Irony (व्यंग्य)", "व्यंग्य अलंकार", "Entire poem guiding 'how to kill a tree'", "पेड़ मारने के तरीके बताकर कवि वास्तव में पेड़ों को बचाने का करुण संदेश देते हैं।"),
                dev("Personification (मानवीकरण)", "मानवीकरण अलंकार", "The bleeding bark will heal / pain", "पेड़ के तने से रस बहने को मनुष्य के खून बहने व दर्द से जोड़ा गया है।"),
                dev("Metaphor (रूपक)", "रूपक अलंकार", "Leprous hide / Anchoring earth / Earth-cave", "छाल को कुष्ठ जैसी त्वचा तथा मिट्टी को गहरा लंगर व गुफा कहा गया है।"),
                dev("Alliteration (अनुप्रास)", "अनुप्रास अलंकार", "bleeding bark / white and wet", "'b' और 'w' ध्वनियों की आवृत्ति है।")
            ),
            extraFacts = listOf(
                f("What helps the tree grow slowly over the years according to Gieve Patel?", "Earth, sunlight, air, and water", listOf("Only fertilizers", "Iron ropes", "Axe blades"), "धरती की परत, धूप, हवा और पानी का वर्षों तक सेवन कर पेड़ विशाल बनता है।"),
                f("Which part of the tree is described as 'white and wet' and most sensitive?", "Its hidden root", listOf("Dry top leaves", "Rough outer bark", "Old fallen twigs"), "धरती के भीतर छिपी उसकी सफ़ेद व नम जड़ (root) ही उसका सबसे संवेदनशील व शक्तिशाली हिस्सा है।"),
                f("What happens to the 'bleeding bark' if a tree is only chopped partially?", "It heals and sends out curled green twigs", listOf("It turns into stone", "It disappears overnight", "It catches fire"), "कटी हुई छाल से घाव भर जाता है और नीचे से फिर हरी टहनियाँ निकल आती हैं।")
            )
        ),

        makePoemChapter(
            id = "c9_bh_p8",
            classLevel = 9,
            bookName = "Beehive",
            poemNumber = 8,
            title = "A Slumber Did My Spirit Seal",
            titleHi = "एक गहरी तंद्रा ने मेरी आत्मा को जड़ कर दिया",
            poet = "William Wordsworth",
            summaryEn = "In this deeply moving short elegy of just eight lines, William Wordsworth mourns the sudden death of his beloved Lucy. While alive, he never imagined time could touch her; now in death, she lies beyond motion and earthly years, peacefully merged into rocks, stones, and trees.",
            summaryHi = "प्रकृति के महान कवि विलियम वर्ड्सवर्थ की यह मात्र 8 पंक्तियों की मार्मिक शोक-कविता (Elegy) उनकी प्रिय लूसी की मृत्यु पर आधारित है। जीवित रहते कवि ने कभी नहीं सोचा था कि समय उसे छू पाएगा; अब मृत्यु के बाद वह हर सांसारिक बंधन से परे चट्टानों, पत्थरों और पेड़ों के साथ पृथ्वी की दैनिक गति में विलीन हो गई है।",
            hindiExplanation = "प्रथम स्टैंज़ा में कवि स्वीकार करते हैं कि एक गहरी तंद्रा (अज्ञान/शोक) ने उनकी चेतना को बंद कर दिया था; उन्हें लगता था कि उनकी प्रिय (लूसी) कभी बूढ़ी या मृत नहीं होगी। दूसरे स्टैंज़ा में कठोर सत्य सामने है—अब उसमें कोई हलचल या शक्ति नहीं है, वह न सुनती है न देखती है, बल्कि पृथ्वी के दैनिक घूर्णन में चट्टानों और वृक्षों का अविभाज्य अंग बन गई है।",
            themeEn = "Inevitability of mortality and eternal peaceful union of the departed soul with nature.",
            themeHi = "मृत्यु की अटल सच्चाई और दिवंगत आत्मा का प्रकृति में शांत व शाश्वत विलीनीकरण।",
            words = listOf(
                w("Slumber", "noun", "Deep sleep or trance-like numbness", "गहरी नींद / तंद्रा", "A slumber sealed the poet's spirit from fear."),
                w("Spirit", "noun", "Soul or inner mind", "आत्मा / अंतर्मन", "A slumber did my spirit seal."),
                w("Earthly years", "phrase", "Passage of human aging and time", "सांसारिक उम्र / समय का प्रभाव", "She seemed a thing that could not feel earthly years."),
                w("Motion", "noun", "Ability to move physically", "गति / हलचल", "In death, she has no motion now and no force."),
                w("Diurnal course", "phrase", "Daily 24-hour rotation of Earth on its axis", "पृथ्वी की दैनिक घूर्णन गति", "She is rolled round in earth's diurnal course.")
            ),
            matchPairs = listOf(
                MatchPair("Slumber", "Poet's illusion / deep grief"),
                MatchPair("No motion, no force", "Reality of physical death"),
                MatchPair("Diurnal course", "Earth's daily spinning around sun"),
                MatchPair("Rocks, stones, and trees", "Eternal union with nature")
            ),
            stanzas = listOf(
                st(1, "A slumber did my spirit seal; I had no human fears: She seemed a thing that could not feel The touch of earthly years.", "एक गहरी नींद ने मेरी आत्मा पर मुहर लगा दी थी और मुझे कोई मानवीय भय न था; वह ऐसी लगती थी जिसे सांसारिक वर्षों या बुढ़ापे-मृत्यु का स्पर्श भी न छू सके।", "कवि प्रेम के भ्रम में इतने डूबे थे कि उन्होंने कभी कल्पना नहीं की थी कि उनकी प्रिय भी नश्वर है और एक दिन मृत्यु उसे ले जाएगी।", "Alliteration: 'spirit seal' में 's' ध्वनि की पुनरावृत्ति।"),
                st(2, "No motion has she now, no force; She neither hears nor sees; Rolled round in earth's diurnal course, With rocks, and stones, and trees.", "अब उसमें न कोई गति है न शक्ति; वह न सुनती है और न देखती है; वह पृथ्वी के दैनिक चक्र में चट्टानों, पत्थरों और वृक्षों के साथ घूमती रहती है।", "मृत्यु के बाद भौतिक शरीर समाप्त हो जाता है पर प्रकृति का हिस्सा बनकर अमर हो जाता है—पृथ्वी के साथ अनंत यात्रा करता है।", "Rhyme & Rhythm: 8 पंक्तियों की अत्यंत संक्षिप्त पर गहन 'Lucy Poem' (ABAB CDCD)।")
            ),
            poeticDevices = listOf(
                dev("Alliteration (अनुप्रास)", "अनुप्रास अलंकार", "spirit seal / Rolled round", "'s' और 'r' वर्ण की मधुर आवृत्ति शांति व गंभीरता लाती है।"),
                dev("Euphemism (शालीन उक्ति)", "कोमल अभिव्यक्ति", "A slumber did my spirit seal", "मृत्यु या गहरे शोक को सीधे भयावह न कहकर 'slumber' (गहरी नींद) कहा गया है।"),
                dev("Elegy & Imagery", "शोकगीत एवं प्रकृति बिंब", "Rolled round in earth's diurnal course, with rocks, and stones, and trees", "यह वर्ड्सवर्थ की लूसी कविता है जो मृत्यु में भी प्रकृति से एकता दिखाती है।"),
                dev("Rhyme Scheme", "तुक योजना", "ABAB CDCD", "दोनों क्वाट्रेन (चार-पंक्ति स्टैंज़ा) की तुक योजना ABAB CDCD है।")
            ),
            extraFacts = listOf(
                f("What is meant by 'earth's diurnal course' in Wordsworth's poem?", "Earth's daily rotation on its axis", listOf("Ocean tidal waves", "Autumn leaf fall", "A river's seasonal flow"), "'Diurnal course' का अर्थ पृथ्वी का अपनी धुरी पर प्रतिदिन घूमना (दैनिक घूर्णन) है।"),
                f("What sealed the poet's spirit in the opening line?", "A slumber (deep sleep-like ignorance/grief)", listOf("A winter storm", "A golden lock", "A loud bell"), "कवि की आत्मा पर एक गहरी तंद्रा (slumber) ने मुहर लगा दी थी।"),
                f("With what natural elements does the departed loved one roll round now?", "Rocks, stones, and trees", listOf("Stars and comets", "Ships and trains", "Clouds and snow"), "अब वह पृथ्वी की गति के साथ चट्टानों, पत्थरों और वृक्षों (rocks, and stones, and trees) संग घूमती रहती है।")
            )
        )
    )

    val specs: Map<String, ChapterRichSpec> = poems.map { poem ->
        val (stanzas, devices, facts) = when (poem.id) {
            "c9_bh_p1" -> Triple(
                listOf(
                    st(1, "Two roads diverged in a yellow wood...", "पीले जंगल में दो रास्ते अलग होते हैं; कवि असमंजस में हैं।", "जीवन के दो विकल्पों के सामने खड़ा मनुष्य दोनों राहों पर एक साथ नहीं चल सकता।", "Metaphor: Yellow wood = पतझड़ व निर्णय बिंदु।"),
                    st(2, "Then took the other, just as fair... grassy and wanted wear...", "कवि कम चली हुई हरी घास वाली राह चुनते हैं।", "भीड़ से हटकर नया रास्ता अपनाने का साहस।", "Alliteration: wanted wear।"),
                    st(3, "Way leads on to way, I doubted if I should ever come back...", "एक रास्ता आगे कई रास्तों में बदलता है; वापस आना संभव नहीं होता।", "निर्णय एक बार लेने के बाद भविष्य आगे बढ़ जाता है।", "Life truth: समय लौटता नहीं।"),
                    st(4, "I took the one less traveled by, And that has made all the difference.", "कम चली गई राह ने ही जीवन में पूरा अंतर पैदा किया।", "स्वतंत्र सोच व साहसिक निर्णय ही सफलता रचते हैं।", "Famous closing moral.")
                ),
                listOf(
                    dev("Metaphor", "रूपक", "Two roads diverged in a yellow wood", "सड़कें जीवन के फैसलों का प्रतीक हैं।"),
                    dev("Alliteration", "अनुप्रास", "wanted wear / first for", "प्रथम अक्षर की आवृत्ति से लय आती है।"),
                    dev("Rhyme Scheme", "तुक योजना", "ABAAB", "पाँचों पंक्तियों की तुक ABAAB है।")
                ),
                listOf(
                    f("Who composed 'The Road Not Taken'?", "Robert Frost", listOf("W.B. Yeats", "John Keats", "James Kirkup"), "रॉबर्ट फ्रॉस्ट ने यह कविता लिखी।")
                )
            )
            "c9_bh_p2" -> Triple(
                listOf(
                    st(1, "Wind, come softly. Don't break the shutters...", "हवा से धीमे बहने व किताबें न बिखेरने की विनती।", "शुरुआती विनम्र प्रार्थना पर हवा ध्यान नहीं देती।", "Anaphora: Don't..."),
                    st(2, "You're very clever at poking fun at weaklings...", "हवा कमजोर चीज़ों व छतों को तोड़कर हँसती है।", "विपदा कमजोर लोगों की परीक्षा लेती है।", "Personification: Wind god."),
                    st(3, "Make the heart steadfast...", "आओ मज़बूत घर व अडिग दिल बनाएँ।", "स्वयं को सशक्त करना ही समाधान है।", "Call to courage."),
                    st(4, "Makes strong fires roar and flourish...", "प्रबल आग हवा से और चमकती है।", "कठिनाई बहादुर का साथ देती है।", "Core Message.")
                ),
                listOf(
                    dev("Personification", "मानवीकरण", "You brought rain again", "पवन को जीवित सचेत शक्ति माना गया।"),
                    dev("Anaphora", "पुनरुक्ति", "Don't break... Don't scatter... Don't throw...", "वाक्यों के आरंभ में शब्द दोहराया गया।"),
                    dev("Metaphor", "रूपक", "Weak fires vs strong fires", "कमजोर और मजबूत मन का रूपक।")
                ),
                listOf(
                    f("Who translated 'Wind' from Tamil to English?", "A.K. Ramanujan", listOf("Robert Frost", "Ruskin Bond", "Vikram Seth"), "ए.के. रामानुजन ने इसका अंग्रेजी अनुवाद किया।")
                )
            )
            "c9_bh_p3" -> Triple(
                listOf(
                    st(1, "When the humid shadows hover... press the pillow...", "काले बादल देख कमरे के बिस्तर पर बारिश सुनना परम आनंद है।", "बरसात में कुटिया का सुकून मन को शांत करता है।", "Personification: darkness weeps."),
                    st(2, "Every tinkle on the shingles has an echo in the heart...", "छत पर बूंदों की टप-टप से हजारों यादें जाग उठती हैं।", "बारिश अतीत की कल्पनाओं का ताना-बाना बुनती है।", "Onomatopoeia: Patter & Tinkle."),
                    st(3, "Now in memory comes my mother...", "माँ का प्यारा चेहरा याद आता है जैसे वे सोते बच्चों को देखती थीं।", "माँ की ममता वर्षा की ध्वनि में जीवंत हो उठती है।", "Nostalgic tribute to mother.")
                ),
                listOf(
                    dev("Onomatopoeia", "ध्वनि अलंकार", "Patter, tinkle", "वर्षा की वास्तविक टप-टप आवाज़ सुनाती है।"),
                    dev("Alliteration", "अनुप्रास", "humid hover / press pillow / busy being", "मधुर संगीतमय ध्वनि।"),
                    dev("Personification", "मानवीकरण", "Melancholy darkness gently weeps", "अंधेरे को रोता हुआ दिखाया गया है।")
                ),
                listOf(
                    f("Who is remembered lovingly in the last stanza of 'Rain on the Roof'?", "The poet's mother", listOf("The poet's teacher", "His childhood pet", "A king"), "अंतिम स्टैंज़ा में कवि अपनी माँ को स्नेहपूर्वक याद करते हैं।")
                )
            )
            "c9_bh_p4" -> Triple(
                listOf(
                    st(1, "I will arise and go now, and go to Innisfree...", "मिट्टी-टहनी की कुटिया, नौ सेम की कतारें व मधुमक्खियों के बीच जीवन।", "सादगीपूर्ण आत्मनिर्भर प्राकृतिक जीवन का संकल्प।", "Auditory imagery: bee-loud glade."),
                    st(2, "Peace comes dropping slow from veils of the morning...", "सुबह कोहरा, दोपहर बैंगनी, शाम लिननेट और आधी रात चमक।", "पूरे दिन प्रकृति में बहती अद्भुत शांति।", "Metaphor: veils of morning."),
                    st(3, "While I stand on the roadway... deep heart's core.", "शहर की सड़कों पर खड़े रहते हुए भी दिल में झील की लहरें सुनाई देती हैं।", "प्रकृति का आकर्षण हृदय में सदा जीवित रहता है।", "Rhyme Scheme: ABAB.")
                ),
                listOf(
                    dev("Alliteration", "अनुप्रास", "lake water lapping with low sounds", "लहरों की छप-छप जैसा संगीत।"),
                    dev("Metaphor", "रूपक", "Veils of the morning", "सुबह की धुंध को घूँघट कहा गया।"),
                    dev("Imagery", "बिंब", "noon a purple glow / midnight's all a glimmer", "रंग और प्रकाश का अद्भुत चित्रण।")
                ),
                listOf(
                    f("Which bird's wings fill the evening sky at Innisfree?", "The linnet", listOf("The eagle", "The crow", "The owl"), "शाम को आकाश लिननेट पक्षी के पंखों से भर उठता है।")
                )
            )
            "c9_bh_p5" -> Triple(
                listOf(
                    st(1, "Away, away in the Northland...", "बर्फीले उत्तर प्रदेश में लंबी रातें व फर पहने बच्चे।", "कहानी की पृष्ठभूमि का सजीव वर्णन।", "Simile: like bear's cubs."),
                    st(2, "Good Saint Peter came to the door...", "भूखे संत पीटर ने केक बनाती महिला से एक छोटा केक माँगा।", "जरूरतमंद अतिथि की सेवा का अवसर।", "Ballad style."),
                    st(3, "Too large to give away... flat as a wafer...", "छोटा करते-करते भी वह केक नहीं दे सकी।", "स्वार्थ और कंजूसी की पराकाष्ठा।", "Simile: flat as a wafer."),
                    st(4, "Changed into a woodpecker...", "शाप से कठफोड़वा पक्षी बनकर सख्त लकड़ी खोदनी पड़ी।", "लोभ का परिणाम व परोपकार की शिक्षा।", "Rhyme Scheme: ABCB.")
                ),
                listOf(
                    dev("Simile", "उपमा", "like bear's cubs / flat as a wafer / black as a coal", "स्पष्ट तुलनात्मक शब्द।"),
                    dev("Repetition", "पुनरावृत्ति", "boring, and boring, for food", "कठोर संघर्ष को दर्शाया गया।"),
                    dev("Ballad", "लोकगीत शैली", "Narrative poem with moral", "लोककथा का काव्यात्मक रूप।")
                ),
                listOf(
                    f("What animal draws sledges in the snowy Northland?", "Swift reindeer", listOf("Camels", "Horses", "Elephants"), "बर्फ पर गाड़ियाँ तेज़ रेनडियर (reindeer) खींचते हैं।")
                )
            )
            "c9_bh_p6" -> Triple(
                listOf(
                    st(1, "Remember, no men are strange, no countries foreign...", "सभी वर्दियों के नीचे एक जैसा मानव शरीर साँस लेता है।", "भौगोलिक व सैन्य भेदभाव से ऊपर मानव एकता।", "Metaphor: uniforms."),
                    st(2, "Fed by peaceful harvests, by war's long winter starv'd...", "शांति सबका पेट भरती है, युद्ध सबको भूखा मारता है।", "शांति बनाम युद्ध का विपरीत प्रभाव।", "Metaphor: war's long winter."),
                    st(3, "Their hands are ours... strength won by love...", "हर देश का परिश्रम और प्रेम एक समान है।", "नफरत नहीं, प्रेम ही विजय दिलाता है।", "Humanity."),
                    st(4, "It is the human earth that we defile...", "हथियार उठाकर हम अपनी ही पवित्र धरती को दूषित करते हैं।", "विश्व शांति की अंतिम व सशक्त पुकार।", "Refrain.")
                ),
                listOf(
                    dev("Metaphor", "रूपक", "Beneath all uniforms / war's long winter", "वर्दी राष्ट्रीयता और शीतकाल युद्ध-संकट का रूपक है।"),
                    dev("Alliteration", "अनुप्रास", "body breathes / war's winter", "ध्वन्यात्मक सौंदर्य।"),
                    dev("Repetition", "पुनरावृत्ति", "Remember, no men are foreign...", "मुख्य शांति संदेश दोहराया गया।")
                ),
                listOf(
                    f("According to 'No Men Are Foreign', what can win strength in every land?", "Love and common understanding", listOf("Missiles and armies", "Borders", "Walls"), "शक्ति प्रेम और आपसी समझ से जीती जा सकती है।")
                )
            )
            "c9_bh_p7" -> Triple(
                listOf(
                    st(1, "It takes much time to kill a tree...", "चाकू के वार से पेड़ नहीं मरता; उसने वर्षों प्रकृति से शक्ति ली है।", "वृक्ष की जड़ और तना अत्यंत सशक्त होते हैं।", "Irony."),
                    st(2, "The bleeding bark will heal...", "कटी छाल फिर भर जाएगी और नीचे से टहनियाँ फूटेंगी।", "प्रकृति घाव भरकर पुनः खड़ी हो जाती है।", "Personification: bleeding bark."),
                    st(3, "The root is to be pulled out of anchoring earth...", "जड़ को रस्सी से खींचकर धरती से बाहर निकालना पड़ता है।", "असली ताकत जड़ के भीतर छिपी होती है।", "Metaphor: earth-cave."),
                    st(4, "Scorching and choking in sun and air...", "धूप में सूखकर मुरझाने पर ही पेड़ पूरी तरह मरता है।", "वृक्ष कटाई पर गहरा पर्यावरण संदेश।", "Cruelty of deforestation.")
                ),
                listOf(
                    dev("Irony", "व्यंग्य", "Describing tree cutting as murder guide", "क्रूरता उजागर कर वृक्ष बचाने का संदेश।"),
                    dev("Personification", "मानवीकरण", "Bleeding bark will heal", "पेड़ को जीवित प्राणी की तरह दर्द महसूस करते दिखाया गया।"),
                    dev("Metaphor", "रूपक", "Leprous hide / Anchoring earth", "छाल और धरती के लिए सशक्त उपमान।")
                ),
                listOf(
                    f("What emerges close to the ground if a tree trunk is hacked?", "Curled green twigs", listOf("Dry ashes", "Yellow stones", "Dead roots"), "ज़मीन के पास से फिर छोटी हरी मुड़ी हुई टहनियाँ (curled green twigs) निकल आती हैं।")
                )
            )
            else -> Triple(
                listOf(
                    st(1, "A slumber did my spirit seal...", "गहरी तंद्रा ने आत्मा को जड़ कर दिया; लगा था समय उसे कभी छू न पाएगा।", "जीवित रहते प्रिय के खोने का भय मन में न था।", "Alliteration: spirit seal."),
                    st(2, "No motion has she now... earth's diurnal course...", "अब वह अचल है और पृथ्वी की दैनिक गति के साथ चट्टानों व पेड़ों में समा गई है।", "मृत्यु के बाद आत्मा प्रकृति के शाश्वत चक्र का अंग बन जाती है।", "Rhyme Scheme: ABAB CDCD.")
                ),
                listOf(
                    dev("Alliteration", "अनुप्रास", "spirit seal / Rolled round", "शोक और अनंत चक्र की ध्वनि।"),
                    dev("Euphemism", "शालीन उक्ति", "Slumber", "मृत्यु की कठोरता को कोमल शब्द से व्यक्त किया गया।"),
                    dev("Imagery", "प्रकृति बिंब", "Rocks, and stones, and trees", "प्रकृति में पूर्ण विलय का चित्रण।")
                ),
                listOf(
                    f("Who is the poet of 'A Slumber Did My Spirit Seal'?", "William Wordsworth", listOf("John Keats", "Robert Frost", "Walt Whitman"), "प्रकृति कवि विलियम वर्ड्सवर्थ ने यह लूसी कविता लिखी।")
                )
            )
        }

        ChapterRichSpec(
            chapterId = poem.id,
            detailedHindiTeaching = "इमरान गोरी सर द्वारा पद्यांश-वार काव्य व्याख्या: ${poem.hindiExplanation}",
            paragraphs = emptyList(), // Auto-populated cleanly from stanzas
            characters = listOf(
                ch(poem.author, "${poem.author} (कवि / वक्ता)", "कविता '${poem.title}' के रचनाकार", listOf("संवेदनशील", "प्रकृति व मानवता प्रेमी", "विचारशील"), "${poem.author} ने अत्यंत सरल प्रतीकों और अलंकारों से जीवन व प्रकृति का गहरा सत्य प्रस्तुत किया है।", "${poem.author} crafts vivid imagery and enduring philosophical insight in '${poem.title}'.")
            ),
            cartoonScenes = listOf(
                sc(1, "कविता संसार में स्वागत", "Poem Intro: ${poem.title}", "नमस्ते बच्चों! इमरान सर आज आपको '${poem.title}' (${poem.author}) का सुंदर भावार्थ व अलंकार सिखाएँगे!", "Imran Sir", poem.author, CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Poet Intro"),
                sc(2, "कविता का मुख्य दृश्य", "Central Imagery", poem.summaryHi, "Poet", "Nature", CartoonSetting.HOME_GARDEN, CartoonMood.THOUGHTFUL, "Stanza View"),
                sc(3, "काव्य सौंदर्य व अलंकार", "Poetic Devices Magic", "ध्यान से देखें—कविता में कौन-से अलंकार, प्रतीक व तुकबंदी (Rhyme Scheme) जादू बिखेर रहे हैं!", "Imran Sir", "Students", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Poetic Craft"),
                sc(4, "केंद्रीय भाव व बोर्ड तैयारी", "Central Idea & Exam Tip", "अब 30+ महत्वपूर्ण कविता प्रश्न, पद्यांश और MCQs हल करके 100% अंक पक्के करें!", "Imran Sir", "Toppers", CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Exam Mastery")
            ),
            extraFacts = facts,
            themeEn = poem.themeEn,
            themeHi = poem.themeHi,
            messageHi = poem.summaryHi,
            poemSpec = PoemRichSpec(
                poetIntroEn = "${poem.author} is an internationally acclaimed poet whose classic work '${poem.title}' is prescribed in MPBSE Class 9 Beehive.",
                poetIntroHi = "${poem.author} विश्वप्रसिद्ध कवि हैं जिनकी कालजयी रचना '${poem.title}' कक्षा 9वीं (Beehive) के MP बोर्ड पाठ्यक्रम में शामिल है।",
                centralIdeaEn = poem.summaryEn,
                centralIdeaHi = poem.summaryHi,
                themeEn = poem.themeEn,
                themeHi = poem.themeHi,
                hindiTranslationAndInterpretation = "${poem.summaryHi}\n\nविस्तृत भावार्थ: ${poem.hindiExplanation}",
                stanzas = stanzas,
                poeticDevices = devices
            )
        )
    }.associateBy { it.chapterId }
}
