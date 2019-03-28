package com.mamicamp.tesyant.mamicamp.main

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.mamicamp.tesyant.mamicamp.R
import com.mamicamp.tesyant.mamicamp.model.DataDetail
import kotlinx.android.synthetic.main.item_list.view.*

class MainAdapter(val activity: Activity, val data: ArrayList<DataDetail>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(activity).inflate(
                R.layout.item_list,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(data[position])
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(detailDataDetail: DataDetail) {
            val url = detailDataDetail.image_url
            Glide
                .with(itemView.context)
                .load(url)
                .centerCrop()
                .into(itemView.img_kos)
            Log.e("Adapter", "masuk")
            itemView.tv_name.text = "Name : ${detailDataDetail.name}"
            itemView.tv_type.text = "Type : ${detailDataDetail.type}"
            itemView.tv_price.text = "Price : ${detailDataDetail.price}"
            itemView.tv_category.text = "Category : ${detailDataDetail.category}"
            Log.e("adapter", "ADAPTER OK")
        }
    }
}