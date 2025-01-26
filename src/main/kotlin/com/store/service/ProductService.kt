package com.store.service

import com.store.model.ProductDetails
import com.store.model.Product
import com.store.model.ProductType
import org.springframework.stereotype.Service

@Service
class
ProductService {
    private val productStore = mutableSetOf<Product>()
    private var currentId = 1L

    fun getProducts(type: ProductType): List<Product> {
        return productStore.filter { it.type == type }
    }

    fun getAllProducts(): List<Product> {
        return productStore.toList()
    }

    fun addProduct(productDetails: ProductDetails): Product {
        val product = Product(
            id = currentId++,
            name = productDetails.name,
            type = productDetails.type,
            inventory = productDetails.inventory,
            cost = productDetails.cost
        )
        productStore.add(product)
        return product
    }
}