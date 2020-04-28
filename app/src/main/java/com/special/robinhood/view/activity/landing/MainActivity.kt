package com.special.robinhood.view.activity.landing

import android.os.Bundle
import com.special.robinhood.databinding.ActivityMainBinding
import com.special.robinhood.extensions.addFragment
import com.special.robinhood.presentation.presenter.landing.MainPresenter
import com.special.robinhood.presentation.view.landing.MainContractor
import com.special.robinhood.view.activity.BaseActivity
import com.special.robinhood.view.fragment.landing.MainFragment
import javax.inject.Inject

class MainActivity : BaseActivity(), MainContractor.View {

    @Inject
    lateinit var presenter: MainPresenter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.setView(this)
        presenter.onStart()
        addFragment(MainFragment.newInstance("data1", "data2"), binding.frameLayout.id)

    }

    override fun displayText(text: String) {
        binding.textTitle.text = text
    }

}