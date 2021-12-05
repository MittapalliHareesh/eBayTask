package com.adevinta.ebay.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adevinta.ebay.model.ImageItem
import com.adevinta.ebay.adapter.ImageGalleryAdapter.ViewHolder
import com.adevinta.ebay.databinding.ImageItemBinding

class ImageGalleryAdapter(private val listener: OnImageClickListener) :
    ListAdapter<ImageItem, ViewHolder>(ImageDataDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val imageItemBinding = ImageItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(imageItemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    class ViewHolder(private val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(imageItem: ImageItem, listener: OnImageClickListener) {
            binding.imageItem = imageItem
            binding.clickListener = listener
            binding.executePendingBindings()
        }
    }

    interface OnImageClickListener {
        fun onImageClick(imageItem: ImageItem)
    }
}

class ImageDataDiffCallback : DiffUtil.ItemCallback<ImageItem>() {
    /**
     * This method will be called to check whether old and new items are the same.
     * @param oldItem Indicates model class
     * @param newItem Indicates model class
     */
    override fun areItemsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
        return oldItem.uri == newItem.uri
    }

    /**
     * This method will be called to check whether old and new items represent the same item visually.
     * This will only be called when areItemsTheSame() returns true.
     * @param oldItem Indicates model class
     * @param newItem Indicates model class
     */
    override fun areContentsTheSame(oldItem: ImageItem, newItem: ImageItem): Boolean {
        return oldItem == newItem
    }
}
