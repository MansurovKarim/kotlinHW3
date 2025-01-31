package com.example.kotlinhw3.utils

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper {
    private lateinit var sharedPreferences: SharedPreferences

    fun init(context: Context){
        sharedPreferences = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    }
    var text: Boolean
        get() = sharedPreferences.getBoolean("text", false)
        set(value) = sharedPreferences.edit().putBoolean("text", value).apply()

    fun setOnBoardingCompleted(isCompleted: Boolean){
        sharedPreferences.edit().putBoolean("isBoardingCompleted", isCompleted).apply()
    }

    fun isOnBoardingCompleted(): Boolean{
        return sharedPreferences.getBoolean("isBoardingCompleted", false)
    }

    var layoutManager: Boolean
        get() = sharedPreferences.getBoolean("layoutManager", true)
        set(value) = sharedPreferences.edit().putBoolean("layoutManager", value).apply()

    fun isLinearLayout(): Boolean{
        return sharedPreferences.getBoolean("layoutManager", true)
    }

    fun setLinearLayout(value: Boolean){
        sharedPreferences.edit().putBoolean("layoutManager", value).apply()
    }
    fun setRegistered(isRegistered: Boolean) {
        sharedPreferences.edit().putBoolean("isRegistered", isRegistered).apply()
    }


    fun isRegistered(): Boolean {
        return sharedPreferences.getBoolean("isRegistered", false)
    }
}
