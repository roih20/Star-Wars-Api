package com.rodrigo.starwars.viewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rodrigo.starwars.R
import com.rodrigo.starwars.api.Results
import com.rodrigo.starwars.api.StarWarsPeople

class StarWarsRv: RecyclerView.Adapter<StarWarsRv.ViewHolder>() {

    private var character = ArrayList<StarWarsPeople>()

    fun setData(newList: ArrayList<StarWarsPeople>){
        this.character = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(starWarsPeople: StarWarsPeople){
            itemView.apply {
                    findViewById<TextView>(R.id.name_txt).text = starWarsPeople.name
                    findViewById<TextView>(R.id.height_txt).text = starWarsPeople.height.toString()
                    findViewById<TextView>(R.id.gender_txt).text = starWarsPeople.gender

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val card = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_people, parent, false)

        return ViewHolder(card)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       character?.let {
           holder.bind(it[position])
       }
    }

    override fun getItemCount(): Int{
        return character.size
    }
}