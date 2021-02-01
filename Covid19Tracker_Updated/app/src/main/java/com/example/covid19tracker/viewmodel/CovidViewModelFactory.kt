package com.example.covid19tracker.viewmodel

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CovidViewModelFactory(private val context: Context, private val owner: LifecycleOwner):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CovidViewModel::class.java)){
            return CovidViewModel(context,owner) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}