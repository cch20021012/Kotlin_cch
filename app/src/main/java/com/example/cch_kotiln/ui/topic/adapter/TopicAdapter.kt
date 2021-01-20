package com.example.cch_kotiln.ui.topic.adapter

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.example.cch_kotiln.R
import com.example.cch_kotiln.base.BaseAdapter

import com.example.cch_kotiln.base.IItemClick
import com.example.cch_kotiln.model.TopicBean

class TopicAdapter(context: Context,list: List<TopicBean.DataX>,layouts:SparseArray<Int>,click: IItemClick<TopicBean.DataX>) :
    BaseAdapter<TopicBean.DataX>(context,list,layouts,click){
    override fun layoutId(position: Int): Int {
        return R.layout.rlv_topic_list_item
    }

    override fun bindData(binding: ViewDataBinding, data: TopicBean.DataX) {

    }
}