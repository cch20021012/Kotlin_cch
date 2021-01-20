package com.example.cch_kotiln.model

data class HotGoodsQ(
    val bannerInfo: BannerInfo
)

data class BannerInfo(
    val img_url: String,
    val name: String,
    val url: String
)