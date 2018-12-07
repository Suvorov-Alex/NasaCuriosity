package com.example.alex.nasacuriosity.network.api

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.reflect.KClass

fun <T : Any> getApi(apiClass: KClass<T>, baseUrl: String): T =
  Retrofit
    .Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .baseUrl(baseUrl)
    .build()
    .create(apiClass.java)