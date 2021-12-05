package com.adevinta.ebay.api

import com.adevinta.ebay.model.ResponseData
import retrofit2.http.GET

interface ApiService {

    @GET("328139645")
    suspend fun getImages(): ResponseData
}