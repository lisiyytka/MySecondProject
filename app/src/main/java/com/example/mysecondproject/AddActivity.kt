package com.example.mysecondproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_add.btn_0
import kotlinx.android.synthetic.main.activity_add.btn_1
import kotlinx.android.synthetic.main.activity_add.btn_2
import kotlinx.android.synthetic.main.activity_add.btn_3
import kotlinx.android.synthetic.main.activity_add.btn_4
import kotlinx.android.synthetic.main.activity_add.btn_5
import kotlinx.android.synthetic.main.activity_add.btn_6
import kotlinx.android.synthetic.main.activity_add.btn_7
import kotlinx.android.synthetic.main.activity_add.btn_8
import kotlinx.android.synthetic.main.activity_add.btn_9
import kotlinx.android.synthetic.main.activity_add.btn_minus
import kotlinx.android.synthetic.main.activity_add.btn_plus
import kotlinx.android.synthetic.main.activity_calculat.*
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
        btn_ac.setOnClickListener {
            result_text.text=""
        }
        btn_delete.setOnClickListener {
            val str=math_operation.text.toString()
            if(str.isNotEmpty()){
                math_operation.text=str.substring(0,str.length-1)

                result_text.text=""
            }
        }
        //Основнаые действия калькулятора
        btn_equal.setOnClickListener {
            try {
                val ex = ExpressionBuilder(math_operation.text.toString()).build()//библиотека калькулятора
                val result = ex.evaluate()
                val longres =result.toLong()// Убирание 0 после точки
                if(result==longres.toDouble())
                    result_text.text= longres.toString()
                else
                    result_text.text= result.toString()

                //Отправка данных в MainActivity
                //val intent = Intent(this@CalculateActivity, MainActivity::class.java)
                //intent.putExtra("resu", result.toString())
                //startActivity(intent)

            } catch (e: Exception){
                Log.d("Ошибка","Сообщение: ${e.message}")
            }

        }

    }

    fun setTextFields(str: String) {
        if(result_text.text!="") {
            math_operation.text = result_text.text
            result_text.text=""
        }

        math_operation.append(str)
    }
}

