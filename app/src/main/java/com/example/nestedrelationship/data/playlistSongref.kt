package com.example.nestedrelationship.data

import androidx.room.Entity

@Entity(
    primaryKeys = ["playlist_id","songId"]
)
data class playlistSongref(
    val playlist_id :Int,
    val songId:Int


)
