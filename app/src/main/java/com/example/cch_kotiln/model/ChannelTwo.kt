package com.example.cch_kotiln.model

data class ChannelTwo(
    val `data`: Datac,
    val errmsg: String,
    val errno: Int
)

data class Datac(
    val categoryList: List<Categoryc>,
    val currentCategory: CurrentCategoryc
)

data class Categoryc(
    val banner_url: String,
    val front_desc: String,
    val front_name: String,
    val icon_url: String,
    val id: Int,
    val img_url: String,
    val is_show: Int,
    val keywords: String,
    val level: String,
    val name: String,
    val parent_id: Int,
    val show_index: Int,
    val sort_order: Int,
    val type: Int,
    val wap_banner_url: String
)

data class CurrentCategoryc(
    val banner_url: String,
    val front_desc: String,
    val front_name: String,
    val icon_url: String,
    val id: Int,
    val img_url: String,
    val is_show: Int,
    val keywords: String,
    val level: String,
    val name: String,
    val parent_id: Int,
    val show_index: Int,
    val sort_order: Int,
    val subCategoryList: List<SubCategoryc>,
    val type: Int,
    val wap_banner_url: String
)

data class SubCategoryc(
    val banner_url: String,
    val front_desc: String,
    val front_name: String,
    val icon_url: String,
    val id: Int,
    val img_url: String,
    val is_show: Int,
    val keywords: String,
    val level: String,
    val name: String,
    val parent_id: Int,
    val show_index: Int,
    val sort_order: Int,
    val type: Int,
    val wap_banner_url: String
)