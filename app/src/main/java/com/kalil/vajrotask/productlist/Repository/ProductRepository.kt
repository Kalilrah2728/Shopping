package com.kalil.vajrotask.productlist.Repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.kalil.vajrotask.productlist.Retrofit.ApiClient
import com.kalil.vajrotask.productlist.model.Datamodel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ProductRepository {

    val serviceSetterGetter = MutableLiveData<Datamodel>()

    fun getServicesApiCall(): MutableLiveData<Datamodel> {

        val call = ApiClient.apiInterface.getProduct()

        call.enqueue(object: Callback<Datamodel> {
            override fun onFailure(call: Call<Datamodel>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())
            }

            override fun onResponse(
                call: Call<Datamodel>,
                response: Response<Datamodel>
            ) {
                Log.v("DEBUG : ", response.body().toString())

                val data = response.body()

                val msg = data!!.products

                serviceSetterGetter.value = Datamodel(msg)
            }
        })

        return serviceSetterGetter
    }
}