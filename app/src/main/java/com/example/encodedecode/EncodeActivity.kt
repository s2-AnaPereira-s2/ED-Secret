package com.example.encodedecode

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class EncodeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_encode)

        val code = intent.getStringExtra("CODE")
        val codeDecode: String? = intent.getStringExtra("CODEDECODE")

        if (code != null) {
            val result_textview = findViewById<TextView>(R.id.result)
            result_textview.text = code
        }
        else if (codeDecode != null) {
            val result_textview = findViewById<TextView>(R.id.result)
            result_textview.text = codeDecode
        }
    }
}