package com.adevinta.ebay.repository

import com.adevinta.ebay.api.ApiService
import javax.inject.Inject

class ImageGalleryRepository @Inject constructor(val apiService: ApiService) {

    suspend fun getImagesAPI() = apiService.getImages()
}