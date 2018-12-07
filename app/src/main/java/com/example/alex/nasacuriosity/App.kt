package com.example.alex.nasacuriosity

import android.app.Application
import com.example.alex.nasacuriosity.db.RoomDatabase

class App : Application() {

  companion object {
    private const val ROOM_DB_NAME = "nasa-curiosity-db-room"

    lateinit var app: App

    fun getInstance(): App = app
  }

  lateinit var db: RoomDatabase

  fun getDatabase(): RoomDatabase = db

  override fun onCreate() {
    super.onCreate()
    app = this
    db = RoomDatabase.create(this, ROOM_DB_NAME)
  }
}