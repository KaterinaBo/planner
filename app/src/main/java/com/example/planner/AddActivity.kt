package com.example.planner

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.io.IOException

class AddActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add2)

    }

    fun ok(view: View){
        val textName: TextView = findViewById(R.id.addName) as TextView
        val textDesc: TextView = findViewById(R.id.addText) as TextView

        if (textName.text.toString().isEmpty() || textDesc.text.toString().isEmpty()){
            Toast.makeText(this, "Заполните поля!", Toast.LENGTH_LONG).show()
        }
        else{
            val item = Item(textName.text.toString(), textDesc.text.toString())

            var db = DBHandler(this)
            db.insertData(item)
            finish()
        }

    }




}
