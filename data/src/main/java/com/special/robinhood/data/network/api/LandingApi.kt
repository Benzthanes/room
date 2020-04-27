package com.special.robinhood.data.network.api

import com.special.robinhood.data.model.MobileEntity
import com.special.robinhood.data.network.service.LandingService
import io.reactivex.Single
import javax.inject.Inject

class LandingApi @Inject constructor(
        private val service: LandingService
) {
    fun getMobileList(): Single<List<MobileEntity>> {
        return service.getMobileList()
    }
}