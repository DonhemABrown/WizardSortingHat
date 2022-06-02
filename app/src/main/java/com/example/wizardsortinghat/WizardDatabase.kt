package com.example.wizardsortinghat

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//1 -  annotation       //2 - entities
@Database(entities = [Wizards::class], version = 1, exportSchema = false) //Students = Wizards
//3 - abstract and extend
abstract class WizardDatabase : RoomDatabase(){
    //4 abstract and return Dao
    abstract fun wizardDao(): WizardDao
    //5 - Singleton
    companion object {
        var INSTANCE: WizardDatabase? = null
        fun getInstance(context: Context): WizardDatabase? {
            if(INSTANCE == null) {
                //6 - we are acquiring an instance of RoomDB builder
                synchronized(WizardDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        WizardDatabase::class.java, "students.db")
                        .allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
        fun destroyInstance() {
            INSTANCE = null
        }
    }
}

