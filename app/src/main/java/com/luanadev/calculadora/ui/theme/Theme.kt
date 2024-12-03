package com.luanadev.calculadora.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CalculadoraTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) {
        darkColorScheme(
            primary = PrimaryColor,
            onPrimary = TextPrimary,
            background = DarkBackground,
            surface = DarkBackground,
            onBackground = TextPrimary,
            onSurface = TextSecondary
        )
    } else {
        lightColorScheme(
            primary = PrimaryColor,
            onPrimary = TextPrimary,
            background = LightBackground,
            surface = LightBackground,
            onBackground = DarkBackground,
            onSurface = TextPrimary
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

@Composable
fun LuxuriousTextPreview() {
    CalculadoraTheme {
        Text(
            text = "Calculadora de Luxo",
            color = MaterialTheme.colorScheme.primary,
            fontSize = Size_24,
            fontWeight = FontWeight.Bold,
            fontFamily = MontserratFont
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLuxuriousText() {
    LuxuriousTextPreview()
}