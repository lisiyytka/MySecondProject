package com.example.mysecondproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class SettingsActivity : BaseActivity(3) {
    private val TAG = "SettingsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        setupBottomNavigation()
        Log.d(TAG, "onCreate")
    }
}
