package com.special.robinhood.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.special.robinhood.R
import com.special.robinhood.databinding.CustomItemBinding

class SampleAdapter constructor(
        private val listener: OnHolderClickListener,
        private val itemList: ArrayList<String> = arrayListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun setItem(items: List<String>) {
        itemList.clear()
        itemList.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemBinding = CustomItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SampleHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = itemList[position]
        if (holder is SampleHolder) {
            holder.bind(data, listener)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    interface OnHolderClickListener {
        fun onClick(display: String)
    }

    inner class SampleHolder(private val itemBinding: CustomItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(display: String, listener: OnHolderClickListener) {
            itemBinding.apply {
                tvTitle.text = display + "title"
                tvDetail.text = display + "description"
                ivMenu.setImageResource(R.drawable.ic_launcher_background)
                itemView.setOnClickListener {
                    listener.onClick(display)
                }
            }
        }
    }
}