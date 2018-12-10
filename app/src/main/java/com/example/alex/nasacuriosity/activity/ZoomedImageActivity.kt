package com.example.alex.nasacuriosity.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.alex.nasacuriosity.R
import com.github.chrisbanes.photoview.PhotoView
import com.squareup.picasso.Picasso


class ZoomedImageActivity : AppCompatActivity() {
  private var photoView: PhotoView? = null

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_zoomed_image)

    supportActionBar?.hide()

    photoView = findViewById(R.id.full_size_image)

    val imageUrl = intent.getStringExtra("Image_URL")
    Picasso.get()
      .load(imageUrl)
      .placeholder(R.drawable.placeholder)
      .into(photoView)
  }
}