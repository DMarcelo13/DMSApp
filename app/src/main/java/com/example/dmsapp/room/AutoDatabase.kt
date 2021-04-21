package com.example.dmsapp.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AutoCacheEntity::class], version = 1)
abstract class AutoDatabase : RoomDatabase() {
    companion object{
        val DATABASE_NAME = "AutoDB"
    }
    abstract fun autoDao() : AutoDao
}