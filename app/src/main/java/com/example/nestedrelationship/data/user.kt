package com.example.nestedrelationship.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class user(

    @PrimaryKey val userId :Int,
    val name :String,
    val age:Int
)
