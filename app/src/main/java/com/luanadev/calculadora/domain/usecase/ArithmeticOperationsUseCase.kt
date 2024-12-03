package com.luanadev.calculadora.domain.usecase

import com.luanadev.calculadora.data.model.Operation
import kotlin.math.pow
import kotlin.math.sqrt

class ArithmeticOperationsUseCase {
    fun calculate(operation: Operation): Double {
        return when (operation.operator) {
            "+" -> operation.number1 + operation.number2
            "-" -> operation.number1 - operation.number2
            "*" -> operation.number1 * operation.number2
            "/" -> if (operation.number2 != 0.0) operation.number1 / operation.number2 else Double.NaN
            "^" -> operation.number1.pow(operation.number2)
            "√" -> if (operation.number1 >= 0) sqrt(operation.number1) else Double.NaN
            else -> throw IllegalArgumentException("Operador inválido: ${operation.operator}")
        }
    }
}
