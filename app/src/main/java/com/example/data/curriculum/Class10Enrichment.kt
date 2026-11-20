package com.example.data.curriculum

import com.example.data.model.CartoonMood
import com.example.data.model.CartoonScene
import com.example.data.model.CartoonSetting
import com.example.data.model.CharacterSketch
import com.example.data.model.ParagraphExplanation
import com.example.data.model.QuestionType
import com.example.data.model.WordMeaning

object Class10Enrichment {

    val specs: Map<String, ChapterRichSpec> = listOf(
        spec(
            id = "c10_ff_1",
            teachingHi = "कक्षा 10 MP बोर्ड का यह सबसे महत्वपूर्ण पाठ एक सीधे-सादे किसान लेंचो की अटूट ईश्वर आस्था को दर्शाता है। जब ओलावृष्टि से उसकी मक्के की पूरी फसल तबाह हो जाती है, तो वह किसी इंसान के बजाय सीधे ईश्वर को 100 पेसो मदद के लिए पत्र लिखता है! दयालु पोस्टमास्टर अपने वेतन और मित्रों से 70 पेसो जुटाकर 'God' के नाम भेजते हैं, पर लेंचो बाकी 30 पेसो के लिए डाक कर्मियों पर ही शक कर बैठता है!",
            paragraphs = listOf(
                p(1, "लेंचो की फसल और बारिश की आशा", "Lencho's house sat on the crest of a low hill overlooking ripe corn fields needing rain.", "लेंचो का घर छोटी पहाड़ी की चोटी पर था। वह मक्के की फसल के लिए बारिश का इंतजार कर रहा था और बादलों को देखकर खुश हुआ मानो आकाश से नए सिक्के बरसने वाले हों।", "किसान का जीवन और सपना प्रकृति की कृपा पर टिका होता है।"),
                p(2, "ओलावृष्टि से पूर्ण विनाश", "Suddenly a strong wind blew and huge hailstones fell for an hour, leaving the field white as salt.", "खुशी जल्द ही संकट में बदल गई जब एक घंटे तक भारी ओले गिरते रहे। पूरा खेत सफेद नमक की चादर जैसा ढँक गया और एक भी पत्ता न बचा।", "अचानक आई आपदा में भी लेंचो ने ईश्वर पर भरोसा नहीं छोड़ा।"),
                p(3, "ईश्वर के नाम 100 पेसो का पत्र", "Lencho wrote a letter addressed 'To God', asking for 100 pesos to sow again.", "लेंचो ने रविवार को कस्बे जाकर 'To God' पते पर पत्र लिखा और अगली फसल बोने व परिवार चलाने के लिए 100 पेसो माँगे।", "सच्ची आस्था बड़ी से बड़ी विपत्ति में सहारा देती है।"),
                p(4, "पोस्टमास्टर की दया और विडंबनापूर्ण अंत", "The postmaster collected 70 pesos, yet Lencho suspected the post office employees as 'a bunch of crooks'.", "पोस्टमास्टर ने लेंचो का विश्वास बचाने के लिए 70 पेसो इकट्ठे कर भेजे। पर पूरे 100 न पाकर लेंचो ने दूसरा पत्र लिखा कि बाकी 30 पेसो डाक घर वालों ने चुरा लिए!", "यह कहानी मानवीय दया और भोली आस्था की सुंदर विडंबना दिखाती है।")
            ),
            characters = listOf(
                c("Lencho", "लेंचो", "परिश्रमी किसान व मुख्य पात्र", listOf("मेहनती", "अटूट आस्थावान", "भोला"), "लेंचो खेत में बैल की तरह मेहनत करता है। उसका ईश्वर पर भरोसा इतना गहरा है कि वह पोस्टमास्टर की मदद को भी ईश्वर का ही भेजा धन मानता है।", "Lencho is a hardworking, simple farmer whose unquestioning faith in God leads him to write directly to heaven."),
                c("The Postmaster", "पोस्टमास्टर", "दयालु व संवेदनशील अधिकारी", listOf("सहानुभूतिपूर्ण", "उदार", "हँसमुख"), "पोस्टमास्टर लेंचो की आस्था देखकर भावुक हो जाते हैं और अपने वेतन का हिस्सा व साथियों का दान जोड़कर 70 पेसो भेजते हैं।", "The postmaster is a kind, generous man who raises 70 pesos to preserve Lencho's faith in God.")
            ),
            scenes = listOf(
                s(1, "लेंचो का खेत और काले बादल", "Waiting for Rain", "पहाड़ी पर खड़े किसान लेंचो बारिश की बूँदों को देखकर खुश हो रहे हैं—अरे, ये तो चाँदी के सिक्के हैं!", "Lencho", "Rainclouds", CartoonSetting.FARM_STORM, CartoonMood.HAPPY, "Rain Joy"),
                s(2, "ओलों का भयानक तूफान", "Hailstorm Disaster", "हाय राम! एक घंटे तक बड़े-बड़े ओले गिरे और लेंचो की मक्के की पूरी फसल नष्ट हो गई!", "Lencho", "Storm", CartoonSetting.FARM_STORM, CartoonMood.DRAMATIC, "Hailstorm"),
                s(3, "ईश्वर के नाम पत्र", "Letter To God", "लेंचो ने कागज़ उठाया और लिखा—हे ईश्वर, हमें 100 पेसो भेजें, वरना परिवार भूखा रह जाएगा!", "Lencho", "Postman", CartoonSetting.CITY_MARKET, CartoonMood.THOUGHTFUL, "Writing Letter"),
                s(4, "पोस्टमास्टर की उदारता", "70 Pesos & Irony", "पोस्टमास्टर ने अपने वेतन से 70 पेसो भेजे! पर लेंचो को लगा बाकी 30 पेसो डाकघर वालों ने रखे!", "Postmaster", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Lesson Irony")
            ),
            words = listOf(
                w("Crest", "noun", "Top of a hill", "चोटी / शिखर", "His house was the only one on the crest of a low hill."),
                w("Downpour", "noun", "Heavy rain", "मूसलाधार बारिश", "The earth needed a downpour or at least a shower."),
                w("Hailstones", "noun", "Balls of ice falling from clouds", "ओले", "Large hailstones destroyed the corn crop."),
                w("Locusts", "noun", "Swarms of destructive insects", "टिड्डी दल", "A plague of locusts would have left more than this."),
                w("Solitary", "adj", "Lonely / single", "अकेला / एकाकी", "He lived in a solitary house in the valley."),
                w("Amiable", "adj", "Friendly and pleasant", "मिलनसार / स्नेही", "The postmaster was a fat, amiable fellow."),
                w("Contentment", "noun", "Satisfaction", "संतोष", "He watched with contentment from the office."),
                w("Crooks", "noun", "Dishonest people", "बेईमान / ठग", "Lencho called the post office employees a bunch of crooks.")
            ),
            facts = listOf(
                f("What did Lencho compare the big raindrops to?", "Ten cent pieces", listOf("Five cent pieces", "Gold coins", "Diamonds"), "लेंचो ने बड़ी बूँदों की तुलना 10 सेंट के सिक्कों और छोटी बूँदों की 5 सेंट से की।"),
                f("How much money did Lencho demand from God?", "100 pesos", listOf("70 pesos", "30 pesos", "50 pesos"), "लेंचो ने ईश्वर से 100 पेसो की माँग की थी।"),
                f("How much money did the postmaster actually manage to send?", "70 pesos", listOf("100 pesos", "60 pesos", "80 pesos"), "पोस्टमास्टर केवल 70 पेसो ही इकट्ठे कर सके थे।")
            ),
            fbs = listOf("The postmaster signed the letter with a single word: ______." to "God", "Lencho's crop was completely destroyed by ______." to "hailstones"),
            tfs = listOf("Lencho's wife was very happy after the hailstorm." to false, "The postmaster laughed at first but soon admired Lencho's deep faith." to true)
        ),

        spec(
            id = "c10_ff_2",
            teachingHi = "यह पाठ दक्षिण अफ्रीका के प्रथम अश्वेत राष्ट्रपति नेल्सन मंडेला की आत्मकथा से है। 10 मई 1994 को रंगभेद (Apartheid) समाप्त होने के बाद वे लोकतांत्रिक सरकार की शपथ लेते हैं। मंडेला समझाते हैं कि साहस का अर्थ डर न होना नहीं, बल्कि डर पर विजय पाना है—और उत्पीड़क तथा पीड़ित दोनों को ही आज़ाद करना ज़रूरी है!",
            paragraphs = listOf(
                p(1, "10 मई 1994 का ऐतिहासिक शपथ समारोह", "On 10 May 1994, Nelson Mandela was sworn in as South Africa's first Black President.", "प्रीटोरिया के यूनियन बिल्डिंग्स एम्फीथिएटर में दुनिया भर के नेताओं के सामने नेल्सन मंडेला ने लोकतंत्र और समानता की ऐतिहासिक शपथ ली।", "सदियों के रंगभेद का अंत और समानता का सूर्योदय।"),
                p(2, "शहीदों को नमन और साहस की परिभाषा", "Mandela remembered freedom fighters and defined courage as triumph over fear.", "मंडेला उन अनगिनत देशभक्तों को याद करते हैं जिन्होंने आज़ादी के लिए बलिदान दिया। वे कहते हैं कि बहादुर वह नहीं जो डरता नहीं, बल्कि वह जो डर को जीत ले।", "साहस भय का अभाव नहीं, भय पर विजय है।"),
                p(3, "प्रेम की स्वाभाविक शक्ति और दोहरे कर्तव्य", "Every person has twin obligations—to family and to community/country; love comes more naturally than hate.", "मंडेला बताते हैं कि हर व्यक्ति के दो कर्तव्य होते हैं—परिवार के प्रति और देश के प्रति। नफरत सिखाई जाती है, जबकि प्रेम इंसान के हृदय में स्वाभाविक रूप से जन्म लेता है।", "दमन करने वाला भी घृणा का कैदी होता है; सबकी स्वतंत्रता आवश्यक है।")
            ),
            characters = listOf(
                c("Nelson Mandela", "नेल्सन मंडेला", "दक्षिण अफ्रीका के प्रथम अश्वेत राष्ट्रपति", listOf("साहसी", "क्षमाशील", "लोकतंत्र के रक्षक"), "27 वर्ष जेल में बिताने के बावजूद मंडेला ने नफरत नहीं चुनी, बल्कि सबके लिए समान और रंगभेद-मुक्त समाज का निर्माण किया।", "Mandela is an iconic leader of resilience, forgiveness, and universal human dignity.")
            ),
            scenes = listOf(
                s(1, "प्रीटोरिया में ऐतिहासिक सुबह", "10 May 1994 Inauguration", "दक्षिण अफ्रीका के आकाश में तिरंगे रंग का धुआँ और जेट विमानों की सलामी—लोकतंत्र का नया सवेरा है!", "Mandela", "Leaders", CartoonSetting.ROYAL_PALACE, CartoonMood.INSPIRING, "Oath Ceremony"),
                s(2, "रंगभेद के विरुद्ध लंबा संघर्ष", "Triumph Over Fear", "मंडेला समझाते हैं—बहादुरी का मतलब डर न लगना नहीं, बल्कि डर को हरा देना है!", "Mandela", "Prisoners", CartoonSetting.MOUNTAIN_LAB, CartoonMood.THOUGHTFUL, "Courage Quote"),
                s(3, "दोहरे कर्तव्य और प्रेम", "Twin Obligations", "हर नागरिक के दो फर्ज़ हैं—परिवार और देश! प्यार इंसान के दिल में नफरत से ज्यादा स्वाभाविक है!", "Mandela", "Citizens", CartoonSetting.HOME_GARDEN, CartoonMood.HAPPY, "Humanity Lesson"),
                s(4, "बोर्ड मंत्र", "Freedom For All", "इमरान सर बताते हैं—जिसने किसी की आज़ादी छीनी वह भी नफरत की जेल में बंद है!", "Mandela", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Moral Summary")
            ),
            words = listOf(
                w("Apartheid", "noun", "Racial discrimination system", "रंगभेद नीति", "Apartheid created a deep wound in South Africa."),
                w("Inauguration", "noun", "Formal ceremony starting a new era", "उद्घाटन / शपथ समारोह", "Dignitaries attended the inauguration on 10 May."),
                w("Obligations", "noun", "Duties or responsibilities", "कर्तव्य / उत्तरदायित्व", "Every man has twin obligations in life."),
                w("Triumph", "noun", "Great victory", "विजय", "Courage is the triumph over fear."),
                w("Eradicate", "verb", "Remove completely", "जड़ से मिटाना", "They pledged to eradicate poverty and discrimination.")
            ),
            facts = listOf(
                f("Where did the inauguration ceremony take place on 10 May 1994?", "Union Buildings amphitheatre in Pretoria", listOf("Cape Town Parliament", "Johannesburg Stadium", "Durban Hall"), "शपथ समारोह प्रिटोरिया के यूनियन बिल्डिंग्स एम्फीथिएटर में हुआ।")
            )
        ),

        spec(
            id = "c10_ff_3",
            teachingHi = "इस पाठ की दो रोचक कहानियाँ भय पर विजय पाने के बारे में हैं। भाग 1 में एक छोटा सीगल पक्षी उड़ने से डरता है, पर जब उसकी माँ चोंच में मछली लेकर पास आकर रुकती हैं तो भूख के कारण वह छलाँग लगाता है और अपने पंखों से आसमान में उड़ना सीख जाता है! भाग 2 में एक पायलट तूफानी बादलों में फँसने पर एक रहस्यमयी काले हवाई जहाज की मदद से सुरक्षित लैंड होता है।",
            paragraphs = listOf(
                p(1, "नन्हे सीगल का उड़ने से डरना", "The young seagull was afraid to fly because he felt his wings would never support him.", "अपने छोटे भाई-बहनों को उड़ते देखकर भी नन्हा सीगल चट्टान के किनारे से कूदने से डरता है। भूख और अकेलेपन से वह बेहाल है।", "मन का डर ही हमारी उड़ान को रोकता है।"),
                p(2, "माँ की युक्ति और पहली सफल उड़ान", "His mother tempted him with a piece of fish; diving for food, he opened his wings and soared.", "माँ मछली का टुकड़ा लेकर पास आती हैं और ठीक सामने हवा में रुक जाती हैं। भूख से पागल होकर सीगल झपटता है, नीचे गिरता है और अचानक उसके पंख खुल जाते हैं!", "पहला कदम उठाते ही आत्मविश्वास जाग जाता है।"),
                p(3, "काला एरोप्लेन और रहस्यमयी मदद", "Caught in black storm clouds without instruments, the narrator followed a mysterious black aeroplane.", "ओल्ड डकोटा उड़ाते हुए पायलट तूफान में फँस जाता है, कम्पास खराब हो जाता है। तभी एक अनजान काला जहाज रास्ता दिखाकर उसे सुरक्षित रनवे पर उतार देता है!", "संकट के समय उम्मीद और हिम्मत हमें रास्ता दिखाती है।")
            ),
            characters = listOf(
                c("The Young Seagull", "नन्हा सीगल पक्षी", "भाग 1 का मुख्य पात्र", listOf("डरा हुआ पहले", "भूखा", "उत्साही विजेता"), "शुरू में वह उड़ान से डरता है, परंतु पहली छलाँग के बाद समुद्र के ऊपर आत्मविश्वास से उड़ता है।", "The young seagull overcomes paralyzing fear to discover the joy of flight.")
            ),
            scenes = listOf(
                s(1, "चट्टान पर अकेला सीगल", "Afraid to Fly", "भाई-बहन उड़ गए, पर नन्हा सीगल गहरे समुद्र को देखकर डर से काँप रहा है!", "Young Seagull", "Cliff", CartoonSetting.OCEAN_SHIP, CartoonMood.THOUGHTFUL, "Fear on Ledge"),
                s(2, "माँ की चोंच में मछली", "Mother's Clever Plan", "भूख से तड़पते सीगल के सामने माँ मछली लेकर उड़ रही हैं—उसने झपट्टा मारा और पंख खुल गए!", "Young Seagull", "Mother Seagull", CartoonSetting.OCEAN_SHIP, CartoonMood.HAPPY, "First Flight"),
                s(3, "तूफान में काला जहाज", "Black Aeroplane Rescue", "घने काले बादलों में फँसे डकोटा पायलट के सामने बिना लाइट वाला काला जहाज रास्ता दिखा रहा है!", "Pilot", "Black Plane", CartoonSetting.MOUNTAIN_LAB, CartoonMood.MYSTERY, "Storm Escape"),
                s(4, "रनवे पर सुरक्षित उतरना", "Safe Landing", "पायलट सुरक्षित उतर गया, पर कंट्रोल टावर बोली—रडार पर तो कोई दूसरा जहाज था ही नहीं! चमत्कार!", "Pilot", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Mystery Moral")
            ),
            words = listOf(
                w("Ledge", "noun", "A narrow shelf projecting from a rock", "चट्टान का उभरा किनारा", "The young seagull stood alone on the ledge."),
                w("Herring", "noun", "A kind of sea fish", "हेरिंग मछली", "His brother caught his first herring."),
                w("Soaring", "verb", "Flying high smoothly", "ऊँची उड़ान भरना", "He felt himself soaring gradually downwards and upwards."),
                w("Compass", "noun", "An instrument showing directions", "दिशा सूचक यंत्र", "The compass turned round and round in the storm.")
            ),
            facts = listOf(
                f("What was the name of the aeroplane the narrator was flying?", "Old Dakota (DS 088)", listOf("Airbus 320", "Black Hawk", "Boeing 707"), "कथावाचक का जहाज 'Old Dakota DS 088' था।")
            )
        ),

        spec(
            id = "c10_ff_4",
            teachingHi = "यह पाठ ऐनी फ्रैंक की विश्व प्रसिद्ध डायरी का अंश है। द्वितीय विश्व युद्ध में छिपने से पहले 13 वर्षीय ऐनी 'किट्टी' नाम की डायरी में अपने अकेलेपन, स्कूल की यादों और गणित शिक्षक मिस्टर कीसिंग की मज़ेदार घटनाओं को लिखती है। तीन बार बातें करने की सजा में निबंध मिलने पर ऐनी ऐसी कविता लिखती है कि शिक्षक खुद हँसकर उसे बोलने की इजाज़त दे देते हैं!",
            paragraphs = listOf(
                p(1, "'कागज़ में लोगों से अधिक धैर्य होता है'", "Anne decided to treat her diary named 'Kitty' as a true friend because paper has more patience than people.", "13 वर्षीय ऐनी के पास परिवार और सहेलियाँ हैं, फिर भी वह भीतर से अकेली महसूस करती है और अपनी डायरी 'किट्टी' को अपना सच्चा दोस्त बनाती है।", "लिखना मन के भावों को व्यक्त करने का सुंदर माध्यम है।"),
                p(2, "मिस्टर कीसिंग की सजा और 'Chatterbox' निबंध", "Her maths teacher Mr. Keesing annoyed by her talking assigned essays like 'A Chatterbox'.", "कक्षा में अधिक बात करने के कारण गणित के अध्यापक मिस्टर कीसिंग ऐनी को 'Chatterbox' (बातूनी) विषय पर निबंध लिखने की सजा देते हैं। ऐनी चालाकी से तर्क देती है कि बात करना विद्यार्थियों का गुण है।", "रचनात्मक बुद्धि से कठिन परिस्थिति को भी जीता जा सकता है।"),
                p(3, "मज़ाकिया कविता और शिक्षक का हृदय परिवर्तन", "Anne wrote a funny verse about a mother duck and father swan; Mr. Keesing laughed and stopped punishing her.", "तीसरी बार 'Quack, Quack, Quack, Said Mistress Chatterbox' पर ऐनी सहेली सने की मदद से एक प्यारी कविता लिखती है। मिस्टर कीसिंग वह कविता पूरी कक्षा को सुनाते हैं और सजा माफ कर देते हैं!", "स्वस्थ हास्य कठोर से कठोर शिक्षक का भी दिल जीत लेता है।")
            ),
            characters = listOf(
                c("Anne Frank", "ऐनी फ्रैंक (13 वर्ष)", "चतुर, भावुक एवं लेखन-प्रेमी छात्रा", listOf("तेज़ बुद्धि", "बातूनी व हास्यप्रिय", "ईमानदार"), "ऐनी अपनी डायरी किट्टी से दिल की हर बात साझा करती है और अपनी रचनात्मकता से मिस्टर कीसिंग को भी प्रभावित कर देती है।", "Anne Frank is a witty, observant teenager who uses humor and writing to cope with loneliness."),
                c("Mr. Keesing", "मिस्टर कीसिंग", "पुराने ख्यालात के गणित शिक्षक", listOf("अनुशासित", "विनोदी बाद में", "सच्चे गुरु"), "पहले वे ऐनी के बात करने से चिढ़ते हैं, पर उसकी अनोखी कविता पढ़कर उसका सम्मान करने लगते हैं।", "Mr. Keesing is a strict maths teacher whose good humor shines when he reads Anne's poem.")
            ),
            scenes = listOf(
                s(1, "प्यारी डायरी 'किट्टी'", "Paper Has More Patience", "13वें जन्मदिन पर मिली डायरी को ऐनी ने अपना सबसे अच्छा दोस्त 'किट्टी' नाम दिया है!", "Anne", "Kitty Diary", CartoonSetting.HOME_GARDEN, CartoonMood.THOUGHTFUL, "Dear Kitty"),
                s(2, "गणित कक्षा में बातचीत", "Mr. Keesing's Essay", "ऐनी कक्षा में गप्पें लड़ा रही थी—मिस्टर कीसिंग ने सजा दी: 'A Chatterbox' पर निबंध लिखो!", "Anne", "Mr. Keesing", CartoonSetting.CLASSROOM, CartoonMood.DRAMATIC, "Essay Punishment"),
                s(3, "बतख और हंस की कविता", "Quack Quack Verse", "ऐनी ने ऐसी मज़ेदार कविता लिखी कि मिस्टर कीसिंग खिलखिलाकर हँस पड़े!", "Mr. Keesing", "Anne", CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Funny Poem"),
                s(4, "कक्षा में आज़ादी", "Allowed to Talk", "इमरान सर बताते हैं—अच्छी लेखन कला और सकारात्मक हास्य से हर परीक्षा जीती जा सकती है!", "Anne", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Creative Win")
            ),
            words = listOf(
                w("Confide", "verb", "Tell personal secrets to a trusted friend", "मन की बात साझा करना", "She wanted a true friend in whom she could confide."),
                w("Jot down", "verb", "Write quickly", "जल्दी से लिख लेना", "Anyone could ramble on and jot down thoughts."),
                w("Incorrigible", "adj", "Impossible to correct", "जिसे सुधारा न जा सके", "Mr. Keesing called her an incorrigible chatterbox."),
                w("Ingenuity", "noun", "Clever originality", "चतुर रचनात्मकता", "She wrote the essay with great ingenuity.")
            ),
            facts = listOf(
                f("What name did Anne Frank give to her diary?", "Kitty", listOf("Maggie", "Sanne", "Margot"), "ऐनी ने अपनी डायरी का नाम 'किट्टी' (Kitty) रखा था।")
            )
        ),

        spec(
            id = "c10_ff_8",
            teachingHi = "इस पाठ में लेखक केन्या से इंग्लैंड जाते समय एक बहुत प्यारे ऊदबिलाव (Otter) 'मिजबिल' को पालते हैं। मिजबिल की पानी के प्रति दीवानगी, बाथटब में खेलना, हवाई जहाज में डिब्बे से निकलकर मज़ाकिया हंगामा करना और लंदन की गलियों में कंचों व पिंग-पोंग बॉल से खेलना पाठ को बेहद रोचक बनाता है।",
            paragraphs = listOf(
                p(1, "इराक के दलदल से मिला नया दोस्त 'मिजबिल'", "After losing his dog, Gavin Maxwell got an otter in Iraq and named him Mijbil.", "अपने कुत्ते की मृत्यु के बाद लेखक ने इराक से एक नन्हा ऊदबिलाव पाला, जो देखते ही देखते मिट्टी की परत हटाकर प्यारे चॉकलेट-भूरे मिजबिल के रूप में सामने आया।", "प्रकृति के जीव स्नेह और धैर्य से परिवार का हिस्सा बन जाते हैं।"),
                p(2, "मिजबिल का पानी प्रेम और खेल", "Mijbil loved plunging into water and invented games with marbles and ping-pong balls.", "मिजबिल को स्थिर पानी बिल्कुल पसंद नहीं था; उसने स्वयं बाथरूम का नल घुमाकर खोलना सीख लिया और टूटे सूटकेस पर गेंद लुढ़काने का खेल बना लिया।", "ऊदबिलाव अत्यंत बुद्धिमान और चंचल प्राणी होते हैं।"),
                p(3, "लंदन की उड़ान और अनोखे अंदाज़े", "During the flight, Mijbil escaped his box causing chaos until a kind air hostess helped; Londoners guessed funny animals for him.", "हवाई जहाज में मिजबिल बॉक्स से निकल भागा, पर दयालु एयर होस्टेस ने मदद की। लंदन में लोग उसे पहचान ही नहीं पाए और सील, गिलहरी व हिप्पो तक कह डाला!", "पशु-पक्षियों से प्रेम जीवन में अनोखा आनंद भर देता है।")
            ),
            characters = listOf(
                c("Mijbil the Otter", "मिजबिल (ऊदबिलाव)", "बुद्धिमान व चंचल पालतू जीव", listOf("पानी का प्रेमी", "चतुर", "खेलकूद में माहिर"), "मिजबिल नल खोलना और सूटकेस पर गेंद से खेलना खुद सीख लेता है तथा लेखक से बहुत लगाव रखता है।", "Mijbil is a playful, remarkably clever Lutrogale perspicillata otter who bonds closely with the author.")
            ),
            scenes = listOf(
                s(1, "पार्सल में से निकला मिजबिल", "Meeting Mijbil", "दोस्त द्वारा भेजे बोरे में से मखमली चॉकलेट रंग का प्यारा मिजबिल बाहर निकला!", "Maxwell", "Mijbil", CartoonSetting.HOME_GARDEN, CartoonMood.HAPPY, "Otter Arrival"),
                s(2, "बाथरूम में नल का जादू", "Water Wonderland", "मिजबिल ने अपने पंजों से बाथरूम का नल घुमाकर खोल दिया और छप-छप नहाने लगा!", "Mijbil", "Bathroom Tap", CartoonSetting.OCEAN_SHIP, CartoonMood.HAPPY, "Tap Trick"),
                s(3, "फ्लाइट में पकड़ा-पकड़ी", "Chaos on the Plane", "अरे! हवाई जहाज की सीटों के नीचे मिजबिल भाग निकला—'एक चूहा! एक चूहा!' सब चिल्ला उठे!", "Mijbil", "Air Hostess", CartoonSetting.CITY_MARKET, CartoonMood.DRAMATIC, "Flight Adventure"),
                s(4, "लंदन में कंचे व पिंग-पोंग", "London Walks", "लंदन की गलियों में मिजबिल अपनी पिंग-पोंग बॉल से खेलता है और सबको हैरान कर देता है!", "Maxwell", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Animal Bond")
            ),
            words = listOf(
                w("Symmetry", "noun", "Exact balance or matching beauty", "सुडौलपन / संतुलन", "His small body had the symmetry of a medieval dragon."),
                w("Plunging", "verb", "Diving quickly into water", "डुबकी लगाना", "He spent hours plunging and rolling in the tub."),
                w("Compulsive", "adj", "Driven by an irresistible habit", "अनिवार्य आदत जैसा", "Mijbil had compulsive habits along London walks."),
                w("Conjecture", "noun", "A guess based on incomplete evidence", "अनुमान / अटकल", "Londoners made wild conjectures about Mijbil.")
            ),
            facts = listOf(
                f("What was the scientific species name later given to Mijbil?", "Lutrogale perspicillata maxwelli", listOf("Canis familiaris", "Felis catus", "Ursus arctos"), "मिजबिल की इस प्रजाति को वैज्ञानिकों ने लेखक के नाम पर Maxwell's otter (Lutrogale perspicillata maxwelli) नाम दिया।")
            )
        ),

        spec(
            id = "c10_fp_1",
            teachingHi = "पशु चिकित्सक जेम्स हैरियट की यह कहानी अत्यधिक लाड़-प्यार के नुकसान को समझाती है। अमीर मिसेज़ पम्फ्री अपने छोटे कुत्ते ट्रिकी को चॉकलेट, केक, अंडे और क्रीम खिलाकर इतना मोटा कर देती हैं कि वह बीमार हो जाता है। डॉ. हैरियट बिना किसी इंजेक्शन या ऑपरेशन के, केवल दो दिन पानी व अन्य कुत्तों के साथ दौड़-भाग से ट्रिकी को पूरी तरह स्वस्थ कर देते हैं!",
            paragraphs = listOf(
                p(1, "अति लाड़-प्यार से बीमार ट्रिकी", "Mrs. Pumphrey overfed Tricki with malt, cod-liver oil, and Horlicks until he looked like a bloated sausage.", "मिसेज़ पम्फ्री को लगता है कि ट्रिकी कमजोर है, इसलिए वे उसे मीठे पकवान और अतिरिक्त भोजन देती हैं। नतीजतन ट्रिकी चलना भी बंद कर देता है।", "ज़रूरत से अधिक लाड़ और जंक फूड स्वास्थ्य के शत्रु हैं।"),
                p(2, "सर्जन के अस्पताल में दो दिन केवल पानी", "Dr. Herriot admitted Tricki for a fortnight and gave him only plenty of water for two days.", "डॉ. हैरियट ट्रिकी को अस्पताल ले जाते हैं। दो दिन बिना खाने और भरपूर पानी के बाद तीसरे दिन ट्रिकी अन्य कुत्तों के साथ खेलने लगता है और तेज़ी से ठीक होता है।", "संतुलित आहार और व्यायाम सबसे अच्छी दवा है।"),
                p(3, "'शल्य चिकित्सा की विजय' (विडंबना)", "Mrs. Pumphrey sent eggs and wine for Tricki, which the staff enjoyed, and wept in joy seeing him healthy.", "मिसेज़ पम्फ्री ट्रिकी के लिए अंडे व वाइन भेजती रहीं जो डॉक्टर व स्टाफ ने मज़े से खाए! जब ट्रिकी फुर्ती से उनकी गोद में कूद पड़ा तो उन्होंने इसे 'A Triumph of Surgery' कहा।", "सही जीवनशैली बिना दवा के भी चमत्कार कर सकती है।")
            ),
            characters = listOf(
                c("Dr. James Herriot", "डॉ. जेम्स हैरियट", "समझदार व व्यावहारिक पशु चिकित्सक", listOf("बुद्धिमान", "दयालु", "व्यावहारिक"), "डॉ. हैरियट ने दवा के बजाय सही डाइट और व्यायाम से ट्रिकी को नया जीवन दिया।", "Dr. Herriot is a wise, compassionate vet who cures Tricki naturally with diet and exercise."),
                c("Mrs. Pumphrey", "मिसेज़ पम्फ्री", "अमीर व अति-स्नेही मालकिन", listOf("धनी", "भावुक", "अति-लाड़ करने वाली"), "वे ट्रिकी से बेइंतहा प्यार करती हैं, लेकिन उनके अत्यधिक खिलाने ने ही उसे बीमार कर दिया था।", "Mrs. Pumphrey is wealthy and loving, though her over-indulgence nearly harms her pet.")
            ),
            scenes = listOf(
                s(1, "फूला हुआ बेचारा ट्रिकी", "Overfed Tricki", "केक और चॉकलेट खाकर छोटा ट्रिकी एक फूले हुए सॉसेज जैसा हो गया है और चल नहीं पा रहा!", "Tricki", "Mrs. Pumphrey", CartoonSetting.HOME_GARDEN, CartoonMood.THOUGHTFUL, "Unhealthy Diet"),
                s(2, "क्लीनिक में सिर्फ पानी और खेल", "Water & Exercise Cure", "डॉ. हैरियट के क्लीनिक में दो दिन पानी पीने के बाद ट्रिकी ग्रेहाउंड 'जो' के साथ दौड़ने लगा!", "Dr. Herriot", "Joe", CartoonSetting.HOME_GARDEN, CartoonMood.HAPPY, "Play Recovery"),
                s(3, "अंडे और वाइन की दावत", "Staff Feast", "मिसेज़ पम्फ्री रोज़ अंडे और वाइन भेज रही हैं—डॉ. हैरियट और ट्रिस्टन की तो दावत हो गई!", "Dr. Herriot", "Tristan", CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Funny Feast"),
                s(4, "फुर्तीला ट्रिकी वापस घर", "Triumph of Surgery", "15 दिन बाद ट्रिकी छलाँग लगाकर मालकिन की गोद में आ गया—संतुलित आहार ही असली डॉक्टर है!", "Mrs. Pumphrey", "Imran Sir", CartoonSetting.HOME_GARDEN, CartoonMood.INSPIRING, "Healthy Moral")
            ),
            words = listOf(
                w("Sausage", "noun", "Minced meat packed in a tube shape", "मोटा गोल टुकड़ा", "Tricki looked like a bloated sausage with a leg at each corner."),
                w("Rheumy", "adj", "Watery and inflamed eyes", "पानी भरी धुंधली आँखें", "His eyes were bloodshot and rheumy."),
                w("Fortnight", "noun", "A period of two weeks", "पंद्रह दिन / पखवाड़ा", "Tricki stayed at the surgery for a fortnight."),
                w("Scrimmage", "noun", "Playful rough struggle", "धक्का-मुक्की / खेल की छीना-झपटी", "He enjoyed being bowled over in every scrimmage.")
            ),
            facts = listOf(
                f("For how many days was Tricki given no food at the surgery?", "Two days", listOf("Five days", "Seven days", "Ten days"), "अस्पताल में पहले दो दिन ट्रिकी को भोजन नहीं, केवल भरपूर पानी दिया गया।")
            )
        ),

        spec(
            id = "c10_fp_2",
            teachingHi = "रस्किन बॉन्ड की यह कहानी साबित करती है कि विश्वास और शिक्षा एक चोर का हृदय भी बदल सकते हैं। 15 वर्षीय चोर हरि सिंह दयालु लेखक अनिल का काम सँभालता है। अनिल उसे पढ़ना-लिखना सिखाता है। एक रात हरि 600 रुपये चुराकर स्टेशन भागता है, पर अनिल के विश्वास और शिक्षा से बड़ा आदमी बनने की चाह उसे वापस ले आती है!",
            paragraphs = listOf(
                p(1, "हरि सिंह का अनिल से मिलना", "Fifteen-year-old thief Hari Singh flattered young writer Anil and offered to cook for him.", "कुश्ती मैच के पास हरि सिंह ने मीठी बातों से अनिल का विश्वास जीता। खाना पकाना न जानने पर भी अनिल ने उसे रखा और पढ़ना-लिखना सिखाना शुरू किया।", "सच्ची दया अजनबी में भी उम्मीद जगाती है।"),
                p(2, "600 रुपये की चोरी और स्टेशन पर दुविधा", "One night Hari stole 600 rupees from under Anil's mattress and rushed to catch the Lucknow Express.", "जब अनिल को एक किताब के लिए 600 रुपये मिले, तो हरि ने रात में पैसे चुरा लिए। पर स्टेशन पर ट्रेन सामने होने के बावजूद उसके कदम रुक गए!", "चोरी की रकम पल भर की है, पर शिक्षा जीवन भर की पूँजी है।"),
                p(3, "शिक्षा के लिए वापसी और अनिल की मौन क्षमा", "Remembering that education could make him a respected man, Hari returned the damp notes; Anil forgave him silently.", "बारिश में भीगते हुए हरि वापस आकर गद्दे के नीचे पैसे रख देता है। सुबह अनिल गीले नोट से सब जान जाते हैं, फिर भी बिना कुछ कहे हरि को 50 रुपये और पढ़ाने का वादा देते हैं!", "क्षमा और विश्वास इंसान को अंदर से बदल देते हैं।")
            ),
            characters = listOf(
                c("Hari Singh", "हरि सिंह (15 वर्ष)", "सुधार की राह पर चला युवा चोर", listOf("चतुर", "ज्ञान का भूखा", "परिवर्तित हृदय"), "चोरी में माहिर होने के बावजूद शिक्षा के प्रति आकर्षण और अनिल के विश्वास ने हरि को ईमानदारी की ओर मोड़ दिया।", "Hari Singh is a clever 15-year-old thief whose desire for education and respect transforms him."),
                c("Anil", "अनिल (25 वर्ष)", "दयालु व उदार लेखक", listOf("सरल", "विश्वास करने वाला", "क्षमाशील"), "अनिल स्वयं कम कमाते हैं, पर हरि को पढ़ाना सिखाते हैं और उसकी चोरी जानकर भी उसे सुधरने का मौका देते हैं।", "Anil is a trusting, compassionate writer whose quiet forgiveness reforms Hari Singh.")
            ),
            scenes = listOf(
                s(1, "कुश्ती के मैदान में मुलाकात", "Meeting Anil", "15 साल का चालाक हरि सिंह सीधे-सादे लेखक अनिल से दोस्ती करके उसके घर रहने लगा!", "Hari Singh", "Anil", CartoonSetting.CITY_MARKET, CartoonMood.HAPPY, "New Job"),
                s(2, "आधी रात 600 रुपये की चोरी", "Midnight Theft", "सोते हुए अनिल के गद्दे के नीचे से हरि ने 600 रुपये निकाल लिए और चुपचाप स्टेशन की ओर दौड़ा!", "Hari Singh", "Anil", CartoonSetting.HOME_GARDEN, CartoonMood.DRAMATIC, "Stealing Cash"),
                s(3, "बारिश में मन का परिवर्तन", "Choosing Education", "लखनऊ एक्सप्रेस सामने है, पर हरि सोच रहा है—अगर पढ़ा-लिखा तो 600 से कहीं बड़ा आदमी बनूँगा!", "Hari Singh", "Rain", CartoonSetting.CITY_MARKET, CartoonMood.THOUGHTFUL, "Heart Change"),
                s(4, "गीला नोट और मौन क्षमा", "Quiet Forgiveness", "सुबह गीला 50 का नोट देखकर भी अनिल मुस्कुराए—आज से हम पूरे वाक्य लिखना सीखेंगे!", "Anil", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Trust Wins")
            ),
            words = listOf(
                w("Flattery", "noun", "Excessive insincere praise", "चापलूसी", "A little flattery helps in making friends."),
                w("Queer", "adj", "Strange / unusual", "अजीब / विचित्र", "Anil made money in a queer way."),
                w("Unlined", "adj", "Smooth, without wrinkles of worry", "बिना शिकन वाला / निश्चिंत", "Anil's face was clear and unlined."),
                w("Spirits", "noun", "Mood or enthusiasm", "मनोबल / उत्साह", "His spirits rose when Anil smiled warmly.")
            ),
            facts = listOf(
                f("How much money did Anil give Hari the next morning?", "A fifty-rupee note", listOf("A hundred-rupee note", "Twenty rupees", "Ten rupees"), "सुबह अनिल ने हरि को पचास रुपये का गीला नोट दिया और नियमित वेतन का वादा किया।")
            )
        ),

        spec(
            id = "c10_fp_7",
            teachingHi = "गॉय डी मोपासां की यह कहानी दिखावे और असंतोष के खतरनाक परिणाम को दिखाती है। मटिल्डा अपनी गरीबी से हमेशा दुःखी रहती है। एक बड़े समारोह में जाने के लिए वह सहेली मैडम फॉरेस्टियर से हीरे का हार उधार लेती है और उसे खो देती है। नया हार खरीदने के लिए वह और उसका पति 10 साल कर्ज में खटते हैं—बाद में पता चलता है कि असली हार तो सिर्फ 500 फ्रैंक का नकली हार था!",
            paragraphs = listOf(
                p(1, "मटिल्डा का विलासितापूर्ण सपना", "Matilda Loisel was pretty and charming but suffered incessantly because she was married to a petty clerk.", "मटिल्डा हमेशा महल, रेशमी वस्त्र और हीरे के गहनों के सपने देखती थी। जब पति को मंत्री की पार्टी का कार्ड मिला, तो उसने नए गाउन और उधार के हीरों का हार माँगा।", "चादर से बाहर पैर पसारना परेशानी को न्योता देता है।"),
                p(2, "हार खोना और दस वर्षों की घोर गरीबी", "After shining at the ball, Matilda lost the necklace; they borrowed 36,000 francs to buy a lookalike.", "पार्टी में सबने मटिल्डा की तारीफ की, पर घर लौटते ही हार खो गया! सच बताने के बजाय उन्होंने 36,000 फ्रैंक का भारी कर्ज़ लेकर वैसा ही हार लौटाया और 10 साल गरीबी में काटे।", "डर या दिखावे में सच छिपाना मुसीबत को सौ गुना बढ़ा देता है।"),
                p(3, "अंतिम झटका: 'वह तो नकली था!'", "Ten years later, Forestier revealed the lost necklace was only paste worth at most 500 francs.", "दस वर्ष बाद कर्ज़ चुकाकर बूढ़ी हो चुकी मटिल्डा ने सहेली को सच बताया। सहेली चौंककर बोली—अरे बेचारी मटिल्डा! मेरा हार तो नकली था, सिर्फ 500 फ्रैंक का!", "संतोष और ईमानदारी ही सुखी जीवन की असली कुंजी हैं।")
            ),
            characters = listOf(
                c("Matilda Loisel", "मटिल्डा लॉयज़ेल", "दिखावे में फँसी नायिका", listOf("महत्वाकांक्षी", "असंतुष्ट पहले", "परिश्रमी बाद में"), "शुरू में मटिल्डा अपनी स्थिति से असंतुष्ट रहती है, पर कर्ज़ चुकाने के लिए दस साल कठोर श्रम कर अपनी गलती की भारी कीमत चुकाती है।", "Matilda's vanity costs her ten years of youth, though she faces the resulting poverty with grit."),
                c("M. Loisel", "मिस्टर लॉयज़ेल", "समर्पित व ईमानदार पति", listOf("त्यागी", "पत्नी-प्रेमी", "परिश्रमी"), "पत्नी की खुशी के लिए वे अपने बचाए 400 फ्रैंक गाउन के लिए दे देते हैं और दस साल कर्ज़ चुकाने में जुटे रहते हैं।", "M. Loisel is a devoted, selfless husband who sacrifices all his savings and comfort for Matilda.")
            ),
            scenes = listOf(
                s(1, "पार्टी के लिए उधार का हार", "Borrowing the Necklace", "मटिल्डा अपनी अमीर सहेली फॉरेस्टियर के संदूक से चमकता हुआ हीरे का हार उधार लेती है!", "Matilda", "Mme Forestier", CartoonSetting.ROYAL_PALACE, CartoonMood.HAPPY, "Diamond Borrow"),
                s(2, "ओह! हार खो गया!", "The Necklace is Lost", "मंत्री की पार्टी के बाद घर के आईने के सामने देखती है—गले में हार ही नहीं है! सब ढूँढ रहे हैं!", "Matilda", "M. Loisel", CartoonSetting.HOME_GARDEN, CartoonMood.DRAMATIC, "Missing Gem"),
                s(3, "कर्ज़ चुकाने के 10 कठिन साल", "Ten Years of Toil", "36,000 फ्रैंक का कर्ज़ चुकाने के लिए दोनों छोटे कमरे में रहे और दिन-रात मेहनत की!", "Matilda", "M. Loisel", CartoonSetting.CITY_MARKET, CartoonMood.THOUGHTFUL, "Hard Years"),
                s(4, "500 फ्रैंक का नकली हार!", "Shocking Truth", "फॉरेस्टियर बोली—वह तो नकली काँच का हार था! बच्चों, कभी झूठा दिखावा न करें और सच बोलें!", "Mme Forestier", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Honesty Moral")
            ),
            words = listOf(
                w("Incessantly", "adv", "Continuously without stopping", "लगातार / निरंतर", "She suffered incessantly from modest living."),
                w("Dismay", "noun", "Sudden shock and fear", "निराशा / घबराहट", "Her husband looked at her in dismay."),
                w("Ruinous", "adj", "Disastrous / financially destructive", "बर्बाद करने वाला", "Loisel took ruinous obligations from usurers."),
                w("Paste", "noun", "Imitation glass gem", "नकली हीरा / काँच", "Mine were false—only paste worth 500 francs!")
            ),
            facts = listOf(
                f("How much did M. Loisel have saved for buying a gun?", "400 francs", listOf("500 francs", "36,000 francs", "18,000 francs"), "मिस्टर लॉयज़ेल ने बंदूक खरीदने के लिए 400 फ्रैंक बचा रखे थे, जो उन्होंने गाउन के लिए दे दिए।")
            )
        ),

        spec(
            id = "c10_fp_8",
            teachingHi = "के.ए. अब्बास की यह सशक्त कहानी बालिका शिक्षा और आत्मसम्मान की विजय को दर्शाती है। चेचक के दाग और हकलाने के कारण सबको मूर्ख लगने वाली 'भोली' (सुलेखा) को जब उसकी दयालु शिक्षिका का स्नेह मिलता है, तो वह आत्मविश्वासी बन जाती है। विवाह मंडप में जब लालची दूल्हा 5,000 रुपये दहेज माँगता है, तो भोली निडर होकर शादी से इनकार कर देती है!",
            paragraphs = listOf(
                p(1, "सुलेखा का 'भोली' बनना और उपेक्षा", "Sulekha suffered brain injury in infancy and smallpox pockmarks, earning the nickname Bholi.", "बचपन में चारपाई से गिरने और दो वर्ष की उम्र में चेचक के दाग के कारण घर वाले सुलेखा को 'भोली' (सीधी-मूर्ख) समझकर उपेक्षित रखते थे।", "परिवार की उपेक्षा बच्चे का आत्मविश्वास तोड़ सकती है।"),
                p(2, "स्कूल शिक्षिका का जादुई स्नेह", "At school, a gentle teacher encouraged Bholi kindly, filling her heart with new hope.", "गाँव में स्कूल खुलने पर भोली को वहाँ भेजा गया। उसकी शिक्षिका ने पहली बार उससे प्यार से बात की और कहा कि पढ़-लिखकर वह किसी के भी बराबर बोल सकेगी।", "सच्ची शिक्षा और गुरु का स्नेह व्यक्तित्व को बदल देता है।"),
                p(3, "दहेज के लोभी को करारा जवाब", "At the wedding, Bishamber demanded 5,000 rupees dowry; Bholi threw the garland into the fire and refused.", "सालों बाद जब बूढ़ा बिशंभर भोली के दाग देख पिता रामलाल से 5,000 रुपये दहेज माँगता है, तो शिक्षित भोली बिना हकलाए कहती है—मैं इस नीच लालची से शादी नहीं करूँगी!", "शिक्षा लड़कियों को अन्याय व दहेज के विरुद्ध खड़े होने की शक्ति देती है।")
            ),
            characters = listOf(
                c("Bholi (Sulekha)", "भोली (सुलेखा)", "शिक्षा से सशक्त बनी आत्मविश्वासी युवती", listOf("शुरू में संकोची", "मेहनती छात्रा", "निडर व स्वाभिमानी"), "शिक्षिका के प्रोत्साहन से सुलेखा का डर और हकलाना दूर हो गया और वह माता-पिता के बुढ़ापे का सहारा बन गई।", "Bholi transforms from a timid stammering child into a fearless, educated woman who rejects dowry."),
                c("Bholi's Teacher", "भोली की शिक्षिका", "जीवन बदलने वाली आदर्श गुरु", listOf("करुणामय", "धैर्यवान", "प्रेरणास्रोत"), "उन्होंने भोली में छिपी क्षमता को पहचानकर उसे आत्मविश्वास दिया।", "Bholi's teacher is an empathetic mentor whose kindness awakens Bholi's self-worth.")
            ),
            scenes = listOf(
                s(1, "डरी-सहमी नन्ही भोली", "Timid Bholi", "चेचक के दाग और हकलाने की वजह से सब सुलेखा को 'भोली' कहकर चिढ़ाते हैं और स्कूल भेज देते हैं।", "Bholi", "Ramlal", CartoonSetting.HOME_GARDEN, CartoonMood.THOUGHTFUL, "Childhood Neglect"),
                s(2, "शिक्षिका का स्नेहभरा हाथ", "Kind Schoolteacher", "स्कूल में मैडम ने प्यार से कहा—अपना नाम बोलो सुलेखा! तुम्हारी आवाज़ कोयल जैसी हो जाएगी!", "Teacher", "Bholi", CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Confidence Born"),
                s(3, "मंडप में दहेज का लालच", "5,000 Rupees Dowry", "दूल्हा बिशंभर दाग देखकर बोला—5,000 रुपये दो वरना बारात वापस ले जाऊँगा! रामलाल लाचार रो पड़े!", "Bishamber", "Ramlal", CartoonSetting.ROYAL_PALACE, CartoonMood.DRAMATIC, "Dowry Demand"),
                s(4, "निडर सुलेखा का ऐतिहासिक निर्णय", "Rejecting Greed", "भोली ने माला फेंक दी—पिताजी, पैसे वापस लीजिए! मैं इसी स्कूल में पढ़ाऊँगी! शिक्षा ज़िंदाबाद!", "Sulekha", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Empowerment")
            ),
            words = listOf(
                w("Numberdar", "noun", "Village headman / revenue official", "गाँव का नंबरदार / मुखिया", "Ramlal was the village Numberdar."),
                w("Stammered", "verb", "Spoke haltingly repeating sounds", "हकलाना", "Because she stammered, other children mimicked her."),
                w("Benevolent", "adj", "Kind and well-meaning", "दयालु / स्नेही", "The teacher's soft, soothing voice felt benevolent."),
                w("Triumphant", "adj", "Showing proud victory", "विजयी / गर्वभरा", "A light of triumphant satisfaction shone in the teacher's eyes.")
            ),
            facts = listOf(
                f("Who persuaded Ramlal to send his daughters to the new primary school?", "The Tehsildar", listOf("Bishamber Nath", "The Postman", "His eldest son"), "तहसीलदार साहब ने नंबरदार रामलाल से अपनी बेटियों को स्कूल भेजने को कहा था।")
            )
        )
    ).associateBy { it.chapterId } + Class10MissingChapters.specs + Class10PoemsCurriculum.specs

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
}
