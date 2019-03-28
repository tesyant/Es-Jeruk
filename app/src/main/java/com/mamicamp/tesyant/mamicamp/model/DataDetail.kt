package com.mamicamp.tesyant.mamicamp.model

import com.google.gson.annotations.SerializedName

data class DataDetail (

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("price")
    var price: Int? = null,

    @SerializedName("type")
    var type: String? = null,

    @SerializedName("category")
    var category: String? = null,

    @SerializedName("description")
    var description: String? = null,

    @SerializedName("image_url")
    var image_url: String? = null

)