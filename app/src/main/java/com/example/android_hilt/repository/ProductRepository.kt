package com.example.android_hilt.repository

import com.example.android_hilt.data.ProductDataSource
import com.example.android_hilt.network.Product
import com.example.android_hilt.network.ProductResponse
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productRemoteDataSource: ProductDataSource
    ) {
    suspend fun getProducts():ProductResponse{
        return productRemoteDataSource.getAllProducts()
    }
}