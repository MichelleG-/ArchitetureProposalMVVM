package com.architeture.proprosal.di.module.presentation.fragment

import com.architeture.proprosal.domain.interector.GetAllProductsByIdInterector
import com.architeture.proprosal.domain.interector.GetAllProductsByIdInterectorImpl
import com.architeture.proprosal.domain.interector.InsertProductInterector
import com.architeture.proprosal.domain.interector.InsertProductInterectorImpl
import dagger.Binds
import dagger.Module

@Module
abstract class EditFragmentModule {

    @Binds
    abstract fun bindsInsertProduct(impl: InsertProductInterectorImpl): InsertProductInterector

}