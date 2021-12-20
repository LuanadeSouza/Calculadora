package br.com.luanadev.calculadoraapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

    }

    private fun init() {
        setNumber()
        setOperadores()
        setLimpar()
        setDelet()
        setResult()
    }

    private fun setResult() {
        equal.setOnClickListener {
            try {
                val expressao = ExpressionBuilder(expressao.text.toString()).build()
                val resultado = expressao.evaluate()
                val longResult = resultado.toLong()
                if (resultado == longResult.toDouble()) {
                    result.text = longResult.toString()
                } else {
                    result.text = resultado.toString()
                }

            } catch (e: Exception) {
            }
        }
    }

    private fun setDelet() {
        backspace.setOnClickListener {
            val textoDigitado = expressao.text.toString()
            if (textoDigitado.isNotBlank()) {
                expressao.text = textoDigitado.substring(0, textoDigitado.length - 1)
            }
            result.text = ""
        }
    }

    private fun setLimpar() {
        clean.setOnClickListener {
            expressao.text = ""
            result.text = ""
        }
    }

    private fun setOperadores() {
        add_up.setOnClickListener { acrescentarUmaExpressao("+", false) }
        subtraction.setOnClickListener { acrescentarUmaExpressao("-", false) }
        multiplication.setOnClickListener { acrescentarUmaExpressao("*", false) }
        division.setOnClickListener { acrescentarUmaExpressao("/", false) }
    }

    private fun setNumber() {
        number_zero.setOnClickListener { acrescentarUmaExpressao("0", true) }
        number_one.setOnClickListener { acrescentarUmaExpressao("1", true) }
        number_two.setOnClickListener { acrescentarUmaExpressao("2", true) }
        number_three.setOnClickListener { acrescentarUmaExpressao("3", true) }
        number_four.setOnClickListener { acrescentarUmaExpressao("4", true) }
        number_five.setOnClickListener { acrescentarUmaExpressao("5", true) }
        number_six.setOnClickListener { acrescentarUmaExpressao("6", true) }
        number_seven.setOnClickListener { acrescentarUmaExpressao("7", true) }
        number_eight.setOnClickListener { acrescentarUmaExpressao("8", true) }
        number_nine.setOnClickListener { acrescentarUmaExpressao("9", true) }
        ponto.setOnClickListener { acrescentarUmaExpressao(".", true) }

    }

    private fun acrescentarUmaExpressao(dados: String, limpar_dados: Boolean) {
        if (result.text.isNotEmpty()) {
            expressao.text = ""
        }
        if (limpar_dados) {
            result.text = ""
            expressao.append(dados)
        } else {
            expressao.append(result.text)
            expressao.append(dados)
            result.text = ""
        }
    }

}