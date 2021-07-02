package com.example.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreferences = getSharedPreferences("Preferences", MODE_PRIVATE)
        val edit = sharedPreferences.edit()
        val name1: EditText = findViewById(R.id.editname)
        val button: Button = findViewById(R.id.button)

        val name = sharedPreferences.getString("name", null)
        name1.setText(name)

        button.setOnClickListener {
            val name = name1.text.toString()
            edit.apply {
            putString("name", name)
                apply()
            }
            Intent(this, SecondActivity::class.java).also {
                it.putExtra( "Name", name)
                startActivity(it)
            }
        }
        val btn: Button = findViewById(R.id.google)

        btn.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"))
            startActivity(i)
        }

        val gal: Button = findViewById(R.id.gallery)
        gal.setOnClickListener {
            val intent = Intent()
            intent.action = Intent.ACTION_PICK
            intent.type = "image/*"
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}