package com.ascedncorp.androidbasic

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ascedncorp.androidbasic.databinding.ActivitySecondBinding

class SecondActivity: AppCompatActivity() {

    private val text by lazy {
        intent.getStringExtra("text")
    }

    private val binding: ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.textview.text = text
    }
}