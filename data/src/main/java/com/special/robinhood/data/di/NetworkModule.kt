package com.special.robinhood.data.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
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
}