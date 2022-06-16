package com.example.lab2_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab2_2.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button
        binding.TextWord
        binding.editText
        val words = arrayOf("Car", "Android","Mechanic")
        var getWord = ""
        binding.button.setOnClickListener {
            if(binding.TextWord.text == "Ready to start?" || getWord == binding.editText.text.toString()) {
                val Ran = Random.nextInt(0,words.size)
                getWord =  words[Ran]
                val word =String(getWord.toCharArray().toMutableList().shuffled().toCharArray())
                binding.TextWord.text = word
            }
        }
    }
}