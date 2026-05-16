package com.tugas5.ppab_05_l0124133_muftifarismurtadho.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val CustomColorScheme = lightColorScheme(
    primary = CustomPrimary,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFE8EAF6),
    onPrimaryContainer = CustomPrimary,
    secondary = CustomSecondary,
    onSecondary = Color.White,
    background = CustomBackground,
    surface = CustomSurface,
    onBackground = CustomOnSurface,
    onSurface = CustomOnSurface,
    onSurfaceVariant = CustomOnSurfaceVariant,
    outline = CustomOutline,
)

@Composable
fun PlayStoreDemoTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = CustomColorScheme,
        typography = Typography,
        content = content
    )
}
