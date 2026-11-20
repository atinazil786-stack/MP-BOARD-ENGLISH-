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
import com.example.data.model.QuestionType

object Class9MissingChapters {

    val chapters: List<Chapter> = listOf(
        makeProseChapter(
            id = "c9_mo_3",
            classLevel = 9,
            bookName = "Moments",
            chapterNumber = 3,
            category = "Supplementary",
            title = "Iswaran the Storyteller",
            titleHi = "ईश्वरन कहानीकार",
            author = "R.K. Laxman",
            summaryEn = "Mahendra, a junior supervisor, is accompanied by his loyal cook Iswaran whose dramatic Tamil thriller-inspired storytelling blurs the line between reality and ghost superstition, ultimately forcing Mahendra to resign.",
            summaryHi = "जूनियर सुपरवाइज़र महेंद्र के साथ उनका रसोइया ईश्वरन रहता है, जो बेहद नाटकीय ढंग से कहानियाँ सुनाता है। ईश्वरन की भूत की कहानियाँ महेंद्र के मन में इतना डर भर देती हैं कि एक रात वह खुद भूत का भ्रम देख नौकरी छोड़ने का फैसला कर लेता है।",
            hindiExplanation = "महेंद्र एक निर्माण कार्य निरीक्षक था जिसका तबादला अलग-अलग स्थानों पर होता रहता था। उसका रसोइया ईश्वरन न केवल स्वादिष्ट खाना बनाता था बल्कि बिना किसी टीवी के भी अपनी आँखों-हाथों के अभिनय से महाकाव्यों जैसी रोमांचक कहानियाँ सुनाता था। एक दिन ईश्वरन ने बताया कि वह फैक्ट्री क्षेत्र पहले कब्रिस्तान था और पूर्णिमा की रात वहाँ एक महिला का भूत नवजात लिए घूमती है। पहले तो महेंद्र ने इसे बकवास कहा, पर एक चाँदनी रात खिड़की से आकृति देख वह इतना भयभीत हुआ कि उसने तुरंत इस्तीफा दे दिया।",
            themeEn = "Vivid imagination and dramatic storytelling can overpower even a rational mind.",
            themeHi = "अत्यधिक कल्पनाशील और नाटकीय कहानी सुनने से तार्किक व्यक्ति के मन में भी भय और भ्रम घर कर सकता है।",
            messageHi = "अंधविश्वास और सुनी-सुनाई डरावनी बातों पर आँख मूँदकर डरने से बचना चाहिए; तथ्य की जाँच आवश्यक है।",
            words = listOf(
                w("Desolate", "adj", "Empty and bleak", "सुनसान / वीरान", "Mahendra stayed at a desolate construction site."),
                w("Anecdote", "noun", "A short amusing or interesting story", "रोचक किस्सा", "Iswaran narrated every anecdote with suspense."),
                w("Conjure", "verb", "Create as if by magic", "जादू की तरह उत्पन्न करना", "He could conjure delicious dishes quickly."),
                w("Prostrate", "adj", "Lying flat on the ground", "जमीन पर पस्त पड़ा हुआ", "The tusker stood before the quiet town hall crowd."),
                w("Apparition", "noun", "A ghost or ghostlike image", "प्रेतात्मा / भूत जैसी छाया", "Mahendra panicked thinking he saw a ghost apparition.")
            ),
            matchPairs = listOf(
                MatchPair("Mahendra", "Junior supervisor"),
                MatchPair("Iswaran", "Master storyteller cook"),
                MatchPair("Maddened Tusker", "Controlled by toe-nail trick"),
                MatchPair("Full-moon night", "Female ghost superstition")
            ),
            extract1 = ExtractSpec(
                extractText = "“His descriptions were greatly influenced by the Tamil authors that he read.”",
                promptEn = "How did Iswaran make simple incidents thrilling for Mahendra?",
                promptHi = "ईश्वरन महेंद्र के लिए छोटी घटनाओं को भी रोमांचक कैसे बनाता था?",
                answerEn = "By waving hands dramatically, raising eyebrows, and building suspense like Tamil thrillers.",
                answerHi = "वह हाथ हिलाकर, भौंहें चढ़ाकर और तमिल रोमांचक उपन्यासों की शैली में सस्पेंस बनाकर सुनाता था।"
            ),
            extract2 = ExtractSpec(
                extractText = "“Mahendra resolved to leave the haunted place the very next day.”",
                promptEn = "Why did a rational man like Mahendra suddenly resign?",
                promptHi = "महेंद्र जैसे तार्किक व्यक्ति ने अचानक नौकरी छोड़ने का निश्चय क्यों किया?",
                answerEn = "Eerie sounds and a cloudy shadow outside his window convinced his frightened mind of Iswaran's ghost story.",
                answerHi = "खिड़की के बाहर अजीब आवाज़ और परछाई देखकर उसे ईश्वरन की भूत वाली बात सच लगने लगी।"
            ),
            pyqPromptEn = "Describe how Iswaran tackled the wild mad tusker in his childhood story.",
            pyqPromptHi = "ईश्वरन ने अपनी कहानी में पागल हाथी को किस प्रकार काबू किया? वर्णन कीजिए।",
            pyqAnswerEn = "Iswaran grabbed a cane, stepped bravely in front of the elephant, and whacked its third toenail on the quick, stunning it.",
            pyqAnswerHi = "ईश्वरन ने एक छड़ी लेकर हाथी के तीसरे पैर के नाखून के पास जोर से वार किया जिससे हाथी बेहोश हो गया।",
            mcq1Prompt = "What trick did Iswaran claim felled the mad elephant?",
            mcq1Options = listOf("Throwing stones", "Striking its third toenail", "Feeding bananas", "Blowing a whistle"),
            mcq1Correct = 1,
            mcq1Hi = "ईश्वरन ने दावा किया कि उसने जापानी कला (कराटे/जू-जित्सु) से हाथी के तीसरे नाखून पर वार किया।",
            mcq2Prompt = "On which night did Iswaran claim the female ghost appeared?",
            mcq2Options = listOf("New moon night", "Full moon night", "Rainy afternoon", "Winter morning"),
            mcq2Correct = 1,
            mcq2Hi = "ईश्वरन ने बताया कि पूर्णिमा (Full moon night) को महिला का भूत दिखाई देता है।"
        ),
        makeProseChapter(
            id = "c9_mo_4",
            classLevel = 9,
            bookName = "Moments",
            chapterNumber = 4,
            category = "Supplementary",
            title = "In the Kingdom of Fools",
            titleHi = "मूर्खों के राज्य में",
            author = "A.K. Ramanujan",
            summaryEn = "In a kingdom ruled by a foolish king and minister where night was turned into day and everything cost one duddu, a greedy disciple ignores his guru's warning and gets trapped—until the wise guru outwits the king to save him.",
            summaryHi = "एक मूर्ख राजा और मंत्री के राज्य में रात को दिन और दिन को रात बना दिया गया था तथा हर चीज़ एक टके (duddu) में मिलती थी। सस्ते भोजन के लालच में शिष्य वहीं रुक जाता है और फाँसी पर चढ़ने ही वाला होता है कि बुद्धिमान गुरु अपनी युक्ति से उसे बचा लेते हैं और स्वयं राजा बन जाते हैं।",
            hindiExplanation = "कन्नड़ लोककथा पर आधारित इस पाठ में एक गुरु और शिष्य मूर्खों के राज्य में पहुँचते हैं। वहाँ दिन में सब सोते थे और रात में काम करते थे। हर वस्तु केवल एक दुड्डू में मिलती थी। गुरु समझ गए कि मूर्खों के बीच रहना खतरनाक है, पर शिष्य सस्ते घी-केले के लालच में वहीं रुक गया। एक चोर की मौत के अजीब मुकदमे में राजा मोटे व्यक्ति को सूली पर चढ़ाने का आदेश देता है और शिष्य पकड़ा जाता है। तब गुरुजी नाटक रचते हैं कि इस नए तख्ते पर पहले मरने वाला अगले जन्म में राजा बनेगा! लालची राजा-मंत्री खुद फाँसी पर चढ़ जाते हैं।",
            themeEn = "Wisdom can defeat foolish power, whereas greed blinds judgment.",
            themeHi = "बुद्धिमत्ता और दूरदर्शिता किसी भी संकट से बचा सकती है, जबकि लालच और मूर्खता विनाश का कारण बनती है।",
            messageHi = "मूर्ख लोगों के राज्य में सस्ते लाभ के लालच में न फँसें; गुरु व अनुभवी लोगों की सलाह मानें।",
            words = listOf(
                w("Duddu", "noun", "A small coin of very low value", "टका / छोटा सिक्का", "Everything in the kingdom cost a single duddu."),
                w("Stake", "noun", "A heavy wooden post used for execution", "सूली का खंभा", "The king ordered a new stake for execution."),
                w("Scribe", "noun", "Person in old times whose job was writing", "लेखक / मुंशी", "The merchant blamed the goldsmith and bricklayer."),
                w("Ascetic", "noun", "A person practicing strict self-discipline", "तपस्वी / साधु", "The guru acted like a wise ascetic."),
                w("Baffled", "adj", "Completely confused", "चकित / हैरान", "The foolish king was baffled by the guru's request.")
            ),
            matchPairs = listOf(
                MatchPair("Everything costs 1 duddu", "Foolish king's rule"),
                MatchPair("Disciple", "Chose cheap food over wisdom"),
                MatchPair("Wise Guru", "Outwitted the king safely"),
                MatchPair("Stake secret", "Trick to trap king & minister")
            ),
            extract1 = ExtractSpec(
                extractText = "“This is a kingdom of fools, it wouldn't be a good idea for us to stay here.”",
                promptEn = "Why did the guru advise his disciple to leave the kingdom immediately?",
                promptHi = "गुरु ने अपने शिष्य को तुरंत राज्य छोड़ने की सलाह क्यों दी?",
                answerEn = "Because foolish rulers are unpredictable and nobody knows what absurd thing they might do next.",
                answerHi = "क्योंकि मूर्ख शासकों का कोई भरोसा नहीं होता—वे कभी भी किसी बेकसूर को सजा दे सकते हैं।"
            ),
            extract2 = ExtractSpec(
                extractText = "“Whoever dies on it first will be reborn as the king of this country.”",
                promptEn = "How did the guru trick the king into freeing his disciple?",
                promptHi = "गुरु ने राजा को चकमा देकर शिष्य की जान कैसे बचाई?",
                answerEn = "By claiming the new stake was sacred and whoever died first would become future king and second would become minister.",
                answerHi = "गुरु ने कहा कि नई सूली पवित्र है—इस पर पहले चढ़ने वाला अगले जन्म में राजा और दूसरा मंत्री बनेगा।"
            ),
            pyqPromptEn = "Why was the disciple chosen to be executed instead of the thin merchant?",
            pyqPromptHi = "पतले व्यापारी की जगह शिष्य को सूली पर चढ़ाने के लिए क्यों चुना गया?",
            pyqAnswerEn = "The rich merchant was too thin to fit the newly built stake, so the foolish king ordered soldiers to find a fat man—the well-fed disciple.",
            pyqAnswerHi = "व्यापारी बहुत पतला था और नई सूली में फिट नहीं हुआ, इसलिए राजा ने एक मोटे आदमी (शिष्य) को पकड़वाया।",
            mcq1Prompt = "What was the single price of any item in the Kingdom of Fools?",
            mcq1Options = listOf("Five rupees", "One gold coin", "One duddu", "Ten paise"),
            mcq1Correct = 2,
            mcq1Hi = "मूर्खों के राज्य में चावल हो या केले, हर चीज़ केवल एक दुड्डू (single duddu) में मिलती थी।",
            mcq2Prompt = "Who finally became the new King and Minister of the kingdom?",
            mcq2Options = listOf("The goldsmith and merchant", "The Guru and his disciple", "The bricklayer and mason", "The thief's brother and friend"),
            mcq2Correct = 1,
            mcq2Hi = "राजा-मंत्री के मरने के बाद प्रजा की विनती पर गुरु और शिष्य राजा व मंत्री बने।"
        ),
        makeProseChapter(
            id = "c9_mo_6",
            classLevel = 9,
            bookName = "Moments",
            chapterNumber = 6,
            category = "Supplementary",
            title = "Weathering the Storm in Ersama",
            titleHi = "एरसामा में तूफान का सामना",
            author = "Harsh Mander",
            summaryEn = "After the devastating 1999 Odisha super-cyclone, teenager Prashant rises as a selfless community leader, organizing food via helicopter signals, cleaning shelters, rehabilitating orphans, and bringing hope to broken families.",
            summaryHi = "अक्टूबर 1999 के भयानक ओडिशा महा-चक्रवात के बाद 19 वर्षीय प्रशांत साहस और नेतृत्व दिखाता है। वह रेडकॉस आश्रय स्थल में भोजन, स्वच्छता और अनाथ बच्चों व विधवाओं के पुनर्वास का अद्भुत अभियान चलाता है।",
            hindiExplanation = "27 अक्टूबर 1999 को 19 वर्षीय प्रशांत अपने मित्र के घर एरसामा गया था तभी 350 किमी/घंटा की रफ्तार से महाचक्रवात आया। दो दिन छत पर नारियल के पेड़ की टहनियों से गिरे नारियल खाकर बचने के बाद वह पानी में तैरते हुए अपने गाँव कालीकुडा लौटा। परिवार को जीवित देख उसने निराश लोगों को संगठित किया। उसने थालियाँ बजाकर व बच्चों की मदद से हेलीकॉप्टर को भोजन गिराने का संकेत दिया, गंदगी साफ की, और अनाथ बच्चों को निःसंतान विधवाओं की देखरेख में रखकर नई आशा जगाई।",
            themeEn = "Courageous youth leadership and community solidarity overcome natural disasters.",
            themeHi = "संकट की घड़ी में युवा नेतृत्व, करुणा और सामूहिक एकता बड़ी से बड़ी आपदा को हरा सकती है।",
            messageHi = "विपदा में निराश होने के बजाय समाज के साथ मिलकर सेवा और पुनर्निर्माण में जुट जाना सच्ची मानवता है।",
            words = listOf(
                w("Devastation", "noun", "Widespread destruction and ruin", "तबाही / विनाश", "The super cyclone caused widespread devastation in Odisha."),
                w("Incessant", "adj", "Continuing without pause", "लगातार / अविरल", "Incessant rain battered the house for 36 hours."),
                w("Mourn", "verb", "Feel deep sorrow over loss", "शोक मनाना", "They gathered to mourn the victims of the flood."),
                w("Orphan", "noun", "A child whose parents have died", "अनाथ बच्चा", "Prashant created a shelter for orphaned children."),
                w("Mobilized", "verb", "Organized people for action", "एकजुट कर सक्रिय करना", "Prashant mobilized villagers to clean the shelter.")
            ),
            matchPairs = listOf(
                MatchPair("October 1999", "Odisha super-cyclone"),
                MatchPair("Kalikuda", "Prashant's native village"),
                MatchPair("Empty utensils", "Signal to rescue helicopters"),
                MatchPair("Food-for-work", "Widows' rehabilitation program")
            ),
            extract1 = ExtractSpec(
                extractText = "“Prashant, all nineteen years old, decided to step in as leader of his village.”",
                promptEn = "What steps did Prashant take at the Red Cross shelter?",
                promptHi = "प्रशांत ने रेड क्रॉस आश्रय स्थल पर क्या कदम उठाए?",
                answerEn = "He organized youth volunteers to clear filth, secure rice from the merchant, and signal helicopters for food drops.",
                answerHi = "उसने युवाओं की टीम बनाकर गंदगी साफ कराई, व्यापारी से चावल दिलाया और हेलीकॉप्टर से भोजन मँगवाया।"
            ),
            extract2 = ExtractSpec(
                extractText = "“His wounded spirit has healed simply because he had no time to bother about his own pain.”",
                promptEn = "How did serving others help Prashant heal emotionally?",
                promptHi = "दूसरों की सेवा ने प्रशांत के मन के दर्द को कैसे कम किया?",
                answerEn = "Working tirelessly for widows and orphans gave him purpose and strength.",
                answerHi = "अनाथ बच्चों और विधवाओं की सेवा में व्यस्त रहकर उसे आत्मबल और मानसिक शांति मिली।"
            ),
            pyqPromptEn = "Why did Prashant oppose sending orphans to distant government institutions?",
            pyqPromptHi = "प्रशांत ने अनाथ बच्चों को अलग सरकारी संस्थाओं में भेजने का विरोध क्यों किया?",
            pyqAnswerEn = "He felt orphans needed loving care among familiar villagers and widows rather than lonely institutional upbringing.",
            pyqAnswerHi = "उसका मानना था कि अनाथ बच्चे गाँव की विधवाओं के साथ अपने समाज में अधिक प्यार और सुरक्षा पाएँगे।",
            mcq1Prompt = "When did the devastating super-cyclone hit Odisha in this lesson?",
            mcq1Options = listOf("27 October 1999", "15 August 2001", "26 January 1995", "10 May 2005"),
            mcq1Correct = 0,
            mcq1Hi = "यह भयंकर चक्रवात 27 अक्टूबर 1999 को ओडिशा के तटीय क्षेत्रों में आया था।",
            mcq2Prompt = "How did Prashant and the villagers survive on his friend's rooftop during the storm?",
            mcq2Options = listOf("By eating green coconuts", "By drinking milk", "By fishing", "By buying packets"),
            mcq2Correct = 0,
            mcq2Hi = "छत पर गिरे हुए नारियल के पेड़ों के कच्चे नारियल खाकर उन्होंने दो दिन बिताए।"
        ),
        makeProseChapter(
            id = "c9_mo_8",
            classLevel = 9,
            bookName = "Moments",
            chapterNumber = 8,
            category = "Supplementary",
            title = "A House Is Not a Home",
            titleHi = "मकान घर नहीं होता",
            author = "Zan Gaudioso",
            summaryEn = "Teenager Zan struggles with loneliness after moving to a new high school, and then loses his house and beloved red tabby cat in a sudden fire—only to rediscover warmth when schoolmates shower gifts and a kind stranger returns his cat.",
            summaryHi = "नए हाईस्कूल में अकेलेपन से जूझ रहे किशोर ज़ैन का घर अचानक आग में जलकर राख हो जाता है और उसकी प्यारी बिल्ली भी गुम हो जाती है। पर जब नए स्कूल के सहपाठी उसके लिए किताबें-कपड़े जुटाते हैं और एक दयालु महिला उसकी बिल्ली लौटाती है, तो उसे एहसास होता है कि सच्चा 'घर' ईंटों से नहीं, अपनों के प्यार से बनता है।",
            hindiExplanation = "ज़ैन के लिए नया हाईस्कूल बहुत अजनबी था; वह अपने पुराने दोस्तों और शिक्षकों को याद करता था। एक ठंडी रविवार दोपहर घर में आग लग गई। उसकी माँ पिता की निशानियाँ बचाने जलते घर में घुसीं, जिन्हें दमकलकर्मियों ने बचाया, पर बिल्ली कहीं न दिखी। अगले दिन ज़ैन फटे जूतों में उदास स्कूल गया। तब पूरे स्कूल के विद्यार्थियों ने उसके लिए नोटबुक्स, बैग, कपड़े और मदद इकट्ठी कर उसका दिल जीत लिया। एक महीने बाद एक नेक महिला उसकी खोई बिल्ली लेकर आई और ज़ैन फिर से मुस्कुरा उठा।",
            themeEn = "True home lies in community kindness, friendship, and emotional belonging—not material walls.",
            themeHi = "ईंट-पत्थर के मकान से नहीं, बल्कि मित्रों की सहानुभूति, प्रेम और अपनेपन से ही असली 'घर' बनता है।",
            messageHi = "मुश्किल समय में दूसरों की छोटी-सी मदद भी किसी के जीवन में नई रोशनी भर सकती है।",
            words = listOf(
                w("Searing", "adj", "Intense burning pain or heat", "झुलसाने वाला / तीखा", "Zan felt searing grief losing his house."),
                w("Dazed", "adj", "Shocked and unable to think clearly", "स्तब्ध / चकराया हुआ", "He sat dazed watching the fire flames."),
                w("Plight", "noun", "A dangerous or unfortunate situation", "दुर्दशा / कठिन स्थिति", "Classmates moved by his plight donated supplies."),
                w("Zombie", "noun", "Someone moving mechanically without spirit", "सुन्न व्यक्ति की तरह", "He walked to school like a zombie."),
                w("Gratitude", "noun", "Feeling of thankfulness", "कृतज्ञता / आभार", "Tears of gratitude filled Zan's eyes.")
            ),
            matchPairs = listOf(
                MatchPair("Fire tragedy", "Destroyed house and keepsakes"),
                MatchPair("Schoolmates", "Gifted clothes and notebooks"),
                MatchPair("Red tabby cat", "Returned by a kind woman"),
                MatchPair("A House vs Home", "Walls vs Love & Belonging")
            ),
            extract1 = ExtractSpec(
                extractText = "“That day my life changed forever when I opened the locker and saw genuine kindness.”",
                promptEn = "How did Zan's schoolmates transform his attitude toward his new school?",
                promptHi = "ज़ैन के नए स्कूल के साथियों ने उसका नजरिया कैसे बदल दिया?",
                answerEn = "They pooled notebooks, backpacks, jeans, and warm smiles, making him feel accepted and loved.",
                answerHi = "उन्होंने बैग, किताबें, कपड़े और दोस्ती देकर उसे अकेलेपन से बाहर निकाला।"
            ),
            extract2 = ExtractSpec(
                extractText = "“My cat was back and so was I.”",
                promptEn = "What does the closing line signify about Zan's emotional journey?",
                promptHi = "अंतिम पंक्ति 'मेरी बिल्ली लौट आई और मैं भी लौट आया' क्या दर्शाती है?",
                answerEn = "It marks the end of his alienation and grief—he feels whole, grateful, and truly at home again.",
                answerHi = "इसका अर्थ है कि वह अपने पुराने डर व अकेलेपन से उबरकर जीवन के प्रति फिर से आशावादी बन गया।"
            ),
            pyqPromptEn = "Why did Zan's mother rush back into the burning house?",
            pyqPromptHi = "ज़ैन की माँ जलते हुए घर के अंदर दोबारा क्यों दौड़ गईं?",
            pyqAnswerEn = "She ran inside to rescue a metal box containing precious letters and photographs of Zan's late father.",
            pyqAnswerHi = "वह ज़ैन के स्वर्गीय पिता की अंतिम तस्वीरें और पत्र बचाने के लिए जलते घर में घुसीं।",
            mcq1Prompt = "What happened to Zan's house on a chilly Sunday afternoon?",
            mcq1Options = listOf("It flooded", "It caught fire completely", "A cyclone blew its roof", "Thieves robbed it"),
            mcq1Correct = 1,
            mcq1Hi = "एक ठंडे रविवार दोपहर ज़ैन का पूरा घर आग की चपेट में आकर जल गया।",
            mcq2Prompt = "Who returned Zan's lost red tabby cat after a month?",
            mcq2Options = listOf("A fireman", "A kind neighborhood woman", "His old teacher", "The school principal"),
            mcq2Correct = 1,
            mcq2Hi = "एक दयालु पड़ोसी महिला ने कॉलर पर फोन नंबर देख एक महीने बाद बिल्ली वापस लौटाई।"
        ),
        makeProseChapter(
            id = "c9_mo_9",
            classLevel = 9,
            bookName = "Moments",
            chapterNumber = 9,
            category = "Supplementary",
            title = "The Beggar",
            titleHi = "भिखारी",
            author = "Anton Chekhov",
            summaryEn = "Lushkoff, an alcoholic beggar who lies for alms, is caught by advocate Sergei and offered wood-chopping work—yet it is cook Olga's selfless scolding and quiet tears while chopping his wood that genuinely reforms him into a notary.",
            summaryHi = "झूठ बोलकर भीख माँगने वाले शराबी भिखारी लुशकॉफ को वकील सर्गेई लकड़ी काटने का काम देते हैं। लेकिन असल बदलाव सर्गेई की रसोइन ओल्गा के निस्वार्थ त्याग और आँसुओं से आता है, जो चुपचाप उसके हिस्से की लकड़ी काटती थी। दो साल बाद लुशकॉफ एक सम्मानजनक नोटरी बन जाता है।",
            hindiExplanation = "वकील सर्गेई ने जब भिखारी लुशकॉफ का झूठ पकड़ा कि वह कभी छात्र नहीं बल्कि रूसी गायक मंडली से निकाला गया शराबी था, तो उन्होंने भीख देने के बजाय अपने घर पर लकड़ी काटने का काम दिया। लुशकॉफ कमजोरी के कारण लकड़ी काट नहीं सकता था। सर्गेई की सख्त दिखने वाली रसोइन ओल्गा उसे डांटती तो थी, पर रो-रोकर खुद सारी लकड़ी काट देती थी! ओल्गा के इस निस्वार्थ प्रेम और करुणा ने लुशकॉफ का हृदय बदल दिया—उसने शराब छोड़ दी और मेहनत से नोटरी बन गया।",
            themeEn = "Unconditional compassion and empathy heal ruined souls far better than harsh sermons.",
            themeHi = "निस्वार्थ करुणा और सहानुभूति भटके हुए व्यक्ति के जीवन को सदा के लिए बदल सकती है।",
            messageHi = "भीख से किसी का भविष्य नहीं सुधरता; सम्मानजनक काम और स्नेहपूर्ण मार्गदर्शन से व्यक्ति आत्मनिर्भर बनता है।",
            words = listOf(
                w("Mendicant", "noun", "A beggar", "भिखारी", "Sergei stared sternly at the ragged mendicant."),
                w("Swindling", "verb", "Cheating people out of money", "ठगी करना / धोखा देना", "Sergei accused Lushkoff of swindling passersby."),
                w("Waif", "noun", "A homeless, helpless thin person", "बेसहारा व कमजोर व्यक्ति", "The pale waif trembled in the cold shed."),
                w("Notary", "noun", "Official authorized to certify legal documents", "कानूनी दस्तावेज प्रमाणक (नोटरी)", "Two years later, Lushkoff worked cleanly as a notary."),
                w("Roasting", "noun", "Severe scolding", "कड़ी डाँट-फटकार", "Olga gave him a fierce verbal roasting before helping.")
            ),
            matchPairs = listOf(
                MatchPair("Lushkoff", "Reformed beggar turned notary"),
                MatchPair("Sergei", "Advocate who offered work"),
                MatchPair("Olga", "Kind cook who chopped wood secretly"),
                MatchPair("35 roubles", "Lushkoff's monthly notary salary")
            ),
            extract1 = ExtractSpec(
                extractText = "“She would sit down opposite me and grow sad, look into my face and weep... For her sake I gave up drinking.”",
                promptEn = "Who was truly responsible for reforming Lushkoff's life and how?",
                promptHi = "लुशकॉफ का जीवन बदलने का असली श्रेय किसे जाता है और कैसे?",
                answerEn = "Cook Olga; though she scolded him harshly, she cried over his misery and silently chopped all his wood.",
                answerHi = "रसोइन ओल्गा को; वह बाहर से डांटती थी पर उसके दुःख पर रोती और चुपचाप उसकी सारी लकड़ियाँ काट देती थी।"
            ),
            extract2 = ExtractSpec(
                extractText = "“I cannot get on without lying. Nobody will give me anything when I tell the truth.”",
                promptEn = "Why did Lushkoff invent false stories of being a teacher or student?",
                promptHi = "लुशकॉफ स्कूल शिक्षक या छात्र होने का झूठ क्यों बोलता था?",
                answerEn = "Because people refused to give alms when he admitted he was fired from a choir for drunkenness.",
                answerHi = "क्योंकि सच बताने पर कोई दया दिखाकर भीख नहीं देता था।"
            ),
            pyqPromptEn = "Compare the roles played by Sergei and Olga in changing Lushkoff.",
            pyqPromptHi = "लुशकॉफ को सुधारने में सर्गेई और ओल्गा की भूमिकाओं की तुलना कीजिए।",
            pyqAnswerEn = "Sergei gave Lushkoff initial work and dignity, whereas Olga touched his heart through silent sacrifice and deep human tears.",
            pyqAnswerHi = "सर्गेई ने उसे काम का अवसर दिया, जबकि ओल्गा के निस्वार्थ आंसुओं और त्याग ने उसका हृदय परिवर्तन किया।",
            mcq1Prompt = "What profession did Lushkoff hold when Sergei met him outside the theatre two years later?",
            mcq1Options = listOf("School teacher", "Notary", "Doctor", "Actor"),
            mcq1Correct = 1,
            mcq1Hi = "दो साल बाद लुशकॉफ 35 रूबल प्रति माह वेतन पर नोटरी (Notary) बन चुका था।",
            mcq2Prompt = "Who actually chopped the wood in Sergei's woodshed?",
            mcq2Options = listOf("Sergei himself", "Olga the cook", "Lushkoff's friend", "A neighbor"),
            mcq2Correct = 1,
            mcq2Hi = "सर्गेई की दयालु रसोइन ओल्गा ने ही लुशकॉफ के हिस्से की सारी लकड़ियाँ काटी थीं।"
        )
    )

    val specs: Map<String, ChapterRichSpec> = listOf(
        ChapterRichSpec(
            chapterId = "c9_mo_3",
            detailedHindiTeaching = "आर.के. लक्ष्मण की यह हास्य व रहस्यमयी कहानी दिखाती है कि कहानी सुनाने की कला किसी व्यक्ति के दिमाग पर कितना गहरा असर डाल सकती है। ईश्वरन छोटे-से पेड़ के गिरने को भी विशाल राक्षस जैसा बनाकर पेश करता है!",
            paragraphs = listOf(
                p(1, "ईश्वरन का खाना व कहानी सुनाने का जादू", "Iswaran cooked anywhere and read Tamil thrillers to weave endless suspenseful tales for Mahendra.", "निर्माण स्थलों पर ईश्वरन बिना शिकायत के काम करता और रोज़ रात को महेंद्र के लिए टीवी से भी बढ़कर रोमांचक कहानियाँ सुनाता था।", "सकारात्मक और रचनात्मक व्यक्ति हर जगह माहौल रोचक बना देता है।"),
                p(2, "पागल हाथी की वीरतापूर्ण कहानी", "He claimed as a boy he floored a runaway tusker by hitting a nerve on its third toenail.", "ईश्वरन ने बताया कि स्कूल के खेल मैदान में घुसे पागल हाथी को उसने जापानी कला से एक छड़ी मारकर गिरा दिया था।", "अतिशयोक्ति कहानियों को मनोरंजक बनाती है, पर सच से अलग हो सकती है।"),
                p(3, "पूर्णिमा की रात भूत का डर और त्यागपत्र", "One full-moon night, strange moaning outside the window terrified Mahendra into resigning.", "भूतों से न डरने का दावा करने वाले महेंद्र ने जब पूर्णिमा की रात खिड़की से सफेद साया देखा, तो वह डर के मारे नौकरी छोड़ बैठा।", "अंधविश्वास मन में बैठ जाए तो तार्किक व्यक्ति भी घबरा जाता है।")
            ),
            characters = listOf(
                ch("Iswaran", "ईश्वरन", "कुशल रसोइया व नाटकीय कथाकार", listOf("मेहनती", "कल्पनाशील", "उत्तम अभिनेता"), "ईश्वरन अपने मालिक के लिए हर सुविधा जुटाता था और तमिल थ्रिलर पढ़कर रोमांचक किस्से गढ़ता था।", "Iswaran is an imaginative cook whose dramatic narration creates both wonder and fear."),
                ch("Mahendra", "महेंद्र", "सरल जूनियर सुपरवाइज़र", listOf("कर्तव्यनिष्ठ", "पहले तार्किक", "भावुक व डरा हुआ"), "महेंद्र अकेले रहते हुए ईश्वरन की कहानियों का आनंद लेता है, पर अंत में भूत की बात से घबरा जाता है।", "Mahendra is an ordinary bachelor supervisor who dismisses ghosts until fear overtakes him.")
            ),
            cartoonScenes = listOf(
                sc(1, "सुपरवाइज़र का अस्थायी घर", "Site Life", "कहीं तंबू तो कहीं ईंटों का मकान—महेंद्र के हर तबादले में रसोइया ईश्वरन हँसते हुए साथ चलता है!", "Mahendra", "Iswaran", CartoonSetting.HOME_GARDEN, CartoonMood.HAPPY, "Moving Camps"),
                sc(2, "पागल हाथी और स्कूल मैदान", "Tusker Tale", "हाथ-पैर नचाते हुए ईश्वरन सुना रहा है—देखते ही देखते मैंने हाथी के तीसरे नाखून पर वार किया!", "Iswaran", "Elephant", CartoonSetting.CITY_MARKET, CartoonMood.DRAMATIC, "Dramatic Story"),
                sc(3, "कब्रिस्तान की डरावनी बात", "Haunted Talk", "रात के खाने पर ईश्वरन बोला—साहब, यह जगह पहले श्मशान थी और पूर्णिमा को भूतनी दिखती है!", "Iswaran", "Mahendra", CartoonSetting.HOME_GARDEN, CartoonMood.MYSTERY, "Spooky Warning"),
                sc(4, "चाँदनी रात में खिड़की के बाहर साया", "Leaving Forever", "सुबह ईश्वरन मुस्कुराकर बोला—देखा साहब? और महेंद्र अपना इस्तीफा थमा कर चल पड़ा!", "Mahendra", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.THOUGHTFUL, "Superstition Lesson")
            )
        ),
        ChapterRichSpec(
            chapterId = "c9_mo_4",
            detailedHindiTeaching = "ए.के. रामानुजन द्वारा संकलित यह कन्नड़ लोककथा मज़ेदार व्यंग्य है। जब सत्ता मूर्खों के हाथ में होती है तो न्याय भी मज़ाक बन जाता है—केवल एक सच्चा गुरु अपनी सूझबूझ से शिष्य को मौत के मुँह से निकालता है।",
            paragraphs = listOf(
                p(1, "मूर्खों का अनोखा राज्य", "Everything cost one duddu and citizens worked at night and slept by day under royal orders.", "इस राज्य में दिन में सोकर रात को जागने का फरमान था और हर वस्तु एक दुड्डू में मिलती थी।", "जहाँ नियम तर्क से परे हों, वहाँ रहना खतरे से खाली नहीं।"),
                p(2, "चोर की मौत और हास्यास्पद मुकदमा", "After a burglar died under a weak wall, blame shifted from merchant to bricklayer, dancing girl, and goldsmith.", "दीवार गिरने से चोर मरने पर राजा ने बारी-बारी व्यापारी, राजमिस्त्री, नर्तकी और सुनार पर दोष मढ़ा और अंत में मोटे शिष्य को पकड़ लिया!", "मूर्ख न्याय प्रणाली दोषियों की जगह निर्दोषों को फँसा देती है।"),
                p(3, "गुरु की बुद्धिमत्ता से बचाव", "The guru convinced the king the new stake granted kingship in the next birth, trapping the foolish rulers themselves.", "गुरु ने सूली को 'राजपाट की सूली' बताकर लालची राजा और मंत्री को स्वयं फाँसी पर चढ़ने को मजबूर कर दिया।", "संकट में बुद्धि और वाक्-चातुर्य जान बचा सकते हैं।")
            ),
            characters = listOf(
                ch("The Wise Guru", "बुद्धिमान गुरु", "दूरदर्शी व चतुर मार्गदर्शक", listOf("विवेकशील", "शांतिप्रिय", "युक्तिवान"), "गुरुजी ने लालच में न फँसकर पहले ही राज्य छोड़ा और मुसीबत में शिष्य को चालाकी से बचाया।", "The Guru combines spiritual wisdom with quick-witted presence of mind."),
                ch("The Disciple", "लालची शिष्य", "सस्ते भोजन का शौकीन युवा", listOf("भोला", "स्वाद का लालची", "पछताने वाला"), "वह घी-केले के सस्ते दाम देख रुक जाता है, पर संकट में गुरु की सीख समझ जाता है।", "The Disciple learns through near-tragedy why wisdom matters more than cheap comfort.")
            ),
            cartoonScenes = listOf(
                sc(1, "उल्टा राज्य: दिन में सन्नाटा!", "Daytime Sleep", "अरे! दिन के उजाले में पूरा शहर सो रहा है और एक दुड्डू में ढेर सारी मिठाई मिल रही है!", "Guru", "Disciple", CartoonSetting.CITY_MARKET, CartoonMood.MYSTERY, "Strange Kingdom"),
                sc(2, "चोर और दरबार का तमाशा", "Absurd Trial", "दीवार गिरी चोर पर, और मूर्ख राजा कभी सुनार तो कभी नर्तकी को सज़ा सुना रहा है!", "Foolish King", "Minister", CartoonSetting.ROYAL_PALACE, CartoonMood.DRAMATIC, "Royal Court"),
                sc(3, "सूली के सामने शिष्य की पुकार", "Guru Returns", "हे गुरुदेव! मेरी रक्षा कीजिए! तभी गुरुजी चुपचाप शिष्य के कान में शानदार योजना बताते हैं!", "Guru", "Disciple", CartoonSetting.ROYAL_PALACE, CartoonMood.THOUGHTFUL, "Clever Plan"),
                sc(4, "राजा बनाम बुद्धि", "Wisdom Triumphs", "लालची राजा-मंत्री खुद सूली पर चढ़ गए और गुरु-शिष्य ने राज्य में समझदारी से शासन शुरू किया!", "Guru", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "New Era")
            )
        ),
        ChapterRichSpec(
            chapterId = "c9_mo_6",
            detailedHindiTeaching = "हर्ष मंदर की यह सच्ची कहानी बताती है कि 1999 के ओडिशा चक्रवात में एक 19 साल का लड़का कैसे पूरे गाँव का सहारा बन गया। परीक्षा में प्रशांत के राहत कार्यों पर दीर्घ उत्तरीय प्रश्न अवश्य आता है!",
            paragraphs = listOf(
                p(1, "350 किमी की आँधी और 36 घंटे छत पर संघर्ष", "A violent super-cyclone trapped Prashant on his friend's roof for two days with fallen coconuts for food.", "पानी चारों तरफ भर गया, पेड़ उखड़ गए और लाशें तैरने लगीं। प्रशांत छत से सब देख अपने परिवार की चिंता में डूब गया।", "प्रकृति के प्रकोप के बीच जीवित रहना पहला संघर्ष था।"),
                p(2, "18 किमी तैरकर गाँव वापसी", "Wading through chest-deep water with a long stick, Prashant reached Kalikuda and found his family safe.", "कमर से गर्दन तक गहरे पानी में लाठी के सहारे चलते हुए प्रशांत अपने गाँव पहुँचा और दादी व भाई-बहनों को जीवित पाकर रो पड़ा।", "परिवार के प्रति प्रेम खतरनाक रास्तों को भी पार करा देता है।"),
                p(3, "हेलीकॉप्टर संकेत व समाज सेवा", "At the Red Cross shelter, he organized cleanliness teams, signalled choppers, and united widows with orphans.", "उसने बच्चों के पेट पर खाली थालियाँ रखकर हेलीकॉप्टर को संदेश दिया और विधवाओं व अनाथ बच्चों का नया परिवार बसाया।", "सच्चा नेतृत्व दूसरों के आँसू पोंछने से पहचान पाता है।")
            ),
            characters = listOf(
                ch("Prashant", "प्रशांत (19 वर्ष)", "अद्भुत युवा आपदा नायक", listOf("निडर", "संगठनकर्ता", "संवेदनशील"), "स्वयं का घर टूटने के बाद भी वह निराश न होकर पूरे 2500 शरणार्थियों की देखभाल करता है।", "Prashant shows mature empathy, practical leadership, and resilience after a catastrophic cyclone.")
            ),
            cartoonScenes = listOf(
                sc(1, "ओडिशा में 1999 का महाचक्रवात", "Super Cyclone", "तेज़ हवाएँ और लगातार बारिश! प्रशांत और उसका परिवार दो दिन छत पर नारियल खाकर डटे हैं!", "Prashant", "Friends", CartoonSetting.FARM_STORM, CartoonMood.DRAMATIC, "Storm Fury"),
                sc(2, "कमर तक पानी में गाँव की राह", "Journey Home", "लंबी लाठी से रास्ता टटोलते हुए प्रशांत 18 किमी चलकर अपने गाँव कालीकुडा पहुँचा!", "Prashant", "Villagers", CartoonSetting.OCEAN_SHIP, CartoonMood.THOUGHTFUL, "Long Walk"),
                sc(3, "आकाश की ओर खाली थालियाँ", "Helicopter Signal", "शानदार उपाय! बच्चों ने रेत पर थालियाँ रखीं और ऊपर से हेलीकॉप्टर ने भोजन गिराया!", "Prashant", "Children", CartoonSetting.CITY_MARKET, CartoonMood.HAPPY, "Smart Rescue"),
                sc(4, "विधवाओं और बच्चों की मुस्कान", "Rebuilding Lives", "अनाथ बच्चों और विधवाओं को साथ लाकर प्रशांत ने सबको नई उम्मीद दे दी!", "Prashant", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.INSPIRING, "Youth Power")
            )
        ),
        ChapterRichSpec(
            chapterId = "c9_mo_8",
            detailedHindiTeaching = "ज़ैन गॉडियोसो की यह आत्मकथात्मक कहानी हर विद्यार्थी के दिल को छूती है। जब सब कुछ जलकर राख हो गया, तब अजनबी सहपाठियों के छोटे-छोटे उपहारों ने एक टूटे लड़के को जीवन से प्यार करना सिखाया!",
            paragraphs = listOf(
                p(1, "नया स्कूल और अकेलापन", "Moving to a bigger high school made Zan feel awkward and isolated from old friends.", "पुराने जूनियर स्कूल के शिक्षकों व दोस्तों से बिछड़कर ज़ैन नए स्कूल में गुमसुम रहने लगा।", "नए माहौल में घुलने-मिलने में समय लगता है।"),
                p(2, "रविवार की भयानक आग", "Fire engulfed his home; firefighters saved his mother who ran inside for her late husband's pictures.", "अचानक पूरे घर में आग लग गई। सब कुछ खाक हो गया और उसकी प्यारी बिल्ली भी कहीं खो गई।", "संपत्ति से ज्यादा अपनों का जीवन और स्मृतियाँ अनमोल होती हैं।"),
                p(3, "स्कूल में उपहार और बिल्ली की वापसी", "Classmates gifted notebooks and clothes, and a kind stranger tracked down and returned his red tabby cat.", "अगले दिन स्कूल में मेज पर सजे उपहार देख ज़ैन की आँखों से अकेलेपन के बादल छँट गए।", "प्यार और समुदाय की दया हर नुकसान की भरपाई कर देती है।")
            ),
            characters = listOf(
                ch("Zan Gaudioso", "ज़ैन गॉडियोसो", "संवेदनशील किशोर कथाकार", listOf("बिल्ली-प्रेमी", "भावनात्मक", "कृतज्ञ"), "आग में घर और बिल्ली खोने के बाद स्कूल के मित्रों की मदद से वह जीवन का असली अर्थ समझता है।", "Zan moves from lonely despair to deep gratitude through community empathy.")
            ),
            cartoonScenes = listOf(
                sc(1, "नए स्कूल की सूनी राहें", "Lonely Teen", "नए हाईस्कूल में ज़ैन अकेला खड़ा है—उसे अपनी प्यारी बिल्ली और पुराने दोस्त याद आ रहे हैं!", "Zan", "Cat", CartoonSetting.CLASSROOM, CartoonMood.THOUGHTFUL, "Missing Old School"),
                sc(2, "घर में भयानक आग की लपटें", "Sunday Fire", "हवा में धुआँ और लपटें! बहादुर माँ पिता की यादें बचाने भीतर भागीं, फायरमैन ने उन्हें बचाया!", "Zan", "Mother", CartoonSetting.HOME_GARDEN, CartoonMood.DRAMATIC, "House Fire"),
                sc(3, "जिम हॉल में उपहारों का ढेर", "School Kindness", "अरे वाह! पूरे स्कूल ने ज़ैन के लिए बैग, कॉपियाँ और नए जूते इकट्ठे कर दिए—अब वह अकेला नहीं!", "Zan", "Classmates", CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Warm Support"),
                sc(4, "एक महीने बाद बिल्ली वापस!", "Happy Reunion", "दरवाज़े पर एक नेक महिला अपनी गोद में ज़ैन की लाल बिल्ली लाई—इमरान सर कहते हैं, प्यार ही घर है!", "Zan", "Imran Sir", CartoonSetting.HOME_GARDEN, CartoonMood.INSPIRING, "True Home")
            )
        ),
        ChapterRichSpec(
            chapterId = "c9_mo_9",
            detailedHindiTeaching = "रूस के महान लेखक एंटन चेखव की यह कहानी दिखाती है कि कठोर उपदेश से नहीं, बल्कि किसी के निस्वार्थ आंसुओं से इंसान बदलता है। ओल्गा का चरित्र इस पाठ की आत्मा है!",
            paragraphs = listOf(
                p(1, "भिखारी लुशकॉफ का झूठ पकड़ा जाना", "Sergei recognized Lushkoff lying about being a teacher after pretending earlier to be an expelled student.", "सर्गेई ने याद दिलाया कि परसों वह खुद को छात्र बता रहा था और आज स्कूल मास्टर बताकर पैसे माँग रहा है।", "सच्चाई से भागना और झूठ पर जीना सम्मान छीन लेता है।"),
                p(2, "लकड़ी काटने का काम और ओल्गा की भूमिका", "Too weak from alcohol to chop wood, Lushkoff stood by while cook Olga wept and chopped the wood for him.", "कड़ाके की ठंड में ओल्गा पहले उसे भला-बुरा कहती, फिर दया से रो पड़ती और खुद सारी लकड़ी काट देती थी!", "मौन सेवा और निस्वार्थ दयालुता पत्थर दिल को भी पिघला देती है।"),
                p(3, "नोटरी के रूप में नया जीवन", "Years later outside a theatre, well-dressed notary Lushkoff revealed Olga's tears made him quit drinking forever.", "लुशकॉफ ने सर्गेई को धन्यवाद दिया पर सच बताया कि ओल्गा के आँसुओं ने ही उसे शराब छोड़ने पर मजबूर किया।", "सहानुभूति और श्रम इंसान को नया जन्म देते हैं।")
            ),
            characters = listOf(
                ch("Olga", "ओल्गा (रसोइन)", "बाहर से कठोर, भीतर से करुणामय महिला", listOf("निस्वार्थ", "सहानुभूतिपूर्ण", "मेहनती"), "ओल्गा बिना कोई प्रचार किए अपने आँसुओं और मेहनत से लुशकॉफ का जीवन सँवार देती है।", "Olga embodies silent self-sacrifice and redemptive compassion."),
                ch("Lushkoff", "लुशकॉफ", "सुधरा हुआ भूतपूर्व भिखारी", listOf("पहले कमजोर व झूठा", "बाद में कृतज्ञ", "ईमानदार नोटरी"), "ओल्गा की करुणा से प्रेरित होकर वह शराब छोड़ देता है और मेहनती नोटरी बनता है।", "Lushkoff transforms from a deceitful beggar into an honest notary grateful to Olga.")
            ),
            cartoonScenes = listOf(
                sc(1, "सड़क पर झूठ बोलता भिखारी", "Caught Lying", "अरे! कल छात्र और आज शिक्षक? वकील सर्गेई ने लुशकॉफ का झूठ तुरंत पकड़ लिया!", "Sergei", "Lushkoff", CartoonSetting.CITY_MARKET, CartoonMood.DRAMATIC, "Truth Revealed"),
                sc(2, "बर्फ में लकड़ीघर और ओल्गा", "Olga's Secret Help", "ओल्गा डाँट रही है—कामचोर! पर फिर खुद रोते हुए लुशकॉफ की सारी लकड़ियाँ काट रही है!", "Olga", "Lushkoff", CartoonSetting.HOME_GARDEN, CartoonMood.THOUGHTFUL, "Silent Kindness"),
                sc(3, "मेहनत और बदलाव", "Quitting Alcohol", "ओल्गा के आँसुओं ने लुशकॉफ का दिल बदल दिया—उसने नशा छोड़ा और लेखन कार्य सीख लिया!", "Lushkoff", "Sergei", CartoonSetting.CITY_MARKET, CartoonMood.INSPIRING, "Self Reform"),
                sc(4, "थिएटर के बाहर गर्व भरी भेंट", "Notary Lushkoff", "कोट पहने नोटरी लुशकॉफ ने कहा—सर, ओल्गा के त्याग ने मुझे बचा लिया! इमरान सर की सलामी!", "Lushkoff", "Imran Sir", CartoonSetting.CLASSROOM, CartoonMood.HAPPY, "Dignity Won")
            )
        )
    ).associateBy { it.chapterId }
}
