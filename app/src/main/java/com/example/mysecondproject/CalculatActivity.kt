package com.example.mysecondproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_calculat.*
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculat)

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
        btn_minus.setOnClickListener { setTextFields("-") }
        btn_plus.setOnClickListener { setTextFields("+") }
        btn_spliter.setOnClickListener { setTextFields("/") }
        btn_mulriplate.setOnClickListener { setTextFields("*") }
        btn_edgeLeft.setOnClickListener { setTextFields("(") }
        btn_edgeRight.setOnClickListener { setTextFields(")") }

        btn_ac.setOnClickListener {
            math_operation.text = ""
            result_text.text=""
        }

        btn_back.setOnClickListener {
            val str=math_operation.text.ToString()
            if(str.isNotEmpty()){
                math_operation.text=str.substring(0,str.lenght-1)

                result_text.text=""
            }
        }

        btn_equal.setOnClickListener {
            try {

                val ex = ExpressionBuilder(math_operation.text.ToString()).build()
                val result = ex.evaluate()

                val longres =result.ToLong()
                if(result==longres.ToDouble())
                    result_text.text= longres.ToString()
                else
                    result_text.text= result.ToString()

            } catch (e:Exeption){
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


