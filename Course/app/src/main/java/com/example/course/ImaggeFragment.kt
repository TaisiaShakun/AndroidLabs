package com.example.course

import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener

class ImaggeFragment : Fragment(R.layout.fragment_imagge) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        setFragmentResultListener("imageFragment") { _, bundle ->
            val image = bundle.getInt("image")
            val imageView = view?.findViewById<ImageView>(R.id.imageView)
            imageView?.setImageResource(image)
        }
    }
}