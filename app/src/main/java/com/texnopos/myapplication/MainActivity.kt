package com.texnopos.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter: MyAdapter = MyAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        setData()
    }

    private fun setData() {
        val models: MutableList<ListItem> = mutableListOf()
        for(i in 1..100) {
            if (i%5==0) {
                val reklama = Ad(ListItem.AD_TYPE, "", "", "")
                models.add(reklama)
            } else {
                val posts : MutableList<Post> = mutableListOf()
                for(j in 1..10) {
                    val post = Post("", "")
                    posts.add(post)
                }
                val postList = PostList(ListItem.POST_TYPE, posts)
                models.add(postList)
            }
        }
        adapter.models = models
    }
}
