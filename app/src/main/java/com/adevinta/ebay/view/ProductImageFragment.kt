package com.adevinta.ebay.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adevinta.ebay.R
import com.adevinta.ebay.databinding.ProductImageFragmentBinding
import com.adevinta.ebay.util.AppConstants
import com.bumptech.glide.Glide
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

        val url = arguments?.get(getString(R.string.selectedImage))

        Glide.with(requireContext())
            .load(AppConstants.https + url + AppConstants.largeImageSize)
            .dontTransform()
            .into(productImageFragmentBinding.largerImg)

        return productImageFragmentBinding.root
    }
}