package com.kalil.vajrotask.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kalil.vajrotask.productlist.model.Product

@Dao
interface CartDao {
    @Query("SELECT * FROM cart_items")
    suspend fun getAll(): List<CartItem>

    @Insert
    suspend fun insertAll(CartItem: CartItem)

    @Query("Delete FROM cart_items where ID = :autoId")
    suspend fun delete(autoId: Int?)

}