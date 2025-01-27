package com.store.service

import com.store.model.ProductDetails
import com.store.model.Product
import com.store.model.ProductType
import com.store.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class
ProductService(@Autowired private val productRepository: ProductRepository) {
    fun getProducts(type: ProductType): List<Product> {
        return productRepository.getProducts(type)
    }

    fun getAllProducts(): List<Product> {
        return productRepository.getAllProducts()
    }

    fun addProduct(productDetails: ProductDetails): Product {
        return productRepository.addProduct(productDetails)
    }
}