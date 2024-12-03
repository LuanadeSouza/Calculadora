package com.luanadev.calculadora.domain.usecase

import com.luanadev.calculadora.data.model.Operation

class OperationFactory(private val arithmeticOperations: ArithmeticOperationsUseCase) {
    fun executeOperation(operation: Operation): Double {
        return arithmeticOperations.calculate(operation)
    }
}
