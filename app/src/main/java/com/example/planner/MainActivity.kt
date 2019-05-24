package com.example.planner

import android.content.ClipData
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.ValueEventListener
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

    var db = DBHandler(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()
        val itemList = findViewById<RecyclerView>(R.id.ItemsList)
        itemList.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?

        val items = db.readData() as ArrayList<Item>

        val adapter = CustomAdapter(items)
        itemList.adapter = adapter
    }

    override fun onPause() {
        super.onPause()
        if (isFinishing){
            val items = db.readData() as ArrayList<Item>
            updateFireBase(items)
        }
        //Toast.makeText(this, "pause", Toast.LENGTH_SHORT).show()
    }


    fun addItem (view: View){
        val addIntent = Intent(this, AddActivity::class.java)
        startActivity(addIntent)
    }

    fun finish (view: View){
        finish()
    }

    fun updateFireBase(items: ArrayList<Item>){

        FirebaseApp.initializeApp(applicationContext)
        var database = FirebaseDatabase.getInstance()
        var myRef = database.getReference("message")
        myRef.removeValue()
        for(item in items){
            myRef.push().setValue(item)
        }
        //Toast.makeText(this, "update", Toast.LENGTH_LONG).show()

    }


}
