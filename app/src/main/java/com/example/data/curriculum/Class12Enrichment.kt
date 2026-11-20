package com.example.data.curriculum

import com.example.data.model.CartoonMood
import com.example.data.model.CartoonScene
import com.example.data.model.CartoonSetting
import com.example.data.model.CharacterSketch
import com.example.data.model.ParagraphExplanation
import com.example.data.model.WordMeaning

object Class12Enrichment {

    val specs: Map<String, ChapterRichSpec> = listOf(
        spec(
            id = "c12_fl_1",
            teachingHi = "अल्फोंस डॉडेट की यह प्रसिद्ध कहानी बताती है कि हमें अपनी मातृभाषा और शिक्षा का महत्व कभी टालना नहीं चाहिए। 1870 में प्रशिया से हारने के बाद बर्लिन से आदेश आता है कि एल्सास और लॉरेन के स्कूलों में अब फ्रेंच नहीं, केवल जर्मन पढ़ाई जाएगी। छोटा फ्रांज़ जो पढ़ाई से भागता था, उस अंतिम कक्षा में एम. हेमल की भावुक विदाई देखकर फूट-फूटकर रोता है और 'Vive La France!' के साथ भाषा प्रेम का अमिट पाठ सीखता है।",
            paragraphs = listOf(
                p(1, "स्कूल में असामान्य सन्नाटा और बर्लिन का आदेश", "Little Franz expected a scolding on participles, yet found the classroom solemn as a Sunday morning.", "देरी से स्कूल पहुँचे फ्रांज़ को अचरज हुआ कि न शोर है न डाँट! गाँव के बूढ़े पिछली बेंचों पर बैठे हैं और एम. हेमल ने बताया कि आज यह उनका अंतिम फ्रेंच पाठ है।", "जो चीज़ पास होती है, उसकी कीमत खोने पर ही समझ आती है।"),
                p(2, "टालमटोल का पछतावा और मातृभाषा की रक्षा", "M. Hamel gently reminded villagers that putting off learning had cost them their language.", "एम. हेमल कहते हैं कि बच्चों के साथ-साथ माता-पिता और स्वयं वे भी पढ़ाई टालने के दोषी हैं। वे फ्रेंच को विश्व की सबसे सुंदर व स्पष्ट भाषा बताते हैं—मातृभाषा ही गुलामी की जेल की चाबी है!", "अपनी भाषा और शिक्षा से जुड़ाव कभी कल पर नहीं टालना चाहिए।"),
                p(3, "'विवे ला फ्रांस!' और मौन विदाई", "As twelve struck and Prussian soldiers marched past, M. Hamel wrote 'Vive La France!' on the board.", "बारह बजने पर जब एम. हेमल का गला भर आया, तो उन्होंने पूरी शक्ति से ब्लैकबोर्ड पर बड़े अक्षरों में लिखा—'Vive La France!' (फ्रांस अमर रहे) और हाथ के इशारे से कक्षा समाप्त की।", "सच्चा शिक्षक अंतिम क्षण तक कर्तव्य व देशभक्ति निभाता है।")
            ),
            characters = listOf(
                c("M. Hamel", "एम. हेमल", "40 वर्ष से समर्पित फ्रेंच शिक्षक", listOf("देशभक्त", "कर्तव्यनिष्ठ", "भावुक व आदर्श गुरु"), "चालीस वर्षों की सेवा के बाद स्कूल छोड़ते समय एम. हेमल अत्यंत धैर्य और गौरव के साथ अपना अंतिम पाठ पढ़ाते हैं।", "M. Hamel is a devoted, patriotic French teacher of forty years whose dignity shines during his final lesson."),
                c("Franz", "फ्रांज़", "लापरवाह से संवेदनशील बना विद्यार्थी", listOf("जिज्ञासु", "ईमानदार", "पश्चाताप करने वाला"), "पहले किताबें उसे बोझ लगती थीं, पर अंतिम दिन वही किताबें उसे पुरानी मित्र लगने लगती हैं।", "Young Franz transforms from a reluctant student into an attentive learner deeply moved by losing his language.")
            ),
            scenes = listOf(
                s(1, "रविवार जैसा शांत स्कूल", "Solemn Classroom", "अरे! स्कूल में आज शोर क्यों नहीं है? और पीछे गाँव के बूढ़े बुजुर्ग क्यों बैठे हैं?", "Franz", "M. Hamel", CartoonSetting.CLASSROOM, CartoonMood.MYSTERY, "Quiet School"),
                s(2, "बर्लिन से आया कठोर आदेश", "The Last French Lesson", "एम. हेमल ने भारी मन से बताया—बच्चों, कल से यहाँ सिर्फ जर्मन पढ़ाई जाएगी, यह मेरा आखिरी फ्रेंच पाठ है!", "M. Hamel", "Villagers", CartoonSetting.CLASSROOM, CartoonMood.DRAMATIC, "Berlin Order"),
                s(3, "मातृभाषा जेल की चाबी है", "Value Your Language", "फ्रांज़ को पछतावा हो रहा है कि उसने पढ़ाई क्यों टाली—जब तक भाषा पास है, गुलाम आज़ाद रहता है!", "M. Hamel", "Franz", CartoonSetting.CLASSROOM, CartoonMood.THOUGHTFUL, "Key to Prison"),
                s(4, "'Vive La France!' की गूँज", "Emotional Goodbye", "बारह बजे गला भर आने पर एम. हेमल ने बोर्ड पर लिखा—Vive La France! आज से कभी पढ़ाई कल पर न टालें!", "M. Hamel", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Final Blackboard")
            ),
            words = listOf(
                w("Participles", "noun", "Verb forms acting as adjectives", "कृदंत / व्याकरण के पार्टिसिपल", "Franz had not prepared his lesson on participles."),
                w("Commotion", "noun", "Noisy confusion and bustle", "हंगामा / शोरगुल", "Usually there was a great commotion when school began."),
                w("Reproach", "verb", "Express disapproval or blame", "दोष देना / धिक्कारना", "We have all a great deal to reproach ourselves with."),
                w("Cranky", "adj", "Irritable / easily annoyed", "चिड़चिड़ा", "Franz forgot how cranky M. Hamel sometimes was.")
            ),
            facts = listOf(
                f("For how many years had M. Hamel taught faithfully in that school?", "Forty years", listOf("Twenty years", "Ten years", "Fifty years"), "एम. हेमल ने उसी स्कूल में चालीस वर्षों तक ईमानदारी से अध्यापन किया था।")
            )
        ),

        spec(
            id = "c12_fl_2",
            teachingHi = "अनीस जंग की यह मार्मिक रिपोर्ट बताती है कि गरीबी और परंपरा के नाम पर लाखों बच्चों का बचपन खो रहा है। भाग 1 में सीमापुरी का कचरा बीनने वाला साहेब कचरे में 'सोना' यानी रोटी ढूँढता है, पर चाय की दुकान पर नौकरी करते ही अपनी आज़ादी खो देता है। भाग 2 में फिरोज़ाबाद का मुकेश चूड़ी बनाने की खतरनाक परंपरा तोड़कर 'मोटर मैकेनिक' बनने का साहसिक सपना देखता है!",
            paragraphs = listOf(
                p(1, "सीमापुरी के बच्चे और साहेब-ए-आलम", "Saheb-e-Alam, whose name means 'Lord of the Universe', scrounged in Seemapuri garbage dumps.", "दिल्ली के बाहरी इलाके सीमापुरी में ढाका से आए दस हजार परिवार रहते हैं। उनके लिए कचरा ही पेट भरने का 'सोना' है, जबकि नंगे पाँव रहना उनकी मजबूरी है।", "गरीबी बच्चों से स्कूल और जूते दोनों छीन लेती है।"),
                p(2, "चाय के स्टील के कनस्तर का बोझ", "Taking a job at a tea stall for 800 rupees, Saheb lost his carefree look because the steel canister was heavier than his plastic bag.", "चाय की दुकान पर 800 रुपये तो मिलते हैं, पर प्लास्टिक का थैला उसका अपना था और स्टील का कनस्तर मालिक का। साहेब अब खुद का मालिक नहीं रहा।", "आर्थिक मजबूरी बचपन की आज़ादी छीन लेती है।"),
                p(3, "फिरोज़ाबाद के मुकेश का सपना: मोटर मैकेनिक", "Mukesh refused to accept the bangle-making destiny in dark Firozabad workshops and dreamed of driving a car.", "चूड़ी बनाने वाले कारखानों की अंधेरी कोठरियों में बच्चे आँखों की रोशनी खो देते हैं और साहूकारों-बिचौलियों के जाल में फँसे रहते हैं। लेकिन मुकेश ठान लेता है कि वह मोटर मैकेनिक बनेगा!", "साहस और नई सोच गरीबी के दुष्चक्र को तोड़ने की पहली सीढ़ी है।")
            ),
            characters = listOf(
                c("Saheb-e-Alam", "साहेब-ए-आलम", "सीमापुरी का कचरा बीनने वाला बालक", listOf("आशावादी पहले", "गरीबी से विवश", "सरल"), "बड़े नाम वाला साहेब कचरे में सिक्के खोजता है और स्कूल जाने का सपना देखता है, पर मजबूरी में चाय की दुकान पर काम करने लगता है।", "Saheb represents impoverished migrant children whose dreams and freedom are stifled by survival."),
                c("Mukesh", "मुकेश", "फिरोज़ाबाद का स्वप्नदर्शी बालक", listOf("साहसी", "दृढ़ निश्चयी", "प्रगतिशील"), "पीढ़ियों के चूड़ी व्यवसाय को चुनौती देकर मुकेश मोटर मैकेनिक बनने का व्यावहारिक सपना देखता है।", "Mukesh dares to break away from exploitative hereditary labour through determination.")
            ),
            scenes = listOf(
                s(1, "सीमापुरी में सोने की खोज", "Scrounging for Gold", "सुबह की धूप में साहेब और उसके दोस्त कचरे में रोटी और एक रुपये का सिक्का खोज रहे हैं!", "Saheb", "Anees Jung", CartoonSetting.CITY_MARKET, CartoonMood.THOUGHTFUL, "Seemapuri Reality"),
                s(2, "कनस्तर बनाम प्लास्टिक बैग", "Loss of Freedom", "चाय की दुकान पर 800 रुपये तो मिले, पर भारी स्टील का कनस्तर साहेब की मुस्कान ले गया!", "Saheb", "Tea Stall", CartoonSetting.CITY_MARKET, CartoonMood.DRAMATIC, "Lost Freedom"),
                s(3, "फिरोज़ाबाद की चूड़ी भट्टियाँ", "Glass Bangle Furnace", "अंधेरी गर्म भट्टियों के पास बच्चे रंगीन चूड़ियाँ जोड़ रहे हैं—कठिन गरीबी और दलालों का जाल!", "Mukesh", "Grandmother", CartoonSetting.MOUNTAIN_LAB, CartoonMood.THOUGHTFUL, "Firozabad Life"),
                s(4, "मुकेश का मोटर मैकेनिक सपना", "Daring to Dream", "मुकेश गर्व से कहता है—मैं मोटर मैकेनिक बनूँगा और कार चलाऊँगा! इमरान सर सलाम करते हैं!", "Mukesh", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "New Hope")
            ),
            words = listOf(
                w("Scrounging", "verb", "Searching around for food or useful items", "कचरे में ढूँढना / टटोलना", "Why do you do this, I ask Saheb whom I encounter scrounging."),
                w("Perpetual", "adj", "Never ending / continuous", "लगातार / अंतहीन", "They live in a perpetual state of poverty."),
                w("Mirage", "noun", "An illusion or unreachable hope", "मृगतृष्णा / भ्रम", "His dream looms like a mirage amidst dusty streets."),
                w("Vicious", "adj", "Cruel and trapping in a bad cycle", "दुष्ट / कुचक्र जैसा", "They are caught in the vicious circle of middlemen.")
            ),
            facts = listOf(
                f("How much monthly wage did Saheb receive at the tea stall?", "800 rupees and all his meals", listOf("500 rupees", "1,200 rupees", "400 rupees"), "चाय की दुकान पर साहेब को महीने के 800 रुपये और पूरा भोजन मिलता था।")
            )
        ),

        spec(
            id = "c12_fl_3",
            teachingHi = "विलियम डगलस का यह आत्मकथात्मक पाठ सिखाता है कि निरंतर प्रयास से बड़े से बड़े डर को हराया जा सकता है। बचपन में कैलिफोर्निया बीच की लहरों से डर बैठने के बाद, 11 वर्ष की उम्र में एक 18 साल का लड़का उन्हें YMCA पूल के 9 फीट गहरे पानी में फेंक देता है! डूबने के करीब पहुँचकर उनमें पानी का भयंकर फोबिया बैठ जाता है, जिसे वे महीनों प्रशिक्षक के साथ अभ्यास कर वेंटवर्थ झील में तैरकर जीत लेते हैं!",
            paragraphs = listOf(
                p(1, "बचपन का डर और YMCA पूल की दुर्घटना", "At eleven, a big bruiser tossed William Douglas into the nine-foot deep end of the YMCA pool.", "तीन-चार साल की उम्र में लहरों से डरने के बाद डगलस ने सुरक्षित YMCA पूल में तैरना शुरू किया, पर एक बड़े लड़के ने उन्हें गहरे पानी में फेंक दिया। वे तीन बार नीचे गए और बेहोश हो गए।", "एक दुर्घटना मन में गहरा भय (Phobia) पैदा कर सकती है।"),
                p(2, "पानी के डर ने हर आनंद छीन लिया", "The haunting fear of water ruined his fishing, boating, and canoeing joys for years.", "कई वर्षों तक पानी देखते ही डगलस के पैर सुन्न पड़ जाते थे—न वे मछली पकड़ पाते थे और न नाव चला पाते थे।", "मन का डर जीवन के सुख सीमित कर देता है।"),
                p(3, "प्रशिक्षक के साथ कठोर प्रशिक्षण और झील पर विजय", "Hiring an instructor, Douglas practiced piece by piece for months, then swam across Lake Wentworth.", "अक्टूबर से अप्रैल तक प्रशिक्षक ने उन्हें रस्सी, सांस छोड़ने व पैर चलाने का अभ्यास कराया। अंत में उन्होंने वेंटवर्थ झील के पार तैरकर चिल्लाकर अपने पुराने डर को विदा कर दिया!", "'सिर्फ डर से ही डरना चाहिए'—दृढ़ संकल्प हर भय को जीत सकता है।")
            ),
            characters = listOf(
                c("William Douglas", "विलियम डगलस", "भय पर विजय पाने वाले साहसी लेखक", listOf("धैर्यवान", "साहसी", "दृढ़ निश्चयी"), "गहरे पानी में लगभग डूबने के बाद भी डगलस ने जीवनभर डरकर रहने से इनकार किया और तैरने में महारत हासिल की।", "William Douglas shows immense perseverance by systematically conquering a paralyzing trauma.")
            ),
            scenes = listOf(
                s(1, "YMCA पूल में अचानक हादसा", "YMCA Pool Accident", "11 साल के डगलस पूल किनारे बैठे थे कि एक बड़े लड़के ने उन्हें 9 फीट गहरे पानी में फेंक दिया!", "Douglas", "Big Boy", CartoonSetting.OCEAN_SHIP, CartoonMood.DRAMATIC, "Deep Fall"),
                s(2, "तीन बार नीचे से ऊपर आने की कोशिश", "Three Desperate Tries", "डगलस ने पीले पानी में ऊपर छलाँग लगाने की तीन कोशिशें कीं, पर हिम्मत जवाब दे गई और आँखें बंद हो गईं!", "Douglas", "Water", CartoonSetting.OCEAN_SHIP, CartoonMood.THOUGHTFUL, "Near Drowning"),
                s(3, "इंस्ट्रक्टर के साथ कठोर अभ्यास", "Piece by Piece Training", "रस्सी और पुली की मदद से प्रशिक्षक ने महीनों में एक-एक करके डगलस को पूरा तैराक बना दिया!", "Douglas", "Instructor", CartoonSetting.OCEAN_SHIP, CartoonMood.INSPIRING, "Swim Practice"),
                s(4, "वेंटवर्थ झील पर जीत", "Conquering Terror", "दो मील तैरकर झील पार की और डगलस मुस्कुराए—डर भाग गया! रूज़वेल्ट सही थे: डर सिर्फ डरने में है!", "Douglas", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Fear Defeated")
            ),
            words = listOf(
                w("Treacherous", "adj", "Dangerous and unpredictable", "खतरनाक / विश्वासघाती", "Mother warned him against the treacherous Yakima River."),
                w("Bruiser", "noun", "A big, tough-looking aggressive boy", "ताकतवर हट्टा-कट्टा लड़का", "A big bruiser of a boy tossed him into the pool."),
                w("Residual", "adj", "Remaining after the main part is gone", "बचा हुआ / अवशिष्ट", "Tiny vestiges of residual doubts returned when he swam alone."),
                w("Stark", "adj", "Complete, harsh, and bare", "कठोर / पूर्ण", "Stark terror seized him under nine feet of water.")
            ),
            facts = listOf(
                f("Whose famous quote did Douglas recall: 'All we have to fear is fear itself'?", "Franklin D. Roosevelt", listOf("Abraham Lincoln", "Nelson Mandela", "Mahatma Gandhi"), "डगलस ने राष्ट्रपति फ्रैंकलिन डी. रूज़वेल्ट का प्रसिद्ध कथन याद किया।")
            )
        ),

        spec(
            id = "c12_fl_5",
            teachingHi = "लुई फिशर का यह ऐतिहासिक पाठ बताता है कि चंपारण में 1917 का किसान आंदोलन भारत की आज़ादी का पहला बड़ा मोड़ कैसे बना। अनपढ़ व दृढ़ किसान राजकुमार शुक्ल गाँधीजी को बिहार के चंपारण ले जाते हैं, जहाँ अंग्रेज़ ज़मींदार किसानों से 15% भूमि पर नील की खेती करवाकर मुआवज़ा वसूल रहे थे। गाँधीजी ने बिना हिंसा, कानून और सत्य के बल पर किसानों का डर मिटाया और स्वशासन व आत्मनिर्भरता सिखाई!",
            paragraphs = listOf(
                p(1, "राजकुमार शुक्ल की अडिग जिद और गाँधीजी का आगमन", "Resolute peasant Rajkumar Shukla followed Gandhi everywhere until Gandhi agreed to visit Champaran.", "1916 के लखनऊ अधिवेशन से ही राजकुमार शुक्ल गाँधीजी के पीछे-पीछे कानपुर, अहमदाबाद और कलकत्ता तक गए। उनकी लगन देख गाँधीजी 1917 में पटना व मुजफ्फरपुर होते हुए चंपारण पहुँचे।", "सच्ची लगन बड़े नेताओं और इतिहास की दिशा मोड़ देती है।"),
                p(2, "मोतिहारी की अदालत और सविनय अवज्ञा की पहली जीत", "Ordered to leave Tirhut, Gandhi refused; thousands of peasants surrounded Motihari courthouse, forcing officials to drop the case.", "जब गाँधीजी ने सरकारी आदेश मानने से इनकार किया तो मोतिहारी अदालत के बाहर हज़ारों किसानों की भीड़ उमड़ पड़ी। अंग्रेज़ सरकार ने पहली बार सविनय अवज्ञा की शक्ति देखी और केस वापस लेना पड़ा!", "भयमुक्त किसान ही सच्ची स्वतंत्रता के निर्माता होते हैं।"),
                p(3, "25% वापसी, आत्मनिर्भरता और चंपारण का विकास", "Landlords agreed to refund 25% of money; Gandhi explained the amount mattered less than breaking landlords' prestige, then opened schools and clinics.", "25% मुआवज़ा लेकर भी गाँधीजी जीते क्योंकि अंग्रेज़ ज़मींदारों का घमंड टूट गया! इसके बाद उन्होंने चंपारण के 6 गाँवों में स्कूल, स्वच्छता और डॉक्टर की सेवा शुरू कराई।", "राजनीतिक आज़ादी के साथ सामाजिक व शैक्षिक सुधार भी आवश्यक हैं।")
            ),
            characters = listOf(
                c("Mahatma Gandhi", "महात्मा गांधी", "अहिंसक नेतृत्व और सत्य के प्रतीक", listOf("निडर", "व्यावहारिक", "समाज सुधारक"), "गाँधीजी ने चंपारण के किसानों का भय मिटाया, वकीलों को एकजुट किया और केवल समझौते पर न रुककर गाँवों में शिक्षा व स्वास्थ्य पर काम किया।", "Gandhi leads Champaran through moral courage, nonviolent civil disobedience, and grassroots social uplift."),
                c("Rajkumar Shukla", "राजकुमार शुक्ल", "दृढ़ निश्चयी चंपारण किसान", listOf("अडिग", "संकल्पवान", "गरीबों के प्रतिनिधि"), "यद्यपि वे अनपढ़ थे, पर उनके अडिग निश्चय ने ही गाँधीजी को चंपारण की समस्या सुलझाने के लिए बाध्य किया।", "Rajkumar Shukla is an illiterate yet remarkably resolute sharecropper whose persistence brings Gandhi to Champaran.")
            ),
            scenes = listOf(
                s(1, "राजकुमार शुक्ल की अडिग लगन", "Resolute Farmer", "जहाँ-जहाँ गाँधीजी गए, गरीब किसान राजकुमार शुक्ल चुपचाप पीछे रहे—बस चंपारण चलिए बापू!", "Rajkumar Shukla", "Gandhi", CartoonSetting.CITY_MARKET, CartoonMood.THOUGHTFUL, "Persistent Plea"),
                s(2, "मोतिहारी में किसानों का जनसैलाब", "Fearless Champaran", "अदालत के बाहर किसानों की ऐतिहासिक भीड़ देखकर अंग्रेज़ अधिकारी हिल गए—केस वापस लिया गया!", "Gandhi", "Peasants", CartoonSetting.ROYAL_PALACE, CartoonMood.DRAMATIC, "Civil Disobedience"),
                s(3, "25% वापसी का समझौता", "25% Refund Victory", "गाँधीजी बोले—रकम छोटी नहीं, आज ज़मींदारों का अहंकार और किसानों का डर टूटा है—यही असली जीत है!", "Gandhi", "Landlords", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Prestige Broken"),
                s(4, "गाँवों में शिक्षा व स्वच्छता", "Self-Reliance Lesson", "चंपारण में 6 स्कूल खुले और कस्तूरबा ने स्वच्छता सिखाई—इमरान सर कहते हैं, आत्मनिर्भर बनो!", "Gandhi", "Imran Sir", CartoonSetting.HOME_GARDEN, CartoonMood.HAPPY, "Social Reform")
            ),
            words = listOf(
                w("Sharecroppers", "noun", "Farmers giving a fixed share of harvest as rent", "बटाईदार किसान", "Most arable land was worked by Indian sharecroppers."),
                w("Resolute", "adj", "Firmly determined and purposeful", "दृढ़ निश्चयी / अडिग", "Rajkumar Shukla was poor and illiterate yet resolute."),
                w("Deadlock", "noun", "A standstill where no agreement seems possible", "गतिरोध / अटकाव", "The official inquiry broke the longstanding deadlock."),
                w("Chided", "verb", "Scolded gently", "हल्की डाँट लगाई", "Gandhi chided the lawyers for collecting big fees.")
            ),
            facts = listOf(
                f("Which synthetic substitute caused German planters to stop wanting natural indigo from Champaran?", "Synthetic indigo", listOf("Synthetic cotton", "Artificial silk", "Chemical tea"), "जर्मनी द्वारा कृत्रिम नील (Synthetic indigo) बना लेने से प्राकृतिक नील की माँग घट गई थी।")
            )
        ),

        spec(
            id = "c12_vi_1",
            teachingHi = "जैक फिनी की यह कल्पनाशील और मनोवैज्ञानिक कहानी आधुनिक जीवन के तनाव से भागने की इच्छा को दिखाती है। 31 वर्षीय चार्ली दावा करता है कि न्यूयॉर्क के ग्रैंड सेंट्रल स्टेशन पर केवल दो नहीं बल्कि एक 'तीसरा स्तर' (Third Level) भी है, जो उसे 1894 के शांत युग में ले जाता है! उसका मनोचिकित्सक मित्र सैम इसे 'जागते हुए सपना देखना' कहता है—पर अंत में सैम खुद भी 1894 में चला जाता है!",
            paragraphs = listOf(
                p(1, "ग्रैंड सेंट्रल स्टेशन पर तीसरे स्तर की खोज", "Charley wandered into an arched corridor at Grand Central and emerged onto a 1894-era Third Level.", "चार्ली अपने अपार्टमेंट जल्दी पहुँचने के लिए सबवे से जाता है और रास्ता भटककर पुराने लकड़ी के टिकट घर, पीतल के पीकदान और 11 जून 1894 के 'द वर्ल्ड' अखबार वाले तीसरे स्तर पर पहुँच जाता है!", "आधुनिक दुनिया के तनाव में मन शांतिपूर्ण अतीत की ओर भागता है।"),
                p(2, "गेल्सबर्ग जाने का असफल प्रयास और पुरानी मुद्रा", "Trying to buy two tickets to Galesburg, Illinois, Charley fled when the clerk suspected his modern currency.", "चार्ली अपनी पत्नी लुइसा के साथ 1894 के शांत गेल्सबर्ग जाने के लिए टिकट माँगता है, पर आधुनिक नोट देखकर क्लर्क उसे जेल भेजने की धमकी देता है। चार्ली 300 डॉलर के पुराने नोट बदलवाता है, पर फिर वह दरवाज़ा नहीं मिलता!", "कल्पना की दुनिया हमें राहत देती है, पर टिकट हर बार नहीं मिलता।"),
                p(3, "सैम का रहस्यमयी पत्र (फर्स्ट-डे कवर)", "Inside his stamp collection, Charley found a first-day cover dated 18 July 1894 signed by psychiatrist Sam Weiner.", "डाक टिकट संग्रह (Philately) में चार्ली को 1894 का एक लिफाफा मिलता है जिसमें उसका दोस्त सैम लिखता है—चार्ली, तुम सही थे! मैं गेल्सबर्ग में सूखे घास और संगीत का आनंद ले रहा हूँ, तुम और लुइसा इसे ढूँढते रहो!", "यह कहानी वास्तविकता और कल्पना का सुंदर रहस्य बुनती है।")
            ),
            characters = listOf(
                c("Charley", "चार्ली (31 वर्ष)", "तनाव से मुक्ति चाहने वाला आधुनिक युवक", listOf("कल्पनाशील", "भावुक", "अतीत-प्रेमी"), "चार्ली आधुनिक जीवन की असुरक्षा व युद्ध भय से दूर 1894 के शांत गेल्सबर्ग की तलाश करता है और डाक टिकट इकट्ठे करता है।", "Charley is a 31-year-old New Yorker seeking refuge from modern anxiety in the idyllic memory of 1894."),
                c("Sam Weiner", "सैम वाइनर", "चार्ली का मनोचिकित्सक मित्र", listOf("तार्किक पहले", "सपना देखने वाला", "रोमांचप्रेमी"), "पहले वह चार्ली की बात को मानसिक भ्रम कहता है, पर खुद भी पुराने नोट खरीदकर 1894 के गेल्सबर्ग में बस जाता है।", "Sam is Charley's psychiatrist friend who dismisses the Third Level—until he secretly finds it himself.")
            ),
            scenes = listOf(
                s(1, "ग्रैंड सेंट्रल की भूलभुलैया", "Lost in Subways", "जल्दी घर जाने के चक्कर में चार्ली एक अनजान सुरंग में मुड़ गया और समय में पीछे चला गया!", "Charley", "Subway", CartoonSetting.CITY_MARKET, CartoonMood.MYSTERY, "Time Tunnel"),
                s(2, "1894 का विंटेज स्टेशन", "The 1894 Third Level", "अरे वाह! गैस की लालटेनें, मूँछों वाले लोग और 11 जून 1894 का अखबार—चार्ली 1894 में पहुँच गया है!", "Charley", "Ticket Clerk", CartoonSetting.CITY_MARKET, CartoonMood.THOUGHTFUL, "1894 Era"),
                s(3, "पुरानी मुद्रा और गायब रास्ता", "300 Dollars Old Bills", "चार्ली ने बैंक से 300 डॉलर के पुराने नोट तो ले लिए, पर दोबारा तीसरा स्तर मिला ही नहीं!", "Charley", "Louisa", CartoonSetting.HOME_GARDEN, CartoonMood.DRAMATIC, "Missing Door"),
                s(4, "स्टाम्प एल्बम में सैम का पत्र!", "Sam's 1894 Letter", "चमत्कार! जो डॉक्टर इसे सपना कहता था, वही सैम 1894 के गेल्सबर्ग से चार्ली को चिट्ठी लिख रहा है!", "Sam", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Surprise Ending")
            ),
            words = listOf(
                w("Suburban", "adj", "Located on the outer edge of a city", "उपनगरीय / शहर के बाहरी इलाके का", "Charley hurried to his suburban apartment."),
                w("Waking dream", "noun", "Daydreaming while awake as wish fulfillment", "जागते हुए देखा गया सपना", "Sam called the Third Level a waking-dream wish fulfillment."),
                w("Philately", "noun", "Collection and study of postage stamps", "डाक टिकट संग्रहण", "His grandfather and Charley enjoyed stamp collecting."),
                w("First-day cover", "noun", "Stamped envelope mailed on the first day of issue", "प्रथम दिवस आवरण लिफाफा", "He found an unusual first-day cover from 1894.")
            ),
            facts = listOf(
                f("How much did Sam spend on old-style currency according to the story?", "800 dollars worth", listOf("300 dollars worth", "100 dollars worth", "500 dollars worth"), "सैम ने 1894 में घास-चारा व अनाज व्यवसाय के लिए 800 डॉलर की पुरानी मुद्रा खरीदी थी।")
            )
        ),

        spec(
            id = "c12_vi_4",
            teachingHi = "पर्ल एस. बक की यह महान मानवीय कहानी द्वितीय विश्व युद्ध के समय जापान के डॉ. सदाओ होकी की नैतिक परीक्षा को दिखाती है। समुद्र तट पर एक घायल अमेरिकी युद्धबंदी (दुश्मन सैनिक) मिलने पर देशभक्त होने के बावजूद डॉ. सदाओ और उनकी पत्नी हाना डॉक्टर धर्म व मानवता को चुनते हैं। वे उसका ऑपरेशन कर जान बचाते हैं और अंततः उसे एक सुरक्षित नाव से भागने में मदद कर मानवता की जीत कराते हैं!",
            paragraphs = listOf(
                p(1, "समुद्र तट पर घायल अमेरिकी युद्धबंदी", "Dr. Sadao and Hana found a bleeding American prisoner of war washed ashore near their Japanese home.", "युद्धकाल में जब एक घायल गोरा अमेरिकी सैनिक उनके घर के पास समुद्र से बहकर आता है, तो देशभक्ति और चिकित्सक कर्तव्य के बीच डॉ. सदाओ का अंतर्द्वंद्व शुरू होता है।", "मानव जीवन की रक्षा किसी भी देश की सीमा से बड़ी होती है।"),
                p(2, "घर में ऑपरेशन और नौकरों का विरोध", "Though servants walked out in fear, Sadao operated with Hana's help to remove the bullet.", "खतरा जानकर घर के सभी नौकर काम छोड़कर चले जाते हैं, पर पत्नी हाना साहस के साथ डॉक्टर को बेहोशी की दवा देने में मदद करती हैं और गोली सफलतापूर्वक निकाल ली जाती है।", "सच्चा जीवनसाथी कठिन नैतिक परीक्षा में ढाल बनकर खड़ा रहता है।"),
                p(3, "जनरल का वादा और टॉम की सुरक्षित विदाई", "When the old General forgot to send private assassins, Sadao gave Tom food, water, and a boat to escape.", "बीमार जनरल के हत्यारे न भेजने पर डॉ. सदाओ रात में टॉम को भोजन, टॉर्च और नाव देकर पास के द्वीप की ओर रवाना कर देते हैं—और इस तरह मानवता व कर्तव्य दोनों निभा लेते हैं!", "करुणा और चिकित्सा धर्म युद्ध की नफरत से ऊपर हैं।")
            ),
            characters = listOf(
                c("Dr. Sadao Hoki", "डॉ. सदाओ होकी", "कुशल व करुणामय जापानी सर्जन", listOf("कर्तव्यनिष्ठ डॉक्टर", "देशभक्त फिर भी मानवीय", "निडर व बुद्धिमान"), "अमेरिका से सर्जरी सीखकर आए डॉ. सदाओ ने युद्धकालीन नफरत से ऊपर उठकर एक दुश्मन सैनिक की जान बचाई और सुरक्षित रास्ता भी दिखाया।", "Dr. Sadao balances patriotic loyalty with unwavering medical ethics and profound human compassion."),
                c("Hana", "हाना (सदाओ की पत्नी)", "साहसी व समझदार जापानी महिला", listOf("समर्थक", "दयालु", "संकट में धैर्यवान"), "नौकरों के जाने पर भी वह घायल कैदी की सेवा व ऑपरेशन में पति का पूरा साथ देती है।", "Hana stands courageously beside Dr. Sadao, overcoming fear and prejudice to help save a human life.")
            ),
            scenes = listOf(
                s(1, "कोहरे में समुद्र किनारे घायल सैनिक", "Enemy Washed Ashore", "कोहरे के बीच समुद्र किनारे एक घायल अमेरिकी सैनिक पड़ा है—डॉ. सदाओ और हाना दुविधा में हैं!", "Dr. Sadao", "Hana", CartoonSetting.OCEAN_SHIP, CartoonMood.MYSTERY, "Beach Discovery"),
                s(2, "मानवता बनाम देशभक्ति: ऑपरेशन", "Life-Saving Surgery", "नौकर घर छोड़कर चले गए, पर हाना के सहयोग से डॉ. सदाओ ने दुश्मन सैनिक की गोली निकाल दी!", "Dr. Sadao", "Tom", CartoonSetting.MOUNTAIN_LAB, CartoonMood.DRAMATIC, "Brave Operation"),
                s(3, "जनरल की चुप्पी", "General's Promise", "बूढ़ा जनरल अपने दर्द में हत्यारे भेजना भूल गया—टॉम अब ठीक होकर चल-फिर रहा है!", "General", "Dr. Sadao", CartoonSetting.ROYAL_PALACE, CartoonMood.THOUGHTFUL, "Quiet Wait"),
                s(4, "नाव से सुरक्षित आज़ादी", "Humanity Wins", "डॉ. सदाओ ने टॉम को नाव, खाना और टॉर्च देकर सुरक्षित भेज दिया—मानवता सबसे बड़ा धर्म है!", "Dr. Sadao", "Imran Sir", CartoonSetting.OCEAN_SHIP, CartoonMood.INSPIRING, "Compassion Wins")
            ),
            words = listOf(
                w("Staggered", "verb", "Walked unsteadily as if about to fall", "लड़खड़ाकर चलना", "A dark figure staggered out of the sea mist."),
                w("Stupor", "noun", "State of near-unconsciousness", "अर्ध-बेहोशी / सुन्न अवस्था", "The wounded man lay in a deep stupor."),
                w("Repulsion", "noun", "Strong feeling of disgust or dislike", "घृणा / अरुचि", "Hana suppressed her fear and repulsion while helping."),
                w("Assassins", "noun", "Hired secret killers", "गुप्त हत्यारे", "The General promised to send private assassins.")
            ),
            facts = listOf(
                f("Where did Dr. Sadao study medicine and meet Hana?", "In America", listOf("In Germany", "In England", "In France"), "डॉ. सदाओ ने अमेरिका में चिकित्सा शिक्षा प्राप्त की और वहीं प्रोफेसर हार्ले के घर हाना से मिले।")
            )
        )
    ).associateBy { it.chapterId } + Class12MissingChapters.specs + Class12PoemsCurriculum.specs

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
