package com.example.sample.data

import android.content.Context

class ProfileStore(context: Context) {
    private val prefs = context.getSharedPreferences("profile", Context.MODE_PRIVATE)

    fun displayName(): String = prefs.getString("display_name", null)!!

    fun saveDisplayName(name: String) {
        prefs.edit().putString("display_name", name).apply()
    }
}
