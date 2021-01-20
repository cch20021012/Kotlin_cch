package com.example.cch_kotiln.ui.sort

import android.content.Intent
import android.util.Log
import android.util.SparseArray
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.cch_kotiln.BR
import com.example.cch_kotiln.R
import com.example.cch_kotiln.base.BaseFragment
import com.example.cch_kotiln.base.IItemClick
import com.example.cch_kotiln.databinding.FragmentSortsubBinding
import com.example.cch_kotiln.model.SubCategorySortList
import com.example.cch_kotiln.model.Topic
import com.example.cch_kotiln.ui.sort.adapter.SortAdapter
import com.example.cch_kotiln.viewmodel.sort.SortListDataViewModel
import kotlinx.android.synthetic.main.fragment_sortsub.*

class SortSubFragment(var id:String) :BaseFragment<SortListDataViewModel, FragmentSortsubBinding>(
    R.layout.fragment_sortsub,
    SortListDataViewModel::class.java
){
    override fun initView() {

    }

    override fun initVM() {
        mViewModel.sortDataList.observe(this, Observer {
            mDataBinding.setVariable(BR.vmSortLits,it)
            recySort.layoutManager=GridLayoutManager(context,3)
            var brandarr=SparseArray<Int>()
            brandarr.put(R.layout.rlv_sort_item,BR.vmSortItem)
            var click=SortItemClick()
            recySort.adapter=SortAdapter(context!!,it.subCategoryList,brandarr,click)
            tv_name.setText(it.name)
            Glide.with(context!!).load(it.wap_banner_url).into(img)

        })
    }

    override fun initData() {
        mViewModel.getSortDataList(id)
    }

    override fun initVariable() {

    }
    inner class SortItemClick : IItemClick<SubCategorySortList> {
        override fun itemClick(data: SubCategorySortList) {
            var intent =Intent(activity,SortActivity::class.java)
            Log.i("TAG", "itemClick: "+data.id)
            intent.putExtra("id",data.id.toString())
            intent.putExtra("name",data.name)
            startActivity(intent)
        }
    }
}