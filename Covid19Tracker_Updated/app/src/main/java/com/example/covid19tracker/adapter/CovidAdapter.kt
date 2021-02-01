package com.example.covid19tracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19tracker.ItemClickListener
import com.example.covid19tracker.R
import com.example.covid19tracker.database.Users
import com.example.covid19tracker.viewholder.CovidViewHolder

class CovidAdapter(private var usModelList: List<Users>, val itemClickListener: ItemClickListener) :RecyclerView.Adapter<CovidViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return CovidViewHolder(view,itemClickListener)
    }

    override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
        val dataModel = usModelList[position]
        holder.setData(dataModel)
    }

    override fun getItemCount(): Int {
       return usModelList.size
    }
    fun updateList(modelList: List<Users>) {
        usModelList = modelList
        notifyDataSetChanged()
    }
}