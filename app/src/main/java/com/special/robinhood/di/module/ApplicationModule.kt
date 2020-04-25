package com.special.robinhood.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import com.special.robinhood.cache.BufferooCacheImpl
import com.special.robinhood.cache.PreferencesHelper
import com.special.robinhood.cache.db.DbOpenHelper
import com.special.robinhood.cache.mapper.BufferooEntityMapper
import com.special.robinhood.data.BufferooDataRepository
import com.special.robinhood.data.executor.JobExecutor
import com.special.robinhood.data.mapper.BufferooMapper
import com.special.robinhood.data.repository.BufferooCache
import com.special.robinhood.data.source.BufferooDataStoreFactory
import com.special.robinhood.domain.executor.PostExecutionThread
import com.special.robinhood.domain.executor.ThreadExecutor
import com.special.robinhood.domain.repository.BufferooRepository
import com.special.robinhood.view.UiThread

/**
 * Module used to provide dependencies at an application-level.
 */
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
    internal fun provideBufferooRepository(factory: BufferooDataStoreFactory,
                                           mapper: BufferooMapper): BufferooRepository {
        return BufferooDataRepository(factory, mapper)
    }

    @Provides
    internal fun provideBufferooCache(factory: DbOpenHelper,
                                      entityMapper: BufferooEntityMapper,
                                      mapper: com.special.robinhood.cache.db.mapper.BufferooMapper,
                                      helper: PreferencesHelper): BufferooCache {
        return BufferooCacheImpl(factory, entityMapper, mapper, helper)
    }

    @Provides
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }
}
