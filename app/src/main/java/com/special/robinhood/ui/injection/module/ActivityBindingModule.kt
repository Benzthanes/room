package com.special.robinhood.ui.injection.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.special.robinhood.ui.browse.BrowseActivity
import com.special.robinhood.ui.injection.scopes.PerActivity

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(BrowseActivityModule::class))
    abstract fun bindMainActivity(): BrowseActivity

}