package com.example.encodedecode

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val alphabet = arrayOf(
            "a",
            "b",
            "c",
            "d",
            "e",
            "f",
            "g",
            "h",
            "i",
            "j",
            "k",
            "l",
            "m",
            "n",
            "o",
            "p",
            "q",
            "r",
            "s",
            "t",
            "u",
            "v",
            "w",
            "x",
            "y",
            "z"
        )

        val inputsecret = findViewById<TextInputEditText>(R.id.messageedittext)
        val inputshift = findViewById<TextInputEditText>(R.id.shiftnumberet)
        val encode = findViewById<Button>(R.id.encode)
        val decode = findViewById<Button>(R.id.decode)


        encode.setOnClickListener {
            val result = mutableListOf<Char>()
            val secret = inputsecret.text.toString()
            val shift = inputshift.text.toString().toInt()

            for (letter in secret) {
                if (letter.lowercaseChar()
                        .toString() !in alphabet
                ) { // Convert Char to String for comparison
                    result.add(letter) // Add the letter to the result list
                }
                else {
                    val index_new_letter = (alphabet.indexOf(letter.lowercaseChar().toString()) + shift)
                    val new_letter = alphabet[index_new_letter].first()
                    result.add(new_letter)
                }
            }
            val code = result.joinToString("")
            val RevealCode = Intent(this, EncodeActivity::class.java)
            RevealCode.putExtra("CODE", code)
            startActivity(RevealCode)
        }

        decode.setOnClickListener {
            val result = mutableListOf<Char>()
            val secret = inputsecret.text.toString()
            val shift = inputshift.text.toString().toInt()

            for (letter in secret) {
                if (letter.lowercaseChar()
                        .toString() !in alphabet
                ) { // Convert Char to String for comparison
                    result.add(letter) // Add the letter to the result list
                }
                else {
                    val index_new_letter = (alphabet.indexOf(letter.lowercaseChar().toString()) - shift)
                    val new_letter = alphabet[index_new_letter].first()
                    result.add(new_letter)
                }
            }
            val codeDecode = result.joinToString("")
            val RevealSecret = Intent(this, DecodeActivity::class.java)
            RevealSecret.putExtra("CODEDECODE", codeDecode)
            startActivity(RevealSecret)
        }
    }
}




