package com.areeb.cleanarchitecture.data

import com.areeb.cleanarchitecture.data.models.PostDto

interface IRemoteOperation {
    suspend fun getPhotos(): Resource<List<PostDto>>
    suspend fun getPhotosById(id: Int): Resource<PostDto>
}
