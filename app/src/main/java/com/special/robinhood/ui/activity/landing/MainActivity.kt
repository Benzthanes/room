package com.special.robinhood.ui.activity.landing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.special.robinhood.presentation.browse.MainActivityContract
import com.special.robinhood.presentation.browse.MainActivityPresenter
import com.special.robinhood.ui.R
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainActivityContract.View {

    @Inject
    lateinit var onboardingPresenter: MainActivityPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse)
        AndroidInjection.inject(this)
        onboardingPresenter.setView(this)
    }

}