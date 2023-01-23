package com.kalil.vajrotask.productlist.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kalil.vajrotask.productlist.Repository.ProductRepository
import com.kalil.vajrotask.productlist.model.Datamodel
import com.kalil.vajrotask.productlist.model.Product
import kotlinx.coroutines.Job

class ProductlistviewModel : ViewModel() {

    lateinit var job: Job

    val productList = MutableLiveData<ArrayList<Product>>()

    val _productListResponseModel = MutableLiveData<Datamodel>()
    val productListResponseModel: LiveData<Datamodel> by lazy { _productListResponseModel }


    var servicesLiveData: MutableLiveData<Datamodel>? = null

    fun getData() : MutableLiveData<Datamodel>? {
        servicesLiveData = ProductRepository.getServicesApiCall()
        return servicesLiveData
    }

}