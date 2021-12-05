package com.adevinta.ebay.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.adevinta.ebay.R
import com.adevinta.ebay.databinding.ProductImageFragmentBinding
import com.adevinta.ebay.util.AppConstants
import com.adevinta.ebay.util.InternetConnection
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class ProductImageFragment : Fragment() {

    private lateinit var productImageFragmentBinding: ProductImageFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        productImageFragmentBinding =
            ProductImageFragmentBinding.inflate(inflater, container, false)
        activity?.toolbar?.title = getString(R.string.detail)
        val url = arguments?.get(getString(R.string.selectedImage)).toString()
        loadImage(url)
        return productImageFragmentBinding.root
    }

    private fun loadImage(url: String) {
        if (InternetConnection.checkNetworkConnection(requireContext())) {
            Glide.with(requireContext())
                .load(AppConstants.https + url + AppConstants.largeImageSize)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontTransform()
                .into(productImageFragmentBinding.largerImg)
        } else {
            Toast.makeText(requireContext(), getString(R.string.noInternet), Toast.LENGTH_LONG)
                .show()
        }
    }
}