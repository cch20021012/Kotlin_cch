package com.example.cch_kotiln.ui.home.adapter

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.example.cch_kotiln.R
import com.example.cch_kotiln.base.BaseAdapter
import com.example.cch_kotiln.base.IItemClick
import com.example.cch_kotiln.model.NewGoods

class MyNetGoodAdaper(context: Context,list: List<NewGoods>,layouts:SparseArray<Int>,click:IItemClick<NewGoods>):
    BaseAdapter<NewGoods>(context,list,layouts,click) {
    override fun layoutId(position: Int): Int {
        return R.layout.rlv_net_item
    }

    override fun bindData(binding: ViewDataBinding, data: NewGoods) {

    }
}