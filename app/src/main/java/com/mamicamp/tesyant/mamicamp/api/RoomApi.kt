package com.mamicamp.tesyant.mamicamp.api

import com.mamicamp.tesyant.mamicamp.BuildConfig

object RoomApi {
    fun getData(): String {
        return BuildConfig.BASE_URL
    }
}