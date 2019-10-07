package com.architeture.proprosal.di.module.domain.mapper

import com.architeture.proprosal.domain.mapper.ProductMapper
import com.architeture.proprosal.domain.mapper.ProductMapperImpl
import dagger.Binds
import dagger.Module

@Module
abstract class MapperModule {

    @Binds
    abstract fun bindsProductMapper(impl: ProductMapperImpl): ProductMapper

}