package com.example.mysecondproject

import android.content.Intent
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_money.*
import kotlinx.android.synthetic.main.bottom_navigation_view.*

abstract class BaseActivity(val navNumber: Int) : AppCompatActivity(){
    private val TAG = "BaseActivity"
    fun setupBottomNavigation(){
        bottom_navigation_view.setIconSize(29f, 29f)
        bottom_navigation_view.setTextVisibility(false)
        bottom_navigation_view.enableItemShiftingMode(false)
        bottom_navigation_view.enableShiftingMode(false)
        bottom_navigation_view.enableAnimation(false)
        for(i in 0 until bottom_navigation_view.menu.size()){
            bottom_navigation_view.setIconTintList(i, null)
        }
        bottom_navigation_view.setOnNavigationItemSelectedListener {
            val nextActivity =
                when(it.itemId) {
                    R.id.nav_item_money -> MoneyActivity::class.java
                    R.id.nav_item_qr -> QrActivity::class.java
                    R.id.nav_item_add -> AddCategory::class.java
                    R.id.nav_item_settings -> SettingsActivity::class.java
                    else -> {
                        Log.e(TAG, "unknown nav item clicked $it")
                        null
                    }
                }
            if(nextActivity != null){
         //       val fdfadf = findViewById<TextView>(R.id.nav_item_add)
//                if (nextActivity == fdfadf)
//                {
//                    findViewById<TextView>(R.id.sum_centre)
//                    val sumCentreFin = sum_centre.text.toString()
//                    val intent = Intent(this@BaseActivity, AddActivity::class.java)
//                    intent.putExtra("sumCentreFin",sumCentreFin.toString())
//                    startActivity(intent)
//                }
                val intent = Intent(this, nextActivity)
                intent.flags= Intent.FLAG_ACTIVITY_NO_ANIMATION
                startActivity(intent)
                overridePendingTransition(0,0)
                true
            } else {
                false
            }
        }
        bottom_navigation_view.menu.getItem(navNumber).isChecked = true
    }

    //fun transFin(){
   //     findViewById<TextView>(R.id.sum_centre)
    //    val sumCentreFin = sum_centre.text.toString()
   //     val intent = Intent(this@BaseActivity, AddActivity::class.java)
    //    intent.putExtra("sumCentreFin",sumCentreFin.toString())
    //    startActivity(intent)
   // }
}