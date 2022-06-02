package com.example.wizardsortinghat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SortToHouse : AppCompatActivity() {
    /*
        val repo: StudentRepository by lazy {
            StudentRepository(this)
        }
    */
    lateinit var vm: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sort_form)

        vm = MainViewModel(application)
        var name: EditText = findViewById(R.id.name)
        var house: EditText = findViewById(R.id.house)
        var save: Button = findViewById(R.id.save)


        save.setOnClickListener {
            vm.insertWizard(Wizards(null, name.text.toString(), house.text.toString()))
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }

    }
}