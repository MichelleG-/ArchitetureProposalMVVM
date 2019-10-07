package com.architeture.proprosal.presentation.fragment

import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.architeture.proposal.R
import com.architeture.proposal.databinding.FragmentMainBinding
import com.architeture.proprosal.di.module.presentation.view.ViewModelFactory
import com.architeture.proprosal.presentation.adapter.ProductAdapter
import com.architeture.proprosal.presentation.utils.navigate
import com.architeture.proprosal.presentation.view.model.MainFragmentViewModel
import com.architeture.proprosal.presentation.view.model.persistence.ProductViewModel
import com.architeture.proprosal.presentation.fragment.MainFragmentDirections
import javax.inject.Inject

class MainFragment : BaseFragment<FragmentMainBinding, MainFragmentViewModel>() {

    @Inject lateinit var viewModelFactory: ViewModelFactory

    override fun getBindingVariable(): Int = BR.mainFragmentViewModel

    override fun getLayoutId(): Int = R.layout.fragment_main

    override fun getViewModel(): MainFragmentViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainFragmentViewModel::class.java)

    override fun initBinding() {
        with(binding) {
            setupMenu()
            recyclerProducts.adapter = ProductAdapter(emptyArray<ProductViewModel>().toMutableList()) {

            }
            recyclerProducts.layoutManager = LinearLayoutManager(context)
        }
    }

    private fun FragmentMainBinding.setupMenu() {
        toolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.add -> {
                    navigate(MainFragmentDirections.actionMainFragmentToEditFragment())
                    true
                }
                else -> false
            }
        }
    }
}