package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val kitten = Cat()
        kitten.name = "Sally"
        kitten.age = 1
        kitten.type = "American Wirehair"

        var Sphinks = Cat("Vally", 4, "Spinks")
        println(Sphinks.HowOldCat() + kitten.HowOldCat())

        println("they have sumarry " + sumage(kitten.age , Sphinks.age).toString())
    }
    fun sumage(Age1:Int, Age2:Int):Int {
        return Age1 + Age2
    }

}