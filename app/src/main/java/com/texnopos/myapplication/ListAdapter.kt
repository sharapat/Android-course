package com.texnopos.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val activity: MainActivity) : RecyclerView.Adapter<ListViewHolder>() {

    private var models: MutableList<User> = mutableListOf()

    fun setData(data: MutableList<User>) {
        models = data
        notifyDataSetChanged()
    }

    fun addUser(position: Int, title: String, description: String) {
        models.add(position, User(title, description))
        notifyItemInserted(position)
        notifyItemRangeChanged(position, models.size)
    }

    fun removeUser(position: Int) {
        models.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, models.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ListViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.populateModel(models[position], itemCount, position, activity)
    }
}