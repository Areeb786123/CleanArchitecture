package com.areeb.cleanarchitecture.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostDto(
    val id: Int? = null,
    val title: String? = null,
    val url: String? = null
) : Parcelable
