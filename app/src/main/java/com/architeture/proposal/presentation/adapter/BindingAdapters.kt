package com.architeture.proprosal.presentation.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.architeture.proprosal.presentation.utils.safeLet

@BindingAdapter("items")
fun setItems(recyclerView: RecyclerView, list: List<Any>?) {
    safeLet(recyclerView.adapter, list) {adapter, listLet ->
        if (adapter is AdapterItemsContract) {
            adapter.replaceItems(listLet)
        }
    }
}