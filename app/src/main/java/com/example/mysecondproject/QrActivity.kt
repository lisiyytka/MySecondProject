package com.example.mysecondproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class QrActivity : BaseActivity(1) {
    private val TAG = "QrActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr)
        setupBottomNavigation()
        Log.d(TAG, "onCreate")
    }
}
