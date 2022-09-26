package com.ascedncorp.androidbasic

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ascedncorp.androidbasic.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("text", binding.edittext.text.toString())
            startActivity(intent)
        }
    }
}