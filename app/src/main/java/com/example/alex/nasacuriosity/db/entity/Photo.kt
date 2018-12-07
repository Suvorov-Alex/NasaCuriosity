package com.example.alex.nasacuriosity.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo")
data class Photo(
  @PrimaryKey
  val id: Long,
  @ColumnInfo(name = "imageUrl")
  val imageUrl: String?
)