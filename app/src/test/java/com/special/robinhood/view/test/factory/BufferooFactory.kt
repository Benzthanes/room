package com.special.robinhood.view.test.factory

import com.special.robinhood.presentation.model.BufferooView
import com.special.robinhood.view.test.factory.DataFactory.Factory.randomUuid

/**
 * Factory class for Bufferoo related instances
 */
class BufferooFactory {

    companion object Factory {

        fun makeBufferooView(): BufferooView {
            return BufferooView(randomUuid(), randomUuid(), randomUuid())
        }

    }

}