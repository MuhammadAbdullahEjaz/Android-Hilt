package com.example.android_hilt.data

import com.example.android_hilt.network.Product
import com.example.android_hilt.network.ProductResponse

interface ProductDataSource {
    suspend fun getAllProducts():ProductResponse
}