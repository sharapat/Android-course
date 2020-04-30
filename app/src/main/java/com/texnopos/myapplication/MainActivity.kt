package com.texnopos.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter: ListAdapter = ListAdapter(this)
    private val models: MutableList<User> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        setData(0, 1)
    }

    private fun setData(size: Int, count: Int) {
        for(i in size until count+size) {
            val model = User()
            model.title = "Title ${i+1}"
            model.description = "Description ${i+1}"
            models.add(model)
        }
        adapter.setData(models)
    }

    fun onItemClicked(size: Int, position: Int) {
        setData(size, position+1)
    }

    fun onOptionsButtonClick(view: View) {
        val optionsMenu = PopupMenu(this, view)
        val menuInflater = optionsMenu.menuInflater
        menuInflater.inflate(R.menu.menu_item_options, optionsMenu.menu)
        optionsMenu.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.itemAdd -> {

                }
                R.id.itemDelete -> {
                    Toast.makeText(this, "ItemDeleteClicked", Toast.LENGTH_LONG).show()
                }
            }
            return@setOnMenuItemClickListener true
        }
        optionsMenu.show()
    }
}
