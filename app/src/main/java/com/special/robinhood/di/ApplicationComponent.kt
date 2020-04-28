package com.special.robinhood.di

import android.app.Application
import com.special.robinhood.AndroidApplication
import com.special.robinhood.data.di.DataModule
import com.special.robinhood.data.di.NetworkModule
import com.special.robinhood.data.di.RepositoryModule
import com.special.robinhood.data.di.ServiceModule
import com.special.robinhood.data.di.SharedPreferencesModule
import com.special.robinhood.di.module.ActivityBuilder
import com.special.robinhood.di.module.AndroidModule
import com.special.robinhood.di.module.ApplicationModule
import com.special.robinhood.di.module.DeepLinkModule
import com.special.robinhood.di.module.FragmentBuilder
import com.special.robinhood.domain.di.DomainModule
import com.special.robinhood.domain.di.UseCaseModule
import com.special.robinhood.presentation.di.PresenterModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = [
    ActivityBuilder::class,
    FragmentBuilder::class,
    ApplicationModule::class,
    AndroidModule::class,
    PresenterModule::class,
    DomainModule::class,
    DataModule::class,
    RepositoryModule::class,
    ServiceModule::class,
    NetworkModule::class,
    UseCaseModule::class,
    DeepLinkModule::class,
    SharedPreferencesModule::class,
    AndroidSupportInjectionModule::class
])

@Singleton
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: AndroidApplication)
}
