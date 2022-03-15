package com.special.robinhood.data.cache

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.special.robinhood.data.model.MobileCacheEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface MobileCacheDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMobileList(mobile: List<MobileCacheEntity>) : Completable

    @Update()
    fun updateMobileList(mobile: MobileCacheEntity)

    @Delete
    fun deleteMobileList(mobile: MobileCacheEntity)

    @Query("SELECT * FROM mobile")
    fun getMobileAll(): Single<List<MobileCacheEntity>>

    @Query("SELECT * FROM mobile WHERE id = :id")
    fun getMobileById(id: Int): Single<MobileCacheEntity>

    @Query("DELETE FROM mobile")
    fun deleteTable()
}