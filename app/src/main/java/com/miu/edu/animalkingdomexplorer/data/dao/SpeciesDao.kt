package com.miu.edu.animalkingdomexplorer.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.miu.edu.animalkingdomexplorer.data.model.Species

@Dao
interface SpeciesDao {

    @Query("SELECT * FROM species")
    fun getAllSpecies(): LiveData<List<Species>>

    @Query("SELECT * FROM species WHERE id = :speciesID")
    fun getSpeciesById(speciesID: Int): LiveData<Species>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSpecies(species: Species)

    @Query("DELETE FROM species")
    suspend fun deleteAllSpecies()
}