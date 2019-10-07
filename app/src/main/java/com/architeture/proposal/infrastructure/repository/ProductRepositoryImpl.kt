package com.architeture.proprosal.infrastructure.repository

import androidx.lifecycle.LiveData
import com.architeture.proprosal.infrastructure.local.dataset.ProductDataSet
import com.architeture.proprosal.infrastructure.local.db.entity.Product
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDataSet: ProductDataSet
) : ProductRepository {
    override fun insert(product: Product) =
        productDataSet.insert(product)

    override fun deleteAll() =
        productDataSet.deleteAll()

    override fun getAllProductsById(): LiveData<List<Product>> =
        productDataSet.getAllProductsById()

    override fun update(product: Product) =
        productDataSet.update(product)

    override fun delete(product: Product) =
        productDataSet.delete(product)
}