package com.ascedncorp.androidbasic

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ascedncorp.androidbasic.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private val binding: ActivitySecondBinding by lazy {
        ActivitySecondBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // The Preferences won't be shared between activities.
        val preferencesInput = getPreferences(Context.MODE_PRIVATE).getString(
            MainActivity.INPUT_TEXT_KEY,
            getString(R.string.second_activity_text)
        )
        binding.tvPreferences.text = String.format(
            getString(R.string.second_activity_preferences),
            preferencesInput
        )
        // The SharedPreferences will be shared to the whole application.
        val sharedPreferencesInput = getSharedPreferences(
            BuildConfig.APPLICATION_ID,
            Context.MODE_PRIVATE
        ).getString(
            Constant.GLOBAL_INPUT_CACHE_KEY,
            getString(R.string.second_activity_text)
        )
        binding.tvSharedPreferences.text = String.format(
            getString(R.string.second_activity_sharedpreferences),
            sharedPreferencesInput
        )
    }
}
