package com.example.planner

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

 class CustomAdapter(private val itemList: ArrayList<Item> ) :RecyclerView.Adapter<CustomAdapter.ViewHolder>(){



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.list, p0, false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return itemList.size

    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val item:Item = itemList[p1]


        p0?.textViewName?.text = item.name
        p0?.textViewDesc?.text = item.desc
    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){


        val textViewDesc = itemView.findViewById(R.id.textViewDesc) as TextView
        val textViewName = itemView.findViewById(R.id.textViewName) as TextView

        init{
            itemView.setOnClickListener {

                val textEntered: String = textViewDesc.text as String
                val nameEntered: String = textViewName.text as String
               // val indexV = index as String


                val addIntent = Intent(itemView.context, ActivityEdit::class.java)
                addIntent.putExtra("enteredText", textEntered)
                addIntent.putExtra("enteredName", nameEntered)

                itemView.context.startActivity(addIntent)

            }
        }




    }

}