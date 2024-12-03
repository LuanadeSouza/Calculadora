import com.luanadev.calculadora.data.model.Operation
import com.luanadev.calculadora.domain.usecase.ArithmeticOperationsUseCase
import org.junit.Assert.assertEquals
import org.junit.Test

class ArithmeticOperationsUseCaseTest {

    private val arithmeticOperations = ArithmeticOperationsUseCase()

    @Test
    fun `testa soma valida`() {
        // Cria o objeto Operation com os valores da operação
        val operation = Operation(number1 = 5.0, number2 = 3.0, operator = "+")

        // Chama o método calculate passando o objeto Operation
        val result = arithmeticOperations.calculate(operation)

        // Verifica se o resultado é o esperado
        assertEquals(8.0, result, 0.001)
    }

    @Test
    fun `testa subtracao valida`() {
        val operation = Operation(number1 = 10.0, number2 = 4.0, operator = "-")
        val result = arithmeticOperations.calculate(operation)
        assertEquals(6.0, result, 0.001)
    }

    @Test
    fun `testa divisao por zero`() {
        val operation = Operation(number1 = 10.0, number2 = 0.0, operator = "/")
        val result = arithmeticOperations.calculate(operation)
        assertEquals(Double.NaN, result, 0.001)
    }

    @Test(expected = IllegalArgumentException::class)
    fun `testa operador invalido`() {
        val operation = Operation(number1 = 5.0, number2 = 3.0, operator = "%")
        arithmeticOperations.calculate(operation)
    }


}
