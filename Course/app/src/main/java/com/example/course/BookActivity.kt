package com.example.course

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf


class BookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_book)
        val actionbar = supportActionBar

        var Book = intent.getSerializableExtra("serialzable") as Model?
        val name: String = Book!!.name
        actionbar!!.title = name
        actionbar.setDisplayHomeAsUpEnabled(true)

        supportFragmentManager.setFragmentResult("nameFragment", bundleOf("name" to Book.name))
        supportFragmentManager.setFragmentResult("AuthorFragment", bundleOf("Author" to Book.author))
        supportFragmentManager.setFragmentResult("OpisFragment", bundleOf("Opis" to Book.opis))
        supportFragmentManager.setFragmentResult("bottomFragment", bundleOf("id" to Book.id))
        supportFragmentManager.setFragmentResult("imageFragment", bundleOf("image" to Book.image))
    }






    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_activity_actions, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_fav  -> {
            val i = Intent(this, Fav_Books_Activity::class.java)
            startActivity(i)
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}