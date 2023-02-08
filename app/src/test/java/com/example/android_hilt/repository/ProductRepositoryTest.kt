package com.example.android_hilt.repository

import com.example.android_hilt.data.ProductDataSource
import com.example.android_hilt.data.source.FakeProductSource
import com.example.android_hilt.network.ApiError
import com.example.android_hilt.network.Product
import com.example.android_hilt.network.ProductResponse
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class ProductRepositoryTest {

    private val productsList = listOf(
        Product(1, "p1", "pd1", 50, "pb", "pc"),
        Product(1, "p2", "pd2", 60, "pb", "pc"),
        Product(1, "p3", "pd3", 20, "pb", "pc"),
    )
    private val productResponse = ProductResponse(productsList)
    private lateinit var fakeDataSource: ProductDataSource
    private lateinit var productRepository: ProductRepository

    @Before
    fun setup() {
        fakeDataSource = FakeProductSource(productResponse)
        productRepository = ProductRepository(fakeDataSource)
    }

    @Test
    fun getProducts_requestAllProductsFromRemoteDatabase_notEmpty() = runTest {
       val result = productRepository.getProducts()
        assertEquals(result.products.isEmpty(), false)
    }
    @Test(expected = ApiError::class)
    fun getProducts_requestAllProductsFromRemoteDatabase_isEmpty() = runTest {
        fakeDataSource = FakeProductSource(ProductResponse(emptyList()))
        productRepository = ProductRepository(fakeDataSource)
        val result = productRepository.getProducts()
    }
}