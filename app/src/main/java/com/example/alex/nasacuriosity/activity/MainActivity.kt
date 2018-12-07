package com.example.alex.nasacuriosity.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.alex.nasacuriosity.App
import com.example.alex.nasacuriosity.R
import com.example.alex.nasacuriosity.common.PhotosAdapter
import com.example.alex.nasacuriosity.db.entity.Photo
import com.example.alex.nasacuriosity.db.mappers.toDbEntity
import com.example.alex.nasacuriosity.network.api.NasaApi
import com.example.alex.nasacuriosity.network.api.getApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

  private val nasaApi = getApi(NasaApi::class, NasaApi.BASE_URL)

  private val photoDao = App.getInstance().getDatabase().photoDao

  private val photos = mutableListOf<Photo>()
  private val adapter = PhotosAdapter(photos)

  private val disposable = CompositeDisposable()

  private lateinit var photosContent: RecyclerView
  private lateinit var refreshLayout: SwipeRefreshLayout

  companion object {
    const val TAG = "MainActivity"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    photosContent = findViewById(R.id.photo_list)
    refreshLayout = findViewById(R.id.swipe_refresh_photo_list)

    photosContent.layoutManager = LinearLayoutManager(this)
    photosContent.adapter = adapter
    refreshLayout.setOnRefreshListener { updatePhotos() }
    refreshLayout.setColorSchemeResources(android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light)
  }

  override fun onAttachedToWindow() {
    super.onAttachedToWindow()
    bind()
  }

  override fun onDetachedFromWindow() {
    super.onDetachedFromWindow()
    unbind()
  }

  private fun bind() {
    updatePhotos()
    showPhotos()
  }

  private fun unbind() {
    disposable.clear()
  }

  private fun updatePhotos() {
    disposable.add(
      nasaApi
        .photos()
        .map { jsonPhotos -> jsonPhotos.list.asSequence().map { it.toDbEntity() }.toList() }
        .flatMapCompletable { photos -> photoDao.insert(photos) }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnComplete { if (refreshLayout.isRefreshing) refreshLayout.isRefreshing = false }
        .subscribe({ Log.d(TAG, "Photos downloaded and saved to db") }, { Log.d(TAG, it.message) }))
  }

  private fun showPhotos() {
    disposable.add(
      photoDao
        .getAll()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe({ onPhotosUpdated(it) }, { Log.d(TAG, it.message) }))
  }

  private fun onPhotosUpdated(photos: List<Photo>) {
    this.photos.clear()
    this.photos.addAll(photos)
    adapter.notifyDataSetChanged()
  }
}
