package com.texnopos.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DialogListAdapter : RecyclerView.Adapter<DialogItemViewHolder>() {

    var selectedItemPosition: Int = -1
        set(value) {
            if (field != -1) {
                models[selectedItemPosition].isSelected = false
                notifyItemChanged(field)
            }
            field = value
            notifyItemChanged(value)
        }

    var models: List<MyModel> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DialogItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_dialog, parent, false)
        return DialogItemViewHolder(itemView, this)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: DialogItemViewHolder, position: Int) {
        holder.populateModel(models[position], position)
    }
}
