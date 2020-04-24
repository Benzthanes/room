package com.special.robinhood.ui.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import com.special.robinhood.ui.AndroidApplication
import com.special.robinhood.ui.injection.module.ActivityBuilder
import com.special.robinhood.ui.injection.module.ApplicationModule

@Component(modules = arrayOf(ActivityBuilder::class, ApplicationModule::class,
        AndroidSupportInjectionModule::class))
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }

    fun inject(app: AndroidApplication)

}
