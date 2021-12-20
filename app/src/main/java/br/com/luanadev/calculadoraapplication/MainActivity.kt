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
        setOperators()
        setClean()
        setDelete()
        setExpectedResult()
    }

    private fun setExpectedResult() {
        equal.setOnClickListener {
            try {
                val expectedExpression = ExpressionBuilder(expression.text.toString()).build()
                val expectedResult = expectedExpression.evaluate()
                val longResult = expectedResult.toLong()
                if (expectedResult == longResult.toDouble()) {
                    result.text = longResult.toString()
                } else {
                    result.text = expectedResult.toString()
                }

            } catch (e: Exception) {
            }
        }
    }

    private fun setDelete() {
        backspace.setOnClickListener {
            val typedtext = expression.text.toString()
            if (typedtext.isNotBlank()) {
                expression.text = typedtext.substring(0, typedtext.length - 1)
            }
            result.text = ""
        }
    }

    private fun setClean() {
        clean.setOnClickListener {
            expression.text = ""
            result.text = ""
        }
    }

    private fun setOperators() {
        add_up.setOnClickListener { makeAnExpression("+", false) }
        subtraction.setOnClickListener { makeAnExpression("-", false) }
        multiplication.setOnClickListener { makeAnExpression("*", false) }
        division.setOnClickListener { makeAnExpression("/", false) }
    }

    private fun setNumber() {
        number_zero.setOnClickListener { makeAnExpression("0", true) }
        number_one.setOnClickListener { makeAnExpression("1", true) }
        number_two.setOnClickListener { makeAnExpression("2", true) }
        number_three.setOnClickListener { makeAnExpression("3", true) }
        number_four.setOnClickListener { makeAnExpression("4", true) }
        number_five.setOnClickListener { makeAnExpression("5", true) }
        number_six.setOnClickListener { makeAnExpression("6", true) }
        number_seven.setOnClickListener { makeAnExpression("7", true) }
        number_eight.setOnClickListener { makeAnExpression("8", true) }
        number_nine.setOnClickListener { makeAnExpression("9", true) }
        ponto.setOnClickListener { makeAnExpression(".", true) }

    }

    private fun makeAnExpression(data: String, clearData: Boolean) {
        if (result.text.isNotEmpty()) {
            expression.text = ""
        }
        if (clearData) {
            result.text = ""
            expression.append(data)
        } else {
            expression.append(result.text)
            expression.append(data)
            result.text = ""
        }
    }

}