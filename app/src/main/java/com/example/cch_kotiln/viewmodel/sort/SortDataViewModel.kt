package com.example.cch_kotiln.viewmodel.sort

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cch_kotiln.base.BaseViewModel
import com.example.cch_kotiln.model.CategorySort
import com.example.cch_kotiln.net.Injection
import kotlinx.coroutines.launch

class SortDataViewModel:BaseViewModel(Injection.repository) {
    var sortData:MutableLiveData<List<CategorySort>> = MutableLiveData()


    fun getSortData(id:String){
        viewModelScope.launch {
            var result=repository.getSortData(id)
            if (result.errno==0){
                sortData.postValue(result.data.categoryList)
            }
        }
    }


}