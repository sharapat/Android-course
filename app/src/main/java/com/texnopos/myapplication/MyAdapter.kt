package com.texnopos.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var models: List<ListItem> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemViewType(position: Int): Int {
        return models[position].type
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view : View
        return if (viewType == ListItem.AD_TYPE) {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_ads, parent, false)
            AdViewHolder(view)
        } else {
            view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
            PostViewHolder(view)
        }
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (getItemViewType(position) == ListItem.AD_TYPE) {
            (holder as AdViewHolder).populateModel(models[position] as Ad)
        } else {
            (holder as PostViewHolder).populate(models[position] as PostList)
        }
    }
}