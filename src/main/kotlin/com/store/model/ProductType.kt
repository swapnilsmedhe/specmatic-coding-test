package com.store.model

import com.fasterxml.jackson.annotation.JsonValue

enum class ProductType(val type: String) {
    BOOK("book"),
    FOOD("food"),
    GADGET("gadget"),
    OTHER("other");

    @JsonValue
    override fun toString(): String {
        return type
    }

    companion object {
        fun fromString(type: String): ProductType {
            return entries.first { it.type == type }
        }
    }
}