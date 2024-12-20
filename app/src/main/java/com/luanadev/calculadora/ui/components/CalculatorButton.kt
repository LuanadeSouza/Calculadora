package com.luanadev.calculadora.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.luanadev.calculadora.ui.theme.CalculadoraTheme
import com.luanadev.calculadora.ui.theme.MontserratFont
import com.luanadev.calculadora.ui.theme.PrimaryColor
import com.luanadev.calculadora.ui.theme.SecondaryColor
import com.luanadev.calculadora.ui.theme.Size_26
import com.luanadev.calculadora.ui.theme.Spacing_80
import com.luanadev.calculadora.ui.theme.TextPrimary

@Composable
fun CalculatorButton(
    label: String,
    onClick: () -> Unit,
    backgroundColor: Color,
    textColor: Color,
    modifier: Modifier = Modifier
) {
    var isPressed by remember { mutableStateOf(false) }
    val animatedColor by animateColorAsState(
        targetValue = if (isPressed) backgroundColor.copy(alpha = 0.7f) else backgroundColor,
        label = "ButtonColorAnimation"
    )
    val haptic = LocalHapticFeedback.current

    Button(
        onClick = {
            haptic.performHapticFeedback(HapticFeedbackType.TextHandleMove) // Feedback tátil
            isPressed = true
            onClick()
            isPressed = false
        },
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = animatedColor),
        modifier = modifier
            .size(Spacing_80)
            .semantics {
                contentDescription = when (label) {
                    "+" -> "Botão de soma"
                    "-" -> "Botão de subtração"
                    "*" -> "Botão de multiplicação"
                    "/" -> "Botão de divisão"
                    "=" -> "Botão de igual"
                    else -> "Botão $label"
                }
            }
    ) {
        Text(
            text = label,
            fontSize = Size_26,
            fontWeight = FontWeight.Bold,
            fontFamily = MontserratFont,
            color = textColor
        )
    }
}

@Preview(showBackground = true, name = "Calculator Button Preview")
@Composable
fun PreviewCalculatorButton() {
    CalculadoraTheme {
        CalculatorButton(
            label = "+",
            onClick = {},
            backgroundColor = PrimaryColor,
            textColor = TextPrimary
        )
    }
}


@Preview(showBackground = true, name = "Calculator Button Preview - Azul")
@Composable
fun PreviewCalculatorButtonBlue() {
    CalculadoraTheme {
        CalculatorButton(
            label = "+",
            onClick = {},
            backgroundColor = PrimaryColor, // Azul profundo
            textColor = Color.White // Branco
        )
    }
}

@Preview(showBackground = true, name = "Calculator Button Preview - Dourado")
@Composable
fun PreviewCalculatorButtonGold() {
    CalculadoraTheme {
        CalculatorButton(
            label = "C",
            onClick = {},
            backgroundColor = SecondaryColor, // Novo dourado metálico
            textColor = TextPrimary   // Branco
        )
    }
}

@Preview(showBackground = true, name = "Calculator Button Preview - Cinza")
@Composable
fun PreviewCalculatorButtonGray() {
    CalculadoraTheme {
        CalculatorButton(
            label = "5",
            onClick = {},
            backgroundColor = Color(0xFFE0E0E0), // Cinza claro
            textColor = Color.Black // Preto
        )
    }
}