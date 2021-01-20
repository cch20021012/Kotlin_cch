package com.example.cch_kotiln.model

data class HotGoodsData(
    val count: Int,
    val currentPage: Int,
    val `data`: List<DataXHot>,
    val filterCategory: List<FilterCategoryHot>,
    val goodsList: List<GoodsHot>,
    val pageSize: Int,
    val totalPages: Int
)

data class DataXHot(
    val id: Int,
    val list_pic_url: String,
    val name: String,
    val retail_price: String
)

data class FilterCategoryHot(
    val checked: Boolean,
    val id: Int,
    val name: String
)

data class GoodsHot(
    val id: Int,
    val list_pic_url: String,
    val name: String,
    val retail_price: String
)