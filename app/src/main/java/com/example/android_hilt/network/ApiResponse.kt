package com.example.android_hilt.network

sealed class ApiResponse<T>{
    class Success<T>(val data:T): ApiResponse<T>()
    class Error<T>(val message:String): ApiResponse<T>()
    class Loading<T>:ApiResponse<T>()
}


class ApiError():Exception()