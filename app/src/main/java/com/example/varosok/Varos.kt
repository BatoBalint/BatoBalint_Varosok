package com.example.varosok

class Varos {
    var id = 0
    var nev = ""
    var orszag = ""
    var lakossag = 0

    constructor(id :Int, nev :String, orszag :String, lakossag :Int) {
        this.id = id
        this.nev = nev
        this.orszag = orszag
        this.lakossag = lakossag
    }

    constructor(nev :String, orszag :String, lakossag :Int) {
        this.nev = nev
        this.orszag = orszag
        this.lakossag = lakossag
    }

    override fun toString(): String {
        return "$id: $nev, $orszag, $lakossag"
    }
}