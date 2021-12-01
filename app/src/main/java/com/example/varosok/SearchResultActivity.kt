package com.example.varosok

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class SearchResultActivity : AppCompatActivity() {
    lateinit var backBtn : Button
    lateinit var listView : ListView
    lateinit var list : ArrayList<String>
    lateinit var adap : ArrayAdapter<String>
    lateinit var search : String
    lateinit var db : DBHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)
        search = intent.getStringExtra("orszag") ?: ""

        init()

        listView.adapter = adap
    }

    fun init() {
        backBtn = findViewById(R.id.btnVisszaAtSearch)
        listView = findViewById(R.id.listViewAtSearch)

        db = DBHelper(this)

        list = db.getVaros(search)
        if (list.size == 0) {
            list.add("Nem található rekord a következő adattal: $search")
        }
        adap = ArrayAdapter(this, R.layout.my_list_item, list)
        listView.adapter = adap

        backBtn.setOnClickListener { backBtnClick() }
    }

    fun backBtnClick() {
        var main = Intent(this, MainActivity::class.java)
        startActivity(main)
        finish()
    }
}