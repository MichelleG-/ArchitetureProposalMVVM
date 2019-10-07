package com.architeture.proprosal.infrastructure.local.db.dao

import androidx.lifecycle.LiveData
import com.architeture.proprosal.infrastructure.local.dataset.ProductDataSet
import com.architeture.proprosal.infrastructure.local.db.entity.Product
import javax.inject.Inject

class ProductDataSetImpl @Inject constructor(
    private val productDao: ProductDao
) : ProductDataSet {
    override fun insert(product: Product) =
        productDao.insert(product)

    override fun deleteAll() =
        productDao.deleteAll()

    override fun getAllProductsById(): LiveData<List<Product>> =
        productDao.getAllProductsByIds()

    override fun update(product: Product) =
        productDao.updateProduct(product)

    override fun delete(product: Product) =
            productDao.delete(product)
}