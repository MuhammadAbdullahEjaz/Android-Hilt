package com.example.android_hilt.network

sealed class ApiResponse<T>{
    class Success<T>(data:T): ApiResponse<T>()
    class Error<T>(message:String): ApiResponse<T>()
    class Loading<T>:ApiResponse<T>()
}


class ApiError():Exception()