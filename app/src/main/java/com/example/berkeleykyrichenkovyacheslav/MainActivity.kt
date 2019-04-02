package com.example.berkeleykyrichenkovyacheslav

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    private var points = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pickRandomNumbers()
    }

    private fun checkIfCorrectAnswer(isLeft: Boolean) {
        val leftButton = findViewById<Button>(R.id.left_button)
        val rightButton = findViewById<Button>(R.id.right_button)
        val leftNumber = leftButton.text.toString().toInt()
        val rightNumber = rightButton.text.toString().toInt()
        if (isLeft && leftNumber > rightNumber || !isLeft && leftNumber < rightNumber) {
            points++
            Toast.makeText(this, "You got it!", Toast.LENGTH_SHORT).show()

        } else {
            points--
            Toast.makeText(this, "UC Davis my still take you.", Toast.LENGTH_SHORT).show()
        }
        findViewById<TextView>(R.id.points).text = "Points $points"
        pickRandomNumbers()
    }

    fun leftButtonClick(viev: View) {
        checkIfCorrectAnswer(true)
    }

    fun rightButtonClick(viev: View) {
        checkIfCorrectAnswer(false)
    }

    private fun pickRandomNumbers() {
        val leftButton = findViewById<Button>(R.id.left_button)
        val rightButton = findViewById<Button>(R.id.right_button)
        val r = Random()
        val num1 = r.nextInt(10)
        var num2 = num1
        while (num1 == num2) {
            num2 = r.nextInt(10)
        }
        leftButton.text = "$num1"
        rightButton.text = "$num2"
    }
}
