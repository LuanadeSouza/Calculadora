package com.luanadev.calculadora.ui.components

import androidx.compose.foundation.layout.*
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
        listOf("0", ".", "=") // Última linha
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        for ((index, row) in buttons.withIndex()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = if (index == buttons.lastIndex) {
                    Arrangement.End // Alinha a última linha ao lado direito
                } else {
                    Arrangement.SpaceEvenly // Espaçamento uniforme para as outras linhas
                }
            ) {
                for (button in row) {
                    val isOperator = button in listOf("+", "−", "×", "÷", "=")
                    val isAction = button in listOf("C", "±", "%")

                    // Ajusta o botão "0" para ocupar mais espaço horizontal
                    val modifier = if (button == "0" && index == buttons.lastIndex) {
                        Modifier
                            .weight(2f) // Ocupa o dobro do espaço
                            .size(80.dp)
                    } else {
                        Modifier.size(80.dp)
                    }

                    CalculatorButton(
                        label = button,
                        onClick = { onButtonClick(button) },
                        backgroundColor = when {
                            isOperator -> Color(0xFF24394C) // Azul profundo para operadores
                            isAction -> Color(0xFFDAA520) // Dourado para ações
                            else -> Color(0xFFE0E0E0) // Cinza claro para números
                        },
                        textColor = when {
                            isOperator -> Color.White
                            isAction -> Color.Black
                            else -> Color.Black
                        },
                        modifier = modifier.padding(4.dp) // Espaçamento entre os botões
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