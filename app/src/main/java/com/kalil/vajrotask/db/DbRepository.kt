package com.kalil.vajrotask.db

import androidx.lifecycle.LiveData
import com.kalil.vajrotask.productlist.model.Datamodel
import com.kalil.vajrotask.productlist.model.Product

class DbRepository(val roomDao: CartDao) {

    suspend fun insertCartItems(item: Product) {
        roomDao.insertAll(CartItem(name = item.name, price = item.price, avatar = item.image))
    }
    suspend fun deleteCartItems(autoId: Int?) {
        roomDao.delete(autoId = autoId)
    }

    fun getCartData(): LiveData<List<CartItem>> {
        return roomDao.getAll()
    }
}