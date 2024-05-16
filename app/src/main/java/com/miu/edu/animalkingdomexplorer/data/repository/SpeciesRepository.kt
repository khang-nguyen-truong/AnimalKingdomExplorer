package com.miu.edu.animalkingdomexplorer.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.miu.edu.animalkingdomexplorer.data.database.AnimalKingdomDatabase
import com.miu.edu.animalkingdomexplorer.data.model.Species
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SpeciesRepository {

    companion object {

        private var database: AnimalKingdomDatabase? = null

        private var speciesList: LiveData<List<Species>>? = null

        fun initializeDB(context: Context) : AnimalKingdomDatabase {
            return AnimalKingdomDatabase.getDatabase(context)
        }

        fun insertData(context: Context, species: Species) {

            database = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                database?.speciesDao()?.insertSpecies(species)
            }

        }

        fun getSpeciesDataList(context: Context) : LiveData<List<Species>>? {

            database = initializeDB(context)

            speciesList = database?.speciesDao()?.getAllSpecies()

            return speciesList
        }

    }
}