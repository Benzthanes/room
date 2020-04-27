package com.special.robinhood.presentation.controller.landing

import com.special.robinhood.domain.interactor.BaseUseCase
import com.special.robinhood.domain.interactor.landing.MainUseCase
import com.special.robinhood.domain.model.landing.Mobile
import com.special.robinhood.presentation.BaseController
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainController
@Inject constructor(
        private val useCase: MainUseCase
) : BaseController() {

    fun callGetPhone(onSuccess: (List<Mobile>) -> Unit,
                     onError: (Throwable) -> Unit) {
        useCase.execute(
                onSuccess,
                onError,
                BaseUseCase.VoidParams(),
                CompositeDisposable())
    }
}