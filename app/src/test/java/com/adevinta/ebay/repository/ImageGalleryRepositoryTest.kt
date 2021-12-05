package com.adevinta.ebay.repository

import com.adevinta.ebay.api.ApiService
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify

@RunWith(MockitoJUnitRunner::class)
class ImageGalleryRepositoryTest {

    private lateinit var imageGalleryRepository: ImageGalleryRepository

    @Mock
    private lateinit var apiService: ApiService

    @Before
    fun setUp() {
        imageGalleryRepository = ImageGalleryRepository(apiService)
    }

    @Test
    fun `whenever we call getImagesAPI, it should call getImages fun in ApiService`() {
        runBlocking {
            imageGalleryRepository.getImagesAPI()
            verify(apiService).getImages()
        }
    }
}