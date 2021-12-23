package br.com.luanadev.calculadoraapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

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
        add_up.setOnClickListener { calculateTheExpress("+", false) }
        subtraction.setOnClickListener { calculateTheExpress("-", false) }
        multiplication.setOnClickListener { calculateTheExpress("*", false) }
        division.setOnClickListener { calculateTheExpress("/", false) }
    }

    private fun setNumber() {
        number_zero.setOnClickListener { calculateTheExpress("0", true) }
        number_one.setOnClickListener { calculateTheExpress("1", true) }
        number_two.setOnClickListener { calculateTheExpress("2", true) }
        number_three.setOnClickListener { calculateTheExpress("3", true) }
        number_four.setOnClickListener { calculateTheExpress("4", true) }
        number_five.setOnClickListener { calculateTheExpress("5", true) }
        number_six.setOnClickListener { calculateTheExpress("6", true) }
        number_seven.setOnClickListener { calculateTheExpress("7", true) }
        number_eight.setOnClickListener { calculateTheExpress("8", true) }
        number_nine.setOnClickListener { calculateTheExpress("9", true) }
        ponto.setOnClickListener { calculateTheExpress(".", true) }
    }

    private fun calculateTheExpress(data: String, clearData: Boolean) {
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