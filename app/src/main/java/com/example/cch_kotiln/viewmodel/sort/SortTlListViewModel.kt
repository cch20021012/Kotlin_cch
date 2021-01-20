package com.example.cch_kotiln.viewmodel.sort

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cch_kotiln.base.BaseViewModel
import com.example.cch_kotiln.model.SortTlListData
import com.example.cch_kotiln.net.Injection
import kotlinx.coroutines.launch

class SortTlListViewModel : BaseViewModel(Injection.repository){
    var sortTlList: MutableLiveData<List<SortTlListData.DataX>> = MutableLiveData()



    fun getSortDataList(id:Int){
        viewModelScope.launch {
            var result=repository.getSortTlList(id)
            if (result.errno==0){
                sortTlList.postValue(result.data.data)
            }
        }
    }
}