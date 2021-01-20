package com.example.cch_kotiln.ui.home

import android.util.SparseArray
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cch_kotiln.BR
import com.example.cch_kotiln.R
import com.example.cch_kotiln.base.BaseFragment
import com.example.cch_kotiln.base.IItemClick
import com.example.cch_kotiln.databinding.FragmentHomeBinding
import com.example.cch_kotiln.model.DataXch
import com.example.cch_kotiln.ui.home.adapter.ChannelTypeAdapter
import com.example.cch_kotiln.viewmodel.home.ChannelTypeVM
import kotlinx.android.synthetic.main.fragment_channel.*

class ChannelFragment(var Iid:Int,var front_name:String,var title:String):
    BaseFragment<ChannelTypeVM,FragmentHomeBinding>(
    R.layout.fragment_channel,
    ChannelTypeVM::class.java
){


    companion object {
        val instance: HomeFragment by lazy { HomeFragment(R.layout.fragment_channel) }
    }

    override fun initView() {
        tv_n.setText(front_name)
        tv_f.setText(title)
    }

    override fun initVM() {
        mViewModel.getChannelType(Iid!!)
    }

    override fun initData() {
        mViewModel.channelType.observe(this, Observer {
            rlv_channel.layoutManager=GridLayoutManager(context,2)
            var brandarr=SparseArray<Int>()
            brandarr.put(R.layout.rlv_channeltype_item,BR.vmChannelType)
            var channelTypeData=ChannelItemClick()
            rlv_channel.adapter=
                ChannelTypeAdapter(
                    context!!,
                    it,
                    brandarr,
                    channelTypeData
                )
        })
    }

    override fun initVariable() {
    }

    inner class ChannelItemClick : IItemClick<DataXch> {
        override fun itemClick(data: DataXch) {

        }
    }

}