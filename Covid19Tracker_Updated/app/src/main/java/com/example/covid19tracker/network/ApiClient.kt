package com.example.covid19tracker.network

import com.example.covid19tracker.modelclass.CovidModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("v1/states/{state}/current.json")
    fun getCurrent(@Path("state") Id:String) : Call<CovidModel>

}