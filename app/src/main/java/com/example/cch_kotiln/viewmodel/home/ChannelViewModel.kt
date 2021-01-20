package com.example.cch_kotiln.viewmodel.home

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cch_kotiln.base.BaseViewModel
import com.example.cch_kotiln.model.CategoryChannel
import com.example.cch_kotiln.model.ChannelData
import com.example.cch_kotiln.net.Injection
import kotlinx.coroutines.launch

class ChannelViewModel :BaseViewModel(Injection.repository){
    var channel:MutableLiveData<List<ChannelData>> = MutableLiveData()
    var categoryChannel:MutableLiveData<List<CategoryChannel>> = MutableLiveData()
    fun getChannel(){
        viewModelScope.launch {
            var result=repository.getChannel()
            if (result.errno==0){
                Log.i("TAG", "getChannel: "+result)
                categoryChannel.postValue(result.data.categoryList)
            }
        }
    }
}