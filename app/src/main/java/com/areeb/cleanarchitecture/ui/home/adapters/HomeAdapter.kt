package com.areeb.cleanarchitecture.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.areeb.cleanarchitecture.data.models.PostDto
import com.areeb.cleanarchitecture.databinding.ItemClassBinding
import com.areeb.cleanarchitecture.ui.common.ItemListener.ItemClickListener
import com.areeb.cleanarchitecture.ui.common.diffCallBack.DiffCallBack
import com.areeb.cleanarchitecture.ui.home.viewHolder.HomeViewHolder

class HomeAdapter(
    private val clickListener: ItemClickListener<PostDto>
) : ListAdapter<PostDto, HomeViewHolder>(DiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = ItemClassBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: HomeViewHolder, position: Int) {
        viewHolder.bind(
            getItem(position),
            clickListener
        )
    }
}
