package com.example.wizardsortinghat

import android.content.Context
import androidx.lifecycle.LiveData


class WizardRepository(context: Context) {
    var db: WizardDao? = WizardDatabase.getInstance(context)?.wizardDao()!!


    fun getAllWizards(): LiveData<List<Wizards>>? {

        return db?.selectWizards()
    }

    fun search(searchText: String): LiveData<List<Wizards>> {
        return search(searchText)
    }

    fun insertWizard(wizards: Wizards) {
        db?.insertWizard(wizards)
    }

    fun updateWizard(wizards: Wizards) {
        db?.updateWizard(wizards)
    }

    fun deleteWizard(wizards: Wizards) {
        db?.deleteWizard(wizards)
    }


}