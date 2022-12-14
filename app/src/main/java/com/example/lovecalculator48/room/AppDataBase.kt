package com.example.lovecalculator48.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.lovecalculator48.love.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}