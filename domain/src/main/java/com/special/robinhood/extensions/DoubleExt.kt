package com.special.robinhood.domain.extensions

infix fun Double.roundTo(decimal: Int): Double {
    return "%.${decimal}f".format(this).toDouble()
}