package com.architeture.proprosal.infrastructure.repository

import androidx.lifecycle.LiveData
import com.architeture.proprosal.infrastructure.local.db.entity.Product

interface ProductRepository {
    fun insert(product: Product)
    fun deleteAll()
    fun getAllProductsById(): LiveData<List<Product>>
    fun update(product: Product)
    fun delete(product: Product)
}