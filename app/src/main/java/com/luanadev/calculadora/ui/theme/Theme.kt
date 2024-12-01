package com.luanadev.calculadora.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.luanadev.calculadora.R


// Definição da Paleta de Cores Luxuosas
val BlackLuxury = Color(0xFF121212)
val GoldSophisticated = Color(0xFFDAA520)
val WhiteElegant = Color(0xFFFFFFFF)
val DarkGray = Color(0xFF333333)
val LightGray = Color(0xFFE0E0E0)


private val DarkColorScheme = darkColorScheme(
    primary = GoldSophisticated,
    onPrimary = BlackLuxury,
    background = BlackLuxury,
    surface = DarkGray,
    onBackground = WhiteElegant,
    onSurface = WhiteElegant
)

private val LightColorScheme = lightColorScheme(
    primary = GoldSophisticated,
    onPrimary = WhiteElegant,
    background = WhiteElegant,
    surface = LightGray,
    onBackground = BlackLuxury,
    onSurface = BlackLuxury
)

val LuxuryFont = FontFamily(
    Font(R.font.playfair_display_regular, FontWeight.Normal),
    Font(R.font.playfair_display_bold, FontWeight.Bold)
)

@Composable
fun CalculadoraTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true, content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme, typography = Typography, content = content
    )
}

@Composable
fun LuxuriousTextPreview() {
    CalculadoraTheme {
        Text(
            text = "Calculadora de Luxo",
            color = MaterialTheme.colorScheme.primary,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = LuxuryFont
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLuxuriousText() {
    LuxuriousTextPreview()
}