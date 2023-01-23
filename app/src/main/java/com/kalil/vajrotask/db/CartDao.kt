package com.kalil.vajrotask.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.kalil.vajrotask.productlist.model.Product

@Dao
interface CartDao {
    @Query("SELECT * FROM cart_items")
    suspend fun getAll(): List<Product>

    @Insert
    suspend fun insertAll(CartItem: CartItem)

    @Query("SELECT * FROM cart_items where autoId = :autoId")
    suspend fun delete(autoId: String?)

}