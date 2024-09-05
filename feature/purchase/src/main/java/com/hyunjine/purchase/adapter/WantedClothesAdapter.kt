package com.hyunjine.purchase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hyunjine.common_android.util.ItemTouchHelperCallback
import com.hyunjine.purchase.WantedClothesModel
import com.hyunjine.purchase.databinding.ItemWantedClothesBinding
import java.util.Collections

class WantedClothesAdapter: ListAdapter<WantedClothesModel, WantedClothesViewHolder>(WantedClothesDiffUtil), ItemTouchHelperCallback.OnItemMoveListener {
    private object WantedClothesDiffUtil: DiffUtil.ItemCallback<WantedClothesModel>() {
        override fun areItemsTheSame(
            oldItem: WantedClothesModel,
            newItem: WantedClothesModel
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: WantedClothesModel,
            newItem: WantedClothesModel
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WantedClothesViewHolder {
        return WantedClothesViewHolder(
            binding = ItemWantedClothesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: WantedClothesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onMoveItem(fromPosition: Int, toPosition: Int) {
        val newList = mutableListOf<WantedClothesModel>()
        newList.addAll(currentList)
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(newList, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(newList, i, i - 1)
            }
        }
        submitList(newList)
//        if (::moveListener.isInitialized) moveListener(newList)
    }

    override fun onSelectedItem(itemViewHolder: RecyclerView.ViewHolder?) {
//        itemViewHolder?.itemView?.setBackgroundResource(R.drawable.bg_round_edge_rectangle_black_transparent_20dp)
    }

    override fun onClearItem(itemViewHolder: RecyclerView.ViewHolder?) {
//        itemViewHolder?.itemView?.setBackgroundResource(R.drawable.bg_round_edge_rectangle_black_20dp)
    }
}