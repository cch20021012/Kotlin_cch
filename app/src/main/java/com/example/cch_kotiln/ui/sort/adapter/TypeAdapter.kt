package com.example.kotlin_shop.adpater.shop.type

import android.widget.BaseAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.cch_kotiln.model.CategorySort
import com.example.cch_kotiln.ui.sort.SortSubFragment

class TypeAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm){

    private var arrayList=ArrayList<SortSubFragment>()
    private var category= ArrayList<CategorySort>()


    fun addList(arrayList: ArrayList<SortSubFragment>,category:ArrayList<CategorySort>){
        this.arrayList = arrayList
        this.category = category
        notifyDataSetChanged()
    }

    override fun getItem(position: Int): Fragment {
        return arrayList[position]
    }

    override fun getCount(): Int {
       return arrayList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return category[position].name
    }
}