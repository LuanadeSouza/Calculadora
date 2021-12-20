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
        igual.setOnClickListener {
            try {
                val expressao = ExpressionBuilder(expressao.text.toString()).build()
                val resultado = expressao.evaluate()
                val longResult = resultado.toLong()
                if (resultado == longResult.toDouble()) {
                    txt_resultado.text = longResult.toString()
                } else {
                    txt_resultado.text = resultado.toString()
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
            txt_resultado.text = ""
        }
    }

    private fun setLimpar() {
        limpar.setOnClickListener {
            expressao.text = ""
            txt_resultado.text = ""
        }
    }

    private fun setOperadores() {
        soma.setOnClickListener { acrescentarUmaExpressao("+", false) }
        subitracao.setOnClickListener { acrescentarUmaExpressao("-", false) }
        multiplicacao.setOnClickListener { acrescentarUmaExpressao("*", false) }
        divisao.setOnClickListener { acrescentarUmaExpressao("/", false) }
    }

    private fun setNumber() {
        numero_zero.setOnClickListener { acrescentarUmaExpressao("0", true) }
        numero_um.setOnClickListener { acrescentarUmaExpressao("1", true) }
        numero_dois.setOnClickListener { acrescentarUmaExpressao("2", true) }
        numero_tres.setOnClickListener { acrescentarUmaExpressao("3", true) }
        numero_quatro.setOnClickListener { acrescentarUmaExpressao("4", true) }
        numero_cinco.setOnClickListener { acrescentarUmaExpressao("5", true) }
        numero_seis.setOnClickListener { acrescentarUmaExpressao("6", true) }
        numero_sete.setOnClickListener { acrescentarUmaExpressao("7", true) }
        numero_oito.setOnClickListener { acrescentarUmaExpressao("8", true) }
        numero_nove.setOnClickListener { acrescentarUmaExpressao("9", true) }
        ponto.setOnClickListener { acrescentarUmaExpressao(".", true) }

    }

    private fun acrescentarUmaExpressao(dados: String, limpar_dados: Boolean) {
        if (txt_resultado.text.isNotEmpty()) {
            expressao.text = ""
        }
        if (limpar_dados) {
            txt_resultado.text = ""
            expressao.append(dados)
        } else {
            expressao.append(txt_resultado.text)
            expressao.append(dados)
            txt_resultado.text = ""
        }
    }

}