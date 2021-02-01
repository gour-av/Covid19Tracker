package com.example.covid19tracker.parentviewpageradapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.covid19tracker.parentfragment.CountryFragment
import com.example.covid19tracker.parentfragment.GlobalFragment
import java.util.ArrayList

class ViewPagerAdapter(parentfragmentManager: FragmentManager, private val fragmentList: List<Fragment?>? = ArrayList(),
                       private val fragmentTitles: List<String?>? = ArrayList()
): FragmentStatePagerAdapter(parentfragmentManager) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return CountryFragment()
            }
            1 -> {
                return GlobalFragment()
            }

            else -> {
                return CountryFragment()
            }
        }
        return CountryFragment()
    }
    override fun getPageTitle(position: Int): CharSequence? {

        when(position){
            0 ->{
                return "Country"
            }
            1->{
                return "Global"
            }

        }
        return super.getPageTitle(position)
    }
}