package com.example.varosok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView

class SearchResultActivity : AppCompatActivity() {
    lateinit var backBtn : Button
    lateinit var listView : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)

        init()
    }

    fun init() {
        backBtn = findViewById(R.id.btnVisszaAtSearch)
        listView = findViewById(R.id.listViewAtSearch)

        backBtn.setOnClickListener { backBtnClick() }
    }

    fun backBtnClick() {
        var main = Intent(this, MainActivity::class.java)
        startActivity(main)
        finish()
    }
}