package com.special.robinhood.presentation

abstract class BasePresenter<T : BaseView> {
    private var mView: T? = null

    fun setView(view: T) {
        this.mView = view
    }

    fun doInView(view: (T) -> Unit) {
        mView?.let {
            view.invoke(it)
        }
    }
}