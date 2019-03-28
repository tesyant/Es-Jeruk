package com.mamicamp.tesyant.mamicamp.main

import android.util.Log
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mamicamp.tesyant.mamicamp.api.RoomApi.getData
import com.mamicamp.tesyant.mamicamp.model.DataDetail

class MainPresenter {

    var adapter: MainAdapter? = null
    private val data: ArrayList<DataDetail> = arrayListOf()
    val gson = Gson()

     fun getRoomList() {
        getData()
            .httpGet()
            .responseString{ request, response, result ->
                showData(result.component1())
                val status = response.statusCode
                Log.e("STATUS", status.toString())
            }
    }

    fun showData(result: String?) {

        val listType = object : TypeToken<ArrayList<DataDetail>>() {
        }.type

        data.addAll(gson.fromJson(result, listType))
        Log.e("response", "${data.size}")

        adapter?.notifyDataSetChanged()

    }
}