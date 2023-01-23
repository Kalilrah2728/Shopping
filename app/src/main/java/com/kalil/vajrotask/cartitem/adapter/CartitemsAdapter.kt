package com.kalil.vajrotask.cartitem.adapter

import android.widget.Toast
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
    var Order = 0

    lateinit var dbRepository: DbRepository
    val roomDb = RoomDb.getDatabase(productlist)
    override fun setViewHolder(holder: CartlistAdapterBinding, position: Int) {
        holder.cartitemmodel = mList[position]
        dbRepository = DbRepository(roomDb.roomDao())

        holder.deleteItem.setOnClickListener{
            GlobalScope.launch {
                dbRepository.deleteCartItems(mList[position].autoId)

            }
        }
        holder.bu1.setOnClickListener {
            if (Order < 10) {
                Order += 1
                holder.tex1.text = Order.toString()
            } else {
                Toast.makeText(productlist, "You can Reached Maximum Quantity!", Toast.LENGTH_LONG)
                    .show();

            }
        }
        holder.bu2.setOnClickListener {
            if (Order >  1) {
                Order -= 1
                holder.tex1.text = Order.toString()
            } else {
                Toast.makeText(productlist, "You Can't Ordering Less Then one Quantity", Toast.LENGTH_LONG)
                    .show();

            }
        }
    }

    override fun getLayout() = R.layout.cartlist_adapter

    override fun getCount() = mList.size

}