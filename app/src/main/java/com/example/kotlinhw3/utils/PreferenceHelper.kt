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
}