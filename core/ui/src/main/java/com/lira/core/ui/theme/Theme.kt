package com.lira.core.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalLiraColors = staticCompositionLocalOf { EmeraldColors }

@Composable
fun LiraTheme(
    paletteType: LiraPaletteType = LiraPaletteType.EMERALD,
    content: @Composable () -> Unit
) {
    val liraColors = when (paletteType) {
        LiraPaletteType.EMERALD -> EmeraldColors
        LiraPaletteType.AMETHYST -> AmethystColors
        LiraPaletteType.COBALT -> CobaltColors
        LiraPaletteType.AMBER -> AmberColors
        LiraPaletteType.RUBY -> RubyColors
        LiraPaletteType.TITAN -> TitanColors
        LiraPaletteType.IOS_GLASS -> IosGlassColors
        LiraPaletteType.PORCELAIN -> PorcelainColors
    }

    val materialColorScheme = if (liraColors.isLight) {
        lightColorScheme(
            primary = liraColors.primary,
            secondary = liraColors.secondary,
            background = liraColors.background,
            surface = liraColors.surface
        )
    } else {
        darkColorScheme(
            primary = liraColors.primary,
            secondary = liraColors.secondary,
            background = liraColors.background,
            surface = liraColors.surface
        )
    }

    CompositionLocalProvider(LocalLiraColors provides liraColors) {
        MaterialTheme(
            colorScheme = materialColorScheme,
            content = content
        )
    }
}

object LiraThemeConfig {
    val colors: LiraColors
        @Composable
        get() = LocalLiraColors.current
}
