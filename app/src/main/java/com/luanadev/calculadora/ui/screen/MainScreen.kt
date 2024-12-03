package com.luanadev.calculadora.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.luanadev.calculadora.ui.components.CalculatorDisplay
import com.luanadev.calculadora.ui.components.CalculatorGrid
import com.luanadev.calculadora.ui.components.CalculatorHistory
import com.luanadev.calculadora.ui.theme.Spacing_16
import com.luanadev.calculadora.viewmodel.CalculatorViewModel

@Composable
fun MainScreen(calculatorViewModel: CalculatorViewModel = viewModel()) {
    // Observa os estados do ViewModel
    val displayText = calculatorViewModel.displayText.collectAsState().value
    val history = calculatorViewModel.history.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Spacing_16),
        verticalArrangement = Arrangement.spacedBy(Spacing_16)
    ) {
        // Exibe o Histórico
        CalculatorHistory(history = history)

        // Exibe o Display
        CalculatorDisplay(displayText = displayText)

        // Adiciona o Grid de Botões
        CalculatorGrid { button ->
            calculatorViewModel.onButtonClicked(button)
        }
    }
}
