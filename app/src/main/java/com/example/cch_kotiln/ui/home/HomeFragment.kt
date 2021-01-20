package com.example.cch_kotiln.ui.home

import android.content.Intent
import android.util.SparseArray
import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cch_kotiln.BR
import com.example.cch_kotiln.R
import com.example.cch_kotiln.base.BaseFragment
import com.example.cch_kotiln.base.IItemClick
import com.example.cch_kotiln.databinding.FragmentHomeBinding
import com.example.cch_kotiln.model.*
import com.example.cch_kotiln.ui.home.adapter.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.layout_channel_item.view.*


class HomeFragment(val lid: Int) :
    BaseFragment<com.example.cch_kotiln.viewmodel.home.HomeViewModel, FragmentHomeBinding>(
        R.layout.fragment_home,
        com.example.cch_kotiln.viewmodel.home.HomeViewModel::class.java
    ) {
    /**
     * 提供Homefragment实例
     */
    companion object {
        val instance: HomeFragment by lazy { HomeFragment(R.layout.fragment_home) }
    }

    override fun initView() {
        tv_monday.setOnClickListener {
            val intent = Intent(activity, HotGoodsActivity::class.java)
            startActivity(intent)
        }
    }

    override fun initVM() {
        mViewModel.homeData.observe(this, Observer {
            mDataBinding.setVariable(BR.vmHome, it)
        })
    }

    override fun initData() {
        mViewModel!!.getHome()
        showBanner()
        showChannel()
        showBrand()
        showNewGoods()
        showHotGoods()
        showTopic()
        showCategory()
    }

    private fun showBrand() {
        mViewModel.brand.observe(this, Observer {
            rlv_brand.layoutManager = GridLayoutManager(context, 2)
            var brandArr = SparseArray<Int>()
            brandArr.put(R.layout.rlv_brand_item, BR.vmBrand)
            var brandClick = BrandItemClick()
            rlv_brand.adapter =
                MyBrandAdapte(
                    context!!,
                    it,
                    brandArr,
                    brandClick
                )
        })
    }

    private fun showNewGoods() {
        mViewModel!!.newGoods.observe(this, Observer {
            rlv_net.layoutManager = GridLayoutManager(context, 2)
            var brandarr = SparseArray<Int>()
            brandarr.put(R.layout.rlv_net_item, BR.vmNetGood)
            var netItemClick = NetItemClick()
            rlv_net.adapter =
                MyNetGoodAdaper(
                    context!!,
                    it,
                    brandarr,
                    netItemClick
                )
        })
    }

    private fun showHotGoods() {
        mViewModel.hotGoods.observe(this, Observer {
            rlv_hot.layoutManager = LinearLayoutManager(context)
            rlv_hot!!.addItemDecoration(DividerItemDecoration(context, LinearLayout.VERTICAL))

            var brandarr = SparseArray<Int>()
            brandarr.put(R.layout.rlv_hot_item, BR.vmHotGoods)
            var hotItemClick = HotItemClick()
            rlv_hot.adapter =
                MyHotGoodAdapter(
                    context!!,
                    it,
                    brandarr,
                    hotItemClick
                )
        })


    }

    private fun showTopic() {
        mViewModel.topic.observe(this, Observer {
            rlv_topic.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
            var brandarr = SparseArray<Int>()
            brandarr.put(R.layout.rlv_topic_item, BR.vmTopic)
            var topicItemClick = TopicItemClick()
            rlv_topic.adapter =
                MyTopicAdapter(
                    context!!,
                    it,
                    brandarr,
                    topicItemClick
                )
        })
    }

    private fun showCategory() {
        mViewModel.category.observe(this, Observer {
            rlv_category.layoutManager = LinearLayoutManager(context)
            var brandarr = SparseArray<Int>()
            brandarr.put(R.layout.rlv_category_item, BR.vmCategory)
            var CategoryItemClick = CategoryItemClick()
            rlv_category.adapter =
                MyCategoryAdapter(
                    context!!,
                    it,
                    brandarr,
                    CategoryItemClick
                )

        })
    }

    private fun showChannel() {
        mViewModel!!.channel.observe(this, Observer {
            var list: List<Channel> = it
            //居家导航栏

            // 清除所有布局
            ll_channel.removeAllViews()
            // 权重
            val layoutParams =
                LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f)
            //循环  in修饰  indices 长度
            for (i in it.indices) {
                val inflate =
                    LayoutInflater.from(activity).inflate(R.layout.layout_channel_item, null)

                inflate.tv_1.text = it.get(i).name
                Glide.with(this).load(it.get(i).icon_url).into(inflate.img_1)
                inflate.tv_1.gravity = Gravity.CENTER      // 文字居中
                inflate.layoutParams = layoutParams       //  占位
                ll_channel.addView(inflate)             // 添加布局
                //用于点击事件
                inflate.setTag(it)
                inflate.setOnClickListener {
                    val intent = Intent(activity, ChannelActivity::class.java)
                    startActivity(intent)
                }
                //点击跳转
                inflate.setOnClickListener {
                    //取值
                    var name = list.get(i).name
                    var url = list.get(i).url
                    //传值
                    val intent = Intent(activity, ChannelActivity::class.java)
                    intent.putExtra("name", name)
                    startActivity(intent)
                }



            }
        })
    }

    private fun showBanner() {
        mViewModel!!.banner.observe(this, Observer {
            banner_home!!.setImages(it)
            banner_home!!.setImageLoader(MyBannerAdapter())
            banner_home!!.start()
        })

    }

    override fun initVariable() {
        mDataBinding.setVariable(BR.vmHome, mViewModel.homeData.value)
    }


    inner class BrandItemClick : IItemClick<Brand> {
        override fun itemClick(data: Brand) {
            //点击品牌条目
        }
    }

    inner class NetItemClick : IItemClick<NewGoods> {
        override fun itemClick(data: NewGoods) {

        }
    }

    inner class HotItemClick : IItemClick<HotGoods> {
        override fun itemClick(data: HotGoods) {

        }
    }

    inner class TopicItemClick : IItemClick<Topic> {
        override fun itemClick(data: Topic) {

        }
    }

    inner class CategoryItemClick : IItemClick<Category> {
        override fun itemClick(data: Category) {

        }
    }

    inner class TitleClick {
        fun clickBrand() {

        }

        fun clickNewGood() {

        }
    }

}