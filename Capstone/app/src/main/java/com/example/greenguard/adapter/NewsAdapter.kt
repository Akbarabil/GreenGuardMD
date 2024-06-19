package com.example.greenguard.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.greenguard.databinding.ItemCardBinding

class NewsAdapter(private val dataList: List<ItemData>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    data class ItemData(val title: String, val description: String, val imageResId: Int, val url: String)

    inner class ViewHolder(private val binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ItemData) {
            binding.apply {
                imageViewCard.setImageResource(item.imageResId)
                textViewCardTitle.text = item.title
                textViewCardDescription.text = item.description

                // Set OnClickListener untuk membuka URL ketika card di klik
                root.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
                    root.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
    }

    override fun getItemCount() = dataList.size
}
