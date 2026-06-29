package com.example.data

import android.content.Context
import android.content.SharedPreferences

class DuaStorage(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("dua_prefs", Context.MODE_PRIVATE)

    fun isDuaSaved(id: String): Boolean {
        return prefs.getBoolean(id, false)
    }

    fun toggleSavedDua(id: String) {
        val current = isDuaSaved(id)
        prefs.edit().putBoolean(id, !current).apply()
    }
}
