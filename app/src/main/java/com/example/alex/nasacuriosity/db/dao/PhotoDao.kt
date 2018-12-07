package com.example.alex.nasacuriosity.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.alex.nasacuriosity.db.entity.Photo
import io.reactivex.Completable
import io.reactivex.Observable

@Dao
interface PhotoDao {
  @Query("SELECT * FROM photo")
  fun getAll(): Observable<List<Photo>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(photos: List<Photo>): Completable
}