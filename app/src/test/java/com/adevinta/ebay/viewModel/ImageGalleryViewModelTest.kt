package com.adevinta.ebay.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.adevinta.ebay.model.ImageItem
import com.adevinta.ebay.model.ResponseData
import com.adevinta.ebay.repository.ImageGalleryRepository
import com.adevinta.ebay.util.Resource
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.*

@ObsoleteCoroutinesApi
@ExperimentalCoroutinesApi
@DelicateCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ImageGalleryViewModelTest {

    private lateinit var imageGalleryViewModel: ImageGalleryViewModel

    @Mock
    private lateinit var imageGalleryRepository: ImageGalleryRepository

    @Mock
    private lateinit var imageObserver: Observer<Resource<List<ImageItem>>>

    @Mock
    private lateinit var responseData: ResponseData

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
        runBlocking {
            whenever(imageGalleryRepository.getImagesAPI()).thenReturn(responseData)
        }
        imageGalleryViewModel = ImageGalleryViewModel(imageGalleryRepository)
    }


    @Test
    fun `when getImages is called , then observer is updated with success`() {
        runBlocking {
            imageGalleryViewModel.getImages().observeForever(imageObserver)
            delay(10)
            verify(imageObserver, timeout(50)).onChanged(Resource.loading(null))
            verify(imageObserver, timeout(50)).onChanged(Resource.success(responseData.images))
        }
    }


    @Test
    fun `when getImages is called , then observer is updated without any response`() {
        runBlocking {
            imageGalleryViewModel.getImages().observeForever(imageObserver)
            delay(10)
            verify(imageObserver, timeout(50)).onChanged(Resource.loading(null))
        }
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }
}