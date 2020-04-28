package com.special.robinhood.data.di

import com.special.robinhood.data.cache.LocationCache
import com.special.robinhood.data.cache.SessionCache
import com.special.robinhood.data.db.SharedPreferencesHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideSessionCache(preferencesHelper: SharedPreferencesHelper): SessionCache {
        return SessionCache(preferencesHelper)
    }

    @Singleton
    @Provides
    fun provideLocationCache(preferencesHelper: SharedPreferencesHelper): LocationCache {
        return LocationCache(preferencesHelper)
    }
}