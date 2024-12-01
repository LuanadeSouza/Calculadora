package com.luanadev.calculadora.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luanadev.calculadora.ui.theme.CalculadoraTheme

@Composable
fun CalculatorGrid(onButtonClick: (String) -> Unit) {
    val buttons = listOf(
        listOf("C", "±", "%", "÷"),
        listOf("7", "8", "9", "×"),
        listOf("4", "5", "6", "−"),
        listOf("1", "2", "3", "+"),
        listOf("0", ".", "=")
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp), // Margem horizontal para o grid
        verticalArrangement = Arrangement.spacedBy(8.dp) // Espaçamento entre as linhas
    ) {
        for (row in buttons) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp) // Espaçamento entre os botões
            ) {
                for (button in row) {
                    val isOperator = button in listOf("+", "−", "×", "÷", "=")
                    val isAction = button in listOf("C", "±", "%")

                    CalculatorButton(
                        label = button,
                        onClick = { onButtonClick(button) },
                        backgroundColor = when {
                            isOperator -> Color(0xFFDAA520) // Dourado para operações
                            isAction -> Color(0xFF333333) // Cinza escuro para ações
                            else -> Color(0xFFE0E0E0) // Cinza claro para números
                        },
                        textColor = when {
                            isOperator -> Color.White
                            isAction -> Color.White
                            else -> Color.Black
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    CalculadoraTheme {
        CalculatorGrid(
            onButtonClick = {}
        )
    }
}