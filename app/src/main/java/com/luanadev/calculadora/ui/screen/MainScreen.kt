package com.luanadev.calculadora.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.luanadev.calculadora.ui.components.CalculatorDisplay
import com.luanadev.calculadora.ui.components.CalculatorGrid
import com.luanadev.calculadora.viewmodel.CalculatorViewModel

@Composable
fun MainScreen(calculatorViewModel: CalculatorViewModel = viewModel()) {
    val displayText = calculatorViewModel.displayText.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        // Exibe o Display
        CalculatorDisplay(displayText = displayText)

        Spacer(modifier = Modifier.height(16.dp))

        // Adiciona o Grid de Botões
        CalculatorGrid { button ->
            calculatorViewModel.onButtonClicked(button)
        }
    }
}

