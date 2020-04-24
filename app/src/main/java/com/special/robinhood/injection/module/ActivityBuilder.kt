package com.special.robinhood.injection.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.special.robinhood.view.activity.landing.MainActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

}