package com.example.cch_kotiln.net.repository

import com.example.cch_kotiln.api.ServiceApi
import com.example.cch_kotiln.net.RetrofitFactory

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SystemRepository {
    private lateinit var serviceApi: ServiceApi

    init {
        serviceApi= RetrofitFactory.instance.create(ServiceApi::class.java)
    }

    suspend fun refreshToken()= withContext(Dispatchers.IO){
        serviceApi.refreshToken()
    }

    suspend fun getHome()= withContext(Dispatchers.IO){
        serviceApi.getHome()
    }

    suspend fun getTopic(id:Int)= withContext(Dispatchers.IO){
        serviceApi.getTopic(id)
    }

    suspend fun getChannel()= withContext(Dispatchers.IO){
        serviceApi.getChannel()
    }
    suspend fun getChannelType(id:Int)= withContext(Dispatchers.IO){
        serviceApi.getChannelType(id)
    }
    suspend fun getHotGoods()= withContext(Dispatchers.IO){
        serviceApi.getHotGoods()
    }
    suspend fun getHotGoodsData(map:HashMap<String,String>)= withContext(Dispatchers.IO){
        serviceApi.getHotGoodsData(map)
    }
    suspend fun getSortData(id:String)= withContext(Dispatchers.IO){
        serviceApi.getSortData(id)
    }
    suspend fun getSortListData(id:String)= withContext(Dispatchers.IO){
        serviceApi.getSortListData(id)
    }

    suspend fun getSortTl(id:String)= withContext(Dispatchers.IO){
        serviceApi.getSortTl(id)
    }
    suspend fun getSortTlList(id:Int)= withContext(Dispatchers.IO){
        serviceApi.getSortTlList(id)
    }
}