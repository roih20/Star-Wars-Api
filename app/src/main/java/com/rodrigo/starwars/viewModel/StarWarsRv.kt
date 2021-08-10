package com.rodrigo.starwars.viewModel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rodrigo.starwars.R
import com.rodrigo.starwars.api.Results

class StarWarsRv: RecyclerView.Adapter<StarWarsRv.ViewHolder>() {

    private var character = emptyList<Results>()

    fun setData(newList: List<Results>){
        character = newList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(response: Results){
            itemView.apply {

                response.results.forEach { starWarsPeople ->
                    findViewById<TextView>(R.id.name_txt).text = starWarsPeople.name
                    findViewById<TextView>(R.id.gender_txt).text = starWarsPeople.gender
                    findViewById<TextView>(R.id.height_txt).text = starWarsPeople.height.toString()
                }

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