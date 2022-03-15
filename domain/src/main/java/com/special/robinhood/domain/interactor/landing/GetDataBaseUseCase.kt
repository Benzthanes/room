package com.special.robinhood.domain.interactor.landing

import com.special.robinhood.domain.executor.ThreadExecutor
import com.special.robinhood.domain.interactor.BaseSingleUseCase
import com.special.robinhood.domain.interactor.BaseUseCase
import com.special.robinhood.domain.interactor.ThreadExecutors
import com.special.robinhood.domain.model.landing.Mobile
import com.special.robinhood.domain.repository.landing.DatabaseRepositoryContractor
import javax.inject.Inject
import javax.inject.Named

class GetDataBaseUseCase @Inject constructor(
    @Named(ThreadExecutors.SUBSCRIBER_ON_IO) subscriberOn: ThreadExecutor,
    @Named(ThreadExecutors.OBSERVER_ON) observerOn: ThreadExecutor,
    private val cache: DatabaseRepositoryContractor
) : BaseSingleUseCase<List<Mobile>, BaseUseCase.VoidParams>(
    subscriberOn,
    observerOn,
    builder = { cache.getPhoneList() }
)