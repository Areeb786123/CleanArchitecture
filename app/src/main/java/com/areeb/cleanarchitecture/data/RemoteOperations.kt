package com.areeb.cleanarchitecture.data

import com.areeb.cleanarchitecture.data.models.PostDto
import com.areeb.cleanarchitecture.data.network.network.remote.api.home.HomeApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteOperations @Inject constructor(
    private val homeApi: HomeApi
) : IRemoteOperation, SafeApiCall {
    override suspend fun getPhotos(): Resource<List<PostDto>> {
        return safeApiCall { homeApi.getPhotos() }
    }

    override suspend fun getPhotosById(id: Int): Resource<PostDto> {
        return safeApiCall { homeApi.getPhotoById(id) }
    }
}
