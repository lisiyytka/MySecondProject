package com.example.mysecondproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.title = "Back"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        var intent = intent
        val finishRes = intent.getStringExtra("resu")
        //textView
        val resultTv = findViewById<TextView>(R.id.textView_finish_result)
        //setText
        resultTv.text=finishRes
        var resultTv1 = "123"
        findViewById<Button>(R.id.edit_btn)
        //возврат значения в math_operation и старт калькулятора
        edit_btn.setOnClickListener {

            val resultIntent= Intent(this@MainActivity, AddActivity::class.java)
            intent.putExtra("qweer", resultTv1.toString())
            startActivity(resultIntent)

        }
    }
}

