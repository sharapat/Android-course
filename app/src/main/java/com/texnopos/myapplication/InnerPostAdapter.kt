package com.texnopos.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_post.view.*

class InnerPostAdapter : RecyclerView.Adapter<InnerPostAdapter.InnerPostViewHolder>() {

    inner class InnerPostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(post: Post) {
            itemView.tvPost.text = post.description
        }
    }

    var posts: List<Post> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InnerPostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return InnerPostViewHolder(view)
    }

    override fun getItemCount(): Int = posts.size

    override fun onBindViewHolder(holder: InnerPostViewHolder, position: Int) {
        holder.populateModel(posts[position])
    }
}