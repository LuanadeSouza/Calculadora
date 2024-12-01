package com.luanadev.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.luanadev.calculadora.ui.screen.MainScreen
import com.luanadev.calculadora.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculadoraTheme {
                MainScreen() // Chama a função MainScreen como a tela principal
            }
        }
    }
}
