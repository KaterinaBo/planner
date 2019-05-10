package com.example.planner

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.list.*

class ActivityEdit : AppCompatActivity() {

    private var textEntered = ""
    private var nameEntered = ""
    private var index = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)


        val intentStarted: Intent = intent

        textEntered = intentStarted.getStringExtra("enteredText")
        nameEntered = intentStarted.getStringExtra("enteredName")
        index = intentStarted.getStringExtra("index")

        val textName: TextView  = findViewById(R.id.editName) as TextView
        val textDesc: TextView = findViewById(R.id.editText) as TextView

        textName.setText(nameEntered)
        textDesc.setText(textEntered)

    }

     fun editItem(view: View){
         val textName: TextView  = findViewById(R.id.editName) as TextView
         val textDesc: TextView = findViewById(R.id.editText) as TextView

         //val newItem = Item(textName.text.toString(), textDesc.text.toString())
         var db = DBHandler(this)

         //val items = db.readData() as ArrayList<Item>

         db.updateData(textDesc.text.toString(),textName.text.toString(),index)

         val editIntent = Intent(this, MainActivity::class.java)
         startActivity(editIntent)

    }

    fun delItem(view: View){
        var db = DBHandler(this)
        db.deleteData(index)
        val editIntent = Intent(this, MainActivity::class.java)
        startActivity(editIntent)

    }
}
