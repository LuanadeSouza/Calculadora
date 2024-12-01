package com.luanadev.calculadora.viewmodel

import androidx.lifecycle.ViewModel
import com.luanadev.calculadora.data.model.Operation
import com.luanadev.calculadora.domain.usecase.CalculateOperation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CalculatorViewModel : ViewModel() {
    private val calculateOperation = CalculateOperation()

    private val _displayText = MutableStateFlow("0")
    val displayText: StateFlow<String> = _displayText

    fun onButtonClicked(input: String) {
        // Atualiza o estado baseado no botão clicado
        _displayText.value = input
    }

    fun calculateResult(operation: Operation) {
        val result = calculateOperation.execute(operation)
        _displayText.value = result.toString()
    }
}
