package com.special.robinhood.data.db

import android.content.Context
import android.content.SharedPreferences
import com.special.robinhood.domain.constants.SharedPreferencesConstants
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesHelper
@Inject constructor(
        context: Context
) {

    companion object {
        private const val PREF_ROBIN_HOOD_PACKAGE_NAME = "com.special.robinhood.preferences"
    }

    private val robinHoodPref: SharedPreferences

    init {
        robinHoodPref = context.getSharedPreferences(PREF_ROBIN_HOOD_PACKAGE_NAME, Context.MODE_PRIVATE)
    }

    var appLanguage: String
        get() = robinHoodPref.getString(SharedPreferencesConstants.APP_LANGUAGE, "th") ?: "th"
        set(appLanguage) = robinHoodPref.edit()
                .putString(SharedPreferencesConstants.APP_LANGUAGE, appLanguage)
                .apply()

}