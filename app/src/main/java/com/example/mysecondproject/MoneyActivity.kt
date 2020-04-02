package com.example.mysecondproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_money.*

class MoneyActivity : BaseActivity(0) {
    private val TAG = "MoneyActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_money)
        setupBottomNavigation()
        Log.d(TAG, "onCreate")

        findViewById<TextView>(R.id.sum_centre)
        val fishTv=sum_centre.text
        intent = Intent(this, AddActivity::class.java)

    }
}
