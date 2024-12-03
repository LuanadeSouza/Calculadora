package com.luanadev.calculadora.ui.components

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
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
            .padding(16.dp)
            .semantics { contentDescription = description }, // Descrição acessível
        shape = RoundedCornerShape(16.dp),
        // elevation = 8.dp
    ) {
        Box(
            contentAlignment = Alignment.CenterEnd,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
        ) {
            Text(
                text = when {
                    displayText.isBlank() -> "0" // Mostra "0" quando vazio
                    displayText == "NaN" -> "Erro" // Mostra "Erro" para resultados inválidos
                    else -> displayText
                },
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontSize = 48.sp
                ),
                textAlign = TextAlign.End,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
