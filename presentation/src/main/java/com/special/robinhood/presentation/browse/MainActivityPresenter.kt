package com.special.robinhood.presentation.browse

import com.special.robinhood.domain.model.Bufferoo
import com.special.robinhood.presentation.BasePresenter
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class MainActivityPresenter @Inject constructor() : BasePresenter<MainActivityContract.View>() {

    inner class BufferooSubscriber : DisposableSingleObserver<List<Bufferoo>>() {

        override fun onSuccess(t: List<Bufferoo>) {
        }

        override fun onError(exception: Throwable) {
        }

    }

}