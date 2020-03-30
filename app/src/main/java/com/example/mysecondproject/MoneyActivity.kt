package com.example.mysecondproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MoneyActivity : BaseActivity(0) {
    private val TAG = "MoneyActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_money)
        setupBottomNavigation()
        Log.d(TAG, "onCreate")
    }
}
