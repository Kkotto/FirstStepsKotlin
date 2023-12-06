package com.kkotto.firststepskotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.toast_button).setOnClickListener {
            val toast = Toast.makeText(
                this,
                findViewById<TextView>(R.id.text_view).text,
                Toast.LENGTH_SHORT
            )
            toast.show()
        }

        findViewById<Button>(R.id.count_button).setOnClickListener {
            val nextValue = convertTextViewToInt(this) + 1
            findViewById<TextView>(R.id.text_view).text = nextValue.toString()
        }

        findViewById<Button>(R.id.random_button).setOnClickListener {
            val random = java.util.Random()
            val upperBound = convertTextViewToInt(this)
            val randomNumber = random.nextInt(upperBound + 1)
            findViewById<TextView>(R.id.text_view).text = randomNumber.toString()
        }

    }

    private fun convertTextViewToInt(view: MainActivity) =
        view.findViewById<TextView>(R.id.text_view).text.toString().toInt()
}