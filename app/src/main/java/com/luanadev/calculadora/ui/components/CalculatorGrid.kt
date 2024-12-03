package com.luanadev.calculadora.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.luanadev.calculadora.ui.theme.CalculadoraTheme
import com.luanadev.calculadora.ui.theme.LightBackground
import com.luanadev.calculadora.ui.theme.PrimaryColor
import com.luanadev.calculadora.ui.theme.SecondaryColor
import com.luanadev.calculadora.ui.theme.Spacing_8
import com.luanadev.calculadora.ui.theme.Spacing_80
import com.luanadev.calculadora.ui.theme.TextPrimary

@Composable
fun CalculatorGrid(onButtonClick: (String) -> Unit) {
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
            .padding(horizontal = Spacing_8),
        verticalArrangement = Arrangement.spacedBy(Spacing_8)
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
                            isOperator -> PrimaryColor
                            isAction -> SecondaryColor
                            else -> LightBackground
                        },
                        textColor = when {
                            isOperator -> TextPrimary
                            isAction -> TextPrimary
                            else -> Color.Black
                        },
                        modifier = Modifier
                            .size(Spacing_80)
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