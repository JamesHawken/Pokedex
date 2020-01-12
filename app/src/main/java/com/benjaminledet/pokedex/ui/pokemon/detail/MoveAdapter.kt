package com.benjaminledet.pokedex.ui.pokemon.detail

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.benjaminledet.pokedex.R
import com.benjaminledet.pokedex.data.model.Move

class MoveAdapter (val movesList: ArrayList<String> ): RecyclerView.Adapter<MoveAdapter.ViewHolder>()
{
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.moves_layout, p0, false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
        return  movesList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val move:String= movesList[position]
        Log.d("MoveAdapter", move)
        holder.textViewMove.text= move

    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textViewMove= itemView.findViewById(R.id.moveTextView) as TextView

    }
}