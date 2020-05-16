package com.example.mysecondproject

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import java.security.AccessControlContext

val DATABASE_NAME = "MyDB"
val TABLE_NAME = "Finance"
val COL_CATEGORY = "Category"
val COL_LOSS = "Loss"
val COL_INCOME= "Income"
val COL_DATE = "Date"
val COL_COMMENT= "Comment"
val COL_ID = "id"

class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,1) {
    override fun onCreate(db: SQLiteDatabase?) {

    val createTable = "CREATE TABLE " + TABLE_NAME +" (" +
            COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT," +
            COL_CATEGORY + " VARCHAR(256)," +
            COL_LOSS + " REAL," +
            COL_INCOME + " REAL," +
            COL_DATE + "DATETIME," +
            COL_COMMENT + "VARCHAR(256))";

    db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(field: Field){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_CATEGORY, field.Category)
        cv.put(COL_LOSS, field.Loss)
        cv.put(COL_INCOME, field.Income)
        cv.put(COL_DATE, field.Date)
        cv.put(COL_COMMENT, field.Comment)
        var result = db.insert(TABLE_NAME, null, cv)
        if(result == -1.toLong())
            Toast.makeText(context,"Failed!",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context,"Success",Toast.LENGTH_SHORT).show()
    }
}