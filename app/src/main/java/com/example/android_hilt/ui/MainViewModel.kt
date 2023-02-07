package com.example.android_hilt.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_hilt.network.ApiError
import com.example.android_hilt.network.ApiResponse
import com.example.android_hilt.network.Product
import com.example.android_hilt.network.ProductResponse
import com.example.android_hilt.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor (private val productRepository: ProductRepository) : ViewModel() {

    init {
        getProducts()
    }

    private val _products: MutableLiveData<ApiResponse<ProductResponse>> = MutableLiveData()
    val products: LiveData<ApiResponse<ProductResponse>> = _products

    fun getProducts() {
        viewModelScope.launch {
            try {
                _products.postValue(ApiResponse.Loading())
                val result = productRepository.getProducts()
                _products.postValue(ApiResponse.Success(result))
            }catch (e:ApiError){
                _products.postValue(ApiResponse.Error(e.message ?: ""))
            }
        }
    }

}