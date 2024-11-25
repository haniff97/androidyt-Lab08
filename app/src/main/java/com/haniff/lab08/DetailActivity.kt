package com.haniff.lab08

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.haniff.lab08.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.nameTextView.text = intent.getStringExtra("name")
        binding.numberTextView.text = intent.getStringExtra("phone")
        binding.SizeTextView.text = intent.getStringExtra("size")
        binding.sendButton.setOnClickListener {
            binding.ratingTextView.text = binding.ratingBar.rating.toString()

            Snackbar.make(view, "Thank you for your rating",
                Snackbar.LENGTH_LONG).setAction("OK"){
                print("User pressed ok!")}.show()

        }
        binding.DateTextView.text = intent.getStringExtra("date")
        binding.TimeTextView.text = intent.getStringExtra("time")

    }
}