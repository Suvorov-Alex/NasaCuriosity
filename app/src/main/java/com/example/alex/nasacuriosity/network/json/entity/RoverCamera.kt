package com.example.alex.nasacuriosity.network.json.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RoverCamera(
  @SerializedName("name")
  @Expose
  val name: String,
  @SerializedName("full_name")
  @Expose
  val fullName: String
)