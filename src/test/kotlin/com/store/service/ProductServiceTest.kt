package com.store.service

import com.store.model.Product
import com.store.model.ProductDetails
import com.store.model.ProductType
import com.store.repository.ProductRepository
import io.mockk.every
import io.mockk.mockk
import java.math.BigDecimal
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ProductServiceTest {

    private val productRepository: ProductRepository = mockk()
    private val productService: ProductService = ProductService(productRepository)

    @Test
    fun `should get products by type`() {
        val productType = ProductType.GADGET
        val product1 = Product(1L, "Samsung Galaxy S24 Ultra", productType, 10, BigDecimal("99.99"))
        val product2 = Product(2L, "iPhone 14 Pro", productType, 5, BigDecimal("999.99"))

        every { productRepository.getProducts(productType) } returns listOf(product1, product2)

        val products = productService.getProducts(productType)

        assertEquals(2, products.size)
        assertTrue(products.contains(product1))
        assertTrue(products.contains(product2))
    }

    @Test
    fun `should get all products`() {
        val product1 = Product(1L, "Samsung Galaxy S24 Ultra", ProductType.GADGET, 10, BigDecimal("99.99"))
        val product2 = Product(2L, "The Psychology of Money", ProductType.BOOK, 5, BigDecimal("49.99"))

        every { productRepository.getAllProducts() } returns listOf(product1, product2)

        val allProducts = productService.getAllProducts()

        assertEquals(2, allProducts.size)
        assertTrue(allProducts.contains(product1))
        assertTrue(allProducts.contains(product2))
    }

    @Test
    fun `should add a product`() {
        val productDetails = ProductDetails("Samsung Galaxy S24 Ultra", ProductType.GADGET, 10, BigDecimal("99.99"))
        val addedProduct = Product(1L, "Samsung Galaxy S24 Ultra", ProductType.GADGET, 10, BigDecimal("99.99"))

        every { productRepository.addProduct(productDetails) } returns addedProduct

        val result = productService.addProduct(productDetails)

        assertEquals(addedProduct.name, result.name)
        assertEquals(addedProduct.type, result.type)
        assertEquals(addedProduct.inventory, result.inventory)
        assertEquals(addedProduct.cost, result.cost)
    }
}