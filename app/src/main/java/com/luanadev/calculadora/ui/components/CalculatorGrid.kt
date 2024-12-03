package com.luanadev.calculadora.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luanadev.calculadora.ui.theme.CalculadoraTheme
import com.luanadev.calculadora.ui.theme.LightBackground
import com.luanadev.calculadora.ui.theme.PrimaryColor
import com.luanadev.calculadora.ui.theme.SecondaryColor
import com.luanadev.calculadora.ui.theme.TextPrimary

@Composable
fun CalculatorGrid(onButtonClick: (String) -> Unit) {
    // Configuração dos botões
    val buttons = listOf(
        listOf("C", "±", "%", "÷"),
        listOf("7", "8", "9", "×"),
        listOf("4", "5", "6", "−"),
        listOf("1", "2", "3", "+"),
        listOf("0", ".", "=", "√")
    )

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        for (row in buttons) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (button in row) {
                    val isOperator = button in listOf("+", "−", "×", "÷", "=", "√")
                    val isAction = button in listOf("C", "±", "%")

                    CalculatorButton(
                        label = button,
                        onClick = { onButtonClick(button) },
                        backgroundColor = when {
                            isOperator -> PrimaryColor // Azul Escuro para operadores
                            isAction -> SecondaryColor // Verde Esmeralda para ações
                            else -> LightBackground // Cinza Claro para números
                        },
                        textColor = when {
                            isOperator -> TextPrimary // Branco
                            isAction -> TextPrimary // Branco
                            else -> Color.Black //
                        },
                        modifier = Modifier
                            .size(80.dp)
                            .semantics { contentDescription = "Botão $button" }
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