package com.example.cch_kotiln

import androidx.fragment.app.Fragment
import com.example.cch_kotiln.base.BaseViewModel
import com.example.cch_kotiln.net.Injection
import com.example.cch_kotiln.ui.car.ShopFragment
import com.example.cch_kotiln.ui.home.HomeFragment
import com.example.cch_kotiln.ui.me.MineFragment
import com.example.cch_kotiln.ui.sort.SortFragment
import com.example.cch_kotiln.ui.topic.TopicFragment


class MainViewModel: BaseViewModel(Injection.repository) {

    var fragments:MutableList<Fragment> = mutableListOf()

    init {
        fragments.add(HomeFragment.instance)
        fragments.add(TopicFragment.instance)
        fragments.add(SortFragment.instance)
        fragments.add(ShopFragment.instance)
        fragments.add(MineFragment.instance)
    }




}