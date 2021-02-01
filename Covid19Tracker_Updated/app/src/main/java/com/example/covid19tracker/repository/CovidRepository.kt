package com.example.covid19tracker.repository

import com.example.covid19tracker.modelclass.CovidModel
import com.example.covid19tracker.network.ApiClient
import com.example.covid19tracker.network.Network
import retrofit2.Callback

class CovidRepository(private val callback: Callback<CovidModel>) {
    var Id: String ="ak"
    fun getListofRate(){
        val apiClient = Network.getInstance().create(ApiClient::class.java)
        val call = apiClient.getCurrent(Id)

        call.enqueue(callback)
    }
}