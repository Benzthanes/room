package com.special.robinhood.injection

import android.app.Application
import com.special.robinhood.AndroidApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import com.special.robinhood.injection.module.ActivityBuilder
import com.special.robinhood.injection.module.ApplicationModule
import com.special.robinhood.injection.module.FragmentBuilder
import javax.inject.Singleton

@Component(modules = [
    ActivityBuilder::class,
    FragmentBuilder::class,
    ApplicationModule::class,
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
