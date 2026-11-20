package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.FormatQuote
import androidx.compose.material.icons.rounded.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.model.ChapterQuestion

@Composable
fun SubjectiveQuestionCard(
    index: Int,
    question: ChapterQuestion,
    bilingualMode: Boolean,
    isFavourite: Boolean,
    onToggleFavourite: () -> Unit
) {
    var showAnswer by remember(question.id) { mutableStateOf(true) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SourceTagPill(sourceTag = question.sourceTag, bilingualMode = bilingualMode)
                IconButton(
                    onClick = onToggleFavourite,
                    modifier = Modifier.testTag("fav_btn_${question.id}")
                ) {
                    Icon(
                        imageVector = if (isFavourite) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                        contentDescription = if (isFavourite) "Remove favourite question" else "Save favourite question",
                        tint = if (isFavourite) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            if (question.extractText.isNotBlank()) {
                Surface(
                    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.55f),
                    shape = MaterialTheme.shapes.small
                ) {
                    Row(modifier = Modifier.padding(12.dp)) {
                        Icon(
                            imageVector = Icons.Rounded.FormatQuote,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = question.extractText,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }

            if (question.boardReference.isNotBlank()) {
                Text(
                    text = question.boardReference,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Text(
                text = "Q$index. ${question.promptEn}",
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurface
            )
            if (bilingualMode && question.promptHi.isNotBlank()) {
                Text(
                    text = question.promptHi,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            if (showAnswer) {
                Surface(
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    shape = MaterialTheme.shapes.small
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        Text(
                            text = "Answer: ${question.answerEn}",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        if (bilingualMode && question.answerHi.isNotBlank()) {
                            Text(
                                text = "हिंदी भावार्थ: ${question.answerHi}",
                                style = MaterialTheme.typography.bodySmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            }

            OutlinedButton(
                onClick = { showAnswer = !showAnswer },
                modifier = Modifier.height(40.dp)
            ) {
                Icon(Icons.Rounded.Visibility, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text(if (showAnswer) "Hide Answer" else "Show Answer")
            }
        }
    }
}

@Composable
fun InteractiveMcqCard(
    index: Int,
    question: ChapterQuestion,
    bilingualMode: Boolean,
    isFavourite: Boolean,
    onToggleFavourite: () -> Unit
) {
    var selectedOption by remember(question.id) { mutableIntStateOf(-1) }
    val answered = selectedOption >= 0

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SourceTagPill(sourceTag = question.sourceTag, bilingualMode = bilingualMode)
                IconButton(onClick = onToggleFavourite) {
                    Icon(
                        imageVector = if (isFavourite) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                        contentDescription = "Save favourite MCQ",
                        tint = if (isFavourite) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }

            Text(
                text = "Q$index. ${question.promptEn}",
                style = MaterialTheme.typography.titleSmall
            )
            if (bilingualMode && question.promptHi.isNotBlank()) {
                Text(
                    text = question.promptHi,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            val letters = listOf("A", "B", "C", "D")
            question.options.forEachIndexed { idx, opt ->
                val isSelected = selectedOption == idx
                val isCorrectOption = idx == question.correctOptionIndex
                val bgColor = when {
                    !answered -> MaterialTheme.colorScheme.surfaceVariant
                    isCorrectOption -> MaterialTheme.colorScheme.tertiaryContainer
                    isSelected -> MaterialTheme.colorScheme.errorContainer
                    else -> MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f)
                }
                val border = when {
                    !answered -> BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                    isCorrectOption -> BorderStroke(1.5.dp, MaterialTheme.colorScheme.tertiary)
                    isSelected -> BorderStroke(1.5.dp, MaterialTheme.colorScheme.error)
                    else -> BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
                }

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { selectedOption = idx }
                        .testTag("mcq_${question.id}_opt_$idx"),
                    color = bgColor,
                    shape = RoundedCornerShape(12.dp),
                    border = border
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${letters.getOrElse(idx) { "${idx + 1}" }}.",
                            style = MaterialTheme.typography.labelLarge,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = opt,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.weight(1f)
                        )
                        if (answered && isCorrectOption) {
                            Icon(
                                imageVector = Icons.Rounded.CheckCircle,
                                contentDescription = "Correct option",
                                tint = MaterialTheme.colorScheme.tertiary,
                                modifier = Modifier.size(18.dp)
                            )
                        }
                    }
                }
            }

            if (answered && question.explanationHi.isNotBlank()) {
                Surface(
                    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.5f),
                    shape = MaterialTheme.shapes.small
                ) {
                    Text(
                        text = "Explanation: ${question.explanationHi}",
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun InteractiveFillBlankCard(
    index: Int,
    question: ChapterQuestion,
    bilingualMode: Boolean
) {
    var userInput by remember(question.id) { mutableStateOf("") }
    var checked by remember(question.id) { mutableStateOf(false) }
    val isCorrect = userInput.trim().equals(question.answerEn.trim(), ignoreCase = true)

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            SourceTagPill(sourceTag = question.sourceTag, bilingualMode = bilingualMode)
            Text("Q$index. ${question.promptEn}", style = MaterialTheme.typography.titleSmall)
            OutlinedTextField(
                value = userInput,
                onValueChange = {
                    userInput = it
                    checked = false
                },
                label = { Text("Type missing word") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Button(onClick = { checked = true }, modifier = Modifier.height(48.dp)) {
                    Text("Check")
                }
                OutlinedButton(
                    onClick = {
                        userInput = question.answerEn
                        checked = true
                    },
                    modifier = Modifier.height(48.dp)
                ) {
                    Text("Reveal Answer")
                }
            }
            if (checked) {
                Text(
                    text = if (isCorrect) "Correct! Answer: ${question.answerEn}" else "Expected: ${question.answerEn}",
                    style = MaterialTheme.typography.bodyMedium,
                    color = if (isCorrect) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.error,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
fun InteractiveTrueFalseCard(
    index: Int,
    question: ChapterQuestion,
    bilingualMode: Boolean
) {
    var chosen by remember(question.id) { mutableStateOf<String?>(null) }
    val expectedTrue = question.answerEn.equals("True", ignoreCase = true)

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            SourceTagPill(sourceTag = question.sourceTag, bilingualMode = bilingualMode)
            Text("Q$index. ${question.promptEn}", style = MaterialTheme.typography.titleSmall)
            Row(horizontalArrangement = Arrangement.spacedBy(10.dp), modifier = Modifier.fillMaxWidth()) {
                listOf("True", "False").forEach { option ->
                    val isThisChosen = chosen == option
                    val isRight = (option == "True") == expectedTrue
                    OutlinedButton(
                        onClick = { chosen = option },
                        modifier = Modifier
                            .weight(1f)
                            .height(48.dp),
                        border = BorderStroke(
                            width = if (isThisChosen) 2.dp else 1.dp,
                            color = when {
                                chosen == null -> MaterialTheme.colorScheme.outline
                                isRight -> MaterialTheme.colorScheme.tertiary
                                isThisChosen -> MaterialTheme.colorScheme.error
                                else -> MaterialTheme.colorScheme.outlineVariant
                            }
                        )
                    ) {
                        Text(option)
                    }
                }
            }
            if (chosen != null) {
                val correct = (chosen == "True") == expectedTrue
                Text(
                    text = if (correct) "Correct! (${question.answerEn})" else "Incorrect — Correct answer is ${question.answerEn}",
                    style = MaterialTheme.typography.bodySmall,
                    color = if (correct) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.error,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}

@Composable
fun InteractiveMatchCard(
    question: ChapterQuestion,
    bilingualMode: Boolean
) {
    val pairs = question.matchPairs
    val shuffledRight = remember(question.id) { pairs.map { it.right }.shuffled() }
    var selectedLeftIdx by remember(question.id) { mutableIntStateOf(0) }
    var matchedMap by remember(question.id) { mutableStateOf<Map<String, String>>(emptyMap()) }
    var showAnswerKey by remember(question.id) { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            SourceTagPill(sourceTag = question.sourceTag, bilingualMode = bilingualMode)
            Text(question.promptEn, style = MaterialTheme.typography.titleSmall)
            Text(
                text = "Tap a left item, then tap its matching right pair.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            pairs.forEachIndexed { idx, pair ->
                val isSelectedLeft = selectedLeftIdx == idx
                val matchedRight = matchedMap[pair.left]
                val isMatchedCorrect = matchedRight == pair.right
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { selectedLeftIdx = idx },
                    shape = RoundedCornerShape(10.dp),
                    color = when {
                        matchedRight != null && isMatchedCorrect -> MaterialTheme.colorScheme.tertiaryContainer
                        matchedRight != null -> MaterialTheme.colorScheme.errorContainer
                        isSelectedLeft -> MaterialTheme.colorScheme.primaryContainer
                        else -> MaterialTheme.colorScheme.surfaceVariant
                    }
                ) {
                    Row(
                        modifier = Modifier.padding(12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "${idx + 1}. ${pair.left}",
                            style = MaterialTheme.typography.bodyMedium,
                            fontWeight = FontWeight.SemiBold,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = matchedRight ?: "Tap answer below",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }

            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                Text("Choices:", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
                shuffledRight.forEach { rightText ->
                    OutlinedButton(
                        onClick = {
                            val activeLeft = pairs.getOrNull(selectedLeftIdx)?.left ?: return@OutlinedButton
                            matchedMap = matchedMap + (activeLeft to rightText)
                            if (selectedLeftIdx + 1 < pairs.size) {
                                selectedLeftIdx += 1
                            }
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(rightText, modifier = Modifier.fillMaxWidth())
                    }
                }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedButton(onClick = { showAnswerKey = !showAnswerKey }) {
                    Text(if (showAnswerKey) "Hide Key" else "Show Answer Key")
                }
                OutlinedButton(onClick = {
                    matchedMap = emptyMap()
                    selectedLeftIdx = 0
                }) {
                    Text("Reset")
                }
            }

            if (showAnswerKey) {
                Surface(
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    shape = MaterialTheme.shapes.small
                ) {
                    Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        pairs.forEach { p ->
                            Text("• ${p.left}  →  ${p.right}", style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
        }
    }
}
