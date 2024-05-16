package com.miu.edu.animalkingdomexplorer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.miu.edu.animalkingdomexplorer.R
import com.miu.edu.animalkingdomexplorer.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private lateinit var binding : FragmentDashboardBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding  = FragmentDashboardBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.speciesDetailsButton.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_speciesDetailsFragment)

        }

        binding.animalDetailsButton.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_animalDetailsFragment)
        }
    }
}