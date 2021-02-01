package com.example.covid19tracker.useruimodel

import com.example.covid19tracker.modelclass.CovidModel

sealed class CovidUIModel {
    data class Success(val covidModelList:  CovidModel) : CovidUIModel()

    data class Failure(val error: String) : CovidUIModel()
}