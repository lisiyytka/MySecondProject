package com.example.mysecondproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class QrActivity : AppCompatActivity() {
    private val TAG = "QrActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qr)
        Log.d(TAG, "onCreate")
    }
}
