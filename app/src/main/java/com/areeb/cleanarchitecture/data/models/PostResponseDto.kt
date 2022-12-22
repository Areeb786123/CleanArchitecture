package com.areeb.cleanarchitecture.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostResponseDto(
    val result: List<PostDto>
) : Parcelable
