package com.example.wtscheduler.presenter.exp_purchase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wtscheduler.common.extension.setOnSingleClickListener
import com.example.wtscheduler.databinding.ItemExpPurchaseBinding

class ExpPurchaseAdapter: ListAdapter<ExpPurchase, ExpPurchaseAdapter.ExpPurchaseViewHolder>(ExpPurchaseDiff) {
    var itemClickListener: ((ExpPurchase) -> Unit)? = null

    inner class ExpPurchaseViewHolder(private val binding: ItemExpPurchaseBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnSingleClickListener {
                itemClickListener?.invoke(currentList[adapterPosition])
            }
        }

        fun bind(data: ExpPurchase) = binding.run {
            tvLink.text = data.link
            tvName.text = data.name
        }
    }

    fun submitItem(data: ExpPurchase) {
        submitList(currentList.toMutableList().apply { add(data) })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpPurchaseViewHolder {
        return ExpPurchaseViewHolder(ItemExpPurchaseBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ExpPurchaseViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    private object ExpPurchaseDiff: DiffUtil.ItemCallback<ExpPurchase>() {
        override fun areItemsTheSame(oldItem: ExpPurchase, newItem: ExpPurchase): Boolean {
            return oldItem.seq == newItem.seq
        }

        override fun areContentsTheSame(oldItem: ExpPurchase, newItem: ExpPurchase): Boolean {
            return oldItem == newItem
        }
    }
}