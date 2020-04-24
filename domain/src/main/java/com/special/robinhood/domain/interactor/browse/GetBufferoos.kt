package com.special.robinhood.domain.interactor.browse

import io.reactivex.Single
import com.special.robinhood.domain.executor.PostExecutionThread
import com.special.robinhood.domain.executor.ThreadExecutor
import com.special.robinhood.domain.interactor.SingleUseCase
import com.special.robinhood.domain.model.Bufferoo
import com.special.robinhood.domain.repository.BufferooRepository
import javax.inject.Inject

/**
 * Use case used for retreiving a [List] of [Bufferoo] instances from the [BufferooRepository]
 */
open class GetBufferoos @Inject constructor(val bufferooRepository: BufferooRepository,
                                            threadExecutor: ThreadExecutor,
                                            postExecutionThread: PostExecutionThread):
        SingleUseCase<List<Bufferoo>, Void?>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(params: Void?): Single<List<Bufferoo>> {
        return bufferooRepository.getBufferoos()
    }

}