package com.store.repository

import com.store.model.Product
import com.store.model.ProductDetails
import com.store.model.ProductType

interface ProductRepository {
    fun getProducts(type: ProductType): List<Product>
    fun getAllProducts(): List<Product>
    fun addProduct(productDetails: ProductDetails): Product
}