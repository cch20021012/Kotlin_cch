package com.example.cch_kotiln.ui.home.adapter

import android.content.Context
import android.util.SparseArray
import androidx.databinding.ViewDataBinding
import com.example.cch_kotiln.R
import com.example.cch_kotiln.base.BaseAdapter
import com.example.cch_kotiln.base.IItemClick
import com.example.cch_kotiln.model.Brand


class MyBrandAdapte(context: Context, list: List<Brand>, layouts:SparseArray<Int>, click: IItemClick<Brand>)
    : BaseAdapter<Brand>(context,list,layouts,click){
    override fun layoutId(position: Int): Int {
       return R.layout.rlv_brand_item
    }

    override fun bindData(binding: ViewDataBinding, data: Brand) {

    }
//    RecyclerView.Adapter<MyBrandAdapte.MyViewHolder>() {
//    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val tv_name:TextView=itemView.findViewById(R.id.tv_name);
//        val tv_price:TextView=itemView.findViewById(R.id.tv_price);
//        val img_pic:ImageView=itemView.findViewById(R.id.img_pic);
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val root = LayoutInflater.from(context).inflate(R.layout.rlv_brand_item, parent,false);
//        return MyViewHolder(root)
//    }
//
//    override fun getItemCount(): Int {
//        return list.size
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        val brand=list.get(position)
//        holder.tv_name.setText(brand.name)
//        holder.tv_price.setText(brand.floor_price+"元起")
//        Glide.with(context).load(brand.new_pic_url).into(holder.img_pic)
//    }
}