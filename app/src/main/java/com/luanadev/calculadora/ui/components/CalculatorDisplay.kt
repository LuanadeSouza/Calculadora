package com.luanadev.calculadora.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.luanadev.calculadora.ui.theme.CalculadoraTheme
import com.luanadev.calculadora.ui.theme.Size_48
import com.luanadev.calculadora.ui.theme.Spacing_120
import com.luanadev.calculadora.ui.theme.Spacing_16

@Composable
fun CalculatorDisplay(displayText: String) {
    val description = when {
        displayText.isBlank() -> "Display vazio"
        displayText == "NaN" -> "Erro: resultado inválido"
        else -> "Display mostrando: $displayText"
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Spacing_16)
            .semantics { contentDescription = description }, // Descrição acessível
        shape = RoundedCornerShape(Spacing_16),
    ) {
        Box(
            contentAlignment = Alignment.CenterEnd,
            modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .height(Spacing_120)
        ) {
            Text(
                modifier =
                Modifier
                    .padding(Spacing_16)
                    .semantics { contentDescription = "Texto atual: $displayText" },
                text = when {
                    displayText.isBlank() -> "0" // Mostra "0" quando vazio
                    displayText == "NaN" -> "Erro" // Mostra "Erro" para resultados inválidos
                    else -> displayText
                },
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontSize = Size_48
                ),
                textAlign = TextAlign.End,
                color = Color.Black
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCalculatorDisplay() {
    CalculadoraTheme {
        CalculatorDisplay(
            "123456"
        )
    }
}
