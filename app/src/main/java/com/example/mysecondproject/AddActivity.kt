package com.example.mysecondproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_money.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class AddActivity : BaseActivity(2) {
    private val TAG = "AddActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        setupBottomNavigation()
        Log.d(TAG, "onCreate")
        btn_plus.setOnClickListener { setTextFields("+") }
        btn_multiply.setOnClickListener { setTextFields("*") }
        btn_divide.setOnClickListener { setTextFields("/") }
        btn_minus.setOnClickListener { setTextFields("-") }
        btn_0.setOnClickListener { setTextFields("0") }
        btn_1.setOnClickListener { setTextFields("1") }
        btn_2.setOnClickListener { setTextFields("2") }
        btn_3.setOnClickListener { setTextFields("3") }
        btn_4.setOnClickListener { setTextFields("4") }
        btn_5.setOnClickListener { setTextFields("5") }
        btn_6.setOnClickListener { setTextFields("6") }
        btn_7.setOnClickListener { setTextFields("7") }
        btn_8.setOnClickListener { setTextFields("8") }
        btn_9.setOnClickListener { setTextFields("9") }
        btn_dott.setOnClickListener { setTextFields(".") }

        btn_delete.setOnClickListener {
            val str=sum.text.toString()
            if(str.isNotEmpty()){
                sum.text=str.substring(0,str.length-1)
            }
    }


        //Основнаые действия калькулятора
        btn_equals.setOnClickListener {
            try {
                val ex = ExpressionBuilder(sum.text.toString()).build()//библиотека калькулятора
                val result = ex.evaluate()
                val longres =result.toLong()// Убирание 0 после точки
                if(result==longres.toDouble())
                    sum.text= longres.toString()
                else
                    sum.text= result.toString()

            } catch (e:Exception){
                Log.d("Ошибка","Сообщение: ${e.message}")
            }

        }

        check.setOnClickListener {
            val sumRetr = sum.text.toString()
            val intent = Intent(this@AddActivity, MoneyActivity::class.java)
            intent.putExtra("sum",sumRetr.toString())
            startActivity(intent)
        }

    }

    fun setTextFields(str: String) {
        sum.append(str)
    }

}

