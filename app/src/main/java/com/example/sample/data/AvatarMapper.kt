package com.example.sample.data

class AvatarMapper {
    fun initialsOf(displayName: String): String =
        displayName
            .split(" ")
            .filter { it.isNotBlank() }
            .take(2)
            .joinToString("") { it.first().uppercase() }
}
