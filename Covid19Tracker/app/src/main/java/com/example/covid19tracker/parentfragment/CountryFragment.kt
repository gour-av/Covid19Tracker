package com.example.covid19tracker.parentfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.covid19tracker.R
import com.example.covid19tracker.childviewpageradapter.ChildViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_country.*


class CountryFragment : Fragment() {
    private var adapter: ChildViewPagerAdapter? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_country, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        adapter = ChildViewPagerAdapter(childFragmentManager)
        child_view_pager.setAdapter(adapter)
       // child_tab_layout.size.rangeTo(10)
        child_tab_layout.setupWithViewPager(child_view_pager)
    }
}