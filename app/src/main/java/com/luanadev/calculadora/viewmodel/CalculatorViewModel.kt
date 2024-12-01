package com.luanadev.calculadora.viewmodel

import androidx.lifecycle.ViewModel
import com.luanadev.calculadora.data.model.OperationHistory
import com.luanadev.calculadora.domain.usecase.CalculateOperation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CalculatorViewModel : ViewModel() {

    private val _displayText = MutableStateFlow("0")
    val displayText: StateFlow<String> = _displayText

    private val _history = MutableStateFlow<List<OperationHistory>>(emptyList())
    val history: StateFlow<List<OperationHistory>> = _history

    private var previousValue: Double? = null
    private var currentOperator: String? = null

    private val calculateOperation = CalculateOperation()

    fun onButtonClicked(input: String) {
        when (input) {
            "C" -> clearAll()
            "±" -> toggleSign()
            "%" -> applyPercentage()
            "+", "−", "×", "÷", "^", "√" -> setOperator(input)
            "=" -> calculateResult()
            else -> appendNumber(input)
        }
    }

    private fun clearAll() {
        _displayText.value = "0"
        previousValue = null
        currentOperator = null
    }

    private fun toggleSign() {
        val value = _displayText.value.toDoubleOrNull() ?: return
        _displayText.value = (value * -1).toString()
    }

    private fun applyPercentage() {
        val value = _displayText.value.toDoubleOrNull() ?: return
        _displayText.value = (value / 100).toString()
    }

    private fun setOperator(operator: String) {
        val value = _displayText.value.toDoubleOrNull() ?: return
        previousValue = value
        currentOperator = operator
        _displayText.value = if (operator == "√") "0" else "0"
    }

    private fun calculateResult() {
        val secondValue = _displayText.value.toDoubleOrNull() ?: return
        val operator = currentOperator ?: return
        val firstValue = previousValue ?: return

        val operation = OperationHistory(
            operation = if (operator == "√") "$operator($firstValue)" else "$firstValue $operator $secondValue",
            result = if (operator == "√") calculateOperation.execute(firstValue, operator = "√").toString()
            else calculateOperation.execute(firstValue, secondValue, operator).toString()
        )

        _history.value = _history.value + operation
        _displayText.value = operation.result

        previousValue = null
        currentOperator = null
    }

    private fun appendNumber(input: String) {
        _displayText.value = if (_displayText.value == "0") input else _displayText.value + input
    }
}

