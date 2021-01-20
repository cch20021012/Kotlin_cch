package com.example.cch_kotiln.ui.topic

import android.annotation.SuppressLint
import android.util.Log
import android.util.SparseArray
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cch_kotiln.BR
import com.example.cch_kotiln.R
import com.example.cch_kotiln.base.BaseFragment
import com.example.cch_kotiln.base.IItemClick
import com.example.cch_kotiln.databinding.FragmentTopicBinding
import com.example.cch_kotiln.model.TopicBean
import com.example.cch_kotiln.ui.topic.adapter.TopicAdapter
import com.example.cch_kotiln.viewmodel.topic.TopicViewModel
import kotlinx.android.synthetic.main.fragment_topic.*

class TopicFragment:BaseFragment<TopicViewModel,FragmentTopicBinding>(
    R.layout.fragment_topic,
    TopicViewModel::class.java
) {

    companion object{
        val instance:TopicFragment by lazy { TopicFragment() }
        var listid:Int=1
        var select:Boolean=true

    }


    override fun initView() {
        rlv_topic.layoutManager=LinearLayoutManager(activity)



        btn_down.setOnClickListener {
            initSelect()
        }
        btn_up.setOnClickListener {
            initisSelect()
        }

    }
    @SuppressLint("ResourceAsColor")
    fun initSelect(){
        if (select){
            mViewModel.getTopic(2)
            initData()
            select=false
            btn_up.setTextColor(-0x1000000)
            btn_down.setTextColor(R.color.colorGrey)
            nsv.fling(0);
            nsv.smoothScrollTo(0, 0);
        }else{
            return
        }
    }
    @SuppressLint("ResourceAsColor")
    fun initisSelect(){
        if (!select){
            mViewModel.getTopic(1)
            initData()
            select=true
            btn_down.setTextColor(-0x1000000)
            btn_up.setTextColor(R.color.colorGrey)
            nsv.fling(0);
            nsv.smoothScrollTo(0, 0);
        }else{
            return
        }
    }

    override fun initVM() {
        mViewModel.getTopic(1)

    }

    override fun initData() {
        mViewModel.topic.observe(this, Observer {
            var list:List<TopicBean.DataX> = ArrayList()
            list=it
            var brandarr=SparseArray<Int>()
            brandarr.put(R.layout.rlv_topic_list_item,BR.vmTopicItem)
            var click=TopicClickItem()
            var topicadapter = TopicAdapter(context!!,list,brandarr,click)
            rlv_topic.adapter=topicadapter
            topicadapter.notifyDataSetChanged()
            Log.i("TAG", "initData: "+list)
        })
    }

    override fun initVariable() {

    }
    inner class TopicClickItem:IItemClick<TopicBean.DataX>{
        override fun itemClick(data: TopicBean.DataX) {
            TODO("Not yet implemented")
        }

    }
}