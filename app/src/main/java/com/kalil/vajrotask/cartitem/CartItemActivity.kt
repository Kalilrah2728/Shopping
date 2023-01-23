package com.kalil.vajrotask.cartitem

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.kalil.vajrotask.R
import com.kalil.vajrotask.cartitem.adapter.CartitemsAdapter
import com.kalil.vajrotask.cartitem.viewmodel.CartitemviewModel
import com.kalil.vajrotask.databinding.ActivityCartItemBinding
import com.kalil.vajrotask.db.CartItem

class CartItemActivity : AppCompatActivity() {

    lateinit var dataBinding: ActivityCartItemBinding
    lateinit var viewModel: CartitemviewModel
    lateinit var cartitemsAdapter: CartitemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_cart_item)
        viewModel = ViewModelProvider(this)[CartitemviewModel::class.java]
        dataBinding.apply {
            this.lifecycleOwner = this@CartItemActivity
            this.cartitemviewmodel = viewModel
        }

        viewModel.getAllCart().observe(this) {
            viewModel.beneficiary.clear()
            if (!it.isNullOrEmpty()) {

                it.iterator().forEach {
                    viewModel.beneficiary.add(
                        CartItem(
                            autoId = it.autoId,
                            name = it.name,
                            price = it.price,
                            avatar = it.avatar
                        )
                    )
                }
                recycLoader(it)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun recycLoader(it: List<CartItem>) {
        cartitemsAdapter = CartitemsAdapter(this, it)
        dataBinding.recyclerView1.adapter = cartitemsAdapter
        cartitemsAdapter.notifyDataSetChanged()
        startActivity(intent)
        finish()
    }
}