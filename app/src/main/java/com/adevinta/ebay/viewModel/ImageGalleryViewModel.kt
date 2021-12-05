package com.adevinta.ebay.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.adevinta.ebay.repository.ImageGalleryRepository
import com.adevinta.ebay.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import retrofit2.HttpException
import java.lang.Exception
import javax.inject.Inject

/**
 * @HiltViewModel Indicates DI for ViewModel. All Hilt ViewModels are provided by the
 * ViewModelComponent which follows the same lifecycle as a ViewModel.
 */
@HiltViewModel
class ImageGalleryViewModel @Inject constructor(private val repository: ImageGalleryRepository) :
    ViewModel() {

    /**
     * It initiate call to APIService class to fetch response.
     * Response status either be any one the states SUCCESS or ERROR or LOADING. Based state data
     * will be populated to View.
     */
    fun getImages() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getImagesAPI().images))
        } catch (httpException: HttpException) {
            emit(
                Resource.error(
                    data = null,
                    message = getErrorMessage(httpException.code())
                )
            )
        } catch (exception: Exception) {
            emit(
                Resource.error(
                    data = null,
                    message = exception.message ?: "Error Occurred while fetching data!"
                )
            )
        }
    }

    private fun getErrorMessage(httpCode: Int): String {
        return when (httpCode) {
            401 -> "Accessing Unauthorised request"
            404 -> "Not Found.\n\nPlease validate the requested URL."
            500 -> "Server not found Error"
            else -> "Something went wrong!!"
        }
    }
}