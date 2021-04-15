package com.codepundit.invitation.utis

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadImageRound(source: Int){
    Glide.with(this)
        .load(source)
        .centerCrop()
        .apply(RequestOptions.circleCropTransform())
        .into(this)
}