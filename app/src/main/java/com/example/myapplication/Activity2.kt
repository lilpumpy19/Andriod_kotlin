package com.example.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlin.random.Random

class Activity2 : AppCompatActivity() {

    private lateinit var changeBackButton: Button
    private lateinit var goButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val name = intent.getStringExtra("name")
        val age = intent.getStringExtra("age")
        val male = intent.getStringExtra("male")
        changeBackButton = findViewById(R.id.changeBackButton)
        goButton = findViewById(R.id.goButton)

        findViewById<TextView>(R.id.name).append(name)
        findViewById<TextView>(R.id.age).append(age)
        findViewById<TextView>(R.id.male).append(male)

        changeBackButton.setOnClickListener {
            changeBackgroundColor(it)
        }

        goButton.setOnClickListener {
            var intent = android.content.Intent(this, ScrollingActivity::class.java)
            startActivity(intent)
        }


    }

    private fun changeBackgroundColor(view:View) {
        val randomColor = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
        view.rootView.setBackgroundColor(randomColor)
    }
}