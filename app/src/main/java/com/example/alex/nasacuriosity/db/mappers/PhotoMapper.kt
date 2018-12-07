package com.example.alex.nasacuriosity.db.mappers

import com.example.alex.nasacuriosity.network.json.entity.Photo
import com.example.alex.nasacuriosity.db.entity.Photo as PhotoDb

fun Photo.toDbEntity(): PhotoDb = PhotoDb((id).toLong(), imgSrc)