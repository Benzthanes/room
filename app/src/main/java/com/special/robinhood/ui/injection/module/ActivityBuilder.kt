package com.special.robinhood.ui.injection.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.special.robinhood.ui.onboard.MainActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

}