package com.example.cch_kotiln.api


import com.example.cch_kotiln.model.*
import com.example.cch_kotiln.net.BaseResp
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.QueryMap
import java.util.HashMap

interface ServiceApi {


    @POST("auth/refreshToken")  //刷新token
    suspend fun refreshToken(): BaseResp<String>

    @GET("index")
    suspend fun getHome():BaseResp<HomeData>   // BaseResp抽取的一个bean类的外层结构 homeData当前接口返回的具体

    //专题
    @GET("topic/list?size=10")
    suspend fun getTopic(@Query("page")id:Int):BaseResp<TopicBean>

    //https://cdplay.cn/api/catalog/index?
    @GET("catalog/index?")
    suspend fun getChannel():BaseResp<ChannelData>

    @GET("goods/list?page=1&size=200x")
    suspend fun getChannelType(@Query("categoryId") categoryId:Int):BaseResp<ChannelTypeData>

    //新品首发
    @GET("goods/hot")
    suspend fun getHotGoods():BaseResp<HotGoodsQ>

    //新品首发列表

    @GET("goods/list")
    suspend fun getHotGoodsData(@QueryMap map: HashMap<String, String>):BaseResp<HotGoodsData>

    //分类数据
    @GET("catalog/index")
    suspend fun getSortData(@Query("id") id:String):BaseResp<SortData>

    //分类对应的详情数据
    @GET("catalog/current")
    suspend fun getSortListData(@Query("id") id:String):BaseResp<SortListData>

    //分类点击页面导航
    @GET("goods/category?id=1008013")
    suspend fun getSortTl(@Query("id")id:String):BaseResp<SortTlData>

    @GET("goods/list?page=1&size=200x")
    suspend fun getSortTlList(@Query("categoryId") categoryId:Int):BaseResp<SortTlListData>

    //详情页
    @GET("goods/detail?")
    suspend fun getDetail(@Query("id")id: String):BaseResp<DetailData>

    //获取购物车数据
    @GET("cart/index")
    suspend fun getCar():BaseResp<CarData>
}