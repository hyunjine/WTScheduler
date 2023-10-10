package com.example.wtscheduler.presenter.exercise.adapter

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.wtscheduler.common.extension.setOnSingleClickListener
import com.example.wtscheduler.databinding.ItemExerciseBinding
import com.example.wtscheduler.presenter.exercise.model.Exercise

class ExerciseAdapter: ListAdapter<Exercise, ExerciseAdapter.ExerciseViewHolder>(ExerciseDiff) {
    var itemClickListener: ((Int) -> Unit)? = null

    inner class ExerciseViewHolder(private val binding: ItemExerciseBinding): RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnSingleClickListener {
                itemClickListener?.invoke(adapterPosition)
            }
        }

        fun bind(item: Exercise) = binding.run {
            tvName.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseViewHolder {
        return ExerciseViewHolder(ItemExerciseBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ExerciseViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    private object ExerciseDiff: DiffUtil.ItemCallback<Exercise>() {
        override fun areItemsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Exercise, newItem: Exercise): Boolean {
            return oldItem == newItem
        }
    }
}