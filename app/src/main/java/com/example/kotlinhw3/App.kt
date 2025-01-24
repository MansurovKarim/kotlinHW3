package com.example.kotlinhw3

import android.app.Application
import androidx.room.Room
import com.example.kotlinhw3.data.db.AppDAtaBase
import com.example.kotlinhw3.utils.PreferenceHelper

class App : Application()  {

    companion object{
        var appDataBase: AppDAtaBase? = null
    }

    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = PreferenceHelper()
        sharedPreferences.init(this)
        getInstance()
    }
    private fun getInstance(): AppDAtaBase? {
        if (appDataBase == null){
            appDataBase = applicationContext?.let { context->
                Room.databaseBuilder(
                    context,
                    AppDAtaBase::class.java,
                    "note_database"
                ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
            }
        }
        return appDataBase
    }
}