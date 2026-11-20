package com.example.ui.components

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.util.Base64
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material.icons.rounded.Verified
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.data.model.QuestionSourceTag
import com.example.ui.theme.RoyalIndigo
import com.example.ui.theme.SaffronGoldLight
import java.io.ByteArrayOutputStream

@Composable
fun SourceTagPill(
    sourceTag: QuestionSourceTag,
    bilingualMode: Boolean,
    modifier: Modifier = Modifier
) {
    val (containerColor, contentColor, icon) = when (sourceTag) {
        QuestionSourceTag.NCERT,
        QuestionSourceTag.MP_BOARD_VERIFIED -> Triple(
            MaterialTheme.colorScheme.tertiaryContainer,
            MaterialTheme.colorScheme.onTertiaryContainer,
            Icons.Rounded.Verified
        )
        QuestionSourceTag.AI_GENERATED -> Triple(
            MaterialTheme.colorScheme.secondaryContainer,
            MaterialTheme.colorScheme.onSecondaryContainer,
            Icons.Rounded.AutoAwesome
        )
        QuestionSourceTag.PRACTICE,
        QuestionSourceTag.ADMIN_ADDED -> Triple(
            MaterialTheme.colorScheme.primaryContainer,
            MaterialTheme.colorScheme.onPrimaryContainer,
            Icons.Rounded.Verified
        )
    }

    Surface(
        modifier = modifier,
        color = containerColor,
        contentColor = contentColor,
        shape = RoundedCornerShape(999.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                modifier = Modifier.size(13.dp)
            )
            Text(
                text = if (bilingualMode) "${sourceTag.badgeText} • ${sourceTag.badgeHi}" else sourceTag.badgeText,
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

@Composable
fun SectionHeading(
    titleEn: String,
    titleHi: String? = null,
    bilingualMode: Boolean = true,
    modifier: Modifier = Modifier,
    trailing: (@Composable () -> Unit)? = null
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = titleEn,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onBackground
            )
            if (bilingualMode && !titleHi.isNullOrBlank()) {
                Text(
                    text = titleHi,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
        if (trailing != null) {
            Spacer(modifier = Modifier.width(8.dp))
            trailing()
        }
    }
}

@Composable
fun EmptyStateCard(
    icon: ImageVector,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(36.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

@Composable
fun StatusBannerCard(
    text: String,
    containerColor: Color,
    contentColor: Color,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        color = containerColor,
        contentColor = contentColor,
        shape = MaterialTheme.shapes.medium
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 10.dp)
        )
    }
}

fun decodeTeacherPhotoBitmap(base64: String): ImageBitmap? {
    if (base64.isBlank()) return null
    return try {
        val bytes = Base64.decode(base64, Base64.DEFAULT)
        BitmapFactory.decodeByteArray(bytes, 0, bytes.size)?.asImageBitmap()
    } catch (_: Exception) {
        null
    }
}

fun encodePickedTeacherPhoto(context: Context, uri: Uri): Pair<String, String?> {
    return try {
        val rawBitmap: Bitmap = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val source = ImageDecoder.createSource(context.contentResolver, uri)
            ImageDecoder.decodeBitmap(source) { decoder, _, _ ->
                decoder.isMutableRequired = false
            }
        } else {
            context.contentResolver.openInputStream(uri)?.use { stream ->
                BitmapFactory.decodeStream(stream)
            } ?: return "" to "Unable to open the selected image."
        }

        val maxDim = 512
        val w = rawBitmap.width.coerceAtLeast(1)
        val h = rawBitmap.height.coerceAtLeast(1)
        val scale = minOf(maxDim.toFloat() / w, maxDim.toFloat() / h, 1f)
        val targetW = (w * scale).toInt().coerceAtLeast(1)
        val targetH = (h * scale).toInt().coerceAtLeast(1)
        val scaled = if (scale < 1f) {
            Bitmap.createScaledBitmap(rawBitmap, targetW, targetH, true)
        } else {
            rawBitmap
        }

        val out = ByteArrayOutputStream()
        scaled.compress(Bitmap.CompressFormat.JPEG, 86, out)
        val bytes = out.toByteArray()
        if (bytes.size > 300 * 1024) {
            out.reset()
            scaled.compress(Bitmap.CompressFormat.JPEG, 68, out)
        }
        val b64 = Base64.encodeToString(out.toByteArray(), Base64.NO_WRAP)
        if (b64.length > 440_000) {
            "" to "Selected photo is too large even after compression. Please pick a smaller image."
        } else {
            b64 to null
        }
    } catch (e: Exception) {
        "" to (e.localizedMessage ?: "Failed to process the selected photo.")
    }
}

@Composable
fun TeacherCircularAvatar(
    customPhotoBase64: String = "",
    size: Dp = 64.dp,
    borderColor: Color = SaffronGoldLight,
    borderWidth: Dp = 2.5.dp,
    showVerifiedBadge: Boolean = false,
    contentDescription: String = "Imran Gori Sir official teacher profile photo",
    modifier: Modifier = Modifier
) {
    val customBitmap = remember(customPhotoBase64) { decodeTeacherPhotoBitmap(customPhotoBase64) }
    val faceCenteredAlignment = remember { BiasAlignment(horizontalBias = 0f, verticalBias = -0.58f) }

    Box(
        modifier = modifier.size(size),
        contentAlignment = Alignment.Center
    ) {
        Surface(
            modifier = Modifier.size(size),
            shape = CircleShape,
            border = BorderStroke(borderWidth, borderColor),
            color = Color.White,
            shadowElevation = 4.dp
        ) {
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.surfaceVariant),
                contentAlignment = Alignment.Center
            ) {
                if (customBitmap != null) {
                    Image(
                        bitmap = customBitmap,
                        contentDescription = contentDescription,
                        modifier = Modifier
                            .size(size)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center
                    )
                } else {
                    Image(
                        painter = painterResource(id = R.drawable.img_imran_sir_avatar),
                        contentDescription = contentDescription,
                        modifier = Modifier
                            .size(size)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop,
                        alignment = faceCenteredAlignment
                    )
                }
            }
        }

        if (showVerifiedBadge) {
            Surface(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size((size.value * 0.30f).coerceIn(18f, 30f).dp),
                shape = CircleShape,
                color = RoyalIndigo,
                border = BorderStroke(1.5.dp, Color.White),
                shadowElevation = 2.dp
            ) {
                Box(contentAlignment = Alignment.Center) {
                    Icon(
                        imageVector = Icons.Rounded.Verified,
                        contentDescription = "Verified Educator Imran Gori Sir",
                        tint = SaffronGoldLight,
                        modifier = Modifier.size((size.value * 0.19f).coerceIn(11f, 19f).dp)
                    )
                }
            }
        }
    }
}

@Composable
fun TeacherBrandIdentityBlock(
    titleColor: Color = Color.White,
    subtitleColor: Color = SaffronGoldLight,
    showTagline: Boolean = false,
    taglineColor: Color = Color.White.copy(alpha = 0.85f),
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = "IMRAN GORI SIR",
            style = MaterialTheme.typography.labelLarge,
            color = subtitleColor,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "MP BOARD ENGLISH HUB",
            style = MaterialTheme.typography.titleLarge,
            color = titleColor,
            fontWeight = FontWeight.Bold
        )
        if (showTagline) {
            Text(
                text = "Learn English Smartly – Score Higher!",
                style = MaterialTheme.typography.labelMedium,
                color = taglineColor
            )
        }
    }
}
