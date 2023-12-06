package com.kkotto.firststepskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.kkotto.firststepskotlin.extensions.loadFromSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView: ImageView = this.findViewById(R.id.displayed_image)
        val inputField: TextView = this.findViewById(R.id.search_input_field)
        val searchButton: Button = this.findViewById(R.id.search_button)
        val clearButton: Button = this.findViewById(R.id.clear_button)

        searchButton.setOnClickListener {
            if (inputField.text.isNotEmpty()) {
                imageView.loadFromSource(inputField.text.toString())
            } else {
                val toast = Toast.makeText(this, "URL is empty...", Toast.LENGTH_SHORT)
                toast.show()
            }
        }

        clearButton.setOnClickListener {
            inputField.text = ""
        }
    }
}