package com.luanadev.calculadora.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.luanadev.calculadora.data.model.OperationHistory

@Composable
fun CalculatorHistory(history: List<OperationHistory>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        items(history.size) { index ->
            val item = history[index]
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                BasicText(text = item.operation)
                BasicText(text = item.result)
            }
        }
    }
}
