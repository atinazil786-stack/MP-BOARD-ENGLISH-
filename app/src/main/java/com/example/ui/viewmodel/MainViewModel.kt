package com.example.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.curriculum.ChapterEnrichmentRegistry
import com.example.data.curriculum.Class10Curriculum
import com.example.data.curriculum.Class11Curriculum
import com.example.data.curriculum.Class12Curriculum
import com.example.data.curriculum.Class9Curriculum
import com.example.data.curriculum.GrammarCurriculum
import com.example.data.curriculum.PreviousYearPapersCurriculum
import com.example.data.curriculum.WritingSkillsCurriculum
import com.example.data.local.LocalPreferences
import com.example.data.local.LocalUserSettings
import com.example.data.model.ActiveExamPaper
import com.example.data.model.AdminPdfNoteDoc
import com.example.data.model.AdminPreviousPaperDoc
import com.example.data.model.AdminTestPaperDoc
import com.example.data.model.AdminVideoLinkDoc
import com.example.data.model.AdminWritingMaterialDoc
import com.example.data.model.BookmarkDoc
import com.example.data.model.Chapter
import com.example.data.model.ChapterQuestion
import com.example.data.model.GrammarTopic
import com.example.data.model.PreviousYearPaper
import com.example.data.model.PyqQuestionItem
import com.example.data.model.PyqSectionType
import com.example.data.model.StudentTestSummaryDoc
import com.example.data.model.StudyProgressDoc
import com.example.data.model.TestResultDoc
import com.example.data.model.UserProfileDoc
import com.example.data.model.WritingExamQuestion
import com.example.data.model.WritingExercise
import com.example.data.model.WritingPracticeAttemptDoc
import com.example.data.model.WritingSkillTopic
import com.example.data.model.WritingSolvedExample
import com.example.data.repository.CurriculumRepository
import com.example.data.repository.StudentRepository
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class MainViewModel(
    private val currentUserId: String,
    private val userDisplayName: String,
    private val userEmail: String?,
    private val isEmailVerified: Boolean,
    private val studentRepository: StudentRepository,
    private val curriculumRepository: CurriculumRepository,
    private val localPrefs: LocalPreferences
) : ViewModel() {

    private val _isAdmin = MutableStateFlow(false)
    val isAdmin: StateFlow<Boolean> = _isAdmin.asStateFlow()

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _statusMessage = MutableStateFlow<String?>(null)
    val statusMessage: StateFlow<String?> = _statusMessage.asStateFlow()

    private val _firestoreError = MutableStateFlow<String?>(null)
    val firestoreError: StateFlow<String?> = _firestoreError.asStateFlow()

    val localSettings: StateFlow<LocalUserSettings> = localPrefs.settingsFlow
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), LocalUserSettings())

    val userProfile: StateFlow<UserProfileDoc?> = studentRepository.observeUserProfile(currentUserId)
        .catch { error ->
            handleStreamError("userProfile", error)
            emit(null)
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), null)

    val bookmarks: StateFlow<List<BookmarkDoc>> = studentRepository.observeBookmarks(currentUserId)
        .catch { error ->
            handleStreamError("bookmarks", error)
            emit(emptyList())
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())

    val progressList: StateFlow<List<StudyProgressDoc>> = studentRepository.observeProgress(currentUserId)
        .catch { error ->
            handleStreamError("progress", error)
            emit(emptyList())
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())

    val testHistory: StateFlow<List<TestResultDoc>> = studentRepository.observeTestHistory(currentUserId)
        .catch { error ->
            handleStreamError("testHistory", error)
            emit(emptyList())
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())

    val writingPracticeHistory: StateFlow<List<WritingPracticeAttemptDoc>> =
        studentRepository.observeWritingPracticeHistory(currentUserId)
            .catch { error ->
                handleStreamError("writingPractice", error)
                emit(emptyList())
            }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())

    private val adminChaptersFlow = curriculumRepository.observePublishedAdminChapters()
        .catch { error ->
            handleStreamError("chapters", error)
            emit(emptyList())
        }

    val adminQuestions: StateFlow<List<ChapterQuestion>> = curriculumRepository.observePublishedAdminQuestions()
        .catch { error ->
            handleStreamError("chapterQuestions", error)
            emit(emptyList())
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())

    private val adminGrammarFlow = curriculumRepository.observePublishedAdminGrammar()
        .catch { error ->
            handleStreamError("grammarTopics", error)
            emit(emptyList())
        }

    val customTestPapers: StateFlow<List<AdminTestPaperDoc>> = curriculumRepository.observePublishedCustomTests()
        .catch { error ->
            handleStreamError("customTests", error)
            emit(emptyList())
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())

    val pdfNotes: StateFlow<List<AdminPdfNoteDoc>> = curriculumRepository.observePublishedPdfNotes()
        .catch { error ->
            handleStreamError("pdfNotes", error)
            emit(emptyList())
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())

    val videoLinks: StateFlow<List<AdminVideoLinkDoc>> = curriculumRepository.observePublishedVideoLinks()
        .catch { error ->
            handleStreamError("videoLinks", error)
            emit(emptyList())
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())

    val adminWritingMaterials: StateFlow<List<AdminWritingMaterialDoc>> = curriculumRepository.observePublishedWritingMaterials()
        .catch { error ->
            handleStreamError("writingMaterials", error)
            emit(emptyList())
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())

    private val teacherProfileConfigFlow = curriculumRepository.observeTeacherProfileConfig()
        .catch { error ->
            handleStreamError("teacherProfileConfig", error)
            emit(null)
        }

    val teacherPhotoBase64: StateFlow<String> = combine(
        teacherProfileConfigFlow,
        localSettings
    ) { remoteConfig, local ->
        if (remoteConfig != null) {
            remoteConfig.photoBase64.ifBlank { local.teacherPhotoBase64 }
        } else {
            local.teacherPhotoBase64
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), "")

    val writingTopics: StateFlow<List<WritingSkillTopic>> = adminWritingMaterials
        .combine(MutableStateFlow(WritingSkillsCurriculum.topics)) { remoteDocs, baseTopics ->
            val mappedRemote = remoteDocs.mapIndexed { idx, doc ->
                doc.toDomainWritingTopic(orderIndex = baseTopics.size + idx + 1)
            }
            (baseTopics + mappedRemote).distinctBy { it.id }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), WritingSkillsCurriculum.topics)

    val adminPreviousPapers: StateFlow<List<AdminPreviousPaperDoc>> = curriculumRepository.observePublishedPreviousPapers()
        .catch { error ->
            handleStreamError("previousPapers", error)
            emit(emptyList())
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())

    val previousPapers: StateFlow<List<PreviousYearPaper>> = adminPreviousPapers
        .combine(MutableStateFlow(PreviousYearPapersCurriculum.papers)) { remotePapers, basePapers ->
            val mappedRemote = remotePapers.map { it.toDomainPaper() }
            (mappedRemote + basePapers)
                .distinctBy { it.id }
                .sortedWith(compareBy<PreviousYearPaper> { it.classLevel }.thenByDescending { it.year })
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), PreviousYearPapersCurriculum.papers)

    @OptIn(ExperimentalCoroutinesApi::class)
    val adminStudentResults: StateFlow<List<StudentTestSummaryDoc>> = isAdmin
        .flatMapLatest { admin ->
            if (admin) {
                studentRepository.observeAllStudentTestResults()
                    .catch { error ->
                        handleStreamError("studentTestResults", error)
                        emit(emptyList())
                    }
            } else {
                flowOf(emptyList())
            }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())

    private val baseChapters: List<Chapter> = ChapterEnrichmentRegistry.enrichAll(
        Class9Curriculum.chapters +
            Class10Curriculum.chapters +
            Class11Curriculum.chapters +
            Class12Curriculum.chapters
    )

    val chapters: StateFlow<List<Chapter>> = combine(adminChaptersFlow, adminQuestions) { remoteChapters, remoteQs ->
        val enrichedRemote = remoteChapters.map { ChapterEnrichmentRegistry.enrichChapter(it) }
        val mergedChapters = (baseChapters + enrichedRemote)
            .distinctBy { it.id }
            .map { chapter ->
                val extraForChapter = remoteQs.filter { it.chapterId == chapter.id }
                if (extraForChapter.isEmpty()) chapter
                else chapter.copy(questions = (chapter.questions + extraForChapter).distinctBy { it.id })
            }
        mergedChapters.sortedWith(compareBy<Chapter> { it.classLevel }.thenBy { it.bookName }.thenBy { it.chapterNumber })
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), baseChapters)

    val grammarTopics: StateFlow<List<GrammarTopic>> = adminGrammarFlow
        .combine(MutableStateFlow(GrammarCurriculum.topics)) { remoteGrammar, baseGrammar ->
            (baseGrammar + remoteGrammar).distinctBy { it.id }
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), GrammarCurriculum.topics)

    init {
        viewModelScope.launch {
            studentRepository.ensureUserProfile(
                userId = currentUserId,
                displayName = userDisplayName,
                email = userEmail,
                defaultClass = localSettings.value.selectedClass
            )
            _isAdmin.value = studentRepository.checkIsAdmin(currentUserId, userEmail, isEmailVerified)
        }
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun clearStatusMessage() {
        _statusMessage.value = null
    }

    fun selectClass(classLevel: Int) {
        viewModelScope.launch {
            localPrefs.setSelectedClass(classLevel)
            val profile = userProfile.value
            studentRepository.updateUserPreferences(
                userId = currentUserId,
                selectedClass = classLevel,
                darkMode = profile?.darkMode ?: localSettings.value.darkMode,
                bilingualMode = profile?.bilingualMode ?: localSettings.value.bilingualMode
            )
        }
    }

    fun toggleDarkMode(enabled: Boolean) {
        viewModelScope.launch {
            localPrefs.setDarkMode(enabled)
            val profile = userProfile.value
            studentRepository.updateUserPreferences(
                userId = currentUserId,
                selectedClass = profile?.selectedClass?.toInt() ?: localSettings.value.selectedClass,
                darkMode = enabled,
                bilingualMode = profile?.bilingualMode ?: localSettings.value.bilingualMode
            )
        }
    }

    fun toggleBilingualMode(enabled: Boolean) {
        viewModelScope.launch {
            localPrefs.setBilingualMode(enabled)
            val profile = userProfile.value
            studentRepository.updateUserPreferences(
                userId = currentUserId,
                selectedClass = profile?.selectedClass?.toInt() ?: localSettings.value.selectedClass,
                darkMode = profile?.darkMode ?: localSettings.value.darkMode,
                bilingualMode = enabled
            )
        }
    }

    fun toggleChapterBookmark(chapter: Chapter) {
        viewModelScope.launch {
            val bmId = "bm_ch_${chapter.id}"
            val exists = bookmarks.value.any { it.id == bmId }
            val result = studentRepository.toggleBookmark(
                userId = currentUserId,
                bookmarkId = bmId,
                itemType = "chapter",
                targetId = chapter.id,
                classLevel = chapter.classLevel,
                title = chapter.title,
                subtitle = "Class ${chapter.classLevel} • ${chapter.bookName}",
                currentlySaved = exists
            )
            result.onSuccess { saved ->
                _statusMessage.value = if (saved) "Chapter bookmarked" else "Bookmark removed"
            }.onFailure { err ->
                _statusMessage.value = err.localizedMessage ?: "Unable to update bookmark"
            }
        }
    }

    fun toggleFavoriteQuestion(question: ChapterQuestion, contextTitle: String) {
        viewModelScope.launch {
            val bmId = "bm_q_${question.id}"
            val exists = bookmarks.value.any { it.id == bmId }
            val result = studentRepository.toggleBookmark(
                userId = currentUserId,
                bookmarkId = bmId,
                itemType = "question",
                targetId = question.id,
                classLevel = question.classLevel,
                title = question.promptEn.take(180),
                subtitle = contextTitle.take(350),
                currentlySaved = exists
            )
            result.onSuccess { saved ->
                _statusMessage.value = if (saved) "Added to Favourite Questions" else "Removed from Favourites"
            }.onFailure { err ->
                _statusMessage.value = err.localizedMessage ?: "Unable to save question"
            }
        }
    }

    fun removeBookmarkById(bookmark: BookmarkDoc) {
        viewModelScope.launch {
            studentRepository.toggleBookmark(
                userId = currentUserId,
                bookmarkId = bookmark.id,
                itemType = bookmark.itemType,
                targetId = bookmark.targetId,
                classLevel = bookmark.classLevel.toInt(),
                title = bookmark.title,
                subtitle = bookmark.subtitle,
                currentlySaved = true
            )
        }
    }

    fun markSectionCompleted(chapterId: String, classLevel: Int, sectionKey: String) {
        viewModelScope.launch {
            studentRepository.markChapterSectionCompleted(
                userId = currentUserId,
                chapterId = chapterId,
                classLevel = classLevel,
                sectionKey = sectionKey
            )
        }
    }

    fun saveExamScore(
        paper: ActiveExamPaper,
        correct: Int,
        wrong: Int,
        skipped: Int,
        durationUsedSeconds: Int
    ) {
        viewModelScope.launch {
            val total = paper.questions.size.coerceAtLeast(1)
            val pct = ((correct * 100) / total).coerceIn(0, 100)
            studentRepository.saveTestResult(
                userId = currentUserId,
                testTitle = paper.title,
                testMode = paper.mode.code,
                classLevel = paper.classLevel,
                totalQuestions = total,
                correctCount = correct,
                wrongCount = wrong,
                skippedCount = skipped,
                percentage = pct,
                durationSeconds = durationUsedSeconds,
                studentName = userProfile.value?.displayName ?: userDisplayName
            )
            val currentStreak = (userProfile.value?.dailyStreak?.toInt() ?: localSettings.value.dailyStreak)
            val newStreak = if (paper.mode.code == "DAILY_QUIZ") currentStreak + 1 else currentStreak
            val totalTests = (userProfile.value?.totalTestsTaken?.toInt() ?: testHistory.value.size) + 1
            studentRepository.incrementStreakAndTestCount(currentUserId, newStreak, totalTests)
            if (paper.mode.code == "DAILY_QUIZ") {
                localPrefs.recordDailyQuizCompletion("today", newStreak)
            }
        }
    }

    private fun handleStreamError(source: String, error: Throwable) {
        val firestoreError = generateSequence(error) { it.cause }
            .filterIsInstance<FirebaseFirestoreException>()
            .firstOrNull()
        if (firestoreError == null && error is CancellationException) throw error
        val rootError = firestoreError ?: error
        Log.w(TAG, "Error observing $source", rootError)
        _firestoreError.value = rootError.message ?: "Failed to sync $source"
    }

    private companion object {
        const val TAG = "MainViewModel"
    }
}

private fun AdminWritingMaterialDoc.toDomainWritingTopic(orderIndex: Int): WritingSkillTopic {
    val classes = applicableClasses.map { it.toInt() }.filter { it in 9..12 }.ifEmpty { listOf(9, 10, 11, 12) }
    val solved = if (solvedExampleEn.isNotBlank()) {
        listOf(
            WritingSolvedExample(
                title = title,
                questionEn = examQuestion.ifBlank { "Write a $topicCategory on \"$title\"." },
                englishAnswer = solvedExampleEn,
                hindiExplanation = solvedExampleHi.ifBlank { explanationHi }
            )
        )
    } else emptyList()

    val examQs = if (examQuestion.isNotBlank()) {
        listOf(
            WritingExamQuestion(
                id = "wm_eq_$id",
                boardRef = "Added by Imran Gori Sir",
                marks = 4,
                questionEn = examQuestion,
                questionHi = titleHi,
                modelAnswer = modelAnswer.ifBlank { solvedExampleEn }
            )
        )
    } else emptyList()

    val exercises = listOf(
        WritingExercise(
            id = "wm_ex_$id",
            promptEn = examQuestion.ifBlank { "Practice writing $topicCategory: $title" },
            promptHi = titleHi,
            marks = 4,
            hintsHi = explanationHi.take(180)
        )
    )

    return WritingSkillTopic(
        id = id,
        order = orderIndex,
        titleEn = title,
        titleHi = titleHi.ifBlank { topicCategory },
        applicableClasses = classes,
        syllabusNoteHi = "Imran Gori Sir द्वारा जोड़ा गया: $topicCategory (Classes ${classes.joinToString(", ")})",
        explanationHi = explanationHi,
        rulesAndFormatEn = listOf("Topic Category: $topicCategory", "Follow standard MP Board format below."),
        formatTemplate = formatTemplate,
        stepsHi = emptyList(),
        solvedExamples = solved,
        examQuestionsAndModels = examQs,
        practiceExercises = exercises,
        isAdminAdded = true
    )
}

private fun AdminPreviousPaperDoc.toDomainPaper(): PreviousYearPaper {
    val parsedQuestions = questionsFormatted.mapIndexedNotNull { idx, raw ->
        val clean = raw.trim()
        if (clean.isEmpty()) return@mapIndexedNotNull null
        val parts = clean.split("::").map { it.trim() }
        val sectionType = when (parts.getOrNull(0)?.uppercase()) {
            "OBJECTIVE", "MCQ" -> PyqSectionType.OBJECTIVE
            "VERY_SHORT", "VS" -> PyqSectionType.VERY_SHORT
            "SHORT", "S" -> PyqSectionType.SHORT
            "LONG", "L" -> PyqSectionType.LONG
            else -> PyqSectionType.SHORT
        }
        val questionText = if (parts.size >= 2) parts[1] else clean
        val answerText = parts.getOrNull(2).orEmpty().ifBlank { "Refer to uploaded PDF / Imran Gori Sir notes." }
        val explanation = parts.getOrNull(3).orEmpty()
        PyqQuestionItem(
            id = "${id}_q_$idx",
            sectionType = sectionType,
            chapterTag = parts.getOrNull(4)?.ifBlank { "MP Board Paper" } ?: "MP Board Paper",
            marks = when (sectionType) {
                PyqSectionType.OBJECTIVE -> 1
                PyqSectionType.VERY_SHORT -> 2
                PyqSectionType.SHORT -> 3
                PyqSectionType.LONG -> 5
            },
            questionEn = questionText,
            questionHi = "",
            answerKeyEn = answerText,
            modelSolutionEn = answerText,
            explanationHi = explanation
        )
    }

    return PreviousYearPaper(
        id = id,
        classLevel = classLevel.toInt(),
        year = year.toInt(),
        title = title,
        titleHi = "इमरान गोरी सर द्वारा अपलोड किया गया पेपर ($year)",
        setCode = setCode,
        isVerifiedPyq = isVerifiedPyq,
        sourceLabel = if (isVerifiedPyq) "Uploaded PYQ $year (Imran Gori Sir)" else "Blueprint / Practice $year",
        summaryHi = summaryHi.ifBlank { "Imran Gori Sir द्वारा अपलोड किया गया प्रश्न पत्र PDF व महत्वपूर्ण प्रश्न।" },
        chapterTopicsTag = listOf("Uploaded Paper"),
        questions = parsedQuestions,
        pdfUrl = pdfUrl,
        pdfBase64 = pdfBase64,
        pdfFileName = pdfFileName,
        isAdminAdded = true
    )
}
