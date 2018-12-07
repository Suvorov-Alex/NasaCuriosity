package com.example.alex.nasacuriosity.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import com.example.alex.nasacuriosity.db.dao.PhotoDao
import com.example.alex.nasacuriosity.db.entity.Photo
import androidx.room.RoomDatabase as RoomDb

@Database(entities = [Photo::class], version = 1)
abstract class RoomDatabase : RoomDb() {

  abstract val photoDao: PhotoDao

  companion object {
    fun create(context: Context, name: String): RoomDatabase =
      Room
        .databaseBuilder(context, RoomDatabase::class.java, name)
        .build()
  }

}