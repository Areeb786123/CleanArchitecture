package com.areeb.cleanarchitecture.utils

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.areeb.cleanarchitecture.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imageUrl")
fun setImageView(imageView: ImageView, imageUrl: String?) {
    imageUrl?.let {
        // https should be declare from Constant file because it is not a good practice
        val imgUri = imageUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imageView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(imageView)
    }
}
