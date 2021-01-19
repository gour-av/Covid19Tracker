package com.example.covid19tracker.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.covid19tracker.modelclass.USModel
import kotlinx.android.synthetic.main.item_layout.view.*

class USViewHolder(private val view: View):RecyclerView.ViewHolder(view) {
    fun setData(usModel: USModel){
        view.apply {
            tv_name.text = usModel.name
            tv_state.text = usModel.state
            tv_notes.text = usModel.notes
        }
    }

}