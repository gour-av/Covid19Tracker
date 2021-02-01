package com.example.covid19tracker.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.covid19tracker.database.UserDatabase
import com.example.covid19tracker.database.Users

class CovidListViewModel(private val context: Context) :ViewModel(){
    fun fetchDataFromDB(): LiveData<List<Users>> {
        return UserDatabase.getInstance(context)
                .userDao.getAllUsers()
    }
}