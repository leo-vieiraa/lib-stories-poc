package com.example.libstoriespoc.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.libstoriespoc.domain.model.Story

open class StoriesDiffCallback() : DiffUtil.ItemCallback<Story>() {
    override fun areItemsTheSame(oldItem: Story, newItem: Story): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: Story, newItem: Story): Boolean = oldItem == newItem
}