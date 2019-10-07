package com.architeture.proprosal.di

import com.architeture.proprosal.di.module.presentation.activity.MainActivityModule
import com.architeture.proprosal.di.module.presentation.fragment.EditFragmentModule
import com.architeture.proprosal.di.module.presentation.fragment.MainFragmentModule
import com.architeture.proprosal.presentation.activity.MainActivity
import com.architeture.proprosal.presentation.fragment.EditFragment
import com.architeture.proprosal.presentation.fragment.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun buildMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun buildMainFragment(): MainFragment

    @ContributesAndroidInjector(modules = [EditFragmentModule::class])
    abstract fun buildEditFragment(): EditFragment


}