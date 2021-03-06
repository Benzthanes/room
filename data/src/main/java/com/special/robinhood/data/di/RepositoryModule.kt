package com.special.robinhood.data.di

import com.special.robinhood.data.repository.landing.LandingRepository
import com.special.robinhood.data.mapper.LandingMapper
import com.special.robinhood.data.network.api.landing.LandingApi
import com.special.robinhood.domain.repository.landing.LandingRepositoryContractor
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    internal fun provideLandingRepository(
            api: LandingApi,
            mapper: LandingMapper
    ): LandingRepositoryContractor {
        return LandingRepository(api, mapper)
    }
}