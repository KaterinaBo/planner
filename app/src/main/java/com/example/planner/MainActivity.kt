package com.example.planner

import android.content.ClipData
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val itemList = findViewById<RecyclerView>(R.id.ItemsList)
        itemList.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        val items = ArrayList<Item>()
        items.add(Item("1","Помыть пол"))
        items.add(Item("2","Сходить в магазин"))


        Toast.makeText(this,"create",Toast.LENGTH_LONG  ).show()

        val adapter = CustomAdapter(items)

        itemList.adapter = adapter

    }


}
