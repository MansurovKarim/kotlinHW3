package com.example.kotlinhw3

import android.app.Application
import com.example.kotlinhw3.utils.PreferenceHelper

class App : Application()  {
    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = PreferenceHelper()
        sharedPreferences.init(this)
    }
}