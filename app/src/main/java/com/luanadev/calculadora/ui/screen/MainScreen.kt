package com.luanadev.calculadora.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.luanadev.calculadora.ui.components.CalculatorDisplay
import com.luanadev.calculadora.viewmodel.CalculatorViewModel

@Composable
fun MainScreen(calculatorViewModel: CalculatorViewModel = viewModel()) {
    val displayText = calculatorViewModel.displayText.collectAsState().value

    Column {
        CalculatorDisplay(displayText = displayText)
        // Aqui, adicionaremos os botões
    }
}
