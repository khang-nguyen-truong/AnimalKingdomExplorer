package com.miu.edu.animalkingdomexplorer.data.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.miu.edu.animalkingdomexplorer.data.database.AnimalKingdomDatabase
import com.miu.edu.animalkingdomexplorer.data.model.Animal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class AnimalRepository {

    companion object {

        private var database: AnimalKingdomDatabase? = null

        private var animalList: LiveData<List<Animal>>? = null

        fun initializeDB(context: Context) : AnimalKingdomDatabase {
            return AnimalKingdomDatabase.getDatabase(context)
        }

        fun insertData(context: Context,animal: Animal) {

            database = initializeDB(context)

            CoroutineScope(IO).launch {
                database?.animalDao()?.insertAnimal(animal)
            }

        }

        fun getAnimalDataList(context: Context) : LiveData<List<Animal>>? {

            database = initializeDB(context)

            animalList = database?.animalDao()?.getAllAnimals()

            return animalList
        }

    }
}