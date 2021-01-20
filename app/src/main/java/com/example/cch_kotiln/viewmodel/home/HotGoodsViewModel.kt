package com.example.cch_kotiln.viewmodel.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cch_kotiln.base.BaseViewModel
import com.example.cch_kotiln.model.BannerInfo
import com.example.cch_kotiln.model.DataXHot
import com.example.cch_kotiln.net.Injection
import kotlinx.coroutines.launch

class HotGoodsViewModel:BaseViewModel(Injection.repository) {
    var hotGoods:MutableLiveData<BannerInfo> = MutableLiveData()
    var hotGoodsData:MutableLiveData<List<DataXHot>> = MutableLiveData()

    fun getHotGoods(){
        viewModelScope.launch {
            var result=repository.getHotGoods()
            if (result.errno==0){
                hotGoods.postValue(result.data.bannerInfo)
            }
        }
    }
    fun getHotGoodsData(map:HashMap<String,String>){
        viewModelScope.launch {
            var result=repository.getHotGoodsData(map)
            if (result.errno==0){
                hotGoodsData.postValue(result.data.data)
            }
        }
    }
}