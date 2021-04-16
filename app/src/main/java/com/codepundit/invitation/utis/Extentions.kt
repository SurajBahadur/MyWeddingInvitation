package com.codepundit.invitation.utis

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.codepundit.invitation.R

fun ImageView.loadImageRound(source: Int){
    Glide.with(this)
        .load(source)
        .centerCrop()
        .apply(RequestOptions.circleCropTransform())
        .into(this)
}
fun ImageView.loadImageRound(source: Drawable){
    Glide.with(this)
        .load(source)
        .centerCrop()
        .apply(RequestOptions.circleCropTransform())
        .into(this)
}


fun ImageView.loadCard(source: Int){
    Glide.with(this)
        .load(source)
        .centerCrop()
        .into(this)
}
