package com.special.robinhood.presentation.presenter.landing

import com.special.robinhood.presentation.BasePresenter
import com.special.robinhood.presentation.view.landing.MainContractor
import javax.inject.Inject

class MainPresenter @Inject constructor() : BasePresenter<MainContractor.View>(), MainContractor.Presenter {

    override fun onStart() {
        mView?.displayText("a")
    }

}