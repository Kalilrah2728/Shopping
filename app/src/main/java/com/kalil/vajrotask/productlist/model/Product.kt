package com.kalil.vajrotask.productlist.model

data class Product(
    var description: String,
    var href: String,
    var id: String,
    var image: String,
//    var images: List<String>? = null,
    var name: String,
//    var options: List<String>? = null,
    var price: String,
    var product_id: String,
    var quantity: Int,
    var sku: String,
    var special: String,
    var thumb: String,
    var zoom_thumb: String
)