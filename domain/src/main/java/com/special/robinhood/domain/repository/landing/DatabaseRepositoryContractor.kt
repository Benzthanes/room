package com.special.robinhood.domain.repository.landing

import com.special.robinhood.domain.model.landing.Mobile
import io.reactivex.Completable
import io.reactivex.Single

interface DatabaseRepositoryContractor {

    fun getPhoneList(): Single<List<Mobile>>

    fun insertPhoneList(mobileList: List<Mobile>): Completable

}