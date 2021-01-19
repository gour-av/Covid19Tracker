package com.example.covid19tracker.usfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid19tracker.R
import com.example.covid19tracker.adapter.USAdapter
import com.example.covid19tracker.modelclass.USModel
import com.example.covid19tracker.useruimodel.USUIModel
import com.example.covid19tracker.viewmodel.USViewModel
import kotlinx.android.synthetic.main.fragment_u_s_a.*


class USAFragment : Fragment() {

    private lateinit var usViewModel: USViewModel
    private lateinit var usAdapter: USAdapter
    private val usmodelListing = emptyList<USModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_u_s_a, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        usViewModel = ViewModelProvider(this).get(USViewModel::class.java)
        setRecyclerAdapter()
        observeliveData()
        usViewModel.callApi()
    }

    private fun observeliveData() {
        usViewModel.liveData.observe(this, Observer {
            when(it){
                is USUIModel.Success ->{
                    usAdapter.updateList(listOf(it.dataModelList))
                }
                is USUIModel.Failure ->{
                    Toast.makeText(
                        activity,
                        "Error message ${it.error}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })
    }

    private fun setRecyclerAdapter() {
       usAdapter = USAdapter(usmodelListing)
        val layoutManager = LinearLayoutManager(activity)
            recycler_view.apply {
            this.layoutManager = layoutManager
            adapter = usAdapter
        }
    }
}