package com.example.covid19tracker.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.covid19tracker.R
import com.example.covid19tracker.parentviewpageradapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity() {

    private var adapter: ViewPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        adapter = ViewPagerAdapter(supportFragmentManager)
        view_pager.setAdapter(adapter)
        tab_layout.setupWithViewPager(view_pager)

    }
}