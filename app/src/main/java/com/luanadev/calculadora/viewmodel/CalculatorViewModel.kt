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

    private var currentOperation: Operation? = null
    private var isOperatorPressed = false

    fun onButtonClicked(input: String) {
        when (input) {
            "C" -> clearDisplay()
            "±" -> toggleSign()
            "%" -> applyPercentage()
            "+", "−", "×", "÷" -> setOperator(input)
            "=" -> calculateResult()
            else -> appendNumber(input)
        }
    }

    private fun clearDisplay() {
        _displayText.value = "0"
        currentOperation = null
    }

    private fun toggleSign() {
        _displayText.value = (_displayText.value.toDoubleOrNull()?.times(-1)).toString()
    }

    private fun applyPercentage() {
        _displayText.value = (_displayText.value.toDoubleOrNull()?.div(100)).toString()
    }

    private fun setOperator(operator: String) {
        val number = _displayText.value.toDoubleOrNull() ?: return
        currentOperation = Operation(number1 = number, number2 = 0.0, operator = operator)
        isOperatorPressed = true
    }

    private fun calculateResult() {
        val operation = currentOperation ?: return
        val number2 = _displayText.value.toDoubleOrNull() ?: return
        currentOperation = operation.copy(number2 = number2)
        val result = calculateOperation.execute(currentOperation!!)
        _displayText.value = result.toString()
        currentOperation = null
    }

    private fun appendNumber(input: String) {
        if (isOperatorPressed) {
            _displayText.value = input
            isOperatorPressed = false
        } else {
            _displayText.value = if (_displayText.value == "0") input else _displayText.value + input
        }
    }
}
