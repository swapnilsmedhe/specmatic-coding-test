package com.store.repository

import com.store.model.ProductDetails
import com.store.model.ProductType
import java.math.BigDecimal
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class InMemoryProductRepositoryTest {

    private lateinit var productRepository: InMemoryProductRepository

    @BeforeEach
    fun setUp() {
        productRepository = InMemoryProductRepository()
    }

    @Test
    fun `should add product`() {
        val productDetails = ProductDetails("Samsung Galaxy S24 Ultra", ProductType.GADGET, 10, BigDecimal(99.99))

        val addedProduct = productRepository.addProduct(productDetails)

        assertTrue(addedProduct.id > 0)
        assertEquals("Samsung Galaxy S24 Ultra", addedProduct.name)
        assertEquals(ProductType.GADGET, addedProduct.type)
        assertEquals(10, addedProduct.inventory)
        assertEquals(BigDecimal(99.99), addedProduct.cost)
    }

    @Test
    fun `should get all products`() {
        val firstProduct = ProductDetails("Samsung Galaxy S24 Ultra", ProductType.GADGET, 10, BigDecimal(99.99))
        val secondProduct = ProductDetails("The Psychology of Money", ProductType.BOOK, 5, BigDecimal(49.99))

        productRepository.addProduct(firstProduct)
        productRepository.addProduct(secondProduct)

        val allProducts = productRepository.getAllProducts()

        assertEquals("Samsung Galaxy S24 Ultra", allProducts[0].name)
        assertEquals(ProductType.GADGET, allProducts[0].type)
        assertEquals(10, allProducts[0].inventory)
        assertEquals(BigDecimal(99.99), allProducts[0].cost)

        assertEquals("The Psychology of Money", allProducts[1].name)
        assertEquals(ProductType.BOOK, allProducts[1].type)
        assertEquals(5, allProducts[1].inventory)
        assertEquals(BigDecimal(49.99), allProducts[1].cost)
    }

    @Test
    fun `should get products by type`() {
        val firstProduct = ProductDetails("Galaxy S24 Ultra", ProductType.GADGET, 10, BigDecimal(99.99))
        val secondProduct = ProductDetails("Iphone 16 Pro", ProductType.GADGET, 5, BigDecimal(49.99))
        val thirdProduct = ProductDetails("The psychology of money", ProductType.BOOK, 7, BigDecimal(29.99))

        productRepository.addProduct(firstProduct)
        productRepository.addProduct(secondProduct)
        productRepository.addProduct(thirdProduct)

        val gadgetTypeProducts = productRepository.getProducts(ProductType.GADGET)

        assertEquals(2, gadgetTypeProducts.size)
        assertTrue(gadgetTypeProducts.all { it.type == ProductType.GADGET })
    }
}
