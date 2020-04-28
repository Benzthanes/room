package com.special.robinhood.domain.extensions

class BooleanExt {

    /**
     * example for this : condition then { A } ?: B
     */
    infix fun <T> Boolean.then(param: () -> T): T? = if (this) param() else null
}