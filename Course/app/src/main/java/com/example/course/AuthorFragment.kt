package com.example.course

import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener

class AuthorFragment : Fragment(R.layout.fragment_author) {
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState);

    setFragmentResultListener("AuthorFragment") { requestKey, bundle ->
        val name = bundle.getString("Author")
        view?.findViewById<TextView>(R.id.Author)?.text = name
    }
}
}