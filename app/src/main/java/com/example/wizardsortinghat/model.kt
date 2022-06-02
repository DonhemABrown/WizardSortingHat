package com.example.wizardsortinghat

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wizards")
data class Wizards(@PrimaryKey(autoGenerate = true)var wizardId: Int?,
                    @ColumnInfo(name = "name")var name: String?,
                    @ColumnInfo(name = "house")var house: String?){

}

