package com.example.cch_kotiln.ui.sort

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.cch_kotiln.BR
import com.example.cch_kotiln.R
import com.example.cch_kotiln.base.BaseFragment
import com.example.cch_kotiln.base.IItemClick
import com.example.cch_kotiln.databinding.FragmentSortBinding
import com.example.cch_kotiln.model.CategorySort
import com.example.cch_kotiln.model.SortData
import com.example.cch_kotiln.model.SubCategory
import com.example.cch_kotiln.model.Topic
import com.example.cch_kotiln.ui.topic.TopicFragment
import com.example.cch_kotiln.viewmodel.sort.SortDataViewModel
import com.example.kotlin_shop.adpater.shop.type.TypeAdapter
import kotlinx.android.synthetic.main.fragment_sort.*
import q.rorbin.verticaltablayout.adapter.TabAdapter
import q.rorbin.verticaltablayout.widget.ITabView
import q.rorbin.verticaltablayout.widget.QTabView

class SortFragment(Iid:Int):BaseFragment<SortDataViewModel,FragmentSortBinding>(
    R.layout.fragment_sort,
    SortDataViewModel::class.java
) {
    companion object{
        val instance: SortFragment by lazy { SortFragment(R.layout.fragment_sort) }
    }
    private lateinit var tabAdapter: TabAdapter
    private var sortList:MutableList<CategorySort> = mutableListOf()

    private var sortDataList:MutableList<SubCategory> = mutableListOf()


    override fun initView() {

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun initVM() {
        mViewModel.sortData.observe(this, Observer {
            var fragments=ArrayList<SortSubFragment>()
            for (i in it.indices){
                var ff = SortSubFragment(it.get(i).id.toString())
                fragments.add(ff)

            }
            var typeAdapter=TypeAdapter(childFragmentManager)
            vp_main.adapter=typeAdapter
            typeAdapter.addList(fragments,it as ArrayList<CategorySort>)
            verticaltablayout.setupWithViewPager(vp_main)
        })
    }

    override fun initData() {
        mViewModel.getSortData("0")
    }

    override fun initVariable() {

    }
    //adapter 和 viewpager结合使用
    inner class MyTabAdapter:TabAdapter {
        override fun getCount(): Int {
            return sortList.size
        }

        override fun getBadge(position: Int): ITabView.TabBadge {
            TODO("Not yet implemented")
        }

        override fun getIcon(position: Int): ITabView.TabIcon {
            TODO("Not yet implemented")
        }

        override fun getTitle(position: Int): ITabView.TabTitle {
            TODO("Not yet implemented")
        }

        override fun getBackground(position: Int): Int {
            TODO("Not yet implemented")
        }

    }

}