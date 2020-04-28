package com.special.robinhood.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.special.robinhood.data.cache.SessionCache
import com.special.robinhood.data.db.SharedPreferencesHelper
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    private val TIMEOUT = 30

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
            interceptor: Interceptor,
            logging: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
                .writeTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                .readTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                .connectTimeout(TIMEOUT.toLong(), TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addInterceptor(logging)
                .build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(
            gson: Gson,
            okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .baseUrl("https://scb-test-mobile.herokuapp.com/")
                .build()
    }

    @Provides
    @Singleton
    fun provideAppHeaderInterceptor(
            preferencesHelper: SharedPreferencesHelper,
            sessionCache: SessionCache
    ): Interceptor {
        return Interceptor {
            it.proceed(it.request()
                    .newBuilder()
//                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept-Language", preferencesHelper.appLanguage)
//                    .method(original.method(), original.body())
                    .build())
        }
    }
}
