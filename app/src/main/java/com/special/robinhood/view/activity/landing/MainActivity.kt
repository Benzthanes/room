package com.special.robinhood.view.activity.landing

import android.os.Bundle
import com.special.robinhood.R
import com.special.robinhood.presentation.presenter.landing.MainPresenter
import com.special.robinhood.presentation.view.landing.MainView
import com.special.robinhood.view.activity.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse)
        presenter.setView(this)
    }

}