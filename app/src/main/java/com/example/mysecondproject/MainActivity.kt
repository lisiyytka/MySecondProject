package com.example.mysecondproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() { 

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun plusME(args: Array<String>){
        println("ВВедите значение")
        val s: String? = readLine()
        if (s!=null) {    }
    }

    fun stringg(view: View){
        val randomIntent = Intent(this, SecondaryArctivity::class.java)

    }
}

