package com.example.nestedrelationship.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nestedrelationship.data.playlist
import com.example.nestedrelationship.data.playlistSongref
import com.example.nestedrelationship.data.song
import com.example.nestedrelationship.data.user

@Database(
    entities = [user::class,playlist::class, song::class , playlistSongref::class],
    version = 1,
    exportSchema = false
)
abstract class database: RoomDatabase() {
    abstract fun detailDao():dao

    companion object{
        @Volatile private var instance:database? = null
        private val lock= Any()

        operator fun invoke(context: Context) = instance ?: synchronized(lock){
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        private fun buildDatabase(context: Context)  = Room.databaseBuilder(
            context.applicationContext,
            database::class.java,
            "songdb"
        ).build()
    }
}
