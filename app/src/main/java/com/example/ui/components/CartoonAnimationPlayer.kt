package com.example.ui.components

import android.speech.tts.TextToSpeech
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.VolumeOff
import androidx.compose.material.icons.automirrored.rounded.VolumeUp
import androidx.compose.material.icons.rounded.Movie
import androidx.compose.material.icons.rounded.Pause
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.material.icons.rounded.Replay
import androidx.compose.material.icons.rounded.SkipNext
import androidx.compose.material.icons.rounded.SkipPrevious
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.data.model.CartoonMood
import com.example.data.model.CartoonScene
import com.example.data.model.CartoonSetting
import com.example.ui.theme.JetBrainsMonoFamily
import kotlinx.coroutines.delay
import java.util.Locale
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CartoonAnimationVideoPlayer(
    chapterId: String,
    chapterTitle: String,
    chapterTitleHi: String,
    scenes: List<CartoonScene>,
    bilingualMode: Boolean,
    onVideoCompleted: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (scenes.isEmpty()) return

    var currentSceneIndex by remember(chapterId) { mutableIntStateOf(0) }
    var isPlaying by remember(chapterId) { mutableStateOf(false) }
    var sceneProgress by remember(chapterId) { mutableFloatStateOf(0f) }
    var voiceNarrationEnabled by remember(chapterId) { mutableStateOf(true) }
    var ttsReady by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val tts = remember(context) {
        var engine: TextToSpeech? = null
        try {
            engine = TextToSpeech(context.applicationContext) { status ->
                if (status == TextToSpeech.SUCCESS) {
                    val hiLocale = Locale("hi", "IN")
                    val langRes = engine?.setLanguage(hiLocale)
                    if (langRes == TextToSpeech.LANG_MISSING_DATA || langRes == TextToSpeech.LANG_NOT_SUPPORTED) {
                        engine?.setLanguage(Locale.ENGLISH)
                    }
                    ttsReady = true
                }
            }
        } catch (_: Exception) {
            ttsReady = false
        }
        engine
    }

    DisposableEffect(tts) {
        onDispose {
            try {
                tts?.stop()
                tts?.shutdown()
            } catch (_: Exception) {
            }
        }
    }

    val activeScene = scenes.getOrElse(currentSceneIndex) { scenes.first() }
    val totalDurationSeconds = remember(scenes) { scenes.sumOf { it.durationSeconds.coerceAtLeast(5) } }
    val elapsedBeforeScene = remember(scenes, currentSceneIndex) {
        scenes.take(currentSceneIndex).sumOf { it.durationSeconds.coerceAtLeast(5) }
    }
    val currentSceneDuration = activeScene.durationSeconds.coerceAtLeast(5)
    val totalElapsedSeconds = (elapsedBeforeScene + (sceneProgress * currentSceneDuration).toInt())
        .coerceIn(0, totalDurationSeconds)

    // Speak Hindi narration when scene changes while playing
    LaunchedEffect(currentSceneIndex, isPlaying, voiceNarrationEnabled, ttsReady) {
        if (isPlaying && voiceNarrationEnabled && ttsReady) {
            try {
                tts?.speak(activeScene.narrationHi, TextToSpeech.QUEUE_FLUSH, null, "scene_${chapterId}_$currentSceneIndex")
            } catch (_: Exception) {
            }
        } else {
            try {
                tts?.stop()
            } catch (_: Exception) {
            }
        }
    }

    // Frame tick for scene playback timeline
    LaunchedEffect(isPlaying, currentSceneIndex, scenes) {
        if (!isPlaying) return@LaunchedEffect
        val stepMillis = 100L
        val durationMillis = (currentSceneDuration * 1000L).coerceAtLeast(3000L)
        val increment = stepMillis.toFloat() / durationMillis.toFloat()
        while (isPlaying) {
            delay(stepMillis)
            val next = sceneProgress + increment
            if (next >= 1f) {
                if (currentSceneIndex < scenes.lastIndex) {
                    currentSceneIndex += 1
                    sceneProgress = 0f
                } else {
                    sceneProgress = 1f
                    isPlaying = false
                    onVideoCompleted()
                }
            } else {
                sceneProgress = next
            }
        }
    }

    val skyTopTarget = when (activeScene.mood) {
        CartoonMood.HAPPY -> Color(0xFF1E88E5)
        CartoonMood.THOUGHTFUL -> Color(0xFF3949AB)
        CartoonMood.DRAMATIC -> Color(0xFF1A237E)
        CartoonMood.INSPIRING -> Color(0xFF0D47A1)
        CartoonMood.MYSTERY -> Color(0xFF263238)
    }
    val skyBottomTarget = when (activeScene.mood) {
        CartoonMood.HAPPY -> Color(0xFF81D4FA)
        CartoonMood.THOUGHTFUL -> Color(0xFF9FA8DA)
        CartoonMood.DRAMATIC -> Color(0xFF5C6BC0)
        CartoonMood.INSPIRING -> Color(0xFF4FC3F7)
        CartoonMood.MYSTERY -> Color(0xFF455A64)
    }
    val skyTop by animateColorAsState(targetValue = skyTopTarget, animationSpec = tween(700), label = "skyTop")
    val skyBottom by animateColorAsState(targetValue = skyBottomTarget, animationSpec = tween(700), label = "skyBottom")

    val infiniteTransition = rememberInfiniteTransition(label = "cartoonLoop")
    val wavePhase by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = (2 * PI).toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2400, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "wavePhase"
    )
    val bounceFactor by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 900, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "bounce"
    )
    val blinkCycle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 3200, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "blink"
    )

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Main 2D Video Stage Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .testTag("cartoon_video_player_card"),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF0E1B33)),
            border = BorderStroke(1.5.dp, MaterialTheme.colorScheme.secondary.copy(alpha = 0.55f))
        ) {
            Column {
                // Branded Top Video Header Bar
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF102549))
                        .padding(horizontal = 14.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.weight(1f)) {
                        Surface(
                            color = Color(0xFFF59E0B),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Row(
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.spacedBy(4.dp)
                            ) {
                                Icon(Icons.Rounded.Movie, contentDescription = null, tint = Color(0xFF1E293B), modifier = Modifier.size(14.dp))
                                Text(
                                    text = "2D STORY STUDIO",
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color(0xFF1E293B),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Imran Gori Sir • Scene ${activeScene.sceneNumber}/${scenes.size}",
                            style = MaterialTheme.typography.labelMedium,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                    IconButton(
                        onClick = { voiceNarrationEnabled = !voiceNarrationEnabled },
                        modifier = Modifier.size(40.dp).testTag("cartoon_tts_toggle")
                    ) {
                        Icon(
                            imageVector = if (voiceNarrationEnabled) Icons.AutoMirrored.Rounded.VolumeUp else Icons.AutoMirrored.Rounded.VolumeOff,
                            contentDescription = if (voiceNarrationEnabled) "Mute Hindi voice narration" else "Enable Hindi voice narration",
                            tint = if (voiceNarrationEnabled) Color(0xFFFBBF24) else Color.White.copy(alpha = 0.6f)
                        )
                    }
                }

                // 16:9 2D Cartoon Canvas Theatre
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(16f / 9.5f)
                        .clickable {
                            if (sceneProgress >= 1f && currentSceneIndex == scenes.lastIndex) {
                                currentSceneIndex = 0
                                sceneProgress = 0f
                            }
                            isPlaying = !isPlaying
                        }
                ) {
                    Canvas(modifier = Modifier.fillMaxSize()) {
                        drawCartoonStage(
                            setting = activeScene.settingType,
                            mood = activeScene.mood,
                            skyTop = skyTop,
                            skyBottom = skyBottom,
                            wavePhase = wavePhase,
                            bounce = if (isPlaying) bounceFactor else 0.18f,
                            isBlinking = blinkCycle > 0.93f,
                            isSpeaking = isPlaying,
                            hasSecondary = activeScene.secondaryCharacter.isNotBlank()
                        )
                    }

                    // Top-left Action Pill & Scene Title Badge
                    Surface(
                        color = Color(0xAA0B1324),
                        shape = RoundedCornerShape(999.dp),
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(10.dp)
                    ) {
                        Text(
                            text = "${activeScene.actionLabel} • ${activeScene.titleHi}",
                            style = MaterialTheme.typography.labelSmall,
                            color = Color(0xFFFDE68A),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                        )
                    }

                    // Character Name Tags at Bottom of Stage
                    Row(
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth()
                            .padding(horizontal = 14.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Surface(
                            color = Color(0xCC1E3A8A),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Text(
                                text = activeScene.characterName,
                                style = MaterialTheme.typography.labelSmall,
                                color = Color.White,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                            )
                        }
                        if (activeScene.secondaryCharacter.isNotBlank()) {
                            Surface(
                                color = Color(0xCC92400E),
                                shape = RoundedCornerShape(8.dp)
                            ) {
                                Text(
                                    text = activeScene.secondaryCharacter,
                                    style = MaterialTheme.typography.labelSmall,
                                    color = Color.White,
                                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                                )
                            }
                        }
                    }

                    // Center Play Overlay when Paused
                    if (!isPlaying) {
                        Surface(
                            color = Color(0xBB0F172A),
                            shape = CircleShape,
                            border = BorderStroke(2.dp, Color(0xFFFBBF24)),
                            modifier = Modifier
                                .align(Alignment.Center)
                                .size(60.dp)
                        ) {
                            Box(contentAlignment = Alignment.Center) {
                                Icon(
                                    imageVector = if (sceneProgress >= 1f && currentSceneIndex == scenes.lastIndex) Icons.Rounded.Replay else Icons.Rounded.PlayArrow,
                                    contentDescription = "Play 2D animation",
                                    tint = Color(0xFFFBBF24),
                                    modifier = Modifier.size(34.dp)
                                )
                            }
                        }
                    }
                }

                // Live Hindi & English Subtitle Box
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF0A1429))
                        .padding(horizontal = 14.dp, vertical = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = activeScene.narrationHi,
                        style = MaterialTheme.typography.bodyLarge,
                        color = Color(0xFFFEF3C7),
                        fontWeight = FontWeight.Medium
                    )
                    if (bilingualMode) {
                        Text(
                            text = "${activeScene.subtitleEn}  ($chapterTitle)",
                            style = MaterialTheme.typography.bodySmall,
                            color = Color(0xFFCBD5E1)
                        )
                    }
                }

                // Timeline & Controls Bar
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF112244))
                        .padding(horizontal = 14.dp, vertical = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    val overallProgress = ((elapsedBeforeScene + sceneProgress * currentSceneDuration) / totalDurationSeconds.coerceAtLeast(1))
                        .coerceIn(0f, 1f)
                    LinearProgressIndicator(
                        progress = { overallProgress },
                        color = Color(0xFFF59E0B),
                        trackColor = Color.White.copy(alpha = 0.2f),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(6.dp)
                            .clip(RoundedCornerShape(999.dp))
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${formatSeconds(totalElapsedSeconds)} / ${formatSeconds(totalDurationSeconds)}",
                            style = MaterialTheme.typography.labelMedium,
                            fontFamily = JetBrainsMonoFamily,
                            color = Color.White.copy(alpha = 0.85f)
                        )

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(6.dp)
                        ) {
                            IconButton(
                                onClick = {
                                    if (currentSceneIndex > 0) {
                                        currentSceneIndex -= 1
                                        sceneProgress = 0f
                                    } else {
                                        sceneProgress = 0f
                                    }
                                },
                                modifier = Modifier.size(48.dp)
                            ) {
                                Icon(Icons.Rounded.SkipPrevious, contentDescription = "Previous scene", tint = Color.White)
                            }

                            FilledIconButton(
                                onClick = {
                                    if (!isPlaying && sceneProgress >= 1f && currentSceneIndex == scenes.lastIndex) {
                                        currentSceneIndex = 0
                                        sceneProgress = 0f
                                    }
                                    isPlaying = !isPlaying
                                },
                                colors = IconButtonDefaults.filledIconButtonColors(
                                    containerColor = Color(0xFFF59E0B),
                                    contentColor = Color(0xFF0F172A)
                                ),
                                modifier = Modifier
                                    .size(48.dp)
                                    .testTag("cartoon_play_pause_btn")
                            ) {
                                Icon(
                                    imageVector = if (isPlaying) Icons.Rounded.Pause else Icons.Rounded.PlayArrow,
                                    contentDescription = if (isPlaying) "Pause animation" else "Play animation"
                                )
                            }

                            IconButton(
                                onClick = {
                                    if (currentSceneIndex < scenes.lastIndex) {
                                        currentSceneIndex += 1
                                        sceneProgress = 0f
                                    } else {
                                        sceneProgress = 1f
                                        isPlaying = false
                                        onVideoCompleted()
                                    }
                                },
                                modifier = Modifier.size(48.dp)
                            ) {
                                Icon(Icons.Rounded.SkipNext, contentDescription = "Next scene", tint = Color.White)
                            }
                        }

                        IconButton(
                            onClick = {
                                currentSceneIndex = 0
                                sceneProgress = 0f
                                isPlaying = true
                            },
                            modifier = Modifier.size(48.dp)
                        ) {
                            Icon(Icons.Rounded.Replay, contentDescription = "Replay chapter story", tint = Color.White)
                        }
                    }
                }
            }
        }

        // Interactive Scene Strip
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            scenes.forEachIndexed { idx, scene ->
                val isCurrent = idx == currentSceneIndex
                Surface(
                    modifier = Modifier
                        .clickable {
                            currentSceneIndex = idx
                            sceneProgress = 0f
                            isPlaying = true
                        }
                        .testTag("cartoon_scene_chip_${scene.sceneNumber}"),
                    shape = RoundedCornerShape(12.dp),
                    color = if (isCurrent) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surface,
                    border = BorderStroke(
                        width = if (isCurrent) 2.dp else 1.dp,
                        color = if (isCurrent) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant
                    )
                ) {
                    Column(modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp)) {
                        Text(
                            text = "Scene ${scene.sceneNumber}",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = scene.titleHi,
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }
        }

        if (chapterTitleHi.isNotBlank()) {
            StatusBannerCard(
                text = "Imran Gori Sir 2D Story Studio: $chapterTitle ($chapterTitleHi) — हर दृश्य को टैप करके सरल हिंदी में देखें व सुनें।",
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.onSecondaryContainer
            )
        }
    }
}

private fun formatSeconds(sec: Int): String {
    val m = sec / 60
    val s = sec % 60
    return String.format(Locale.US, "%02d:%02d", m, s)
}

private fun DrawScope.drawCartoonStage(
    setting: CartoonSetting,
    mood: CartoonMood,
    skyTop: Color,
    skyBottom: Color,
    wavePhase: Float,
    bounce: Float,
    isBlinking: Boolean,
    isSpeaking: Boolean,
    hasSecondary: Boolean
) {
    val w = size.width
    val h = size.height

    // 1. Animated Sky Gradient Backdrop
    drawRect(
        brush = Brush.verticalGradient(colors = listOf(skyTop, skyBottom)),
        size = size
    )

    // 2. Celestial Sun / Moon & Drifting Clouds
    val sunCenter = Offset(w * 0.84f, h * 0.2f)
    if (mood == CartoonMood.MYSTERY || mood == CartoonMood.DRAMATIC) {
        drawCircle(color = Color(0xFFFEF08A), radius = h * 0.085f, center = sunCenter)
        drawCircle(color = skyTop.copy(alpha = 0.85f), radius = h * 0.07f, center = Offset(sunCenter.x + h * 0.025f, sunCenter.y - h * 0.015f))
    } else {
        drawCircle(color = Color(0x44FDE047), radius = h * 0.14f, center = sunCenter)
        drawCircle(color = Color(0xFFFACC15), radius = h * 0.09f, center = sunCenter)
    }

    val cloudDrift = sin(wavePhase) * w * 0.03f
    drawCloud(Offset(w * 0.22f + cloudDrift, h * 0.19f), h * 0.06f, Color.White.copy(alpha = 0.78f))
    drawCloud(Offset(w * 0.56f - cloudDrift, h * 0.14f), h * 0.05f, Color.White.copy(alpha = 0.65f))

    // 3. Setting-specific Background Art
    val groundTop = h * 0.66f
    when (setting) {
        CartoonSetting.CLASSROOM -> {
            // Classroom Wall & Green Blackboard
            drawRect(color = Color(0xFFF1F5F9).copy(alpha = 0.92f), topLeft = Offset(0f, h * 0.12f), size = Size(w, groundTop - h * 0.12f))
            // Wooden Frame Board
            drawRoundRect(
                color = Color(0xFF78350F),
                topLeft = Offset(w * 0.2f, h * 0.16f),
                size = Size(w * 0.6f, h * 0.36f),
                cornerRadius = CornerRadius(14f, 14f)
            )
            drawRoundRect(
                color = Color(0xFF14532D),
                topLeft = Offset(w * 0.22f, h * 0.185f),
                size = Size(w * 0.56f, h * 0.31f),
                cornerRadius = CornerRadius(10f, 10f)
            )
            // Chalk lines on board
            drawLine(Color.White.copy(alpha = 0.75f), Offset(w * 0.27f, h * 0.26f), Offset(w * 0.58f, h * 0.26f), strokeWidth = 4f, cap = StrokeCap.Round)
            drawLine(Color(0xFFFDE047), Offset(w * 0.27f, h * 0.33f), Offset(w * 0.48f, h * 0.33f), strokeWidth = 3f, cap = StrokeCap.Round)
            drawLine(Color.White.copy(alpha = 0.55f), Offset(w * 0.27f, h * 0.40f), Offset(w * 0.53f, h * 0.40f), strokeWidth = 3f, cap = StrokeCap.Round)
            // Floor
            drawRect(color = Color(0xFFD97706), topLeft = Offset(0f, groundTop), size = Size(w, h - groundTop))
        }
        CartoonSetting.FARM_STORM -> {
            // Rolling hills & farm cottage
            drawCircle(color = Color(0xFF166534), radius = w * 0.45f, center = Offset(w * 0.25f, h * 1.02f))
            drawCircle(color = Color(0xFF15803D), radius = w * 0.45f, center = Offset(w * 0.78f, h * 1.05f))
            // Animated rain streaks in dramatic storm
            if (mood == CartoonMood.DRAMATIC) {
                for (i in 0..10) {
                    val rx = w * (0.08f + i * 0.085f)
                    val ry = ((wavePhase * 40f + i * 35f) % (h * 0.6f))
                    drawLine(Color(0xAA93C5FD), Offset(rx, ry), Offset(rx - 8f, ry + 20f), strokeWidth = 2.5f)
                }
            }
            // Barn House
            drawRect(color = Color(0xFFDC2626), topLeft = Offset(w * 0.43f, h * 0.46f), size = Size(w * 0.14f, h * 0.22f))
            val roof = Path().apply {
                moveTo(w * 0.40f, h * 0.46f)
                lineTo(w * 0.50f, h * 0.35f)
                lineTo(w * 0.60f, h * 0.46f)
                close()
            }
            drawPath(roof, color = Color(0xFF78350F))
        }
        CartoonSetting.OCEAN_SHIP -> {
            // Animated Ocean Waves
            drawRect(color = Color(0xFF0284C7), topLeft = Offset(0f, h * 0.60f), size = Size(w, h * 0.40f))
            for (i in 0..8) {
                val wx = w * (i / 8f)
                val wy = h * 0.61f + sin(wavePhase + i) * h * 0.025f
                drawCircle(color = Color(0xFF38BDF8), radius = w * 0.09f, center = Offset(wx, wy + h * 0.08f))
            }
            // Sailboat in background
            val shipY = h * 0.54f + sin(wavePhase) * 6f
            val hull = Path().apply {
                moveTo(w * 0.42f, shipY)
                lineTo(w * 0.58f, shipY)
                lineTo(w * 0.55f, shipY + h * 0.07f)
                lineTo(w * 0.45f, shipY + h * 0.07f)
                close()
            }
            drawPath(hull, color = Color(0xFF78350F))
            val sail = Path().apply {
                moveTo(w * 0.50f, shipY - h * 0.15f)
                lineTo(w * 0.57f, shipY - 4f)
                lineTo(w * 0.50f, shipY - 4f)
                close()
            }
            drawPath(sail, color = Color.White)
        }
        CartoonSetting.ROYAL_PALACE -> {
            // Palace Domes & Pillars
            drawRect(color = Color(0xFFFEF3C7), topLeft = Offset(w * 0.32f, h * 0.38f), size = Size(w * 0.36f, h * 0.30f))
            drawCircle(color = Color(0xFFD97706), radius = w * 0.08f, center = Offset(w * 0.50f, h * 0.36f))
            drawCircle(color = Color(0xFFF59E0B), radius = w * 0.045f, center = Offset(w * 0.37f, h * 0.38f))
            drawCircle(color = Color(0xFFF59E0B), radius = w * 0.045f, center = Offset(w * 0.63f, h * 0.38f))
            drawRect(color = Color(0xFF78350F), topLeft = Offset(0f, groundTop), size = Size(w, h - groundTop))
        }
        CartoonSetting.CITY_MARKET -> {
            // Town buildings
            drawRect(color = Color(0xFFE2E8F0), topLeft = Offset(w * 0.16f, h * 0.34f), size = Size(w * 0.16f, h * 0.34f))
            drawRect(color = Color(0xFFFDE68A), topLeft = Offset(w * 0.36f, h * 0.28f), size = Size(w * 0.18f, h * 0.40f))
            drawRect(color = Color(0xFFCBD5E1), topLeft = Offset(w * 0.58f, h * 0.36f), size = Size(w * 0.17f, h * 0.32f))
            drawRect(color = Color(0xFF475569), topLeft = Offset(0f, groundTop), size = Size(w, h - groundTop))
        }
        CartoonSetting.MOUNTAIN_LAB -> {
            val m1 = Path().apply {
                moveTo(0f, groundTop)
                lineTo(w * 0.30f, h * 0.28f)
                lineTo(w * 0.62f, groundTop)
                close()
            }
            val m2 = Path().apply {
                moveTo(w * 0.38f, groundTop)
                lineTo(w * 0.72f, h * 0.24f)
                lineTo(w, groundTop)
                close()
            }
            drawPath(m1, color = Color(0xFF334155))
            drawPath(m2, color = Color(0xFF475569))
            drawRect(color = Color(0xFF1E293B), topLeft = Offset(0f, groundTop), size = Size(w, h - groundTop))
        }
        CartoonSetting.HOME_GARDEN -> {
            // Trees & Green Lawn
            drawRect(color = Color(0xFF22C55E), topLeft = Offset(0f, groundTop), size = Size(w, h - groundTop))
            drawRect(color = Color(0xFF78350F), topLeft = Offset(w * 0.48f, h * 0.44f), size = Size(w * 0.04f, h * 0.24f))
            drawCircle(color = Color(0xFF15803D), radius = h * 0.14f, center = Offset(w * 0.50f, h * 0.38f))
            drawCircle(color = Color(0xFF16A34A), radius = h * 0.10f, center = Offset(w * 0.44f, h * 0.42f))
            drawCircle(color = Color(0xFF16A34A), radius = h * 0.10f, center = Offset(w * 0.56f, h * 0.42f))
        }
    }

    // 4. Primary 2D Cartoon Character (Left)
    val char1X = if (hasSecondary) w * 0.27f else w * 0.50f
    val char1Y = h * 0.67f - bounce * h * 0.035f
    drawCartoonCharacter(
        center = Offset(char1X, char1Y),
        scale = h * 0.0023f,
        shirtColor = Color(0xFF1D4ED8),
        skinColor = Color(0xFFFDBA74),
        hairColor = Color(0xFF1E293B),
        waveAngle = if (isSpeaking) sin(wavePhase) * 26f else 8f,
        isBlinking = isBlinking,
        isSpeaking = isSpeaking,
        bounce = bounce,
        facingRight = true
    )

    // Animated Comic Speech Bubble near Main Character
    if (isSpeaking) {
        val bubbleX = char1X + w * 0.11f
        val bubbleY = char1Y - h * 0.32f
        drawRoundRect(
            color = Color.White.copy(alpha = 0.94f),
            topLeft = Offset(bubbleX, bubbleY),
            size = Size(w * 0.13f, h * 0.11f),
            cornerRadius = CornerRadius(18f, 18f)
        )
        // Speaking animated equalizer bars inside bubble
        for (bar in 0..3) {
            val barH = h * (0.025f + 0.035f * ((sin(wavePhase * 2f + bar * 1.1f) + 1f) / 2f))
            drawLine(
                color = Color(0xFF1D4ED8),
                start = Offset(bubbleX + w * (0.025f + bar * 0.025f), bubbleY + h * 0.055f - barH / 2f),
                end = Offset(bubbleX + w * (0.025f + bar * 0.025f), bubbleY + h * 0.055f + barH / 2f),
                strokeWidth = 5f,
                cap = StrokeCap.Round
            )
        }
    }

    // 5. Secondary 2D Cartoon Character (Right)
    if (hasSecondary) {
        val char2X = w * 0.73f
        val char2Y = h * 0.68f - (1f - bounce) * h * 0.025f
        drawCartoonCharacter(
            center = Offset(char2X, char2Y),
            scale = h * 0.00215f,
            shirtColor = Color(0xFFD97706),
            skinColor = Color(0xFFFED7AA),
            hairColor = Color(0xFF451A03),
            waveAngle = if (isSpeaking) -cos(wavePhase) * 18f else -6f,
            isBlinking = isBlinking,
            isSpeaking = false,
            bounce = 1f - bounce,
            facingRight = false
        )
    }
}

private fun DrawScope.drawCloud(center: Offset, radius: Float, color: Color) {
    drawCircle(color = color, radius = radius, center = center)
    drawCircle(color = color, radius = radius * 0.8f, center = Offset(center.x - radius * 0.8f, center.y + radius * 0.18f))
    drawCircle(color = color, radius = radius * 0.8f, center = Offset(center.x + radius * 0.8f, center.y + radius * 0.18f))
}

private fun DrawScope.drawCartoonCharacter(
    center: Offset,
    scale: Float,
    shirtColor: Color,
    skinColor: Color,
    hairColor: Color,
    waveAngle: Float,
    isBlinking: Boolean,
    isSpeaking: Boolean,
    bounce: Float,
    facingRight: Boolean
) {
    val s = scale.coerceAtLeast(0.55f)
    val headRadius = 34f * s
    val bodyW = 54f * s
    val bodyH = 66f * s
    val headCenter = Offset(center.x, center.y - bodyH - headRadius * 0.8f)

    // Shadow on ground
    drawOval(
        color = Color(0x33000000),
        topLeft = Offset(center.x - 36f * s, center.y + 18f * s),
        size = Size(72f * s, 14f * s)
    )

    // Legs
    drawLine(Color(0xFF1E293B), Offset(center.x - 14f * s, center.y - 6f * s), Offset(center.x - 16f * s, center.y + 22f * s), strokeWidth = 12f * s, cap = StrokeCap.Round)
    drawLine(Color(0xFF1E293B), Offset(center.x + 14f * s, center.y - 6f * s), Offset(center.x + 16f * s, center.y + 22f * s), strokeWidth = 12f * s, cap = StrokeCap.Round)

    // Waving Arm
    val armPivot = Offset(center.x + (if (facingRight) bodyW * 0.42f else -bodyW * 0.42f), center.y - bodyH * 0.78f)
    rotate(degrees = waveAngle, pivot = armPivot) {
        drawLine(
            color = skinColor,
            start = armPivot,
            end = Offset(armPivot.x + (if (facingRight) 36f * s else -36f * s), armPivot.y - 24f * s),
            strokeWidth = 11f * s,
            cap = StrokeCap.Round
        )
    }

    // Resting Arm
    val restArmX = center.x + (if (facingRight) -bodyW * 0.44f else bodyW * 0.44f)
    drawLine(
        color = skinColor,
        start = Offset(restArmX, center.y - bodyH * 0.76f),
        end = Offset(restArmX + (if (facingRight) -14f * s else 14f * s), center.y - bodyH * 0.25f),
        strokeWidth = 11f * s,
        cap = StrokeCap.Round
    )

    // Torso / Shirt
    drawRoundRect(
        color = shirtColor,
        topLeft = Offset(center.x - bodyW / 2f, center.y - bodyH),
        size = Size(bodyW, bodyH),
        cornerRadius = CornerRadius(20f * s, 20f * s)
    )
    // Collar detail
    drawLine(Color.White, Offset(center.x - 12f * s, center.y - bodyH), Offset(center.x, center.y - bodyH + 14f * s), strokeWidth = 4f * s)
    drawLine(Color.White, Offset(center.x + 12f * s, center.y - bodyH), Offset(center.x, center.y - bodyH + 14f * s), strokeWidth = 4f * s)

    // Head
    drawCircle(color = skinColor, radius = headRadius, center = headCenter)
    // Hair arc
    drawArc(
        color = hairColor,
        startAngle = 190f,
        sweepAngle = 160f,
        useCenter = true,
        topLeft = Offset(headCenter.x - headRadius * 1.03f, headCenter.y - headRadius * 1.08f),
        size = Size(headRadius * 2.06f, headRadius * 1.55f)
    )

    // Eyes
    val eyeOffsetX = if (facingRight) 10f * s else -10f * s
    val leftEye = Offset(headCenter.x - 10f * s + eyeOffsetX * 0.25f, headCenter.y - 2f * s)
    val rightEye = Offset(headCenter.x + 10f * s + eyeOffsetX * 0.25f, headCenter.y - 2f * s)
    if (isBlinking) {
        drawLine(Color(0xFF1E293B), Offset(leftEye.x - 5f * s, leftEye.y), Offset(leftEye.x + 5f * s, leftEye.y), strokeWidth = 3f * s, cap = StrokeCap.Round)
        drawLine(Color(0xFF1E293B), Offset(rightEye.x - 5f * s, rightEye.y), Offset(rightEye.x + 5f * s, rightEye.y), strokeWidth = 3f * s, cap = StrokeCap.Round)
    } else {
        drawCircle(color = Color.White, radius = 6.5f * s, center = leftEye)
        drawCircle(color = Color.White, radius = 6.5f * s, center = rightEye)
        drawCircle(color = Color(0xFF0F172A), radius = 3.5f * s, center = Offset(leftEye.x + (if (facingRight) 1.5f * s else -1.5f * s), leftEye.y))
        drawCircle(color = Color(0xFF0F172A), radius = 3.5f * s, center = Offset(rightEye.x + (if (facingRight) 1.5f * s else -1.5f * s), rightEye.y))
    }

    // Mouth (animates open/close when speaking)
    val mouthCenter = Offset(headCenter.x + eyeOffsetX * 0.25f, headCenter.y + 15f * s)
    if (isSpeaking) {
        val openH = (5f + 7f * bounce) * s
        drawOval(
            color = Color(0xFF991B1B),
            topLeft = Offset(mouthCenter.x - 9f * s, mouthCenter.y - openH / 2f),
            size = Size(18f * s, openH)
        )
    } else {
        drawArc(
            color = Color(0xFF7C2D12),
            startAngle = 15f,
            sweepAngle = 150f,
            useCenter = false,
            topLeft = Offset(mouthCenter.x - 10f * s, mouthCenter.y - 6f * s),
            size = Size(20f * s, 10f * s),
            style = Stroke(width = 3.5f * s, cap = StrokeCap.Round)
        )
    }
}
