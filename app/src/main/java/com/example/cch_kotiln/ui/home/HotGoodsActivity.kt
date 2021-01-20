package com.example.cch_kotiln.ui.home

import android.annotation.SuppressLint
import android.graphics.Color
import android.provider.Settings
import android.view.View
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.example.cch_kotiln.R
import com.example.cch_kotiln.base.BaseActivity
import com.example.cch_kotiln.databinding.ActivityMainBinding
import com.example.cch_kotiln.model.DataXHot
import com.example.cch_kotiln.viewmodel.home.HotGoodsViewModel
import kotlinx.android.synthetic.main.layout_activity_hotgood.*

class HotGoodsActivity:BaseActivity<HotGoodsViewModel,ActivityMainBinding>(
    R.layout.layout_activity_hotgood,
    HotGoodsViewModel::class.java
) {
    var list:MutableList<DataXHot> = mutableListOf()
    //是否是新品
    var isNew = 1
    var page = 1
    var size = 100
    var order: String? = null
    var sort: String? = null
    var categoryId = 0
    override fun initView() {

    }

    override fun initVM() {
        mViewModel.getHotGoods()
        var map = HashMap<String, String>()
        mViewModel.getHotGoodsData(map)
    }

    override fun initData() {
        mViewModel.hotGoods.observe(this, Observer {
            txt_info.setText(it.name)
            Glide.with(this).load(it.img_url).into(img_hotgood)
        })
        mViewModel.hotGoodsData.observe(this, Observer {

        })
    }

    override fun initVariable() {

    }

    override fun showTips(tips: String) {

    }

    fun updateGoodList(list: List<DataXHot>){
        this.list.clear()
        this.list.addAll(list)
        //goodlistAdapter.notifyDataSetChanged()
    }


    /**
     * 组装当前的接口参数
     * @return
     */
    private fun getParam(): HashMap<String, String>? {
        val map = HashMap<String, String>()
        map["isNew"] = isNew.toString()
        map["page"] = page.toString()
        map["size"] = size.toString()
        map["order"] = order!!
        map["sort"] = sort!!
        map["category"] = categoryId.toString()
        return map
    }

    /**
     * 按价格升序排序
     */
    @SuppressLint("ResourceType")
    private fun priceStateUp() {
        img_arrow_up.setImageResource(R.mipmap.ic_arrow_up_select)
        img_arrow_down.setImageResource(R.mipmap.ic_arrow_down_normal)
        txt_price.setTextColor(Color.parseColor(getString(R.color.red)))
    }

    /**
     * 价格的降序排列
     */
    @SuppressLint("ResourceType")
    private fun priceStateDown() {
        img_arrow_up.setImageResource(R.mipmap.ic_arrow_up_normal)
        img_arrow_down.setImageResource(R.mipmap.ic_arrow_down_select)
        txt_price.setTextColor(Color.parseColor(getString(R.color.red)))
    }

    /**
     * 重置条件选择的所有状态
     */
    @SuppressLint("ResourceType")
    private fun resetPriceState() {
        img_arrow_up.setImageResource(R.mipmap.ic_arrow_up_normal)
        img_arrow_down.setImageResource(R.mipmap.ic_arrow_down_normal)
        txt_price.setTextColor(Color.parseColor(getString(R.color.black)))
        txt_all.setTextColor(Color.parseColor(getString(R.color.black)))
        txt_sort.setTextColor(Color.parseColor(getString(R.color.black)))
        layout_price.setTag(0)
    }

    /**
     * 重置点击事件
     */
    private fun resetClickEnable(view: View){
        txt_all.isClickable = true
        layout_price.isClickable = true
        txt_sort.isClickable = true
        view.isClickable = false

    }
}