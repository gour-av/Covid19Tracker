package com.example.covid19tracker.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19tracker.ItemClickListener
import com.example.covid19tracker.database.Users
import kotlinx.android.synthetic.main.item_layout.view.*

class CovidViewHolder(private val view: View, val listener: ItemClickListener):RecyclerView.ViewHolder(view) {

    fun setData(covidModel: Users) {
        view.apply {
            tv_name.text = covidModel.name
            tv_state.text = covidModel.state
            btn_data.setOnClickListener(View.OnClickListener {
                listener.onItemClicked(adapterPosition, covidModel.state)

            })

            /* tv_notes.text = usModel.notes*/
        }
    }
}