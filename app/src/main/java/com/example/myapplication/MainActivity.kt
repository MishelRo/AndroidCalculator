package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_0.setOnClickListener { setTextField("0") }
        btn_1.setOnClickListener { setTextField("1") }
        btn_2.setOnClickListener { setTextField("2") }
        btn_3.setOnClickListener { setTextField("3") }
        btn_4.setOnClickListener { setTextField("4") }
        btn_5.setOnClickListener { setTextField("5") }
        btn_6.setOnClickListener { setTextField("6") }
        btn_7.setOnClickListener { setTextField("7") }
        btn_8.setOnClickListener { setTextField("8") }
        btn_9.setOnClickListener { setTextField("9") }

        btn_LScope.setOnClickListener{ setTextField("(") }
        btn_RScope.setOnClickListener{ setTextField(")") }
        btn_DelButt.setOnClickListener{ setTextField("/")}
        btn_UmnButt.setOnClickListener{ setTextField("*") }
        btn_PlusButt.setOnClickListener{ setTextField("+") }
        btn_MinusButt.setOnClickListener{ setTextField("-") }
        com.setOnClickListener{ setTextField(".")}
        btn_AC.setOnClickListener {
            math_operation.text = ""
            result_text.text = ""
        }
        btn_back.setOnClickListener{ val str = math_operation.text.toString()
            if(str.isNotEmpty()) {
                math_operation.text = str.substring(0, str.length -1)
            }
            result_text.text = ""
        }

        btn_schore.setOnClickListener{
try {
    val ex = ExpressionBuilder(math_operation.text.toString()).build()
    val result = ex.evaluate()
    val longres = result.toLong()
    if (result == longres.toDouble()) {
        result_text.text = longres.toString()
    } else {
        result_text.text = result.toString()
    }
} catch(e: Exception) {
    Log.d("Error", "${e.message}")

}
        }
    }

    fun setTextField(str: String) {
     val item =  math_operation.lineCount
math_operation.append(str)
    }
    fun deleteLastItem(){

    }
}