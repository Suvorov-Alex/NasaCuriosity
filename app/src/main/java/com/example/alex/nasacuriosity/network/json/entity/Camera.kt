package com.example.alex.nasacuriosity.network.json.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Camera(
  @SerializedName("photoId")
  @Expose
  val id: Int,
  @SerializedName("name")
  @Expose
  val name: String,
  @SerializedName("rover_id")
  @Expose
  val roverId: Int,
  @SerializedName("full_name")
  @Expose
  val fullName: String
)