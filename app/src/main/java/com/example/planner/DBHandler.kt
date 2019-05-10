package com.example.planner

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "ItemDB"
val TABLE_NAME = "Items"
val COL_NAME = "name"
val COL_DESC = "desc"
val COL_ID = "id"


class DBHandler (var context: Context):SQLiteOpenHelper(context, DATABASE_NAME, null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + "(" +
                COL_ID + " INTEGER PRIMARY KEY,"+
                COL_NAME + " text," +
                COL_DESC + " text)"
        db?.execSQL(createTable)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(item : Item){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put(COL_NAME, item.name)
        cv.put(COL_DESC, item.desc)

        var result =  db.insert(TABLE_NAME, null,cv)

        if (result == -1.toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT ).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT ).show()
    }

    fun readData(): MutableList<Item>{
        var list : MutableList<Item> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME
        val result = db.rawQuery(query, null)

        if (result.moveToFirst()){
                do {

                    var item = Item()
                    item.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                    item.name = result.getString(result.getColumnIndex(COL_NAME))
                    item.desc = result.getString(result.getColumnIndex(COL_DESC))
                    list.add(item)
                } while(result.moveToNext())
            }
        result.close()
        db.close()
        return list
    }
}