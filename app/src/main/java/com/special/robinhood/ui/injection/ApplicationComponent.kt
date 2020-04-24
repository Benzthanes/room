package com.special.robinhood.ui.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import com.special.robinhood.ui.BufferooApplication
import com.special.robinhood.ui.injection.module.ActivityBindingModule
import com.special.robinhood.ui.injection.module.ApplicationModule
import com.special.robinhood.ui.injection.scopes.PerApplication

@PerApplication
@Component(modules = arrayOf(ActivityBindingModule::class, ApplicationModule::class,
        AndroidSupportInjectionModule::class))
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }

    fun inject(app: BufferooApplication)

}
