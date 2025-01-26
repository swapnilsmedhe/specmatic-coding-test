package com.store.model

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonValue
import com.store.exception.InvalidProductTypeException

enum class ProductType {
    BOOK,
    FOOD,
    GADGET,
    OTHER;

    @JsonValue
    fun toJson(): String {
        return name.lowercase()
    }

    companion object {
        @JvmStatic
        @JsonCreator
        fun fromString(value: String): ProductType {
            return entries.firstOrNull { it.name.equals(value, ignoreCase = true) }
                ?: throw InvalidProductTypeException(value)
        }
    }
}