package com.miu.edu.animalkingdomexplorer.ui.animaldetails

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.miu.edu.animalkingdomexplorer.data.model.Animal
import com.miu.edu.animalkingdomexplorer.data.repository.AnimalRepository

class AnimalViewModel : ViewModel() {

    var animalListLiveData: LiveData<List<Animal>>? = null

    fun insertData(context: Context, animal: Animal) {
        AnimalRepository.insertData(context,animal)
    }

    fun getAnimalList(context: Context): LiveData<List<Animal>>? {
        animalListLiveData = AnimalRepository.getAnimalDataList(context)
        return animalListLiveData
    }

}