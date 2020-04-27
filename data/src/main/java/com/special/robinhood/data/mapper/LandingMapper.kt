package com.special.robinhood.data.mapper

import com.special.robinhood.data.model.MobileEntity
import com.special.robinhood.domain.model.landing.Mobile
import javax.inject.Inject

class LandingMapper @Inject constructor() {

    fun transformMobile(data: List<MobileEntity>): List<Mobile> {
        return data.map {
            Mobile().apply {
                this.brand = it.brand
                this.thumbImageURL = it.thumbImageURL
                this.price = it.price
                this.name = it.name
                this.rating = it.rating
                this.id = it.id
                this.description = it.description
            }
        }
    }
}