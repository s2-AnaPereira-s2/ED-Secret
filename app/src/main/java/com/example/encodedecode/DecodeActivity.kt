package com.example.encodedecode

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DecodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_decode)

        val codeDecode: String? = intent.getStringExtra("CODEDECODE")
        val result_textview = findViewById<TextView>(R.id.result)
        result_textview.text = codeDecode


    }
}