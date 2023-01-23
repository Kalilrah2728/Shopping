package com.kalil.vajrotask.productlist.Retrofit

import androidx.lifecycle.MutableLiveData
import com.kalil.vajrotask.productlist.model.Datamodel
import com.kalil.vajrotask.productlist.model.RequestmodelDummy
import com.twinkle.ncsl.projectutils.Variable
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ApiInterface {

    /*@GET("mocky.io")
    fun doGetProducts(@Body body: RequestmodelDummy): Call<Datamodel>*/

    @GET("mocky.io")
    fun getProduct() : Call<Datamodel>
}