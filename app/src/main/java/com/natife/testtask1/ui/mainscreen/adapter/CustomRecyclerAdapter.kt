package com.natife.testtask1.ui.mainscreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.natife.testtask1.data.Item
import com.natife.testtask1.databinding.ListItemBinding

class CustomRecyclerAdapter(
    private var listener: OnItemClickListener
) : RecyclerView.Adapter<CustomRecyclerAdapter.CustomViewHolder>() {

    private var listItem: ArrayList<Item> = arrayListOf()

    class CustomViewHolder(
        private val listener: OnItemClickListener,
        private val itemBinding: ListItemBinding
    ) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Item) {
            itemBinding.apply {
                nameItem.text = item.name
            }
            itemBinding.root.setOnClickListener {
                listener.onItemClicked(item.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ListItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CustomViewHolder(listener, binding)
    }

    override fun onBindViewHolder(viewHolder: CustomViewHolder, position: Int) {
        viewHolder.bind(listItem[position])
    }

    override fun getItemCount() = listItem.size

    fun updateList(list: List<Item>) {
        listItem.addAll(list)
        notifyDataSetChanged()
    }

    interface OnItemClickListener {
        fun onItemClicked(id: Int)
    }
}