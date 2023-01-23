package com.kalil.vajrotask.db

import com.kalil.vajrotask.productlist.model.Datamodel

class DbRepository(val roomDao: CartDao) {

    suspend fun insertCartItems(referenceTable: List<Datamodel>) {
        referenceTable.iterator().forEach {
            it.products.forEach {
                roomDao.insertAll(
                    CartItem(
                        it.id,
                        it.name,
                        it.price,
                        it.image
                    )
                )
            }
        }
    }

    suspend fun deleteCartItems(autoId: String?) {
        roomDao.delete(autoId = autoId)
    }
}