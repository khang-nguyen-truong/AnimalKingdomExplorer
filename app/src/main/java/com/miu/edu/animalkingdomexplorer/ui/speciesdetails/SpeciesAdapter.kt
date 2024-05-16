package com.miu.edu.animalkingdomexplorer.ui.speciesdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.miu.edu.animalkingdomexplorer.data.model.Species
import com.miu.edu.animalkingdomexplorer.databinding.ItemSpeciesBinding

class SpeciesAdapter : ListAdapter<Species, SpeciesAdapter.ViewHolder>(diffUtil) {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Species>() {
            override fun areItemsTheSame(
                oldItem: Species,
                newItem: Species
            ): Boolean = oldItem == newItem

            override fun areContentsTheSame(
                oldItem: Species,
                newItem: Species
            ): Boolean = oldItem == newItem

        }
    }

    inner class ViewHolder(
        private val binding: ItemSpeciesBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun updateView(item: Species) {
            binding.name.text = item.name
            binding.description.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemSpeciesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.updateView(getItem(position))
    }
}