package com.example.covid19tracker.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Users")
data class Users(
    @PrimaryKey(autoGenerate = true)
    val userId:Int=0,
            @ColumnInfo(name = "state")
            val state: String? = null,

    @ColumnInfo(name = "name")
    val name: String? = null,
    )

