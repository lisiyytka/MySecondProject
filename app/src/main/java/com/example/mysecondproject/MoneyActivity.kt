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

class MoneyActivity :AppCompatActivity() {
    private val TAG = "MoneyActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_money)
        Log.d(TAG, "onCreate")
        var intent = intent
        val sumTv = intent.getStringExtra("sum")

        val sumCentre = findViewById<TextView>(R.id.sum_centre)
        sumCentre.text="$"+sumTv

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
