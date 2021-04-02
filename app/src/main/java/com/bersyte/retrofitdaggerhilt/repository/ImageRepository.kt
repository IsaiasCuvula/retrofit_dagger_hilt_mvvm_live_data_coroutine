package com.bersyte.retrofitdaggerhilt.repository

import com.bersyte.retrofitdaggerhilt.api.ImageService
import javax.inject.Inject

class ImageRepository
@Inject
constructor(private val api: ImageService) {

    suspend fun getAllImages() = api.getAllImages()

}