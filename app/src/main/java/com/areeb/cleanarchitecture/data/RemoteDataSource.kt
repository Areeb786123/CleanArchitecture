package com.areeb.cleanarchitecture.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val networkInterceptor: NetworkConnectionInterceptor
) {
    fun <Api> buildApi(api: Class<Api>, baseUrl: String): Api {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }
}
