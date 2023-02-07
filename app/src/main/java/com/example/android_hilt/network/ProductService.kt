package com.example.android_hilt.network

import com.example.android_hilt.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {

    @GET(Constants.PRODUCTS_URL)
    suspend fun getProducts(): Response<ProductResponse>

}