package com.store.model

import com.store.validation.ValidProductName
import jakarta.validation.constraints.DecimalMin
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class ProductDetails(
    @field:ValidProductName(message = "Name must not be blank")
    val name: String,

    val type: ProductType,

    @field:Min(value = 1, message = "Inventory must be at least 1")
    @field:Max(value = 9999, message = "Inventory cannot exceed 9999")
    val inventory: Int,

    @field:NotNull(message = "Cost must not be null")
    @field:DecimalMin(value = "0.01", message = "Cost must be at least 0.01")
    val cost: BigDecimal
)
