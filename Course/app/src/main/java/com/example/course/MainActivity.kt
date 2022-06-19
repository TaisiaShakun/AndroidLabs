package com.example.course

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), CellClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(this, fetchList(), this)

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
    private fun fetchList(): ArrayList<Model> {
        val list = arrayListOf<Model>()
        val list_name_book = resources.getStringArray(R.array.book_name)
        val list_author = resources.getStringArray(R.array.author)
        for (i in 0..list_name_book.size-1) {
            val model = Model(i, list_name_book[i], list_author[i], R.drawable.book2,list_name_book[i] +   " by " + list_author[i])
            list.add(model)
        }
        return list
    }

    override fun onCellClickListener(Book: Model) {

        val i = Intent(this, BookActivity::class.java).apply{
           val b = Bundle()
            b.putSerializable("serialzable",Book )
            putExtras(b)
        }
        startActivity(i)

    }
}