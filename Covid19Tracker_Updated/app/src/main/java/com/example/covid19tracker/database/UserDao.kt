package com.example.covid19tracker.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(users: Users)

    @Query("Select * From Users")
    fun getAllUsers() :LiveData<List<Users>>

    @Query("Update users Set state =:state,name=:name where userId = :id")
    fun updateUserDetails(state:String,name:String,id:Int)
}