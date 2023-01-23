package com.kalil.vajrotask.productlist.adapter

import android.view.View
import com.kalil.vajrotask.R
import com.kalil.vajrotask.databinding.ProductlistAdapterBinding
import com.kalil.vajrotask.db.DbRepository
import com.kalil.vajrotask.db.RoomDb
import com.kalil.vajrotask.productlist.ProductlistActivity
import com.kalil.vajrotask.productlist.model.Product
import com.kalil.vajrotask.utils.BaseRecyclerAdapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProductlistAdapter(
    val productlist: ProductlistActivity,
    private val mList: List<Product>
) : BaseRecyclerAdapter<ProductlistAdapterBinding>(productlist) {
    var dbRepository: DbRepository

    init {
        val roomDb = RoomDb.getDatabase(productlist)
        dbRepository = DbRepository(roomDb.roomDao())
    }

    override fun setViewHolder(holder: ProductlistAdapterBinding, position: Int) {
        holder.productlistmmodel = mList[position]
        val item = mList[position]

        holder.imageView2.clipToOutline = true
        holder.textView4.setOnClickListener{
            GlobalScope.launch {
                dbRepository.insertCartItems(item)
            }
            holder.textView5.visibility = View.VISIBLE
            holder.textView4.visibility = View.GONE
        }
    }

    override fun getLayout() = R.layout.productlist_adapter

    override fun getCount() = mList.size
    
}