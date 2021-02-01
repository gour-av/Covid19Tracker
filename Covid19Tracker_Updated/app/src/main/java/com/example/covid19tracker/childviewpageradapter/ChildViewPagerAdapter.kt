package com.example.covid19tracker.childviewpageradapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.covid19tracker.childfragments.TodayFragment
import com.example.covid19tracker.childfragments.TotalFragment
import com.example.covid19tracker.childfragments.YesterdayFragment
import java.util.ArrayList

class ChildViewPagerAdapter(childfragmentManager: FragmentManager, private val fragmentList: List<Fragment?>? = ArrayList(),
                            private val fragmentTitles: List<String?>? = ArrayList()
):FragmentStatePagerAdapter(childfragmentManager) {
    override fun getCount(): Int {
       return 3
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return TotalFragment()
            }
            1 -> {
                return  TodayFragment()
            }
            2 -> {
                return  YesterdayFragment()
            }

            else -> {
                return TotalFragment()
            }
        }
        return TotalFragment()
    }
    override fun getPageTitle(position: Int): CharSequence? {

        when(position){
            0 ->{
                return "Total"
            }
            1->{
                return "Today"
            }
            2->{
                return "Yesterday"
            }

        }
        return super.getPageTitle(position)
    }
}