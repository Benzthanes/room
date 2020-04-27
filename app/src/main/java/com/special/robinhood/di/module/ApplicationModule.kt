package com.special.robinhood.di.module

import android.app.Application
import android.content.Context
import com.special.robinhood.cache.BufferooCacheImpl
import com.special.robinhood.cache.PreferencesHelper
import com.special.robinhood.cache.db.DbOpenHelper
import com.special.robinhood.cache.mapper.BufferooEntityMapper
import com.special.robinhood.data.repository.BufferooCache
import dagger.Module
import dagger.Provides

@Module
open class ApplicationModule {

    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    internal fun providePreferencesHelper(context: Context): PreferencesHelper {
        return PreferencesHelper(context)
    }

    @Provides
    internal fun provideBufferooCache(factory: DbOpenHelper,
                                      entityMapper: BufferooEntityMapper,
                                      mapper: com.special.robinhood.cache.db.mapper.BufferooMapper,
                                      helper: PreferencesHelper): BufferooCache {
        return BufferooCacheImpl(factory, entityMapper, mapper, helper)
    }

}
