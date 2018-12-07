package com.example.alex.nasacuriosity.network.json.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Photos(
  @SerializedName("photos")
  @Expose
  val list: List<Photo>
)
