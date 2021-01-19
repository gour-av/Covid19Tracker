package com.example.covid19tracker.useruimodel

import com.example.covid19tracker.modelclass.USModel

sealed class USUIModel {
    data class Success(val dataModelList: USModel) : USUIModel()

    data class Failure(val error: String) : USUIModel()
}