package com.example.mysecondproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : BaseActivity(2) {
    private val TAG = "AddActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setupBottomNavigation()
        Log.d(TAG, "onCreate")
    }
}
