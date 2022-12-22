package com.areeb.cleanarchitecture.ui.home.viewModels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.areeb.cleanarchitecture.data.Resource
import com.areeb.cleanarchitecture.data.models.PostResponseDto
import com.areeb.cleanarchitecture.data.repository.home.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {
    companion object {
        private const val TAG = "HomeViewModel"
    }

    private val _posts = MutableLiveData<PostResponseDto>()
    private val posts: LiveData<PostResponseDto>
        get() = _posts

    fun getPosts() {
        viewModelScope.launch {
            repository.getPhotos()
                .catch { exception ->
                    Log.e(TAG, exception.toString())
                }.collect {
                    setPostResponse(it)
                }
        }
    }

    private fun setPostResponse(response: Resource<PostResponseDto>) {
        if (response is Resource.Success) {
            response.data.let {
                _posts.value = it
                Log.e("postsValue", it.toString())
            }
        }
    }
}
