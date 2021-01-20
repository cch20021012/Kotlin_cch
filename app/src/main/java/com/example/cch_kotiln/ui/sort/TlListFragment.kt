package com.example.cch_kotiln.ui.sort

import android.util.SparseArray
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.cch_kotiln.BR
import com.example.cch_kotiln.R
import com.example.cch_kotiln.base.BaseFragment
import com.example.cch_kotiln.base.IItemClick
import com.example.cch_kotiln.databinding.FragmentSortBinding
import com.example.cch_kotiln.model.SortTlListData
import com.example.cch_kotiln.ui.sort.adapter.SortTlListAdapter
import com.example.cch_kotiln.viewmodel.sort.SortTlListViewModel
import kotlinx.android.synthetic.main.fragment_sorttilist.*

class TlListFragment:BaseFragment<SortTlListViewModel,FragmentSortBinding>(
    R.layout.fragment_sorttilist,
    SortTlListViewModel::class.java
) {
    override fun initView() {

    }

    override fun initVM() {
        var id = arguments?.getInt("id")
        mViewModel.getSortDataList(id!!)
    }

    override fun initData() {
        mViewModel.sortTlList.observe(this, Observer {
            rlv.layoutManager=GridLayoutManager(context,2)
            var brandarr=SparseArray<Int>()
            brandarr.put(R.layout.rlv_sorttllist_item,BR.vmSortTllist)
            var click=SortTlLIstItem()
            rlv.adapter=SortTlListAdapter(context!!,it,brandarr,click)
        })
    }

    override fun initVariable() {

    }
    inner class SortTlLIstItem:IItemClick<SortTlListData.DataX>{
        override fun itemClick(data: SortTlListData.DataX) {

        }

    }
}