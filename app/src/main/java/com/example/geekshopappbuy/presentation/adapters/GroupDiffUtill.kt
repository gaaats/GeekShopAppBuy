package com.example.geekshopappbuy.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.example.geekshopappbuy.domain.entitys.GeekGroupUI

class GroupDiffUtill: DiffUtil.ItemCallback<GeekGroupUI>() {
    override fun areItemsTheSame(oldItem: GeekGroupUI, newItem: GeekGroupUI): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: GeekGroupUI, newItem: GeekGroupUI): Boolean {
        return oldItem == newItem
    }
}