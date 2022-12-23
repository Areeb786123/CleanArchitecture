package com.areeb.cleanarchitecture.ui.homeDetail.viewModel

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.areeb.cleanarchitecture.data.Resource
import com.areeb.cleanarchitecture.data.models.PostDto
import com.areeb.cleanarchitecture.data.repository.home.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {
    companion object {
        private const val TAG = "Detail ViewModel"
    }

    private val _photoDetail = MutableLiveData<PostDto>()
    val photoDetail: LiveData<PostDto>
        get() = _photoDetail

    private val _resourceStatus = MutableLiveData<Resource<Any>?>()
    val resourceStatus: LiveData<Resource<Any>?>
        get() = _resourceStatus

    fun saveBundlesArguments(bundle: Bundle?) {
        viewModelScope.launch {
            val photoId = bundle?.getInt("postId", 0)
            photoId?.let { getPostDetailsById(it) }
        }
    }
    fun clearResourceStatus() {
        _resourceStatus.value = null
    }

    private fun getPostDetailsById(id: Int) {
        viewModelScope.launch {
            setResourceStatus(Resource.Loading(true))
            repository.getPhotosById(id)
                .catch {
                    Log.e("error", TAG)
                }.collect {
                    setPhotoByIdResponse(it)
                }
        }
    }

    private fun setPhotoByIdResponse(photo: Resource<PostDto>) {
        viewModelScope.launch {
            setResourceStatus(Resource.Success(true))
            if (photo is Resource.Success) {
                photo.data.let {
                    _photoDetail.value = it
                }
            }
        }
    }

    fun setResourceStatus(resourceStatus: Resource<Any>?) {
        _resourceStatus.value = resourceStatus
    }
}
