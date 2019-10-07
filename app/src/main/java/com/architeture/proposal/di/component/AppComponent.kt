package com.architeture.proprosal.di.component

import android.app.Application
import com.architeture.proprosal.application.ArchitetureProposalMVVM
import com.architeture.proprosal.di.AppModule
import com.architeture.proprosal.di.module.ArchitetureProposalMVVMModule
import com.architeture.proprosal.di.module.dataset.DataSetModule
import com.architeture.proprosal.di.module.domain.mapper.MapperModule
import com.architeture.proprosal.di.module.local.db.dao.DaoModule
import com.architeture.proprosal.di.module.repository.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ArchitetureProposalMVVMModule::class,
        DataSetModule::class,
        DaoModule::class,
        RepositoryModule::class,
        MapperModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<ArchitetureProposalMVVM> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}