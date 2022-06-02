package com.example.wizardsortinghat

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MainViewModel(app: Application): AndroidViewModel(app){
    private val repo: WizardRepository
    val allWizards : LiveData<List<Wizards>>?
    val allGryffindor: LiveData<List<Wizards>>?
    val allHufflepuff: LiveData<List<Wizards>>?
    val allRavenclaw: LiveData<List<Wizards>>?
    val allSlytherin: LiveData<List<Wizards>>?

    init{
        repo = WizardRepository(app)
        allWizards = repo.getAllWizards()
        allGryffindor = repo.getAllGryffindor()
        allHufflepuff = repo.getAllHufflepuff()
        allRavenclaw = repo.getAllRavenclaw()
        allSlytherin = repo.getAllSlytherin()
    }

    fun getAllWizards()= viewModelScope.launch {
        //return db?.selectWizards() ?: listOf<Wizards>()
        repo.getAllWizards()
    }

    fun getAllGryffindor() = viewModelScope.launch {
        //return db?.selectWizards() ?: listOf<Wizards>()
        repo.getAllGryffindor()
    }

    fun getAllHufflepuff() = viewModelScope.launch {
        //return db?.selectWizards() ?: listOf<Wizards>()
        repo.getAllHufflepuff()
    }
    fun getAllRavenclaw() = viewModelScope.launch {
        //return db?.selectWizards() ?: listOf<Wizards>()
        repo.getAllRavenclaw()
    }

    fun getAllSlytherin() = viewModelScope.launch {
        //return db?.selectWizards() ?: listOf<Wizards>()
        repo.getAllSlytherin()
    }
//

    fun search(searchText: String) = viewModelScope.launch {
        repo.search(searchText)
    }

    fun insertWizard(wizards: Wizards) = viewModelScope.launch {
        repo.insertWizard(wizards)
    }

    fun updateWizard(wizards: Wizards) {
        repo.updateWizard(wizards)
    }

    fun deleteWizard(wizards: Wizards){
        repo.deleteWizard(wizards)
    }
}