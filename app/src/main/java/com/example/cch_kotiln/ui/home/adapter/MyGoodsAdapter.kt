package com.example.cch_kotiln.ui.home.adapter

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.example.cch_kotiln.R
import com.example.cch_kotiln.base.BaseAdapter
import com.example.cch_kotiln.base.IItemClick
import com.example.cch_kotiln.model.Goods

class MyGoodsAdapter(context: Context,list: List<Goods>,layouts:SparseArray<Int>,click: IItemClick<Goods>):
    BaseAdapter<Goods>(context,list,layouts,click){
    override fun layoutId(position: Int): Int {
        return R.layout.rlv_goods_item
    }

    override fun bindData(binding: ViewDataBinding, data: Goods) {

    }
}