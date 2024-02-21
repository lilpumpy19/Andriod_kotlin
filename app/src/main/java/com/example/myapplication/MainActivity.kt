package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var maleRadioButton: RadioButton
    private lateinit var femaleRadioButton: RadioButton
    private lateinit var clearButton: Button
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.nameEditText)
        ageEditText = findViewById(R.id.ageEditText)
        maleRadioButton = findViewById(R.id.maleRadioButton)
        femaleRadioButton = findViewById(R.id.femaleRadioButton)
        clearButton = findViewById(R.id.clearButton)
        submitButton = findViewById(R.id.submitButton)

        clearButton.setOnClickListener {
            clearFields()
        }

        submitButton.setOnClickListener {
            val intent = android.content.Intent(this, Activity2::class.java)
            intent.putExtra("name", nameEditText.text.toString())
            intent.putExtra("age", ageEditText.text.toString())
            intent.putExtra("male", if (maleRadioButton.isChecked) "male" else "female")
            startActivity(intent)
        }
    }

    private fun clearFields() {
        nameEditText.text.clear()
        ageEditText.text.clear()
        maleRadioButton.isChecked = true
    }
}