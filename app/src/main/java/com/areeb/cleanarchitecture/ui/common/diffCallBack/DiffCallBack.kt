package com.areeb.cleanarchitecture.ui.common.diffCallBack

import androidx.recyclerview.widget.DiffUtil
import com.areeb.cleanarchitecture.data.models.PostDto

class DiffCallBack : DiffUtil.ItemCallback<PostDto>() {
    override fun areItemsTheSame(oldItem: PostDto, newItem: PostDto): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PostDto, newItem: PostDto): Boolean {
       return  oldItem == newItem
    }
}