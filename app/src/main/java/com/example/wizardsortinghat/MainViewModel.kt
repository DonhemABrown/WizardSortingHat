package com.example.wizardsortinghat

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch


class MainViewModel(app: Application): AndroidViewModel(app){
    private val repo: WizardRepository
    val allWizards : LiveData<List<Wizards>>?

    init{
        repo = WizardRepository(app)
        allWizards = repo.getAllWizards()
    }

    fun getAllWizards()= viewModelScope.launch {
        //return db?.selectWizards() ?: listOf<Wizards>()
        repo.getAllWizards()
    }


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