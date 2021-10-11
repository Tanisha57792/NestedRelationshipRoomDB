package com.example.nestedrelationship.database

import androidx.room.*
import com.example.nestedrelationship.data.*

@Dao
interface dao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSong(st:List<song>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlaylist(ap:List<playlist>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(ap:List<user>)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlaylistSongref(ap:List<playlistSongref>)


    @Transaction
    @Query("SELECT * FROM playlist WHERE playlist_id =:playlist_id")
    fun getPlaylistWithSongs(playlist_id:Int):List<PlaylistWithSongs>

    @Transaction
    @Query("SELECT * FROM song WHERE songId = :id")
    fun getSongsFromPlaylist(id:Int):List<SongWithPlaylists>


    @Transaction
    @Query("SELECT * FROM user WHERE userId=:id")
    fun getUserWithPlaylistAndSongs(id:Int):List<UserWithPlaylistAndSong>





}