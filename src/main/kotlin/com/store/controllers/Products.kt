package com.store.controllers

import com.store.model.Product
import com.store.model.ProductDetails
import com.store.model.ProductId
import com.store.model.ProductType
import com.store.service.ProductService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/products")
class Products(private val productService: ProductService) {
    @GetMapping
    fun getAllProducts(@RequestParam(required = false) type: String?): ResponseEntity<List<Product>> {
        if (type == null) {
            val products = productService.getAllProducts()
            return ResponseEntity.ok(products)
        }

        val products = productService.getProducts(ProductType.fromString(type))
        return ResponseEntity.ok(products)
    }

    @PostMapping
    fun createProduct(@Valid @RequestBody productDetails: ProductDetails): ResponseEntity<ProductId> {
        val createdProduct = productService.addProduct(productDetails)
        return ResponseEntity.status(HttpStatus.CREATED).body(ProductId(createdProduct.id))
    }
}

// Comment