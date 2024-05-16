package com.miu.edu.animalkingdomexplorer.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.miu.edu.animalkingdomexplorer.data.model.Animal

@Dao
interface AnimalDao {

    @Query("SELECT * FROM animals")
    fun getAllAnimals(): LiveData<List<Animal>>

    @Query("SELECT * FROM animals WHERE id = :animalID")
    fun getAnimalById(animalID: Int): LiveData<Animal>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAnimal(animal: Animal)

    @Query("DELETE FROM animals")
    suspend fun deleteAllAnimals()
}