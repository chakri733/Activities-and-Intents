package com.example.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val name = intent.getStringExtra("Name")
        val show = "$name"
        val textView: TextView = findViewById(R.id.textView)
        textView.text = show

        val surname: EditText = findViewById(R.id.surName)
        val button2: Button = findViewById(R.id.surnameButton)

        val sharedPreferences = getSharedPreferences("Preferences", MODE_PRIVATE)
        val edit = sharedPreferences.edit()

        val ssurname = sharedPreferences.getString("surname", null)
        surname.setText(ssurname)

        val button: Button = findViewById(R.id.button2)
        button.setOnClickListener {
            finish()
        }
        button2.setOnClickListener {
            val surName = surname.text.toString()
            edit.apply {
                putString("surname", surName)
                apply()
            }
            Intent(this, ThirdActivity::class.java).also {
                it.putExtra("SurName", surName)
                it.putExtra("Name", name)
                startActivity(it)
            }
        }
        val btn: Button = findViewById(R.id.insta)
        btn.setOnClickListener {
            val url = "https://www.instagram.com"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
    }
}