package com.areeb.cleanarchitecture.ui.home.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.areeb.cleanarchitecture.data.models.PostDto
import com.areeb.cleanarchitecture.databinding.ItemClassBinding
import com.areeb.cleanarchitecture.utils.setImageView

class HomeViewHolder(private val bindingAdapter: ItemClassBinding) :
    RecyclerView.ViewHolder(bindingAdapter.root) {

    private lateinit var post: PostDto

    fun bind(post: PostDto) {
        this.post = post

        bindingAdapter.itemTextView.text = post.title
        setImageView(bindingAdapter.itemImageView, post.url)
    }
}
