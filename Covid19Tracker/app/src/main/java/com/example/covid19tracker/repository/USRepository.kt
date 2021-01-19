package com.example.covid19tracker.repository

import com.example.covid19tracker.modelclass.USModel
import com.example.covid19tracker.network.ApiClient
import com.example.covid19tracker.network.Network
import retrofit2.Callback

class USRepository(private val callback: Callback<USModel>) {

    fun getListOfUSStates(){
        val apiClient = Network.getInstance().create(ApiClient::class.java)
        val call = apiClient.getUsers()

        call.enqueue(callback)
    }
}