package com.special.robinhood.data.cache

import com.special.robinhood.data.db.SharedPreferencesHelper

class LocationCache(private var preferencesHelper: SharedPreferencesHelper) {

    private var lastKnowLat: Double? = null
    private var lastKnowLng: Double? = null

    fun setLastKnowLat(lastKnowLat: Double) {
        this.lastKnowLat = lastKnowLat
    }

    fun getLastKnowLat() = lastKnowLat

    fun setLastKnowLng(lastKnowLng: Double) {
        this.lastKnowLng = lastKnowLng
    }

    fun getLastKnowLng() = lastKnowLng

    fun clearLastKnowLatLng() {
        this.lastKnowLat = null
        this.lastKnowLng = null
    }
}
