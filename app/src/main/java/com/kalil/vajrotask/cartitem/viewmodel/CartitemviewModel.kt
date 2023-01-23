package com.kalil.vajrotask.cartitem.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kalil.vajrotask.db.CartItem
import com.kalil.vajrotask.db.DbRepository
import com.kalil.vajrotask.db.RoomDb

class CartitemviewModel(application: Application) : AndroidViewModel(application){

    var dbRepository: DbRepository

    init {
        val roomDb = RoomDb.getDatabase(application)
        dbRepository = DbRepository(roomDb.roomDao())
    }
    fun getAllCart(): LiveData<List<CartItem>> = dbRepository.getCartData()
    var beneficiary = arrayListOf<CartItem>()
}