package com.store.service

import com.store.model.Product
import com.store.model.ProductType
import org.springframework.stereotype.Service

@Service
class
ProductService {
    private val productStore = mutableSetOf<Product>()

    fun getAllProducts(type: ProductType): List<Product> {
        return productStore.filter { it.type == type }
    }
}