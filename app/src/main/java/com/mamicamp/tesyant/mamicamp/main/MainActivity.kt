package com.mamicamp.tesyant.mamicamp.main

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.github.kittinunf.fuel.httpGet
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mamicamp.tesyant.mamicamp.R
import com.mamicamp.tesyant.mamicamp.api.RoomApi
import com.mamicamp.tesyant.mamicamp.model.DataDetail
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var kosAdapter: MainAdapter? = null
    private val data: ArrayList<DataDetail> = arrayListOf()
    val gson = Gson()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val list = findViewById<RecyclerView>(R.id.kos_list)
        kosAdapter = MainAdapter(this, data)
        list.adapter = kosAdapter
        list.layoutManager = LinearLayoutManager(this)
        getRoomList()


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

    }

    fun getRoomList() {
        RoomApi.getData()
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

        kosAdapter?.notifyDataSetChanged()

    }

}
