package com.example.dmsapp.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AutoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(catEntity: AutoCacheEntity): Long
    @Query("select * from autos")
    suspend fun get(): List<AutoCacheEntity>
}