package com.example.cch_kotiln.ui.home.adapter

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.example.cch_kotiln.R
import com.example.cch_kotiln.base.BaseAdapter
import com.example.cch_kotiln.base.IItemClick
import com.example.cch_kotiln.model.Topic


class MyTopicAdapter(context: Context, list: List<Topic>, layouts:SparseArray<Int>, click:IItemClick<Topic>):
    BaseAdapter<Topic>(context,list,layouts,click){
    override fun layoutId(position: Int): Int {
        return R.layout.rlv_topic_item
    }

    override fun bindData(binding: ViewDataBinding, data: Topic) {
    }
}