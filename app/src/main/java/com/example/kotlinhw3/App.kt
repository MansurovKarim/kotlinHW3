package com.example.kotlinhw3

import android.app.Application
import androidx.room.Room
import com.example.kotlinhw3.data.db.AppDataBase
import com.example.kotlinhw3.utils.PreferenceHelper

class App : Application()  {

    companion object{
        var appDataBase: AppDataBase? = null
    }

    override fun onCreate() {
        super.onCreate()
        val sharedPreferences = PreferenceHelper()
        sharedPreferences.init(this)
        getInstance()
    }
    private fun getInstance(): AppDataBase? {
        if (appDataBase == null){
            appDataBase = applicationContext?.let { context->
                Room.databaseBuilder(
                    context,
                    AppDataBase::class.java,
                    "note_database"
                ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
            }
        }
        return appDataBase
    }
}