package com.example.nestedrelationship

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.nestedrelationship.data.playlist
import com.example.nestedrelationship.data.playlistSongref
import com.example.nestedrelationship.data.song
import com.example.nestedrelationship.data.user
import com.example.nestedrelationship.database.database
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val user:List<user> = arrayListOf(
            user(101,"Tani",23),
            user(102,"vani",20),
            user(103,"vanshika",18),
            user(104,"Mani",34)
        )

        val playlist:List<playlist> = arrayListOf(
            playlist(1,101,"slayer"),
            playlist(2,202,"slime"),
            playlist(3,101,"Aarigato")
        )

        val song:List<song> = arrayListOf(
            song(11,"Say you so","xyz"),
            song(12,"Say you so","xyz"),
            song(13,"Lisa","abc"),
            song(14,"Say so","Rainych")

        )

        val ref:List<playlistSongref> = arrayListOf(

            playlistSongref(1,12),
            playlistSongref(2,11),
            playlistSongref(2,14),
            playlistSongref(1,11)
        )

        val db= database(this)

        CoroutineScope(Dispatchers.Default).launch {

            db.detailDao().insertSong(song)
            db.detailDao().insertPlaylist(playlist)
            db.detailDao().insertUser(user)
            db.detailDao().insertPlaylistSongref(ref)

            val st = db.detailDao().getUserWithPlaylistAndSongs(101)
          //  val st = db.detailDao().getSongsFromPlaylist(12)
          //  val st = db .detailDao().getPlaylistWithSongs(2)


            Log.i("TAG",st.toString())



        }


    }
}