package com.example.covid19tracker.navfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.covid19tracker.ItemClickListener
import com.example.covid19tracker.R
import com.example.covid19tracker.adapter.CovidAdapter
import com.example.covid19tracker.database.Users
import com.example.covid19tracker.viewmodel.CovidListViewModel
import com.example.covid19tracker.viewmodel.CovidListViewModelFactory
import com.example.covid19tracker.viewmodel.CovidViewModel
import com.example.covid19tracker.viewmodel.CovidViewModelFactory
import com.hbb20.CountryCodePicker
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(),CountryCodePicker.OnCountryChangeListener,View.OnClickListener,ItemClickListener {
    private var ccp: CountryCodePicker?=null
    private var countryName:String?=null
    private lateinit var covidViewModel: CovidViewModel
    private lateinit var covidListViewModel: CovidListViewModel
    private lateinit var usAdapter: CovidAdapter
    private var covidmodelListing = emptyList<Users>()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        ccp = view.findViewById(R.id.country_code_picker)
        ccp!!.setOnCountryChangeListener(this)
        ccp!!.setDefaultCountryUsingNameCode("JP")

        covidViewModel = CovidViewModelFactory(this.requireContext(), requireActivity()).create(CovidViewModel::class.java)
        covidListViewModel = CovidListViewModelFactory(requireActivity()).create(CovidListViewModel::class.java)
        setRecyclerAdapter()
        observeliveData()
        initListeners()

    }
    private fun observeliveData() {
        covidListViewModel.fetchDataFromDB().observe(this, Observer {
            it?.let {
                this@HomeFragment.covidmodelListing = it
                usAdapter.updateList(covidmodelListing)
            }
        })
    }

    private fun setRecyclerAdapter() {
        usAdapter = CovidAdapter(covidmodelListing, this)
        val layoutManager = LinearLayoutManager(activity)
        recycler_view.apply {
            this.layoutManager = layoutManager
            adapter = usAdapter
        }
    }


    private fun initListeners() {
        btn_save.setOnClickListener(this)

    }


    override fun onCountrySelected() {
        countryName = ccp!!.selectedCountryName
        Toast.makeText(activity, "Country Name " + countryName, Toast.LENGTH_SHORT).show()
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_save -> {
             covidViewModel.CovidcallApi()

            }


        }

    }



    override fun onItemClicked(position: Int, state: String?) {
        val fragment = StatisticsFragment()
        val bundle  = Bundle()
        bundle.putString("data",state)

        fragment.arguments = bundle
        fragmentManager?.beginTransaction()?.add(R.id.frame1, fragment, "StatisticsFragment")
                ?.addToBackStack("StatisticsFragment")?.commit()
    }

}