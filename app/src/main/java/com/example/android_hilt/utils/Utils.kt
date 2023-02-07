package com.example.android_hilt.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat.getSystemService


//@RequiresApi(Build.VERSION_CODES.M)
//fun isNetworkAvailable(): Boolean {
//    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
//    val network = connectivityManager!!.activeNetwork
//    val capabilities = connectivityManager.getNetworkCapabilities(network)
//    if (capabilities != null) {
//        if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || capabilities.hasTransport(
//                NetworkCapabilities.TRANSPORT_WIFI
//            )
//        ) {
//            return true
//        }
//    }
//    return false
//}