package com.kalil.vajrotask.cartitem.adapter

import com.kalil.vajrotask.R
import com.kalil.vajrotask.cartitem.CartItemActivity
import com.kalil.vajrotask.databinding.CartlistAdapterBinding
import com.kalil.vajrotask.db.CartItem
import com.kalil.vajrotask.db.DbRepository
import com.kalil.vajrotask.db.RoomDb
import com.kalil.vajrotask.utils.BaseRecyclerAdapter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CartitemsAdapter(
    val productlist: CartItemActivity,
    private val mList: List<CartItem>
) : BaseRecyclerAdapter<CartlistAdapterBinding>(productlist) {

    lateinit var dbRepository: DbRepository
    val roomDb = RoomDb.getDatabase(productlist)
    override fun setViewHolder(holder: CartlistAdapterBinding, position: Int) {
        holder.cartitemmodel = mList[position]
        dbRepository = DbRepository(roomDb.roomDao())
        GlobalScope.launch {
            dbRepository.deleteCartItems(mList[position].autoId)
        }

    }

    override fun getLayout() = R.layout.cartlist_adapter

    override fun getCount() = mList.size

}