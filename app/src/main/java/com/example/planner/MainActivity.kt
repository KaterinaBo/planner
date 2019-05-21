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





class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val itemList = findViewById<RecyclerView>(R.id.ItemsList)
        itemList.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?

        FirebaseApp.initializeApp(this)
        var database = FirebaseDatabase.getInstance()
        var myRef = database.getReference("message")

        myRef.setValue("Hello, World!")


/*
        // Read from the database
        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = dataSnapshot.getValue(String::class.java)
                Log.d("name", "Value is: " + value!!)
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                //Log.w(FragmentActivity.TAG, "Failed to read value.", error.toException())
            }
        })*/
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
