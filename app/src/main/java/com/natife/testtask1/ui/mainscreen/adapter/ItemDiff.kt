package com.natife.testtask1.ui.mainscreen.adapter

import androidx.recyclerview.widget.DiffUtil
import com.natife.testtask1.data.Item


class ItemDiff : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return true
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return true
    }
}
