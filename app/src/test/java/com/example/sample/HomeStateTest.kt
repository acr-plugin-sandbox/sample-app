package com.example.sample

import com.example.sample.ui.HomeState
import org.junit.Assert.assertEquals
import org.junit.Test

class HomeStateTest {
    @Test
    fun keepsTitle() {
        assertEquals("Welcome", HomeState(title = "Welcome").title)
    }
}
