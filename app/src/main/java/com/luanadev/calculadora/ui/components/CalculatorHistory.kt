package com.luanadev.calculadora.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import com.luanadev.calculadora.data.model.OperationHistory
import com.luanadev.calculadora.ui.theme.Size_16
import com.luanadev.calculadora.ui.theme.Spacing_16
import com.luanadev.calculadora.ui.theme.Spacing_4
import com.luanadev.calculadora.ui.theme.Spacing_8

@Composable
fun CalculatorHistory(history: List<OperationHistory>) {
    if (history.isEmpty()) {
        Text(
            text = "Sem operações no histórico.",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .fillMaxWidth()
                .padding(Spacing_16)
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Spacing_8),
            verticalArrangement = Arrangement.spacedBy(Spacing_8)
        ) {
            items(history) { item ->
                HistoryItem(item)
            }
        }
    }
}

@Composable
fun HistoryItem(item: OperationHistory) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Spacing_8, vertical = Spacing_4)
            .semantics {
                contentDescription =
                    "Histórico de operação: ${item.operation}, Resultado: ${item.result}"
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Spacing_16),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item.operation,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = Size_16,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = item.result,
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontSize = Size_16
                )
            )
        }
    }
}
