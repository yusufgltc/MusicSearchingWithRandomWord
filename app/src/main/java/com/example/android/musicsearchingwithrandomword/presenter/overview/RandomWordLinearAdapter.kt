package com.example.android.musicsearchingwithrandomword.presenter.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.musicsearchingwithrandomword.databinding.LinearListItemBinding
import com.example.android.musicsearchingwithrandomword.network.models.RandomWord

class RandomWordLinearAdapter : ListAdapter<RandomWord,
        RandomWordLinearAdapter.RandomWordViewHolder>(DiffCallback) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RandomWordViewHolder {
        return RandomWordViewHolder(
            LinearListItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(
        holder: RandomWordViewHolder,
        position: Int
    ) {
        val randomWord = getItem(position)
        holder.bind(randomWord)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<RandomWord>() {
        override fun areItemsTheSame(oldItem: RandomWord, newItem: RandomWord): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: RandomWord, newItem: RandomWord): Boolean {
            return oldItem.word == newItem.word
        }
    }

    class RandomWordViewHolder(
        private var binding: LinearListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(randomWord: RandomWord) {
            binding.randomWord = randomWord
            binding.executePendingBindings()
        }
    }

}