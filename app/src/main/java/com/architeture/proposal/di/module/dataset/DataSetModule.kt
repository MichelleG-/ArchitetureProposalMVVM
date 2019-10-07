package com.architeture.proprosal.di.module.dataset

import com.architeture.proprosal.infrastructure.local.dataset.ProductDataSet
import com.architeture.proprosal.infrastructure.local.db.dao.ProductDataSetImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DataSetModule {

    @Binds
    abstract fun bindsProductDataset(impl: ProductDataSetImpl): ProductDataSet

}