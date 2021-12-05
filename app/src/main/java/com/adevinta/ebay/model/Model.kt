package com.adevinta.ebay.model

data class ResponseData(
    val images: List<ImageItem>
)

data class ImageItem(
    val set: String,
    val uri: String
)