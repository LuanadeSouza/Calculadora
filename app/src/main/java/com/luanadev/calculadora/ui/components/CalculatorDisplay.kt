package com.luanadev.calculadora.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luanadev.calculadora.ui.theme.MontserratFont

@Composable
fun CalculatorDisplay(
    displayText: String
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp),
        shadowElevation = 4.dp
    ) {
        Box(
            contentAlignment = Alignment.CenterEnd,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp) // Altura do display
                .padding(end = 16.dp)
        ) {
            Text(
                text = displayText,
                style = MaterialTheme.typography.headlineLarge.copy(
                    fontSize = 48.sp,
                    fontFamily = MontserratFont,
                ),
                textAlign = TextAlign.End,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCalculatorDisplay() {
    CalculatorDisplay(displayText = "12345")
}
