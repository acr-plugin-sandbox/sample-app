package com.example.sample.data

/** Maps a display name to the initials shown in the avatar. */
class AvatarMapper {
    /** Returns the initials of the first two words of [displayName]. */
    fun initialsOf(displayName: String): String =
        displayName
            .split(" ")
            .filter { it.isNotBlank() }
            .take(2)
            .joinToString("") { it.first().uppercase() }
}
