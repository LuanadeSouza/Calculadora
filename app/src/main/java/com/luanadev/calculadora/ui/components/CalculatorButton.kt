package com.luanadev.calculadora.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    textColor: Color
) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor),
        modifier = Modifier
            .size(80.dp) // Botão maior para melhor usabilidade
            .padding(4.dp) // Espaçamento entre os botões
    ) {
        Text(
            text = label,
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = MontserratFont,
            color = textColor
        )
    }
}

@Preview(showBackground = true, name = "Calculator Button Preview")
@Composable
fun PreviewCalculatorButton() {
    // Aplicando o tema da calculadora
    CalculadoraTheme {
        // Exemplo de botão de número
        CalculatorButton(
            label = "5",
            onClick = {},
            backgroundColor = Color(0xFFE0E0E0), // Cinza claro
            textColor = Color.Black
        )
    }
}

@Preview(showBackground = true, name = "Opção 1 - Dourado Elegante")
@Composable
fun PreviewButtonOption1() {
    CalculadoraTheme {
        CalculatorButton(
            label = "5",
            onClick = {},
            backgroundColor = Color(0xFFDAA520), // Dourado
            textColor = Color.White // Texto branco
        )
    }
}

@Preview(showBackground = true, name = "Opção 2 - Preto com Dourado")
@Composable
fun PreviewButtonOption2() {
    CalculadoraTheme {
        CalculatorButton(
            label = "+",
            onClick = {},
            backgroundColor = Color(0xFF121212), // Preto
            textColor = Color(0xFFDAA520) // Dourado
        )
    }
}

@Preview(showBackground = true, name = "Opção 3 - Cinza Minimalista")
@Composable
fun PreviewButtonOption3() {
    CalculadoraTheme {
        CalculatorButton(
            label = "0",
            onClick = {},
            backgroundColor = Color(0xFFE0E0E0), // Cinza claro
            textColor = Color.Black // Preto
        )
    }
}

@Preview(showBackground = true, name = "Opção 4 - Azul Moderno")
@Composable
fun PreviewButtonOption4() {
    CalculadoraTheme {
        CalculatorButton(
            label = "=",
            onClick = {},
            backgroundColor = Color(0xFF1E88E5), // Azul
            textColor = Color.White // Branco
        )
    }
}

@Preview(showBackground = true, name = "Opção 5 - Vermelho Sofisticado")
@Composable
fun PreviewButtonOption5() {
    CalculadoraTheme {
        CalculatorButton(
            label = "C",
            onClick = {},
            backgroundColor = Color(0xFFD32F2F), // Vermelho
            textColor = Color.White // Branco
        )
    }
}


