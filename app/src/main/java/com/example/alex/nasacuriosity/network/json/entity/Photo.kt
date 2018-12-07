package com.example.alex.nasacuriosity.network.json.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Photo(
  @SerializedName("id")
  @Expose
  val id: Int,
  @SerializedName("sol")
  @Expose
  val sol: Int,
  @SerializedName("camera")
  @Expose
  val camera: Camera,
  @SerializedName("img_src")
  @Expose
  val imgSrc: String,
  @SerializedName("earth_date")
  @Expose
  val earthDate: String,
  @SerializedName("rover")
  @Expose
  val rover: Rover
)