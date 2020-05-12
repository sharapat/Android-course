package com.texnopos.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val adapter: ListAdapter = ListAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        setData(1)
    }

    private fun setData(count: Int) {
        val models: MutableList<User> = mutableListOf()
        for(i in 0 until count) {
            val model = User()
            model.title = "Title ${i+1}"
            model.description = "Description ${i+1}"
            models.add(model)
        }
        adapter.setData(models)
    }

    fun onOptionsButtonClick(view: View, position: Int) {
        val optionsMenu = PopupMenu(this, view)
        val menuInflater = optionsMenu.menuInflater
        menuInflater.inflate(R.menu.menu_item_options, optionsMenu.menu)
        optionsMenu.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.itemAdd -> {
                    val dialog = CustomDialog(this, this)
                    dialog.show()
                }
                R.id.itemDelete -> {
                    val dialog = AlertDialog.Builder(this)
                        .setTitle("Anıq óshirejaqsańba?")
                        .setMessage("Eger bul itemdı óshirseńiz onı qayta tikley almaysız")
                        .setPositiveButton("Awa"
                        ) { dialog, which ->
                            adapter.removeUser(position)
                        }
                        .setNegativeButton("Yaq") {
                            dialog, which ->
                            dialog.dismiss()
                        }
                    dialog.show()

                }
            }
            return@setOnMenuItemClickListener true
        }
        optionsMenu.show()
    }
}
