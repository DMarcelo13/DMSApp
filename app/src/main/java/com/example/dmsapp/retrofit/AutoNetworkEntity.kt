package com.example.dmsapp.retrofit

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class AutoNetworkEntity (

    @SerializedName("id")
    @Expose
    var id: Int,

    @SerializedName("nombre")
    @Expose
    var nombre: String,

    @SerializedName("descripcion")
    @Expose
    var descripcion: String,

    @SerializedName("img")
    @Expose
    var img: String
)