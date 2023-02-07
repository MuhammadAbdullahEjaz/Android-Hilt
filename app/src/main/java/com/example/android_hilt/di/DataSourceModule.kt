package com.example.android_hilt.di

import com.example.android_hilt.data.ProductDataSource
import com.example.android_hilt.data.ProductRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
interface DataSourceModule {
    @Binds
    @Singleton
    fun bindsProductRemoteDataSource(
        productRemoteDataSource: ProductRemoteDataSource
    ):ProductDataSource
}