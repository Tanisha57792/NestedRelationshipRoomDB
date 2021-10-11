package com.example.nestedrelationship.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class playlist(
    @PrimaryKey val playlist_id:Int,
    val userCreatorId:Int,
    val PlayListname:String
)
