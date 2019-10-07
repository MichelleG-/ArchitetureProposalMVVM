package com.architeture.proprosal.domain.interector

import com.architeture.proprosal.domain.utils.withExecutor
import com.architeture.proprosal.infrastructure.repository.ProductRepository
import com.architeture.proprosal.presentation.view.model.persistence.ProductViewModel
import io.reactivex.Completable
import javax.inject.Inject

interface DeleteAllProductInterector : Interector<ProductViewModel, Completable>

class DeleteAllProductInterectorImpl @Inject constructor(
    private val productRepository: ProductRepository
) : DeleteAllProductInterector {
    override fun execute(param: ProductViewModel): Completable = Completable.create {
        try {
            productRepository.deleteAll()
            it.onComplete()
        }catch (e: Exception) {
            it.onError(e)
        }
    }.withExecutor()
}
