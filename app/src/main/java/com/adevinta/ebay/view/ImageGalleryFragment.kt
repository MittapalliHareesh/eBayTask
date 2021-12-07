package com.adevinta.ebay.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.adevinta.ebay.R
import com.adevinta.ebay.adapter.ImageGalleryAdapter
import com.adevinta.ebay.databinding.ImageGalleryFragmentBinding
import com.adevinta.ebay.model.ImageItem
import com.adevinta.ebay.util.InternetConnection
import com.adevinta.ebay.util.Resource
import com.adevinta.ebay.util.Status
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
        loadImages()
        return imageGalleryFragmentBinding.root
    }

    /**
     * This fun is for Network connectivity check.
     * If it returns TRUE i.e connection is available then it will API and it will fetch data.
     * Otherwise will throw network error message.
     */
    private fun loadImages() {
        if (InternetConnection.checkNetworkConnection(requireContext())) {
            populateImages()
        } else {
            imageGalleryFragmentBinding.progressBar.visibility = View.GONE
            Toast.makeText(requireContext(), getString(R.string.noInternet), Toast.LENGTH_LONG)
                .show()
        }
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
        imageGalleryViewModel.getImages().observe(viewLifecycleOwner, {
            it?.let { resource ->
                renderUiState(resource)
            }
        })
    }

    private fun renderUiState(resource: Resource<List<ImageItem>>) {
        when (resource.status) {
            Status.SUCCESS -> {
                imageGalleryFragmentBinding.rcvAppliance.visibility = View.VISIBLE
                imageGalleryFragmentBinding.progressBar.visibility = View.GONE
                @Suppress("UNCHECKED_CAST")
                (imageGalleryFragmentBinding.rcvAppliance.adapter as ListAdapter<*, *>)
                    .submitList(resource.data as List<Nothing>?)
            }

            Status.LOADING -> {
                imageGalleryFragmentBinding.rcvAppliance.visibility = View.GONE
                imageGalleryFragmentBinding.progressBar.visibility = View.VISIBLE
            }

            Status.ERROR -> {
                imageGalleryFragmentBinding.rcvAppliance.visibility = View.VISIBLE
                imageGalleryFragmentBinding.progressBar.visibility = View.GONE
                Toast.makeText(requireContext(), resource.message, Toast.LENGTH_LONG).show()
            }
        }
    }
}