package com.example.dmsapp.di

import android.app.Application
import com.example.dmsapp.utils.AdapterAutos
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AdapterModule {

    @Singleton
    @Provides
    fun provideAdapterGenres(application: Application): AdapterAutos{
        return AdapterAutos()
    }
}