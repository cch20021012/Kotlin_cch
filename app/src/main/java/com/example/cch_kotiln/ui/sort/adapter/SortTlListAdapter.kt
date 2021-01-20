package com.example.cch_kotiln.ui.sort.adapter

import android.content.Context
import android.util.SparseArray
import android.widget.ImageView
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.example.cch_kotiln.BR
import com.example.cch_kotiln.R
import com.example.cch_kotiln.base.BaseAdapter

import com.example.cch_kotiln.base.IItemClick
import com.example.cch_kotiln.model.SortTlListData
import com.example.cch_kotiln.model.SubCategorySortList

class SortTlListAdapter(context: Context, list: List<SortTlListData.DataX>, layouts:SparseArray<Int>, var click: IItemClick<SortTlListData.DataX>)
    : BaseAdapter<SortTlListData.DataX>(context,list,layouts,click){
    override fun layoutId(position: Int): Int {
        return R.layout.rlv_sorttllist_item
    }

    override fun bindData(binding: ViewDataBinding, data: SortTlListData.DataX) {
        var imageView:ImageView=binding.root.findViewById(R.id.img_pic)
        //Glide.with(context).load(data.list_pic_url).into(imageView)

    }
}