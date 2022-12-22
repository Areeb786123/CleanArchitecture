package com.areeb.cleanarchitecture.di

import com.areeb.cleanarchitecture.data.RemoteDataSource
import com.areeb.cleanarchitecture.data.network.network.remote.api.home.HomeApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn (SingletonComponent::class)
object ApplicationModule {
    @Singleton
    @Provides
    fun providesHomeApi(
        remoteDataSource: RemoteDataSource
    ): HomeApi {
        return remoteDataSource.buildApi(
            HomeApi::class.java,
            "https://jsonplaceholder.typicode.com/"

        )
    }
}