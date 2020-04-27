package com.special.robinhood.di.module

import android.app.Application
import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.special.robinhood.cache.BufferooCacheImpl
import com.special.robinhood.cache.PreferencesHelper
import com.special.robinhood.cache.db.DbOpenHelper
import com.special.robinhood.cache.mapper.BufferooEntityMapper
import com.special.robinhood.data.LandingRepository
import com.special.robinhood.data.mapper.LandingMapper
import com.special.robinhood.data.network.LandingApi
import com.special.robinhood.data.repository.BufferooCache
import com.special.robinhood.domain.executor.ThreadExecutor
import com.special.robinhood.domain.interactor.ThreadExecutors.OBSERVER_ON
import com.special.robinhood.domain.interactor.ThreadExecutors.SUBSCRIBER_ON
import com.special.robinhood.domain.interactor.ThreadExecutors.SUBSCRIBER_ON_COMPUTATION
import com.special.robinhood.domain.interactor.ThreadExecutors.SUBSCRIBER_ON_IO
import com.special.robinhood.domain.repository.LandingRepositoryContractor
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

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
