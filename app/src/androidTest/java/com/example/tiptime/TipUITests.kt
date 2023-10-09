package com.example.tiptime

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculateTip_20PercentNoRoundUp() {
        with(composeTestRule) {
            this.setContent {
                TipTimeTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        TipTimeLayout()
                    }
                }
            }
            this.onNodeWithText("Bill Amount")
                .performTextInput("10")
            this.onNodeWithText("Tip Percentage").performTextInput("20")
            val expectedTip = NumberFormat.getCurrencyInstance().format(2)
            this.onNodeWithText("Tip Amount: $expectedTip").assertExists(
                "No node with this text was found."
            )
        }
    }
}