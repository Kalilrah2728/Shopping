package com.kalil.vajrotask.utils

import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.kalil.vajrotask.R
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView?, url: String?) {
    if (!url.isNullOrEmpty()) {
        Picasso.get().load(url).placeholder(R.drawable.place_holder).into(view)
    }
}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView?, url: Uri?) {
    Picasso.get().load(url).placeholder(R.drawable.place_holder).into(view)
}
