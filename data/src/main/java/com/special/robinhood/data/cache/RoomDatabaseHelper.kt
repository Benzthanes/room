package com.special.robinhood.data.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.special.robinhood.data.model.MobileCacheEntity

@Database(
    entities = arrayOf(MobileCacheEntity::class),
    version = 2,
    exportSchema = true
)
abstract class RoomDatabaseHelper : RoomDatabase() {
    companion object {
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE mobile ADD COLUMN test TEXT")
            }
        }
        fun getAppDatabase(context: Context): RoomDatabaseHelper =
            Room.databaseBuilder(context, RoomDatabaseHelper::class.java, "db_app")
                .addMigrations(MIGRATION_1_2)
                .fallbackToDestructiveMigration()
                .build()
    }

    abstract fun mobileCacheDao(): MobileCacheDao
}