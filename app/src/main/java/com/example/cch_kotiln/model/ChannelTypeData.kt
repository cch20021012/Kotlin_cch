package com.example.cch_kotiln.model

data class ChannelTypeData(
    val count: Int,
    val currentPage: Int,
    val `data`: List<DataXch>,
    val filterCategory: List<FilterCategory>,
    val goodsList: List<Goodsch>,
    val pageSize: Int,
    val totalPages: Int
)

data class DataXch(
    val id: Int,
    val list_pic_url: String,
    val name: String,
    val retail_price: String
)

data class FilterCategory(
    val checked: Boolean,
    val id: Int,
    val name: String
)

data class Goodsch(
    val id: Int,
    val list_pic_url: String,
    val name: String,
    val retail_price: String
)

