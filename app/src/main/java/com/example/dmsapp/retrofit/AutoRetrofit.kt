package com.example.dmsapp.retrofit

import retrofit2.http.GET

interface AutoRetrofit {
    @GET("autos")
    suspend fun get () : List<AutoNetworkEntity>

}