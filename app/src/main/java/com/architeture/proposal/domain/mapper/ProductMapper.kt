package com.architeture.proprosal.domain.mapper

import com.architeture.proprosal.domain.utils.toMoney
import com.architeture.proprosal.infrastructure.local.db.entity.Product
import com.architeture.proprosal.presentation.view.model.persistence.ProductViewModel
import javax.inject.Inject

interface ProductMapper : Mapper<ProductViewModel, Product>

class ProductMapperImpl @Inject constructor() : ProductMapper {
    override fun mapperToPresentation(response: Product): ProductViewModel =
        ProductViewModel(
            id = response.id,
            name = response.name,
            value = response.value,
            valueFormat = response.value.toMoney()
        )

    override fun mapperToInfra(param: ProductViewModel): Product =
        Product(
            id = param.id,
            value = param.value,
            name = param.name ?: ""
        )
}