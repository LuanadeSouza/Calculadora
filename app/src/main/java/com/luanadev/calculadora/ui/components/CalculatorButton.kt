package com.luanadev.calculadora.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luanadev.calculadora.ui.theme.GoldSophisticated
import com.luanadev.calculadora.ui.theme.WhiteElegant

@Composable
fun CalculatorButton(
    label: String,
    onClick: () -> Unit,
    backgroundColor: Color = GoldSophisticated,
    textColor: Color = WhiteElegant
) {
    Button(
        onClick = onClick,
        modifier = Modifier.size(70.dp), // Tamanho do botão
        shape = CircleShape, // Botão redondo
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor)
    ) {
        Text(
            text = label,
            color = textColor,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@Preview(showBackground = true, name = "Luxurious Button")
fun PreviewCalculatorButton() {
    CalculatorButton(label = "1", onClick = {})
}
