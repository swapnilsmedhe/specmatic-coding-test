package com.store.model

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import com.store.validation.ValidProductName

data class ProductDetails(
    @field:ValidProductName(message = "Name must not contain boolean values or numbers")
    @field:NotBlank(message = "Name must not be blank")
    val name: String,

    @field:NotBlank(message = "Type must not be blank")
    val type: String,

    @field:Min(value = 1, message = "Inventory must be at least 1")
    val inventory: Int
)
