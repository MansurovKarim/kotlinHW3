package com.example.kotlinhw3.data.db

import androidx.room.Dao
import androidx.room.RoomDatabase

abstract class AppDAtaBase: RoomDatabase() {
    abstract fun noteDao(): Dao
}