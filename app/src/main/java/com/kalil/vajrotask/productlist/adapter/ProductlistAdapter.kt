package com.kalil.vajrotask.productlist.adapter

import com.kalil.vajrotask.R
import com.kalil.vajrotask.databinding.ProductlistAdapterBinding
import com.kalil.vajrotask.db.CartDao
import com.kalil.vajrotask.db.CartItem
import com.kalil.vajrotask.db.DbRepository
import com.kalil.vajrotask.db.RoomDb
import com.kalil.vajrotask.productlist.ProductlistActivity
import com.kalil.vajrotask.productlist.model.Product
import com.twinkle.ncsl.projectutils.BaseRecyclerAdapter
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

        holder.textView4.setOnClickListener{
            GlobalScope.launch {
                dbRepository.insertCartItems(item)
            }
        }
    }

    override fun getLayout() = R.layout.productlist_adapter

    override fun getCount() = mList.size
    
}