package com.example.wizardsortinghat

import androidx.lifecycle.LiveData
import androidx.room.*

//
@Dao
interface WizardDao {
    //CRUD
    //create
    @Insert
    fun insertWizard(wizard : Wizards)
    //Read
    @Query("select * from wizards")
    //change to live data for viewmodel
    fun selectWizards(): LiveData<List<Wizards>>

/*    @Query("select * from wizards where house = :gryffindor")
    //change to live data for viewmodel
    fun selectGryffindor(): LiveData<List<Wizards>>

    @Query("select * from wizards where house = :slytherin")
    //change to live data for viewmodel
    fun selectSlytherin(): LiveData<List<Wizards>>

    @Query("select * from wizards where house = :ravenclaw")
    //change to live data for viewmodel
    fun selectRavenclaw(): LiveData<List<Wizards>>

    @Query("select * from wizards where house = :hufflepuff")
    //change to live data for viewmodel
    fun selectHufflepuff(): LiveData<List<Wizards>>*/

    //update
    @Update
    fun updateWizard(wizard : Wizards)

    //Delete
    @Delete
    fun deleteWizard(wizard : Wizards)
}