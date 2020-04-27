package com.special.robinhood.data

import com.special.robinhood.data.mapper.LandingMapper
import com.special.robinhood.data.network.api.landing.LandingApi
import com.special.robinhood.domain.model.Mobile
import com.special.robinhood.domain.repository.LandingRepositoryContractor
import io.reactivex.Single
import javax.inject.Inject

class LandingRepository @Inject constructor(private val api: LandingApi,
                                            private val mapper: LandingMapper) :
        LandingRepositoryContractor {

    override fun getPhoneList(): Single<List<Mobile>> {
        return api.getMobileList().map {
            mapper.transformMobile(it)
        }
    }

}