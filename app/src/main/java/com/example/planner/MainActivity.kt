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

        //var item = Item("1", "Gjvsnm gjk")

        var db = DBHandler(this)
        //db.insertData(item)

        val items = db.readData() as ArrayList<Item>

       // val items = ArrayList<Item>()
       // items.add(Item("2","Сходить в магазин"))


        Toast.makeText(this,"create",Toast.LENGTH_LONG  ).show()

        val adapter = CustomAdapter(items)

        itemList.adapter = adapter
    }

    fun addItem (view: View){
        val addIntent = Intent(this, AddActivity::class.java)
        startActivity(addIntent)
    }

}
