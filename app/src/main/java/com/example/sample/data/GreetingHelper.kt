package com.example.sample.data

class GreetingHelper {
    fun greet(name: String?): String = if (name == null) "Hello" else "Hello, $name"
}
