package com.example.data.curriculum

import com.example.data.model.CartoonMood
import com.example.data.model.CartoonScene
import com.example.data.model.CartoonSetting
import com.example.data.model.CharacterSketch
import com.example.data.model.ParagraphExplanation
import com.example.data.model.WordMeaning

object Class11Enrichment {

    val specs: Map<String, ChapterRichSpec> = listOf(
        spec(
            id = "c11_hb_1",
            teachingHi = "खुशवंत सिंह का यह संस्मरण अपनी दादी के प्रति गहरे प्रेम और पीढ़ियों के बदलते रिश्ते को दर्शाता है। पहले गाँव में दादी उन्हें नहलाकर स्कूल छोड़ने जाती थीं, पर शहर जाने और विश्वविद्यालय में पढ़ाई के बाद उनके बीच संवाद कम हुआ। फिर भी दादी का गौरैयों को दाना डालना और माला जपना शांत आध्यात्मिक जीवन दिखाता है। उनकी मृत्यु के दिन हजारों गौरैयाँ बिना चहचहाए और बिना रोटी खाए मौन श्रद्धांजलि देती हैं!",
            paragraphs = listOf(
                p(1, "गाँव का स्नेहपूर्ण बचपन और दादी का रूप", "Grandmother was short, fat, and slightly bent, always telling beads of her rosary.", "लेखक बताते हैं कि उनकी दादी बीस साल से एक जैसी ही दिखती थीं—सफेद साड़ी, झुकी कमर और होठों पर शांत प्रार्थना। गाँव में वे उन्हें स्कूल छोड़ती थीं और लौटते समय बासी रोटियाँ गाँव के कुत्तों को डालती थीं।", "पुराने संस्कार और सादगी मन को शांत रखते हैं।"),
                p(2, "शहर आने पर दूरी और गौरैयों से मित्रता", "In the city, the author went to an English school in a motor bus; Grandmother spent afternoons feeding sparrows.", "शहर में अंग्रेज़ी स्कूल, विज्ञान और संगीत की पढ़ाई देख दादी दुःखी हुईं क्योंकि वहाँ ईश्वर और धर्मग्रंथ नहीं पढ़ाए जाते थे। दोपहर में सैकड़ों गौरैयों को रोटी के टुकड़े खिलाना उनका सबसे खुशहाल समय बन गया।", "प्रकृति और पक्षियों से जुड़ाव अकेलेपन को भी सुखद बना देता है।"),
                p(3, "अंतिम विदाई और गौरैयों की मौन श्रद्धांजलि", "After celebrating his return from abroad, Grandmother passed away peacefully; thousands of sparrows sat silently around her.", "पाँच वर्ष बाद लेखक के विदेश से लौटने पर दादी ने ढोलक बजाकर गीत गाए। अगली शाम शांत प्रार्थना में उनके हाथ से माला गिर गई। आँगन में हजारों गौरैयाँ चुपचाप बैठी रहीं और बिना ब्रेड के टुकड़े छुए उड़ गईं!", "मूक पक्षी भी निस्वार्थ प्रेम और पवित्र आत्मा को पहचानते हैं।")
            ),
            characters = listOf(
                c("The Grandmother", "दादीजी", "धार्मिक, स्नेही एवं शांत स्वभाव की बुजुर्ग", listOf("धार्मिक", "पशु-पक्षी प्रेमी", "स्वाभिमानी व शांत"), "दादीजी आधुनिक अंग्रेज़ी शिक्षा से असहमत थीं पर पोते की खुशी में शांत रहीं। उनका माला जपना और गौरैयों को दाना डालना उनकी करुणा दर्शाता है।", "Grandmother is a dignified, deeply spiritual woman whose quiet affection extends from her grandson to stray dogs and sparrows.")
            ),
            scenes = listOf(
                s(1, "गाँव के स्कूल का साथ", "Village Morning Walk", "सुबह की धुंध में दादी अपने पोते खुशवंत की स्लेट थामे गाँव के मंदिर-स्कूल ले जा रही हैं!", "Grandmother", "Khushwant", CartoonSetting.HOME_GARDEN, CartoonMood.HAPPY, "Village Walk"),
                s(2, "शहर में बदलाव और दूरी", "University Separation", "अंग्रेज़ी स्कूल की बस आने और अलग कमरा मिलने से दादी अब शांत बैठकर चरखा कातती हैं।", "Grandmother", "Spinning Wheel", CartoonSetting.HOME_GARDEN, CartoonMood.THOUGHTFUL, "Quiet Change"),
                s(3, "आँगन में सैकड़ों गौरैयाँ", "Feeding the Sparrows", "वाह! दोपहर में सैकड़ों प्यारी गौरैयाँ दादी के कंधे और सिर पर बैठकर दाने खा रही हैं!", "Grandmother", "Sparrows", CartoonSetting.HOME_GARDEN, CartoonMood.HAPPY, "Sparrow Joy"),
                s(4, "गौरैयों की मौन श्रद्धांजलि", "Silent Farewell", "दादी के जाने पर हजारों गौरैयाँ बिल्कुल शांत बैठी रहीं—सच्चा प्रेम शब्दों का मोहताज नहीं होता!", "Sparrows", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Silent Tribute")
            ),
            words = listOf(
                w("Mantelpiece", "noun", "A shelf above a fireplace", "अंगीठी के ऊपर की ताक", "Grandfather's portrait hung above the mantelpiece."),
                w("Monotonous", "adj", "Dull and unchanging", "एकरस / नीरस", "She sang her morning prayers in a monotonous sing-song."),
                w("Veritable", "adj", "Real / true (for emphasis)", "वास्तविक / सचमुच का", "A veritable bedlam of chirrupings filled the verandah."),
                w("Frivolous", "adj", "Silly / not serious", "हल्का-फुल्का / तुच्छ", "She fed the sparrows with frivolous rebukes."),
                w("Shroud", "noun", "Cloth used to wrap a dead body", "कफ़न", "They covered her with a red shroud.")
            ),
            facts = listOf(
                f("What did Grandmother feed the sparrows in the city courtyard?", "Little bits of bread", listOf("Rice grains", "Wheat flour", "Sweet biscuits"), "शहर के आँगन में दादीजी गौरैयों को रोटी (bread) के छोटे-छोटे टुकड़े खिलाती थीं।")
            )
        ),

        spec(
            id = "c11_hb_2",
            teachingHi = "यह रोमांचक सच्ची कहानी दर्शाती है कि एकता, साहस और आशावाद किसी भी तूफान को हरा सकते हैं। लेखक अपनी पत्नी मैरी और दोनों बच्चों जोनाथन व सुज़ैन के साथ 'वेववॉकर' नाव से दुनिया का चक्कर लगाने निकलते हैं। हिंद महासागर की विशाल लहर नाव को लगभग डुबो देती है, पर परिवार के हर सदस्य की हिम्मत—विशेषकर 6 वर्षीय बेटे के शब्द 'हमें मरने से डर नहीं लगता अगर हम सब साथ हैं'—उन्हें बचा लेती है!",
            paragraphs = listOf(
                p(1, "वेववॉकर से विश्व यात्रा का सपना", "In July 1976, the narrator, Mary, Jonathan (6), and Suzanne (7) sailed from Plymouth on Wavewalker.", "कैप्टन कुक की 200 वर्ष पुरानी यात्रा दोहराने के लिए 37 वर्षीय व्यापारी परिवार सहित 23 मीटर लंबी 'वेववॉकर' नाव लेकर निकले और केप टाउन से दो नाविक लैरी व हर्ब को साथ लिया।", "बड़े सपनों के लिए तैयारी और टीमवर्क ज़रूरी है।"),
                p(2, "2 जनवरी 1977 की भीषण लहर और तबाही", "On 2 January, a gigantic wave slammed the deck, injuring the narrator and flooding the ship.", "दक्षिणी हिंद महासागर में विशाल लहर ने नाव को पलटने की कगार पर पहुँचा दिया। कप्तान की पसलियाँ टूट गईं, पानी भर गया, पर लैरी व हर्ब पंप चलाते रहे और मैरी ने स्टीयरिंग संभाला।", "विपदा में हार मानने के बजाय तुरंत काम में जुट जाना जीवन बचाता है।"),
                p(3, "बच्चों का साहस और आइल एम्स्टर्डम पर विजय", "Six-year-old Jon said they weren't afraid to die if together; they reached Ile Amsterdam on 6 January.", "छह साल के जॉन ने कहा—पापा, अगर हम सब साथ हैं तो हमें मरने से डर नहीं लगता! इन शब्दों से प्रेरित होकर पिता ने सटीक गणना से छोटा द्वीप 'आइल एम्स्टर्डम' खोज निकाला और सभी बच गए!", "परिवार का प्रेम और बच्चों का हौसला असंभव को संभव कर देता है।")
            ),
            characters = listOf(
                c("The Narrator (Captain)", "कथावाचक (कप्तान पिता)", "साहसी नाविक और जिम्मेदार पिता", listOf("संकट में शांत", "प्रयासशील", "कुशल नाविक"), "टूटी पसलियों और भयंकर चोट के बावजूद वे नाव की मरम्मत करते हैं और सटीक नेविगेशन से सबको सुरक्षित द्वीप तक पहुँचाते हैं।", "The narrator displays extraordinary grit, leadership, and resourcefulness under life-threatening crisis."),
                c("Jonathan & Suzanne", "जोनाथन (6) व सुज़ैन (7)", "अद्भुत साहसी बच्चे", listOf("निडर", "परिवार-प्रेमी", "धैर्यवान"), "सिर पर गंभीर चोट होने पर भी सुज़ैन पिता को परेशान नहीं करती और जॉन अपने निडर शब्दों से पिता को नई ताकत देता है।", "Young Jonathan and Suzanne inspire the adults with extraordinary bravery and composure.")
            ),
            scenes = listOf(
                s(1, "प्लाइमाउथ से 'वेववॉकर' की शुरुआत", "Setting Sail", "सपनों की नाव 'वेववॉकर' पर पूरा परिवार समुद्र की लहरों पर विश्व यात्रा के लिए निकल पड़ा है!", "Narrator", "Family", CartoonSetting.OCEAN_SHIP, CartoonMood.HAPPY, "Voyage Start"),
                s(2, "2 जनवरी का महातूफान", "Gigantic Wave Strike", "संभलो! 15 मीटर ऊँची काली लहर ने नाव को हिला दिया—नाव में तेज़ी से पानी भर रहा है!", "Narrator", "Wavewalker", CartoonSetting.OCEAN_SHIP, CartoonMood.DRAMATIC, "Storm Hit"),
                s(3, "बच्चों का अमूल्य साहस", "Not Afraid to Die", "नन्हा जॉन बोला—पापा, जब हम सब साथ हैं तो डर कैसा? और सुज़ैन ने अपने दर्द को छिपाए रखा!", "Jonathan", "Suzanne", CartoonSetting.OCEAN_SHIP, CartoonMood.THOUGHTFUL, "Brave Kids"),
                s(4, "आइल एम्स्टर्डम की सुहानी सुबह", "Island Rescue", "चमत्कार! 6 जनवरी को सामने आइल एम्स्टर्डम दिखाई दे गया—एकता और हिम्मत की जीत हुई!", "Narrator", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Safe Island")
            ),
            words = listOf(
                w("Honing", "verb", "Sharpening or perfecting a skill", "निखारना / तेज़ करना", "They spent sixteen years honing seafaring skills."),
                w("Gales", "noun", "Very strong sea winds", "तेज़ समुद्री आँधी", "Atrocious gales struck the boat after Cape Town."),
                w("Pinpricks", "noun", "Tiny specks on a huge surface", "सुई की नोक जैसे छोटे बिंदु", "They searched for two tiny pinpricks in the vast ocean."),
                w("Respite", "noun", "A short period of rest or relief", "थोड़ी राहत / विराम", "They got a brief respite on 4 January.")
            ),
            facts = listOf(
                f("Name the two crewmen who joined in Cape Town to tackle the southern Indian Ocean.", "Larry Vigil and Herb Seigler", listOf("John and Peter", "George and Martin", "Tom and Mark"), "केप टाउन से लैरी विजिल (अमेरिकी) और हर्ब सिग्लर (स्विस) नाव में शामिल हुए थे।")
            )
        ),

        spec(
            id = "c11_hb_3",
            teachingHi = "यह पाठ मिस्र के युवा सम्राट तूतंखामुन (King Tut) की रहस्यमय मृत्यु और उनकी ममी की आधुनिक वैज्ञानिक जाँच के बारे में है। 1922 में हावर्ड कार्टर ने उनकी सोने से भरी कब्र खोजी थी। 2005 में आधुनिक सीटी स्कैन मशीन से उनके शरीर के 1700 डिजिटल एक्स-रे लेकर रहस्य सुलझाया गया—यह विज्ञान और पुरातत्व का अद्भुत संगम है!",
            paragraphs = listOf(
                p(1, "किंग टुट की ममी का सीटी स्कैन", "On 5 January 2005, King Tut's 3,300-year-old mummy underwent a CT scan in the Valley of the Kings.", "तीन हजार तीन सौ साल पुराने किशोर सम्राट टुट की ममी को कब्र से निकालकर पोर्टेबल सीटी स्कैनर में रखा गया, ताकि मृत्यु के रहस्य की जाँच हो सके।", "आधुनिक विज्ञान अतीत के रहस्यों को खोल सकता है।"),
                p(2, "1922 में हावर्ड कार्टर की खोज", "British archaeologist Howard Carter discovered Tut's intact tomb in 1922 with dazzling gold treasures.", "हावर्ड कार्टर को राल (Resin) से चिपकी ममी को निकालने में कठिनाई हुई, क्योंकि प्राचीन पुजारियों की राल सीमेंट जैसी सख्त हो गई थी और कार्टर को उसे छेनी से अलग करना पड़ा।", "पुरातत्व का उद्देश्य आज खजाने के बजाय जीवन-मृत्यु के सच को समझना है।"),
                p(3, "रेतीली हवा और प्राचीन अभिशाप का मिथक", "After completing the scan despite a brief sandstorm and fan glitch, the young king rested peacefully again.", "स्कैन के समय अचानक मशीन का पंखा खराब हुआ और कुछ लोग 'फराओ के शाप' से डरने लगे, पर बैकअप से काम पूरा हुआ और आकाश में ओरियन नक्षत्र चमक रहा था।", "वैज्ञानिक तथ्य अंधविश्वास से ऊपर होते हैं।")
            ),
            characters = listOf(
                c("King Tut (Tutankhamun)", "सम्राट तूतंखामुन", "मिस्र के अंतिम किशोर सम्राट", listOf("युवा शासक", "प्राचीन धरोहर", "ऐतिहासिक रहस्य"), "लगभग 19 वर्ष की अल्पायु में रहस्यमयी मृत्यु के बाद वे विश्व के सबसे प्रसिद्ध प्राचीन सम्राट बने।", "King Tut was the teenaged final heir of a powerful Egyptian dynasty whose mummy fascinated the modern world."),
                c("Howard Carter", "हावर्ड कार्टर", "1922 के ब्रिटिश पुरातत्ववेत्ता", listOf("खोजी", "दृढ़ निश्चयी", "साहसी"), "वर्षों की असफल खोज के बाद कार्टर ने ही 1922 में तूत की अछूती कब्र और सोने का खजाना खोजा।", "Howard Carter discovered King Tut's intact tomb in 1922, opening a golden chapter in archaeology.")
            ),
            scenes = listOf(
                s(1, "1922: सोने के ताबूत की खोज", "Howard Carter's Find", "राजाओं की घाटी में रेत के नीचे हावर्ड कार्टर को सम्राट टुट का चमकता सोने का खजाना मिला!", "Howard Carter", "King Tut", CartoonSetting.ROYAL_PALACE, CartoonMood.MYSTERY, "1922 Discovery"),
                s(2, "सख्त राल की चुनौती", "Resin Challenge", "अरे! ममी सोने के ताबूत में राल से जमकर पत्थर बन गई है—कार्टर ने बड़ी मुश्किल से बाहर निकाला।", "Howard Carter", "Workers", CartoonSetting.MOUNTAIN_LAB, CartoonMood.DRAMATIC, "Excavation"),
                s(3, "2005: सीटी स्कैन की जांच", "Modern CT Scan", "आधुनिक सीटी स्कैन मशीन से 1700 एक्स-रे लेकर डॉक्टर ज़ाही हवास मृत्यु की गुत्थी सुलझा रहे हैं!", "Zahi Hawass", "CT Machine", CartoonSetting.MOUNTAIN_LAB, CartoonMood.THOUGHTFUL, "Science Check"),
                s(4, "सितारों के नीचे शांति", "Peace Returns", "जाँच सफल रही! सम्राट टुट को वापस उनकी कब्र में शांति से रख दिया गया—विज्ञान और इतिहास की जीत!", "Zahi Hawass", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Archaeology Evolution")
            ),
            words = listOf(
                w("Scudded", "verb", "Moved quickly across the sky", "तेज़ी से तैरकर गुज़रना", "Dark-bellied clouds scudded across the desert sky."),
                w("Circumvented", "verb", "Found a clever way around an obstacle", "बचकर निकलना / रास्ता निकालना", "Guards circumvented tomb robbers."),
                w("Resin", "noun", "Sticky substance from trees used in mummification", "राल / गोंद", "Ritual resins had hardened, cementing Tut to his coffin."),
                w("Forensic", "adj", "Scientific method used for investigation", "अपराध/वैज्ञानिक जाँच संबंधी", "Forensic reconstruction revealed details of Tut's death.")
            ),
            facts = listOf(
                f("Who was the Secretary General of Egypt's Supreme Council of Antiquities during the 2005 CT scan?", "Zahi Hawass", listOf("Howard Carter", "Ray Johnson", "Akhenaten"), "2005 में ज़ाही हवास मिस्र की पुरावशेष परिषद के महासचिव थे।")
            )
        ),

        spec(
            id = "c11_sn_1",
            teachingHi = "विलियम सरोयन की यह मनमोहक कहानी दो आर्मेनियाई भाइयों अरम (9) और मुराद (13) की है, जिनका गारोग्लैनियन कबीला अपनी अटूट ईमानदारी के लिए प्रसिद्ध था। एक सुबह मुराद एक सुंदर सफेद घोड़ा लेकर आता है! बच्चे घुड़सवारी के शौक से थोड़े दिन घोड़े को छिपाकर चलाते हैं, पर अपनी अंतरात्मा और किसान जॉन बायरो के विश्वास को देख वे घोड़ा चुपचाप वापस लौटा देते हैं।",
            paragraphs = listOf(
                p(1, "सुबह 4 बजे सफेद घोड़े का जादू", "Nine-year-old Aram woke up to see his cousin Mourad sitting on a magnificent white horse.", "अरम को अपनी आँखों पर भरोसा नहीं हुआ क्योंकि उनका परिवार बहुत गरीब था और पूरा गारोग्लैनियन कबीला ईमानदारी के लिए मशहूर था। फिर भी घोड़े की सवारी का मोह उसे खींच लेता है।", "बच्चों का सपना और ईमानदारी के बीच मीठा संघर्ष।"),
                p(2, "मुराद का पशु-प्रेम और जॉन बायरो की मुलाकात", "The boys hid the horse in a deserted barn; one day owner John Byro met them yet trusted their family honesty.", "किसान जॉन बायरो अपने खोए घोड़े से मिलते हैं। दाँत देखकर भी वे कहते हैं—तुम्हारे कबीले की ईमानदारी मशहूर है, इसलिए मैं इसे मेरे घोड़े का जुड़वाँ मानूँगा!", "किसी परिवार की अच्छी प्रतिष्ठा सबसे बड़ा प्रमाण होती है।"),
                p(3, "ईमानदारी की वापसी और स्वस्थ घोड़ा", "Moved by John Byro's faith, the boys returned the horse quietly to his vineyard the next morning.", "जॉन बायरो के विश्वास से प्रेरित होकर दोनों भाई अगली सुबह चुपचाप घोड़ा वापस बाँध देते हैं। घोड़ा पहले से अधिक स्वस्थ और शांत हो चुका था!", "सच्ची ईमानदारी अंततः सही मार्ग दिखा देती है।")
            ),
            characters = listOf(
                c("Mourad", "मुराद (13 वर्ष)", "क्रेज़ी स्ट्रीक वाला पशु-प्रेमी किशोर", listOf("साहसी", "पशु-प्रेमी", "सच्चे कबीले का वारिस"), "कबीले के लोग मुराद को सनकी मानते हैं, पर उसमें घोड़े व घायल चिड़िया से बात करने की अद्भुत कोमलता है।", "Mourad has a 'way with' animals and horses, blending youthful mischief with deep family honor."),
                c("Aram", "अरम (9 वर्ष)", "कहानी का ईमानदार बाल कथावाचक", listOf("सच्चा", "कल्पनाशील", "चचेरे भाई का प्रशंसक"), "अरम पहले चोरी मानने से हिचकिचाता है, पर घोड़े के प्रति प्रेम और परिवार की मर्यादा दोनों को निभाता है।", "Aram is an honest, thoughtful nine-year-old narrator torn between adventure and family integrity.")
            ),
            scenes = listOf(
                s(1, "सुबह 4 बजे खिड़की पर सफेद घोड़ा", "Morning Surprise", "टप-टप! सुबह चार बजे मुराद चमकते हुए सफेद घोड़े पर बैठकर अरम को बुला रहा है!", "Mourad", "Aram", CartoonSetting.FARM_STORM, CartoonMood.HAPPY, "White Horse"),
                s(2, "अंगूर के बाग में घुड़सवारी", "Wild Ride", "अरम घोड़े से अंगूर की बेलों में गिर गया और मुराद ने अपनी समझ से घोड़े को शांत किया!", "Aram", "Mourad", CartoonSetting.HOME_GARDEN, CartoonMood.HAPPY, "Horse Ride"),
                s(3, "किसान जॉन बायरो का विश्वास", "Power of Trust", "किसान जॉन बायरो ने घोड़े के दाँत देखे, पर कबीले की ईमानदारी जानकर बच्चों पर शक नहीं किया!", "John Byro", "Boys", CartoonSetting.CITY_MARKET, CartoonMood.THOUGHTFUL, "Family Honor"),
                s(4, "चुपचाप घोड़ा वापस!", "Honest Return", "अगली सुबह दोनों ने घोड़ा जॉन बायरो के अस्तबल में लौटा दिया—अंतरात्मा और ईमानदारी की जीत!", "Mourad", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Integrity Moral")
            ),
            words = listOf(
                w("Magnificence", "noun", "Extreme beauty and grandeur", "भव्यता / शानदार सौंदर्य", "The white horse breathed with quiet magnificence."),
                w("Capricious", "adj", "Unpredictable / impulsive", "मनमौजी / चंचल", "Mourad was considered a capricious descendant."),
                w("Vineyard", "noun", "Land where grapes are grown", "अंगूर का बाग", "The horse leaped over seven vines in the vineyard."),
                w("Suspicious", "adj", "Doubtful / questioning", "संदिग्ध / शंका करने वाला", "A suspicious man would believe his eyes instead of his heart.")
            ),
            facts = listOf(
                f("Where did Aram and Mourad hide the white horse every morning?", "In Fetvajian's deserted vineyard barn", listOf("Behind Uncle Khosrove's shop", "In John Byro's carriage", "Near the river bank"), "दोनों लड़के घोड़े को फतवाजियान के सूने अंगूर के बाग वाले खलिहान में छिपाते थे।")
            )
        ),

        spec(
            id = "c11_sn_4",
            teachingHi = "ए.जे. क्रोनिन की यह हृदयस्पर्शी कहानी डॉक्टर एंड्र्यू मैन्सन के समर्पण और जीवन रक्षक जज़्बे को दिखाती है। निजी दुःख से निराश डॉक्टर जब कोयला खदान के गाँव में जो मॉर्गन के घर डिलीवरी कराने पहुँचते हैं, तो माँ और नवजात शिशु दोनों की जान खतरे में होती है। शिशु को मृत समझे जाने के बाद भी डॉक्टर आधे घंटे तक गर्म-ठंडे पानी व कृत्रिम साँस से प्रयास करते रहते हैं—और अचानक नन्हा शिशु रो पड़ता है!",
            paragraphs = listOf(
                p(1, "आधी रात में जो मॉर्गन की प्रतीक्षा", "Despite personal heartache over Christine, young doctor Andrew Manson rushed to Joe Morgan's house at midnight.", "अंधेरी रात में बीस साल बाद पहली संतान की उम्मीद में खड़े जो मॉर्गन ने कहा—डॉक्टर साहब, हम सब आप पर भरोसा करते हैं।", "डॉक्टर का कर्तव्य व्यक्तिगत दुःख से ऊपर होता है।"),
                p(2, "माँ और बेजान शिशु के बीच कठिन निर्णय", "After a harsh birth, the child appeared lifeless and the mother was sinking fast.", "बच्चे को बेजान देखकर दाई ने उसे बिस्तर के नीचे रख दिया। डॉक्टर एंड्र्यू पहले माँ को इंजेक्शन देकर बचाते हैं और फिर तुरंत शिशु की ओर मुड़ते हैं।", "सही प्राथमिकता और शांत दिमाग संकट में राह दिखाता है।"),
                p(3, "30 मिनट का संघर्ष और जीवन का चमत्कार", "Using alternating hot and cold water basins and gentle chest presses, Andrew revived the newborn.", "एंड्र्यू ने हार नहीं मानी! गर्म और ठंडे पानी के दो टब मँगवाकर शिशु को बारी-बारी डुबोया और छाती पर हल्का दबाव दिया। अचानक नन्हे सीने में साँस आ गई!", "जब तक साँस और उम्मीद है, प्रयास कभी नहीं छोड़ना चाहिए।")
            ),
            characters = listOf(
                c("Dr. Andrew Manson", "डॉ. एंड्र्यू मैन्सन", "कर्तव्यनिष्ठ युवा डॉक्टर", listOf("समर्पित", "निडर", "हार न मानने वाला"), "स्वयं की मानसिक थकान के बावजूद डॉ. एंड्र्यू ने आधे घंटे लगातार मेहनत कर माँ और बच्चे दोनों की जान बचाई।", "Dr. Andrew Manson exemplifies selfless medical dedication, perseverance, and quick clinical courage.")
            ),
            scenes = listOf(
                s(1, "आधी रात दरवाजे पर जो मॉर्गन", "Midnight Call", "रात के 12 बजे जो मॉर्गन उम्मीद भरी निगाहों से डॉ. एंड्र्यू को घर बुलाने आए हैं!", "Dr. Andrew", "Joe Morgan", CartoonSetting.CITY_MARKET, CartoonMood.THOUGHTFUL, "Night Emergency"),
                s(2, "दोहरी चुनौती", "Saving Mother First", "माँ की हालत नाज़ुक है और बच्चा हिल नहीं रहा—डॉक्टर एंड्र्यू पहले माँ की जान बचाते हैं!", "Dr. Andrew", "Nurse", CartoonSetting.MOUNTAIN_LAB, CartoonMood.DRAMATIC, "Critical Moment"),
                s(3, "गर्म और ठंडे पानी का चमत्कार", "Tireless Revival", "30 मिनट तक डॉ. एंड्र्यू बारी-बारी गर्म-ठंडे पानी और कृत्रिम साँस से नन्हे शिशु को जगा रहे हैं!", "Dr. Andrew", "Baby", CartoonSetting.MOUNTAIN_LAB, CartoonMood.INSPIRING, "Reviving Life"),
                s(4, "'ओह गॉड! मैंने कुछ सच्चा कर दिखाया!'", "Tears of Joy", "वाँ-वाँ! नन्हे बच्चे की पहली किलकारी गूँजी—इमरान सर कहते हैं, लगन हो तो चमत्कार संभव है!", "Dr. Andrew", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Life Saved")
            ),
            words = listOf(
                w("Premonition", "noun", "A feeling that something bad will happen", "पूर्वाभास", "Andrew felt a strange premonition at the Morgan house."),
                w("Pallid", "adj", "Abnormally pale and weak", "पीला / निस्तेज", "The newborn baby's skin looked white and pallid."),
                w("Asphyxia", "noun", "Condition caused by severe lack of oxygen", "दम घुटना / ऑक्सीजन की कमी", "Andrew recognized the signs of asphyxia pallida."),
                w("Hysterical", "adj", "Overwhelmed with uncontrolled emotion", "उन्मादी / अत्यंत भावुक", "The midwife let out a hysterical cry of joy.")
            ),
            facts = listOf(
                f("After how many years of marriage were Joe and Susan Morgan expecting their first child?", "Nearly twenty years", listOf("Five years", "Ten years", "Two years"), "जो और सुसन मॉर्गन विवाह के लगभग बीस वर्षों बाद पहली संतान की प्रतीक्षा कर रहे थे।")
            )
        )
    ).associateBy { it.chapterId } + Class11MissingChapters.specs + Class11PoemsCurriculum.specs

    private fun spec(
        id: String,
        teachingHi: String,
        paragraphs: List<ParagraphExplanation>,
        characters: List<CharacterSketch>,
        scenes: List<CartoonScene>,
        words: List<WordMeaning>,
        facts: List<ChapterFactItem>
    ) = ChapterRichSpec(
        chapterId = id,
        detailedHindiTeaching = teachingHi,
        paragraphs = paragraphs,
        characters = characters,
        cartoonScenes = scenes,
        extraWords = words,
        extraFacts = facts
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
}
