package com.example.android_hilt.di

import com.example.android_hilt.network.ProductService
import com.example.android_hilt.utils.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton
import kotlin.math.log


@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun providesMoshi(): Moshi {
        return Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()
    }

    @Singleton
    @Provides
    fun providesOkHttpLogger():HttpLoggingInterceptor{
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return  logging
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(loggingInterceptor: HttpLoggingInterceptor):OkHttpClient{
        val okHttpClient = OkHttpClient.Builder()
        return okHttpClient.addInterceptor(loggingInterceptor)
            .build()
    }


    @Singleton
    @Provides
    fun provideNetwork(moshi: Moshi, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideProductService(retrofit: Retrofit): ProductService {
        return retrofit.create(ProductService::class.java)
    }


}