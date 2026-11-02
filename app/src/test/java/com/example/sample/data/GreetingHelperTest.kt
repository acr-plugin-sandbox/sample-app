package com.example.sample.data

import org.junit.Assert.assertEquals
import org.junit.Test

class GreetingHelperTest {
    @Test
    fun greetsByName() {
        assertEquals("Hello, Ada", GreetingHelper().greet("Ada"))
    }

    @Test
    fun greetsAnonymousUsers() {
        assertEquals("Hello", GreetingHelper().greet(null))
    }
}
