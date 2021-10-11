package com.example.nestedrelationship.data

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class PlaylistWithSongs(
    @Embedded val playlist: playlist,
    @Relation(
        parentColumn = "playlist_id",
        entityColumn = "songId",
        associateBy = Junction(playlistSongref::class)
    )
    val songs: List<song>
)

data class SongWithPlaylists(
    @Embedded val song: song,
    @Relation(
        parentColumn = "songId",
        entityColumn = "playlist_id",
        associateBy = Junction(playlistSongref::class)
    )
    val playlists: List<playlist>
)

data class UserWithPlaylistAndSong(

    @Embedded val user:user,

    @Relation(
        entity = com.example.nestedrelationship.data.playlist::class,
        parentColumn = "userId",
        entityColumn = "userCreatorId"
    )
    val playlist: List<PlaylistWithSongs>
)
