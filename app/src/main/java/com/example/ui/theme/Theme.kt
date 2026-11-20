package com.example.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

private val LightColors = lightColorScheme(
    primary = RoyalIndigo,
    onPrimary = Color.White,
    primaryContainer = RoyalIndigoContainer,
    onPrimaryContainer = OnRoyalIndigoContainer,
    secondary = SaffronGold,
    onSecondary = Color.White,
    secondaryContainer = SaffronContainer,
    onSecondaryContainer = OnSaffronContainer,
    tertiary = EmeraldTeal,
    onTertiary = Color.White,
    tertiaryContainer = EmeraldContainer,
    onTertiaryContainer = OnEmeraldContainer,
    background = IvoryBackground,
    onBackground = InkPrimary,
    surface = IvorySurface,
    onSurface = InkPrimary,
    surfaceVariant = IvorySurfaceVariant,
    onSurfaceVariant = InkSecondary,
    outline = HairlineLight,
    outlineVariant = HairlineLight,
    error = CrimsonError,
    onError = Color.White,
    errorContainer = CrimsonContainer,
    onErrorContainer = CrimsonError
)

private val DarkColors = darkColorScheme(
    primary = IndigoBrightDark,
    onPrimary = RoyalIndigoDark,
    primaryContainer = IndigoContainerDark,
    onPrimaryContainer = Color.White,
    secondary = SaffronBrightDark,
    onSecondary = Color(0xFF291800),
    secondaryContainer = SaffronContainerDark,
    onSecondaryContainer = SaffronBrightDark,
    tertiary = TealBrightDark,
    onTertiary = Color(0xFF00201C),
    tertiaryContainer = TealContainerDark,
    onTertiaryContainer = TealBrightDark,
    background = SlateBackgroundDark,
    onBackground = InkLight,
    surface = SlateSurfaceDark,
    onSurface = InkLight,
    surfaceVariant = SlateSurfaceVariantDark,
    onSurfaceVariant = InkSecondaryDark,
    outline = HairlineDark,
    outlineVariant = HairlineDark,
    error = CrimsonErrorDark,
    onError = Color(0xFF450A0A),
    errorContainer = CrimsonContainerDark,
    onErrorContainer = CrimsonErrorDark
)

val AppShapes = Shapes(
    small = RoundedCornerShape(10.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(22.dp),
    extraLarge = RoundedCornerShape(28.dp)
)

@Composable
fun MpEnglishHubTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors
    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}
