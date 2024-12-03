package com.luanadev.calculadora.domain.usecase

class OperationValidatorUseCase {
    fun validateInputs(firstValue: Double?, secondValue: Double?, operator: String): Boolean {
        if (firstValue == null) throw IllegalArgumentException("O primeiro valor é inválido.")
        if (operator == "/" && secondValue == 0.0) throw IllegalArgumentException("Divisão por zero.")
        if (operator == "√" && firstValue < 0) throw IllegalArgumentException("Raiz de número negativo.")
        return true
    }
}
