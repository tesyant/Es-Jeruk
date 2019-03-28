package com.mamicamp.tesyant.mamicamp.model

import com.google.gson.annotations.SerializedName

data class RoomResponse(

    @SerializedName("data")
    val data: ArrayList<DataDetail>
)