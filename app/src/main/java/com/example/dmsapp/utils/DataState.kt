package com.example.dmsapp.utils

import com.example.dmsapp.model.Auto
import java.lang.Exception

sealed class DataState {
    object Idle:DataState()
    data class Success(val autos:List<Auto>) : DataState()
    data class Error(val exception: Exception) : DataState()
    object Loading: DataState()
}