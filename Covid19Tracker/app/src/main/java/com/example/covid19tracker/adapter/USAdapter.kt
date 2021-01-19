package com.example.covid19tracker.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19tracker.R
import com.example.covid19tracker.modelclass.USModel
import com.example.covid19tracker.useruimodel.USUIModel
import com.example.covid19tracker.viewholder.USViewHolder

class USAdapter(private var usModelList: List<USModel>) :RecyclerView.Adapter<USViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): USViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return USViewHolder(view)
    }

    override fun onBindViewHolder(holder: USViewHolder, position: Int) {
        val dataModel = usModelList[position]
        holder.setData(dataModel)
    }

    override fun getItemCount(): Int {
       return usModelList.size
    }
    fun updateList(modelList: List<USModel>) {
        usModelList = modelList
        notifyDataSetChanged()
    }
}