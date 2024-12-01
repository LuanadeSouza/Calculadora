package com.luanadev.calculadora.domain.usecase

class CalculateOperation {
    /**
     * Executa a operação matemática com base nos valores e no operador fornecidos.
     *
     * @param firstValue O primeiro número.
     * @param secondValue O segundo número.
     * @param operator O operador matemático (ex.: "+", "−", "×", "÷").
     * @return O resultado da operação.
     */
    fun execute(firstValue: Double, secondValue: Double, operator: String): Double {
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
            else -> throw IllegalArgumentException("Operador inválido: $operator")
        }
    }
}
