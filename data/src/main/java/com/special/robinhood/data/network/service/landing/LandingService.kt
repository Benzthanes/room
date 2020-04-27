package com.special.robinhood.data.network.service.landing

import com.special.robinhood.data.model.MobileEntity
import io.reactivex.Single
import retrofit2.http.GET

interface LandingService {
    @GET("api/mobiles/")
    fun getMobileList(): Single<List<MobileEntity>>

}