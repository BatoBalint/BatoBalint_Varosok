package com.example.varosok

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DB_NAME = "varosok"
val TABLE_NAME = "varos"
val COL_ID = "id"
val COL_NEV = "name"
val COL_ORSZAG = "country"
val COL_LAKOSSAG = "population"

class DBHelper(var context: Context) : SQLiteOpenHelper(context, DB_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        var query = "CREATE TABLE $TABLE_NAME (" +
                "$COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COL_NEV VARCHAR(60), " +
                "$COL_ORSZAG VARCHAR(60), " +
                "$COL_LAKOSSAG INTEGER)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertVaros(v : Varos) {
        var db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NEV, v.nev)
        cv.put(COL_ORSZAG, v.orszag)
        cv.put(COL_LAKOSSAG, v.lakossag)
        var result = db.insert(TABLE_NAME, null, cv)
        if (result == null) {
            Toast.makeText(context, "Sikertelen felvetel", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Sikeres felvetel", Toast.LENGTH_SHORT).show()
        }
    }

    fun getVaros(orszag : String) : ArrayList<String> {
        var list : ArrayList<String> = ArrayList()

        var db = this.readableDatabase
        var query = "$COL_ORSZAG = '$orszag'"
        var results = db.query(TABLE_NAME, null, query, null, null, null, null, null)

        if(results.moveToFirst()) {
            do {
                var nev = results.getString(1)
                list.add(nev)
            } while (results.moveToNext())
        }
        results.close()
        db.close()
        return list
    }
}