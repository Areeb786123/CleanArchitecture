package com.areeb.cleanarchitecture.data.network.network.remote.api.home

import com.areeb.cleanarchitecture.data.models.PostDto
import retrofit2.http.GET
import retrofit2.http.Path

interface HomeApi {

    @GET("photos")
    suspend fun getPhotos(): List<PostDto>

    @GET("photos/{id}")
    suspend fun getPhotoById(@Path("id") type: Int): PostDto
}
