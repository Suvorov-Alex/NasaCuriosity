package com.example.alex.nasacuriosity.viewmodel

import androidx.lifecycle.ViewModel
import com.example.alex.nasacuriosity.db.entity.Photo

class MainActivityViewModel : ViewModel() {
  private lateinit var photos: List<Photo>
}