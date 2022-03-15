package com.special.robinhood.data.repository

import com.special.robinhood.data.cache.MobileCacheDao
import com.special.robinhood.data.cache.RoomDatabaseHelper
import com.special.robinhood.data.mapper.LandingMapper
import com.special.robinhood.domain.model.landing.Mobile
import com.special.robinhood.domain.repository.landing.DatabaseRepositoryContractor
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class DataBaseRepository @Inject constructor(
    private val database: MobileCacheDao,
    private val mapper: LandingMapper
) : DatabaseRepositoryContractor {

    override fun getPhoneList(): Single<List<Mobile>> {
        return database.getMobileAll().map {
            mapper.transformMobileCache(it)
        }
    }

    override fun insertPhoneList(mobileList: List<Mobile>): Completable {
        return database.insertMobileList(mapper.transformMobileToEntityCache(mobileList))
    }

}