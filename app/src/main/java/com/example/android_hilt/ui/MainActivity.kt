package com.example.android_hilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import com.example.android_hilt.R
import com.example.android_hilt.databinding.ActivityMainBinding
import com.example.android_hilt.network.ApiResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    //test

    private val viewModel: MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.products.observe(this) {
            when (it) {
                is ApiResponse.Loading -> {
                    binding.loading.visibility = View.VISIBLE

                }
                is ApiResponse.Success -> {
                    binding.loading.visibility = View.GONE

                }
                is ApiResponse.Error -> {
                    binding.loading.visibility = View.GONE

                }
            }
        }
    }
}