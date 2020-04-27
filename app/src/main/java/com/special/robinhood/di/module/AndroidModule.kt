package com.special.robinhood.di.module

import com.special.robinhood.domain.executor.ThreadExecutor
import com.special.robinhood.domain.interactor.ThreadExecutors
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
class AndroidModule {

    @Provides
    @Singleton
    @Named(ThreadExecutors.SUBSCRIBER_ON)
    internal fun provideSubscriberOnThreadExecutor(): ThreadExecutor {
        return ThreadExecutor(Schedulers.newThread())
    }

    @Provides
    @Singleton
    @Named(ThreadExecutors.SUBSCRIBER_ON_IO)
    internal fun provideSubscriberOnIOThreadExecutor(): ThreadExecutor {
        return ThreadExecutor(Schedulers.io())
    }

    @Provides
    @Singleton
    @Named(ThreadExecutors.SUBSCRIBER_ON_COMPUTATION)
    internal fun provideSubscriberOnComputationThreadExecutor(): ThreadExecutor {
        return ThreadExecutor(Schedulers.computation())
    }

    @Provides
    @Singleton
    @Named(ThreadExecutors.OBSERVER_ON)
    internal fun provideObserverOnExecutionThread(): ThreadExecutor {
        return ThreadExecutor(AndroidSchedulers.mainThread())
    }

}