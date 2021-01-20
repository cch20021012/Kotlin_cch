package com.example.cch_kotiln.ui.home.adapter

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.example.cch_kotiln.R
import com.example.cch_kotiln.base.BaseAdapter
import com.example.cch_kotiln.base.IItemClick
import com.example.cch_kotiln.model.HotGoods

class MyHotGoodAdapter(context: Context,list: List<HotGoods>,layouts:SparseArray<Int>,click: IItemClick<HotGoods>):
    BaseAdapter<HotGoods>(context,list,layouts,click){
    override fun layoutId(position: Int): Int {
        return R.layout.rlv_hot_item
    }

    override fun bindData(binding: ViewDataBinding, data: HotGoods) {

    }
}