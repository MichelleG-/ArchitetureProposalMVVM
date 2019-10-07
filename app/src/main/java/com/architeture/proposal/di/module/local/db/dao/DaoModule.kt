package com.architeture.proprosal.di.module.local.db.dao

import com.architeture.proprosal.di.ProductDB
import com.architeture.proprosal.infrastructure.local.db.ProductDataBase
import com.architeture.proprosal.infrastructure.local.db.dao.ProductDao
import dagger.Module
import dagger.Provides

@Module
class DaoModule {

    @Provides
    fun providesProductDao(@ProductDB productDB: ProductDataBase): ProductDao =
            productDB.productDao()

}