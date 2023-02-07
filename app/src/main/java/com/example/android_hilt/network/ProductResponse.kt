package com.example.android_hilt.network

import com.squareup.moshi.Json


data class ProductResponse(
    val products: List<Product>
)