package com.special.robinhood.ui.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.special.robinhood.presentation.browse.MainActivityContract
import com.special.robinhood.presentation.browse.MainActivityPresenter

import com.special.robinhood.ui.R
import javax.inject.Inject

class BlankFragment : Fragment() , MainActivityContract.View {

    @Inject
    lateinit var onboardingPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                BlankFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
    }
}
