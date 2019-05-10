package com.example.planner

class Item {

    var id: Int = 0
    var name: String = ""
    var desc: String = ""

    constructor(name: String, desc: String){
        this.name = name
        this.desc = desc
    }
    constructor(){
    }
}