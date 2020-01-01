package com.benjaminledet.pokedex.data.remote.response

import com.google.gson.annotations.SerializedName

data class EncounterResponse(

    @SerializedName("id")
    val id:Int,

    @SerializedName("name")
    val name:String,

    @SerializedName("order")
    val order:Int,

    @SerializedName("names")
    val names:List<String>

)