package com.example.pdm_parcial1.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pdm_parcial1.R
import com.example.pdm_parcial1.Room.Entities.MatchEntity
import kotlinx.android.synthetic.main.matches_cardview.view.*

class MatchAdapter(var items : List<MatchEntity>, val clickListener : (MatchEntity) -> Unit) : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.matches_cardview,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], clickListener)
    }


    fun dataChange(lista_books : List<MatchEntity>){
        items = lista_books
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: MatchEntity,clickListener: (MatchEntity) -> Unit) = with(itemView) {
            tv_title_match.text = item.MatchName
            this.setOnClickListener{clickListener(item)}
        }
    }
}