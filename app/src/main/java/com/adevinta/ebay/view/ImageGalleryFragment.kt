package com.adevinta.ebay.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.adevinta.ebay.R
import com.adevinta.ebay.adapter.ImageGalleryAdapter
import com.adevinta.ebay.databinding.ImageGalleryFragmentBinding
import com.adevinta.ebay.model.ImageItem
import com.adevinta.ebay.viewModel.ImageGalleryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class ImageGalleryFragment : Fragment() {

    private lateinit var imageGalleryFragmentBinding: ImageGalleryFragmentBinding
    private val imageGalleryViewModel: ImageGalleryViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        imageGalleryFragmentBinding =
            ImageGalleryFragmentBinding.inflate(inflater, container, false)
        activity?.toolbar?.title = getString(R.string.app_name)
        imageGalleryFragmentBinding.imageGalleryViewModel = imageGalleryViewModel
        populateImages()
        return imageGalleryFragmentBinding.root
    }

    private fun populateImages() {
        val bundle = Bundle()
        imageGalleryFragmentBinding.rcvAppliance.apply {
            adapter = ImageGalleryAdapter(object : ImageGalleryAdapter.OnImageClickListener {
                override fun onImageClick(imageItem: ImageItem) {
                    bundle.putString(getString(R.string.selectedImage), imageItem.uri)
                    findNavController().navigate(
                        R.id.action_MainFragment_to_ProductImageFragment,
                        bundle
                    )
                }
            })
            layoutManager = GridLayoutManager(context, 2)
        }
        imageGalleryViewModel.imagesLiveData.observe(viewLifecycleOwner, {
            it?.let {
                @Suppress("UNCHECKED_CAST")
                (imageGalleryFragmentBinding.rcvAppliance.adapter as ListAdapter<*, *>).submitList(
                    it as List<Nothing>?
                )
            }
        })
    }
}