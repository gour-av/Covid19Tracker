package com.example.covid19tracker

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.covid19tracker.childfragments.TodayFragment
import com.example.covid19tracker.childfragments.TotalFragment
import com.example.covid19tracker.childfragments.YesterdayFragment
import com.example.covid19tracker.navfragments.ChartFragment
import com.example.covid19tracker.navfragments.HelpFragment
import com.example.covid19tracker.navfragments.HomeFragment
import com.example.covid19tracker.navfragments.StatisticsFragment
import java.util.ArrayList

class MainViewPagerAdapter(mainfragmentManager: FragmentManager, private val fragmentList: List<Fragment?>? = ArrayList(),
                           private val fragmentTitles: List<String?>? = ArrayList()
):FragmentStatePagerAdapter(mainfragmentManager) {
    override fun getCount(): Int {
        return 4;
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return HomeFragment()
            }
            1 -> {
                return  StatisticsFragment()
            }
            2 -> {
                return  ChartFragment()
            }
            3 -> {
                return  HelpFragment()
            }

            else -> {
                return HomeFragment()
            }
        }
        return HomeFragment()

    }

    override fun getItemPosition(`object`: Any): Int {
        when(`object`){
            0 ->{
                return R.drawable.ic_home
            }
            1->{
                return R.drawable.ic_bar_chart
            }
            2->{
                return R.drawable.ic_chart
            }
            3->{
                return R.drawable.ic_i
            }

        }
        return getItemPosition(`object`)

    }


}