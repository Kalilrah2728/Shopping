package com.kalil.vajrotask.db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "cart_items")
data class CartItem(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID") var autoId:Int?=null,
    @ColumnInfo(name = "PRODUCT_NAME") var name: String?=null,
    @ColumnInfo(name = "PRICE") var price: String?=null,
    @ColumnInfo(name = "PRODUCT_IMAGE") var avatar: String?=null
) : Parcelable