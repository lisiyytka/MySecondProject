package com.example.mysecondproject

import android.annotation.SuppressLint
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
import android.widget.ArrayAdapter;
import android.widget.Spinner;


class AddActivity : AppCompatActivity() {
    private val TAG = "AddActivity"

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        Log.d(TAG, "onCreate")
        val text = intent.getStringExtra("text")
        val categoryName = findViewById<TextView>(R.id.category_text)
        categoryName.text = text
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
            val intent = Intent(this, MoneyActivity::class.java)
            val text = sum.text.toString()
            //val a = Transfer(categoryName.text.toString(),)

//            a.Category= categoryName.text.toString()
//            findViewById<TextView>(R.id.massageTextEdit)
//            a.Comment=massageTextEdit.text.toString()
            //intent.putExtra("sum", text)
            startActivity(intent)
        }

        back.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            startActivity(intent)
        }

        val arrayAdapter = ArrayAdapter.createFromResource(this, R.array.currencies,R.layout.spinner_item)
        current.adapter = arrayAdapter
    }

    fun setTextFields(str: String) {
        sum.append(str)
    }

}