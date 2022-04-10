package com.ilbensaber.breakingbad.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ilbensaber.breakingbad.model.Death
import com.ilbensaber.breakingbad.model.EntityCharacter
import com.ilbensaber.breakingbad.model.EntityEpisode
import com.ilbensaber.breakingbad.model.Quote

private const val DATABASE = "breaking_bad_db"

@Database(entities = [Death::class, Quote::class, EntityEpisode::class, EntityCharacter::class],
    version = 4, exportSchema = false)
abstract class RoomDB : RoomDatabase() {

    abstract fun deathDao() : DeathDao
    abstract fun quoteDao() : QuoteDao
    abstract fun episodeDao() : EpisodeDao
    abstract fun characterDao() : CharacterDao

    companion object {

        @Volatile private var INSTANCE: RoomDB? = null

        fun getDatabasenIstance(mContext: Context): RoomDB =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabaseInstance(mContext).also {
                    INSTANCE = it
                }
            }

        private fun buildDatabaseInstance(mContext: Context) =
            Room.databaseBuilder(mContext, RoomDB::class.java, DATABASE)
                .fallbackToDestructiveMigration()
                .build()

    }
}