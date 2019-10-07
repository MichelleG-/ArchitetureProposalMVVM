package com.architeture.proprosal.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.architeture.proprosal.di.ApplicationContext
import com.architeture.proprosal.di.ProductDB
import com.architeture.proprosal.di.module.presentation.view.ViewModelModule
import com.architeture.proprosal.infrastructure.local.db.ProductDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [
    ViewModelModule::class
])
class ArchitetureProposalMVVMModule{

    @Provides
    @Singleton
    @ApplicationContext
    fun providesContext(application: Application) : Context = application.applicationContext

    @Provides
    @Singleton
    @ProductDB
    fun providesProductDatabase(@ApplicationContext context: Context): ProductDataBase =
            Room.databaseBuilder(context, ProductDataBase::class.java, "product_database").build()

}