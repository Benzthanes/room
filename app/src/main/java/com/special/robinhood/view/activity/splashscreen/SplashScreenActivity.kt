package com.special.robinhood.view.activity.splashscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.special.robinhood.presentation.presenter.splashscreen.SplashScreenPresenter
import dagger.android.AndroidInjection
import javax.inject.Inject

class SplashScreenActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: SplashScreenPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        presenter.start()

    }

}