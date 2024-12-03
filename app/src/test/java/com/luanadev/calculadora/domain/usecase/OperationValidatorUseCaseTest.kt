package com.luanadev.calculadora.domain.usecase

import org.junit.Assert.assertThrows
import org.junit.Test

class OperationValidatorUseCaseTest {
    private val operationValidatorUseCase = OperationValidatorUseCase()

    @Test
    fun `testa divisao por zero`() {
        assertThrows(IllegalArgumentException::class.java) {
            operationValidatorUseCase.validateInputs(5.0, 0.0, "/")
        }
    }

    @Test
    fun `testa raiz quadrada de numero negativo`() {
        assertThrows(IllegalArgumentException::class.java) {
            operationValidatorUseCase.validateInputs(-4.0, 0.0, "√")
        }
    }
}
