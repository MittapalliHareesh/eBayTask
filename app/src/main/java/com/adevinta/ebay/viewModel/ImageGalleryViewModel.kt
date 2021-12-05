package com.adevinta.ebay.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adevinta.ebay.model.ImageItem
import com.adevinta.ebay.repository.ImageGalleryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class ImageGalleryViewModel @Inject constructor(private val repository: ImageGalleryRepository) :
    ViewModel() {

    private val _imagesLiveData = MutableLiveData<List<ImageItem>>()
    val imagesLiveData: MutableLiveData<List<ImageItem>>
        get() = _imagesLiveData

    init {
        loadImages()
    }

    private fun loadImages() {
        viewModelScope.launch {
            imagesLiveData.value = repository.getImages().images
        }
    }
}