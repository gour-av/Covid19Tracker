package com.example.covid19tracker.network

import com.example.covid19tracker.modelclass.USModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {
    @GET("v1/states/info.json")
    fun getUsers():Call<USModel>
}