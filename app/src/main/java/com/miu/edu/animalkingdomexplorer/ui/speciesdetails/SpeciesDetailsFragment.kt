package com.miu.edu.animalkingdomexplorer.ui.speciesdetails

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.miu.edu.animalkingdomexplorer.data.model.Species
import com.miu.edu.animalkingdomexplorer.databinding.FragmentSpeciesDetailsBinding

class SpeciesDetailsFragment : Fragment(), OnAddSpeciesItemClicked {

    private lateinit var binding: FragmentSpeciesDetailsBinding
    private lateinit var speciesViewModel: SpeciesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSpeciesDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        speciesViewModel = ViewModelProvider(this)[SpeciesViewModel::class.java]

        speciesViewModel.getSpeciesList(requireContext())?.observe(viewLifecycleOwner) { speciesList ->
            speciesList?.let {
                binding.speciesRecyclerView.adapter = SpeciesAdapter().apply {
                    submitList(it)
                }
            }
        }
        binding.addSpecies.setOnClickListener {
            val speciesDialog = SpeciesDialogFragment(this)
            speciesDialog.show(childFragmentManager, speciesDialog.tag)
        }
    }

    override fun onSpeciesItemClick(species: Species, dialog: Dialog?) {
        speciesViewModel.insertData(requireContext(),species)
        dialog?.dismiss()
    }
}