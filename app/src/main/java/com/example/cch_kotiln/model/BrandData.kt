package com.example.cch_kotiln.model

data class BrandData(
    val `data`: Data,
    val errmsg: String,
    val errno: Int
)

data class Data(
    val count: Int,
    val currentPage: Int,
    val `data`: List<DataX>,
    val pageSize: Int,
    val totalPages: Int
)

data class DataX(
    val app_list_pic_url: String,
    val floor_price: Double,
    val id: Int,
    val name: String
)