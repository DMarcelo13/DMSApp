package com.example.dmsapp.repository

import com.example.dmsapp.retrofit.AutoRetrofit
import com.example.dmsapp.retrofit.NetworkMapper
import com.example.dmsapp.room.AutoDao
import com.example.dmsapp.room.CacheMapper
import com.example.dmsapp.utils.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class AutoRepository constructor(
    private val autoDao : AutoDao,
    private val autoRetrofit: AutoRetrofit,
    private val cacheMapper: CacheMapper,
    private val networkMapper: NetworkMapper
){
    suspend fun getAuto(): Flow<DataState> = flow{
        emit(DataState.Loading)
        delay(2000)
        try {
            val autoData = autoRetrofit.get()
            val autoMap = networkMapper.mapFromEntityList(autoData)
            for (tempAuto in autoMap){
                autoDao.insert(cacheMapper.mapToEntity(tempAuto))
            }
            val cacheAut = autoDao.get()
            emit(DataState.Success(cacheMapper.mapFromEntityList(cacheAut)))
        }catch (e: Exception){
            emit(DataState.Error(e))
        }
    }
}