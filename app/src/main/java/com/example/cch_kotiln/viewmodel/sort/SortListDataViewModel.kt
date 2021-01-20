package com.example.cch_kotiln.viewmodel.sort

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cch_kotiln.base.BaseViewModel
import com.example.cch_kotiln.model.CurrentCategorySortList
import com.example.cch_kotiln.model.SubCategorySortList
import com.example.cch_kotiln.net.Injection
import kotlinx.coroutines.launch

class SortListDataViewModel :BaseViewModel(Injection.repository){
    var sortDataList: MutableLiveData<CurrentCategorySortList> = MutableLiveData()



    fun getSortDataList(id:String){
        viewModelScope.launch {
            var result=repository.getSortListData(id)
            if (result.errno==0){
                sortDataList.postValue(result.data.currentCategory)
            }
        }
    }
}