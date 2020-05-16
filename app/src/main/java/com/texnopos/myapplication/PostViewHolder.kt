package com.texnopos.myapplication

import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val adapter = InnerAdapter()

    fun populate(model: PostList) {
        itemView.innerList.adapter = adapter
        adapter.models = model.posts
        itemView.innerList.addItemDecoration(DividerItemDecoration(itemView.context, DividerItemDecoration.HORIZONTAL))
    }
}