package com.example.course

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.fragment.app.setFragmentResultListener

class BottomFragment : Fragment(R.layout.fragment_bottom) {
    private var _id : Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setFragmentResultListener("bottomFragment") { _, bundle ->
            _id = bundle.getInt("id")
            val favoritesService = context?.let { FavoritesService(it) }
            val favorites = favoritesService?.get()
            val button2 = view?.findViewById<Button>(R.id.button3)
            val button1 = view?.findViewById<Button>(R.id.button2)
            if(favorites?.contains(_id) == true) {
                button1?.isEnabled = false;
            } else {
                button2?.isEnabled = false;
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button2 = view.findViewById<Button>(R.id.button3)
        val button1 = view.findViewById<Button>(R.id.button2)

        val favoritesService = context?.let { FavoritesService(it) }
        button1?.setOnClickListener {
            button1.isEnabled = false
            button2.isEnabled = true
            favoritesService?.add(_id)
        }
        button2?.setOnClickListener {
            button2.isEnabled = false
            button1.isEnabled = true
            favoritesService?.remove(_id)
        }
    }
}