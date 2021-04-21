package com.example.dmsapp.di

import android.content.Context
import androidx.room.Room
import com.example.dmsapp.room.AutoDao
import com.example.dmsapp.room.AutoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideAutoDb(@ApplicationContext context: Context): AutoDatabase {
        return Room.databaseBuilder(context, AutoDatabase::class.java, AutoDatabase.DATABASE_NAME).fallbackToDestructiveMigration().build()
    }

    @Singleton
    @Provides
    fun provideAutoDao(autoDatabase: AutoDatabase): AutoDao {
        return autoDatabase.autoDao()
    }
}