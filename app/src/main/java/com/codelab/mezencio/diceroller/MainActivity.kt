package com.codelab.mezencio.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val resultText: TextView = findViewById(R.id.tv_result_text)

        val rollButton: Button = findViewById(R.id.btn_roll)
        rollButton.setOnClickListener { rollDice(resultText) }

        val countUpButton: Button = findViewById(R.id.btn_count_up)
        countUpButton.setOnClickListener { countUp(resultText) }
    }

    private fun rollDice(resultText: TextView) {
//        Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show()
        val randomInt = (1..6).random()
        resultText.text = randomInt.toString()
    }

    private fun countUp(resultText: TextView) {
        if (resultText.text == "Hello World!") {
            resultText.text = "1"
            return
        }
        if (resultText.text == "6") {
            return
        }
        resultText.text = (resultText.text.toString().toInt().plus(1)).toString()
    }
}