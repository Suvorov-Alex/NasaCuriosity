package com.example.alex.nasacuriosity.network.json.entity

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Rover(
  @SerializedName("photoId")
  @Expose
  val id: Int,
  @SerializedName("name")
  @Expose
  val name: String,
  @SerializedName("landing_date")
  @Expose
  val landingDate: String,
  @SerializedName("launch_date")
  @Expose
  val launchDate: String,
  @SerializedName("status")
  @Expose
  val status: String,
  @SerializedName("max_sol")
  @Expose
  val maxSol: Int,
  @SerializedName("max_date")
  @Expose
  val maxDate: String,
  @SerializedName("total_photos")
  @Expose
  val totalPhotos: Int,
  @SerializedName("cameras")
  @Expose
  val cameras: List<RoverCamera>
)