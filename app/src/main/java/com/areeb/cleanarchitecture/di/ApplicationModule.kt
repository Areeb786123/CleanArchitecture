package com.areeb.cleanarchitecture.di

import com.areeb.cleanarchitecture.data.RemoteDataSource
import com.areeb.cleanarchitecture.data.network.network.remote.api.home.HomeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {
    @Singleton
    @Provides
    fun providesHomeApi(): HomeApi = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(HomeApi::class.java)
}
