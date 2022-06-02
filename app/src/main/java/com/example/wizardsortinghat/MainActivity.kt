package com.example.wizardsortinghat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var wizardList : ArrayList<Wizards>
    lateinit var vm : MainViewModel
   lateinit var adapter : WizardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm = MainViewModel(application)
        wizardList = ArrayList()

     val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        // assigned the layout manager of the view
        recyclerView.layoutManager = LinearLayoutManager(this)
        //3
        //create an adapter with data source
        adapter = WizardAdapter({position -> onCardClick(position) }, wizardList)

        //Take the views adapter and then assign it to the custom adapter we created

        recyclerView.adapter = adapter
        // assign the adapter view


        var gryf: ImageButton = findViewById(R.id.gryf)
        gryf.setOnClickListener {
            val myIntent = Intent(this, GetGryffindor::class.java)
            startActivity(myIntent)
        }

        var huff: ImageButton = findViewById(R.id.huff)
        huff.setOnClickListener {
            val myIntent = Intent(this, GetHufflepuff::class.java)
            startActivity(myIntent)
        }
        var rave: ImageButton = findViewById(R.id.rave)
        rave.setOnClickListener {
            val myIntent = Intent(this, GetRavenclaw::class.java)
            startActivity(myIntent)
        }
        var slyth: ImageButton = findViewById(R.id.slyth)
        slyth.setOnClickListener {
            val myIntent = Intent(this, GetSlytherin::class.java)
            startActivity(myIntent)
        }
        var sortToHouse: Button = findViewById(R.id.sort)
        sortToHouse.setOnClickListener {
            val myIntent = Intent(this, SortToHouse::class.java)
            startActivity(myIntent)
        }





        vm.allWizards?.observe(this, {
                wizardList -> getWizards(wizardList)
        })

    }
//fornow
    // 2. Why you need this
   fun onCardClick(position: Int) {
        println("position:::$position")
        val myIntent = Intent(this, UpdateWizard::class.java)
        myIntent.putExtra("Id", wizardList[position].wizardId)
        myIntent.putExtra("name", wizardList[position].name)
        myIntent.putExtra("house", wizardList[position].house)
        startActivity(myIntent)
    }

    fun getWizards(wizardList: List<Wizards>) {
        this.wizardList.clear()
        this.wizardList.addAll(wizardList)
        adapter.notifyDataSetChanged()
    }

}


//will have a button for each wizard house - clicking on each will go to respective house directory
//will have a button to begin sort into house (who are you)
//will display a welcome message
//In other class - create a sort method that surveys 4 qualities to select house, and create a bio
