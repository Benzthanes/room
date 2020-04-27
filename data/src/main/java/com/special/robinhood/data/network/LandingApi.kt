package com.special.robinhood.data.network

import com.special.robinhood.data.model.MobileEntity
import io.reactivex.Single
import retrofit2.http.GET

interface LandingApi {
    @GET("api/mobiles/")
    fun getPhones(): Single<List<MobileEntity>>

}