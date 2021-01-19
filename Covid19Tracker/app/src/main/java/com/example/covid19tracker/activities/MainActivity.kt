package com.example.covid19tracker.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.covid19tracker.R
import com.example.covid19tracker.usfragment.USAFragment
import com.hbb20.CountryCodePicker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),CountryCodePicker.OnCountryChangeListener{
    private var ccp:CountryCodePicker?=null
    private var countryName:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ccp = findViewById(R.id.country_code_picker)
        ccp!!.setOnCountryChangeListener(this)
        ccp!!.setDefaultCountryUsingNameCode("JP")
        img_home.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, NavigationActivity::class.java)
            startActivity(intent)
        })


        launchFragmentUSA()



    }

    override fun onCountrySelected() {
        countryName = ccp!!.selectedCountryName
        Toast.makeText(this, "Country Name " + countryName, Toast.LENGTH_SHORT).show()

    }

    private fun launchFragmentUSA() {
     val usafragment = USAFragment()
        supportFragmentManager.beginTransaction().add(R.id.fl_container,usafragment,"USAFragment").commit()
    }

}