package com.lira.core.ui.theme

import androidx.compose.ui.graphics.Color

enum class LiraPaletteType {
    EMERALD, AMETHYST, COBALT, AMBER, RUBY, TITAN, IOS_GLASS, PORCELAIN
}

data class LiraColors(
    val primary: Color,
    val secondary: Color,
    val background: Color,
    val surface: Color,
    val cardBg: Color,
    val accentGlow: Color,
    val bubbleUser: Color,
    val bubbleAssistant: Color,
    val bubbleAssistantText: Color,
    val error: Color,
    val success: Color,
    val isLight: Boolean
)

val EmeraldColors = LiraColors(
    primary = Color(0xFF00FF66), secondary = Color(0xFF00CC52),
    background = Color(0xFF000000), surface = Color(0xFF121212), cardBg = Color(0xFF1A1A1A),
    accentGlow = Color(0x3300FF66), bubbleUser = Color(0xFF00FF66), bubbleAssistant = Color(0xFF1A1A1A),
    bubbleAssistantText = Color(0xFFE0E0E0), error = Color(0xFFFF3355), success = Color(0xFF00FF66), isLight = false
)

val AmethystColors = LiraColors(
    primary = Color(0xFFB366FF), secondary = Color(0xFF9933FF),
    background = Color(0xFF000000), surface = Color(0xFF121212), cardBg = Color(0xFF1A1A1A),
    accentGlow = Color(0x33B366FF), bubbleUser = Color(0xFFB366FF), bubbleAssistant = Color(0xFF1A1A1A),
    bubbleAssistantText = Color(0xFFE0E0E0), error = Color(0xFFFF3355), success = Color(0xFF00FF66), isLight = false
)

val CobaltColors = LiraColors(
    primary = Color(0xFF3399FF), secondary = Color(0xFF0066CC),
    background = Color(0xFF000000), surface = Color(0xFF121212), cardBg = Color(0xFF1A1A1A),
    accentGlow = Color(0x333399FF), bubbleUser = Color(0xFF3399FF), bubbleAssistant = Color(0xFF1A1A1A),
    bubbleAssistantText = Color(0xFFE0E0E0), error = Color(0xFFFF3355), success = Color(0xFF00FF66), isLight = false
)

val AmberColors = LiraColors(
    primary = Color(0xFFFFB300), secondary = Color(0xFFFF8F00),
    background = Color(0xFF000000), surface = Color(0xFF121212), cardBg = Color(0xFF1A1A1A),
    accentGlow = Color(0x33FFB300), bubbleUser = Color(0xFFFFB300), bubbleAssistant = Color(0xFF1A1A1A),
    bubbleAssistantText = Color(0xFFE0E0E0), error = Color(0xFFFF3355), success = Color(0xFF00FF66), isLight = false
)

val RubyColors = LiraColors(
    primary = Color(0xFFFF3355), secondary = Color(0xFFCC0022),
    background = Color(0xFF000000), surface = Color(0xFF121212), cardBg = Color(0xFF1A1A1A),
    accentGlow = Color(0x33FF3355), bubbleUser = Color(0xFFFF3355), bubbleAssistant = Color(0xFF1A1A1A),
    bubbleAssistantText = Color(0xFFE0E0E0), error = Color(0xFFFF3355), success = Color(0xFF00FF66), isLight = false
)

val TitanColors = LiraColors(
    primary = Color(0xFFE0E0E0), secondary = Color(0xFFA0A0A0),
    background = Color(0xFF000000), surface = Color(0xFF121212), cardBg = Color(0xFF1A1A1A),
    accentGlow = Color(0x33E0E0E0), bubbleUser = Color(0xFFE0E0E0), bubbleAssistant = Color(0xFF1A1A1A),
    bubbleAssistantText = Color(0xFFE0E0E0), error = Color(0xFFFF3355), success = Color(0xFF00FF66), isLight = false
)

val IosGlassColors = LiraColors(
    primary = Color(0xFF007AFF), secondary = Color(0xFF5856D6),
    background = Color(0xFFF2F2F7), surface = Color(0xFFFFFFFF), cardBg = Color(0xFFFFFFFF),
    accentGlow = Color(0x22007AFF), bubbleUser = Color(0xFF007AFF), bubbleAssistant = Color(0xFFE5E5EA),
    bubbleAssistantText = Color(0xFF000000), error = Color(0xFFFF3B30), success = Color(0xFF34C759), isLight = true
)

val PorcelainColors = LiraColors(
    primary = Color(0xFF2C2C2E), secondary = Color(0xFF3A3A3C),
    background = Color(0xFFFAFAFA), surface = Color(0xFFFFFFFF), cardBg = Color(0xFFFFFFFF),
    accentGlow = Color(0x222C2C2E), bubbleUser = Color(0xFF2C2C2E), bubbleAssistant = Color(0xFFEFEFF4),
    bubbleAssistantText = Color(0xFF000000), error = Color(0xFFFF3B30), success = Color(0xFF34C759), isLight = true
)
