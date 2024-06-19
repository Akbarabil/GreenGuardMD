package com.example.greenguard.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.greenguard.databinding.ItemForumBinding

class ForumAdapter(private val dataList: List<ItemData>) :
    RecyclerView.Adapter<ForumAdapter.ViewHolder>() {

    data class ItemData(val title: String, val description: String)

    inner class ViewHolder(private val binding: ItemForumBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemData) {
            binding.apply {
                titleName.text = item.title
                descriptionForum.text = item.description
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemForumBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    override fun getItemCount() = dataList.size
}