package com.texnopos.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val myAdapter: PostListAdapter = PostListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = myAdapter
        setData()
    }

    private fun setData() {
        val models: MutableList<List<Post>> = mutableListOf()
        for(i in 1..10) {
            val postList: MutableList<Post> = mutableListOf()
            for(i in 1..20) {
                postList.add(Post(i, "I am Post", "Description $i"))
            }
            models.add(postList)
        }
        myAdapter.models = models
    }

}
