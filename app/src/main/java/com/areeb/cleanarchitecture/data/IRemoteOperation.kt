package com.areeb.cleanarchitecture.data

import com.areeb.cleanarchitecture.data.models.PostResponseDto

interface IRemoteOperation {
    suspend fun getPhotos(): Resource<PostResponseDto>
}
