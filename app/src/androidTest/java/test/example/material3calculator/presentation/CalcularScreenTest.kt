package test.example.material3calculator.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import test.example.material3calculator.MainActivity

class CalcularScreenTest {

    @get:Rule
    val composeRule = createAndroidComposeRule(MainActivity::class.java)
    private lateinit var viewModel: CalculatorViewModel

    @Before
    fun setUp() {
        viewModel = CalculatorViewModel()
    }

    @Test
    fun enterExpression_correctResultDisplayed() {
        composeRule.onNodeWithText("1").performClick()
        composeRule.onNodeWithText("+").performClick()
        composeRule.onNodeWithText("2").performClick()
        composeRule.onNodeWithText("x").performClick()
        composeRule.onNodeWithText("3").performClick()
        composeRule.onNodeWithText("-").performClick()
        composeRule.onNodeWithText("5").performClick()
        composeRule.onNodeWithText("=").performClick()

        composeRule.onNodeWithText("2.0").assertIsDisplayed()
    }

}