package com.example.mysecondproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add_category.*

class AddCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_category)

        ic_supermarket.setOnClickListener {
            val intent = Intent(this@AddCategory, AddActivity::class.java)
            val sumRetr = text_supermarket.text.toString()
            intent.putExtra("supermarket",sumRetr)
            startActivity(intent) }

        ic_cafe_food.setOnClickListener {
            val intent = Intent(this@AddCategory, AddActivity::class.java)
            val sumRetr = text_cafe.text.toString()
            intent.putExtra("supermarket",sumRetr)
            startActivity(intent) }

        ic_car.setOnClickListener {
            val intent = Intent(this@AddCategory, AddActivity::class.java)
            val sumRetr = text_car.text.toString()
            intent.putExtra("supermarket",sumRetr)
            startActivity(intent) }

        ic_health.setOnClickListener {
            val intent = Intent(this@AddCategory, AddActivity::class.java)
            val sumRetr = text_health.text.toString()
            intent.putExtra("supermarket",sumRetr)
            startActivity(intent) }

        ic_cigarettes.setOnClickListener {
            val intent = Intent(this@AddCategory, AddActivity::class.java)
            val sumRetr = text_cigarettes.text.toString()
            intent.putExtra("supermarket",sumRetr)
            startActivity(intent) }

        ic_clothes.setOnClickListener {
            val intent = Intent(this@AddCategory, AddActivity::class.java)
            val sumRetr = text_cloth.text.toString()
            intent.putExtra("supermarket",sumRetr)
            startActivity(intent) }

        ic_education.setOnClickListener {
            val intent = Intent(this@AddCategory, AddActivity::class.java)
            val sumRetr = text_education.text.toString()
            intent.putExtra("supermarket",sumRetr)
            startActivity(intent) }

        ic_entertainment.setOnClickListener {
            val intent = Intent(this@AddCategory, AddActivity::class.java)
            val sumRetr = text_entertainment.text.toString()
            intent.putExtra("supermarket",sumRetr)
            startActivity(intent) }

        ic_house.setOnClickListener {
            val intent = Intent(this@AddCategory, AddActivity::class.java)
            val sumRetr = text_house.text.toString()
            intent.putExtra("supermarket",sumRetr)
            startActivity(intent)
        }

        ic_petrol.setOnClickListener {
            val intent = Intent(this@AddCategory, AddActivity::class.java)
            val sumRetr = text_petrol.text.toString()
            intent.putExtra("supermarket",sumRetr)
            startActivity(intent)
        }

        ic_hobby.setOnClickListener {
            val intent = Intent(this@AddCategory, AddActivity::class.java)
            val sumRetr = text_entertainment.text.toString()
            intent.putExtra("supermarket",sumRetr)
            startActivity(intent)
        }

        ic_spa.setOnClickListener {
            val intent = Intent(this@AddCategory, AddActivity::class.java)
            val sumRetr = text_spa.text.toString()
            intent.putExtra("supermarket",sumRetr)
            startActivity(intent)
        }

        ic_home_appliances.setOnClickListener {
            val intent = Intent(this@AddCategory, AddActivity::class.java)
            val sumRetr = text_tech.text.toString()
            intent.putExtra("supermarket",sumRetr)
            startActivity(intent)
        }

        ic_pets.setOnClickListener {
            val intent = Intent(this@AddCategory, AddActivity::class.java)
            val sumRetr = text_animal.text.toString()
            intent.putExtra("supermarket",sumRetr)
            startActivity(intent)
        }

        ic_relaxation.setOnClickListener {
            val intent = Intent(this@AddCategory, AddActivity::class.java)
            val sumRetr = text_relax.text.toString()
            intent.putExtra("supermarket",sumRetr)
            startActivity(intent)
        }

        ic_sport.setOnClickListener {
            val intent = Intent(this@AddCategory, AddActivity::class.java)
            val sumRetr = text_sport.text.toString()
            intent.putExtra("supermarket",sumRetr)
            startActivity(intent)
        }

        ic_money.setOnClickListener {
            val intent = Intent(this@AddCategory, AddActivity::class.java)
            val sumRetr = text_pay.text.toString()
            intent.putExtra("supermarket",sumRetr)
            startActivity(intent)
        }

        ic_unexpected_spending.setOnClickListener {
            val intent = Intent(this@AddCategory, AddActivity::class.java)
            val sumRetr = text_unexpected_spending.text.toString()
            intent.putExtra("supermarket",sumRetr)
            startActivity(intent)
        }

        ic_no_category.setOnClickListener {
            val intent = Intent(this@AddCategory, AddActivity::class.java)
            val sumRetr = text_no_category.text.toString()
            intent.putExtra("supermarket",sumRetr)
            startActivity(intent)
        }
    }
}
