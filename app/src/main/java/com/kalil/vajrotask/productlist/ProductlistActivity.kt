package com.kalil.vajrotask.productlist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.kalil.vajrotask.R
import com.kalil.vajrotask.databinding.ActivityProductlistBinding
import com.kalil.vajrotask.productlist.adapter.ProductlistAdapter
import com.kalil.vajrotask.productlist.model.Datamodel
import com.kalil.vajrotask.productlist.model.Product
import com.kalil.vajrotask.productlist.viewmodel.ProductlistviewModel

class ProductlistActivity : AppCompatActivity() {

    lateinit var dataBinding: ActivityProductlistBinding
    lateinit var viewModel: ProductlistviewModel
    lateinit var productData:Datamodel
    lateinit var adapter: ProductlistAdapter

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productlist)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_productlist)
        viewModel = ViewModelProvider(this)[ProductlistviewModel::class.java]
        dataBinding.apply {
            this.lifecycleOwner = this@ProductlistActivity
            this.productlistmodel = viewModel
        }

        viewModel.productListResponseModel.observe(this) {
            adapter = ProductlistAdapter(this,it.products)
            dataBinding.recyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        }

        viewModel.getData()!!.observe(this) {
            it.products
            println("ITEMS" + it.products)
        }

    }

}