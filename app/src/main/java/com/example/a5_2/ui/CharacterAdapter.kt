package com.example.a5_2.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a5_2.databinding.ItemCharactersBinding
import com.example.a5_2.model.Characters
import com.example.a5_2.model.Result
import com.example.rickandmorty3.extencion.glide

class CharacterAdapter(private var characters: Characters,private var onClick:(Int)->Unit):RecyclerView.Adapter<CharacterAdapter.ViewHolder> (){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemCharactersBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(characters.results[position])
    }

    override fun getItemCount(): Int  {
        return characters.results.size
    }



    inner class ViewHolder(private val binding: ItemCharactersBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(result: Result) {
            Log.e("adapter", "bind: $result")
            binding.tvNamePersonCharacter.text = result.name
            binding.tvNamePerson1.text = result.species
            binding.imageIcon.glide(result.image)
            itemView.setOnClickListener{
                onClick(result.id)
            }
        }
    }
}