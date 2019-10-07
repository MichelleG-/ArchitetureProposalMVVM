package com.architeture.proprosal.di.module.repository

import com.architeture.proprosal.infrastructure.repository.ProductRepository
import com.architeture.proprosal.infrastructure.repository.ProductRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindsProduct(impl: ProductRepositoryImpl): ProductRepository

}