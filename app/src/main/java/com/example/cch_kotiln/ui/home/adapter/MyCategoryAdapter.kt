package com.example.cch_kotiln.ui.home.adapter

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cch_kotiln.BR
import com.example.cch_kotiln.R
import com.example.cch_kotiln.base.BaseAdapter
import com.example.cch_kotiln.base.IItemClick
import com.example.cch_kotiln.model.Category
import com.example.cch_kotiln.model.Goods

class MyCategoryAdapter(context: Context,list: List<Category>,layouts:SparseArray<Int>,click: IItemClick<Category>):
    BaseAdapter<Category>(context,list,layouts,click){
    override fun layoutId(position: Int): Int {
        return R.layout.rlv_category_item
    }

    override fun bindData(binding: ViewDataBinding, data: Category) {
        val rlv:RecyclerView=binding.root.findViewById(R.id.rlv)
        rlv.layoutManager= GridLayoutManager(context,2)
        var brandarr = SparseArray<Int>()
        brandarr.put(R.layout.rlv_goods_item,BR.vmGoods)
        var goodClickItem = GoodClickItem()
        rlv.adapter= MyGoodsAdapter(
            context!!,
            data.goodsList,
            brandarr,
            goodClickItem
        )

    }
    inner class GoodClickItem:IItemClick<Goods>{
        override fun itemClick(data: Goods) {

        }

    }
}