package com.tugas3.ppab_03_l0124133_muftifarismurtadho.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val PlayGreen = Color(0xFF01875F)
val PlayGreenLight = Color(0xFF4DB987)
val PlayGreenContainer = Color(0xFFD6F5E8)
val PlayBackground = Color(0xFFFFFFFF)
val PlaySurface = Color(0xFFF8F9FA)
val PlaySurfaceVariant = Color(0xFFF1F3F4)
val PlayOnSurface = Color(0xFF202124)
val PlayOnSurfaceVariant = Color(0xFF5F6368)
val PlayOutline = Color(0xFFDADCE0)

private val PlayStoreColorScheme = lightColorScheme(
    primary = PlayGreen,
    onPrimary = Color.White,
    primaryContainer = PlayGreenContainer,
    onPrimaryContainer = Color(0xFF002114),
    secondary = PlayGreenLight,
    onSecondary = Color.White,
    background = PlayBackground,
    surface = PlaySurface,
    onBackground = PlayOnSurface,
    onSurface = PlayOnSurface,
    onSurfaceVariant = PlayOnSurfaceVariant,
    outline = PlayOutline,
    surfaceVariant = PlaySurfaceVariant,
)

@Composable
fun PlayStoreDemoTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = PlayStoreColorScheme,
        content = content
    )
}
