package com.architeture.proprosal.domain.interector

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.architeture.proprosal.domain.mapper.ProductMapper
import com.architeture.proprosal.infrastructure.repository.ProductRepository
import com.architeture.proprosal.presentation.view.model.persistence.ProductViewModel
import javax.inject.Inject

interface GetAllProductsByIdInterector : Interector<Unit, LiveData<List<ProductViewModel>>>

class GetAllProductsByIdInterectorImpl @Inject constructor(
    private val productRepository: ProductRepository,
    private val productMapper: ProductMapper
) : GetAllProductsByIdInterector {
    override fun execute(param: Unit): LiveData<List<ProductViewModel>> =
        Transformations.map(productRepository.getAllProductsById()) { input ->
            input.map { productMapper.mapperToPresentation(it) }
        }
}