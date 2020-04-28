package com.special.robinhood.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.special.robinhood.view.activity.landing.MainActivity
import com.special.robinhood.view.activity.ordertracking.OrderTrackingActivity
import com.special.robinhood.view.activity.splashscreen.SplashScreenActivity

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract fun bindSplashScreenActivity(): SplashScreenActivity

    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun bindOrderTrackingActivity(): OrderTrackingActivity

}