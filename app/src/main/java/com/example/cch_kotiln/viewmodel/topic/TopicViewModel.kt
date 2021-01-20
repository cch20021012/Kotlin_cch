package com.example.cch_kotiln.viewmodel.topic

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cch_kotiln.base.BaseViewModel
import com.example.cch_kotiln.model.TopicBean
import com.example.cch_kotiln.net.Injection
import kotlinx.coroutines.launch

class TopicViewModel :BaseViewModel(Injection.repository){
    var topic:MutableLiveData<List<TopicBean.DataX>> = MutableLiveData()

    fun getTopic(id:Int){
        viewModelScope.launch {
            var result=repository.getTopic(id)
            if (result.errno==0){
                topic.postValue(result.data.data)
            }
        }
    }
}