package com.special.robinhood.presentation.presenter.landing

import com.special.robinhood.domain.model.landing.Mobile
import com.special.robinhood.presentation.BasePresenter
import com.special.robinhood.presentation.controller.landing.MainController
import com.special.robinhood.presentation.view.landing.MainContractor
import javax.inject.Inject

class MainPresenter
@Inject constructor(
    private val controller: MainController
) : BasePresenter<MainContractor.View>(), MainContractor.Presenter {

    override fun onStart() {
        controller.callGetPhoneCache({
//            if (it.isNullOrEmpty()) {
                getPhoneFromApi()
//            } else {
//                doInView { view -> view.displayText("get phone list cache success::") }
//            }
        }, {
            doInView { view -> view.displayText("get phone list cache fail::") }
            getPhoneFromApi()
        })
    }

    private fun getPhoneFromApi() {
        controller.callGetPhone(
            {
                doInView { view -> view.displayText("Call phone list success::") }
                saveToCache(it)
            },
            {
                doInView { view -> view.displayText("Exception::") }
            }
        )
    }

    private fun saveToCache(list: List<Mobile>) {
        controller.insertPhoneCache(list,
            {
                doInView { view -> view.displayText("save phone list success::") }
            },
            {
                doInView { view -> view.displayText("save phone list fail::") }
            }
        )
    }

}