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

object Class12MissingChapters {

    val chapters: List<Chapter> = listOf(
        // --- FLAMINGO PROSE (4 missing) ---
        makeProseChapter(
            id = "c12_fl_4",
            classLevel = 12,
            bookName = "Flamingo",
            chapterNumber = 4,
            category = "Prose",
            title = "The Rattrap",
            titleHi = "चूहेदानी (द रैटट्रैप)",
            author = "Selma Lagerlof",
            summaryEn = "A homeless Swedish rattrap peddler views the whole world as a giant rattrap tempting people with riches as bait. After stealing thirty kronor from a lonely crofter, he takes shelter at Ramsjo Ironworks and is invited home by Edla Willmansson—whose genuine kindness and trust awaken his innate human goodness.",
            summaryHi = "स्वीडन का एक गरीब चूहेदानी बेचने वाला फेरीवाला पूरी दुनिया को एक बड़ी चूहेदानी मानता है जो धन-दौलत का चारा डालकर लोगों को फँसाती है। बूढ़े किसान के 30 क्रोनर चुराकर भागते हुए वह रैमजो आयरनमिल में रुकता है जहाँ एडला विलमानसन की करुणा और सम्मान उसका हृदय परिवर्तन कर देते हैं।",
            hindiExplanation = "घूम-घूमकर तार की चूहेदानियाँ बेचने वाला एक फटेहाल फेरीवाला एक दिन बूढ़े क्रॉफ्टर (किसान) के घर रुकता है और दयालु मेज़बान के 30 क्रोनर चुरा लेता है। जंगल में भटकते हुए उसे लगता है कि वह खुद दुनिया की चूहेदानी में फँस गया! ठंड से बचने के लिए वह रैमजो लोहे की भट्टी में सोता है, जहाँ मालिक (Ironmaster) उसे पुराना साथी कैप्टन वॉन स्टाले समझ लेते हैं। उनकी बेटी एडला असली सच जानकर भी क्रिसमस की शाम उसे सम्मान से रोकती है। इस निस्वार्थ प्रेम से पिघलकर वह चोर 30 क्रोनर और एक छोटी चूहेदानी क्रिसमस उपहार के रूप में लौटा जाता है!",
            themeEn = "Innate goodness inside every human being can be awakened through compassion, dignity, and love.",
            themeHi = "हर इंसान में अच्छाई छिपी होती है, जिसे प्रेम, दया और सम्मान देकर जगाया जा सकता है।",
            messageHi = "लालच के चारे से बचें और गलतियाँ करने वालों को भी करुणा व सुधार का अवसर दें।",
            words = listOf(
                w("Peddler", "noun", "Person travelling from place to place selling small goods", "फेरीवाला", "The vagabond peddler sold small wire rattraps."),
                w("Bait", "noun", "Food or temptation placed to trap someone", "चारा / प्रलोभन", "Riches, joys, and shelter are the world's tempting bait."),
                w("Crofter", "noun", "Tenant farmer working on a small farm", "छोटा किसान", "The lonely old crofter welcomed the peddler warmly."),
                w("Incredulous", "adj", "Unwilling or unable to believe", "अविश्वासी / हैरान", "The peddler stared at the thirty kronor notes."),
                w("Compassion", "noun", "Sympathetic concern for others' suffering", "करुणा / सहानुभूति", "Edla's compassion transformed the thief into a dignified Captain.")
            ),
            matchPairs = listOf(
                MatchPair("The Peddler", "Signed letter as Captain von Stahle"),
                MatchPair("Old Crofter", "Robbed of thirty kronor"),
                MatchPair("Ramsjo Ironworks", "Forge where Ironmaster found him"),
                MatchPair("Edla Willmansson", "Persuaded father to keep guest for Christmas")
            ),
            extract1 = ExtractSpec(
                extractText = "“The whole world with its lands and seas, its cities and villages was nothing but a big rattrap.”",
                promptEn = "Why did the peddler compare the world to a giant rattrap?",
                promptHi = "फेरीवाले ने पूरी दुनिया की तुलना एक विशाल चूहेदानी से क्यों की?",
                answerEn = "Because just as cheese and pork lure rats into a trap, worldly riches, shelter, and joys lure humans into trouble and greed.",
                answerHi = "क्योंकि जैसे पनीर या चारे से चूहा फँसता है, वैसे ही धन, सुख और ऐश्वर्य का लालच इंसान को मुसीबतों में फँसा देता है।"
            ),
            extract2 = ExtractSpec(
                extractText = "“Since you have been so nice to me all day long, as if I was a captain, I want to be nice to you, in return...”",
                promptEn = "How did Edla's kindness bring out the peddler's honourable self?",
                promptHi = "एडला के स्नेहपूर्ण व्यवहार ने फेरीवाले के भीतर की ईमानदारी को कैसे जगाया?",
                answerEn = "Because Edla treated him with real dignity even after knowing he wasn't a real captain, inspiring him to return the stolen 30 kronor and behave like a true gentleman.",
                answerHi = "एडला ने सच जानकर भी उसे एक कैप्टन जैसा सम्मान व क्रिसमस की शांति दी, जिससे प्रेरित होकर उसने चोरी के 30 क्रोनर वापस कर दिए।"
            ),
            pyqPromptEn = "Why did the peddler sign himself as 'Captain von Stahle' at the end of 'The Rattrap'?",
            pyqPromptHi = "कहानी के अंत में फेरीवाले ने पत्र पर 'कैप्टन वॉन स्टाले' के रूप में हस्ताक्षर क्यों किए?",
            pyqAnswerEn = "Edla's unconditional respect raised him to the moral dignity of a true Captain, giving him the strength to rise above his thieving past and clear himself.",
            pyqAnswerHi = "एडला ने उसे सच्चे कैप्टन की तरह सम्मान दिया था, जिससे प्रेरित होकर वह अपनी पुरानी बुरी आदतों से ऊपर उठा और एक सज्जन की तरह 30 क्रोनर लौटाए।",
            mcq1Prompt = "How much money did the old crofter boast of earning from his cow and lose to the peddler?",
            mcq1Options = listOf("Thirty kronor", "Fifty dollars", "Ten pounds", "One hundred francs"),
            mcq1Correct = 0,
            mcq1Hi = "बूढ़े क्रॉफ्टर ने अपनी गाय के दूध से 30 क्रोनर (thirty kronor) कमाए थे जो फेरीवाले ने चुरा लिए।",
            mcq2Prompt = "What Christmas gift did the peddler leave behind for Edla Willmansson?",
            mcq2Options = listOf("A small rattrap, thirty kronor to return to the crofter, and a thank-you letter", "A gold watch", "A silver ring", "A warm coat"),
            mcq2Correct = 0,
            mcq2Hi = "उसने एडला के लिए क्रिसमस उपहार में एक छोटी चूहेदानी, 30 क्रोनर और 'कैप्टन वॉन स्टाले' नाम से धन्यवाद पत्र छोड़ा।"
        ),
        makeProseChapter(
            id = "c12_fl_6",
            classLevel = 12,
            bookName = "Flamingo",
            chapterNumber = 6,
            category = "Prose",
            title = "Poets and Pancakes",
            titleHi = "कवि और पैनकेक",
            author = "Asokamitran",
            summaryEn = "A humorous yet sharp insider memoir of Gemini Studios in Madras during the 1940s–50s. Asokamitran depicts the makeup department's 'Pancake' cream, the strict office boy, versatile Subbu, the quiet Legal Adviser, the Moral Re-Armament Army visit, and the mystery of English poet Stephen Spender.",
            summaryHi = "अशोकमित्रन के हास्यपूर्ण संस्मरण में मद्रास के प्रसिद्ध 'जेमिनी स्टूडियो' की झलक है—मेकअप रूम का 'पैनकेक' मेकअप, हताश ऑफिस बॉय, हरफनमौला सुब्बू, कानूनी सलाहकार, एमआरए (MRA) नाटक मंडली और अंग्रेज़ कवि स्टीफन स्पेंडर के रहस्यमयी आगमन की रोचक कहानी।",
            hindiExplanation = "अशोकमित्रन जेमिनी स्टूडियो में अखबारों की कटिंग फाइल में चिपकाने का काम करते थे। मेकअप विभाग में 'पैनकेक' ब्रांड का मेकअप ट्रक भर-भरकर आता था। 40 साल का ऑफिस बॉय अपनी नाकामी का दोष चालाक, मिलनसार और सर्वगुण संपन्न 'कोतमंगलम सुब्बू' को देता था। स्टूडियो में कभी कम्युनिस्ट विरोधी MRA समूह आया और कभी अंग्रेज़ संपादक-कवि स्टीफन स्पेंडर आए, जिनका भाषण भाषाई अंतर के कारण कोई नहीं समझ पाया। सालों बाद लेखक ने 'द एनकाउंटर' पत्रिका और 'द गॉड दैट फेल्ड' पुस्तक पढ़कर स्पेंडर को पहचाना!",
            themeEn = "Behind cinema glamour lie ordinary human ambitions, mild jealousies, political undercurrents, and unexpected literary links.",
            themeHi = "फिल्मी चकाचौंध के पीछे सामान्य मानवीय महत्वाकांक्षाएँ, हल्की ईर्ष्या, विचारधाराएँ और अनपेक्षित साहित्यिक जुड़ाव छिपे होते हैं।",
            messageHi = "हास्य और शांत अवलोकन से हम हर कार्यस्थल की विविधताओं को समझ सकते हैं।",
            words = listOf(
                w("Pancake", "noun", "Popular theatrical greasepaint makeup brand", "चेहरे का मेकअप (पैनकेक ब्रांड)", "Gemini Studios bought truckloads of Pancake."),
                w("Subservient", "adj", "Excessively obedient or compliant", "अत्यधिक आज्ञाकारी / चापलूस", "Subbu was cheerful yet deeply loyal to The Boss."),
                w("Sycophant", "noun", "Flatterer seeking personal gain", "चापलूस", "Critics unfairly branded Subbu a sycophant."),
                w("Incandescent", "adj", "Emitting bright light / passionately glowing", "चमकदार / तेज़ रोशनी वाला", "The makeup room glowed under incandescent lights."),
                w("Baffled", "verb", "Totally confused or puzzled", "भौंचक्का / उलझन में", "The Gemini staff remained baffled by Spender's English accent.")
            ),
            matchPairs = listOf(
                MatchPair("Pancake", "Makeup material ordered in truckloads"),
                MatchPair("Kothamangalam Subbu", "No. 2 at Gemini Studios, tailor-made for films"),
                MatchPair("Stephen Spender", "Editor of 'The Encounter' who visited"),
                MatchPair("S.S. Vasan", "Founder-Boss of Gemini Studios")
            ),
            extract1 = ExtractSpec(
                extractText = "“His success in films overshadowed and dwarfed his literary achievements—or so his critics felt.”",
                promptEn = "Who is being praised here and what were his remarkable talents?",
                promptHi = "यहाँ किसकी प्रशंसा की जा रही है और उनकी प्रमुख प्रतिभाएँ क्या थीं?",
                answerEn = "Kothamangalam Subbu, the versatile No. 2 at Gemini Studios, who excelled as a film ideator, actor, novelist ('Thillana Mohanambal'), and generous host.",
                answerHi = "जेमिनी स्टूडियो के नंबर-2 कोतमंगलम सुब्बू की, जो फिल्म लेखन, अभिनय, उपन्यास ('थिल्लाना मोहनम्बल') व उदारता में निपुण थे।"
            ),
            extract2 = ExtractSpec(
                extractText = "“He was an English poet... What was he doing in a film studio which made Tamil films for the simplest sort of people?”",
                promptEn = "How did Asokamitran years later discover the real identity of the English visitor?",
                promptHi = "वर्षों बाद अशोकमित्रन को उस अंग्रेज़ अतिथि की असली पहचान कैसे पता चली?",
                answerEn = "When checking the editor of 'The Encounter' at British Council Library and buying 'The God That Failed', he recognized Stephen Spender's name.",
                answerHi = "ब्रिटिश काउंसिल पुस्तकालय में 'द एनकाउंटर' पत्रिका के संपादक तथा 'द गॉड दैट फेल्ड' पुस्तक देखकर उन्हें पता चला कि वे कवि स्टीफन स्पेंडर थे।"
            ),
            pyqPromptEn = "Why was the Legal Adviser at Gemini Studios ironically referred to as 'the opposite'?",
            pyqPromptHi = "जेमिनी स्टूडियो के कानूनी सलाहकार (Legal Adviser) को व्यंग्य से 'उल्टा' (the opposite) क्यों कहा जाता था?",
            pyqAnswerEn = "Instead of solving legal troubles calmly, he once ended a talented actress's career by playing back a tape of her angry outburst—acting more like a trouble-maker than adviser.",
            pyqAnswerHi = "समस्याएँ सुलझाने के बजाय उन्होंने एक बार एक होनहार अभिनेत्री का गुस्सा रिकॉर्ड कर उसे सुनाकर उसका करियर समाप्त कर दिया था।",
            mcq1Prompt = "Which brand name was used for the truckloads of makeup material bought by Gemini Studios?",
            mcq1Options = listOf("Pancake", "Lakme", "Max Factor", "Revlon"),
            mcq1Correct = 0,
            mcq1Hi = "जेमिनी स्टूडियो में ट्रक भरकर 'पैनकेक' (Pancake) नामक मेकअप सामग्री आती थी।",
            mcq2Prompt = "What was the title of the book Asokamitran bought for fifty paise that featured an essay by Stephen Spender?",
            mcq2Options = listOf("The God That Failed", "The Discovery", "My Experiments", "The Encounter"),
            mcq2Correct = 0,
            mcq2Hi = "मद्रास फुटपाथ पर पचास पैसे में खरीदी गई किताब 'द गॉड दैट फेल्ड' (The God That Failed) में स्टीफन स्पेंडर का निबंध था।"
        ),
        makeProseChapter(
            id = "c12_fl_7",
            classLevel = 12,
            bookName = "Flamingo",
            chapterNumber = 7,
            category = "Prose",
            title = "The Interview",
            titleHi = "साक्षात्कार (द इंटरव्यू)",
            author = "Christopher Silvester & Umberto Eco",
            summaryEn = "Part I by Christopher Silvester surveys contrasting views on journalism's famous genre—the Interview: celebrated by some as a supreme source of truth, yet despised by V.S. Naipaul, Rudyard Kipling, and Saul Bellow as an invasion of privacy. Part II presents an engaging interview with scholar-novelist Umberto Eco explaining 'empty spaces' (interstices) and the massive success of 'The Name of the Rose'.",
            summaryHi = "भाग 1 में क्रिस्टोफर सिल्वेस्टर बताते हैं कि पत्रकारिता में 'साक्षात्कार' को कुछ लोग सत्य जानने का श्रेष्ठ माध्यम मानते हैं, तो नायपॉल व किपलिंग जैसे लेखक इसे निजता का अतिक्रमण मानते हैं। भाग 2 में प्रसिद्ध विद्वान व उपन्यासकार अम्बर्टो इको से मुकुंद पद्मनाभन का रोचक साक्षात्कार है जिसमें इको 'खाली समय' (Interstices) और 'द नेम ऑफ द रोज़' की सफलता का रहस्य बताते हैं।",
            hindiExplanation = "130 वर्षों से साक्षात्कार पत्रकारिता का अभिन्न अंग है। रूडयार्ड किपलिंग इसे अनैतिक व अपराध तक कहते थे, तो एच.जी. वेल्स ने इसे कष्टदायक परीक्षा बताया—पर फिर भी वे खुद इंटरव्यू देते भी थे! दूसरे भाग में 'द हिंदू' के मुकुंद पद्मनाभन इतालवी प्रोफेसर अम्बर्टो इको से पूछते हैं कि वे इतनी सारी किताबें कैसे लिखते हैं? इको बताते हैं कि वे जीवन के छोटे-छोटे खाली अंतराल (Interstices—जैसे किसी की प्रतीक्षा करते समय) का उपयोग करते हैं और उनकी सभी रचनाओं के पीछे एक ही दार्शनिक उद्देश्य (शांति व अहिंसा) रहता है।",
            themeEn = "Interviews illuminate human minds despite privacy debates; mindful use of tiny moments yields extraordinary creativity.",
            themeHi = "निजता पर बहसों के बावजूद साक्षात्कार महान व्यक्तियों के विचारों को उजागर करते हैं; समय के छोटे-छोटे अंतरालों का सदुपयोग बड़ी रचनाएँ रचता है।",
            messageHi = "दिन के खाली मिनटों (Interstices) को बर्बाद न करें—यही छोटे पल बड़े लक्ष्यों की कुंजी हैं।",
            words = listOf(
                w("Intrusion", "noun", "Unwelcome interference in someone's privacy", "अतिक्रमण / दखलंदाजी", "Celebrities often see interviews as an unwarranted intrusion."),
                w("Interstices", "noun", "Tiny empty gaps or intervals of time/space", "खाली अंतराल / बीच का थोड़ा समय", "Umberto Eco works productively in the interstices of his day."),
                w("Semiotics", "noun", "Study of signs and symbols", "संकेत-विज्ञान", "Eco was globally famous for his academic work on semiotics."),
                w("Thesis", "noun", "Long academic research essay", "शोध-प्रबंध", "Even Eco's doctoral thesis told the story of his research."),
                w("Thumbprints", "noun", "Painful pressure or lasting imprint", "गला दबाने जैसा दबाव", "Saul Bellow compared interviews to thumbprints on his windpipe.")
            ),
            matchPairs = listOf(
                MatchPair("Rudyard Kipling", "Called interviews immoral and an assault"),
                MatchPair("Saul Bellow", "Felt interviews like thumbprints on windpipe"),
                MatchPair("Umberto Eco", "Used empty spaces called interstices"),
                MatchPair("The Name of the Rose", "Eco's medieval detective novel (10M+ sold)")
            ),
            extract1 = ExtractSpec(
                extractText = "“We have a lot of empty spaces in our lives. I call them interstices. Say you are coming over to my place... while waiting for your elevator I have already written an article!”",
                promptEn = "What are 'interstices' according to Umberto Eco, and how do they help him write so much?",
                promptHi = "अम्बर्टो इको के अनुसार 'इंटरस्टिसेस' (Interstices) क्या हैं और वे इनसे इतना अधिक कैसे लिख पाते हैं?",
                answerEn = "'Interstices' are the tiny empty gaps between scheduled tasks; instead of wasting those spare minutes waiting, Eco focuses and drafts articles.",
                answerHi = "दो कामों के बीच मिलने वाले छोटे-छोटे खाली समय को इको 'इंटरस्टिसेस' कहते हैं, जिनका सदुपयोग करके वे लेख लिख लेते हैं।"
            ),
            extract2 = ExtractSpec(
                extractText = "“It is a serious novel. It's a detective yarn at one level but it also delves into metaphysics, theology, and medieval history.”",
                promptEn = "Why did journalists' expectations fail regarding 'The Name of the Rose'?",
                promptHi = "'द नेम ऑफ द रोज़' उपन्यास के बारे में पत्रकारों का अनुमान गलत क्यों साबित हुआ?",
                answerEn = "Publishers expected only 3,000 copies to sell because of its difficult scholarly themes, yet over 10–15 million readers loved its gripping medieval mystery.",
                answerHi = "प्रकाशकों को लगा था कि गंभीर दर्शन व इतिहास के कारण किताब कम बिकेगी, पर इसकी 1 से 1.5 करोड़ प्रतियाँ बिकीं क्योंकि पाठकों को कठिन व अनूठा विषय भी पसंद आता है।"
            ),
            pyqPromptEn = "Why do many famous writers strongly dislike being interviewed?",
            pyqPromptHi = "कई प्रसिद्ध लेखक साक्षात्कार (Interview) दिए जाने को नापसंद क्यों करते हैं?",
            pyqAnswerEn = "Writers like V.S. Naipaul feel wounded by losing a part of themselves; Rudyard Kipling viewed it as a cowardly intrusion; Lewis Carroll had a horror of the interviewer; and Saul Bellow felt suffocated by constant probing.",
            pyqAnswerHi = "नायपॉल इसे स्वयं का कुछ अंश खोना मानते थे, किपलिंग इसे अनैतिक आक्रमण कहते थे, और सॉल बेलो को इसमें साँस रुकने जैसा दबाव महसूस होता था।",
            mcq1Prompt = "Who wrote the bestselling novel 'The Name of the Rose' and described himself as a university professor who writes novels on Sundays?",
            mcq1Options = listOf("Umberto Eco", "V.S. Naipaul", "Denis Brian", "H.G. Wells"),
            mcq1Correct = 0,
            mcq1Hi = "अम्बर्टो इको (Umberto Eco) ने स्वयं को विश्वविद्यालय का प्रोफेसर बताया जो रविवार को उपन्यास लिखते हैं।",
            mcq2Prompt = "Who interviewed Umberto Eco in Part II of 'The Interview'?",
            mcq2Options = listOf("Mukund Padmanabhan", "Christopher Silvester", "Rudyard Kipling", "Caroline Kipling"),
            mcq2Correct = 0,
            mcq2Hi = "'द हिंदू' के पत्रकार मुकुंद पद्मनाभन ने अम्बर्टो इको का साक्षात्कार लिया था।"
        ),
        makeProseChapter(
            id = "c12_fl_8",
            classLevel = 12,
            bookName = "Flamingo",
            chapterNumber = 8,
            category = "Prose",
            title = "Going Places",
            titleHi = "सपनों की उड़ान (गोइंग प्लेसेस)",
            author = "A.R. Barton",
            summaryEn = "Teenager Sophie from a working-class family escapes bleak reality through wild daydreams—wanting a glamorous boutique, actress fame, or fashion design—while practical friend Jansie warns they are 'earmarked for the biscuit factory'. Sophie invents a romantic meeting with Irish football star Danny Casey, confusing fantasy with reality until heartbreak waits alone by the canal.",
            summaryHi = "निम्न-मध्यमवर्गीय किशोरी सोफी अपनी कठोर वास्तविकता से बचने के लिए बड़े-बड़े दिवास्वप्न देखती है—जैसे बुटीक खोलना या अभिनेत्री बनना, जबकि उसकी व्यावहारिक सहेली जैन्सी जानती है कि उन्हें बिस्कुट फैक्ट्री में काम करना होगा। सोफी आयरिश फुटबॉल सितारे डैनी केसी से मिलने की काल्पनिक कहानी गढ़ती है और नहर किनारे उसकी प्रतीक्षा में निराश होती है।",
            hindiExplanation = "स्कूल से घर लौटते समय सोफी अमीर बुटीक व मैरी क्वांट जैसी फैशन डिजाइनर बनने के सपने देखती है। घर में पिता की सख्ती, माता का झुकता शरीर और छोटे भाई डेरेक की व्यस्तता वास्तविक गरीबी दिखाते हैं। सोफी अपने चुप रहने वाले बड़े भाई ज्यॉफ को बताती है कि वह आर्केड में मशहूर फुटबॉलर डैनी केसी से मिली और अगली शाम नहर किनारे मिलने वाली है! शनिवार को वह डैनी की राह देखती है, पर जब कोई नहीं आता तो उसे अकेले अपने टूटे हुए सपनों के साथ लौटना पड़ता है।",
            themeEn = "Adolescent hero-worship and escapist daydreaming clash painfully with socioeconomic reality.",
            themeHi = "किशोरावस्था का हीरो-वर्शिप (अंध-प्रशंसा) और दिवास्वप्न जब कठोर आर्थिक यथार्थ से टकराते हैं तो निराशा हाथ लगती है।",
            messageHi = "बड़े सपने देखें, पर उन्हें कल्पना के बजाय परिश्रम और व्यावहारिक योजना से पूरा करने का प्रयास करें।",
            words = listOf(
                w("Earmarked", "verb", "Designated or set aside for a fixed fate", "पहले से तय किया हुआ", "Jansie sighed that both girls were earmarked for the biscuit factory."),
                w("Incongruity", "noun", "Out-of-place mismatch", "असंगति / बेमेलपन", "There was incongruity between Sophie's silk dreams and her small kitchen."),
                w("Prodigy", "noun", "Exceptionally talented young person", "विलक्षण प्रतिभा वाला युवा", "Irish striker Danny Casey was hailed as a football prodigy."),
                w("Despondency", "noun", "Deep sadness from loss of hope", "निराशा / हताशा", "Waiting alone by the canal filled Sophie with sweet despondency."),
                w("Disdain", "noun", "Feeling that someone is unworthy of respect", "तिरस्कार / अवहेलना", "Sophie's father glared at her tall tales with disdain.")
            ),
            matchPairs = listOf(
                MatchPair("Sophie", "Daydreamer imagining meeting Danny Casey"),
                MatchPair("Jansie", "Practical friend mindful of reality"),
                MatchPair("Geoff", "Quiet apprentice mechanic brother"),
                MatchPair("Danny Casey", "Young Irish football prodigy")
            ),
            extract1 = ExtractSpec(
                extractText = "“Jansie, knowing they were both earmarked for the biscuit factory, became melancholy.”",
                promptEn = "How do Sophie and Jansie contrast in their outlook toward the future?",
                promptHi = "भविष्य के प्रति सोफी और जैन्सी के दृष्टिकोण में क्या अंतर है?",
                answerEn = "Sophie indulges in unrealistic fantasies of boutiques and glamour, while Jansie is grounded, realistic, and aware of their modest financial limits.",
                answerHi = "सोफी बुटीक व ग्लैमर के अवास्तविक सपनों में खोई रहती है, जबकि जैन्सी यथार्थवादी है और अपनी पारिवारिक सीमाओं को जानती है।"
            ),
            extract2 = ExtractSpec(
                extractText = "“She wished she hadn't told them. Now she had to face Geoff's silent disappointment and Jansie's questions.”",
                promptEn = "Why did Sophie suffer at the canal bench on Saturday evening?",
                promptHi = "शनिवार शाम नहर के किनारे बेंच पर सोफी को पीड़ा क्यों हुई?",
                answerEn = "Because Danny Casey naturally never appeared for the imaginary date she invented, forcing her to confront the painful gap between wishful fantasy and hard truth.",
                answerHi = "क्योंकि डैनी केसी के साथ मुलाकात केवल सोफी की कल्पना थी; नहर किनारे अकेले इंतज़ार में उसे अपने झूठ और यथार्थ की खाई का एहसास हुआ।"
            ),
            pyqPromptEn = "Why did Sophie confide her fantasies to her elder brother Geoff rather than her father?",
            pyqPromptHi = "सोफी अपनी कल्पनाएँ और मन की बातें पिता के बजाय अपने बड़े भाई ज्यॉफ से क्यों साझा करती थी?",
            pyqAnswerEn = "Geoff was silent, mysterious, and rode out to unknown parts of the city as an apprentice mechanic, symbolizing freedom; Sophie longed to enter his wider world unlike her critical, loud father.",
            pyqAnswerHi = "ज्यॉफ शांत और रहस्यमयी था जो मोटरसाइकिल से बाहरी दुनिया में जाता था; सोफी पिता की डाँट के बजाय भाई के विश्वास और आज़ाद संसार से जुड़ना चाहती थी।",
            mcq1Prompt = "Which country did young football sensation Danny Casey play for in 'Going Places'?",
            mcq1Options = listOf("Ireland", "Spain", "Brazil", "Germany"),
            mcq1Correct = 0,
            mcq1Hi = "फुटबॉल खिलाड़ी डैनी केसी आयरलैंड (Ireland) का युवा प्रतिभाशाली खिलाड़ी था।",
            mcq2Prompt = "What factory job did Jansie warn Sophie they were both destined for after school?",
            mcq2Options = listOf("A biscuit factory", "A shoe factory", "A glass workshop", "A textile mill"),
            mcq2Correct = 0,
            mcq2Hi = "जैन्सी जानती थी कि स्कूल के बाद उन दोनों के लिए 'बिस्कुट फैक्ट्री' (biscuit factory) का काम तय था।"
        ),

        // --- VISTAS SUPPLEMENTARY (4 missing) ---
        makeProseChapter(
            id = "c12_vi_2",
            classLevel = 12,
            bookName = "Vistas",
            chapterNumber = 2,
            category = "Supplementary",
            title = "The Tiger King",
            titleHi = "बाघ राजा (द टाइगर किंग)",
            author = "Kalki",
            summaryEn = "A sharp political satire on Maharaja Jilani Jung Jung Bahadur of Pratibandapuram. When astrologers prophesy his death by the hundredth tiger, he vows to kill 100 tigers—banning others from hunting and marrying purely for royal tiger populations. Ironically, after sparing a missed hundredth live tiger, a tiny wooden toy-tiger splinter kills the proud king!",
            summaryHi = "कल्कि की यह व्यंग्यात्मक कहानी प्रतिबंधपुरम के महाराजा जिलानी जंग जंग बहादुर की है। जन्म पर ज्योतिषियों ने भविष्यवाणी की कि उनकी मृत्यु 100वें बाघ से होगी। घमंडी राजा ने 99 बाघ मार डाले और 100वें बाघ पर गोली चलाकर बेहोश होने को ही मृत्यु मान लिया—पर अंततः अपने बेटे के लिए खरीदे लकड़ी के सस्ते बाघ की फांस से ही उनकी मृत्यु हो जाती है!",
            hindiExplanation = "10 दिन के शिशु राजकुमार ने चमत्कारिक ढंग से बोलकर पूछा—'बाघों को सावधान कर दो!' बड़े होकर राजा ने राज्य में बाघ शिकार पर प्रतिबंध लगाया और ब्रिटिश अफसर के साथ तस्वीर खिंचवाने की माँग ठुकराकर 3 लाख रुपये की हीरे की अंगूठियाँ भेजीं। 70 बाघ मारने के बाद उन्होंने अधिक बाघों वाले राज्य की राजकुमारी से शादी की! 99 के बाद 100वाँ बाघ बूढ़ा होने से दीवान मद्रास चिड़ियाघर से लाए। राजा की गोली चूक गई पर शोर से बाघ बेहोश हो गया। अंत में एक सस्ते लकड़ी के बाघ की कील राजा के हाथ में चुभकर संक्रमण कर देती है और ऑपरेशन में राजा की मृत्यु हो जाती है—यही 100वाँ बाघ निकला!",
            themeEn = "Arrogant rulers exploiting nature and twisting power cannot outsmart destiny or ironic justice.",
            themeHi = "सत्ता के मद में प्रकृति व जीवों का विनाश करने वाला घमंडी शासक अंततः नियति के व्यंग्य से नहीं बच सकता।",
            messageHi = "वन्यजीवों के प्रति क्रूरता व अंधा अहंकार हमेशा पतन का कारण बनता है।",
            words = listOf(
                w("Astrologers", "noun", "People predicting fate via stars", "ज्योतिषी", "Chief astrologer warned the king to beware of the hundredth tiger."),
                w("Proclamation", "noun", "Official royal public announcement", "शाही घोषणा", "The Maharaja issued a proclamation banning tiger hunting."),
                w("Bribe", "noun", "Gift given to influence an official", "रिश्वत", "Fifty diamond rings saved his throne from the British officer."),
                w("Suppurating", "verb", "Forming pus / getting badly infected", "मवाद पड़ना / संक्रमण फैलना", "The wooden splinter caused a suppurating sore on the king's hand."),
                w("Irony", "noun", "Contrast between expectation and outcome", "विडंबना / व्यंग्य", "A lifeless wooden toy tiger became the hundredth killer.")
            ),
            matchPairs = listOf(
                MatchPair("Pratibandapuram", "Kingdom of Maharaja Jung Jung Bahadur"),
                MatchPair("Fifty diamond rings", "Sent to Duraisani (cost 3 lakh rupees)"),
                MatchPair("Dewan", "Brought old tiger from People's Park Madras"),
                MatchPair("Wooden toy tiger", "Gifted on son's third birthday")
            ),
            extract1 = ExtractSpec(
                extractText = "“Let tigers beware!”",
                promptEn = "Who uttered these astonishing words and at what age?",
                promptHi = "ये हैरान करने वाले शब्द किसने और किस उम्र में बोले थे?",
                answerEn = "Ten-day-old infant prince Jilani Jung Jung Bahadur uttered these fearless words when astrologers predicted a tiger would cause his death.",
                answerHi = "केवल दस दिन के नवजात राजकुमार जिलानी जंग जंग बहादुर ने ज्योतिषियों की भविष्यवाणी सुनकर यह कहा।"
            ),
            extract2 = ExtractSpec(
                extractText = "“In that way the hundredth tiger took its final revenge upon the Tiger King.”",
                promptEn = "How did destiny fulfil the prophecy through a wooden toy tiger?",
                promptHi = "लकड़ी के बाघ के ज़रिए नियति की भविष्यवाणी कैसे पूरी हुई?",
                answerEn = "A tiny sliver from a roughly carved wooden toy tiger pierced the Maharaja's right hand while playing with his son, triggering a fatal infection despite three famous Madras surgeons operating.",
                answerHi = "बेटे के साथ खेलते समय अनगढ़ लकड़ी के बाघ की एक छोटी-सी फांस राजा के हाथ में चुभी, जिससे संक्रमण फैला और मद्रास के तीन बड़े सर्जन भी उन्हें नहीं बचा सके।"
            ),
            pyqPromptEn = "How did the Tiger King save his kingdom when a high-ranking British officer demanded to shoot a tiger?",
            pyqPromptHi = "एक बड़े ब्रिटिश अधिकारी द्वारा बाघ के शिकार की माँग करने पर टाइगर किंग ने अपना राज्य कैसे बचाया?",
            pyqAnswerEn = "He sent fifty sample diamond rings from a Calcutta jeweller to the British officer's wife (Duraisani), expecting her to pick one or two; she kept all fifty, costing three lakh rupees yet saving his throne.",
            pyqAnswerHi = "महाराजा ने कलकत्ता से पचास कीमती हीरे की अंगूठियाँ अफसर की पत्नी (दुराइसानी) को भेजीं। उन्होंने सभी 50 अंगूठियाँ रख लीं—तीन लाख रुपये खर्च हुए पर राजा का सिंहासन बच गया!",
            mcq1Prompt = "What caused the actual death of the Tiger King?",
            mcq1Options = listOf("An infection from a wooden toy tiger sliver", "A real Bengal tiger attack", "Snake bite", "Old age fever"),
            mcq1Correct = 0,
            mcq1Hi = "महाराजा की मृत्यु उनके बेटे के लकड़ी के खिलौने वाले बाघ की फांस से हुए संक्रमण के कारण हुई।",
            mcq2Prompt = "Why did the Maharaja decide to marry a princess from another state?",
            mcq2Options = listOf("To gain access to a kingdom with a large tiger population", "To learn French", "For gold mines", "To escape astrologers"),
            mcq2Correct = 0,
            mcq2Hi = "अपने राज्य में 70 बाघ मार चुकने के बाद उन्होंने ऐसे राज्य की राजकुमारी से विवाह किया जहाँ बाघों की संख्या अधिक थी।"
        ),
        makeProseChapter(
            id = "c12_vi_3",
            classLevel = 12,
            bookName = "Vistas",
            chapterNumber = 3,
            category = "Supplementary",
            title = "Journey to the End of the Earth",
            titleHi = "पृथ्वी के छोर तक की यात्रा",
            author = "Tishani Doshi",
            summaryEn = "Tishani Doshi travels to Antarctica aboard the Russian research vessel Akademik Shokalskiy as part of Geoff Green's 'Students on Ice' programme. Exploring untouched white landscapes, Gondwana geological history, phytoplankton sensitivity, and retreating glaciers reveals that saving small ecological links protects the entire planet.",
            summaryHi = "कवयित्री व लेखिका तिशानी दोशी ज्यॉफ ग्रीन के 'स्टूडेंट्स ऑन आइस' कार्यक्रम के तहत रूसी जहाज़ 'अकादमिक शोकाल्स्की' से अंटार्कटिका जाती हैं। 65 करोड़ वर्ष पुराने गोंडवाना महाद्वीप के इतिहास, फाइटोप्लांकटन सूक्ष्म जीवों और पिघलते ग्लेशियरों को देखकर वे समझती हैं कि छोटी चीज़ों की सुरक्षा से ही पृथ्वी बचेगी।",
            hindiExplanation = "मद्रास से 100 घंटे की यात्रा कर तिशानी दोशी अंटार्कटिका की बर्फीली शांति पर पहुँचती हैं। यहाँ पृथ्वी के अतीत, वर्तमान और भविष्य को देखा जा सकता है क्योंकि कभी भारत व अंटार्कटिका एक ही विशाल दक्षिणी महाद्वीप 'गोंडवाना' का हिस्सा थे। ज्यॉफ ग्रीन ने अमीर सेलिब्रिटीज के बजाय हाईस्कूल छात्रों को ले जाना चुना क्योंकि युवा नीति-निर्माता वास्तव में धरती को बचा सकते हैं। समुद्री पौधे 'फाइटोप्लांकटन' का उदाहरण सिखाता है—छोटी चीज़ों का ध्यान रखो, बड़ी अपने आप संभल जाएँगी!",
            themeEn = "Antarctica holds Earth's geological history and warns future leaders about climate change and ecological balance.",
            themeHi = "अंटार्कटिका पृथ्वी के भूवैज्ञानिक अतीत का संग्रहालय है और भावी पीढ़ी को जलवायु परिवर्तन से पृथ्वी को बचाने का संदेश देता है।",
            messageHi = "पृथ्वी की सूक्ष्म पारिस्थितिकी (जैसे फाइटोप्लांकटन व ग्लेशियर) का संरक्षण करें—यही मानव भविष्य की सुरक्षा है।",
            words = listOf(
                w("Gondwana", "noun", "Ancient supercontinent before continental drift", "प्राचीन महाद्वीप गोंडवाना", "650 million years ago Gondwana united India and Antarctica."),
                w("Phytoplankton", "noun", "Microscopic marine plants forming ocean food base", "सूक्ष्म समुद्री वनस्पति", "Depletion of ozone affects single-celled phytoplankton."),
                w("Ubiquitous", "adj", "Found everywhere at once", "सर्वव्यापी", "Silence was ubiquitous across the polar expanse."),
                w("Prognosis", "noun", "Forecast of likely future outcome", "पूर्वानुमान", "Melting ice shelves warn of a grim climate prognosis."),
                w("Blasé", "adj", "Unimpressed or indifferent due to familiarity", "उदासीन / बेपरवाह", "Students cannot stay blasé after witnessing collapsing glaciers.")
            ),
            matchPairs = listOf(
                MatchPair("Akademik Shokalskiy", "Russian research vessel"),
                MatchPair("Geoff Green", "Founded Students on Ice programme"),
                MatchPair("Gondwana", "Supercontinent 650 million years ago"),
                MatchPair("Phytoplankton", "Microscopic carbon-cycle base")
            ),
            extract1 = ExtractSpec(
                extractText = "“Take care of the small things and the big things will take care of themselves.”",
                promptEn = "Which Antarctic organism illustrates this ecological lesson in Tishani Doshi's essay?",
                promptHi = "तिशानी दोशी के निबंध में अंटार्कटिका का कौन-सा सूक्ष्म जीव इस पारिस्थितिक सीख को दर्शाता है?",
                answerEn = "Microscopic single-celled sea plants called phytoplankton nourish the entire Southern Ocean food chain and regulate global carbon; protecting them protects all larger marine life.",
                answerHi = "सूक्ष्म समुद्री वनस्पति 'फाइटोप्लांकटन' पूरे दक्षिणी महासागर की खाद्य श्रृंखला व कार्बन चक्र का आधार है—इनकी रक्षा से ही संपूर्ण समुद्री जीवन सुरक्षित रहेगा।"
            ),
            extract2 = ExtractSpec(
                extractText = "“The rapid increase of human populations has left us battling with other species for limited resources...”",
                promptEn = "Why did Geoff Green shift from taking wealthy tourists to high-school students?",
                promptHi = "ज्यॉफ ग्रीन ने अमीर पर्यटकों के बजाय हाईस्कूल के छात्रों को अंटार्कटिका ले जाना क्यों शुरू किया?",
                answerEn = "Retired celebrities give very little back, whereas impressionable high-school students are future policy-makers ready to absorb, learn, and act against global warming.",
                answerHi = "क्योंकि बुजुर्ग सेलिब्रिटी केवल सैर करते थे, जबकि छात्र भविष्य के नीति-निर्माता हैं जो ग्लोबल वार्मिंग देख कर तुरंत धरती बचाने का संकल्प लेते हैं।"
            ),
            pyqPromptEn = "Why is Antarctica the ideal place to study Earth's past, present, and future?",
            pyqPromptHi = "पृथ्वी के अतीत, वर्तमान और भविष्य को समझने के लिए अंटार्कटिका सबसे उपयुक्त स्थान क्यों है?",
            pyqAnswerEn = "Antarctica holds half-million-year-old carbon records trapped inside ice cores (past), preserves pristine silence free of human habitation (present), and shows melting ice shelves warning of rising seas (future).",
            pyqAnswerHi = "अंटार्कटिका की बर्फ की परतों में लाखों साल पुराने कार्बन रिकॉर्ड (अतीत), मानव-रहित शुद्ध प्रकृति (वर्तमान) और पिघलते ग्लेशियरों द्वारा भविष्य के जलवायु संकट का स्पष्ट संकेत मौजूद है।",
            mcq1Prompt = "What was the name of the Russian research vessel carrying 'Students on Ice' to Antarctica?",
            mcq1Options = listOf("Akademik Shokalskiy", "Wavewalker", "Titanic II", "Arctic Star"),
            mcq1Correct = 0,
            mcq1Hi = "लेखिका रूसी शोध पोत 'अकादमिक शोकाल्स्की' (Akademik Shokalskiy) से अंटार्कटिका गई थीं।",
            mcq2Prompt = "What is the name of the gigantic ancient southern supercontinent that existed 650 million years ago?",
            mcq2Options = listOf("Gondwana", "Atlantis", "Eurasia", "Laurasia"),
            mcq2Correct = 0,
            mcq2Hi = "65 करोड़ वर्ष पहले भारत और अंटार्कटिका एक ही विशाल दक्षिणी महाद्वीप 'गोंडवाना' का हिस्सा थे।"
        ),
        makeProseChapter(
            id = "c12_vi_5",
            classLevel = 12,
            bookName = "Vistas",
            chapterNumber = 5,
            category = "Supplementary",
            title = "On the Face of It",
            titleHi = "पहली नज़र से परे (ऑन द फेस ऑफ इट)",
            author = "Susan Hill",
            summaryEn = "A touching play about a brief encounter between fourteen-year-old Derry, withdrawn and bitter over an acid-scarred face, and Mr. Lamb, an optimistic old man with a tin leg who lives joyfully in an open garden. Mr. Lamb teaches Derry to love life beyond physical appearances; even though Mr. Lamb falls fatally from a ladder, Derry returns bravely transformed.",
            summaryHi = "सुज़ैन हिल का यह संवेदनशील नाटक तेजाब से जले चेहरे के कारण समाज से कटे 14 वर्षीय डेरी और टिन के पैर वाले आशावादी बुजुर्ग श्री लैम्ब के संवाद पर आधारित है। श्री लैम्ब अपने खुले बगीचे में डेरी को हीनभावना से बाहर निकालकर जीवन से प्रेम करना सिखाते हैं। अंत में सीढ़ी से गिरकर श्री लैम्ब के चले जाने पर भी डेरी साहस के साथ वापस लौटता है।",
            hindiExplanation = "डेरी लोगों के घूरने व सहानुभूति भरे डर से बचने के लिए श्री लैम्ब के शांत बगीचे की दीवार कूदकर आता है। युद्ध में एक पैर खो चुके मिस्टर लैम्ब बच्चों को टॉफी व जेली देते हैं और कहते हैं कि जीवन में हर चीज़—जैसे 'ब्यूटी एंड द बीस्ट'—भीतर से देखी जाती है। वे डेरी को मधुमक्खियों का संगीत और खुले दरवाज़ों वाला घर दिखाते हैं। माँ के रोकने पर भी डेरी वापस श्री लैम्ब की मदद करने दौड़ता है, पर सेब तोड़ते समय सीढ़ी से गिरकर वे दम तोड़ देते हैं—लेकिन डेरी को जीवन जीने का साहस मिल चुका होता है!",
            themeEn = "True disability lies in negative attitude and isolation, not physical scars; empathy heals alienation.",
            themeHi = "असली विकलांगता शरीर के घावों में नहीं बल्कि नकारात्मक सोच व अलगाव में होती है; सहानुभूति और आशावाद हर पीड़ा को भर सकते हैं।",
            messageHi = "शारीरिक कमियों या लोगों की टिप्पणियों से न डरें—अपनी आंतरिक शक्ति से संसार का सामना करें।",
            words = listOf(
                w("Trespassing", "verb", "Entering someone's property without permission", "बिना अनुमति प्रवेश करना", "Derry climbed the wall thinking the garden was empty."),
                w("Scrap", "noun", "Small detached piece / discarded metal", "टुकड़ा", "Kids teased Mr. Lamb as 'Lamey-Lamb' for his tin leg."),
                w("Monstrous", "adj", "Frightfully ugly or cruel", "भयानक", "People stared only at Derry's scarred face calling it monstrous."),
                w("Peculiar", "adj", "Strange or unusual", "अनोखा / विचित्र", "Mr. Lamb shared peculiar wise stories in his garden."),
                w("Humming", "verb", "Making a low continuous musical sound", "गुनगुनाना", "Bees didn't buzz for Mr. Lamb—they hummed songs.")
            ),
            matchPairs = listOf(
                MatchPair("Derry (14 yrs)", "Withdrawn boy with acid-burnt cheek"),
                MatchPair("Mr. Lamb", "Optimistic old man with a tin leg"),
                MatchPair("Crab apples", "Used to make golden jelly"),
                MatchPair("Open gate & no curtains", "Symbol of welcoming life openly")
            ),
            extract1 = ExtractSpec(
                extractText = "“Why is one green, growing plant called a weed and another 'flower'? Where's the difference. It's all life... growing.”",
                promptEn = "What philosophy did Mr. Lamb teach Derry through weeds and flowers?",
                promptHi = "खरपतवार और फूलों के उदाहरण से श्री लैम्ब ने डेरी को क्या जीवन-दर्शन सिखाया?",
                answerEn = "Mr. Lamb taught that labels like 'ugly' or 'pretty' are merely shallow human opinions; every living being has equal value and right to thrive.",
                answerHi = "उन्होंने सिखाया कि सुंदर या बदसूरत केवल देखने वालों की सोच है; प्रकृति में हर जीवन समान और मूल्यवान है।"
            ),
            extract2 = ExtractSpec(
                extractText = "“You've got two arms, two legs and eyes and ears, you've got a tongue and a brain. You'll get on the way you want, like all the rest.”",
                promptEn = "How did Mr. Lamb restore Derry's lost self-confidence?",
                promptHi = "श्री लैम्ब ने डेरी का खोया हुआ आत्मविश्वास किस प्रकार जगाया?",
                answerEn = "By reminding Derry of all his intact abilities and urging him not to waste life hiding from whispers or caring about one scarred cheek.",
                answerHi = "उन्होंने डेरी को उसके स्वस्थ अंगों, बुद्धि व संभावनाओं की याद दिलाकर समझाया कि एक जले चेहरे के कारण दुनिया से डरकर जीना बंद नहीं करना चाहिए।"
            ),
            pyqPromptEn = "Why did Mr. Lamb keep the gate of his garden always open and put no curtains on his windows?",
            pyqPromptHi = "श्री लैम्ब अपने बगीचे का दरवाज़ा हमेशा खुला क्यों रखते थे और खिड़कियों पर पर्दे क्यों नहीं लगाते थे?",
            pyqAnswerEn = "He hated shutting things out or locking himself in; he welcomed sunlight, wind, darkness, and lonely visitors freely so he never felt isolated despite his tin leg.",
            pyqAnswerHi = "उन्हें प्रकाश, हवा व लोगों को बाहर रोकना पसंद नहीं था; वे अकेलेपन से दूर सबका खुला स्वागत करना चाहते थे।",
            mcq1Prompt = "How had half of Derry's face been burnt in his childhood?",
            mcq1Options = listOf("Acid fell down on one side of his face", "A bonfire accident", "Lightning strike", "Hot tea spill"),
            mcq1Correct = 0,
            mcq1Hi = "बचपन में तेजाब (Acid) गिरने से डेरी का एक तरफ का चेहरा जल गया था।",
            mcq2Prompt = "What happened to Mr. Lamb's real leg years ago?",
            mcq2Options = listOf("It was blown off in a war, replaced by a tin leg", "Broken in a cricket match", "Lost in a train crash", "Injured climbing an apple tree"),
            mcq2Correct = 0,
            mcq2Hi = "युद्ध में बम विस्फोट से उनका असली पैर चला गया था, जिसकी जगह टिन का पैर लगा था।"
        ),
        makeProseChapter(
            id = "c12_vi_6",
            classLevel = 12,
            bookName = "Vistas",
            chapterNumber = 6,
            category = "Supplementary",
            title = "Memories of Childhood",
            titleHi = "बचपन की यादें",
            author = "Zitkala-Sa & Bama",
            summaryEn = "Two powerful autobiographical excerpts depicting childhood oppression and resistance: Part I 'The Cutting of My Long Hair' shows Native American girl Zitkala-Sa fighting forced cultural assimilation at Carlisle Indian School, while Part II 'We Too Are Human Beings' shows Tamil Dalit writer Bama confronting untouchability and turning her brother Annan's advice into academic excellence.",
            summaryHi = "दो सशक्त आत्मकथात्मक अंश जो अन्याय के विरुद्ध प्रतिरोध दिखाते हैं—भाग 1 में मूल अमेरिकी लड़की ज़िटकाला-सा बोर्डिंग स्कूल में अपने लंबे बाल जबरन काटे जाने का कड़ा विरोध करती हैं। भाग 2 में तमिल लेखिका बामा बचपन में छुआछूत की पीड़ा देखती हैं और भाई अन्नन की सलाह से पढ़ाई में प्रथम आकर सम्मान अर्जित करती हैं।",
            hindiExplanation = "पहले भाग में ज़िटकाला-सा को ठंड, घंटी के कड़े नियमों (eating by formula) व पाश्चात्य ड्रेस से आघात पहुँचता है। उनकी जनजाति में केवल कायरों के बाल छोटे काटे जाते थे, इसलिए वे पलंग के नीचे छिपकर रोती-संघर्ष करती हैं, पर जबरन बाल काट दिए जाते हैं। दूसरे भाग में तीसरी कक्षा की बामा बाजार में देखती हैं कि एक बड़ा बुजुर्ग ज़मींदार को वड़ाई का पैकेट डोरी से लटकाकर बिना छुए दे रहा है! पहले उन्हें हँसी आई पर भाई अन्नन ने जब जातिगत अपमान समझाया और कहा कि शिक्षा ही इज्ज़त दिला सकती है, तो बामा मन लगाकर पढ़ीं और कक्षा में प्रथम आईं!",
            themeEn = "Marginalized children resist cultural erasure and caste humiliation through courage, dignity, and education.",
            themeHi = "अन्याय, सांस्कृतिक दमन और जातिगत भेदभाव का सबसे शक्तिशाली उत्तर साहस, आत्मसम्मान और उच्च शिक्षा है।",
            messageHi = "किसी भी भेदभाव के सामने हार न मानें—शिक्षा और कड़ी मेहनत से ही समाज में सच्चा सम्मान मिलता है।",
            words = listOf(
                w("Shingled", "adj", "Cut short close to the head like roof tiles", "बहुत छोटे काटे गए बाल", "Only cowards wore shingled hair in Zitkala-Sa's tribe."),
                w("Indignity", "noun", "Treatment causing shame or humiliation", "अपमान / तिरस्कार", "She resisted every indignity inflicted at the boarding school."),
                w("Untouchability", "noun", "Cruel caste-based social exclusion", "अस्पृश्यता / छुआछूत", "Annan explained the painful reality of untouchability to Bama."),
                w("Rebellion", "noun", "Open resistance against unfair authority", "विद्रोह / प्रतिरोध", "Zitkala-Sa refused to submit without scratching and fighting."),
                w("Infuriate", "verb", "Make extremely angry", "क्रोध से भर देना", "Watching the elder bow down infuriated young Bama.")
            ),
            matchPairs = listOf(
                MatchPair("Zitkala-Sa", "Fought cutting of her long braided hair"),
                MatchPair("Judewin", "Friend who warned Zitkala-Sa"),
                MatchPair("Bama", "Observed elder carrying vadais by string"),
                MatchPair("Annan", "Told Bama to study hard to earn respect")
            ),
            extract1 = ExtractSpec(
                extractText = "“I cried aloud, shaking my head all the while until I felt the cold blades of the scissors against my neck, and heard them gnaw off one of my thick braids.”",
                promptEn = "Why did Zitkala-Sa rebel fiercely against having her long hair cut?",
                promptHi = "ज़िटकाला-सा ने अपने लंबे बाल काटे जाने का इतना कड़ा विरोध क्यों किया?",
                answerEn = "Among her Sioux people, short or shingled hair was worn only by mourners or captured cowards; cutting her braids felt like crushing her pride, identity, and mother's teachings.",
                answerHi = "उनकी जनजाति में छोटे बाल केवल शोक मनाने वाले या युद्ध में पकड़े गए कायर रखते थे; बाल काटना उनकी संस्कृति व आत्मसम्मान को कुचलने जैसा था।"
            ),
            extract2 = ExtractSpec(
                extractText = "“The words that Annan spoke to me that day made a very deep impression on me. And I studied hard, with all my breath and being, in a frenzy almost.”",
                promptEn = "What life-changing advice did Annan give to his younger sister Bama?",
                promptHi = "अन्नन ने अपनी छोटी बहन बामा को जीवन बदल देने वाली क्या सलाह दी?",
                answerEn = "Annan advised Bama that because they were born into a marginalized caste, only studying with total dedication and standing first in class could throw off humiliation and bring people to respect her.",
                answerHi = "अन्नन ने समझाया कि सामाजिक भेदभाव को मिटाने का एकमात्र रास्ता मन लगाकर पढ़ाई में अव्वल आना है—ज्ञान व योग्यता से लोग स्वयं सम्मान के साथ जुड़ेंगे।"
            ),
            pyqPromptEn = "Compare how Zitkala-Sa and Bama respond to oppression despite coming from vastly different cultures.",
            pyqPromptHi = "अलग-अलग संस्कृतियों से होने के बावजूद ज़िटकाला-सा और बामा अन्याय के विरुद्ध किस प्रकार समान साहस दिखाती हैं?",
            pyqAnswerEn = "Both refuse silent submission: young Zitkala-Sa fights physically and later uses her pen to defend Native rights, while Bama channels her outrage into intense education and becomes an acclaimed writer inspiring social equality.",
            pyqAnswerHi = "दोनों ने अन्याय को चुपचाप स्वीकार नहीं किया: ज़िटकाला-सा ने विरोध कर और लेखन से पहचान बनाई, वहीं बामा ने क्रोध को पढ़ाई की ऊर्जा में बदलकर प्रथम स्थान व साहित्यिक सम्मान पाया।",
            mcq1Prompt = "According to Zitkala-Sa's mother, who wore short, shingled hair in their Native American community?",
            mcq1Options = listOf("Mourners and cowards", "Tribal chiefs", "School teachers", "Hunters"),
            mcq1Correct = 0,
            mcq1Hi = "उनकी माँ ने बताया था कि केवल शोकग्रस्त (mourners) या युद्ध में पकड़े गए कायर (cowards) ही छोटे बाल रखते थे।",
            mcq2Prompt = "Why was the village elder carrying the packet of vadais by its string without touching the paper?",
            mcq2Options = listOf("Due to caste untouchability practiced by the upper-caste landlord", "Because the packet was boiling hot", "Because his hands were muddy", "Because he was playing a game"),
            mcq2Correct = 0,
            mcq2Hi = "जमींदार जातिगत छुआछूत (untouchability) मानता था, इसलिए बुजुर्ग को डोरी पकड़कर पैकेट देना पड़ा ताकि वह अपवित्र न हो।"
        )
    )

    val specs: Map<String, ChapterRichSpec> = listOf(
        ChapterRichSpec(
            chapterId = "c12_fl_4",
            detailedHindiTeaching = "सेल्मा लागरलॉफ (नोबेल पुरस्कार विजेता) की 'The Rattrap' बोर्ड परीक्षा की सबसे प्रिय कहानी है। एडला का स्नेह, 30 क्रोनर और 'Captain von Stahle' का संदेश हर प्रश्न में काम आता है!",
            paragraphs = listOf(
                p(1, "दुनिया एक विशाल चूहेदानी और 30 क्रोनर की चोरी", "A lonely peddler believed the world baits people with wealth; tempted by thirty kronor, he robbed his kind crofter host.", "बूढ़े किसान ने मेहमान को दलिया, तंबाकू और मजोलिस खेल का सुख दिया, फिर भी लालच में फँसकर फेरीवाला 30 क्रोनर लेकर जंगल भाग गया।", "प्रलोभन इंसान को गलत राह पर फँसा देता है।"),
                p(2, "रैमजो आयरनमिल और एडला का निमंत्रण", "Mistaken by the Ironmaster for an old regimental comrade, the peddler refused until warm-hearted Edla kindly persuaded him.", "आयरनमास्टर की बेटी एडला ने डरे हुए फेरीवाले का विश्वास जीतकर क्रिसमस के लिए अपने घर बुलाया—चाहे वह गलती से आया हो पर शांति से रह सके।", "विनम्र व्यवहार डर को भरोसे में बदल देता है।"),
                p(3, "सच्चाई के बाद भी सम्मान और हृदय परिवर्तन", "Even after realizing he was a stranger, Edla insisted he stay for Christmas peace; moved to goodness, he left 30 kronor and a gift as 'Captain von Stahle'.", "एडला के इस मानवीय विश्वास ने चोर को अंदर से बदल दिया—सुबह चर्च से लौटकर पिता-पुत्री ने मेज़ पर 30 क्रोनर और चूहेदानी का तोहफा पाया!", "प्रेम और क्षमा अपराधी को भी सज्जन बना सकते हैं।")
            ),
            characters = listOf(
                ch("The Rattrap Peddler", "फेरीवाला (कैप्टन वॉन स्टाले)", "दार्शनिक पर भटका हुआ गरीब", listOf("कल्पनाशील", "लाचार फिर सुधरा", "आत्मसम्मानी अंत में"), "क्रॉफ्टर के पैसे चुराने के बाद एडला की निस्वार्थ करुणा से प्रेरित होकर वह ईमानदारी से पैसा लौटा देता है।", "The peddler shifts from cynical thief to honorable 'Captain von Stahle' through Edla's grace."),
                ch("Edla Willmansson", "एडला विलमानसन", "करुणामयी एवं समझदार युवती", listOf("दयालु", "सहनशील", "निर्णायक"), "पिता के गुस्से के बावजूद एडला एक गरीब अजनबी को क्रिसमस पर सम्मान व सुरक्षा देती हैं और उसका जीवन बदल देती हैं।", "Edla's quiet compassion and unwavering dignity awaken the best within the peddler.")
            ),
            cartoonScenes = listOf(
                sc(1, "सड़क पर चूहेदानी बेचता फेरीवाला", "World Is a Rattrap", "वाह! फेरीवाला सोच रहा है—यह पूरी दुनिया पनीर के टुकड़े की तरह धन-दौलत का जाल बिछाती है!", "Peddler", "Rattraps", CartoonSetting.CITY_MARKET, CartoonMood.THOUGHTFUL, "Rattrap Metaphor"),
                sc(2, "बूढ़े किसान के 30 क्रोनर चोरी!", "The 30 Kronor Bait", "हे भगवान! दयालु क्रॉफ्टर की खिड़की से 30 क्रोनर चुराकर फेरीवाला जंगल में खुद भटक गया!", "Peddler", "Crofter", CartoonSetting.FARM_STORM, CartoonMood.DRAMATIC, "Temptation Trap"),
                sc(3, "एडला की करुणा और क्रिसमस की शाम", "Edla's Kindness", "सच जानने पर भी एडला ने कहा—आज कम से कम एक दिन इसे शांति से हमारे घर क्रिसमस मनाने दो!", "Edla", "Ironmaster", CartoonSetting.ROYAL_PALACE, CartoonMood.INSPIRING, "True Dignity"),
                sc(4, "क्रिसमस उपहार: 30 क्रोनर वापस!", "Captain von Stahle", "देखो! मेज़ पर चूहेदानी, 30 क्रोनर और पत्र रखा है—दयालुता ने चोर को कैप्टन बना दिया!", "Edla", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Heart Transformed")
            )
        ),
        ChapterRichSpec(
            chapterId = "c12_fl_6",
            detailedHindiTeaching = "अशोकमित्रन का यह संस्मरण जेमिनी स्टूडियो (मद्रास) के अंदरूनी माहौल, मेकअप रूम की मज़ेदार घटनाओं, सुब्बू की बहुमुखी प्रतिभा और स्टीफन स्पेंडर की रहस्यमयी विज़िट को हास्यपूर्ण शैली में प्रस्तुत करता है।",
            paragraphs = listOf(
                p(1, "जेमिनी स्टूडियो का मेकअप विभाग और पैनकेक", "Truckloads of 'Pancake' brand makeup transformed actors under harsh lights in a strangely integrated department.", "रॉबर्ट क्लाइव की पुरानी घुड़साल वाली इमारत में मेकअप रूम राष्ट्रीय एकता की मिसाल था जहाँ एक बंगाली, महाराष्ट्रीयन, कन्नडिगा व तमिल मिलकर काम करते थे!", "फिल्मी चमक के पीछे विशाल टीमवर्क छिपा होता है।"),
                p(2, "हताश ऑफिस बॉय बनाम प्रतिभावान सुब्बू", "The 40-year-old office boy blamed cheerful Kothamangalam Subbu for his unfulfilled poetic ambitions.", "सुब्बू मिनटों में एक ही दृश्य के 14 वैकल्पिक तरीके सुझा देते थे—कवि, उपन्यासकार, अभिनेता और उदार मेज़बान होने पर भी वे कभी घमंड नहीं करते थे।", "सच्ची प्रतिभा और विनम्रता साथ चलते हैं।"),
                p(3, "एमआरए मंडली और स्टीफन स्पेंडर का रहस्य", "Years after an English poet baffled everyone with his accent at Gemini Studios, Asokamitran recognized Stephen Spender via 'The Encounter' and 'The God That Failed'.", "तब समझ आया कि बॉस एस.एस. वासन और स्पेंडर दोनों का जुड़ाव साहित्य और कम्युनिज़्म-मोहभंग से था!", "अधूरी मुलाकातों के अर्थ वर्षों बाद किताबों से खुलते हैं।")
            ),
            characters = listOf(
                ch("Kothamangalam Subbu", "कोतमंगलम सुब्बू", "जेमिनी स्टूडियो के नंबर-2 हरफनमौला", listOf("रचनात्मक", "उदार", "स्वामिभक्त"), "फिल्म निर्माण के हर पहलू में माहिर सुब्बू एक अच्छे कवि व लेखक थे जिनका घर सदैव मेहमानों से भरा रहता था।", "Subbu was multi-talented, cheerful, fiercely loyal to his boss, and astonishingly generous."),
                ch("Asokamitran", "अशोकमित्रन", "श्रोता व सूक्ष्म हास्यकार कथावाचक", listOf("अवलोकनशील", "व्यंग्य-निपुण", "पुस्तक-प्रेमी"), "अखबार की कटिंग का छोटा काम करते हुए भी वे स्टूडियो की हर बड़ी-छोटी प्रवृत्ति को अद्भुत हास्य से लिखते हैं।", "Asokamitran blends deadpan humour with sharp observation inside Gemini Studios.")
            ),
            cartoonScenes = listOf(
                sc(1, "मेकअप रूम में पैनकेक की बरसात!", "Pancake Truckloads", "हाहा! ट्रक भरकर पैनकेक क्रीम आई है और तेज बल्बों की गर्मी में कलाकार तैयार हो रहे हैं!", "Makeup Chief", "Actors", CartoonSetting.CITY_MARKET, CartoonMood.HAPPY, "Studio Chaos"),
                sc(2, "हरफनमौला सुब्बू के 14 आइडिया!", "Versatile Subbu", "डायरेक्टर अटक गए! पर सुब्बू ने तुरंत एक दृश्य करने के 14 शानदार तरीके बता दिए—लाजवाब!", "Subbu", "Director", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Creative Genius"),
                sc(3, "अंग्रेज़ मेहमान की अनोखी स्पीच", "Baffled Audience", "अरे! कोई स्टीफन स्पेंडर का अंग्रेज़ी लहज़ा समझ ही नहीं पा रहा—पूरा स्टूडियो शांत बैठा है!", "Spender", "Staff", CartoonSetting.ROYAL_PALACE, CartoonMood.MYSTERY, "Language Gap"),
                sc(4, "50 पैसे की किताब से खुला राज़!", "The God That Failed", "सालों बाद फुटपाथ पर किताब देखकर अशोकमित्रन चौंके—अरे ये तो स्टीफन स्पेंडर थे!", "Asokamitran", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.THOUGHTFUL, "Literary Mystery")
            )
        ),
        ChapterRichSpec(
            chapterId = "c12_fl_7",
            detailedHindiTeaching = "यह पाठ दो भागों में है—भाग 1 में साक्षात्कार (Interview) की शक्ति व विवाद, और भाग 2 में विश्व प्रसिद्ध विद्वान अम्बर्टो इको से जीवन के खाली समय 'Interstices' का मंत्र!",
            paragraphs = listOf(
                p(1, "साक्षात्कार: सत्य का झरोखा या निजता पर हमला?", "Since its invention 130 years ago, the interview became indispensable yet hated by Kipling, Naipaul, and Saul Bellow as intrusive.", "डेनिस ब्रायन के अनुसार आज हम अपने समकालीन महान लोगों की सबसे सटीक छवि साक्षात्कारों से ही पाते हैं।", "हर माध्यम के लाभ और सीमाएँ दोनों होती हैं।"),
                p(2, "अम्बर्टो इको और 'इंटरस्टिसेस' का जादू", "Asked how he handles vast scholarly output, Eco revealed he utilizes tiny empty time gaps ('interstices') between tasks.", "लिफ्ट आने के इंतज़ार में ही एक लेख लिख देने वाले इको बताते हैं कि उनके सभी कार्यों के पीछे एक ही नैतिक दर्शन है।", "छोटे-छोटे खाली समय का उपयोग अद्भुत सफलता देता है।"),
                p(3, "'द नेम ऑफ द रोज़' की विश्वव्यापी सफलता", "Contrary to publishers' doubts about a serious philosophical thriller, Eco's novel sold over ten million copies globally.", "पत्रकार व पाठक कठिन और गंभीर साहित्य का भी आनंद लेते हैं बशर्ते वह सही समय व रोचक शैली में लिखा जाए।", "मौलिक गुणवत्ता सदैव पाठकों तक पहुँच बना लेती है।")
            ),
            characters = listOf(
                ch("Umberto Eco", "अम्बर्टो इको", "इतालवी सेमियोटिक्स प्रोफेसर व उपन्यासकार", listOf("समय-सचेत", "विद्वान", "विनम्र व हास्यप्रिय"), "गंभीर अकादमिक शोध को भी कहानी की तरह लिखने वाले इको रविवार को उपन्यास लिखकर विश्वविख्यात हुए।", "Umberto Eco balances deep academic scholarship with storytelling flair and masterly use of time.")
            ),
            cartoonScenes = listOf(
                sc(1, "पत्रकारों का कैमरा बनाम लेखक", "Interview Debate", "कोई इसे सत्य का दर्पण कहता है तो किपलिंग और नायपॉल इसे निजता पर हमला मानते हैं!", "Journalist", "Authors", CartoonSetting.CITY_MARKET, CartoonMood.DRAMATIC, "Media Debate"),
                sc(2, "मुकुंद से मिले प्रोफेसर अम्बर्टो इको", "Meeting Umberto Eco", "मुकुंद पूछते हैं—सर, आप एक साथ इतनी किताबें, निबंध और उपन्यास कैसे लिखते हैं?", "Mukund", "Umberto Eco", CartoonSetting.CLASSROOM, CartoonMood.THOUGHTFUL, "Smart Interview"),
                sc(3, "लिफ्ट के इंतज़ार में 'इंटरस्टिसेस'!", "Secret of Interstices", "इको मुस्कुराए—जब तुम नीचे से ऊपर लिफ्ट में आ रहे थे, उस खाली 2 मिनट में मैंने एक लेख लिख डाला!", "Umberto Eco", "Elevator", CartoonSetting.MOUNTAIN_LAB, CartoonMood.INSPIRING, "Time Mastery"),
                sc(4, "एक करोड़ से ज़्यादा पाठक!", "The Name of the Rose", "लोग कठिन किताबें भी पढ़ते हैं—इमरान सर कहते हैं: आज से अपना हर खाली मिनट सार्थक बनाएँ!", "Umberto Eco", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Bestseller Wisdom")
            )
        ),
        ChapterRichSpec(
            chapterId = "c12_fl_8",
            detailedHindiTeaching = "ए.आर. बार्टन की 'Going Places' किशोरावस्था के सपनों और आर्थिक यथार्थ के टकराव की कहानी है। सोफी बनाम जैन्सी का अंतर MP बोर्ड में हर साल महत्वपूर्ण है!",
            paragraphs = listOf(
                p(1, "सोफी के बड़े सपने और जैन्सी का यथार्थ", "Sophie dreamed of owning an amazing boutique or becoming an actress, while realistic Jansie worried about working in a biscuit factory.", "कमजोर आर्थिक पृष्ठभूमि और संकीर्ण रसोई के बावजूद सोफी अपने सपनों की चमकदार दुनिया में जीती है।", "सपने सुंदर होते हैं पर उन्हें वास्तविक योजना से जोड़ना ज़रूरी है।"),
                p(2, "ज्यॉफ को सुनाई डैनी केसी की काल्पनिक कहानी", "To impress her quiet mechanic brother Geoff, Sophie claimed she met Irish football prodigy Danny Casey at Royce's arcade.", "पिता ने तुरंत इसे 'एक और मनगढ़ंत कहानी' कहकर डाँटा, और सोफी डरी कि कहीं जैन्सी इसे पूरे मोहल्ले में न फैला दे।", "झूठ व कल्पना पर बनी कहानियाँ अंततः बोझ बन जाती हैं।"),
                p(3, "नहर के किनारे अकेली प्रतीक्षा", "Waiting alone on a wooden bench by the canal, Sophie faced heartbreak as Danny Casey naturally never arrived.", "अकेले लौटते हुए उसे ज्यॉफ और जैन्सी का सामना करने की पीड़ा सताती है, फिर भी वह कल्पना में डैनी का चेहरा संजोए रखती है।", "अति दिवास्वप्न से बाहर निकलकर वास्तविक लक्ष्य पर परिश्रम करना चाहिए।")
            ),
            characters = listOf(
                ch("Sophie", "सोफी", "कल्पनाओं में खोई किशोर लड़की", listOf("स्वप्नदर्शी", "भावुक", "हीरो-भक्त"), "सोफी गरीबी की घुटन से भागकर डैनी केसी व शानदार बुटीक के दिवास्वप्नों में सुकून खोजती है।", "Sophie is an imaginative working-class teenager whose escapist fantasies end in quiet disillusionment."),
                ch("Jansie", "जैन्सी", "व्यावहारिक एवं यथार्थवादी सहेली", listOf("तार्किक", "जमीन से जुड़ी", "साधारण"), "जैन्सी जानती है कि परिवार की सीमाओं के बीच बिस्कुट फैक्ट्री ही उनका यथार्थ है—वह सोफी को भी सावधान करती है।", "Jansie serves as Sophie's grounded foil, fully aware of their modest social reality.")
            ),
            cartoonScenes = listOf(
                sc(1, "स्कूल से लौटते दो अलग दृष्टिकोण", "Dreams vs Reality", "सोफी कहती है मैं शहर की सबसे शानदार बुटीक खोलूँगी, पर जैन्सी याद दिलाती है—बिस्कुट फैक्ट्री इंतज़ार कर रही है!", "Sophie", "Jansie", CartoonSetting.CITY_MARKET, CartoonMood.THOUGHTFUL, "Two Outlooks"),
                sc(2, "ज्यॉफ के साथ डैनी केसी की कहानी!", "Hero Worship", "अरे ज्यॉफ! आज मैंने रॉइस आर्केड के बाहर आयरिश फुटबॉलर डैनी केसी से बात की—वे अगले हफ्ते मुझसे मिलेंगे!", "Sophie", "Geoff", CartoonSetting.HOME_GARDEN, CartoonMood.MYSTERY, "Fantasized Meet"),
                sc(3, "नहर किनारे सूनी बेंच पर इंतज़ार", "Canal Bench Wait", "शनिवार की शाम ढल गई, पर नहर किनारे कोई नहीं आया—सोफी अकेली बैठी उदास हो रही है!", "Sophie", "Canal", CartoonSetting.HOME_GARDEN, CartoonMood.DRAMATIC, "Painful Truth"),
                sc(4, "दिवास्वप्न नहीं—मेहनत से बनें सफल!", "Work Over Daydream", "इमरान सर समझाते हैं: सपने ज़रूर देखें, पर कल्पना के बजाय मेहनत व पढ़ाई को अपनी ताकत बनाएँ!", "Sophie", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Real Ambition")
            )
        ),
        ChapterRichSpec(
            chapterId = "c12_vi_2",
            detailedHindiTeaching = "कल्कि की 'The Tiger King' बोर्ड की सबसे रोचक व व्यंग्यात्मक कहानी है। 10 दिन के शिशु का बोलना, 50 हीरे की अंगूठियाँ (3 लाख), और अंत में लकड़ी के खिलौने वाले बाघ से मृत्यु सभी बिंदु याद रखें!",
            paragraphs = listOf(
                p(1, "चमत्कारी भविष्यवाणी और 'लेटेस्ट टाइगर्स बिवेयर!'", "Born under the Bull, ten-day-old Prince Jung Jung Bahadur spoke clearly after astrologers warned of death by the hundredth tiger.", "बड़े होकर महाराजा ने राज्य में बाघों का शिकार बंद कराया और खुद सौ बाघ मारने की प्रतिज्ञा ले ली।", "अहंकार और अंधविश्वास शासक को विवेकहीन बना देते हैं।"),
                p(2, "ब्रिटिश अफसर, 50 अंगूठियाँ और ससुराल के बाघ", "He risked his throne by refusing a British officer a tiger photo, saved it via ₹3 lakh diamond rings, and married to hunt 30 more tigers.", "दीवान साहब ने मद्रास से एक बूढ़ा बाघ मँगवाकर जंगल में छोड़ा ताकि महाराजा का 100वाँ शिकार पूरा हो सके!", "चापलूस मंत्री भी राजा के झूठे घमंड को हवा देते हैं।"),
                p(3, "लकड़ी के बाघ की फांस से 100वें बाघ का प्रतिशोध", "Missing the real 100th tiger (later shot secretly by hunters), the king died from an infected sliver of a cheap wooden toy tiger.", "असली 99 बाघ मारकर भी नियति ने एक निर्जीव लकड़ी के बाघ से अपनी भविष्यवाणी पूरी कर ली!", "नियति और प्रकृति से खिलवाड़ कभी सफल नहीं होता।")
            ),
            characters = listOf(
                ch("Maharaja Jung Jung Bahadur", "महाराजा जिलानी जंग जंग बहादुर", "प्रतिबंधपुरम का घमंडी 'टाइगर किंग'", listOf("अभिमानी", "साहसी पर क्रूर", "नियति का शिकार"), "मृत्यु को मात देने के चक्कर में वे 99 बाघ मार देते हैं और अंततः लकड़ी के बाघ की कील से मारे जाते हैं।", "The Tiger King is witty, eccentric, and despotic—blinded by pride over defeating destiny.")
            ),
            cartoonScenes = listOf(
                sc(1, "10 दिन का नन्हा राजकुमार बोला!", "Talking Infant", "सब हैरान! 10 दिन के राजकुमार ने ज्योतिषी से कहा—'सभी बाघ सावधान हो जाएँ!'", "Baby Prince", "Astrologers", CartoonSetting.ROYAL_PALACE, CartoonMood.MYSTERY, "Royal Prophecy"),
                sc(2, "तीन लाख रुपये की 50 हीरे की अंगूठियाँ!", "50 Diamond Rings", "हाहा! अंग्रेज़ अफसर की पत्नी ने सभी 50 अंगूठियाँ रख लीं—3 लाख में महाराजा की कुर्सी बची!", "King", "British Officer", CartoonSetting.ROYAL_PALACE, CartoonMood.HAPPY, "Expensive Save"),
                sc(3, "दीवान की कार से निकला बूढ़ा बाघ!", "The 100th Tiger", "बूढ़ा बाघ धमाके से बेहोश हुआ—राजा ने सोचा 100 पूरे हो गए, पर असल में गोली चूक गई थी!", "King", "Dewan", CartoonSetting.FARM_STORM, CartoonMood.DRAMATIC, "Missed Shot"),
                sc(4, "लकड़ी के बाघ ने लिया अंतिम बदला!", "Wooden Tiger Splinter", "सस्ते लकड़ी के बाघ की छोटी फांस से संक्रमण हुआ और टाइगर किंग चले गए—प्रकृति से न उलझें!", "King", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Ironic Fate")
            )
        ),
        ChapterRichSpec(
            chapterId = "c12_vi_3",
            detailedHindiTeaching = "तिशानी दोशी की अंटार्कटिका यात्रा ग्लोबल वार्मिंग, गोंडवाना महाद्वीप, Students on Ice, और Phytoplankton को सरल विज्ञान व साहित्य में समझाती है!",
            paragraphs = listOf(
                p(1, "अंटार्कटिका पहुँच और गोंडवाना का अतीत", "Reaching icy Antarctica after 100 hours from Madras, Tishani reflects on Gondwana—when India and Antarctica were joined 650 million years ago.", "बर्फ के विशाल सफेद विस्तार में कोई बिलबोर्ड या इंसान नहीं—केवल धरती के करोड़ों साल पुराने इतिहास का मौन है।", "धरती का भूगर्भीय अतीत हमें विनम्र बनाता है।"),
                p(2, "स्टूडेंट्स ऑन आइस (Students on Ice) का उद्देश्य", "Geoff Green switched from wealthy celebrities to high-school students because young future leaders care deeply enough to act.", "पिघलते ग्लेशियर अपनी आँखों से देखकर हर छात्र समझ जाता है कि ग्लोबल वार्मिंग कोई दूर की कल्पना नहीं, सच्चा खतरा है।", "युवा जागरूकता ही पर्यावरण संरक्षण की सबसे बड़ी शक्ति है।"),
                p(3, "फाइटोप्लांकटन व छोटी चीज़ों का महत्व", "Single-celled phytoplankton support the entire ocean food web; ozone depletion threatens them and Earth's climate balance.", "मधुमक्खियों व सील्स से घिरी बर्फ पर चलने का रोमांचक अनुभव उन्हें पृथ्वी से गहराई से जोड़ देता है।", "छोटे जीवों की रक्षा करने से पूरी धरती सुरक्षित रहती है।")
            ),
            characters = listOf(
                ch("Tishani Doshi", "तिशानी दोशी", "भारतीय कवयित्री, नर्तकी व यात्री", listOf("संवेदनशील", "प्रकृति-प्रेमी", "वैज्ञानिक चिंतक"), "चेन्नई की गर्म जलवायु से अंटार्कटिका की ठंड में जाकर वे जीवन व पारिस्थितिकी का गहरा पाठ लाती हैं।", "Tishani Doshi blends poetic wonder with urgent ecological awareness on her Antarctic expedition.")
            ),
            cartoonScenes = listOf(
                sc(1, "रूसी जहाज़ अकादमिक शोकाल्स्की पर यात्रा", "Antarctica Voyage", "9 टाइम-ज़ोन पार करके तिशानी और छात्रों का दल अंटार्कटिका के सफेद समंदर में पहुँच गया!", "Tishani", "Ship", CartoonSetting.OCEAN_SHIP, CartoonMood.HAPPY, "Polar Voyage"),
                sc(2, "65 करोड़ साल पुराना गोंडवाना रहस्य", "Gondwana History", "देखिए छात्रों! कभी भारत और बर्फीला अंटार्कटिका एक ही महाद्वीप 'गोंडवाना' का हिस्सा थे!", "Geoff Green", "Students", CartoonSetting.MOUNTAIN_LAB, CartoonMood.THOUGHTFUL, "Earth Past"),
                sc(3, "सूक्ष्म फाइटोप्लांकटन की बड़ी ताकत", "Phytoplankton Lesson", "समुद्र के इन छोटे-छोटे पौधों को बचाओगे, तो व्हेल, पेंगुइन और पूरी धरती अपने आप बच जाएगी!", "Tishani", "Ocean", CartoonSetting.OCEAN_SHIP, CartoonMood.INSPIRING, "Micro Eco Link"),
                sc(4, "युवा पीढ़ी बने पृथ्वी की रक्षक!", "Students on Ice", "पिघलते ग्लेशियर देखकर युवाओं ने ठाना—हम कार्बन कम करेंगे और धरती को हरा-भरा रखेंगे!", "Students", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Protect Earth")
            )
        ),
        ChapterRichSpec(
            chapterId = "c12_vi_5",
            detailedHindiTeaching = "सुज़ैन हिल का 'On the Face of It' हर विद्यार्थी के दिल को छूता है—मिस्टर लैम्ब का आशावाद और 14 वर्षीय डेरी का बदला हुआ जीवन दृष्टिकोण मुख्य विषय हैं।",
            paragraphs = listOf(
                p(1, "बगीचे में मुलाकात और डेरी का कटु अनुभव", "Fourteen-year-old Derry entered Mr. Lamb's garden quietly, scarred on one cheek by acid and wounded by cruel public stares.", "डेरी मानता था कि कोई उससे प्यार नहीं कर सकता, यहाँ तक कि उसकी माँ भी हमेशा सही गाल ही चूमती हैं।", "समाज के तानों से मन के घाव शरीर से भी गहरे हो जाते हैं।"),
                p(2, "मिस्टर लैम्ब का खुला दर्शन", "Old Mr. Lamb—himself having a tin leg—compared weeds and flowers, recalled the fairy tale Beauty and the Beast, and urged positivity.", "जब बच्चे उन्हें 'लैमी-लैम्ब' कहते, तो वे बुरा न मानकर उन्हें सेब की जेली देते और खुले दरवाज़े रखकर जीवन का स्वागत करते थे।", "सकारात्मक दृष्टि से हर कमी शक्ति बन जाती है।"),
                p(3, "सीढ़ी से दुर्घटना और डेरी का नया साहस", "Defying his mother, Derry ran back to help Mr. Lamb pick crab apples, arriving as Lamb fell fatally—yet Derry was forever freed from fear.", "डेरी अब दुनिया से छिपने के लिए नहीं लौटा—उसका आत्मविश्वास लौट चुका था और मिस्टर लैम्ब का संदेश उसके भीतर जीवित था।", "सच्चे मार्गदर्शक चले जाने पर भी शिष्यों को निडर बना जाते हैं।")
            ),
            characters = listOf(
                ch("Mr. Lamb", "मिस्टर लैम्ब", "आशावादी और स्नेही बुजुर्ग", listOf("सकारात्मक", "खुले विचारों वाले", "साहसी"), "युद्ध में पैर खोने के बावजूद वे मधुमक्खियों के गीत सुनते हैं, किताबें पढ़ते हैं और डेरी को जीने की नई राह दिखाते हैं।", "Mr. Lamb turns personal disability into boundless warmth, wisdom, and hospitality."),
                ch("Derry (Derek)", "डेरी (14 वर्ष)", "तेजाब से झुलसे चेहरे वाला किशोर", listOf("प्रारंभ में चिड़चिड़ा", "संवेदनशील", "अंततः निडर"), "मिस्टर लैम्ब के स्नेह से प्रभावित होकर डेरी हीनभावना त्यागता है और आत्मनिर्भर बन जाता है।", "Derry evolves from bitter self-isolation to courageous self-acceptance.")
            ),
            cartoonScenes = listOf(
                sc(1, "बगीचे की दीवार कूदकर आया डेरी", "Garden Encounter", "डेरी चौंक गया! बगीचा खाली नहीं था—वहाँ टिन के पैर वाले दयालु मिस्टर लैम्ब खड़े मुस्कुरा रहे हैं!", "Derry", "Mr. Lamb", CartoonSetting.HOME_GARDEN, CartoonMood.MYSTERY, "First Meeting"),
                sc(2, "खरपतवार और फूल का ज्ञान", "Weeds & Flowers", "मिस्टर लैम्ब बोले—एक हरा पौधा फूल और दूसरा खरपतवार कैसे? सब जीवन है डेरी, खुद से प्यार करो!", "Mr. Lamb", "Derry", CartoonSetting.HOME_GARDEN, CartoonMood.INSPIRING, "Equal Life"),
                sc(3, "घर में माँ से साहसी बहस", "Standing Up", "डेरी ने माँ से साफ कहा—अब चेहरे की परवाह नहीं, मुझे बगीचे जाकर दुनिया सुनना और जीना सीखना है!", "Derry", "Mother", CartoonSetting.HOME_GARDEN, CartoonMood.DRAMATIC, "New Courage"),
                sc(4, "बगीचे में लौटा बदला हुआ डेरी", "Fear Overcome", "मिस्टर लैम्ब सेब की सीढ़ी से गिर पड़े पर डेरी को नया जीवन दे गए—आत्मविश्वास ही असली सुंदरता है!", "Derry", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.THOUGHTFUL, "Inner Beauty")
            )
        ),
        ChapterRichSpec(
            chapterId = "c12_vi_6",
            detailedHindiTeaching = "इस अध्याय में दो बहादुर लेखिकाओं के बचपन के सच हैं—(1) ज़िटकाला-सा का लंबे बाल काटे जाने के खिलाफ संघर्ष और (2) तमिल लेखिका बामा द्वारा छुआछूत के खिलाफ पढ़ाई को हथियार बनाना!",
            paragraphs = listOf(
                p(1, "ज़िटकाला-सा: बाल कटाई का विद्रोह", "At Carlisle Indian School, Native girl Zitkala-Sa hid under a bed to protect her long braids—fighting bravely before being overpowered.", "उनके लिए छोटे बाल कायरों की निशानी थे—शारीरिक हार के बाद भी उनकी आत्मा ने अन्याय को कभी स्वीकार नहीं किया।", "अपनी संस्कृति व स्वाभिमान की रक्षा करना महान साहस है।"),
                p(2, "बामा: बाज़ार में देखा जातिगत अपमान", "Third-grader Bama laughed seeing an elder hold a vadai packet by its string—until brother Annan revealed the humiliation of untouchability.", "यह जानकर नन्ही बामा का मन क्रोध से भर गया कि केवल जन्म के कारण एक बुजुर्ग को अछूत मानकर अपमानित किया जा रहा है।", "अन्याय देखकर चुप रहने के बजाय उसका मूल कारण समझना ज़रूरी है।"),
                p(3, "अन्नन का मंत्र: शिक्षा से सम्मान", "Annan urged Bama to study diligently and stand first; she excelled, winning friends and rising above caste barriers.", "दिन-रात मेहनत कर कक्षा में प्रथम आते ही वही लोग बामा के मित्र बनने आगे आए—शिक्षा ने उनका जीवन बदल दिया!", "शिक्षा व योग्यता सामाजिक भेदभाव तोड़ने की सबसे तेज़ तलवार है।")
            ),
            characters = listOf(
                ch("Zitkala-Sa", "ज़िटकाला-सा", "स्वाभिमानी मूल अमेरिकी लड़की", listOf("निडर", "संस्कृति-रक्षक", "विद्रोही"), "विदेशी बोर्डिंग स्कूल के कठोर नियमों और जबरन बाल काटने का उसने अंतिम क्षण तक साहसी विरोध किया।", "Zitkala-Sa fiercely defends her Native heritage against forced cultural assimilation."),
                ch("Bama", "बामा", "तेज़ बुद्धि तमिल दलित लेखिका", listOf("अवलोकनशील", "मेहनती", "शिक्षा-प्रेमी"), "अन्नन की प्रेरणा से बामा ने छुआछूत की पीड़ा को पढ़ाई में प्रथम आने की प्रेरणा में बदल दिया।", "Bama turns childhood outrage into relentless academic excellence and literary strength.")
            ),
            cartoonScenes = listOf(
                sc(1, "बोर्डिंग स्कूल की सख्त घंटियाँ", "Breakfast by Formula", "अरे! घंटी की आवाज़ पर बैठना, खाना—ज़िटकाला-सा विदेशी स्कूल में अपनी संस्कृति खोती देख रो पड़ीं!", "Zitkala-Sa", "Judewin", CartoonSetting.CLASSROOM, CartoonMood.THOUGHTFUL, "Culture Shock"),
                sc(2, "पलंग के नीचे ज़िटकाला-सा का प्रतिरोध", "Brave Resistance", "मेरे लंबे बाल मत काटो! छोटी ज़िटकाला-सा ने विरोध किया—अपना स्वाभिमान कभी बिना लड़े मत छोड़ो!", "Zitkala-Sa", "Matron", CartoonSetting.CLASSROOM, CartoonMood.DRAMATIC, "Standing Tall"),
                sc(3, "बामा ने देखा वड़ाई का पैकेट!", "The String Lesson", "अरे भैया, वे चाचा डोरी से वड़ाई क्यों ला रहे हैं? अन्नन ने छुआछूत की कड़वी सच्चाई समझा दी!", "Bama", "Annan", CartoonSetting.CITY_MARKET, CartoonMood.MYSTERY, "Eye Opener"),
                sc(4, "कक्षा में प्रथम आकर बामा की जीत!", "Power of Education", "वाह बामा! दिन-रात पढ़कर बामा ने कक्षा में टॉप किया—अन्नन व इमरान सर कहते हैं: शिक्षा ही असली शक्ति है!", "Bama", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Triumph via Study")
            )
        )
    ).associateBy { it.chapterId }
}
