package com.texnopos.myapplication

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import kotlinx.android.synthetic.main.dialog_custom_add.*

class CustomDialog(context: Context, activity: MainActivity) : Dialog(context) {

    private val adapter = DialogListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom_add)
        recyclerView.adapter = adapter
        setData()
    }

    private fun setData() {
        val sanlar: MutableList<MyModel> = mutableListOf()
        for(i in 1..100) {
            sanlar.add(MyModel(i, false))
        }
        adapter.models = sanlar
    }
}