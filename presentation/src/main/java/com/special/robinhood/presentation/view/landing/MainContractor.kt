package com.special.robinhood.presentation.view.landing

import com.special.robinhood.presentation.BaseView

interface MainContractor {

    interface View : BaseView {
        fun displayText(text: String)
    }

    interface Presenter {
        fun onStart()
    }
}