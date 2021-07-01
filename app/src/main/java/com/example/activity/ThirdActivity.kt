package com.example.activity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        val surname: TextView = findViewById(R.id.surName)
        val SurName = intent.getStringExtra("SurName")
        val Name = intent.getStringExtra("Name")
        val show = "$SurName $Name"

        surname.text = show
        val button: Button = findViewById(R.id.button3)

        button.setOnClickListener {
            onDestroy()
        }

    }
}