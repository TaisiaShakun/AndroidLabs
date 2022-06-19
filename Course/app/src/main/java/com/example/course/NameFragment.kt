package com.example.course

import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener

class NameFragment : Fragment(R.layout.fragment_name) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        setFragmentResultListener("nameFragment") { requestKey, bundle ->
            val name = bundle.getString("name")
            view?.findViewById<TextView>(R.id.NameBook)?.text = name
        }
    }
}

