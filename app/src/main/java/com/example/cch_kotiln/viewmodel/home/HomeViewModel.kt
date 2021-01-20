package com.example.cch_kotiln.viewmodel.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cch_kotiln.base.BaseViewModel
import com.example.cch_kotiln.model.*
import com.example.cch_kotiln.net.Injection


import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class HomeViewModel: BaseViewModel(Injection.repository) {
    var banner:MutableLiveData<List<Banner>> = MutableLiveData()
    var brand:MutableLiveData<List<Brand>> = MutableLiveData()
    var hotGoods:MutableLiveData<List<HotGoods>> = MutableLiveData()
    var channel:MutableLiveData<List<Channel>> = MutableLiveData(listOf())
    var newGoods:MutableLiveData<List<NewGoods>> = MutableLiveData(listOf())
    var topic:MutableLiveData<List<Topic>> = MutableLiveData(listOf())
    var category:MutableLiveData<List<Category>> = MutableLiveData(listOf())

    //网络请求的状态值  -1 网络请求错误
    var loadStatue:MutableLiveData<Int> = MutableLiveData()

    var homeData:MutableLiveData<HomeData> = MutableLiveData()

    fun getHome() {
        viewModelScope.launch {
            var result = repository.getHome()
            if (result.errno == 0) {
                //banner图
                banner.postValue(result.data.banner)
                //品牌制造商
                brand.postValue(result.data.brandList)
                //商品类型
                channel.postValue(result.data.channel)
                //新品首发
                newGoods.postValue(result.data.newGoodsList)
                //人气推荐
                hotGoods.postValue(result.data.hotGoodsList)
                //专题
                topic.postValue(result.data.topicList)
                //居家
                category.postValue(result.data.categoryList)
            } else if (result.errno == 665) {
                refreshToken()
            }
        }
    }
//    fun loadHomeData(){
//        GlobalScope.launch {
//            loadData()
//        }
//    }
//    /**
//     * 定义给V层调用的方法
//     */
//    private suspend fun loadData(){
//        var result = repository.getHome()
//        if(result != null){
//            homeData.postValue(result.data)
//        }else{
//            loadStatue.postValue(-1)
//        }
//    }
//    /**
//     * 网络请求
//     */
//    suspend fun get(str:String) = withContext(Dispatchers.IO){
//        var result = URL(str).readText(charset("utf-8"))
//        return@withContext Gson().fromJson<HomeData>(result,HomeData::class.java)
//    }

}