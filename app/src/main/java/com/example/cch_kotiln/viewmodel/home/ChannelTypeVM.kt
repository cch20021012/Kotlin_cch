package com.example.cch_kotiln.viewmodel.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cch_kotiln.base.BaseViewModel
import com.example.cch_kotiln.model.ChannelTypeData
import com.example.cch_kotiln.model.DataXch
import com.example.cch_kotiln.model.FilterCategory
import com.example.cch_kotiln.net.Injection
import kotlinx.coroutines.launch

class ChannelTypeVM :BaseViewModel(Injection.repository){
    var channelType:MutableLiveData<List<DataXch>> = MutableLiveData()
    fun getChannelType(id:Int){
        viewModelScope.launch {
            var result=repository.getChannelType(id)
            if (result.errno==0){
                channelType.postValue(result.data.data)
            }
        }
    }
}