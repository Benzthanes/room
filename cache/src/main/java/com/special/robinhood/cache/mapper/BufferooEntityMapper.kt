package com.special.robinhood.cache.mapper

import com.special.robinhood.cache.model.CachedBufferoo
import com.special.robinhood.data.model.BufferooEntity
import javax.inject.Inject

/**
 * Map a [CachedBufferoo] instance to and from a [BufferooEntity] instance when data is moving between
 * this later and the Data layer
 */
class BufferooEntityMapper @Inject constructor(): EntityMapper<CachedBufferoo, BufferooEntity> {

    /**
     * Map a [BufferooEntity] instance to a [CachedBufferoo] instance
     */
    override fun mapToCached(type: BufferooEntity): CachedBufferoo {
        return CachedBufferoo(type.name, type.title, type.avatar)
    }

    /**
     * Map a [CachedBufferoo] instance to a [BufferooEntity] instance
     */
    override fun mapFromCached(type: CachedBufferoo): BufferooEntity {
        return BufferooEntity(type.name, type.title, type.avatar)
    }

}