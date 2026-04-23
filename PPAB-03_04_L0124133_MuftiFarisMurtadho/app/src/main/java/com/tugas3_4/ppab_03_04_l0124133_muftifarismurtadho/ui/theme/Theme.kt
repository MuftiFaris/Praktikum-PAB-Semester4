package com.tugas3_4.ppab_03_04_l0124133_muftifarismurtadho.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Custom Modern Theme Colors
val CustomPrimary = Color(0xFF3F51B5) // Indigo
val CustomSecondary = Color(0xFF009688) // Teal
val CustomBackground = Color(0xFFF8F9FA)
val CustomSurface = Color(0xFFFFFFFF)
val CustomOnSurface = Color(0xFF1C1B1F)
val CustomOnSurfaceVariant = Color(0xFF49454F)
val CustomOutline = Color(0xFFCAC4D0)

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
