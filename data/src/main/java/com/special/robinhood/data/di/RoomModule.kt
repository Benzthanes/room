package com.special.robinhood.data.di

import android.content.Context
import com.special.robinhood.data.cache.MobileCacheDao
import com.special.robinhood.data.cache.RoomDatabaseHelper
import com.special.robinhood.data.mapper.LandingMapper
import com.special.robinhood.data.repository.DataBaseRepository
import com.special.robinhood.domain.model.landing.Mobile
import com.special.robinhood.domain.repository.landing.DatabaseRepositoryContractor

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    internal fun provideRoomDataBaseHelper(context: Context): RoomDatabaseHelper {
        return RoomDatabaseHelper.getAppDatabase(context)
    }

    @Provides
    @Singleton
    internal fun provideRoomDataMobileCacheDao(roomHelper: RoomDatabaseHelper): MobileCacheDao {
        return roomHelper.mobileCacheDao()
    }

    @Provides
    @Singleton
    internal fun provideDataBaseRepository(
        cache: MobileCacheDao,
        mapper: LandingMapper
    ): DatabaseRepositoryContractor {
        return DataBaseRepository(cache, mapper)
    }
}