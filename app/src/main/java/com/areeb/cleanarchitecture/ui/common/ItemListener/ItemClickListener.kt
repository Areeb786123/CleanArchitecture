package com.areeb.cleanarchitecture.ui.common.ItemListener

class ItemClickListener<T> (val clickListener: (t: T) -> Unit) {
    fun onClick(t: T) = clickListener(t)
}
