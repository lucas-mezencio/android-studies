package com.codelabs.mezencio.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var boxThree: TextView
    private lateinit var boxFour: TextView
    private lateinit var boxFive: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        boxThree = findViewById(R.id.tv_box_three)
        boxFour = findViewById(R.id.tv_box_four)
        boxFive = findViewById(R.id.tv_box_five)

        setListeners()
    }

    private fun makeColored(view: View) {
        when (view.id) {
            R.id.tv_box_one -> view.setBackgroundColor(Color.DKGRAY)
            R.id.tv_box_two -> view.setBackgroundColor(Color.GRAY)
            R.id.tv_box_three -> view.setBackgroundColor(Color.BLUE)
            R.id.tv_box_four -> view.setBackgroundColor(Color.MAGENTA)
            R.id.tv_box_five -> view.setBackgroundColor(Color.BLUE)

            R.id.red_button -> boxThree.setBackgroundResource(R.color.my_red)
            R.id.yellow_button -> boxFour.setBackgroundResource(R.color.my_yellow)
            R.id.green_button -> boxFive.setBackgroundResource(R.color.my_green)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    private fun setListeners() {
        val boxOneText = findViewById<TextView>(R.id.tv_box_one)
        val boxTwoText = findViewById<TextView>(R.id.tv_box_two)
        val boxThreeText = findViewById<TextView>(R.id.tv_box_three)
        val boxFourText = findViewById<TextView>(R.id.tv_box_four)
        val boxFiveText = findViewById<TextView>(R.id.tv_box_five)

        val rootConstraintLayout = findViewById<View>(R.id.constraint_layout)

        val redButton = findViewById<Button>(R.id.red_button)
        val greenButton = findViewById<Button>(R.id.green_button)
        val yellowButton = findViewById<Button>(R.id.yellow_button)

        val clickableViews: List<View> =
            listOf(boxOneText, boxTwoText, boxThreeText,
                boxFourText, boxFiveText, rootConstraintLayout,
                redButton, greenButton, yellowButton
            )

        for (item in clickableViews) {
            item.setOnClickListener(this::makeColored)
        }
    }
}