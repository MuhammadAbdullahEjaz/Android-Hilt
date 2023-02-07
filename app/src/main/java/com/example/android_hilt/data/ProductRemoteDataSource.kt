package com.example.android_hilt.data

import com.example.android_hilt.network.ApiError
import com.example.android_hilt.network.Product
import com.example.android_hilt.network.ProductResponse
import com.example.android_hilt.network.ProductService
import javax.inject.Inject

class ProductRemoteDataSource @Inject constructor(
    private val productService: ProductService
) :
    ProductDataSource {
    override suspend fun getAllProducts(): ProductResponse {
        val result = productService.getProducts()
        if (result.isSuccessful) {
            return result.body()!!
        } else {
            throw ApiError()
        }
    }

}