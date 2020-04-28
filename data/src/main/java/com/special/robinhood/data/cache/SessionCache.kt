package com.special.robinhood.data.cache

import com.special.robinhood.data.db.SharedPreferencesHelper

class SessionCache(private var preferencesHelper: SharedPreferencesHelper) {

    private var sessionId: String? = null

    fun setSessionId(sessionId: String) {
        this.sessionId = sessionId
    }

    fun getSessionId() = sessionId ?: ""

    fun clearSessionId() {
        this.sessionId = null
    }
}
