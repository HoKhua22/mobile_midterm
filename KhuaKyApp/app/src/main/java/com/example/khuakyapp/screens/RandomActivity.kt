package com.example.khuakyapp.screens

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.khuakyapp.R
import kotlin.random.Random

lateinit var imageView: ImageView
lateinit var button: Button

val cardImages: IntArray = intArrayOf(
  R.drawable.food1,
  R.drawable.food2,
  R.drawable.food3,
  R.drawable.food4,
  R.drawable.food5,
  R.drawable.food6,
  R.drawable.fish,
  R.drawable.meat,
  R.drawable.bread
)

class RandomActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_random)

    imageView = findViewById(R.id.imageView)
    button = findViewById(R.id.button)

    button.setOnClickListener {
      val random = Random
      imageView.setImageResource(cardImages[random.nextInt(cardImages.size)])
    }
  }
}

