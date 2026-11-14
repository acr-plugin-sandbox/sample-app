package com.example.sample.data

/** Builds the greeting shown on the home screen. */
class GreetingHelper {
    /** Greets [name], or the anonymous user when it is null. */
    fun greet(name: String?): String = if (name == null) "Hello" else "Hello, $name"
}
