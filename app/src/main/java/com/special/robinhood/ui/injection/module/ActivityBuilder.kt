package com.special.robinhood.ui.injection.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.special.robinhood.ui.activity.landing.MainActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

}