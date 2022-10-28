package com.ascedncorp.androidbasic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ascedncorp.androidbasic.databinding.FragmentMainBinding

class MainFragment: Fragment() {

    private lateinit var binding: FragmentMainBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Get a preferences file of this activity
        val preferences = activity?.getPreferences(Context.MODE_PRIVATE)
        val sharedPreferences = activity?.getSharedPreferences(
            BuildConfig.APPLICATION_ID,
            Context.MODE_PRIVATE
        )
        // Get last input value
        binding.edittext.setText(preferences?.getString(MainActivity.INPUT_TEXT_KEY, null))
        // Set buttons' actions
        binding.button.setOnClickListener {
            // Save the value when this button was clicked
            preferences?.edit()?.apply {
                putString(MainActivity.INPUT_TEXT_KEY, binding.edittext.text?.toString() ?: "")
                apply()
            }
            sharedPreferences?.edit()?.apply {
                putString(MainActivity.INPUT_TEXT_KEY, binding.edittext.text?.toString() ?: "")
                apply()
            }
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.container, SecondFragment.newInstance(binding.edittext.text.toString()))
                .addToBackStack(null)
                .commit()
        }
        binding.buttonSecondActivity.setOnClickListener {
            startActivity(Intent(requireActivity(), SecondActivity::class.java))
        }
    }
}
