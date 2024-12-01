package com.luanadev.calculadora.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luanadev.calculadora.ui.theme.CalculadoraTheme
import com.luanadev.calculadora.ui.theme.MontserratFont

@Composable
fun CalculatorButton(
    label: String,
    onClick: () -> Unit,
    backgroundColor: Color,
    textColor: Color,
    modifier: Modifier = Modifier // Permite personalização externa do botão
) {
    var isPressed by remember { mutableStateOf(false) }

    // Animação para suavizar a transição de cores ao pressionar o botão
    val animatedColor by animateColorAsState(
        targetValue = if (isPressed) backgroundColor.copy(alpha = 0.7f) else backgroundColor,
        label = "ButtonColorAnimation"
    )

    Button(
        onClick = {
            isPressed = true
            onClick() // Executa a ação do botão
            isPressed = false
        },
        shape = CircleShape, // Botão arredondado
        colors = ButtonDefaults.buttonColors(containerColor = animatedColor),
        modifier = modifier
            .size(80.dp) // Tamanho padrão do botão
            .padding(4.dp) // Espaçamento entre os botões
    ) {
        Text(
            text = label,
            fontSize = 26.sp, // Tamanho da fonte
            fontWeight = FontWeight.Bold, // Negrito para maior impacto
            fontFamily = MontserratFont, // Fonte Montserrat
            color = textColor // Cor do texto
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
            backgroundColor = Color(0xFF24394C), // Azul profundo
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
            backgroundColor = Color(0xFFDAA520), // Dourado
            textColor = Color.Black // Preto
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
