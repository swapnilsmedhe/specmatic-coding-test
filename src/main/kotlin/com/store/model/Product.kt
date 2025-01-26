package com.store.model

import java.math.BigDecimal

data class Product(
    var id: Long,
    val name: String,
    val type: ProductType,
    val inventory: Int,
    val cost: BigDecimal
)

