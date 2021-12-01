package com.example.varosok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class InsertActivity : AppCompatActivity() {
    lateinit var backBtn : Button
    lateinit var insertBtn : Button
    lateinit var nev : EditText
    lateinit var orszag : EditText
    lateinit var lakossag : EditText
    lateinit var db : DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        init()
    }

    fun init() {
        backBtn = findViewById(R.id.btnVisszaAtInsert)
        insertBtn = findViewById(R.id.btnFelvetelAtInsert)
        nev = findViewById(R.id.nevEtAtInsert)
        orszag = findViewById(R.id.orszagEtAtInsert)
        lakossag = findViewById(R.id.lakossagEtAtInsert)

        db = DBHelper(this)

        backBtn.setOnClickListener { backBtnClick() }
        insertBtn.setOnClickListener { insertBtnClick() }
    }

    fun backBtnClick() {
        var main = Intent(this, MainActivity::class.java)
        startActivity(main)
        finish()
    }

    fun insertBtnClick() {
        var nevText = nev.text.toString()
        var orszagText = orszag.text.toString()
        var lakossagText = lakossag.text.toString()
        if (lakossagText.trim() == "") {
            lakossagText = 0.toString()
            lakossag.setText(0)
        }
        if (nevText != "" && orszagText != "") {
            var v = Varos(nevText, orszagText, lakossagText.toInt())
            db.insertVaros(v)
        } else {
            Toast.makeText(this, "Minden mezot ki kell tolteni", Toast.LENGTH_SHORT).show()
        }

    }
}