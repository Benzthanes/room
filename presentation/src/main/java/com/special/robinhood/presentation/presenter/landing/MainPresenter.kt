package com.special.robinhood.presentation.presenter.landing

import com.special.robinhood.presentation.BasePresenter
import com.special.robinhood.presentation.controller.landing.MainController
import com.special.robinhood.presentation.view.landing.MainContractor
import javax.inject.Inject

class MainPresenter
@Inject constructor(
        private val controller: MainController
) : BasePresenter<MainContractor.View>(), MainContractor.Presenter {

    override fun onStart() {
        controller.callGetPhone(
                {
                    doInView { view -> view.displayText("Call phone list success::") }
                },
                {
                    doInView { view -> view.displayText("Exception::") }
                }
        )
    }

}