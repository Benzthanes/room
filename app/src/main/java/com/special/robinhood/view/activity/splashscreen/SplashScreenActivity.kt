package com.special.robinhood.view.activity.splashscreen

import android.content.Intent
import android.os.Bundle
import com.special.robinhood.presentation.presenter.splashscreen.SplashScreenPresenter
import com.special.robinhood.view.activity.BaseActivity
import com.special.robinhood.view.activity.landing.MainActivity
import javax.inject.Inject

class SplashScreenActivity : BaseActivity() {

    @Inject
    lateinit var presenter: SplashScreenPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.start()
        startActivity(Intent(this, MainActivity::class.java))
    }

}