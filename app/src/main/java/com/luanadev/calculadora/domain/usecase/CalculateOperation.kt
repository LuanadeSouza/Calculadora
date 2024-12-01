package com.luanadev.calculadora.domain.usecase

import kotlin.math.pow
import kotlin.math.sqrt

class CalculateOperation {
    /**
     * Executa a operação matemática com base nos valores e no operador fornecidos.
     *
     * @param firstValue O primeiro número.
     * @param secondValue O segundo número (quando aplicável).
     * @param operator O operador matemático (ex.: "+", "−", "×", "÷", "^", "√").
     * @return O resultado da operação.
     */
    fun execute(firstValue: Double, secondValue: Double = 0.0, operator: String): Double {
        return when (operator) {
            "+" -> firstValue + secondValue
            "−" -> firstValue - secondValue
            "×" -> firstValue * secondValue
            "÷" -> {
                if (secondValue != 0.0) {
                    firstValue / secondValue
                } else {
                    Double.NaN // Retorna "NaN" para divisões por zero
                }
            }
            "^" -> firstValue.pow(secondValue) // Eleva o primeiro valor ao segundo
            "√" -> {
                if (firstValue >= 0) {
                    sqrt(firstValue) // Calcula a raiz quadrada do primeiro valor
                } else {
                    Double.NaN // Retorna "NaN" para raízes de números negativos
                }
            }
            else -> throw IllegalArgumentException("Operador inválido: $operator")
        }
    }
}
