package com.example.lab1

class Cat (){
    var name: String = ""
    var age: Int = 0
    var type: String = ""

    constructor(name: String, age: Int, type:String) : this() {
        this.name = name
        this.age = age
        this.type = type
    }
   fun HowOldCat():String{
        if(age > 3) {
            return name + " Old "
        }
        else {
            return name + " Young "
        }
    }
}
