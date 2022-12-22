package com.areeb.cleanarchitecture.data.network.network.remote.api.home

import com.areeb.cleanarchitecture.data.models.PostDto
import retrofit2.http.GET

interface HomeApi {

    @GET("/photos")
    suspend fun getPhotos(): List<PostDto>
}
