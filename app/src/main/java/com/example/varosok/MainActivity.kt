package com.example.varosok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var keresBtn : Button
    lateinit var felvetelBtn : Button
    lateinit var varosET : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    fun init() {
        keresBtn = findViewById(R.id.btnKeres)
        felvetelBtn = findViewById(R.id.btnFelvetel)
        varosET = findViewById(R.id.varosET)

        keresBtn.setOnClickListener { keresBtnClick() }
        felvetelBtn.setOnClickListener { felvetelBtnClick() }
    }

    fun keresBtnClick() {
        if (!varosET.text.isEmpty()) {
            var keres = Intent(this, SearchResultActivity::class.java)
            keres.putExtra("orszag", varosET.text.toString())
            startActivity(keres)
            finish()
        } else {
            Toast.makeText(this, "Nem maradhat ures az orszag mezo", Toast.LENGTH_LONG).show()
        }
    }

    fun felvetelBtnClick() {
        var felvetel = Intent(this, InsertActivity::class.java)
        startActivity(felvetel)
        finish()
    }
}