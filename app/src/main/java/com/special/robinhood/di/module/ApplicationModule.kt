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

    private val TIMEOUT = 30

    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    internal fun providePreferencesHelper(context: Context): PreferencesHelper {
        return PreferencesHelper(context)
    }

    // ThreadExecutor provide
    @Provides
    @Singleton
    @Named(SUBSCRIBER_ON)
    open fun provideSubscriberOnThreadExecutor(): ThreadExecutor {
        return ThreadExecutor(Schedulers.newThread())
    }

    @Provides
    @Singleton
    @Named(SUBSCRIBER_ON_IO)
    open fun provideSubscriberOnIOThreadExecutor(): ThreadExecutor {
        return ThreadExecutor(Schedulers.io())
    }

    @Provides
    @Singleton
    @Named(SUBSCRIBER_ON_COMPUTATION)
    open fun provideSubscriberOnComputationThreadExecutor(): ThreadExecutor {
        return ThreadExecutor(Schedulers.computation())
    }

    @Provides
    @Singleton
    @Named(OBSERVER_ON)
    open fun provideObserverOnExecutionThread(): ThreadExecutor {
        return ThreadExecutor(AndroidSchedulers.mainThread())
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val mOkHttpBuilder = OkHttpClient.Builder()
        mOkHttpBuilder.writeTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
        mOkHttpBuilder.readTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
        mOkHttpBuilder.connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
        mOkHttpBuilder.addInterceptor { chain -> chain.proceed(chain.request()) }
        return mOkHttpBuilder.build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl("https://scb-test-mobile.herokuapp.com/")
                .build()
    }

    @Provides
    @Singleton
    internal fun provideApiInterface(retrofit: Retrofit): LandingApi {
        return retrofit.create(LandingApi::class.java)
    }
//
//    @Provides
//    @Singleton
//    internal fun provideGetPhoneListUseCase(
//            @Named(SUBSCRIBER_ON_IO) subscriberOn: ThreadExecutor,
//            @Named(OBSERVER_ON) observerOn: ThreadExecutor,
//            repository: LandingRepository): MainUseCase {
//        return MainUseCase(subscriberOn, observerOn, repository)
//    }


    @Provides
    internal fun provideLandingRepository(service: LandingApi,
                                          mapper: LandingMapper): LandingRepositoryContractor {
        return LandingRepository(service, mapper)
    }

    @Provides
    internal fun provideBufferooCache(factory: DbOpenHelper,
                                      entityMapper: BufferooEntityMapper,
                                      mapper: com.special.robinhood.cache.db.mapper.BufferooMapper,
                                      helper: PreferencesHelper): BufferooCache {
        return BufferooCacheImpl(factory, entityMapper, mapper, helper)
    }

//
//    @Provides
//    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
//        return uiThread
//    }
}
