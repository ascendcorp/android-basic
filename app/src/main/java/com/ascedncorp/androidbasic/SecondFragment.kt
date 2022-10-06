package com.ascedncorp.androidbasic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ascedncorp.androidbasic.databinding.FragmentMainBinding
import com.ascedncorp.androidbasic.databinding.FragmentSecondBinding

class SecondFragment: Fragment() {

    private lateinit var binding: FragmentSecondBinding

    companion object {
        const val EXTRA_TEXT = "SecondFragment:EXTRA_TEXT"

        fun newInstance(text: String) = SecondFragment().apply {
            arguments = Bundle().apply {
                putString(EXTRA_TEXT, text)
            }
        }
    }

    private val text by lazy {
        arguments?.getString(EXTRA_TEXT)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textview.text = text
    }
}