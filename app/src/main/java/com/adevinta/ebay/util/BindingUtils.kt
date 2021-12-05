package com.adevinta.ebay.util

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.adevinta.ebay.R
import com.adevinta.ebay.model.ImageItem
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

@BindingAdapter("productsImage")
fun AppCompatImageView.setDrawableImage(imageData: ImageItem) {

    Glide.with(context)
        .load(AppConstants.https + imageData.uri + AppConstants.thumbnailImageSize)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(findViewById(R.id.itemImage))
}