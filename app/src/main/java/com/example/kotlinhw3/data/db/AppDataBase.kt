package com.example.kotlinhw3.data.db

import androidx.room.RoomDatabase
import com.example.kotlinhw3.data.db.daos.Dao

abstract class AppDataBase: RoomDatabase() {
    abstract fun noteDao(): Dao
}