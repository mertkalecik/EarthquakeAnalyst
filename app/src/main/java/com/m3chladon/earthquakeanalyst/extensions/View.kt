package com.m3chladon.earthquakeanalyst.extensions

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.m3chladon.earthquakeanalyst.R

@BindingAdapter("android:visibility")
fun View.setVisibility(bool: Boolean) {
    if (bool)
        this.visibility = View.VISIBLE
    else
        this.visibility = View.GONE
}

@BindingAdapter("auto:background")
fun TextView.setBackground(@DrawableRes drawableRes: Int?) {
    drawableRes?.let {
        background = ContextCompat.getDrawable(context, it)
    }
}

@BindingAdapter("auto:drawable")
fun AppCompatImageView.setDrawable(gender: String): Drawable? {
   return if (gender == "Kadın" || gender == "Female") {
        ContextCompat.getDrawable(context, R.drawable.icon_female)
    } else {
       ContextCompat.getDrawable(context, R.drawable.icon_male)
   }
}