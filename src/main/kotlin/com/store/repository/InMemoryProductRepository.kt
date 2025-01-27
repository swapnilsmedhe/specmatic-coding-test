package com.store.repository

import com.store.model.Product
import com.store.model.ProductDetails
import com.store.model.ProductType
import org.springframework.stereotype.Repository

@Repository
class InMemoryProductRepository : ProductRepository {
    private val productStore = mutableSetOf<Product>()
    private var currentId = 1L

    override fun getProducts(type: ProductType): List<Product> {
        return productStore.filter { it.type == type }
    }

    override fun getAllProducts(): List<Product> {
        return productStore.toList()
    }

    override fun addProduct(productDetails: ProductDetails): Product {
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
