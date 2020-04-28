package com.special.robinhood.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImageFormUrl(url: String?) {
    Glide.with(this.context)
            .load(url.orEmpty())
            .into(this)
}

fun ImageView.loadImageFormUrl(url: String?, placeHolder: Int?) {
    Glide.with(this.context)
            .load(url.orEmpty())
            .apply(RequestOptions()
                    .placeholder(placeHolder ?: 0))
            .into(this)
}