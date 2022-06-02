package com.example.wizardsortinghat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class UpdateWizard : AppCompatActivity() {

    lateinit var vm: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.update_wizard)

        vm = MainViewModel(application)
        var id: TextView = findViewById(R.id.theid)
        var name: EditText = findViewById(R.id.thename)
        var house: EditText = findViewById(R.id.thehouse)
        var update: Button = findViewById(R.id.update)
        var delete: Button = findViewById(R.id.expel)


        id.setText(intent.getIntExtra("Id",0).toString())
        name.setText(intent.getStringExtra("name"))
        house.setText(intent.getStringExtra("house"))

        update.setOnClickListener {
            vm.updateWizard(Wizards(id.text.toString().toInt(), name.text.toString(), house.text.toString()))
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)


        }

        delete.setOnClickListener {
            vm.deleteWizard(Wizards(id.text.toString().toInt(), name.text.toString(), house.text.toString()))
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)


        }


    }
}