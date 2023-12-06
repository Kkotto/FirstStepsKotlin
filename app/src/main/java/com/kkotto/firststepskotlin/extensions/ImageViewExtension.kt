package com.kkotto.firststepskotlin.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadFromSource(url: String) {
    Glide.with(this).load(url).into(this)
}
