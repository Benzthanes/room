package com.special.robinhood.data

import com.special.robinhood.data.mapper.LandingMapper
import com.special.robinhood.data.network.LandingApi
import com.special.robinhood.domain.model.Mobile
import com.special.robinhood.domain.repository.LandingRepositoryContractor
import io.reactivex.Single
import javax.inject.Inject

/**
 * Provides an implementation of the [LandingRepositoryContractor] interface for communicating to and from
 * data sources
 */
class LandingRepository @Inject constructor(private val service: LandingApi,
                                            private val mapper: LandingMapper) :
        LandingRepositoryContractor {

    override fun getPhoneList(): Single<List<Mobile>> {
        return service.getPhones().map {
            mapper.transformMobile(it)
        }
    }

}