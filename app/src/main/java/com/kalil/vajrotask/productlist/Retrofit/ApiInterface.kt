package com.kalil.vajrotask.productlist.Retrofit

import com.kalil.vajrotask.productlist.model.Datamodel
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    /*@GET("mocky.io")
    fun doGetProducts(@Body body: RequestmodelDummy): Call<Datamodel>*/

    @POST("mocky.io/v2")
    fun getProduct() : Call<Datamodel>
}