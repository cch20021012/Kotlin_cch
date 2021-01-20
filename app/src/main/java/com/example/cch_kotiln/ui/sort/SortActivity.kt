package com.example.cch_kotiln.ui.sort

import android.os.Bundle
import android.util.Log
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Observer
import com.example.cch_kotiln.R
import com.example.cch_kotiln.base.BaseActivity
import com.example.cch_kotiln.databinding.ActivitySortBinding
import com.example.cch_kotiln.viewmodel.sort.SortTlViewModel
import kotlinx.android.synthetic.main.activity_root.*

class SortActivity :BaseActivity<SortTlViewModel,ActivitySortBinding>(
    R.layout.activity_sort,
    SortTlViewModel::class.java
){
    var name :String?=null
    override fun initView() {
        name=intent.getStringExtra("name")
    }

    override fun initVM() {
       mViewModel.sortTl.observe(this, Observer {
           var fragments=ArrayList<TlListFragment>()
           for (i in it.indices){
               var ff = TlListFragment()
               var bundle=Bundle()
               bundle.putInt("id",it.get(i).id)
               ff.arguments=bundle
               fragments.add(ff)
           }
            vp_main.adapter = object :FragmentPagerAdapter(supportFragmentManager){
                override fun getItem(position: Int): Fragment {
                    return fragments.get(position)
                }

                override fun getCount(): Int {
                    return fragments.size
                }

                override fun getPageTitle(position: Int): CharSequence? {
                    return it.get(position).name
                }
            }
           tl_main.setupWithViewPager(vp_main)
            for (i in it.indices){
                if (name==it.get(i).name){
                    tl_main!!.getTabAt(i)!!.select()
                }
            }
       })
    }

    override fun initData() {
        var id: String? =intent.getStringExtra("id")
        Log.i("TAG", "initData: "+id)
        mViewModel.getSortDataList(id!!)
    }

    override fun initVariable() {

    }

    override fun showTips(tips: String) {
        TODO("Not yet implemented")
    }
}