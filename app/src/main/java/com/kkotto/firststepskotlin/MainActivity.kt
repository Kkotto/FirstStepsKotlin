package com.kkotto.firststepskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.kkotto.firststepskotlin.extensions.loadFromSource
import java.io.FileNotFoundException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView: ImageView = this.findViewById(R.id.displayed_image)
        val inputField: TextView = this.findViewById(R.id.search_input_field)
        val searchButton: Button = this.findViewById(R.id.search_button)
        val clearButton: Button = this.findViewById(R.id.clear_button)

        searchButton.setOnClickListener {
            handleSearchButtonListener(inputField.text.toString(), imageView)
        }

        clearButton.setOnClickListener {
            inputField.text = ""
        }
    }

    private fun handleSearchButtonListener(inputField: String, imageView: ImageView) {
        try {
            if (inputField.isNotEmpty()) {
                imageView.loadFromSource(inputField)
            } else {
                showToast("URL is empty...")
            }
        } catch (exception: FileNotFoundException) {
            showToast("File's not found...")
        }
    }

    private fun showToast(message: String) {
        val toast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
        toast.show()
    }
}