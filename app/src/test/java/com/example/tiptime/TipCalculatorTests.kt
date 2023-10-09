package com.example.tiptime

import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.NumberFormat

class TipCalculatorTests {

    @Test
    fun calculateTip_10PercentNoRoundUp() {
        val expected = NumberFormat.getCurrencyInstance().format(10.0)
        val actual = calculateTip(amount = 100.0, tipPercent = 10.0, roundUp = false)
        assertEquals(expected, actual)
    }
}