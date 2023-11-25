package com.example.studyfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.studyfragment.databinding.ItemDataBinding

class DataAdapter(private val items: List<String>): RecyclerView.Adapter<DataAdapter.DataViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val layout_inflatter = LayoutInflater.from(parent.context)
        return DataViewHolder(ItemDataBinding.inflate(layout_inflatter, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    class DataViewHolder(private val binding: ItemDataBinding): RecyclerView.ViewHolder(binding.root){
        fun bindView(item: String) {
            binding.title.text = item
        }
    }
}