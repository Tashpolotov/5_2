package com.example.rickandmorty3.extencion

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.a5_2.R

fun View.glide(url: String){
    Glide.with(this).load(url).placeholder(R.drawable.rick).circleCrop().into(this as ImageView)
}