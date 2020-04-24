package com.special.robinhood.ui.injection.module

import dagger.Module
import dagger.Provides
import com.special.robinhood.domain.interactor.browse.GetBufferoos
import com.special.robinhood.presentation.browse.BrowseBufferoosContract
import com.special.robinhood.presentation.browse.BrowseBufferoosPresenter
import com.special.robinhood.presentation.mapper.BufferooMapper
import com.special.robinhood.ui.browse.BrowseActivity
import com.special.robinhood.ui.injection.scopes.PerActivity



/**
 * Module used to provide dependencies at an activity-level.
 */
@Module
open class BrowseActivityModule {

    @PerActivity
    @Provides
    internal fun provideBrowseView(browseActivity: BrowseActivity): BrowseBufferoosContract.View {
        return browseActivity
    }

    @PerActivity
    @Provides
    internal fun provideBrowsePresenter(mainView: BrowseBufferoosContract.View,
                                        getBufferoos: GetBufferoos, mapper: BufferooMapper):
            BrowseBufferoosContract.Presenter {
        return BrowseBufferoosPresenter(mainView, getBufferoos, mapper)
    }

}
