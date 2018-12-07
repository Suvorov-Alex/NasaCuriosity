package com.example.alex.nasacuriosity.network.api

import com.example.alex.nasacuriosity.network.json.entity.Photos
import io.reactivex.Single
import retrofit2.http.GET


interface NasaApi {
  companion object {
    const val BASE_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/"
  }

  @GET("photos?sol=1000&page=2&api_key=DEMO_KEY")
  fun photos(): Single<Photos>
}
//https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY
//https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&page=2&api_key=DEMO_KEY