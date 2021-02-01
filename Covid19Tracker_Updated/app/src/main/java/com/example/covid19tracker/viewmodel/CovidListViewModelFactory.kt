package com.example.covid19tracker.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CovidListViewModelFactory(private val context: Context):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CovidListViewModel::class.java)){
            return CovidListViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}