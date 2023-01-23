package com.kalil.vajrotask.productlist.adapter

import com.kalil.vajrotask.R
import com.kalil.vajrotask.databinding.ProductlistAdapterBinding
import com.kalil.vajrotask.productlist.ProductlistActivity
import com.kalil.vajrotask.productlist.model.Product
import com.twinkle.ncsl.projectutils.BaseRecyclerAdapter

class ProductlistAdapter(
    val productlist: ProductlistActivity,
    private val mList: List<Product>
) : BaseRecyclerAdapter<ProductlistAdapterBinding>(productlist) {
    
    override fun setViewHolder(holder: ProductlistAdapterBinding, position: Int) {
        holder.productlistmmodel = mList[position]
    }

    override fun getLayout() = R.layout.productlist_adapter

    override fun getCount() = mList.size
    
}