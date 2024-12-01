package com.luanadev.calculadora.domain.usecase

import com.luanadev.calculadora.data.model.Operation

class CalculateOperation {
    fun execute(operation: Operation): Double {
        return when (operation.operator) {
            "+" -> operation.number1 + operation.number2
            "-" -> operation.number1 - operation.number2
            "*" -> operation.number1 * operation.number2
            "/" -> if (operation.number2 != 0.0) operation.number1 / operation.number2 else Double.NaN
            else -> throw IllegalArgumentException("Operador inválido")
        }
    }
}
