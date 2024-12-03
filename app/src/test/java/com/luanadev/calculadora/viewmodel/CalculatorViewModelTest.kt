package com.luanadev.calculadora.viewmodel

import app.cash.turbine.test
import com.luanadev.calculadora.data.model.OperationHistory
import com.luanadev.calculadora.domain.usecase.ArithmeticOperationsUseCase
import com.luanadev.calculadora.domain.usecase.OperationFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class CalculatorViewModelTest {

    private lateinit var viewModel: CalculatorViewModel
    private val arithmeticOperations = ArithmeticOperationsUseCase()
    private val operationFactory = OperationFactory(arithmeticOperations)

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        // Configura o dispatcher de teste como o principal
        setMain(testDispatcher)
        viewModel = CalculatorViewModel()
    }

    @Test
    fun `testa display inicial`() = runTest {
        viewModel.displayText.test {
            val initialValue = awaitItem()
            assertEquals("0", initialValue)
        }
    }

    @Test
    fun `testa soma valida`() = runTest {
        viewModel.onButtonClicked("5")
        viewModel.onButtonClicked("+")
        viewModel.onButtonClicked("3")
        viewModel.onButtonClicked("=")

        viewModel.displayText.test {
            val result = awaitItem() // Recebe o resultado após a soma
            assertEquals("8.0", result)
        }
    }

    @Test
    fun `testa divisao por zero`() = runTest {
        viewModel.onButtonClicked("5")
        viewModel.onButtonClicked("/")
        viewModel.onButtonClicked("0")
        viewModel.onButtonClicked("=")

        viewModel.displayText.test {
            val result = awaitItem()
            assertEquals("NaN", result)
        }
    }

    @Test
    fun `testa toggle sign`() = runTest {
        viewModel.onButtonClicked("5")
        viewModel.onButtonClicked("±")

        viewModel.displayText.test {
            val result = awaitItem()
            assertEquals("-5.0", result)
        }
    }

    @Test
    fun `testa historico apos operacao`() = runTest {
        viewModel.onButtonClicked("5")
        viewModel.onButtonClicked("+")
        viewModel.onButtonClicked("3")
        viewModel.onButtonClicked("=")

        viewModel.history.test {
            val history = awaitItem()
            val lastOperation = history.lastOrNull()

            assertEquals(
                OperationHistory(operation = "5.0 + 3.0", result = "8.0"),
                lastOperation
            )
        }
    }

    @Test
    fun `testa limpar display`() = runTest {
        viewModel.onButtonClicked("5")
        viewModel.onButtonClicked("C")

        viewModel.displayText.test {
            val result = awaitItem()
            assertEquals("0", result)
        }
    }

    @Test
    fun `testa operador raiz quadrada`() = runTest {
        viewModel.onButtonClicked("9")
        viewModel.onButtonClicked("√")
        viewModel.onButtonClicked("=")

        viewModel.displayText.test {
            val result = awaitItem()
            assertEquals("3.0", result)
        }
    }
}
