package com.special.robinhood.presentation.presenter.landing

import com.special.robinhood.domain.interactor.BaseUseCase
import com.special.robinhood.domain.interactor.landing.MainUseCase
import com.special.robinhood.presentation.BasePresenter
import com.special.robinhood.presentation.view.landing.MainContractor
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainPresenter @Inject constructor(private val useCase: MainUseCase) :
        BasePresenter<MainContractor.View>(), MainContractor.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun onStart() {
        useCase.execute({ data ->
            mView?.displayText("Hello RobinHood success")
        }, {
            mView?.displayText("error")
        }, BaseUseCase.VoidParams(), compositeDisposable)

    }

}