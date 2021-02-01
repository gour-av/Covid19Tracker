package com.example.covid19tracker.navfragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.covid19tracker.R
import com.example.covid19tracker.childfragments.TodayFragment
import com.example.covid19tracker.childfragments.TotalFragment

import com.example.covid19tracker.modelclass.CovidModel
import com.example.covid19tracker.parentviewpageradapter.ViewPagerAdapter
import com.example.covid19tracker.useruimodel.CovidUIModel
import com.example.covid19tracker.viewmodel.CovidViewModel

import kotlinx.android.synthetic.main.fragment_statistics.*
import kotlinx.android.synthetic.main.fragment_total.*


class StatisticsFragment : Fragment() {
    private var adapter: ViewPagerAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = ViewPagerAdapter(childFragmentManager)
        view_pager.setAdapter(adapter)
        tab_layout.setupWithViewPager(view_pager)



Toast.makeText(context,arguments?.getString("data") + " hey", Toast.LENGTH_SHORT).show()

    }




}