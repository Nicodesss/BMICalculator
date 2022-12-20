package com.example.bmicalculator

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var resultHealth:String = ""
    var healthRange:String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val height = findViewById<EditText>(R.id.edtHeight)
        val weight = findViewById<EditText>(R.id.edtWeight)
        val check = findViewById<Button>(R.id.btnCheck)
        val result = findViewById<TextView>(R.id.txtCalculate)
        val health = findViewById<TextView>(R.id.txtHealth)
        val range = findViewById<TextView>(R.id.txtRange)



        check.setOnClickListener { onClicked ->
            val bmiResult:Double = weight.text.toString().toDouble()/ ((height.text.toString().toDouble()/100)*(height.text.toString().toDouble()/100))
            val bmi = String.format("%.2f", bmiResult).toDouble()
            result.text = bmi.toString()

            healthyCheck(bmi,health)
            health.text = resultHealth
            range.text = healthRange
        }
    }


    fun healthyCheck(bmi:Double, health:TextView){
        when{
            bmi <= 18.4 ->{
                resultHealth = "Underweight"
                healthRange = "Underweight range is <= 18.4"
                health.setTextColor(Color.parseColor("#FF8000"))
            }
            bmi in 18.5..24.9 ->{
                resultHealth = "Normal"
                healthRange = "Normal range is 18.5 - 24.9"
                health.setTextColor(Color.parseColor("#00FF00"))
            }
            bmi in 25.0..39.9 -> {
                resultHealth = "Overweight"
                healthRange = "Overweight range is 25.0 - 39.9"
                health.setTextColor(Color.parseColor("#FF8000"))

            }
            bmi >= 40 ->
            {
                resultHealth = "Obese"
                healthRange = "Obese range is >= 40.0"
                health.setTextColor(Color.parseColor("#FF0000"))

            }
        }
    }

}