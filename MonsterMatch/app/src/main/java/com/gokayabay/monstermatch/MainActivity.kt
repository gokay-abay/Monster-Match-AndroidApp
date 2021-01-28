package com.gokayabay.monstermatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gokayabay.monstermatch.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

// entry point to the application
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setting the contect view as this layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.headImageView.setImageResource(R.drawable.monster2_head)
    }
}