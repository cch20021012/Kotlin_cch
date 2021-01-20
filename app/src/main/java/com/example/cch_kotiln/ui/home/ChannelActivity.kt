package com.example.cch_kotiln.ui.home

import android.os.Bundle
import android.util.Log
import android.widget.BaseAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.Observer
import com.example.cch_kotiln.R
import com.example.cch_kotiln.base.BaseActivity
import com.example.cch_kotiln.databinding.ActivityMainBinding
import com.example.cch_kotiln.model.CategoryChannel
import com.example.cch_kotiln.model.FilterCategory
import com.example.cch_kotiln.viewmodel.home.ChannelViewModel
import kotlinx.android.synthetic.main.layout_activity_channel.*
import java.util.ArrayList

class ChannelActivity : BaseActivity<ChannelViewModel, ActivityMainBinding>(
    R.layout.layout_activity_channel,
    ChannelViewModel::class.java
) {
    private lateinit var qqname: String
    override fun initView() {
        qqname = intent.getStringExtra("name").toString()
    }

    override fun initVM() {
        mViewModel.getChannel()
    }

    override fun initData() {
        mViewModel.categoryChannel.observe(this, Observer {
            if (it != null && it.size > 0) {
                var list = it

                var fragments = ArrayList<ChannelFragment>()
                for (i in it.indices) {
                    var ff = ChannelFragment(it.get(i).id,it.get(i).name,it.get(i).front_name)
                    fragments.add(ff)
                    Log.i("TAG", "initData: "+it.get(i).name)
                }

                //创建适配器
                vp_main!!.adapter = object : FragmentStatePagerAdapter(supportFragmentManager) {
                    override fun getCount(): Int {
                        return fragments.size
                    }

                    override fun getItem(position: Int): Fragment {
                        return fragments[position]
                    }

                    override fun getPageTitle(position: Int): CharSequence? {
                        return it[position].name
                    }
                }
                tab_main!!.setupWithViewPager(vp_main)

                for (i in it.indices) {
                    //如果获取的name == 集合的name
                    if (qqname == it[i].name) {
                        //被选中   select
                        tab_main!!.getTabAt(i)!!.select()
                    }
                }
            }

        })
    }

    override fun initVariable() {

    }

    override fun showTips(tips: String) {
    }

}