package com.example.wizardsortinghat //switch to wizard


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//4
class WizardAdapter(private val onCardClick: (position: Int) -> Unit,
                     private val wizardList: List<Wizards>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflate a view and return it
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.wizard_list_item_layout, parent, false)
        return ViewHolder(view, onCardClick)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // add current item to the holder

        val itemVM = wizardList[position]
        holder.name.text = itemVM.name
        holder.house.text = itemVM.house
// 3
//        holder.onClickListener {
//            var a = MainActivity()
//            a.onClick(position)
//        }
    }

    override fun getItemCount(): Int {
        // return the size of the datasource
        return wizardList.size
    }
}



//5
class ViewHolder(view: View, private val onCardClick: (position: Int) -> Unit)
    :RecyclerView.ViewHolder(view), View.OnClickListener  {
    init {
        itemView.setOnClickListener(this)
    }
    val name : TextView = view.findViewById(R.id.name)
    val house : TextView = view.findViewById(R.id.house)
    //6
    override fun onClick(v: View?) {
        val position = adapterPosition
        //7 - the function below is what is passed and referring to the one in MainActivity
        onCardClick(position)
    }
}