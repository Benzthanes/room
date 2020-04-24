package com.special.robinhood.ui.injection.module

import com.special.robinhood.ui.fragment.landing.BlankFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector
    abstract fun bindBlankFragment(): BlankFragment
}