package com.ascedncorp.androidbasic

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ascedncorp.androidbasic.databinding.ActivitySecondBinding

class SecondActivity: AppCompatActivity() {

    companion object {
        const val EXTRA_TEXT = "SecondActivity:EXTRA_TEXT"

        fun newIntent(context: Context, text: String): Intent {
            return Intent(context, SecondActivity::class.java).apply {
                putExtra(EXTRA_TEXT, text)
            }
        }
    }

    private val text by lazy {
        intent.getStringExtra(EXTRA_TEXT)
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