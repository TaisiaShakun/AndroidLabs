package com.example.lab51


import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lab51.databinding.ThirdfragmentBinding


class ThirdFragment : Fragment(R.layout.thirdfragment) {

    private lateinit var binding: ThirdfragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ThirdfragmentBinding.inflate(layoutInflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val colorString = arguments?.getString("color","#000000")
        val color = Color.parseColor(colorString)
        binding.layout.background = ColorDrawable(color)
    }

    companion object {
        fun newInstance(color: String): ThirdFragment {
            val args = Bundle()
            args.putString("color", color)

            val fragment = ThirdFragment()
            fragment.arguments = args
            return fragment
        }
    }
}