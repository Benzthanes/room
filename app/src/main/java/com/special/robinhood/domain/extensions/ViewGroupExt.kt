package com.special.robinhood.domain.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ViewGroupExt {

    fun ViewGroup.inflateLayoutResId(layoutResId: Int): View {
        return LayoutInflater.from(this.context).inflate(layoutResId, this, false)
    }
}
