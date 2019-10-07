package com.architeture.proprosal.domain.interector

import com.architeture.proprosal.domain.mapper.ProductMapper
import com.architeture.proprosal.domain.utils.withExecutor
import com.architeture.proprosal.infrastructure.repository.ProductRepository
import com.architeture.proprosal.presentation.view.model.persistence.ProductViewModel
import io.reactivex.Completable
import javax.inject.Inject

interface DeleteProductInterector : Interector<ProductViewModel, Completable>

class DeleteProductInterectorImpl @Inject constructor(
    private val productRepository: ProductRepository,
    private val productMapper: ProductMapper
) : DeleteProductInterector {
    override fun execute(param: ProductViewModel): Completable = Completable.create {
        try {
            productRepository.delete(productMapper.mapperToInfra(param))
            it.onComplete()
        }catch (e: Exception) {
            it.onError(e)
        }
    }.withExecutor()
}