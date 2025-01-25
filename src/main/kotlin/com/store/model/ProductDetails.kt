package com.store.model

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Min

data class ProductDetails(
    @field:NotBlank(message = "Name must not be blank")
    @field:Pattern(
        regexp = "^[a-zA-Z ]+$",
        message = "Name must be a string containing only alphanumeric characters and spaces"
    )
    val name: String,

    @field:NotBlank(message = "Type must not be blank")
    val type: String,

    @field:Min(value = 1, message = "Inventory must be at least 1")
    val inventory: Int
)
