package com.luanadev.calculadora.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luanadev.calculadora.ui.theme.CalculadoraTheme
import com.luanadev.calculadora.ui.theme.DarkBackground
import com.luanadev.calculadora.ui.theme.LightBackground
import com.luanadev.calculadora.ui.theme.PrimaryColor
import com.luanadev.calculadora.ui.theme.SecondaryColor
import com.luanadev.calculadora.ui.theme.TextPrimary

@Composable
fun CalculatorGrid(onButtonClick: (String) -> Unit) {
    val buttons = listOf(
        listOf("C", "±", "%", "÷"),
        listOf("7", "8", "9", "×"),
        listOf("4", "5", "6", "−"),
        listOf("1", "2", "3", "+"),
        listOf("0", ".", "=", "√") // Última linha com "0", ".", "=", e "√"
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
                horizontalArrangement = Arrangement.SpaceEvenly // Espaçamento uniforme
            ) {
                for (button in row) {
                    val isOperator = button in listOf("+", "−", "×", "÷", "=", "√")
                    val isAction = button in listOf("C", "±", "%")

                    CalculatorButton(
                        label = button,
                        onClick = { onButtonClick(button) },
                        backgroundColor = when {
                            isOperator -> PrimaryColor // Azul Escuro
                            isAction -> SecondaryColor // Verde Esmeralda
                            else -> LightBackground // Cinza Claro
                        },
                        textColor = when {
                            isOperator -> TextPrimary // Branco
                            isAction -> TextPrimary // Branco
                            else -> DarkBackground // Azul Acinzentado
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