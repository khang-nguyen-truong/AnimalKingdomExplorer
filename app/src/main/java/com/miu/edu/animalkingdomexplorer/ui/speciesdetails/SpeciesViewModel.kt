package com.miu.edu.animalkingdomexplorer.ui.speciesdetails

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.miu.edu.animalkingdomexplorer.data.model.Species
import com.miu.edu.animalkingdomexplorer.data.repository.SpeciesRepository

class SpeciesViewModel  : ViewModel(){

    var speciesListLiveData: LiveData<List<Species>>? = null

    fun insertData(context: Context, species: Species) {
        SpeciesRepository.insertData(context,species)
    }

    fun getSpeciesList(context: Context): LiveData<List<Species>>? {
        speciesListLiveData = SpeciesRepository.getSpeciesDataList(context)
        return speciesListLiveData
    }

}