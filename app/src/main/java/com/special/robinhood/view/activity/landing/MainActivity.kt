package com.special.robinhood.view.activity.landing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.special.robinhood.R
import com.special.robinhood.presentation.view.landing.MainView
import com.special.robinhood.presentation.presenter.landing.MainPresenter
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse)
        AndroidInjection.inject(this)
        presenter.setView(this)
    }

}