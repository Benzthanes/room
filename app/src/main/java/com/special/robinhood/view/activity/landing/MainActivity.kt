package com.special.robinhood.view.activity.landing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.special.robinhood.R
import com.special.robinhood.presentation.browse.MainActivityContract
import com.special.robinhood.presentation.browse.MainActivityPresenter
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainActivityContract.View {

    @Inject
    lateinit var presenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browse)
        AndroidInjection.inject(this)
        presenter.setView(this)
    }

}