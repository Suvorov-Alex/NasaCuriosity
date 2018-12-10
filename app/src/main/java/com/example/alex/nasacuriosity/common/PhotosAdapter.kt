package com.example.alex.nasacuriosity.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alex.nasacuriosity.R
import com.example.alex.nasacuriosity.db.entity.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cardview.view.photo_title
import kotlinx.android.synthetic.main.cardview.view.photo_view

class PhotosAdapter(
  private val photos: List<Photo>
) : RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {

  override fun getItemCount(): Int = photos.size

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
    return PhotoViewHolder(view)
  }

  override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
   /* val photoId = photos[position].id
    holder.photoId.text = photoId.toString()*/

    val photoImage = photos[position].imageUrl
    Picasso.get()
      .load(photoImage)
      .placeholder(R.drawable.placeholder)
      .into(holder.photoImage)
  }

  class PhotoViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val photoImage: ImageView = view.photo_view
    val photoId: TextView = view.photo_title
  }
}

