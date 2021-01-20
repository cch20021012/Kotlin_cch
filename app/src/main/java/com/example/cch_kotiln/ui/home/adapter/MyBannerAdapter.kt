package com.example.cch_kotiln.ui.home.adapter

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.cch_kotiln.model.Banner

import com.youth.banner.loader.ImageLoader

class MyBannerAdapter: ImageLoader(){
    override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
        var item = path as Banner
        Glide.with(context!!).load(item.image_url).into(imageView!!)
    }

}