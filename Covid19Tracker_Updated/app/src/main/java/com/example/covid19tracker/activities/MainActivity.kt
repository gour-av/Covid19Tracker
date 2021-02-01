package com.example.covid19tracker.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.covid19tracker.R
import com.example.covid19tracker.navfragments.ChartFragment
import com.example.covid19tracker.navfragments.HelpFragment
import com.example.covid19tracker.navfragments.HomeFragment
import com.example.covid19tracker.navfragments.StatisticsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){
  /*  private var adapter: MainViewPagerAdapter? = null*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
      /*  adapter = MainViewPagerAdapter(supportFragmentManager)
        parent_view_pager.setAdapter(adapter)
        parent_tab_layout.setupWithViewPager(parent_view_pager)*/
      val fragment = HomeFragment()
      supportFragmentManager.beginTransaction().replace(R.id.frame1, fragment, fragment.javaClass.getSimpleName())
              .commit()
      // setSupportActionBar(toolbar)
      // bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
      val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
          when (menuItem.itemId) {
              R.id.action_home -> {
                  val fragment = HomeFragment()
                  supportFragmentManager.beginTransaction().replace(R.id.frame1, fragment, fragment.javaClass.getSimpleName())
                          .commit()
                  return@OnNavigationItemSelectedListener true
              }
              R.id.action_static -> {
                  val fragment = StatisticsFragment()
                  supportFragmentManager.beginTransaction().replace(R.id.frame1, fragment, fragment.javaClass.getSimpleName())
                          .commit()
                  return@OnNavigationItemSelectedListener true
              }
              R.id.action_book -> {
                  val fragment = ChartFragment()
                  supportFragmentManager.beginTransaction().replace(R.id.frame1, fragment, fragment.javaClass.getSimpleName())
                          .commit()
                  return@OnNavigationItemSelectedListener true
              }
              R.id.action_help -> {
                  val fragment = HelpFragment()
                  supportFragmentManager.beginTransaction().replace(R.id.frame1, fragment, fragment.javaClass.getSimpleName())
                          .commit()
                  return@OnNavigationItemSelectedListener true
              }

          }
          false
      }
      btm_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
  }






}



