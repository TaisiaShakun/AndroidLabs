package com.example.lab6

import Model
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), CellClickListener {
    private var colors : Array<String> = arrayOf("#FF2D00", "#FFE300", "#16FF00", "#00FFE5", "#0036FF", "#8D00FF", "#F500FF", "#FF0076", "#FF8900", "#AEFF00")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = GridLayoutManager(this,3)
        recyclerView.adapter = Adapter(this, fetchList(), this)
    }

    private fun fetchList(): ArrayList<Model> {
        val list = arrayListOf<Model>()

        for (i in 0..100) {
            val model = Model( i, colors[i % 10])
            list.add(model)
        }
        return list
    }

    override fun onCellClickListener(number: String) {
        val dialog = ExampleDialog(number)
        dialog.show(supportFragmentManager, "dlg")
        //Toast.makeText(this,number, Toast.LENGTH_SHORT).show()
    }
}