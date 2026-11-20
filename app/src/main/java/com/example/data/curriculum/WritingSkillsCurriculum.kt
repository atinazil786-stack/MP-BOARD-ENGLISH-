package com.example.data.curriculum

import com.example.data.model.WritingExamQuestion
import com.example.data.model.WritingExercise
import com.example.data.model.WritingSkillTopic
import com.example.data.model.WritingSolvedExample

object WritingSkillsCurriculum {

    val topics: List<WritingSkillTopic> = listOf(
        // 1. Note Making
        WritingSkillTopic(
            id = "ws_note_making",
            order = 1,
            titleEn = "Note Making & Summarizing",
            titleHi = "नोट मेकिंग और सारांश लेखन",
            applicableClasses = listOf(9, 10, 11, 12),
            syllabusNoteHi = "MP Board Class 9th, 10th, 11th व 12th में Unseen Passage पर आधारित 4 अंक (Note Making + Title) का अनिवार्य प्रश्न आता है।",
            explanationHi = "नोट मेकिंग का अर्थ है किसी बड़े अनुच्छेद (Passage) को पढ़कर उसके मुख्य बिंदुओं (Main Points) और उप-बिंदुओं (Sub-Points) को संक्षिप्त रूप में लिखना। इसमें पूरे वाक्य नहीं लिखे जाते बल्कि छोटे वाक्यांश (Phrases) और संक्षिप्त शब्दों (Abbreviations) का उपयोग किया जाता है। अंत में एक उपयुक्त शीर्षक (Title) और Key to Abbreviations बॉक्स बनाना बहुत जरूरी होता है।",
            rulesAndFormatEn = listOf(
                "Give a short, catchy Title in Capital Letters (1 mark).",
                "Use standard indentation: 1, 1.1, 1.2, 2, 2.1, 2.2 (2 marks).",
                "Do NOT write full sentences — use concise phrases.",
                "Use at least 4–5 standard abbreviations & list them in a Key box (1 mark)."
            ),
            formatTemplate = """
TITLE: IMPORTANCE OF TIME MANAGEMENT

1. Meaning of Time Management
   1.1 Planning daily schedule
   1.2 Prioritising imp. tasks
   1.3 Avoiding procrastination
2. Benefits for Students
   2.1 Better exam prep. & less stress
   2.2 Balanced study-rest routine
   2.3 Higher acad. achievement
3. Practical Tips
   3.1 Make to-do lists
   3.2 Avoid mobile distractions

Key to Abbreviations:
• imp.   = important
• prep.  = preparation
• acad.  = academic
• &      = and
            """.trimIndent(),
            stepsHi = listOf(
                "Step 1: पैसेज को ध्यान से दो बार पढ़ें और मुख्य विषय (Central Idea) पहचानें।",
                "Step 2: विषय के अनुसार 2 से 4 शब्दों का छोटा और सटीक Title ऊपर लिखें।",
                "Step 3: मुख्य विचारों को 1, 2, 3 नंबर दें और उनके अंदर के बिंदुओं को 1.1, 1.2, 2.1, 2.2 लिखें।",
                "Step 4: कम से कम 4 शब्दों के संक्षिप्त रूप (जैसे edu., govt., imp., dev.) बनाकर नीचे बॉक्स में लिखें।"
            ),
            solvedExamples = listOf(
                WritingSolvedExample(
                    title = "Solved Example: Healthy Lifestyle & Yoga",
                    questionEn = "Read a passage on how yoga and balanced diet improve student concentration, immunity, and mental peace. Make notes on it using recognizable abbreviations and supply a suitable title.",
                    englishAnswer = """
TITLE: YOGA AND HEALTHY LIFESTYLE

1. Need for Healthy Habits
   1.1 Modern life full of stress
   1.2 Junk food causes obesity & fatigue
2. Role of Yoga
   2.1 Improves conc. & memory power
   2.2 Builds strong immunity & flexibility
   2.3 Brings mental peace
3. Balanced Diet Essentials
   3.1 Fresh fruits, green veg. & milk
   3.2 Drinking 8 glasses of water daily

Key to Abbreviations:
• &     = and
• conc. = concentration
• veg.  = vegetables
• reqd. = required
                    """.trimIndent(),
                    hindiExplanation = "इस उदाहरण में शीर्षक बड़े अक्षरों में लिखा गया है। हर मुख्य बिंदु के नीचे 2–3 उप-बिंदु स्पष्ट इंडेंटेशन (1.1, 1.2) के साथ दिए गए हैं और कोई भी पूरा वाक्य नहीं लिखा गया है। अंत में 4 Abbreviations का Key बॉक्स पूरे अंक दिलाता है।"
                )
            ),
            examQuestionsAndModels = listOf(
                WritingExamQuestion(
                    id = "wq_nm_1",
                    boardRef = "MP Board Exam Pattern (Class 10–12)",
                    marks = 4,
                    questionEn = "Make notes on a passage describing 'Save Trees, Save Earth' covering deforestation causes, ecological impact, and afforestation steps. Supply a suitable title.",
                    questionHi = "'पेड़ बचाओ, पृथ्वी बचाओ' विषय पर वनों की कटाई के कारण, प्रभाव और वृक्षारोपण के उपायों पर नोट्स बनाइए एवं शीर्षक लिखिए।",
                    modelAnswer = """
TITLE: SAVE TREES, SAVE EARTH

1. Causes of Deforestation
   1.1 Rapid urban. & housing growth
   1.2 Need for wood & ind. land
2. Harmful Effects
   2.1 Global warming & erratic rain
   2.2 Soil erosion & wildlife loss
3. Solutions & Action
   3.1 Mass plantation drives
   3.2 Strict govt. forest laws
   3.3 Recycling paper products

Key to Abbreviations:
• urban. = urbanization
• ind.   = industrial
• govt.  = government
• &      = and
                    """.trimIndent()
                )
            ),
            practiceExercises = listOf(
                WritingExercise(
                    id = "wp_nm_1",
                    promptEn = "Prepare clean Notes with Title and 4 Abbreviations on: 'Benefits of Reading Books in the Digital Age' (mention focus, vocabulary, imagination, vs screen fatigue).",
                    promptHi = "'डिजिटल युग में किताबें पढ़ने के लाभ' पर Title व 4 Abbreviations के साथ नोट्स लिखिए।",
                    marks = 4,
                    hintsHi = "शीर्षक: READING IN DIGITAL AGE | मुख्य बिंदु: 1. Importance of Reading, 2. Benefits over Screens, 3. Habits to Build."
                )
            )
        ),

        // 2. Formal Application Writing
        WritingSkillTopic(
            id = "ws_formal_application",
            order = 2,
            titleEn = "Formal Application Writing",
            titleHi = "औपचारिक प्रार्थना पत्र (Application)",
            applicableClasses = listOf(9, 10, 11, 12),
            syllabusNoteHi = "MP Board Class 9th व 10th में 4 अंक का मुख्य प्रश्न तथा Class 11th–12th में स्कूल/कॉलेज स्तर के आवेदन हेतु अनिवार्य।",
            explanationHi = "जब विद्यार्थी अपने विद्यालय के प्राचार्य (Principal) या कक्षा शिक्षक को किसी विशेष कारण से (जैसे अवकाश, शुल्क मुक्ति, टीसी/स्थानांतरण प्रमाण पत्र, या बुक बैंक से पुस्तकें प्राप्त करने हेतु) पत्र लिखते हैं, उसे Formal Application कहते हैं। इसकी भाषा विनम्र, स्पष्ट और सटीक होनी चाहिए।",
            rulesAndFormatEn = listOf(
                "Align the entire application strictly to the LEFT margin (Modern MPBSE Block Format).",
                "Do NOT put an apostrophe in 'Yours obediently'.",
                "State the Subject clearly in one crisp line.",
                "Mention exact dates / duration if applying for leave."
            ),
            formatTemplate = """
To,
The Principal,
Govt. Higher Secondary School,
[City / District (M.P.)]

Date: 15 October 2025

Subject: Application for [clear purpose].

Respected Sir/Madam,

Most humbly I beg to state that I am a regular student of Class [X] in your school. [State your reason politely in 3–4 lines].

Kindly grant me [permission / leave / certificate]. I shall be highly obliged to you.

Thanking you.

Yours obediently,
Name: [Name given in exam / ABC]
Class: [X]
            """.trimIndent(),
            stepsHi = listOf(
                "Step 1: बाईं तरफ 'To, The Principal,' व विद्यालय का नाम लिखें (जो प्रश्न में दिया हो)।",
                "Step 2: दिनांक के बाद 'Subject:' लिखकर एक लाइन में कारण स्पष्ट करें।",
                "Step 3: 'Respected Sir/Madam,' से शुरुआत कर विनम्र भाषा में अपना निवेदन लिखें।",
                "Step 4: अंत में 'Yours obediently,' के बाद प्रश्न में दिया नाम और कक्षा लिखें (असली नाम/रोल नंबर न लिखें)।"
            ),
            solvedExamples = listOf(
                WritingSolvedExample(
                    title = "Solved Example: Transfer Certificate (T.C.) Application",
                    questionEn = "You are Ankit Verma studying in Govt. H.S. School, Ujjain. Write an application to your Principal requesting him to issue your Transfer Certificate (T.C.) as your father has been transferred to Indore.",
                    englishAnswer = """
To,
The Principal,
Govt. Higher Secondary School,
Ujjain (M.P.)

Date: 12 July 2025

Subject: Application for issuing Transfer Certificate (T.C.).

Respected Sir,

With due respect, I beg to state that I am a regular student of Class X-A of your school. My father is a government employee and has been transferred from Ujjain to Indore last week. Our entire family is shifting there soon.

Therefore, I am unable to continue my studies here. Kindly issue my Transfer Certificate at the earliest so that I may take admission in a new school in Indore. I have cleared all school dues and returned all library books.

Thanking you.

Yours obediently,
Ankit Verma
Class X-A
                    """.trimIndent(),
                    hindiExplanation = "यह MP Board का सबसे अधिक पूछे जाने वाला आवेदन है। ध्यान दें कि प्रश्न में दिया गया नाम (Ankit Verma) और स्कूल (Govt. H.S. School, Ujjain) ही लिखा गया है। सभी स्कूल बकाया क्लियर होने की बात लिखना उत्तर को प्रभावशाली बनाता है।"
                )
            ),
            examQuestionsAndModels = listOf(
                WritingExamQuestion(
                    id = "wq_app_1",
                    boardRef = "MP Board High School Frequent Question",
                    marks = 4,
                    questionEn = "Write an application to the Principal of your school requesting him for full fee concession (Scholarship / Poor Boy Fund).",
                    questionHi = "अपने विद्यालय के प्राचार्य को पूर्ण शुल्क मुक्ति (Fee Concession) हेतु प्रार्थना पत्र लिखिए।",
                    modelAnswer = """
To,
The Principal,
Govt. Model H.S. School,
Bhopal (M.P.)

Date: 05 August 2025

Subject: Application for full fee concession.

Respected Sir,

Most humbly I beg to state that I am a regular student of Class X in your school. My father is a small farmer with a very limited monthly income. He has to support a large family and finds it difficult to pay my school fees.

I am a hardworking student and scored 88% marks in Class IX. I am keen to continue my studies sincerely. Kindly grant me full fee concession from the Poor Boys' Fund for the current academic session.

Thanking you.

Yours obediently,
Rohit Patidar
Class X
                    """.trimIndent()
                )
            ),
            practiceExercises = listOf(
                WritingExercise(
                    id = "wp_app_1",
                    promptEn = "Write an application to your Principal requesting 4 days' sick leave as you are suffering from viral fever.",
                    promptHi = "वायरल बुखार के कारण 4 दिन के अवकाश हेतु प्राचार्य को अंग्रेजी में आवेदन लिखिए।",
                    marks = 4,
                    hintsHi = "Subject: Application for 4 days' sick leave | कारण व डॉक्टर की सलाह का उल्लेख करें।"
                )
            )
        ),

        // 3. Informal Letter Writing
        WritingSkillTopic(
            id = "ws_informal_letter",
            order = 3,
            titleEn = "Informal Letter Writing",
            titleHi = "अनौपचारिक पत्र लेखन",
            applicableClasses = listOf(9, 10, 11, 12),
            syllabusNoteHi = "MP Board Class 9th, 10th, 11th और 12th सभी कक्षाओं में मित्र/भाई/माता-पिता को पत्र (4 अंक) अक्सर विकल्प (OR) में आता है।",
            explanationHi = "मित्रों, माता-पिता, भाई-बहन या रिश्तेदारों को लिखे जाने वाले व्यक्तिगत पत्र Informal Letters कहलाते हैं। इनमें Subject (विषय) नहीं लिखा जाता और न ही 'To' लिखा जाता है। इनकी भाषा आत्मीय, सरल और स्नेहपूर्ण होती है।",
            rulesAndFormatEn = listOf(
                "Start with Sender's Address (your address given in question) on top-left.",
                "Do NOT write a Subject line in informal letters.",
                "Use friendly salutations: 'Dear Father,', 'Dear Friend Rahul,'.",
                "End warmly: 'Yours affectionately,' (for family) or 'Your sincere friend,' (for friends)."
            ),
            formatTemplate = """
[Sender's House No. / Street]
[City (M.P.)]

Date: 20 February 2025

Dear [Friend's Name / Father],

I am fine here and hope the same for you. [Main message in 2 short paragraphs: reason for writing, details, good wishes].

Please convey my regards to Uncle and Aunty and love to younger ones.

Yours lovingly / Your sincere friend,
[Name from question]
            """.trimIndent(),
            stepsHi = listOf(
                "Step 1: सबसे ऊपर बाईं ओर अपना पता (Sender's Address) और फिर तारीख लिखें।",
                "Step 2: 'Dear [Name],' लिखकर कुशल-मंगल पूछें ('I am fine here and hope you are doing well').",
                "Step 3: मुख्य बात जैसे शादी का निमंत्रण, सफलता की बधाई, या गर्मी की छुट्टियों का निमंत्रण लिखें।",
                "Step 4: बड़ों को प्रणाम ('Convey my regards to parents') लिखकर 'Yours lovingly,' से समाप्त करें।"
            ),
            solvedExamples = listOf(
                WritingSolvedExample(
                    title = "Solved Example: Congratulating a Friend on Brilliant Success",
                    questionEn = "You arePriya / Yash residing at 14, Nehru Nagar, Jabalpur. Write a letter to your friend congratulating him/her on his/her brilliant success in the MP Board Class 10th/12th examination.",
                    englishAnswer = """
14, Nehru Nagar,
Jabalpur (M.P.)

Date: 25 May 2025

Dear Aarav,

I am very happy to know that you have passed the Board Examination with 94% marks and secured a position in the State Merit List. Accept my heartiest congratulations on this brilliant achievement!

Your hard work, discipline, and regular study have finally brought great honour to your parents and teachers. I am proud of having a sincere friend like you. We will celebrate together when I visit your home next Sunday.

Please convey my respectful regards to Uncle and Aunty.

Your sincere friend,
Yash
                    """.trimIndent(),
                    hindiExplanation = "इस पत्र में कोई Subject नहीं है। शुरुआत Sender's Address से हुई है और दो छोटे पैराग्राफ में बधाई और भावनाएं व्यक्त की गई हैं। MP Board में यह प्रश्न बार-बार पूछा जाता है।"
                )
            ),
            examQuestionsAndModels = listOf(
                WritingExamQuestion(
                    id = "wq_inf_1",
                    boardRef = "MP Board Class 9–12 Standard Question",
                    marks = 4,
                    questionEn = "Write a letter to your friend inviting him/her to attend your elder brother's marriage ceremony.",
                    questionHi = "अपने मित्र को अपने बड़े भाई की शादी में शामिल होने के लिए निमंत्रण पत्र लिखिए।",
                    modelAnswer = """
42, Civil Lines,
Sagar (M.P.)

Date: 10 November 2025

Dear Kabir,

I hope this letter finds you in good health. You will be glad to know that the marriage of my elder brother is going to take place on 24th November 2025 at Sagar.

I cordially invite you along with your parents to grace the auspicious occasion. Please arrive two days earlier so we can enjoy the pre-wedding functions together.

Convey my regards to your parents. Waiting eagerly for you.

Yours lovingly,
Aman
                    """.trimIndent()
                )
            ),
            practiceExercises = listOf(
                WritingExercise(
                    id = "wp_inf_1",
                    promptEn = "Write a letter to your father requesting him to send Rs. 2,000 to buy reference books and pay exam fees.",
                    promptHi = "किताबें खरीदने व परीक्षा शुल्क हेतु ₹2000 मंगवाने के लिए पिताजी को पत्र लिखिए।",
                    marks = 4,
                    hintsHi = "Respected Father लिखें और अंत में 'Your loving son/daughter' का प्रयोग करें।"
                )
            )
        ),

        // 4. Formal Letter Writing
        WritingSkillTopic(
            id = "ws_formal_letter",
            order = 4,
            titleEn = "Formal Letter Writing (Official / Editor)",
            titleHi = "औपचारिक पत्र (कलेक्टर / संपादक / अधिकारी)",
            applicableClasses = listOf(10, 11, 12),
            syllabusNoteHi = "MP Board Class 10th, 11th और 12th में Collector को Loudspeaker प्रतिबंध, Municipal Officer को स्वच्छता, तथा Editor को समस्या पत्र (4 अंक) नियमित पूछे जाते हैं।",
            explanationHi = "जिला कलेक्टर, नगर निगम आयुक्त, डाकपाल (Postmaster) या समाचार पत्र के संपादक (Editor) को जनसमस्याओं, शिकायतों या सुझावों के लिए लिखे जाने वाले पत्र Formal / Official Letters कहलाते हैं। इनमें Sender's Address के बाद Date और फिर Receiver's Address आता है।",
            rulesAndFormatEn = listOf(
                "Include BOTH Sender's Address and Receiver's Address separated by Date.",
                "Never use slang or emotional language; remain formal and objective.",
                "End with 'Yours faithfully,' or 'Yours sincerely,'."
            ),
            formatTemplate = """
[Sender's Address]
[City (M.P.)]

Date: 08 March 2025

The [Collector / Editor / Commissioner],
[Office / Newspaper Name],
[City (M.P.)]

Subject: Complaint / Request regarding [Issue].

Sir/Madam,

Through this letter, I wish to draw your kind attention towards [describe problem clearly with local details and its impact on citizens/students].

Therefore, I earnestly request you to take immediate action to resolve this issue at the earliest.

Thanking you.

Yours faithfully,
[Name]
            """.trimIndent(),
            stepsHi = listOf(
                "Step 1: पहले अपना पता लिखें, एक लाइन छोड़कर Date लिखें।",
                "Step 2: अधिकारी का पद और कार्यालय का पता (जैसे The Collector, District Indore) लिखें।",
                "Step 3: संक्षिप्त Subject लिखें और समस्या का प्रभाव स्पष्ट करें।",
                "Step 4: उचित समाधान का निवेदन कर 'Yours faithfully,' लिखकर समाप्त करें।"
            ),
            solvedExamples = listOf(
                WritingSolvedExample(
                    title = "Solved Example: Ban on Loudspeakers to District Collector",
                    questionEn = "Write a letter to the Collector of your district requesting him to impose a ban on the use of loudspeakers during board examinations.",
                    englishAnswer = """
22, Tilak Nagar,
Rewa (M.P.)

Date: 18 February 2025

The Collector,
District Rewa (M.P.)

Subject: Request to impose a ban on loudspeakers during board examinations.

Respected Sir,

I wish to bring to your kind notice that the MP Board High School and Higher Secondary Examinations are going to commence next week. However, the indiscriminate use of loudspeakers late at night in our locality causes severe disturbance to students preparing for their exams.

Concentration is essential during these crucial days. On behalf of all students, I earnestly request you to impose an immediate ban on the use of loudspeakers until the examinations are over.

Thanking you.

Yours faithfully,
Neha Tiwari
                    """.trimIndent(),
                    hindiExplanation = "यह MP Board Class 10 और 12 दोनों का अत्यंत महत्वपूर्ण पत्र है। ध्यान दें कि Receiver में 'The Collector' और ऊपर Sender का पता दोनों क्रमशः दिए गए हैं।"
                )
            ),
            examQuestionsAndModels = listOf(
                WritingExamQuestion(
                    id = "wq_fl_1",
                    boardRef = "MP Board Class 11–12 High-Frequency Question",
                    marks = 4,
                    questionEn = "Write a letter to the Municipal Commissioner complaining about irregular water supply / poor sanitary conditions in your ward.",
                    questionHi = "अपने वार्ड में अनियमित जल आपूर्ति एवं गंदगी की शिकायत हेतु नगर निगम आयुक्त को पत्र लिखिए।",
                    modelAnswer = """
18, Subhash Ward,
Gwalior (M.P.)

Date: 14 April 2025

The Municipal Commissioner,
Municipal Corporation,
Gwalior (M.P.)

Subject: Complaint regarding poor sanitation and irregular water supply.

Sir,

Through this letter, I wish to draw your attention to the insanitary conditions in Subhash Ward. Garbage bins have not been cleared for over a week, leading to foul smell and breeding of mosquitoes. Moreover, tap water supply is highly irregular during summer.

Kindly direct the sanitation inspector and water department to take prompt action for public health and convenience.

Thanking you.

Yours faithfully,
Raghavendra Singh
                    """.trimIndent()
                )
            ),
            practiceExercises = listOf(
                WritingExercise(
                    id = "wp_fl_1",
                    promptEn = "Write a letter to the Editor of a local newspaper highlighting the problem of reckless driving near school zones.",
                    promptHi = "विद्यालय के पास लापरवाह वाहन चलाने की समस्या पर समाचार पत्र के संपादक को पत्र लिखिए।",
                    marks = 4,
                    hintsHi = "शुरुआत करें: 'Through the columns of your esteemed newspaper, I wish to highlight...'"
                )
            )
        ),

        // 5. Notice Writing
        WritingSkillTopic(
            id = "ws_notice",
            order = 5,
            titleEn = "Notice Writing",
            titleHi = "सूचना लेखन (Notice)",
            applicableClasses = listOf(11, 12),
            syllabusNoteHi = "MP Board Class 11th और 12th (Section B — Short Composition, 4 अंक) में Notice Writing, Poster Making और Advertisement आपस में विकल्प में आते हैं।",
            explanationHi = "किसी विद्यालय, संस्था या क्लब द्वारा विद्यार्थियों या सदस्यों को किसी कार्यक्रम, प्रतियोगिता, पिकनिक या खोई-पाई वस्तु की जानकारी देने के लिए जो संक्षिप्त सूचना बोर्ड पर लगाई जाती है, उसे Notice कहते हैं। Notice हमेशा एक आयताकार बॉक्स (Box) के अंदर लिखा जाता है और शब्द सीमा लगभग 50 शब्द होती है।",
            rulesAndFormatEn = listOf(
                "MUST draw a neat rectangular BOX around the entire notice.",
                "Write Issuing Organization Name at the top center.",
                "Write 'NOTICE' in capital letters below it; Date on left side.",
                "Answer What, When, Where, Who to contact inside ~50 words."
            ),
            formatTemplate = """
+--------------------------------------------------+
|         GOVT. EXCELLENCE SCHOOL, BHOPAL          |
|                      NOTICE                      |
| Date: 15 Sep 2025                                |
|                                                  |
|           INTER-SCHOOL DEBATE CONTEST            |
|                                                  |
| All students of Classes IX to XII are informed   |
| that an Inter-School Debate Competition will be  |
| held on 25 Sep 2025 at 11:00 AM in the School    |
| Auditorium. Interested students may give their   |
| names to the undersigned by 20 Sep 2025.         |
|                                                  |
| [Signature / Name]                               |
| Secretary, Cultural Club                         |
+--------------------------------------------------+
            """.trimIndent(),
            stepsHi = listOf(
                "Step 1: सबसे पहले एक साफ बॉक्स बनाएं (बिना बॉक्स के 1 अंक कट सकता है)।",
                "Step 2: ऊपर बीच में स्कूल का नाम और अगली लाइन में NOTICE बड़े अक्षरों में लिखें।",
                "Step 3: बाईं तरफ Date लिखकर बीच में कार्यक्रम का Heading लिखें।",
                "Step 4: तारीख, समय, स्थान लिखकर नीचे अपना नाम व पद (Designation) लिखें।"
            ),
            solvedExamples = listOf(
                WritingSolvedExample(
                    title = "Solved Example: Lost Watch Notice",
                    questionEn = "You are Sanya, student of Class XII. You have lost your wristwatch in the school playground. Draft a notice for the school notice board.",
                    englishAnswer = """
+--------------------------------------------------+
|          GOVT. MODEL H.S. SCHOOL, INDORE         |
|                      NOTICE                      |
| Date: 10 Oct 2025                                |
|                                                  |
|                LOST! LOST! LOST!                 |
|                                                  |
| This is to inform all students that I lost my    |
| silver-dial Titan wristwatch in the school       |
| playground yesterday during the lunch break.     |
| It has a black leather strap. Anyone who finds   |
| it is requested to return it to the undersigned  |
| or deposit it in the Principal's office.         |
| A suitable treat is promised!                    |
|                                                  |
| Sanya                                            |
| Class XII-B                                      |
+--------------------------------------------------+
                    """.trimIndent(),
                    hindiExplanation = "Notice में बॉक्स, स्कूल का नाम, NOTICE शीर्षक, तारीख, स्पष्ट विषय, वस्तु का विवरण और संपर्क व्यक्ति का नाम — सभी आवश्यक बिंदु 50 शब्दों के अंदर पूरे किए गए हैं।"
                )
            ),
            examQuestionsAndModels = listOf(
                WritingExamQuestion(
                    id = "wq_not_1",
                    boardRef = "MP Board Class 12th Board Exam Pattern",
                    marks = 4,
                    questionEn = "As Head Boy / Head Girl of your school, draft a notice informing students about a Blood Donation Camp / Annual Function.",
                    questionHi = "स्कूल के हेड बॉय/गर्ल के रूप में वार्षिक उत्सव (Annual Function) हेतु एक Notice तैयार कीजिए।",
                    modelAnswer = """
+--------------------------------------------------+
|        GOVT. H.S. SCHOOL, JABALPUR (M.P.)        |
|                      NOTICE                      |
| Date: 02 Dec 2025                                |
|                                                  |
|             ANNUAL FUNCTION 2025-26              |
|                                                  |
| All students are hereby informed that our school |
| is celebrating its Annual Function on 20 Dec     |
| 2025 at 4:00 PM in the Main Ground. Students     |
| interested in cultural programs (dance, drama,   |
| speech) may register with their class teacher    |
| before 10 Dec 2025.                              |
|                                                  |
| Aarav Sharma                                     |
| Head Boy                                         |
+--------------------------------------------------+
                    """.trimIndent()
                )
            ),
            practiceExercises = listOf(
                WritingExercise(
                    id = "wp_not_1",
                    promptEn = "Draft a notice in a box for an Educational Tour to Pachmarhi organized by your school.",
                    promptHi = "पचमढ़ी के शैक्षणिक भ्रमण (Educational Tour) के लिए बॉक्स में एक Notice लिखिए।",
                    marks = 4,
                    hintsHi = "तिथि, शुल्क, सहमति पत्र (Parents' Consent) और अंतिम तिथि जरूर लिखें।"
                )
            )
        ),

        // 6. Poster Making
        WritingSkillTopic(
            id = "ws_poster",
            order = 6,
            titleEn = "Poster Making",
            titleHi = "पोस्टर निर्माण (Poster Making)",
            applicableClasses = listOf(11, 12),
            syllabusNoteHi = "MP Board Class 11th व 12th के परीक्षा पत्र में 4 अंक का अत्यंत लोकप्रिय प्रश्न ('Say No to Drugs / Plastics', 'Save Water', 'Bomb Blast Alert')।",
            explanationHi = "पोस्टर का उद्देश्य जनता या विद्यार्थियों में किसी सामाजिक विषय (जैसे जल संरक्षण, प्लास्टिक बंद, नशा मुक्ति, वृक्षारोपण) के प्रति जागरूकता फैलाना होता है। पोस्टर हमेशा एक बड़े बॉक्स में, आकर्षक नारे (Slogans), छोटे बुलेट पॉइंट्स और सरल चित्रों (Simple sketches) के साथ बनाया जाता है।",
            rulesAndFormatEn = listOf(
                "Enclose the entire poster inside a prominent decorative border/box.",
                "Write a bold catchy Heading + rhyming Slogans.",
                "Keep text minimal — use phrases and bullet points, NOT paragraphs.",
                "Always mention 'Issued in Public Interest by: [Name/Club]' at the bottom."
            ),
            formatTemplate = """
+--------------------------------------------------+
|           ★ SAVE WATER, SAVE LIFE! ★             |
|        "Every Drop Counts – Don't Waste It"      |
|                                                  |
|      [ Simple Water Drop / Tap Sketch ]          |
|                                                  |
|  HOW CAN YOU HELP?                               |
|  ✔ Close running taps tightly                    |
|  ✔ Practice Rainwater Harvesting                 |
|  ✔ Reuse water for gardening                     |
|  ✔ Never pollute rivers or ponds                 |
|                                                  |
|     NO WATER = NO GREEN = NO FUTURE!             |
|                                                  |
|  Issued by: Eco Club, Govt. H.S. School          |
+--------------------------------------------------+
            """.trimIndent(),
            stepsHi = listOf(
                "Step 1: पूरे पेज की चौड़ाई के बराबर एक आकर्षक बॉक्स बनाएं।",
                "Step 2: सबसे ऊपर बड़े अक्षरों में मुख्य शीर्षक और एक तुकबंदी वाला नारा (Slogan) लिखें।",
                "Step 3: बीच में पेन/पेंसिल से विषय से जुड़ा आसान सा चित्र बनाएं (जैसे पानी की बूंद या पेड़)।",
                "Step 4: 4 से 5 छोटे बुलेट पॉइंट्स लिखें और नीचे 'Issued by: ...' जरूर लिखें।"
            ),
            solvedExamples = listOf(
                WritingSolvedExample(
                    title = "Solved Example: Say No to Plastics",
                    questionEn = "Design an attractive and effective poster against the use of polythene bags / plastics.",
                    englishAnswer = """
+--------------------------------------------------+
|          ✖ SAY NO TO PLASTIC BAGS! ✖             |
|     "Be Fantastic — Stop Using Plastic!"         |
|                                                  |
|  DANGERS OF POLYTHENE:                           |
|  • Chokes drains & causes floods                 |
|  • Kills stray cows & marine life                |
|  • Pollutes soil for hundreds of years           |
|                                                  |
|  USE ECO-FRIENDLY ALTERNATIVES:                  |
|  ✔ Cloth Bags   ✔ Jute Bags   ✔ Paper Bags       |
|                                                  |
|      GO GREEN – KEEP MP CLEAN & GREEN!           |
|  Issued in Public Interest by: Green Youth Club  |
+--------------------------------------------------+
                    """.trimIndent(),
                    hindiExplanation = "इस पोस्टर में बड़े नारे, नुकसान और विकल्प दोनों संक्षिप्त रूप में बताए गए हैं और नीचे जारीकर्ता का नाम लिखा है।"
                )
            ),
            examQuestionsAndModels = listOf(
                WritingExamQuestion(
                    id = "wq_pos_1",
                    boardRef = "MP Board Class 12th Previous Exam Topic",
                    marks = 4,
                    questionEn = "Prepare an attractive poster urging people to say NO to Drugs / Tobacco.",
                    questionHi = "नशा मुक्ति ('Say No to Drugs') विषय पर एक आकर्षक पोस्टर तैयार कीजिए।",
                    modelAnswer = """
+--------------------------------------------------+
|            ★ SAY NO TO DRUGS! ★                  |
|     "Choose Life & Dreams, Not Addiction"        |
|                                                  |
|  DRUGS DESTROY:                                  |
|  ✖ Your Health & Brain                           |
|  ✖ Your Career & Future                          |
|  ✖ Your Family's Happiness                       |
|                                                  |
|  STOP BEFORE IT'S TOO LATE!                      |
|  ✔ Play Sports  ✔ Study Hard  ✔ Stay Healthy     |
|                                                  |
|  Issued by: NSS Unit, Bhopal (M.P.)              |
+--------------------------------------------------+
                    """.trimIndent()
                )
            ),
            practiceExercises = listOf(
                WritingExercise(
                    id = "wp_pos_1",
                    promptEn = "Design a poster for 'Donate Blood, Save a Life' with catchy slogans and organizer details.",
                    promptHi = "'रक्तदान महादान' (Donate Blood, Save Life) पर एक पोस्टर बनाइए।",
                    marks = 4,
                    hintsHi = "शीर्षक, नारा, रक्तदान के फायदे और स्थान/तारीख बॉक्स के भीतर लिखें।"
                )
            )
        ),

        // 7. Advertisement Writing
        WritingSkillTopic(
            id = "ws_advertisement",
            order = 7,
            titleEn = "Advertisement Writing (Classified)",
            titleHi = "विज्ञापन लेखन (Classified Advertisement)",
            applicableClasses = listOf(11, 12),
            syllabusNoteHi = "MP Board Class 11th और 12th के परीक्षा पैटर्न में For Sale, To-Let, Situation Vacant, Lost & Found (4 अंक) अक्सर आते हैं।",
            explanationHi = "समाचार पत्रों में किसी वस्तु को बेचने (For Sale), घर किराए पर देने (To-Let), नौकरी (Situation Vacant) या खोई वस्तु (Lost & Found) के लिए जो संक्षिप्त विज्ञापन दिए जाते हैं, उन्हें Classified Advertisement कहते हैं। इसे हमेशा बॉक्स में लिखते हैं और शब्द सीमा लगभग 50 शब्द रहती है।",
            rulesAndFormatEn = listOf(
                "Draw a neat box and center the heading in CAPITALS (FOR SALE / TO-LET).",
                "Do NOT write full sentences or personal stories; use comma-separated phrases.",
                "Include key features (model/condition/rooms/salary) + Contact phone/email."
            ),
            formatTemplate = """
+--------------------------------------------------+
|                    FOR SALE                      |
|                                                  |
| Available for immediate sale: a white Maruti     |
| Swift Dzire, 2021 model, single-owner driven,    |
| 28,000 km, excellent condition, valid insurance, |
| chilled AC, new tyres. Reason: owner shifting    |
| abroad. Expected price Rs. 5.5 Lakhs (neg.).     |
|                                                  |
| Contact: Mr. Verma, Mob: 98XXXXXXXX (Ujjain)     |
+--------------------------------------------------+
            """.trimIndent(),
            stepsHi = listOf(
                "Step 1: बॉक्स बनाएं और ऊपर बीच में श्रेणी का नाम लिखें (जैसे FOR SALE, TO-LET, SITUATION VACANT)।",
                "Step 2: कम शब्दों में कॉमा लगाकर मुख्य विशेषताएं बताएं।",
                "Step 3: कीमत/किराया/योग्यता लिखें।",
                "Step 4: सबसे नीचे संपर्क सूत्र (Contact details) अवश्य लिखें।"
            ),
            solvedExamples = listOf(
                WritingSolvedExample(
                    title = "Solved Example: House / Flat For Sale (Father Going Abroad)",
                    questionEn = "Your father has been transferred to another city. You want to sell certain household goods (TV, Fridge, Washing Machine). Draft a suitable advertisement in not more than 50 words.",
                    englishAnswer = """
+--------------------------------------------------+
|                    FOR SALE                      |
|                                                  |
| Available for immediate sale: LG 43-inch LED TV, |
| Samsung Double-Door Refrigerator, and IFB Front- |
| Load Washing Machine. All items only 1.5 years   |
| old, under warranty, and in mint condition.      |
| Selling due to transfer to another city.         |
| Price very reasonable.                           |
|                                                  |
| Contact: Anil Gupta, 25 Malviya Nagar, Bhopal.   |
| Phone: 9425XXXXXX                                |
+--------------------------------------------------+
                    """.trimIndent(),
                    hindiExplanation = "यह MP Board Class 12th का प्रसिद्ध विज्ञापन है। पूरे 50 शब्दों में स्पष्ट वस्तुएं, स्थिति, कारण और संपर्क नंबर शामिल हैं।"
                )
            ),
            examQuestionsAndModels = listOf(
                WritingExamQuestion(
                    id = "wq_adv_1",
                    boardRef = "MP Board Class 11–12 Exam Pattern",
                    marks = 4,
                    questionEn = "You have a two-bedroom flat to let out on rent near Railway Station, Sagar. Draft a TO-LET advertisement.",
                    questionHi = "दो कमरों का फ्लैट किराए पर देने (TO-LET) हेतु एक क्लासीफाइड विज्ञापन लिखिए।",
                    modelAnswer = """
+--------------------------------------------------+
|                     TO-LET                       |
|                                                  |
| Available on rent: newly built, airy 2-BHK flat  |
| on ground floor near Railway Station, Sagar.     |
| 24-hour water & power supply, modular kitchen,   |
| two-wheeler parking. Ideal for small family or   |
| bank employees. Rent Rs. 8,500/month.            |
|                                                  |
| Contact: R.K. Jain, Mob: 9981XXXXXX              |
+--------------------------------------------------+
                    """.trimIndent()
                )
            ),
            practiceExercises = listOf(
                WritingExercise(
                    id = "wp_adv_1",
                    promptEn = "Draft a 'SITUATION VACANT' advertisement for an English Teacher required at a CBSE/MP Board school in Indore.",
                    promptHi = "अंग्रेजी शिक्षक की आवश्यकता हेतु 'SITUATION VACANT' विज्ञापन तैयार कीजिए।",
                    marks = 4,
                    hintsHi = "योग्यता (M.A., B.Ed.), अनुभव, वेतन और ईमेल/संपर्क लिखें।"
                )
            )
        ),

        // 8. Picture Composition
        WritingSkillTopic(
            id = "ws_picture_composition",
            order = 8,
            titleEn = "Picture Composition (Visual Prompt)",
            titleHi = "चित्र वर्णन (Picture Composition)",
            applicableClasses = listOf(9, 10),
            syllabusNoteHi = "MP Board Class 9th और 10th की परीक्षा में 3 अंक का अनिवार्य प्रश्न — चित्र देखकर 60–80 शब्दों का अनुच्छेद लिखना होता है।",
            explanationHi = "Picture Composition में आपको एक चित्र (जैसे स्वच्छ भारत, पेड़ बचाओ, मोबाइल की लत, कोविड/स्वास्थ्य सुरक्षा, या एक किसान) दिया जाता है। आपको उस चित्र में दिखाई दे रही बातों का वर्णन करते हुए उससे मिलने वाला संदेश सरल अंग्रेजी में 1 अनुच्छेद में लिखना होता है।",
            rulesAndFormatEn = listOf(
                "Give a clear 2–4 word Title based on the picture.",
                "Describe what you directly observe in the picture (setting, people, action).",
                "Explain the hidden social message / lesson in simple Present Tense.",
                "Stick to 60–80 words (6–8 clean sentences)."
            ),
            formatTemplate = """
Title: [Theme of the Picture]

This picture clearly shows [describe main scene/people]. On one side we see [detail 1], and on the other side [detail 2]. Through this visual, we learn an important message about [social theme]. Everyone should [positive action]. It reminds us that [concluding moral sentence].
            """.trimIndent(),
            stepsHi = listOf(
                "Step 1: चित्र को गौर से देखें और समझें कि यह किस समस्या या अच्छी आदत को दिखाता है।",
                "Step 2: सबसे ऊपर चित्र का Title लिखें।",
                "Step 3: 'This picture depicts...' से शुरुआत कर चित्र की हर मुख्य वस्तु का वर्णन करें।",
                "Step 4: अंतिम 2 वाक्यों में इसका नैतिक संदेश (Message) लिखें।"
            ),
            solvedExamples = listOf(
                WritingSolvedExample(
                    title = "Solved Example: Picture Showing 'Save Trees' / 'Healthy Habits'",
                    questionEn = "On the basis of a picture showing students cleaning their school campus, planting saplings, and putting waste in dustbins, write a short paragraph in about 75 words.",
                    englishAnswer = """
Clean and Green School Campus

This picture highlights the importance of cleanliness and greenery in our surroundings. We can see young students enthusiastically cleaning their school campus. Some students are sweeping the ground, while others are throwing garbage into separate blue and green dustbins. Two students are also planting small saplings and watering them. Cleanliness keeps diseases away, and trees give us fresh oxygen. This picture inspires us to adopt the Swachh Bharat habit every day.
                    """.trimIndent(),
                    hindiExplanation = "Class 9 और 10 में पूरे 3 में से 3 अंक पाने के लिए सरल Present Continuous और Simple Present Tense के छोटे-छोटे 6–7 सटीक वाक्य लिखें।"
                )
            ),
            examQuestionsAndModels = listOf(
                WritingExamQuestion(
                    id = "wq_pic_1",
                    boardRef = "MP Board Class 10th Standard Question",
                    marks = 3,
                    questionEn = "Describe a visual scene depicting 'Harmful Effects of Excessive Mobile Phone Usage among Youth'.",
                    questionHi = "'युवाओं में मोबाइल फोन के अत्यधिक उपयोग के नुकसान' दर्शाते चित्र पर लगभग 75 शब्दों का वर्णन लिखिए।",
                    modelAnswer = """
Avoid Excessive Screen Time

The given picture shows how excessive smartphone usage is affecting young students. A boy is sitting in his room glued to a mobile screen late at night while books lie untouched nearby. Overuse of mobile phones causes weak eyesight, lack of sleep, and poor concentration in studies. Instead of wasting hours on social media and games, students should play outdoor sports and spend quality time with their family.
                    """.trimIndent()
                )
            ),
            practiceExercises = listOf(
                WritingExercise(
                    id = "wp_pic_1",
                    promptEn = "Write a 70-word picture composition describing a scene of 'Rainwater Harvesting & Tree Plantation' in a village.",
                    promptHi = "'वर्षा जल संचयन और वृक्षारोपण' दर्शाते चित्र पर 70 शब्दों का अनुच्छेद लिखिए।",
                    marks = 3,
                    hintsHi = "शीर्षक लिखें और चित्र के 4 मुख्य कार्य व अंतिम संदेश शामिल करें।"
                )
            )
        ),

        // 9. Report Writing
        WritingSkillTopic(
            id = "ws_report_writing",
            order = 9,
            titleEn = "Report Writing",
            titleHi = "प्रतिवेदन / रिपोर्ट लेखन (Report Writing)",
            applicableClasses = listOf(11, 12),
            syllabusNoteHi = "MP Board Class 11th और 12th में Section B (Long Composition — 4 अंक) में Road Accident, NSS Camp, Tree Plantation Drive पर Report आती है।",
            explanationHi = "Report Writing का अर्थ है किसी घटित हो चुकी घटना, स्कूल कार्यक्रम, शिविर (NSS Camp) या दुर्घटना (Road Accident) का तथ्यात्मक और क्रमबद्ध विवरण लिखना। चूंकि घटना हो चुकी होती है, इसलिए रिपोर्ट हमेशा Past Tense में लिखी जाती है।",
            rulesAndFormatEn = listOf(
                "Give a bold Title and write 'By: [Name/Reporter]' right below it.",
                "Begin with Place and Date (e.g., Bhopal, 14 August:).",
                "Write mainly in Simple Past & Past Passive voice.",
                "Answer What happened, When, Where, How, and Result/Outcome."
            ),
            formatTemplate = """
                  [HEADING / EVENT TITLE]
                  By: [Reporter / Student Name]

[City], [Date]: A [name of event / incident] took place at [place] yesterday at [time]. [Describe who inaugurated/participated and key sequence of events in Past Tense].

Around [number] students/people took part enthusiastically. Finally, [mention conclusion, prize distribution, or rescue steps]. Everyone appreciated the effort.
            """.trimIndent(),
            stepsHi = listOf(
                "Step 1: बीच में आकर्षक शीर्षक लिखें और नीचे 'By: [Name]' लिखें।",
                "Step 2: शुरुआत 'शहर का नाम, तारीख:' से करें।",
                "Step 3: Past Tense (was, were, took place, distributed) में घटनाक्रम बताएं।",
                "Step 4: अंत में कार्यक्रम की सफलता या परिणाम का उल्लेख करें।"
            ),
            solvedExamples = listOf(
                WritingSolvedExample(
                    title = "Solved Example: Annual Sports Day / NSS Plantation Drive",
                    questionEn = "Write a report in about 100 words on a 'Tree Plantation Campaign' held in your school under NSS.",
                    englishAnswer = """
TREE PLANTATION CAMPAIGN AT GOVT. H.S. SCHOOL
By: Riya Sen, Class XII

Indore, 15 July: The NSS unit of Govt. H.S. School, Indore organized a grand Tree Plantation Campaign on the school campus yesterday. The District Forest Officer graced the occasion as Chief Guest and inaugurated the drive by planting a Neem sapling.

Over 150 students and all teachers planted more than 300 saplings of Neem, Peepal, and Gulmohar around the playground. Tree guards were placed to protect the young plants. The Principal delivered an inspiring speech urging students to adopt one tree each. The program concluded with an oath to keep our Earth clean and green.
                    """.trimIndent(),
                    hindiExplanation = "ध्यान दें कि पूरी रिपोर्ट Past Tense (organized, graced, planted, concluded) में लिखी गई है और वास्तविक तथ्य (कितने छात्र, कौन मुख्य अतिथि, कौन से पौधे) शामिल किए गए हैं।"
                )
            ),
            examQuestionsAndModels = listOf(
                WritingExamQuestion(
                    id = "wq_rep_1",
                    boardRef = "MP Board Class 12th Frequent Exam Question",
                    marks = 4,
                    questionEn = "Write a newspaper report on a road accident you witnessed near your school gate, using hints (speeding bus, cyclist injured, crowd helped, ambulance arrived).",
                    questionHi = "दिए गए बिंदुओं की सहायता से सड़क दुर्घटना (Road Accident) पर एक समाचार रिपोर्ट लिखिए।",
                    modelAnswer = """
MAJOR ROAD ACCIDENT NEAR BUS STAND
By: Staff Reporter

Jabalpur, 20 October: A serious road accident occurred near the Main Bus Stand today at 9:30 AM when a speeding private bus hit a cyclist. The cyclist sustained head injuries and fell unconscious on the road.

Passers-by immediately rushed to help and stopped the bus. A local shopkeeper called the 108 Ambulance and informed the traffic police. Within ten minutes, the injured youth was shifted to Victoria Hospital where his condition is now reported stable. Police have seized the bus and registered a case against the reckless driver.
                    """.trimIndent()
                )
            ),
            practiceExercises = listOf(
                WritingExercise(
                    id = "wp_rep_1",
                    promptEn = "Write a report on 'Science Exhibition' organized in your school (100 words).",
                    promptHi = "अपने विद्यालय में आयोजित 'विज्ञान प्रदर्शनी' (Science Exhibition) पर रिपोर्ट लिखिए।",
                    marks = 4,
                    hintsHi = "शीर्षक, By-line, शहर-तारीख के बाद Past Tense में मॉडल्स और पुरस्कार वितरण लिखें।"
                )
            )
        ),

        // 10. Article Writing
        WritingSkillTopic(
            id = "ws_article_writing",
            order = 10,
            titleEn = "Article Writing",
            titleHi = "लेख लेखन (Article Writing)",
            applicableClasses = listOf(10, 11, 12),
            syllabusNoteHi = "MP Board Class 11th और 12th में Paragraph/Article Writing 4 अंक में तथा Class 10th में समसामयिक विषयों पर पूछा जाता है।",
            explanationHi = "Article Writing किसी समसामयिक या महत्वपूर्ण विषय (जैसे Value of Games, Clean India Mission, Women Empowerment, Online Education) पर अपने विचारों को तीन भागों — Introduction, Body (Causes/Benefits), और Conclusion — में व्यवस्थित रूप से प्रस्तुत करने की कला है।",
            rulesAndFormatEn = listOf(
                "Heading centered at top + 'By: [Writer Name]' below it.",
                "Paragraph 1: Define topic / Catchy opening statement.",
                "Paragraph 2: Causes, advantages, or real-life examples.",
                "Paragraph 3: Practical solutions and hopeful conclusion."
            ),
            formatTemplate = """
                [TITLE OF THE ARTICLE]
                By: [Student Name]

[Introduction: Hook the reader + introduce the topic clearly.]

[Main Body: Explain importance, advantages, problems, or statistics clearly in 4–5 lines.]

[Conclusion: Summarize key message and give positive suggestions for society/students.]
            """.trimIndent(),
            stepsHi = listOf(
                "Step 1: ऊपर शीर्षक और 'By: ...' लिखें।",
                "Step 2: पहले पैराग्राफ में विषय का परिचय दें।",
                "Step 3: दूसरे पैराग्राफ में फायदे/नुकसान/कारण विस्तार से लिखें।",
                "Step 4: तीसरे पैराग्राफ में सुझाव और सकारात्मक निष्कर्ष लिखें।"
            ),
            solvedExamples = listOf(
                WritingSolvedExample(
                    title = "Solved Example: Importance of Games and Sports",
                    questionEn = "Write an article in about 100–120 words on 'Importance of Games and Sports in Student Life'.",
                    englishAnswer = """
IMPORTANCE OF GAMES AND SPORTS
By: Kavya Joshi

"A healthy mind resides in a healthy body." Games and sports are not merely pastimes; they are an essential part of holistic education. In today's competitive world, students often remain confined to books and screens, neglecting physical fitness.

Playing outdoor sports like cricket, football, and athletics strengthens muscles, improves blood circulation, and builds immunity. Beyond physical health, sports teach invaluable life skills such as teamwork, discipline, leadership, and accepting victory or defeat gracefully.

Schools must allot regular periods for sports alongside academics. Active participation in games shapes confident, energetic, and balanced citizens.
                    """.trimIndent(),
                    hindiExplanation = "लेख की शुरुआत एक प्रसिद्ध कहावत से की गई है और 3 सुव्यवस्थित अनुच्छेदों में शारीरिक, मानसिक और व्यावहारिक लाभ समझाए गए हैं।"
                )
            ),
            examQuestionsAndModels = listOf(
                WritingExamQuestion(
                    id = "wq_art_1",
                    boardRef = "MP Board Class 11–12 Exam Pattern",
                    marks = 4,
                    questionEn = "Write an article on 'Role of Computers and Internet in Modern Education'.",
                    questionHi = "'आधुनिक शिक्षा में कंप्यूटर और इंटरनेट की भूमिका' पर एक Article लिखिए।",
                    modelAnswer = """
COMPUTERS AND INTERNET IN EDUCATION
By: Devansh Patel

Computers and the internet have revolutionized modern classrooms. Learning is no longer restricted to printed textbooks; students can access digital lectures, educational apps, and global libraries within seconds.

Audio-visual explanations make difficult concepts in English, Science, and Mathematics easy to grasp. During exams, online mock tests and digital notes save time and improve practice. However, students must use the internet wisely and avoid distractions like excessive gaming. When guided properly, technology acts as the finest companion to teachers and textbooks.
                    """.trimIndent()
                )
            ),
            practiceExercises = listOf(
                WritingExercise(
                    id = "wp_art_1",
                    promptEn = "Write an article on 'Save Girl Child, Educate Girl Child (Beti Bachao, Beti Padhao)'.",
                    promptHi = "'बेटी बचाओ, बेटी पढ़ाओ' विषय पर 100 शब्दों का एक Article लिखिए।",
                    marks = 4,
                    hintsHi = "महिला शिक्षा का समाज और परिवार में योगदान 3 पैराग्राफ में लिखें।"
                )
            )
        ),

        // 11. Speech Writing
        WritingSkillTopic(
            id = "ws_speech_writing",
            order = 11,
            titleEn = "Speech Writing",
            titleHi = "भाषण लेखन (Speech Writing)",
            applicableClasses = listOf(11, 12),
            syllabusNoteHi = "MP Board Class 11th और 12th में Morning Assembly या Annual Function पर Speech / Debate Writing (4 अंक) पूछी जाती है।",
            explanationHi = "Speech Writing श्रोताओं (Audience) के सामने बोले जाने वाला लेख होता है। इसलिए इसकी शुरुआत 'Respected Principal, Teachers, and my dear friends, Good morning!' से होती है और अंत 'Thank you very much! Jai Hind!' से किया जाता है।",
            rulesAndFormatEn = listOf(
                "Begin with formal Greeting + self-introduction + topic announcement.",
                "Use conversational pronouns ('we', 'you', 'our') to connect with listeners.",
                "Ask a rhetorical question or include a short quote.",
                "End politely with 'Thank you for your patient hearing.'"
            ),
            formatTemplate = """
Respected Principal Sir, worthy teachers, and my dear friends, a very good morning to all of you!

Today, I, [Name], stand before you to express my views on '[Topic]'.

[Body: 2 short paragraphs sharing facts, problems, and solutions directly to the audience.]

Let us all take a pledge today to [call to action].
Thank you very much for listening patiently!
            """.trimIndent(),
            stepsHi = listOf(
                "Step 1: श्रोताओं का अभिवादन (Greeting) करके विषय की घोषणा करें।",
                "Step 2: पहले भाग में विषय का महत्व या मुख्य समस्या स्पष्ट करें।",
                "Step 3: छात्रों व समाज से एक व्यावहारिक संकल्प लेने की अपील करें।",
                "Step 4: 'Thank you!' कहकर भाषण समाप्त करें।"
            ),
            solvedExamples = listOf(
                WritingSolvedExample(
                    title = "Solved Example: Morning Assembly Speech on Discipline",
                    questionEn = "Prepare a speech in about 100 words to be delivered in the morning assembly on 'Importance of Discipline in Student Life'.",
                    englishAnswer = """
Respected Principal Sir, respected teachers, and my dear friends, good morning to everyone!

Today I want to speak on a golden rule of success: 'Discipline in Student Life'. Discipline means following rules, respecting elders, and managing time wisely. Without discipline, even brilliant talent goes waste.

Look at nature — the sun rises on time and seasons follow an order. Similarly, a disciplined student studies regularly, completes homework on time, and stays calm during exams. Great leaders like Dr. APJ Abdul Kalam achieved greatness solely through self-discipline.

Let us promise ourselves to stay punctual and disciplined every single day. Thank you!
                    """.trimIndent(),
                    hindiExplanation = "Speech हमेशा श्रोताओं से सीधे संवाद (direct address) के रूप में होती है। शुरुआत और अंत दोनों परीक्षा में पूरे अंक दिलाते हैं।"
                )
            ),
            examQuestionsAndModels = listOf(
                WritingExamQuestion(
                    id = "wq_sp_1",
                    boardRef = "MP Board Class 11–12 Exam Pattern",
                    marks = 4,
                    questionEn = "Write a speech on 'Cleanliness is Next to Godliness' for the Gandhi Jayanti assembly.",
                    questionHi = "गांधी जयंती सभा में 'स्वच्छता ही सेवा है' विषय पर एक Speech लिखिए।",
                    modelAnswer = """
Respected Principal, teachers, and dear friends, very good morning!

On the auspicious occasion of Gandhi Jayanti, I am honoured to speak on 'Cleanliness is Next to Godliness'. Mahatma Gandhi believed that clean surroundings reflect a pure heart and a progressive nation.

Keeping our classrooms, homes, and streets clean protects us from dangerous diseases. Instead of waiting for sweepers, every student must use dustbins and avoid littering. A clean India is the greatest tribute we can pay to Bapu. Let us pledge to keep our school and city spotless. Thank you and Jai Hind!
                    """.trimIndent()
                )
            ),
            practiceExercises = listOf(
                WritingExercise(
                    id = "wp_sp_1",
                    promptEn = "Draft a morning assembly speech on 'Say No to Junk Food, Eat Healthy'.",
                    promptHi = "'जंक फूड छोड़ें, स्वस्थ भोजन अपनाएं' विषय पर प्रार्थना सभा के लिए Speech लिखिए।",
                    marks = 4,
                    hintsHi = "Greeting से शुरू कर मोटापा, आलस्य व ताजे भोजन के लाभ बताएं।"
                )
            )
        ),

        // 12. Paragraph Writing
        WritingSkillTopic(
            id = "ws_paragraph_writing",
            order = 12,
            titleEn = "Paragraph Writing",
            titleHi = "अनुच्छेद लेखन (Paragraph Writing)",
            applicableClasses = listOf(9, 10, 11, 12),
            syllabusNoteHi = "MP Board Class 9th–10th (3–4 अंक) व 11th–12th (4 अंक) में दिए गए संक्षिप्त बिंदुओं के आधार पर 80–120 शब्दों का Paragraph पूछा जाता है।",
            explanationHi = "Paragraph Writing में केवल एक ही अनुच्छेद (Single Paragraph) के भीतर किसी एक विषय का स्पष्ट और सुसंगठित वर्णन किया जाता है। Essay की तरह इसमें अलग-अलग Headings नहीं डाले जाते; सभी वाक्य आपस में जुड़े होने चाहिए।",
            rulesAndFormatEn = listOf(
                "Keep everything in ONE single unified paragraph.",
                "Start with a strong Topic Sentence summarizing the theme.",
                "Support it with 4–6 connecting sentences covering all given verbal inputs.",
                "Finish with a clear concluding thought."
            ),
            formatTemplate = """
                    [TITLE OF PARAGRAPH]

[Topic Sentence introducing the subject cleanly.] [Supporting detail 1.] [Supporting detail 2 covering all exam hints.] [Supporting detail 3 with example.] [Concluding sentence wrapping up the main lesson.]
            """.trimIndent(),
            stepsHi = listOf(
                "Step 1: प्रश्न में दिए गए सभी संकेत शब्दों (Hints) को एक क्रम में जोड़ें।",
                "Step 2: सिर्फ एक ही पैराग्राफ लिखें, बार-बार लाइन न तोड़ें।",
                "Step 3: सरल और छोटे वाक्यों का प्रयोग करें ताकि व्याकरण की गलतियां न हों।"
            ),
            solvedExamples = listOf(
                WritingSolvedExample(
                    title = "Solved Example: Benefits of Morning Walk",
                    questionEn = "Write a short paragraph in about 80 words on 'Morning Walk' using hints: fresh air, nature, active mind, healthy heart.",
                    englishAnswer = """
Morning Walk

A morning walk is the best and easiest form of physical exercise for people of all ages. In the early morning, the air is pure, cool, and free from pollution. Walking amidst green trees and chirping birds fills our mind with peace and positivity. It strengthens the heart, regulates blood pressure, and keeps the body energetic throughout the day. Students who go for a morning walk develop better memory and focus in studies. Truly, an early morning walk is a priceless gift for good health.
                    """.trimIndent(),
                    hindiExplanation = "दिए गए चारों संकेत (fresh air, nature, active mind, healthy heart) एक ही धाराप्रवाह पैराग्राफ में सरल अंग्रेजी में लिखे गए हैं।"
                )
            ),
            examQuestionsAndModels = listOf(
                WritingExamQuestion(
                    id = "wq_para_1",
                    boardRef = "MP Board High & Higher Secondary Pattern",
                    marks = 4,
                    questionEn = "Write a paragraph on 'Online Education — Merits and Demerits' in about 100 words.",
                    questionHi = "'ऑनलाइन शिक्षा — लाभ और हानि' विषय पर 100 शब्दों में अनुच्छेद लिखिए।",
                    modelAnswer = """
Online Education — Merits and Demerits

Online education has become an integral part of modern learning. Its biggest advantage is flexibility, as students can watch recorded classes and download study notes anytime from home. It connects learners in remote villages with experienced educators. However, online learning also has certain drawbacks. Prolonged screen exposure strains the eyes, and lack of face-to-face teacher supervision can reduce discipline. Moreover, poor internet connectivity remains a hurdle in rural areas. Therefore, a balanced blend of classroom teaching and smart digital learning is ideal for students today.
                    """.trimIndent()
                )
            ),
            practiceExercises = listOf(
                WritingExercise(
                    id = "wp_para_1",
                    promptEn = "Write a paragraph in 80 words on 'Importance of English Language' covering global communication, higher education, and job opportunities.",
                    promptHi = "'अंग्रेजी भाषा का महत्व' विषय पर 80 शब्दों का Paragraph लिखिए।",
                    marks = 4,
                    hintsHi = "सभी तीनों बिंदु एक ही पैराग्राफ में स्पष्ट लिखें।"
                )
            )
        ),

        // 13. Essay Writing
        WritingSkillTopic(
            id = "ws_essay_writing",
            order = 13,
            titleEn = "Essay Writing",
            titleHi = "निबंध लेखन (Essay Writing)",
            applicableClasses = listOf(9, 10),
            syllabusNoteHi = "MP Board Class 9th और 10th की बोर्ड परीक्षा में 5 अंक (लगभग 150 शब्द) का अत्यंत महत्वपूर्ण प्रश्न — 'Wonders of Science', 'My Hobby', 'An Indian Festival', 'Importance of Trees'।",
            explanationHi = "Essay (निबंध) किसी विषय पर विस्तार से लिखा गया निबंधात्मक उत्तर होता है जिसे स्पष्ट उप-शीर्षकों (Sub-headings) में बाँटकर लिखा जाता है: Introduction, मुख्य बिंदु (3–4 Headings), और Conclusion। MP Board में Heading-wise Essay लिखने पर पूरे अंक मिलते हैं।",
            rulesAndFormatEn = listOf(
                "Divide the essay into 5–6 short Headings (1. Introduction ... Last: Conclusion).",
                "Target 150 words cleanly without spelling errors.",
                "Include 1 memorable proverb or quotation.",
                "Underline every sub-heading neatly in the exam sheet."
            ),
            formatTemplate = """
              [ESSAY TITLE IN CAPITALS]

1. Introduction: [3–4 clear introductory lines]
2. [Main Aspect 1]: [3–4 lines]
3. [Main Aspect 2]: [3–4 lines]
4. [Main Aspect 3 / Precautions]: [3–4 lines]
5. Conclusion: [3–4 concluding lines]
            """.trimIndent(),
            stepsHi = listOf(
                "Step 1: निबंध के लिए 5 आसान Headings याद रखें (Introduction, Body Points, Conclusion)।",
                "Step 2: हर Heading के अंदर केवल 3–4 सरल वाक्य लिखें।",
                "Step 3: MP Board में 'Wonders of Science / Science in Daily Life' सबसे ज्यादा पूछा जाता है — इसे पूरी तरह तैयार रखें।"
            ),
            solvedExamples = listOf(
                WritingSolvedExample(
                    title = "Solved Example: Wonders of Science (MP Board Most Repeated Essay)",
                    questionEn = "Write an essay in about 150 words on 'Wonders of Science'.",
                    englishAnswer = """
WONDERS OF SCIENCE

1. Introduction
We live in the age of science. Science has made human life comfortable, fast, and full of wonders. From waking up to an alarm clock to sleeping under a fan, science serves us everywhere.

2. Electricity and Machines
Electricity is the greatest gift of science. It runs lights, fans, refrigerators, computers, and massive factories.

3. Means of Transport and Communication
Trains, buses, and aeroplanes have shortened long distances. Mobile phones and the internet have connected the entire world within seconds.

4. Medical Science
Science has cured deadly diseases through vaccines, X-rays, and modern surgery, increasing human life expectancy.

5. Conclusion
Science is a good servant but a bad master. Used peacefully for human welfare, science can make our Earth a true paradise.
                    """.trimIndent(),
                    hindiExplanation = "Class 9 और 10 MP Board में यह निबंध वर्षों से पूछा जाता रहा है। प्रत्येक हेडिंग में 2–3 सरल व शुद्ध वाक्य लिखे गए हैं जिन्हें आसानी से याद किया जा सकता है।"
                )
            ),
            examQuestionsAndModels = listOf(
                WritingExamQuestion(
                    id = "wq_ess_1",
                    boardRef = "MP Board Class 9th–10th Classic Exam Question",
                    marks = 5,
                    questionEn = "Write an essay in about 150 words on 'Any Great Leader' OR 'Environmental Pollution'.",
                    questionHi = "'पर्यावरण प्रदूषण' (Environmental Pollution) पर लगभग 150 शब्दों का निबंध लिखिए।",
                    modelAnswer = """
ENVIRONMENTAL POLLUTION

1. Introduction
Environmental pollution is one of the biggest dangers facing humanity today. Contamination of air, water, and soil threatens every living creature on Earth.

2. Air and Water Pollution
Smoke from vehicles and factories pollutes the air we breathe. Industrial waste and plastics dumped into rivers poison our drinking water.

3. Noise and Soil Pollution
Loudspeakers, horns, and chemical fertilizers harm both human ears and soil fertility.

4. Measures to Control Pollution
Planting more trees, using public transport, banning single-use plastic, and treating factory waste can save our environment.

5. Conclusion
Protecting nature is our sacred duty. Clean surroundings ensure a safe, healthy future for coming generations.
                    """.trimIndent()
                )
            ),
            practiceExercises = listOf(
                WritingExercise(
                    id = "wp_ess_1",
                    promptEn = "Write a 150-word heading-wise essay on 'My Hobby (Reading / Gardening)'.",
                    promptHi = "'मेरा शौक' (My Hobby) विषय पर Headings के साथ 150 शब्दों का निबंध लिखिए।",
                    marks = 5,
                    hintsHi = "Headings: 1. Introduction, 2. Why I chose this hobby, 3. Benefits, 4. Conclusion."
                )
            )
        ),

        // 14. Invitation Writing
        WritingSkillTopic(
            id = "ws_invitation_writing",
            order = 14,
            titleEn = "Invitation Writing & Replies",
            titleHi = "निमंत्रण पत्र व उत्तर लेखन (Invitation)",
            applicableClasses = listOf(11, 12),
            syllabusNoteHi = "MP Board Class 11th और 12th के Advanced Writing / Formal & Informal Short Composition सिलेबस में महत्वपूर्ण विषय।",
            explanationHi = "Invitation दो प्रकार के होते हैं: (1) Formal Card Invitation (शादी, स्कूल वार्षिक उत्सव, उद्घाटन के लिए Third Person में बॉक्स के अंदर) और (2) Informal Invitation (मित्रों को जन्मदिन/पार्टी के लिए पत्र के रूप में)। इसके साथ Acceptance/Refusal Reply लिखना भी सिखाया जाता है।",
            rulesAndFormatEn = listOf(
                "Formal Card Invitations use Third Person ('request the pleasure of your company'), NO 'I/We', centered alignment inside a BOX.",
                "Mention Host Name, Occasion, Date, Time, Venue, and RSVP at bottom left.",
                "Informal Invitations use First/Second Person like a short friendly letter."
            ),
            formatTemplate = """
+--------------------------------------------------+
|    The Principal, Staff & Students of            |
|        GOVT. MODEL H.S. SCHOOL, BHOPAL           |
|                                                  |
|    cordially invite you to their                 |
|             ANNUAL SPORTS MEET 2025              |
|                                                  |
|    Date  : 22 November 2025                      |
|    Time  : 10:00 AM onwards                      |
|    Venue : School Main Playground                |
|    Chief Guest: Hon. District Collector          |
|                                                  |
|  RSVP:                         With Best Regards |
|  Sports Secretary              Principal         |
+--------------------------------------------------+
            """.trimIndent(),
            stepsHi = listOf(
                "Step 1: कार्ड निमंत्रण (Formal) हमेशा एक बॉक्स में बीच से अलाइन कर लिखें।",
                "Step 2: Third Person शैली प्रयोग करें ('Mr. & Mrs. Sharma cordially invite you...')।",
                "Step 3: Date, Time, Venue और Chief Guest स्पष्ट लिखें।",
                "Step 4: नीचे बाईं ओर RSVP (संपर्क फोन/नाम) लिखें।"
            ),
            solvedExamples = listOf(
                WritingSolvedExample(
                    title = "Solved Example: Formal Birthday / House Warming Invitation Card",
                    questionEn = "Draft a formal printed invitation card inviting friends and relatives on your younger sister's 10th Birthday Party.",
                    englishAnswer = """
+--------------------------------------------------+
|         Mr. & Mrs. Rajesh Verma                  |
|      solicit your gracious presence on the       |
|              10th BIRTHDAY PARTY                 |
|         of their beloved daughter                |
|                    ANANYA                        |
|                                                  |
|      on Sunday, 18 May 2025 at 6:30 PM           |
|      Venue: Hotel Vrindavan Garden, Ujjain       |
|                                                  |
|  RSVP:                  With Best Compliments:   |
|  Rajesh Verma           All Verma Family         |
|  Mob: 9826XXXXXX                                 |
+--------------------------------------------------+
                    """.trimIndent(),
                    hindiExplanation = "यह एक सुंदर औपचारिक कार्ड निमंत्रण है जिसमें मेजबान, अवसर, समय, स्थान और RSVP सभी बॉक्स के अंदर सही जगह रखे गए हैं।"
                )
            ),
            examQuestionsAndModels = listOf(
                WritingExamQuestion(
                    id = "wq_inv_1",
                    boardRef = "Higher Secondary Writing Practice",
                    marks = 4,
                    questionEn = "You are Rohan. You have received an invitation from your friend Aman to attend his birthday party, but you have an exam the next morning. Write an informal reply declining the invitation.",
                    questionHi = "मित्र के जन्मदिन निमंत्रण को परीक्षा होने के कारण विनम्रता से अस्वीकार करते हुए उत्तर लिखिए।",
                    modelAnswer = """
12, Shastri Nagar,
Indore (M.P.)

Date: 14 November 2025

Dear Aman,

Thank you so much for your warm invitation to your birthday party on 18th November. I am truly sorry that I will not be able to attend the celebration as my Pre-Board English examination is scheduled for the very next morning.

I wish you a very Happy Birthday in advance and pray for your bright future. Let us meet right after my exams end.

Yours affectionately,
Rohan
                    """.trimIndent()
                )
            ),
            practiceExercises = listOf(
                WritingExercise(
                    id = "wp_inv_1",
                    promptEn = "Draft a Formal Card Invitation on behalf of your Principal inviting parents to the Annual Prize Distribution Ceremony.",
                    promptHi = "वार्षिक पुरस्कार वितरण समारोह हेतु माता-पिता के लिए एक Formal Invitation Card लिखिए।",
                    marks = 4,
                    hintsHi = "बॉक्स, Third Person, Date, Time, Venue और RSVP आवश्यक हैं।"
                )
            )
        ),

        // 15. Message Writing
        WritingSkillTopic(
            id = "ws_message_writing",
            order = 15,
            titleEn = "Message Writing",
            titleHi = "संदेश लेखन (Message Writing)",
            applicableClasses = listOf(9, 10),
            syllabusNoteHi = "MP Board Class 9th और 10th में किसी टेलीफोन वार्तालाप या नोट के आधार पर संक्षिप्त Message (40–50 शब्द, बॉक्स में) लिखने का अभ्यास आवश्यक है।",
            explanationHi = "जब कोई व्यक्ति घर या ऑफिस में मौजूद नहीं होता और उसके लिए फोन पर कोई संदेश आता है, तो उसके लिए छोड़ी गई संक्षिप्त लिखित सूचना Message कहलाती है। इसे हमेशा एक छोटे बॉक्स में लिखा जाता है और इसमें Date, Time,Receiver का नाम, मुख्य संदेश और Sender का नाम होता है।",
            rulesAndFormatEn = listOf(
                "Always enclose inside a neat rectangular BOX.",
                "Write 'MESSAGE' centered on top; Date on left, Time on right.",
                "Address the recipient shortly ('Dear Papa / Dear Ritu,').",
                "Keep within 40–50 words; sign only your first name at the bottom."
            ),
            formatTemplate = """
+------------------------------------------+
|                 MESSAGE                  |
| 15 Oct 2025                    4:30 PM   |
|                                          |
| Dear [Recipient Name],                   |
| [Mention who called/informed and exact   |
| short message clearly in 3–4 lines.]     |
|                                          |
| [Sender's Name]                          |
+------------------------------------------+
            """.trimIndent(),
            stepsHi = listOf(
                "Step 1: सबसे पहले एक बॉक्स बनाएं और बीच में MESSAGE लिखें।",
                "Step 2: बाईं तरफ Date और दाईं तरफ Time लिखें।",
                "Step 3: जिसको संदेश देना है उसका नाम लिखकर किसने फोन किया और क्या जरूरी काम बताया — केवल यही संक्षेप में लिखें।",
                "Step 4: नीचे सिर्फ अपना पहला नाम लिखें।"
            ),
            solvedExamples = listOf(
                WritingSolvedExample(
                    title = "Solved Example: Telephone Message for Father",
                    questionEn = "You receive a telephone call from Mr. Mehta while your father is away. Mr. Mehta informs that the office meeting scheduled for tomorrow at 10 AM has been postponed to 3 PM. Write a message in 40 words as you are going out for tuition.",
                    englishAnswer = """
+------------------------------------------+
|                 MESSAGE                  |
| 20 Aug 2025                    5:15 PM   |
|                                          |
| Dear Papa,                               |
| Mr. Mehta called up to inform that       |
| tomorrow's 10:00 AM office meeting has   |
| been postponed to 3:00 PM. Please note   |
| the revised timing. I am leaving for     |
| tuition now.                             |
|                                          |
| Kunal                                    |
+------------------------------------------+
                    """.trimIndent(),
                    hindiExplanation = "केवल जरूरी जानकारी (किसका फोन था, मीटिंग का बदला समय) 40 शब्दों के भीतर बॉक्स में लिखी गई है।"
                )
            ),
            examQuestionsAndModels = listOf(
                WritingExamQuestion(
                    id = "wq_msg_1",
                    boardRef = "MP Board Class 9th–10th Practice Question",
                    marks = 4,
                    questionEn = "Your friend Rahul called to inform you that your English teacher is on leave tomorrow and extra class is cancelled. Write a message for your sister Pooja before going to market.",
                    questionHi = "अपने मित्र राहुल के फोन संदेश के आधार पर अपनी बहन पूजा के लिए 45 शब्दों में एक Message लिखिए।",
                    modelAnswer = """
+------------------------------------------+
|                 MESSAGE                  |
| 11 Nov 2025                    6:00 PM   |
|                                          |
| Dear Pooja,                              |
| Rahul called up just now to inform that  |
| English Sir is on leave tomorrow, so the |
| morning extra class stands cancelled.    |
| School will begin at the regular time.   |
|                                          |
| Ankit                                    |
+------------------------------------------+
                    """.trimIndent()
                )
            ),
            practiceExercises = listOf(
                WritingExercise(
                    id = "wp_msg_1",
                    promptEn = "Write a 45-word Message for your mother informing that you are going to your friend's house to collect science notes and will return by 7 PM.",
                    promptHi = "माताजी के लिए 45 शब्दों में एक Message लिखिए कि आप मित्र के घर विज्ञान के नोट्स लेने जा रहे हैं।",
                    marks = 4,
                    hintsHi = "बॉक्स के अंदर MESSAGE, Date, Time, मुख्य बात और नीचे अपना नाम लिखें।"
                )
            )
        )
    )
}
