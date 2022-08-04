package com.example.geekshopappbuy.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import coil.load
import com.example.geekshopappbuy.R
import com.example.geekshopappbuy.domain.entitys.GeekGroupUI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class GroupsListAdapter @Inject constructor(


) :
    ListAdapter<GeekGroupUI, GroupRecVVievHolder>(GroupDiffUtill()) {

    private var onItemClickListener : ((groupId: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupRecVVievHolder {
        LayoutInflater.from(parent.context)
            .inflate(R.layout.single_item_group_, parent, false).also {
                return GroupRecVVievHolder(it)
            }
    }

    override fun onBindViewHolder(holder: GroupRecVVievHolder, position: Int) {
        val currentItem = getItem(position)
        holder.binding.apply {
            tvTitle.text = currentItem.name
            tvDescription.text = currentItem.description
            if (currentItem.image.isEmpty()) {
                img.setImageResource(R.drawable.news)
            } else {
                CoroutineScope(Dispatchers.IO).launch {
                    img.load(currentItem.image) {
                        placeholder(R.drawable.ic_baseline_downloading_24)
                    }
                }
            }
            root.setOnClickListener {
                onItemClickListener?.invoke(currentItem.id)
            }
        }
    }

    fun setOnItemClickListener (listener: (groupId: Int)-> Unit){
        onItemClickListener = listener
    }
}