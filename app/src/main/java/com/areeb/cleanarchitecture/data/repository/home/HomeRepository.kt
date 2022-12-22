package com.areeb.cleanarchitecture.data.repository.home

import com.areeb.cleanarchitecture.data.RemoteOperations
import com.areeb.cleanarchitecture.data.models.PostDto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val remoteOperations: RemoteOperations
) {
    fun getPhotos(): Flow<List<PostDto>> {
        return flow {
            val photosResponse = remoteOperations.getPhotos()
            emit(photosResponse)
        }.flowOn(Dispatchers.IO)
    }
}
