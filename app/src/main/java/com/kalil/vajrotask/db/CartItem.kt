package com.kalil.vajrotask.db

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "cart_items")
data class CartItem(
    @PrimaryKey(autoGenerate = true) val autoId:String?=null,
    val name: String?,
    val email: String?,
    val avatar: String?
) : Parcelable