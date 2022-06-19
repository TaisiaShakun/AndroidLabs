package com.example.lab51

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.add
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lab51.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.item_1 -> setCurrentFragment("#00FF00")
                R.id.item_2 -> setCurrentFragment("#FF0000")
                R.id.item_3 -> setCurrentFragment("#0000FF")
            }
            true
        }

        binding.bottomNavigationView.selectedItemId = R.id.item_1
    }

    private fun setCurrentFragment(hex: String) {
        supportFragmentManager.commit {
            replace(R.id.fragmentContainerView, ThirdFragment.newInstance(hex))
        }

    }
}