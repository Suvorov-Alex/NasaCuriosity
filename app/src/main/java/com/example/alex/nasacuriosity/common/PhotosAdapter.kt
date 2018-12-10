package com.example.alex.nasacuriosity.common

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.alex.nasacuriosity.R
import com.example.alex.nasacuriosity.activity.ZoomedImageActivity
import com.example.alex.nasacuriosity.db.entity.Photo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.cardview.view.*

class PhotosAdapter(
    private val photos: List<Photo>,
    private var onItemClickListener: View.OnClickListener? = null
) : RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder>() {

    override fun getItemCount(): Int = photos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return PhotoViewHolder(view).withListener { pos, _ ->
            val intent = Intent(parent.context, ZoomedImageActivity::class.java)
            intent.putExtra("Image_URL", photos[pos].imageUrl)
            parent.context.startActivity(intent)
        }
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

    fun <T : RecyclerView.ViewHolder> T.withListener(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener {
            event.invoke(adapterPosition, itemViewType)
        }
        return this
    }
}

