package com.areeb.cleanarchitecture.ui.home.viewHolder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.areeb.cleanarchitecture.data.models.PostDto
import com.areeb.cleanarchitecture.databinding.ItemClassBinding
import com.areeb.cleanarchitecture.ui.common.ItemListener.ItemClickListener
import com.areeb.cleanarchitecture.utils.setImageView

class HomeViewHolder(private val bindingAdapter: ItemClassBinding) :
    RecyclerView.ViewHolder(bindingAdapter.root), View.OnClickListener {

    init {
        bindingAdapter.itemImageView.setOnClickListener(this)
    }

    private lateinit var post: PostDto
    private lateinit var clickListener: ItemClickListener<PostDto>

    fun bind(post: PostDto, clickListener: ItemClickListener<PostDto>) {
        this.post = post
        this.clickListener = clickListener

        bindingAdapter.itemTextView.text = post.title
        setImageView(bindingAdapter.itemImageView, post.url)
    }

    override fun onClick(view: View) {
        clickListener.onClick(post)
    }
}
