package com.miu.edu.animalkingdomexplorer.ui.animaldetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.miu.edu.animalkingdomexplorer.data.model.Animal
import com.miu.edu.animalkingdomexplorer.databinding.ItemAnimalBinding

class AnimalAdapter : ListAdapter<Animal, AnimalAdapter.ViewHolder>(diffUtil) {

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Animal>() {
            override fun areItemsTheSame(
                oldItem: Animal,
                newItem: Animal
            ): Boolean = oldItem == newItem

            override fun areContentsTheSame(
                oldItem: Animal,
                newItem: Animal
            ): Boolean = oldItem == newItem

        }
    }

    inner class ViewHolder(
        private val binding: ItemAnimalBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun updateView(item: Animal) {

            binding.name.text = item.name
            binding.habitat.text = item.habitat
            binding.diet.text = item.diet
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAnimalBinding.inflate(
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