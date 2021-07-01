package com.codingmonk21.listcomposerdemo


import android.content.Context
import android.graphics.drawable.Drawable
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

fun getColoredDrawable(context: Context, color: Int): Drawable {
    val unwrappedDrawable = AppCompatResources.getDrawable(context, R.drawable.rc_bg)
    val wrappedDrawable = DrawableCompat.wrap(unwrappedDrawable!!)
    DrawableCompat.setTint(wrappedDrawable, ContextCompat.getColor(context, color))
    return wrappedDrawable
}