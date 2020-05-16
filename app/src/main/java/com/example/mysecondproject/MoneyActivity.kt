package com.example.mysecondproject

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_add.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_money.*
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import org.w3c.dom.Comment
import java.sql.Date


class MoneyActivity :AppCompatActivity() {
    private val TAG = "MoneyActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_money)
        Log.d(TAG, "onCreate")
//        var intent = intent
//        val sumTv = intent.getStringExtra("sum")
//
        val sumCentre = findViewById<TextView>(R.id.sum_centre)

        //suka
        val arrayAdapter = ArrayAdapter.createFromResource(this, R.array.periods,R.layout.spinner_item_period)
        period.adapter = arrayAdapter

        add_btn.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            startActivity(intent)
        }

        app_settings.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
    }
}







/**
 * Created by Eyehunt Team on 07/06/18.
 */
class Transfer(
    category: String,
    loss: Int,
    income: Int,
    date: Int,
    comment: String
)
{
    val id: Int = 0
    var Category: String = category
    var Loss: Int = loss
    var Income: Int = income
    var Date: Int = date
    var Comment: String = comment
}

class DatabaseHandler(context: Context) :
    SQLiteOpenHelper(context, DB_NAME, null, DB_VERSIOM) {

    companion object {
        private val DB_NAME = "ControlBudget"
        private val DB_VERSIOM = 1;
        private val TABLE_NAME = "Transactions"
        private val ID = "id"
        private val CATEGORY = "Category"
        private val LOSS = "Loss"
        private val INCOME = "Income"
        private val DATA = "Data"
        private val COMMENT = "Comment"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = "CREATE TABLE $TABLE_NAME " +
                "($ID Integer AUTO_INCREMENT, $CATEGORY TEXT, $LOSS Money, $INCOME Money, $DATA DATETIME, $COMMENT TEXT)"
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        // Called when the database needs to be upgraded
    }

    //Inserting (Creating) data
    fun addTransfer(transfer: Transfer): Boolean {
        //Create and/or open a database that will be used for reading and writing.
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(CATEGORY, transfer.Category)
        values.put(LOSS, transfer.Loss)
        values.put(INCOME, transfer.Income)
        values.put(DATA, transfer.Date)
        values.put(COMMENT, transfer.Comment)
        val _success = db.insert(TABLE_NAME, null, values)
        db.close()
        Log.v("InsertedID", "$_success")
        return (Integer.parseInt("$_success") != -1)
    }

    //get all users
//    fun getAllUsers(): String {
//        var allUser: String = "";
//        val db = readableDatabase
//        val selectALLQuery = "SELECT * FROM $TABLE_NAME"
//        val cursor = db.rawQuery(selectALLQuery, null)
//        if (cursor != null) {
//            if (cursor.moveToFirst()) {
//                do {
//                    var id = cursor.getString(cursor.getColumnIndex(ID))
//                    var firstName = cursor.getString(cursor.getColumnIndex(FIRST_NAME))
//                    var lastName = cursor.getString(cursor.getColumnIndex(LAST_NAME))
//
//                    allUser = "$allUser\n$id $firstName $lastName"
//                } while (cursor.moveToNext())
//            }
//        }
//        cursor.close()
//        db.close()
//        return allUser
//    }

}