package com.special.robinhood.data.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.special.robinhood.data.model.MobileCacheEntity

@Database(entities = arrayOf(MobileCacheEntity::class), version = 1)
abstract class RoomDatabaseHelper : RoomDatabase() {
    companion object {
        fun getAppDatabase(context: Context): RoomDatabaseHelper =
            Room.databaseBuilder(context, RoomDatabaseHelper::class.java, "db_app")
                .fallbackToDestructiveMigration()
                .build()
    }

    abstract fun mobileCacheDao(): MobileCacheDao
}