package com.luanadev.calculadora.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.luanadev.calculadora.ui.components.CalculatorDisplay
import com.luanadev.calculadora.ui.components.CalculatorGrid
import com.luanadev.calculadora.ui.components.CalculatorHistory
import com.luanadev.calculadora.ui.theme.CalculadoraTheme
import com.luanadev.calculadora.ui.theme.Spacing_16
import com.luanadev.calculadora.viewmodel.CalculatorViewModel

@Composable
fun MainScreen(calculatorViewModel: CalculatorViewModel = viewModel()) {
    val displayText = calculatorViewModel.displayText.collectAsState().value
    val history = calculatorViewModel.history.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Spacing_16),
        verticalArrangement = Arrangement.spacedBy(Spacing_16)
    ) {
        CalculatorHistory(history = history)

        CalculatorDisplay(displayText = displayText)

        CalculatorGrid { button ->
            calculatorViewModel.onButtonClicked(button)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    val calculatorViewModel: CalculatorViewModel = viewModel()
    CalculadoraTheme {
        MainScreen(
            calculatorViewModel
        )
    }
}