package com.example.course
import java.io.Serializable
import android.widget.ImageView

class Model(val id : Int,
            val name : String,
            val author : String,
            val image : Int? = null,
            val opis : String = "") : Serializable