package com.special.robinhood.presentation

abstract class BasePresenter<T : BaseView> {
    var mView: T? = null

    fun setView(view: T) {
        this.mView = view
    }
}