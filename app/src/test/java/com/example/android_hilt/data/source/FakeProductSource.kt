package com.example.android_hilt.data.source

import com.example.android_hilt.data.ProductDataSource
import com.example.android_hilt.network.ApiError
import com.example.android_hilt.network.ProductResponse

class FakeProductSource(private var products:ProductResponse) : ProductDataSource {
    override suspend fun getAllProducts(): ProductResponse {
        if(products.products.isEmpty()){
            throw ApiError()
        }
        return products
    }

}