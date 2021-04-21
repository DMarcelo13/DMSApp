package com.example.dmsapp.di

import com.example.dmsapp.repository.AutoRepository
import com.example.dmsapp.retrofit.AutoRetrofit
import com.example.dmsapp.retrofit.NetworkMapper
import com.example.dmsapp.room.AutoDao
import com.example.dmsapp.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent :: class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideAutoRepository(
        autoDao: AutoDao,
        autoRetrofit: AutoRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): AutoRepository {
        return AutoRepository(autoDao, autoRetrofit, cacheMapper, networkMapper)
    }
}