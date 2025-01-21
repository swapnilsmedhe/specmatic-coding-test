package com.store.model

data class Product(
    var id: Long,
    val name: String,
    val type: ProductType,
    val inventory: Int
)

