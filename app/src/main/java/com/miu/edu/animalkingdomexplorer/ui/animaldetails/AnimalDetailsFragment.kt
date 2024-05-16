package com.miu.edu.animalkingdomexplorer.ui.animaldetails

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.miu.edu.animalkingdomexplorer.data.model.Animal
import com.miu.edu.animalkingdomexplorer.databinding.FragmentAnimalDetailsBinding

class AnimalDetailsFragment : Fragment(), OnAddAnimalItemClicked {

    private lateinit var binding: FragmentAnimalDetailsBinding

    private lateinit var animalViewModel: AnimalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentAnimalDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        animalViewModel = ViewModelProvider(this)[AnimalViewModel::class.java]

        animalViewModel.getAnimalList(requireContext())?.observe(viewLifecycleOwner) { animalList ->
            animalList?.let {
                if (animalList.isNotEmpty()) {
                    binding.animalRecyclerView.adapter = AnimalAdapter().apply {
                        submitList(it)
                    }
                }
            }
        }
        binding.addAnimal.setOnClickListener {
            val animalDialog = AnimalDialogFragment(this)
            animalDialog.show(childFragmentManager, animalDialog.tag)
        }
    }

    override fun onAnimalItemClick(animal: Animal, dialog: Dialog?) {
        animalViewModel.insertData(requireContext(),animal)
        dialog?.dismiss()
    }
}