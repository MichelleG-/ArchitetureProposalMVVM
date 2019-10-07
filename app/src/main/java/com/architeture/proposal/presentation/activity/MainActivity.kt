package com.architeture.proprosal.presentation.activity

import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.architeture.proposal.R
import com.architeture.proposal.databinding.ActivityMainBinding
import com.architeture.proprosal.presentation.view.model.MainViewModel
import kotlinx.android.synthetic.main.activity_main.nav_container


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override fun getBindingVariable(): Int = BR.mainViewModel

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun getViewModel(): MainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

    override fun getNavContainer(): Int = R.id.nav_container

    override fun getNavContainerFragment(): Fragment = nav_container

    override fun initBinding() {}

}