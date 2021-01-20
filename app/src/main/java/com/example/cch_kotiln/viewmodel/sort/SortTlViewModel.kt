package com.example.cch_kotiln.viewmodel.sort

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cch_kotiln.base.BaseViewModel
import com.example.cch_kotiln.model.CurrentCategorySortList
import com.example.cch_kotiln.model.SortTlData
import com.example.cch_kotiln.net.Injection
import kotlinx.coroutines.launch

class SortTlViewModel :BaseViewModel(Injection.repository){
    var sortTl: MutableLiveData<List<SortTlData.BrotherCategory>> = MutableLiveData()



    fun getSortDataList(id:String){
        viewModelScope.launch {
            var result=repository.getSortTl(id)
            if (result.errno==0){
                sortTl.postValue(result.data.brotherCategory)
            }
        }
    }
}