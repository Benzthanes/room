package com.special.robinhood.presentation.controller.landing

import com.special.robinhood.domain.interactor.BaseUseCase
import com.special.robinhood.domain.interactor.landing.GetDataBaseUseCase
import com.special.robinhood.domain.interactor.landing.InsertDataBaseUseCase
import com.special.robinhood.domain.interactor.landing.MainUseCase
import com.special.robinhood.domain.model.landing.Mobile
import com.special.robinhood.presentation.BaseController
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainController
@Inject constructor(
    private val useCase: MainUseCase,
    private val getDataBaseUseCase: GetDataBaseUseCase,
    private val insertDataBaseUseCase: InsertDataBaseUseCase
) : BaseController() {

    fun callGetPhone(
        onSuccess: (List<Mobile>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        useCase.execute(
            onSuccess,
            onError,
            BaseUseCase.VoidParams(),
            CompositeDisposable()
        )
    }

    fun callGetPhoneCache(
        onSuccess: (List<Mobile>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        getDataBaseUseCase.execute(
            onSuccess,
            onError,
            BaseUseCase.VoidParams(),
            CompositeDisposable()
        )
    }

    fun insertPhoneCache(
        request: List<Mobile>,
        onSuccess: () -> Unit,
        onError: (Throwable) -> Unit
    ) {
        insertDataBaseUseCase.execute(
            onSuccess,
            onError,
            InsertDataBaseUseCase.Param(request),
            CompositeDisposable()
        )
    }

}