package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.MenuBook
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Quiz
import androidx.compose.material.icons.rounded.Spellcheck
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.credentials.CredentialManager
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.core.firebase.attemptAutoSignIn
import com.example.core.firebase.authStateFlow
import com.example.core.firebase.configureAppCheck
import com.example.core.firebase.onGoogleSignInClicked
import com.example.core.firebase.signOut
import com.example.data.local.AppLocalDatabase
import com.example.data.local.LocalPreferences
import com.example.data.model.ChapterQuestion
import com.example.data.model.ExamMode
import com.example.data.model.PyqSectionType
import com.example.data.model.QuestionSourceTag
import com.example.data.model.QuestionType
import com.example.data.repository.AiTeacherRepository
import com.example.data.repository.CurriculumRepository
import com.example.data.repository.StudentRepository
import com.example.ui.screens.AboutTeacherScreen
import com.example.ui.screens.AdminScreen
import com.example.ui.screens.AiAnswerPracticeScreen
import com.example.ui.screens.AskImranSirScreen
import com.example.ui.screens.AuthScreen
import com.example.ui.screens.ChapterDetailScreen
import com.example.ui.screens.ClassesScreen
import com.example.ui.screens.ExamRunnerScreen
import com.example.ui.screens.GrammarDetailScreen
import com.example.ui.screens.GrammarScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.PreviousYearPaperDetailScreen
import com.example.ui.screens.PreviousYearPapersDashboardScreen
import com.example.ui.screens.ProfileScreen
import com.example.ui.screens.ScorecardScreen
import com.example.ui.screens.SplashScreen
import com.example.ui.screens.TestsScreen
import com.example.ui.screens.WritingSkillDetailScreen
import com.example.ui.screens.WritingSkillsDashboardScreen
import com.example.ui.theme.MpEnglishHubTheme
import com.example.ui.viewmodel.AdminViewModel
import com.example.ui.viewmodel.AiTeacherViewModel
import com.example.ui.viewmodel.ExamViewModel
import com.example.ui.viewmodel.MainViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.auth

private enum class BottomNavTab(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    HOME("home", "Home", Icons.Rounded.Home),
    CLASSES("classes", "Classes", Icons.AutoMirrored.Rounded.MenuBook),
    GRAMMAR("grammar", "Grammar", Icons.Rounded.Spellcheck),
    TESTS("tests", "Tests", Icons.Rounded.Quiz),
    PROFILE("profile", "Profile", Icons.Rounded.Person)
}

private enum class OverlayView {
    NONE,
    CHAPTER_DETAIL,
    GRAMMAR_DETAIL,
    ASK_AI,
    ADMIN_STUDIO,
    WRITING_DASHBOARD,
    WRITING_DETAIL,
    PYQ_DASHBOARD,
    PYQ_DETAIL,
    AI_ANSWER_PRACTICE,
    ABOUT_TEACHER
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureAppCheck(this, intent)
        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            val localPrefs = remember(context) { LocalPreferences(context.applicationContext) }
            val localSettings by localPrefs.settingsFlow.collectAsStateWithLifecycle(
                initialValue = com.example.data.local.LocalUserSettings()
            )
            MpEnglishHubTheme(darkTheme = localSettings.darkMode) {
                MpBoardEnglishHubApp(localPrefs = localPrefs)
            }
        }
    }
}

@Composable
private fun MpBoardEnglishHubApp(localPrefs: LocalPreferences) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val credentialManager = remember(context) { CredentialManager.create(context) }

    val authUser by Firebase.auth.authStateFlow().collectAsStateWithLifecycle(
        initialValue = Firebase.auth.currentUser
    )

    var showSplash by remember { mutableStateOf(true) }
    var isSigningIn by remember { mutableStateOf(false) }
    var authError by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        if (Firebase.auth.currentUser == null) {
            attemptAutoSignIn(
                context = context,
                credentialManager = credentialManager,
                onAuthSuccess = {
                    authError = null
                },
                onUnauthenticated = {},
                scope = scope
            )
        }
    }

    if (showSplash) {
        SplashScreen(onFinished = { showSplash = false })
        return
    }

    val user = authUser
    if (user == null) {
        AuthScreen(
            isSigningIn = isSigningIn,
            errorMessage = authError,
            onGoogleSignInClick = {
                isSigningIn = true
                authError = null
                onGoogleSignInClicked(
                    context = context,
                    credentialManager = credentialManager,
                    onAuthSuccess = {
                        isSigningIn = false
                        authError = null
                    },
                    onAuthError = { err ->
                        isSigningIn = false
                        authError = err
                    },
                    scope = scope,
                    onAuthCancelled = {
                        isSigningIn = false
                    }
                )
            }
        )
    } else {
        key(user.uid) {
            AuthenticatedHubShell(
                user = user,
                localPrefs = localPrefs,
                onSignOut = {
                    signOut(credentialManager = credentialManager, scope = scope)
                }
            )
        }
    }
}

@Composable
private fun AuthenticatedHubShell(
    user: FirebaseUser,
    localPrefs: LocalPreferences,
    onSignOut: () -> Unit
) {
    val context = LocalContext.current
    val appContext = context.applicationContext

    val dao = remember(appContext) { AppLocalDatabase.getInstance(appContext).studentDao() }
    val studentRepo = remember(appContext, dao) { StudentRepository(appContext, dao) }

    val mainViewModel: MainViewModel = viewModel(
        key = "main_${user.uid}",
        factory = viewModelFactory {
            initializer {
                val curriculumRepo = CurriculumRepository(appContext)
                MainViewModel(
                    currentUserId = user.uid,
                    userDisplayName = user.displayName ?: "MP Board Student",
                    userEmail = user.email,
                    isEmailVerified = user.isEmailVerified,
                    studentRepository = studentRepo,
                    curriculumRepository = curriculumRepo,
                    localPrefs = localPrefs
                )
            }
        }
    )

    val examViewModel: ExamViewModel = viewModel(key = "exam_${user.uid}")
    val aiViewModel: AiTeacherViewModel = viewModel(
        key = "ai_${user.uid}",
        factory = viewModelFactory {
            initializer { AiTeacherViewModel(AiTeacherRepository()) }
        }
    )
    val adminViewModel: AdminViewModel = viewModel(
        key = "admin_${user.uid}",
        factory = viewModelFactory {
            initializer {
                AdminViewModel(
                    currentUserId = user.uid,
                    curriculumRepository = CurriculumRepository(appContext),
                    localPrefs = localPrefs
                )
            }
        }
    )

    val localSettings by mainViewModel.localSettings.collectAsStateWithLifecycle()
    val userProfile by mainViewModel.userProfile.collectAsStateWithLifecycle()
    val isAdmin by mainViewModel.isAdmin.collectAsStateWithLifecycle()
    val searchQuery by mainViewModel.searchQuery.collectAsStateWithLifecycle()
    val chapters by mainViewModel.chapters.collectAsStateWithLifecycle()
    val adminQuestions by mainViewModel.adminQuestions.collectAsStateWithLifecycle()
    val grammarTopics by mainViewModel.grammarTopics.collectAsStateWithLifecycle()
    val customTestPapers by mainViewModel.customTestPapers.collectAsStateWithLifecycle()
    val writingTopics by mainViewModel.writingTopics.collectAsStateWithLifecycle()
    val previousPapers by mainViewModel.previousPapers.collectAsStateWithLifecycle()
    val pdfNotes by mainViewModel.pdfNotes.collectAsStateWithLifecycle()
    val videoLinks by mainViewModel.videoLinks.collectAsStateWithLifecycle()
    val writingPracticeHistory by mainViewModel.writingPracticeHistory.collectAsStateWithLifecycle()
    val adminWritingMaterials by mainViewModel.adminWritingMaterials.collectAsStateWithLifecycle()
    val adminPreviousPapers by mainViewModel.adminPreviousPapers.collectAsStateWithLifecycle()
    val adminStudentResults by mainViewModel.adminStudentResults.collectAsStateWithLifecycle()
    val bookmarks by mainViewModel.bookmarks.collectAsStateWithLifecycle()
    val progressList by mainViewModel.progressList.collectAsStateWithLifecycle()
    val testHistory by mainViewModel.testHistory.collectAsStateWithLifecycle()
    val teacherPhotoBase64 by mainViewModel.teacherPhotoBase64.collectAsStateWithLifecycle()
    val statusMessage by mainViewModel.statusMessage.collectAsStateWithLifecycle()
    val examState by examViewModel.uiState.collectAsStateWithLifecycle()
    val aiState by aiViewModel.uiState.collectAsStateWithLifecycle()
    val aiPracticeState by aiViewModel.practiceState.collectAsStateWithLifecycle()
    val adminState by adminViewModel.uiState.collectAsStateWithLifecycle()

    val selectedClass = userProfile?.selectedClass?.toInt() ?: localSettings.selectedClass
    val bilingualMode = userProfile?.bilingualMode ?: localSettings.bilingualMode
    val darkMode = localSettings.darkMode
    val streakCount = userProfile?.dailyStreak?.toInt() ?: localSettings.dailyStreak
    val testsTaken = userProfile?.totalTestsTaken?.toInt() ?: testHistory.size

    val snackbarHostState = remember { SnackbarHostState() }
    LaunchedEffect(statusMessage) {
        val msg = statusMessage ?: return@LaunchedEffect
        snackbarHostState.showSnackbar(msg)
        mainViewModel.clearStatusMessage()
    }

    var activeOverlay by remember { mutableStateOf(OverlayView.NONE) }
    var activeChapterId by remember { mutableStateOf<String?>(null) }
    var activeGrammarId by remember { mutableStateOf<String?>(null) }
    var activeWritingTopicId by remember { mutableStateOf<String?>(null) }
    var activePyqId by remember { mutableStateOf<String?>(null) }
    var aiPrefillQuestion by remember { mutableStateOf<String?>(null) }
    var aiPrefillAnswer by remember { mutableStateOf<String?>(null) }
    var aiPrefillMarks by remember { mutableStateOf<Int?>(null) }
    var aiPrefillTitle by remember { mutableStateOf<String?>(null) }
    var classesCategoryFilter by remember { mutableStateOf("All") }
    var adminInitialTab by remember { mutableStateOf(0) }

    val saveScoreCallback: (com.example.ui.viewmodel.ExamResultSummary) -> Unit = { summary ->
        mainViewModel.saveExamScore(
            paper = summary.paper,
            correct = summary.correctCount,
            wrong = summary.wrongCount,
            skipped = summary.skippedCount,
            durationUsedSeconds = summary.timeTakenSeconds
        )
    }

    // Active Exam Runner or Scorecard full-screen flow takes top priority
    if (examState.resultSummary != null) {
        ScorecardScreen(
            summary = examState.resultSummary!!,
            bilingualMode = bilingualMode,
            onRetake = { examViewModel.retakeExam(saveScoreCallback) },
            onClose = { examViewModel.exitExam() }
        )
        return
    }

    if (examState.activePaper != null) {
        ExamRunnerScreen(
            uiState = examState,
            bilingualMode = bilingualMode,
            onSelectAnswer = { qIdx, optIdx -> examViewModel.selectAnswer(qIdx, optIdx) },
            onJumpToQuestion = { examViewModel.jumpToQuestion(it) },
            onToggleFlag = { examViewModel.toggleFlag(it) },
            onSubmitExam = { examViewModel.submitExam(saveScoreCallback) },
            onExitExam = { examViewModel.exitExam() }
        )
        return
    }

    // Secondary Full-Screen Views with BackHandler
    if (activeOverlay != OverlayView.NONE) {
        BackHandler {
            activeOverlay = when (activeOverlay) {
                OverlayView.WRITING_DETAIL -> OverlayView.WRITING_DASHBOARD
                OverlayView.PYQ_DETAIL -> OverlayView.PYQ_DASHBOARD
                else -> OverlayView.NONE
            }
        }
        when (activeOverlay) {
            OverlayView.CHAPTER_DETAIL -> {
                val chapter = chapters.firstOrNull { it.id == activeChapterId }
                if (chapter != null) {
                    val sameBook = chapters.filter { it.classLevel == chapter.classLevel && it.bookName == chapter.bookName }
                    val completed = progressList.firstOrNull { it.chapterId == chapter.id }?.completedSections.orEmpty()
                    val notesForChapter = pdfNotes.filter {
                        it.classLevel.toInt() == chapter.classLevel && (it.chapterId == chapter.id || it.chapterId == "general")
                    }
                    val videosForChapter = videoLinks.filter {
                        it.classLevel.toInt() == chapter.classLevel && it.chapterId == chapter.id
                    }
                    ChapterDetailScreen(
                        chapter = chapter,
                        sameBookChapters = sameBook,
                        bilingualMode = bilingualMode,
                        bookmarks = bookmarks,
                        completedSections = completed,
                        chapterPdfNotes = notesForChapter,
                        chapterVideoLinks = videosForChapter,
                        onBack = { activeOverlay = OverlayView.NONE },
                        onSwitchChapter = { activeChapterId = it.id },
                        onToggleBookmark = { mainViewModel.toggleChapterBookmark(it) },
                        onToggleFavoriteQuestion = { q, ctx -> mainViewModel.toggleFavoriteQuestion(q, ctx) },
                        onMarkSectionCompleted = { secKey -> mainViewModel.markSectionCompleted(chapter.id, chapter.classLevel, secKey) },
                        onLaunchChapterTest = { ch, questionCount, durationMinutes ->
                            activeOverlay = OverlayView.NONE
                            examViewModel.startExam(
                                title = "Chapter Test ($questionCount Q): ${ch.title}",
                                mode = ExamMode.CHAPTER_WISE,
                                classLevel = ch.classLevel,
                                durationMinutes = durationMinutes,
                                questionCount = questionCount,
                                chapters = chapters,
                                grammarTopics = grammarTopics,
                                extraQuestions = adminQuestions,
                                chapterIdFilter = ch.id,
                                onAutoSaveResult = saveScoreCallback
                            )
                        }
                    )
                    return
                } else {
                    activeOverlay = OverlayView.NONE
                }
            }
            OverlayView.GRAMMAR_DETAIL -> {
                val topic = grammarTopics.firstOrNull { it.id == activeGrammarId }
                if (topic != null) {
                    GrammarDetailScreen(
                        topic = topic,
                        bilingualMode = bilingualMode,
                        bookmarks = bookmarks,
                        onBack = { activeOverlay = OverlayView.NONE },
                        onToggleFavoriteQuestion = { q, ctx -> mainViewModel.toggleFavoriteQuestion(q, ctx) }
                    )
                    return
                } else {
                    activeOverlay = OverlayView.NONE
                }
            }
            OverlayView.ASK_AI -> {
                AskImranSirScreen(
                    selectedClass = selectedClass,
                    teacherPhotoBase64 = teacherPhotoBase64,
                    uiState = aiState,
                    onSelectMode = { aiViewModel.selectMode(it) },
                    onSendQuery = { aiViewModel.sendQuery(it, selectedClass) },
                    onClearChat = { aiViewModel.clearChat() },
                    onBack = { activeOverlay = OverlayView.NONE }
                )
                return
            }
            OverlayView.ADMIN_STUDIO -> {
                AdminScreen(
                    isAdmin = isAdmin,
                    teacherPhotoBase64 = teacherPhotoBase64,
                    initialTab = adminInitialTab,
                    adminUiState = adminState,
                    adminViewModel = adminViewModel,
                    chapters = chapters,
                    adminQuestions = adminQuestions,
                    grammarTopics = grammarTopics,
                    customTestPapers = customTestPapers,
                    pdfNotes = pdfNotes,
                    adminPreviousPapers = adminPreviousPapers,
                    videoLinks = videoLinks,
                    adminWritingMaterials = adminWritingMaterials,
                    studentTestResults = adminStudentResults,
                    onBack = { activeOverlay = OverlayView.NONE }
                )
                return
            }
            OverlayView.WRITING_DASHBOARD -> {
                WritingSkillsDashboardScreen(
                    selectedClass = selectedClass,
                    bilingualMode = bilingualMode,
                    topics = writingTopics,
                    onOpenTopic = { topic ->
                        activeWritingTopicId = topic.id
                        activeOverlay = OverlayView.WRITING_DETAIL
                    },
                    onOpenAiAnswerPractice = {
                        aiPrefillQuestion = null
                        aiPrefillAnswer = null
                        aiPrefillMarks = null
                        aiPrefillTitle = null
                        aiViewModel.clearPracticeEvaluation()
                        activeOverlay = OverlayView.AI_ANSWER_PRACTICE
                    },
                    onBack = { activeOverlay = OverlayView.NONE }
                )
                return
            }
            OverlayView.WRITING_DETAIL -> {
                val topic = writingTopics.firstOrNull { it.id == activeWritingTopicId }
                if (topic != null) {
                    WritingSkillDetailScreen(
                        topic = topic,
                        bilingualMode = bilingualMode,
                        onBack = { activeOverlay = OverlayView.WRITING_DASHBOARD },
                        onSendToAiEvaluation = { qPrompt, draft, marks, title ->
                            aiPrefillQuestion = qPrompt
                            aiPrefillAnswer = draft
                            aiPrefillMarks = marks
                            aiPrefillTitle = title
                            aiViewModel.clearPracticeEvaluation()
                            activeOverlay = OverlayView.AI_ANSWER_PRACTICE
                        }
                    )
                    return
                } else {
                    activeOverlay = OverlayView.WRITING_DASHBOARD
                }
            }
            OverlayView.PYQ_DASHBOARD -> {
                val launchPyqPractice: (com.example.data.model.PreviousYearPaper) -> Unit = { pyq ->
                    val pyqMcqs = pyq.questions
                        .filter { it.sectionType == PyqSectionType.OBJECTIVE && it.options.isNotEmpty() && it.correctOptionIndex >= 0 }
                        .map { q ->
                            ChapterQuestion(
                                id = q.id,
                                chapterId = pyq.id,
                                classLevel = pyq.classLevel,
                                type = QuestionType.MCQ,
                                sourceTag = if (pyq.isVerifiedPyq) QuestionSourceTag.MP_BOARD_VERIFIED else QuestionSourceTag.PRACTICE,
                                promptEn = q.questionEn,
                                promptHi = q.questionHi,
                                answerEn = q.answerKeyEn,
                                options = q.options,
                                correctOptionIndex = q.correctOptionIndex,
                                explanationHi = q.explanationHi
                            )
                        }
                    activeOverlay = OverlayView.NONE
                    examViewModel.startCustomQuestionListExam(
                        title = "${pyq.title} Practice",
                        classLevel = pyq.classLevel,
                        durationMinutes = 15,
                        customMcqs = pyqMcqs,
                        fallbackChapters = chapters,
                        fallbackGrammar = grammarTopics,
                        onAutoSaveResult = saveScoreCallback
                    )
                }
                PreviousYearPapersDashboardScreen(
                    selectedClass = selectedClass,
                    bilingualMode = bilingualMode,
                    papers = previousPapers,
                    onOpenPaper = { paper ->
                        activePyqId = paper.id
                        activeOverlay = OverlayView.PYQ_DETAIL
                    },
                    onPracticeOnline = launchPyqPractice,
                    onBack = { activeOverlay = OverlayView.NONE }
                )
                return
            }
            OverlayView.PYQ_DETAIL -> {
                val paper = previousPapers.firstOrNull { it.id == activePyqId }
                if (paper != null) {
                    PreviousYearPaperDetailScreen(
                        paper = paper,
                        bilingualMode = bilingualMode,
                        onPracticeOnline = { pyq ->
                            val pyqMcqs = pyq.questions
                                .filter { it.sectionType == PyqSectionType.OBJECTIVE && it.options.isNotEmpty() && it.correctOptionIndex >= 0 }
                                .map { q ->
                                    ChapterQuestion(
                                        id = q.id,
                                        chapterId = pyq.id,
                                        classLevel = pyq.classLevel,
                                        type = QuestionType.MCQ,
                                        sourceTag = if (pyq.isVerifiedPyq) QuestionSourceTag.MP_BOARD_VERIFIED else QuestionSourceTag.PRACTICE,
                                        promptEn = q.questionEn,
                                        promptHi = q.questionHi,
                                        answerEn = q.answerKeyEn,
                                        options = q.options,
                                        correctOptionIndex = q.correctOptionIndex,
                                        explanationHi = q.explanationHi
                                    )
                                }
                            activeOverlay = OverlayView.NONE
                            examViewModel.startCustomQuestionListExam(
                                title = "${pyq.title} Practice",
                                classLevel = pyq.classLevel,
                                durationMinutes = 15,
                                customMcqs = pyqMcqs,
                                fallbackChapters = chapters,
                                fallbackGrammar = grammarTopics,
                                onAutoSaveResult = saveScoreCallback
                            )
                        },
                        onBack = { activeOverlay = OverlayView.PYQ_DASHBOARD }
                    )
                    return
                } else {
                    activeOverlay = OverlayView.PYQ_DASHBOARD
                }
            }
            OverlayView.AI_ANSWER_PRACTICE -> {
                AiAnswerPracticeScreen(
                    selectedClass = selectedClass,
                    bilingualMode = bilingualMode,
                    chapters = chapters,
                    practiceState = aiPracticeState,
                    practiceHistory = writingPracticeHistory,
                    prefilledQuestion = aiPrefillQuestion,
                    prefilledAnswer = aiPrefillAnswer,
                    prefilledMarks = aiPrefillMarks,
                    prefilledTitle = aiPrefillTitle,
                    onEvaluateAndSave = { cls, chId, chTitle, qPrompt, ans, marks, refAns ->
                        aiViewModel.evaluateAnswer(
                            userId = user.uid,
                            studentRepository = studentRepo,
                            classLevel = cls,
                            chapterId = chId,
                            chapterTitle = chTitle,
                            questionPrompt = qPrompt,
                            studentAnswer = ans,
                            maxMarks = marks,
                            referenceAnswer = refAns
                        )
                    },
                    onClearResult = { aiViewModel.clearPracticeEvaluation() },
                    onBack = { activeOverlay = OverlayView.NONE }
                )
                return
            }
            OverlayView.ABOUT_TEACHER -> {
                AboutTeacherScreen(
                    teacherPhotoBase64 = teacherPhotoBase64,
                    bilingualMode = bilingualMode,
                    totalChaptersCount = chapters.size,
                    isAdmin = isAdmin,
                    onOpenAskAi = { activeOverlay = OverlayView.ASK_AI },
                    onOpenAdminPhotoManager = {
                        adminInitialTab = 0
                        activeOverlay = OverlayView.ADMIN_STUDIO
                    },
                    onBack = { activeOverlay = OverlayView.NONE }
                )
                return
            }
            OverlayView.NONE -> Unit
        }
    }

    // Main 5-Tab Bottom Navigation / Adaptive NavigationRail Shell
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route ?: BottomNavTab.HOME.route

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val useRail = maxWidth >= 700.dp

        Scaffold(
            contentWindowInsets = WindowInsets.safeDrawing,
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { activeOverlay = OverlayView.ASK_AI },
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.onSecondary,
                    modifier = Modifier.testTag("fab_ask_imran_sir_ai")
                ) {
                    Icon(Icons.Rounded.AutoAwesome, contentDescription = "Open Ask Imran Sir AI")
                }
            },
            bottomBar = {
                if (!useRail) {
                    NavigationBar {
                        BottomNavTab.entries.forEach { tab ->
                            NavigationBarItem(
                                selected = currentRoute == tab.route,
                                onClick = {
                                    navController.navigate(tab.route) {
                                        popUpTo(BottomNavTab.HOME.route) { saveState = true }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                icon = { Icon(tab.icon, contentDescription = tab.label) },
                                label = { Text(tab.label, maxLines = 1) },
                                modifier = Modifier.testTag("nav_${tab.route}")
                            )
                        }
                    }
                }
            }
        ) { innerPadding ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
                if (useRail) {
                    NavigationRail {
                        BottomNavTab.entries.forEach { tab ->
                            NavigationRailItem(
                                selected = currentRoute == tab.route,
                                onClick = {
                                    navController.navigate(tab.route) {
                                        popUpTo(BottomNavTab.HOME.route) { saveState = true }
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                icon = { Icon(tab.icon, contentDescription = tab.label) },
                                label = { Text(tab.label) }
                            )
                        }
                    }
                }

                NavHost(
                    navController = navController,
                    startDestination = BottomNavTab.HOME.route,
                    modifier = Modifier.weight(1f)
                ) {
                    composable(BottomNavTab.HOME.route) {
                        HomeScreen(
                            studentName = userProfile?.displayName ?: user.displayName ?: "Student",
                            selectedClass = selectedClass,
                            bilingualMode = bilingualMode,
                            streakCount = streakCount,
                            testsTaken = testsTaken,
                            searchQuery = searchQuery,
                            teacherPhotoBase64 = teacherPhotoBase64,
                            chapters = chapters,
                            grammarTopics = grammarTopics,
                            writingTopics = writingTopics,
                            progressList = progressList,
                            onSearchQueryChange = { mainViewModel.updateSearchQuery(it) },
                            onClassCardClick = { cls ->
                                classesCategoryFilter = "All"
                                mainViewModel.selectClass(cls)
                                navController.navigate(BottomNavTab.CLASSES.route) {
                                    popUpTo(BottomNavTab.HOME.route) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            onOpenPoemsSection = {
                                classesCategoryFilter = "Poem"
                                navController.navigate(BottomNavTab.CLASSES.route) {
                                    popUpTo(BottomNavTab.HOME.route) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            onOpenAboutTeacher = { activeOverlay = OverlayView.ABOUT_TEACHER },
                            onChapterClick = { ch ->
                                activeChapterId = ch.id
                                activeOverlay = OverlayView.CHAPTER_DETAIL
                            },
                            onGrammarTopicClick = { topic ->
                                activeGrammarId = topic.id
                                activeOverlay = OverlayView.GRAMMAR_DETAIL
                            },
                            onWritingTopicClick = { wTopic ->
                                activeWritingTopicId = wTopic.id
                                activeOverlay = OverlayView.WRITING_DETAIL
                            },
                            onStartDailyQuiz = {
                                examViewModel.startExam(
                                    title = "Daily 5-Min Board Quiz (Class ${selectedClass}th)",
                                    mode = ExamMode.DAILY_QUIZ,
                                    classLevel = selectedClass,
                                    durationMinutes = ExamMode.DAILY_QUIZ.durationMinutes,
                                    questionCount = ExamMode.DAILY_QUIZ.questionCount,
                                    chapters = chapters,
                                    grammarTopics = grammarTopics,
                                    extraQuestions = adminQuestions,
                                    onAutoSaveResult = saveScoreCallback
                                )
                            },
                            onOpenAskAi = { activeOverlay = OverlayView.ASK_AI },
                            onOpenTests = {
                                navController.navigate(BottomNavTab.TESTS.route) {
                                    popUpTo(BottomNavTab.HOME.route) { saveState = true }
                                    launchSingleTop = true
                                    restoreState = true
                                }
                            },
                            onOpenWritingSkills = { activeOverlay = OverlayView.WRITING_DASHBOARD },
                            onOpenPyqPapers = { activeOverlay = OverlayView.PYQ_DASHBOARD },
                            onOpenAiAnswerPractice = {
                                aiPrefillQuestion = null
                                aiPrefillAnswer = null
                                aiPrefillMarks = null
                                aiPrefillTitle = null
                                aiViewModel.clearPracticeEvaluation()
                                activeOverlay = OverlayView.AI_ANSWER_PRACTICE
                            }
                        )
                    }

                    composable(BottomNavTab.CLASSES.route) {
                        ClassesScreen(
                            selectedClass = selectedClass,
                            bilingualMode = bilingualMode,
                            chapters = chapters,
                            bookmarks = bookmarks,
                            progressList = progressList,
                            selectedCategory = classesCategoryFilter,
                            onSelectCategory = { classesCategoryFilter = it },
                            onSelectClass = { mainViewModel.selectClass(it) },
                            onOpenChapter = { ch ->
                                activeChapterId = ch.id
                                activeOverlay = OverlayView.CHAPTER_DETAIL
                            },
                            onToggleBookmark = { mainViewModel.toggleChapterBookmark(it) }
                        )
                    }

                    composable(BottomNavTab.GRAMMAR.route) {
                        GrammarScreen(
                            grammarTopics = grammarTopics,
                            bilingualMode = bilingualMode,
                            onTopicClick = { topic ->
                                activeGrammarId = topic.id
                                activeOverlay = OverlayView.GRAMMAR_DETAIL
                            }
                        )
                    }

                    composable(BottomNavTab.TESTS.route) {
                        TestsScreen(
                            selectedClass = selectedClass,
                            bilingualMode = bilingualMode,
                            chapters = chapters,
                            customTestPapers = customTestPapers,
                            onStartStandardExam = { mode, cls, chapterFilter ->
                                val examTitle = if (chapterFilter != null) {
                                    "Chapter Test: ${chapterFilter.title}"
                                } else {
                                    "${mode.titleEn} (Class ${cls}th)"
                                }
                                examViewModel.startExam(
                                    title = examTitle,
                                    mode = mode,
                                    classLevel = cls,
                                    durationMinutes = mode.durationMinutes,
                                    questionCount = mode.questionCount,
                                    chapters = chapters,
                                    grammarTopics = grammarTopics,
                                    extraQuestions = adminQuestions,
                                    chapterIdFilter = chapterFilter?.id,
                                    onAutoSaveResult = saveScoreCallback
                                )
                            },
                            onStartCustomTest = { paper ->
                                val modeEnum = ExamMode.entries.firstOrNull { it.code == paper.testMode } ?: ExamMode.TEST_20
                                examViewModel.startExam(
                                    title = paper.title,
                                    mode = modeEnum,
                                    classLevel = paper.classLevel.toInt(),
                                    durationMinutes = paper.durationMinutes.toInt(),
                                    questionCount = paper.questionCount.toInt(),
                                    chapters = chapters,
                                    grammarTopics = grammarTopics,
                                    extraQuestions = adminQuestions,
                                    onAutoSaveResult = saveScoreCallback
                                )
                            },
                            onOpenPyqPapers = { activeOverlay = OverlayView.PYQ_DASHBOARD },
                            onOpenAiAnswerPractice = {
                                aiPrefillQuestion = null
                                aiPrefillAnswer = null
                                aiPrefillMarks = null
                                aiPrefillTitle = null
                                aiViewModel.clearPracticeEvaluation()
                                activeOverlay = OverlayView.AI_ANSWER_PRACTICE
                            }
                        )
                    }

                    composable(BottomNavTab.PROFILE.route) {
                        ProfileScreen(
                            displayName = userProfile?.displayName ?: user.displayName ?: "MP Board Student",
                            email = user.email,
                            selectedClass = selectedClass,
                            darkMode = darkMode,
                            bilingualMode = bilingualMode,
                            streakCount = streakCount,
                            testsTaken = testsTaken,
                            isAdmin = isAdmin,
                            teacherPhotoBase64 = teacherPhotoBase64,
                            chapters = chapters,
                            bookmarks = bookmarks,
                            progressList = progressList,
                            testHistory = testHistory,
                            onSelectClass = { mainViewModel.selectClass(it) },
                            onToggleDarkMode = { mainViewModel.toggleDarkMode(it) },
                            onToggleBilingualMode = { mainViewModel.toggleBilingualMode(it) },
                            onRemoveBookmark = { mainViewModel.removeBookmarkById(it) },
                            onOpenChapterById = { chId ->
                                activeChapterId = chId
                                activeOverlay = OverlayView.CHAPTER_DETAIL
                            },
                            onOpenAboutTeacher = { activeOverlay = OverlayView.ABOUT_TEACHER },
                            onOpenAskAi = { activeOverlay = OverlayView.ASK_AI },
                            onOpenAdminStudio = {
                                adminInitialTab = 0
                                activeOverlay = OverlayView.ADMIN_STUDIO
                            },
                            onSignOut = onSignOut
                        )
                    }
                }
            }
        }
    }
}
