package com.example.nestedrelationship.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class song (
    @PrimaryKey val songId:Int,
    val songName:String,
    val artist:String
        )
