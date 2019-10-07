package com.architeture.proprosal.domain.interector

import com.architeture.proprosal.domain.mapper.ProductMapper
import com.architeture.proprosal.domain.utils.withExecutor
import com.architeture.proprosal.infrastructure.repository.ProductRepository
import com.architeture.proprosal.presentation.view.model.persistence.ProductViewModel
import io.reactivex.Completable
import javax.inject.Inject

interface UpdateProductInterector : Interector<ProductViewModel, Completable>

class UpdateProductInterectorimpl @Inject constructor(
    private val productRepository: ProductRepository,
    private val productMapper: ProductMapper
) : UpdateProductInterector {
    override fun execute(param: ProductViewModel): Completable = Completable.create {
        try {
            productRepository.update(productMapper.mapperToInfra(param))
            it.onComplete()
        }catch (e: Exception) {
            it.onError(e)
        }
    }.withExecutor()
}