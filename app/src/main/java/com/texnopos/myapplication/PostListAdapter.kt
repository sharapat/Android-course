package com.texnopos.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class PostListAdapter : RecyclerView.Adapter<PostListAdapter.PostListViewHolder>() {
    inner class PostListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val adapter = InnerPostAdapter()

        fun populateModel(postList: List<Post>) {
            itemView.innerList.adapter = adapter
            adapter.posts = postList
        }
    }

    var models: List<List<Post>> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return PostListViewHolder(view)
    }

    override fun getItemCount(): Int = models.size

    override fun onBindViewHolder(holder: PostListViewHolder, position: Int) {
        holder.populateModel(models[position])
    }
}