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
import com.example.cch_kotiln.model.SubCategorySortList

class SortAdapter(context: Context,list: List<SubCategorySortList>,layouts:SparseArray<Int>,var click: IItemClick<SubCategorySortList>)
    : BaseAdapter<SubCategorySortList>(context,list,layouts,click){
    override fun layoutId(position: Int): Int {
        return R.layout.rlv_sort_item
    }

    override fun bindData(binding: ViewDataBinding, data: SubCategorySortList) {
        var imageView:ImageView=binding.root.findViewById(R.id.img_pic)
        Glide.with(context).load(data.wap_banner_url).into(imageView)
        binding.setVariable(BR.vmSortItemClick,click)
    }

}