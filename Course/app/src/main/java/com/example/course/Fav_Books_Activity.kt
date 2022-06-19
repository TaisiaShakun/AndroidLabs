package com.example.course

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File

class Fav_Books_Activity : AppCompatActivity(), CellClickListener {
    var Books = arrayListOf<Model>()
    var favorites: List<Int> = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fav_books)
        val actionbar = supportActionBar
        actionbar!!.title = "Favorite Books"
        actionbar.setDisplayHomeAsUpEnabled(true)
        val favoritesService = FavoritesService(this)
        favorites = favoritesService.get()

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(this, fetchList(), this)

    }
    override fun onCellClickListener(Book: Model) {

        val i = Intent(this, BookActivity::class.java).apply{
            val b = Bundle()
            b.putSerializable("serialzable",Book )
            putExtras(b)
        }
        startActivity(i)

    }

    private fun fetchList(): ArrayList<Model> {
        val list = arrayListOf<Model>()
        val list_name_book = resources.getStringArray(R.array.book_name)
        val list_author = resources.getStringArray(R.array.author)
        for (i in favorites) {
            val model = Model(i, list_name_book[i], list_author[i], i)
            Books.add(model)
        }
        return Books
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}