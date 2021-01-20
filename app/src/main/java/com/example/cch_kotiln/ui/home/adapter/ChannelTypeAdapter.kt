package com.example.cch_kotiln.ui.home.adapter

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.example.cch_kotiln.R
import com.example.cch_kotiln.base.BaseAdapter
import com.example.cch_kotiln.base.IItemClick
import com.example.cch_kotiln.model.ChannelTypeData
import com.example.cch_kotiln.model.DataXch
import com.example.cch_kotiln.model.FilterCategory

class ChannelTypeAdapter(context: Context, list:List<DataXch>, layouts:SparseArray<Int>, click: IItemClick<DataXch>):
    BaseAdapter<DataXch>(context,list,layouts,click){
    override fun layoutId(position: Int): Int {
        return R.layout.rlv_channeltype_item
    }

    override fun bindData(binding: ViewDataBinding, data: DataXch) {

    }

}