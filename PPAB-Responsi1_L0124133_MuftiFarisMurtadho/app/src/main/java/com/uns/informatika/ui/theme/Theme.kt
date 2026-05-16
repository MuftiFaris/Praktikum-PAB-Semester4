package com.uns.informatika.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Primary palette — UNS Blue
val Blue800 = Color(0xFF0D47A1)
val Blue700 = Color(0xFF1565C0)
val Blue600 = Color(0xFF1976D2)
val Blue100 = Color(0xFFBBDEFB)
val Blue50  = Color(0xFFE3F2FD)

// Accent — Amber
val Amber700 = Color(0xFFF57F17)
val Amber500 = Color(0xFFFF8F00)
val Amber50  = Color(0xFFFFF8E1)

// Neutrals
val Gray900 = Color(0xFF212121)
val Gray700 = Color(0xFF616161)
val Gray200 = Color(0xFFEEEEEE)
val Gray50  = Color(0xFFFAFAFA)

// Semantic
val Green600 = Color(0xFF2E7D32)
val Red600   = Color(0xFFC62828)
val Teal600  = Color(0xFF00695C)

private val LightColorScheme = lightColorScheme(
    primary          = Blue700,
    onPrimary        = Color.White,
    primaryContainer = Blue50,
    onPrimaryContainer = Blue800,
    secondary        = Amber700,
    onSecondary      = Color.White,
    secondaryContainer = Amber50,
    onSecondaryContainer = Amber700,
    background       = Gray50,
    onBackground     = Gray900,
    surface          = Color.White,
    onSurface        = Gray900,
    surfaceVariant   = Blue50,
    onSurfaceVariant = Blue800,
    outline          = Color(0xFFBDBDBD),
    error            = Red600,
    onError          = Color.White
)

private val DarkColorScheme = darkColorScheme(
    primary          = Blue100,
    onPrimary        = Blue800,
    primaryContainer = Blue800,
    onPrimaryContainer = Blue100,
    secondary        = Amber500,
    onSecondary      = Gray900,
    background       = Color(0xFF121212),
    onBackground     = Color.White,
    surface          = Color(0xFF1E1E1E),
    onSurface        = Color.White,
    surfaceVariant   = Color(0xFF2C2C2C),
    onSurfaceVariant = Blue100,
    outline          = Color(0xFF424242)
)

@Composable
fun InformaticsAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography  = InformaticsTypography,
        content     = content
    )
}
