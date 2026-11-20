package com.example.data.curriculum

import com.example.data.model.CartoonMood
import com.example.data.model.CartoonScene
import com.example.data.model.CartoonSetting
import com.example.data.model.CharacterSketch
import com.example.data.model.ParagraphExplanation
import com.example.data.model.QuestionType
import com.example.data.model.WordMeaning

object Class9Enrichment {

    val specs: Map<String, ChapterRichSpec> = listOf(
        spec(
            id = "c9_bh_1",
            teachingHi = "यह कहानी वर्ष 2157 के भविष्य के स्कूलों को दिखाती है। आज के बच्चों की तरह तब बच्चे एक साथ स्कूल नहीं जाते थे, बल्कि घर के कमरे में एक मैकेनिकल (रोबोट) टीचर के सामने अकेले बैठकर कंप्यूटर स्क्रीन से पढ़ते थे। टॉमी को एक पुरानी कागज़ की किताब मिलती है जिसे पढ़कर मार्गी हैरान रह जाती है कि पुराने ज़माने में सभी बच्चे एक साथ हँसते-खेलते और एक इंसान शिक्षक से पढ़ते थे!",
            paragraphs = listOf(
                p(1, "साल 2157 की डायरी और असली किताब की खोज", "On 17 May 2157, Margie wrote in her diary that Tommy had found a real printed book.", "17 मई 2157 को मार्गी अपनी डायरी में लिखती है कि टॉमी को अटारी में एक असली कागज़ की किताब मिली। इसके पीले और सिकुड़े पन्नों पर शब्द स्क्रीन की तरह चलते नहीं थे, बल्कि स्थिर थे।", "भविष्य में कागज़ की किताबें दुर्लभ हो चुकी थीं।"),
                p(2, "रोबोट शिक्षक और भूगोल की परीक्षा में कठिनाई", "Margie hated school because her mechanical teacher had been giving her test after test in geography.", "मार्गी को अपने रोबोट टीचर से नफरत थी क्योंकि उसका भूगोल वाला भाग तेज सेट हो गया था और वह लगातार टेस्ट दे रहा था। फिर काउंटी इंस्पेक्टर ने आकर उसकी गति मार्गी की उम्र के अनुसार धीमी की।", "हर बच्चे की सीखने की गति अलग होती है।"),
                p(3, "पुराने ज़माने के स्कूलों की कल्पना", "Tommy explained that centuries ago schools were in a special building where human teachers taught all kids.", "टॉमी बताता है कि सैकड़ों वर्ष पहले स्कूल एक अलग इमारत में होते थे जहाँ एक इंसान शिक्षक सभी बच्चों को एक साथ पढ़ाता था और बच्चे आपस में मदद करते थे।", "असली कक्षाओं में दोस्ती, संवाद और आनंद होता है।"),
                p(4, "मार्गी की सोच: 'वे कितना मज़ा करते होंगे!'", "Margie sat before her flashing mechanical screen thinking about the fun children had in old schools.", "कहानी के अंत में मार्गी अपने स्कूलरूम में स्क्रीन के सामने बैठती है, पर उसका मन पुराने स्कूलों के बच्चों की मस्ती, हँसी और दोस्ती के बारे में सोचता रहता है।", "सच्ची शिक्षा केवल मशीन से नहीं, मानवीय जुड़ाव से मिलती है।")
            ),
            characters = listOf(
                c("Margie Jones", "मार्गी जोन्स (11 वर्ष)", "कहानी की मुख्य बालिका पात्र", listOf("जिज्ञासु", "भावुक", "मित्रता की चाह रखने वाली"), "मार्गी 2157 की एक ग्यारह वर्षीय लड़की है जो रोबोट टीचर की एकरसता से ऊब चुकी है और पुराने स्कूलों के मानवीय माहौल को पसंद करती है।", "Margie is an imaginative 11-year-old girl of 2157 who longs for human teachers and real classmates."),
                c("Tommy", "टॉमी (13 वर्ष)", "मार्गी का जिज्ञासु मित्र", listOf("समझदार", "जानकार", "तार्किक"), "टॉमी को अटारी से पुरानी किताब मिलती है। वह मार्गी को अतीत के स्कूलों और मानव शिक्षकों के बारे में विस्तार से समझाता है।", "Tommy is Margie's 13-year-old friend who discovers the printed book and explains past schooling.")
            ),
            scenes = listOf(
                s(1, "अटारी में पुरानी किताब", "Finding the Real Book", "देखो बच्चों! 2157 में टॉमी को एक पुरानी कागज़ की किताब मिली है, जिसके अक्षर स्क्रीन की तरह भागते नहीं हैं!", "Tommy", "Margie", CartoonSetting.HOME_GARDEN, CartoonMood.MYSTERY, "Book Discovery"),
                s(2, "रोबोट टीचर की क्लास", "Mechanical Teacher Trouble", "मार्गी का रोबोट टीचर बहुत तेज भूगोल टेस्ट दे रहा है। मम्मी ने काउंटी इंस्पेक्टर को बुलाया है!", "Margie", "County Inspector", CartoonSetting.MOUNTAIN_LAB, CartoonMood.DRAMATIC, "Screen Fix"),
                s(3, "पुराने स्कूल की याद", "Old School Building", "टॉमी बताता है कि पुराने ज़माने में सब बच्चे एक साथ स्कूल जाते थे, साथ खेलते थे और इंसान टीचर पढ़ाते थे!", "Tommy", "Margie", CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Past Flashback"),
                s(4, "मार्गी का सपना", "The Fun They Had", "रोबोट स्क्रीन के सामने बैठी मार्गी सोचती है—काश हमारा स्कूल भी पहले जैसा मज़ेदार होता!", "Margie", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Lesson Moral")
            ),
            words = listOf(
                w("Attic", "noun", "Space just below the roof", "अटारी (छत के नीचे का कमरा)", "Tommy found the real book in the attic."),
                w("Slot", "noun", "A narrow opening for inserting homework", "खाँचा / स्लॉट", "Margie put her homework paper into the slot."),
                w("Geared", "verb", "Adjusted to a particular level", "स्तर के अनुसार सेट किया हुआ", "The geography sector was geared a little too quick."),
                w("Scornful", "adj", "Showing contempt or dislike", "तिरस्कारपूर्ण / नापसंद", "Margie looked scornful at the idea of school."),
                w("Loftily", "adv", "In a superior proud manner", "गर्व से / बड़प्पन दिखाते हुए", "Tommy added loftily that it was centuries ago."),
                w("Dispute", "verb", "Disagree or argue about something", "विवाद करना / असहमत होना", "Margie was not prepared to dispute that."),
                w("Nonchalantly", "adv", "In a calm, casual manner", "लापरवाही / सहजता से", "Tommy walked away whistling nonchalantly."),
                w("Mechanical", "adj", "Operated by a machine", "मशीनी / यांत्रिक", "She had a mechanical teacher next to her bedroom.")
            ),
            facts = listOf(
                f("In which year does the story 'The Fun They Had' take place?", "2157", listOf("1957", "2057", "2257"), "कहानी की घटना 17 मई 2157 की है।"),
                f("Who repaired Margie's mechanical teacher?", "The County Inspector", listOf("Her father", "Tommy", "A school principal"), "काउंटी इंस्पेक्टर ने भूगोल वाले हिस्से की गति ठीक की।"),
                f("In which subject was Margie doing badly?", "Geography", listOf("Mathematics", "History", "Science"), "रोबोट का भूगोल सेक्टर तेज सेट हो जाने के कारण मार्गी के नंबर कम आ रहे थे।")
            ),
            qa = listOf(
                qa(QuestionType.SHORT, "Why did Margie hate her mechanical school?", "मार्गी को अपने मशीनी स्कूल से नफरत क्यों थी?", "Because her mechanical teacher gave continuous geography tests without human warmth or classmates.", "क्योंकि रोबोट टीचर लगातार भूगोल टेस्ट देता था और वहाँ कोई मित्र या इंसान शिक्षक नहीं था।", true)
            ),
            fbs = listOf("Margie's mechanical teacher was adjusted to an average ______-year level." to "ten", "Tommy found the real book in the ______." to "attic"),
            tfs = listOf("Margie was eleven years old in the story." to true, "Tommy was younger than Margie." to false)
        ),

        spec(
            id = "c9_bh_2",
            teachingHi = "यह पाठ दो महान संगीत साधकों की सच्ची प्रेरणादायक कहानी है: भाग 1 में एवलिन ग्लेनी बहरी होने के बावजूद शरीर के कंपन से संगीत महसूस करके विश्व प्रसिद्ध तालवादक बनीं। भाग 2 में उस्ताद बिस्मिल्लाह खाँ ने शहनाई को मंदिरों से निकालकर दुनिया के बड़े मंचों तक पहुँचाया और भारत रत्न प्राप्त किया।",
            paragraphs = listOf(
                p(1, "एवलिन की सुनने की शक्ति खोना और दृढ़ निश्चय", "Evelyn Glennie lost her hearing gradually by age eleven, yet refused to give up music.", "ग्यारह वर्ष की उम्र तक एवलिन की सुनने की क्षमता लगभग समाप्त हो गई, लेकिन उन्होंने हार नहीं मानी और एक सामान्य जीवन व संगीत करियर का संकल्प लिया।", "शारीरिक कमी सफलता की राह नहीं रोक सकती।"),
                p(2, "रॉन फोर्ब्स का मार्गदर्शन: शरीर से संगीत महसूस करना", "Percussionist Ron Forbes advised Evelyn not to listen through ears but sense vibrations.", "प्रसिद्ध तालवादक रॉन फोर्ब्स ने दो बड़े ड्रम बजाकर एवलिन को सिखाया कि कान से नहीं बल्कि पूरे शरीर की त्वचा और पैरों से संगीत के कंपन (Vibrations) को महसूस करो।", "सही गुरु मार्ग दिखा दे तो असंभव भी संभव हो जाता है।"),
                p(3, "बिस्मिल्लाह खाँ और शहनाई का जन्म", "A barber improvised the pungi and played it in the Shah's chambers, naming it Shehnai.", "मुगल दरबार में प्रतिबंधित 'पुंगी' को एक नाई ने सुधारकर शहनाई बनाया, जिसे बाद में डुमराँव के उस्ताद बिस्मिल्लाह खाँ ने शास्त्रीय सम्मान दिलाया।", "परिश्रम और साधना कला को अमर बना देती है।"),
                p(4, "भारत रत्न और मातृभूमि से अटूट प्रेम", "Bismillah Khan loved Benares and the Ganga so deeply that he refused to settle in the USA.", "उस्ताद बिस्मिल्लाह खाँ ने अमेरिका में स्कूल खोलने का प्रस्ताव ठुकरा दिया क्योंकि वे अपनी गंगा नदी, बनारस और हिंदुस्तानी संगीत से दूर नहीं रह सकते थे।", "सफलता के शिखर पर भी अपनी जड़ों से प्रेम रखना चाहिए।")
            ),
            characters = listOf(
                c("Evelyn Glennie", "एवलिन ग्लेनी", "प्रसिद्ध बधिर तालवादक (Percussionist)", listOf("अडिग निश्चय", "संवेदनशील", "मेहनती"), "एवलिन कान से न सुन पाने के बावजूद पैरों और उंगलियों से कंपन महसूस कर 1000 से अधिक वाद्य यंत्र बजाने में निपुण बनीं।", "Evelyn is a world-renowned Scottish percussionist who overcame profound deafness through determination."),
                c("Ustad Bismillah Khan", "उस्ताद बिस्मिल्लाह खाँ", "भारत रत्न शहनाई वादक", listOf("देशभक्त", "सरल", "संगीत समर्पित"), "बिस्मिल्लाह खाँ ने शहनाई को विश्व मंच पर पहुँचाया, किंतु वे सदैव बनारस और गंगा की सादगी में ही रमे रहे।", "Bismillah Khan elevated the shehnai to classical status and cherished India's cultural heritage.")
            ),
            scenes = listOf(
                s(1, "एवलिन और रॉन फोर्ब्स का अभ्यास", "Feeling Music Vibrations", "एवलिन नंगे पाँव लकड़ी के मंच पर खड़ी हैं और रॉन फोर्ब्स के ड्रम के कंपन को दिल से महसूस कर रही हैं!", "Evelyn", "Ron Forbes", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Vibration Practice"),
                s(2, "रॉयल एकेडमी में विजय", "Top Musical Honour", "सख्त मेहनत से एवलिन ने रॉयल एकेडमी ऑफ म्यूज़िक में सर्वोच्च अंक और सम्मान हासिल किया!", "Evelyn", "Audience", CartoonSetting.ROYAL_PALACE, CartoonMood.HAPPY, "Award Night"),
                s(3, "गंगा घाट और शहनाई रियाज़", "Bismillah Khan at Ganga", "सुबह की सुनहरी धूप में छोटे बिस्मिल्लाह खाँ बालाजी मंदिर और गंगा किनारे घंटों शहनाई का रियाज़ कर रहे हैं!", "Bismillah Khan", "Ali Bux", CartoonSetting.OCEAN_SHIP, CartoonMood.THOUGHTFUL, "Ganga Riyaz"),
                s(4, "भारत रत्न सम्मान", "Pride of India", "उस्ताद बिस्मिल्लाह खाँ को भारत रत्न मिला—संगीत साधना से हर सपना सच हो सकता है!", "Bismillah Khan", "Imran Sir", CartoonSetting.ROYAL_PALACE, CartoonMood.INSPIRING, "Bharat Ratna")
            ),
            words = listOf(
                w("Profoundly", "adv", "Completely / very deeply", "गहराई से / पूर्णतः", "Evelyn was profoundly deaf by age eleven."),
                w("Daunting", "adj", "Frightening / difficult", "कठिन / डराने वाला", "Facing the Royal Academy was a daunting task."),
                w("Resonances", "noun", "Echoing vibrations of sound", "गूँज / कंपन", "She felt resonances flowing into her body."),
                w("Auspicious", "adj", "Favourable / lucky", "शुभ / मंगलमय", "Shehnai sound is considered auspicious."),
                w("Improvised", "verb", "Invented or improved spontaneously", "सुधारकर नया रूप दिया", "A barber improvised the traditional pungi."),
                w("Indispensable", "adj", "Absolutely necessary", "अनिवार्य / अभिन्न", "Shehnai became indispensable at weddings."),
                w("Priceless", "adj", "Of value too great to measure", "अमूल्य", "She gave free concerts in prisons and hospitals."),
                w("Coveted", "adj", "Greatly desired", "बहुप्रतीक्षित / प्रतिष्ठित", "He received India's coveted Bharat Ratna.")
            ),
            facts = listOf(
                f("Who spotted Evelyn's musical potential and trained her to feel vibrations?", "Ron Forbes", listOf("James Blades", "Bismillah Khan", "Ann Richlin"), "तालवादक रॉन फोर्ब्स ने एवलिन की प्रतिभा को पहचाना।"),
                f("In which year was Ustad Bismillah Khan awarded the Bharat Ratna?", "2001", listOf("1995", "1947", "2006"), "सन् 2001 में उस्ताद बिस्मिल्लाह खाँ को भारत रत्न से सम्मानित किया गया।")
            ),
            fbs = listOf("Aurangzeb banned the playing of ______ in the royal residence." to "pungi", "Evelyn feels the sound through her bare ______ on wooden platforms." to "feet"),
            tfs = listOf("Bismillah Khan agreed to settle permanently in the USA." to false, "Evelyn Glennie won the Soloist of the Year award in 1991." to true)
        ),

        spec(
            id = "c9_bh_3",
            teachingHi = "यह कहानी छोटी बच्ची केज़िया और उसके सख्त दिखने वाले पिता के रिश्ते की मधुर कथा है। पहले केज़िया अपने पिता से बहुत डरती थी और गलती से पिता के ज़रूरी भाषण के कागज़ फाड़कर पिन-कुशन में भर देती है, जिससे उसे डाँट पड़ती है। परंतु जब माँ अस्पताल में होती हैं और केज़िया को डरावना सपना आता है, तो वही पिता उसे गोद में सुलाकर अपना गहरा प्रेम दिखाते हैं।",
            paragraphs = listOf(
                p(1, "पिता से डर और हकलाना", "To Kezia, her father was a figure to be feared and avoided.", "केज़िया को अपने पिता बहुत बड़े और सख्त लगते थे। उनके सामने बोलते समय वह डर के मारे हकलाने लगती थी, जबकि पड़ोस के श्री मैकडोनाल्ड अपने बच्चों के साथ हँसते-खेलते थे।", "कठोर अनुशासन कभी-कभी बच्चों में डर पैदा कर देता है।"),
                p(2, "पिन-कुशन उपहार और अनजानी गलती", "Kezia tore her father's great speech papers to stuff a pin-cushion birthday gift.", "दादी की सलाह पर केज़िया ने पिता के जन्मदिन के लिए पिन-कुशन बनाया और उसमें भरने के लिए मेज़ पर रखे पिता के ज़रूरी भाषण के कागज़ फाड़ दिए। पिता ने गुस्से में उसके हाथों पर रूलर से मारा।", "बच्चे प्रेम से गलती कर बैठते हैं, माता-पिता को भी धैर्य रखना चाहिए।"),
                p(3, "अकेली रात और डरावना सपना", "One night when Mother was in hospital, Kezia had a terrifying nightmare of a butcher.", "एक रात जब माँ अस्पताल में थीं, केज़िया ने भयानक सपना देखा और रो पड़ी। तभी पिता आए, उसे गोद में उठाकर अपने बिस्तर पर सुलाया और गर्माहट दी।", "सख्त दिखने वाले पिता के भीतर भी कोमल हृदय होता है।")
            ),
            characters = listOf(
                c("Kezia", "केज़िया", "संवेदनशील छोटी बच्ची", listOf("भोली", "प्रेम की प्यासी", "संवेदनशील"), "केज़िया शुरू में पिता से डरती है, पर जब वह उनका स्नेह देखती है तो समझ जाती है कि पिता का दिल बहुत बड़ा है।", "Kezia is an affectionate little girl who overcomes her fear of her stern father."),
                c("Kezia's Father", "केज़िया के पिता", "परिश्रमी व अनुशासनप्रिय पिता", listOf("मेहनती", "अनुशासित", "दयालु हृदय"), "वे दिनभर काम के कारण थके रहते हैं और सख्त दिखते हैं, पर मुसीबत में बेटी को सबसे सुरक्षित आश्रय देते हैं।", "Though strict and overworked, Kezia's father deeply loves and protects his daughter.")
            ),
            scenes = listOf(
                s(1, "सख्त पिता और डरी केज़िया", "Morning Goodbye", "हर सुबह पिता के भारी आवाज़ से नन्ही केज़िया घबरा जाती है और चुपचाप जूते उतारती है।", "Kezia", "Father", CartoonSetting.HOME_GARDEN, CartoonMood.THOUGHTFUL, "Strict Routine"),
                s(2, "कागज़ की गलती", "The Pin-Cushion Mistake", "ओह! केज़िया ने जन्मदिन का तोहफा बनाने के लिए पिता के भाषण के कागज़ फाड़ दिए!", "Kezia", "Grandmother", CartoonSetting.HOME_GARDEN, CartoonMood.DRAMATIC, "Torn Speech"),
                s(3, "मैकडोनाल्ड परिवार का प्यार", "Happy Neighbours", "खिड़की से केज़िया देखती है कि मिस्टर मैकडोनाल्ड अपने बच्चों के साथ बगीचे में हँस-खेल रहे हैं!", "Kezia", "Macdonalds", CartoonSetting.HOME_GARDEN, CartoonMood.HAPPY, "Fence View"),
                s(4, "पिता का बड़ा दिल", "Father's Warm Hug", "रात के डरावने सपने के बाद पिता ने केज़िया को अपने पास सुलाया। केज़िया बोली—पापा, आपका दिल बहुत बड़ा है!", "Kezia", "Father", CartoonSetting.HOME_GARDEN, CartoonMood.INSPIRING, "Warm Reconciliation")
            ),
            words = listOf(
                w("Stutter", "verb", "Speak with involuntary pauses", "हकलाना", "Kezia began to stutter only in front of her father."),
                w("Wretched", "adj", "Very unhappy or unfortunate", "दयनीय / दुःखी", "She looked like a wretched little creature."),
                w("Brink", "noun", "Edge of crying or danger", "कगार / किनारा", "The child was always on the brink of suicide of tears."),
                w("Nightmare", "noun", "A frightening dream", "डरावना सपना", "She woke up crying from a nightmare."),
                w("Sighed", "verb", "Let out a long deep breath", "आह भरी / चैन की सांस ली", "Kezia sighed softly as she felt her father's heartbeat.")
            ),
            facts = listOf(
                f("What birthday gift did Kezia make for her father?", "A yellow silk pin-cushion", listOf("A greeting card", "A woollen scarf", "A wooden pen"), "केज़िया ने दादी के कहने पर पीले रेशम का पिन-कुशन बनाया।")
            )
        ),

        spec(
            id = "c9_bh_4",
            teachingHi = "यह पाठ महान वैज्ञानिक अल्बर्ट आइंस्टीन के मानवीय जीवन को दिखाता है। बचपन में वे देर से बोले और स्कूल के सख्त नियमों से ऊब गए थे, पर गणित व भौतिकी में वे अद्भुत थे। उन्होंने सापेक्षता का सिद्धांत दिया, नोबेल पुरस्कार पाया और जीवनभर विश्व शांति तथा परमाणु हथियारों के विरुद्ध आवाज़ उठाई।",
            paragraphs = listOf(
                p(1, "बचपन और अनोखी जिज्ञासा", "Einstein did not speak until age two-and-a-half and loved mechanical toys.", "आइंस्टीन ढाई साल तक नहीं बोले और बचपन में अपने में खोए रहते थे, जिस कारण साथी उन्हें 'ब्रदर बोरिंग' कहते थे। उन्हें यांत्रिक खिलौने बहुत पसंद थे।", "असामान्य बचपन भी महान प्रतिभा का संकेत हो सकता है।"),
                p(2, "सापेक्षता का सिद्धांत और नोबेल पुरस्कार", "Einstein published the Special Theory of Relativity in 1905 and won the 1921 Nobel Prize.", "1905 में आइंस्टीन ने सापेक्षता का विशेष सिद्धांत दिया (E = mc²) और 1915 में सामान्य सिद्धांत, जिसने विज्ञान की दुनिया बदल दी। 1921 में उन्हें भौतिकी का नोबेल मिला।", "निरंतर शोध और जिज्ञासा इतिहास रच देती है।"),
                p(3, "विश्व शांति और लोकतंत्र के समर्थक", "Shocked by atomic bombings, Einstein campaigned for peace and a world government.", "हिरोशिमा और नागासाकी की तबाही से आहत होकर आइंस्टीन ने परमाणु हथियारों का विरोध किया और विश्व शांति के लिए जीवनभर प्रयास किए।", "विज्ञान का उद्देश्य मानव कल्याण होना चाहिए, विनाश नहीं।")
            ),
            characters = listOf(
                c("Albert Einstein", "अल्बर्ट आइंस्टीन", "महान वैज्ञानिक और शांति दूत", listOf("जिज्ञासु", "प्रतिभाशाली", "मानवतावादी"), "आइंस्टीन न केवल विज्ञान के जादूगर थे, बल्कि शांति और लोकतंत्र के सच्चे समर्थक भी थे।", "Einstein was both a revolutionary physicist and a tireless advocate for global peace.")
            ),
            scenes = listOf(
                s(1, "म्यूनिख के सख्त स्कूल से विदाई", "Curious Young Albert", "रटने वाले सख्त स्कूल से ऊबकर अल्बर्ट स्विट्जरलैंड के खुले माहौल में पढ़ने चले गए।", "Albert", "Headmaster", CartoonSetting.CLASSROOM, CartoonMood.THOUGHTFUL, "School Shift"),
                s(2, "पेटेंट ऑफिस की मेज़ पर खोज", "Relativity Discovery", "बर्न के पेटेंट ऑफिस के दराज में अल्बर्ट ने ब्रह्मांड के सबसे बड़े रहस्य—E=mc²—को लिखा!", "Albert", "Mileva", CartoonSetting.MOUNTAIN_LAB, CartoonMood.INSPIRING, "E=mc² Breakthrough"),
                s(3, "1921 का नोबेल पुरस्कार", "Nobel Glory", "पूरे विश्व ने आइंस्टीन की प्रतिभा को सलाम किया और उन्हें भौतिकी का नोबेल सम्मान मिला!", "Albert", "Scientists", CartoonSetting.ROYAL_PALACE, CartoonMood.HAPPY, "Nobel Prize"),
                s(4, "विश्व शांति का संदेश", "Messenger of Peace", "इमरान सर समझाते हैं—सच्चा वैज्ञानिक वही है जो मानवता और विश्व शांति के लिए काम करे!", "Albert", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Peace Message")
            ),
            words = listOf(
                w("Freak", "noun", "Someone unusual or different", "अनोखा / विचित्र", "His mother thought little Albert was a freak."),
                w("Stifled", "verb", "Felt suffocated or restricted", "घुटन महसूस करना", "He felt stifled by strict school regimentation."),
                w("Unravel", "verb", "Solve or reveal a mystery", "रहस्य सुलझाना", "He wanted to unravel the mysteries of the universe."),
                w("Emigrated", "verb", "Moved permanently to another country", "दूसरे देश जा बसना", "Einstein emigrated to the United States in 1933.")
            ),
            facts = listOf(
                f("What nickname did Albert Einstein's playmates give him?", "Brother Boring", listOf("Little Genius", "Brother Silent", "Master Mind"), "बचपन में साथी खेल न पाने के कारण उन्हें 'Brother Boring' कहते थे।")
            )
        ),

        spec(
            id = "c9_bh_5",
            teachingHi = "यह एक मज़ेदार और शिक्षाप्रद कहानी है जिसमें एक अविवाहित होम्योपैथी डॉक्टर अपनी सुंदरता पर घमंड करते हुए आईना देख रहा होता है। अचानक एक ज़हरीला साँप उसके कंधे पर आ गिरता है! डर से डॉक्टर पत्थर बन जाता है, पर साँप भी आईने में अपनी सुंदरता देखने में लग जाता है और डॉक्टर की जान बच जाती है। सुबह चोर डॉक्टर का सारा सामान ले जाता है, बस उसकी गंदी बनियान छोड़ जाता है!",
            paragraphs = listOf(
                p(1, "गर्मी की रात और डॉक्टर का अहंकार", "A young homoeopathic doctor looked in the mirror and planned to grow a thin moustache.", "डॉक्टर बहुत कम पैसे कमाता था और किराए के कमरे में रहता था। आईने में खुद को देखकर वह अपनी सुंदरता और भविष्य की अमीर दुल्हन के सपने बुन रहा था।", "अहंकार अक्सर वास्तविक खतरे से अनजान रखता है।"),
                p(2, "कंधे पर साँप का गिरना", "A fat snake slithered onto the doctor's shoulder and coiled around his left arm.", "अचानक छत की बीम से एक मोटा साँप डॉक्टर की कुर्सी और फिर कंधे पर गिरकर बाएँ हाथ से लिपट गया। डॉक्टर साँस रोके मूर्ति की तरह बैठा रहा।", "संकट में घबराने के बजाय शांत रहना ही जीवन बचाता है।"),
                p(3, "साँप का आईना देखना और चोरी का हास्य", "The snake moved towards the mirror, letting the doctor flee, though a thief stole everything.", "जब साँप ने मेज़ पर रखे आईने में अपना प्रतिबिंब देखा तो वह डॉक्टर का हाथ छोड़कर आईने के पास चला गया। डॉक्टर भाग निकला, पर अगली सुबह देखा कि चोर सब कुछ ले गया!", "प्रकृति के सामने मनुष्य का अहंकार क्षणभर में टूट जाता है।")
            ),
            characters = listOf(
                c("The Homoeopath Doctor", "होम्योपैथी डॉक्टर", "कहानी का कथावाचक", listOf("अभिमानी पहले", "भयभीत फिर विनम्र", "हास्यप्रिय"), "पहले डॉक्टर रूप का अहंकार करता है, पर मौत को करीब से देखने पर ईश्वर की शरण और विनम्रता का महत्व समझ जाता है।", "The young doctor learns humility after a terrifying yet humorous encounter with a mirror-gazing snake.")
            ),
            scenes = listOf(
                s(1, "आईने के सामने सपने", "Doctor's Vanity", "गर्म रात में लैंप के पास डॉक्टर आईने में मूँछें संवारते हुए शादी के सपने देख रहे हैं!", "Doctor", "Mirror", CartoonSetting.HOME_GARDEN, CartoonMood.HAPPY, "Mirror Pride"),
                s(2, "धड़ाम! कंधे पर साँप", "The Snake Strikes", "अरे बाप रे! बीम से एक मोटा कोबरा डॉक्टर के बाएँ हाथ पर लिपट गया है—डॉक्टर पत्थर बन गए हैं!", "Doctor", "Snake", CartoonSetting.MOUNTAIN_LAB, CartoonMood.DRAMATIC, "Frozen Fear"),
                s(3, "साँप की सेल्फी (आईना प्रेम)", "Snake Admires Mirror", "हाहा! साँप खुद को आईने में देखकर खो गया और डॉक्टर मौका पाकर जान बचाकर भाग निकले!", "Doctor", "Snake", CartoonSetting.HOME_GARDEN, CartoonMood.MYSTERY, "Smart Escape"),
                s(4, "चोर का मज़ेदार तोहफा", "Thief Left Vest", "सुबह कमरे में सब गायब था—सिर्फ डॉक्टर की गंदी बनियान बची थी! घमंड से हमेशा बचो बच्चों!", "Doctor", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Humorous Moral")
            ),
            words = listOf(
                w("Solitary", "adj", "Single / alone", "अकेला / एकांत", "His meagre earnings gave him a solitary black coat."),
                w("Slithered", "verb", "Moved smoothly like a snake", "रेंगकर फिसलना", "The snake slithered along his shoulder."),
                w("Admire", "verb", "Look at with pleasure and approval", "प्रशंसा करना / निहारना", "The snake seemed to admire its reflection."),
                w("Meagre", "adj", "Very small in amount", "अल्प / बहुत कम", "His earnings were meagre.")
            ),
            facts = listOf(
                f("What single item did the thief leave behind in the doctor's room?", "His dirty vest", listOf("His black coat", "His suitcase", "Sixty rupees"), "चोर सफाई पसंद था इसलिए उसने केवल डॉक्टर की गंदी बनियान छोड़ दी।")
            )
        ),

        spec(
            id = "c9_bh_6",
            teachingHi = "यह पाठ भारत के मिसाइल मैन और पूर्व राष्ट्रपति डॉ. ए.पी.जे. अब्दुल कलाम की आत्मकथा 'Wings of Fire' का अंश है। रामेश्वरम के एक साधारण परिवार में जन्मे कलाम ने बचपन में इमली के बीज और अखबार बेचकर पहली कमाई की। इस पाठ में धार्मिक सद्भाव, माता-पिता के संस्कार और विज्ञान शिक्षक शिवसुब्रह्मण्यम अय्यर की प्रेरणा का अद्भुत वर्णन है।",
            paragraphs = listOf(
                p(1, "रामेश्वरम में बचपन और पहली कमाई", "Abdul Kalam was born in Rameswaram to honest parents and earned his first wages collecting newspapers.", "कलाम का जन्म रामेश्वरम के मध्यमवर्गीय तमिल परिवार में हुआ। द्वितीय विश्व युद्ध के समय उन्होंने चचेरे भाई शमसुद्दीन के साथ चलते ट्रेन से फेंके गए अखबार उठाकर अपनी पहली कमाई की।", "ईमानदारी और मेहनत बचपन से महान चरित्र बनाती है।"),
                p(2, "मित्रता और सांप्रदायिक एकता", "Kalam's closest friends Ramanadha Sastry, Aravindan, and Sivaprakasan belonged to Hindu families.", "कलाम के तीन पक्के मित्र हिंदू परिवारों से थे, पर बच्चों ने कभी धर्म का भेद नहीं समझा। जब एक नए शिक्षक ने भेदभाव किया, तो लक्ष्मण शास्त्री ने उसे सख्त चेतावनी दी।", "सच्ची दोस्ती धर्म और जाति की दीवारों से ऊपर होती है।"),
                p(3, "अय्यर सर की सीख और बड़ा बदलाव", "Science teacher Sivasubramania Iyer invited Kalam to dinner and changed his conservative wife's mind.", "विज्ञान शिक्षक अय्यर सर ने कलाम को घर पर भोजन कराया। अगली बार उनकी पत्नी ने स्वयं अपने हाथों से कलाम को खाना परोसा और रूढ़िवादिता समाप्त हुई।", "आदर्श शिक्षक समाज में सकारात्मक बदलाव लाते हैं।")
            ),
            characters = listOf(
                c("A.P.J. Abdul Kalam", "ए.पी.जे. अब्दुल कलाम", "ईमानदार व जिज्ञासु बालक (भविष्य के राष्ट्रपति)", listOf("सादा जीवन", "परिश्रमी", "सर्वधर्म समभाव"), "कलाम ने बचपन में माता-पिता से ईमानदारी व आत्मानुशासन सीखा और आगे चलकर भारत के महान वैज्ञानिक व राष्ट्रपति बने।", "Young Kalam embodies simplicity, resilience, secular harmony, and lifelong curiosity.")
            ),
            scenes = listOf(
                s(1, "रामेश्वरम में अखबारों का बंडल", "First Honest Wages", "युद्ध के समय चलते ट्रेन से गिरते अखबारों का बंडल पकड़कर छोटे कलाम ने अपनी पहली कमाई की!", "Young Kalam", "Samsuddin", CartoonSetting.CITY_MARKET, CartoonMood.INSPIRING, "First Earnings"),
                s(2, "कक्षा में एकता का पाठ", "Friendship Beyond Barriers", "नए टीचर के भेदभाव पर पुजारी लक्ष्मण शास्त्री ने एकता और समानता का कड़ा संदेश दिया!", "Kalam", "Ramanadha", CartoonSetting.CLASSROOM, CartoonMood.DRAMATIC, "Unity Lesson"),
                s(3, "अय्यर सर के घर भोजन", "Breaking Prejudice", "विज्ञान शिक्षक अय्यर सर के व्यवहार ने सामाजिक रूढ़ियों को तोड़कर प्रेम का संदेश दिया!", "Kalam", "Iyer Sir", CartoonSetting.HOME_GARDEN, CartoonMood.THOUGHTFUL, "Dinner Invitation"),
                s(4, "उड़ान की अनुमति", "Wings of Fire", "पिता ने खलील जिब्रान की पंक्तियों से कहा—बेटे, बड़ा बनने के लिए घर से बाहर उड़ान भरनी ही पड़ती है!", "Kalam", "Jainulabdeen", CartoonSetting.OCEAN_SHIP, CartoonMood.HAPPY, "Higher Studies")
            ),
            words = listOf(
                w("Austere", "adj", "Simple and strict without luxuries", "सादगीपूर्ण / संयमी", "His father avoided all inessential comforts with an austere lifestyle."),
                w("Innate", "adj", "Inborn / natural", "जन्मजात / स्वाभाविक", "Jainulabdeen possessed great innate wisdom."),
                w("Segregation", "noun", "Unfair separation of groups", "अलगाव / भेदभाव", "Sivasubramania Iyer broke social segregation."),
                w("Orthodox", "adj", "Strictly following old traditions", "रूढ़िवादी", "He had a rather orthodox Brahmin background.")
            ),
            facts = listOf(
                f("From which book is the chapter 'My Childhood' taken?", "Wings of Fire", listOf("Ignited Minds", "India 2020", "My Experiments with Truth"), "'My Childhood' डॉ. कलाम की आत्मकथा 'Wings of Fire' से लिया गया है।")
            )
        ),

        spec(
            id = "c9_bh_7",
            teachingHi = "यह पाठ दो साहसी महिलाओं—संतोष यादव और मारिया शारापोवा—की सफलता गाथा है। हरियाणा के एक पारंपरिक गाँव की संतोष यादव ने अपनी इच्छाशक्ति से पढ़कर एवरेस्ट दो बार फतह किया। वहीं साइबेरिया की मारिया शारापोवा ने कम उम्र में परिवार से दूर रहकर कड़ा अभ्यास किया और विश्व की नंबर 1 टेनिस खिलाड़ी बनीं।",
            paragraphs = listOf(
                p(1, "संतोष यादव का परंपराओं से संघर्ष", "Santosh Yadav refused early marriage at sixteen and chose higher education in Delhi.", "हरियाणा के गाँव में जन्मी संतोष ने 16 वर्ष की उम्र में शादी से इनकार कर दिल्ली में पढ़ाई की और माता-पिता को अपनी दृढ़ता से मना लिया।", "सही लक्ष्य के लिए साहस से कदम उठाना आवश्यक है।"),
                p(2, "एवरेस्ट पर दो बार तिरंगा और पर्यावरण प्रेम", "Santosh scaled Mount Everest twice and brought down 500 kilograms of garbage from the Himalayas.", "1992 में वे एवरेस्ट फतह करने वाली सबसे कम उम्र की महिला बनीं और एक वर्ष बाद दूसरी बार शिखर पर पहुँचीं। वे हिमालय से 500 किलो कचरा भी नीचे लाईं।", "सच्चा पर्वतारोही प्रकृति की रक्षा भी करता है।"),
                p(3, "मारिया शारापोवा की तपस्या और विश्व नंबर 1", "At nine, Maria Sharapova went to Florida with her father and rose to World No. 1.", "नौ साल की उम्र में मारिया अमेरिका गईं, कठिन अकेलापन सहा, तानों के बावजूद मेहनत की और विंबलडन जीतकर विश्व नंबर 1 बनीं।", "त्याग और अनुशासन सफलता की असली कीमत हैं।")
            ),
            characters = listOf(
                c("Santosh Yadav", "संतोष यादव", "दो बार एवरेस्ट विजेता भारतीय पर्वतारोही", listOf("निडर", "पर्यावरण प्रेमी", "आत्मनिर्भर"), "संतोष ने रूढ़ियों को तोड़कर अपनी शिक्षा पूरी की और भारत का गौरव बढ़ाया।", "Santosh Yadav is a courageous two-time Everest summiteer and environmental champion."),
                c("Maria Sharapova", "मारिया शारापोवा", "विश्व नंबर 1 टेनिस स्टार", listOf("एकाग्र", "कठोर परिश्रमी", "आत्मविश्वासी"), "कम उम्र में माँ से दूर रहकर भी मारिया ने अपने लक्ष्य से ध्यान नहीं हटाया।", "Maria Sharapova achieved tennis greatness through discipline and mental toughness.")
            ),
            scenes = listOf(
                s(1, "रूढ़ियों के विरुद्ध संतोष का फैसला", "Choosing Education", "संतोष ने बचपन में ही ठान लिया कि वह पारंपरिक बंधनों में नहीं बँधेंगी और उच्च शिक्षा लेंगी!", "Santosh", "Parents", CartoonSetting.HOME_GARDEN, CartoonMood.THOUGHTFUL, "Firm Stand"),
                s(2, "एवरेस्ट शिखर पर तिरंगा", "Twice on Everest", "बर्फीली हवाओं के बीच संतोष यादव ने एवरेस्ट की चोटी पर भारतीय तिरंगा लहराया!", "Santosh", "Team", CartoonSetting.MOUNTAIN_LAB, CartoonMood.INSPIRING, "Summit Victory"),
                s(3, "फ्लोरिडा में मारिया का अभ्यास", "Maria's Hard Training", "कठिन अकेलेपन में भी नन्ही मारिया हर सुबह टेनिस कोर्ट में पसीना बहाती रहीं!", "Maria", "Coach", CartoonSetting.CITY_MARKET, CartoonMood.DRAMATIC, "Tennis Drill"),
                s(4, "विश्व नंबर 1 का ताज", "Reaching the Top", "2004 में विंबलडन और फिर विश्व नंबर 1—मेहनत कभी बेकार नहीं जाती!", "Maria", "Imran Sir", CartoonSetting.ROYAL_PALACE, CartoonMood.HAPPY, "World Number One")
            ),
            words = listOf(
                w("Contentment", "noun", "State of peaceful satisfaction", "संतोष / तृप्ति", "Her parents lived with quiet contentment."),
                w("Culmination", "noun", "Highest point of achievement", "चरम सीमा / परिणति", "Everest was the culmination of her training."),
                w("Endurance", "noun", "Ability to bear prolonged hardship", "सहनशक्ति", "Mountaineering requires immense endurance."),
                w("Disarming", "adj", "Winning affection and removing fear", "मन मोह लेने वाला / सहज", "Maria has a disarming smile.")
            ),
            facts = listOf(
                f("How much garbage did Santosh Yadav collect and bring down from the Himalayas?", "500 kilograms", listOf("50 kilograms", "100 kilograms", "200 kilograms"), "संतोष यादव हिमालय से 500 किलोग्राम कचरा नीचे लाई थीं।")
            )
        ),

        spec(
            id = "c9_bh_8",
            teachingHi = "इस यात्रा वृत्तांत में लेखक विक्रम सेठ काठमांडू के दो प्रसिद्ध धार्मिक स्थलों—पशुपतिनाथ मंदिर और बौद्धनाथ स्तूप—का सजीव वर्णन करते हैं। पशुपतिनाथ के बाहर शोरगुल और भीड़ है, जबकि बौद्धनाथ स्तूप में अद्भुत शांति है। अंत में एक बाँसुरी वाले की मधुर धुन लेखक का मन मोह लेती है।",
            paragraphs = listOf(
                p(1, "पशुपतिनाथ मंदिर का जीवंत दृश्य", "At Pashupatinath, a sign reads 'Entrance for the Hindus only', amidst bustling crowds.", "पशुपतिनाथ मंदिर के बाहर यात्रियों, पुजारियों, कबूतरों और बंदरों की चहल-पहल और 'Febrile confusion' देखने को मिलती है।", "भीड़भाड़ और धार्मिक आस्था का मिलाजुला चित्रण।"),
                p(2, "बौद्धनाथ स्तूप की शांति", "In contrast, the Baudhnath stupa offers a haven of quietness.", "पशुपतिनाथ के कोलाहल के ठीक विपरीत, बौद्धनाथ स्तूप के विशाल सफेद गुंबद के चारों ओर गहरी शांति और सुकून महसूस होता है।", "शांति बाहरी स्थान से अधिक भीतर की अनुभूति है।"),
                p(3, "बाँसुरी विक्रेता और संगीत की सार्वभौमिकता", "A flute seller plays meditatively; flute music is common to all human cultures.", "चौराहे पर खड़ा बाँसुरी वाला अपनी मधुर धुन में खोया रहता है। लेखक अनुभव करते हैं कि बाँसुरी हर मानव संस्कृति में साँस की तरह जुड़ी है।", "संगीत भाषा और सीमाओं से परे सबको जोड़ता है।")
            ),
            characters = listOf(
                c("Vikram Seth", "विक्रम सेठ", "संवेदनशील यात्री व लेखक", listOf("सूक्ष्म प्रेक्षक", "कला प्रेमी", "शांतचित्त"), "लेखक काठमांडू की गलियों, मंदिरों और बाँसुरी की ध्वनि को जीवंत शब्दों में पिरोते हैं।", "Vikram Seth observes Kathmandu's contrasts with poetic sensitivity.")
            ),
            scenes = listOf(
                s(1, "पशुपतिनाथ का व्यस्त द्वार", "Pashupatinath Crowd", "बागमती नदी के किनारे पशुपतिनाथ मंदिर में श्रद्धालु, बंदर और फूल विक्रेता हर तरफ हैं!", "Vikram Seth", "Pilgrims", CartoonSetting.CITY_MARKET, CartoonMood.DRAMATIC, "Temple Bustle"),
                s(2, "बौद्धनाथ की शांत छटा", "Quiet Baudhnath Stupa", "बौद्धनाथ स्तूप के सफेद विशाल गुंबद के पास कितनी अद्भुत शांति है!", "Vikram Seth", "Monks", CartoonSetting.MOUNTAIN_LAB, CartoonMood.THOUGHTFUL, "Peaceful Stupa"),
                s(3, "चौराहे पर बाँसुरी की धुन", "Magic of the Flute", "बाँसुरी वाले की बिना दिखावे की मधुर तान सुनकर लेखक मंत्रमुग्ध हो जाते हैं!", "Flute Seller", "Vikram Seth", CartoonSetting.CITY_MARKET, CartoonMood.HAPPY, "Flute Melody"),
                s(4, "घर वापसी का निर्णय", "Returning Home", "इमरान सर बताते हैं—बाँसुरी की आवाज़ मानवता की साँस जैसी सार्वभौमिक भाषा है!", "Vikram Seth", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Cultural Unity")
            ),
            words = listOf(
                w("Proclaim", "verb", "Announce officially", "घोषणा करना", "A sign proclaims entrance rules at the gate."),
                w("Febrile", "adj", "Hurried and excited", "उत्तेजित / हड़बड़ी भरा", "An atmosphere of febrile confusion reigns outside."),
                w("Haven", "noun", "A place of safety and peace", "शरणस्थली / शांत स्थान", "The stupa felt like a haven of quietness."),
                w("Meditatively", "adv", "Thoughtfully and calmly", "ध्यानमग्न होकर", "The flute seller played slowly and meditatively.")
            ),
            facts = listOf(
                f("Which holy river flows beside the Pashupatinath temple in Kathmandu?", "Bagmati", listOf("Ganga", "Kosi", "Yamuna"), "काठमांडू में पशुपतिनाथ मंदिर के पास बागमती नदी बहती है।")
            )
        ),

        spec(
            id = "c9_bh_9",
            teachingHi = "यह एक रोचक एकांकी नाटक (Play) है। जेरार्ड एक नाटककार है जिसके घर में एक अपराधी घुसपैठिया (Intruder) पिस्तौल लेकर घुस आता है। वह जेरार्ड को मारकर उसकी पहचान चुराना चाहता है। पर जेरार्ड अपनी तेज़ बुद्धि से झूठी कहानी गढ़ता है कि वह खुद एक अपराधी है और पुलिस उसके पीछे है—इस तरह घुसपैठिये को अलमारी में बंद कर देता है!",
            paragraphs = listOf(
                p(1, "कुटिया में घुसपैठिये का प्रवेश", "An armed intruder enters Gerrard's lonely cottage intending to kill him and steal his identity.", "जेरार्ड फोन पर बात कर रहा होता है तभी एक पिस्तौलधारी घुसपैठिया आ धमकता है। वह शक्ल में जेरार्ड जैसा है और जेरार्ड को मारकर उसका नाम अपनाना चाहता है।", "अचानक आए संकट में डरना नहीं चाहिए।"),
                p(2, "जेरार्ड की चतुराई भरी कहानी", "Gerrard calmly invents a tale that he himself is a wanted criminal ready to flee.", "जेरार्ड बिना घबराए घुसपैठिये को विश्वास दिलाता है कि वह स्वयं हत्या के केस में फरार है और पुलिस किसी भी पल यहाँ पहुँच सकती है।", "उपस्थित बुद्धि (Presence of mind) तलवार से भी तेज होती है।"),
                p(3, "अलमारी में कैद और नाटक का अंत", "Gerrard pushes the tricked intruder into a cupboard and locks him in.", "गैरेज की ओर देखने के बहाने जेरार्ड घुसपैठिये को अलमारी में धकेलकर बंद कर देता है और पुलिस के सार्जेंट को फोन लगा देता है।", "सत्य और बुद्धिमानी से हर चाल नाकाम की जा सकती है।")
            ),
            characters = listOf(
                c("Gerrard", "जेरार्ड", "चतुर और शांत नाटककार", listOf("बुद्धिमान", "निडर", "हाजिरजवाब"), "जेरार्ड पिस्तौल के सामने भी अपना संतुलन नहीं खोता और अपनी नाटकीय बुद्धि से अपराधी को जाल में फँसा लेता है।", "Gerrard is a quick-witted, calm playwright who outsmarts an armed intruder."),
                c("The Intruder", "घुसपैठिया", "अहंकारी व जल्दबाज़ अपराधी", listOf("अभिमानी", "अधैर्यवान", "मूर्खतापूर्ण अतिआत्मविश्वासी"), "अति-आत्मविश्वास में आकर वह जेरार्ड की गढ़ी हुई कहानी पर भरोसा कर लेता है और पकड़ा जाता है।", "The Intruder is overconfident and easily falls into Gerrard's clever trap.")
            ),
            scenes = listOf(
                s(1, "पिस्तौल के साथ घुसपैठ", "Intruder Enters", "अचानक शांत कमरे में पिस्तौल लिए घुसपैठिया जेरार्ड पर निशाना साधता है!", "Intruder", "Gerrard", CartoonSetting.HOME_GARDEN, CartoonMood.DRAMATIC, "Armed Entry"),
                s(2, "पहचान चुराने की योजना", "Identity Theft Plot", "घुसपैठिया बताता है कि वह जेरार्ड जैसा दिखता है और उसे मारकर उसकी पहचान लेगा!", "Intruder", "Gerrard", CartoonSetting.MOUNTAIN_LAB, CartoonMood.MYSTERY, "Evil Plan"),
                s(3, "जेरार्ड का चतुर नाटक", "Gerrard's Smart Bluff", "जेरार्ड मुस्कुराकर झूठ बोलता है—मेरे भी पीछे पुलिस लगी है, जल्दी मेरे साथ भागो!", "Gerrard", "Intruder", CartoonSetting.CITY_MARKET, CartoonMood.THOUGHTFUL, "Clever Bluff"),
                s(4, "अलमारी में लॉक!", "Caught in Cupboard", "धड़ाम! जेरार्ड ने घुसपैठिये को अलमारी में बंद कर पुलिस बुला ली—बुद्धि की जीत!", "Gerrard", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Smart Victory")
            ),
            words = listOf(
                w("Intruder", "noun", "A person entering without permission", "घुसपैठिया", "The intruder held a revolver in his hand."),
                w("Nonchalant", "adj", "Calm and unconcerned", "शांत व बेफिक्र", "Gerrard kept a nonchalant tone despite danger."),
                w("Melodramatic", "adj", "Over-dramatic or exaggerated", "अति-नाटकीय", "Gerrard called the intruder's threat melodramatic."),
                w("Disguise", "noun", "Clothing or appearance to hide identity", "वेश बदलना / छद्मवेश", "Gerrard showed false moustaches as disguise props.")
            ),
            facts = listOf(
                f("Where did Gerrard trap the intruder at the end of the play?", "Inside a cupboard", listOf("Inside a basement", "Inside a car", "On the terrace"), "जेरार्ड ने चालाकी से घुसपैठिये को अलमारी (cupboard) में बंद कर दिया।")
            )
        ),

        spec(
            id = "c9_mo_1",
            teachingHi = "मुल्क राज आनंद की यह मार्मिक कहानी बताती है कि बच्चों के लिए माता-पिता से बढ़कर दुनिया की कोई चीज़ नहीं होती। मेले में जाते समय बच्चा मिठाई, खिलौने, माला और झूले की माँग करता है, पर जब वह भीड़ में माता-पिता से बिछड़ जाता है तो एक दयालु अजनबी के वे सभी उपहार भी ठुकरा देता है—उसे बस अपने माँ-पापा चाहिए!",
            paragraphs = listOf(
                p(1, "वसंत मेले का उत्साह और छोटे आकर्षण", "On his way to the spring fair, the child gets fascinated by toys, mustard fields, and dragonflies.", "वसंत मेले में जाते हुए बच्चा खिलौनों, सरसों के पीले खेतों, गुलमोहर की माला और जलेबी-बर्फी देखकर रुक जाता है, पर माता-पिता की एक पुकार पर दौड़ पड़ता है।", "बच्चे की दुनिया रंग-बिरंगी और जिज्ञासा से भरी होती है।"),
                p(2, "झूले के पास बिछड़ने का दर्द", "When he asks boldly for a ride on the roundabout, he turns and finds his parents gone.", "झूले (roundabout) के पास पहुँचकर जब वह हिम्मत से झूलने की अनुमति माँगता है और पीछे मुड़ता है, तो वहाँ उसके माता-पिता नहीं होते! वह ज़ोर-ज़ोर से रोने लगता है।", "माता-पिता से बिछड़ते ही दुनिया का सारा आनंद फीका पड़ जाता है।"),
                p(3, "अजनबी की सहानुभूति और 'मुझे मेरी माँ चाहिए!'", "A kind man offers him sweets, balloons, and rides, but the child only sobs for his mother and father.", "भीड़ में दबा बच्चा एक दयालु व्यक्ति को मिलता है। वह उसे गुब्बारे, मिठाई और झूले का लालच देता है, पर बच्चा हर चीज़ से मुँह मोड़कर केवल 'मुझे मेरी माँ और पापा चाहिए' कहता है।", "माता-पिता का प्रेम संसार के किसी भी खिलौने या धन से अनमोल है।")
            ),
            characters = listOf(
                c("The Little Child", "नन्हा बालक", "मेले में खोया मासूम बच्चा", listOf("मासूम", "मातृ-पितृ प्रेमी", "भावुक"), "मेले की हर चीज़ की जिद करने वाला बच्चा बिछड़ते ही समझ जाता है कि माँ-बाप के बिना हर खिलौना व्यर्थ है।", "The innocent boy values his parents above all tempting attractions of the fair."),
                c("The Kind Stranger", "दयालु अजनबी", "मददगार राहगीर", listOf("सहानुभूतिपूर्ण", "करुणामय", "धैर्यवान"), "वह रोते बच्चे को सुरक्षित उठाकर शांत करने व उसके माता-पिता से मिलाने का हर संभव प्रयास करता है।", "The compassionate stranger tries tirelessly to comfort the lost child.")
            ),
            scenes = listOf(
                s(1, "वसंत मेले की रंगीन गलियाँ", "Spring Fair Joy", "वाह! मेले में खिलौने, गुब्बारे और पीले सरसों के खेत देखकर बच्चा कितना खुश है!", "Child", "Parents", CartoonSetting.CITY_MARKET, CartoonMood.HAPPY, "Fair Wonders"),
                s(2, "भीड़ में खो जाना", "Lost at the Roundabout", "ओह नो! झूले के पास पीछे मुड़कर देखा तो मम्मी-पापा गायब हैं—बच्चा रोने लगा!", "Child", "Crowd", CartoonSetting.CITY_MARKET, CartoonMood.DRAMATIC, "Lost in Crowd"),
                s(3, "अजनबी के मीठे प्रस्ताव", "Stranger's Kind Offers", "एक दयालु भैया उसे मिठाई और गुब्बारे देते हैं, पर बच्चा रोते हुए मना कर देता है!", "Child", "Kind Stranger", CartoonSetting.CITY_MARKET, CartoonMood.THOUGHTFUL, "Refusing Gifts"),
                s(4, "अनमोल रिश्ता", "Love Beyond All Things", "इमरान सर समझाते हैं—बच्चों, माँ-पापा का साथ दुनिया के हर खिलौने और मिठाई से कीमती होता है!", "Child", "Imran Sir", CartoonSetting.HOME_GARDEN, CartoonMood.INSPIRING, "Parents First")
            ),
            words = listOf(
                w("Lagged", "verb", "Fell behind others", "पीछे रह जाना", "He lagged behind looking at roadside toys."),
                w("Gaudy", "adj", "Brightly coloured and showy", "भड़कीला / चमकीला", "He saw gaudy butterflies in the mustard field."),
                w("Inconsolable", "adj", "Impossible to comfort", "जिसे शांत न किया जा सके", "The lost child wept in inconsolable grief."),
                w("Throng", "noun", "A large crowded group", "भीड़ / जनसमूह", "Men jostled each other in the temple throng.")
            ),
            facts = listOf(
                f("What was the child's favourite sweet at the fair before getting lost?", "Burfi", listOf("Gulab Jamun", "Rasgulla", "Jalebi"), "खोने से पहले बच्चे को 'बर्फी' (Burfi) सबसे अधिक पसंद थी।")
            )
        ),

        spec(
            id = "c9_mo_2",
            teachingHi = "रस्किन बॉन्ड की यह हास्य कहानी एक शरारती लाल बंदर 'टोटो' के बारे में है जिसे दादाजी पाँच रुपये में एक ताँगे वाले से खरीदते हैं। टोटो देखने में सुंदर है, पर वह हर चीज़ तोड़ता है—दीवार का कागज़ फाड़ देता है, दादी की प्लेट तोड़ता है, और एक दिन पुलाव का बर्तन लेकर पेड़ पर भाग जाता है! अंततः परेशान होकर दादाजी उसे तीन रुपये में वापस बेच देते हैं।",
            paragraphs = listOf(
                p(1, "ताँगे वाले से टोटो की खरीद", "Grandfather bought Toto, a pretty red monkey, from a tonga-driver for five rupees.", "पशु प्रेमी दादाजी ने ताँगे वाले के पास बँधे टोटो को पाँच रुपये में खरीद लिया। उसकी चमकती आँखें और तीसरी हाथ जैसी पूँछ देखते ही बनती थी।", "पालतू जानवर देखने में प्यारे पर संभालने में चुनौतीपूर्ण हो सकते हैं।"),
                p(2, "शरारतों का सिलसिला और सहारनपुर यात्रा", "Toto tore wallpaper, ripped blazers, and poked his head out of Grandfather's canvas kit-bag at Dehradun.", "दादी के गुस्से से बचाने के लिए टोटो को अलमारी और फिर नौकरों के कमरे में रखा गया। सहारनपुर यात्रा के दौरान टिकट कलेक्टर ने उसे 'कुत्ता' मानकर तीन रुपये किराया भी वसूला!", "नटखट टोटो हर जगह कोई न कोई नया हंगामा खड़ा करता था।"),
                p(3, "गरम पानी व पुलाव कांड और वापसी", "Toto almost boiled himself in a kettle and threw Grandma's pullao dish down from a jackfruit tree.", "एक दिन टोटो चाय की केतली में बैठ गया और फिर पुलाव की थाली लेकर कटहल के पेड़ पर चढ़ गया। इतने नुकसान देख दादाजी ने उसे तीन रुपये में वापस ताँगे वाले को बेच दिया।", "हर जीव अपने प्राकृतिक माहौल में ही सबसे बेहतर रहता है।")
            ),
            characters = listOf(
                c("Toto", "टोटो (बंदर)", "कहानी का अत्यंत शरारती नन्हा बंदर", listOf("नटखट", "चतुर", "विनाशकारी शरारती"), "टोटो की आँखों में शरारत चमकती थी; वह न केवल कपड़े व बर्तन तोड़ता था, बल्कि गरम पानी से नहाने जैसी हरकतें भी करता था।", "Toto is a mischievous yet clever red monkey whose costly pranks make him impossible to keep as a pet."),
                c("Grandfather", "दादाजी", "दयालु पशु-प्रेमी बुजुर्ग", listOf("पशु प्रेमी", "धैर्यवान", "हँसमुख"), "दादाजी ने अपने घर में छोटा चिड़ियाघर बना रखा था और वे टोटो की हरकत को भी पहले बुद्धिमत्ता मानकर मुस्कुराते थे।", "Grandfather is an affectionate animal lover who eventually realizes Toto cannot remain a household pet.")
            ),
            scenes = listOf(
                s(1, "दादाजी का नया मेहमान टोटो", "Buying Toto", "दादाजी पाँच रुपये में नटखट लाल बंदर टोटो को घर ले आए हैं!", "Grandfather", "Toto", CartoonSetting.HOME_GARDEN, CartoonMood.HAPPY, "Pet Arrival"),
                s(2, "स्टेशन पर टिकट का हंगामा", "Dog Fare Mystery", "अरे! कैनवास बैग से टोटो का सिर बाहर निकला और टिकट कलेक्टर ने उसे कुत्ता बताकर 3 रुपये लिए!", "Grandfather", "Ticket Collector", CartoonSetting.CITY_MARKET, CartoonMood.DRAMATIC, "Railway Comedy"),
                s(3, "कटहल के पेड़ पर पुलाव पार्टी", "Pullao on Tree", "देखो! टोटो दादी का सारा पुलाव खाकर खाली प्लेट ऊपर से फेंक रहा है!", "Toto", "Grandmother", CartoonSetting.HOME_GARDEN, CartoonMood.HAPPY, "Tree Mischief"),
                s(4, "टोटो की विदाई", "Sold Back for 3 Rupees", "इमरान सर हँसते हैं—नुकसान बहुत बढ़ गया, इसलिए दादाजी ने टोटो को 3 रुपये में वापस दे दिया!", "Grandfather", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.THOUGHTFUL, "Story Ending")
            ),
            words = listOf(
                w("Mischievous", "adj", "Playfully causing trouble", "शरारती / नटखट", "Toto had a mischievous sparkle in his eyes."),
                w("Wrench", "verb", "Pull violently with a twist", "झटके से उखाड़ना", "He tried to wrench the peg out of the wall."),
                w("Abode", "noun", "A house or home", "निवास स्थान", "The stable became Toto's temporary abode."),
                w("Prodded", "verb", "Poked with a finger", "उंगली से छुआ / टटोला", "Toto cunningly prodded the warm water with his hand.")
            ),
            facts = listOf(
                f("For how much did Grandfather sell Toto back to the tonga-driver?", "Three rupees", listOf("Five rupees", "Ten rupees", "Two rupees"), "दादाजी ने टोटो को पाँच रुपये में खरीदा था और बाद में तीन रुपये में वापस बेच दिया।")
            )
        ),

        spec(
            id = "c9_mo_5",
            teachingHi = "ऑस्कर वाइल्ड की यह करुणामयी कहानी 'सुखी राजकुमार' की सोने की मूर्ति और एक छोटी अबाबील (Swallow) चिड़िया की मित्रता पर आधारित है। ऊँचे स्तंभ पर खड़ा राजकुमार अपने शहर के गरीबों का दुःख देखकर रोता है और अबाबील के जरिए अपना सारा सोना, नीलम और माणिक गरीबों में बँटवा देता है। ईश्वर दोनों को स्वर्ग की सबसे अनमोल वस्तुएँ मानते हैं!",
            paragraphs = listOf(
                p(1, "सुखी राजकुमार के आँसू", "High above the city, the gilded Happy Prince wept upon seeing poverty and misery.", "शहर के बीच खड़ी सोने से मढ़ी राजकुमार की मूर्ति पहले महल में दुःख से अनजान थी, पर अब शहर के भूखे बच्चों और गरीबों को देख वह रोती है।", "सच्ची खुशी दूसरों के दर्द को समझने में है।"),
                p(2, "अबाबील की मदद और त्याग", "The little swallow stayed back instead of flying to Egypt and carried gems to the needy.", "मिस्र जा रही नन्ही अबाबील राजकुमार की दूत बनती है और गरीब दर्ज़ी, भूखे लेखक व माचिस बेचने वाली बच्ची तक राजकुमार के हीरे-मोती और सोना पहुँचाती है।", "दूसरों की सेवा में किया गया त्याग जीवन को सार्थक बनाता है।"),
                p(3, "सीसे का टूटा दिल और ईश्वर का सम्मान", "When the swallow died of frost and the Prince's lead heart broke, God chose both for Paradise.", "कड़ाके की ठंड में अबाबील राजकुमार के पैरों में प्राण त्याग देती है और राजकुमार का सीसे का दिल टूट जाता है। ईश्वर के दूत दोनों को स्वर्ग की सबसे कीमती चीज़ चुनते हैं।", "करुणा और प्रेम पर आधारित सेवा अमर हो जाती है।")
            ),
            characters = listOf(
                c("The Happy Prince", "सुखी राजकुमार", "करुणा से भरी सोने की मूर्ति", listOf("दयालु", "त्यागी", "परोपकारी"), "राजकुमार गरीबों की मदद के लिए अपनी आँखों के नीलम और शरीर का सारा सोना दान कर देता है।", "The Happy Prince sacrifices all his gold and jewels to relieve the suffering of the poor."),
                c("The Little Swallow", "नन्ही अबाबील चिड़िया", "राजकुमार की निष्ठावान दूत", listOf("निस्वार्थ", "सच्ची मित्र", "साहसी"), "ठंड से मरने का खतरा जानकर भी वह नेत्रहीन राजकुमार का साथ नहीं छोड़ती।", "The Swallow gives up warmth and life to serve the blind Happy Prince.")
            ),
            scenes = listOf(
                s(1, "मूर्ति पर गिरी आँसू की बूँद", "Prince's Tears", "सोने की मूर्ति के पैरों में बैठी नन्ही चिड़िया पर राजकुमार के गर्म आँसू गिर रहे हैं!", "Happy Prince", "Swallow", CartoonSetting.ROYAL_PALACE, CartoonMood.THOUGHTFUL, "Sad City View"),
                s(2, "गरीबों तक मदद की उड़ान", "Messenger of Kindness", "अबाबील राजकुमार की तलवार का माणिक और आँखों के नीलम लेकर गरीब घरों में पहुँचा रही है!", "Swallow", "Seamstress", CartoonSetting.CITY_MARKET, CartoonMood.INSPIRING, "Helping Poor"),
                s(3, "ठंड में सच्ची दोस्ती", "Final Goodbye", "राजकुमार अंधा हो गया है, इसलिए नन्ही चिड़िया कड़ाके की सर्दी में भी उसके पास रुक जाती है!", "Swallow", "Happy Prince", CartoonSetting.ROYAL_PALACE, CartoonMood.DRAMATIC, "Deep Sacrifice"),
                s(4, "स्वर्ग में अमर सम्मान", "God's Most Precious Things", "ईश्वर के दूत ने टूटे सीसे के दिल और मरी हुई चिड़िया को स्वर्ग के लिए सबसे अनमोल चुना!", "Angel", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Eternal Reward")
            ),
            words = listOf(
                w("Gilded", "adj", "Covered thinly with gold", "सोने से मढ़ी हुई", "The statue of the Happy Prince was gilded with gold leaf."),
                w("Sapphire", "noun", "A precious blue gemstone", "नीलम रत्न", "His eyes were two bright blue sapphires."),
                w("Seamstress", "noun", "A woman who earns by sewing", "सिलाई करने वाली महिला", "Her hands were coarse and red."),
                w("Furnace", "noun", "An enclosed chamber for melting metal", "भट्ठी", "The broken lead heart did not melt in the furnace.")
            ),
            facts = listOf(
                f("Where were the other swallows flying to escape winter?", "Egypt", listOf("India", "France", "England"), "दूसरी अबाबील चिड़ियाँ सर्दी से बचने के लिए मिस्र (Egypt) जा रही थीं।")
            )
        ),

        spec(
            id = "c9_mo_7",
            teachingHi = "ओ. हेनरी की यह विश्व प्रसिद्ध कहानी आशा, सच्ची मित्रता और महान त्याग को दर्शाती है। बीमार जॉन्सी मान बैठती है कि खिड़की के बाहर की बेल का आखिरी पत्ता गिरते ही उसकी मृत्यु हो जाएगी। पर पड़ोसी बूढ़ा कलाकार बहरमैन तूफानी बारिश की रात में दीवार पर एक असली जैसा पत्ता पेंट कर देता है, जिससे जॉन्सी में जीने की इच्छा लौट आती है और बहरमैन की उत्कृष्ट कला अमर हो जाती है!",
            paragraphs = listOf(
                p(1, "जॉन्सी की निराशा और पत्तों की गिनती", "Johnsy suffered from pneumonia and linked her survival to the falling leaves of an ivy creeper.", "निमोनिया से पीड़ित जॉन्सी ने उम्मीद छोड़ दी और सोचा कि बेल का अंतिम पत्ता गिरते ही वह मर जाएगी। उसकी सहेली सू उसे हिम्मत देने की पूरी कोशिश करती है।", "नकारात्मक सोच दवा से भी अधिक नुकसान पहुँचाती है।"),
                p(2, "बहरमैन का गुप्त और महान बलिदान", "Through a stormy night, old Behrman painted a realistic green leaf on the wall.", "रातभर तेज़ बारिश और ठंडी हवा में भीगकर साठ वर्षीय चित्रकार बहरमैन ने दीवार पर बेल का एक पत्ता पेंट किया, ताकि सुबह वह पत्ता न गिरे।", "सच्चा कलाकार दूसरों के जीवन को बचाने के लिए खुद को न्योछावर कर देता है।"),
                p(3, "जीने की नई उम्मीद और 'द लास्ट लीफ' मास्टरपीस", "Seeing the leaf still clinging after the storm, Johnsy recovered, while Behrman died of pneumonia.", "तूफान के बाद भी पत्ता टिका देख जॉन्सी का हौसला लौट आया और वह ठीक हो गई, पर निमोनिया से बहरमैन का निधन हो गया। वही पत्ता उनकी जीवन की सर्वश्रेष्ठ कृति था।", "आशा और निस्वार्थ प्रेम जीवन की सबसे बड़ी शक्ति हैं।")
            ),
            characters = listOf(
                c("Behrman", "बहरमैन (60 वर्षीय चित्रकार)", "निस्वार्थ महान कलाकार", listOf("त्यागी", "स्नेही", "उत्कृष्ट कलाकार"), "सालों से मास्टरपीस बनाने का सपना देखने वाले बहरमैन ने जॉन्सी की जान बचाने के लिए अपनी जान देकर सर्वश्रेष्ठ पेंटिंग बनाई।", "Old Behrman sacrifices his own life in the storm to paint the life-saving masterpiece leaf."),
                c("Johnsy", "जॉन्सी", "युवा चित्रकार सहेली", listOf("निराश पहले", "आशावादी बाद में", "संवेदनशील"), "जॉन्सी पत्तों के साथ जीवन की उम्मीद खो बैठी थी, लेकिन अंतिम पत्ते ने उसमें जीने का नया विश्वास जगाया।", "Johnsy recovers from severe pneumonia once hope is restored by the painted leaf.")
            ),
            scenes = listOf(
                s(1, "खिड़की पर गिरते पत्ते", "Counting Ivy Leaves", "बीमार जॉन्सी खिड़की से बेल के गिरते पत्ते गिनकर उम्मीद खो रही है और सू परेशान है!", "Johnsy", "Sue", CartoonSetting.HOME_GARDEN, CartoonMood.THOUGHTFUL, "Losing Hope"),
                s(2, "तूफानी रात में बहरमैन", "Painting in the Storm", "बरसते पानी और कड़ाके की ठंड में बूढ़े बहरमैन ने लालटेन की रोशनी में दीवार पर एक पत्ता पेंट किया!", "Behrman", "Storm", CartoonSetting.MOUNTAIN_LAB, CartoonMood.DRAMATIC, "Stormy Sacrifice"),
                s(3, "आशा की सुबह", "The Leaf Still Clings", "सुबह जॉन्सी ने देखा—अंतिम पत्ता अभी भी हरा है! उसमें जीने का नया साहस आ गया!", "Johnsy", "Sue", CartoonSetting.HOME_GARDEN, CartoonMood.HAPPY, "Renewed Hope"),
                s(4, "अमर मास्टरपीस", "Behrman's Masterpiece", "इमरान सर बताते हैं—वह पत्ता बहरमैन की असली मास्टरपीस थी, क्योंकि उसने एक जीवन बचाया!", "Sue", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "True Masterpiece")
            ),
            words = listOf(
                w("Pneumonia", "noun", "A serious lung infection", "निमोनिया रोग", "Johnsy was struck down by pneumonia in November."),
                w("Creeper", "noun", "A climbing plant", "बेल / लता", "An old ivy creeper climbed half-way up the brick wall."),
                w("Masterpiece", "noun", "A work of outstanding artistry", "सर्वश्रेष्ठ कलाकृति", "Behrman dreamed of painting a masterpiece."),
                w("Janitor", "noun", "A building caretaker", "चौकीदार / रखवाला", "The janitor found Behrman's wet clothes and brushes.")
            ),
            facts = listOf(
                f("What was old Behrman's lifelong dream?", "To paint a masterpiece", listOf("To travel to Italy", "To open a museum", "To buy a mansion"), "बहरमैन का जीवनभर का सपना एक 'मास्टरपीस' (सर्वश्रेष्ठ कलाकृति) बनाना था।")
            )
        )
    ).associateBy { it.chapterId } + Class9MissingChapters.specs + Class9PoemsCurriculum.specs

    private fun spec(
        id: String,
        teachingHi: String,
        paragraphs: List<ParagraphExplanation>,
        characters: List<CharacterSketch>,
        scenes: List<CartoonScene>,
        words: List<WordMeaning>,
        facts: List<ChapterFactItem>,
        qa: List<ChapterQaSpec> = emptyList(),
        fbs: List<Pair<String, String>> = emptyList(),
        tfs: List<Pair<String, Boolean>> = emptyList()
    ) = ChapterRichSpec(
        chapterId = id,
        detailedHindiTeaching = teachingHi,
        paragraphs = paragraphs,
        characters = characters,
        cartoonScenes = scenes,
        extraWords = words,
        extraFacts = facts,
        extraQa = qa,
        extraFillBlanks = fbs,
        extraTrueFalse = tfs
    )

    private fun p(n: Int, h: String, ex: String, hi: String, key: String) =
        ParagraphExplanation(n, h, ex, hi, key)

    private fun c(name: String, nameHi: String, role: String, traits: List<String>, hi: String, en: String) =
        CharacterSketch(name, nameHi, role, traits, hi, en)

    private fun s(n: Int, title: String, sub: String, nar: String, c1: String, c2: String, set: CartoonSetting, mood: CartoonMood, act: String) =
        CartoonScene(n, title, sub, nar, c1, c2, set, mood, act)

    private fun w(word: String, pos: String, en: String, hi: String, ex: String) =
        WordMeaning(word, pos, en, hi, ex)

    private fun f(q: String, ans: String, dist: List<String>, hi: String) =
        ChapterFactItem(q, ans, dist, hi)

    private fun qa(t: QuestionType, pEn: String, pHi: String, aEn: String, aHi: String, pyq: Boolean = false) =
        ChapterQaSpec(t, pEn, pHi, aEn, aHi, pyq)
}
