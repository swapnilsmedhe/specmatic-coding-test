package com.store.controllers

import com.store.model.Product
import com.store.model.ProductType
import com.store.service.ProductService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/products")
class Products(private val productService: ProductService) {
    @GetMapping
    fun getAllProducts(@RequestParam(required = false) type: String?): ResponseEntity<List<Product>> {
        val products = productService.getAllProducts(ProductType.fromString(type ?: "other"))
        return ResponseEntity.ok(products)
    }
}
