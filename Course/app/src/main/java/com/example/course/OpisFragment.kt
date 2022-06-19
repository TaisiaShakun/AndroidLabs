package com.example.course

import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener

class OpisFragment : Fragment(R.layout.fragment_opis) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        setFragmentResultListener("OpisFragment") { requestKey, bundle ->
            val name = bundle.getString("Opis")
            view?.findViewById<TextView>(R.id.Opis)?.text = name
        }
    }
}