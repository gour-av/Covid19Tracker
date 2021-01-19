package com.example.covid19tracker.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.covid19tracker.modelclass.USModel
import com.example.covid19tracker.repository.USRepository
import com.example.covid19tracker.useruimodel.USUIModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class USViewModel:ViewModel(),Callback<USModel> {

    private val repository = USRepository(this)

    private val mutableLiveData = MutableLiveData<USUIModel>()

    val liveData: LiveData<USUIModel> = mutableLiveData
    override fun onResponse(call: Call<USModel>, response: Response<USModel>) {
        response.body()?.let {
            mutableLiveData.value = USUIModel.Success(it)
        }

    }

    override fun onFailure(call: Call<USModel>, t: Throwable) {
        mutableLiveData.value = USUIModel.Failure(t.message!!)

    }
    fun callApi(){
        repository.getListOfUSStates()
    }

}