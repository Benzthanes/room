package com.special.robinhood.di.module

import com.special.robinhood.view.fragment.landing.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector
    abstract fun bindBlankFragment(): MainFragment
}