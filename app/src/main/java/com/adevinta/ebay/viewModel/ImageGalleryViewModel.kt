package com.adevinta.ebay.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.adevinta.ebay.repository.ImageGalleryRepository
import com.adevinta.ebay.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class ImageGalleryViewModel @Inject constructor(private val repository: ImageGalleryRepository) :
    ViewModel() {

    fun getImages() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getImages().images))
        } catch (exception: Exception) {
            emit(
                Resource.error(
                    data = null,
                    message = exception.message ?: "Error Occurred while fetching data!"
                )
            )
        }
    }
}