package test.example.material3calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import test.example.material3calculator.presentation.CalcularScreen
import test.example.material3calculator.ui.theme.Material3CalculatorTheme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3CalculatorTheme {
                CalcularScreen()
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun CalcularPreview() {
    Material3CalculatorTheme {
        CalcularScreen()
    }
}